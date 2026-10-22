package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.StateSet;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private boolean DEBUG_DESKTOP;
    private ArrayList<Transition> mAbstractTransitionList;
    private HashMap<String, Integer> mConstraintSetIdMap;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    Transition mCurrentTransition;
    private int mDefaultDuration;
    private Transition mDefaultTransition;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition;
    private boolean mIgnoreTouch;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private int mLayoutDuringTransition;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion;
    private boolean mRtl;
    StateSet mStateSet;
    private ArrayList<Transition> mTransitionList;
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context r5, Transition r6, XmlPullParser r7) {
                Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
                XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r6;
                TypedArray r10 = r8.obtainStyledAttributes(Xml.asAttributeSet(r9), R.styleable.OnClick);
                int r11 = r10.getIndexCount();
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L11;
                int r0 = r10.getIndex(r12);
                if (r0 != ZeusTransformUtils.mapRes(R.styleable.OnClick_targetId, "styleable", "OnClick_targetId")) goto L8;
                this.mTargetId = r10.getResourceId(r0, this.mTargetId);
            L10:
                r12 = r12 + 1;
                goto L3
            L8:
                if (r0 != ZeusTransformUtils.mapRes(R.styleable.OnClick_clickAction, "styleable", "OnClick_clickAction")) goto L10;
                this.mMode = r10.getInt(r0, this.mMode);
                goto L10
            L11:
                r10.recycle();
            }

            public TransitionOnClick(Transition r2, int r3, int r4) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r2;
                this.mTargetId = r3;
                this.mMode = r4;
            }

            public void addOnClickListeners(MotionLayout r7, int r8, Transition r9) {
                int r0 = this.mTargetId;
                MotionLayout r10 = r7;
                if (r0 == (-1)) goto L6;
                r10 = r7.findViewById(r0);
            L6:
                if (r10 != null) goto L9;
                Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r1 = Transition.access$100(r9);
                int r11 = Transition.access$000(r9);
                if (r1 != (-1)) goto L13;
                r10.setOnClickListener(this);
                return;
            L13:
                int r2 = this.mMode;
                boolean r3 = false;
                if ((r2 & 1) == 0) goto L17;
                if (r8 != r1) goto L17;
                boolean r4 = true;
            L19:
                if ((r2 & 256) == 0) goto L22;
                if (r8 != r1) goto L22;
                boolean r5 = true;
            L23:
                boolean r6 = r4 | r5;
                if ((r2 & 1) == 0) goto L27;
                if (r8 != r1) goto L27;
                boolean r12 = true;
            L28:
                boolean r13 = r12 | r6;
                if ((r2 & 16) == 0) goto L32;
                if (r8 != r11) goto L32;
                boolean r14 = true;
            L33:
                boolean r15 = r13 | r14;
                if ((r2 & 4096) == 0) goto L38;
                if (r8 != r11) goto L38;
                r3 = true;
            L38:
                if ((r15 | r3) == false) goto L41;
                r10.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r14 = false;
            L27:
                r12 = false;
            L22:
                r5 = false;
            L17:
                r4 = false;
                goto L19
            }

            boolean isTransitionViable(Transition r4, MotionLayout r5) {
                Transition r0 = this.mTransition;
                if (r0 != r4) goto L5;
                return true;
            L5:
                int r6 = Transition.access$000(r0);
                int r3 = Transition.access$100(this.mTransition);
                if (r3 != (-1)) goto L13;
                if (r5.mCurrentState == r6) goto L11;
                return true;
            L11:
                return false;
            L13:
                if (r5.mCurrentState != r3) goto L15;
                return true;
            L15:
                if (r5.mCurrentState != r6) goto L18;
                return true;
            L18:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r8) {
                MotionLayout r9 = MotionScene.access$700(Transition.access$800(this.mTransition));
                if (r9.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r0 = r9.getCurrentState();
                if (r0 != (-1)) goto L11;
                r9.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r1 = new Transition(Transition.access$800(this.mTransition), this.mTransition);
                Transition.access$102(r1, r0);
                Transition.access$002(r1, Transition.access$000(this.mTransition));
                r9.setTransition(r1);
                r9.transitionToEnd();
                return;
            L13:
                Transition r2 = Transition.access$800(this.mTransition).mCurrentTransition;
                int r3 = this.mMode;
                boolean r4 = false;
                if ((r3 & 1) == 0) goto L16;
            L19:
                boolean r5 = true;
            L21:
                if ((r3 & 16) == 0) goto L23;
            L26:
                boolean r6 = true;
            L27:
                if (r5 == false) goto L30;
                if (r6 == false) goto L30;
                boolean r7 = true;
            L31:
                if (r7 == false) goto L41;
                Transition r10 = Transition.access$800(this.mTransition).mCurrentTransition;
                Transition r11 = this.mTransition;
                if (r10 == r11) goto L36;
                r9.setTransition(r11);
            L36:
                if (r9.getCurrentState() == r9.getEndState()) goto L43;
                if (r9.getProgress() > 0.5f) goto L43;
                r6 = false;
            L43:
                if (isTransitionViable(r2, r9) == false) goto L61;
                if (r4 == true) goto L46;
            L48:
                if (r6 == true) goto L50;
            L52:
                if (r4 == true) goto L54;
            L57:
                if (r6 == true) goto L59;
                return;
            L59:
                if ((this.mMode & 4096) == 0) goto L66;
                r9.setTransition(this.mTransition);
                float r12 = 0.0f;
            L56:
                r9.setProgress(r12);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L57;
                r9.setTransition(this.mTransition);
                r12 = 1.0f;
                goto L56
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r9.setTransition(this.mTransition);
                r9.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r9.setTransition(this.mTransition);
                r9.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r4 = r5;
            L30:
                r7 = false;
                goto L31
            L23:
                if ((r3 & 4096) != 0) goto L26;
                r6 = false;
                goto L27
            L16:
                if ((r3 & 256) != 0) goto L19;
                r5 = false;
                goto L21
            }

            public void removeOnClickListeners(MotionLayout r3) {
                int r0 = this.mTargetId;
                if (r0 != (-1)) goto L5;
                return;
            L5:
                View r4 = r3.findViewById(r0);
                if (r4 != null) goto L9;
                Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r4.setOnClickListener(null);
            }
        }

        public Transition(int r5, MotionScene r6, int r7, int r8) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = r5;
            this.mMotionScene = r6;
            this.mConstraintSetStart = r7;
            this.mConstraintSetEnd = r8;
            this.mDuration = MotionScene.access$900(r6);
            this.mLayoutDuringTransition = MotionScene.access$1000(r6);
        }

        Transition(MotionScene r5, Context r6, XmlPullParser r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = MotionScene.access$900(r5);
            this.mLayoutDuringTransition = MotionScene.access$1000(r5);
            this.mMotionScene = r5;
            fillFromAttributeList(r5, r8, Xml.asAttributeSet(r9));
        }

        Transition(MotionScene r5, Transition r6) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = r5;
            this.mDuration = MotionScene.access$900(r5);
            if (r6 == null) goto L6;
            this.mPathMotionArc = r6.mPathMotionArc;
            this.mDefaultInterpolator = r6.mDefaultInterpolator;
            this.mDefaultInterpolatorString = r6.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = r6.mDefaultInterpolatorID;
            this.mDuration = r6.mDuration;
            this.mKeyFramesList = r6.mKeyFramesList;
            this.mStagger = r6.mStagger;
            this.mLayoutDuringTransition = r6.mLayoutDuringTransition;
            return;
        }

        static /* synthetic */ int access$000(Transition r0) {
            return r0.mConstraintSetEnd;
        }

        static /* synthetic */ int access$002(Transition r0, int r1) {
            r0.mConstraintSetEnd = r1;
            return r1;
        }

        static /* synthetic */ int access$100(Transition r0) {
            return r0.mConstraintSetStart;
        }

        static /* synthetic */ int access$102(Transition r0, int r1) {
            r0.mConstraintSetStart = r1;
            return r1;
        }

        static /* synthetic */ boolean access$1300(Transition r0) {
            return r0.mIsAbstract;
        }

        static /* synthetic */ ArrayList access$1400(Transition r0) {
            return r0.mKeyFramesList;
        }

        static /* synthetic */ int access$1500(Transition r0) {
            return r0.mDefaultInterpolator;
        }

        static /* synthetic */ String access$1600(Transition r0) {
            return r0.mDefaultInterpolatorString;
        }

        static /* synthetic */ int access$1700(Transition r0) {
            return r0.mDefaultInterpolatorID;
        }

        static /* synthetic */ int access$1800(Transition r0) {
            return r0.mDuration;
        }

        static /* synthetic */ int access$1900(Transition r0) {
            return r0.mPathMotionArc;
        }

        static /* synthetic */ TouchResponse access$200(Transition r0) {
            return r0.mTouchResponse;
        }

        static /* synthetic */ float access$2000(Transition r0) {
            return r0.mStagger;
        }

        static /* synthetic */ TouchResponse access$202(Transition r0, TouchResponse r1) {
            r0.mTouchResponse = r1;
            return r1;
        }

        static /* synthetic */ int access$300(Transition r0) {
            return r0.mId;
        }

        static /* synthetic */ ArrayList access$400(Transition r0) {
            return r0.mOnClicks;
        }

        static /* synthetic */ boolean access$500(Transition r0) {
            return r0.mDisable;
        }

        static /* synthetic */ int access$600(Transition r0) {
            return r0.mAutoTransition;
        }

        static /* synthetic */ MotionScene access$800(Transition r0) {
            return r0.mMotionScene;
        }

        private void fill(MotionScene r13, Context r14, TypedArray r15) {
            Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
            int r0 = r15.getIndexCount();
            int r3 = 0;
        L4:
            if (r3 >= r0) goto L66;
            int r6 = r15.getIndex(r3);
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_constraintSetEnd, "styleable", "Transition_constraintSetEnd")) goto L15;
            this.mConstraintSetEnd = r15.getResourceId(r6, -1);
            String r4 = ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintSetEnd);
            if ("layout".equals(r4) == false) goto L12;
            ConstraintSet r5 = new ConstraintSet();
            r5.load(r16, this.mConstraintSetEnd);
            SparseArray r7 = MotionScene.access$1100(r13);
            int r8 = this.mConstraintSetEnd;
        L10:
            r7.append(r8, r5);
        L64:
            r3 = r3 + 1;
            goto L4
        L12:
            if ("xml".equals(r4) == false) goto L64;
            this.mConstraintSetEnd = MotionScene.access$1200(r13, r16, this.mConstraintSetEnd);
            goto L64
        L15:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_constraintSetStart, "styleable", "Transition_constraintSetStart")) goto L23;
            this.mConstraintSetStart = r15.getResourceId(r6, this.mConstraintSetStart);
            String r9 = ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintSetStart);
            if ("layout".equals(r9) == false) goto L20;
            r5 = new ConstraintSet();
            r5.load(r16, this.mConstraintSetStart);
            r7 = MotionScene.access$1100(r13);
            r8 = this.mConstraintSetStart;
            goto L10
        L20:
            if ("xml".equals(r9) == false) goto L64;
            this.mConstraintSetStart = MotionScene.access$1200(r13, r16, this.mConstraintSetStart);
            goto L64
        L23:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_motionInterpolator, "styleable", "Transition_motionInterpolator")) goto L39;
            TypedValue r10 = r15.peekValue(r6);
            if (r10.type != 1) goto L30;
            int r11 = r15.getResourceId(r6, -1);
            this.mDefaultInterpolatorID = r11;
            if (r11 == (-1)) goto L64;
        L28:
            this.mDefaultInterpolator = -2;
            goto L64
        L30:
            if (r10.type != 3) goto L37;
            String r12 = r15.getString(r6);
            this.mDefaultInterpolatorString = r12;
            if (r12 == null) goto L64;
            if (r12.indexOf("/") <= 0) goto L36;
            this.mDefaultInterpolatorID = r15.getResourceId(r6, -1);
            goto L28
        L36:
            this.mDefaultInterpolator = -1;
            goto L64
        L37:
            this.mDefaultInterpolator = r15.getInteger(r6, this.mDefaultInterpolator);
            goto L64
        L39:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_duration, "styleable", "Transition_duration")) goto L44;
            int r17 = r15.getInt(r6, this.mDuration);
            this.mDuration = r17;
            if (r17 >= 8) goto L64;
            this.mDuration = 8;
            goto L64
        L44:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_staggered, "styleable", "Transition_staggered")) goto L47;
            this.mStagger = r15.getFloat(r6, this.mStagger);
            goto L64
        L47:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_autoTransition, "styleable", "Transition_autoTransition")) goto L50;
            this.mAutoTransition = r15.getInteger(r6, this.mAutoTransition);
            goto L64
        L50:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_android_id, "styleable", "Transition_android_id")) goto L53;
            this.mId = r15.getResourceId(r6, this.mId);
            goto L64
        L53:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_transitionDisable, "styleable", "Transition_transitionDisable")) goto L56;
            this.mDisable = r15.getBoolean(r6, this.mDisable);
            goto L64
        L56:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_pathMotionArc, "styleable", "Transition_pathMotionArc")) goto L59;
            this.mPathMotionArc = r15.getInteger(r6, -1);
            goto L64
        L59:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_layoutDuringTransition, "styleable", "Transition_layoutDuringTransition")) goto L62;
            this.mLayoutDuringTransition = r15.getInteger(r6, 0);
            goto L64
        L62:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_transitionFlags, "styleable", "Transition_transitionFlags")) goto L64;
            this.mTransitionFlags = r15.getInteger(r6, 0);
            goto L64
        L66:
            if (this.mConstraintSetStart != (-1)) goto L90;
            this.mIsAbstract = true;
            return;
        }

        private void fillFromAttributeList(MotionScene r3, Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            TypedArray r7 = r6.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Transition);
            fill(r3, r6, r7);
            r7.recycle();
        }

        public void addKeyFrame(KeyFrames r1) {
            this.mKeyFramesList.add(r1);
        }

        public void addOnClick(int r5, int r6) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            TransitionOnClick r1 = (TransitionOnClick) ZeusTransformUtils.preCheckCast(r0.next(), TransitionOnClick.class, "com.obric.memorydata.plugin");
            if (r1.mTargetId != r5) goto L4;
            r1.mMode = r6;
            return;
        L9:
            TransitionOnClick r2 = new TransitionOnClick(this, r5, r6);
            this.mOnClicks.add(r2);
        }

        public void addOnClick(Context r3, XmlPullParser r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.mOnClicks.add(new TransitionOnClick(r5, this, r6));
        }

        public String debugString(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r0 = "null";
        L7:
            if (this.mConstraintSetEnd != (-1)) goto L9;
            StringBuilder r4 = new StringBuilder().append(r0).append(" -> null");
        L11:
            return r4.toString();
        L9:
            r4 = new StringBuilder().append(r0).append(" -> ").append(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceEntryName(this.mConstraintSetEnd));
            goto L11
        L5:
            r0 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceEntryName(this.mConstraintSetStart);
            goto L7
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int r1) {
            if ((this.mTransitionFlags & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void removeOnClick(int r5) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            TransitionOnClick r1 = (TransitionOnClick) ZeusTransformUtils.preCheckCast(r0.next(), TransitionOnClick.class, "com.obric.memorydata.plugin");
            if (r1.mTargetId != r5) goto L4;
        L9:
            if (r1 == null) goto L15;
            this.mOnClicks.remove(r1);
            return;
        L15:
            return;
        L8:
            r1 = null;
            goto L9
        }

        public void setAutoTransition(int r1) {
            this.mAutoTransition = r1;
        }

        public void setDuration(int r2) {
            this.mDuration = Math.max(r2, 8);
        }

        public void setEnable(boolean r1) {
            setEnabled(r1);
        }

        public void setEnabled(boolean r1) {
            this.mDisable = !r1;
        }

        public void setInterpolatorInfo(int r1, String r2, int r3) {
            this.mDefaultInterpolator = r1;
            this.mDefaultInterpolatorString = r2;
            this.mDefaultInterpolatorID = r3;
        }

        public void setLayoutDuringTransition(int r1) {
            this.mLayoutDuringTransition = r1;
        }

        public void setOnSwipe(OnSwipe r3) {
            if (r3 != null) goto L4;
            TouchResponse r4 = null;
        L5:
            this.mTouchResponse = r4;
            return;
        L4:
            r4 = new TouchResponse(MotionScene.access$700(this.mMotionScene), r3);
            goto L5
        }

        public void setOnTouchUp(int r1) {
            TouchResponse r0 = getTouchResponse();
            if (r0 == null) goto L6;
            r0.setTouchUpMode(r1);
            return;
        }

        public void setPathMotionArc(int r1) {
            this.mPathMotionArc = r1;
        }

        public void setStagger(float r1) {
            this.mStagger = r1;
        }

        public void setTransitionFlag(int r1) {
            this.mTransitionFlags = r1;
        }
    }

    MotionScene(Context r4, MotionLayout r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r5;
        this.mViewTransitionController = new ViewTransitionController(r5);
        load(r7, r6);
        this.mConstraintSetMap.put(ZeusTransformUtils.mapRes(R.id.motion_base, OaidModel.KEY_ID, "motion_base"), new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.motion_base, OaidModel.KEY_ID, "motion_base")));
    }

    public MotionScene(MotionLayout r4) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = r4;
        this.mViewTransitionController = new ViewTransitionController(r4);
    }

    static /* synthetic */ int access$1000(MotionScene r0) {
        return r0.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene r0) {
        return r0.mConstraintSetMap;
    }

    static /* synthetic */ int access$1200(MotionScene r2, Context r3, int r4) {
        return r2.parseInclude((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ MotionLayout access$700(MotionScene r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene r0) {
        return r0.mDefaultDuration;
    }

    private int getId(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r8.contains("/") == false) goto L7;
        int r10 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin"), r8.substring(r8.indexOf(47) + 1), OaidModel.KEY_ID, r9.getPackageName(), "com.obric.memorydata.plugin");
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id getMap res = " + r10);
    L8:
        if (r10 != (-1)) goto L15;
        if (r8 != null) goto L11;
    L13:
        Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        return r10;
    L11:
        if (r8.length() <= 1) goto L13;
        return Integer.parseInt(r8.substring(1));
    L15:
        return r10;
    L7:
        r10 = -1;
        goto L8
    }

    private int getIndex(Transition r6) {
        int r7 = Transition.access$300(r6);
        if (r7 == (-1)) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300((Transition) ZeusTransformUtils.preCheckCast(this.mTransitionList.get(r1), Transition.class, "com.obric.memorydata.plugin")) == r7) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    static String getLine(Context r2, int r3, XmlPullParser r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        return ".(" + Debug.getName(r5, r3) + ".xml:" + r6.getLineNumber() + ") \"" + r6.getName() + "\"";
    }

    private int getRealID(int r2) {
        StateSet r1 = this.mStateSet;
        if (r1 == null) goto L7;
        int r3 = r1.stateGetConstraintID(r2, -1, -1);
        if (r3 == (-1)) goto L7;
        return r3;
    L7:
        return r2;
    }

    private boolean hasCycleDependency(int r5) {
        int r0 = this.mDeriveMap.get(r5);
        int r1 = this.mDeriveMap.size();
    L3:
        if (r0 <= 0) goto L11;
        if (r0 == r5) goto L6;
        int r3 = r1 - 1;
        if (r1 < 0) goto L9;
        r0 = this.mDeriveMap.get(r0);
        r1 = r3;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void load(Context r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r0 = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getXml(r11);
        Transition r2 = null;
        int r3 = r0.getEventType();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L4:
        byte r4 = 1;
        if (r3 == 1) goto L117;
        if (r3 != 0) goto L8;
        r0.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L80:
        r3 = r0.next();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L8:
        if (r3 != 2) goto L80;
        String r5 = r0.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.DEBUG_DESKTOP == false) goto L15;
        System.out.println("parsing = " + r5);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L15:
        switch(r5.hashCode()) {
            case -1349929691: goto L45;
            case -1239391468: goto L42;
            case -687739768: goto L39;
            case 61998586: goto L36;
            case 269306229: goto L33;
            case 312750793: goto L30;
            case 327855227: goto L27;
            case 793277014: goto L24;
            case 1382829617: goto L21;
            case 1942574248: goto L18;
            default: goto L115;
        };
    L115:
        r4 = -1;
    L48:
        switch(r4) {
            case 0: goto L78;
            case 1: goto L63;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L54;
            case 8: goto L51;
            case 9: goto L50;
            default: goto L80;
        };     // Catch: IOException -> L82 XmlPullParserException -> L84
    L50:
        this.mViewTransitionController.add(new ViewTransition(r12, r0));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L51:
        KeyFrames r6 = new KeyFrames(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (r2 == null) goto L80;
        Transition.access$1400(r2).add(r6);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L54:
        parseInclude(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L55:
        parseConstraintSet(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L56:
        this.mStateSet = new StateSet(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L57:
        if (r2 == null) goto L80;
        r2.addOnClick(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L59:
        if (r2 != null) goto L61;
        Log.v(TypedValues.MotionScene.NAME, " OnSwipe (" + ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceEntryName(r11) + ".xml:" + r0.getLineNumber() + ")");     // Catch: IOException -> L82 XmlPullParserException -> L84
    L61:
        if (r2 == null) goto L80;
        Transition.access$202(r2, new TouchResponse(r12, this.mMotionLayout, r0));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L63:
        ArrayList<Transition> r7 = this.mTransitionList;     // Catch: IOException -> L82 XmlPullParserException -> L84
        Transition r8 = new Transition(this, r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        r7.add(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.mCurrentTransition != null) goto L71;
        if (Transition.access$1300(r8) == true) goto L71;
        this.mCurrentTransition = r8;     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (Transition.access$200(r8) == null) goto L71;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L71:
        if (Transition.access$1300(r8) == true) goto L73;
    L77:
        r2 = r8;
        goto L80
    L73:
        if (Transition.access$000(r8) != (-1)) goto L75;
        this.mDefaultTransition = r8;     // Catch: IOException -> L82 XmlPullParserException -> L84
    L76:
        this.mTransitionList.remove(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L77
    L75:
        this.mAbstractTransitionList.add(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L76
    L78:
        parseMotionSceneTags(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L18:
        if (r5.equals(INCLUDE_TAG) == false) goto L47;
        r4 = 6;
        goto L48
    L47:
        r4 = -1;
        goto L48
    L21:
        if (r5.equals(STATESET_TAG) == false) goto L106;
        r4 = 4;
        goto L48
    L106:
        r4 = -1;
        goto L48
    L24:
        if (r5.equals(TypedValues.MotionScene.NAME) == false) goto L107;
        r4 = 0;
        goto L48
    L107:
        r4 = -1;
        goto L48
    L27:
        if (r5.equals(ONSWIPE_TAG) == false) goto L108;
        r4 = 2;
        goto L48
    L108:
        r4 = -1;
        goto L48
    L30:
        if (r5.equals(ONCLICK_TAG) == false) goto L109;
        r4 = 3;
        goto L48
    L109:
        r4 = -1;
        goto L48
    L33:
        if (r5.equals(TRANSITION_TAG) == true) goto L48;
        r4 = -1;
        goto L48
    L36:
        if (r5.equals("ViewTransition") == false) goto L111;
        r4 = 9;
        goto L48
    L111:
        r4 = -1;
        goto L48
    L39:
        if (r5.equals(INCLUDE_TAG_UC) == false) goto L112;
        r4 = 7;
        goto L48
    L112:
        r4 = -1;
        goto L48
    L42:
        if (r5.equals("KeyFrameSet") == false) goto L113;
        r4 = 8;
        goto L48
    L113:
        r4 = -1;
        goto L48
    L45:
        if (r5.equals(CONSTRAINTSET_TAG) == false) goto L114;
        r4 = 5;
        goto L48
    L114:
        r4 = -1;
        goto L48
    L117:
        return;
    L82:
        e = move-exception;
        e.printStackTrace();
        return;
    L84:
        e = move-exception;
        e.printStackTrace();
    }

    private int parseConstraintSet(Context r14, XmlPullParser r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r17 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r15, XmlPullParser.class, "com.obric.memorydata.plugin");
        ConstraintSet r0 = new ConstraintSet();
        r0.setForceId(false);
        int r2 = r17.getAttributeCount();
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r4 >= r2) goto L60;
        String r8 = r17.getAttributeName(r4);
        String r9 = r17.getAttributeValue(r4);
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id string = " + r9);
    L8:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            default: goto L10;
        };
    L10:
        byte r10 = -1;
    L23:
        switch(r10) {
            case 0: goto L58;
            case 1: goto L69;
            case 2: goto L25;
            default: goto L59;
        };
    L25:
        r5 = getId(r16, r9);
        this.mConstraintSetIdMap.put(stripID(r9), Integer.valueOf(r5));
        r0.mIdString = Debug.getName(r16, r5);
        goto L59
    L58:
        r6 = getId(r16, r9);
        goto L59
    L69:
        r0.mRotate = Integer.parseInt(r9);     // Catch: NumberFormatException -> L28
    L28:
        r9.hashCode();
        switch(r9.hashCode()) {
            case -768416914: goto L48;
            case 3317767: goto L44;
            case 3387192: goto L40;
            case 108511772: goto L36;
            case 1954540437: goto L32;
            default: goto L30;
        };
    L30:
        byte r11 = -1;
    L51:
        switch(r11) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            default: goto L59;
        };
    L53:
        r0.mRotate = 3;
        goto L59
    L54:
        r0.mRotate = 1;
        goto L59
    L55:
        r0.mRotate = 0;
        goto L59
    L56:
        r0.mRotate = 2;
        goto L59
    L57:
        r0.mRotate = 4;
        goto L59
    L32:
        if (r9.equals("x_right") == false) goto L85;
        r11 = 4;
        goto L51
    L85:
        r11 = -1;
        goto L51
    L36:
        if (r9.equals("right") == false) goto L86;
        r11 = 3;
        goto L51
    L86:
        r11 = -1;
        goto L51
    L40:
        if (r9.equals("none") == false) goto L87;
        r11 = 2;
        goto L51
    L87:
        r11 = -1;
        goto L51
    L44:
        if (r9.equals("left") == false) goto L88;
        r11 = 1;
        goto L51
    L88:
        r11 = -1;
        goto L51
    L48:
        if (r9.equals("x_left") == false) goto L89;
        r11 = 0;
        goto L51
    L89:
        r11 = -1;
    L59:
        r4 = r4 + 1;
        goto L4
    L12:
        if (r8.equals(OaidModel.KEY_ID) == false) goto L82;
        r10 = 2;
        goto L23
    L82:
        r10 = -1;
        goto L23
    L16:
        if (r8.equals("constraintRotate") == false) goto L83;
        r10 = 1;
        goto L23
    L83:
        r10 = -1;
        goto L23
    L20:
        if (r8.equals("deriveConstraintsFrom") == false) goto L84;
        r10 = 0;
        goto L23
    L84:
        r10 = -1;
        goto L23
    L60:
        if (r5 != (-1)) goto L62;
    L68:
        return r5;
    L62:
        if (this.mMotionLayout.mDebugPath == 0) goto L64;
        r0.setValidateOnParse(true);
    L64:
        r0.load(r16, r17);
        if (r6 == (-1)) goto L67;
        this.mDeriveMap.put(r5, r6);
    L67:
        this.mConstraintSetMap.put(r5, r0);
        goto L68
    }

    private int parseInclude(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r7 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getXml(r5);
        int r0 = r7.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r0 == 1) goto L27;
        String r1 = r7.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r0) goto L12;
        if (CONSTRAINTSET_TAG.equals(r1) == false) goto L12;
        return parseConstraintSet(r6, r7);
    L12:
        r0 = r7.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L5
    L27:
        return -1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    private void parseInclude(Context r7, XmlPullParser r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        TypedArray r10 = r9.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.memorydata.plugin")), R.styleable.include);
        int r0 = r10.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r10.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.include_constraintSet, "styleable", "include_constraintSet")) goto L7;
        parseInclude(r9, r10.getResourceId(r2, -1));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        r10.recycle();
    }

    private void parseMotionSceneTags(Context r7, XmlPullParser r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.memorydata.plugin")), R.styleable.MotionScene);
        int r10 = r9.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_defaultDuration, "styleable", "MotionScene_defaultDuration")) goto L10;
        int r3 = r9.getInt(r2, this.mDefaultDuration);
        this.mDefaultDuration = r3;
        if (r3 >= 8) goto L12;
        this.mDefaultDuration = 8;
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_layoutDuringTransition, "styleable", "MotionScene_layoutDuringTransition")) goto L12;
        this.mLayoutDuringTransition = r9.getInteger(r2, 0);
        goto L12
    L13:
        r9.recycle();
    }

    private void readConstraintChain(int r4, MotionLayout r5) {
        ConstraintSet r0 = (ConstraintSet) ZeusTransformUtils.preCheckCast(this.mConstraintSetMap.get(r4), ConstraintSet.class, "com.obric.memorydata.plugin");
        r0.derivedState = r0.mIdString;
        int r6 = this.mDeriveMap.get(r4);
        if (r6 <= 0) goto L9;
        readConstraintChain(r6, r5);
        ConstraintSet r7 = (ConstraintSet) ZeusTransformUtils.preCheckCast(this.mConstraintSetMap.get(r6), ConstraintSet.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6));
        return;
    L8:
        r0.derivedState += "/" + r7.derivedState;
        r0.readFallback(r7);
    L10:
        r0.applyDeltaFrom(r0);
        return;
    L9:
        r0.derivedState += "  layout";
        r0.readFallback(r5);
        goto L10
    }

    public static String stripID(String r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        int r0 = r1.indexOf(47);
        if (r0 >= 0) goto L9;
        return r1;
    L9:
        return r1.substring(r0 + 1);
    }

    public void addOnClickListeners(MotionLayout r7, int r8) {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Transition r1 = (Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$400(r1).size() <= 0) goto L4;
        Iterator r2 = Transition.access$400(r1).iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r2.next(), Transition.TransitionOnClick.class, "com.obric.memorydata.plugin")).removeOnClickListeners(r7);
        goto L9
    L11:
        Iterator<Transition> r3 = this.mAbstractTransitionList.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Transition r4 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$400(r4).size() <= 0) goto L13;
        Iterator r5 = Transition.access$400(r4).iterator();
    L18:
        if (r5.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r5.next(), Transition.TransitionOnClick.class, "com.obric.memorydata.plugin")).removeOnClickListeners(r7);
        goto L18
    L20:
        Iterator<Transition> r6 = this.mTransitionList.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Transition r9 = (Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$400(r9).size() <= 0) goto L22;
        Iterator r10 = Transition.access$400(r9).iterator();
    L27:
        if (r10.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r10.next(), Transition.TransitionOnClick.class, "com.obric.memorydata.plugin")).addOnClickListeners(r7, r8, r9);
        goto L27
    L29:
        Iterator<Transition> r11 = this.mAbstractTransitionList.iterator();
    L31:
        if (r11.hasNext() == false) goto L38;
        Transition r12 = (Transition) ZeusTransformUtils.preCheckCast(r11.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$400(r12).size() <= 0) goto L31;
        Iterator r13 = Transition.access$400(r12).iterator();
    L36:
        if (r13.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r13.next(), Transition.TransitionOnClick.class, "com.obric.memorydata.plugin")).addOnClickListeners(r7, r8, r12);
        goto L36
    }

    public void addTransition(Transition r3) {
        int r0 = getIndex(r3);
        ArrayList<Transition> r2 = this.mTransitionList;
        if (r0 != (-1)) goto L5;
        r2.add(r3);
        return;
    L5:
        r2.set(r0, r3);
    }

    public boolean applyViewTransition(int r1, MotionController r2) {
        return this.mViewTransitionController.applyViewTransition(r1, r2);
    }

    boolean autoTransition(MotionLayout r8, int r9) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L10:
        if (r0.hasNext() == false) goto L41;
        Transition r2 = (Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$600(r2) == 0) goto L10;
        Transition r3 = this.mCurrentTransition;
        if (r3 != r2) goto L20;
        if (r3.isTransitionFlag(2) == true) goto L10;
    L20:
        if (r9 != Transition.access$100(r2)) goto L31;
        if (Transition.access$600(r2) == 4) goto L25;
        if (Transition.access$600(r2) != 2) goto L31;
    L25:
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.setTransition(r2);
        if (Transition.access$600(r2) != 4) goto L28;
        r8.transitionToEnd();
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        r8.setProgress(1.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.onNewStateAttachHandlers();
    L31:
        if (r9 != Transition.access$000(r2)) goto L10;
        if (Transition.access$600(r2) == 3) goto L36;
        if (Transition.access$600(r2) != 1) goto L10;
    L36:
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.setTransition(r2);
        if (Transition.access$600(r2) != 3) goto L39;
        r8.transitionToStart();
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        r8.setProgress(0.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.TransitionState.SETUP);
        r8.setState(MotionLayout.TransitionState.MOVING);
        r8.setState(MotionLayout.TransitionState.FINISHED);
        r8.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    public Transition bestTransitionFor(int r17, float r18, float r19, MotionEvent r20) {
        if (r17 == (-1)) goto L37;
        List<Transition> r4 = getTransitionsWithState(r17);
        float r5 = 0.0f;
        Transition r6 = null;
        RectF r7 = new RectF();
        Iterator<Transition> r8 = r4.iterator();
    L6:
        if (r8.hasNext() == false) goto L35;
        Transition r9 = (Transition) ZeusTransformUtils.preCheckCast(r8.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$500(r9) == true) goto L6;
        if (Transition.access$200(r9) == null) goto L6;
        Transition.access$200(r9).setRTL(this.mRtl);
        RectF r10 = Transition.access$200(r9).getTouchRegion(this.mMotionLayout, r7);
        if (r10 == null) goto L18;
        if (r20 == null) goto L18;
        if (r10.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r11 = Transition.access$200(r9).getLimitBoundsTo(this.mMotionLayout, r7);
        if (r11 == null) goto L24;
        if (r20 == null) goto L24;
        if (r11.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r12 = Transition.access$200(r9).dot(r18, r19);
        if (Transition.access$200(r9).mIsRotateMode == false) goto L29;
        if (r20 == null) goto L29;
        float r13 = r20.getX() - Transition.access$200(r9).mRotateCenterX;
        float r14 = r20.getY() - Transition.access$200(r9).mRotateCenterY;
        r12 = ((float) (Math.atan2(r19 + r14, r18 + r13) - Math.atan2(r13, r14))) * 10.0f;
    L29:
        if (Transition.access$000(r9) != r17) goto L31;
        float r15 = -1.0f;
    L32:
        float r16 = r12 * r15;
        if (r16 <= r5) goto L6;
        r6 = r9;
        r5 = r16;
        goto L6
    L31:
        r15 = 1.1f;
        goto L32
    L35:
        return r6;
    L37:
        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean r1) {
        this.mDisableAutoTransition = r1;
    }

    public void enableViewTransition(int r1, boolean r2) {
        this.mViewTransitionController.enableViewTransition(r1, r2);
    }

    public int gatPathMotionArc() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1900(r0);
    }

    int getAutoCompleteMode() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getAutoCompleteMode();
    }

    ConstraintSet getConstraintSet(int r2) {
        return getConstraintSet(r2, -1, -1);
    }

    ConstraintSet getConstraintSet(int r4, int r5, int r6) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r4);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L11;
        int r7 = r0.stateGetConstraintID(r4, r5, r6);
        if (r7 == (-1)) goto L11;
        r4 = r7;
    L11:
        if (this.mConstraintSetMap.get(r4) != null) goto L15;
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4) + " In MotionScene");
        SparseArray<ConstraintSet> r3 = this.mConstraintSetMap;
        r4 = r3.keyAt(0);
    L14:
        return (ConstraintSet) ZeusTransformUtils.preCheckCast(r3.get(r4), ConstraintSet.class, "com.obric.memorydata.plugin");
    L15:
        r3 = this.mConstraintSetMap;
        goto L14
    }

    public ConstraintSet getConstraintSet(Context r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r9);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mConstraintSetMap.size()) goto L16;
        int r2 = this.mConstraintSetMap.keyAt(r0);
        String r3 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(r2);
        if (this.DEBUG_DESKTOP == false) goto L12;
        System.out.println("Id for <" + r0 + "> is <" + r3 + "> looking for <" + r9 + ">");
    L12:
        if (r9.equals(r3) == true) goto L14;
        r0 = r0 + 1;
        goto L7
    L14:
        return (ConstraintSet) ZeusTransformUtils.preCheckCast(this.mConstraintSetMap.get(r2), ConstraintSet.class, "com.obric.memorydata.plugin");
    L16:
        return null;
    }

    public int[] getConstraintSetIds() {
        int r0 = this.mConstraintSetMap.size();
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mConstraintSetMap.keyAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L7;
        return Transition.access$1800(r0);
    L7:
        return this.mDefaultDuration;
    }

    int getEndId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r0);
    }

    public Interpolator getInterpolator() {
        int r0 = Transition.access$1500(this.mCurrentTransition);
        if (r0 == (-2)) goto L34;
        if (r0 == (-1)) goto L31;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L26;
        if (r0 == 4) goto L24;
        if (r0 == 5) goto L22;
        if (r0 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L31:
        final Easing r1 = Easing.getInterpolator(Transition.access$1600(this.mCurrentTransition));
        return new AnonymousClass1(this, r1);
    L34:
        return AnimationUtils.loadInterpolator((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Transition.access$1700(this.mCurrentTransition));
    }

    Key getKeyFrame(Context r7, int r8, int r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Transition r6 = this.mCurrentTransition;
        if (r6 != null) goto L5;
        return null;
    L5:
        Iterator r12 = Transition.access$1400(r6).iterator();
    L7:
        if (r12.hasNext() == false) goto L21;
        KeyFrames r0 = (KeyFrames) ZeusTransformUtils.preCheckCast(r12.next(), KeyFrames.class, "com.obric.memorydata.plugin");
        Iterator<Integer> r2 = r0.getKeys().iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r9 != r3.intValue()) goto L10;
        Iterator<Key> r4 = r0.getKeyFramesForView(r3.intValue()).iterator();
    L15:
        if (r4.hasNext() == false) goto L10;
        Key r5 = (Key) ZeusTransformUtils.preCheckCast(r4.next(), Key.class, "com.obric.memorydata.plugin");
        if (r5.mFramePosition != r10) goto L15;
        if (r5.mType != r8) goto L15;
        return r5;
    L21:
        return null;
    }

    public void getKeyFrames(MotionController r4) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L11;
        Transition r3 = this.mDefaultTransition;
        if (r3 == null) goto L10;
        Iterator r5 = Transition.access$1400(r3).iterator();
    L8:
        if (r5.hasNext() == false) goto L18;
        ((KeyFrames) ZeusTransformUtils.preCheckCast(r5.next(), KeyFrames.class, "com.obric.memorydata.plugin")).addFrames(r4);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r6 = Transition.access$1400(r0).iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        ((KeyFrames) ZeusTransformUtils.preCheckCast(r6.next(), KeyFrames.class, "com.obric.memorydata.plugin")).addFrames(r4);
        goto L13
    }

    float getMaxAcceleration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    boolean getMoveWhenScrollAtTop() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View r1, int r2) {
        return 0.0f;
    }

    float getProgressDirection(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(r2, r3);
    }

    int getSpringBoundary() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringBoundary();
    }

    float getSpringDamping() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringDamping();
    }

    float getSpringMass() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringMass();
    }

    float getSpringStiffiness() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStiffness();
    }

    float getSpringStopThreshold() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$2000(r0);
    }

    int getStartId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r0);
    }

    public Transition getTransitionById(int r4) {
        Iterator<Transition> r3 = this.mTransitionList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Transition r0 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$300(r0) != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    int getTransitionDirection(int r4) {
        Iterator<Transition> r3 = this.mTransitionList.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (Transition.access$100((Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.memorydata.plugin")) != r4) goto L4;
        return 0;
    L9:
        return 1;
    }

    public List<Transition> getTransitionsWithState(int r5) {
        int r6 = getRealID(r5);
        ArrayList r0 = new ArrayList();
        Iterator<Transition> r4 = this.mTransitionList.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Transition r1 = (Transition) ZeusTransformUtils.preCheckCast(r4.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$100(r1) == r6) goto L9;
        if (Transition.access$000(r1) != r6) goto L4;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    boolean hasKeyFramePosition(View r6, int r7) {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator r8 = Transition.access$1400(r5).iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        Iterator<Key> r1 = ((KeyFrames) ZeusTransformUtils.preCheckCast(r8.next(), KeyFrames.class, "com.obric.memorydata.plugin")).getKeyFramesForView(r6.getId()).iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        if (((Key) ZeusTransformUtils.preCheckCast(r1.next(), Key.class, "com.obric.memorydata.plugin")).mFramePosition != r7) goto L10;
        return true;
    L15:
        return false;
    }

    public boolean isViewTransitionEnabled(int r1) {
        return this.mViewTransitionController.isViewTransitionEnabled(r1);
    }

    public int lookUpConstraintId(String r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.mConstraintSetIdMap.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    }

    public String lookUpConstraintName(int r5) {
        Iterator<Map.Entry<String, Integer>> r4 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (r1.intValue() != r5) goto L4;
        return (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }

    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    void processScrollMove(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(r2, r3);
        return;
    }

    void processScrollUp(float r2, float r3) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(r2, r3);
        return;
    }

    void processTouchEvent(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r0 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r4 = r12.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L10;
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        this.mLastTouchDown = r12;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r15 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r0);
        if (r15 != null) goto L35;
    L38:
        RectF r16 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r16 != null) goto L41;
    L43:
        this.mMotionOutsideRegion = false;
    L44:
        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        return;
    L41:
        if (r16.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L43;
        this.mMotionOutsideRegion = true;
        goto L44
    L35:
        if (r15.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L38;
        this.mLastTouchDown = null;
        this.mIgnoreTouch = true;
        return;
    L65:
        return;
    L10:
        if (r4 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r6 = r12.getRawY() - this.mLastTouchY;
        float r7 = r12.getRawX() - this.mLastTouchX;
        if (r7 == 0.0d) goto L18;
    L19:
        MotionEvent r8 = this.mLastTouchDown;
        if (r8 == null) goto L64;
        Transition r9 = bestTransitionFor(r13, r7, r6, r8);
        if (r9 == null) goto L47;
        r14.setTransition(r9);
        RectF r1 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r1 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r5;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r1.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r5 = true;
        goto L29
    L64:
        return;
    L18:
        if (r6 != 0.0d) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L52;
    L56:
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r17 = this.mVelocityTracker;
        if (r17 == null) goto L67;
        r17.recycle();
        this.mVelocityTracker = null;
        if (r14.mCurrentState == (-1)) goto L68;
        autoTransition(r14, r14.mCurrentState);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.access$200(r2) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(r12, this.mVelocityTracker, r13, this);
        goto L56
    }

    void readFallback(MotionLayout r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mConstraintSetMap.size()) goto L10;
        int r1 = this.mConstraintSetMap.keyAt(r0);
        if (hasCycleDependency(r1) == true) goto L7;
        readConstraintChain(r1, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
        return;
    }

    public void removeTransition(Transition r2) {
        int r3 = getIndex(r2);
        if (r3 == (-1)) goto L6;
        this.mTransitionList.remove(r3);
        return;
    }

    public void setConstraintSet(int r1, ConstraintSet r2) {
        this.mConstraintSetMap.put(r1, r2);
    }

    public void setDuration(int r2) {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L5;
        r0.setDuration(r2);
        return;
    L5:
        this.mDefaultDuration = r2;
    }

    public void setKeyframe(View r5, int r6, String r7, Object r8) {
        Transition r4 = this.mCurrentTransition;
        if (r4 != null) goto L5;
        return;
    L5:
        Iterator r9 = Transition.access$1400(r4).iterator();
    L7:
        if (r9.hasNext() == false) goto L18;
        Iterator<Key> r0 = ((KeyFrames) ZeusTransformUtils.preCheckCast(r9.next(), KeyFrames.class, "com.obric.memorydata.plugin")).getKeyFramesForView(r5.getId()).iterator();
    L10:
        if (r0.hasNext() == false) goto L7;
        if (((Key) ZeusTransformUtils.preCheckCast(r0.next(), Key.class, "com.obric.memorydata.plugin")).mFramePosition != r6) goto L10;
        if (r8 == null) goto L16;
        float r3 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue();
    L17:
        int r1 = (r3 > 0.0f ? 1 : (r3 == 0.0f ? 0 : -1));
        r7.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    L16:
        r3 = 0.0f;
        goto L17
    }

    public void setRtl(boolean r1) {
        this.mRtl = r1;
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r2) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    void setTransition(int r8, int r9) {
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L11;
        int r1 = r0.stateGetConstraintID(r8, -1, -1);
        if (r1 != (-1)) goto L8;
        r1 = r8;
    L8:
        int r2 = this.mStateSet.stateGetConstraintID(r9, -1, -1);
        if (r2 != (-1)) goto L13;
    L12:
        r2 = r9;
    L13:
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L16;
    L20:
        Iterator<Transition> r4 = this.mTransitionList.iterator();
    L22:
        if (r4.hasNext() == false) goto L37;
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(r4.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$000(r5) != r2) goto L28;
        if (Transition.access$100(r5) != r1) goto L28;
    L31:
        this.mCurrentTransition = r5;
        if (r5 != null) goto L34;
        return;
    L34:
        if (Transition.access$200(r5) == null) goto L61;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L61:
        return;
    L28:
        if (Transition.access$000(r5) != r9) goto L22;
        if (Transition.access$100(r5) != r8) goto L22;
    L37:
        Transition r10 = this.mDefaultTransition;
        Iterator<Transition> r6 = this.mAbstractTransitionList.iterator();
    L39:
        if (r6.hasNext() == false) goto L43;
        Transition r7 = (Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.memorydata.plugin");
        if (Transition.access$000(r7) != r9) goto L39;
        r10 = r7;
        goto L39
    L43:
        Transition r11 = new Transition(this, r10);
        Transition.access$102(r11, r1);
        Transition.access$002(r11, r2);
        if (r1 == (-1)) goto L46;
        this.mTransitionList.add(r11);
    L46:
        this.mCurrentTransition = r11;
        return;
    L16:
        if (Transition.access$000(r3) != r9) goto L20;
        if (Transition.access$100(this.mCurrentTransition) != r8) goto L20;
        return;
    L11:
        r1 = r8;
        goto L12
    }

    public void setTransition(Transition r1) {
        this.mCurrentTransition = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r1) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    void setupTouch() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    boolean supportTouch() {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Transition.access$200((Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.memorydata.plugin")) == null) goto L4;
        return true;
    L8:
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r5) == null) goto L13;
        return true;
    }

    public boolean validateLayout(MotionLayout r2) {
        if (r2 == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (r2.mScene != this) goto L7;
        return true;
    }

    public void viewTransition(int r1, View... r2) {
        this.mViewTransitionController.viewTransition(r1, r2);
    }
}

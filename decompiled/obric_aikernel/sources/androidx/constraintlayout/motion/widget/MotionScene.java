package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
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
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.bytedance.bdinstall.oaid.OaidModel;
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

            public TransitionOnClick(Context r10, Transition r11, XmlPullParser r12) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r11;
                TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r12), R.styleable.OnClick);
                int r14 = r13.getIndexCount();
                int r15 = 0;
            L3:
                if (r15 >= r14) goto L11;
                int r16 = r13.getIndex(r15);
                if (r16 != R.styleable.OnClick_targetId) goto L8;
                this.mTargetId = r13.getResourceId(r16, this.mTargetId);
            L10:
                r15 = r15 + 1;
                goto L3
            L8:
                if (r16 != R.styleable.OnClick_clickAction) goto L10;
                this.mMode = r13.getInt(r16, this.mMode);
                goto L10
            L11:
                r13.recycle();
            }

            public TransitionOnClick(Transition r10, int r11, int r12) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r10;
                this.mTargetId = r11;
                this.mMode = r12;
            }

            public void addOnClickListeners(MotionLayout r10, int r11, Transition r12) {
                int r13 = this.mTargetId;
                View r14 = r10;
                if (r13 == (-1)) goto L6;
                r14 = r10.findViewById(r13);
            L6:
                if (r14 != null) goto L9;
                Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r15 = Transition.access$100(r12);
                int r16 = Transition.access$000(r12);
                if (r15 != (-1)) goto L13;
                r14.setOnClickListener(this);
                return;
            L13:
                int r17 = this.mMode;
                boolean r18 = false;
                if ((r17 & 1) == 0) goto L17;
                if (r11 != r15) goto L17;
                boolean r19 = true;
            L19:
                if ((r17 & 256) == 0) goto L22;
                if (r11 != r15) goto L22;
                boolean r20 = true;
            L23:
                boolean r21 = r19 | r20;
                if ((r17 & 1) == 0) goto L27;
                if (r11 != r15) goto L27;
                boolean r22 = true;
            L28:
                boolean r23 = r22 | r21;
                if ((r17 & 16) == 0) goto L32;
                if (r11 != r16) goto L32;
                boolean r24 = true;
            L33:
                boolean r25 = r23 | r24;
                if ((r17 & 4096) == 0) goto L38;
                if (r11 != r16) goto L38;
                r18 = true;
            L38:
                if ((r25 | r18) == false) goto L41;
                r14.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r24 = false;
            L27:
                r22 = false;
            L22:
                r20 = false;
            L17:
                r19 = false;
                goto L19
            }

            boolean isTransitionViable(Transition r10, MotionLayout r11) {
                Transition r12 = this.mTransition;
                if (r12 != r10) goto L5;
                return true;
            L5:
                int r13 = Transition.access$000(r12);
                int r14 = Transition.access$100(this.mTransition);
                if (r14 == (-1)) goto L8;
                int r15 = r11.mCurrentState;
                if (r15 == r14) goto L19;
                if (r15 != r13) goto L17;
                return true;
            L17:
                return false;
            L19:
                return true;
            L8:
                if (r11.mCurrentState == r13) goto L11;
                return true;
            L11:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r10) {
                MotionLayout r11 = MotionScene.access$700(Transition.access$800(this.mTransition));
                if (r11.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r12 = r11.getCurrentState();
                if (r12 != (-1)) goto L11;
                r11.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r13 = new Transition(Transition.access$800(this.mTransition), this.mTransition);
                Transition.access$102(r13, r12);
                Transition.access$002(r13, Transition.access$000(this.mTransition));
                r11.setTransition(r13);
                r11.transitionToEnd();
                return;
            L13:
                Transition r14 = Transition.access$800(this.mTransition).mCurrentTransition;
                int r15 = this.mMode;
                boolean r16 = false;
                if ((r15 & 1) == 0) goto L16;
            L19:
                boolean r17 = true;
            L21:
                if ((r15 & 16) == 0) goto L23;
            L26:
                boolean r18 = true;
            L27:
                if (r17 == false) goto L30;
                if (r18 == false) goto L30;
                boolean r19 = true;
            L31:
                if (r19 == false) goto L41;
                Transition r20 = Transition.access$800(this.mTransition).mCurrentTransition;
                Transition r21 = this.mTransition;
                if (r20 == r21) goto L36;
                r11.setTransition(r21);
            L36:
                if (r11.getCurrentState() == r11.getEndState()) goto L43;
                if (r11.getProgress() > 0.5f) goto L43;
                r18 = false;
            L43:
                if (isTransitionViable(r14, r11) == false) goto L61;
                if (r16 == true) goto L46;
            L48:
                if (r18 == true) goto L50;
            L52:
                if (r16 == true) goto L54;
            L57:
                if (r18 == true) goto L59;
                return;
            L59:
                if ((this.mMode & 4096) == 0) goto L66;
                r11.setTransition(this.mTransition);
                float r22 = 0.0f;
            L56:
                r11.setProgress(r22);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L57;
                r11.setTransition(this.mTransition);
                r22 = 1.0f;
                goto L56
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r11.setTransition(this.mTransition);
                r11.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r11.setTransition(this.mTransition);
                r11.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r16 = r17;
            L30:
                r19 = false;
                goto L31
            L23:
                if ((r15 & 4096) != 0) goto L26;
                r18 = false;
                goto L27
            L16:
                if ((r15 & 256) != 0) goto L19;
                r17 = false;
                goto L21
            }

            public void removeOnClickListeners(MotionLayout r10) {
                int r11 = this.mTargetId;
                if (r11 != (-1)) goto L5;
                return;
            L5:
                View r12 = r10.findViewById(r11);
                if (r12 != null) goto L9;
                Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r12.setOnClickListener(null);
            }
        }

        public Transition(int r10, MotionScene r11, int r12, int r13) {
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
            this.mId = r10;
            this.mMotionScene = r11;
            this.mConstraintSetStart = r12;
            this.mConstraintSetEnd = r13;
            this.mDuration = MotionScene.access$900(r11);
            this.mLayoutDuringTransition = MotionScene.access$1000(r11);
        }

        Transition(MotionScene r10, Context r11, XmlPullParser r12) {
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
            this.mDuration = MotionScene.access$900(r10);
            this.mLayoutDuringTransition = MotionScene.access$1000(r10);
            this.mMotionScene = r10;
            fillFromAttributeList(r10, r11, Xml.asAttributeSet(r12));
        }

        Transition(MotionScene r10, Transition r11) {
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
            this.mMotionScene = r10;
            this.mDuration = MotionScene.access$900(r10);
            if (r11 == null) goto L6;
            this.mPathMotionArc = r11.mPathMotionArc;
            this.mDefaultInterpolator = r11.mDefaultInterpolator;
            this.mDefaultInterpolatorString = r11.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = r11.mDefaultInterpolatorID;
            this.mDuration = r11.mDuration;
            this.mKeyFramesList = r11.mKeyFramesList;
            this.mStagger = r11.mStagger;
            this.mLayoutDuringTransition = r11.mLayoutDuringTransition;
            return;
        }

        static /* synthetic */ int access$000(Transition r10) {
            return r10.mConstraintSetEnd;
        }

        static /* synthetic */ int access$002(Transition r10, int r11) {
            r10.mConstraintSetEnd = r11;
            return r11;
        }

        static /* synthetic */ int access$100(Transition r10) {
            return r10.mConstraintSetStart;
        }

        static /* synthetic */ int access$102(Transition r10, int r11) {
            r10.mConstraintSetStart = r11;
            return r11;
        }

        static /* synthetic */ boolean access$1300(Transition r10) {
            return r10.mIsAbstract;
        }

        static /* synthetic */ ArrayList access$1400(Transition r10) {
            return r10.mKeyFramesList;
        }

        static /* synthetic */ int access$1500(Transition r10) {
            return r10.mDefaultInterpolator;
        }

        static /* synthetic */ String access$1600(Transition r10) {
            return r10.mDefaultInterpolatorString;
        }

        static /* synthetic */ int access$1700(Transition r10) {
            return r10.mDefaultInterpolatorID;
        }

        static /* synthetic */ int access$1800(Transition r10) {
            return r10.mDuration;
        }

        static /* synthetic */ int access$1900(Transition r10) {
            return r10.mPathMotionArc;
        }

        static /* synthetic */ TouchResponse access$200(Transition r10) {
            return r10.mTouchResponse;
        }

        static /* synthetic */ float access$2000(Transition r10) {
            return r10.mStagger;
        }

        static /* synthetic */ TouchResponse access$202(Transition r10, TouchResponse r11) {
            r10.mTouchResponse = r11;
            return r11;
        }

        static /* synthetic */ int access$300(Transition r10) {
            return r10.mId;
        }

        static /* synthetic */ ArrayList access$400(Transition r10) {
            return r10.mOnClicks;
        }

        static /* synthetic */ boolean access$500(Transition r10) {
            return r10.mDisable;
        }

        static /* synthetic */ int access$600(Transition r10) {
            return r10.mAutoTransition;
        }

        static /* synthetic */ MotionScene access$800(Transition r10) {
            return r10.mMotionScene;
        }

        private void fill(MotionScene r10, Context r11, TypedArray r12) {
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L66;
            int r15 = r12.getIndex(r14);
            if (r15 != R.styleable.Transition_constraintSetEnd) goto L15;
            this.mConstraintSetEnd = r12.getResourceId(r15, -1);
            String r16 = r11.getResources().getResourceTypeName(this.mConstraintSetEnd);
            if ("layout".equals(r16) == false) goto L12;
            ConstraintSet r17 = new ConstraintSet();
            r17.load(r11, this.mConstraintSetEnd);
            SparseArray r18 = MotionScene.access$1100(r10);
            int r19 = this.mConstraintSetEnd;
        L10:
            r18.append(r19, r17);
        L64:
            r14 = r14 + 1;
            goto L4
        L12:
            if ("xml".equals(r16) == false) goto L64;
            this.mConstraintSetEnd = MotionScene.access$1200(r10, r11, this.mConstraintSetEnd);
            goto L64
        L15:
            if (r15 != R.styleable.Transition_constraintSetStart) goto L23;
            this.mConstraintSetStart = r12.getResourceId(r15, this.mConstraintSetStart);
            String r20 = r11.getResources().getResourceTypeName(this.mConstraintSetStart);
            if ("layout".equals(r20) == false) goto L20;
            r17 = new ConstraintSet();
            r17.load(r11, this.mConstraintSetStart);
            r18 = MotionScene.access$1100(r10);
            r19 = this.mConstraintSetStart;
            goto L10
        L20:
            if ("xml".equals(r20) == false) goto L64;
            this.mConstraintSetStart = MotionScene.access$1200(r10, r11, this.mConstraintSetStart);
            goto L64
        L23:
            if (r15 != R.styleable.Transition_motionInterpolator) goto L39;
            int r21 = r12.peekValue(r15).type;
            if (r21 != 1) goto L30;
            int r22 = r12.getResourceId(r15, -1);
            this.mDefaultInterpolatorID = r22;
            if (r22 == (-1)) goto L64;
        L28:
            this.mDefaultInterpolator = -2;
            goto L64
        L30:
            if (r21 != 3) goto L37;
            String r23 = r12.getString(r15);
            this.mDefaultInterpolatorString = r23;
            if (r23 == null) goto L64;
            if (r23.indexOf("/") <= 0) goto L36;
            this.mDefaultInterpolatorID = r12.getResourceId(r15, -1);
            goto L28
        L36:
            this.mDefaultInterpolator = -1;
            goto L64
        L37:
            this.mDefaultInterpolator = r12.getInteger(r15, this.mDefaultInterpolator);
            goto L64
        L39:
            if (r15 != R.styleable.Transition_duration) goto L44;
            int r24 = r12.getInt(r15, this.mDuration);
            this.mDuration = r24;
            if (r24 >= 8) goto L64;
            this.mDuration = 8;
            goto L64
        L44:
            if (r15 != R.styleable.Transition_staggered) goto L47;
            this.mStagger = r12.getFloat(r15, this.mStagger);
            goto L64
        L47:
            if (r15 != R.styleable.Transition_autoTransition) goto L50;
            this.mAutoTransition = r12.getInteger(r15, this.mAutoTransition);
            goto L64
        L50:
            if (r15 != R.styleable.Transition_android_id) goto L53;
            this.mId = r12.getResourceId(r15, this.mId);
            goto L64
        L53:
            if (r15 != R.styleable.Transition_transitionDisable) goto L56;
            this.mDisable = r12.getBoolean(r15, this.mDisable);
            goto L64
        L56:
            if (r15 != R.styleable.Transition_pathMotionArc) goto L59;
            this.mPathMotionArc = r12.getInteger(r15, -1);
            goto L64
        L59:
            if (r15 != R.styleable.Transition_layoutDuringTransition) goto L62;
            this.mLayoutDuringTransition = r12.getInteger(r15, 0);
            goto L64
        L62:
            if (r15 != R.styleable.Transition_transitionFlags) goto L64;
            this.mTransitionFlags = r12.getInteger(r15, 0);
            goto L64
        L66:
            if (this.mConstraintSetStart != (-1)) goto L90;
            this.mIsAbstract = true;
            return;
        }

        private void fillFromAttributeList(MotionScene r10, Context r11, AttributeSet r12) {
            TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.Transition);
            fill(r10, r11, r13);
            r13.recycle();
        }

        public void addKeyFrame(KeyFrames r10) {
            this.mKeyFramesList.add(r10);
        }

        public void addOnClick(int r10, int r11) {
            Iterator<TransitionOnClick> r12 = this.mOnClicks.iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            TransitionOnClick r13 = r12.next();
            if (r13.mTargetId != r10) goto L4;
            r13.mMode = r11;
            return;
        L9:
            TransitionOnClick r14 = new TransitionOnClick(this, r10, r11);
            this.mOnClicks.add(r14);
        }

        public void addOnClick(Context r10, XmlPullParser r11) {
            this.mOnClicks.add(new TransitionOnClick(r10, this, r11));
        }

        public String debugString(Context r10) {
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r11 = "null";
        L7:
            if (this.mConstraintSetEnd != (-1)) goto L10;
            return r11 + " -> null";
        L10:
            return r11 + " -> " + r10.getResources().getResourceEntryName(this.mConstraintSetEnd);
        L5:
            r11 = r10.getResources().getResourceEntryName(this.mConstraintSetStart);
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

        public boolean isTransitionFlag(int r10) {
            if ((this.mTransitionFlags & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void removeOnClick(int r10) {
            Iterator<TransitionOnClick> r11 = this.mOnClicks.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            TransitionOnClick r12 = r11.next();
            if (r12.mTargetId != r10) goto L4;
        L9:
            if (r12 == null) goto L15;
            this.mOnClicks.remove(r12);
            return;
        L15:
            return;
        L8:
            r12 = null;
            goto L9
        }

        public void setAutoTransition(int r10) {
            this.mAutoTransition = r10;
        }

        public void setDuration(int r10) {
            this.mDuration = Math.max(r10, 8);
        }

        public void setEnable(boolean r10) {
            setEnabled(r10);
        }

        public void setEnabled(boolean r10) {
            this.mDisable = !r10;
        }

        public void setInterpolatorInfo(int r10, String r11, int r12) {
            this.mDefaultInterpolator = r10;
            this.mDefaultInterpolatorString = r11;
            this.mDefaultInterpolatorID = r12;
        }

        public void setLayoutDuringTransition(int r10) {
            this.mLayoutDuringTransition = r10;
        }

        public void setOnSwipe(OnSwipe r10) {
            if (r10 != null) goto L4;
            TouchResponse r11 = null;
        L5:
            this.mTouchResponse = r11;
            return;
        L4:
            r11 = new TouchResponse(MotionScene.access$700(this.mMotionScene), r10);
            goto L5
        }

        public void setOnTouchUp(int r10) {
            TouchResponse r11 = getTouchResponse();
            if (r11 == null) goto L6;
            r11.setTouchUpMode(r10);
            return;
        }

        public void setPathMotionArc(int r10) {
            this.mPathMotionArc = r10;
        }

        public void setStagger(float r10) {
            this.mStagger = r10;
        }

        public void setTransitionFlag(int r10) {
            this.mTransitionFlags = r10;
        }
    }

    MotionScene(Context r10, MotionLayout r11, int r12) {
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
        this.mMotionLayout = r11;
        this.mViewTransitionController = new ViewTransitionController(r11);
        load(r10, r12);
        SparseArray<ConstraintSet> r13 = this.mConstraintSetMap;
        int r14 = R.id.motion_base;
        r13.put(r14, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(r14));
    }

    public MotionScene(MotionLayout r10) {
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
        this.mMotionLayout = r10;
        this.mViewTransitionController = new ViewTransitionController(r10);
    }

    static /* synthetic */ int access$1000(MotionScene r10) {
        return r10.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene r10) {
        return r10.mConstraintSetMap;
    }

    static /* synthetic */ int access$1200(MotionScene r10, Context r11, int r12) {
        return r10.parseInclude(r11, r12);
    }

    static /* synthetic */ MotionLayout access$700(MotionScene r10) {
        return r10.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene r10) {
        return r10.mDefaultDuration;
    }

    private int getId(Context r10, String r11) {
        if (r11.contains("/") == false) goto L7;
        int r12 = r10.getResources().getIdentifier(r11.substring(r11.indexOf(47) + 1), OaidModel.KEY_ID, r10.getPackageName());
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id getMap res = " + r12);
    L8:
        if (r12 == (-1)) goto L10;
        return r12;
    L10:
        if (r11.length() > 1) goto L15;
        Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        return r12;
    L15:
        return Integer.parseInt(r11.substring(1));
    L7:
        r12 = -1;
        goto L8
    }

    private int getIndex(Transition r10) {
        int r11 = Transition.access$300(r10);
        if (r11 == (-1)) goto L13;
        int r12 = 0;
    L6:
        if (r12 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300(this.mTransitionList.get(r12)) == r11) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return r12;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    static String getLine(Context r10, int r11, XmlPullParser r12) {
        return ".(" + Debug.getName(r10, r11) + ".xml:" + r12.getLineNumber() + ") \"" + r12.getName() + "\"";
    }

    private int getRealID(int r10) {
        StateSet r11 = this.mStateSet;
        if (r11 == null) goto L7;
        int r12 = r11.stateGetConstraintID(r10, -1, -1);
        if (r12 == (-1)) goto L7;
        return r12;
    L7:
        return r10;
    }

    private boolean hasCycleDependency(int r10) {
        int r11 = this.mDeriveMap.get(r10);
        int r12 = this.mDeriveMap.size();
    L3:
        if (r11 <= 0) goto L11;
        if (r11 == r10) goto L6;
        int r13 = r12 - 1;
        if (r12 < 0) goto L9;
        r11 = this.mDeriveMap.get(r11);
        r12 = r13;
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
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        Transition r13 = null;
        int r14 = r12.getEventType();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L4:
        byte r15 = 1;
        if (r14 == 1) goto L117;
        if (r14 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L80:
        r14 = r12.next();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L8:
        if (r14 != 2) goto L80;
        String r16 = r12.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.DEBUG_DESKTOP == false) goto L15;
        System.out.println("parsing = " + r16);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L15:
        switch(r16.hashCode()) {
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
        r15 = -1;
    L48:
        switch(r15) {
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
        this.mViewTransitionController.add(new ViewTransition(r10, r12));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L51:
        KeyFrames r17 = new KeyFrames(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (r13 == null) goto L80;
        Transition.access$1400(r13).add(r17);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L54:
        parseInclude(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L55:
        parseConstraintSet(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L56:
        this.mStateSet = new StateSet(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L57:
        if (r13 == null) goto L80;
        r13.addOnClick(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L59:
        if (r13 != null) goto L61;
        Log.v(TypedValues.MotionScene.NAME, " OnSwipe (" + r10.getResources().getResourceEntryName(r11) + ".xml:" + r12.getLineNumber() + ")");     // Catch: IOException -> L82 XmlPullParserException -> L84
    L61:
        if (r13 == null) goto L80;
        Transition.access$202(r13, new TouchResponse(r10, this.mMotionLayout, r12));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L63:
        ArrayList<Transition> r18 = this.mTransitionList;     // Catch: IOException -> L82 XmlPullParserException -> L84
        Transition r19 = new Transition(this, r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        r18.add(r19);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.mCurrentTransition != null) goto L71;
        if (Transition.access$1300(r19) == true) goto L71;
        this.mCurrentTransition = r19;     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (Transition.access$200(r19) == null) goto L71;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L71:
        if (Transition.access$1300(r19) == true) goto L73;
    L77:
        r13 = r19;
        goto L80
    L73:
        if (Transition.access$000(r19) != (-1)) goto L75;
        this.mDefaultTransition = r19;     // Catch: IOException -> L82 XmlPullParserException -> L84
    L76:
        this.mTransitionList.remove(r19);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L77
    L75:
        this.mAbstractTransitionList.add(r19);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L76
    L78:
        parseMotionSceneTags(r10, r12);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L18:
        if (r16.equals(INCLUDE_TAG) == false) goto L47;
        r15 = 6;
        goto L48
    L47:
        r15 = -1;
        goto L48
    L21:
        if (r16.equals(STATESET_TAG) == false) goto L106;
        r15 = 4;
        goto L48
    L106:
        r15 = -1;
        goto L48
    L24:
        if (r16.equals(TypedValues.MotionScene.NAME) == false) goto L107;
        r15 = 0;
        goto L48
    L107:
        r15 = -1;
        goto L48
    L27:
        if (r16.equals(ONSWIPE_TAG) == false) goto L108;
        r15 = 2;
        goto L48
    L108:
        r15 = -1;
        goto L48
    L30:
        if (r16.equals(ONCLICK_TAG) == false) goto L109;
        r15 = 3;
        goto L48
    L109:
        r15 = -1;
        goto L48
    L33:
        if (r16.equals(TRANSITION_TAG) == true) goto L48;
        r15 = -1;
        goto L48
    L36:
        if (r16.equals("ViewTransition") == false) goto L111;
        r15 = 9;
        goto L48
    L111:
        r15 = -1;
        goto L48
    L39:
        if (r16.equals(INCLUDE_TAG_UC) == false) goto L112;
        r15 = 7;
        goto L48
    L112:
        r15 = -1;
        goto L48
    L42:
        if (r16.equals("KeyFrameSet") == false) goto L113;
        r15 = 8;
        goto L48
    L113:
        r15 = -1;
        goto L48
    L45:
        if (r16.equals(CONSTRAINTSET_TAG) == false) goto L114;
        r15 = 5;
        goto L48
    L114:
        r15 = -1;
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
        ConstraintSet r10 = new ConstraintSet();
        r10.setForceId(false);
        int r11 = r15.getAttributeCount();
        int r12 = 0;
        int r13 = -1;
        int r16 = -1;
    L4:
        if (r12 >= r11) goto L60;
        String r17 = r15.getAttributeName(r12);
        String r18 = r15.getAttributeValue(r12);
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id string = " + r18);
    L8:
        r17.hashCode();
        switch(r17.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            default: goto L10;
        };
    L10:
        byte r19 = -1;
    L23:
        switch(r19) {
            case 0: goto L58;
            case 1: goto L69;
            case 2: goto L25;
            default: goto L59;
        };
    L25:
        r13 = getId(r14, r18);
        this.mConstraintSetIdMap.put(stripID(r18), Integer.valueOf(r13));
        r10.mIdString = Debug.getName(r14, r13);
        goto L59
    L58:
        r16 = getId(r14, r18);
        goto L59
    L69:
        r10.mRotate = Integer.parseInt(r18);     // Catch: NumberFormatException -> L28
    L28:
        r18.hashCode();
        switch(r18.hashCode()) {
            case -768416914: goto L48;
            case 3317767: goto L44;
            case 3387192: goto L40;
            case 108511772: goto L36;
            case 1954540437: goto L32;
            default: goto L30;
        };
    L30:
        byte r20 = -1;
    L51:
        switch(r20) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            default: goto L59;
        };
    L53:
        r10.mRotate = 3;
        goto L59
    L54:
        r10.mRotate = 1;
        goto L59
    L55:
        r10.mRotate = 0;
        goto L59
    L56:
        r10.mRotate = 2;
        goto L59
    L57:
        r10.mRotate = 4;
        goto L59
    L32:
        if (r18.equals("x_right") == false) goto L85;
        r20 = 4;
        goto L51
    L85:
        r20 = -1;
        goto L51
    L36:
        if (r18.equals("right") == false) goto L86;
        r20 = 3;
        goto L51
    L86:
        r20 = -1;
        goto L51
    L40:
        if (r18.equals("none") == false) goto L87;
        r20 = 2;
        goto L51
    L87:
        r20 = -1;
        goto L51
    L44:
        if (r18.equals("left") == false) goto L88;
        r20 = 1;
        goto L51
    L88:
        r20 = -1;
        goto L51
    L48:
        if (r18.equals("x_left") == false) goto L89;
        r20 = 0;
        goto L51
    L89:
        r20 = -1;
    L59:
        r12 = r12 + 1;
        goto L4
    L12:
        if (r17.equals(OaidModel.KEY_ID) == false) goto L82;
        r19 = 2;
        goto L23
    L82:
        r19 = -1;
        goto L23
    L16:
        if (r17.equals("constraintRotate") == false) goto L83;
        r19 = 1;
        goto L23
    L83:
        r19 = -1;
        goto L23
    L20:
        if (r17.equals("deriveConstraintsFrom") == false) goto L84;
        r19 = 0;
        goto L23
    L84:
        r19 = -1;
        goto L23
    L60:
        if (r13 != (-1)) goto L62;
    L68:
        return r13;
    L62:
        if (this.mMotionLayout.mDebugPath == 0) goto L64;
        r10.setValidateOnParse(true);
    L64:
        r10.load(r14, r15);
        if (r16 == (-1)) goto L67;
        this.mDeriveMap.put(r13, r16);
    L67:
        this.mConstraintSetMap.put(r13, r10);
        goto L68
    }

    private int parseInclude(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r13 == 1) goto L27;
        String r14 = r12.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r13) goto L12;
        if (CONSTRAINTSET_TAG.equals(r14) == false) goto L12;
        return parseConstraintSet(r10, r12);
    L12:
        r13 = r12.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
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

    private void parseInclude(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.include);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.include_constraintSet) goto L7;
        parseInclude(r10, r12.getResourceId(r15, -1));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r12.recycle();
    }

    private void parseMotionSceneTags(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.MotionScene);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L13;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.MotionScene_defaultDuration) goto L10;
        int r16 = r12.getInt(r15, this.mDefaultDuration);
        this.mDefaultDuration = r16;
        if (r16 >= 8) goto L12;
        this.mDefaultDuration = 8;
    L12:
        r14 = r14 + 1;
        goto L3
    L10:
        if (r15 != R.styleable.MotionScene_layoutDuringTransition) goto L12;
        this.mLayoutDuringTransition = r12.getInteger(r15, 0);
        goto L12
    L13:
        r12.recycle();
    }

    private void readConstraintChain(int r10, MotionLayout r11) {
        ConstraintSet r12 = this.mConstraintSetMap.get(r10);
        r12.derivedState = r12.mIdString;
        int r13 = this.mDeriveMap.get(r10);
        if (r13 <= 0) goto L9;
        readConstraintChain(r13, r11);
        ConstraintSet r14 = this.mConstraintSetMap.get(r13);
        if (r14 != null) goto L8;
        Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), r13));
        return;
    L8:
        r12.derivedState += "/" + r14.derivedState;
        r12.readFallback(r14);
    L10:
        r12.applyDeltaFrom(r12);
        return;
    L9:
        r12.derivedState += "  layout";
        r12.readFallback(r11);
        goto L10
    }

    public static String stripID(String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        int r11 = r10.indexOf(47);
        if (r11 >= 0) goto L9;
        return r10;
    L9:
        return r10.substring(r11 + 1);
    }

    public void addOnClickListeners(MotionLayout r10, int r11) {
        Iterator<Transition> r12 = this.mTransitionList.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Transition r13 = r12.next();
        if (Transition.access$400(r13).size() <= 0) goto L4;
        Iterator r14 = Transition.access$400(r13).iterator();
    L9:
        if (r14.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) r14.next()).removeOnClickListeners(r10);
        goto L9
    L11:
        Iterator<Transition> r15 = this.mAbstractTransitionList.iterator();
    L13:
        if (r15.hasNext() == false) goto L20;
        Transition r16 = r15.next();
        if (Transition.access$400(r16).size() <= 0) goto L13;
        Iterator r17 = Transition.access$400(r16).iterator();
    L18:
        if (r17.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) r17.next()).removeOnClickListeners(r10);
        goto L18
    L20:
        Iterator<Transition> r18 = this.mTransitionList.iterator();
    L22:
        if (r18.hasNext() == false) goto L29;
        Transition r19 = r18.next();
        if (Transition.access$400(r19).size() <= 0) goto L22;
        Iterator r20 = Transition.access$400(r19).iterator();
    L27:
        if (r20.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) r20.next()).addOnClickListeners(r10, r11, r19);
        goto L27
    L29:
        Iterator<Transition> r21 = this.mAbstractTransitionList.iterator();
    L31:
        if (r21.hasNext() == false) goto L38;
        Transition r22 = r21.next();
        if (Transition.access$400(r22).size() <= 0) goto L31;
        Iterator r23 = Transition.access$400(r22).iterator();
    L36:
        if (r23.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) r23.next()).addOnClickListeners(r10, r11, r22);
        goto L36
    }

    public void addTransition(Transition r10) {
        int r11 = getIndex(r10);
        ArrayList<Transition> r12 = this.mTransitionList;
        if (r11 != (-1)) goto L5;
        r12.add(r10);
        return;
    L5:
        r12.set(r11, r10);
    }

    public boolean applyViewTransition(int r10, MotionController r11) {
        return this.mViewTransitionController.applyViewTransition(r10, r11);
    }

    boolean autoTransition(MotionLayout r10, int r11) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r12 = this.mTransitionList.iterator();
    L10:
        if (r12.hasNext() == false) goto L41;
        Transition r13 = r12.next();
        if (Transition.access$600(r13) == 0) goto L10;
        Transition r14 = this.mCurrentTransition;
        if (r14 != r13) goto L20;
        if (r14.isTransitionFlag(2) == true) goto L10;
    L20:
        if (r11 != Transition.access$100(r13)) goto L31;
        if (Transition.access$600(r13) == 4) goto L25;
        if (Transition.access$600(r13) != 2) goto L31;
    L25:
        MotionLayout.TransitionState r15 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r15);
        r10.setTransition(r13);
        if (Transition.access$600(r13) != 4) goto L28;
        r10.transitionToEnd();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        r10.setProgress(1.0f);
        r10.evaluate(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r15);
        r10.onNewStateAttachHandlers();
    L31:
        if (r11 != Transition.access$000(r13)) goto L10;
        if (Transition.access$600(r13) == 3) goto L36;
        if (Transition.access$600(r13) != 1) goto L10;
    L36:
        MotionLayout.TransitionState r16 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r16);
        r10.setTransition(r13);
        if (Transition.access$600(r13) != 3) goto L39;
        r10.transitionToStart();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        r10.setProgress(0.0f);
        r10.evaluate(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r16);
        r10.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    public Transition bestTransitionFor(int r17, float r18, float r19, MotionEvent r20) {
        if (r17 == (-1)) goto L37;
        List<Transition> r10 = getTransitionsWithState(r17);
        float r11 = 0.0f;
        Transition r12 = null;
        RectF r13 = new RectF();
        Iterator<Transition> r14 = r10.iterator();
    L6:
        if (r14.hasNext() == false) goto L35;
        Transition r15 = r14.next();
        if (Transition.access$500(r15) == true) goto L6;
        if (Transition.access$200(r15) == null) goto L6;
        Transition.access$200(r15).setRTL(this.mRtl);
        RectF r16 = Transition.access$200(r15).getTouchRegion(this.mMotionLayout, r13);
        if (r16 == null) goto L18;
        if (r20 == null) goto L18;
        if (r16.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r21 = Transition.access$200(r15).getLimitBoundsTo(this.mMotionLayout, r13);
        if (r21 == null) goto L24;
        if (r20 == null) goto L24;
        if (r21.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r22 = Transition.access$200(r15).dot(r18, r19);
        if (Transition.access$200(r15).mIsRotateMode == false) goto L29;
        if (r20 == null) goto L29;
        float r23 = r20.getX() - Transition.access$200(r15).mRotateCenterX;
        float r110 = r20.getY() - Transition.access$200(r15).mRotateCenterY;
        r22 = ((float) (Math.atan2(r19 + r110, r18 + r23) - Math.atan2(r23, r110))) * 10.0f;
    L29:
        if (Transition.access$000(r15) != r17) goto L31;
        float r111 = -1.0f;
    L32:
        float r24 = r22 * r111;
        if (r24 <= r11) goto L6;
        r12 = r15;
        r11 = r24;
        goto L6
    L31:
        r111 = 1.1f;
        goto L32
    L35:
        return r12;
    L37:
        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean r10) {
        this.mDisableAutoTransition = r10;
    }

    public void enableViewTransition(int r10, boolean r11) {
        this.mViewTransitionController.enableViewTransition(r10, r11);
    }

    public int gatPathMotionArc() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1900(r10);
    }

    int getAutoCompleteMode() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getAutoCompleteMode();
    }

    ConstraintSet getConstraintSet(int r10) {
        return getConstraintSet(r10, -1, -1);
    }

    ConstraintSet getConstraintSet(int r10, int r11, int r12) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r10);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        StateSet r13 = this.mStateSet;
        if (r13 == null) goto L11;
        int r14 = r13.stateGetConstraintID(r10, r11, r12);
        if (r14 == (-1)) goto L11;
        r10 = r14;
    L11:
        if (this.mConstraintSetMap.get(r10) != null) goto L15;
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), r10) + " In MotionScene");
        SparseArray<ConstraintSet> r15 = this.mConstraintSetMap;
        r10 = r15.keyAt(0);
    L14:
        return r15.get(r10);
    L15:
        r15 = this.mConstraintSetMap;
        goto L14
    }

    public ConstraintSet getConstraintSet(Context r10, String r11) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + r11);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        int r12 = 0;
    L7:
        if (r12 >= this.mConstraintSetMap.size()) goto L16;
        int r13 = this.mConstraintSetMap.keyAt(r12);
        String r14 = r10.getResources().getResourceName(r13);
        if (this.DEBUG_DESKTOP == false) goto L12;
        System.out.println("Id for <" + r12 + "> is <" + r14 + "> looking for <" + r11 + ">");
    L12:
        if (r11.equals(r14) == true) goto L14;
        r12 = r12 + 1;
        goto L7
    L14:
        return this.mConstraintSetMap.get(r13);
    L16:
        return null;
    }

    public int[] getConstraintSetIds() {
        int r10 = this.mConstraintSetMap.size();
        int[] r11 = new int[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = this.mConstraintSetMap.keyAt(r12);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition r10 = this.mCurrentTransition;
        if (r10 == null) goto L7;
        return Transition.access$1800(r10);
    L7:
        return this.mDefaultDuration;
    }

    int getEndId() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r10);
    }

    public Interpolator getInterpolator() {
        int r10 = Transition.access$1500(this.mCurrentTransition);
        if (r10 == (-2)) goto L34;
        if (r10 == (-1)) goto L31;
        if (r10 == 0) goto L30;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L26;
        if (r10 == 4) goto L24;
        if (r10 == 5) goto L22;
        if (r10 == 6) goto L20;
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
        final Easing r11 = Easing.getInterpolator(Transition.access$1600(this.mCurrentTransition));
        return new AnonymousClass1(this, r11);
    L34:
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1700(this.mCurrentTransition));
    }

    Key getKeyFrame(Context r10, int r11, int r12, int r13) {
        Transition r14 = this.mCurrentTransition;
        if (r14 != null) goto L5;
        return null;
    L5:
        Iterator r15 = Transition.access$1400(r14).iterator();
    L7:
        if (r15.hasNext() == false) goto L21;
        KeyFrames r16 = (KeyFrames) r15.next();
        Iterator<Integer> r17 = r16.getKeys().iterator();
    L10:
        if (r17.hasNext() == false) goto L7;
        Integer r18 = r17.next();
        if (r12 != r18.intValue()) goto L10;
        Iterator<Key> r19 = r16.getKeyFramesForView(r18.intValue()).iterator();
    L15:
        if (r19.hasNext() == false) goto L10;
        Key r20 = r19.next();
        if (r20.mFramePosition != r13) goto L15;
        if (r20.mType != r11) goto L15;
        return r20;
    L21:
        return null;
    }

    public void getKeyFrames(MotionController r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L11;
        Transition r12 = this.mDefaultTransition;
        if (r12 == null) goto L10;
        Iterator r13 = Transition.access$1400(r12).iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        ((KeyFrames) r13.next()).addFrames(r10);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r14 = Transition.access$1400(r11).iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((KeyFrames) r14.next()).addFrames(r10);
        goto L13
    }

    float getMaxAcceleration() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    boolean getMoveWhenScrollAtTop() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View r10, int r11) {
        return 0.0f;
    }

    float getProgressDirection(float r10, float r11) {
        Transition r12 = this.mCurrentTransition;
        if (r12 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r12) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(r10, r11);
    }

    int getSpringBoundary() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringBoundary();
    }

    float getSpringDamping() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringDamping();
    }

    float getSpringMass() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringMass();
    }

    float getSpringStiffiness() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStiffness();
    }

    float getSpringStopThreshold() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r10) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$2000(r10);
    }

    int getStartId() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r10);
    }

    public Transition getTransitionById(int r10) {
        Iterator<Transition> r11 = this.mTransitionList.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Transition r12 = r11.next();
        if (Transition.access$300(r12) != r10) goto L4;
        return r12;
    L8:
        return null;
    }

    int getTransitionDirection(int r10) {
        Iterator<Transition> r11 = this.mTransitionList.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (Transition.access$100(r11.next()) != r10) goto L4;
        return 0;
    L9:
        return 1;
    }

    public List<Transition> getTransitionsWithState(int r10) {
        int r11 = getRealID(r10);
        ArrayList r12 = new ArrayList();
        Iterator<Transition> r13 = this.mTransitionList.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Transition r14 = r13.next();
        if (Transition.access$100(r14) == r11) goto L9;
        if (Transition.access$000(r14) != r11) goto L4;
    L9:
        r12.add(r14);
        goto L4
    L10:
        return r12;
    }

    boolean hasKeyFramePosition(View r10, int r11) {
        Transition r12 = this.mCurrentTransition;
        if (r12 != null) goto L5;
        return false;
    L5:
        Iterator r13 = Transition.access$1400(r12).iterator();
    L7:
        if (r13.hasNext() == false) goto L15;
        Iterator<Key> r14 = ((KeyFrames) r13.next()).getKeyFramesForView(r10.getId()).iterator();
    L10:
        if (r14.hasNext() == false) goto L7;
        if (r14.next().mFramePosition != r11) goto L10;
        return true;
    L15:
        return false;
    }

    public boolean isViewTransitionEnabled(int r10) {
        return this.mViewTransitionController.isViewTransitionEnabled(r10);
    }

    public int lookUpConstraintId(String r10) {
        Integer r11 = this.mConstraintSetIdMap.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.intValue();
    }

    public String lookUpConstraintName(int r10) {
        Iterator<Map.Entry<String, Integer>> r11 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<String, Integer> r12 = r11.next();
        Integer r13 = r12.getValue();
        if (r13 == null) goto L4;
        if (r13.intValue() != r10) goto L4;
        return r12.getKey();
    L12:
        return null;
    }

    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    void processScrollMove(float r10, float r11) {
        Transition r12 = this.mCurrentTransition;
        if (r12 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r12) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(r10, r11);
        return;
    }

    void processScrollUp(float r10, float r11) {
        Transition r12 = this.mCurrentTransition;
        if (r12 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r12) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(r10, r11);
        return;
    }

    void processTouchEvent(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r10 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r11 = r12.getAction();
        boolean r15 = false;
        if (r11 != 0) goto L10;
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        this.mLastTouchDown = r12;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r16 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r10);
        if (r16 != null) goto L35;
    L38:
        RectF r17 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r10);
        if (r17 != null) goto L41;
    L43:
        this.mMotionOutsideRegion = false;
    L44:
        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        return;
    L41:
        if (r17.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L43;
        this.mMotionOutsideRegion = true;
        goto L44
    L35:
        if (r16.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L38;
        this.mLastTouchDown = null;
        this.mIgnoreTouch = true;
        return;
    L65:
        return;
    L10:
        if (r11 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r18 = r12.getRawY() - this.mLastTouchY;
        float r19 = r12.getRawX() - this.mLastTouchX;
        if (r19 == 0.0d) goto L18;
    L19:
        MotionEvent r20 = this.mLastTouchDown;
        if (r20 == null) goto L64;
        Transition r21 = bestTransitionFor(r13, r19, r18, r20);
        if (r21 == null) goto L47;
        r14.setTransition(r21);
        RectF r22 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r10);
        if (r22 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r15;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r22.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r15 = true;
        goto L29
    L64:
        return;
    L18:
        if (r18 != 0.0d) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r23 = this.mCurrentTransition;
        if (r23 != null) goto L52;
    L56:
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r110 = this.mVelocityTracker;
        if (r110 == null) goto L67;
        r110.recycle();
        this.mVelocityTracker = null;
        int r111 = r14.mCurrentState;
        if (r111 == (-1)) goto L68;
        autoTransition(r14, r111);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.access$200(r23) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(r12, this.mVelocityTracker, r13, this);
        goto L56
    }

    void readFallback(MotionLayout r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mConstraintSetMap.size()) goto L10;
        int r12 = this.mConstraintSetMap.keyAt(r11);
        if (hasCycleDependency(r12) == true) goto L7;
        readConstraintChain(r12, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
        return;
    }

    public void removeTransition(Transition r10) {
        int r11 = getIndex(r10);
        if (r11 == (-1)) goto L6;
        this.mTransitionList.remove(r11);
        return;
    }

    public void setConstraintSet(int r10, ConstraintSet r11) {
        this.mConstraintSetMap.put(r10, r11);
    }

    public void setDuration(int r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 == null) goto L5;
        r11.setDuration(r10);
        return;
    L5:
        this.mDefaultDuration = r10;
    }

    public void setKeyframe(View r10, int r11, String r12, Object r13) {
        Transition r14 = this.mCurrentTransition;
        if (r14 != null) goto L5;
        return;
    L5:
        Iterator r15 = Transition.access$1400(r14).iterator();
    L7:
        if (r15.hasNext() == false) goto L16;
        Iterator<Key> r16 = ((KeyFrames) r15.next()).getKeyFramesForView(r10.getId()).iterator();
    L10:
        if (r16.hasNext() == false) goto L7;
        if (r16.next().mFramePosition != r11) goto L10;
        if (r13 == null) goto L15;
        ((Float) r13).floatValue();
    L15:
        r12.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    }

    public void setRtl(boolean r10) {
        this.mRtl = r10;
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r11) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    void setTransition(int r10, int r11) {
        StateSet r12 = this.mStateSet;
        if (r12 == null) goto L11;
        int r13 = r12.stateGetConstraintID(r10, -1, -1);
        if (r13 != (-1)) goto L8;
        r13 = r10;
    L8:
        int r14 = this.mStateSet.stateGetConstraintID(r11, -1, -1);
        if (r14 != (-1)) goto L13;
    L12:
        r14 = r11;
    L13:
        Transition r15 = this.mCurrentTransition;
        if (r15 != null) goto L16;
    L20:
        Iterator<Transition> r16 = this.mTransitionList.iterator();
    L22:
        if (r16.hasNext() == false) goto L37;
        Transition r17 = r16.next();
        if (Transition.access$000(r17) != r14) goto L28;
        if (Transition.access$100(r17) != r13) goto L28;
    L31:
        this.mCurrentTransition = r17;
        if (r17 != null) goto L34;
        return;
    L34:
        if (Transition.access$200(r17) == null) goto L61;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L61:
        return;
    L28:
        if (Transition.access$000(r17) != r11) goto L22;
        if (Transition.access$100(r17) != r10) goto L22;
    L37:
        Transition r18 = this.mDefaultTransition;
        Iterator<Transition> r19 = this.mAbstractTransitionList.iterator();
    L39:
        if (r19.hasNext() == false) goto L43;
        Transition r20 = r19.next();
        if (Transition.access$000(r20) != r11) goto L39;
        r18 = r20;
        goto L39
    L43:
        Transition r21 = new Transition(this, r18);
        Transition.access$102(r21, r13);
        Transition.access$002(r21, r14);
        if (r13 == (-1)) goto L46;
        this.mTransitionList.add(r21);
    L46:
        this.mCurrentTransition = r21;
        return;
    L16:
        if (Transition.access$000(r15) != r11) goto L20;
        if (Transition.access$100(this.mCurrentTransition) != r10) goto L20;
        return;
    L11:
        r13 = r10;
        goto L12
    }

    public void setTransition(Transition r10) {
        this.mCurrentTransition = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r10) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    void setupTouch() {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r10) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    boolean supportTouch() {
        Iterator<Transition> r10 = this.mTransitionList.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (Transition.access$200(r10.next()) == null) goto L4;
        return true;
    L8:
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r11) == null) goto L13;
        return true;
    }

    public boolean validateLayout(MotionLayout r10) {
        if (r10 == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (r10.mScene != this) goto L7;
        return true;
    }

    public void viewTransition(int r10, View... r11) {
        this.mViewTransitionController.viewTransition(r10, r11);
    }
}

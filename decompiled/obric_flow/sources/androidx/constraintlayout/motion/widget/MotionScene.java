package androidx.constraintlayout.motion.widget;

import ai.j0;
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
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
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

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
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

            public TransitionOnClick(Context r5, Transition r10, XmlPullParser r11) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r10;
                TypedArray r12 = r5.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.OnClick);
                int r13 = r12.getIndexCount();
                int r14 = 0;
            L3:
                if (r14 >= r13) goto L11;
                int r15 = r12.getIndex(r14);
                if (r15 != R.styleable.OnClick_targetId) goto L8;
                this.mTargetId = r12.getResourceId(r15, this.mTargetId);
            L10:
                r14 = r14 + 1;
                goto L3
            L8:
                if (r15 != R.styleable.OnClick_clickAction) goto L10;
                this.mMode = r12.getInt(r15, this.mMode);
                goto L10
            L11:
                r12.recycle();
            }

            public void addOnClickListeners(MotionLayout r10, int r11, Transition r12) {
                int r5 = this.mTargetId;
                View r13 = r10;
                if (r5 == (-1)) goto L6;
                r13 = r10.findViewById(r5);
            L6:
                if (r13 != null) goto L9;
                Log.e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r14 = Transition.access$100(r12);
                int r15 = Transition.access$000(r12);
                if (r14 != (-1)) goto L13;
                r13.setOnClickListener(this);
                return;
            L13:
                int r16 = this.mMode;
                boolean r17 = false;
                if ((r16 & 1) == 0) goto L17;
                if (r11 != r14) goto L17;
                boolean r18 = true;
            L19:
                if ((r16 & 256) == 0) goto L22;
                if (r11 != r14) goto L22;
                boolean r19 = true;
            L23:
                boolean r20 = r18 | r19;
                if ((r16 & 1) == 0) goto L27;
                if (r11 != r14) goto L27;
                boolean r21 = true;
            L28:
                boolean r22 = r21 | r20;
                if ((r16 & 16) == 0) goto L32;
                if (r11 != r15) goto L32;
                boolean r23 = true;
            L33:
                boolean r24 = r22 | r23;
                if ((r16 & 4096) == 0) goto L38;
                if (r11 != r15) goto L38;
                r17 = true;
            L38:
                if ((r24 | r17) == false) goto L41;
                r13.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r23 = false;
            L27:
                r21 = false;
            L22:
                r19 = false;
            L17:
                r18 = false;
                goto L19
            }

            public boolean isTransitionViable(Transition r5, MotionLayout r10) {
                Transition r11 = this.mTransition;
                if (r11 != r5) goto L5;
                return true;
            L5:
                int r12 = Transition.access$000(r11);
                int r13 = Transition.access$100(this.mTransition);
                if (r13 == (-1)) goto L8;
                int r14 = r10.mCurrentState;
                if (r14 == r13) goto L19;
                if (r14 != r12) goto L17;
                return true;
            L17:
                return false;
            L19:
                return true;
            L8:
                if (r10.mCurrentState == r12) goto L11;
                return true;
            L11:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r10) {
                MotionLayout r11 = MotionScene.access$800(Transition.access$700(this.mTransition));
                if (r11.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r5 = r11.getCurrentState();
                if (r5 != (-1)) goto L11;
                r11.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r12 = new Transition(Transition.access$700(this.mTransition), this.mTransition);
                Transition.access$102(r12, r5);
                Transition.access$002(r12, Transition.access$000(this.mTransition));
                r11.setTransition(r12);
                r11.transitionToEnd();
                return;
            L13:
                Transition r13 = Transition.access$700(this.mTransition).mCurrentTransition;
                int r14 = this.mMode;
                boolean r15 = false;
                if ((r14 & 1) == 0) goto L16;
            L19:
                boolean r16 = true;
            L21:
                if ((r14 & 16) == 0) goto L23;
            L26:
                boolean r17 = true;
            L27:
                if (r16 == false) goto L38;
                if (r17 == false) goto L38;
                Transition r18 = Transition.access$700(this.mTransition).mCurrentTransition;
                Transition r19 = this.mTransition;
                if (r18 == r19) goto L33;
                r11.setTransition(r19);
            L33:
                if (r11.getCurrentState() == r11.getEndState()) goto L40;
                if (r11.getProgress() > 0.5f) goto L40;
                r17 = false;
            L40:
                if (isTransitionViable(r13, r11) == false) goto L58;
                if (r15 == true) goto L43;
            L45:
                if (r17 == true) goto L47;
            L49:
                if (r15 == true) goto L51;
            L53:
                if (r17 == true) goto L55;
                return;
            L55:
                if ((this.mMode & 4096) == 0) goto L63;
                r11.setTransition(this.mTransition);
                r11.setProgress(0.0f);
                return;
            L63:
                return;
            L51:
                if ((this.mMode & 256) == 0) goto L53;
                r11.setTransition(this.mTransition);
                r11.setProgress(1.0f);
                return;
            L47:
                if ((this.mMode & 16) == 0) goto L49;
                r11.setTransition(this.mTransition);
                r11.transitionToStart();
                return;
            L43:
                if ((this.mMode & 1) == 0) goto L45;
                r11.setTransition(this.mTransition);
                r11.transitionToEnd();
                return;
            L58:
                return;
            L38:
                r15 = r16;
                goto L40
            L23:
                if ((r14 & 4096) != 0) goto L26;
                r17 = false;
                goto L27
            L16:
                if ((r14 & 256) != 0) goto L19;
                r16 = false;
                goto L21
            }

            public void removeOnClickListeners(MotionLayout r5) {
                int r10 = this.mTargetId;
                if (r10 != (-1)) goto L5;
                return;
            L5:
                View r11 = r5.findViewById(r10);
                if (r11 != null) goto L9;
                Log.e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r11.setOnClickListener(null);
            }
        }

        public Transition(MotionScene r5, Transition r10) {
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
            if (r10 == null) goto L6;
            this.mPathMotionArc = r10.mPathMotionArc;
            this.mDefaultInterpolator = r10.mDefaultInterpolator;
            this.mDefaultInterpolatorString = r10.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = r10.mDefaultInterpolatorID;
            this.mDuration = r10.mDuration;
            this.mKeyFramesList = r10.mKeyFramesList;
            this.mStagger = r10.mStagger;
            this.mLayoutDuringTransition = r10.mLayoutDuringTransition;
            return;
        }

        public static /* synthetic */ int access$000(Transition r5) {
            return r5.mConstraintSetEnd;
        }

        public static /* synthetic */ int access$002(Transition r5, int r10) {
            r5.mConstraintSetEnd = r10;
            return r10;
        }

        public static /* synthetic */ int access$100(Transition r5) {
            return r5.mConstraintSetStart;
        }

        public static /* synthetic */ int access$102(Transition r5, int r10) {
            r5.mConstraintSetStart = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$1200(Transition r5) {
            return r5.mIsAbstract;
        }

        public static /* synthetic */ ArrayList access$1300(Transition r5) {
            return r5.mKeyFramesList;
        }

        public static /* synthetic */ int access$1400(Transition r5) {
            return r5.mDefaultInterpolator;
        }

        public static /* synthetic */ String access$1500(Transition r5) {
            return r5.mDefaultInterpolatorString;
        }

        public static /* synthetic */ int access$1600(Transition r5) {
            return r5.mDefaultInterpolatorID;
        }

        public static /* synthetic */ int access$1700(Transition r5) {
            return r5.mDuration;
        }

        public static /* synthetic */ int access$1800(Transition r5) {
            return r5.mPathMotionArc;
        }

        public static /* synthetic */ float access$1900(Transition r5) {
            return r5.mStagger;
        }

        public static /* synthetic */ TouchResponse access$200(Transition r5) {
            return r5.mTouchResponse;
        }

        public static /* synthetic */ TouchResponse access$202(Transition r5, TouchResponse r10) {
            r5.mTouchResponse = r10;
            return r10;
        }

        public static /* synthetic */ int access$300(Transition r5) {
            return r5.mId;
        }

        public static /* synthetic */ ArrayList access$400(Transition r5) {
            return r5.mOnClicks;
        }

        public static /* synthetic */ boolean access$500(Transition r5) {
            return r5.mDisable;
        }

        public static /* synthetic */ int access$600(Transition r5) {
            return r5.mAutoTransition;
        }

        public static /* synthetic */ MotionScene access$700(Transition r5) {
            return r5.mMotionScene;
        }

        private void fill(MotionScene r10, Context r11, TypedArray r12) {
            int r5 = r12.getIndexCount();
            int r13 = 0;
        L4:
            if (r13 >= r5) goto L55;
            int r14 = r12.getIndex(r13);
            if (r14 != R.styleable.Transition_constraintSetEnd) goto L11;
            this.mConstraintSetEnd = r12.getResourceId(r14, this.mConstraintSetEnd);
            if ("layout".equals(r11.getResources().getResourceTypeName(this.mConstraintSetEnd)) == false) goto L53;
            ConstraintSet r15 = new ConstraintSet();
            r15.load(r11, this.mConstraintSetEnd);
            MotionScene.access$1100(r10).append(this.mConstraintSetEnd, r15);
        L53:
            r13 = r13 + 1;
            goto L4
        L11:
            if (r14 != R.styleable.Transition_constraintSetStart) goto L16;
            this.mConstraintSetStart = r12.getResourceId(r14, this.mConstraintSetStart);
            if ("layout".equals(r11.getResources().getResourceTypeName(this.mConstraintSetStart)) == false) goto L53;
            ConstraintSet r16 = new ConstraintSet();
            r16.load(r11, this.mConstraintSetStart);
            MotionScene.access$1100(r10).append(this.mConstraintSetStart, r16);
            goto L53
        L16:
            if (r14 != R.styleable.Transition_motionInterpolator) goto L30;
            int r17 = r12.peekValue(r14).type;
            if (r17 != 1) goto L23;
            int r18 = r12.getResourceId(r14, -1);
            this.mDefaultInterpolatorID = r18;
            if (r18 == (-1)) goto L53;
            this.mDefaultInterpolator = -2;
            goto L53
        L23:
            if (r17 != 3) goto L28;
            String r19 = r12.getString(r14);
            this.mDefaultInterpolatorString = r19;
            if (r19.indexOf("/") <= 0) goto L27;
            this.mDefaultInterpolatorID = r12.getResourceId(r14, -1);
            this.mDefaultInterpolator = -2;
            goto L53
        L27:
            this.mDefaultInterpolator = -1;
            goto L53
        L28:
            this.mDefaultInterpolator = r12.getInteger(r14, this.mDefaultInterpolator);
            goto L53
        L30:
            if (r14 != R.styleable.Transition_duration) goto L33;
            this.mDuration = r12.getInt(r14, this.mDuration);
            goto L53
        L33:
            if (r14 != R.styleable.Transition_staggered) goto L36;
            this.mStagger = r12.getFloat(r14, this.mStagger);
            goto L53
        L36:
            if (r14 != R.styleable.Transition_autoTransition) goto L39;
            this.mAutoTransition = r12.getInteger(r14, this.mAutoTransition);
            goto L53
        L39:
            if (r14 != R.styleable.Transition_android_id) goto L42;
            this.mId = r12.getResourceId(r14, this.mId);
            goto L53
        L42:
            if (r14 != R.styleable.Transition_transitionDisable) goto L45;
            this.mDisable = r12.getBoolean(r14, this.mDisable);
            goto L53
        L45:
            if (r14 != R.styleable.Transition_pathMotionArc) goto L48;
            this.mPathMotionArc = r12.getInteger(r14, -1);
            goto L53
        L48:
            if (r14 != R.styleable.Transition_layoutDuringTransition) goto L51;
            this.mLayoutDuringTransition = r12.getInteger(r14, 0);
            goto L53
        L51:
            if (r14 != R.styleable.Transition_transitionFlags) goto L53;
            this.mTransitionFlags = r12.getInteger(r14, 0);
            goto L53
        L55:
            if (this.mConstraintSetStart != (-1)) goto L77;
            this.mIsAbstract = true;
            return;
        }

        private void fillFromAttributeList(MotionScene r5, Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Transition);
            fill(r5, r10, r12);
            r12.recycle();
        }

        public void addOnClick(Context r5, XmlPullParser r10) {
            this.mOnClicks.add(new TransitionOnClick(r5, this, r10));
        }

        public String debugString(Context r5) {
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r10 = "null";
        L7:
            if (this.mConstraintSetEnd == (-1)) goto L11;
            StringBuilder r11 = j0.w(r10, " -> ");
            r11.append(r5.getResources().getResourceEntryName(this.mConstraintSetEnd));
            return r11.toString();
        L11:
            return j0.j(r10, " -> null");
        L5:
            r10 = r5.getResources().getResourceEntryName(this.mConstraintSetStart);
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

        public boolean isTransitionFlag(int r5) {
            if ((this.mTransitionFlags & r5) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setAutoTransition(int r5) {
            this.mAutoTransition = r5;
        }

        public void setDuration(int r5) {
            this.mDuration = r5;
        }

        public void setEnable(boolean r5) {
            this.mDisable = !r5;
        }

        public void setPathMotionArc(int r5) {
            this.mPathMotionArc = r5;
        }

        public void setStagger(float r5) {
            this.mStagger = r5;
        }

        public Transition(int r5, MotionScene r10, int r11, int r12) {
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
            this.mMotionScene = r10;
            this.mConstraintSetStart = r11;
            this.mConstraintSetEnd = r12;
            this.mDuration = MotionScene.access$900(r10);
            this.mLayoutDuringTransition = MotionScene.access$1000(r10);
        }

        public Transition(MotionScene r5, Context r10, XmlPullParser r11) {
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
            fillFromAttributeList(r5, r10, Xml.asAttributeSet(r11));
        }
    }

    public MotionScene(MotionLayout r5) {
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
    }

    public static /* synthetic */ int access$1000(MotionScene r5) {
        return r5.mLayoutDuringTransition;
    }

    public static /* synthetic */ SparseArray access$1100(MotionScene r5) {
        return r5.mConstraintSetMap;
    }

    public static /* synthetic */ MotionLayout access$800(MotionScene r5) {
        return r5.mMotionLayout;
    }

    public static /* synthetic */ int access$900(MotionScene r5) {
        return r5.mDefaultDuration;
    }

    private int getId(Context r10, String r11) {
        if (r11.contains("/") == false) goto L7;
        int r12 = r10.getResources().getIdentifier(r11.substring(r11.indexOf(47) + 1), "id", r10.getPackageName());
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id getMap res = " + r12);
    L8:
        if (r12 == (-1)) goto L10;
        return r12;
    L10:
        if (r11.length() > 1) goto L15;
        Log.e(TAG, "error in parsing id");
        return r12;
    L15:
        return Integer.parseInt(r11.substring(1));
    L7:
        r12 = -1;
        goto L8
    }

    private int getIndex(Transition r5) {
        int r10 = Transition.access$300(r5);
        if (r10 == (-1)) goto L13;
        int r11 = 0;
    L6:
        if (r11 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300(this.mTransitionList.get(r11)) == r10) goto L9;
        r11 = r11 + 1;
        goto L6
    L9:
        return r11;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    private int getRealID(int r5) {
        StateSet r10 = this.mStateSet;
        if (r10 == null) goto L7;
        int r11 = r10.stateGetConstraintID(r5, -1, -1);
        if (r11 == (-1)) goto L7;
        return r11;
    L7:
        return r5;
    }

    private boolean hasCycleDependency(int r5) {
        int r10 = this.mDeriveMap.get(r5);
        int r11 = this.mDeriveMap.size();
    L3:
        if (r10 <= 0) goto L11;
        if (r10 == r5) goto L6;
        int r12 = r11 - 1;
        if (r11 < 0) goto L9;
        r10 = this.mDeriveMap.get(r10);
        r11 = r12;
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
        XmlResourceParser r5 = r10.getResources().getXml(r11);
        int r12 = r5.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
        Transition r13 = null;
    L4:
        byte r14 = 1;
        if (r12 == 1) goto L96;
        if (r12 != 0) goto L8;
        r5.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L68:
        r12 = r5.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L8:
        if (r12 != 2) goto L68;
        String r15 = r5.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (this.DEBUG_DESKTOP == false) goto L19;
        System.out.println("parsing = " + r15);     // Catch: IOException -> L13 XmlPullParserException -> L15
    L19:
        switch(r15.hashCode()) {
            case -1349929691: goto L40;
            case -1239391468: goto L37;
            case 269306229: goto L34;
            case 312750793: goto L31;
            case 327855227: goto L28;
            case 793277014: goto L25;
            case 1382829617: goto L22;
            default: goto L94;
        };
    L94:
        r14 = -1;
    L43:
        switch(r14) {
            case 0: goto L66;
            case 1: goto L52;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            default: goto L44;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L44:
        Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + r15);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L45:
        Transition.access$1300(r13).add(new KeyFrames(r10, r5));     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L46:
        parseConstraintSet(r10, r5);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L47:
        this.mStateSet = new StateSet(r10, r5);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L48:
        r13.addOnClick(r10, r5);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L49:
        if (r13 != null) goto L51;
        Log.v(TAG, " OnSwipe (" + r10.getResources().getResourceEntryName(r11) + ".xml:" + r5.getLineNumber() + ")");     // Catch: IOException -> L13 XmlPullParserException -> L15
    L51:
        Transition.access$202(r13, new TouchResponse(r10, this.mMotionLayout, r5));     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L52:
        ArrayList<Transition> r16 = this.mTransitionList;     // Catch: IOException -> L13 XmlPullParserException -> L15
        r13 = new Transition(this, r10, r5);     // Catch: IOException -> L13 XmlPullParserException -> L15
        r16.add(r13);     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (this.mCurrentTransition != null) goto L60;
        if (Transition.access$1200(r13) == true) goto L60;
        this.mCurrentTransition = r13;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (Transition.access$200(r13) == null) goto L60;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L13 XmlPullParserException -> L15
    L60:
        if (Transition.access$1200(r13) == false) goto L68;
        if (Transition.access$000(r13) != (-1)) goto L64;
        this.mDefaultTransition = r13;     // Catch: IOException -> L13 XmlPullParserException -> L15
    L65:
        this.mTransitionList.remove(r13);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L64:
        this.mAbstractTransitionList.add(r13);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L65
    L66:
        parseMotionSceneTags(r10, r5);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L68
    L22:
        if (r15.equals("StateSet") == false) goto L42;
        r14 = 4;
        goto L43
    L42:
        r14 = -1;
        goto L43
    L25:
        if (r15.equals(TAG) == false) goto L88;
        r14 = 0;
        goto L43
    L88:
        r14 = -1;
        goto L43
    L28:
        if (r15.equals("OnSwipe") == false) goto L89;
        r14 = 2;
        goto L43
    L89:
        r14 = -1;
        goto L43
    L31:
        if (r15.equals("OnClick") == false) goto L90;
        r14 = 3;
        goto L43
    L90:
        r14 = -1;
        goto L43
    L34:
        if (r15.equals("Transition") == true) goto L43;
        r14 = -1;
        goto L43
    L37:
        if (r15.equals("KeyFrameSet") == false) goto L92;
        r14 = 6;
        goto L43
    L92:
        r14 = -1;
        goto L43
    L40:
        if (r15.equals("ConstraintSet") == false) goto L93;
        r14 = 5;
        goto L43
    L93:
        r14 = -1;
        goto L43
    L96:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r13, XmlPullParser r14) {
        ConstraintSet r5 = new ConstraintSet();
        int r10 = 0;
        r5.setForceId(false);
        int r11 = r14.getAttributeCount();
        int r12 = -1;
        int r15 = -1;
    L3:
        if (r10 >= r11) goto L15;
        String r16 = r14.getAttributeName(r10);
        String r17 = r14.getAttributeValue(r10);
        if (this.DEBUG_DESKTOP == false) goto L7;
        System.out.println("id string = " + r17);
    L7:
        r16.getClass();
        if (r16.equals("deriveConstraintsFrom") == false) goto L10;
        r15 = getId(r13, r17);
    L14:
        r10 = r10 + 1;
        goto L3
    L10:
        if (r16.equals("id") == false) goto L14;
        r12 = getId(r13, r17);
        this.mConstraintSetIdMap.put(stripID(r17), Integer.valueOf(r12));
        goto L14
    L15:
        if (r12 != (-1)) goto L17;
        return;
    L17:
        if (this.mMotionLayout.mDebugPath == 0) goto L19;
        r5.setValidateOnParse(true);
    L19:
        r5.load(r13, r14);
        if (r15 == (-1)) goto L22;
        this.mDeriveMap.put(r12, r15);
    L22:
        this.mConstraintSetMap.put(r12, r5);
    }

    private void parseMotionSceneTags(Context r5, XmlPullParser r10) {
        TypedArray r11 = r5.obtainStyledAttributes(Xml.asAttributeSet(r10), R.styleable.MotionScene);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.MotionScene_defaultDuration) goto L8;
        this.mDefaultDuration = r11.getInt(r14, this.mDefaultDuration);
    L10:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 != R.styleable.MotionScene_layoutDuringTransition) goto L10;
        this.mLayoutDuringTransition = r11.getInteger(r14, 0);
        goto L10
    L11:
        r11.recycle();
    }

    private void readConstraintChain(int r5) {
        int r10 = this.mDeriveMap.get(r5);
        if (r10 <= 0) goto L10;
        readConstraintChain(this.mDeriveMap.get(r5));
        ConstraintSet r11 = this.mConstraintSetMap.get(r5);
        ConstraintSet r12 = this.mConstraintSetMap.get(r10);
        if (r12 != null) goto L8;
        Log.e(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), r10));
        return;
    L8:
        r11.readFallback(r12);
        this.mDeriveMap.put(r5, -1);
        return;
    }

    public static String stripID(String r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        int r10 = r5.indexOf(47);
        if (r10 >= 0) goto L9;
        return r5;
    L9:
        return r5.substring(r10 + 1);
    }

    public void addOnClickListeners(MotionLayout r5, int r10) {
        Iterator<Transition> r11 = this.mTransitionList.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Transition r12 = r11.next();
        if (Transition.access$400(r12).size() <= 0) goto L4;
        Iterator r13 = Transition.access$400(r12).iterator();
    L9:
        if (r13.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) r13.next()).removeOnClickListeners(r5);
        goto L9
    L11:
        Iterator<Transition> r14 = this.mAbstractTransitionList.iterator();
    L13:
        if (r14.hasNext() == false) goto L20;
        Transition r15 = r14.next();
        if (Transition.access$400(r15).size() <= 0) goto L13;
        Iterator r16 = Transition.access$400(r15).iterator();
    L18:
        if (r16.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) r16.next()).removeOnClickListeners(r5);
        goto L18
    L20:
        Iterator<Transition> r17 = this.mTransitionList.iterator();
    L22:
        if (r17.hasNext() == false) goto L29;
        Transition r18 = r17.next();
        if (Transition.access$400(r18).size() <= 0) goto L22;
        Iterator r19 = Transition.access$400(r18).iterator();
    L27:
        if (r19.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) r19.next()).addOnClickListeners(r5, r10, r18);
        goto L27
    L29:
        Iterator<Transition> r20 = this.mAbstractTransitionList.iterator();
    L31:
        if (r20.hasNext() == false) goto L38;
        Transition r21 = r20.next();
        if (Transition.access$400(r21).size() <= 0) goto L31;
        Iterator r22 = Transition.access$400(r21).iterator();
    L36:
        if (r22.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) r22.next()).addOnClickListeners(r5, r10, r21);
        goto L36
    }

    public void addTransition(Transition r5) {
        int r10 = getIndex(r5);
        if (r10 != (-1)) goto L5;
        this.mTransitionList.add(r5);
        return;
    L5:
        this.mTransitionList.set(r10, r5);
    }

    public boolean autoTransition(MotionLayout r10, int r11) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r5 = this.mTransitionList.iterator();
    L10:
        if (r5.hasNext() == false) goto L39;
        Transition r12 = r5.next();
        if (Transition.access$600(r12) == 0) goto L10;
        if (this.mCurrentTransition == r12) goto L10;
        if (r11 != Transition.access$100(r12)) goto L29;
        if (Transition.access$600(r12) == 4) goto L23;
        if (Transition.access$600(r12) != 2) goto L29;
    L23:
        MotionLayout.TransitionState r13 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r13);
        r10.setTransition(r12);
        if (Transition.access$600(r12) != 4) goto L26;
        r10.transitionToEnd();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L27:
        return true;
    L26:
        r10.setProgress(1.0f);
        r10.evaluate(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r13);
        r10.onNewStateAttachHandlers();
    L29:
        if (r11 != Transition.access$000(r12)) goto L10;
        if (Transition.access$600(r12) == 3) goto L34;
        if (Transition.access$600(r12) != 1) goto L10;
    L34:
        MotionLayout.TransitionState r14 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r14);
        r10.setTransition(r12);
        if (Transition.access$600(r12) != 3) goto L37;
        r10.transitionToStart();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L38:
        return true;
    L37:
        r10.setProgress(0.0f);
        r10.evaluate(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r14);
        r10.onNewStateAttachHandlers();
        goto L38
    L39:
        return false;
    }

    public Transition bestTransitionFor(int r10, float r11, float r12, MotionEvent r13) {
        if (r10 == (-1)) goto L34;
        List<Transition> r5 = getTransitionsWithState(r10);
        RectF r14 = new RectF();
        Iterator<Transition> r15 = r5.iterator();
        float r16 = 0.0f;
        Transition r17 = null;
    L6:
        if (r15.hasNext() == false) goto L32;
        Transition r18 = r15.next();
        if (Transition.access$500(r18) == true) goto L6;
        if (Transition.access$200(r18) == null) goto L6;
        Transition.access$200(r18).setRTL(this.mRtl);
        RectF r19 = Transition.access$200(r18).getTouchRegion(this.mMotionLayout, r14);
        if (r19 == null) goto L18;
        if (r13 == null) goto L18;
        if (r19.contains(r13.getX(), r13.getY()) == false) goto L6;
    L18:
        RectF r20 = Transition.access$200(r18).getTouchRegion(this.mMotionLayout, r14);
        if (r20 == null) goto L24;
        if (r13 == null) goto L24;
        if (r20.contains(r13.getX(), r13.getY()) == false) goto L6;
    L24:
        float r21 = Transition.access$200(r18).dot(r11, r12);
        if (Transition.access$000(r18) != r10) goto L28;
        float r22 = -1.0f;
    L27:
        float r23 = r21 * r22;
        if (r23 <= r16) goto L6;
        r17 = r18;
        r16 = r23;
        goto L6
    L28:
        r22 = 1.1f;
        goto L27
    L32:
        return r17;
    L34:
        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean r5) {
        this.mDisableAutoTransition = r5;
    }

    public int gatPathMotionArc() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1800(r5);
    }

    public ConstraintSet getConstraintSet(Context r10, String r11) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        PrintStream r5 = System.out;
        r5.println("id " + r11);
        r5.println("size " + this.mConstraintSetMap.size());
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
        int r5 = this.mConstraintSetMap.size();
        int[] r10 = new int[r5];
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10[r11] = this.mConstraintSetMap.keyAt(r11);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition r5 = this.mCurrentTransition;
        if (r5 == null) goto L7;
        return Transition.access$1700(r5);
    L7:
        return this.mDefaultDuration;
    }

    public int getEndId() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r5);
    }

    public Interpolator getInterpolator() {
        int r5 = Transition.access$1400(this.mCurrentTransition);
        if (r5 == (-2)) goto L30;
        if (r5 == (-1)) goto L27;
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L22;
        if (r5 == 4) goto L20;
        if (r5 == 5) goto L18;
        return null;
    L18:
        return new BounceInterpolator();
    L20:
        return new AnticipateInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final Easing r10 = Easing.getInterpolator(Transition.access$1500(this.mCurrentTransition));
        return new AnonymousClass1(this, r10);
    L30:
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1600(this.mCurrentTransition));
    }

    public Key getKeyFrame(Context r10, int r11, int r12, int r13) {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator r14 = Transition.access$1300(r5).iterator();
    L7:
        if (r14.hasNext() == false) goto L21;
        KeyFrames r15 = (KeyFrames) r14.next();
        Iterator<Integer> r16 = r15.getKeys().iterator();
    L10:
        if (r16.hasNext() == false) goto L7;
        Integer r17 = r16.next();
        if (r12 != r17.intValue()) goto L10;
        Iterator<Key> r18 = r15.getKeyFramesForView(r17.intValue()).iterator();
    L15:
        if (r18.hasNext() == false) goto L10;
        Key r19 = r18.next();
        if (r19.mFramePosition != r13) goto L15;
        if (r19.mType != r11) goto L15;
        return r19;
    L21:
        return null;
    }

    public void getKeyFrames(MotionController r5) {
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L11;
        Transition r11 = this.mDefaultTransition;
        if (r11 == null) goto L10;
        Iterator r12 = Transition.access$1300(r11).iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        ((KeyFrames) r12.next()).addFrames(r5);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r13 = Transition.access$1300(r10).iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        ((KeyFrames) r13.next()).addFrames(r5);
        goto L13
    }

    public float getMaxAcceleration() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r5) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r5) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r5) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View r5, int r10) {
        return 0.0f;
    }

    public float getProgressDirection(float r5, float r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r11) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(r5, r10);
    }

    public float getStaggered() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$1900(r5);
    }

    public int getStartId() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r5);
    }

    public Transition getTransitionById(int r5) {
        Iterator<Transition> r10 = this.mTransitionList.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Transition r11 = r10.next();
        if (Transition.access$300(r11) != r5) goto L4;
        return r11;
    L8:
        return null;
    }

    public int getTransitionDirection(int r5) {
        Iterator<Transition> r10 = this.mTransitionList.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (Transition.access$100(r10.next()) != r5) goto L4;
        return 0;
    L9:
        return 1;
    }

    public List<Transition> getTransitionsWithState(int r5) {
        int r10 = getRealID(r5);
        ArrayList r11 = new ArrayList();
        Iterator<Transition> r12 = this.mTransitionList.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Transition r13 = r12.next();
        if (Transition.access$100(r13) == r10) goto L9;
        if (Transition.access$000(r13) != r10) goto L4;
    L9:
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    public boolean hasKeyFramePosition(View r5, int r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L5;
        return false;
    L5:
        Iterator r12 = Transition.access$1300(r11).iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Iterator<Key> r13 = ((KeyFrames) r12.next()).getKeyFramesForView(r5.getId()).iterator();
    L10:
        if (r13.hasNext() == false) goto L7;
        if (r13.next().mFramePosition != r10) goto L10;
        return true;
    L15:
        return false;
    }

    public int lookUpConstraintId(String r5) {
        return this.mConstraintSetIdMap.get(r5).intValue();
    }

    public String lookUpConstraintName(int r5) {
        Iterator<Map.Entry<String, Integer>> r10 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r11 = r10.next();
        if (r11.getValue().intValue() != r5) goto L4;
        return r11.getKey();
    L9:
        return null;
    }

    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }

    public void processScrollMove(float r5, float r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r11) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(r5, r10);
        return;
    }

    public void processScrollUp(float r5, float r10) {
        Transition r11 = this.mCurrentTransition;
        if (r11 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r11) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(r5, r10);
        return;
    }

    public void processTouchEvent(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r5 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r10 = r12.getAction();
        boolean r11 = false;
        if (r10 != 0) goto L10;
        this.mLastTouchX = r12.getRawX();
        this.mLastTouchY = r12.getRawY();
        this.mLastTouchDown = r12;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r15 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r5);
        if (r15 != null) goto L35;
    L38:
        RectF r16 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r5);
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
        if (r10 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r17 = r12.getRawY() - this.mLastTouchY;
        float r18 = r12.getRawX() - this.mLastTouchX;
        if (r18 == 0.0d) goto L18;
    L19:
        MotionEvent r19 = this.mLastTouchDown;
        if (r19 == null) goto L64;
        Transition r20 = bestTransitionFor(r13, r18, r17, r19);
        if (r20 == null) goto L47;
        r14.setTransition(r20);
        RectF r21 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r5);
        if (r21 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r11;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r21.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r11 = true;
        goto L29
    L64:
        return;
    L18:
        if (r17 != 0.0d) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r22 = this.mCurrentTransition;
        if (r22 != null) goto L52;
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
        if (Transition.access$200(r22) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(r12, this.mVelocityTracker, r13, this);
        goto L56
    }

    public void readFallback(MotionLayout r5) {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.mConstraintSetMap.size()) goto L11;
        int r12 = this.mConstraintSetMap.keyAt(r11);
        if (hasCycleDependency(r12) == true) goto L7;
        readConstraintChain(r12);
        r11 = r11 + 1;
        goto L4
    L7:
        Log.e(TAG, "Cannot be derived from yourself");
        return;
    L11:
        if (r10 >= this.mConstraintSetMap.size()) goto L13;
        this.mConstraintSetMap.valueAt(r10).readFallback(r5);
        r10 = r10 + 1;
        goto L11
    }

    public void removeTransition(Transition r5) {
        int r10 = getIndex(r5);
        if (r10 == (-1)) goto L6;
        this.mTransitionList.remove(r10);
        return;
    }

    public void setConstraintSet(int r5, ConstraintSet r10) {
        this.mConstraintSetMap.put(r5, r10);
    }

    public void setDuration(int r5) {
        Transition r10 = this.mCurrentTransition;
        if (r10 == null) goto L5;
        r10.setDuration(r5);
        return;
    L5:
        this.mDefaultDuration = r5;
    }

    public void setKeyframe(View r5, int r10, String r11, Object r12) {
        Transition r13 = this.mCurrentTransition;
        if (r13 != null) goto L5;
        return;
    L5:
        Iterator r14 = Transition.access$1300(r13).iterator();
    L7:
        if (r14.hasNext() == false) goto L16;
        Iterator<Key> r15 = ((KeyFrames) r14.next()).getKeyFramesForView(r5.getId()).iterator();
    L10:
        if (r15.hasNext() == false) goto L7;
        if (r15.next().mFramePosition != r10) goto L10;
        if (r12 == null) goto L15;
        Float r16 = (Float) r12;
    L15:
        r11.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    }

    public void setRtl(boolean r5) {
        this.mRtl = r5;
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r10) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    public void setTransition(int r10, int r11) {
        StateSet r5 = this.mStateSet;
        if (r5 == null) goto L12;
        int r12 = r5.stateGetConstraintID(r10, -1, -1);
        if (r12 != (-1)) goto L8;
        r12 = r10;
    L8:
        int r13 = this.mStateSet.stateGetConstraintID(r11, -1, -1);
        if (r13 != (-1)) goto L13;
    L11:
        r13 = r11;
    L13:
        Iterator<Transition> r14 = this.mTransitionList.iterator();
    L15:
        if (r14.hasNext() == false) goto L30;
        Transition r15 = r14.next();
        if (Transition.access$000(r15) != r13) goto L21;
        if (Transition.access$100(r15) != r12) goto L21;
    L24:
        this.mCurrentTransition = r15;
        if (r15 != null) goto L27;
        return;
    L27:
        if (Transition.access$200(r15) == null) goto L54;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L54:
        return;
    L21:
        if (Transition.access$000(r15) != r11) goto L15;
        if (Transition.access$100(r15) != r10) goto L15;
    L30:
        Transition r16 = this.mDefaultTransition;
        Iterator<Transition> r17 = this.mAbstractTransitionList.iterator();
    L32:
        if (r17.hasNext() == false) goto L36;
        Transition r18 = r17.next();
        if (Transition.access$000(r18) != r11) goto L32;
        r16 = r18;
        goto L32
    L36:
        Transition r19 = new Transition(this, r16);
        Transition.access$102(r19, r12);
        Transition.access$002(r19, r13);
        if (r12 == (-1)) goto L39;
        this.mTransitionList.add(r19);
    L39:
        this.mCurrentTransition = r19;
        return;
    L12:
        r12 = r10;
        goto L11
    }

    public void setupTouch() {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r5) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    public boolean supportTouch() {
        Iterator<Transition> r5 = this.mTransitionList.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (Transition.access$200(r5.next()) == null) goto L4;
        return true;
    L8:
        Transition r10 = this.mCurrentTransition;
        if (r10 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r10) == null) goto L13;
        return true;
    }

    public boolean validateLayout(MotionLayout r5) {
        if (r5 == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (r5.mScene != this) goto L7;
        return true;
    }

    public ConstraintSet getConstraintSet(int r5) {
        return getConstraintSet(r5, -1, -1);
    }

    public ConstraintSet getConstraintSet(int r5, int r10, int r11) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        PrintStream r12 = System.out;
        r12.println("id " + r5);
        r12.println("size " + this.mConstraintSetMap.size());
    L5:
        StateSet r13 = this.mStateSet;
        if (r13 == null) goto L11;
        int r14 = r13.stateGetConstraintID(r5, r10, r11);
        if (r14 == (-1)) goto L11;
        r5 = r14;
    L11:
        if (this.mConstraintSetMap.get(r5) != null) goto L15;
        Log.e(TAG, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), r5) + " In MotionScene");
        SparseArray<ConstraintSet> r15 = this.mConstraintSetMap;
        return r15.get(r15.keyAt(0));
    L15:
        return this.mConstraintSetMap.get(r5);
    }

    public MotionScene(Context r5, MotionLayout r10, int r11) {
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
        load(r5, r11);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public void setTransition(Transition r5) {
        this.mCurrentTransition = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r5) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }
}

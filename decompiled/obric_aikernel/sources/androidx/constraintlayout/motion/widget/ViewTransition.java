package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
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
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    private int mClearsTag;
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private boolean mDisabled;
    private int mDuration;
    private int mId;
    private int mIfTagNotSet;
    private int mIfTagSet;
    KeyFrames mKeyFrames;
    private int mOnStateTransition;
    private int mPathMotionArc;
    private int mSetsTag;
    private int mSharedValueCurrent;
    private int mSharedValueID;
    private int mSharedValueTarget;
    private int mTargetId;
    private String mTargetString;
    private int mUpDuration;
    int mViewTransitionMode;
    ConstraintSet set;

    static class Animate {
        boolean hold_at_100;
        KeyCache mCache;
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        Interpolator mInterpolator;
        long mLastRender;
        MotionController mMC;
        float mPosition;
        private final int mSetsTag;
        long mStart;
        Rect mTempRec;
        int mUpDuration;
        ViewTransitionController mVtController;
        boolean reverse;

        Animate(ViewTransitionController r10, MotionController r11, int r12, int r13, int r14, Interpolator r15, int r16, int r17) {
            this.mCache = new KeyCache();
            this.reverse = false;
            this.mTempRec = new Rect();
            this.hold_at_100 = false;
            this.mVtController = r10;
            this.mMC = r11;
            this.mDuration = r12;
            this.mUpDuration = r13;
            long r18 = System.nanoTime();
            this.mStart = r18;
            this.mLastRender = r18;
            this.mVtController.addAnimation(this);
            this.mInterpolator = r15;
            this.mSetsTag = r16;
            this.mClearsTag = r17;
            if (r14 != 3) goto L5;
            this.hold_at_100 = true;
        L5:
            if (r12 != 0) goto L7;
            float r19 = Float.MAX_VALUE;
        L8:
            this.mDpositionDt = r19;
            mutate();
            return;
        L7:
            r19 = 1.0f / r12;
            goto L8
        }

        void mutate() {
            if (this.reverse == false) goto L5;
            mutateReverse();
            return;
        L5:
            mutateForward();
        }

        void mutateForward() {
            long r10 = System.nanoTime();
            long r11 = r10 - this.mLastRender;
            this.mLastRender = r10;
            float r12 = this.mPosition + (((float) (r11 * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = r12;
            if (r12 < 1.0f) goto L5;
            this.mPosition = 1.0f;
        L5:
            Interpolator r13 = this.mInterpolator;
            if (r13 != null) goto L8;
            float r14 = this.mPosition;
        L9:
            float r15 = r14;
            MotionController r16 = this.mMC;
            boolean r17 = r16.interpolate(r16.mView, r15, r10, this.mCache);
            if (this.mPosition < 1.0f) goto L21;
            if (this.mSetsTag == (-1)) goto L15;
            this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        L15:
            if (this.mClearsTag == (-1)) goto L18;
            this.mMC.getView().setTag(this.mClearsTag, null);
        L18:
            if (this.hold_at_100 == true) goto L21;
            this.mVtController.removeAnimation(this);
        L21:
            if (this.mPosition < 1.0f) goto L23;
            if (r17 == true) goto L23;
            return;
        L23:
            this.mVtController.invalidate();
            return;
        L8:
            r14 = r13.getInterpolation(this.mPosition);
            goto L9
        }

        void mutateReverse() {
            long r10 = System.nanoTime();
            long r11 = r10 - this.mLastRender;
            this.mLastRender = r10;
            float r12 = this.mPosition - (((float) (r11 * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = r12;
            if (r12 >= 0.0f) goto L5;
            this.mPosition = 0.0f;
        L5:
            Interpolator r13 = this.mInterpolator;
            if (r13 != null) goto L8;
            float r14 = this.mPosition;
        L9:
            float r15 = r14;
            MotionController r16 = this.mMC;
            boolean r17 = r16.interpolate(r16.mView, r15, r10, this.mCache);
            if (this.mPosition > 0.0f) goto L19;
            if (this.mSetsTag == (-1)) goto L15;
            this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        L15:
            if (this.mClearsTag == (-1)) goto L17;
            this.mMC.getView().setTag(this.mClearsTag, null);
        L17:
            this.mVtController.removeAnimation(this);
        L19:
            if (this.mPosition > 0.0f) goto L21;
            if (r17 == true) goto L21;
            return;
        L21:
            this.mVtController.invalidate();
            return;
        L8:
            r14 = r13.getInterpolation(this.mPosition);
            goto L9
        }

        public void reactTo(int r10, float r11, float r12) {
            if (r10 == 1) goto L14;
            if (r10 != 2) goto L19;
            this.mMC.getView().getHitRect(this.mTempRec);
            if (this.mTempRec.contains((int) r11, (int) r12) == false) goto L10;
            return;
        L10:
            if (this.reverse == true) goto L18;
            reverse(true);
            return;
        L18:
            return;
        L19:
            return;
        L14:
            if (this.reverse == true) goto L20;
            reverse(true);
            return;
        }

        void reverse(boolean r10) {
            this.reverse = r10;
            if (r10 == false) goto L10;
            int r11 = this.mUpDuration;
            if (r11 == (-1)) goto L10;
            if (r11 != 0) goto L8;
            float r12 = Float.MAX_VALUE;
        L9:
            this.mDpositionDt = r12;
            goto L10
        L8:
            r12 = 1.0f / r11;
        L10:
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }
    }

    static {
    }

    ViewTransition(Context r10, XmlPullParser r11) {
        this.mOnStateTransition = -1;
        this.mDisabled = false;
        this.mPathMotionArc = 0;
        this.mDuration = -1;
        this.mUpDuration = -1;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mSetsTag = -1;
        this.mClearsTag = -1;
        this.mIfTagSet = -1;
        this.mIfTagNotSet = -1;
        this.mSharedValueTarget = -1;
        this.mSharedValueID = -1;
        this.mSharedValueCurrent = -1;
        this.mContext = r10;
        int r12 = r11.getEventType();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L5:
        if (r12 == 1) goto L61;
        if (r12 == 2) goto L13;
        if (r12 != 3) goto L42;
        if (VIEW_TRANSITION_TAG.equals(r11.getName()) == false) goto L42;
        return;
    L42:
        r12 = r11.next();     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L5
    L13:
        String r13 = r11.getName();     // Catch: IOException -> L44 XmlPullParserException -> L46
        switch(r13.hashCode()) {
            case -1962203927: goto L29;
            case -1239391468: goto L26;
            case 61998586: goto L23;
            case 366511058: goto L20;
            case 1791837707: goto L17;
            default: goto L31;
        };     // Catch: IOException -> L44 XmlPullParserException -> L46
    L31:
        byte r14 = -1;
    L32:
        if (r14 == 0) goto L41;
        if (r14 == 1) goto L40;
        if (r14 == 2) goto L39;
        if (r14 == 3) goto L38;
        if (r14 == 4) goto L38;
        Log.e(TAG, Debug.getLoc() + " unknown tag " + r13);     // Catch: IOException -> L44 XmlPullParserException -> L46
        Log.e(TAG, ".xml:" + r11.getLineNumber());     // Catch: IOException -> L44 XmlPullParserException -> L46
    L38:
        ConstraintAttribute.parse(r10, r11, this.mConstraintDelta.mCustomConstraints);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L39:
        this.mConstraintDelta = ConstraintSet.buildDelta(r10, r11);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L40:
        this.mKeyFrames = new KeyFrames(r10, r11);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L41:
        parseViewTransitionTags(r10, r11);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L17:
        if (r13.equals(CUSTOM_ATTRIBUTE) == false) goto L31;
        r14 = 3;
        goto L32
    L20:
        if (r13.equals(CUSTOM_METHOD) == false) goto L31;
        r14 = 4;
        goto L32
    L23:
        if (r13.equals(VIEW_TRANSITION_TAG) == false) goto L31;
        r14 = 0;
        goto L32
    L26:
        if (r13.equals(KEY_FRAME_SET_TAG) == false) goto L31;
        r14 = 1;
        goto L32
    L29:
        if (r13.equals(CONSTRAINT_OVERRIDE) == false) goto L31;
        r14 = 2;
        goto L32
    L61:
        return;
    L44:
        e = move-exception;
        e.printStackTrace();
        return;
    L46:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void a(ViewTransition r10, View[] r11) {
        r10.lambda$applyTransition$0(r11);
    }

    private /* synthetic */ void lambda$applyTransition$0(View[] r10) {
        int r11 = 0;
        if (this.mSetsTag == (-1)) goto L8;
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        r10[r13].setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        r13 = r13 + 1;
    L8:
        if (this.mClearsTag == (-1)) goto L12;
        int r14 = r10.length;
    L10:
        if (r11 >= r14) goto L15;
        r10[r11].setTag(this.mClearsTag, null);
        r11 = r11 + 1;
        goto L10
    L15:
        return;
    }

    private void parseViewTransitionTags(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.ViewTransition);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L70;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.ViewTransition_android_id) goto L8;
        this.mId = r12.getResourceId(r15, this.mId);
    L69:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r15 != R.styleable.ViewTransition_motionTarget) goto L19;
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        int r16 = r12.getResourceId(r15, this.mTargetId);
        this.mTargetId = r16;
        if (r16 != (-1)) goto L69;
    L16:
        this.mTargetString = r12.getString(r15);
        goto L69
    L15:
        if (r12.peekValue(r15).type == 3) goto L16;
        this.mTargetId = r12.getResourceId(r15, this.mTargetId);
        goto L69
    L19:
        if (r15 != R.styleable.ViewTransition_onStateTransition) goto L22;
        this.mOnStateTransition = r12.getInt(r15, this.mOnStateTransition);
        goto L69
    L22:
        if (r15 != R.styleable.ViewTransition_transitionDisable) goto L25;
        this.mDisabled = r12.getBoolean(r15, this.mDisabled);
        goto L69
    L25:
        if (r15 != R.styleable.ViewTransition_pathMotionArc) goto L28;
        this.mPathMotionArc = r12.getInt(r15, this.mPathMotionArc);
        goto L69
    L28:
        if (r15 != R.styleable.ViewTransition_duration) goto L31;
        this.mDuration = r12.getInt(r15, this.mDuration);
        goto L69
    L31:
        if (r15 != R.styleable.ViewTransition_upDuration) goto L34;
        this.mUpDuration = r12.getInt(r15, this.mUpDuration);
        goto L69
    L34:
        if (r15 != R.styleable.ViewTransition_viewTransitionMode) goto L37;
        this.mViewTransitionMode = r12.getInt(r15, this.mViewTransitionMode);
        goto L69
    L37:
        if (r15 != R.styleable.ViewTransition_motionInterpolator) goto L52;
        int r17 = r12.peekValue(r15).type;
        if (r17 != 1) goto L43;
        int r18 = r12.getResourceId(r15, -1);
        this.mDefaultInterpolatorID = r18;
        if (r18 == (-1)) goto L69;
    L42:
        this.mDefaultInterpolator = -2;
        goto L69
    L43:
        if (r17 != 3) goto L50;
        String r19 = r12.getString(r15);
        this.mDefaultInterpolatorString = r19;
        if (r19 != null) goto L47;
    L49:
        this.mDefaultInterpolator = -1;
        goto L69
    L47:
        if (r19.indexOf("/") <= 0) goto L49;
        this.mDefaultInterpolatorID = r12.getResourceId(r15, -1);
        goto L42
    L50:
        this.mDefaultInterpolator = r12.getInteger(r15, this.mDefaultInterpolator);
        goto L69
    L52:
        if (r15 != R.styleable.ViewTransition_setsTag) goto L55;
        this.mSetsTag = r12.getResourceId(r15, this.mSetsTag);
        goto L69
    L55:
        if (r15 != R.styleable.ViewTransition_clearsTag) goto L58;
        this.mClearsTag = r12.getResourceId(r15, this.mClearsTag);
        goto L69
    L58:
        if (r15 != R.styleable.ViewTransition_ifTagSet) goto L61;
        this.mIfTagSet = r12.getResourceId(r15, this.mIfTagSet);
        goto L69
    L61:
        if (r15 != R.styleable.ViewTransition_ifTagNotSet) goto L64;
        this.mIfTagNotSet = r12.getResourceId(r15, this.mIfTagNotSet);
        goto L69
    L64:
        if (r15 != R.styleable.ViewTransition_SharedValueId) goto L67;
        this.mSharedValueID = r12.getResourceId(r15, this.mSharedValueID);
        goto L69
    L67:
        if (r15 != R.styleable.ViewTransition_SharedValue) goto L69;
        this.mSharedValueTarget = r12.getInteger(r15, this.mSharedValueTarget);
        goto L69
    L70:
        r12.recycle();
    }

    private void updateTransition(MotionScene.Transition r10, View r11) {
        int r12 = this.mDuration;
        if (r12 == (-1)) goto L5;
        r10.setDuration(r12);
    L5:
        r10.setPathMotionArc(this.mPathMotionArc);
        r10.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int r13 = r11.getId();
        KeyFrames r14 = this.mKeyFrames;
        if (r14 == null) goto L14;
        ArrayList<Key> r15 = r14.getKeyFramesForView(-1);
        KeyFrames r16 = new KeyFrames();
        Iterator<Key> r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.addKey(r17.next().clone().setViewId(r13));
        goto L9
    L11:
        r10.addKeyFrame(r16);
        return;
    }

    void applyIndependentTransition(ViewTransitionController r10, MotionLayout r11, View r12) {
        MotionController r13 = new MotionController(r12);
        r13.setBothStates(r12);
        this.mKeyFrames.addAllFrames(r13);
        r13.setup(r11.getWidth(), r11.getHeight(), this.mDuration, System.nanoTime());
        new Animate(r10, r13, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(r11.getContext()), this.mSetsTag, this.mClearsTag);
    }

    void applyTransition(ViewTransitionController r10, MotionLayout r11, int r12, ConstraintSet r13, final View... r14) {
        if (this.mDisabled == false) goto L5;
        return;
    L5:
        int r15 = this.mViewTransitionMode;
        int r16 = 0;
        if (r15 != 2) goto L10;
        applyIndependentTransition(r10, r11, r14[0]);
        return;
    L10:
        if (r15 != 1) goto L24;
        int[] r17 = r11.getConstraintSetIds();
        int r18 = 0;
    L13:
        if (r18 >= r17.length) goto L24;
        int r19 = r17[r18];
        if (r19 == r12) goto L23;
        ConstraintSet r20 = r11.getConstraintSet(r19);
        int r21 = r14.length;
        int r22 = 0;
    L18:
        if (r22 >= r21) goto L23;
        ConstraintSet.Constraint r23 = r20.getConstraint(r14[r22].getId());
        ConstraintSet.Constraint r24 = this.mConstraintDelta;
        if (r24 == null) goto L22;
        r24.applyDelta(r23);
        r23.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
    L22:
        r22 = r22 + 1;
    L23:
        r18 = r18 + 1;
    L24:
        ConstraintSet r25 = new ConstraintSet();
        r25.clone(r13);
        int r26 = r14.length;
        int r27 = 0;
    L25:
        if (r27 >= r26) goto L30;
        ConstraintSet.Constraint r28 = r25.getConstraint(r14[r27].getId());
        ConstraintSet.Constraint r29 = this.mConstraintDelta;
        if (r29 == null) goto L29;
        r29.applyDelta(r28);
        r28.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
    L29:
        r27 = r27 + 1;
        goto L25
    L30:
        r11.updateState(r12, r25);
        int r30 = R.id.view_transition;
        r11.updateState(r30, r13);
        r11.setState(r30, -1, -1);
        MotionScene.Transition r31 = new MotionScene.Transition(-1, r11.mScene, r30, r12);
        int r32 = r14.length;
    L31:
        if (r16 >= r32) goto L33;
        updateTransition(r31, r14[r16]);
        r16 = r16 + 1;
        goto L31
    L33:
        r11.setTransition(r31);
        r11.transitionToEnd(new a(this, r14));
    }

    boolean checkTags(View r10) {
        int r11 = this.mIfTagSet;
        if (r11 != (-1)) goto L6;
    L4:
        boolean r12 = true;
    L9:
        int r13 = this.mIfTagNotSet;
        if (r13 != (-1)) goto L13;
    L11:
        boolean r14 = true;
    L16:
        if (r12 == false) goto L20;
        if (r14 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L13:
        if (r10.getTag(r13) == null) goto L11;
        r14 = false;
        goto L16
    L6:
        if (r10.getTag(r11) != null) goto L4;
        r12 = false;
        goto L9
    }

    int getId() {
        return this.mId;
    }

    Interpolator getInterpolator(Context r10) {
        int r11 = this.mDefaultInterpolator;
        if (r11 == (-2)) goto L34;
        if (r11 == (-1)) goto L31;
        if (r11 == 0) goto L30;
        if (r11 == 1) goto L28;
        if (r11 == 2) goto L26;
        if (r11 == 4) goto L24;
        if (r11 == 5) goto L22;
        if (r11 == 6) goto L20;
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
        final Easing r12 = Easing.getInterpolator(this.mDefaultInterpolatorString);
        return new AnonymousClass1(this, r12);
    L34:
        return AnimationUtils.loadInterpolator(r10, this.mDefaultInterpolatorID);
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    boolean isEnabled() {
        return !this.mDisabled;
    }

    boolean matchesView(View r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.mTargetId != (-1)) goto L11;
        if (this.mTargetString != null) goto L11;
        return false;
    L11:
        if (checkTags(r10) == true) goto L14;
        return false;
    L14:
        if (r10.getId() != this.mTargetId) goto L17;
        return true;
    L17:
        if (this.mTargetString != null) goto L20;
        return false;
    L20:
        if ((r10.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        String r11 = ((ConstraintLayout.LayoutParams) r10.getLayoutParams()).constraintTag;
        if (r11 == null) goto L26;
        if (r11.matches(this.mTargetString) == false) goto L26;
        return true;
    L26:
        return false;
    }

    void setEnabled(boolean r10) {
        this.mDisabled = !r10;
    }

    void setId(int r10) {
        this.mId = r10;
    }

    public void setSharedValue(int r10) {
        this.mSharedValueTarget = r10;
    }

    public void setSharedValueCurrent(int r10) {
        this.mSharedValueCurrent = r10;
    }

    public void setSharedValueID(int r10) {
        this.mSharedValueID = r10;
    }

    public void setStateTransition(int r10) {
        this.mOnStateTransition = r10;
    }

    boolean supports(int r10) {
        int r11 = this.mOnStateTransition;
        if (r11 != 1) goto L8;
        if (r10 == 0) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r11 != 2) goto L13;
        if (r10 == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r11 != 3) goto L19;
        if (r10 == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        return false;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }
}

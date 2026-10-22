package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    RectF mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    HashMap<String, Method> mMethodHashMap;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    int mViewTransitionOnCross;
    int mViewTransitionOnNegativeCross;
    int mViewTransitionOnPositiveCross;

    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static final int VT_CROSS = 12;
        private static final int VT_NEGATIVE_CROSS = 13;
        private static final int VT_POSITIVE_CROSS = 14;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r10 = new SparseIntArray();
            mAttrMap = r10;
            r10.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        private Loader() {
        }

        public static void read(KeyTrigger r10, TypedArray r11, Context r12) {
            int r13 = r11.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L29;
            int r15 = r11.getIndex(r14);
            switch(mAttrMap.get(r15)) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L6;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L6:
            Log.e(TypedValues.TriggerType.NAME, "unused attribute 0x" + Integer.toHexString(r15) + "   " + mAttrMap.get(r15));
        L28:
            r14 = r14 + 1;
            goto L3
        L7:
            r10.mViewTransitionOnPositiveCross = r11.getResourceId(r15, r10.mViewTransitionOnPositiveCross);
            goto L28
        L8:
            r10.mViewTransitionOnNegativeCross = r11.getResourceId(r15, r10.mViewTransitionOnNegativeCross);
            goto L28
        L9:
            r10.mViewTransitionOnCross = r11.getResourceId(r15, r10.mViewTransitionOnCross);
            goto L28
        L10:
            KeyTrigger.access$702(r10, r11.getResourceId(r15, KeyTrigger.access$700(r10)));
            goto L28
        L11:
            KeyTrigger.access$602(r10, r11.getBoolean(r15, KeyTrigger.access$600(r10)));
            goto L28
        L12:
            KeyTrigger.access$502(r10, r11.getResourceId(r15, KeyTrigger.access$500(r10)));
            goto L28
        L13:
            int r16 = r11.getInteger(r15, r10.mFramePosition);
            r10.mFramePosition = r16;
            KeyTrigger.access$002(r10, (r16 + 0.5f) / 100.0f);
            goto L28
        L23:
            KeyTrigger.access$402(r10, r11.getResourceId(r15, KeyTrigger.access$400(r10)));
            goto L28
        L24:
            r10.mTriggerSlack = r11.getFloat(r15, r10.mTriggerSlack);
            goto L28
        L25:
            KeyTrigger.access$302(r10, r11.getString(r15));
            goto L28
        L26:
            KeyTrigger.access$202(r10, r11.getString(r15));
            goto L28
        L27:
            KeyTrigger.access$102(r10, r11.getString(r15));
            goto L28
        L15:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L20;
            int r17 = r11.getResourceId(r15, r10.mTargetId);
            r10.mTargetId = r17;
            if (r17 != (-1)) goto L28;
        L21:
            r10.mTargetString = r11.getString(r15);
            goto L28
        L20:
            if (r11.peekValue(r15).type == 3) goto L21;
            r10.mTargetId = r11.getResourceId(r15, r10.mTargetId);
            goto L28
        }
    }

    public KeyTrigger() {
        this.mCurveFit = -1;
        this.mCross = null;
        int r10 = Key.UNSET;
        this.mTriggerReceiver = r10;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = r10;
        this.mTriggerCollisionId = r10;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = r10;
        this.mViewTransitionOnPositiveCross = r10;
        this.mViewTransitionOnCross = r10;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mMethodHashMap = new HashMap();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$002(KeyTrigger r10, float r11) {
        r10.mFireThreshold = r11;
        return r11;
    }

    static /* synthetic */ String access$102(KeyTrigger r10, String r11) {
        r10.mNegativeCross = r11;
        return r11;
    }

    static /* synthetic */ String access$202(KeyTrigger r10, String r11) {
        r10.mPositiveCross = r11;
        return r11;
    }

    static /* synthetic */ String access$302(KeyTrigger r10, String r11) {
        r10.mCross = r11;
        return r11;
    }

    static /* synthetic */ int access$400(KeyTrigger r10) {
        return r10.mTriggerID;
    }

    static /* synthetic */ int access$402(KeyTrigger r10, int r11) {
        r10.mTriggerID = r11;
        return r11;
    }

    static /* synthetic */ int access$500(KeyTrigger r10) {
        return r10.mTriggerCollisionId;
    }

    static /* synthetic */ int access$502(KeyTrigger r10, int r11) {
        r10.mTriggerCollisionId = r11;
        return r11;
    }

    static /* synthetic */ boolean access$600(KeyTrigger r10) {
        return r10.mPostLayout;
    }

    static /* synthetic */ boolean access$602(KeyTrigger r10, boolean r11) {
        r10.mPostLayout = r11;
        return r11;
    }

    static /* synthetic */ int access$700(KeyTrigger r10) {
        return r10.mTriggerReceiver;
    }

    static /* synthetic */ int access$702(KeyTrigger r10, int r11) {
        r10.mTriggerReceiver = r11;
        return r11;
    }

    private void fire(String r10, View r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.startsWith(".") == false) goto L9;
        fireCustom(r10, r11);
        return;
    L9:
        if (this.mMethodHashMap.containsKey(r10) == false) goto L13;
        Method r12 = this.mMethodHashMap.get(r10);
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12 != null) goto L26;
        r12 = r11.getClass().getMethod(r10, new Class[0]);     // Catch: NoSuchMethodException -> L18
        this.mMethodHashMap.put(r10, r12);     // Catch: NoSuchMethodException -> L18
    L18:
        this.mMethodHashMap.put(r10, null);
        Log.e(TypedValues.TriggerType.NAME, "Could not find method \"" + r10 + "\"on class " + r11.getClass().getSimpleName() + " " + Debug.getName(r11));
        return;
    L26:
        r12.invoke(r11, new Object[0]);     // Catch: Exception -> L22
        return;
    L22:
        Log.e(TypedValues.TriggerType.NAME, "Exception in call \"" + this.mCross + "\"on class " + r11.getClass().getSimpleName() + " " + Debug.getName(r11));
        return;
    L13:
        r12 = null;
        goto L15
    }

    private void fireCustom(String r10, View r11) {
        if (r10.length() != 1) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        r10 = r10.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator<String> r13 = this.mCustomConstraints.keySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L18;
        String r14 = r13.next();
        String r15 = r14.toLowerCase(Locale.ROOT);
        if (r12 == true) goto L15;
        if (r15.matches(r10) == false) goto L10;
    L15:
        ConstraintAttribute r16 = this.mCustomConstraints.get(r14);
        if (r16 == null) goto L10;
        r16.applyCustom(r11);
        goto L10
    L18:
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void setUpRect(RectF r10, View r11, boolean r12) {
        r10.top = r11.getTop();
        r10.bottom = r11.getBottom();
        r10.left = r11.getLeft();
        r10.right = r11.getRight();
        if (r12 == false) goto L6;
        r11.getMatrix().mapRect(r10);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyTrigger().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo4clone() {
        return clone();
    }

    public void conditionallyFire(float r10, View r11) {
        if (this.mTriggerCollisionId == Key.UNSET) goto L28;
        if (this.mTriggerCollisionView != null) goto L7;
        this.mTriggerCollisionView = ((ViewGroup) r11.getParent()).findViewById(this.mTriggerCollisionId);
    L7:
        setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
        setUpRect(this.mTargetRect, r11, this.mPostLayout);
        if (this.mCollisionRect.intersect(this.mTargetRect) == false) goto L19;
        if (this.mFireCrossReset == false) goto L12;
        this.mFireCrossReset = false;
        boolean r12 = true;
    L14:
        if (this.mFirePositiveReset == false) goto L16;
        this.mFirePositiveReset = false;
        boolean r13 = true;
    L17:
        this.mFireNegativeReset = true;
        boolean r14 = r13;
        boolean r15 = false;
    L61:
        this.mFireLastPos = r10;
        if (r15 == true) goto L65;
        if (r12 == true) goto L65;
        if (r14 == true) goto L65;
    L67:
        if (this.mTriggerReceiver != Key.UNSET) goto L69;
        View r16 = r11;
    L70:
        if (r15 == false) goto L77;
        String r17 = this.mNegativeCross;
        if (r17 == null) goto L75;
        fire(r17, r16);
    L75:
        if (this.mViewTransitionOnNegativeCross == Key.UNSET) goto L77;
        ((MotionLayout) r11.getParent()).viewTransition(this.mViewTransitionOnNegativeCross, new View[]{r16});
    L77:
        if (r14 == false) goto L84;
        String r18 = this.mPositiveCross;
        if (r18 == null) goto L82;
        fire(r18, r16);
    L82:
        if (this.mViewTransitionOnPositiveCross == Key.UNSET) goto L84;
        ((MotionLayout) r11.getParent()).viewTransition(this.mViewTransitionOnPositiveCross, new View[]{r16});
    L84:
        if (r12 == false) goto L92;
        String r19 = this.mCross;
        if (r19 == null) goto L89;
        fire(r19, r16);
    L89:
        if (this.mViewTransitionOnCross == Key.UNSET) goto L93;
        ((MotionLayout) r11.getParent()).viewTransition(this.mViewTransitionOnCross, new View[]{r16});
        return;
    L93:
        return;
    L92:
        return;
    L69:
        r16 = ((MotionLayout) r11.getParent()).findViewById(this.mTriggerReceiver);
    L65:
        ((MotionLayout) r11.getParent()).fireTrigger(this.mTriggerID, r14, r10);
        goto L67
    L16:
        r13 = false;
        goto L17
    L12:
        r12 = false;
        goto L14
    L19:
        if (this.mFireCrossReset == true) goto L21;
        this.mFireCrossReset = true;
        r12 = true;
    L23:
        if (this.mFireNegativeReset == false) goto L25;
        this.mFireNegativeReset = false;
        r15 = true;
    L26:
        this.mFirePositiveReset = true;
    L60:
        r14 = false;
        goto L61
    L25:
        r15 = false;
        goto L26
    L21:
        r12 = false;
        goto L23
    L28:
        if (this.mFireCrossReset == false) goto L33;
        float r20 = this.mFireThreshold;
        if (((r10 - r20) * (this.mFireLastPos - r20)) >= 0.0f) goto L35;
        this.mFireCrossReset = false;
        r12 = true;
    L37:
        if (this.mFireNegativeReset == false) goto L44;
        float r21 = this.mFireThreshold;
        float r22 = r10 - r21;
        if (((this.mFireLastPos - r21) * r22) < 0.0f) goto L41;
    L46:
        boolean r23 = false;
    L48:
        if (this.mFirePositiveReset == false) goto L57;
        float r24 = this.mFireThreshold;
        float r25 = r10 - r24;
        if (((this.mFireLastPos - r24) * r25) < 0.0f) goto L52;
    L54:
        boolean r26 = false;
    L55:
        boolean r27 = r23;
        r14 = r26;
        r15 = r27;
        goto L61
    L52:
        if (r25 <= 0.0f) goto L54;
        this.mFirePositiveReset = false;
        r26 = true;
        goto L55
    L57:
        if (Math.abs(r10 - this.mFireThreshold) <= this.mTriggerSlack) goto L59;
        this.mFirePositiveReset = true;
    L59:
        r15 = r23;
        goto L60
    L41:
        if (r22 >= 0.0f) goto L46;
        this.mFireNegativeReset = false;
        r23 = true;
        goto L48
    L44:
        if (Math.abs(r10 - this.mFireThreshold) <= this.mTriggerSlack) goto L46;
        this.mFireNegativeReset = true;
    L35:
        r12 = false;
        goto L37
    L33:
        if (Math.abs(r10 - this.mFireThreshold) <= this.mTriggerSlack) goto L35;
        this.mFireCrossReset = true;
        goto L35
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r10) {
        super.copy(r10);
        KeyTrigger r11 = (KeyTrigger) r10;
        this.mCurveFit = r11.mCurveFit;
        this.mCross = r11.mCross;
        this.mTriggerReceiver = r11.mTriggerReceiver;
        this.mNegativeCross = r11.mNegativeCross;
        this.mPositiveCross = r11.mPositiveCross;
        this.mTriggerID = r11.mTriggerID;
        this.mTriggerCollisionId = r11.mTriggerCollisionId;
        this.mTriggerCollisionView = r11.mTriggerCollisionView;
        this.mTriggerSlack = r11.mTriggerSlack;
        this.mFireCrossReset = r11.mFireCrossReset;
        this.mFireNegativeReset = r11.mFireNegativeReset;
        this.mFirePositiveReset = r11.mFirePositiveReset;
        this.mFireThreshold = r11.mFireThreshold;
        this.mFireLastPos = r11.mFireLastPos;
        this.mPostLayout = r11.mPostLayout;
        this.mCollisionRect = r11.mCollisionRect;
        this.mTargetRect = r11.mTargetRect;
        this.mMethodHashMap = r11.mMethodHashMap;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r10) {
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r10, AttributeSet r11) {
        Loader.read(this, r10.obtainStyledAttributes(r11, R.styleable.KeyTrigger), r10);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1594793529: goto L50;
            case -966421266: goto L46;
            case -786670827: goto L42;
            case -648752941: goto L38;
            case -638126837: goto L34;
            case -76025313: goto L30;
            case -9754574: goto L26;
            case 64397344: goto L22;
            case 364489912: goto L18;
            case 1301930599: goto L14;
            case 1401391082: goto L10;
            case 1535404999: goto L6;
            default: goto L53;
        };
    L53:
        switch(r12) {
            case 0: goto L66;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L56;
            case 11: goto L55;
            default: goto L79;
        };
    L55:
        this.mTriggerReceiver = toInt(r11);
        return;
    L56:
        this.mPostLayout = toBoolean(r11);
        return;
    L57:
        this.mViewTransitionOnCross = toInt(r11);
        return;
    L58:
        this.mTriggerSlack = toFloat(r11);
        return;
    L59:
        this.mCross = r11.toString();
        return;
    L60:
        this.mViewTransitionOnNegativeCross = toInt(r11);
        return;
    L61:
        this.mTriggerCollisionView = (View) r11;
        return;
    L62:
        this.mNegativeCross = r11.toString();
        return;
    L63:
        this.mTriggerID = toInt(r11);
        return;
    L64:
        this.mTriggerCollisionId = toInt(r11);
        return;
    L65:
        this.mViewTransitionOnPositiveCross = toInt(r11);
        return;
    L66:
        this.mPositiveCross = r11.toString();
        return;
    L79:
        return;
    L6:
        if (r10.equals("triggerReceiver") == false) goto L53;
        r12 = 11;
        goto L53
    L10:
        if (r10.equals("postLayout") == false) goto L53;
        r12 = 10;
        goto L53
    L14:
        if (r10.equals("viewTransitionOnCross") == false) goto L53;
        r12 = 9;
        goto L53
    L18:
        if (r10.equals("triggerSlack") == false) goto L53;
        r12 = 8;
        goto L53
    L22:
        if (r10.equals("CROSS") == false) goto L53;
        r12 = 7;
        goto L53
    L26:
        if (r10.equals("viewTransitionOnNegativeCross") == false) goto L53;
        r12 = 6;
        goto L53
    L30:
        if (r10.equals("triggerCollisionView") == false) goto L53;
        r12 = 5;
        goto L53
    L34:
        if (r10.equals("negativeCross") == false) goto L53;
        r12 = 4;
        goto L53
    L38:
        if (r10.equals("triggerID") == false) goto L53;
        r12 = 3;
        goto L53
    L42:
        if (r10.equals("triggerCollisionId") == false) goto L53;
        r12 = 2;
        goto L53
    L46:
        if (r10.equals("viewTransitionOnPositiveCross") == false) goto L53;
        r12 = 1;
        goto L53
    L50:
        if (r10.equals("positiveCross") == false) goto L53;
        r12 = 0;
        goto L53
    }
}

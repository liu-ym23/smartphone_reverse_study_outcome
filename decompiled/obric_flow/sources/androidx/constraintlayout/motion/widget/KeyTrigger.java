package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;

    public static class Loader {
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
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mAttrMap = r5;
            r5.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        private Loader() {
        }

        public static void read(KeyTrigger r5, TypedArray r10, Context r11) {
            int r12 = r10.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L27;
            int r14 = r10.getIndex(r13);
            switch(mAttrMap.get(r14)) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L8;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L13;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L8;
            };
        L7:
            KeyTrigger.access$702(r5, r10.getResourceId(r14, KeyTrigger.access$700(r5)));
            goto L8
        L9:
            KeyTrigger.access$602(r5, r10.getBoolean(r14, KeyTrigger.access$600(r5)));
        L26:
            r13 = r13 + 1;
            goto L3
        L10:
            KeyTrigger.access$502(r5, r10.getResourceId(r14, KeyTrigger.access$500(r5)));
            goto L26
        L11:
            int r15 = r10.getInteger(r14, r5.mFramePosition);
            r5.mFramePosition = r15;
            KeyTrigger.access$002(r5, (r15 + 0.5f) / 100.0f);
            goto L26
        L21:
            KeyTrigger.access$402(r5, r10.getResourceId(r14, KeyTrigger.access$400(r5)));
            goto L26
        L22:
            r5.mTriggerSlack = r10.getFloat(r14, r5.mTriggerSlack);
            goto L26
        L23:
            KeyTrigger.access$302(r5, r10.getString(r14));
            goto L26
        L24:
            KeyTrigger.access$202(r5, r10.getString(r14));
            goto L26
        L25:
            KeyTrigger.access$102(r5, r10.getString(r14));
        L8:
            Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(r14) + "   " + mAttrMap.get(r14));
            goto L26
        L13:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L18;
            int r16 = r10.getResourceId(r14, r5.mTargetId);
            r5.mTargetId = r16;
            if (r16 != (-1)) goto L26;
            r5.mTargetString = r10.getString(r14);
            goto L26
        L18:
            if (r10.peekValue(r14).type != 3) goto L20;
            r5.mTargetString = r10.getString(r14);
            goto L26
        L20:
            r5.mTargetId = r10.getResourceId(r14, r5.mTargetId);
            goto L26
        }
    }

    public KeyTrigger() {
        this.mCurveFit = -1;
        this.mCross = null;
        int r5 = Key.UNSET;
        this.mTriggerReceiver = r5;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = r5;
        this.mTriggerCollisionId = r5;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$002(KeyTrigger r5, float r10) {
        r5.mFireThreshold = r10;
        return r10;
    }

    public static /* synthetic */ String access$102(KeyTrigger r5, String r10) {
        r5.mNegativeCross = r10;
        return r10;
    }

    public static /* synthetic */ String access$202(KeyTrigger r5, String r10) {
        r5.mPositiveCross = r10;
        return r10;
    }

    public static /* synthetic */ String access$302(KeyTrigger r5, String r10) {
        r5.mCross = r10;
        return r10;
    }

    public static /* synthetic */ int access$400(KeyTrigger r5) {
        return r5.mTriggerID;
    }

    public static /* synthetic */ int access$402(KeyTrigger r5, int r10) {
        r5.mTriggerID = r10;
        return r10;
    }

    public static /* synthetic */ int access$500(KeyTrigger r5) {
        return r5.mTriggerCollisionId;
    }

    public static /* synthetic */ int access$502(KeyTrigger r5, int r10) {
        r5.mTriggerCollisionId = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$600(KeyTrigger r5) {
        return r5.mPostLayout;
    }

    public static /* synthetic */ boolean access$602(KeyTrigger r5, boolean r10) {
        r5.mPostLayout = r10;
        return r10;
    }

    public static /* synthetic */ int access$700(KeyTrigger r5) {
        return r5.mTriggerReceiver;
    }

    public static /* synthetic */ int access$702(KeyTrigger r5, int r10) {
        r5.mTriggerReceiver = r10;
        return r10;
    }

    private void setUpRect(RectF r5, View r10, boolean r11) {
        r5.top = r10.getTop();
        r5.bottom = r10.getBottom();
        r5.left = r10.getLeft();
        r5.right = r10.getRight();
        if (r11 == false) goto L6;
        r10.getMatrix().mapRect(r5);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r5) {
    }

    public void conditionallyFire(float r11, View r12) {
        boolean r5 = true;
        boolean r10 = false;
        if (this.mTriggerCollisionId == Key.UNSET) goto L28;
        if (this.mTriggerCollisionView != null) goto L7;
        this.mTriggerCollisionView = ((ViewGroup) r12.getParent()).findViewById(this.mTriggerCollisionId);
    L7:
        setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
        setUpRect(this.mTargetRect, r12, this.mPostLayout);
        if (this.mCollisionRect.intersect(this.mTargetRect) == false) goto L19;
        if (this.mFireCrossReset == false) goto L12;
        this.mFireCrossReset = false;
        boolean r13 = true;
    L14:
        if (this.mFirePositiveReset == false) goto L16;
        this.mFirePositiveReset = false;
        boolean r14 = true;
    L17:
        this.mFireNegativeReset = true;
    L61:
        this.mFireLastPos = r11;
        if (r10 == true) goto L65;
        if (r13 == true) goto L65;
        if (r14 == true) goto L65;
    L67:
        if (this.mTriggerReceiver == Key.UNSET) goto L71;
        r12 = ((MotionLayout) r12.getParent()).findViewById(this.mTriggerReceiver);
    L71:
        if (r10 == true) goto L73;
    L82:
        if (r14 == true) goto L84;
    L93:
        if (r13 == true) goto L95;
        return;
    L95:
        if (this.mCross != null) goto L97;
        return;
    L97:
        if (this.mFireCross == null) goto L111;
    L109:
        this.mFireCross.invoke(r12, null);     // Catch: Exception -> L103
        return;
    L103:
        Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
        return;
    L111:
        this.mFireCross = r12.getClass().getMethod(this.mCross, null);     // Catch: NoSuchMethodException -> L100
    L100:
        Log.e("KeyTrigger", "Could not find method \"" + this.mCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
        goto L109
    L84:
        if (this.mPositiveCross == null) goto L93;
        if (this.mFirePositiveCross == null) goto L115;
    L107:
        this.mFirePositiveCross.invoke(r12, null);     // Catch: Exception -> L92
    L92:
        Log.e("KeyTrigger", "Exception in call \"" + this.mPositiveCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
        goto L93
    L115:
        this.mFirePositiveCross = r12.getClass().getMethod(this.mPositiveCross, null);     // Catch: NoSuchMethodException -> L89
    L89:
        Log.e("KeyTrigger", "Could not find method \"" + this.mPositiveCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
        goto L107
    L73:
        if (this.mNegativeCross == null) goto L82;
        if (this.mFireNegativeCross == null) goto L113;
    L105:
        this.mFireNegativeCross.invoke(r12, null);     // Catch: Exception -> L81
    L81:
        Log.e("KeyTrigger", "Exception in call \"" + this.mNegativeCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
        goto L82
    L113:
        this.mFireNegativeCross = r12.getClass().getMethod(this.mNegativeCross, null);     // Catch: NoSuchMethodException -> L78
    L78:
        Log.e("KeyTrigger", "Could not find method \"" + this.mNegativeCross + "\"on class " + r12.getClass().getSimpleName() + " " + Debug.getName(r12));
    L65:
        ((MotionLayout) r12.getParent()).fireTrigger(this.mTriggerID, r14, r11);
        goto L67
    L16:
        r14 = false;
        goto L17
    L12:
        r13 = false;
        goto L14
    L19:
        if (this.mFireCrossReset == true) goto L21;
        this.mFireCrossReset = true;
        r13 = true;
    L23:
        if (this.mFireNegativeReset == false) goto L25;
        this.mFireNegativeReset = false;
        boolean r15 = true;
    L26:
        this.mFirePositiveReset = true;
        r10 = r15;
        r14 = false;
        goto L61
    L25:
        r15 = false;
        goto L26
    L21:
        r13 = false;
        goto L23
    L28:
        if (this.mFireCrossReset == false) goto L33;
        float r16 = this.mFireThreshold;
        if (((this.mFireLastPos - r16) * (r11 - r16)) >= 0.0f) goto L35;
        this.mFireCrossReset = false;
        r13 = true;
    L37:
        if (this.mFireNegativeReset == false) goto L44;
        float r17 = this.mFireThreshold;
        float r18 = r11 - r17;
        if (((this.mFireLastPos - r17) * r18) < 0.0f) goto L41;
    L46:
        boolean r19 = false;
    L48:
        if (this.mFirePositiveReset == false) goto L58;
        float r20 = this.mFireThreshold;
        float r21 = r11 - r20;
        if (((this.mFireLastPos - r20) * r21) < 0.0f) goto L52;
    L54:
        r5 = false;
    L55:
        r14 = r5;
    L56:
        r10 = r19;
        goto L61
    L52:
        if (r21 <= 0.0f) goto L54;
        this.mFirePositiveReset = false;
        goto L55
    L58:
        if (Math.abs(r11 - this.mFireThreshold) <= this.mTriggerSlack) goto L60;
        this.mFirePositiveReset = true;
    L60:
        r14 = false;
        goto L56
    L41:
        if (r18 >= 0.0f) goto L46;
        this.mFireNegativeReset = false;
        r19 = true;
        goto L48
    L44:
        if (Math.abs(r11 - this.mFireThreshold) <= this.mTriggerSlack) goto L46;
        this.mFireNegativeReset = true;
    L35:
        r13 = false;
        goto L37
    L33:
        if (Math.abs(r11 - this.mFireThreshold) <= this.mTriggerSlack) goto L35;
        this.mFireCrossReset = true;
        goto L35
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r5) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r5, AttributeSet r10) {
        Loader.read(this, r5.obtainStyledAttributes(r10, R.styleable.KeyTrigger), r5);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r5, Object r10) {
    }
}

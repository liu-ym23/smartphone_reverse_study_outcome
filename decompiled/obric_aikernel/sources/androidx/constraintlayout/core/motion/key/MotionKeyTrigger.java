package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyTrigger extends MotionKey {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final int TYPE_CROSS = 312;
    public static final int TYPE_NEGATIVE_CROSS = 310;
    public static final int TYPE_POSITIVE_CROSS = 309;
    public static final int TYPE_POST_LAYOUT = 304;
    public static final int TYPE_TRIGGER_COLLISION_ID = 307;
    public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
    public static final int TYPE_TRIGGER_ID = 308;
    public static final int TYPE_TRIGGER_RECEIVER = 311;
    public static final int TYPE_TRIGGER_SLACK = 305;
    public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
    public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
    public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    FloatRect mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    FloatRect mTargetRect;
    private int mTriggerCollisionId;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    int mViewTransitionOnCross;
    int mViewTransitionOnNegativeCross;
    int mViewTransitionOnPositiveCross;

    public MotionKeyTrigger() {
        this.mCurveFit = -1;
        this.mCross = null;
        int r10 = MotionKey.UNSET;
        this.mTriggerReceiver = r10;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = r10;
        this.mTriggerCollisionId = r10;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = r10;
        this.mViewTransitionOnPositiveCross = r10;
        this.mViewTransitionOnCross = r10;
        this.mCollisionRect = new FloatRect();
        this.mTargetRect = new FloatRect();
        this.mType = 5;
        this.mCustom = new HashMap();
    }

    private void fireCustom(String r10, MotionWidget r11) {
        if (r10.length() != 1) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        r10 = r10.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator<String> r13 = this.mCustom.keySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L18;
        String r14 = r13.next();
        String r15 = r14.toLowerCase(Locale.ROOT);
        if (r12 == true) goto L15;
        if (r15.matches(r10) == false) goto L10;
    L15:
        CustomVariable r16 = this.mCustom.get(r14);
        if (r16 == null) goto L10;
        r16.applyToWidget(r11);
        goto L10
    L18:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTrigger().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    public void conditionallyFire(float r10, MotionWidget r11) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r10) {
        return copy(r10);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTrigger copy(MotionKey r10) {
        super.copy(r10);
        MotionKeyTrigger r11 = (MotionKeyTrigger) r10;
        this.mCurveFit = r11.mCurveFit;
        this.mCross = r11.mCross;
        this.mTriggerReceiver = r11.mTriggerReceiver;
        this.mNegativeCross = r11.mNegativeCross;
        this.mPositiveCross = r11.mPositiveCross;
        this.mTriggerID = r11.mTriggerID;
        this.mTriggerCollisionId = r11.mTriggerCollisionId;
        this.mTriggerSlack = r11.mTriggerSlack;
        this.mFireCrossReset = r11.mFireCrossReset;
        this.mFireNegativeReset = r11.mFireNegativeReset;
        this.mFirePositiveReset = r11.mFirePositiveReset;
        this.mFireThreshold = r11.mFireThreshold;
        this.mFireLastPos = r11.mFireLastPos;
        this.mPostLayout = r11.mPostLayout;
        this.mCollisionRect = r11.mCollisionRect;
        this.mTargetRect = r11.mTargetRect;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        r10.hashCode();
        switch(r10.hashCode()) {
            case -1594793529: goto L46;
            case -966421266: goto L42;
            case -786670827: goto L38;
            case -648752941: goto L34;
            case -638126837: goto L30;
            case -76025313: goto L26;
            case -9754574: goto L22;
            case 364489912: goto L18;
            case 1301930599: goto L14;
            case 1401391082: goto L10;
            case 1535404999: goto L6;
            default: goto L4;
        };
    L4:
        byte r11 = -1;
    L49:
        switch(r11) {
            case 0: goto L71;
            case 1: goto L69;
            case 2: goto L67;
            case 3: goto L65;
            case 4: goto L63;
            case 5: goto L61;
            case 6: goto L59;
            case 7: goto L57;
            case 8: goto L55;
            case 9: goto L53;
            case 10: goto L51;
            default: goto L50;
        };
    L50:
        return -1;
    L51:
        return 311;
    L53:
        return 304;
    L55:
        return 301;
    L57:
        return 305;
    L59:
        return 303;
    L61:
        return 306;
    L63:
        return 310;
    L65:
        return 308;
    L67:
        return 307;
    L69:
        return 302;
    L71:
        return 309;
    L6:
        if (r10.equals("triggerReceiver") == false) goto L73;
        r11 = 10;
        goto L49
    L73:
        r11 = -1;
        goto L49
    L10:
        if (r10.equals("postLayout") == false) goto L74;
        r11 = 9;
        goto L49
    L74:
        r11 = -1;
        goto L49
    L14:
        if (r10.equals("viewTransitionOnCross") == false) goto L75;
        r11 = 8;
        goto L49
    L75:
        r11 = -1;
        goto L49
    L18:
        if (r10.equals("triggerSlack") == false) goto L76;
        r11 = 7;
        goto L49
    L76:
        r11 = -1;
        goto L49
    L22:
        if (r10.equals("viewTransitionOnNegativeCross") == false) goto L77;
        r11 = 6;
        goto L49
    L77:
        r11 = -1;
        goto L49
    L26:
        if (r10.equals("triggerCollisionView") == false) goto L78;
        r11 = 5;
        goto L49
    L78:
        r11 = -1;
        goto L49
    L30:
        if (r10.equals("negativeCross") == false) goto L79;
        r11 = 4;
        goto L49
    L79:
        r11 = -1;
        goto L49
    L34:
        if (r10.equals("triggerID") == false) goto L80;
        r11 = 3;
        goto L49
    L80:
        r11 = -1;
        goto L49
    L38:
        if (r10.equals("triggerCollisionId") == false) goto L81;
        r11 = 2;
        goto L49
    L81:
        r11 = -1;
        goto L49
    L42:
        if (r10.equals("viewTransitionOnPositiveCross") == false) goto L82;
        r11 = 1;
        goto L49
    L82:
        r11 = -1;
        goto L49
    L46:
        if (r10.equals("positiveCross") == false) goto L83;
        r11 = 0;
        goto L49
    L83:
        r11 = -1;
        goto L49
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        if (r10 != 305) goto L5;
        this.mTriggerSlack = r11;
        return true;
    L5:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 307) goto L5;
        this.mTriggerCollisionId = r11;
        return true;
    L5:
        if (r10 != 308) goto L7;
        this.mTriggerID = toInt(Integer.valueOf(r11));
        return true;
    L7:
        if (r10 == 311) goto L14;
        switch(r10) {
            case 301: goto L13;
            case 302: goto L12;
            case 303: goto L11;
            default: goto L10;
        };
    L11:
        this.mViewTransitionOnNegativeCross = r11;
        return true;
    L12:
        this.mViewTransitionOnPositiveCross = r11;
        return true;
    L13:
        this.mViewTransitionOnCross = r11;
        return true;
    L10:
        return super.setValue(r10, r11);
    L14:
        this.mTriggerReceiver = r11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 309) goto L5;
        this.mPositiveCross = r11;
        return true;
    L5:
        if (r10 != 310) goto L7;
        this.mNegativeCross = r11;
        return true;
    L7:
        if (r10 != 312) goto L9;
        this.mCross = r11;
        return true;
    L9:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, boolean r11) {
        if (r10 != 304) goto L5;
        this.mPostLayout = r11;
        return true;
    L5:
        return super.setValue(r10, r11);
    }
}

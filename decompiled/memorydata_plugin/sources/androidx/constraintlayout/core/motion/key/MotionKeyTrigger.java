package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        this.mTriggerReceiver = UNSET;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = UNSET;
        this.mTriggerCollisionId = UNSET;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = UNSET;
        this.mViewTransitionOnPositiveCross = UNSET;
        this.mViewTransitionOnCross = UNSET;
        this.mCollisionRect = new FloatRect();
        this.mTargetRect = new FloatRect();
        this.mType = 5;
        this.mCustom = new HashMap();
    }

    private void fireCustom(String r6, MotionWidget r7) {
        if (r6.length() != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r6 = r6.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator<String> r1 = this.mCustom.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = r2.toLowerCase(Locale.ROOT);
        if (r0 == true) goto L15;
        if (r3.matches(r6) == false) goto L10;
    L15:
        CustomVariable r4 = (CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustom.get(r2), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        r4.applyToWidget(r7);
        goto L10
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTrigger().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo36clone() {
        return clone();
    }

    public void conditionallyFire(float r1, MotionWidget r2) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r1) {
        return copy(r1);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTrigger copy(MotionKey r3) {
        super.copy(r3);
        MotionKeyTrigger r4 = (MotionKeyTrigger) ZeusTransformUtils.preCheckCast(r3, MotionKeyTrigger.class, "com.obric.memorydata.plugin");
        this.mCurveFit = r4.mCurveFit;
        this.mCross = r4.mCross;
        this.mTriggerReceiver = r4.mTriggerReceiver;
        this.mNegativeCross = r4.mNegativeCross;
        this.mPositiveCross = r4.mPositiveCross;
        this.mTriggerID = r4.mTriggerID;
        this.mTriggerCollisionId = r4.mTriggerCollisionId;
        this.mTriggerSlack = r4.mTriggerSlack;
        this.mFireCrossReset = r4.mFireCrossReset;
        this.mFireNegativeReset = r4.mFireNegativeReset;
        this.mFirePositiveReset = r4.mFirePositiveReset;
        this.mFireThreshold = r4.mFireThreshold;
        this.mFireLastPos = r4.mFireLastPos;
        this.mPostLayout = r4.mPostLayout;
        this.mCollisionRect = r4.mCollisionRect;
        this.mTargetRect = r4.mTargetRect;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r2) {
        r2.hashCode();
        switch(r2.hashCode()) {
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
        byte r1 = -1;
    L49:
        switch(r1) {
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
        if (r2.equals("triggerReceiver") == false) goto L73;
        r1 = 10;
        goto L49
    L73:
        r1 = -1;
        goto L49
    L10:
        if (r2.equals("postLayout") == false) goto L74;
        r1 = 9;
        goto L49
    L74:
        r1 = -1;
        goto L49
    L14:
        if (r2.equals("viewTransitionOnCross") == false) goto L75;
        r1 = 8;
        goto L49
    L75:
        r1 = -1;
        goto L49
    L18:
        if (r2.equals("triggerSlack") == false) goto L76;
        r1 = 7;
        goto L49
    L76:
        r1 = -1;
        goto L49
    L22:
        if (r2.equals("viewTransitionOnNegativeCross") == false) goto L77;
        r1 = 6;
        goto L49
    L77:
        r1 = -1;
        goto L49
    L26:
        if (r2.equals("triggerCollisionView") == false) goto L78;
        r1 = 5;
        goto L49
    L78:
        r1 = -1;
        goto L49
    L30:
        if (r2.equals("negativeCross") == false) goto L79;
        r1 = 4;
        goto L49
    L79:
        r1 = -1;
        goto L49
    L34:
        if (r2.equals("triggerID") == false) goto L80;
        r1 = 3;
        goto L49
    L80:
        r1 = -1;
        goto L49
    L38:
        if (r2.equals("triggerCollisionId") == false) goto L81;
        r1 = 2;
        goto L49
    L81:
        r1 = -1;
        goto L49
    L42:
        if (r2.equals("viewTransitionOnPositiveCross") == false) goto L82;
        r1 = 1;
        goto L49
    L82:
        r1 = -1;
        goto L49
    L46:
        if (r2.equals("positiveCross") == false) goto L83;
        r1 = 0;
        goto L49
    L83:
        r1 = -1;
        goto L49
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 305) goto L5;
        this.mTriggerSlack = r3;
        return true;
    L5:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 307) goto L5;
        this.mTriggerCollisionId = r3;
        return true;
    L5:
        if (r2 != 308) goto L7;
        this.mTriggerID = toInt(Integer.valueOf(r3));
        return true;
    L7:
        if (r2 == 311) goto L14;
        switch(r2) {
            case 301: goto L13;
            case 302: goto L12;
            case 303: goto L11;
            default: goto L10;
        };
    L11:
        this.mViewTransitionOnNegativeCross = r3;
        return true;
    L12:
        this.mViewTransitionOnPositiveCross = r3;
        return true;
    L13:
        this.mViewTransitionOnCross = r3;
        return true;
    L10:
        return super.setValue(r2, r3);
    L14:
        this.mTriggerReceiver = r3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 309) goto L5;
        this.mPositiveCross = r3;
        return true;
    L5:
        if (r2 != 310) goto L7;
        this.mNegativeCross = r3;
        return true;
    L7:
        if (r2 != 312) goto L9;
        this.mCross = r3;
        return true;
    L9:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, boolean r3) {
        if (r2 != 304) goto L5;
        this.mPostLayout = r3;
        return true;
    L5:
        return super.setValue(r2, r3);
    }
}

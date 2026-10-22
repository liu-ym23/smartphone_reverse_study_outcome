package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    HashMap<Integer, HashMap<String, KeyPosition>> keyPositions;
    private int mAutoTransition;
    TypedBundle mBundle;
    private int mDefaultInterpolator;
    private String mDefaultInterpolatorString;
    private int mDuration;
    private Easing mEasing;
    private float mStagger;
    private HashMap<String, WidgetState> state;

    static class KeyPosition {
        int frame;
        String target;
        int type;
        float x;
        float y;

        public KeyPosition(String r1, int r2, int r3, float r4, float r5) {
            this.target = r1;
            this.frame = r2;
            this.type = r3;
            this.x = r4;
            this.y = r5;
        }
    }

    static class WidgetState {
        WidgetFrame end;
        WidgetFrame interpolated;
        Motion motionControl;
        MotionWidget motionWidgetEnd;
        MotionWidget motionWidgetInterpolated;
        MotionWidget motionWidgetStart;
        KeyCache myKeyCache;
        int myParentHeight;
        int myParentWidth;
        WidgetFrame start;

        public WidgetState() {
            this.myKeyCache = new KeyCache();
            this.myParentHeight = -1;
            this.myParentWidth = -1;
            this.start = new WidgetFrame();
            this.end = new WidgetFrame();
            this.interpolated = new WidgetFrame();
            this.motionWidgetStart = new MotionWidget(this.start);
            this.motionWidgetEnd = new MotionWidget(this.end);
            this.motionWidgetInterpolated = new MotionWidget(this.interpolated);
            Motion r0 = new Motion(this.motionWidgetStart);
            this.motionControl = r0;
            r0.setStart(this.motionWidgetStart);
            this.motionControl.setEnd(this.motionWidgetEnd);
        }

        public WidgetFrame getFrame(int r2) {
            if (r2 != 0) goto L6;
            return this.start;
        L6:
            if (r2 != 1) goto L10;
            return this.end;
        L10:
            return this.interpolated;
        }

        public void interpolate(int r8, int r9, float r10, Transition r11) {
            this.myParentHeight = r9;
            this.myParentWidth = r8;
            this.motionControl.setup(r8, r9, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(r8, r9, this.interpolated, this.start, this.end, r11, r10);
            this.interpolated.interpolatedPos = r10;
            this.motionControl.interpolate(this.motionWidgetInterpolated, r10, System.nanoTime(), this.myKeyCache);
        }

        public void setKeyAttribute(TypedBundle r2) {
            MotionKeyAttributes r0 = new MotionKeyAttributes();
            r2.applyDelta(r0);
            this.motionControl.addKey(r0);
        }

        public void setKeyCycle(TypedBundle r2) {
            MotionKeyCycle r0 = new MotionKeyCycle();
            r2.applyDelta(r0);
            this.motionControl.addKey(r0);
        }

        public void setKeyPosition(TypedBundle r2) {
            MotionKeyPosition r0 = new MotionKeyPosition();
            r2.applyDelta(r0);
            this.motionControl.addKey(r0);
        }

        public void update(ConstraintWidget r2, int r3) {
            if (r3 != 0) goto L5;
            this.start.update(r2);
            this.motionControl.setStart(this.motionWidgetStart);
        L7:
            this.myParentWidth = -1;
            return;
        L5:
            if (r3 != 1) goto L7;
            this.end.update(r2);
            this.motionControl.setEnd(this.motionWidgetEnd);
            goto L7
        }
    }

    public Transition() {
        this.keyPositions = new HashMap();
        this.state = new HashMap();
        this.mBundle = new TypedBundle();
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mEasing = null;
        this.mAutoTransition = 0;
        this.mDuration = 400;
        this.mStagger = 0.0f;
    }

    public static Interpolator getInterpolator(int r0, final String r1) {
        switch(r0) {
            case -1: goto L20;
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return $$Lambda$Transition$kTqhkacDGl7bkJ_FxtRxR_k_Afw.INSTANCE;
    L8:
        return $$Lambda$Transition$ul0kEsqd10SU52AIEAqa6fVAWO4.INSTANCE;
    L10:
        return $$Lambda$Transition$Yi0tFJq43DAyzMLAvtaWRa7Xz0.INSTANCE;
    L12:
        return $$Lambda$Transition$8lLgbd07jtmvSR2560hJTuwv_oE.INSTANCE;
    L14:
        return $$Lambda$Transition$2y6TlTJLX_ZX7on7V1Mv0YOmh2E.INSTANCE;
    L16:
        return $$Lambda$Transition$Fe0xKkwgE1Zm2sr90qjBYb6gqK0.INSTANCE;
    L18:
        return $$Lambda$Transition$CTmQdYvAzbwqPbYmXKKHzcfxhy8.INSTANCE;
    L20:
        return new $$Lambda$Transition$jXM2vb2eju1USPXMc6tRUnJaYj0(r1);
    }

    private WidgetState getWidgetState(String r2) {
        return (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin");
    }

    private WidgetState getWidgetState(String r4, ConstraintWidget r5, int r6) {
        WidgetState r0 = (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r4), WidgetState.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        r0 = new WidgetState();
        this.mBundle.applyDelta(r0.motionControl);
        this.state.put(r4, r0);
        if (r5 == null) goto L7;
        r0.update(r5, r6);
    L7:
        return r0;
    }

    static /* synthetic */ float lambda$getInterpolator$0(String r2, float r3) {
        return (float) Easing.getInterpolator(r2).get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$1(float r3) {
        return (float) Easing.getInterpolator("standard").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$2(float r3) {
        return (float) Easing.getInterpolator("accelerate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$3(float r3) {
        return (float) Easing.getInterpolator("decelerate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$4(float r3) {
        return (float) Easing.getInterpolator("linear").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$5(float r3) {
        return (float) Easing.getInterpolator("anticipate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$6(float r3) {
        return (float) Easing.getInterpolator("overshoot").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$7(float r3) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(r3);
    }

    public void addCustomColor(int r2, String r3, String r4, int r5) {
        getWidgetState(r3, null, r2).getFrame(r2).addCustomColor(r4, r5);
    }

    public void addCustomFloat(int r2, String r3, String r4, float r5) {
        getWidgetState(r3, null, r2).getFrame(r2).addCustomFloat(r4, r5);
    }

    public void addKeyAttribute(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyAttribute(r4);
    }

    public void addKeyCycle(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyCycle(r4);
    }

    public void addKeyPosition(String r9, int r10, int r11, float r12, float r13) {
        TypedBundle r0 = new TypedBundle();
        r0.add(TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        r0.add(100, r10);
        r0.add(TypedValues.PositionType.TYPE_PERCENT_X, r12);
        r0.add(TypedValues.PositionType.TYPE_PERCENT_Y, r13);
        getWidgetState(r9, null, 0).setKeyPosition(r0);
        KeyPosition r1 = new KeyPosition(r9, r10, r11, r12, r13);
        HashMap<String, KeyPosition> r14 = (HashMap) ZeusTransformUtils.preCheckCast(this.keyPositions.get(Integer.valueOf(r10)), HashMap.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        r14 = new HashMap();
        this.keyPositions.put(Integer.valueOf(r10), r14);
    L5:
        r14.put(r9, r1);
    }

    public void addKeyPosition(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyPosition(r4);
    }

    public void clear() {
        this.state.clear();
    }

    public boolean contains(String r1) {
        return this.state.containsKey(r1);
    }

    public void fillKeyPositions(WidgetFrame r6, float[] r7, float[] r8, float[] r9) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 > 100) goto L11;
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.keyPositions.get(Integer.valueOf(r0)), HashMap.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        KeyPosition r3 = (KeyPosition) ZeusTransformUtils.preCheckCast(r2.get(r6.widget.stringId), KeyPosition.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        r7[r1] = r3.x;
        r8[r1] = r3.y;
        r9[r1] = r3.frame;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    }

    public KeyPosition findNextPosition(String r4, int r5) {
    L3:
        if (r5 > 100) goto L10;
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(this.keyPositions.get(Integer.valueOf(r5)), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        KeyPosition r1 = (KeyPosition) ZeusTransformUtils.preCheckCast(r0.get(r4), KeyPosition.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return r1;
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        return null;
    }

    public KeyPosition findPreviousPosition(String r4, int r5) {
    L2:
        if (r5 < 0) goto L9;
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(this.keyPositions.get(Integer.valueOf(r5)), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        KeyPosition r1 = (KeyPosition) ZeusTransformUtils.preCheckCast(r0.get(r4), KeyPosition.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        return r1;
    L8:
        r5 = r5 - 1;
        goto L2
    L9:
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 1).end;
    }

    public WidgetFrame getEnd(String r2) {
        WidgetState r1 = (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.end;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    public WidgetFrame getInterpolated(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 2).interpolated;
    }

    public WidgetFrame getInterpolated(String r2) {
        WidgetState r1 = (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.interpolated;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    public int getKeyFrames(String r2, float[] r3, int[] r4, int[] r5) {
        return ((WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin")).motionControl.buildKeyFrames(r3, r4, r5);
    }

    public Motion getMotion(String r3) {
        return getWidgetState(r3, null, 0).motionControl;
    }

    public int getNumberKeyPositions(WidgetFrame r6) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 > 100) goto L11;
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.keyPositions.get(Integer.valueOf(r0)), HashMap.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        if (((KeyPosition) ZeusTransformUtils.preCheckCast(r2.get(r6.widget.stringId), KeyPosition.class, "com.obric.memorydata.plugin")) == null) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    public float[] getPath(String r2) {
        WidgetState r1 = (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin");
        float[] r3 = new float[124];
        r1.motionControl.buildPath(r3, 62);
        return r3;
    }

    public WidgetFrame getStart(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 0).start;
    }

    public WidgetFrame getStart(String r2) {
        WidgetState r1 = (WidgetState) ZeusTransformUtils.preCheckCast(this.state.get(r2), WidgetState.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.start;
    }

    public boolean hasPositionKeyframes() {
        if (this.keyPositions.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void interpolate(int r5, int r6, float r7) {
        Easing r0 = this.mEasing;
        if (r0 == null) goto L5;
        r7 = (float) r0.get(r7);
    L5:
        Iterator<String> r1 = this.state.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((WidgetState) ZeusTransformUtils.preCheckCast(this.state.get((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), WidgetState.class, "com.obric.memorydata.plugin")).interpolate(r5, r6, r7, this);
        goto L7
    }

    public boolean isEmpty() {
        return this.state.isEmpty();
    }

    public void setTransitionProperties(TypedBundle r2) {
        r2.applyDelta(this.mBundle);
        r2.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 706) goto L7;
        this.mStagger = r3;
        return false;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, int r2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 705) goto L7;
        this.mDefaultInterpolatorString = r3;
        this.mEasing = Easing.getInterpolator(r3);
        return false;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer r6, int r7) {
        ArrayList<ConstraintWidget> r8 = r6.getChildren();
        int r0 = r8.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r8.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        getWidgetState(r2.stringId, null, r7).update(r2, r7);
        r1 = r1 + 1;
        goto L3
    }
}

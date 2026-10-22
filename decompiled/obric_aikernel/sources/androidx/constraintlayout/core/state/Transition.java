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

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        float f244x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        float f245y;

        public KeyPosition(String r10, int r11, int r12, float r13, float r14) {
            this.target = r10;
            this.frame = r11;
            this.type = r12;
            this.f244x = r13;
            this.f245y = r14;
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
            Motion r10 = new Motion(this.motionWidgetStart);
            this.motionControl = r10;
            r10.setStart(this.motionWidgetStart);
            this.motionControl.setEnd(this.motionWidgetEnd);
        }

        public WidgetFrame getFrame(int r10) {
            if (r10 != 0) goto L6;
            return this.start;
        L6:
            if (r10 != 1) goto L10;
            return this.end;
        L10:
            return this.interpolated;
        }

        public void interpolate(int r10, int r11, float r12, Transition r13) {
            this.myParentHeight = r11;
            this.myParentWidth = r10;
            this.motionControl.setup(r10, r11, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(r10, r11, this.interpolated, this.start, this.end, r13, r12);
            this.interpolated.interpolatedPos = r12;
            this.motionControl.interpolate(this.motionWidgetInterpolated, r12, System.nanoTime(), this.myKeyCache);
        }

        public void setKeyAttribute(TypedBundle r10) {
            MotionKeyAttributes r11 = new MotionKeyAttributes();
            r10.applyDelta(r11);
            this.motionControl.addKey(r11);
        }

        public void setKeyCycle(TypedBundle r10) {
            MotionKeyCycle r11 = new MotionKeyCycle();
            r10.applyDelta(r11);
            this.motionControl.addKey(r11);
        }

        public void setKeyPosition(TypedBundle r10) {
            MotionKeyPosition r11 = new MotionKeyPosition();
            r10.applyDelta(r11);
            this.motionControl.addKey(r11);
        }

        public void update(ConstraintWidget r10, int r11) {
            if (r11 != 0) goto L5;
            this.start.update(r10);
            this.motionControl.setStart(this.motionWidgetStart);
        L7:
            this.myParentWidth = -1;
            return;
        L5:
            if (r11 != 1) goto L7;
            this.end.update(r10);
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

    public static /* synthetic */ float a(float r10) {
        return lambda$getInterpolator$3(r10);
    }

    public static /* synthetic */ float b(float r10) {
        return lambda$getInterpolator$4(r10);
    }

    public static /* synthetic */ float c(float r10) {
        return lambda$getInterpolator$1(r10);
    }

    public static /* synthetic */ float d(float r10) {
        return lambda$getInterpolator$2(r10);
    }

    public static /* synthetic */ float e(float r10) {
        return lambda$getInterpolator$7(r10);
    }

    public static /* synthetic */ float f(String r10, float r11) {
        return lambda$getInterpolator$0(r10, r11);
    }

    public static /* synthetic */ float g(float r10) {
        return lambda$getInterpolator$5(r10);
    }

    public static Interpolator getInterpolator(int r10, final String r11) {
        switch(r10) {
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
        return g.f252a;
    L8:
        return h.f253a;
    L10:
        return f.f251a;
    L12:
        return c.f248a;
    L14:
        return b.f247a;
    L16:
        return e.f250a;
    L18:
        return d.f249a;
    L20:
        return new a(r11);
    }

    private WidgetState getWidgetState(String r10) {
        return this.state.get(r10);
    }

    private WidgetState getWidgetState(String r10, ConstraintWidget r11, int r12) {
        WidgetState r13 = this.state.get(r10);
        if (r13 != null) goto L7;
        r13 = new WidgetState();
        this.mBundle.applyDelta(r13.motionControl);
        this.state.put(r10, r13);
        if (r11 == null) goto L7;
        r13.update(r11, r12);
    L7:
        return r13;
    }

    public static /* synthetic */ float h(float r10) {
        return lambda$getInterpolator$6(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$0(String r10, float r11) {
        return (float) Easing.getInterpolator(r10).get(r11);
    }

    private static /* synthetic */ float lambda$getInterpolator$1(float r10) {
        return (float) Easing.getInterpolator("standard").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$2(float r10) {
        return (float) Easing.getInterpolator("accelerate").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$3(float r10) {
        return (float) Easing.getInterpolator("decelerate").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$4(float r10) {
        return (float) Easing.getInterpolator("linear").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$5(float r10) {
        return (float) Easing.getInterpolator("anticipate").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$6(float r10) {
        return (float) Easing.getInterpolator("overshoot").get(r10);
    }

    private static /* synthetic */ float lambda$getInterpolator$7(float r10) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(r10);
    }

    public void addCustomColor(int r10, String r11, String r12, int r13) {
        getWidgetState(r11, null, r10).getFrame(r10).addCustomColor(r12, r13);
    }

    public void addCustomFloat(int r10, String r11, String r12, float r13) {
        getWidgetState(r11, null, r10).getFrame(r10).addCustomFloat(r12, r13);
    }

    public void addKeyAttribute(String r10, TypedBundle r11) {
        getWidgetState(r10, null, 0).setKeyAttribute(r11);
    }

    public void addKeyCycle(String r10, TypedBundle r11) {
        getWidgetState(r10, null, 0).setKeyCycle(r11);
    }

    public void addKeyPosition(String r10, int r11, int r12, float r13, float r14) {
        TypedBundle r15 = new TypedBundle();
        r15.add(TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        r15.add(100, r11);
        r15.add(TypedValues.PositionType.TYPE_PERCENT_X, r13);
        r15.add(TypedValues.PositionType.TYPE_PERCENT_Y, r14);
        getWidgetState(r10, null, 0).setKeyPosition(r15);
        KeyPosition r16 = new KeyPosition(r10, r11, r12, r13, r14);
        HashMap<String, KeyPosition> r17 = this.keyPositions.get(Integer.valueOf(r11));
        if (r17 != null) goto L5;
        r17 = new HashMap();
        this.keyPositions.put(Integer.valueOf(r11), r17);
    L5:
        r17.put(r10, r16);
    }

    public void addKeyPosition(String r10, TypedBundle r11) {
        getWidgetState(r10, null, 0).setKeyPosition(r11);
    }

    public void clear() {
        this.state.clear();
    }

    public boolean contains(String r10) {
        return this.state.containsKey(r10);
    }

    public void fillKeyPositions(WidgetFrame r10, float[] r11, float[] r12, float[] r13) {
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 > 100) goto L11;
        HashMap<String, KeyPosition> r16 = this.keyPositions.get(Integer.valueOf(r14));
        if (r16 == null) goto L10;
        KeyPosition r17 = r16.get(r10.widget.stringId);
        if (r17 == null) goto L10;
        r11[r15] = r17.f244x;
        r12[r15] = r17.f245y;
        r13[r15] = r17.frame;
        r15 = r15 + 1;
    L10:
        r14 = r14 + 1;
        goto L4
    }

    public KeyPosition findNextPosition(String r10, int r11) {
    L3:
        if (r11 > 100) goto L10;
        HashMap<String, KeyPosition> r12 = this.keyPositions.get(Integer.valueOf(r11));
        if (r12 == null) goto L9;
        KeyPosition r13 = r12.get(r10);
        if (r13 == null) goto L9;
        return r13;
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return null;
    }

    public KeyPosition findPreviousPosition(String r10, int r11) {
    L2:
        if (r11 < 0) goto L9;
        HashMap<String, KeyPosition> r12 = this.keyPositions.get(Integer.valueOf(r11));
        if (r12 == null) goto L8;
        KeyPosition r13 = r12.get(r10);
        if (r13 == null) goto L8;
        return r13;
    L8:
        r11 = r11 - 1;
        goto L2
    L9:
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(ConstraintWidget r10) {
        return getWidgetState(r10.stringId, null, 1).end;
    }

    public WidgetFrame getEnd(String r10) {
        WidgetState r11 = this.state.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.end;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        return 0;
    }

    public WidgetFrame getInterpolated(ConstraintWidget r10) {
        return getWidgetState(r10.stringId, null, 2).interpolated;
    }

    public WidgetFrame getInterpolated(String r10) {
        WidgetState r11 = this.state.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.interpolated;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    public int getKeyFrames(String r10, float[] r11, int[] r12, int[] r13) {
        return this.state.get(r10).motionControl.buildKeyFrames(r11, r12, r13);
    }

    public Motion getMotion(String r10) {
        return getWidgetState(r10, null, 0).motionControl;
    }

    public int getNumberKeyPositions(WidgetFrame r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 > 100) goto L11;
        HashMap<String, KeyPosition> r13 = this.keyPositions.get(Integer.valueOf(r11));
        if (r13 == null) goto L10;
        if (r13.get(r10.widget.stringId) == null) goto L10;
        r12 = r12 + 1;
    L10:
        r11 = r11 + 1;
        goto L4
    L11:
        return r12;
    }

    public float[] getPath(String r10) {
        WidgetState r11 = this.state.get(r10);
        float[] r12 = new float[124];
        r11.motionControl.buildPath(r12, 62);
        return r12;
    }

    public WidgetFrame getStart(ConstraintWidget r10) {
        return getWidgetState(r10.stringId, null, 0).start;
    }

    public WidgetFrame getStart(String r10) {
        WidgetState r11 = this.state.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.start;
    }

    public boolean hasPositionKeyframes() {
        if (this.keyPositions.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void interpolate(int r10, int r11, float r12) {
        Easing r13 = this.mEasing;
        if (r13 == null) goto L5;
        r12 = (float) r13.get(r12);
    L5:
        Iterator<String> r14 = this.state.keySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        this.state.get(r14.next()).interpolate(r10, r11, r12, this);
        goto L7
    }

    public boolean isEmpty() {
        return this.state.isEmpty();
    }

    public void setTransitionProperties(TypedBundle r10) {
        r10.applyDelta(this.mBundle);
        r10.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        if (r10 != 706) goto L7;
        this.mStagger = r11;
        return false;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 705) goto L7;
        this.mDefaultInterpolatorString = r11;
        this.mEasing = Easing.getInterpolator(r11);
        return false;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, boolean r11) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer r10, int r11) {
        ArrayList<ConstraintWidget> r12 = r10.getChildren();
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        ConstraintWidget r15 = r12.get(r14);
        getWidgetState(r15.stringId, null, r11).update(r15, r11);
        r14 = r14 + 1;
        goto L3
    }
}

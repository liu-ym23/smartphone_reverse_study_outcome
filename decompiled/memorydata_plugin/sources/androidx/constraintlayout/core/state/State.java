package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = null;
    static final int UNKNOWN = -1;
    protected HashMap<Object, HelperReference> mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences;
    HashMap<String, ArrayList<String>> mTags;
    private int numHelpers;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.State$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Helper = null;

        static {
            int[] r0 = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper = r0;
            r0[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[Helper.BARRIER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;

        static {
            Chain r0 = new Chain("SPREAD", 0);
            SPREAD = r0;
            Chain r1 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            Chain r3 = new Chain("PACKED", 2);
            PACKED = r3;
            $VALUES = new Chain[]{r0, r1, r3};
        }

        private Chain(String r1, int r2) {
            super(r1, r2);
        }

        public static Chain valueOf(String r2) {
            return (Chain) ZeusTransformUtils.preCheckCast(Enum.valueOf(Chain.class, r2), Chain.class, "com.obric.memorydata.plugin");
        }

        public static Chain[] values() {
            return (Chain[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Chain[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BASELINE_TO_BOTTOM = null;
        public static final Constraint BASELINE_TO_TOP = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
        public static final Constraint CIRCULAR_CONSTRAINT = null;
        public static final Constraint END_TO_END = null;
        public static final Constraint END_TO_START = null;
        public static final Constraint LEFT_TO_LEFT = null;
        public static final Constraint LEFT_TO_RIGHT = null;
        public static final Constraint RIGHT_TO_LEFT = null;
        public static final Constraint RIGHT_TO_RIGHT = null;
        public static final Constraint START_TO_END = null;
        public static final Constraint START_TO_START = null;
        public static final Constraint TOP_TO_BOTTOM = null;
        public static final Constraint TOP_TO_TOP = null;

        static {
            Constraint r0 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r0;
            Constraint r1 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r1;
            Constraint r3 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            Constraint r5 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r5;
            Constraint r7 = new Constraint("START_TO_START", 4);
            START_TO_START = r7;
            Constraint r9 = new Constraint("START_TO_END", 5);
            START_TO_END = r9;
            Constraint r11 = new Constraint("END_TO_START", 6);
            END_TO_START = r11;
            Constraint r13 = new Constraint("END_TO_END", 7);
            END_TO_END = r13;
            Constraint r15 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r15;
            Constraint r14 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r14;
            Constraint r12 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r12;
            Constraint r10 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r10;
            Constraint r8 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r8;
            Constraint r6 = new Constraint("BASELINE_TO_TOP", 13);
            BASELINE_TO_TOP = r6;
            Constraint r4 = new Constraint("BASELINE_TO_BOTTOM", 14);
            BASELINE_TO_BOTTOM = r4;
            Constraint r2 = new Constraint("CENTER_HORIZONTALLY", 15);
            CENTER_HORIZONTALLY = r2;
            Constraint r16 = new Constraint("CENTER_VERTICALLY", 16);
            CENTER_VERTICALLY = r16;
            Constraint r17 = new Constraint("CIRCULAR_CONSTRAINT", 17);
            CIRCULAR_CONSTRAINT = r17;
            $VALUES = new Constraint[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
        }

        private Constraint(String r1, int r2) {
            super(r1, r2);
        }

        public static Constraint valueOf(String r2) {
            return (Constraint) ZeusTransformUtils.preCheckCast(Enum.valueOf(Constraint.class, r2), Constraint.class, "com.obric.memorydata.plugin");
        }

        public static Constraint[] values() {
            return (Constraint[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Constraint[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BOTTOM = null;
        public static final Direction END = null;
        public static final Direction LEFT = null;
        public static final Direction RIGHT = null;
        public static final Direction START = null;
        public static final Direction TOP = null;

        static {
            Direction r0 = new Direction("LEFT", 0);
            LEFT = r0;
            Direction r1 = new Direction("RIGHT", 1);
            RIGHT = r1;
            Direction r3 = new Direction("START", 2);
            START = r3;
            Direction r5 = new Direction("END", 3);
            END = r5;
            Direction r7 = new Direction("TOP", 4);
            TOP = r7;
            Direction r9 = new Direction("BOTTOM", 5);
            BOTTOM = r9;
            $VALUES = new Direction[]{r0, r1, r3, r5, r7, r9};
        }

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String r2) {
            return (Direction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Direction.class, r2), Direction.class, "com.obric.memorydata.plugin");
        }

        public static Direction[] values() {
            return (Direction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Direction[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Helper extends Enum<Helper> {
        private static final /* synthetic */ Helper[] $VALUES = null;
        public static final Helper ALIGN_HORIZONTALLY = null;
        public static final Helper ALIGN_VERTICALLY = null;
        public static final Helper BARRIER = null;
        public static final Helper FLOW = null;
        public static final Helper HORIZONTAL_CHAIN = null;
        public static final Helper LAYER = null;
        public static final Helper VERTICAL_CHAIN = null;

        static {
            Helper r0 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r0;
            Helper r1 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r1;
            Helper r3 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r3;
            Helper r5 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r5;
            Helper r7 = new Helper("BARRIER", 4);
            BARRIER = r7;
            Helper r9 = new Helper("LAYER", 5);
            LAYER = r9;
            Helper r11 = new Helper("FLOW", 6);
            FLOW = r11;
            $VALUES = new Helper[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private Helper(String r1, int r2) {
            super(r1, r2);
        }

        public static Helper valueOf(String r2) {
            return (Helper) ZeusTransformUtils.preCheckCast(Enum.valueOf(Helper.class, r2), Helper.class, "com.obric.memorydata.plugin");
        }

        public static Helper[] values() {
            return (Helper[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Helper[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        PARENT = 0;
    }

    public State() {
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        this.mTags = new HashMap();
        ConstraintReference r0 = new ConstraintReference(this);
        this.mParent = r0;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, r0);
    }

    private String createHelperKey() {
        StringBuilder r0 = new StringBuilder().append("__HELPER_KEY_");
        int r1 = this.numHelpers;
        this.numHelpers = r1 + 1;
        return r0.append(r1).append("__").toString();
    }

    public void apply(ConstraintWidgetContainer r9) {
        r9.removeAllChildren();
        this.mParent.getWidth().apply(this, r9, 0);
        this.mParent.getHeight().apply(this, r9, 1);
        Iterator<Object> r0 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        HelperWidget r3 = ((HelperReference) ZeusTransformUtils.preCheckCast(this.mHelperReferences.get(r1), HelperReference.class, "com.obric.memorydata.plugin")).getHelperWidget();
        if (r3 == null) goto L4;
        Reference r2 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r1), Reference.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        r2 = constraints(r1);
    L10:
        r2.setConstraintWidget(r3);
        goto L4
    L11:
        Iterator<Object> r4 = this.mReferences.keySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        Reference r6 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r5), Reference.class, "com.obric.memorydata.plugin");
        if (r6 == this.mParent) goto L13;
        if (ZeusTransformUtils.instanceOf(r6.getFacade(), HelperReference.class) == false) goto L13;
        HelperWidget r7 = ((HelperReference) ZeusTransformUtils.preCheckCast(r6.getFacade(), HelperReference.class, "com.obric.memorydata.plugin")).getHelperWidget();
        if (r7 == null) goto L13;
        Reference r8 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r5), Reference.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L23;
        r8 = constraints(r5);
    L23:
        r8.setConstraintWidget(r7);
        goto L13
    L24:
        Iterator<Object> r10 = this.mReferences.keySet().iterator();
    L26:
        if (r10.hasNext() == false) goto L34;
        Reference r11 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r10.next()), Reference.class, "com.obric.memorydata.plugin");
        if (r11 != this.mParent) goto L29;
        r11.setConstraintWidget(r9);
        goto L26
    L29:
        ConstraintWidget r12 = r11.getConstraintWidget();
        r12.setDebugName(r11.getKey().toString());
        r12.setParent(null);
        if (ZeusTransformUtils.instanceOf(r11.getFacade(), GuidelineReference.class) == false) goto L32;
        r11.apply();
    L32:
        r9.add(r12);
        goto L26
    L34:
        Iterator<Object> r13 = this.mHelperReferences.keySet().iterator();
    L36:
        if (r13.hasNext() == false) goto L44;
        HelperReference r14 = (HelperReference) ZeusTransformUtils.preCheckCast(this.mHelperReferences.get(r13.next()), HelperReference.class, "com.obric.memorydata.plugin");
        if (r14.getHelperWidget() == null) goto L43;
        Iterator<Object> r15 = r14.mReferences.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        r14.getHelperWidget().add(((Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r15.next()), Reference.class, "com.obric.memorydata.plugin")).getConstraintWidget());
    L43:
        r14.apply();
        goto L36
    L44:
        Iterator<Object> r16 = this.mReferences.keySet().iterator();
    L46:
        if (r16.hasNext() == false) goto L65;
        Reference r17 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r16.next()), Reference.class, "com.obric.memorydata.plugin");
        if (r17 == this.mParent) goto L46;
        if (ZeusTransformUtils.instanceOf(r17.getFacade(), HelperReference.class) == false) goto L46;
        HelperReference r18 = (HelperReference) ZeusTransformUtils.preCheckCast(r17.getFacade(), HelperReference.class, "com.obric.memorydata.plugin");
        HelperWidget r19 = r18.getHelperWidget();
        if (r19 == null) goto L46;
        Iterator<Object> r20 = r18.mReferences.iterator();
    L55:
        if (r20.hasNext() == false) goto L64;
        Object r21 = r20.next();
        Reference r22 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r21), Reference.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L58;
        if (ZeusTransformUtils.instanceOf(r21, Reference.class) == true) goto L62;
        System.out.println("couldn't find reference for " + r21);
        goto L55
    L62:
        ConstraintWidget r23 = ((Reference) ZeusTransformUtils.preCheckCast(r21, Reference.class, "com.obric.memorydata.plugin")).getConstraintWidget();
    L59:
        r19.add(r23);
        goto L55
    L58:
        r23 = r22.getConstraintWidget();
        goto L59
    L64:
        r17.apply();
        goto L46
    L65:
        Iterator<Object> r24 = this.mReferences.keySet().iterator();
    L67:
        if (r24.hasNext() == false) goto L72;
        Object r25 = r24.next();
        Reference r26 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r25), Reference.class, "com.obric.memorydata.plugin");
        r26.apply();
        ConstraintWidget r27 = r26.getConstraintWidget();
        if (r27 == null) goto L67;
        if (r25 == null) goto L67;
        r27.stringId = r25.toString();
        goto L67
    }

    public BarrierReference barrier(Object r3, Direction r4) {
        ConstraintReference r5 = constraints(r3);
        if (r5.getFacade() != null) goto L5;
    L6:
        BarrierReference r0 = new BarrierReference(this);
        r0.setBarrierDirection(r4);
        r5.setFacade(r0);
    L8:
        return (BarrierReference) ZeusTransformUtils.preCheckCast(r5.getFacade(), BarrierReference.class, "com.obric.memorydata.plugin");
    L5:
        if (ZeusTransformUtils.instanceOf(r5.getFacade(), BarrierReference.class) == true) goto L8;
        goto L6
    }

    public AlignHorizontallyReference centerHorizontally(Object... r3) {
        AlignHorizontallyReference r2 = (AlignHorizontallyReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.ALIGN_HORIZONTALLY), AlignHorizontallyReference.class, "com.obric.memorydata.plugin");
        r2.add(r3);
        return r2;
    }

    public AlignVerticallyReference centerVertically(Object... r3) {
        AlignVerticallyReference r2 = (AlignVerticallyReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.ALIGN_VERTICALLY), AlignVerticallyReference.class, "com.obric.memorydata.plugin");
        r2.add(r3);
        return r2;
    }

    public ConstraintReference constraints(Object r4) {
        Reference r0 = (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r4), Reference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = createConstraintReference(r4);
        this.mReferences.put(r4, r0);
        r0.setKey(r4);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintReference.class) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) ZeusTransformUtils.preCheckCast(r0, ConstraintReference.class, "com.obric.memorydata.plugin");
    }

    public int convertDimension(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L7;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L9;
        return 0;
    L9:
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public ConstraintReference createConstraintReference(Object r1) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        Iterator<Object> r0 = this.mReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r1 = r0.next();
        ConstraintReference r2 = constraints(r1);
        if (ZeusTransformUtils.instanceOf(r2, ConstraintReference.class) == false) goto L4;
        ((ConstraintReference) ZeusTransformUtils.preCheckCast(r2, ConstraintReference.class, "com.obric.memorydata.plugin")).setView(r1);
        goto L4
    }

    public ArrayList<String> getIdsForTag(String r2) {
        if (this.mTags.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.mTags.get(r2), ArrayList.class, "com.obric.memorydata.plugin");
    }

    public GuidelineReference guideline(Object r4, int r5) {
        ConstraintReference r0 = constraints(r4);
        if (r0.getFacade() != null) goto L5;
    L6:
        GuidelineReference r1 = new GuidelineReference(this);
        r1.setOrientation(r5);
        r1.setKey(r4);
        r0.setFacade(r1);
    L8:
        return (GuidelineReference) ZeusTransformUtils.preCheckCast(r0.getFacade(), GuidelineReference.class, "com.obric.memorydata.plugin");
    L5:
        if (ZeusTransformUtils.instanceOf(r0.getFacade(), GuidelineReference.class) == true) goto L8;
        goto L6
    }

    public State height(Dimension r1) {
        return setHeight(r1);
    }

    public HelperReference helper(Object r4, Helper r5) {
        if (r4 != null) goto L4;
        r4 = createHelperKey();
    L4:
        HelperReference r0 = (HelperReference) ZeusTransformUtils.preCheckCast(this.mHelperReferences.get(r4), HelperReference.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L24;
        int r1 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Helper[r5.ordinal()];
        if (r1 != 1) goto L9;
        HelperReference r6 = new HorizontalChainReference(this);
    L22:
        r0 = r6;
    L23:
        r0.setKey(r4);
        this.mHelperReferences.put(r4, r0);
        goto L24
    L9:
        if (r1 != 2) goto L11;
        r6 = new VerticalChainReference(this);
        goto L22
    L11:
        if (r1 != 3) goto L13;
        r6 = new AlignHorizontallyReference(this);
        goto L22
    L13:
        if (r1 != 4) goto L15;
        r6 = new AlignVerticallyReference(this);
        goto L22
    L15:
        if (r1 == 5) goto L17;
        r0 = new HelperReference(this, r5);
        goto L23
    L17:
        r6 = new BarrierReference(this);
    L24:
        return r0;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.HORIZONTAL_CHAIN), HorizontalChainReference.class, "com.obric.memorydata.plugin");
    }

    public HorizontalChainReference horizontalChain(Object... r3) {
        HorizontalChainReference r2 = (HorizontalChainReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.HORIZONTAL_CHAIN), HorizontalChainReference.class, "com.obric.memorydata.plugin");
        r2.add(r3);
        return r2;
    }

    public GuidelineReference horizontalGuideline(Object r2) {
        return guideline(r2, 0);
    }

    public void map(Object r2, Object r3) {
        ConstraintReference r1 = constraints(r2);
        if (ZeusTransformUtils.instanceOf(r1, ConstraintReference.class) == false) goto L6;
        ((ConstraintReference) ZeusTransformUtils.preCheckCast(r1, ConstraintReference.class, "com.obric.memorydata.plugin")).setView(r3);
        return;
    }

    Reference reference(Object r2) {
        return (Reference) ZeusTransformUtils.preCheckCast(this.mReferences.get(r2), Reference.class, "com.obric.memorydata.plugin");
    }

    public void reset() {
        this.mHelperReferences.clear();
        this.mTags.clear();
    }

    public boolean sameFixedHeight(int r1) {
        return this.mParent.getHeight().equalsFixedValue(r1);
    }

    public boolean sameFixedWidth(int r1) {
        return this.mParent.getWidth().equalsFixedValue(r1);
    }

    public State setHeight(Dimension r2) {
        this.mParent.setHeight(r2);
        return this;
    }

    public void setTag(String r4, String r5) {
        ConstraintReference r0 = constraints(r4);
        if (ZeusTransformUtils.instanceOf(r0, ConstraintReference.class) == false) goto L10;
        ((ConstraintReference) ZeusTransformUtils.preCheckCast(r0, ConstraintReference.class, "com.obric.memorydata.plugin")).setTag(r5);
        if (this.mTags.containsKey(r5) == true) goto L7;
        ArrayList<String> r1 = new ArrayList();
        this.mTags.put(r5, r1);
    L8:
        r1.add(r4);
        return;
    L7:
        r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mTags.get(r5), ArrayList.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public State setWidth(Dimension r2) {
        this.mParent.setWidth(r2);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.VERTICAL_CHAIN), VerticalChainReference.class, "com.obric.memorydata.plugin");
    }

    public VerticalChainReference verticalChain(Object... r3) {
        VerticalChainReference r2 = (VerticalChainReference) ZeusTransformUtils.preCheckCast(helper(null, Helper.VERTICAL_CHAIN), VerticalChainReference.class, "com.obric.memorydata.plugin");
        r2.add(r3);
        return r2;
    }

    public GuidelineReference verticalGuideline(Object r2) {
        return guideline(r2, 1);
    }

    public State width(Dimension r1) {
        return setWidth(r1);
    }
}

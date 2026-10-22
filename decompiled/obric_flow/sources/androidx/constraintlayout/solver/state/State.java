package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.room.solver.CodeGenScope;
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
    private int numHelpers;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.State$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = null;

        static {
            int[] r5 = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = r5;
            r5[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.BARRIER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;

        static {
            Chain r5 = new Chain("SPREAD", 0);
            SPREAD = r5;
            Chain r10 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r10;
            Chain r11 = new Chain("PACKED", 2);
            PACKED = r11;
            $VALUES = new Chain[]{r5, r10, r11};
        }

        private Chain(String r5, int r10) {
            super(r5, r10);
        }

        public static Chain valueOf(String r5) {
            return (Chain) Enum.valueOf(Chain.class, r5);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
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
            Constraint r5 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r5;
            Constraint r10 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r10;
            Constraint r11 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r11;
            Constraint r12 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r12;
            Constraint r13 = new Constraint("START_TO_START", 4);
            START_TO_START = r13;
            Constraint r14 = new Constraint("START_TO_END", 5);
            START_TO_END = r14;
            Constraint r15 = new Constraint("END_TO_START", 6);
            END_TO_START = r15;
            Constraint r16 = new Constraint("END_TO_END", 7);
            END_TO_END = r16;
            Constraint r17 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r17;
            Constraint r18 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r18;
            Constraint r19 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r19;
            Constraint r110 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r110;
            Constraint r111 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r111;
            Constraint r112 = new Constraint("CENTER_HORIZONTALLY", 13);
            CENTER_HORIZONTALLY = r112;
            Constraint r113 = new Constraint("CENTER_VERTICALLY", 14);
            CENTER_VERTICALLY = r113;
            $VALUES = new Constraint[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113};
        }

        private Constraint(String r5, int r10) {
            super(r5, r10);
        }

        public static Constraint valueOf(String r5) {
            return (Constraint) Enum.valueOf(Constraint.class, r5);
        }

        public static Constraint[] values() {
            return (Constraint[]) $VALUES.clone();
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
            Direction r5 = new Direction("LEFT", 0);
            LEFT = r5;
            Direction r10 = new Direction("RIGHT", 1);
            RIGHT = r10;
            Direction r11 = new Direction("START", 2);
            START = r11;
            Direction r12 = new Direction("END", 3);
            END = r12;
            Direction r13 = new Direction("TOP", 4);
            TOP = r13;
            Direction r14 = new Direction("BOTTOM", 5);
            BOTTOM = r14;
            $VALUES = new Direction[]{r5, r10, r11, r12, r13, r14};
        }

        private Direction(String r5, int r10) {
            super(r5, r10);
        }

        public static Direction valueOf(String r5) {
            return (Direction) Enum.valueOf(Direction.class, r5);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
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
            Helper r5 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r5;
            Helper r10 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r10;
            Helper r11 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r11;
            Helper r12 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r12;
            Helper r13 = new Helper("BARRIER", 4);
            BARRIER = r13;
            Helper r14 = new Helper("LAYER", 5);
            LAYER = r14;
            Helper r15 = new Helper("FLOW", 6);
            FLOW = r15;
            $VALUES = new Helper[]{r5, r10, r11, r12, r13, r14, r15};
        }

        private Helper(String r5, int r10) {
            super(r5, r10);
        }

        public static Helper valueOf(String r5) {
            return (Helper) Enum.valueOf(Helper.class, r5);
        }

        public static Helper[] values() {
            return (Helper[]) $VALUES.clone();
        }
    }

    static {
        PARENT = 0;
    }

    public State() {
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        ConstraintReference r5 = new ConstraintReference(this);
        this.mParent = r5;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, r5);
    }

    private String createHelperKey() {
        StringBuilder r5 = new StringBuilder("__HELPER_KEY_");
        int r10 = this.numHelpers;
        this.numHelpers = r10 + 1;
        return a.s(r5, r10, CodeGenScope.CLASS_PROPERTY_PREFIX);
    }

    public void apply(ConstraintWidgetContainer r5) {
        r5.removeAllChildren();
        this.mParent.getWidth().apply(this, r5, 0);
        this.mParent.getHeight().apply(this, r5, 1);
        Iterator<Object> r10 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r11 = r10.next();
        HelperWidget r12 = this.mHelperReferences.get(r11).getHelperWidget();
        if (r12 == null) goto L4;
        Reference r13 = this.mReferences.get(r11);
        if (r13 != null) goto L10;
        r13 = constraints(r11);
    L10:
        r13.setConstraintWidget(r12);
        goto L4
    L11:
        Iterator<Object> r14 = this.mReferences.keySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        Reference r16 = this.mReferences.get(r15);
        if (r16 != this.mParent) goto L16;
        r16.setConstraintWidget(r5);
        goto L13
    L16:
        ConstraintWidget r17 = r16.getConstraintWidget();
        r17.setParent(null);
        if ((r16 instanceof GuidelineReference) == false) goto L19;
        r16.apply();
    L19:
        r5.add(r17);
        goto L13
    L21:
        Iterator<Object> r18 = this.mHelperReferences.keySet().iterator();
    L23:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();
        HelperReference r20 = this.mHelperReferences.get(r19);
        if (r20.getHelperWidget() == null) goto L23;
        Iterator<Object> r21 = r20.mReferences.iterator();
    L28:
        if (r21.hasNext() == false) goto L30;
        Object r22 = r21.next();
        Reference r23 = this.mReferences.get(r22);
        r20.getHelperWidget().add(r23.getConstraintWidget());
        goto L28
    L30:
        r20.apply();
        goto L23
    L31:
        Iterator<Object> r24 = this.mReferences.keySet().iterator();
    L33:
        if (r24.hasNext() == false) goto L35;
        Object r25 = r24.next();
        this.mReferences.get(r25).apply();
        goto L33
    }

    public BarrierReference barrier(Object r5, Direction r10) {
        BarrierReference r11 = (BarrierReference) helper(r5, Helper.BARRIER);
        r11.setBarrierDirection(r10);
        return r11;
    }

    public AlignHorizontallyReference centerHorizontally(Object... r5) {
        AlignHorizontallyReference r10 = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        r10.add(r5);
        return r10;
    }

    public AlignVerticallyReference centerVertically(Object... r5) {
        AlignVerticallyReference r10 = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        r10.add(r5);
        return r10;
    }

    public ConstraintReference constraints(Object r5) {
        Reference r10 = this.mReferences.get(r5);
        if (r10 != null) goto L6;
        r10 = createConstraintReference(r5);
        this.mReferences.put(r5, r10);
        r10.setKey(r5);
    L6:
        if ((r10 instanceof ConstraintReference) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) r10;
    }

    public int convertDimension(Object r5) {
        if ((r5 instanceof Float) == false) goto L7;
        return ((Float) r5).intValue();
    L7:
        if ((r5 instanceof Integer) == true) goto L9;
        return 0;
    L9:
        return ((Integer) r5).intValue();
    }

    public ConstraintReference createConstraintReference(Object r5) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        Iterator<Object> r5 = this.mReferences.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Object r10 = r5.next();
        constraints(r10).setView(r10);
        goto L4
    }

    public GuidelineReference guideline(Object r5, int r10) {
        Reference r11 = this.mReferences.get(r5);
        Object r12 = r11;
        if (r11 != null) goto L6;
        GuidelineReference r13 = new GuidelineReference(this);
        r13.setOrientation(r10);
        r13.setKey(r5);
        this.mReferences.put(r5, r13);
        r12 = r13;
    L6:
        return (GuidelineReference) r12;
    }

    public State height(Dimension r5) {
        return setHeight(r5);
    }

    public HelperReference helper(Object r5, Helper r10) {
        if (r5 != null) goto L4;
        r5 = createHelperKey();
    L4:
        HelperReference r11 = this.mHelperReferences.get(r5);
        if (r11 != null) goto L24;
        int r12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[r10.ordinal()];
        if (r12 != 1) goto L9;
        HelperReference r13 = new HorizontalChainReference(this);
    L18:
        r11 = r13;
    L23:
        this.mHelperReferences.put(r5, r11);
        goto L24
    L9:
        if (r12 != 2) goto L11;
        r13 = new VerticalChainReference(this);
        goto L18
    L11:
        if (r12 != 3) goto L13;
        r13 = new AlignHorizontallyReference(this);
        goto L18
    L13:
        if (r12 != 4) goto L15;
        r13 = new AlignVerticallyReference(this);
        goto L18
    L15:
        if (r12 == 5) goto L17;
        r11 = new HelperReference(this, r10);
        goto L23
    L17:
        r13 = new BarrierReference(this);
    L24:
        return r11;
    }

    public HorizontalChainReference horizontalChain(Object... r5) {
        HorizontalChainReference r10 = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        r10.add(r5);
        return r10;
    }

    public GuidelineReference horizontalGuideline(Object r5) {
        return guideline(r5, 0);
    }

    public void map(Object r5, Object r10) {
        constraints(r5).setView(r10);
    }

    public Reference reference(Object r5) {
        return this.mReferences.get(r5);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension r5) {
        this.mParent.setHeight(r5);
        return this;
    }

    public State setWidth(Dimension r5) {
        this.mParent.setWidth(r5);
        return this;
    }

    public VerticalChainReference verticalChain(Object... r5) {
        VerticalChainReference r10 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r10.add(r5);
        return r10;
    }

    public GuidelineReference verticalGuideline(Object r5) {
        return guideline(r5, 1);
    }

    public State width(Dimension r5) {
        return setWidth(r5);
    }
}

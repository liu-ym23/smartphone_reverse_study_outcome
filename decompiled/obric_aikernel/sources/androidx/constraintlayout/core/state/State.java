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
            int[] r10 = new int[Helper.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper = r10;
            r10[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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
            Chain r10 = new Chain("SPREAD", 0);
            SPREAD = r10;
            Chain r11 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r11;
            Chain r12 = new Chain("PACKED", 2);
            PACKED = r12;
            $VALUES = new Chain[]{r10, r11, r12};
        }

        private Chain(String r10, int r11) {
            super(r10, r11);
        }

        public static Chain valueOf(String r10) {
            return (Chain) Enum.valueOf(Chain.class, r10);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
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
            Constraint r10 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r10;
            Constraint r11 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r11;
            Constraint r12 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r12;
            Constraint r13 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r13;
            Constraint r14 = new Constraint("START_TO_START", 4);
            START_TO_START = r14;
            Constraint r15 = new Constraint("START_TO_END", 5);
            START_TO_END = r15;
            Constraint r16 = new Constraint("END_TO_START", 6);
            END_TO_START = r16;
            Constraint r17 = new Constraint("END_TO_END", 7);
            END_TO_END = r17;
            Constraint r18 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r18;
            Constraint r19 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r19;
            Constraint r110 = new Constraint("BOTTOM_TO_TOP", 10);
            BOTTOM_TO_TOP = r110;
            Constraint r111 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            BOTTOM_TO_BOTTOM = r111;
            Constraint r20 = new Constraint("BASELINE_TO_BASELINE", 12);
            BASELINE_TO_BASELINE = r20;
            Constraint r21 = new Constraint("BASELINE_TO_TOP", 13);
            BASELINE_TO_TOP = r21;
            Constraint r22 = new Constraint("BASELINE_TO_BOTTOM", 14);
            BASELINE_TO_BOTTOM = r22;
            Constraint r23 = new Constraint("CENTER_HORIZONTALLY", 15);
            CENTER_HORIZONTALLY = r23;
            Constraint r24 = new Constraint("CENTER_VERTICALLY", 16);
            CENTER_VERTICALLY = r24;
            Constraint r25 = new Constraint("CIRCULAR_CONSTRAINT", 17);
            CIRCULAR_CONSTRAINT = r25;
            $VALUES = new Constraint[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25};
        }

        private Constraint(String r10, int r11) {
            super(r10, r11);
        }

        public static Constraint valueOf(String r10) {
            return (Constraint) Enum.valueOf(Constraint.class, r10);
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
            Direction r10 = new Direction("LEFT", 0);
            LEFT = r10;
            Direction r11 = new Direction("RIGHT", 1);
            RIGHT = r11;
            Direction r12 = new Direction("START", 2);
            START = r12;
            Direction r13 = new Direction("END", 3);
            END = r13;
            Direction r14 = new Direction("TOP", 4);
            TOP = r14;
            Direction r15 = new Direction("BOTTOM", 5);
            BOTTOM = r15;
            $VALUES = new Direction[]{r10, r11, r12, r13, r14, r15};
        }

        private Direction(String r10, int r11) {
            super(r10, r11);
        }

        public static Direction valueOf(String r10) {
            return (Direction) Enum.valueOf(Direction.class, r10);
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
            Helper r10 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r10;
            Helper r11 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r11;
            Helper r12 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r12;
            Helper r13 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r13;
            Helper r14 = new Helper("BARRIER", 4);
            BARRIER = r14;
            Helper r15 = new Helper("LAYER", 5);
            LAYER = r15;
            Helper r16 = new Helper("FLOW", 6);
            FLOW = r16;
            $VALUES = new Helper[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private Helper(String r10, int r11) {
            super(r10, r11);
        }

        public static Helper valueOf(String r10) {
            return (Helper) Enum.valueOf(Helper.class, r10);
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
        this.mTags = new HashMap();
        ConstraintReference r10 = new ConstraintReference(this);
        this.mParent = r10;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, r10);
    }

    private String createHelperKey() {
        StringBuilder r10 = new StringBuilder();
        r10.append("__HELPER_KEY_");
        int r11 = this.numHelpers;
        this.numHelpers = r11 + 1;
        r10.append(r11);
        r10.append("__");
        return r10.toString();
    }

    public void apply(ConstraintWidgetContainer r10) {
        r10.removeAllChildren();
        this.mParent.getWidth().apply(this, r10, 0);
        this.mParent.getHeight().apply(this, r10, 1);
        Iterator<Object> r11 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r12 = r11.next();
        HelperWidget r13 = this.mHelperReferences.get(r12).getHelperWidget();
        if (r13 == null) goto L4;
        Reference r14 = this.mReferences.get(r12);
        if (r14 != null) goto L10;
        r14 = constraints(r12);
    L10:
        r14.setConstraintWidget(r13);
        goto L4
    L11:
        Iterator<Object> r15 = this.mReferences.keySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L24;
        Object r16 = r15.next();
        Reference r17 = this.mReferences.get(r16);
        if (r17 == this.mParent) goto L13;
        if ((r17.getFacade() instanceof HelperReference) == false) goto L13;
        HelperWidget r18 = ((HelperReference) r17.getFacade()).getHelperWidget();
        if (r18 == null) goto L13;
        Reference r19 = this.mReferences.get(r16);
        if (r19 != null) goto L23;
        r19 = constraints(r16);
    L23:
        r19.setConstraintWidget(r18);
        goto L13
    L24:
        Iterator<Object> r20 = this.mReferences.keySet().iterator();
    L26:
        if (r20.hasNext() == false) goto L34;
        Reference r21 = this.mReferences.get(r20.next());
        if (r21 != this.mParent) goto L29;
        r21.setConstraintWidget(r10);
        goto L26
    L29:
        ConstraintWidget r22 = r21.getConstraintWidget();
        r22.setDebugName(r21.getKey().toString());
        r22.setParent(null);
        if ((r21.getFacade() instanceof GuidelineReference) == false) goto L32;
        r21.apply();
    L32:
        r10.add(r22);
        goto L26
    L34:
        Iterator<Object> r23 = this.mHelperReferences.keySet().iterator();
    L36:
        if (r23.hasNext() == false) goto L44;
        HelperReference r24 = this.mHelperReferences.get(r23.next());
        if (r24.getHelperWidget() == null) goto L43;
        Iterator<Object> r25 = r24.mReferences.iterator();
    L41:
        if (r25.hasNext() == false) goto L43;
        r24.getHelperWidget().add(this.mReferences.get(r25.next()).getConstraintWidget());
    L43:
        r24.apply();
        goto L36
    L44:
        Iterator<Object> r26 = this.mReferences.keySet().iterator();
    L46:
        if (r26.hasNext() == false) goto L65;
        Reference r27 = this.mReferences.get(r26.next());
        if (r27 == this.mParent) goto L46;
        if ((r27.getFacade() instanceof HelperReference) == false) goto L46;
        HelperReference r28 = (HelperReference) r27.getFacade();
        HelperWidget r29 = r28.getHelperWidget();
        if (r29 == null) goto L46;
        Iterator<Object> r30 = r28.mReferences.iterator();
    L55:
        if (r30.hasNext() == false) goto L64;
        Object r31 = r30.next();
        Reference r32 = this.mReferences.get(r31);
        if (r32 != null) goto L58;
        if ((r31 instanceof Reference) == true) goto L62;
        System.out.println("couldn't find reference for " + r31);
        goto L55
    L62:
        ConstraintWidget r33 = ((Reference) r31).getConstraintWidget();
    L59:
        r29.add(r33);
        goto L55
    L58:
        r33 = r32.getConstraintWidget();
        goto L59
    L64:
        r27.apply();
        goto L46
    L65:
        Iterator<Object> r34 = this.mReferences.keySet().iterator();
    L67:
        if (r34.hasNext() == false) goto L72;
        Object r35 = r34.next();
        Reference r36 = this.mReferences.get(r35);
        r36.apply();
        ConstraintWidget r37 = r36.getConstraintWidget();
        if (r37 == null) goto L67;
        if (r35 == null) goto L67;
        r37.stringId = r35.toString();
        goto L67
    }

    public BarrierReference barrier(Object r10, Direction r11) {
        ConstraintReference r12 = constraints(r10);
        if (r12.getFacade() != null) goto L5;
    L6:
        BarrierReference r13 = new BarrierReference(this);
        r13.setBarrierDirection(r11);
        r12.setFacade(r13);
    L8:
        return (BarrierReference) r12.getFacade();
    L5:
        if ((r12.getFacade() instanceof BarrierReference) == true) goto L8;
        goto L6
    }

    public AlignHorizontallyReference centerHorizontally(Object... r10) {
        AlignHorizontallyReference r11 = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        r11.add(r10);
        return r11;
    }

    public AlignVerticallyReference centerVertically(Object... r10) {
        AlignVerticallyReference r11 = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        r11.add(r10);
        return r11;
    }

    public ConstraintReference constraints(Object r10) {
        Reference r11 = this.mReferences.get(r10);
        if (r11 != null) goto L6;
        r11 = createConstraintReference(r10);
        this.mReferences.put(r10, r11);
        r11.setKey(r10);
    L6:
        if ((r11 instanceof ConstraintReference) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) r11;
    }

    public int convertDimension(Object r10) {
        if ((r10 instanceof Float) == false) goto L7;
        return ((Float) r10).intValue();
    L7:
        if ((r10 instanceof Integer) == true) goto L9;
        return 0;
    L9:
        return ((Integer) r10).intValue();
    }

    public ConstraintReference createConstraintReference(Object r10) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        Iterator<Object> r10 = this.mReferences.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r11 = r10.next();
        ConstraintReference r12 = constraints(r11);
        if ((r12 instanceof ConstraintReference) == false) goto L4;
        r12.setView(r11);
        goto L4
    }

    public ArrayList<String> getIdsForTag(String r10) {
        if (this.mTags.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return this.mTags.get(r10);
    }

    public GuidelineReference guideline(Object r10, int r11) {
        ConstraintReference r12 = constraints(r10);
        if (r12.getFacade() != null) goto L5;
    L6:
        GuidelineReference r13 = new GuidelineReference(this);
        r13.setOrientation(r11);
        r13.setKey(r10);
        r12.setFacade(r13);
    L8:
        return (GuidelineReference) r12.getFacade();
    L5:
        if ((r12.getFacade() instanceof GuidelineReference) == true) goto L8;
        goto L6
    }

    public State height(Dimension r10) {
        return setHeight(r10);
    }

    public HelperReference helper(Object r10, Helper r11) {
        if (r10 != null) goto L4;
        r10 = createHelperKey();
    L4:
        HelperReference r12 = this.mHelperReferences.get(r10);
        if (r12 != null) goto L24;
        int r13 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Helper[r11.ordinal()];
        if (r13 != 1) goto L9;
        HelperReference r14 = new HorizontalChainReference(this);
    L22:
        r12 = r14;
    L23:
        r12.setKey(r10);
        this.mHelperReferences.put(r10, r12);
        goto L24
    L9:
        if (r13 != 2) goto L11;
        r14 = new VerticalChainReference(this);
        goto L22
    L11:
        if (r13 != 3) goto L13;
        r14 = new AlignHorizontallyReference(this);
        goto L22
    L13:
        if (r13 != 4) goto L15;
        r14 = new AlignVerticallyReference(this);
        goto L22
    L15:
        if (r13 == 5) goto L17;
        r12 = new HelperReference(this, r11);
        goto L23
    L17:
        r14 = new BarrierReference(this);
    L24:
        return r12;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public HorizontalChainReference horizontalChain(Object... r10) {
        HorizontalChainReference r11 = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        r11.add(r10);
        return r11;
    }

    public GuidelineReference horizontalGuideline(Object r10) {
        return guideline(r10, 0);
    }

    public void map(Object r10, Object r11) {
        ConstraintReference r12 = constraints(r10);
        if ((r12 instanceof ConstraintReference) == false) goto L6;
        r12.setView(r11);
        return;
    }

    Reference reference(Object r10) {
        return this.mReferences.get(r10);
    }

    public void reset() {
        this.mHelperReferences.clear();
        this.mTags.clear();
    }

    public boolean sameFixedHeight(int r10) {
        return this.mParent.getHeight().equalsFixedValue(r10);
    }

    public boolean sameFixedWidth(int r10) {
        return this.mParent.getWidth().equalsFixedValue(r10);
    }

    public State setHeight(Dimension r10) {
        this.mParent.setHeight(r10);
        return this;
    }

    public void setTag(String r10, String r11) {
        ConstraintReference r12 = constraints(r10);
        if ((r12 instanceof ConstraintReference) == false) goto L10;
        r12.setTag(r11);
        if (this.mTags.containsKey(r11) == true) goto L7;
        ArrayList<String> r13 = new ArrayList();
        this.mTags.put(r11, r13);
    L8:
        r13.add(r10);
        return;
    L7:
        r13 = this.mTags.get(r11);
        goto L8
    }

    public State setWidth(Dimension r10) {
        this.mParent.setWidth(r10);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public VerticalChainReference verticalChain(Object... r10) {
        VerticalChainReference r11 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r11.add(r10);
        return r11;
    }

    public GuidelineReference verticalGuideline(Object r10) {
        return guideline(r10, 1);
    }

    public State width(Dimension r10) {
        return setWidth(r10);
    }
}

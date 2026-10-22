package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    DimensionDependency dimension;
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    protected RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    boolean resolved;
    RunGroup runGroup;
    public DependencyNode start;
    ConstraintWidget widget;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r10 = new RunType("NONE", 0);
            NONE = r10;
            RunType r11 = new RunType("START", 1);
            START = r11;
            RunType r12 = new RunType("END", 2);
            END = r12;
            RunType r13 = new RunType("CENTER", 3);
            CENTER = r13;
            $VALUES = new RunType[]{r10, r11, r12, r13};
        }

        private RunType(String r10, int r11) {
            super(r10, r11);
        }

        public static RunType valueOf(String r10) {
            return (RunType) Enum.valueOf(RunType.class, r10);
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }
    }

    public WidgetRun(ConstraintWidget r10) {
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = r10;
    }

    private void resolveDimension(int r10, int r11) {
        int r12 = this.matchConstraintsType;
        if (r12 != 0) goto L5;
    L43:
        this.dimension.resolve(getLimitedDimension(r11, r10));
        return;
    L5:
        if (r12 != 1) goto L7;
        int r13 = getLimitedDimension(this.dimension.wrapValue, r10);
        DimensionDependency r14 = this.dimension;
        int r15 = Math.min(r13, r11);
    L42:
        r14.resolve(r15);
        return;
    L7:
        if (r12 != 2) goto L9;
        ConstraintWidget r16 = this.widget.getParent();
        if (r16 == null) goto L46;
        if (r10 != 0) goto L33;
        WidgetRun r17 = r16.horizontalRun;
    L34:
        DimensionDependency r18 = r17.dimension;
        if (r18.resolved == false) goto L47;
        ConstraintWidget r19 = this.widget;
        if (r10 != 0) goto L39;
        float r20 = r19.mMatchConstraintPercentWidth;
    L40:
        r11 = (int) ((r18.value * r20) + 0.5f);
        goto L43
    L39:
        r20 = r19.mMatchConstraintPercentHeight;
        goto L40
    L47:
        return;
    L33:
        r17 = r16.verticalRun;
        goto L34
    L46:
        return;
    L9:
        if (r12 != 3) goto L49;
        ConstraintWidget r21 = this.widget;
        WidgetRun r22 = r21.horizontalRun;
        ConstraintWidget.DimensionBehaviour r23 = r22.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r24 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r23 == r24) goto L14;
    L20:
        if (r10 != 0) goto L23;
        r22 = r21.verticalRun;
    L23:
        if (r22.dimension.resolved == false) goto L45;
        float r25 = r21.getDimensionRatio();
        if (r10 != 1) goto L27;
        r15 = (int) ((r22.dimension.value / r25) + 0.5f);
    L28:
        r14 = this.dimension;
        goto L42
    L27:
        r15 = (int) ((r25 * r22.dimension.value) + 0.5f);
        goto L28
    L45:
        return;
    L14:
        if (r22.matchConstraintsType != 3) goto L20;
        VerticalWidgetRun r26 = r21.verticalRun;
        if (r26.dimensionBehavior != r24) goto L20;
        if (r26.matchConstraintsType != 3) goto L20;
        return;
    }

    protected final void addTarget(DependencyNode r10, DependencyNode r11, int r12) {
        r10.targets.add(r11);
        r10.margin = r12;
        r11.dependencies.add(r10);
    }

    protected final void addTarget(DependencyNode r10, DependencyNode r11, int r12, DimensionDependency r13) {
        r10.targets.add(r11);
        r10.targets.add(this.dimension);
        r10.marginFactor = r12;
        r10.marginDependency = r13;
        r11.dependencies.add(r10);
        r13.dependencies.add(r10);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    protected final int getLimitedDimension(int r10, int r11) {
        ConstraintWidget r12 = this.widget;
        if (r11 != 0) goto L9;
        int r13 = r12.mMatchConstraintMaxWidth;
        int r14 = Math.max(r12.mMatchConstraintMinWidth, r10);
        if (r13 <= 0) goto L7;
        r14 = Math.min(r13, r10);
    L7:
        if (r14 != r10) goto L14;
        return r10;
    L14:
        return r14;
    L9:
        int r15 = r12.mMatchConstraintMaxHeight;
        r14 = Math.max(r12.mMatchConstraintMinHeight, r10);
        if (r15 <= 0) goto L12;
        r14 = Math.min(r15, r10);
    L12:
        if (r14 != r10) goto L14;
        return r10;
    }

    protected final DependencyNode getTarget(ConstraintAnchor r10) {
        ConstraintAnchor r11 = r10.mTarget;
        if (r11 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r12 = r11.mOwner;
        ConstraintAnchor.Type r13 = r11.mType;
        int r14 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r13.ordinal()];
        if (r14 != 1) goto L8;
        WidgetRun r15 = r12.horizontalRun;
    L23:
        return r15.start;
    L8:
        if (r14 != 2) goto L10;
        WidgetRun r16 = r12.horizontalRun;
    L25:
        return r16.end;
    L10:
        if (r14 != 3) goto L12;
        r15 = r12.verticalRun;
        goto L23
    L12:
        if (r14 == 4) goto L24;
        if (r14 != 5) goto L26;
        r16 = r12.verticalRun;
        goto L25
    L26:
        return null;
    L24:
        return r12.verticalRun.baseline;
    }

    protected final DependencyNode getTarget(ConstraintAnchor r10, int r11) {
        ConstraintAnchor r12 = r10.mTarget;
        if (r12 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r13 = r12.mOwner;
        if (r11 != 0) goto L8;
        WidgetRun r14 = r13.horizontalRun;
    L9:
        ConstraintAnchor.Type r15 = r12.mType;
        int r16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r15.ordinal()];
        if (r16 == 1) goto L20;
        if (r16 == 2) goto L21;
        if (r16 == 3) goto L20;
        if (r16 == 5) goto L21;
        return null;
    L21:
        return r14.end;
    L20:
        return r14.start;
    L8:
        r14 = r13.verticalRun;
        goto L9
    }

    public long getWrapDimension() {
        DimensionDependency r10 = this.dimension;
        if (r10.resolved == true) goto L5;
        return 0;
    L5:
        return r10.value;
    }

    public boolean isCenterConnection() {
        int r10 = this.start.targets.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (this.start.targets.get(r11).run == this) goto L7;
        r12 = r12 + 1;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        int r13 = this.end.targets.size();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L15;
        if (this.end.targets.get(r14).run == this) goto L13;
        r12 = r12 + 1;
    L13:
        r14 = r14 + 1;
        goto L9
    L15:
        if (r12 < 2) goto L24;
        return true;
    L24:
        return false;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    abstract void reset();

    abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
    }

    protected void updateRunCenter(Dependency r10, ConstraintAnchor r11, ConstraintAnchor r12, int r13) {
        DependencyNode r14 = getTarget(r11);
        DependencyNode r15 = getTarget(r12);
        if (r14.resolved == true) goto L5;
        return;
    L5:
        if (r15.resolved == false) goto L29;
        int r16 = r14.value + r11.getMargin();
        int r17 = r15.value - r12.getMargin();
        int r18 = r17 - r16;
        if (this.dimension.resolved == false) goto L10;
    L12:
        DimensionDependency r19 = this.dimension;
        if (r19.resolved == true) goto L16;
        return;
    L16:
        if (r19.value != r18) goto L19;
        this.start.resolve(r16);
        this.end.resolve(r17);
        return;
    L19:
        ConstraintWidget r20 = this.widget;
        if (r13 != 0) goto L22;
        float r21 = r20.getHorizontalBiasPercent();
    L24:
        if (r14 != r15) goto L26;
        r16 = r14.value;
        r17 = r15.value;
        r21 = 0.5f;
    L26:
        this.start.resolve((int) ((r16 + 0.5f) + (((r17 - r16) - this.dimension.value) * r21)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L22:
        r21 = r20.getVerticalBiasPercent();
        goto L24
    L10:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        resolveDimension(r13, r18);
        goto L12
    }

    protected void updateRunEnd(Dependency r10) {
    }

    protected void updateRunStart(Dependency r10) {
    }

    public long wrapSize(int r10) {
        DimensionDependency r11 = this.dimension;
        if (r11.resolved == false) goto L12;
        long r12 = r11.value;
        if (isCenterConnection() == false) goto L8;
        long r13 = this.start.margin - this.end.margin;
    L14:
        return r12 + r13;
    L8:
        if (r10 != 0) goto L11;
        r13 = this.start.margin;
        goto L14
    L11:
        return r12 - ((long) this.end.margin);
    L12:
        return 0;
    }
}

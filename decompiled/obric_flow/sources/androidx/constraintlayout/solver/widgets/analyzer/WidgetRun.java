package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

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

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r5 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r5;
            r5[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r5 = new RunType("NONE", 0);
            NONE = r5;
            RunType r10 = new RunType("START", 1);
            START = r10;
            RunType r11 = new RunType("END", 2);
            END = r11;
            RunType r12 = new RunType("CENTER", 3);
            CENTER = r12;
            $VALUES = new RunType[]{r5, r10, r11, r12};
        }

        private RunType(String r5, int r10) {
            super(r5, r10);
        }

        public static RunType valueOf(String r5) {
            return (RunType) Enum.valueOf(RunType.class, r5);
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }
    }

    public WidgetRun(ConstraintWidget r5) {
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = r5;
    }

    private void resolveDimension(int r10, int r11) {
        int r5 = this.matchConstraintsType;
        if (r5 != 0) goto L5;
        this.dimension.resolve(getLimitedDimension(r11, r10));
        return;
    L5:
        if (r5 != 1) goto L7;
        this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, r10), r11));
        return;
    L7:
        if (r5 != 2) goto L9;
        ConstraintWidget r12 = this.widget.getParent();
        if (r12 == null) goto L46;
        if (r10 != 0) goto L33;
        WidgetRun r13 = r12.horizontalRun;
    L34:
        DimensionDependency r14 = r13.dimension;
        if (r14.resolved == false) goto L47;
        ConstraintWidget r15 = this.widget;
        if (r10 != 0) goto L39;
        float r16 = r15.mMatchConstraintPercentWidth;
    L40:
        this.dimension.resolve(getLimitedDimension((int) ((r14.value * r16) + 0.5f), r10));
        return;
    L39:
        r16 = r15.mMatchConstraintPercentHeight;
        goto L40
    L47:
        return;
    L33:
        r13 = r12.verticalRun;
        goto L34
    L46:
        return;
    L9:
        if (r5 != 3) goto L50;
        ConstraintWidget r17 = this.widget;
        WidgetRun r18 = r17.horizontalRun;
        ConstraintWidget.DimensionBehaviour r19 = r18.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 == r20) goto L14;
    L20:
        if (r10 != 0) goto L23;
        r18 = r17.verticalRun;
    L23:
        if (r18.dimension.resolved == false) goto L44;
        float r21 = r17.getDimensionRatio();
        if (r10 != 1) goto L27;
        int r22 = (int) ((r18.dimension.value / r21) + 0.5f);
    L28:
        this.dimension.resolve(r22);
        return;
    L27:
        r22 = (int) ((r21 * r18.dimension.value) + 0.5f);
        goto L28
    L44:
        return;
    L14:
        if (r18.matchConstraintsType != 3) goto L20;
        VerticalWidgetRun r23 = r17.verticalRun;
        if (r23.dimensionBehavior != r20) goto L20;
        if (r23.matchConstraintsType != 3) goto L20;
        return;
    }

    public final void addTarget(DependencyNode r5, DependencyNode r10, int r11) {
        r5.targets.add(r10);
        r5.margin = r11;
        r10.dependencies.add(r5);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int r5, int r10) {
        if (r10 != 0) goto L8;
        ConstraintWidget r11 = this.widget;
        int r12 = r11.mMatchConstraintMaxWidth;
        int r13 = Math.max(r11.mMatchConstraintMinWidth, r5);
        if (r12 <= 0) goto L6;
        r13 = Math.min(r12, r5);
    L6:
        if (r13 != r5) goto L13;
        return r5;
    L13:
        return r13;
    L8:
        ConstraintWidget r14 = this.widget;
        int r15 = r14.mMatchConstraintMaxHeight;
        r13 = Math.max(r14.mMatchConstraintMinHeight, r5);
        if (r15 <= 0) goto L11;
        r13 = Math.min(r15, r5);
    L11:
        if (r13 != r5) goto L13;
        return r5;
    }

    public final DependencyNode getTarget(ConstraintAnchor r5) {
        ConstraintAnchor r10 = r5.mTarget;
        if (r10 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r11 = r10.mOwner;
        ConstraintAnchor.Type r12 = r10.mType;
        int r13 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r12.ordinal()];
        if (r13 == 1) goto L21;
        if (r13 == 2) goto L25;
        if (r13 == 3) goto L24;
        if (r13 == 4) goto L23;
        if (r13 == 5) goto L22;
        return null;
    L22:
        return r11.verticalRun.end;
    L23:
        return r11.verticalRun.baseline;
    L24:
        return r11.verticalRun.start;
    L25:
        return r11.horizontalRun.end;
    L21:
        return r11.horizontalRun.start;
    }

    public long getWrapDimension() {
        DimensionDependency r5 = this.dimension;
        if (r5.resolved == true) goto L5;
        return 0;
    L5:
        return r5.value;
    }

    public boolean isCenterConnection() {
        int r5 = this.start.targets.size();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r10 >= r5) goto L8;
        if (this.start.targets.get(r10).run == this) goto L7;
        r11 = r11 + 1;
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        int r12 = this.end.targets.size();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L15;
        if (this.end.targets.get(r13).run == this) goto L13;
        r11 = r11 + 1;
    L13:
        r13 = r13 + 1;
        goto L9
    L15:
        if (r11 < 2) goto L24;
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

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r5) {
    }

    public void updateRunCenter(Dependency r5, ConstraintAnchor r10, ConstraintAnchor r11, int r12) {
        DependencyNode r13 = getTarget(r10);
        DependencyNode r14 = getTarget(r11);
        if (r13.resolved == true) goto L5;
        return;
    L5:
        if (r14.resolved == false) goto L29;
        int r15 = r10.getMargin() + r13.value;
        int r16 = r14.value - r11.getMargin();
        int r17 = r16 - r15;
        if (this.dimension.resolved == false) goto L10;
    L12:
        DimensionDependency r18 = this.dimension;
        if (r18.resolved == true) goto L16;
        return;
    L16:
        if (r18.value != r17) goto L19;
        this.start.resolve(r15);
        this.end.resolve(r16);
        return;
    L19:
        ConstraintWidget r19 = this.widget;
        if (r12 != 0) goto L22;
        float r20 = r19.getHorizontalBiasPercent();
    L24:
        if (r13 != r14) goto L26;
        r15 = r13.value;
        r16 = r14.value;
        r20 = 0.5f;
    L26:
        this.start.resolve((int) ((((r16 - r15) - this.dimension.value) * r20) + (r15 + 0.5f)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L22:
        r20 = r19.getVerticalBiasPercent();
        goto L24
    L10:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        resolveDimension(r12, r17);
        goto L12
    }

    public void updateRunEnd(Dependency r5) {
    }

    public void updateRunStart(Dependency r5) {
    }

    public long wrapSize(int r5) {
        DimensionDependency r10 = this.dimension;
        if (r10.resolved == false) goto L12;
        long r11 = r10.value;
        if (isCenterConnection() == false) goto L8;
        long r12 = this.start.margin - this.end.margin;
    L14:
        return r11 + r12;
    L8:
        if (r5 != 0) goto L11;
        r12 = this.start.margin;
        goto L14
    L11:
        return r11 - ((long) this.end.margin);
    L12:
        return 0;
    }

    public final void addTarget(DependencyNode r5, DependencyNode r10, int r11, DimensionDependency r12) {
        r5.targets.add(r10);
        r5.targets.add(this.dimension);
        r5.marginFactor = r11;
        r5.marginDependency = r12;
        r10.dependencies.add(r5);
        r12.dependencies.add(r5);
    }

    public final DependencyNode getTarget(ConstraintAnchor r5, int r10) {
        ConstraintAnchor r11 = r5.mTarget;
        if (r11 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r12 = r11.mOwner;
        if (r10 != 0) goto L8;
        WidgetRun r13 = r12.horizontalRun;
    L9:
        ConstraintAnchor.Type r14 = r11.mType;
        int r15 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r14.ordinal()];
        if (r15 == 1) goto L20;
        if (r15 == 2) goto L21;
        if (r15 == 3) goto L20;
        if (r15 == 5) goto L21;
        return null;
    L21:
        return r13.end;
    L20:
        return r13.start;
    L8:
        r13 = r12.verticalRun;
        goto L9
    }
}

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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
            RunType r0 = new RunType("NONE", 0);
            NONE = r0;
            RunType r1 = new RunType("START", 1);
            START = r1;
            RunType r3 = new RunType("END", 2);
            END = r3;
            RunType r5 = new RunType("CENTER", 3);
            CENTER = r5;
            $VALUES = new RunType[]{r0, r1, r3, r5};
        }

        private RunType(String r1, int r2) {
            super(r1, r2);
        }

        public static RunType valueOf(String r2) {
            return (RunType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RunType.class, r2), RunType.class, "com.obric.memorydata.plugin");
        }

        public static RunType[] values() {
            return (RunType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RunType[].class, "com.obric.memorydata.plugin");
        }
    }

    public WidgetRun(ConstraintWidget r2) {
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = r2;
    }

    private void resolveDimension(int r5, int r6) {
        int r0 = this.matchConstraintsType;
        if (r0 != 0) goto L5;
    L45:
        this.dimension.resolve(getLimitedDimension(r6, r5));
        return;
    L5:
        if (r0 != 1) goto L7;
        int r7 = getLimitedDimension(this.dimension.wrapValue, r5);
        DimensionDependency r4 = this.dimension;
        int r8 = Math.min(r7, r6);
    L44:
        r4.resolve(r8);
        return;
    L7:
        if (r0 != 2) goto L9;
        ConstraintWidget r9 = this.widget.getParent();
        if (r9 == null) goto L48;
        if (r5 != 0) goto L35;
        WidgetRun r10 = r9.horizontalRun;
    L37:
        if (r10.dimension.resolved == false) goto L49;
        ConstraintWidget r1 = this.widget;
        if (r5 != 0) goto L41;
        float r2 = r1.mMatchConstraintPercentWidth;
    L42:
        r6 = (int) ((r10.dimension.value * r2) + 0.5f);
        goto L45
    L41:
        r2 = r1.mMatchConstraintPercentHeight;
        goto L42
    L49:
        return;
    L35:
        r10 = r9.verticalRun;
        goto L37
    L48:
        return;
    L9:
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
    L20:
        ConstraintWidget r11 = this.widget;
        if (r5 != 0) goto L23;
        WidgetRun r12 = r11.verticalRun;
    L25:
        if (r12.dimension.resolved == false) goto L47;
        float r3 = this.widget.getDimensionRatio();
        if (r5 != 1) goto L29;
        r8 = (int) ((r12.dimension.value / r3) + 0.5f);
    L30:
        r4 = this.dimension;
        goto L44
    L29:
        r8 = (int) ((r3 * r12.dimension.value) + 0.5f);
        goto L30
    L47:
        return;
    L23:
        r12 = r11.horizontalRun;
        goto L25
    L14:
        if (this.widget.horizontalRun.matchConstraintsType != 3) goto L20;
        if (this.widget.verticalRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L20;
        if (this.widget.verticalRun.matchConstraintsType != 3) goto L20;
    }

    public final void addTarget(DependencyNode r1, DependencyNode r2, int r3) {
        r1.targets.add(r2);
        r1.margin = r3;
        r2.dependencies.add(r1);
    }

    public final void addTarget(DependencyNode r2, DependencyNode r3, int r4, DimensionDependency r5) {
        r2.targets.add(r3);
        r2.targets.add(this.dimension);
        r2.marginFactor = r4;
        r2.marginDependency = r5;
        r3.dependencies.add(r2);
        r5.dependencies.add(r2);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    public final int getLimitedDimension(int r1, int r2) {
        if (r2 != 0) goto L8;
        int r3 = this.widget.mMatchConstraintMaxWidth;
        int r0 = Math.max(this.widget.mMatchConstraintMinWidth, r1);
        if (r3 <= 0) goto L6;
        r0 = Math.min(r3, r1);
    L6:
        if (r0 != r1) goto L13;
        return r1;
    L13:
        return r0;
    L8:
        int r4 = this.widget.mMatchConstraintMaxHeight;
        r0 = Math.max(this.widget.mMatchConstraintMinHeight, r1);
        if (r4 <= 0) goto L11;
        r0 = Math.min(r4, r1);
    L11:
        if (r0 != r1) goto L13;
        return r1;
    }

    public final DependencyNode getTarget(ConstraintAnchor r3) {
        if (r3.mTarget != null) goto L5;
        return null;
    L5:
        ConstraintWidget r2 = r3.mTarget.mOwner;
        ConstraintAnchor.Type r4 = r3.mTarget.mType;
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r2.verticalRun.end;
    L23:
        return r2.verticalRun.baseline;
    L24:
        return r2.verticalRun.start;
    L25:
        return r2.horizontalRun.end;
    L21:
        return r2.horizontalRun.start;
    }

    public final DependencyNode getTarget(ConstraintAnchor r2, int r3) {
        if (r2.mTarget != null) goto L5;
        return null;
    L5:
        ConstraintWidget r1 = r2.mTarget.mOwner;
        if (r3 != 0) goto L8;
        WidgetRun r4 = r1.horizontalRun;
    L9:
        ConstraintAnchor.Type r5 = r2.mTarget.mType;
        int r6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L20;
        if (r6 == 5) goto L21;
        return null;
    L21:
        return r4.end;
    L20:
        return r4.start;
    L8:
        r4 = r1.verticalRun;
        goto L9
    }

    public long getWrapDimension() {
        if (this.dimension.resolved == true) goto L5;
        return 0;
    L5:
        return this.dimension.value;
    }

    public boolean isCenterConnection() {
        int r0 = this.start.targets.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        if (((DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(r2), DependencyNode.class, "com.obric.memorydata.plugin")).run == this) goto L8;
        r3 = r3 + 1;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        int r1 = this.end.targets.size();
        int r4 = 0;
    L10:
        if (r4 >= r1) goto L16;
        if (((DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(r4), DependencyNode.class, "com.obric.memorydata.plugin")).run == this) goto L14;
        r3 = r3 + 1;
    L14:
        r4 = r4 + 1;
        goto L10
    L16:
        if (r3 < 2) goto L25;
        return true;
    L25:
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
    public void update(Dependency r2) {
        Dependency r1 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r2, Dependency.class, "com.obric.memorydata.plugin");
    }

    public void updateRunCenter(Dependency r5, ConstraintAnchor r6, ConstraintAnchor r7, int r8) {
        Dependency r9 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r5, Dependency.class, "com.obric.memorydata.plugin");
        DependencyNode r10 = getTarget(r6);
        DependencyNode r0 = getTarget(r7);
        if (r10.resolved == true) goto L5;
        return;
    L5:
        if (r0.resolved == false) goto L29;
        int r1 = r10.value + r6.getMargin();
        int r11 = r0.value - r7.getMargin();
        int r12 = r11 - r1;
        if (this.dimension.resolved == true) goto L13;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        resolveDimension(r8, r12);
    L13:
        if (this.dimension.resolved == true) goto L16;
        return;
    L16:
        if (this.dimension.value != r12) goto L19;
        this.start.resolve(r1);
        this.end.resolve(r11);
        return;
    L19:
        ConstraintWidget r13 = this.widget;
        if (r8 != 0) goto L22;
        float r14 = r13.getHorizontalBiasPercent();
    L24:
        if (r10 != r0) goto L26;
        r1 = r10.value;
        r11 = r0.value;
        r14 = 0.5f;
    L26:
        this.start.resolve((int) ((r1 + 0.5f) + (((r11 - r1) - this.dimension.value) * r14)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L22:
        r14 = r13.getVerticalBiasPercent();
        goto L24
    }

    public void updateRunEnd(Dependency r2) {
        Dependency r1 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r2, Dependency.class, "com.obric.memorydata.plugin");
    }

    public void updateRunStart(Dependency r2) {
        Dependency r1 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r2, Dependency.class, "com.obric.memorydata.plugin");
    }

    public long wrapSize(int r4) {
        if (this.dimension.resolved == false) goto L12;
        long r0 = this.dimension.value;
        if (isCenterConnection() == false) goto L8;
        long r3 = this.start.margin - this.end.margin;
    L14:
        return r0 + r3;
    L8:
        if (r4 != 0) goto L11;
        r3 = this.start.margin;
        goto L14
    L11:
        return r0 - ((long) this.end.margin);
    L12:
        return 0;
    }
}

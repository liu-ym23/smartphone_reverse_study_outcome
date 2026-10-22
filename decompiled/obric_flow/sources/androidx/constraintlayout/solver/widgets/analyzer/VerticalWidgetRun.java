package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r5 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = r5;
            r5[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public VerticalWidgetRun(ConstraintWidget r5) {
        super(r5);
        DependencyNode r10 = new DependencyNode(this);
        this.baseline = r10;
        this.baselineDimension = null;
        DependencyNode r11 = this.start;
        r11.type = DependencyNode.Type.TOP;
        DependencyNode r12 = this.end;
        r12.type = DependencyNode.Type.BOTTOM;
        r10.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r5 = this.widget;
        if (r5.measured == false) goto L6;
        this.dimension.resolve(r5.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L10;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L10:
        ConstraintWidget.DimensionBehaviour r10 = this.dimensionBehavior;
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        DimensionDependency r11 = this.dimension;
        boolean r12 = r11.resolved;
        if (r12 == false) goto L80;
        ConstraintWidget r13 = this.widget;
        if (r13.measured == false) goto L80;
        ConstraintAnchor[] r14 = r13.mListAnchors;
        ConstraintAnchor r15 = r14[2];
        ConstraintAnchor r16 = r15.mTarget;
        if (r16 != null) goto L38;
    L52:
        if (r16 == null) goto L58;
        DependencyNode r17 = getTarget(r15);
        if (r17 == null) goto L155;
        addTarget(this.start, r17, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L156;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L156:
        return;
    L155:
        return;
    L58:
        ConstraintAnchor r18 = r14[3];
        if (r18.mTarget == null) goto L66;
        DependencyNode r19 = getTarget(r18);
        if (r19 == null) goto L64;
        addTarget(this.end, r19, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L64:
        if (this.widget.hasBaseline() == false) goto L158;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L158:
        return;
    L66:
        ConstraintAnchor r20 = r14[4];
        if (r20.mTarget == null) goto L72;
        DependencyNode r21 = getTarget(r20);
        if (r21 == null) goto L160;
        addTarget(this.baseline, r21, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L160:
        return;
    L72:
        if ((r13 instanceof Helper) == false) goto L74;
        return;
    L74:
        if (r13.getParent() != null) goto L76;
        return;
    L76:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L164;
        DependencyNode r22 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r22, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L165;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L165:
        return;
    L164:
        return;
    L38:
        if (r14[3].mTarget == null) goto L52;
        if (r13.isInVerticalChain() == false) goto L42;
        DependencyNode r23 = this.start;
        r23.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r24 = this.end;
        r24.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L153;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L153:
        return;
    L42:
        DependencyNode r25 = getTarget(this.widget.mListAnchors[2]);
        if (r25 == null) goto L45;
        addTarget(this.start, r25, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r26 = getTarget(this.widget.mListAnchors[3]);
        if (r26 == null) goto L48;
        addTarget(this.end, r26, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L80:
        if (r12 == false) goto L82;
    L97:
        r11.addDependency(this);
    L98:
        ConstraintWidget r27 = this.widget;
        ConstraintAnchor[] r28 = r27.mListAnchors;
        ConstraintAnchor r29 = r28[2];
        ConstraintAnchor r30 = r29.mTarget;
        if (r30 == null) goto L110;
        if (r28[3].mTarget == null) goto L110;
        if (r27.isInVerticalChain() == false) goto L105;
        DependencyNode r31 = this.start;
        r31.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r32 = this.end;
        r32.margin = -this.widget.mListAnchors[3].getMargin();
    L107:
        if (this.widget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L150:
        if (this.dimension.targets.size() != 0) goto L167;
        this.dimension.readyToSolve = true;
        return;
    L167:
        return;
    L105:
        DependencyNode r33 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r34 = getTarget(this.widget.mListAnchors[3]);
        r33.addDependency(this);
        r34.addDependency(this);
        this.mRunType = WidgetRun.RunType.CENTER;
    L110:
        if (r30 == null) goto L123;
        DependencyNode r35 = getTarget(r29);
        if (r35 == null) goto L150;
        addTarget(this.start, r35, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L116;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L116:
        ConstraintWidget.DimensionBehaviour r36 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r37 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r36 != r37) goto L150;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L150;
        HorizontalWidgetRun r38 = this.widget.horizontalRun;
        if (r38.dimensionBehavior != r37) goto L150;
        r38.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L150
    L123:
        ConstraintAnchor r39 = r28[3];
        if (r39.mTarget == null) goto L130;
        DependencyNode r40 = getTarget(r39);
        if (r40 == null) goto L150;
        addTarget(this.end, r40, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
        goto L150
    L130:
        ConstraintAnchor r41 = r28[4];
        if (r41.mTarget == null) goto L136;
        DependencyNode r42 = getTarget(r41);
        if (r42 == null) goto L150;
        addTarget(this.baseline, r42, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        addTarget(this.end, this.start, 1, this.dimension);
        goto L150
    L136:
        if ((r27 instanceof Helper) == true) goto L150;
        if (r27.getParent() == null) goto L150;
        DependencyNode r43 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r43, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L142;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L142:
        ConstraintWidget.DimensionBehaviour r44 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r45 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r44 != r45) goto L150;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L150;
        HorizontalWidgetRun r46 = this.widget.horizontalRun;
        if (r46.dimensionBehavior != r45) goto L150;
        r46.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L150
    L82:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r47 = this.widget;
        int r48 = r47.mMatchConstraintDefaultHeight;
        if (r48 == 2) goto L93;
        if (r48 != 3) goto L98;
        if (r47.isInVerticalChain() == true) goto L98;
        ConstraintWidget r49 = this.widget;
        if (r49.mMatchConstraintDefaultWidth == 3) goto L98;
        DimensionDependency r50 = r49.horizontalRun.dimension;
        this.dimension.targets.add(r50);
        r50.dependencies.add(this.dimension);
        DimensionDependency r51 = this.dimension;
        r51.delegateToWidgetRun = true;
        r51.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L93:
        ConstraintWidget r52 = r47.getParent();
        if (r52 == null) goto L98;
        DimensionDependency r53 = r52.verticalRun.dimension;
        this.dimension.targets.add(r53);
        r53.dependencies.add(this.dimension);
        DimensionDependency r54 = this.dimension;
        r54.delegateToWidgetRun = true;
        r54.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L13:
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r55 = this.widget.getParent();
        if (r55 == null) goto L21;
        if (r55.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r56 = (r55.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r55.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r55.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r56);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.dimension.resolve(this.widget.getHeight());
        goto L31
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r57 = this.widget.getParent();
        if (r57 == null) goto L31;
        if (r57.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        addTarget(this.start, r57.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r57.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r5 = this.start;
        if (r5.resolved == false) goto L6;
        this.widget.setY(r5.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultHeight != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r5 == 1) goto L10;
        if (r5 == 2) goto L9;
        if (r5 != 3) goto L11;
        ConstraintWidget r11 = this.widget;
        updateRunCenter(r10, r11.mTop, r11.mBottom, 1);
        return;
    L11:
        DimensionDependency r12 = this.dimension;
        if (r12.readyToSolve == true) goto L14;
    L38:
        DependencyNode r13 = this.start;
        if (r13.readyToSolve == false) goto L86;
        DependencyNode r14 = this.end;
        if (r14.readyToSolve == true) goto L44;
        return;
    L44:
        if (r13.resolved == false) goto L51;
        if (r14.resolved == false) goto L51;
        if (this.dimension.resolved == false) goto L51;
        return;
    L51:
        if (this.dimension.resolved == true) goto L61;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L61;
        ConstraintWidget r15 = this.widget;
        if (r15.mMatchConstraintDefaultWidth != 0) goto L61;
        if (r15.isInVerticalChain() == true) goto L61;
        DependencyNode r16 = this.start.targets.get(0);
        DependencyNode r17 = this.end.targets.get(0);
        int r18 = r16.value;
        DependencyNode r19 = this.start;
        int r20 = r18 + r19.margin;
        int r21 = r17.value + this.end.margin;
        r19.resolve(r20);
        this.end.resolve(r21);
        this.dimension.resolve(r21 - r20);
        return;
    L61:
        if (this.dimension.resolved == true) goto L75;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L75;
        if (this.matchConstraintsType != 1) goto L75;
        if (this.start.targets.size() <= 0) goto L75;
        if (this.end.targets.size() <= 0) goto L75;
        DependencyNode r22 = this.start.targets.get(0);
        DependencyNode r23 = this.end.targets.get(0);
        int r24 = (r23.value + this.end.margin) - (r22.value + this.start.margin);
        DimensionDependency r25 = this.dimension;
        int r26 = r25.wrapValue;
        if (r24 >= r26) goto L73;
        r25.resolve(r24);
        goto L75
    L73:
        r25.resolve(r26);
    L75:
        if (this.dimension.resolved == true) goto L78;
        return;
    L78:
        if (this.start.targets.size() > 0) goto L80;
        return;
    L80:
        if (this.end.targets.size() <= 0) goto L88;
        DependencyNode r27 = this.start.targets.get(0);
        DependencyNode r28 = this.end.targets.get(0);
        int r29 = r27.value + this.start.margin;
        int r30 = r28.value + this.end.margin;
        float r31 = this.widget.getVerticalBiasPercent();
        if (r27 != r28) goto L84;
        r29 = r27.value;
        r30 = r28.value;
        r31 = 0.5f;
    L84:
        float r32 = r29 + 0.5f;
        this.start.resolve((int) ((((r30 - r29) - this.dimension.value) * r31) + r32));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L88:
        return;
    L86:
        return;
    L14:
        if (r12.resolved == true) goto L38;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        ConstraintWidget r33 = this.widget;
        int r34 = r33.mMatchConstraintDefaultHeight;
        if (r34 == 2) goto L33;
        if (r34 != 3) goto L38;
        if (r33.horizontalRun.dimension.resolved == false) goto L38;
        int r35 = r33.getDimensionRatioSide();
        if (r35 == (-1)) goto L31;
        if (r35 == 0) goto L30;
        if (r35 == 1) goto L28;
        int r36 = 0;
    L32:
        this.dimension.resolve(r36);
        goto L38
    L28:
        ConstraintWidget r37 = this.widget;
        float r38 = r37.horizontalRun.dimension.value;
        float r39 = r37.getDimensionRatio();
    L29:
        r36 = (int) ((r38 / r39) + 0.5f);
        goto L32
    L30:
        ConstraintWidget r40 = this.widget;
        r36 = (int) ((r40.getDimensionRatio() * r40.horizontalRun.dimension.value) + 0.5f);
        goto L32
    L31:
        ConstraintWidget r41 = this.widget;
        r38 = r41.horizontalRun.dimension.value;
        r39 = r41.getDimensionRatio();
        goto L29
    L33:
        ConstraintWidget r42 = r33.getParent();
        if (r42 == null) goto L38;
        DimensionDependency r43 = r42.verticalRun.dimension;
        if (r43.resolved == false) goto L38;
        this.dimension.resolve((int) ((r43.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
        goto L38
    L9:
        updateRunEnd(r10);
        goto L11
    L10:
        updateRunStart(r10);
        goto L11
    }
}

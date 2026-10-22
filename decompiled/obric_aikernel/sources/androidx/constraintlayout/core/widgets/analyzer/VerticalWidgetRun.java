package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r10 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r10;
            r10[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public VerticalWidgetRun(ConstraintWidget r10) {
        super(r10);
        DependencyNode r11 = new DependencyNode(this);
        this.baseline = r11;
        this.baselineDimension = null;
        DependencyNode r12 = this.start;
        r12.type = DependencyNode.Type.TOP;
        DependencyNode r13 = this.end;
        r13.type = DependencyNode.Type.BOTTOM;
        r11.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget r10 = this.widget;
        if (r10.measured == false) goto L6;
        this.dimension.resolve(r10.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L10;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L10:
        ConstraintWidget.DimensionBehaviour r11 = this.dimensionBehavior;
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        DimensionDependency r12 = this.dimension;
        boolean r13 = r12.resolved;
        if (r13 == false) goto L82;
        ConstraintWidget r14 = this.widget;
        if (r14.measured == false) goto L82;
        ConstraintAnchor[] r15 = r14.mListAnchors;
        if (r15[2].mTarget == null) goto L54;
        if (r15[3].mTarget == null) goto L54;
        if (r14.isInVerticalChain() == false) goto L42;
        DependencyNode r16 = this.start;
        r16.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r17 = this.end;
        r17.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L162;
    L51:
        DependencyNode r18 = this.baseline;
        DependencyNode r19 = this.start;
        int r20 = this.widget.getBaselineDistance();
    L52:
        addTarget(r18, r19, r20);
        return;
    L162:
        return;
    L42:
        DependencyNode r21 = getTarget(this.widget.mListAnchors[2]);
        if (r21 == null) goto L45;
        addTarget(this.start, r21, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r22 = getTarget(this.widget.mListAnchors[3]);
        if (r22 == null) goto L48;
        addTarget(this.end, r22, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L54:
        if (r15[2].mTarget == null) goto L61;
        DependencyNode r23 = getTarget(r15[2]);
        if (r23 == null) goto L164;
        addTarget(this.start, r23, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L164:
        return;
    L61:
        if (r15[3].mTarget == null) goto L69;
        DependencyNode r24 = getTarget(r15[3]);
        if (r24 == null) goto L66;
        addTarget(this.end, r24, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L66:
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L69:
        if (r15[4].mTarget == null) goto L74;
        DependencyNode r25 = getTarget(r15[4]);
        if (r25 == null) goto L167;
        addTarget(this.baseline, r25, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        r18 = this.end;
        r19 = this.start;
        r20 = this.dimension.value;
        goto L52
    L167:
        return;
    L74:
        if ((r14 instanceof Helper) == false) goto L76;
        return;
    L76:
        if (r14.getParent() != null) goto L78;
        return;
    L78:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L170;
        DependencyNode r26 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r26, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L170:
        return;
    L82:
        if (r13 == false) goto L84;
    L100:
        r12.addDependency(this);
    L101:
        ConstraintWidget r27 = this.widget;
        ConstraintAnchor[] r28 = r27.mListAnchors;
        if (r28[2].mTarget == null) goto L119;
        if (r28[3].mTarget == null) goto L119;
        if (r27.isInVerticalChain() == false) goto L108;
        DependencyNode r29 = this.start;
        r29.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r30 = this.end;
        r30.margin = -this.widget.mListAnchors[3].getMargin();
    L115:
        if (this.widget.hasBaseline() == false) goto L159;
    L116:
        DependencyNode r31 = this.baseline;
        DependencyNode r32 = this.start;
        DimensionDependency r33 = this.baselineDimension;
    L117:
        addTarget(r31, r32, 1, r33);
    L159:
        if (this.dimension.targets.size() != 0) goto L172;
        this.dimension.readyToSolve = true;
        return;
    L172:
        return;
    L108:
        DependencyNode r34 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r35 = getTarget(this.widget.mListAnchors[3]);
        if (r34 == null) goto L111;
        r34.addDependency(this);
    L111:
        if (r35 == null) goto L113;
        r35.addDependency(this);
    L113:
        this.mRunType = WidgetRun.RunType.CENTER;
    L119:
        if (r28[2].mTarget == null) goto L133;
        DependencyNode r36 = getTarget(r28[2]);
        if (r36 == null) goto L159;
        addTarget(this.start, r36, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L125;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L125:
        ConstraintWidget.DimensionBehaviour r37 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r38 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r37 != r38) goto L159;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L159;
        HorizontalWidgetRun r39 = this.widget.horizontalRun;
        if (r39.dimensionBehavior != r38) goto L159;
    L157:
        r39.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L159
    L133:
        if (r28[3].mTarget == null) goto L140;
        DependencyNode r40 = getTarget(r28[3]);
        if (r40 == null) goto L159;
        addTarget(this.end, r40, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L159;
    L140:
        if (r28[4].mTarget == null) goto L145;
        DependencyNode r41 = getTarget(r28[4]);
        if (r41 == null) goto L159;
        addTarget(this.baseline, r41, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        r31 = this.end;
        r32 = this.start;
        r33 = this.dimension;
        goto L117
    L145:
        if ((r27 instanceof Helper) == true) goto L159;
        if (r27.getParent() == null) goto L159;
        DependencyNode r42 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r42, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L151;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L151:
        ConstraintWidget.DimensionBehaviour r43 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r44 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r43 != r44) goto L159;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L159;
        r39 = this.widget.horizontalRun;
        if (r39.dimensionBehavior != r44) goto L159;
    L84:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L100;
        ConstraintWidget r45 = this.widget;
        int r46 = r45.mMatchConstraintDefaultHeight;
        if (r46 == 2) goto L95;
        if (r46 != 3) goto L101;
        if (r45.isInVerticalChain() == true) goto L101;
        ConstraintWidget r47 = this.widget;
        if (r47.mMatchConstraintDefaultWidth == 3) goto L101;
        WidgetRun r48 = r47.horizontalRun;
    L99:
        DimensionDependency r49 = r48.dimension;
        this.dimension.targets.add(r49);
        r49.dependencies.add(this.dimension);
        DimensionDependency r50 = this.dimension;
        r50.delegateToWidgetRun = true;
        r50.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L101
    L95:
        ConstraintWidget r51 = r45.getParent();
        if (r51 == null) goto L101;
        r48 = r51.verticalRun;
        goto L99
    L13:
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r52 = this.widget.getParent();
        if (r52 == null) goto L21;
        if (r52.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r53 = (r52.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r52.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r52.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r53);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.dimension.resolve(this.widget.getHeight());
        goto L31
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r54 = this.widget.getParent();
        if (r54 == null) goto L31;
        if (r54.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        addTarget(this.start, r54.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r54.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r10 = this.start;
        if (r10.resolved == false) goto L6;
        this.widget.setY(r10.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
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

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        int r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 == 2) goto L9;
        if (r11 != 3) goto L11;
        ConstraintWidget r12 = this.widget;
        updateRunCenter(r10, r12.mTop, r12.mBottom, 1);
        return;
    L11:
        DimensionDependency r13 = this.dimension;
        if (r13.readyToSolve == true) goto L14;
    L37:
        DependencyNode r14 = this.start;
        if (r14.readyToSolve == false) goto L85;
        DependencyNode r15 = this.end;
        if (r15.readyToSolve == true) goto L43;
        return;
    L43:
        if (r14.resolved == false) goto L50;
        if (r15.resolved == false) goto L50;
        if (this.dimension.resolved == false) goto L50;
        return;
    L50:
        if (this.dimension.resolved == true) goto L60;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L60;
        ConstraintWidget r16 = this.widget;
        if (r16.mMatchConstraintDefaultWidth != 0) goto L60;
        if (r16.isInVerticalChain() == true) goto L60;
        DependencyNode r17 = this.start.targets.get(0);
        DependencyNode r18 = this.end.targets.get(0);
        int r19 = r17.value;
        DependencyNode r20 = this.start;
        int r21 = r19 + r20.margin;
        int r22 = r18.value + this.end.margin;
        r20.resolve(r21);
        this.end.resolve(r22);
        this.dimension.resolve(r22 - r21);
        return;
    L60:
        if (this.dimension.resolved == true) goto L74;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L74;
        if (this.matchConstraintsType != 1) goto L74;
        if (this.start.targets.size() <= 0) goto L74;
        if (this.end.targets.size() <= 0) goto L74;
        DependencyNode r23 = this.start.targets.get(0);
        DependencyNode r24 = this.end.targets.get(0);
        int r25 = (r24.value + this.end.margin) - (r23.value + this.start.margin);
        DimensionDependency r26 = this.dimension;
        int r27 = r26.wrapValue;
        if (r25 >= r27) goto L72;
        r26.resolve(r25);
        goto L74
    L72:
        r26.resolve(r27);
    L74:
        if (this.dimension.resolved == true) goto L77;
        return;
    L77:
        if (this.start.targets.size() > 0) goto L79;
        return;
    L79:
        if (this.end.targets.size() <= 0) goto L87;
        DependencyNode r28 = this.start.targets.get(0);
        DependencyNode r29 = this.end.targets.get(0);
        int r30 = r28.value + this.start.margin;
        int r31 = r29.value + this.end.margin;
        float r32 = this.widget.getVerticalBiasPercent();
        if (r28 != r29) goto L83;
        r30 = r28.value;
        r31 = r29.value;
        r32 = 0.5f;
    L83:
        this.start.resolve((int) ((r30 + 0.5f) + (((r31 - r30) - this.dimension.value) * r32)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L87:
        return;
    L85:
        return;
    L14:
        if (r13.resolved == true) goto L37;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        ConstraintWidget r33 = this.widget;
        int r34 = r33.mMatchConstraintDefaultHeight;
        if (r34 == 2) goto L32;
        if (r34 != 3) goto L37;
        if (r33.horizontalRun.dimension.resolved == false) goto L37;
        int r35 = r33.getDimensionRatioSide();
        if (r35 == (-1)) goto L29;
        if (r35 == 0) goto L28;
        if (r35 == 1) goto L29;
        int r36 = 0;
    L31:
        this.dimension.resolve(r36);
        goto L37
    L28:
        ConstraintWidget r37 = this.widget;
        float r38 = r37.horizontalRun.dimension.value * r37.getDimensionRatio();
    L30:
        r36 = (int) (r38 + 0.5f);
    L29:
        ConstraintWidget r39 = this.widget;
        r38 = r39.horizontalRun.dimension.value / r39.getDimensionRatio();
        goto L30
    L32:
        ConstraintWidget r40 = r33.getParent();
        if (r40 == null) goto L37;
        DimensionDependency r41 = r40.verticalRun.dimension;
        if (r41.resolved == false) goto L37;
        r36 = (int) ((r41.value * this.widget.mMatchConstraintPercentHeight) + 0.5f);
        goto L31
    L9:
        updateRunEnd(r10);
        goto L11
    L10:
        updateRunStart(r10);
        goto L11
    }
}

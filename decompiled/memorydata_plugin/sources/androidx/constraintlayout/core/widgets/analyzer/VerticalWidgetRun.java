package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public VerticalWidgetRun(ConstraintWidget r2) {
        super(r2);
        this.baseline = new DependencyNode(this);
        this.baselineDimension = null;
        DependencyNode r3 = this.start;
        r3.type = DependencyNode.Type.TOP;
        DependencyNode r4 = this.end;
        r4.type = DependencyNode.Type.BOTTOM;
        DependencyNode r5 = this.baseline;
        r5.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.widget.measured == false) goto L6;
        this.dimension.resolve(this.widget.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L11;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L11:
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r0 = this.widget.getParent();
        if (r0 == null) goto L21;
        if (r0.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r1 = (r0.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r0.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r0.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r1);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getHeight());
    L32:
        if (this.dimension.resolved == false) goto L83;
        if (this.widget.measured == false) goto L83;
        if (this.widget.mListAnchors[2].mTarget == null) goto L54;
        if (this.widget.mListAnchors[3].mTarget == null) goto L54;
        if (this.widget.isInVerticalChain() == false) goto L42;
        DependencyNode r2 = this.start;
        r2.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r3 = this.end;
        r3.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L163;
    L51:
        DependencyNode r4 = this.baseline;
        DependencyNode r5 = this.start;
        int r6 = this.widget.getBaselineDistance();
    L52:
        addTarget(r4, r5, r6);
        return;
    L163:
        return;
    L42:
        DependencyNode r7 = getTarget(this.widget.mListAnchors[2]);
        if (r7 == null) goto L45;
        addTarget(this.start, r7, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r8 = getTarget(this.widget.mListAnchors[3]);
        if (r8 == null) goto L48;
        addTarget(this.end, r8, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L54:
        if (this.widget.mListAnchors[2].mTarget == null) goto L61;
        DependencyNode r9 = getTarget(this.widget.mListAnchors[2]);
        if (r9 == null) goto L165;
        addTarget(this.start, r9, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L165:
        return;
    L61:
        if (this.widget.mListAnchors[3].mTarget == null) goto L69;
        DependencyNode r10 = getTarget(this.widget.mListAnchors[3]);
        if (r10 == null) goto L66;
        addTarget(this.end, r10, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L66:
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L69:
        if (this.widget.mListAnchors[4].mTarget == null) goto L74;
        DependencyNode r11 = getTarget(this.widget.mListAnchors[4]);
        if (r11 == null) goto L168;
        addTarget(this.baseline, r11, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        r4 = this.end;
        r5 = this.start;
        r6 = this.dimension.value;
        goto L52
    L168:
        return;
    L74:
        if (ZeusTransformUtils.instanceOf(this.widget, Helper.class) == false) goto L76;
        return;
    L76:
        if (this.widget.getParent() != null) goto L78;
        return;
    L78:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L171;
        DependencyNode r12 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r12, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L171:
        return;
    L83:
        if (this.dimension.resolved == false) goto L85;
    L101:
        this.dimension.addDependency(this);
    L103:
        if (this.widget.mListAnchors[2].mTarget == null) goto L120;
        if (this.widget.mListAnchors[3].mTarget == null) goto L120;
        if (this.widget.isInVerticalChain() == false) goto L109;
        DependencyNode r13 = this.start;
        r13.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r14 = this.end;
        r14.margin = -this.widget.mListAnchors[3].getMargin();
    L116:
        if (this.widget.hasBaseline() == false) goto L160;
    L117:
        DependencyNode r15 = this.baseline;
        DependencyNode r16 = this.start;
        DimensionDependency r17 = this.baselineDimension;
    L118:
        addTarget(r15, r16, 1, r17);
    L160:
        if (this.dimension.targets.size() != 0) goto L173;
        this.dimension.readyToSolve = true;
        return;
    L173:
        return;
    L109:
        DependencyNode r18 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r19 = getTarget(this.widget.mListAnchors[3]);
        if (r18 == null) goto L112;
        r18.addDependency(this);
    L112:
        if (r19 == null) goto L114;
        r19.addDependency(this);
    L114:
        this.mRunType = WidgetRun.RunType.CENTER;
    L120:
        if (this.widget.mListAnchors[2].mTarget == null) goto L134;
        DependencyNode r20 = getTarget(this.widget.mListAnchors[2]);
        if (r20 == null) goto L160;
        addTarget(this.start, r20, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L127;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L127:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L160;
        if (this.widget.horizontalRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
    L158:
        this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L160
    L134:
        if (this.widget.mListAnchors[3].mTarget == null) goto L141;
        DependencyNode r21 = getTarget(this.widget.mListAnchors[3]);
        if (r21 == null) goto L160;
        addTarget(this.end, r21, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L160;
    L141:
        if (this.widget.mListAnchors[4].mTarget == null) goto L146;
        DependencyNode r22 = getTarget(this.widget.mListAnchors[4]);
        if (r22 == null) goto L160;
        addTarget(this.baseline, r22, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        r15 = this.end;
        r16 = this.start;
        r17 = this.dimension;
        goto L118
    L146:
        if (ZeusTransformUtils.instanceOf(this.widget, Helper.class) == true) goto L160;
        if (this.widget.getParent() == null) goto L160;
        DependencyNode r23 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r23, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L153;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L153:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L160;
        if (this.widget.horizontalRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
    L85:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L101;
        int r24 = this.widget.mMatchConstraintDefaultHeight;
        if (r24 == 2) goto L96;
        if (r24 != 3) goto L103;
        if (this.widget.isInVerticalChain() == true) goto L103;
        if (this.widget.mMatchConstraintDefaultWidth == 3) goto L103;
        DimensionDependency r25 = this.widget.horizontalRun.dimension;
    L100:
        this.dimension.targets.add(r25);
        r25.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L103
    L96:
        ConstraintWidget r26 = this.widget.getParent();
        if (r26 == null) goto L103;
        r25 = r26.verticalRun.dimension;
        goto L100
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r27 = this.widget.getParent();
        if (r27 == null) goto L32;
        if (r27.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        addTarget(this.start, r27.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r27.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.widget.setY(this.start.value);
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
    public void update(Dependency r8) {
        Dependency r9 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r8, Dependency.class, "com.obric.memorydata.plugin");
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        updateRunCenter(r9, this.widget.mTop, this.widget.mBottom, 1);
        return;
    L12:
        if (this.dimension.readyToSolve == false) goto L38;
        if (this.dimension.resolved == true) goto L38;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        int r10 = this.widget.mMatchConstraintDefaultHeight;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L38;
        if (this.widget.horizontalRun.dimension.resolved == false) goto L38;
        int r11 = this.widget.getDimensionRatioSide();
        if (r11 == (-1)) goto L29;
        if (r11 == 0) goto L28;
        if (r11 == 1) goto L29;
        int r12 = 0;
    L30:
        this.dimension.resolve(r12);
        goto L38
    L28:
        float r13 = this.widget.horizontalRun.dimension.value * this.widget.getDimensionRatio();
    L36:
        r12 = (int) (r13 + 0.5f);
    L29:
        r13 = this.widget.horizontalRun.dimension.value / this.widget.getDimensionRatio();
        goto L36
    L31:
        ConstraintWidget r14 = this.widget.getParent();
        if (r14 == null) goto L38;
        if (r14.verticalRun.dimension.resolved == false) goto L38;
        r13 = r14.verticalRun.dimension.value * this.widget.mMatchConstraintPercentHeight;
    L38:
        if (this.start.readyToSolve == true) goto L40;
        return;
    L40:
        if (this.end.readyToSolve == true) goto L43;
        return;
    L43:
        if (this.start.resolved == false) goto L50;
        if (this.end.resolved == false) goto L50;
        if (this.dimension.resolved == false) goto L50;
        return;
    L50:
        if (this.dimension.resolved == true) goto L60;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L60;
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L60;
        if (this.widget.isInVerticalChain() == true) goto L60;
        DependencyNode r15 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r1 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r16 = r15.value + this.start.margin;
        int r2 = r1.value + this.end.margin;
        this.start.resolve(r16);
        this.end.resolve(r2);
        this.dimension.resolve(r2 - r16);
        return;
    L60:
        if (this.dimension.resolved == true) goto L75;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L75;
        if (this.matchConstraintsType != 1) goto L75;
        if (this.start.targets.size() <= 0) goto L75;
        if (this.end.targets.size() <= 0) goto L75;
        DependencyNode r17 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r4 = (r3.value + this.end.margin) - (r17.value + this.start.margin);
        if (r4 >= this.dimension.wrapValue) goto L72;
        DimensionDependency r18 = this.dimension;
    L73:
        r18.resolve(r4);
        goto L75
    L72:
        r18 = this.dimension;
        r4 = this.dimension.wrapValue;
    L75:
        if (this.dimension.resolved == true) goto L78;
        return;
    L78:
        if (this.start.targets.size() > 0) goto L80;
        return;
    L80:
        if (this.end.targets.size() <= 0) goto L88;
        DependencyNode r19 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r5 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r6 = r19.value + this.start.margin;
        int r7 = r5.value + this.end.margin;
        float r20 = this.widget.getVerticalBiasPercent();
        if (r19 != r5) goto L84;
        r6 = r19.value;
        r7 = r5.value;
        r20 = 0.5f;
    L84:
        this.start.resolve((int) ((r6 + 0.5f) + (((r7 - r6) - this.dimension.value) * r20)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L88:
        return;
    L9:
        updateRunEnd(r9);
        goto L12
    L10:
        updateRunStart(r9);
        goto L12
    }
}

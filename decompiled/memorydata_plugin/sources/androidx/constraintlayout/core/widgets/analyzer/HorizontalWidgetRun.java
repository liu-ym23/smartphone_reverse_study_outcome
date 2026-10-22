package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    static {
        tempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget r2) {
        super(r2);
        DependencyNode r3 = this.start;
        r3.type = DependencyNode.Type.LEFT;
        DependencyNode r4 = this.end;
        r4.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        int r9 = r4 - r3;
        int r10 = r6 - r5;
        if (r8 == (-1)) goto L9;
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L22;
        r2[0] = r9;
        r2[1] = (int) ((r9 * r7) + 0.5f);
        return;
    L22:
        return;
    L8:
        r2[0] = (int) ((r10 * r7) + 0.5f);
        r2[1] = r10;
        return;
    L9:
        int r1 = (int) ((r10 * r7) + 0.5f);
        int r11 = (int) ((r9 / r7) + 0.5f);
        if (r1 > r9) goto L13;
        if (r10 > r10) goto L13;
        r2[0] = r1;
        r2[1] = r10;
        return;
    L13:
        if (r9 > r9) goto L20;
        if (r11 > r10) goto L21;
        r2[0] = r9;
        r2[1] = r11;
        return;
    L21:
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.widget.measured == false) goto L6;
        this.dimension.resolve(this.widget.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L23;
        this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L10;
    L32:
        int r2 = 1;
        if (this.dimension.resolved == false) goto L70;
        if (this.widget.measured == false) goto L70;
        if (this.widget.mListAnchors[0].mTarget == null) goto L51;
        if (this.widget.mListAnchors[1].mTarget == null) goto L51;
        if (this.widget.isInHorizontalChain() == false) goto L43;
        DependencyNode r0 = this.start;
        r0.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r1 = this.end;
        ConstraintAnchor r5 = this.widget.mListAnchors[1];
    L99:
        r1.margin = -r5.getMargin();
        return;
    L43:
        DependencyNode r3 = getTarget(this.widget.mListAnchors[0]);
        if (r3 == null) goto L46;
        addTarget(this.start, r3, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r4 = getTarget(this.widget.mListAnchors[1]);
        if (r4 == null) goto L49;
        addTarget(this.end, r4, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L51:
        if (this.widget.mListAnchors[0].mTarget == null) goto L56;
        DependencyNode r6 = getTarget(this.widget.mListAnchors[0]);
        if (r6 == null) goto L125;
        addTarget(this.start, r6, this.widget.mListAnchors[0].getMargin());
    L67:
        DependencyNode r7 = this.end;
        DependencyNode r8 = this.start;
        int r9 = this.dimension.value;
    L68:
        addTarget(r7, r8, r9);
        return;
    L125:
        return;
    L56:
        if (this.widget.mListAnchors[1].mTarget == null) goto L61;
        DependencyNode r10 = getTarget(this.widget.mListAnchors[1]);
        if (r10 == null) goto L126;
        addTarget(this.end, r10, -this.widget.mListAnchors[1].getMargin());
        r7 = this.start;
        r8 = this.end;
        r9 = -this.dimension.value;
        goto L68
    L126:
        return;
    L61:
        if (ZeusTransformUtils.instanceOf(this.widget, Helper.class) == false) goto L63;
        return;
    L63:
        if (this.widget.getParent() != null) goto L65;
        return;
    L65:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L129;
        DependencyNode r11 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r11, this.widget.getX());
        goto L67
    L129:
        return;
    L70:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L93;
        int r12 = this.widget.mMatchConstraintDefaultWidth;
        if (r12 != 2) goto L74;
        ConstraintWidget r13 = this.widget.getParent();
        if (r13 == null) goto L93;
        DimensionDependency r14 = r13.verticalRun.dimension;
        this.dimension.targets.add(r14);
        r14.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        List<Dependency> r15 = this.dimension.dependencies;
        Dependency r16 = this.end;
    L91:
        r15.add(r16);
        goto L93
    L74:
        if (r12 != 3) goto L93;
        if (this.widget.mMatchConstraintDefaultHeight != 3) goto L85;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        this.widget.verticalRun.start.updateDelegate = this;
        this.widget.verticalRun.end.updateDelegate = this;
        this.dimension.updateDelegate = this;
        if (this.widget.isInVerticalChain() == false) goto L82;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        this.widget.verticalRun.dimension.updateDelegate = this;
        this.dimension.targets.add(this.widget.verticalRun.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        r15 = this.widget.verticalRun.end.dependencies;
    L86:
        r16 = this.dimension;
        goto L91
    L82:
        if (this.widget.isInHorizontalChain() == false) goto L84;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        r15 = this.dimension.dependencies;
        r16 = this.widget.verticalRun.dimension;
        goto L91
    L84:
        r15 = this.widget.verticalRun.dimension.targets;
        goto L86
    L85:
        DimensionDependency r17 = this.widget.verticalRun.dimension;
        this.dimension.targets.add(r17);
        r17.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        r15 = this.end.targets;
    L93:
        if (this.widget.mListAnchors[0].mTarget == null) goto L107;
        if (this.widget.mListAnchors[1].mTarget == null) goto L107;
        if (this.widget.isInHorizontalChain() == false) goto L100;
        DependencyNode r18 = this.start;
        r18.margin = this.widget.mListAnchors[0].getMargin();
        r1 = this.end;
        r5 = this.widget.mListAnchors[1];
        goto L99
    L100:
        DependencyNode r19 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r20 = getTarget(this.widget.mListAnchors[1]);
        if (r19 == null) goto L103;
        r19.addDependency(this);
    L103:
        if (r20 == null) goto L105;
        r20.addDependency(this);
    L105:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L107:
        if (this.widget.mListAnchors[0].mTarget == null) goto L112;
        DependencyNode r21 = getTarget(this.widget.mListAnchors[0]);
        if (r21 == null) goto L133;
        addTarget(this.start, r21, this.widget.mListAnchors[0].getMargin());
    L121:
        DependencyNode r22 = this.end;
        DependencyNode r23 = this.start;
    L122:
        addTarget(r22, r23, r2, this.dimension);
        return;
    L133:
        return;
    L112:
        if (this.widget.mListAnchors[1].mTarget == null) goto L117;
        DependencyNode r24 = getTarget(this.widget.mListAnchors[1]);
        if (r24 == null) goto L134;
        addTarget(this.end, r24, -this.widget.mListAnchors[1].getMargin());
        r22 = this.start;
        r23 = this.end;
        r2 = -1;
        goto L122
    L134:
        return;
    L117:
        if (ZeusTransformUtils.instanceOf(this.widget, Helper.class) == false) goto L119;
        return;
    L119:
        if (this.widget.getParent() == null) goto L136;
        DependencyNode r25 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r25, this.widget.getX());
        goto L121
    L136:
        return;
    L10:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
        ConstraintWidget r26 = this.widget.getParent();
        if (r26 == null) goto L20;
        if (r26.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r27 = (r26.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r26.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r26.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r27);
        return;
    L16:
        if (r26.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getWidth());
        goto L32
    L23:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r28 = this.widget.getParent();
        if (r28 == null) goto L32;
        if (r28.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r28.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r28.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r28.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.widget.setX(this.start.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r18) {
        Dependency r0 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r18, Dependency.class, "com.obric.memorydata.plugin");
        int r1 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L9;
        if (r1 != 3) goto L12;
        updateRunCenter(r0, this.widget.mLeft, this.widget.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == true) goto L136;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L136;
        int r2 = this.widget.mMatchConstraintDefaultWidth;
        if (r2 == 2) goto L129;
        if (r2 != 3) goto L136;
        if (this.widget.mMatchConstraintDefaultHeight != 0) goto L22;
    L32:
        DependencyNode r13 = this.widget.verticalRun.start;
        DependencyNode r14 = this.widget.verticalRun.end;
        if (this.widget.mLeft.mTarget == null) goto L35;
        boolean r3 = true;
    L37:
        if (this.widget.mTop.mTarget == null) goto L39;
        boolean r4 = true;
    L41:
        if (this.widget.mRight.mTarget == null) goto L43;
        boolean r5 = true;
    L45:
        if (this.widget.mBottom.mTarget == null) goto L47;
        boolean r6 = true;
    L48:
        int r15 = this.widget.getDimensionRatioSide();
        if (r3 == false) goto L86;
        if (r4 == false) goto L86;
        if (r5 == false) goto L86;
        if (r6 == false) goto L86;
        float r16 = this.widget.getDimensionRatio();
        if (r13.resolved == false) goto L65;
        if (r14.resolved == false) goto L65;
        if (this.start.readyToSolve == true) goto L60;
        return;
    L60:
        if (this.end.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + this.start.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - this.end.margin, r13.value + r13.margin, r14.value - r14.margin, r16, r15);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L180:
        return;
    L65:
        if (this.start.resolved == false) goto L76;
        if (this.end.resolved == false) goto L76;
        if (r13.readyToSolve == true) goto L71;
        return;
    L71:
        if (r14.readyToSolve == false) goto L181;
        computeInsetRatio(tempDimensions, this.start.value + this.start.margin, this.end.value - this.end.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + r13.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - r14.margin, r16, r15);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L76
    L181:
        return;
    L76:
        if (this.start.readyToSolve == true) goto L78;
        return;
    L78:
        if (this.end.readyToSolve == true) goto L80;
        return;
    L80:
        if (r13.readyToSolve == true) goto L82;
        return;
    L82:
        if (r14.readyToSolve == false) goto L184;
        computeInsetRatio(tempDimensions, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + this.start.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - this.end.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + r13.margin, ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - r14.margin, r16, r15);
        this.dimension.resolve(tempDimensions[0]);
        DimensionDependency r7 = this.widget.verticalRun.dimension;
        int r8 = tempDimensions[1];
    L127:
        r7.resolve(r8);
        goto L136
    L184:
        return;
    L86:
        if (r3 == false) goto L107;
        if (r5 == false) goto L107;
        if (this.start.readyToSolve == true) goto L91;
        return;
    L91:
        if (this.end.readyToSolve == false) goto L185;
        float r9 = this.widget.getDimensionRatio();
        int r10 = ((DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + this.start.margin;
        int r11 = ((DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - this.end.margin;
        if (r15 == (-1)) goto L101;
        if (r15 == 0) goto L101;
        if (r15 != 1) goto L136;
        int r12 = getLimitedDimension(r11 - r10, 0);
        int r17 = (int) ((r12 / r9) + 0.5f);
        int r19 = getLimitedDimension(r17, 1);
        if (r17 == r19) goto L105;
        float r20 = r19 * r9;
    L104:
        r12 = (int) (r20 + 0.5f);
    L105:
        this.dimension.resolve(r12);
        this.widget.verticalRun.dimension.resolve(r19);
    L101:
        r12 = getLimitedDimension(r11 - r10, 0);
        int r21 = (int) ((r12 * r9) + 0.5f);
        r19 = getLimitedDimension(r21, 1);
        if (r21 == r19) goto L105;
        r20 = r19 / r9;
        goto L104
    L185:
        return;
    L107:
        if (r4 == false) goto L136;
        if (r6 == false) goto L136;
        if (r13.readyToSolve == true) goto L112;
        return;
    L112:
        if (r14.readyToSolve == false) goto L186;
        float r22 = this.widget.getDimensionRatio();
        int r23 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r13.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value + r13.margin;
        int r24 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r14.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value - r14.margin;
        if (r15 == (-1)) goto L122;
        if (r15 == 0) goto L119;
        if (r15 == 1) goto L122;
    L119:
        r8 = getLimitedDimension(r24 - r23, 1);
        int r25 = (int) ((r8 * r22) + 0.5f);
        int r26 = getLimitedDimension(r25, 0);
        if (r25 == r26) goto L126;
        float r27 = r26 / r22;
    L125:
        r8 = (int) (r27 + 0.5f);
    L126:
        this.dimension.resolve(r26);
        r7 = this.widget.verticalRun.dimension;
    L122:
        r8 = getLimitedDimension(r24 - r23, 1);
        int r28 = (int) ((r8 / r22) + 0.5f);
        r26 = getLimitedDimension(r28, 0);
        if (r28 == r26) goto L126;
        r27 = r26 * r22;
        goto L125
    L186:
        return;
    L47:
        r6 = false;
        goto L48
    L43:
        r5 = false;
        goto L45
    L39:
        r4 = false;
        goto L41
    L35:
        r3 = false;
        goto L37
    L22:
        if (this.widget.mMatchConstraintDefaultHeight == 3) goto L32;
        int r29 = this.widget.getDimensionRatioSide();
        if (r29 == (-1)) goto L30;
        if (r29 == 0) goto L29;
        if (r29 == 1) goto L30;
        int r30 = 0;
    L31:
        this.dimension.resolve(r30);
        goto L136
    L29:
        float r31 = this.widget.verticalRun.dimension.value / this.widget.getDimensionRatio();
    L134:
        r30 = (int) (r31 + 0.5f);
    L30:
        r31 = this.widget.verticalRun.dimension.value * this.widget.getDimensionRatio();
        goto L134
    L129:
        ConstraintWidget r32 = this.widget.getParent();
        if (r32 == null) goto L136;
        if (r32.horizontalRun.dimension.resolved == false) goto L136;
        r31 = r32.horizontalRun.dimension.value * this.widget.mMatchConstraintPercentWidth;
    L136:
        if (this.start.readyToSolve == true) goto L138;
        return;
    L138:
        if (this.end.readyToSolve == true) goto L141;
        return;
    L141:
        if (this.start.resolved == false) goto L148;
        if (this.end.resolved == false) goto L148;
        if (this.dimension.resolved == false) goto L148;
        return;
    L148:
        if (this.dimension.resolved == true) goto L158;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L158;
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L158;
        if (this.widget.isInHorizontalChain() == true) goto L158;
        DependencyNode r33 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r34 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r35 = r33.value + this.start.margin;
        int r36 = r34.value + this.end.margin;
        this.start.resolve(r35);
        this.end.resolve(r36);
        this.dimension.resolve(r36 - r35);
        return;
    L158:
        if (this.dimension.resolved == true) goto L172;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L172;
        if (this.matchConstraintsType != 1) goto L172;
        if (this.start.targets.size() <= 0) goto L172;
        if (this.end.targets.size() <= 0) goto L172;
        DependencyNode r37 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r38 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r39 = Math.min((r38.value + this.end.margin) - (r37.value + this.start.margin), this.dimension.wrapValue);
        int r40 = this.widget.mMatchConstraintMaxWidth;
        int r41 = Math.max(this.widget.mMatchConstraintMinWidth, r39);
        if (r40 <= 0) goto L170;
        r41 = Math.min(r40, r41);
    L170:
        this.dimension.resolve(r41);
    L172:
        if (this.dimension.resolved == true) goto L174;
        return;
    L174:
        DependencyNode r42 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        DependencyNode r43 = (DependencyNode) ZeusTransformUtils.preCheckCast(this.end.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin");
        int r44 = r42.value + this.start.margin;
        int r45 = r43.value + this.end.margin;
        float r46 = this.widget.getHorizontalBiasPercent();
        if (r42 != r43) goto L177;
        r44 = r42.value;
        r45 = r43.value;
        r46 = 0.5f;
    L177:
        this.start.resolve((int) ((r44 + 0.5f) + (((r45 - r44) - this.dimension.value) * r46)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L9:
        updateRunEnd(r0);
        goto L12
    L10:
        updateRunStart(r0);
        goto L12
    }
}

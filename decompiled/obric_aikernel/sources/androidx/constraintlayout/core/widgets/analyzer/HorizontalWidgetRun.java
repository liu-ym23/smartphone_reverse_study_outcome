package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    static {
        tempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget r10) {
        super(r10);
        DependencyNode r11 = this.start;
        r11.type = DependencyNode.Type.LEFT;
        DependencyNode r12 = this.end;
        r12.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] r10, int r11, int r12, int r13, int r14, float r15, int r16) {
        int r17 = r12 - r11;
        int r18 = r14 - r13;
        if (r16 == (-1)) goto L9;
        if (r16 == 0) goto L8;
        if (r16 != 1) goto L19;
        r10[0] = r17;
        r10[1] = (int) ((r17 * r15) + 0.5f);
        return;
    L19:
        return;
    L8:
        r10[0] = (int) ((r18 * r15) + 0.5f);
        r10[1] = r18;
        return;
    L9:
        int r19 = (int) ((r18 * r15) + 0.5f);
        int r20 = (int) ((r17 / r15) + 0.5f);
        if (r19 > r17) goto L12;
        r10[0] = r19;
        r10[1] = r18;
        return;
    L12:
        if (r20 > r18) goto L18;
        r10[0] = r17;
        r10[1] = r20;
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget r10 = this.widget;
        if (r10.measured == false) goto L6;
        this.dimension.resolve(r10.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L22;
        ConstraintWidget.DimensionBehaviour r11 = this.widget.getHorizontalDimensionBehaviour();
        this.dimensionBehavior = r11;
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget.DimensionBehaviour r12 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r11 != r12) goto L20;
        ConstraintWidget r13 = this.widget.getParent();
        if (r13 == null) goto L20;
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r14 = (r13.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r13.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r13.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r14);
        return;
    L16:
        if (r13.getHorizontalDimensionBehaviour() == r12) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getWidth());
    L32:
        DimensionDependency r15 = this.dimension;
        if (r15.resolved == false) goto L70;
        ConstraintWidget r16 = this.widget;
        if (r16.measured == false) goto L70;
        ConstraintAnchor[] r17 = r16.mListAnchors;
        if (r17[0].mTarget == null) goto L51;
        if (r17[1].mTarget == null) goto L51;
        if (r16.isInHorizontalChain() == false) goto L43;
        DependencyNode r18 = this.start;
        r18.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r19 = this.end;
        ConstraintAnchor r20 = this.widget.mListAnchors[1];
    L100:
        r19.margin = -r20.getMargin();
        return;
    L43:
        DependencyNode r21 = getTarget(this.widget.mListAnchors[0]);
        if (r21 == null) goto L46;
        addTarget(this.start, r21, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r22 = getTarget(this.widget.mListAnchors[1]);
        if (r22 == null) goto L49;
        addTarget(this.end, r22, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L51:
        if (r17[0].mTarget == null) goto L56;
        DependencyNode r23 = getTarget(r17[0]);
        if (r23 == null) goto L125;
        DependencyNode r24 = this.start;
        int r25 = this.widget.mListAnchors[0].getMargin();
    L67:
        addTarget(r24, r23, r25);
        DependencyNode r26 = this.end;
        DependencyNode r27 = this.start;
        int r28 = this.dimension.value;
    L68:
        addTarget(r26, r27, r28);
        return;
    L125:
        return;
    L56:
        if (r17[1].mTarget == null) goto L61;
        DependencyNode r29 = getTarget(r17[1]);
        if (r29 == null) goto L126;
        addTarget(this.end, r29, -this.widget.mListAnchors[1].getMargin());
        r26 = this.start;
        r27 = this.end;
        r28 = -this.dimension.value;
        goto L68
    L126:
        return;
    L61:
        if ((r16 instanceof Helper) == false) goto L63;
        return;
    L63:
        if (r16.getParent() != null) goto L65;
        return;
    L65:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L129;
        r23 = this.widget.getParent().horizontalRun.start;
        r24 = this.start;
        r25 = this.widget.getX();
        goto L67
    L129:
        return;
    L70:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L93;
        ConstraintWidget r30 = this.widget;
        int r31 = r30.mMatchConstraintDefaultWidth;
        if (r31 != 2) goto L74;
        ConstraintWidget r32 = r30.getParent();
        if (r32 == null) goto L93;
        DimensionDependency r33 = r32.verticalRun.dimension;
        this.dimension.targets.add(r33);
        r33.dependencies.add(this.dimension);
        DimensionDependency r34 = this.dimension;
        r34.delegateToWidgetRun = true;
        r34.dependencies.add(this.start);
        List<Dependency> r35 = this.dimension.dependencies;
        Dependency r36 = this.end;
    L92:
        r35.add(r36);
        goto L93
    L74:
        if (r31 != 3) goto L93;
        if (r30.mMatchConstraintDefaultHeight != 3) goto L85;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        VerticalWidgetRun r37 = r30.verticalRun;
        r37.start.updateDelegate = this;
        r37.end.updateDelegate = this;
        r15.updateDelegate = this;
        if (r30.isInVerticalChain() == false) goto L82;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        VerticalWidgetRun r38 = this.widget.verticalRun;
        r38.dimension.updateDelegate = this;
        this.dimension.targets.add(r38.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        r35 = this.widget.verticalRun.end.dependencies;
    L87:
        r36 = this.dimension;
        goto L92
    L82:
        if (this.widget.isInHorizontalChain() == false) goto L84;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        r35 = this.dimension.dependencies;
        r36 = this.widget.verticalRun.dimension;
        goto L92
    L84:
        DependencyNode r39 = this.widget.verticalRun.dimension;
    L86:
        r35 = r39.targets;
        goto L87
    L85:
        DimensionDependency r40 = r30.verticalRun.dimension;
        r15.targets.add(r40);
        r40.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        DimensionDependency r41 = this.dimension;
        r41.delegateToWidgetRun = true;
        r41.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        r39 = this.end;
    L93:
        ConstraintWidget r42 = this.widget;
        ConstraintAnchor[] r43 = r42.mListAnchors;
        if (r43[0].mTarget == null) goto L108;
        if (r43[1].mTarget == null) goto L108;
        if (r42.isInHorizontalChain() == false) goto L101;
        DependencyNode r44 = this.start;
        r44.margin = this.widget.mListAnchors[0].getMargin();
        r19 = this.end;
        r20 = this.widget.mListAnchors[1];
        goto L100
    L101:
        DependencyNode r45 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r46 = getTarget(this.widget.mListAnchors[1]);
        if (r45 == null) goto L104;
        r45.addDependency(this);
    L104:
        if (r46 == null) goto L106;
        r46.addDependency(this);
    L106:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L108:
        if (r43[0].mTarget == null) goto L113;
        DependencyNode r47 = getTarget(r43[0]);
        if (r47 == null) goto L133;
        DependencyNode r48 = this.start;
        int r49 = this.widget.mListAnchors[0].getMargin();
    L122:
        addTarget(r48, r47, r49);
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L133:
        return;
    L113:
        if (r43[1].mTarget == null) goto L118;
        DependencyNode r50 = getTarget(r43[1]);
        if (r50 == null) goto L134;
        addTarget(this.end, r50, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L134:
        return;
    L118:
        if ((r42 instanceof Helper) == false) goto L120;
        return;
    L120:
        if (r42.getParent() == null) goto L137;
        r47 = this.widget.getParent().horizontalRun.start;
        r48 = this.start;
        r49 = this.widget.getX();
        goto L122
    L137:
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r51 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r52 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r51 != r52) goto L32;
        ConstraintWidget r53 = this.widget.getParent();
        if (r53 == null) goto L32;
        if (r53.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r53.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r53.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r53.getHorizontalDimensionBehaviour() != r52) goto L32;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r10 = this.start;
        if (r10.resolved == false) goto L6;
        this.widget.setX(r10.value);
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
    public void update(Dependency r17) {
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L9;
        if (r10 != 3) goto L12;
        ConstraintWidget r11 = this.widget;
        updateRunCenter(r17, r11.mLeft, r11.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == false) goto L14;
    L134:
        DependencyNode r12 = this.start;
        if (r12.readyToSolve == false) goto L186;
        DependencyNode r13 = this.end;
        if (r13.readyToSolve == true) goto L140;
        return;
    L140:
        if (r12.resolved == false) goto L147;
        if (r13.resolved == false) goto L147;
        if (this.dimension.resolved == false) goto L147;
        return;
    L147:
        if (this.dimension.resolved == true) goto L157;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        ConstraintWidget r14 = this.widget;
        if (r14.mMatchConstraintDefaultWidth != 0) goto L157;
        if (r14.isInHorizontalChain() == true) goto L157;
        DependencyNode r15 = this.start.targets.get(0);
        DependencyNode r16 = this.end.targets.get(0);
        int r18 = r15.value;
        DependencyNode r19 = this.start;
        int r20 = r18 + r19.margin;
        int r21 = r16.value + this.end.margin;
        r19.resolve(r20);
        this.end.resolve(r21);
        this.dimension.resolve(r21 - r20);
        return;
    L157:
        if (this.dimension.resolved == true) goto L171;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L171;
        if (this.matchConstraintsType != 1) goto L171;
        if (this.start.targets.size() <= 0) goto L171;
        if (this.end.targets.size() <= 0) goto L171;
        DependencyNode r22 = this.start.targets.get(0);
        DependencyNode r23 = this.end.targets.get(0);
        int r24 = Math.min((r23.value + this.end.margin) - (r22.value + this.start.margin), this.dimension.wrapValue);
        ConstraintWidget r25 = this.widget;
        int r26 = r25.mMatchConstraintMaxWidth;
        int r27 = Math.max(r25.mMatchConstraintMinWidth, r24);
        if (r26 <= 0) goto L169;
        r27 = Math.min(r26, r27);
    L169:
        this.dimension.resolve(r27);
    L171:
        if (this.dimension.resolved == true) goto L173;
        return;
    L173:
        DependencyNode r28 = this.start.targets.get(0);
        DependencyNode r29 = this.end.targets.get(0);
        int r30 = r28.value + this.start.margin;
        int r31 = r29.value + this.end.margin;
        float r32 = this.widget.getHorizontalBiasPercent();
        if (r28 != r29) goto L176;
        r30 = r28.value;
        r31 = r29.value;
        r32 = 0.5f;
    L176:
        this.start.resolve((int) ((r30 + 0.5f) + (((r31 - r30) - this.dimension.value) * r32)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L186:
        return;
    L14:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L134;
        ConstraintWidget r33 = this.widget;
        int r34 = r33.mMatchConstraintDefaultWidth;
        if (r34 == 2) goto L129;
        if (r34 != 3) goto L134;
        int r35 = r33.mMatchConstraintDefaultHeight;
        if (r35 == 0) goto L32;
        if (r35 == 3) goto L32;
        int r36 = r33.getDimensionRatioSide();
        if (r36 == (-1)) goto L29;
        if (r36 == 0) goto L28;
        if (r36 == 1) goto L29;
        int r37 = 0;
    L31:
        this.dimension.resolve(r37);
        goto L134
    L28:
        ConstraintWidget r38 = this.widget;
        float r39 = r38.verticalRun.dimension.value / r38.getDimensionRatio();
    L30:
        r37 = (int) (r39 + 0.5f);
    L29:
        ConstraintWidget r40 = this.widget;
        r39 = r40.verticalRun.dimension.value * r40.getDimensionRatio();
    L32:
        VerticalWidgetRun r41 = r33.verticalRun;
        DependencyNode r110 = r41.start;
        DependencyNode r111 = r41.end;
        if (r33.mLeft.mTarget == null) goto L35;
        boolean r42 = true;
    L37:
        if (r33.mTop.mTarget == null) goto L39;
        boolean r43 = true;
    L41:
        if (r33.mRight.mTarget == null) goto L43;
        boolean r44 = true;
    L45:
        if (r33.mBottom.mTarget == null) goto L47;
        boolean r45 = true;
    L48:
        int r112 = r33.getDimensionRatioSide();
        if (r42 == false) goto L86;
        if (r43 == false) goto L86;
        if (r44 == false) goto L86;
        if (r45 == false) goto L86;
        float r113 = this.widget.getDimensionRatio();
        if (r110.resolved == true) goto L56;
    L64:
        DependencyNode r46 = this.start;
        if (r46.resolved == false) goto L75;
        DependencyNode r47 = this.end;
        if (r47.resolved == false) goto L75;
        if (r110.readyToSolve == true) goto L71;
        return;
    L71:
        if (r111.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, r46.value + r46.margin, r47.value - r47.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L75
    L180:
        return;
    L75:
        DependencyNode r48 = this.start;
        if (r48.readyToSolve == true) goto L78;
        return;
    L78:
        if (this.end.readyToSolve == true) goto L80;
        return;
    L80:
        if (r110.readyToSolve == true) goto L82;
        return;
    L82:
        if (r111.readyToSolve == false) goto L183;
        computeInsetRatio(tempDimensions, r48.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        DimensionDependency r49 = this.widget.verticalRun.dimension;
        int r50 = tempDimensions[1];
    L127:
        r49.resolve(r50);
        goto L134
    L183:
        return;
    L56:
        if (r111.resolved == false) goto L64;
        DependencyNode r51 = this.start;
        if (r51.readyToSolve == true) goto L60;
        return;
    L60:
        if (this.end.readyToSolve == false) goto L179;
        computeInsetRatio(tempDimensions, r51.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.value + r110.margin, r111.value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L179:
        return;
    L86:
        if (r42 == false) goto L107;
        if (r44 == false) goto L107;
        if (this.start.readyToSolve == true) goto L91;
        return;
    L91:
        if (this.end.readyToSolve == false) goto L184;
        float r52 = this.widget.getDimensionRatio();
        int r53 = this.start.targets.get(0).value + this.start.margin;
        int r54 = this.end.targets.get(0).value - this.end.margin;
        if (r112 == (-1)) goto L101;
        if (r112 == 0) goto L101;
        if (r112 != 1) goto L134;
        int r55 = getLimitedDimension(r54 - r53, 0);
        int r56 = (int) ((r55 / r52) + 0.5f);
        int r57 = getLimitedDimension(r56, 1);
        if (r56 == r57) goto L105;
        float r58 = r57 * r52;
    L104:
        r55 = (int) (r58 + 0.5f);
    L105:
        this.dimension.resolve(r55);
        this.widget.verticalRun.dimension.resolve(r57);
    L101:
        r55 = getLimitedDimension(r54 - r53, 0);
        int r59 = (int) ((r55 * r52) + 0.5f);
        r57 = getLimitedDimension(r59, 1);
        if (r59 == r57) goto L105;
        r58 = r57 / r52;
        goto L104
    L184:
        return;
    L107:
        if (r43 == false) goto L134;
        if (r45 == false) goto L134;
        if (r110.readyToSolve == true) goto L112;
        return;
    L112:
        if (r111.readyToSolve == false) goto L185;
        float r60 = this.widget.getDimensionRatio();
        int r61 = r110.targets.get(0).value + r110.margin;
        int r62 = r111.targets.get(0).value - r111.margin;
        if (r112 == (-1)) goto L122;
        if (r112 == 0) goto L119;
        if (r112 == 1) goto L122;
    L119:
        r50 = getLimitedDimension(r62 - r61, 1);
        int r63 = (int) ((r50 * r60) + 0.5f);
        int r64 = getLimitedDimension(r63, 0);
        if (r63 == r64) goto L126;
        float r65 = r64 / r60;
    L125:
        r50 = (int) (r65 + 0.5f);
    L126:
        this.dimension.resolve(r64);
        r49 = this.widget.verticalRun.dimension;
    L122:
        r50 = getLimitedDimension(r62 - r61, 1);
        int r66 = (int) ((r50 / r60) + 0.5f);
        r64 = getLimitedDimension(r66, 0);
        if (r66 == r64) goto L126;
        r65 = r64 * r60;
        goto L125
    L185:
        return;
    L47:
        r45 = false;
        goto L48
    L43:
        r44 = false;
        goto L45
    L39:
        r43 = false;
        goto L41
    L35:
        r42 = false;
        goto L37
    L129:
        ConstraintWidget r67 = r33.getParent();
        if (r67 == null) goto L134;
        DimensionDependency r68 = r67.horizontalRun.dimension;
        if (r68.resolved == false) goto L134;
        r37 = (int) ((r68.value * this.widget.mMatchConstraintPercentWidth) + 0.5f);
        goto L31
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }
}

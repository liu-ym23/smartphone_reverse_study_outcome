package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    static {
        tempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget r5) {
        super(r5);
        DependencyNode r10 = this.start;
        r10.type = DependencyNode.Type.LEFT;
        DependencyNode r11 = this.end;
        r11.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] r5, int r10, int r11, int r12, int r13, float r14, int r15) {
        int r16 = r11 - r10;
        int r17 = r13 - r12;
        if (r15 == (-1)) goto L9;
        if (r15 == 0) goto L8;
        if (r15 != 1) goto L19;
        r5[0] = r16;
        r5[1] = (int) ((r16 * r14) + 0.5f);
        return;
    L19:
        return;
    L8:
        r5[0] = (int) ((r17 * r14) + 0.5f);
        r5[1] = r17;
        return;
    L9:
        int r18 = (int) ((r17 * r14) + 0.5f);
        int r19 = (int) ((r16 / r14) + 0.5f);
        if (r18 > r16) goto L12;
        r5[0] = r18;
        r5[1] = r17;
        return;
    L12:
        if (r19 > r17) goto L18;
        r5[0] = r16;
        r5[1] = r19;
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r5 = this.widget;
        if (r5.measured == false) goto L6;
        this.dimension.resolve(r5.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L22;
        ConstraintWidget.DimensionBehaviour r10 = this.widget.getHorizontalDimensionBehaviour();
        this.dimensionBehavior = r10;
        if (r10 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget.DimensionBehaviour r11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r10 != r11) goto L20;
        ConstraintWidget r12 = this.widget.getParent();
        if (r12 == null) goto L16;
        if (r12.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r13 = (r12.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r12.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r12.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r13);
        return;
    L16:
        if (r12.getHorizontalDimensionBehaviour() == r11) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getWidth());
    L32:
        DimensionDependency r14 = this.dimension;
        if (r14.resolved == false) goto L67;
        ConstraintWidget r15 = this.widget;
        if (r15.measured == false) goto L67;
        ConstraintAnchor[] r16 = r15.mListAnchors;
        ConstraintAnchor r17 = r16[0];
        ConstraintAnchor r18 = r17.mTarget;
        if (r18 != null) goto L39;
    L50:
        if (r18 == null) goto L54;
        DependencyNode r19 = getTarget(r17);
        if (r19 == null) goto L112;
        addTarget(this.start, r19, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L112:
        return;
    L54:
        ConstraintAnchor r20 = r16[1];
        if (r20.mTarget == null) goto L60;
        DependencyNode r21 = getTarget(r20);
        if (r21 == null) goto L114;
        addTarget(this.end, r21, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
        return;
    L114:
        return;
    L60:
        if ((r15 instanceof Helper) == false) goto L62;
        return;
    L62:
        if (r15.getParent() != null) goto L64;
        return;
    L64:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L118;
        DependencyNode r22 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r22, this.widget.getX());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L118:
        return;
    L39:
        if (r16[1].mTarget == null) goto L50;
        if (r15.isInHorizontalChain() == false) goto L43;
        DependencyNode r23 = this.start;
        r23.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r24 = this.end;
        r24.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L43:
        DependencyNode r25 = getTarget(this.widget.mListAnchors[0]);
        if (r25 == null) goto L46;
        addTarget(this.start, r25, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r26 = getTarget(this.widget.mListAnchors[1]);
        if (r26 == null) goto L49;
        addTarget(this.end, r26, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L67:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        ConstraintWidget r27 = this.widget;
        int r28 = r27.mMatchConstraintDefaultWidth;
        if (r28 != 2) goto L71;
        ConstraintWidget r29 = r27.getParent();
        if (r29 == null) goto L87;
        DimensionDependency r30 = r29.verticalRun.dimension;
        this.dimension.targets.add(r30);
        r30.dependencies.add(this.dimension);
        DimensionDependency r31 = this.dimension;
        r31.delegateToWidgetRun = true;
        r31.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L87
    L71:
        if (r28 != 3) goto L87;
        if (r27.mMatchConstraintDefaultHeight != 3) goto L82;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        VerticalWidgetRun r32 = r27.verticalRun;
        r32.start.updateDelegate = this;
        r32.end.updateDelegate = this;
        r14.updateDelegate = this;
        if (r27.isInVerticalChain() == false) goto L79;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        VerticalWidgetRun r33 = this.widget.verticalRun;
        r33.dimension.updateDelegate = this;
        this.dimension.targets.add(r33.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        goto L87
    L79:
        if (this.widget.isInHorizontalChain() == false) goto L81;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
        goto L87
    L81:
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        goto L87
    L82:
        DimensionDependency r34 = r27.verticalRun.dimension;
        r14.targets.add(r34);
        r34.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        DimensionDependency r35 = this.dimension;
        r35.delegateToWidgetRun = true;
        r35.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        this.end.targets.add(this.dimension);
    L87:
        ConstraintWidget r36 = this.widget;
        ConstraintAnchor[] r37 = r36.mListAnchors;
        ConstraintAnchor r38 = r37[0];
        ConstraintAnchor r39 = r38.mTarget;
        if (r39 != null) goto L90;
    L95:
        if (r39 == null) goto L99;
        DependencyNode r40 = getTarget(r38);
        if (r40 == null) goto L122;
        addTarget(this.start, r40, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L122:
        return;
    L99:
        ConstraintAnchor r41 = r37[1];
        if (r41.mTarget == null) goto L105;
        DependencyNode r42 = getTarget(r41);
        if (r42 == null) goto L124;
        addTarget(this.end, r42, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L124:
        return;
    L105:
        if ((r36 instanceof Helper) == false) goto L107;
        return;
    L107:
        if (r36.getParent() == null) goto L127;
        DependencyNode r43 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r43, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L127:
        return;
    L90:
        if (r37[1].mTarget == null) goto L95;
        if (r36.isInHorizontalChain() == false) goto L94;
        DependencyNode r44 = this.start;
        r44.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r45 = this.end;
        r45.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L94:
        DependencyNode r46 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r47 = getTarget(this.widget.mListAnchors[1]);
        r46.addDependency(this);
        r47.addDependency(this);
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r48 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r49 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r48 != r49) goto L32;
        ConstraintWidget r50 = this.widget.getParent();
        if (r50 == null) goto L29;
        if (r50.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r50.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r50.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r50.getHorizontalDimensionBehaviour() != r49) goto L32;
        goto L30
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r5 = this.start;
        if (r5.resolved == false) goto L6;
        this.widget.setX(r5.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
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

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r17) {
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r5 == 1) goto L10;
        if (r5 == 2) goto L9;
        if (r5 != 3) goto L12;
        ConstraintWidget r10 = this.widget;
        updateRunCenter(r17, r10.mLeft, r10.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == false) goto L14;
    L134:
        DependencyNode r11 = this.start;
        if (r11.readyToSolve == false) goto L186;
        DependencyNode r12 = this.end;
        if (r12.readyToSolve == true) goto L140;
        return;
    L140:
        if (r11.resolved == false) goto L147;
        if (r12.resolved == false) goto L147;
        if (this.dimension.resolved == false) goto L147;
        return;
    L147:
        if (this.dimension.resolved == true) goto L157;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        ConstraintWidget r13 = this.widget;
        if (r13.mMatchConstraintDefaultWidth != 0) goto L157;
        if (r13.isInHorizontalChain() == true) goto L157;
        DependencyNode r14 = this.start.targets.get(0);
        DependencyNode r15 = this.end.targets.get(0);
        int r16 = r14.value;
        DependencyNode r18 = this.start;
        int r19 = r16 + r18.margin;
        int r20 = r15.value + this.end.margin;
        r18.resolve(r19);
        this.end.resolve(r20);
        this.dimension.resolve(r20 - r19);
        return;
    L157:
        if (this.dimension.resolved == true) goto L171;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L171;
        if (this.matchConstraintsType != 1) goto L171;
        if (this.start.targets.size() <= 0) goto L171;
        if (this.end.targets.size() <= 0) goto L171;
        DependencyNode r21 = this.start.targets.get(0);
        DependencyNode r22 = this.end.targets.get(0);
        int r23 = Math.min((r22.value + this.end.margin) - (r21.value + this.start.margin), this.dimension.wrapValue);
        ConstraintWidget r24 = this.widget;
        int r25 = r24.mMatchConstraintMaxWidth;
        int r26 = Math.max(r24.mMatchConstraintMinWidth, r23);
        if (r25 <= 0) goto L169;
        r26 = Math.min(r25, r26);
    L169:
        this.dimension.resolve(r26);
    L171:
        if (this.dimension.resolved == true) goto L173;
        return;
    L173:
        DependencyNode r27 = this.start.targets.get(0);
        DependencyNode r28 = this.end.targets.get(0);
        int r29 = r27.value + this.start.margin;
        int r30 = r28.value + this.end.margin;
        float r31 = this.widget.getHorizontalBiasPercent();
        if (r27 != r28) goto L176;
        r29 = r27.value;
        r30 = r28.value;
        r31 = 0.5f;
    L176:
        float r32 = r29 + 0.5f;
        this.start.resolve((int) ((((r30 - r29) - this.dimension.value) * r31) + r32));
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
        if (r35 == 0) goto L33;
        if (r35 == 3) goto L33;
        int r36 = r33.getDimensionRatioSide();
        if (r36 == (-1)) goto L31;
        if (r36 == 0) goto L30;
        if (r36 == 1) goto L28;
        int r37 = 0;
    L32:
        this.dimension.resolve(r37);
        goto L134
    L28:
        ConstraintWidget r38 = this.widget;
        float r39 = r38.verticalRun.dimension.value;
        float r40 = r38.getDimensionRatio();
    L29:
        r37 = (int) ((r40 * r39) + 0.5f);
        goto L32
    L30:
        ConstraintWidget r41 = this.widget;
        r37 = (int) ((r41.verticalRun.dimension.value / r41.getDimensionRatio()) + 0.5f);
        goto L32
    L31:
        ConstraintWidget r42 = this.widget;
        r39 = r42.verticalRun.dimension.value;
        r40 = r42.getDimensionRatio();
    L33:
        VerticalWidgetRun r43 = r33.verticalRun;
        DependencyNode r110 = r43.start;
        DependencyNode r111 = r43.end;
        if (r33.mLeft.mTarget == null) goto L36;
        boolean r44 = true;
    L38:
        if (r33.mTop.mTarget == null) goto L40;
        boolean r45 = true;
    L42:
        if (r33.mRight.mTarget == null) goto L44;
        boolean r46 = true;
    L46:
        if (r33.mBottom.mTarget == null) goto L48;
        boolean r47 = true;
    L49:
        int r112 = r33.getDimensionRatioSide();
        if (r44 == false) goto L87;
        if (r45 == false) goto L87;
        if (r46 == false) goto L87;
        if (r47 == false) goto L87;
        float r113 = this.widget.getDimensionRatio();
        if (r110.resolved == true) goto L57;
    L65:
        DependencyNode r48 = this.start;
        if (r48.resolved == false) goto L76;
        DependencyNode r49 = this.end;
        if (r49.resolved == false) goto L76;
        if (r110.readyToSolve == true) goto L72;
        return;
    L72:
        if (r111.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, r48.value + r48.margin, r49.value - r49.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L76
    L180:
        return;
    L76:
        DependencyNode r50 = this.start;
        if (r50.readyToSolve == true) goto L79;
        return;
    L79:
        if (this.end.readyToSolve == true) goto L81;
        return;
    L81:
        if (r110.readyToSolve == true) goto L83;
        return;
    L83:
        if (r111.readyToSolve == false) goto L183;
        computeInsetRatio(tempDimensions, r50.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L134
    L183:
        return;
    L57:
        if (r111.resolved == false) goto L65;
        DependencyNode r51 = this.start;
        if (r51.readyToSolve == true) goto L61;
        return;
    L61:
        if (this.end.readyToSolve == false) goto L179;
        computeInsetRatio(tempDimensions, r51.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.value + r110.margin, r111.value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L179:
        return;
    L87:
        if (r44 == false) goto L108;
        if (r46 == false) goto L108;
        if (this.start.readyToSolve == true) goto L92;
        return;
    L92:
        if (this.end.readyToSolve == false) goto L184;
        float r52 = this.widget.getDimensionRatio();
        int r53 = this.start.targets.get(0).value + this.start.margin;
        int r54 = this.end.targets.get(0).value - this.end.margin;
        if (r112 == (-1)) goto L103;
        if (r112 == 0) goto L103;
        if (r112 != 1) goto L134;
        int r55 = getLimitedDimension(r54 - r53, 0);
        int r56 = (int) ((r55 / r52) + 0.5f);
        int r57 = getLimitedDimension(r56, 1);
        if (r56 == r57) goto L102;
        r55 = (int) ((r57 * r52) + 0.5f);
    L102:
        this.dimension.resolve(r55);
        this.widget.verticalRun.dimension.resolve(r57);
    L103:
        int r58 = getLimitedDimension(r54 - r53, 0);
        int r59 = (int) ((r58 * r52) + 0.5f);
        int r60 = getLimitedDimension(r59, 1);
        if (r59 == r60) goto L106;
        r58 = (int) ((r60 / r52) + 0.5f);
    L106:
        this.dimension.resolve(r58);
        this.widget.verticalRun.dimension.resolve(r60);
        goto L134
    L184:
        return;
    L108:
        if (r45 == false) goto L134;
        if (r47 == false) goto L134;
        if (r110.readyToSolve == true) goto L113;
        return;
    L113:
        if (r111.readyToSolve == false) goto L185;
        float r61 = this.widget.getDimensionRatio();
        int r62 = r110.targets.get(0).value + r110.margin;
        int r63 = r111.targets.get(0).value - r111.margin;
        if (r112 == (-1)) goto L124;
        if (r112 == 0) goto L120;
        if (r112 == 1) goto L124;
    L120:
        int r64 = getLimitedDimension(r63 - r62, 1);
        int r65 = (int) ((r64 * r61) + 0.5f);
        int r66 = getLimitedDimension(r65, 0);
        if (r65 == r66) goto L123;
        r64 = (int) ((r66 / r61) + 0.5f);
    L123:
        this.dimension.resolve(r66);
        this.widget.verticalRun.dimension.resolve(r64);
    L124:
        int r67 = getLimitedDimension(r63 - r62, 1);
        int r68 = (int) ((r67 / r61) + 0.5f);
        int r69 = getLimitedDimension(r68, 0);
        if (r68 == r69) goto L127;
        r67 = (int) ((r69 * r61) + 0.5f);
    L127:
        this.dimension.resolve(r69);
        this.widget.verticalRun.dimension.resolve(r67);
        goto L134
    L185:
        return;
    L48:
        r47 = false;
        goto L49
    L44:
        r46 = false;
        goto L46
    L40:
        r45 = false;
        goto L42
    L36:
        r44 = false;
        goto L38
    L129:
        ConstraintWidget r70 = r33.getParent();
        if (r70 == null) goto L134;
        DimensionDependency r71 = r70.horizontalRun.dimension;
        if (r71.resolved == false) goto L134;
        this.dimension.resolve((int) ((r71.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
        goto L134
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }
}

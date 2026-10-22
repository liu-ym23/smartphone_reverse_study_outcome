package androidx.constraintlayout.solver.widgets.analyzer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget r5, int r10) {
        super(r5);
        this.widgets = new ArrayList();
        this.orientation = r10;
        build();
    }

    private void build() {
        ConstraintWidget r5 = this.widget;
        ConstraintWidget r10 = r5.getPreviousChainMember(this.orientation);
    L3:
        ConstraintWidget r11 = r10;
        ConstraintWidget r12 = r5;
        r5 = r11;
        if (r5 == null) goto L6;
        r10 = r5.getPreviousChainMember(this.orientation);
        goto L3
    L6:
        this.widget = r12;
        this.widgets.add(r12.getRun(this.orientation));
        ConstraintWidget r13 = r12.getNextChainMember(this.orientation);
    L7:
        if (r13 == null) goto L9;
        this.widgets.add(r13.getRun(this.orientation));
        r13 = r13.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r14 = this.widgets.iterator();
    L11:
        if (r14.hasNext() == false) goto L18;
        WidgetRun r15 = r14.next();
        int r16 = this.orientation;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L11;
        r15.widget.verticalChainRun = this;
        goto L11
    L14:
        r15.widget.horizontalChainRun = this;
        goto L11
    L18:
        if (this.orientation != 0) goto L25;
        if (((ConstraintWidgetContainer) this.widget.getParent()).isRtl() == false) goto L25;
        if (this.widgets.size() <= 1) goto L25;
        this.widget = ((WidgetRun) a.h(this.widgets, 1)).widget;
    L25:
        if (this.orientation != 0) goto L27;
        int r17 = this.widget.getHorizontalChainStyle();
    L28:
        this.chainStyle = r17;
        return;
    L27:
        r17 = this.widget.getVerticalChainStyle();
        goto L28
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int r5 = 0;
    L4:
        if (r5 >= this.widgets.size()) goto L10;
        WidgetRun r10 = this.widgets.get(r5);
        if (r10.widget.getVisibility() != 8) goto L8;
        r5 = r5 + 1;
        goto L4
    L8:
        return r10.widget;
    L10:
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r5 = this.widgets.size() - 1;
    L3:
        if (r5 < 0) goto L9;
        WidgetRun r10 = this.widgets.get(r5);
        if (r10.widget.getVisibility() != 8) goto L7;
        r5 = r5 - 1;
        goto L3
    L7:
        return r10.widget;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> r5 = this.widgets.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().apply();
        goto L4
    L6:
        int r10 = this.widgets.size();
        if (r10 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r11 = this.widgets.get(0).widget;
        ConstraintWidget r12 = this.widgets.get(r10 - 1).widget;
        if (this.orientation != 0) goto L21;
        ConstraintAnchor r13 = r11.mLeft;
        ConstraintAnchor r14 = r12.mRight;
        DependencyNode r15 = getTarget(r13, 0);
        int r16 = r13.getMargin();
        ConstraintWidget r17 = getFirstVisibleWidget();
        if (r17 == null) goto L14;
        r16 = r17.mLeft.getMargin();
    L14:
        if (r15 == null) goto L16;
        addTarget(this.start, r15, r16);
    L16:
        DependencyNode r18 = getTarget(r14, 0);
        int r19 = r14.getMargin();
        ConstraintWidget r20 = getLastVisibleWidget();
        if (r20 == null) goto L19;
        r19 = r20.mRight.getMargin();
    L19:
        if (r18 == null) goto L31;
        addTarget(this.end, r18, -r19);
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
    L21:
        ConstraintAnchor r21 = r11.mTop;
        ConstraintAnchor r22 = r12.mBottom;
        DependencyNode r23 = getTarget(r21, 1);
        int r24 = r21.getMargin();
        ConstraintWidget r25 = getFirstVisibleWidget();
        if (r25 == null) goto L24;
        r24 = r25.mTop.getMargin();
    L24:
        if (r23 == null) goto L26;
        addTarget(this.start, r23, r24);
    L26:
        DependencyNode r26 = getTarget(r22, 1);
        int r27 = r22.getMargin();
        ConstraintWidget r28 = getLastVisibleWidget();
        if (r28 == null) goto L29;
        r27 = r28.mBottom.getMargin();
    L29:
        if (r26 == null) goto L31;
        addTarget(this.end, r26, -r27);
        goto L31
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r5 = 0;
    L4:
        if (r5 >= this.widgets.size()) goto L6;
        this.widgets.get(r5).applyToWidget();
        r5 = r5 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> r5 = this.widgets.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().clear();
        goto L4
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r5 = this.widgets.size();
        long r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        WidgetRun r12 = this.widgets.get(r11);
        long r13 = r10 + ((long) r12.start.margin);
        long r14 = r12.getWrapDimension() + r13;
        r10 = ((long) r12.end.margin) + r14;
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int r5 = this.widgets.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        if (this.widgets.get(r10).supportsWrapComputation() == false) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public String toString() {
        if (this.orientation != 0) goto L5;
        String r5 = "horizontal : ";
    L6:
        String r10 = "ChainRun ".concat(r5);
        Iterator<WidgetRun> r11 = this.widgets.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        WidgetRun r12 = r11.next();
        r10 = j0.j(j0.j(r10, "<") + r12, "> ");
        goto L8
    L10:
        return r10;
    L5:
        r5 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r26) {
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L332;
        ConstraintWidget r5 = this.widget.getParent();
        if (r5 != null) goto L10;
    L12:
        boolean r10 = false;
    L13:
        int r11 = this.end.value - this.start.value;
        int r12 = this.widgets.size();
        int r13 = 0;
    L14:
        int r14 = -1;
        int r15 = 8;
        if (r13 >= r12) goto L19;
        if (this.widgets.get(r13).widget.getVisibility() != 8) goto L20;
        r13 = r13 + 1;
    L20:
        int r16 = r12 - 1;
        int r17 = r16;
    L21:
        if (r17 < 0) goto L26;
        if (this.widgets.get(r17).widget.getVisibility() != 8) goto L25;
        r17 = r17 - 1;
        goto L21
    L25:
        r14 = r17;
    L26:
        int r18 = 0;
    L28:
        if (r18 >= 2) goto L77;
        int r19 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        float r113 = 0.0f;
    L30:
        if (r19 >= r12) goto L72;
        WidgetRun r20 = this.widgets.get(r19);
        if (r20.widget.getVisibility() == r15) goto L71;
        r112 = r112 + 1;
        if (r19 <= 0) goto L38;
        if (r19 < r13) goto L38;
        r110 = r110 + r20.start.margin;
    L38:
        DimensionDependency r114 = r20.dimension;
        int r21 = r114.value;
        if (r20.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L41;
        boolean r115 = true;
    L42:
        if (r115 == false) goto L54;
        int r116 = this.orientation;
        if (r116 != 0) goto L49;
        if (r20.widget.horizontalRun.dimension.resolved == true) goto L49;
        return;
    L49:
        if (r116 == 1) goto L51;
    L53:
        int r117 = r21;
    L62:
        int r22 = r117;
    L63:
        if (r115 == true) goto L67;
        r111 = r111 + 1;
        float r23 = r20.widget.mWeight[this.orientation];
        if (r23 < 0.0f) goto L68;
        r113 = r113 + r23;
    L68:
        if (r19 >= r16) goto L71;
        if (r19 >= r14) goto L71;
        r110 = r110 + (-r20.end.margin);
        goto L71
    L67:
        r110 = r110 + r22;
        goto L68
    L51:
        if (r20.widget.verticalRun.dimension.resolved == true) goto L53;
        return;
    L54:
        r117 = r21;
        if (r20.matchConstraintsType != 1) goto L60;
        if (r18 != 0) goto L60;
        r22 = r114.wrapValue;
        r111 = r111 + 1;
    L58:
        r115 = true;
    L60:
        if (r114.resolved == false) goto L62;
        r22 = r117;
        goto L58
    L41:
        r115 = false;
    L71:
        r19 = r19 + 1;
        r15 = 8;
        goto L30
    L72:
        if (r110 < r11) goto L76;
        if (r111 == 0) goto L76;
        r18 = r18 + 1;
        r15 = 8;
    L76:
        int r24 = r112;
    L78:
        int r25 = this.start.value;
        if (r10 == false) goto L82;
        r25 = this.end.value;
    L82:
        if (r110 > r11) goto L84;
    L87:
        if (r111 <= 0) goto L144;
        float r118 = r11 - r110;
        int r119 = (int) ((r118 / r111) + 0.5f);
        int r120 = 0;
        int r121 = 0;
    L89:
        if (r120 >= r12) goto L123;
        WidgetRun r27 = this.widgets.get(r120);
        int r122 = r119;
        int r28 = r110;
        if (r27.widget.getVisibility() != 8) goto L94;
    L92:
        boolean r29 = r10;
        int r210 = r24;
        r25 = r25;
        float r211 = r118;
    L122:
        r120 = r120 + 1;
        r119 = r122;
        r110 = r28;
        r25 = r25;
        r118 = r211;
        r10 = r29;
        r24 = r210;
        goto L89
    L94:
        if (r27.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L92;
        DimensionDependency r123 = r27.dimension;
        if (r123.resolved == true) goto L92;
        if (r113 <= 0.0f) goto L100;
        int r30 = (int) (((r27.widget.mWeight[this.orientation] * r118) / r113) + 0.5f);
    L102:
        if (this.orientation != 0) goto L112;
        ConstraintWidget r124 = r27.widget;
        r211 = r118;
        int r125 = r124.mMatchConstraintMaxWidth;
        int r126 = r124.mMatchConstraintMinWidth;
        r29 = r10;
        r210 = r24;
        if (r27.matchConstraintsType != 1) goto L106;
        int r31 = Math.min(r30, r123.wrapValue);
    L107:
        int r32 = Math.max(r126, r31);
        if (r125 <= 0) goto L110;
        r32 = Math.min(r125, r32);
    L110:
        if (r32 != r30) goto L120;
    L121:
        r27.dimension.resolve(r30);
    L120:
        r121 = r121 + 1;
        r30 = r32;
        goto L121
    L106:
        r31 = r30;
        goto L107
    L112:
        r29 = r10;
        r210 = r24;
        r211 = r118;
        ConstraintWidget r33 = r27.widget;
        int r34 = r33.mMatchConstraintMaxHeight;
        int r35 = r33.mMatchConstraintMinHeight;
        if (r27.matchConstraintsType != 1) goto L115;
        int r127 = Math.min(r30, r123.wrapValue);
    L116:
        r32 = Math.max(r35, r127);
        if (r34 <= 0) goto L119;
        r32 = Math.min(r34, r32);
    L119:
        if (r32 == r30) goto L121;
    L115:
        r127 = r30;
        goto L116
    L100:
        r30 = r122;
        goto L102
    L123:
        boolean r212 = r10;
        int r213 = r24;
        int r214 = r25;
        int r215 = r110;
        if (r121 <= 0) goto L138;
        r111 = r111 - r121;
        int r36 = 0;
        r110 = 0;
    L126:
        if (r36 >= r12) goto L139;
        WidgetRun r37 = this.widgets.get(r36);
        if (r37.widget.getVisibility() == 8) goto L137;
        if (r36 <= 0) goto L133;
        if (r36 < r13) goto L133;
        r110 = r110 + r37.start.margin;
    L133:
        r110 = r110 + r37.dimension.value;
        if (r36 >= r16) goto L137;
        if (r36 >= r14) goto L137;
        r110 = r110 + (-r37.end.margin);
    L137:
        r36 = r36 + 1;
    L139:
        int r38 = 2;
        if (this.chainStyle != 2) goto L143;
        if (r121 != 0) goto L143;
        int r39 = 0;
        this.chainStyle = 0;
    L145:
        if (r110 <= r11) goto L147;
        this.chainStyle = r38;
    L147:
        if (r213 <= 0) goto L151;
        if (r111 != 0) goto L151;
        if (r13 != r14) goto L151;
        this.chainStyle = r38;
    L151:
        int r40 = this.chainStyle;
        if (r40 != 1) goto L200;
        int r41 = r213;
        if (r41 <= 1) goto L156;
        int r42 = (r11 - r110) / (r41 - 1);
    L159:
        if (r111 <= 0) goto L161;
        r42 = r39;
    L161:
        int r43 = r39;
        int r44 = r214;
    L162:
        if (r43 >= r12) goto L333;
        if (r212 == false) goto L165;
        int r45 = r12 - (r43 + 1);
    L166:
        WidgetRun r46 = this.widgets.get(r45);
        if (r46.widget.getVisibility() != 8) goto L169;
        r46.start.resolve(r44);
        r46.end.resolve(r44);
    L199:
        r43 = r43 + 1;
        goto L162
    L169:
        if (r43 <= 0) goto L173;
        if (r212 == false) goto L172;
        r44 = r44 - r42;
        goto L173
    L172:
        r44 = r44 + r42;
    L173:
        if (r43 <= 0) goto L178;
        if (r43 < r13) goto L178;
        if (r212 == false) goto L177;
        r44 = r44 - r46.start.margin;
        goto L178
    L177:
        r44 = r44 + r46.start.margin;
    L178:
        if (r212 == false) goto L180;
        r46.end.resolve(r44);
    L181:
        DimensionDependency r47 = r46.dimension;
        int r128 = r47.value;
        if (r46.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L184;
    L186:
        if (r212 == false) goto L188;
        r44 = r44 - r128;
    L189:
        if (r212 == false) goto L192;
        r46.start.resolve(r44);
    L193:
        r46.resolved = true;
        if (r43 >= r16) goto L199;
        if (r43 >= r14) goto L199;
        if (r212 == false) goto L198;
        r44 = r44 - (-r46.end.margin);
        goto L199
    L198:
        r44 = r44 + (-r46.end.margin);
        goto L199
    L192:
        r46.end.resolve(r44);
        goto L193
    L188:
        r44 = r44 + r128;
        goto L189
    L184:
        if (r46.matchConstraintsType != 1) goto L186;
        r128 = r47.wrapValue;
        goto L186
    L180:
        r46.start.resolve(r44);
        goto L181
    L165:
        r45 = r43;
        goto L166
    L333:
        return;
    L156:
        if (r41 != 1) goto L158;
        r42 = (r11 - r110) / 2;
        goto L159
    L158:
        r42 = r39;
        goto L159
    L200:
        int r48 = r213;
        if (r40 != 0) goto L242;
        int r49 = (r11 - r110) / (r48 + 1);
        if (r111 <= 0) goto L205;
        r49 = r39;
    L205:
        int r50 = r39;
        int r51 = r214;
    L206:
        if (r50 >= r12) goto L334;
        if (r212 == false) goto L209;
        int r52 = r12 - (r50 + 1);
    L210:
        WidgetRun r53 = this.widgets.get(r52);
        if (r53.widget.getVisibility() != 8) goto L213;
        r53.start.resolve(r51);
        r53.end.resolve(r51);
    L240:
        r50 = r50 + 1;
        goto L206
    L213:
        if (r212 == false) goto L215;
        int r54 = r51 - r49;
    L216:
        if (r50 <= 0) goto L221;
        if (r50 < r13) goto L221;
        if (r212 == false) goto L220;
        r54 = r54 - r53.start.margin;
        goto L221
    L220:
        r54 = r54 + r53.start.margin;
    L221:
        if (r212 == false) goto L223;
        r53.end.resolve(r54);
    L224:
        DimensionDependency r55 = r53.dimension;
        int r129 = r55.value;
        if (r53.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L227;
    L229:
        if (r212 == false) goto L231;
        r51 = r54 - r129;
    L232:
        if (r212 == false) goto L234;
        r53.start.resolve(r51);
    L235:
        if (r50 >= r16) goto L240;
        if (r50 >= r14) goto L240;
        if (r212 == false) goto L239;
        r51 = r51 - (-r53.end.margin);
        goto L240
    L239:
        r51 = r51 + (-r53.end.margin);
        goto L240
    L234:
        r53.end.resolve(r51);
        goto L235
    L231:
        r51 = r54 + r129;
        goto L232
    L227:
        if (r53.matchConstraintsType != 1) goto L229;
        r129 = Math.min(r129, r55.wrapValue);
        goto L229
    L223:
        r53.start.resolve(r54);
        goto L224
    L215:
        r54 = r51 + r49;
        goto L216
    L209:
        r52 = r50;
        goto L210
    L334:
        return;
    L242:
        if (r40 == 2) goto L244;
        return;
    L244:
        if (this.orientation != 0) goto L246;
        float r56 = this.widget.getHorizontalBiasPercent();
    L247:
        if (r212 == false) goto L249;
        r56 = 1.0f - r56;
    L249:
        int r57 = (int) (((r11 - r110) * r56) + 0.5f);
        if (r57 < 0) goto L252;
        if (r111 > 0) goto L252;
    L253:
        if (r212 == false) goto L255;
        int r58 = r214 - r57;
    L256:
        int r59 = r39;
    L257:
        if (r59 >= r12) goto L335;
        if (r212 == false) goto L260;
        int r60 = r12 - (r59 + 1);
    L261:
        WidgetRun r61 = this.widgets.get(r60);
        if (r61.widget.getVisibility() != 8) goto L264;
        r61.start.resolve(r58);
        r61.end.resolve(r58);
    L289:
        r59 = r59 + 1;
        goto L257
    L264:
        if (r59 <= 0) goto L269;
        if (r59 < r13) goto L269;
        if (r212 == false) goto L268;
        r58 = r58 - r61.start.margin;
        goto L269
    L268:
        r58 = r58 + r61.start.margin;
    L269:
        if (r212 == false) goto L271;
        r61.end.resolve(r58);
    L272:
        DimensionDependency r62 = r61.dimension;
        int r130 = r62.value;
        if (r61.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L278;
        if (r61.matchConstraintsType != 1) goto L278;
        r130 = r62.wrapValue;
    L278:
        if (r212 == false) goto L280;
        r58 = r58 - r130;
    L281:
        if (r212 == false) goto L283;
        r61.start.resolve(r58);
    L284:
        if (r59 >= r16) goto L289;
        if (r59 >= r14) goto L289;
        if (r212 == false) goto L288;
        r58 = r58 - (-r61.end.margin);
        goto L289
    L288:
        r58 = r58 + (-r61.end.margin);
        goto L289
    L283:
        r61.end.resolve(r58);
        goto L284
    L280:
        r58 = r58 + r130;
        goto L281
    L271:
        r61.start.resolve(r58);
        goto L272
    L260:
        r60 = r59;
        goto L261
    L335:
        return;
    L255:
        r58 = r214 + r57;
    L252:
        r57 = r39;
        goto L253
    L246:
        r56 = this.widget.getVerticalBiasPercent();
    L143:
        r39 = 0;
        goto L145
    L138:
        r110 = r215;
        goto L139
    L144:
        r212 = r10;
        r213 = r24;
        r214 = r25;
        r39 = 0;
        r38 = 2;
        goto L145
    L84:
        if (r10 == false) goto L86;
        r25 = r25 + ((int) (((r110 - r11) / 2.0f) + 0.5f));
        goto L87
    L86:
        r25 = r25 - ((int) (((r110 - r11) / 2.0f) + 0.5f));
        goto L87
    L77:
        r24 = 0;
        r110 = 0;
        r111 = 0;
        r113 = 0.0f;
        goto L78
    L19:
        r13 = -1;
        goto L20
    L10:
        if ((r5 instanceof ConstraintWidgetContainer) == false) goto L12;
        r10 = ((ConstraintWidgetContainer) r5).isRtl();
        goto L13
    }
}

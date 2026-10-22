package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget r10, int r11) {
        super(r10);
        this.widgets = new ArrayList();
        this.orientation = r11;
        build();
    }

    private void build() {
        ConstraintWidget r10 = this.widget;
    L3:
        ConstraintWidget r11 = r10;
        r10 = r10.getPreviousChainMember(this.orientation);
        if (r10 != null) goto L3;
        this.widget = r11;
        this.widgets.add(r11.getRun(this.orientation));
        ConstraintWidget r12 = r11.getNextChainMember(this.orientation);
    L7:
        if (r12 == null) goto L9;
        this.widgets.add(r12.getRun(this.orientation));
        r12 = r12.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r13 = this.widgets.iterator();
    L11:
        if (r13.hasNext() == false) goto L18;
        WidgetRun r14 = r13.next();
        int r15 = this.orientation;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L11;
        r14.widget.verticalChainRun = this;
        goto L11
    L14:
        r14.widget.horizontalChainRun = this;
        goto L11
    L18:
        if (this.orientation == 0) goto L20;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == false) goto L28;
        if (this.widgets.size() <= 1) goto L28;
        ArrayList<WidgetRun> r17 = this.widgets;
        this.widget = r17.get(r17.size() - 1).widget;
    L28:
        if (this.orientation != 0) goto L30;
        int r18 = this.widget.getHorizontalChainStyle();
    L31:
        this.chainStyle = r18;
        return;
    L30:
        r18 = this.widget.getVerticalChainStyle();
        goto L31
    L20:
        if (((ConstraintWidgetContainer) this.widget.getParent()).isRtl() == false) goto L22;
        r16 = true;
        goto L23
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int r10 = 0;
    L4:
        if (r10 >= this.widgets.size()) goto L10;
        WidgetRun r11 = this.widgets.get(r10);
        if (r11.widget.getVisibility() != 8) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return r11.widget;
    L10:
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r10 = this.widgets.size() - 1;
    L3:
        if (r10 < 0) goto L9;
        WidgetRun r11 = this.widgets.get(r10);
        if (r11.widget.getVisibility() != 8) goto L7;
        r10 = r10 - 1;
        goto L3
    L7:
        return r11.widget;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> r10 = this.widgets.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().apply();
        goto L4
    L6:
        int r11 = this.widgets.size();
        if (r11 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r12 = this.widgets.get(0).widget;
        ConstraintWidget r13 = this.widgets.get(r11 - 1).widget;
        if (this.orientation != 0) goto L21;
        ConstraintAnchor r14 = r12.mLeft;
        ConstraintAnchor r15 = r13.mRight;
        DependencyNode r16 = getTarget(r14, 0);
        int r17 = r14.getMargin();
        ConstraintWidget r18 = getFirstVisibleWidget();
        if (r18 == null) goto L14;
        r17 = r18.mLeft.getMargin();
    L14:
        if (r16 == null) goto L16;
        addTarget(this.start, r16, r17);
    L16:
        DependencyNode r19 = getTarget(r15, 0);
        int r20 = r15.getMargin();
        ConstraintWidget r21 = getLastVisibleWidget();
        if (r21 == null) goto L19;
        r20 = r21.mRight.getMargin();
    L19:
        if (r19 != null) goto L30;
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
    L30:
        addTarget(this.end, r19, -r20);
        goto L31
    L21:
        ConstraintAnchor r22 = r12.mTop;
        ConstraintAnchor r23 = r13.mBottom;
        DependencyNode r24 = getTarget(r22, 1);
        int r25 = r22.getMargin();
        ConstraintWidget r26 = getFirstVisibleWidget();
        if (r26 == null) goto L24;
        r25 = r26.mTop.getMargin();
    L24:
        if (r24 == null) goto L26;
        addTarget(this.start, r24, r25);
    L26:
        r19 = getTarget(r23, 1);
        r20 = r23.getMargin();
        ConstraintWidget r27 = getLastVisibleWidget();
        if (r27 == null) goto L29;
        r20 = r27.mBottom.getMargin();
    L29:
        if (r19 == null) goto L31;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r10 = 0;
    L4:
        if (r10 >= this.widgets.size()) goto L6;
        this.widgets.get(r10).applyToWidget();
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> r10 = this.widgets.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().clear();
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r10 = this.widgets.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        WidgetRun r13 = this.widgets.get(r12);
        r11 = ((r11 + ((long) r13.start.margin)) + r13.getWrapDimension()) + ((long) r13.end.margin);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int r10 = this.widgets.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (this.widgets.get(r11).supportsWrapComputation() == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("ChainRun ");
        if (this.orientation != 0) goto L5;
        String r11 = "horizontal : ";
    L6:
        r10.append(r11);
        Iterator<WidgetRun> r12 = this.widgets.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        WidgetRun r13 = r12.next();
        r10.append("<");
        r10.append(r13);
        r10.append("> ");
        goto L8
    L11:
        return r10.toString();
    L5:
        r11 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r27) {
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L330;
        ConstraintWidget r10 = this.widget.getParent();
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L10;
        boolean r11 = ((ConstraintWidgetContainer) r10).isRtl();
    L11:
        int r12 = this.end.value - this.start.value;
        int r13 = this.widgets.size();
        int r14 = 0;
    L12:
        int r15 = -1;
        int r16 = 8;
        if (r14 >= r13) goto L17;
        if (this.widgets.get(r14).widget.getVisibility() != 8) goto L18;
        r14 = r14 + 1;
    L18:
        int r17 = r13 - 1;
        int r18 = r17;
    L19:
        if (r18 < 0) goto L24;
        if (this.widgets.get(r18).widget.getVisibility() != 8) goto L23;
        r18 = r18 - 1;
        goto L19
    L23:
        r15 = r18;
    L24:
        int r19 = 0;
    L26:
        if (r19 >= 2) goto L75;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        float r114 = 0.0f;
    L28:
        if (r110 >= r13) goto L70;
        WidgetRun r20 = this.widgets.get(r110);
        if (r20.widget.getVisibility() == r16) goto L69;
        r113 = r113 + 1;
        if (r110 <= 0) goto L36;
        if (r110 < r14) goto L36;
        r111 = r111 + r20.start.margin;
    L36:
        DimensionDependency r115 = r20.dimension;
        int r21 = r115.value;
        if (r20.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r116 = true;
    L40:
        if (r116 == false) goto L52;
        int r117 = this.orientation;
        if (r117 != 0) goto L47;
        if (r20.widget.horizontalRun.dimension.resolved == true) goto L47;
        return;
    L47:
        if (r117 == 1) goto L49;
    L51:
        int r118 = r21;
    L60:
        int r22 = r118;
    L61:
        if (r116 == true) goto L65;
        r112 = r112 + 1;
        float r23 = r20.widget.mWeight[this.orientation];
        if (r23 < 0.0f) goto L66;
        r114 = r114 + r23;
    L66:
        if (r110 >= r17) goto L69;
        if (r110 >= r15) goto L69;
        r111 = r111 + (-r20.end.margin);
        goto L69
    L65:
        r111 = r111 + r22;
        goto L66
    L49:
        if (r20.widget.verticalRun.dimension.resolved == true) goto L51;
        return;
    L52:
        r118 = r21;
        if (r20.matchConstraintsType != 1) goto L57;
        if (r19 != 0) goto L57;
        r22 = r115.wrapValue;
        r112 = r112 + 1;
    L59:
        r116 = true;
    L57:
        if (r115.resolved == false) goto L60;
        r22 = r118;
        goto L59
    L39:
        r116 = false;
    L69:
        r110 = r110 + 1;
        r16 = 8;
        goto L28
    L70:
        if (r111 < r12) goto L74;
        if (r112 == 0) goto L74;
        r19 = r19 + 1;
        r16 = 8;
    L74:
        int r24 = r113;
    L76:
        int r25 = this.start.value;
        if (r11 == false) goto L80;
        r25 = this.end.value;
    L80:
        if (r111 <= r12) goto L85;
        int r119 = (int) (((r111 - r12) / 2.0f) + 0.5f);
        if (r11 == false) goto L84;
        r25 = r25 + r119;
        goto L85
    L84:
        r25 = r25 - r119;
    L85:
        if (r112 <= 0) goto L137;
        float r120 = r12 - r111;
        int r121 = (int) ((r120 / r112) + 0.5f);
        int r122 = 0;
        int r123 = 0;
    L87:
        if (r122 >= r13) goto L115;
        WidgetRun r26 = this.widgets.get(r122);
        int r124 = r121;
        int r28 = r111;
        if (r26.widget.getVisibility() != 8) goto L92;
    L113:
        r11 = r11;
        r25 = r25;
        r120 = r120;
    L114:
        r122 = r122 + 1;
        r121 = r124;
        r111 = r28;
        r25 = r25;
        r120 = r120;
        r11 = r11;
        r24 = r24;
        goto L87
    L92:
        if (r26.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L113;
        DimensionDependency r125 = r26.dimension;
        if (r125.resolved == true) goto L113;
        if (r114 <= 0.0f) goto L98;
        int r29 = (int) (((r26.widget.mWeight[this.orientation] * r120) / r114) + 0.5f);
    L100:
        if (this.orientation != 0) goto L102;
        ConstraintWidget r126 = r26.widget;
        int r127 = r126.mMatchConstraintMaxWidth;
        int r128 = r126.mMatchConstraintMinWidth;
    L104:
        if (r26.matchConstraintsType != 1) goto L106;
        int r30 = Math.min(r29, r125.wrapValue);
    L107:
        int r31 = Math.max(r128, r30);
        if (r127 <= 0) goto L110;
        r31 = Math.min(r127, r31);
    L110:
        if (r31 == r29) goto L112;
        r123 = r123 + 1;
        r29 = r31;
    L112:
        r26.dimension.resolve(r29);
        goto L114
    L106:
        r30 = r29;
        goto L107
    L102:
        ConstraintWidget r129 = r26.widget;
        int r130 = r129.mMatchConstraintMaxHeight;
        r128 = r129.mMatchConstraintMinHeight;
        r127 = r130;
        goto L104
    L98:
        r29 = r124;
        goto L100
    L115:
        boolean r210 = r11;
        int r211 = r24;
        int r212 = r25;
        int r213 = r111;
        if (r123 <= 0) goto L131;
        r112 = r112 - r123;
        int r32 = 0;
        int r33 = 0;
    L118:
        if (r32 >= r13) goto L130;
        WidgetRun r34 = this.widgets.get(r32);
        if (r34.widget.getVisibility() == 8) goto L129;
        if (r32 <= 0) goto L125;
        if (r32 < r14) goto L125;
        r33 = r33 + r34.start.margin;
    L125:
        r33 = r33 + r34.dimension.value;
        if (r32 >= r17) goto L129;
        if (r32 >= r15) goto L129;
        r33 = r33 + (-r34.end.margin);
    L129:
        r32 = r32 + 1;
        goto L118
    L130:
        r111 = r33;
    L132:
        int r35 = 2;
        if (this.chainStyle != 2) goto L136;
        if (r123 != 0) goto L136;
        int r36 = 0;
        this.chainStyle = 0;
    L138:
        if (r111 <= r12) goto L140;
        this.chainStyle = r35;
    L140:
        if (r211 <= 0) goto L144;
        if (r112 != 0) goto L144;
        if (r14 != r15) goto L144;
        this.chainStyle = r35;
    L144:
        int r37 = this.chainStyle;
        int r38 = r211;
        if (r37 != 1) goto L193;
        if (r38 <= 1) goto L148;
        int r39 = (r12 - r111) / (r38 - 1);
    L151:
        if (r112 <= 0) goto L153;
        r39 = r36;
    L153:
        int r40 = r36;
        int r41 = r212;
    L154:
        if (r40 >= r13) goto L331;
        if (r210 == false) goto L157;
        int r42 = r13 - (r40 + 1);
    L158:
        WidgetRun r43 = this.widgets.get(r42);
        if (r43.widget.getVisibility() != 8) goto L161;
        r43.start.resolve(r41);
        r43.end.resolve(r41);
    L192:
        r40 = r40 + 1;
        goto L154
    L161:
        if (r40 <= 0) goto L165;
        if (r210 == false) goto L164;
        r41 = r41 - r39;
        goto L165
    L164:
        r41 = r41 + r39;
    L165:
        if (r40 <= 0) goto L171;
        if (r40 < r14) goto L171;
        int r44 = r43.start.margin;
        if (r210 == false) goto L170;
        r41 = r41 - r44;
        goto L171
    L170:
        r41 = r41 + r44;
    L171:
        if (r210 == false) goto L173;
        DependencyNode r45 = r43.end;
    L174:
        r45.resolve(r41);
        DimensionDependency r46 = r43.dimension;
        int r131 = r46.value;
        if (r43.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L177;
    L179:
        if (r210 == false) goto L181;
        r41 = r41 - r131;
    L182:
        if (r210 == false) goto L184;
        DependencyNode r47 = r43.start;
    L185:
        r47.resolve(r41);
        r43.resolved = true;
        if (r40 >= r17) goto L192;
        if (r40 >= r15) goto L192;
        int r48 = -r43.end.margin;
        if (r210 == false) goto L191;
        r41 = r41 - r48;
        goto L192
    L191:
        r41 = r41 + r48;
        goto L192
    L184:
        r47 = r43.end;
        goto L185
    L181:
        r41 = r41 + r131;
        goto L182
    L177:
        if (r43.matchConstraintsType != 1) goto L179;
        r131 = r46.wrapValue;
        goto L179
    L173:
        r45 = r43.start;
        goto L174
    L157:
        r42 = r40;
        goto L158
    L331:
        return;
    L148:
        if (r38 != 1) goto L150;
        r39 = (r12 - r111) / 2;
        goto L151
    L150:
        r39 = r36;
        goto L151
    L193:
        if (r37 != 0) goto L237;
        int r49 = (r12 - r111) / (r38 + 1);
        if (r112 <= 0) goto L197;
        r49 = r36;
    L197:
        int r50 = r36;
        int r51 = r212;
    L198:
        if (r50 >= r13) goto L332;
        if (r210 == false) goto L201;
        int r52 = r13 - (r50 + 1);
    L202:
        WidgetRun r53 = this.widgets.get(r52);
        if (r53.widget.getVisibility() != 8) goto L205;
        r53.start.resolve(r51);
        r53.end.resolve(r51);
    L235:
        r50 = r50 + 1;
        goto L198
    L205:
        if (r210 == false) goto L207;
        int r54 = r51 - r49;
    L208:
        if (r50 <= 0) goto L214;
        if (r50 < r14) goto L214;
        int r55 = r53.start.margin;
        if (r210 == false) goto L213;
        r54 = r54 - r55;
        goto L214
    L213:
        r54 = r54 + r55;
    L214:
        if (r210 == false) goto L216;
        DependencyNode r56 = r53.end;
    L217:
        r56.resolve(r54);
        DimensionDependency r57 = r53.dimension;
        int r132 = r57.value;
        if (r53.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L220;
    L222:
        if (r210 == false) goto L224;
        r51 = r54 - r132;
    L225:
        if (r210 == false) goto L227;
        DependencyNode r58 = r53.start;
    L228:
        r58.resolve(r51);
        if (r50 >= r17) goto L235;
        if (r50 >= r15) goto L235;
        int r59 = -r53.end.margin;
        if (r210 == false) goto L234;
        r51 = r51 - r59;
        goto L235
    L234:
        r51 = r51 + r59;
        goto L235
    L227:
        r58 = r53.end;
        goto L228
    L224:
        r51 = r54 + r132;
        goto L225
    L220:
        if (r53.matchConstraintsType != 1) goto L222;
        r132 = Math.min(r132, r57.wrapValue);
        goto L222
    L216:
        r56 = r53.start;
        goto L217
    L207:
        r54 = r51 + r49;
        goto L208
    L201:
        r52 = r50;
        goto L202
    L332:
        return;
    L237:
        if (r37 == 2) goto L239;
        return;
    L239:
        if (this.orientation != 0) goto L241;
        float r60 = this.widget.getHorizontalBiasPercent();
    L242:
        if (r210 == false) goto L244;
        r60 = 1.0f - r60;
    L244:
        int r61 = (int) (((r12 - r111) * r60) + 0.5f);
        if (r61 < 0) goto L247;
        if (r112 > 0) goto L247;
    L248:
        if (r210 == false) goto L250;
        int r62 = r212 - r61;
    L251:
        int r63 = r36;
    L252:
        if (r63 >= r13) goto L333;
        if (r210 == false) goto L255;
        int r64 = r13 - (r63 + 1);
    L256:
        WidgetRun r65 = this.widgets.get(r64);
        if (r65.widget.getVisibility() != 8) goto L259;
        r65.start.resolve(r62);
        r65.end.resolve(r62);
    L287:
        r63 = r63 + 1;
        goto L252
    L259:
        if (r63 <= 0) goto L265;
        if (r63 < r14) goto L265;
        int r66 = r65.start.margin;
        if (r210 == false) goto L264;
        r62 = r62 - r66;
        goto L265
    L264:
        r62 = r62 + r66;
    L265:
        if (r210 == false) goto L267;
        DependencyNode r67 = r65.end;
    L268:
        r67.resolve(r62);
        DimensionDependency r68 = r65.dimension;
        int r133 = r68.value;
        if (r65.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L274;
        if (r65.matchConstraintsType != 1) goto L274;
        r133 = r68.wrapValue;
    L274:
        if (r210 == false) goto L276;
        r62 = r62 - r133;
    L277:
        if (r210 == false) goto L279;
        DependencyNode r69 = r65.start;
    L280:
        r69.resolve(r62);
        if (r63 >= r17) goto L287;
        if (r63 >= r15) goto L287;
        int r70 = -r65.end.margin;
        if (r210 == false) goto L286;
        r62 = r62 - r70;
        goto L287
    L286:
        r62 = r62 + r70;
        goto L287
    L279:
        r69 = r65.end;
        goto L280
    L276:
        r62 = r62 + r133;
        goto L277
    L267:
        r67 = r65.start;
        goto L268
    L255:
        r64 = r63;
        goto L256
    L333:
        return;
    L250:
        r62 = r212 + r61;
    L247:
        r61 = r36;
        goto L248
    L241:
        r60 = this.widget.getVerticalBiasPercent();
    L136:
        r36 = 0;
        goto L138
    L131:
        r111 = r213;
        goto L132
    L137:
        r210 = r11;
        r211 = r24;
        r212 = r25;
        r36 = 0;
        r35 = 2;
        goto L138
    L75:
        r24 = 0;
        r111 = 0;
        r112 = 0;
        r114 = 0.0f;
        goto L76
    L17:
        r14 = -1;
        goto L18
    L10:
        r11 = false;
        goto L11
    }
}

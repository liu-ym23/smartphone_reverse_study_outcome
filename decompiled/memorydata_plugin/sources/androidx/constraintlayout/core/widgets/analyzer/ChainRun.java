package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget r1, int r2) {
        super(r1);
        this.widgets = new ArrayList();
        this.orientation = r2;
        build();
    }

    private void build() {
        ConstraintWidget r0 = this.widget;
    L3:
        ConstraintWidget r1 = r0;
        r0 = r0.getPreviousChainMember(this.orientation);
        if (r0 != null) goto L3;
        this.widget = r1;
        this.widgets.add(r1.getRun(this.orientation));
        ConstraintWidget r2 = r1.getNextChainMember(this.orientation);
    L7:
        if (r2 == null) goto L9;
        this.widgets.add(r2.getRun(this.orientation));
        r2 = r2.getNextChainMember(this.orientation);
        goto L7
    L9:
        Iterator<WidgetRun> r3 = this.widgets.iterator();
    L11:
        if (r3.hasNext() == false) goto L19;
        WidgetRun r4 = (WidgetRun) ZeusTransformUtils.preCheckCast(r3.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (this.orientation == 0) goto L14;
        if (this.orientation != 1) goto L11;
        r4.widget.verticalChainRun = this;
        goto L11
    L14:
        r4.widget.horizontalChainRun = this;
        goto L11
    L19:
        if (this.orientation == 0) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L29;
        if (this.widgets.size() <= 1) goto L29;
        ArrayList<WidgetRun> r6 = this.widgets;
        this.widget = ((WidgetRun) ZeusTransformUtils.preCheckCast(r6.get(r6.size() - 1), WidgetRun.class, "com.obric.memorydata.plugin")).widget;
    L29:
        if (this.orientation != 0) goto L31;
        int r7 = this.widget.getHorizontalChainStyle();
    L32:
        this.chainStyle = r7;
        return;
    L31:
        r7 = this.widget.getVerticalChainStyle();
        goto L32
    L21:
        if (((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(this.widget.getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).isRtl() == false) goto L23;
        r5 = true;
        goto L24
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.widgets.size()) goto L10;
        WidgetRun r1 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r0), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r1.widget.getVisibility() != 8) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.widget;
    L10:
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int r0 = this.widgets.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        WidgetRun r1 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r0), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r1.widget.getVisibility() != 8) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.widget;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> r0 = this.widgets.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r0.next(), WidgetRun.class, "com.obric.memorydata.plugin")).apply();
        goto L4
    L6:
        int r1 = this.widgets.size();
        if (r1 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r3 = ((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(0), WidgetRun.class, "com.obric.memorydata.plugin")).widget;
        ConstraintWidget r2 = ((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r1 - 1), WidgetRun.class, "com.obric.memorydata.plugin")).widget;
        if (this.orientation != 0) goto L21;
        ConstraintAnchor r4 = r3.mLeft;
        ConstraintAnchor r5 = r2.mRight;
        DependencyNode r6 = getTarget(r4, 0);
        int r7 = r4.getMargin();
        ConstraintWidget r8 = getFirstVisibleWidget();
        if (r8 == null) goto L14;
        r7 = r8.mLeft.getMargin();
    L14:
        if (r6 == null) goto L16;
        addTarget(this.start, r6, r7);
    L16:
        DependencyNode r9 = getTarget(r5, 0);
        int r10 = r5.getMargin();
        ConstraintWidget r11 = getLastVisibleWidget();
        if (r11 == null) goto L19;
        r10 = r11.mRight.getMargin();
    L19:
        if (r9 != null) goto L30;
    L31:
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        return;
    L30:
        addTarget(this.end, r9, -r10);
        goto L31
    L21:
        ConstraintAnchor r12 = r3.mTop;
        ConstraintAnchor r13 = r2.mBottom;
        DependencyNode r14 = getTarget(r12, 1);
        int r15 = r12.getMargin();
        ConstraintWidget r16 = getFirstVisibleWidget();
        if (r16 == null) goto L24;
        r15 = r16.mTop.getMargin();
    L24:
        if (r14 == null) goto L26;
        addTarget(this.start, r14, r15);
    L26:
        r9 = getTarget(r13, 1);
        r10 = r13.getMargin();
        ConstraintWidget r17 = getLastVisibleWidget();
        if (r17 == null) goto L29;
        r10 = r17.mBottom.getMargin();
    L29:
        if (r9 == null) goto L31;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int r0 = 0;
    L4:
        if (r0 >= this.widgets.size()) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r0), WidgetRun.class, "com.obric.memorydata.plugin")).applyToWidget();
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> r3 = this.widgets.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r3.next(), WidgetRun.class, "com.obric.memorydata.plugin")).clear();
        goto L4
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int r0 = this.widgets.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        WidgetRun r4 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r3), WidgetRun.class, "com.obric.memorydata.plugin");
        r1 = ((r1 + ((long) r4.start.margin)) + r4.getWrapDimension()) + ((long) r4.end.margin);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int r0 = this.widgets.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r2), WidgetRun.class, "com.obric.memorydata.plugin")).supportsWrapComputation() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChainRun ");
        if (this.orientation != 0) goto L5;
        String r1 = "horizontal : ";
    L6:
        r0.append(r1);
        Iterator<WidgetRun> r4 = this.widgets.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        WidgetRun r2 = (WidgetRun) ZeusTransformUtils.preCheckCast(r4.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        r0.append("<");
        r0.append(r2);
        r0.append("> ");
        goto L8
    L11:
        return r0.toString();
    L5:
        r1 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r25) {
        Dependency r1 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r25, Dependency.class, "com.obric.memorydata.plugin");
        if (this.start.resolved == true) goto L5;
        return;
    L5:
        if (this.end.resolved == false) goto L327;
        ConstraintWidget r2 = this.widget.getParent();
        if (ZeusTransformUtils.instanceOf(r2, ConstraintWidgetContainer.class) == false) goto L10;
        boolean r3 = ((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r2, ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).isRtl();
    L11:
        int r4 = this.end.value - this.start.value;
        int r5 = this.widgets.size();
        int r6 = 0;
    L12:
        int r7 = -1;
        int r8 = 8;
        if (r6 >= r5) goto L17;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r6), WidgetRun.class, "com.obric.memorydata.plugin")).widget.getVisibility() != 8) goto L18;
        r6 = r6 + 1;
    L18:
        int r9 = r5 - 1;
        int r10 = r9;
    L19:
        if (r10 < 0) goto L24;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r10), WidgetRun.class, "com.obric.memorydata.plugin")).widget.getVisibility() != 8) goto L23;
        r10 = r10 - 1;
        goto L19
    L23:
        r7 = r10;
    L24:
        int r11 = 0;
    L26:
        if (r11 >= 2) goto L72;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        float r18 = 0.0f;
    L28:
        if (r14 >= r5) goto L67;
        WidgetRun r12 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r14), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r12.widget.getVisibility() == r8) goto L66;
        r17 = r17 + 1;
        if (r14 <= 0) goto L36;
        if (r14 < r6) goto L36;
        r15 = r15 + r12.start.margin;
    L36:
        int r13 = r12.dimension.value;
        if (r12.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r19 = true;
    L40:
        if (r19 == false) goto L52;
        if (this.orientation != 0) goto L47;
        if (r12.widget.horizontalRun.dimension.resolved == true) goto L47;
        return;
    L47:
        if (this.orientation == 1) goto L49;
    L58:
        if (r19 == true) goto L62;
        r16 = r16 + 1;
        float r20 = r12.widget.mWeight[this.orientation];
        if (r20 < 0.0f) goto L63;
        r18 = r18 + r20;
    L63:
        if (r14 >= r9) goto L66;
        if (r14 >= r7) goto L66;
        r15 = r15 + (-r12.end.margin);
        goto L66
    L62:
        r15 = r15 + r13;
        goto L63
    L49:
        if (r12.widget.verticalRun.dimension.resolved == true) goto L58;
        return;
    L52:
        if (r12.matchConstraintsType != 1) goto L56;
        if (r11 != 0) goto L56;
        r13 = r12.dimension.wrapValue;
        r16 = r16 + 1;
    L57:
        r19 = true;
    L56:
        if (r12.dimension.resolved == false) goto L58;
    L39:
        r19 = false;
    L66:
        r14 = r14 + 1;
        r8 = 8;
        goto L28
    L67:
        if (r15 < r4) goto L71;
        if (r16 == 0) goto L71;
        r11 = r11 + 1;
        r8 = 8;
    L71:
        int r21 = r16;
        int r22 = r17;
    L73:
        int r110 = this.start.value;
        if (r3 == false) goto L77;
        r110 = this.end.value;
    L77:
        if (r15 <= r4) goto L82;
        int r111 = (int) (((r15 - r4) / 2.0f) + 0.5f);
        if (r3 == false) goto L81;
        r110 = r110 + r111;
        goto L82
    L81:
        r110 = r110 - r111;
    L82:
        if (r21 <= 0) goto L134;
        float r112 = r4 - r15;
        int r113 = (int) ((r112 / r21) + 0.5f);
        int r114 = 0;
        int r115 = 0;
    L84:
        if (r114 >= r5) goto L112;
        int r116 = r113;
        WidgetRun r117 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r114), WidgetRun.class, "com.obric.memorydata.plugin");
        int r23 = r15;
        if (r117.widget.getVisibility() != 8) goto L89;
    L110:
        r112 = r112;
    L111:
        r114 = r114 + 1;
        r113 = r116;
        r15 = r23;
        r112 = r112;
        r110 = r110;
        r3 = r3;
        goto L84
    L89:
        if (r117.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L110;
        if (r117.dimension.resolved == true) goto L110;
        if (r18 <= 0.0f) goto L95;
        int r118 = (int) (((r117.widget.mWeight[this.orientation] * r112) / r18) + 0.5f);
    L97:
        if (this.orientation != 0) goto L99;
        int r119 = r117.widget.mMatchConstraintMaxWidth;
        int r120 = r117.widget.mMatchConstraintMinWidth;
    L101:
        if (r117.matchConstraintsType != 1) goto L103;
        int r24 = Math.min(r118, r117.dimension.wrapValue);
    L104:
        int r26 = Math.max(r120, r24);
        if (r119 <= 0) goto L107;
        r26 = Math.min(r119, r26);
    L107:
        if (r26 == r118) goto L109;
        r115 = r115 + 1;
        r118 = r26;
    L109:
        r117.dimension.resolve(r118);
        goto L111
    L103:
        r24 = r118;
        goto L104
    L99:
        r119 = r117.widget.mMatchConstraintMaxHeight;
        r120 = r117.widget.mMatchConstraintMinHeight;
        goto L101
    L95:
        r118 = r116;
        goto L97
    L112:
        boolean r27 = r3;
        int r28 = r110;
        int r29 = r15;
        if (r115 <= 0) goto L128;
        r21 = r21 - r115;
        int r30 = 0;
        int r121 = 0;
    L115:
        if (r30 >= r5) goto L127;
        WidgetRun r122 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r30), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r122.widget.getVisibility() == 8) goto L126;
        if (r30 <= 0) goto L122;
        if (r30 < r6) goto L122;
        r121 = r121 + r122.start.margin;
    L122:
        r121 = r121 + r122.dimension.value;
        if (r30 >= r9) goto L126;
        if (r30 >= r7) goto L126;
        r121 = r121 + (-r122.end.margin);
    L126:
        r30 = r30 + 1;
        goto L115
    L127:
        r15 = r121;
    L129:
        int r123 = 2;
        if (this.chainStyle != 2) goto L133;
        if (r115 != 0) goto L133;
        int r31 = 0;
        this.chainStyle = 0;
    L135:
        if (r15 <= r4) goto L137;
        this.chainStyle = r123;
    L137:
        if (r22 <= 0) goto L141;
        if (r21 != 0) goto L141;
        if (r6 != r7) goto L141;
        this.chainStyle = r123;
    L141:
        int r124 = this.chainStyle;
        if (r124 != 1) goto L190;
        if (r22 <= 1) goto L145;
        int r32 = (r4 - r15) / (r22 - 1);
    L148:
        if (r21 <= 0) goto L150;
        r32 = r31;
    L150:
        int r33 = r31;
        int r125 = r28;
    L151:
        if (r33 >= r5) goto L328;
        if (r27 == false) goto L154;
        int r34 = r5 - (r33 + 1);
    L155:
        WidgetRun r35 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r34), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r35.widget.getVisibility() != 8) goto L158;
        r35.start.resolve(r125);
        r35.end.resolve(r125);
    L189:
        r33 = r33 + 1;
        goto L151
    L158:
        if (r33 <= 0) goto L162;
        if (r27 == false) goto L161;
        r125 = r125 - r32;
        goto L162
    L161:
        r125 = r125 + r32;
    L162:
        if (r33 <= 0) goto L168;
        if (r33 < r6) goto L168;
        int r36 = r35.start.margin;
        if (r27 == false) goto L167;
        r125 = r125 - r36;
        goto L168
    L167:
        r125 = r125 + r36;
    L168:
        if (r27 == false) goto L170;
        DependencyNode r37 = r35.end;
    L171:
        r37.resolve(r125);
        int r38 = r35.dimension.value;
        if (r35.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L174;
    L176:
        if (r27 == false) goto L178;
        r125 = r125 - r38;
    L179:
        if (r27 == false) goto L181;
        DependencyNode r39 = r35.start;
    L182:
        r39.resolve(r125);
        r35.resolved = true;
        if (r33 >= r9) goto L189;
        if (r33 >= r7) goto L189;
        int r40 = -r35.end.margin;
        if (r27 == false) goto L188;
        r125 = r125 - r40;
        goto L189
    L188:
        r125 = r125 + r40;
        goto L189
    L181:
        r39 = r35.end;
        goto L182
    L178:
        r125 = r125 + r38;
        goto L179
    L174:
        if (r35.matchConstraintsType != 1) goto L176;
        r38 = r35.dimension.wrapValue;
        goto L176
    L170:
        r37 = r35.start;
        goto L171
    L154:
        r34 = r33;
        goto L155
    L328:
        return;
    L145:
        if (r22 != 1) goto L147;
        r32 = (r4 - r15) / 2;
        goto L148
    L147:
        r32 = r31;
        goto L148
    L190:
        if (r124 != 0) goto L234;
        int r41 = (r4 - r15) / (r22 + 1);
        if (r21 <= 0) goto L194;
        r41 = r31;
    L194:
        int r42 = r31;
        int r126 = r28;
    L195:
        if (r42 >= r5) goto L329;
        if (r27 == false) goto L198;
        int r43 = r5 - (r42 + 1);
    L199:
        WidgetRun r44 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r43), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r44.widget.getVisibility() != 8) goto L202;
        r44.start.resolve(r126);
        r44.end.resolve(r126);
    L232:
        r42 = r42 + 1;
        goto L195
    L202:
        if (r27 == false) goto L204;
        int r127 = r126 - r41;
    L205:
        if (r42 <= 0) goto L211;
        if (r42 < r6) goto L211;
        int r45 = r44.start.margin;
        if (r27 == false) goto L210;
        r127 = r127 - r45;
        goto L211
    L210:
        r127 = r127 + r45;
    L211:
        if (r27 == false) goto L213;
        DependencyNode r46 = r44.end;
    L214:
        r46.resolve(r127);
        int r47 = r44.dimension.value;
        if (r44.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L217;
    L219:
        if (r27 == false) goto L221;
        r126 = r127 - r47;
    L222:
        if (r27 == false) goto L224;
        DependencyNode r48 = r44.start;
    L225:
        r48.resolve(r126);
        if (r42 >= r9) goto L232;
        if (r42 >= r7) goto L232;
        int r49 = -r44.end.margin;
        if (r27 == false) goto L231;
        r126 = r126 - r49;
        goto L232
    L231:
        r126 = r126 + r49;
        goto L232
    L224:
        r48 = r44.end;
        goto L225
    L221:
        r126 = r127 + r47;
        goto L222
    L217:
        if (r44.matchConstraintsType != 1) goto L219;
        r47 = Math.min(r47, r44.dimension.wrapValue);
        goto L219
    L213:
        r46 = r44.start;
        goto L214
    L204:
        r127 = r126 + r41;
        goto L205
    L198:
        r43 = r42;
        goto L199
    L329:
        return;
    L234:
        if (r124 == 2) goto L236;
        return;
    L236:
        if (this.orientation != 0) goto L238;
        float r50 = this.widget.getHorizontalBiasPercent();
    L239:
        if (r27 == false) goto L241;
        r50 = 1.0f - r50;
    L241:
        int r51 = (int) (((r4 - r15) * r50) + 0.5f);
        if (r51 < 0) goto L244;
        if (r21 > 0) goto L244;
    L245:
        if (r27 == false) goto L247;
        int r128 = r28 - r51;
    L248:
        int r52 = r31;
    L249:
        if (r52 >= r5) goto L330;
        if (r27 == false) goto L252;
        int r53 = r5 - (r52 + 1);
    L253:
        WidgetRun r54 = (WidgetRun) ZeusTransformUtils.preCheckCast(this.widgets.get(r53), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r54.widget.getVisibility() != 8) goto L256;
        r54.start.resolve(r128);
        r54.end.resolve(r128);
    L284:
        r52 = r52 + 1;
        goto L249
    L256:
        if (r52 <= 0) goto L262;
        if (r52 < r6) goto L262;
        int r55 = r54.start.margin;
        if (r27 == false) goto L261;
        r128 = r128 - r55;
        goto L262
    L261:
        r128 = r128 + r55;
    L262:
        if (r27 == false) goto L264;
        DependencyNode r56 = r54.end;
    L265:
        r56.resolve(r128);
        int r57 = r54.dimension.value;
        if (r54.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L271;
        if (r54.matchConstraintsType != 1) goto L271;
        r57 = r54.dimension.wrapValue;
    L271:
        if (r27 == false) goto L273;
        r128 = r128 - r57;
    L274:
        if (r27 == false) goto L276;
        DependencyNode r58 = r54.start;
    L277:
        r58.resolve(r128);
        if (r52 >= r9) goto L284;
        if (r52 >= r7) goto L284;
        int r59 = -r54.end.margin;
        if (r27 == false) goto L283;
        r128 = r128 - r59;
        goto L284
    L283:
        r128 = r128 + r59;
        goto L284
    L276:
        r58 = r54.end;
        goto L277
    L273:
        r128 = r128 + r57;
        goto L274
    L264:
        r56 = r54.start;
        goto L265
    L252:
        r53 = r52;
        goto L253
    L330:
        return;
    L247:
        r128 = r28 + r51;
    L244:
        r51 = r31;
        goto L245
    L238:
        r50 = this.widget.getVerticalBiasPercent();
    L133:
        r31 = 0;
        goto L135
    L128:
        r15 = r29;
        goto L129
    L134:
        r27 = r3;
        r28 = r110;
        r31 = 0;
        r123 = 2;
        goto L135
    L72:
        r21 = 0;
        r22 = 0;
        r15 = 0;
        r18 = 0.0f;
        goto L73
    L17:
        r6 = -1;
        goto L18
    L10:
        r3 = false;
        goto L11
    }
}

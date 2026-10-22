package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    ArrayList<RunGroup> mGroups;
    private BasicMeasure.Measure mMeasure;
    private BasicMeasure.Measurer mMeasurer;
    private boolean mNeedBuildGraph;
    private boolean mNeedRedoMeasures;
    private ArrayList<WidgetRun> mRuns;
    private ArrayList<RunGroup> runGroups;

    public DependencyGraph(ConstraintWidgetContainer r10) {
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList();
        this.runGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = r10;
        this.mContainer = r10;
    }

    private void applyGroup(DependencyNode r10, int r11, int r12, DependencyNode r13, ArrayList<RunGroup> r14, RunGroup r15) {
        WidgetRun r16 = r10.run;
        if (r16.runGroup != null) goto L54;
        ConstraintWidgetContainer r17 = this.container;
        if (r16 != r17.horizontalRun) goto L7;
        return;
    L7:
        if (r16 == r17.verticalRun) goto L80;
        if (r15 != null) goto L11;
        r15 = new RunGroup(r16, r12);
        r14.add(r15);
    L11:
        r16.runGroup = r15;
        r15.add(r16);
        Iterator<Dependency> r18 = r16.start.dependencies.iterator();
    L13:
        if (r18.hasNext() == false) goto L17;
        Dependency r19 = r18.next();
        if ((r19 instanceof DependencyNode) == false) goto L13;
        applyGroup((DependencyNode) r19, r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<Dependency> r110 = r16.end.dependencies.iterator();
    L19:
        if (r110.hasNext() == false) goto L24;
        Dependency r20 = r110.next();
        if ((r20 instanceof DependencyNode) == false) goto L19;
        applyGroup((DependencyNode) r20, r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator<DependencyNode> r21 = r16.start.targets.iterator();
    L35:
        if (r21.hasNext() == false) goto L40;
        DependencyNode r22 = r21.next();
        if (r22 != r13) goto L39;
        r15.dual = true;
    L39:
        applyGroup(r22, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<DependencyNode> r23 = r16.end.targets.iterator();
    L42:
        if (r23.hasNext() == false) goto L47;
        DependencyNode r24 = r23.next();
        if (r24 != r13) goto L46;
        r15.dual = true;
    L46:
        applyGroup(r24, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if ((r16 instanceof VerticalWidgetRun) == false) goto L79;
        Iterator<DependencyNode> r25 = ((VerticalWidgetRun) r16).baseline.targets.iterator();
    L52:
        if (r25.hasNext() == false) goto L81;
        applyGroup(r25.next(), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if ((r16 instanceof VerticalWidgetRun) == false) goto L33;
        Iterator<Dependency> r26 = ((VerticalWidgetRun) r16).baseline.dependencies.iterator();
    L29:
        if (r26.hasNext() == false) goto L33;
        Dependency r27 = r26.next();
        if ((r27 instanceof DependencyNode) == false) goto L29;
        applyGroup((DependencyNode) r27, r11, 2, r13, r14, r15);
        goto L29
    L80:
        return;
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer r17) {
        Iterator<ConstraintWidget> r10 = r17.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L149;
        ConstraintWidget r11 = r10.next();
        ConstraintWidget.DimensionBehaviour[] r12 = r11.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r13 = r12[0];
        ConstraintWidget.DimensionBehaviour r14 = r12[1];
        if (r11.getVisibility() == 8) goto L7;
        if (r11.mMatchConstraintPercentWidth >= 1.0f) goto L14;
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r11.mMatchConstraintDefaultWidth = 2;
    L14:
        if (r11.mMatchConstraintPercentHeight >= 1.0f) goto L19;
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r11.mMatchConstraintDefaultHeight = 2;
    L19:
        if (r11.getDimensionRatio() <= 0.0f) goto L41;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r15) goto L23;
    L27:
        if (r14 == r15) goto L29;
    L33:
        if (r13 != r15) goto L41;
        if (r14 != r15) goto L41;
        if (r11.mMatchConstraintDefaultWidth != 0) goto L39;
        r11.mMatchConstraintDefaultWidth = 3;
    L39:
        if (r11.mMatchConstraintDefaultHeight != 0) goto L41;
    L32:
        r11.mMatchConstraintDefaultHeight = 3;
        goto L41
    L29:
        if (r13 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        if (r13 != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L23:
        if (r14 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r11.mMatchConstraintDefaultWidth = 3;
        goto L41
    L25:
        if (r14 != ConstraintWidget.DimensionBehaviour.FIXED) goto L27;
    L41:
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r16) goto L44;
    L50:
        ConstraintWidget.DimensionBehaviour r18 = r13;
        if (r14 == r16) goto L53;
    L59:
        ConstraintWidget.DimensionBehaviour r19 = r14;
        HorizontalWidgetRun r20 = r11.horizontalRun;
        r20.dimensionBehavior = r18;
        int r21 = r11.mMatchConstraintDefaultWidth;
        r20.matchConstraintsType = r21;
        VerticalWidgetRun r22 = r11.verticalRun;
        r22.dimensionBehavior = r19;
        int r110 = r11.mMatchConstraintDefaultHeight;
        r22.matchConstraintsType = r110;
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r18 != r23) goto L62;
    L65:
        if (r19 == r23) goto L139;
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L139;
        if (r19 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L139;
    L72:
        if (r18 != r16) goto L98;
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != r111) goto L76;
    L77:
        if (r21 == 3) goto L78;
        if (r21 == 1) goto L84;
        if (r21 != 2) goto L92;
        ConstraintWidget.DimensionBehaviour[] r112 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r113 = r112[0];
        ConstraintWidget.DimensionBehaviour r24 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r113 == r24) goto L91;
        if (r112[0] != r23) goto L98;
    L91:
        int r25 = (int) ((r11.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f);
        int r26 = r11.getHeight();
        ConstraintWidget.DimensionBehaviour r27 = r24;
        int r28 = r25;
    L97:
        ConstraintWidget.DimensionBehaviour r29 = r19;
    L148:
        this.measure(r11, r27, r28, r29, r26);
        r11.horizontalRun.dimension.resolve(r11.getWidth());
        r11.verticalRun.dimension.resolve(r11.getHeight());
        goto L7
    L92:
        ConstraintAnchor[] r30 = r11.mListAnchors;
        if (r30[0].mTarget == null) goto L96;
        if (r30[1].mTarget != null) goto L98;
    L96:
        r28 = 0;
        r26 = 0;
        r27 = r111;
        goto L97
    L84:
        measure(r11, r111, 0, r19, 0);
        DimensionDependency r31 = r11.horizontalRun.dimension;
        int r32 = r11.getWidth();
    L85:
        r31.wrapValue = r32;
        goto L4
    L78:
        if (r19 != r111) goto L80;
        measure(r11, r111, 0, r111, 0);
    L80:
        r26 = r11.getHeight();
        r28 = (int) ((r26 * r11.mDimensionRatio) + 0.5f);
    L81:
        r29 = ConstraintWidget.DimensionBehaviour.FIXED;
    L82:
        DependencyGraph this = this;
        r11 = r11;
        r27 = r29;
        goto L148
    L76:
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L77;
    L98:
        if (r19 != r16) goto L125;
        ConstraintWidget.DimensionBehaviour r114 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != r114) goto L102;
    L103:
        if (r110 == 3) goto L104;
        if (r110 == 1) goto L111;
        if (r110 != 2) goto L120;
        ConstraintWidget.DimensionBehaviour[] r33 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r34 = r33[1];
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r34 == r115) goto L119;
        if (r33[1] != r23) goto L125;
    L119:
        float r35 = r11.mMatchConstraintPercentHeight;
        r28 = r11.getWidth();
        this = this;
        r11 = r11;
        r27 = r18;
        r29 = r115;
        r26 = (int) ((r35 * r17.getHeight()) + 0.5f);
        goto L148
    L120:
        ConstraintAnchor[] r36 = r11.mListAnchors;
        if (r36[2].mTarget == null) goto L124;
        if (r36[3].mTarget != null) goto L125;
    L124:
        r28 = 0;
        r26 = 0;
        r27 = r114;
        goto L97
    L111:
        measure(r11, r18, 0, r114, 0);
    L112:
        r31 = r11.verticalRun.dimension;
        r32 = r11.getHeight();
        goto L85
    L104:
        if (r18 != r114) goto L106;
        measure(r11, r114, 0, r114, 0);
    L106:
        r28 = r11.getWidth();
        float r37 = r11.mDimensionRatio;
        if (r11.getDimensionRatioSide() != (-1)) goto L109;
        r37 = 1.0f / r37;
    L109:
        r26 = (int) ((r28 * r37) + 0.5f);
        goto L81
    L102:
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L103;
    L125:
        if (r18 != r16) goto L4;
        if (r19 != r16) goto L4;
        if (r21 == 1) goto L138;
        if (r110 == 1) goto L138;
        if (r110 != 2) goto L4;
        if (r21 != 2) goto L4;
        ConstraintWidget.DimensionBehaviour[] r38 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r39 = r38[0];
        r29 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r39 != r29) goto L4;
        if (r38[1] != r29) goto L4;
        float r40 = r11.mMatchConstraintPercentWidth;
        float r41 = r11.mMatchConstraintPercentHeight;
        r28 = (int) ((r40 * r17.getWidth()) + 0.5f);
        r26 = (int) ((r41 * r17.getHeight()) + 0.5f);
    L138:
        ConstraintWidget.DimensionBehaviour r42 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        measure(r11, r42, 0, r42, 0);
        r11.horizontalRun.dimension.wrapValue = r11.getWidth();
    L139:
        int r43 = r11.getWidth();
        if (r18 != r23) goto L142;
        r28 = (r17.getWidth() - r11.mLeft.mMargin) - r11.mRight.mMargin;
        r27 = ConstraintWidget.DimensionBehaviour.FIXED;
    L143:
        int r44 = r11.getHeight();
        if (r19 != r23) goto L146;
        r26 = (r17.getHeight() - r11.mTop.mMargin) - r11.mBottom.mMargin;
        r29 = ConstraintWidget.DimensionBehaviour.FIXED;
    L147:
        this = this;
        r11 = r11;
        goto L148
    L146:
        r26 = r44;
        r29 = r19;
        goto L147
    L142:
        r28 = r43;
        r27 = r18;
        goto L143
    L62:
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L65;
        if (r18 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L72;
    L53:
        if (r11.mMatchConstraintDefaultHeight != 1) goto L59;
        if (r11.mTop.mTarget != null) goto L57;
    L58:
        r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L59
    L57:
        if (r11.mBottom.mTarget != null) goto L59;
    L44:
        if (r11.mMatchConstraintDefaultWidth != 1) goto L50;
        if (r11.mLeft.mTarget != null) goto L48;
    L49:
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L50
    L48:
        if (r11.mRight.mTarget != null) goto L50;
    L7:
        r11.measured = true;
        goto L4
    L149:
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer r10, int r11) {
        int r12 = this.mGroups.size();
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L6;
        r13 = Math.max(r13, this.mGroups.get(r14).computeWrapSize(r10, r11));
        r14 = r14 + 1;
        goto L3
    L6:
        return (int) r13;
    }

    private void displayGraph() {
        Iterator<WidgetRun> r10 = this.mRuns.iterator();
        String r11 = "digraph {\n";
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = generateDisplayGraph(r10.next(), r11);
        goto L4
    L6:
        PrintStream r12 = System.out;
        r12.println("content:<<\n" + (r11 + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun r11, int r12, ArrayList<RunGroup> r13) {
        Iterator<Dependency> r10 = r11.start.dependencies.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Dependency r14 = r10.next();
        if ((r14 instanceof DependencyNode) == true) goto L7;
        if ((r14 instanceof WidgetRun) == false) goto L4;
        applyGroup(((WidgetRun) r14).start, r12, 0, r11.end, r13, null);
        goto L4
    L7:
        applyGroup((DependencyNode) r14, r12, 0, r11.end, r13, null);
        goto L4
    L11:
        Iterator<Dependency> r15 = r11.end.dependencies.iterator();
    L13:
        if (r15.hasNext() == false) goto L21;
        Dependency r16 = r15.next();
        if ((r16 instanceof DependencyNode) == true) goto L16;
        if ((r16 instanceof WidgetRun) == false) goto L13;
        applyGroup(((WidgetRun) r16).end, r12, 1, r11.start, r13, null);
        goto L13
    L16:
        applyGroup((DependencyNode) r16, r12, 1, r11.start, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<Dependency> r17 = ((VerticalWidgetRun) r11).baseline.dependencies.iterator();
    L24:
        if (r17.hasNext() == false) goto L50;
        Dependency r18 = r17.next();
        if ((r18 instanceof DependencyNode) == false) goto L24;
        applyGroup((DependencyNode) r18, r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }

    private String generateChainDisplayGraph(ChainRun r10, String r11) {
        int r12 = r10.orientation;
        StringBuilder r13 = new StringBuilder("subgraph ");
        r13.append("cluster_");
        r13.append(r10.widget.getDebugName());
        if (r12 != 0) goto L5;
        String r14 = "_h";
    L6:
        r13.append(r14);
        r13.append(" {\n");
        Iterator<WidgetRun> r15 = r10.widgets.iterator();
        String r16 = "";
    L8:
        if (r15.hasNext() == false) goto L14;
        WidgetRun r17 = r15.next();
        r13.append(r17.widget.getDebugName());
        if (r12 != 0) goto L12;
        String r18 = "_HORIZONTAL";
    L13:
        r13.append(r18);
        r13.append(";\n");
        r16 = generateDisplayGraph(r17, r16);
        goto L8
    L12:
        r18 = "_VERTICAL";
        goto L13
    L14:
        r13.append("}\n");
        return r11 + r16 + r13;
    L5:
        r14 = "_v";
        goto L6
    }

    private String generateDisplayGraph(WidgetRun r10, String r11) {
        DependencyNode r12 = r10.start;
        DependencyNode r13 = r10.end;
        StringBuilder r14 = new StringBuilder(r11);
        if ((r10 instanceof HelperReferences) == false) goto L5;
    L11:
        r14.append(nodeDefinition(r10));
        boolean r15 = isCenteredConnection(r12, r13);
        String r16 = generateDisplayNode(r13, r15, generateDisplayNode(r12, r15, r11));
        boolean r17 = r10 instanceof VerticalWidgetRun;
        if (r17 == false) goto L15;
        r16 = generateDisplayNode(((VerticalWidgetRun) r10).baseline, r15, r16);
    L15:
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L47;
        boolean r18 = r10 instanceof ChainRun;
        if (r18 == true) goto L19;
    L21:
        if (r17 == true) goto L25;
        if (r18 == false) goto L68;
        if (((ChainRun) r10).orientation == 1) goto L25;
    L68:
        if ((r10 instanceof ChainRun) == false) goto L72;
        return generateChainDisplayGraph((ChainRun) r10, r16);
    L72:
        return r14.toString();
    L25:
        ConstraintWidget.DimensionBehaviour r19 = r10.widget.getVerticalDimensionBehaviour();
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L37;
        if (r19 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
        if (r19 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L68;
        r14.append("\n");
        r14.append(r10.widget.getDebugName());
        r14.append("_VERTICAL -> ");
        r14.append(r10.widget.getDebugName());
        String r20 = "_HORIZONTAL;\n";
    L35:
        r14.append(r20);
    L37:
        if (r12.targets.isEmpty() == true) goto L43;
        if (r13.targets.isEmpty() == false) goto L43;
    L40:
        r14.append("\n");
        r14.append(r13.name());
        r14.append(" -> ");
        String r21 = r12.name();
    L41:
        r14.append(r21);
        r14.append("\n");
    L43:
        if (r12.targets.isEmpty() == false) goto L68;
        if (r13.targets.isEmpty() == true) goto L68;
    L46:
        r14.append("\n");
        r14.append(r12.name());
        r14.append(" -> ");
        r21 = r13.name();
        goto L41
    L19:
        if (((ChainRun) r10).orientation != 0) goto L21;
    L47:
        ConstraintWidget.DimensionBehaviour r22 = r10.widget.getHorizontalDimensionBehaviour();
        if (r22 == ConstraintWidget.DimensionBehaviour.FIXED) goto L58;
        if (r22 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L58;
        if (r22 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L68;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L68;
        r14.append("\n");
        r14.append(r10.widget.getDebugName());
        r14.append("_HORIZONTAL -> ");
        r14.append(r10.widget.getDebugName());
        r20 = "_VERTICAL;\n";
    L58:
        if (r12.targets.isEmpty() == true) goto L63;
        if (r13.targets.isEmpty() == true) goto L40;
    L63:
        if (r12.targets.isEmpty() == false) goto L68;
        if (r13.targets.isEmpty() == true) goto L68;
    L5:
        if (r12.dependencies.isEmpty() == false) goto L11;
        if ((r13.dependencies.isEmpty() & r12.targets.isEmpty()) == false) goto L11;
        if (r13.targets.isEmpty() == false) goto L11;
        return r11;
    }

    private String generateDisplayNode(DependencyNode r10, boolean r11, String r12) {
        StringBuilder r13 = new StringBuilder(r12);
        Iterator<DependencyNode> r14 = r10.targets.iterator();
    L4:
        if (r14.hasNext() == false) goto L23;
        DependencyNode r15 = r14.next();
        String r16 = ("\n" + r10.name()) + " -> " + r15.name();
        if (r10.margin > 0) goto L10;
        if (r11 == true) goto L10;
        if ((r10.run instanceof HelperReferences) == true) goto L10;
    L21:
        r13.append(r16 + "\n");
    L10:
        String r17 = r16 + "[";
        if (r10.margin <= 0) goto L15;
        r17 = r17 + "label=\"" + r10.margin + "\"";
        if (r11 == false) goto L15;
        r17 = r17 + ",";
    L15:
        if (r11 == false) goto L18;
        r17 = r17 + " style=dashed ";
    L18:
        if ((r10.run instanceof HelperReferences) == false) goto L20;
        r17 = r17 + " style=bold,color=gray ";
    L20:
        r16 = r17 + "]";
        goto L21
    L23:
        return r13.toString();
    }

    private boolean isCenteredConnection(DependencyNode r10, DependencyNode r11) {
        Iterator<DependencyNode> r12 = r10.targets.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r12.next() == r11) goto L4;
        r13 = r13 + 1;
        goto L4
    L8:
        Iterator<DependencyNode> r14 = r11.targets.iterator();
        int r15 = 0;
    L10:
        if (r14.hasNext() == false) goto L14;
        if (r14.next() == r10) goto L10;
        r15 = r15 + 1;
        goto L10
    L14:
        if (r13 <= 0) goto L28;
        if (r15 <= 0) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    }

    private void measure(ConstraintWidget r10, ConstraintWidget.DimensionBehaviour r11, int r12, ConstraintWidget.DimensionBehaviour r13, int r14) {
        BasicMeasure.Measure r15 = this.mMeasure;
        r15.horizontalBehavior = r11;
        r15.verticalBehavior = r13;
        r15.horizontalDimension = r12;
        r15.verticalDimension = r14;
        this.mMeasurer.measure(r10, r15);
        r10.setWidth(this.mMeasure.measuredWidth);
        r10.setHeight(this.mMeasure.measuredHeight);
        r10.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r10.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun r10) {
        boolean r11 = r10 instanceof VerticalWidgetRun;
        String r12 = r10.widget.getDebugName();
        StringBuilder r13 = new StringBuilder(r12);
        ConstraintWidget r14 = r10.widget;
        if (r11 == true) goto L5;
        ConstraintWidget.DimensionBehaviour r15 = r14.getHorizontalDimensionBehaviour();
    L6:
        RunGroup r16 = r10.runGroup;
        if (r11 == true) goto L9;
        String r17 = "_HORIZONTAL";
    L10:
        r13.append(r17);
        r13.append(" [shape=none, label=<");
        r13.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        r13.append("  <TR>");
        r13.append("    <TD ");
        boolean r18 = r10.start.resolved;
        if (r11 == true) goto L15;
        if (r18 == false) goto L14;
        r13.append(" BGCOLOR=\"green\"");
    L14:
        String r19 = " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
    L18:
        r13.append(r19);
        r13.append("    <TD BORDER=\"1\" ");
        boolean r20 = r10.dimension.resolved;
        if (r20 == true) goto L21;
    L23:
        if (r20 == false) goto L27;
        String r21 = " BGCOLOR=\"lightgray\" ";
    L25:
        r13.append(r21);
    L30:
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        r13.append("style=\"dashed\"");
    L32:
        r13.append(">");
        r13.append(r12);
        if (r16 == null) goto L35;
        r13.append(" [");
        r13.append(r16.groupIndex + 1);
        r13.append("/");
        r13.append(RunGroup.index);
        r13.append("]");
    L35:
        r13.append(" </TD>");
        r13.append("    <TD ");
        if (r11 == true) goto L43;
        if (r10.end.resolved == false) goto L40;
        r13.append(" BGCOLOR=\"green\"");
    L40:
        String r22 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
    L41:
        r13.append(r22);
        r13.append("  </TR></TABLE>");
        r13.append(">];\n");
        return r13.toString();
    L43:
        if (((VerticalWidgetRun) r10).baseline.resolved == false) goto L45;
        r13.append(" BGCOLOR=\"green\"");
    L45:
        r13.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
        r13.append("    <TD ");
        if (r10.end.resolved == false) goto L48;
        r13.append(" BGCOLOR=\"green\"");
    L48:
        r22 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        goto L41
    L27:
        if (r10.widget.measured == false) goto L30;
        r21 = " BGCOLOR=\"yellow\" ";
        goto L25
    L21:
        if (r10.widget.measured == true) goto L23;
        r21 = " BGCOLOR=\"green\" ";
        goto L25
    L15:
        if (r18 == false) goto L17;
        r13.append(" BGCOLOR=\"green\"");
    L17:
        r19 = " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        goto L18
    L9:
        r17 = "_VERTICAL";
        goto L10
    L5:
        r15 = r14.getVerticalDimensionBehaviour();
        goto L6
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList<WidgetRun> r10) {
        r10.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        r10.add(this.mContainer.horizontalRun);
        r10.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> r11 = this.mContainer.mChildren.iterator();
        HashSet r12 = null;
    L4:
        if (r11.hasNext() == false) goto L30;
        ConstraintWidget r13 = r11.next();
        if ((r13 instanceof Guideline) == true) goto L7;
        if (r13.isInHorizontalChain() == true) goto L12;
        r10.add(r13.horizontalRun);
    L19:
        if (r13.isInVerticalChain() == true) goto L21;
        r10.add(r13.verticalRun);
    L28:
        if ((r13 instanceof HelperWidget) == false) goto L4;
        WidgetRun r14 = new HelperReferences(r13);
    L8:
        r10.add(r14);
        goto L4
    L21:
        if (r13.verticalChainRun != null) goto L23;
        r13.verticalChainRun = new ChainRun(r13, 1);
    L23:
        if (r12 != null) goto L25;
        r12 = new HashSet();
    L25:
        r12.add(r13.verticalChainRun);
        goto L28
    L12:
        if (r13.horizontalChainRun != null) goto L14;
        r13.horizontalChainRun = new ChainRun(r13, 0);
    L14:
        if (r12 != null) goto L16;
        r12 = new HashSet();
    L16:
        r12.add(r13.horizontalChainRun);
        goto L19
    L7:
        r14 = new GuidelineReference(r13);
        goto L8
    L30:
        if (r12 == null) goto L32;
        r10.addAll(r12);
    L32:
        Iterator<WidgetRun> r15 = r10.iterator();
    L34:
        if (r15.hasNext() == false) goto L36;
        r15.next().clear();
        goto L34
    L36:
        Iterator<WidgetRun> r16 = r10.iterator();
    L38:
        if (r16.hasNext() == false) goto L43;
        WidgetRun r17 = r16.next();
        if (r17.widget == this.mContainer) goto L38;
        r17.apply();
        goto L38
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour r10, ConstraintWidget.DimensionBehaviour r11) {
        if (this.mNeedBuildGraph == false) goto L22;
        buildGraph();
        Iterator<ConstraintWidget> r12 = this.container.mChildren.iterator();
        boolean r13 = false;
    L6:
        if (r12.hasNext() == false) goto L10;
        ConstraintWidget r14 = r12.next();
        boolean[] r15 = r14.isTerminalWidget;
        r15[0] = true;
        r15[1] = true;
        if ((r14 instanceof Barrier) == false) goto L6;
        r13 = true;
        goto L6
    L10:
        if (r13 == true) goto L31;
        Iterator<RunGroup> r16 = this.mGroups.iterator();
    L13:
        if (r16.hasNext() == false) goto L32;
        RunGroup r17 = r16.next();
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r10 != r18) goto L17;
        boolean r19 = true;
    L18:
        if (r11 != r18) goto L20;
        boolean r20 = true;
    L21:
        r17.defineTerminalWidgets(r19, r20);
        goto L13
    L20:
        r20 = false;
        goto L21
    L17:
        r19 = false;
        goto L18
    L32:
        return;
    L31:
        return;
    }

    public boolean directMeasure(boolean r10) {
        boolean r11 = true;
        boolean r12 = r10 & true;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r13 = this.container.mChildren.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ConstraintWidget r14 = r13.next();
        r14.ensureWidgetRuns();
        r14.measured = false;
        r14.horizontalRun.reset();
        r14.verticalRun.reset();
        goto L8
    L10:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r15 = this.container;
        r15.measured = false;
        r15.horizontalRun.reset();
        this.container.verticalRun.reset();
        this.mNeedRedoMeasures = false;
    L12:
        if (basicMeasureWidgets(this.mContainer) == false) goto L14;
        return false;
    L14:
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour r16 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r17 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph == false) goto L17;
        buildGraph();
    L17:
        int r18 = this.container.getX();
        int r19 = this.container.getY();
        this.container.horizontalRun.start.resolve(r18);
        this.container.verticalRun.start.resolve(r19);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 == r20) goto L20;
        if (r17 == r20) goto L20;
    L35:
        ConstraintWidgetContainer r110 = this.container;
        ConstraintWidget.DimensionBehaviour[] r21 = r110.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r22 = r21[0];
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r22 != r23) goto L38;
    L41:
        int r111 = r110.getWidth() + r18;
        this.container.horizontalRun.end.resolve(r111);
        this.container.horizontalRun.dimension.resolve(r111 - r18);
        measureWidgets();
        ConstraintWidgetContainer r112 = this.container;
        ConstraintWidget.DimensionBehaviour[] r24 = r112.mListDimensionBehaviors;
        if (r24[1] != r23) goto L44;
    L45:
        int r113 = r112.getHeight() + r19;
        this.container.verticalRun.end.resolve(r113);
        this.container.verticalRun.dimension.resolve(r113 - r19);
    L46:
        measureWidgets();
        boolean r114 = true;
    L47:
        Iterator<WidgetRun> r25 = this.mRuns.iterator();
    L49:
        if (r25.hasNext() == false) goto L56;
        WidgetRun r26 = r25.next();
        if (r26.widget != this.container) goto L55;
        if (r26.resolved == false) goto L49;
    L55:
        r26.applyToWidget();
        goto L49
    L56:
        Iterator<WidgetRun> r27 = this.mRuns.iterator();
    L58:
        if (r27.hasNext() == false) goto L79;
        WidgetRun r28 = r27.next();
        if (r114 == true) goto L65;
        if (r28.widget == this.container) goto L58;
    L65:
        if (r28.start.resolved == false) goto L66;
        if (r28.end.resolved == true) goto L73;
        if ((r28 instanceof GuidelineReference) == false) goto L66;
    L73:
        if (r28.dimension.resolved == true) goto L58;
        if ((r28 instanceof ChainRun) == true) goto L58;
        if ((r28 instanceof GuidelineReference) == true) goto L58;
    L66:
        r11 = false;
    L79:
        this.container.setHorizontalDimensionBehaviour(r16);
        this.container.setVerticalDimensionBehaviour(r17);
        return r11;
    L44:
        if (r24[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L46;
    L38:
        if (r21[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L41;
        r114 = false;
    L20:
        if (r12 == false) goto L27;
        Iterator<WidgetRun> r29 = this.mRuns.iterator();
    L23:
        if (r29.hasNext() == false) goto L27;
        if (r29.next().supportsWrapComputation() == true) goto L23;
        r12 = false;
    L27:
        if (r12 == true) goto L29;
    L31:
        if (r12 == false) goto L35;
        if (r17 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L35;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r115 = this.container;
        r115.setHeight(computeWrap(r115, 1));
        ConstraintWidgetContainer r116 = this.container;
        r116.verticalRun.dimension.resolve(r116.getHeight());
        goto L35
    L29:
        if (r16 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r30 = this.container;
        r30.setWidth(computeWrap(r30, 0));
        ConstraintWidgetContainer r31 = this.container;
        r31.horizontalRun.dimension.resolve(r31.getWidth());
        goto L31
    L5:
        if (this.mNeedRedoMeasures == false) goto L12;
        goto L6
    }

    public boolean directMeasureSetup(boolean r10) {
        if (this.mNeedBuildGraph == false) goto L10;
        Iterator<ConstraintWidget> r11 = this.container.mChildren.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ConstraintWidget r12 = r11.next();
        r12.ensureWidgetRuns();
        r12.measured = false;
        HorizontalWidgetRun r13 = r12.horizontalRun;
        r13.dimension.resolved = false;
        r13.resolved = false;
        r13.reset();
        VerticalWidgetRun r14 = r12.verticalRun;
        r14.dimension.resolved = false;
        r14.resolved = false;
        r14.reset();
        goto L6
    L8:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r15 = this.container;
        r15.measured = false;
        HorizontalWidgetRun r16 = r15.horizontalRun;
        r16.dimension.resolved = false;
        r16.resolved = false;
        r16.reset();
        VerticalWidgetRun r17 = this.container.verticalRun;
        r17.dimension.resolved = false;
        r17.resolved = false;
        r17.reset();
        buildGraph();
    L10:
        if (basicMeasureWidgets(this.mContainer) == false) goto L12;
        return false;
    L12:
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        boolean r12 = true;
        boolean r13 = r10 & true;
        ConstraintWidget.DimensionBehaviour r14 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r15 = this.container.getDimensionBehaviour(1);
        int r16 = this.container.getX();
        int r17 = this.container.getY();
        if (r13 == false) goto L25;
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 == r18) goto L7;
        if (r15 != r18) goto L25;
    L7:
        Iterator<WidgetRun> r19 = this.mRuns.iterator();
    L9:
        if (r19.hasNext() == false) goto L15;
        WidgetRun r20 = r19.next();
        if (r20.orientation != r11) goto L9;
        if (r20.supportsWrapComputation() == true) goto L9;
        r13 = false;
    L15:
        if (r11 != 0) goto L20;
        if (r13 == false) goto L25;
        if (r14 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r110 = this.container;
        r110.setWidth(computeWrap(r110, 0));
        ConstraintWidgetContainer r111 = this.container;
        DimensionDependency r21 = r111.horizontalRun.dimension;
        int r112 = r111.getWidth();
    L24:
        r21.resolve(r112);
        goto L25
    L20:
        if (r13 == false) goto L25;
        if (r15 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r113 = this.container;
        r113.setHeight(computeWrap(r113, 1));
        ConstraintWidgetContainer r114 = this.container;
        r21 = r114.verticalRun.dimension;
        r112 = r114.getHeight();
    L25:
        ConstraintWidgetContainer r115 = this.container;
        if (r11 != 0) goto L32;
        ConstraintWidget.DimensionBehaviour[] r22 = r115.mListDimensionBehaviors;
        if (r22[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L30;
    L31:
        int r116 = r115.getWidth() + r16;
        this.container.horizontalRun.end.resolve(r116);
        this.container.horizontalRun.dimension.resolve(r116 - r16);
    L39:
        boolean r117 = true;
    L40:
        measureWidgets();
        Iterator<WidgetRun> r23 = this.mRuns.iterator();
    L42:
        if (r23.hasNext() == false) goto L52;
        WidgetRun r24 = r23.next();
        if (r24.orientation != r11) goto L42;
        if (r24.widget != this.container) goto L51;
        if (r24.resolved == false) goto L42;
    L51:
        r24.applyToWidget();
        goto L42
    L52:
        Iterator<WidgetRun> r25 = this.mRuns.iterator();
    L54:
        if (r25.hasNext() == false) goto L73;
        WidgetRun r26 = r25.next();
        if (r26.orientation != r11) goto L54;
        if (r117 == true) goto L63;
        if (r26.widget == this.container) goto L54;
    L63:
        if (r26.start.resolved == false) goto L64;
        if (r26.end.resolved == false) goto L64;
        if ((r26 instanceof ChainRun) == true) goto L54;
        if (r26.dimension.resolved == true) goto L54;
    L64:
        r12 = false;
    L73:
        this.container.setHorizontalDimensionBehaviour(r14);
        this.container.setVerticalDimensionBehaviour(r15);
        return r12;
    L30:
        if (r22[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
    L37:
        r117 = false;
        goto L40
    L32:
        ConstraintWidget.DimensionBehaviour[] r27 = r115.mListDimensionBehaviors;
        if (r27[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L35;
    L38:
        int r118 = r115.getHeight() + r17;
        this.container.verticalRun.end.resolve(r118);
        this.container.verticalRun.dimension.resolve(r118 - r17);
        goto L39
    L35:
        if (r27[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L37;
        goto L37
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> r10 = this.container.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L45;
        ConstraintWidget r11 = r10.next();
        if (r11.measured == true) goto L4;
        ConstraintWidget.DimensionBehaviour[] r12 = r11.mListDimensionBehaviors;
        boolean r13 = false;
        ConstraintWidget.DimensionBehaviour r14 = r12[0];
        ConstraintWidget.DimensionBehaviour r15 = r12[1];
        int r16 = r11.mMatchConstraintDefaultWidth;
        int r17 = r11.mMatchConstraintDefaultHeight;
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 != r18) goto L11;
    L15:
        boolean r19 = true;
    L16:
        if (r15 != r18) goto L18;
    L20:
        r13 = true;
    L21:
        DimensionDependency r20 = r11.horizontalRun.dimension;
        boolean r21 = r20.resolved;
        DimensionDependency r22 = r11.verticalRun.dimension;
        boolean r110 = r22.resolved;
        if (r21 == false) goto L26;
        if (r110 == false) goto L26;
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r11, r23, r20.value, r23, r22.value);
    L25:
        r11.measured = true;
    L41:
        if (r11.measured == false) goto L4;
        DimensionDependency r24 = r11.verticalRun.baselineDimension;
        if (r24 == null) goto L4;
        r24.resolve(r11.getBaselineDistance());
    L26:
        if (r21 == false) goto L34;
        if (r13 == false) goto L34;
        measure(r11, ConstraintWidget.DimensionBehaviour.FIXED, r20.value, r18, r22.value);
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        DimensionDependency r25 = r11.verticalRun.dimension;
        int r26 = r11.getHeight();
    L31:
        r25.wrapValue = r26;
        goto L41
    L32:
        DimensionDependency r27 = r11.verticalRun.dimension;
        int r28 = r11.getHeight();
    L33:
        r27.resolve(r28);
    L34:
        if (r110 == false) goto L41;
        if (r19 == false) goto L41;
        measure(r11, r18, r20.value, ConstraintWidget.DimensionBehaviour.FIXED, r22.value);
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        r25 = r11.horizontalRun.dimension;
        r26 = r11.getWidth();
        goto L31
    L39:
        r27 = r11.horizontalRun.dimension;
        r28 = r11.getWidth();
        goto L33
    L18:
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
        if (r17 != 1) goto L21;
    L11:
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r16 == 1) goto L15;
    L14:
        r19 = false;
        goto L16
    }

    public void setMeasurer(BasicMeasure.Measurer r10) {
        this.mMeasurer = r10;
    }
}

package androidx.constraintlayout.solver.widgets.analyzer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
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

    public DependencyGraph(ConstraintWidgetContainer r5) {
        this.mNeedBuildGraph = USE_GROUPS;
        this.mNeedRedoMeasures = USE_GROUPS;
        this.mRuns = new ArrayList();
        this.runGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = r5;
        this.mContainer = r5;
    }

    private void applyGroup(DependencyNode r10, int r11, int r12, DependencyNode r13, ArrayList<RunGroup> r14, RunGroup r15) {
        WidgetRun r16 = r10.run;
        if (r16.runGroup != null) goto L54;
        ConstraintWidgetContainer r5 = this.container;
        if (r16 != r5.horizontalRun) goto L7;
        return;
    L7:
        if (r16 == r5.verticalRun) goto L80;
        if (r15 != null) goto L11;
        r15 = new RunGroup(r16, r12);
        r14.add(r15);
    L11:
        r16.runGroup = r15;
        r15.add(r16);
        Iterator<Dependency> r17 = r16.start.dependencies.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        Dependency r18 = r17.next();
        if ((r18 instanceof DependencyNode) == false) goto L13;
        applyGroup((DependencyNode) r18, r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<Dependency> r19 = r16.end.dependencies.iterator();
    L19:
        if (r19.hasNext() == false) goto L24;
        Dependency r20 = r19.next();
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
        r15.dual = USE_GROUPS;
    L39:
        applyGroup(r22, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<DependencyNode> r23 = r16.end.targets.iterator();
    L42:
        if (r23.hasNext() == false) goto L47;
        DependencyNode r24 = r23.next();
        if (r24 != r13) goto L46;
        r15.dual = USE_GROUPS;
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
        Iterator<ConstraintWidget> r5 = r17.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L143;
        ConstraintWidget r10 = r5.next();
        ConstraintWidget.DimensionBehaviour[] r11 = r10.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r12 = r11[0];
        ConstraintWidget.DimensionBehaviour r13 = r11[1];
        if (r10.getVisibility() == 8) goto L7;
        if (r10.mMatchConstraintPercentWidth >= 1.0f) goto L14;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r10.mMatchConstraintDefaultWidth = 2;
    L14:
        if (r10.mMatchConstraintPercentHeight >= 1.0f) goto L19;
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r10.mMatchConstraintDefaultHeight = 2;
    L19:
        if (r10.getDimensionRatio() <= 0.0f) goto L41;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r14) goto L23;
    L27:
        if (r13 == r14) goto L29;
    L33:
        if (r12 != r14) goto L41;
        if (r13 != r14) goto L41;
        if (r10.mMatchConstraintDefaultWidth != 0) goto L39;
        r10.mMatchConstraintDefaultWidth = 3;
    L39:
        if (r10.mMatchConstraintDefaultHeight != 0) goto L41;
        r10.mMatchConstraintDefaultHeight = 3;
        goto L41
    L29:
        if (r12 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
    L32:
        r10.mMatchConstraintDefaultHeight = 3;
        goto L41
    L31:
        if (r12 != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L23:
        if (r13 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r10.mMatchConstraintDefaultWidth = 3;
        goto L41
    L25:
        if (r13 != ConstraintWidget.DimensionBehaviour.FIXED) goto L27;
    L41:
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r15) goto L44;
    L50:
        ConstraintWidget.DimensionBehaviour r16 = r12;
        if (r13 == r15) goto L53;
    L59:
        ConstraintWidget.DimensionBehaviour r18 = r13;
        HorizontalWidgetRun r19 = r10.horizontalRun;
        r19.dimensionBehavior = r16;
        int r20 = r10.mMatchConstraintDefaultWidth;
        r19.matchConstraintsType = r20;
        VerticalWidgetRun r21 = r10.verticalRun;
        r21.dimensionBehavior = r18;
        int r110 = r10.mMatchConstraintDefaultHeight;
        r21.matchConstraintsType = r110;
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r16 != r22) goto L62;
    L65:
        if (r18 == r22) goto L134;
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L134;
        if (r18 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L134;
    L72:
        if (r16 != r15) goto L93;
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != r111) goto L76;
    L77:
        if (r20 == 3) goto L78;
        if (r20 != 1) goto L83;
        measure(r10, r111, 0, r18, 0);
        r10.horizontalRun.dimension.wrapValue = r10.getWidth();
        goto L4
    L83:
        if (r20 == 2) goto L84;
        ConstraintAnchor[] r112 = r10.mListAnchors;
        if (r112[0].mTarget == null) goto L92;
        if (r112[1].mTarget != null) goto L93;
    L92:
        measure(r10, r111, 0, r18, 0);
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L84:
        ConstraintWidget.DimensionBehaviour r113 = r17.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r114 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r113 == r114) goto L87;
        if (r113 != r22) goto L93;
    L87:
        measure(r10, r114, (int) ((r10.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f), r18, r10.getHeight());
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L78:
        if (r18 != r111) goto L80;
        measure(r10, r111, 0, r111, 0);
    L80:
        int r23 = r10.getHeight();
        int r24 = (int) ((r23 * r10.mDimensionRatio) + 0.5f);
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r10, r25, r24, r25, r23);
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L76:
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L77;
    L93:
        if (r18 != r15) goto L118;
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 != r115) goto L97;
    L98:
        if (r110 == 3) goto L99;
        if (r110 != 1) goto L108;
        measure(r10, r16, 0, r115, 0);
        r10.verticalRun.dimension.wrapValue = r10.getHeight();
        goto L4
    L108:
        if (r110 == 2) goto L109;
        ConstraintAnchor[] r26 = r10.mListAnchors;
        if (r26[2].mTarget == null) goto L117;
        if (r26[3].mTarget != null) goto L118;
    L117:
        measure(r10, r115, 0, r18, 0);
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L109:
        ConstraintWidget.DimensionBehaviour r27 = r17.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour r28 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r27 == r28) goto L112;
        if (r27 != r22) goto L118;
    L112:
        measure(r10, r16, r10.getWidth(), r28, (int) ((r10.mMatchConstraintPercentHeight * r17.getHeight()) + 0.5f));
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L99:
        if (r16 != r115) goto L101;
        measure(r10, r115, 0, r115, 0);
    L101:
        int r29 = r10.getWidth();
        float r30 = r10.mDimensionRatio;
        if (r10.getDimensionRatioSide() != (-1)) goto L104;
        r30 = 1.0f / r30;
    L104:
        ConstraintWidget.DimensionBehaviour r31 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r10, r31, r29, r31, (int) ((r29 * r30) + 0.5f));
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L97:
        if (r16 == ConstraintWidget.DimensionBehaviour.FIXED) goto L98;
    L118:
        if (r16 != r15) goto L4;
        if (r18 != r15) goto L4;
        if (r20 == 1) goto L133;
        if (r110 == 1) goto L133;
        if (r110 != 2) goto L4;
        if (r20 != 2) goto L4;
        ConstraintWidget.DimensionBehaviour[] r32 = r17.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r33 = r32[0];
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r33 == r34) goto L129;
        if (r33 != r34) goto L4;
    L129:
        ConstraintWidget.DimensionBehaviour r35 = r32[1];
        if (r35 == r34) goto L132;
        if (r35 != r34) goto L4;
    L132:
        measure(r10, r34, (int) ((r10.mMatchConstraintPercentWidth * r17.getWidth()) + 0.5f), r34, (int) ((r10.mMatchConstraintPercentHeight * r17.getHeight()) + 0.5f));
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
    L133:
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        measure(r10, r36, 0, r36, 0);
        r10.horizontalRun.dimension.wrapValue = r10.getWidth();
        r10.verticalRun.dimension.wrapValue = r10.getHeight();
    L134:
        int r37 = r10.getWidth();
        if (r16 != r22) goto L137;
        int r38 = (r17.getWidth() - r10.mLeft.mMargin) - r10.mRight.mMargin;
        ConstraintWidget.DimensionBehaviour r39 = ConstraintWidget.DimensionBehaviour.FIXED;
    L138:
        int r40 = r10.getHeight();
        if (r18 != r22) goto L141;
        int r41 = (r17.getHeight() - r10.mTop.mMargin) - r10.mBottom.mMargin;
        ConstraintWidget.DimensionBehaviour r42 = ConstraintWidget.DimensionBehaviour.FIXED;
    L142:
        measure(r10, r39, r38, r42, r41);
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
        goto L4
    L141:
        r41 = r40;
        r42 = r18;
        goto L142
    L137:
        r38 = r37;
        r39 = r16;
        goto L138
    L62:
        if (r16 == ConstraintWidget.DimensionBehaviour.FIXED) goto L65;
        if (r16 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L72;
    L53:
        if (r10.mMatchConstraintDefaultHeight != 1) goto L59;
        if (r10.mTop.mTarget != null) goto L57;
    L58:
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L59
    L57:
        if (r10.mBottom.mTarget != null) goto L59;
    L44:
        if (r10.mMatchConstraintDefaultWidth != 1) goto L50;
        if (r10.mLeft.mTarget != null) goto L48;
    L49:
        r12 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L50
    L48:
        if (r10.mRight.mTarget != null) goto L50;
    L7:
        r10.measured = USE_GROUPS;
        goto L4
    L143:
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer r10, int r11) {
        int r5 = this.mGroups.size();
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L6;
        r12 = Math.max(r12, this.mGroups.get(r13).computeWrapSize(r10, r11));
        r13 = r13 + 1;
        goto L3
    L6:
        return (int) r12;
    }

    private void displayGraph() {
        Iterator<WidgetRun> r5 = this.mRuns.iterator();
        String r10 = "digraph {\n";
    L4:
        if (r5.hasNext() == false) goto L6;
        r10 = generateDisplayGraph(r5.next(), r10);
        goto L4
    L6:
        String r11 = j0.j(r10, "\n}\n");
        System.out.println("content:<<\n" + r11 + "\n>>");
    }

    private void findGroup(WidgetRun r11, int r12, ArrayList<RunGroup> r13) {
        Iterator<Dependency> r5 = r11.start.dependencies.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Dependency r10 = r5.next();
        if ((r10 instanceof DependencyNode) == true) goto L7;
        if ((r10 instanceof WidgetRun) == false) goto L4;
        applyGroup(((WidgetRun) r10).start, r12, 0, r11.end, r13, null);
        goto L4
    L7:
        applyGroup((DependencyNode) r10, r12, 0, r11.end, r13, null);
        goto L4
    L11:
        Iterator<Dependency> r14 = r11.end.dependencies.iterator();
    L13:
        if (r14.hasNext() == false) goto L21;
        Dependency r15 = r14.next();
        if ((r15 instanceof DependencyNode) == true) goto L16;
        if ((r15 instanceof WidgetRun) == false) goto L13;
        applyGroup(((WidgetRun) r15).end, r12, 1, r11.start, r13, null);
        goto L13
    L16:
        applyGroup((DependencyNode) r15, r12, 1, r11.start, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<Dependency> r16 = ((VerticalWidgetRun) r11).baseline.dependencies.iterator();
    L24:
        if (r16.hasNext() == false) goto L50;
        Dependency r17 = r16.next();
        if ((r17 instanceof DependencyNode) == false) goto L24;
        applyGroup((DependencyNode) r17, r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }

    private String generateChainDisplayGraph(ChainRun r10, String r11) {
        int r5 = r10.orientation;
        String r12 = "cluster_" + r10.widget.getDebugName();
        if (r5 != 0) goto L5;
        String r13 = j0.j(r12, "_h");
    L6:
        String r14 = j0.k("subgraph ", r13, " {\n");
        Iterator<WidgetRun> r15 = r10.widgets.iterator();
        String r16 = "";
    L8:
        if (r15.hasNext() == false) goto L15;
        WidgetRun r17 = r15.next();
        String r18 = r17.widget.getDebugName();
        if (r5 != 0) goto L12;
        String r19 = j0.j(r18, "_HORIZONTAL");
    L13:
        r14 = j0.D(r14, r19, ";\n");
        r16 = generateDisplayGraph(r17, r16);
        goto L8
    L12:
        r19 = j0.j(r18, "_VERTICAL");
        goto L13
    L15:
        return j0.D(r11, r16, j0.j(r14, "}\n"));
    L5:
        r13 = j0.j(r12, "_v");
        goto L6
    }

    private String generateDisplayGraph(WidgetRun r10, String r11) {
        DependencyNode r5 = r10.start;
        DependencyNode r12 = r10.end;
        if ((r10 instanceof HelperReferences) == false) goto L5;
    L11:
        StringBuilder r13 = j0.u(r11);
        r13.append(nodeDefinition(r10));
        String r14 = r13.toString();
        boolean r15 = isCenteredConnection(r5, r12);
        String r16 = generateDisplayNode(r12, r15, generateDisplayNode(r5, r15, r14));
        boolean r17 = r10 instanceof VerticalWidgetRun;
        if (r17 == false) goto L15;
        r16 = generateDisplayNode(((VerticalWidgetRun) r10).baseline, r15, r16);
    L15:
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L45;
        boolean r18 = r10 instanceof ChainRun;
        if (r18 == true) goto L19;
    L21:
        if (r17 == true) goto L25;
        if (r18 == false) goto L66;
        if (((ChainRun) r10).orientation == 1) goto L25;
    L66:
        if ((r10 instanceof ChainRun) == true) goto L68;
        return r16;
    L68:
        return generateChainDisplayGraph((ChainRun) r10, r16);
    L25:
        ConstraintWidget.DimensionBehaviour r19 = r10.widget.getVerticalDimensionBehaviour();
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
        if (r19 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L36;
        if (r19 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L66;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L66;
        r10.widget.getDebugName();
    L36:
        if (r5.targets.isEmpty() == true) goto L41;
        if (r12.targets.isEmpty() == false) goto L41;
        r16 = j0.j(r16, "\n" + r12.name() + " -> " + r5.name() + "\n");
    L41:
        if (r5.targets.isEmpty() == false) goto L66;
        if (r12.targets.isEmpty() == true) goto L66;
        r16 = j0.j(r16, "\n" + r5.name() + " -> " + r12.name() + "\n");
        goto L66
    L19:
        if (((ChainRun) r10).orientation != 0) goto L21;
    L45:
        ConstraintWidget.DimensionBehaviour r20 = r10.widget.getHorizontalDimensionBehaviour();
        if (r20 == ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        if (r20 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L56;
        if (r20 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L66;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L66;
        r10.widget.getDebugName();
    L56:
        if (r5.targets.isEmpty() == true) goto L61;
        if (r12.targets.isEmpty() == false) goto L61;
        r16 = j0.j(r16, "\n" + r12.name() + " -> " + r5.name() + "\n");
    L61:
        if (r5.targets.isEmpty() == false) goto L66;
        if (r12.targets.isEmpty() == true) goto L66;
        r16 = j0.j(r16, "\n" + r5.name() + " -> " + r12.name() + "\n");
        goto L66
    L5:
        if (r5.dependencies.isEmpty() == false) goto L11;
        if ((r12.dependencies.isEmpty() & r5.targets.isEmpty()) == false) goto L11;
        if (r12.targets.isEmpty() == false) goto L11;
        return r11;
    }

    private String generateDisplayNode(DependencyNode r5, boolean r10, String r11) {
        Iterator<DependencyNode> r12 = r5.targets.iterator();
    L4:
        if (r12.hasNext() == false) goto L22;
        DependencyNode r13 = r12.next();
        StringBuilder r14 = j0.w("\n" + r5.name(), " -> ");
        r14.append(r13.name());
        String r15 = r14.toString();
        if (r5.margin > 0) goto L10;
        if (r10 == true) goto L10;
        if ((r5.run instanceof HelperReferences) == true) goto L10;
    L21:
        r11 = j0.j(r11, j0.j(r15, "\n"));
    L10:
        String r16 = j0.j(r15, "[");
        if (r5.margin <= 0) goto L15;
        r16 = a.s(j0.w(r16, "label=\""), r5.margin, "\"");
        if (r10 == false) goto L15;
        r16 = j0.j(r16, ",");
    L15:
        if (r10 == false) goto L18;
        r16 = j0.j(r16, " style=dashed ");
    L18:
        if ((r5.run instanceof HelperReferences) == false) goto L20;
        r16 = j0.j(r16, " style=bold,color=gray ");
    L20:
        r15 = j0.j(r16, "]");
        goto L21
    L22:
        return r11;
    }

    private boolean isCenteredConnection(DependencyNode r5, DependencyNode r10) {
        Iterator<DependencyNode> r11 = r5.targets.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r11.next() == r10) goto L4;
        r12 = r12 + 1;
        goto L4
    L8:
        Iterator<DependencyNode> r13 = r10.targets.iterator();
        int r14 = 0;
    L10:
        if (r13.hasNext() == false) goto L14;
        if (r13.next() == r5) goto L10;
        r14 = r14 + 1;
        goto L10
    L14:
        if (r12 <= 0) goto L28;
        if (r14 <= 0) goto L29;
        return USE_GROUPS;
    L29:
        return false;
    L28:
        return false;
    }

    private void measure(ConstraintWidget r5, ConstraintWidget.DimensionBehaviour r10, int r11, ConstraintWidget.DimensionBehaviour r12, int r13) {
        BasicMeasure.Measure r14 = this.mMeasure;
        r14.horizontalBehavior = r10;
        r14.verticalBehavior = r12;
        r14.horizontalDimension = r11;
        r14.verticalDimension = r13;
        this.mMeasurer.measure(r5, r14);
        r5.setWidth(this.mMeasure.measuredWidth);
        r5.setHeight(this.mMeasure.measuredHeight);
        r5.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r5.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun r10) {
        boolean r11 = r10 instanceof VerticalWidgetRun;
        String r5 = r10.widget.getDebugName();
        ConstraintWidget r12 = r10.widget;
        if (r11 == true) goto L5;
        ConstraintWidget.DimensionBehaviour r13 = r12.getHorizontalDimensionBehaviour();
    L6:
        RunGroup r14 = r10.runGroup;
        if (r11 == true) goto L9;
        String r15 = j0.j(r5, "_HORIZONTAL");
    L10:
        String r16 = j0.j(j0.j(j0.j(r15, " [shape=none, label=<"), "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">"), "  <TR>");
        if (r11 == true) goto L16;
        String r17 = j0.j(r16, "    <TD ");
        if (r10.start.resolved == false) goto L15;
        r17 = j0.j(r17, " BGCOLOR=\"green\"");
    L15:
        String r18 = j0.j(r17, " PORT=\"LEFT\" BORDER=\"1\">L</TD>");
    L20:
        String r19 = j0.j(r18, "    <TD BORDER=\"1\" ");
        boolean r20 = r10.dimension.resolved;
        if (r20 == true) goto L23;
    L25:
        if (r20 == true) goto L27;
    L29:
        if (r20 == false) goto L31;
    L34:
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r19 = j0.j(r19, "style=\"dashed\"");
    L36:
        if (r14 == null) goto L38;
        StringBuilder r21 = new StringBuilder(" [");
        r21.append(r14.groupIndex + 1);
        r21.append("/");
        String r22 = a.s(r21, RunGroup.index, "]");
    L39:
        String r23 = r19 + ">" + r5 + r22 + " </TD>";
        if (r11 == true) goto L45;
        String r24 = j0.j(r23, "    <TD ");
        if (r10.end.resolved == false) goto L44;
        r24 = j0.j(r24, " BGCOLOR=\"green\"");
    L44:
        String r25 = j0.j(r24, " PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
    L55:
        return j0.j(j0.j(r25, "  </TR></TABLE>"), ">];\n");
    L45:
        String r26 = j0.j(r23, "    <TD ");
        if ((r10 instanceof VerticalWidgetRun) == true) goto L48;
    L50:
        String r27 = j0.j(j0.j(r26, " PORT=\"BASELINE\" BORDER=\"1\">b</TD>"), "    <TD ");
        if (r10.end.resolved == false) goto L53;
        r27 = j0.j(r27, " BGCOLOR=\"green\"");
    L53:
        r25 = j0.j(r27, " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        goto L55
    L48:
        if (((VerticalWidgetRun) r10).baseline.resolved == false) goto L50;
        r26 = j0.j(r26, " BGCOLOR=\"green\"");
        goto L50
    L38:
        r22 = "";
        goto L39
    L31:
        if (r10.widget.measured == false) goto L34;
        r19 = j0.j(r19, " BGCOLOR=\"yellow\" ");
        goto L34
    L27:
        if (r10.widget.measured == false) goto L29;
        r19 = j0.j(r19, " BGCOLOR=\"lightgray\" ");
        goto L34
    L23:
        if (r10.widget.measured == true) goto L25;
        r19 = j0.j(r19, " BGCOLOR=\"green\" ");
        goto L34
    L16:
        String r28 = j0.j(r16, "    <TD ");
        if (r10.start.resolved == false) goto L19;
        r28 = j0.j(r28, " BGCOLOR=\"green\"");
    L19:
        r18 = j0.j(r28, " PORT=\"TOP\" BORDER=\"1\">T</TD>");
        goto L20
    L9:
        r15 = j0.j(r5, "_VERTICAL");
        goto L10
    L5:
        r13 = r12.getVerticalDimensionBehaviour();
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

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour r10, ConstraintWidget.DimensionBehaviour r11) {
        if (this.mNeedBuildGraph == false) goto L22;
        buildGraph();
        Iterator<ConstraintWidget> r5 = this.container.mChildren.iterator();
        boolean r12 = false;
    L6:
        if (r5.hasNext() == false) goto L10;
        ConstraintWidget r13 = r5.next();
        boolean[] r14 = r13.isTerminalWidget;
        r14[0] = USE_GROUPS;
        r14[1] = USE_GROUPS;
        if ((r13 instanceof Barrier) == false) goto L6;
        r12 = true;
        goto L6
    L10:
        if (r12 == true) goto L31;
        Iterator<RunGroup> r15 = this.mGroups.iterator();
    L13:
        if (r15.hasNext() == false) goto L32;
        RunGroup r16 = r15.next();
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r10 != r17) goto L17;
        boolean r18 = true;
    L18:
        if (r11 != r17) goto L20;
        boolean r19 = true;
    L21:
        r16.defineTerminalWidgets(r18, r19);
        goto L13
    L20:
        r19 = false;
        goto L21
    L17:
        r18 = false;
        goto L18
    L32:
        return;
    L31:
        return;
    }

    public boolean directMeasure(boolean r10) {
        boolean r5 = false;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r11 = this.container.mChildren.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ConstraintWidget r12 = r11.next();
        r12.ensureWidgetRuns();
        r12.measured = false;
        r12.horizontalRun.reset();
        r12.verticalRun.reset();
        goto L8
    L10:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r13 = this.container;
        r13.measured = false;
        r13.horizontalRun.reset();
        this.container.verticalRun.reset();
        this.mNeedRedoMeasures = false;
    L12:
        if (basicMeasureWidgets(this.mContainer) == false) goto L14;
        return false;
    L14:
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour r14 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r15 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph == false) goto L17;
        buildGraph();
    L17:
        int r16 = this.container.getX();
        int r17 = this.container.getY();
        this.container.horizontalRun.start.resolve(r16);
        this.container.verticalRun.start.resolve(r17);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 == r18) goto L20;
        if (r15 == r18) goto L20;
    L35:
        ConstraintWidgetContainer r19 = this.container;
        ConstraintWidget.DimensionBehaviour r20 = r19.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r20 != r21) goto L38;
    L41:
        int r110 = r19.getWidth() + r16;
        this.container.horizontalRun.end.resolve(r110);
        this.container.horizontalRun.dimension.resolve(r110 - r16);
        measureWidgets();
        ConstraintWidgetContainer r111 = this.container;
        ConstraintWidget.DimensionBehaviour r22 = r111.mListDimensionBehaviors[1];
        if (r22 != r21) goto L44;
    L45:
        int r112 = r111.getHeight() + r17;
        this.container.verticalRun.end.resolve(r112);
        this.container.verticalRun.dimension.resolve(r112 - r17);
    L46:
        measureWidgets();
        boolean r113 = true;
    L47:
        Iterator<WidgetRun> r23 = this.mRuns.iterator();
    L49:
        if (r23.hasNext() == false) goto L56;
        WidgetRun r24 = r23.next();
        if (r24.widget != this.container) goto L55;
        if (r24.resolved == false) goto L49;
    L55:
        r24.applyToWidget();
        goto L49
    L56:
        Iterator<WidgetRun> r25 = this.mRuns.iterator();
    L58:
        if (r25.hasNext() == false) goto L79;
        WidgetRun r26 = r25.next();
        if (r113 == true) goto L65;
        if (r26.widget == this.container) goto L58;
    L65:
        if (r26.start.resolved == false) goto L80;
        if (r26.end.resolved == true) goto L73;
        if ((r26 instanceof GuidelineReference) == false) goto L80;
    L73:
        if (r26.dimension.resolved == true) goto L58;
        if ((r26 instanceof ChainRun) == true) goto L58;
        if ((r26 instanceof GuidelineReference) == true) goto L58;
    L80:
        this.container.setHorizontalDimensionBehaviour(r14);
        this.container.setVerticalDimensionBehaviour(r15);
        return r5;
    L79:
        r5 = true;
        goto L80
    L44:
        if (r22 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L46;
    L38:
        if (r20 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L41;
        r113 = false;
    L20:
        if (r10 == false) goto L27;
        Iterator<WidgetRun> r27 = this.mRuns.iterator();
    L23:
        if (r27.hasNext() == false) goto L27;
        if (r27.next().supportsWrapComputation() == true) goto L23;
        r10 = false;
    L27:
        if (r10 == true) goto L29;
    L31:
        if (r10 == false) goto L35;
        if (r15 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L35;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r114 = this.container;
        r114.setHeight(computeWrap(r114, 1));
        ConstraintWidgetContainer r115 = this.container;
        r115.verticalRun.dimension.resolve(r115.getHeight());
        goto L35
    L29:
        if (r14 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r28 = this.container;
        r28.setWidth(computeWrap(r28, 0));
        ConstraintWidgetContainer r29 = this.container;
        r29.horizontalRun.dimension.resolve(r29.getWidth());
        goto L31
    L5:
        if (this.mNeedRedoMeasures == false) goto L12;
        goto L6
    }

    public boolean directMeasureSetup(boolean r5) {
        if (this.mNeedBuildGraph == false) goto L10;
        Iterator<ConstraintWidget> r10 = this.container.mChildren.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        ConstraintWidget r11 = r10.next();
        r11.ensureWidgetRuns();
        r11.measured = false;
        HorizontalWidgetRun r12 = r11.horizontalRun;
        r12.dimension.resolved = false;
        r12.resolved = false;
        r12.reset();
        VerticalWidgetRun r13 = r11.verticalRun;
        r13.dimension.resolved = false;
        r13.resolved = false;
        r13.reset();
        goto L6
    L8:
        this.container.ensureWidgetRuns();
        ConstraintWidgetContainer r14 = this.container;
        r14.measured = false;
        HorizontalWidgetRun r15 = r14.horizontalRun;
        r15.dimension.resolved = false;
        r15.resolved = false;
        r15.reset();
        VerticalWidgetRun r16 = this.container.verticalRun;
        r16.dimension.resolved = false;
        r16.resolved = false;
        r16.reset();
        buildGraph();
    L10:
        if (basicMeasureWidgets(this.mContainer) == false) goto L12;
        return false;
    L12:
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return USE_GROUPS;
    }

    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        boolean r5 = false;
        ConstraintWidget.DimensionBehaviour r12 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r13 = this.container.getDimensionBehaviour(1);
        int r14 = this.container.getX();
        int r15 = this.container.getY();
        if (r10 == false) goto L24;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r16) goto L7;
        if (r13 != r16) goto L24;
    L7:
        Iterator<WidgetRun> r17 = this.mRuns.iterator();
    L9:
        if (r17.hasNext() == false) goto L15;
        WidgetRun r18 = r17.next();
        if (r18.orientation != r11) goto L9;
        if (r18.supportsWrapComputation() == true) goto L9;
        r10 = false;
    L15:
        if (r11 != 0) goto L20;
        if (r10 == false) goto L24;
        if (r12 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r19 = this.container;
        r19.setWidth(computeWrap(r19, 0));
        ConstraintWidgetContainer r110 = this.container;
        r110.horizontalRun.dimension.resolve(r110.getWidth());
        goto L24
    L20:
        if (r10 == false) goto L24;
        if (r13 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r111 = this.container;
        r111.setHeight(computeWrap(r111, 1));
        ConstraintWidgetContainer r112 = this.container;
        r112.verticalRun.dimension.resolve(r112.getHeight());
    L24:
        if (r11 != 0) goto L31;
        ConstraintWidgetContainer r113 = this.container;
        ConstraintWidget.DimensionBehaviour r20 = r113.mListDimensionBehaviors[0];
        if (r20 != ConstraintWidget.DimensionBehaviour.FIXED) goto L28;
    L29:
        int r114 = r113.getWidth() + r14;
        this.container.horizontalRun.end.resolve(r114);
        this.container.horizontalRun.dimension.resolve(r114 - r14);
    L30:
        boolean r115 = true;
    L38:
        measureWidgets();
        Iterator<WidgetRun> r21 = this.mRuns.iterator();
    L40:
        if (r21.hasNext() == false) goto L50;
        WidgetRun r22 = r21.next();
        if (r22.orientation != r11) goto L40;
        if (r22.widget != this.container) goto L49;
        if (r22.resolved == false) goto L40;
    L49:
        r22.applyToWidget();
        goto L40
    L50:
        Iterator<WidgetRun> r23 = this.mRuns.iterator();
    L52:
        if (r23.hasNext() == false) goto L71;
        WidgetRun r24 = r23.next();
        if (r24.orientation != r11) goto L52;
        if (r115 == true) goto L61;
        if (r24.widget == this.container) goto L52;
    L61:
        if (r24.start.resolved == false) goto L72;
        if (r24.end.resolved == false) goto L72;
        if ((r24 instanceof ChainRun) == true) goto L52;
        if (r24.dimension.resolved == true) goto L52;
    L72:
        this.container.setHorizontalDimensionBehaviour(r12);
        this.container.setVerticalDimensionBehaviour(r13);
        return r5;
    L71:
        r5 = true;
        goto L72
    L28:
        if (r20 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L29;
    L36:
        r115 = false;
        goto L38
    L31:
        ConstraintWidgetContainer r116 = this.container;
        ConstraintWidget.DimensionBehaviour r25 = r116.mListDimensionBehaviors[1];
        if (r25 != ConstraintWidget.DimensionBehaviour.FIXED) goto L34;
    L37:
        int r117 = r116.getHeight() + r15;
        this.container.verticalRun.end.resolve(r117);
        this.container.verticalRun.dimension.resolve(r117 - r15);
        goto L30
    L34:
        if (r25 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L36;
        goto L36
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = USE_GROUPS;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = USE_GROUPS;
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> r5 = this.container.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L42;
        ConstraintWidget r10 = r5.next();
        if (r10.measured == true) goto L4;
        ConstraintWidget.DimensionBehaviour[] r11 = r10.mListDimensionBehaviors;
        boolean r12 = false;
        ConstraintWidget.DimensionBehaviour r13 = r11[0];
        ConstraintWidget.DimensionBehaviour r14 = r11[1];
        int r15 = r10.mMatchConstraintDefaultWidth;
        int r16 = r10.mMatchConstraintDefaultHeight;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 != r17) goto L11;
    L15:
        boolean r18 = true;
    L16:
        if (r14 != r17) goto L18;
    L20:
        r12 = true;
    L21:
        DimensionDependency r19 = r10.horizontalRun.dimension;
        boolean r20 = r19.resolved;
        DimensionDependency r21 = r10.verticalRun.dimension;
        boolean r110 = r21.resolved;
        if (r20 == false) goto L25;
        if (r110 == false) goto L25;
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.FIXED;
        measure(r10, r22, r19.value, r22, r21.value);
        r10.measured = USE_GROUPS;
    L38:
        if (r10.measured == false) goto L4;
        DimensionDependency r23 = r10.verticalRun.baselineDimension;
        if (r23 == null) goto L4;
        r23.resolve(r10.getBaselineDistance());
    L25:
        if (r20 == false) goto L31;
        if (r12 == false) goto L31;
        measure(r10, ConstraintWidget.DimensionBehaviour.FIXED, r19.value, r17, r21.value);
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        r10.verticalRun.dimension.wrapValue = r10.getHeight();
        goto L38
    L30:
        r10.verticalRun.dimension.resolve(r10.getHeight());
        r10.measured = USE_GROUPS;
    L31:
        if (r110 == false) goto L38;
        if (r18 == false) goto L38;
        measure(r10, r17, r19.value, ConstraintWidget.DimensionBehaviour.FIXED, r21.value);
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r10.horizontalRun.dimension.wrapValue = r10.getWidth();
        goto L38
    L36:
        r10.horizontalRun.dimension.resolve(r10.getWidth());
        r10.measured = USE_GROUPS;
        goto L38
    L18:
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
        if (r16 != 1) goto L21;
    L11:
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r15 == 1) goto L15;
    L14:
        r18 = false;
        goto L16
    }

    public void setMeasurer(BasicMeasure.Measurer r5) {
        this.mMeasurer = r5;
    }

    public void buildGraph(ArrayList<WidgetRun> r10) {
        r10.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        r10.add(this.mContainer.horizontalRun);
        r10.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> r5 = this.mContainer.mChildren.iterator();
        HashSet r11 = null;
    L4:
        if (r5.hasNext() == false) goto L29;
        ConstraintWidget r12 = r5.next();
        if ((r12 instanceof Guideline) == true) goto L7;
        if (r12.isInHorizontalChain() == true) goto L11;
        r10.add(r12.horizontalRun);
    L18:
        if (r12.isInVerticalChain() == true) goto L20;
        r10.add(r12.verticalRun);
    L27:
        if ((r12 instanceof HelperWidget) == false) goto L4;
        r10.add(new HelperReferences(r12));
        goto L4
    L20:
        if (r12.verticalChainRun != null) goto L22;
        r12.verticalChainRun = new ChainRun(r12, 1);
    L22:
        if (r11 != null) goto L24;
        r11 = new HashSet();
    L24:
        r11.add(r12.verticalChainRun);
        goto L27
    L11:
        if (r12.horizontalChainRun != null) goto L13;
        r12.horizontalChainRun = new ChainRun(r12, 0);
    L13:
        if (r11 != null) goto L15;
        r11 = new HashSet();
    L15:
        r11.add(r12.horizontalChainRun);
        goto L18
    L7:
        r10.add(new GuidelineReference(r12));
        goto L4
    L29:
        if (r11 == null) goto L31;
        r10.addAll(r11);
    L31:
        Iterator<WidgetRun> r13 = r10.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        r13.next().clear();
        goto L33
    L35:
        Iterator<WidgetRun> r14 = r10.iterator();
    L37:
        if (r14.hasNext() == false) goto L42;
        WidgetRun r15 = r14.next();
        if (r15.widget == this.mContainer) goto L37;
        r15.apply();
        goto L37
    }
}

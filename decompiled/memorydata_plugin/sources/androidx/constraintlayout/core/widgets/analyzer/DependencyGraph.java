package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public DependencyGraph(ConstraintWidgetContainer r2) {
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList();
        this.runGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList();
        this.container = r2;
        this.mContainer = r2;
    }

    private void applyGroup(DependencyNode r10, int r11, int r12, DependencyNode r13, ArrayList<RunGroup> r14, RunGroup r15) {
        WidgetRun r16 = r10.run;
        if (r16.runGroup == null) goto L5;
        return;
    L5:
        if (r16 != this.container.horizontalRun) goto L7;
        return;
    L7:
        if (r16 == this.container.verticalRun) goto L80;
        if (r15 != null) goto L11;
        r15 = new RunGroup(r16, r12);
        r14.add(r15);
    L11:
        r16.runGroup = r15;
        r15.add(r16);
        Iterator<Dependency> r17 = r16.start.dependencies.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        Dependency r0 = (Dependency) ZeusTransformUtils.preCheckCast(r17.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, DependencyNode.class) == false) goto L13;
        applyGroup((DependencyNode) ZeusTransformUtils.preCheckCast(r0, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<Dependency> r18 = r16.end.dependencies.iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        Dependency r1 = (Dependency) ZeusTransformUtils.preCheckCast(r18.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, DependencyNode.class) == false) goto L19;
        applyGroup((DependencyNode) ZeusTransformUtils.preCheckCast(r1, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator<DependencyNode> r8 = r16.start.targets.iterator();
    L35:
        if (r8.hasNext() == false) goto L40;
        DependencyNode r2 = (DependencyNode) ZeusTransformUtils.preCheckCast(r8.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        if (r2 != r13) goto L39;
        r15.dual = true;
    L39:
        applyGroup(r2, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<DependencyNode> r9 = r16.end.targets.iterator();
    L42:
        if (r9.hasNext() == false) goto L47;
        DependencyNode r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(r9.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        if (r3 != r13) goto L46;
        r15.dual = true;
    L46:
        applyGroup(r3, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r16, VerticalWidgetRun.class) == false) goto L79;
        Iterator<DependencyNode> r19 = ((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(r16, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline.targets.iterator();
    L52:
        if (r19.hasNext() == false) goto L81;
        applyGroup((DependencyNode) ZeusTransformUtils.preCheckCast(r19.next(), DependencyNode.class, "com.obric.memorydata.plugin"), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r16, VerticalWidgetRun.class) == false) goto L33;
        Iterator<Dependency> r20 = ((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(r16, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline.dependencies.iterator();
    L29:
        if (r20.hasNext() == false) goto L33;
        Dependency r4 = (Dependency) ZeusTransformUtils.preCheckCast(r20.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, DependencyNode.class) == false) goto L29;
        applyGroup((DependencyNode) ZeusTransformUtils.preCheckCast(r4, DependencyNode.class, "com.obric.memorydata.plugin"), r11, 2, r13, r14, r15);
        goto L29
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer r13) {
        Iterator<ConstraintWidget> r0 = r13.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L168;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        ConstraintWidget.DimensionBehaviour r3 = r1.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r4 = r1.mListDimensionBehaviors[1];
        if (r1.getVisibility() == 8) goto L7;
        if (r1.mMatchConstraintPercentWidth >= 1.0f) goto L14;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r1.mMatchConstraintDefaultWidth = 2;
    L14:
        if (r1.mMatchConstraintPercentHeight >= 1.0f) goto L19;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r1.mMatchConstraintDefaultHeight = 2;
    L19:
        if (r1.getDimensionRatio() <= 0.0f) goto L45;
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L28;
        if (r4 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r1.mMatchConstraintDefaultWidth = 3;
        goto L45
    L25:
        if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L26;
    L28:
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L35;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
    L33:
        r1.mMatchConstraintDefaultHeight = 3;
        goto L45
    L32:
        if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L35:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L45;
        if (r1.mMatchConstraintDefaultWidth != 0) goto L42;
        r1.mMatchConstraintDefaultWidth = 3;
    L42:
        if (r1.mMatchConstraintDefaultHeight == 0) goto L33;
    L45:
        if (r3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L47;
    L53:
        ConstraintWidget.DimensionBehaviour r5 = r3;
        if (r4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L56;
    L62:
        ConstraintWidget.DimensionBehaviour r8 = r4;
    L63:
        r1.horizontalRun.dimensionBehavior = r5;
        r1.horizontalRun.matchConstraintsType = r1.mMatchConstraintDefaultWidth;
        r1.verticalRun.dimensionBehavior = r8;
        r1.verticalRun.matchConstraintsType = r1.mMatchConstraintDefaultHeight;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
    L77:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L108;
        if (r8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L83;
        if (r8 != ConstraintWidget.DimensionBehaviour.FIXED) goto L108;
    L83:
        if (r1.mMatchConstraintDefaultWidth == 3) goto L85;
        if (r1.mMatchConstraintDefaultWidth == 1) goto L92;
        if (r1.mMatchConstraintDefaultWidth != 2) goto L102;
        if (r13.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED) goto L100;
        if (r13.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L108;
    L100:
        int r6 = (int) ((r1.mMatchConstraintPercentWidth * r13.getWidth()) + 0.5f);
        int r2 = r1.getHeight();
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L106:
        ConstraintWidget.DimensionBehaviour r7 = r8;
        int r9 = r2;
    L167:
        measure(r1, r5, r6, r7, r9);
        r1.horizontalRun.dimension.resolve(r1.getWidth());
        r1.verticalRun.dimension.resolve(r1.getHeight());
        goto L7
    L102:
        if (r1.mListAnchors[0].mTarget == null) goto L105;
        if (r1.mListAnchors[1].mTarget != null) goto L108;
    L105:
        r5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r6 = 0;
        r2 = 0;
        goto L106
    L92:
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, r8, 0);
        DimensionDependency r10 = r1.horizontalRun.dimension;
        int r11 = r1.getWidth();
    L93:
        r10.wrapValue = r11;
        goto L4
    L85:
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L87;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L87:
        r9 = r1.getHeight();
        r6 = (int) ((r9 * r1.mDimensionRatio) + 0.5f);
    L88:
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L89:
        r7 = ConstraintWidget.DimensionBehaviour.FIXED;
    L108:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L140;
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L114;
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L140;
    L114:
        if (r1.mMatchConstraintDefaultHeight == 3) goto L116;
        if (r1.mMatchConstraintDefaultHeight == 1) goto L125;
        if (r1.mMatchConstraintDefaultHeight != 2) goto L135;
        if (r13.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED) goto L133;
        if (r13.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L140;
    L133:
        float r12 = r1.mMatchConstraintPercentHeight;
        r6 = r1.getWidth();
        r9 = (int) ((r12 * r13.getHeight()) + 0.5f);
        goto L89
    L135:
        if (r1.mListAnchors[2].mTarget == null) goto L105;
        if (r1.mListAnchors[3].mTarget != null) goto L140;
    L125:
        measure(r1, r5, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L126:
        r10 = r1.verticalRun.dimension;
        r11 = r1.getHeight();
        goto L93
    L116:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L118;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
    L118:
        r6 = r1.getWidth();
        float r14 = r1.mDimensionRatio;
        if (r1.getDimensionRatioSide() != (-1)) goto L121;
        r14 = 1.0f / r14;
    L121:
        float r15 = r6;
    L122:
        r9 = (int) ((r15 * r14) + 0.5f);
    L140:
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L4;
        if (r1.mMatchConstraintDefaultWidth == 1) goto L157;
        if (r1.mMatchConstraintDefaultHeight == 1) goto L157;
        if (r1.mMatchConstraintDefaultHeight != 2) goto L4;
        if (r1.mMatchConstraintDefaultWidth != 2) goto L4;
        if (r13.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        if (r13.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L4;
        float r16 = r1.mMatchConstraintPercentWidth;
        r15 = r1.mMatchConstraintPercentHeight;
        r6 = (int) ((r16 * r13.getWidth()) + 0.5f);
        r14 = r13.getHeight();
    L157:
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
        r1.horizontalRun.dimension.wrapValue = r1.getWidth();
    L70:
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L158;
        if (r8 == ConstraintWidget.DimensionBehaviour.FIXED) goto L158;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
    L158:
        int r17 = r1.getWidth();
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L161;
        r6 = (r13.getWidth() - r1.mLeft.mMargin) - r1.mRight.mMargin;
        r5 = ConstraintWidget.DimensionBehaviour.FIXED;
    L162:
        int r18 = r1.getHeight();
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L165;
        r9 = (r13.getHeight() - r1.mTop.mMargin) - r1.mBottom.mMargin;
        r7 = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L167
    L165:
        r7 = r8;
        r9 = r18;
        goto L167
    L161:
        r6 = r17;
        goto L162
    L56:
        if (r1.mMatchConstraintDefaultHeight != 1) goto L62;
        if (r1.mTop.mTarget != null) goto L60;
    L61:
        r8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L63
    L60:
        if (r1.mBottom.mTarget != null) goto L62;
    L47:
        if (r1.mMatchConstraintDefaultWidth != 1) goto L53;
        if (r1.mLeft.mTarget != null) goto L51;
    L52:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L53
    L51:
        if (r1.mRight.mTarget != null) goto L53;
    L7:
        r1.measured = true;
        goto L4
    L168:
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer r8, int r9) {
        int r0 = this.mGroups.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, ((RunGroup) ZeusTransformUtils.preCheckCast(this.mGroups.get(r3), RunGroup.class, "com.obric.memorydata.plugin")).computeWrapSize(r8, r9));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    private void displayGraph() {
        Iterator<WidgetRun> r0 = this.mRuns.iterator();
        String r1 = "digraph {\n";
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = generateDisplayGraph((WidgetRun) ZeusTransformUtils.preCheckCast(r0.next(), WidgetRun.class, "com.obric.memorydata.plugin"), r1);
        goto L4
    L6:
        System.out.println("content:<<\n" + (r1 + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun r11, int r12, ArrayList<RunGroup> r13) {
        Iterator<Dependency> r0 = r11.start.dependencies.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Dependency r1 = (Dependency) ZeusTransformUtils.preCheckCast(r0.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, DependencyNode.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, WidgetRun.class) == false) goto L4;
        DependencyNode r3 = ((WidgetRun) ZeusTransformUtils.preCheckCast(r1, WidgetRun.class, "com.obric.memorydata.plugin")).start;
    L8:
        applyGroup(r3, r12, 0, r11.end, r13, null);
        goto L4
    L7:
        r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(r1, DependencyNode.class, "com.obric.memorydata.plugin");
        goto L8
    L12:
        Iterator<Dependency> r2 = r11.end.dependencies.iterator();
    L14:
        if (r2.hasNext() == false) goto L23;
        Dependency r4 = (Dependency) ZeusTransformUtils.preCheckCast(r2.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, DependencyNode.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r4, WidgetRun.class) == false) goto L14;
        DependencyNode r5 = ((WidgetRun) ZeusTransformUtils.preCheckCast(r4, WidgetRun.class, "com.obric.memorydata.plugin")).end;
    L18:
        applyGroup(r5, r12, 1, r11.start, r13, null);
        goto L14
    L17:
        r5 = (DependencyNode) ZeusTransformUtils.preCheckCast(r4, DependencyNode.class, "com.obric.memorydata.plugin");
        goto L18
    L23:
        if (r12 != 1) goto L30;
        Iterator<Dependency> r14 = ((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(r11, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline.dependencies.iterator();
    L26:
        if (r14.hasNext() == false) goto L48;
        Dependency r6 = (Dependency) ZeusTransformUtils.preCheckCast(r14.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DependencyNode.class) == false) goto L26;
        applyGroup((DependencyNode) ZeusTransformUtils.preCheckCast(r6, DependencyNode.class, "com.obric.memorydata.plugin"), r12, 2, null, r13, null);
        goto L26
    L48:
        return;
    }

    private String generateChainDisplayGraph(ChainRun r7, String r8) {
        int r0 = r7.orientation;
        StringBuilder r1 = new StringBuilder("subgraph ");
        r1.append("cluster_");
        r1.append(r7.widget.getDebugName());
        if (r0 != 0) goto L5;
        String r2 = "_h";
    L6:
        r1.append(r2);
        r1.append(" {\n");
        Iterator<WidgetRun> r9 = r7.widgets.iterator();
        String r3 = "";
    L8:
        if (r9.hasNext() == false) goto L14;
        WidgetRun r4 = (WidgetRun) ZeusTransformUtils.preCheckCast(r9.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        r1.append(r4.widget.getDebugName());
        if (r0 != 0) goto L12;
        String r5 = "_HORIZONTAL";
    L13:
        r1.append(r5);
        r1.append(";\n");
        r3 = generateDisplayGraph(r4, r3);
        goto L8
    L12:
        r5 = "_VERTICAL";
        goto L13
    L14:
        r1.append("}\n");
        return r8 + r3 + r1;
    L5:
        r2 = "_v";
        goto L6
    }

    private String generateDisplayGraph(WidgetRun r10, String r11) {
        DependencyNode r0 = r10.start;
        DependencyNode r1 = r10.end;
        StringBuilder r2 = new StringBuilder(r11);
        if (ZeusTransformUtils.instanceOf(r10, HelperReferences.class) == false) goto L5;
    L11:
        r2.append(nodeDefinition(r10));
        boolean r3 = isCenteredConnection(r0, r1);
        String r12 = generateDisplayNode(r1, r3, generateDisplayNode(r0, r3, r11));
        if (ZeusTransformUtils.instanceOf(r10, VerticalWidgetRun.class) == false) goto L15;
        r12 = generateDisplayNode(((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(r10, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline, r3, r12);
    L15:
        if (ZeusTransformUtils.instanceOf(r10, HorizontalWidgetRun.class) == false) goto L17;
    L49:
        ConstraintWidget.DimensionBehaviour r4 = r10.widget.getHorizontalDimensionBehaviour();
        if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L60;
        if (r4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L60;
        if (r4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
    L70:
        if (ZeusTransformUtils.instanceOf(r10, ChainRun.class) == false) goto L74;
        return generateChainDisplayGraph((ChainRun) ZeusTransformUtils.preCheckCast(r10, ChainRun.class, "com.obric.memorydata.plugin"), r12);
    L74:
        return r2.toString();
    L57:
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L70;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_HORIZONTAL -> ");
        r2.append(r10.widget.getDebugName());
        String r5 = "_VERTICAL;\n";
    L37:
        r2.append(r5);
    L60:
        if (r0.targets.isEmpty() == true) goto L65;
        if (r1.targets.isEmpty() == false) goto L65;
    L42:
        r2.append("\n");
        r2.append(r1.name());
        r2.append(" -> ");
        String r6 = r0.name();
    L43:
        r2.append(r6);
        r2.append("\n");
    L65:
        if (r0.targets.isEmpty() == false) goto L70;
        if (r1.targets.isEmpty() == true) goto L70;
    L48:
        r2.append("\n");
        r2.append(r0.name());
        r2.append(" -> ");
        r6 = r1.name();
        goto L43
    L17:
        if (ZeusTransformUtils.instanceOf(r10, ChainRun.class) == false) goto L22;
        if (((ChainRun) ZeusTransformUtils.preCheckCast(r10, ChainRun.class, "com.obric.memorydata.plugin")).orientation == 0) goto L49;
    L22:
        if (ZeusTransformUtils.instanceOf(r10, VerticalWidgetRun.class) == false) goto L24;
    L27:
        ConstraintWidget.DimensionBehaviour r7 = r10.widget.getVerticalDimensionBehaviour();
        if (r7 == ConstraintWidget.DimensionBehaviour.FIXED) goto L39;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L39;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L70;
        if (r10.widget.getDimensionRatio() <= 0.0f) goto L70;
        r2.append("\n");
        r2.append(r10.widget.getDebugName());
        r2.append("_VERTICAL -> ");
        r2.append(r10.widget.getDebugName());
        r5 = "_HORIZONTAL;\n";
    L39:
        if (r0.targets.isEmpty() == true) goto L45;
        if (r1.targets.isEmpty() == true) goto L42;
    L45:
        if (r0.targets.isEmpty() == false) goto L70;
        if (r1.targets.isEmpty() == true) goto L70;
    L24:
        if (ZeusTransformUtils.instanceOf(r10, ChainRun.class) == false) goto L70;
        if (((ChainRun) ZeusTransformUtils.preCheckCast(r10, ChainRun.class, "com.obric.memorydata.plugin")).orientation != 1) goto L70;
    L5:
        if (r0.dependencies.isEmpty() == false) goto L11;
        if ((r1.dependencies.isEmpty() & r0.targets.isEmpty()) == false) goto L11;
        if (r1.targets.isEmpty() == false) goto L11;
        return r11;
    }

    private String generateDisplayNode(DependencyNode r5, boolean r6, String r7) {
        StringBuilder r4 = new StringBuilder(r7);
        Iterator<DependencyNode> r8 = r5.targets.iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        DependencyNode r0 = (DependencyNode) ZeusTransformUtils.preCheckCast(r8.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        String r1 = ("\n" + r5.name()) + " -> " + r0.name();
        if (r5.margin > 0) goto L10;
        if (r6 == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r5.run, HelperReferences.class) == true) goto L10;
    L21:
        r4.append(r1 + "\n");
    L10:
        String r2 = r1 + "[";
        if (r5.margin <= 0) goto L15;
        r2 = r2 + "label=\"" + r5.margin + "\"";
        if (r6 == false) goto L15;
        r2 = r2 + ",";
    L15:
        if (r6 == false) goto L18;
        r2 = r2 + " style=dashed ";
    L18:
        if (ZeusTransformUtils.instanceOf(r5.run, HelperReferences.class) == false) goto L20;
        r2 = r2 + " style=bold,color=gray ";
    L20:
        r1 = r2 + "]";
        goto L21
    L23:
        return r4.toString();
    }

    private boolean isCenteredConnection(DependencyNode r6, DependencyNode r7) {
        Iterator<DependencyNode> r5 = r6.targets.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((DependencyNode) ZeusTransformUtils.preCheckCast(r5.next(), DependencyNode.class, "com.obric.memorydata.plugin")) == r7) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        Iterator<DependencyNode> r8 = r7.targets.iterator();
        int r9 = 0;
    L10:
        if (r8.hasNext() == false) goto L14;
        if (((DependencyNode) ZeusTransformUtils.preCheckCast(r8.next(), DependencyNode.class, "com.obric.memorydata.plugin")) == r6) goto L10;
        r9 = r9 + 1;
        goto L10
    L14:
        if (r1 <= 0) goto L28;
        if (r9 <= 0) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    }

    private void measure(ConstraintWidget r2, ConstraintWidget.DimensionBehaviour r3, int r4, ConstraintWidget.DimensionBehaviour r5, int r6) {
        this.mMeasure.horizontalBehavior = r3;
        this.mMeasure.verticalBehavior = r5;
        this.mMeasure.horizontalDimension = r4;
        this.mMeasure.verticalDimension = r6;
        this.mMeasurer.measure(r2, this.mMeasure);
        r2.setWidth(this.mMeasure.measuredWidth);
        r2.setHeight(this.mMeasure.measuredHeight);
        r2.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r2.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun r8) {
        boolean r7 = ZeusTransformUtils.instanceOf(r8, VerticalWidgetRun.class);
        String r0 = r8.widget.getDebugName();
        StringBuilder r1 = new StringBuilder(r0);
        ConstraintWidget r2 = r8.widget;
        if (r7 == true) goto L5;
        ConstraintWidget.DimensionBehaviour r3 = r2.getHorizontalDimensionBehaviour();
    L6:
        RunGroup r4 = r8.runGroup;
        if (r7 == true) goto L9;
        String r5 = "_HORIZONTAL";
    L10:
        r1.append(r5);
        r1.append(" [shape=none, label=<");
        r1.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        r1.append("  <TR>");
        r1.append("    <TD ");
        boolean r6 = r8.start.resolved;
        if (r7 == true) goto L15;
        if (r6 == false) goto L14;
        r1.append(" BGCOLOR=\"green\"");
    L14:
        String r9 = " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
    L18:
        r1.append(r9);
        r1.append("    <TD BORDER=\"1\" ");
        if (r8.dimension.resolved == false) goto L24;
        if (r8.widget.measured == true) goto L24;
        String r10 = " BGCOLOR=\"green\" ";
    L26:
        r1.append(r10);
    L31:
        if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        r1.append("style=\"dashed\"");
    L33:
        r1.append(">");
        r1.append(r0);
        if (r4 == null) goto L36;
        r1.append(" [");
        r1.append(r4.groupIndex + 1);
        r1.append("/");
        r1.append(RunGroup.index);
        r1.append("]");
    L36:
        r1.append(" </TD>");
        r1.append("    <TD ");
        if (r7 == true) goto L44;
        if (r8.end.resolved == false) goto L41;
        r1.append(" BGCOLOR=\"green\"");
    L41:
        String r11 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
    L42:
        r1.append(r11);
        r1.append("  </TR></TABLE>");
        r1.append(">];\n");
        return r1.toString();
    L44:
        if (((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(r8, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline.resolved == false) goto L46;
        r1.append(" BGCOLOR=\"green\"");
    L46:
        r1.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
        r1.append("    <TD ");
        if (r8.end.resolved == false) goto L49;
        r1.append(" BGCOLOR=\"green\"");
    L49:
        r11 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
    L24:
        if (r8.dimension.resolved == false) goto L28;
        r10 = " BGCOLOR=\"lightgray\" ";
        goto L26
    L28:
        if (r8.widget.measured == false) goto L31;
        r10 = " BGCOLOR=\"yellow\" ";
        goto L26
    L15:
        if (r6 == false) goto L17;
        r1.append(" BGCOLOR=\"green\"");
    L17:
        r9 = " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        goto L18
    L9:
        r5 = "_VERTICAL";
        goto L10
    L5:
        r3 = r2.getVerticalDimensionBehaviour();
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

    public void buildGraph(ArrayList<WidgetRun> r6) {
        r6.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        r6.add(this.mContainer.horizontalRun);
        r6.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> r0 = this.mContainer.mChildren.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L30;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Guideline.class) == true) goto L7;
        if (r2.isInHorizontalChain() == true) goto L12;
        r6.add(r2.horizontalRun);
    L19:
        if (r2.isInVerticalChain() == true) goto L21;
        r6.add(r2.verticalRun);
    L28:
        if (ZeusTransformUtils.instanceOf(r2, HelperWidget.class) == false) goto L4;
        WidgetRun r3 = new HelperReferences(r2);
    L8:
        r6.add(r3);
        goto L4
    L21:
        if (r2.verticalChainRun != null) goto L23;
        r2.verticalChainRun = new ChainRun(r2, 1);
    L23:
        if (r1 != null) goto L25;
        r1 = new HashSet();
    L25:
        r1.add(r2.verticalChainRun);
        goto L28
    L12:
        if (r2.horizontalChainRun != null) goto L14;
        r2.horizontalChainRun = new ChainRun(r2, 0);
    L14:
        if (r1 != null) goto L16;
        r1 = new HashSet();
    L16:
        r1.add(r2.horizontalChainRun);
        goto L19
    L7:
        r3 = new GuidelineReference(r2);
        goto L8
    L30:
        if (r1 == null) goto L32;
        r6.addAll(r1);
    L32:
        Iterator<WidgetRun> r4 = r6.iterator();
    L34:
        if (r4.hasNext() == false) goto L36;
        ((WidgetRun) ZeusTransformUtils.preCheckCast(r4.next(), WidgetRun.class, "com.obric.memorydata.plugin")).clear();
        goto L34
    L36:
        Iterator<WidgetRun> r7 = r6.iterator();
    L38:
        if (r7.hasNext() == false) goto L43;
        WidgetRun r5 = (WidgetRun) ZeusTransformUtils.preCheckCast(r7.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r5.widget == this.mContainer) goto L38;
        r5.apply();
        goto L38
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour r8, ConstraintWidget.DimensionBehaviour r9) {
        if (this.mNeedBuildGraph == false) goto L23;
        buildGraph();
        Iterator<ConstraintWidget> r0 = this.container.mChildren.iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L10;
        ConstraintWidget r3 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r3.isTerminalWidget[0] = true;
        r3.isTerminalWidget[1] = true;
        if (ZeusTransformUtils.instanceOf(r3, Barrier.class) == false) goto L6;
        r2 = true;
        goto L6
    L10:
        if (r2 == true) goto L32;
        Iterator<RunGroup> r7 = this.mGroups.iterator();
    L13:
        if (r7.hasNext() == false) goto L33;
        RunGroup r1 = (RunGroup) ZeusTransformUtils.preCheckCast(r7.next(), RunGroup.class, "com.obric.memorydata.plugin");
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L17;
        boolean r4 = true;
    L19:
        if (r9 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L21;
        boolean r5 = true;
    L22:
        r1.defineTerminalWidgets(r4, r5);
        goto L13
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = false;
        goto L19
    L33:
        return;
    L32:
        return;
    }

    public boolean directMeasure(boolean r11) {
        boolean r0 = true;
        boolean r12 = r11 & true;
        if (this.mNeedBuildGraph == false) goto L5;
    L6:
        Iterator<ConstraintWidget> r1 = this.container.mChildren.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ConstraintWidget r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r1.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r4.ensureWidgetRuns();
        r4.measured = false;
        r4.horizontalRun.reset();
        r4.verticalRun.reset();
        goto L8
    L10:
        this.container.ensureWidgetRuns();
        this.container.measured = false;
        this.container.horizontalRun.reset();
        this.container.verticalRun.reset();
        this.mNeedRedoMeasures = false;
    L12:
        if (basicMeasureWidgets(this.mContainer) == false) goto L14;
        return false;
    L14:
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour r2 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r5 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph == false) goto L17;
        buildGraph();
    L17:
        int r6 = this.container.getX();
        int r7 = this.container.getY();
        this.container.horizontalRun.start.resolve(r6);
        this.container.verticalRun.start.resolve(r7);
        measureWidgets();
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L20;
    L21:
        if (r12 == false) goto L28;
        Iterator<WidgetRun> r8 = this.mRuns.iterator();
    L24:
        if (r8.hasNext() == false) goto L28;
        if (((WidgetRun) ZeusTransformUtils.preCheckCast(r8.next(), WidgetRun.class, "com.obric.memorydata.plugin")).supportsWrapComputation() == true) goto L24;
        r12 = false;
    L28:
        if (r12 == true) goto L30;
    L32:
        if (r12 == true) goto L34;
    L37:
        if (this.container.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L39;
    L42:
        int r13 = this.container.getWidth() + r6;
        this.container.horizontalRun.end.resolve(r13);
        this.container.horizontalRun.dimension.resolve(r13 - r6);
        measureWidgets();
        if (this.container.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L45;
    L46:
        int r14 = this.container.getHeight() + r7;
        this.container.verticalRun.end.resolve(r14);
        this.container.verticalRun.dimension.resolve(r14 - r7);
    L47:
        measureWidgets();
        boolean r15 = true;
    L48:
        Iterator<WidgetRun> r9 = this.mRuns.iterator();
    L50:
        if (r9.hasNext() == false) goto L57;
        WidgetRun r10 = (WidgetRun) ZeusTransformUtils.preCheckCast(r9.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r10.widget != this.container) goto L56;
        if (r10.resolved == false) goto L50;
    L56:
        r10.applyToWidget();
        goto L50
    L57:
        Iterator<WidgetRun> r16 = this.mRuns.iterator();
    L59:
        if (r16.hasNext() == false) goto L80;
        WidgetRun r17 = (WidgetRun) ZeusTransformUtils.preCheckCast(r16.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r15 == true) goto L66;
        if (r17.widget == this.container) goto L59;
    L66:
        if (r17.start.resolved == false) goto L67;
        if (r17.end.resolved == true) goto L74;
        if (ZeusTransformUtils.instanceOf(r17, GuidelineReference.class) == false) goto L67;
    L74:
        if (r17.dimension.resolved == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, ChainRun.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, GuidelineReference.class) == true) goto L59;
    L67:
        r0 = false;
    L80:
        this.container.setHorizontalDimensionBehaviour(r2);
        this.container.setVerticalDimensionBehaviour(r5);
        return r0;
    L45:
        if (this.container.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L47;
    L39:
        if (this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L42;
        r15 = false;
        goto L48
    L34:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r18 = this.container;
        r18.setHeight(computeWrap(r18, 1));
        this.container.verticalRun.dimension.resolve(this.container.getHeight());
        goto L37
    L30:
        if (r2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r19 = this.container;
        r19.setWidth(computeWrap(r19, 0));
        this.container.horizontalRun.dimension.resolve(this.container.getWidth());
        goto L32
    L20:
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L37;
    L5:
        if (this.mNeedRedoMeasures == false) goto L12;
        goto L6
    }

    public boolean directMeasureSetup(boolean r5) {
        if (this.mNeedBuildGraph == false) goto L10;
        Iterator<ConstraintWidget> r6 = this.container.mChildren.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r6.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r1.ensureWidgetRuns();
        r1.measured = false;
        r1.horizontalRun.dimension.resolved = false;
        r1.horizontalRun.resolved = false;
        r1.horizontalRun.reset();
        r1.verticalRun.dimension.resolved = false;
        r1.verticalRun.resolved = false;
        r1.verticalRun.reset();
        goto L6
    L8:
        this.container.ensureWidgetRuns();
        this.container.measured = false;
        this.container.horizontalRun.dimension.resolved = false;
        this.container.horizontalRun.resolved = false;
        this.container.horizontalRun.reset();
        this.container.verticalRun.dimension.resolved = false;
        this.container.verticalRun.resolved = false;
        this.container.verticalRun.reset();
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

    public boolean directMeasureWithOrientation(boolean r11, int r12) {
        boolean r0 = true;
        boolean r13 = r11 & true;
        ConstraintWidget.DimensionBehaviour r1 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r3 = this.container.getDimensionBehaviour(1);
        int r4 = this.container.getX();
        int r5 = this.container.getY();
        if (r13 == true) goto L5;
    L26:
        ConstraintWidget.DimensionBehaviour[] r14 = this.container.mListDimensionBehaviors;
        if (r12 != 0) goto L34;
        if (r14[0] != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
    L32:
        int r15 = this.container.getWidth() + r4;
        this.container.horizontalRun.end.resolve(r15);
        this.container.horizontalRun.dimension.resolve(r15 - r4);
    L40:
        boolean r16 = true;
    L41:
        measureWidgets();
        Iterator<WidgetRun> r6 = this.mRuns.iterator();
    L43:
        if (r6.hasNext() == false) goto L53;
        WidgetRun r7 = (WidgetRun) ZeusTransformUtils.preCheckCast(r6.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r7.orientation != r12) goto L43;
        if (r7.widget != this.container) goto L52;
        if (r7.resolved == false) goto L43;
    L52:
        r7.applyToWidget();
        goto L43
    L53:
        Iterator<WidgetRun> r8 = this.mRuns.iterator();
    L55:
        if (r8.hasNext() == false) goto L74;
        WidgetRun r9 = (WidgetRun) ZeusTransformUtils.preCheckCast(r8.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r9.orientation != r12) goto L55;
        if (r16 == true) goto L64;
        if (r9.widget == this.container) goto L55;
    L64:
        if (r9.start.resolved == false) goto L65;
        if (r9.end.resolved == false) goto L65;
        if (ZeusTransformUtils.instanceOf(r9, ChainRun.class) == true) goto L55;
        if (r9.dimension.resolved == true) goto L55;
    L65:
        r0 = false;
    L74:
        this.container.setHorizontalDimensionBehaviour(r1);
        this.container.setVerticalDimensionBehaviour(r3);
        return r0;
    L31:
        if (this.container.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
    L38:
        r16 = false;
        goto L41
    L34:
        if (r14[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
    L39:
        int r17 = this.container.getHeight() + r5;
        this.container.verticalRun.end.resolve(r17);
        this.container.verticalRun.dimension.resolve(r17 - r5);
        goto L40
    L36:
        if (this.container.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L38;
    L5:
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L7;
    L8:
        Iterator<WidgetRun> r10 = this.mRuns.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        WidgetRun r18 = (WidgetRun) ZeusTransformUtils.preCheckCast(r10.next(), WidgetRun.class, "com.obric.memorydata.plugin");
        if (r18.orientation != r12) goto L10;
        if (r18.supportsWrapComputation() == true) goto L10;
        r13 = false;
    L16:
        if (r12 != 0) goto L21;
        if (r13 == false) goto L26;
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r19 = this.container;
        r19.setWidth(computeWrap(r19, 0));
        DimensionDependency r110 = this.container.horizontalRun.dimension;
        int r20 = this.container.getWidth();
    L25:
        r110.resolve(r20);
        goto L26
    L21:
        if (r13 == false) goto L26;
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r111 = this.container;
        r111.setHeight(computeWrap(r111, 1));
        r110 = this.container.verticalRun.dimension;
        r20 = this.container.getHeight();
        goto L25
    L7:
        if (r3 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        goto L8
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        Iterator<ConstraintWidget> r0 = this.container.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L46;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r1.measured == true) goto L4;
        boolean r3 = false;
        ConstraintWidget.DimensionBehaviour r8 = r1.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r10 = r1.mListDimensionBehaviors[1];
        int r2 = r1.mMatchConstraintDefaultWidth;
        int r4 = r1.mMatchConstraintDefaultHeight;
        if (r8 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
    L15:
        boolean r5 = true;
    L17:
        if (r10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L19;
    L21:
        r3 = true;
    L22:
        boolean r6 = r1.horizontalRun.dimension.resolved;
        boolean r7 = r1.verticalRun.dimension.resolved;
        if (r6 == false) goto L27;
        if (r7 == false) goto L27;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, r1.verticalRun.dimension.value);
    L26:
        r1.measured = true;
    L42:
        if (r1.measured == false) goto L4;
        if (r1.verticalRun.baselineDimension == null) goto L4;
        r1.verticalRun.baselineDimension.resolve(r1.getBaselineDistance());
    L27:
        if (r6 == false) goto L35;
        if (r3 == false) goto L35;
        measure(r1, ConstraintWidget.DimensionBehaviour.FIXED, r1.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.verticalRun.dimension.value);
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        DimensionDependency r9 = r1.verticalRun.dimension;
        int r11 = r1.getHeight();
    L32:
        r9.wrapValue = r11;
        goto L42
    L33:
        DimensionDependency r12 = r1.verticalRun.dimension;
        int r13 = r1.getHeight();
    L34:
        r12.resolve(r13);
    L35:
        if (r7 == false) goto L42;
        if (r5 == false) goto L42;
        measure(r1, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, r1.horizontalRun.dimension.value, ConstraintWidget.DimensionBehaviour.FIXED, r1.verticalRun.dimension.value);
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L40;
        r9 = r1.horizontalRun.dimension;
        r11 = r1.getWidth();
        goto L32
    L40:
        r12 = r1.horizontalRun.dimension;
        r13 = r1.getWidth();
        goto L34
    L19:
        if (r10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L22;
        if (r4 != 1) goto L22;
    L11:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r2 == 1) goto L15;
    L14:
        r5 = false;
        goto L17
    }

    public void setMeasurer(BasicMeasure.Measurer r3) {
        this.mMeasurer = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r3, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
    }
}

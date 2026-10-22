package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    public boolean dual;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position;
    ArrayList<WidgetRun> runs;

    public RunGroup(WidgetRun r3, int r4) {
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        this.groupIndex = 0;
        int r0 = index;
        this.groupIndex = r0;
        index = r0 + 1;
        this.firstRun = r3;
        this.lastRun = r3;
        this.direction = r4;
    }

    private boolean defineTerminalWidget(WidgetRun r8, int r9) {
        if (r8.widget.isTerminalWidget[r9] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r0 = r8.start.dependencies.iterator();
    L7:
        if (r0.hasNext() == false) goto L25;
        Dependency r2 = (Dependency) ZeusTransformUtils.preCheckCast(r0.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, DependencyNode.class) == false) goto L7;
        DependencyNode r3 = (DependencyNode) ZeusTransformUtils.preCheckCast(r2, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r3.run == r8) goto L7;
        if (r3 != r3.run.start) goto L7;
        if (ZeusTransformUtils.instanceOf(r8, ChainRun.class) == false) goto L22;
        Iterator<WidgetRun> r4 = ((ChainRun) ZeusTransformUtils.preCheckCast(r8, ChainRun.class, "com.obric.memorydata.plugin")).widgets.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        defineTerminalWidget((WidgetRun) ZeusTransformUtils.preCheckCast(r4.next(), WidgetRun.class, "com.obric.memorydata.plugin"), r9);
    L24:
        defineTerminalWidget(r3.run, r9);
        goto L7
    L22:
        if (ZeusTransformUtils.instanceOf(r8, HelperReferences.class) == true) goto L24;
        r8.widget.isTerminalWidget[r9] = false;
        goto L24
    L25:
        Iterator<Dependency> r1 = r8.end.dependencies.iterator();
    L27:
        if (r1.hasNext() == false) goto L45;
        Dependency r5 = (Dependency) ZeusTransformUtils.preCheckCast(r1.next(), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DependencyNode.class) == false) goto L27;
        DependencyNode r6 = (DependencyNode) ZeusTransformUtils.preCheckCast(r5, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r6.run == r8) goto L27;
        if (r6 != r6.run.start) goto L27;
        if (ZeusTransformUtils.instanceOf(r8, ChainRun.class) == false) goto L42;
        Iterator<WidgetRun> r7 = ((ChainRun) ZeusTransformUtils.preCheckCast(r8, ChainRun.class, "com.obric.memorydata.plugin")).widgets.iterator();
    L39:
        if (r7.hasNext() == false) goto L44;
        defineTerminalWidget((WidgetRun) ZeusTransformUtils.preCheckCast(r7.next(), WidgetRun.class, "com.obric.memorydata.plugin"), r9);
    L44:
        defineTerminalWidget(r6.run, r9);
        goto L27
    L42:
        if (ZeusTransformUtils.instanceOf(r8, HelperReferences.class) == true) goto L44;
        r8.widget.isTerminalWidget[r9] = false;
        goto L44
    L45:
        return false;
    }

    private long traverseEnd(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.run;
        if (ZeusTransformUtils.instanceOf(r0, HelperReferences.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.dependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = (Dependency) ZeusTransformUtils.preCheckCast(r9.dependencies.get(r2), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DependencyNode.class) == false) goto L13;
        DependencyNode r6 = (DependencyNode) ZeusTransformUtils.preCheckCast(r5, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r6.run == r0) goto L13;
        r3 = Math.min(r3, traverseEnd(r6, ((long) r6.margin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.end) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 - r4;
        return Math.min(Math.min(r3, traverseEnd(r0.start, r11)), r11 - ((long) r0.start.margin));
    L22:
        return r3;
    }

    private long traverseStart(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.run;
        if (ZeusTransformUtils.instanceOf(r0, HelperReferences.class) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.dependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = (Dependency) ZeusTransformUtils.preCheckCast(r9.dependencies.get(r2), Dependency.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DependencyNode.class) == false) goto L13;
        DependencyNode r6 = (DependencyNode) ZeusTransformUtils.preCheckCast(r5, DependencyNode.class, "com.obric.memorydata.plugin");
        if (r6.run == r0) goto L13;
        r3 = Math.max(r3, traverseStart(r6, ((long) r6.margin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.start) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 + r4;
        return Math.max(Math.max(r3, traverseStart(r0.end, r11)), r11 - ((long) r0.end.margin));
    L22:
        return r3;
    }

    public void add(WidgetRun r2) {
        this.runs.add(r2);
        this.lastRun = r2;
    }

    public long computeWrapSize(ConstraintWidgetContainer r12, int r13) {
        long r1 = 0;
        if (ZeusTransformUtils.instanceOf(this.firstRun, ChainRun.class) == true) goto L5;
        WidgetRun r0 = this.firstRun;
        if (r13 != 0) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, HorizontalWidgetRun.class) == true) goto L15;
        return 0;
    L15:
        if (r13 != 0) goto L17;
        DependencyNode r2 = r12.horizontalRun.start;
    L18:
        if (r13 != 0) goto L20;
        DependencyNode r14 = r12.horizontalRun.end;
    L21:
        boolean r3 = this.firstRun.start.targets.contains(r2);
        boolean r15 = this.firstRun.end.targets.contains(r14);
        long r4 = this.firstRun.getWrapDimension();
        if (r3 == false) goto L34;
        if (r15 == false) goto L34;
        long r5 = traverseStart(this.firstRun.start, 0);
        long r7 = traverseEnd(this.firstRun.end, 0);
        long r6 = r5 - r4;
        if (r6 < (-this.firstRun.end.margin)) goto L27;
        r6 = r6 + ((long) this.firstRun.end.margin);
    L27:
        long r8 = ((-r7) - r4) - ((long) this.firstRun.start.margin);
        if (r8 < this.firstRun.start.margin) goto L30;
        r8 = r8 - ((long) this.firstRun.start.margin);
    L30:
        float r16 = this.firstRun.widget.getBiasPercent(r13);
        if (r16 <= 0.0f) goto L33;
        r1 = (long) ((r8 / r16) + (r6 / (1.0f - r16)));
    L33:
        float r17 = r1;
        long r18 = ((long) this.firstRun.start.margin) + ((((long) ((r17 * r16) + 0.5f)) + r4) + ((long) ((r17 * (1.0f - r16)) + 0.5f)));
    L40:
        return r18 - ((long) this.firstRun.end.margin);
    L34:
        if (r3 == true) goto L41;
        if (r15 == false) goto L38;
        long r19 = traverseEnd(this.firstRun.end, this.firstRun.end.margin);
        return Math.max(-r19, ((long) (-this.firstRun.end.margin)) + r4);
    L38:
        r18 = ((long) this.firstRun.start.margin) + this.firstRun.getWrapDimension();
        goto L40
    L41:
        return Math.max(traverseStart(this.firstRun.start, this.firstRun.start.margin), ((long) this.firstRun.start.margin) + r4);
    L20:
        r14 = r12.verticalRun.end;
        goto L21
    L17:
        r2 = r12.verticalRun.start;
        goto L18
    L13:
        if (ZeusTransformUtils.instanceOf(r0, VerticalWidgetRun.class) == true) goto L15;
        return 0;
    L5:
        if (((ChainRun) ZeusTransformUtils.preCheckCast(this.firstRun, ChainRun.class, "com.obric.memorydata.plugin")).orientation == r13) goto L15;
        return 0;
    }

    public void defineTerminalWidgets(boolean r2, boolean r3) {
        if (r2 == true) goto L4;
    L6:
        if (r3 == true) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(this.firstRun, VerticalWidgetRun.class) == false) goto L12;
        defineTerminalWidget(this.firstRun, 1);
        return;
    L12:
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(this.firstRun, HorizontalWidgetRun.class) == false) goto L6;
        defineTerminalWidget(this.firstRun, 0);
        goto L6
    }
}

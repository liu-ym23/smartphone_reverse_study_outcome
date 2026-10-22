package androidx.constraintlayout.solver.widgets.analyzer;

import ai.j0;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
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

    public RunGroup(WidgetRun r5, int r10) {
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        int r11 = index;
        this.groupIndex = r11;
        index = r11 + 1;
        this.firstRun = r5;
        this.lastRun = r5;
        this.direction = r10;
    }

    private boolean defineTerminalWidget(WidgetRun r10, int r11) {
        if (r10.widget.isTerminalWidget[r11] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r5 = r10.start.dependencies.iterator();
    L7:
        if (r5.hasNext() == false) goto L25;
        Dependency r12 = r5.next();
        if ((r12 instanceof DependencyNode) == false) goto L7;
        DependencyNode r13 = (DependencyNode) r12;
        WidgetRun r14 = r13.run;
        if (r14 == r10) goto L7;
        if (r13 != r14.start) goto L7;
        if ((r10 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r15 = ((ChainRun) r10).widgets.iterator();
    L19:
        if (r15.hasNext() == false) goto L24;
        defineTerminalWidget(r15.next(), r11);
    L24:
        defineTerminalWidget(r13.run, r11);
        goto L7
    L22:
        if ((r10 instanceof HelperReferences) == true) goto L24;
        r10.widget.isTerminalWidget[r11] = false;
        goto L24
    L25:
        Iterator<Dependency> r16 = r10.end.dependencies.iterator();
    L27:
        if (r16.hasNext() == false) goto L45;
        Dependency r17 = r16.next();
        if ((r17 instanceof DependencyNode) == false) goto L27;
        DependencyNode r18 = (DependencyNode) r17;
        WidgetRun r19 = r18.run;
        if (r19 == r10) goto L27;
        if (r18 != r19.start) goto L27;
        if ((r10 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r20 = ((ChainRun) r10).widgets.iterator();
    L39:
        if (r20.hasNext() == false) goto L44;
        defineTerminalWidget(r20.next(), r11);
    L44:
        defineTerminalWidget(r18.run, r11);
        goto L27
    L42:
        if ((r10 instanceof HelperReferences) == true) goto L44;
        r10.widget.isTerminalWidget[r11] = false;
        goto L44
    L45:
        return false;
    }

    private long traverseEnd(DependencyNode r10, long r11) {
        WidgetRun r5 = r10.run;
        if ((r5 instanceof HelperReferences) == false) goto L5;
        return r11;
    L5:
        int r12 = r10.dependencies.size();
        int r13 = 0;
        long r14 = r11;
    L6:
        if (r13 >= r12) goto L15;
        Dependency r15 = r10.dependencies.get(r13);
        if ((r15 instanceof DependencyNode) == false) goto L13;
        DependencyNode r16 = (DependencyNode) r15;
        if (r16.run == r5) goto L13;
        r14 = Math.min(r14, traverseEnd(r16, ((long) r16.margin) + r11));
    L13:
        r13 = r13 + 1;
        goto L6
    L15:
        if (r10 != r5.end) goto L22;
        long r17 = r5.getWrapDimension();
        long r18 = r11 - r17;
        return Math.min(Math.min(r14, traverseEnd(r5.start, r18)), r18 - ((long) r5.start.margin));
    L22:
        return r14;
    }

    private long traverseStart(DependencyNode r10, long r11) {
        WidgetRun r5 = r10.run;
        if ((r5 instanceof HelperReferences) == false) goto L5;
        return r11;
    L5:
        int r12 = r10.dependencies.size();
        int r13 = 0;
        long r14 = r11;
    L6:
        if (r13 >= r12) goto L15;
        Dependency r15 = r10.dependencies.get(r13);
        if ((r15 instanceof DependencyNode) == false) goto L13;
        DependencyNode r16 = (DependencyNode) r15;
        if (r16.run == r5) goto L13;
        r14 = Math.max(r14, traverseStart(r16, ((long) r16.margin) + r11));
    L13:
        r13 = r13 + 1;
        goto L6
    L15:
        if (r10 != r5.start) goto L22;
        long r17 = r5.getWrapDimension();
        long r18 = r11 + r17;
        return Math.max(Math.max(r14, traverseStart(r5.end, r18)), r18 - ((long) r5.end.margin));
    L22:
        return r14;
    }

    public void add(WidgetRun r5) {
        this.runs.add(r5);
        this.lastRun = r5;
    }

    public long computeWrapSize(ConstraintWidgetContainer r12, int r13) {
        WidgetRun r5 = this.firstRun;
        long r10 = 0;
        if ((r5 instanceof ChainRun) == true) goto L5;
        if (r13 != 0) goto L12;
        if ((r5 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L17;
        WidgetRun r11 = r12.horizontalRun;
    L16:
        DependencyNode r14 = r11.start;
        if (r13 != 0) goto L21;
        WidgetRun r15 = r12.horizontalRun;
    L20:
        DependencyNode r16 = r15.end;
        boolean r17 = r5.start.targets.contains(r14);
        boolean r18 = this.firstRun.end.targets.contains(r16);
        long r19 = this.firstRun.getWrapDimension();
        if (r17 == false) goto L36;
        if (r18 == false) goto L36;
        long r20 = traverseStart(this.firstRun.start, 0);
        long r21 = traverseEnd(this.firstRun.end, 0);
        long r22 = r20 - r19;
        WidgetRun r110 = this.firstRun;
        int r23 = r110.end.margin;
        if (r22 < (-r23)) goto L28;
        r22 = r22 + ((long) r23);
    L28:
        int r24 = r110.start.margin;
        long r25 = ((-r21) - r19) - ((long) r24);
        if (r25 < r24) goto L31;
        r25 = r25 - ((long) r24);
    L31:
        float r111 = r110.widget.getBiasPercent(r13);
        if (r111 <= 0.0f) goto L34;
        r10 = (long) ((r22 / (1.0f - r111)) + (r25 / r111));
    L34:
        float r112 = r10;
        long r26 = (((long) ((r112 * r111) + 0.5f)) + r19) + ((long) j0.b(1.0f, r111, r112, 0.5f));
        WidgetRun r113 = this.firstRun;
        long r114 = ((long) r113.start.margin) + r26;
        int r115 = r113.end.margin;
    L41:
        return r114 - ((long) r115);
    L36:
        if (r17 == false) goto L38;
        DependencyNode r116 = this.firstRun.start;
        return Math.max(traverseStart(r116, r116.margin), ((long) this.firstRun.start.margin) + r19);
    L38:
        if (r18 == false) goto L40;
        DependencyNode r117 = this.firstRun.end;
        long r118 = traverseEnd(r117, r117.margin);
        return Math.max(-r118, ((long) (-this.firstRun.end.margin)) + r19);
    L40:
        WidgetRun r119 = this.firstRun;
        r114 = r119.getWrapDimension() + r119.start.margin;
        r115 = this.firstRun.end.margin;
        goto L41
    L21:
        r15 = r12.verticalRun;
        goto L20
    L17:
        r11 = r12.verticalRun;
        goto L16
    L12:
        if ((r5 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r5).orientation == r13) goto L14;
        return 0;
    }

    public void defineTerminalWidgets(boolean r5, boolean r10) {
        if (r5 == false) goto L6;
        WidgetRun r11 = this.firstRun;
        if ((r11 instanceof HorizontalWidgetRun) == false) goto L6;
        defineTerminalWidget(r11, 0);
    L6:
        if (r10 == false) goto L11;
        WidgetRun r12 = this.firstRun;
        if ((r12 instanceof VerticalWidgetRun) == false) goto L12;
        defineTerminalWidget(r12, 1);
        return;
    L12:
        return;
    }
}

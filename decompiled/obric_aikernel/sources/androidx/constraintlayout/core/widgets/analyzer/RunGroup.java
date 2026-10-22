package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
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

    public RunGroup(WidgetRun r10, int r11) {
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        this.groupIndex = 0;
        int r12 = index;
        this.groupIndex = r12;
        index = r12 + 1;
        this.firstRun = r10;
        this.lastRun = r10;
        this.direction = r11;
    }

    private boolean defineTerminalWidget(WidgetRun r10, int r11) {
        if (r10.widget.isTerminalWidget[r11] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r12 = r10.start.dependencies.iterator();
    L7:
        if (r12.hasNext() == false) goto L25;
        Dependency r13 = r12.next();
        if ((r13 instanceof DependencyNode) == false) goto L7;
        DependencyNode r14 = (DependencyNode) r13;
        WidgetRun r15 = r14.run;
        if (r15 == r10) goto L7;
        if (r14 != r15.start) goto L7;
        if ((r10 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r16 = ((ChainRun) r10).widgets.iterator();
    L19:
        if (r16.hasNext() == false) goto L24;
        defineTerminalWidget(r16.next(), r11);
    L24:
        defineTerminalWidget(r14.run, r11);
        goto L7
    L22:
        if ((r10 instanceof HelperReferences) == true) goto L24;
        r10.widget.isTerminalWidget[r11] = false;
        goto L24
    L25:
        Iterator<Dependency> r17 = r10.end.dependencies.iterator();
    L27:
        if (r17.hasNext() == false) goto L45;
        Dependency r18 = r17.next();
        if ((r18 instanceof DependencyNode) == false) goto L27;
        DependencyNode r19 = (DependencyNode) r18;
        WidgetRun r20 = r19.run;
        if (r20 == r10) goto L27;
        if (r19 != r20.start) goto L27;
        if ((r10 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r21 = ((ChainRun) r10).widgets.iterator();
    L39:
        if (r21.hasNext() == false) goto L44;
        defineTerminalWidget(r21.next(), r11);
    L44:
        defineTerminalWidget(r19.run, r11);
        goto L27
    L42:
        if ((r10 instanceof HelperReferences) == true) goto L44;
        r10.widget.isTerminalWidget[r11] = false;
        goto L44
    L45:
        return false;
    }

    private long traverseEnd(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.run;
        if ((r12 instanceof HelperReferences) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.dependencies.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = r10.dependencies.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.run == r12) goto L13;
        r15 = Math.min(r15, traverseEnd(r17, ((long) r17.margin) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.end) goto L22;
        long r18 = r12.getWrapDimension();
        long r19 = r11 - r18;
        return Math.min(Math.min(r15, traverseEnd(r12.start, r19)), r19 - ((long) r12.start.margin));
    L22:
        return r15;
    }

    private long traverseStart(DependencyNode r10, long r11) {
        WidgetRun r12 = r10.run;
        if ((r12 instanceof HelperReferences) == false) goto L5;
        return r11;
    L5:
        int r13 = r10.dependencies.size();
        int r14 = 0;
        long r15 = r11;
    L6:
        if (r14 >= r13) goto L15;
        Dependency r16 = r10.dependencies.get(r14);
        if ((r16 instanceof DependencyNode) == false) goto L13;
        DependencyNode r17 = (DependencyNode) r16;
        if (r17.run == r12) goto L13;
        r15 = Math.max(r15, traverseStart(r17, ((long) r17.margin) + r11));
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r10 != r12.start) goto L22;
        long r18 = r12.getWrapDimension();
        long r19 = r11 + r18;
        return Math.max(Math.max(r15, traverseStart(r12.end, r19)), r19 - ((long) r12.end.margin));
    L22:
        return r15;
    }

    public void add(WidgetRun r10) {
        this.runs.add(r10);
        this.lastRun = r10;
    }

    public long computeWrapSize(ConstraintWidgetContainer r12, int r13) {
        WidgetRun r10 = this.firstRun;
        long r11 = 0;
        if ((r10 instanceof ChainRun) == true) goto L5;
        if (r13 != 0) goto L12;
        if ((r10 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L16;
        WidgetRun r14 = r12.horizontalRun;
    L17:
        DependencyNode r15 = r14.start;
        if (r13 != 0) goto L20;
        WidgetRun r16 = r12.horizontalRun;
    L21:
        DependencyNode r17 = r16.end;
        boolean r18 = r10.start.targets.contains(r15);
        boolean r19 = this.firstRun.end.targets.contains(r17);
        long r20 = this.firstRun.getWrapDimension();
        if (r18 == false) goto L34;
        if (r19 == false) goto L34;
        long r21 = traverseStart(this.firstRun.start, 0);
        long r22 = traverseEnd(this.firstRun.end, 0);
        long r23 = r21 - r20;
        WidgetRun r110 = this.firstRun;
        int r24 = r110.end.margin;
        if (r23 < (-r24)) goto L27;
        r23 = r23 + ((long) r24);
    L27:
        int r25 = r110.start.margin;
        long r26 = ((-r22) - r20) - ((long) r25);
        if (r26 < r25) goto L30;
        r26 = r26 - ((long) r25);
    L30:
        float r111 = r110.widget.getBiasPercent(r13);
        if (r111 <= 0.0f) goto L33;
        r11 = (long) ((r26 / r111) + (r23 / (1.0f - r111)));
    L33:
        float r112 = r11;
        long r27 = (((long) ((r112 * r111) + 0.5f)) + r20) + ((long) ((r112 * (1.0f - r111)) + 0.5f));
        WidgetRun r113 = this.firstRun;
        return (((long) r113.start.margin) + r27) - ((long) r113.end.margin);
    L34:
        if (r18 == false) goto L36;
        DependencyNode r114 = this.firstRun.start;
        return Math.max(traverseStart(r114, r114.margin), ((long) this.firstRun.start.margin) + r20);
    L36:
        if (r19 == false) goto L38;
        DependencyNode r115 = this.firstRun.end;
        long r116 = traverseEnd(r115, r115.margin);
        return Math.max(-r116, ((long) (-this.firstRun.end.margin)) + r20);
    L38:
        WidgetRun r117 = this.firstRun;
        return (((long) r117.start.margin) + r117.getWrapDimension()) - ((long) this.firstRun.end.margin);
    L20:
        r16 = r12.verticalRun;
        goto L21
    L16:
        r14 = r12.verticalRun;
        goto L17
    L12:
        if ((r10 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r10).orientation == r13) goto L14;
        return 0;
    }

    public void defineTerminalWidgets(boolean r10, boolean r11) {
        if (r10 == false) goto L6;
        WidgetRun r12 = this.firstRun;
        if ((r12 instanceof HorizontalWidgetRun) == false) goto L6;
        defineTerminalWidget(r12, 0);
    L6:
        if (r11 == false) goto L11;
        WidgetRun r13 = this.firstRun;
        if ((r13 instanceof VerticalWidgetRun) == false) goto L12;
        defineTerminalWidget(r13, 1);
        return;
    L12:
        return;
    }
}

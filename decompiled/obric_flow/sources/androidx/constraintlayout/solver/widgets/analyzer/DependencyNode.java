package androidx.constraintlayout.solver.widgets.analyzer;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DependencyNode implements Dependency {
    public boolean delegateToWidgetRun;
    List<Dependency> dependencies;
    int margin;
    DimensionDependency marginDependency;
    int marginFactor;
    public boolean readyToSolve;
    public boolean resolved;
    WidgetRun run;
    List<DependencyNode> targets;
    Type type;
    public Dependency updateDelegate;
    public int value;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type HORIZONTAL_DIMENSION = null;
        public static final Type LEFT = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final Type UNKNOWN = null;
        public static final Type VERTICAL_DIMENSION = null;

        static {
            Type r5 = new Type("UNKNOWN", 0);
            UNKNOWN = r5;
            Type r10 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r10;
            Type r11 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r11;
            Type r12 = new Type("LEFT", 3);
            LEFT = r12;
            Type r13 = new Type("RIGHT", 4);
            RIGHT = r13;
            Type r14 = new Type("TOP", 5);
            TOP = r14;
            Type r15 = new Type("BOTTOM", 6);
            BOTTOM = r15;
            Type r16 = new Type("BASELINE", 7);
            BASELINE = r16;
            $VALUES = new Type[]{r5, r10, r11, r12, r13, r14, r15, r16};
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public DependencyNode(WidgetRun r5) {
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = r5;
    }

    public void addDependency(Dependency r5) {
        this.dependencies.add(r5);
        if (this.resolved == false) goto L6;
        r5.update(r5);
        return;
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String r5 = this.run.widget.getDebugName();
        Type r10 = this.type;
        if (r10 != Type.LEFT) goto L5;
    L8:
        String r11 = j0.j(r5, "_HORIZONTAL");
    L9:
        StringBuilder r12 = j0.w(r11, ":");
        r12.append(this.type.name());
        return r12.toString();
    L5:
        if (r10 == Type.RIGHT) goto L8;
        r11 = j0.j(r5, "_VERTICAL");
        goto L9
    }

    public void resolve(int r5) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r5;
        Iterator<Dependency> r10 = this.dependencies.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Dependency r11 = r10.next();
        r11.update(r11);
        goto L7
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.run.widget.getDebugName());
        r5.append(":");
        r5.append(this.type);
        r5.append("(");
        if (this.resolved == false) goto L5;
        Object r10 = Integer.valueOf(this.value);
    L6:
        r5.append(r10);
        r5.append(") <t=");
        r5.append(this.targets.size());
        r5.append(":d=");
        r5.append(this.dependencies.size());
        r5.append(">");
        return r5.toString();
    L5:
        r10 = "unresolved";
        goto L6
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Iterator<DependencyNode> r11 = this.targets.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r11.next().resolved == true) goto L4;
        return;
    L8:
        this.readyToSolve = true;
        Dependency r5 = this.updateDelegate;
        if (r5 == null) goto L12;
        r5.update(this);
    L12:
        if (this.delegateToWidgetRun == false) goto L15;
        this.run.update(this);
        return;
    L15:
        Iterator<DependencyNode> r12 = this.targets.iterator();
        DependencyNode r13 = null;
        int r14 = 0;
    L17:
        if (r12.hasNext() == false) goto L22;
        DependencyNode r15 = r12.next();
        if ((r15 instanceof DimensionDependency) == true) goto L17;
        r14 = r14 + 1;
        r13 = r15;
        goto L17
    L22:
        if (r13 == null) goto L33;
        if (r14 != 1) goto L33;
        if (r13.resolved == false) goto L33;
        DimensionDependency r16 = this.marginDependency;
        if (r16 != null) goto L29;
    L32:
        resolve(r13.value + this.margin);
        goto L33
    L29:
        if (r16.resolved == false) goto L31;
        this.margin = this.marginFactor * r16.value;
        goto L32
    L31:
        return;
    L33:
        Dependency r17 = this.updateDelegate;
        if (r17 == null) goto L45;
        r17.update(this);
        return;
    }
}

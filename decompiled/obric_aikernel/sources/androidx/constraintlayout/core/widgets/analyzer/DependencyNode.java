package androidx.constraintlayout.core.widgets.analyzer;

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

    static final enum Type extends Enum<Type> {
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
            Type r10 = new Type("UNKNOWN", 0);
            UNKNOWN = r10;
            Type r11 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r11;
            Type r12 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r12;
            Type r13 = new Type("LEFT", 3);
            LEFT = r13;
            Type r14 = new Type("RIGHT", 4);
            RIGHT = r14;
            Type r15 = new Type("TOP", 5);
            TOP = r15;
            Type r16 = new Type("BOTTOM", 6);
            BOTTOM = r16;
            Type r17 = new Type("BASELINE", 7);
            BASELINE = r17;
            $VALUES = new Type[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public DependencyNode(WidgetRun r10) {
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = r10;
    }

    public void addDependency(Dependency r10) {
        this.dependencies.add(r10);
        if (this.resolved == false) goto L6;
        r10.update(r10);
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
        String r10 = this.run.widget.getDebugName();
        Type r11 = this.type;
        if (r11 != Type.LEFT) goto L5;
    L8:
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        String r13 = "_HORIZONTAL";
    L9:
        r12.append(r13);
        return r12.toString() + ":" + this.type.name();
    L5:
        if (r11 == Type.RIGHT) goto L8;
        r12 = new StringBuilder();
        r12.append(r10);
        r13 = "_VERTICAL";
        goto L9
    }

    public void resolve(int r10) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r10;
        Iterator<Dependency> r11 = this.dependencies.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Dependency r12 = r11.next();
        r12.update(r12);
        goto L7
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.run.widget.getDebugName());
        r10.append(":");
        r10.append(this.type);
        r10.append("(");
        if (this.resolved == false) goto L5;
        Object r11 = Integer.valueOf(this.value);
    L6:
        r10.append(r11);
        r10.append(") <t=");
        r10.append(this.targets.size());
        r10.append(":d=");
        r10.append(this.dependencies.size());
        r10.append(">");
        return r10.toString();
    L5:
        r11 = "unresolved";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Iterator<DependencyNode> r11 = this.targets.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r11.next().resolved == true) goto L4;
        return;
    L8:
        this.readyToSolve = true;
        Dependency r12 = this.updateDelegate;
        if (r12 == null) goto L12;
        r12.update(this);
    L12:
        if (this.delegateToWidgetRun == false) goto L15;
        this.run.update(this);
        return;
    L15:
        DependencyNode r13 = null;
        int r14 = 0;
        Iterator<DependencyNode> r15 = this.targets.iterator();
    L17:
        if (r15.hasNext() == false) goto L22;
        DependencyNode r16 = r15.next();
        if ((r16 instanceof DimensionDependency) == true) goto L17;
        r14 = r14 + 1;
        r13 = r16;
        goto L17
    L22:
        if (r13 == null) goto L33;
        if (r14 != 1) goto L33;
        if (r13.resolved == false) goto L33;
        DimensionDependency r17 = this.marginDependency;
        if (r17 != null) goto L29;
    L32:
        resolve(r13.value + this.margin);
        goto L33
    L29:
        if (r17.resolved == false) goto L31;
        this.margin = this.marginFactor * r17.value;
        goto L32
    L31:
        return;
    L33:
        Dependency r18 = this.updateDelegate;
        if (r18 == null) goto L45;
        r18.update(this);
        return;
    }
}

package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun r5) {
        super(r5);
        if ((r5 instanceof HorizontalWidgetRun) == false) goto L5;
        this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.type = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
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
}

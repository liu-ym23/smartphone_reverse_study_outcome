package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun r10) {
        super(r10);
        if ((r10 instanceof HorizontalWidgetRun) == false) goto L5;
        DependencyNode.Type r11 = DependencyNode.Type.HORIZONTAL_DIMENSION;
    L6:
        this.type = r11;
        return;
    L5:
        r11 = DependencyNode.Type.VERTICAL_DIMENSION;
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}

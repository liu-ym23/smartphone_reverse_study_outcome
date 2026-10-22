package androidx.constraintlayout.core.widgets.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun r2) {
        super(r2);
        if (ZeusTransformUtils.instanceOf(r2, HorizontalWidgetRun.class) == false) goto L5;
        DependencyNode.Type r3 = DependencyNode.Type.HORIZONTAL_DIMENSION;
    L6:
        this.type = r3;
        return;
    L5:
        r3 = DependencyNode.Type.VERTICAL_DIMENSION;
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void resolve(int r3) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r3;
        Iterator<Dependency> r2 = this.dependencies.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Dependency r4 = (Dependency) ZeusTransformUtils.preCheckCast(r2.next(), Dependency.class, "com.obric.memorydata.plugin");
        r4.update(r4);
        goto L7
    }
}

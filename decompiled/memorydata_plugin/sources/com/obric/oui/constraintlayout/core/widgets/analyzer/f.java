package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
class f extends DependencyNode {
    public int m;

    f(WidgetRun r2) {
        super(r2);
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L5;
        DependencyNode.Type r3 = DependencyNode.Type.HORIZONTAL_DIMENSION;
    L6:
        this.e = r3;
        return;
    L5:
        r3 = DependencyNode.Type.VERTICAL_DIMENSION;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.DependencyNode
    public void a(int r3) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.g = r3;
        Iterator<d> r2 = this.k.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin");
        r4.update(r4);
        goto L7
    }
}

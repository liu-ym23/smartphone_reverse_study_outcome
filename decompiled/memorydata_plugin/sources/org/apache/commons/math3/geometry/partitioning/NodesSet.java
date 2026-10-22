package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class NodesSet<S extends Space> implements Iterable<BSPTree<S>> {
    private List<BSPTree<S>> list;

    public NodesSet() {
        this.list = new ArrayList();
    }

    public void add(BSPTree<S> r5) {
        Iterator<BSPTree<S>> r0 = this.list.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r5 != ((BSPTree) ZeusTransformUtils.preCheckCast(r0.next(), BSPTree.class, "com.obric.memorydata.plugin"))) goto L4;
        return;
    L8:
        this.list.add(r5);
    }

    public void addAll(Iterable<BSPTree<S>> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        add((BSPTree) ZeusTransformUtils.preCheckCast(r5.next(), BSPTree.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    @Override // java.lang.Iterable
    public Iterator<BSPTree<S>> iterator() {
        return this.list.iterator();
    }
}

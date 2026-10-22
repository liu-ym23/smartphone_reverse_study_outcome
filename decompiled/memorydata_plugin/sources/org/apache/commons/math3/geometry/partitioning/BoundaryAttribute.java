package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class BoundaryAttribute<S extends Space> {
    private final SubHyperplane<S> plusInside;
    private final SubHyperplane<S> plusOutside;
    private final NodesSet<S> splitters;

    BoundaryAttribute(SubHyperplane<S> r3, SubHyperplane<S> r4, NodesSet<S> r5) {
        SubHyperplane<S> r6 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r7 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r4, SubHyperplane.class, "com.obric.memorydata.plugin");
        this.plusOutside = r6;
        this.plusInside = r7;
        this.splitters = r5;
    }

    public SubHyperplane<S> getPlusInside() {
        return this.plusInside;
    }

    public SubHyperplane<S> getPlusOutside() {
        return this.plusOutside;
    }

    public NodesSet<S> getSplitters() {
        return this.splitters;
    }
}

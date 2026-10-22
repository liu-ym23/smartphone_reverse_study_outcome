package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSubHyperplane<S extends Space, T extends Space> implements SubHyperplane<S> {
    private final Hyperplane<S> hyperplane;
    private final Region<T> remainingRegion;

    public AbstractSubHyperplane(Hyperplane<S> r3, Region<T> r4) {
        Hyperplane<S> r5 = (Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin");
        Region<T> r6 = (Region) ZeusTransformUtils.wrapperContextForParams(r4, Region.class, "com.obric.memorydata.plugin");
        this.hyperplane = r5;
        this.remainingRegion = r6;
    }

    public abstract AbstractSubHyperplane<S, T> buildNew(Hyperplane<S> r1, Region<T> r2);

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public AbstractSubHyperplane<S, T> copySelf() {
        return buildNew(this.hyperplane.copySelf(), this.remainingRegion);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public /* bridge */ /* synthetic */ SubHyperplane copySelf() {
        return copySelf();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public Hyperplane<S> getHyperplane() {
        return this.hyperplane;
    }

    public Region<T> getRemainingRegion() {
        return this.remainingRegion;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return this.remainingRegion.isEmpty();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public AbstractSubHyperplane<S, T> reunite(SubHyperplane<S> r4) {
        AbstractSubHyperplane r5 = (AbstractSubHyperplane) ZeusTransformUtils.preCheckCast((SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r4, SubHyperplane.class, "com.obric.memorydata.plugin"), AbstractSubHyperplane.class, "com.obric.memorydata.plugin");
        return buildNew(this.hyperplane, new RegionFactory().union(this.remainingRegion, r5.remainingRegion));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public /* synthetic */ SubHyperplane reunite(SubHyperplane r3) {
        return reunite((SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin"));
    }
}

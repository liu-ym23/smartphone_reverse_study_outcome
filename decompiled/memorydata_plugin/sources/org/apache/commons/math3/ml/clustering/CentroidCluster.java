package org.apache.commons.math3.ml.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.ml.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
public class CentroidCluster<T extends Clusterable> extends Cluster<T> {
    private static final long serialVersionUID = -3075288519071812288L;
    private final Clusterable center;

    public CentroidCluster(Clusterable r3) {
        this.center = (Clusterable) ZeusTransformUtils.wrapperContextForParams(r3, Clusterable.class, "com.obric.memorydata.plugin");
    }

    public Clusterable getCenter() {
        return this.center;
    }
}

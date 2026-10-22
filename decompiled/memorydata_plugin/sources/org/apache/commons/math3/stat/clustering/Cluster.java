package org.apache.commons.math3.stat.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Cluster<T extends Clusterable<T>> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final T center;
    private final List<T> points;

    public Cluster(T r3) {
        this.center = (T) ZeusTransformUtils.wrapperContextForParams(r3, Clusterable.class, "com.obric.memorydata.plugin");
        this.points = new ArrayList();
    }

    public void addPoint(T r3) {
        Clusterable r4 = (Clusterable) ZeusTransformUtils.wrapperContextForParams(r3, Clusterable.class, "com.obric.memorydata.plugin");
        this.points.add((T) r4);
    }

    public T getCenter() {
        return this.center;
    }

    public List<T> getPoints() {
        return this.points;
    }
}

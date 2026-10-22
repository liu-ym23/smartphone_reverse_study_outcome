package org.apache.commons.math3.ml.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
public class Cluster<T extends Clusterable> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final List<T> points;

    public Cluster() {
        this.points = new ArrayList();
    }

    public void addPoint(T r3) {
        Clusterable r4 = (Clusterable) ZeusTransformUtils.wrapperContextForParams(r3, Clusterable.class, "com.obric.memorydata.plugin");
        this.points.add((T) r4);
    }

    public List<T> getPoints() {
        return this.points;
    }
}

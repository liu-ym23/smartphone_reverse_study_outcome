package org.apache.commons.math3.stat.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class EuclideanDoublePoint implements Serializable, Clusterable<EuclideanDoublePoint> {
    private static final long serialVersionUID = 8026472786091227632L;
    private final double[] point;

    public EuclideanDoublePoint(double[] r1) {
        this.point = r1;
    }

    public /* synthetic */ Object centroidOf(Collection r3) {
        return m3124centroidOf((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: centroidOf, reason: collision with other method in class */
    public EuclideanDoublePoint m3124centroidOf(Collection<EuclideanDoublePoint> r10) {
        Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.memorydata.plugin");
        int r9 = getPoint().length;
        double[] r0 = new double[r9];
        Iterator r2 = r11.iterator();
    L3:
        int r4 = 0;
        if (r2.hasNext() == false) goto L8;
        EuclideanDoublePoint r3 = (EuclideanDoublePoint) ZeusTransformUtils.preCheckCast(r2.next(), EuclideanDoublePoint.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 >= r9) goto L3;
        r0[r4] = r0[r4] + r3.getPoint()[r4];
        r4 = r4 + 1;
    L8:
        if (r4 >= r9) goto L11;
        r0[r4] = r0[r4] / ((double) r11.size());
        r4 = r4 + 1;
        goto L8
    L11:
        return new EuclideanDoublePoint(r0);
    }

    public /* synthetic */ double distanceFrom(Object r3) {
        return distanceFrom((EuclideanDoublePoint) ZeusTransformUtils.preCheckCast(r3, EuclideanDoublePoint.class, "com.obric.memorydata.plugin"));
    }

    public double distanceFrom(EuclideanDoublePoint r1) {
        return MathArrays.distance(this.point, r1.getPoint());
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, EuclideanDoublePoint.class) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.point, ((EuclideanDoublePoint) ZeusTransformUtils.preCheckCast(r3, EuclideanDoublePoint.class, "com.obric.memorydata.plugin")).point);
    }

    public double[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}

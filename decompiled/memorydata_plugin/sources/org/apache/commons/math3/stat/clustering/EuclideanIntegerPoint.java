package org.apache.commons.math3.stat.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class EuclideanIntegerPoint implements Serializable, Clusterable<EuclideanIntegerPoint> {
    private static final long serialVersionUID = 3946024775784901369L;
    private final int[] point;

    public EuclideanIntegerPoint(int[] r1) {
        this.point = r1;
    }

    public /* synthetic */ Object centroidOf(Collection r3) {
        return m3125centroidOf((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: centroidOf, reason: collision with other method in class */
    public EuclideanIntegerPoint m3125centroidOf(Collection<EuclideanIntegerPoint> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        int r7 = getPoint().length;
        int[] r0 = new int[r7];
        Iterator r2 = r9.iterator();
    L3:
        int r4 = 0;
        if (r2.hasNext() == false) goto L8;
        EuclideanIntegerPoint r3 = (EuclideanIntegerPoint) ZeusTransformUtils.preCheckCast(r2.next(), EuclideanIntegerPoint.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 >= r7) goto L3;
        r0[r4] = r0[r4] + r3.getPoint()[r4];
        r4 = r4 + 1;
    L8:
        if (r4 >= r7) goto L11;
        r0[r4] = r0[r4] / r9.size();
        r4 = r4 + 1;
        goto L8
    L11:
        return new EuclideanIntegerPoint(r0);
    }

    public /* synthetic */ double distanceFrom(Object r3) {
        return distanceFrom((EuclideanIntegerPoint) ZeusTransformUtils.preCheckCast(r3, EuclideanIntegerPoint.class, "com.obric.memorydata.plugin"));
    }

    public double distanceFrom(EuclideanIntegerPoint r1) {
        return MathArrays.distance(this.point, r1.getPoint());
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, EuclideanIntegerPoint.class) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.point, ((EuclideanIntegerPoint) ZeusTransformUtils.preCheckCast(r3, EuclideanIntegerPoint.class, "com.obric.memorydata.plugin")).point);
    }

    public int[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}

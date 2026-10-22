package org.apache.commons.math3.optim;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class PointVectorValuePair extends Pair<double[], double[]> implements Serializable {
    private static final long serialVersionUID = 20120513;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513;
        private final double[] point;
        private final double[] value;

        DataTransferObject(double[] r3, double[] r4) {
            this.point = (double[]) ZeusTransformUtils.preCheckCast(r3.clone(), double[].class, "com.obric.memorydata.plugin");
            this.value = (double[]) ZeusTransformUtils.preCheckCast(r4.clone(), double[].class, "com.obric.memorydata.plugin");
        }

        private Object readResolve() {
            return new PointVectorValuePair(this.point, this.value, false);
        }
    }

    public PointVectorValuePair(double[] r2, double[] r3) {
        this(r2, r3, true);
    }

    public PointVectorValuePair(double[] r4, double[] r5, boolean r6) {
        if (r6 == false) goto L7;
        if (r4 != null) goto L6;
        r4 = null;
        goto L7
    L6:
        r4 = (double[]) ZeusTransformUtils.preCheckCast(r4.clone(), double[].class, "com.obric.memorydata.plugin");
    L7:
        if (r6 == false) goto L11;
        if (r5 != null) goto L10;
        r5 = null;
        goto L11
    L10:
        r5 = (double[]) ZeusTransformUtils.preCheckCast(r5.clone(), double[].class, "com.obric.memorydata.plugin");
    L11:
        super(r4, r5);
    }

    private Object writeReplace() {
        return new DataTransferObject((double[]) ZeusTransformUtils.preCheckCast(getKey(), double[].class, "com.obric.memorydata.plugin"), getValue2());
    }

    public double[] getPoint() {
        double[] r2 = (double[]) ZeusTransformUtils.preCheckCast(getKey(), double[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        return (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public double[] getPointRef() {
        return (double[]) ZeusTransformUtils.preCheckCast(getKey(), double[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.util.Pair
    public /* bridge */ /* synthetic */ double[] getValue() {
        return getValue2();
    }

    @Override // org.apache.commons.math3.util.Pair
    /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
    public double[] getValue2() {
        double[] r2 = (double[]) ZeusTransformUtils.preCheckCast(super.getValue(), double[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        return (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public double[] getValueRef() {
        return (double[]) ZeusTransformUtils.preCheckCast(super.getValue(), double[].class, "com.obric.memorydata.plugin");
    }
}

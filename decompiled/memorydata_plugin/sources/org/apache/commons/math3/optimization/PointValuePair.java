package org.apache.commons.math3.optimization;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PointValuePair extends Pair<double[], Double> implements Serializable {
    private static final long serialVersionUID = 20120513;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513;
        private final double[] point;
        private final double value;

        DataTransferObject(double[] r3, double r4) {
            this.point = (double[]) ZeusTransformUtils.preCheckCast(r3.clone(), double[].class, "com.obric.memorydata.plugin");
            this.value = r4;
        }

        private Object readResolve() {
            return new PointValuePair(this.point, this.value, false);
        }
    }

    public PointValuePair(double[] r2, double r3) {
        this(r2, r3, true);
    }

    public PointValuePair(double[] r2, double r3, boolean r5) {
        if (r5 == false) goto L6;
        if (r2 != null) goto L5;
        r2 = null;
        goto L6
    L5:
        r2 = (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    L6:
        super(r2, Double.valueOf(r3));
    }

    private Object writeReplace() {
        return new DataTransferObject((double[]) ZeusTransformUtils.preCheckCast(getKey(), double[].class, "com.obric.memorydata.plugin"), ((Double) ZeusTransformUtils.preCheckCast(getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
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
}

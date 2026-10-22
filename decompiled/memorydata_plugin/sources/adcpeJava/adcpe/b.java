package adcpeJava.adcpe;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f17b;

    public b(d r1, double r2) {
        this.f16a = r1;
        this.f17b = r2;
    }

    public double[] a(a r9) {
        double[] r0 = r9.a();
        byte[] r4 = r9.e();
        int r7 = r0.length;
        if (r7 != 0) goto L7;
        return new double[0];
    L7:
        if (r7 != this.f16a.a()) goto L17;
        RealVector r10 = new ArrayRealVector(r0);
        if (this.f16a.c() != Constants.KeyType.KEY_VERSION_QR.ordinal()) goto L12;
        r10 = e.a(this.f16a.h(), r10, this.f16a.g(), r7);
    L15:
        return r10.subtract(e.a(this.f16a.b(), this.f16a.d(), r4, this.f17b, r7)).mapDivide(this.f16a.b()).toArray();
    L12:
        if (this.f16a.c() != Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()) goto L15;
        r10 = r10.subtract(this.f16a.e().mapMultiply(this.f16a.e().dotProduct(r10) * 2.0d));
        goto L15
    L17:
        throw new RuntimeException(String.format("the length of cipher vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r7), Integer.valueOf(this.f16a.a())}));
    }
}

package adcpeJava.adcpe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.commons.math3.linear.ArrayRealVector;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f14a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f15b;

    a(double[] r1, byte[] r2) {
        this.f14a = r1;
        this.f15b = r2;
    }

    public static a a(double[] r5, String r6) {
        byte[] r7 = e.a(r6, 80);
        byte[] r1 = new byte[32];
        byte[] r3 = new byte[8];
        System.arraycopy(r7, 0, r1, 0, 32);
        System.arraycopy(r7, 32, r3, 0, 8);
        double r2 = e.b(r3);
        return new a(new ArrayRealVector(r5).mapMultiply(r2).toArray(), r1);
    }

    public static a a(float[] r0, String r1) {
        return a(e.a(r0), r1);
    }

    public double[] a() {
        return this.f14a;
    }

    public float[] b() {
        return e.b(this.f14a);
    }

    public double[] c() {
        ArrayRealVector r0 = new ArrayRealVector(this.f14a);
        return r0.mapDivide(r0.getNorm()).toArray();
    }

    public float[] d() {
        return e.b(c());
    }

    public byte[] e() {
        return this.f15b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(this.f14a, r6.f14a) == false) goto L16;
        if (Arrays.equals(this.f15b, r6.f15b) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public String f() {
        return e.c(this.f15b);
    }

    public String g() {
        return f() + e.c(e.a(new ArrayRealVector(this.f14a).getNorm()));
    }
}

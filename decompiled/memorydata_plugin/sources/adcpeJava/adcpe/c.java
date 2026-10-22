package adcpeJava.adcpe;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f18a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f19b;

    public c(d r1, double r2) {
        this.f18a = r1;
        this.f19b = r2;
    }

    public a a(double[] r3) {
        if (r3.length != this.f18a.a()) goto L7;
        byte[] r0 = e.a(r3);
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        r1.update(r0);
        return a(r3, r1.digest());
    L7:
        throw new RuntimeException(String.format("the length of plain vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r3.length), Integer.valueOf(this.f18a.a())}));
    }

    a a(double[] r9, byte[] r10) {
        RealVector r0 = e.a(this.f18a.b(), this.f18a.d(), r10, this.f19b, r9.length);
        RealVector r11 = new ArrayRealVector(r9).mapMultiply(this.f18a.b()).add(r0);
        if (this.f18a.c() != Constants.KeyType.KEY_VERSION_QR.ordinal()) goto L6;
        r11 = e.a(this.f18a.f(), r11, this.f18a.g(), r11.getDimension());
    L9:
        return new a(r11.toArray(), r10);
    L6:
        if (this.f18a.c() != Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()) goto L9;
        double r2 = this.f18a.e().dotProduct(r11) * 2.0d;
        r11 = r11.subtract(this.f18a.e().mapMultiply(r2));
        goto L9
    }

    public a b(double[] r3) {
        if (r3.length != this.f18a.a()) goto L7;
        return a(r3, e.a(32));
    L7:
        throw new RuntimeException(String.format("the length of plain vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r3.length), Integer.valueOf(this.f18a.a())}));
    }
}

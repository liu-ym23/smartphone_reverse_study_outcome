package com.google.crypto.tink.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECParameterSpec f4878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECParameterSpec f4879b = null;
    public static final ECParameterSpec c = null;
    private static final BigInteger d = null;
    private static final BigInteger e = null;
    private static final BigInteger f = null;
    private static final BigInteger g = null;

    static {
        f4878a = a();
        f4879b = b();
        c = c();
        d = BigInteger.valueOf(2);
        e = BigInteger.valueOf(3);
        f = BigInteger.valueOf(4);
        g = BigInteger.valueOf(8);
    }

    public static BigInteger a(EllipticCurve r2) {
        ECField r3 = r2.getField();
        if (ZeusTransformUtils.instanceOf(r3, ECFieldFp.class) == false) goto L7;
        return ((ECFieldFp) ZeusTransformUtils.preCheckCast(r3, ECFieldFp.class, "com.obric.memorydata.plugin")).getP();
    L7:
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    private static ECParameterSpec a() {
        return a("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    private static ECParameterSpec a(String r3, String r4, String r5, String r6, String r7) {
        BigInteger r0 = new BigInteger(r3);
        BigInteger r8 = new BigInteger(r4);
        BigInteger r9 = r0.subtract(new BigInteger("3"));
        BigInteger r1 = new BigInteger(r5, 16);
        BigInteger r10 = new BigInteger(r6, 16);
        BigInteger r11 = new BigInteger(r7, 16);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(r0), r9, r1), new ECPoint(r10, r11), r8, 1);
    }

    public static boolean a(ECParameterSpec r1) {
        if (a(r1, f4878a) == false) goto L5;
    L10:
        return true;
    L5:
        if (a(r1, f4879b) == true) goto L10;
        if (a(r1, c) == true) goto L10;
        return false;
    }

    public static boolean a(ECParameterSpec r2, ECParameterSpec r3) {
        if (r2.getCurve().equals(r3.getCurve()) == true) goto L5;
    L11:
        return false;
    L5:
        if (r2.getGenerator().equals(r3.getGenerator()) == false) goto L11;
        if (r2.getOrder().equals(r3.getOrder()) == false) goto L11;
        if (r2.getCofactor() != r3.getCofactor()) goto L11;
        return true;
    }

    private static ECParameterSpec b() {
        return a("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    private static ECParameterSpec c() {
        return a("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }
}

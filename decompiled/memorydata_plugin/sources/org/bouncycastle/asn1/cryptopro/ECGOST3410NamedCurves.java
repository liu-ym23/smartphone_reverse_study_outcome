package org.bouncycastle.asn1.cryptopro;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class ECGOST3410NamedCurves {
    static final Hashtable curves = null;
    static X9ECParametersHolder gostR3410_2001_CryptoPro_A;
    static X9ECParametersHolder gostR3410_2001_CryptoPro_B;
    static X9ECParametersHolder gostR3410_2001_CryptoPro_C;
    static X9ECParametersHolder gostR3410_2001_CryptoPro_XchB;
    static X9ECParametersHolder id_tc26_gost_3410_12_256_paramSetA;
    static X9ECParametersHolder id_tc26_gost_3410_12_512_paramSetA;
    static X9ECParametersHolder id_tc26_gost_3410_12_512_paramSetB;
    static X9ECParametersHolder id_tc26_gost_3410_12_512_paramSetC;
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        gostR3410_2001_CryptoPro_A = new AnonymousClass1();
        gostR3410_2001_CryptoPro_B = new AnonymousClass2();
        gostR3410_2001_CryptoPro_C = new AnonymousClass3();
        gostR3410_2001_CryptoPro_XchB = new AnonymousClass4();
        id_tc26_gost_3410_12_256_paramSetA = new AnonymousClass5();
        id_tc26_gost_3410_12_512_paramSetA = new AnonymousClass6();
        id_tc26_gost_3410_12_512_paramSetB = new AnonymousClass7();
        id_tc26_gost_3410_12_512_paramSetC = new AnonymousClass8();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, gostR3410_2001_CryptoPro_A);
        defineCurve("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, gostR3410_2001_CryptoPro_B);
        defineCurve("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, gostR3410_2001_CryptoPro_C);
        defineCurve("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, gostR3410_2001_CryptoPro_A);
        defineCurve("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, gostR3410_2001_CryptoPro_XchB);
        defineCurve("Tc26-Gost-3410-12-256-paramSetA", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetA, id_tc26_gost_3410_12_256_paramSetA);
        defineCurve("Tc26-Gost-3410-12-512-paramSetA", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetA, id_tc26_gost_3410_12_512_paramSetA);
        defineCurve("Tc26-Gost-3410-12-512-paramSetB", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetB, id_tc26_gost_3410_12_512_paramSetB);
        defineCurve("Tc26-Gost-3410-12-512-paramSetC", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetC, id_tc26_gost_3410_12_512_paramSetC);
    }

    static /* synthetic */ BigInteger access$000(String r0) {
        return fromHex(r0);
    }

    static /* synthetic */ ECCurve access$100(ECCurve r0) {
        return configureCurve(r0);
    }

    static /* synthetic */ X9ECPoint access$200(ECCurve r0, BigInteger r1, BigInteger r2) {
        return configureBasepoint(r0, r1, r2);
    }

    private static X9ECPoint configureBasepoint(ECCurve r0, BigInteger r1, BigInteger r2) {
        ECPoint r3 = r0.createPoint(r1, r2);
        WNafUtil.configureBasepoint(r3);
        return new X9ECPoint(r3, false);
    }

    private static ECCurve configureCurve(ECCurve r0) {
        return r0;
    }

    static void defineCurve(String r1, ASN1ObjectIdentifier r2, X9ECParametersHolder r3) {
        objIds.put(r1, r2);
        names.put(r2, r1);
        curves.put(r2, r3);
    }

    private static BigInteger fromHex(String r2) {
        return new BigInteger(1, Hex.decodeStrict(r2));
    }

    public static X9ECParametersHolder getByNameLazy(String r0) {
        ASN1ObjectIdentifier r1 = getOID(r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        return getByOIDLazy(r1);
    }

    public static X9ECParameters getByNameX9(String r0) {
        ASN1ObjectIdentifier r1 = getOID(r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        return getByOIDX9(r1);
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier r2) {
        return (X9ECParametersHolder) ZeusTransformUtils.preCheckCast(curves.get(r2), X9ECParametersHolder.class, "com.obric.memorydata.plugin");
    }

    public static X9ECParameters getByOIDX9(ASN1ObjectIdentifier r0) {
        X9ECParametersHolder r1 = getByOIDLazy(r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getParameters();
    }

    public static String getName(ASN1ObjectIdentifier r2) {
        return (String) ZeusTransformUtils.preCheckCast(names.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static ASN1ObjectIdentifier getOID(String r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(objIds.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }
}

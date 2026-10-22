package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class X962NamedCurves {
    static X9ECParametersHolder c2pnb163v1;
    static X9ECParametersHolder c2pnb163v2;
    static X9ECParametersHolder c2pnb163v3;
    static X9ECParametersHolder c2pnb176w1;
    static X9ECParametersHolder c2pnb208w1;
    static X9ECParametersHolder c2pnb272w1;
    static X9ECParametersHolder c2pnb304w1;
    static X9ECParametersHolder c2pnb368w1;
    static X9ECParametersHolder c2tnb191v1;
    static X9ECParametersHolder c2tnb191v2;
    static X9ECParametersHolder c2tnb191v3;
    static X9ECParametersHolder c2tnb239v1;
    static X9ECParametersHolder c2tnb239v2;
    static X9ECParametersHolder c2tnb239v3;
    static X9ECParametersHolder c2tnb359v1;
    static X9ECParametersHolder c2tnb431r1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;
    static X9ECParametersHolder prime192v1;
    static X9ECParametersHolder prime192v2;
    static X9ECParametersHolder prime192v3;
    static X9ECParametersHolder prime239v1;
    static X9ECParametersHolder prime239v2;
    static X9ECParametersHolder prime239v3;
    static X9ECParametersHolder prime256v1;

    static {
        prime192v1 = new AnonymousClass1();
        prime192v2 = new AnonymousClass2();
        prime192v3 = new AnonymousClass3();
        prime239v1 = new AnonymousClass4();
        prime239v2 = new AnonymousClass5();
        prime239v3 = new AnonymousClass6();
        prime256v1 = new AnonymousClass7();
        c2pnb163v1 = new AnonymousClass8();
        c2pnb163v2 = new AnonymousClass9();
        c2pnb163v3 = new AnonymousClass10();
        c2pnb176w1 = new AnonymousClass11();
        c2tnb191v1 = new AnonymousClass12();
        c2tnb191v2 = new AnonymousClass13();
        c2tnb191v3 = new AnonymousClass14();
        c2pnb208w1 = new AnonymousClass15();
        c2tnb239v1 = new AnonymousClass16();
        c2tnb239v2 = new AnonymousClass17();
        c2tnb239v3 = new AnonymousClass18();
        c2pnb272w1 = new AnonymousClass19();
        c2pnb304w1 = new AnonymousClass20();
        c2tnb359v1 = new AnonymousClass21();
        c2pnb368w1 = new AnonymousClass22();
        c2tnb431r1 = new AnonymousClass23();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("prime192v1", X9ObjectIdentifiers.prime192v1, prime192v1);
        defineCurve("prime192v2", X9ObjectIdentifiers.prime192v2, prime192v2);
        defineCurve("prime192v3", X9ObjectIdentifiers.prime192v3, prime192v3);
        defineCurve("prime239v1", X9ObjectIdentifiers.prime239v1, prime239v1);
        defineCurve("prime239v2", X9ObjectIdentifiers.prime239v2, prime239v2);
        defineCurve("prime239v3", X9ObjectIdentifiers.prime239v3, prime239v3);
        defineCurve("prime256v1", X9ObjectIdentifiers.prime256v1, prime256v1);
        defineCurve("c2pnb163v1", X9ObjectIdentifiers.c2pnb163v1, c2pnb163v1);
        defineCurve("c2pnb163v2", X9ObjectIdentifiers.c2pnb163v2, c2pnb163v2);
        defineCurve("c2pnb163v3", X9ObjectIdentifiers.c2pnb163v3, c2pnb163v3);
        defineCurve("c2pnb176w1", X9ObjectIdentifiers.c2pnb176w1, c2pnb176w1);
        defineCurve("c2tnb191v1", X9ObjectIdentifiers.c2tnb191v1, c2tnb191v1);
        defineCurve("c2tnb191v2", X9ObjectIdentifiers.c2tnb191v2, c2tnb191v2);
        defineCurve("c2tnb191v3", X9ObjectIdentifiers.c2tnb191v3, c2tnb191v3);
        defineCurve("c2pnb208w1", X9ObjectIdentifiers.c2pnb208w1, c2pnb208w1);
        defineCurve("c2tnb239v1", X9ObjectIdentifiers.c2tnb239v1, c2tnb239v1);
        defineCurve("c2tnb239v2", X9ObjectIdentifiers.c2tnb239v2, c2tnb239v2);
        defineCurve("c2tnb239v3", X9ObjectIdentifiers.c2tnb239v3, c2tnb239v3);
        defineCurve("c2pnb272w1", X9ObjectIdentifiers.c2pnb272w1, c2pnb272w1);
        defineCurve("c2pnb304w1", X9ObjectIdentifiers.c2pnb304w1, c2pnb304w1);
        defineCurve("c2tnb359v1", X9ObjectIdentifiers.c2tnb359v1, c2tnb359v1);
        defineCurve("c2pnb368w1", X9ObjectIdentifiers.c2pnb368w1, c2pnb368w1);
        defineCurve("c2tnb431r1", X9ObjectIdentifiers.c2tnb431r1, c2tnb431r1);
    }

    static /* synthetic */ BigInteger access$000(String r0) {
        return fromHex(r0);
    }

    static /* synthetic */ ECCurve access$100(ECCurve r0) {
        return configureCurve(r0);
    }

    static /* synthetic */ X9ECPoint access$200(ECCurve r0, String r1) {
        return configureBasepoint(r0, r1);
    }

    private static X9ECPoint configureBasepoint(ECCurve r1, String r2) {
        X9ECPoint r0 = new X9ECPoint(r1, Hex.decodeStrict(r2));
        WNafUtil.configureBasepoint(r0.getPoint());
        return r0;
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

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r0) {
        X9ECParametersHolder r1 = getByOIDLazy(r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier r2) {
        return (X9ECParametersHolder) ZeusTransformUtils.preCheckCast(curves.get(r2), X9ECParametersHolder.class, "com.obric.memorydata.plugin");
    }

    public static String getName(ASN1ObjectIdentifier r2) {
        return (String) ZeusTransformUtils.preCheckCast(names.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static ASN1ObjectIdentifier getOID(String r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(objIds.get(Strings.toLowerCase(r2)), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }
}

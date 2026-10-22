package org.bouncycastle.asn1.sec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.bouncycastle.math.ec.endo.GLVTypeBParameters;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class SECNamedCurves {
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;
    static X9ECParametersHolder secp112r1;
    static X9ECParametersHolder secp112r2;
    static X9ECParametersHolder secp128r1;
    static X9ECParametersHolder secp128r2;
    static X9ECParametersHolder secp160k1;
    static X9ECParametersHolder secp160r1;
    static X9ECParametersHolder secp160r2;
    static X9ECParametersHolder secp192k1;
    static X9ECParametersHolder secp192r1;
    static X9ECParametersHolder secp224k1;
    static X9ECParametersHolder secp224r1;
    static X9ECParametersHolder secp256k1;
    static X9ECParametersHolder secp256r1;
    static X9ECParametersHolder secp384r1;
    static X9ECParametersHolder secp521r1;
    static X9ECParametersHolder sect113r1;
    static X9ECParametersHolder sect113r2;
    static X9ECParametersHolder sect131r1;
    static X9ECParametersHolder sect131r2;
    static X9ECParametersHolder sect163k1;
    static X9ECParametersHolder sect163r1;
    static X9ECParametersHolder sect163r2;
    static X9ECParametersHolder sect193r1;
    static X9ECParametersHolder sect193r2;
    static X9ECParametersHolder sect233k1;
    static X9ECParametersHolder sect233r1;
    static X9ECParametersHolder sect239k1;
    static X9ECParametersHolder sect283k1;
    static X9ECParametersHolder sect283r1;
    static X9ECParametersHolder sect409k1;
    static X9ECParametersHolder sect409r1;
    static X9ECParametersHolder sect571k1;
    static X9ECParametersHolder sect571r1;

    static {
        secp112r1 = new AnonymousClass1();
        secp112r2 = new AnonymousClass2();
        secp128r1 = new AnonymousClass3();
        secp128r2 = new AnonymousClass4();
        secp160k1 = new AnonymousClass5();
        secp160r1 = new AnonymousClass6();
        secp160r2 = new AnonymousClass7();
        secp192k1 = new AnonymousClass8();
        secp192r1 = new AnonymousClass9();
        secp224k1 = new AnonymousClass10();
        secp224r1 = new AnonymousClass11();
        secp256k1 = new AnonymousClass12();
        secp256r1 = new AnonymousClass13();
        secp384r1 = new AnonymousClass14();
        secp521r1 = new AnonymousClass15();
        sect113r1 = new AnonymousClass16();
        sect113r2 = new AnonymousClass17();
        sect131r1 = new AnonymousClass18();
        sect131r2 = new AnonymousClass19();
        sect163k1 = new AnonymousClass20();
        sect163r1 = new AnonymousClass21();
        sect163r2 = new AnonymousClass22();
        sect193r1 = new AnonymousClass23();
        sect193r2 = new AnonymousClass24();
        sect233k1 = new AnonymousClass25();
        sect233r1 = new AnonymousClass26();
        sect239k1 = new AnonymousClass27();
        sect283k1 = new AnonymousClass28();
        sect283r1 = new AnonymousClass29();
        sect409k1 = new AnonymousClass30();
        sect409r1 = new AnonymousClass31();
        sect571k1 = new AnonymousClass32();
        sect571r1 = new AnonymousClass33();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("secp112r1", SECObjectIdentifiers.secp112r1, secp112r1);
        defineCurve("secp112r2", SECObjectIdentifiers.secp112r2, secp112r2);
        defineCurve("secp128r1", SECObjectIdentifiers.secp128r1, secp128r1);
        defineCurve("secp128r2", SECObjectIdentifiers.secp128r2, secp128r2);
        defineCurve("secp160k1", SECObjectIdentifiers.secp160k1, secp160k1);
        defineCurve("secp160r1", SECObjectIdentifiers.secp160r1, secp160r1);
        defineCurve("secp160r2", SECObjectIdentifiers.secp160r2, secp160r2);
        defineCurve("secp192k1", SECObjectIdentifiers.secp192k1, secp192k1);
        defineCurve("secp192r1", SECObjectIdentifiers.secp192r1, secp192r1);
        defineCurve("secp224k1", SECObjectIdentifiers.secp224k1, secp224k1);
        defineCurve("secp224r1", SECObjectIdentifiers.secp224r1, secp224r1);
        defineCurve("secp256k1", SECObjectIdentifiers.secp256k1, secp256k1);
        defineCurve("secp256r1", SECObjectIdentifiers.secp256r1, secp256r1);
        defineCurve("secp384r1", SECObjectIdentifiers.secp384r1, secp384r1);
        defineCurve("secp521r1", SECObjectIdentifiers.secp521r1, secp521r1);
        defineCurve("sect113r1", SECObjectIdentifiers.sect113r1, sect113r1);
        defineCurve("sect113r2", SECObjectIdentifiers.sect113r2, sect113r2);
        defineCurve("sect131r1", SECObjectIdentifiers.sect131r1, sect131r1);
        defineCurve("sect131r2", SECObjectIdentifiers.sect131r2, sect131r2);
        defineCurve("sect163k1", SECObjectIdentifiers.sect163k1, sect163k1);
        defineCurve("sect163r1", SECObjectIdentifiers.sect163r1, sect163r1);
        defineCurve("sect163r2", SECObjectIdentifiers.sect163r2, sect163r2);
        defineCurve("sect193r1", SECObjectIdentifiers.sect193r1, sect193r1);
        defineCurve("sect193r2", SECObjectIdentifiers.sect193r2, sect193r2);
        defineCurve("sect233k1", SECObjectIdentifiers.sect233k1, sect233k1);
        defineCurve("sect233r1", SECObjectIdentifiers.sect233r1, sect233r1);
        defineCurve("sect239k1", SECObjectIdentifiers.sect239k1, sect239k1);
        defineCurve("sect283k1", SECObjectIdentifiers.sect283k1, sect283k1);
        defineCurve("sect283r1", SECObjectIdentifiers.sect283r1, sect283r1);
        defineCurve("sect409k1", SECObjectIdentifiers.sect409k1, sect409k1);
        defineCurve("sect409r1", SECObjectIdentifiers.sect409r1, sect409r1);
        defineCurve("sect571k1", SECObjectIdentifiers.sect571k1, sect571k1);
        defineCurve("sect571r1", SECObjectIdentifiers.sect571r1, sect571r1);
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

    static /* synthetic */ ECCurve access$300(ECCurve r0, GLVTypeBParameters r1) {
        return configureCurveGLV(r0, r1);
    }

    private static X9ECPoint configureBasepoint(ECCurve r1, String r2) {
        X9ECPoint r0 = new X9ECPoint(r1, Hex.decodeStrict(r2));
        WNafUtil.configureBasepoint(r0.getPoint());
        return r0;
    }

    private static ECCurve configureCurve(ECCurve r0) {
        return r0;
    }

    private static ECCurve configureCurveGLV(ECCurve r2, GLVTypeBParameters r3) {
        return r2.configure().setEndomorphism(new GLVTypeBEndomorphism(r2, r3)).create();
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

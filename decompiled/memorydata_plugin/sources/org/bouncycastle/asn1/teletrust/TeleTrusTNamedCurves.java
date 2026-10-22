package org.bouncycastle.asn1.teletrust;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class TeleTrusTNamedCurves {
    static X9ECParametersHolder brainpoolP160r1;
    static X9ECParametersHolder brainpoolP160t1;
    static X9ECParametersHolder brainpoolP192r1;
    static X9ECParametersHolder brainpoolP192t1;
    static X9ECParametersHolder brainpoolP224r1;
    static X9ECParametersHolder brainpoolP224t1;
    static X9ECParametersHolder brainpoolP256r1;
    static X9ECParametersHolder brainpoolP256t1;
    static X9ECParametersHolder brainpoolP320r1;
    static X9ECParametersHolder brainpoolP320t1;
    static X9ECParametersHolder brainpoolP384r1;
    static X9ECParametersHolder brainpoolP384t1;
    static X9ECParametersHolder brainpoolP512r1;
    static X9ECParametersHolder brainpoolP512t1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        brainpoolP160r1 = new AnonymousClass1();
        brainpoolP160t1 = new AnonymousClass2();
        brainpoolP192r1 = new AnonymousClass3();
        brainpoolP192t1 = new AnonymousClass4();
        brainpoolP224r1 = new AnonymousClass5();
        brainpoolP224t1 = new AnonymousClass6();
        brainpoolP256r1 = new AnonymousClass7();
        brainpoolP256t1 = new AnonymousClass8();
        brainpoolP320r1 = new AnonymousClass9();
        brainpoolP320t1 = new AnonymousClass10();
        brainpoolP384r1 = new AnonymousClass11();
        brainpoolP384t1 = new AnonymousClass12();
        brainpoolP512r1 = new AnonymousClass13();
        brainpoolP512t1 = new AnonymousClass14();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("brainpoolP160r1", TeleTrusTObjectIdentifiers.brainpoolP160r1, brainpoolP160r1);
        defineCurve("brainpoolP160t1", TeleTrusTObjectIdentifiers.brainpoolP160t1, brainpoolP160t1);
        defineCurve("brainpoolP192r1", TeleTrusTObjectIdentifiers.brainpoolP192r1, brainpoolP192r1);
        defineCurve("brainpoolP192t1", TeleTrusTObjectIdentifiers.brainpoolP192t1, brainpoolP192t1);
        defineCurve("brainpoolP224r1", TeleTrusTObjectIdentifiers.brainpoolP224r1, brainpoolP224r1);
        defineCurve("brainpoolP224t1", TeleTrusTObjectIdentifiers.brainpoolP224t1, brainpoolP224t1);
        defineCurve("brainpoolP256r1", TeleTrusTObjectIdentifiers.brainpoolP256r1, brainpoolP256r1);
        defineCurve("brainpoolP256t1", TeleTrusTObjectIdentifiers.brainpoolP256t1, brainpoolP256t1);
        defineCurve("brainpoolP320r1", TeleTrusTObjectIdentifiers.brainpoolP320r1, brainpoolP320r1);
        defineCurve("brainpoolP320t1", TeleTrusTObjectIdentifiers.brainpoolP320t1, brainpoolP320t1);
        defineCurve("brainpoolP384r1", TeleTrusTObjectIdentifiers.brainpoolP384r1, brainpoolP384r1);
        defineCurve("brainpoolP384t1", TeleTrusTObjectIdentifiers.brainpoolP384t1, brainpoolP384t1);
        defineCurve("brainpoolP512r1", TeleTrusTObjectIdentifiers.brainpoolP512r1, brainpoolP512r1);
        defineCurve("brainpoolP512t1", TeleTrusTObjectIdentifiers.brainpoolP512t1, brainpoolP512t1);
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

    static void defineCurve(String r2, ASN1ObjectIdentifier r3, X9ECParametersHolder r4) {
        objIds.put(Strings.toLowerCase(r2), r3);
        names.put(r3, r2);
        curves.put(r3, r4);
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

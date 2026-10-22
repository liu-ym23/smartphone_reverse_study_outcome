package org.bouncycastle.crypto.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
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
public class CustomNamedCurves {
    static X9ECParametersHolder curve25519;
    static final Hashtable nameToCurve = null;
    static final Hashtable nameToOID = null;
    static final Vector names = null;
    static final Hashtable oidToCurve = null;
    static final Hashtable oidToName = null;
    static X9ECParametersHolder secp128r1;
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
    static X9ECParametersHolder sm2p256v1;

    static {
        curve25519 = new AnonymousClass1();
        secp128r1 = new AnonymousClass2();
        secp160k1 = new AnonymousClass3();
        secp160r1 = new AnonymousClass4();
        secp160r2 = new AnonymousClass5();
        secp192k1 = new AnonymousClass6();
        secp192r1 = new AnonymousClass7();
        secp224k1 = new AnonymousClass8();
        secp224r1 = new AnonymousClass9();
        secp256k1 = new AnonymousClass10();
        secp256r1 = new AnonymousClass11();
        secp384r1 = new AnonymousClass12();
        secp521r1 = new AnonymousClass13();
        sect113r1 = new AnonymousClass14();
        sect113r2 = new AnonymousClass15();
        sect131r1 = new AnonymousClass16();
        sect131r2 = new AnonymousClass17();
        sect163k1 = new AnonymousClass18();
        sect163r1 = new AnonymousClass19();
        sect163r2 = new AnonymousClass20();
        sect193r1 = new AnonymousClass21();
        sect193r2 = new AnonymousClass22();
        sect233k1 = new AnonymousClass23();
        sect233r1 = new AnonymousClass24();
        sect239k1 = new AnonymousClass25();
        sect283k1 = new AnonymousClass26();
        sect283r1 = new AnonymousClass27();
        sect409k1 = new AnonymousClass28();
        sect409r1 = new AnonymousClass29();
        sect571k1 = new AnonymousClass30();
        sect571r1 = new AnonymousClass31();
        sm2p256v1 = new AnonymousClass32();
        nameToCurve = new Hashtable();
        nameToOID = new Hashtable();
        oidToCurve = new Hashtable();
        oidToName = new Hashtable();
        names = new Vector();
        defineCurveWithOID("curve25519", CryptlibObjectIdentifiers.curvey25519, curve25519);
        defineCurveWithOID("secp128r1", SECObjectIdentifiers.secp128r1, secp128r1);
        defineCurveWithOID("secp160k1", SECObjectIdentifiers.secp160k1, secp160k1);
        defineCurveWithOID("secp160r1", SECObjectIdentifiers.secp160r1, secp160r1);
        defineCurveWithOID("secp160r2", SECObjectIdentifiers.secp160r2, secp160r2);
        defineCurveWithOID("secp192k1", SECObjectIdentifiers.secp192k1, secp192k1);
        defineCurveWithOID("secp192r1", SECObjectIdentifiers.secp192r1, secp192r1);
        defineCurveWithOID("secp224k1", SECObjectIdentifiers.secp224k1, secp224k1);
        defineCurveWithOID("secp224r1", SECObjectIdentifiers.secp224r1, secp224r1);
        defineCurveWithOID("secp256k1", SECObjectIdentifiers.secp256k1, secp256k1);
        defineCurveWithOID("secp256r1", SECObjectIdentifiers.secp256r1, secp256r1);
        defineCurveWithOID("secp384r1", SECObjectIdentifiers.secp384r1, secp384r1);
        defineCurveWithOID("secp521r1", SECObjectIdentifiers.secp521r1, secp521r1);
        defineCurveWithOID("sect113r1", SECObjectIdentifiers.sect113r1, sect113r1);
        defineCurveWithOID("sect113r2", SECObjectIdentifiers.sect113r2, sect113r2);
        defineCurveWithOID("sect131r1", SECObjectIdentifiers.sect131r1, sect131r1);
        defineCurveWithOID("sect131r2", SECObjectIdentifiers.sect131r2, sect131r2);
        defineCurveWithOID("sect163k1", SECObjectIdentifiers.sect163k1, sect163k1);
        defineCurveWithOID("sect163r1", SECObjectIdentifiers.sect163r1, sect163r1);
        defineCurveWithOID("sect163r2", SECObjectIdentifiers.sect163r2, sect163r2);
        defineCurveWithOID("sect193r1", SECObjectIdentifiers.sect193r1, sect193r1);
        defineCurveWithOID("sect193r2", SECObjectIdentifiers.sect193r2, sect193r2);
        defineCurveWithOID("sect233k1", SECObjectIdentifiers.sect233k1, sect233k1);
        defineCurveWithOID("sect233r1", SECObjectIdentifiers.sect233r1, sect233r1);
        defineCurveWithOID("sect239k1", SECObjectIdentifiers.sect239k1, sect239k1);
        defineCurveWithOID("sect283k1", SECObjectIdentifiers.sect283k1, sect283k1);
        defineCurveWithOID("sect283r1", SECObjectIdentifiers.sect283r1, sect283r1);
        defineCurveWithOID("sect409k1", SECObjectIdentifiers.sect409k1, sect409k1);
        defineCurveWithOID("sect409r1", SECObjectIdentifiers.sect409r1, sect409r1);
        defineCurveWithOID("sect571k1", SECObjectIdentifiers.sect571k1, sect571k1);
        defineCurveWithOID("sect571r1", SECObjectIdentifiers.sect571r1, sect571r1);
        defineCurveWithOID("sm2p256v1", GMObjectIdentifiers.sm2p256v1, sm2p256v1);
        defineCurveAlias("B-163", SECObjectIdentifiers.sect163r2);
        defineCurveAlias("B-233", SECObjectIdentifiers.sect233r1);
        defineCurveAlias("B-283", SECObjectIdentifiers.sect283r1);
        defineCurveAlias("B-409", SECObjectIdentifiers.sect409r1);
        defineCurveAlias("B-571", SECObjectIdentifiers.sect571r1);
        defineCurveAlias("K-163", SECObjectIdentifiers.sect163k1);
        defineCurveAlias("K-233", SECObjectIdentifiers.sect233k1);
        defineCurveAlias("K-283", SECObjectIdentifiers.sect283k1);
        defineCurveAlias("K-409", SECObjectIdentifiers.sect409k1);
        defineCurveAlias("K-571", SECObjectIdentifiers.sect571k1);
        defineCurveAlias("P-192", SECObjectIdentifiers.secp192r1);
        defineCurveAlias("P-224", SECObjectIdentifiers.secp224r1);
        defineCurveAlias("P-256", SECObjectIdentifiers.secp256r1);
        defineCurveAlias("P-384", SECObjectIdentifiers.secp384r1);
        defineCurveAlias("P-521", SECObjectIdentifiers.secp521r1);
    }

    static /* synthetic */ ECCurve access$000(ECCurve r0) {
        return configureCurve(r0);
    }

    static /* synthetic */ X9ECPoint access$100(ECCurve r0, String r1) {
        return configureBasepoint(r0, r1);
    }

    static /* synthetic */ ECCurve access$200(ECCurve r0, GLVTypeBParameters r1) {
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

    static void defineCurveAlias(String r2, ASN1ObjectIdentifier r3) {
        Object r0 = oidToCurve.get(r3);
        if (r0 == null) goto L7;
        String r4 = Strings.toLowerCase(r2);
        nameToOID.put(r4, r3);
        nameToCurve.put(r4, r0);
        return;
    L7:
        throw new IllegalStateException();
    }

    static void defineCurveWithOID(String r1, ASN1ObjectIdentifier r2, X9ECParametersHolder r3) {
        names.addElement(r1);
        oidToName.put(r2, r1);
        oidToCurve.put(r2, r3);
        String r4 = Strings.toLowerCase(r1);
        nameToOID.put(r4, r2);
        nameToCurve.put(r4, r3);
    }

    public static X9ECParametersHolder getByNameLazy(String r2) {
        return (X9ECParametersHolder) ZeusTransformUtils.preCheckCast(nameToCurve.get(Strings.toLowerCase(r2)), X9ECParametersHolder.class, "com.obric.memorydata.plugin");
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r0) {
        X9ECParametersHolder r1 = getByOIDLazy(r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier r2) {
        return (X9ECParametersHolder) ZeusTransformUtils.preCheckCast(oidToCurve.get(r2), X9ECParametersHolder.class, "com.obric.memorydata.plugin");
    }

    public static String getName(ASN1ObjectIdentifier r2) {
        return (String) ZeusTransformUtils.preCheckCast(oidToName.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static Enumeration getNames() {
        return names.elements();
    }
}

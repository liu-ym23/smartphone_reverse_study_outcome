package org.bouncycastle.asn1.anssi;

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
public class ANSSINamedCurves {
    static X9ECParametersHolder FRP256v1;
    static final Hashtable curves = null;
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        FRP256v1 = new AnonymousClass1();
        objIds = new Hashtable();
        curves = new Hashtable();
        names = new Hashtable();
        defineCurve("FRP256v1", ANSSIObjectIdentifiers.FRP256v1, FRP256v1);
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

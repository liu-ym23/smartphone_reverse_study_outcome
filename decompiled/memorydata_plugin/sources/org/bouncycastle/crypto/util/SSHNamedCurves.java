package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class SSHNamedCurves {
    private static HashMap<ECCurve, String> curveMap;
    private static final Map<String, String> curveNameToSSHName = null;
    private static final Map<String, ASN1ObjectIdentifier> oidMap = null;
    private static final Map<ASN1ObjectIdentifier, String> oidToName = null;

    static {
        oidMap = Collections.unmodifiableMap(new AnonymousClass1());
        curveNameToSSHName = Collections.unmodifiableMap(new AnonymousClass2());
        curveMap = new AnonymousClass3();
        oidToName = Collections.unmodifiableMap(new AnonymousClass4());
    }

    static /* synthetic */ Map access$000() {
        return oidMap;
    }

    public static ASN1ObjectIdentifier getByName(String r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(oidMap.get(r2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    public static String getName(ASN1ObjectIdentifier r2) {
        return (String) ZeusTransformUtils.preCheckCast(oidToName.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static String getNameForParameters(ECDomainParameters r2) {
        if (ZeusTransformUtils.instanceOf(r2, ECNamedDomainParameters.class) == false) goto L7;
        return getName(((ECNamedDomainParameters) ZeusTransformUtils.preCheckCast(r2, ECNamedDomainParameters.class, "com.obric.memorydata.plugin")).getName());
    L7:
        return getNameForParameters(r2.getCurve());
    }

    public static String getNameForParameters(ECCurve r2) {
        return (String) ZeusTransformUtils.preCheckCast(curveNameToSSHName.get(curveMap.get(r2)), String.class, "com.obric.memorydata.plugin");
    }

    public static X9ECParameters getParameters(ASN1ObjectIdentifier r0) {
        return NISTNamedCurves.getByOID(r0);
    }
}

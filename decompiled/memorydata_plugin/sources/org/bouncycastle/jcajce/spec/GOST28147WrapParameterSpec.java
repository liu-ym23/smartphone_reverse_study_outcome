package org.bouncycastle.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class GOST28147WrapParameterSpec implements AlgorithmParameterSpec {
    private static Map oidMappings;
    private byte[] sBox;
    private byte[] ukm;

    static {
        HashMap r0 = new HashMap();
        oidMappings = r0;
        r0.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
        oidMappings.put(RosstandartObjectIdentifiers.id_tc26_gost_28147_param_Z, "Param-Z");
    }

    public GOST28147WrapParameterSpec(String r2) {
        this.ukm = null;
        this.sBox = null;
        this.sBox = GOST28147Engine.getSBox(r2);
    }

    public GOST28147WrapParameterSpec(ASN1ObjectIdentifier r1, byte[] r2) {
        this(getName(r1));
        this.ukm = Arrays.clone(r2);
    }

    private static String getName(ASN1ObjectIdentifier r3) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(oidMappings.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unknown OID: " + r3);
    }

    public byte[] getSBox() {
        return Arrays.clone(this.sBox);
    }

    public byte[] getUKM() {
        return Arrays.clone(this.ukm);
    }
}

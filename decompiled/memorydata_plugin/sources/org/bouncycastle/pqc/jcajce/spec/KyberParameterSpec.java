package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.crystals.kyber.KyberParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class KyberParameterSpec implements AlgorithmParameterSpec {
    public static final KyberParameterSpec kyber1024 = null;
    public static final KyberParameterSpec kyber1024_aes = null;
    public static final KyberParameterSpec kyber512 = null;
    public static final KyberParameterSpec kyber512_aes = null;
    public static final KyberParameterSpec kyber768 = null;
    public static final KyberParameterSpec kyber768_aes = null;
    private static Map parameters;
    private final String name;

    static {
        KyberParameterSpec r0 = new KyberParameterSpec(KyberParameters.kyber512);
        kyber512 = r0;
        KyberParameterSpec r1 = new KyberParameterSpec(KyberParameters.kyber768);
        kyber768 = r1;
        KyberParameterSpec r2 = new KyberParameterSpec(KyberParameters.kyber1024);
        kyber1024 = r2;
        KyberParameterSpec r3 = new KyberParameterSpec(KyberParameters.kyber512_aes);
        kyber512_aes = r3;
        KyberParameterSpec r4 = new KyberParameterSpec(KyberParameters.kyber768_aes);
        kyber768_aes = r4;
        KyberParameterSpec r5 = new KyberParameterSpec(KyberParameters.kyber1024_aes);
        kyber1024_aes = r5;
        HashMap r6 = new HashMap();
        parameters = r6;
        r6.put("kyber512", r0);
        parameters.put("kyber768", r1);
        parameters.put("kyber1024", r2);
        parameters.put("kyber512-aes", r3);
        parameters.put("kyber768-aes", r4);
        parameters.put("kyber1024-aes", r5);
    }

    private KyberParameterSpec(KyberParameters r1) {
        this.name = r1.getName();
    }

    public static KyberParameterSpec fromName(String r2) {
        return (KyberParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), KyberParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

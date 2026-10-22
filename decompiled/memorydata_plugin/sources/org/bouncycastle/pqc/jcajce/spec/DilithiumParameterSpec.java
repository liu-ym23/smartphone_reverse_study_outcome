package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class DilithiumParameterSpec implements AlgorithmParameterSpec {
    public static final DilithiumParameterSpec dilithium2 = null;
    public static final DilithiumParameterSpec dilithium2_aes = null;
    public static final DilithiumParameterSpec dilithium3 = null;
    public static final DilithiumParameterSpec dilithium3_aes = null;
    public static final DilithiumParameterSpec dilithium5 = null;
    public static final DilithiumParameterSpec dilithium5_aes = null;
    private static Map parameters;
    private final String name;

    static {
        DilithiumParameterSpec r0 = new DilithiumParameterSpec(DilithiumParameters.dilithium2);
        dilithium2 = r0;
        DilithiumParameterSpec r1 = new DilithiumParameterSpec(DilithiumParameters.dilithium3);
        dilithium3 = r1;
        DilithiumParameterSpec r2 = new DilithiumParameterSpec(DilithiumParameters.dilithium5);
        dilithium5 = r2;
        DilithiumParameterSpec r3 = new DilithiumParameterSpec(DilithiumParameters.dilithium2_aes);
        dilithium2_aes = r3;
        DilithiumParameterSpec r4 = new DilithiumParameterSpec(DilithiumParameters.dilithium3_aes);
        dilithium3_aes = r4;
        DilithiumParameterSpec r5 = new DilithiumParameterSpec(DilithiumParameters.dilithium5_aes);
        dilithium5_aes = r5;
        HashMap r6 = new HashMap();
        parameters = r6;
        r6.put("dilithium2", r0);
        parameters.put("dilithium3", r1);
        parameters.put("dilithium5", r2);
        parameters.put("dilithium2-aes", r3);
        parameters.put("dilithium3-aes", r4);
        parameters.put("dilithium5-aes", r5);
    }

    private DilithiumParameterSpec(DilithiumParameters r1) {
        this.name = r1.getName();
    }

    public static DilithiumParameterSpec fromName(String r2) {
        return (DilithiumParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), DilithiumParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class SNTRUPrimeParameterSpec implements AlgorithmParameterSpec {
    private static Map parameters;
    public static final SNTRUPrimeParameterSpec sntrup1013 = null;
    public static final SNTRUPrimeParameterSpec sntrup1277 = null;
    public static final SNTRUPrimeParameterSpec sntrup653 = null;
    public static final SNTRUPrimeParameterSpec sntrup761 = null;
    public static final SNTRUPrimeParameterSpec sntrup857 = null;
    public static final SNTRUPrimeParameterSpec sntrup953 = null;
    private final String name;

    static {
        SNTRUPrimeParameterSpec r0 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup653);
        sntrup653 = r0;
        SNTRUPrimeParameterSpec r1 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup761);
        sntrup761 = r1;
        SNTRUPrimeParameterSpec r2 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup857);
        sntrup857 = r2;
        SNTRUPrimeParameterSpec r3 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup953);
        sntrup953 = r3;
        SNTRUPrimeParameterSpec r4 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup1013);
        sntrup1013 = r4;
        SNTRUPrimeParameterSpec r5 = new SNTRUPrimeParameterSpec(SNTRUPrimeParameters.sntrup1277);
        sntrup1277 = r5;
        HashMap r6 = new HashMap();
        parameters = r6;
        r6.put("sntrup653", r0);
        parameters.put("sntrup761", r1);
        parameters.put("sntrup857", r2);
        parameters.put("sntrup953", r3);
        parameters.put("sntrup1013", r4);
        parameters.put("sntrup1277", r5);
    }

    private SNTRUPrimeParameterSpec(SNTRUPrimeParameters r1) {
        this.name = r1.getName();
    }

    public static SNTRUPrimeParameterSpec fromName(String r2) {
        return (SNTRUPrimeParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), SNTRUPrimeParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

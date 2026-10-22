package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.frodo.FrodoParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class FrodoParameterSpec implements AlgorithmParameterSpec {
    public static final FrodoParameterSpec frodokem1344aes = null;
    public static final FrodoParameterSpec frodokem1344shake = null;
    public static final FrodoParameterSpec frodokem640aes = null;
    public static final FrodoParameterSpec frodokem640shake = null;
    public static final FrodoParameterSpec frodokem976aes = null;
    public static final FrodoParameterSpec frodokem976shake = null;
    private static Map parameters;
    private final String name;

    static {
        FrodoParameterSpec r0 = new FrodoParameterSpec(FrodoParameters.frodokem640aes);
        frodokem640aes = r0;
        FrodoParameterSpec r1 = new FrodoParameterSpec(FrodoParameters.frodokem640shake);
        frodokem640shake = r1;
        FrodoParameterSpec r2 = new FrodoParameterSpec(FrodoParameters.frodokem976aes);
        frodokem976aes = r2;
        FrodoParameterSpec r3 = new FrodoParameterSpec(FrodoParameters.frodokem976shake);
        frodokem976shake = r3;
        FrodoParameterSpec r4 = new FrodoParameterSpec(FrodoParameters.frodokem1344aes);
        frodokem1344aes = r4;
        FrodoParameterSpec r5 = new FrodoParameterSpec(FrodoParameters.frodokem1344shake);
        frodokem1344shake = r5;
        HashMap r6 = new HashMap();
        parameters = r6;
        r6.put("frodokem19888r3", r0);
        parameters.put("frodokem19888shaker3", r1);
        parameters.put("frodokem31296r3", r2);
        parameters.put("frodokem31296shaker3", r3);
        parameters.put("frodokem43088r3", r4);
        parameters.put("frodokem43088shaker3", r5);
        parameters.put("frodokem640aes", r0);
        parameters.put("frodokem640shake", r1);
        parameters.put("frodokem976aes", r2);
        parameters.put("frodokem976shake", r3);
        parameters.put("frodokem1344aes", r4);
        parameters.put("frodokem1344shake", r5);
    }

    private FrodoParameterSpec(FrodoParameters r1) {
        this.name = r1.getName();
    }

    public static FrodoParameterSpec fromName(String r2) {
        return (FrodoParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), FrodoParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

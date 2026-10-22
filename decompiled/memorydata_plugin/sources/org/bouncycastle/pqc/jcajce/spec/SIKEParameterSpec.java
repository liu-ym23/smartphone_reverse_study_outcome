package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.sike.SIKEParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class SIKEParameterSpec implements AlgorithmParameterSpec {
    private static Map parameters;
    public static final SIKEParameterSpec sikep434 = null;
    public static final SIKEParameterSpec sikep434_compressed = null;
    public static final SIKEParameterSpec sikep503 = null;
    public static final SIKEParameterSpec sikep503_compressed = null;
    public static final SIKEParameterSpec sikep610 = null;
    public static final SIKEParameterSpec sikep610_compressed = null;
    public static final SIKEParameterSpec sikep751 = null;
    public static final SIKEParameterSpec sikep751_compressed = null;
    private final String name;

    static {
        sikep434 = new SIKEParameterSpec(SIKEParameters.sikep434);
        sikep503 = new SIKEParameterSpec(SIKEParameters.sikep503);
        sikep610 = new SIKEParameterSpec(SIKEParameters.sikep610);
        sikep751 = new SIKEParameterSpec(SIKEParameters.sikep751);
        sikep434_compressed = new SIKEParameterSpec(SIKEParameters.sikep434_compressed);
        sikep503_compressed = new SIKEParameterSpec(SIKEParameters.sikep503_compressed);
        sikep610_compressed = new SIKEParameterSpec(SIKEParameters.sikep610_compressed);
        sikep751_compressed = new SIKEParameterSpec(SIKEParameters.sikep751_compressed);
        parameters = new HashMap();
    }

    private SIKEParameterSpec(SIKEParameters r1) {
        this.name = r1.getName();
    }

    public static SIKEParameterSpec fromName(String r2) {
        return (SIKEParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), SIKEParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

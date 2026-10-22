package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.hqc.HQCParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class HQCParameterSpec implements AlgorithmParameterSpec {
    public static final HQCParameterSpec hqc128 = null;
    public static final HQCParameterSpec hqc192 = null;
    public static final HQCParameterSpec hqc256 = null;
    private static Map parameters;
    private final String name;

    static {
        HQCParameterSpec r0 = new HQCParameterSpec(HQCParameters.hqc128);
        hqc128 = r0;
        HQCParameterSpec r1 = new HQCParameterSpec(HQCParameters.hqc192);
        hqc192 = r1;
        HQCParameterSpec r2 = new HQCParameterSpec(HQCParameters.hqc256);
        hqc256 = r2;
        HashMap r3 = new HashMap();
        parameters = r3;
        r3.put("hqc128", r0);
        parameters.put("hqc192", r1);
        parameters.put("hqc256", r2);
    }

    private HQCParameterSpec(HQCParameters r1) {
        this.name = r1.getName();
    }

    public static HQCParameterSpec fromName(String r2) {
        return (HQCParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), HQCParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

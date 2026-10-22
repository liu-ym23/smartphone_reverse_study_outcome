package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.falcon.FalconParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class FalconParameterSpec implements AlgorithmParameterSpec {
    public static final FalconParameterSpec falcon_1024 = null;
    public static final FalconParameterSpec falcon_512 = null;
    private static Map parameters;
    private final String name;

    static {
        FalconParameterSpec r0 = new FalconParameterSpec(FalconParameters.falcon_512);
        falcon_512 = r0;
        FalconParameterSpec r1 = new FalconParameterSpec(FalconParameters.falcon_1024);
        falcon_1024 = r1;
        HashMap r2 = new HashMap();
        parameters = r2;
        r2.put("falcon-512", r0);
        parameters.put("falcon-1024", r1);
    }

    private FalconParameterSpec(FalconParameters r1) {
        this.name = r1.getName();
    }

    public static FalconParameterSpec fromName(String r2) {
        return (FalconParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), FalconParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

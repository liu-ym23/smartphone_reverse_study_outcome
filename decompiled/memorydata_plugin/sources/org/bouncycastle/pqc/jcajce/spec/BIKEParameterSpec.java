package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.bike.BIKEParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class BIKEParameterSpec implements AlgorithmParameterSpec {
    public static final BIKEParameterSpec bike128 = null;
    public static final BIKEParameterSpec bike192 = null;
    public static final BIKEParameterSpec bike256 = null;
    private static Map parameters;
    private final String name;

    static {
        BIKEParameterSpec r0 = new BIKEParameterSpec(BIKEParameters.bike128);
        bike128 = r0;
        BIKEParameterSpec r1 = new BIKEParameterSpec(BIKEParameters.bike192);
        bike192 = r1;
        BIKEParameterSpec r2 = new BIKEParameterSpec(BIKEParameters.bike256);
        bike256 = r2;
        HashMap r3 = new HashMap();
        parameters = r3;
        r3.put("bike128", r0);
        parameters.put("bike192", r1);
        parameters.put("bike256", r2);
    }

    private BIKEParameterSpec(BIKEParameters r1) {
        this.name = r1.getName();
    }

    public static BIKEParameterSpec fromName(String r2) {
        return (BIKEParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), BIKEParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

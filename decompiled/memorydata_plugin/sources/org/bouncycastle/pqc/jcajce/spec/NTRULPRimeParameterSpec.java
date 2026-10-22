package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class NTRULPRimeParameterSpec implements AlgorithmParameterSpec {
    public static final NTRULPRimeParameterSpec ntrulpr1013 = null;
    public static final NTRULPRimeParameterSpec ntrulpr1277 = null;
    public static final NTRULPRimeParameterSpec ntrulpr653 = null;
    public static final NTRULPRimeParameterSpec ntrulpr761 = null;
    public static final NTRULPRimeParameterSpec ntrulpr857 = null;
    public static final NTRULPRimeParameterSpec ntrulpr953 = null;
    private static Map parameters;
    private final String name;

    static {
        NTRULPRimeParameterSpec r0 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr653);
        ntrulpr653 = r0;
        NTRULPRimeParameterSpec r1 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr761);
        ntrulpr761 = r1;
        NTRULPRimeParameterSpec r2 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr857);
        ntrulpr857 = r2;
        NTRULPRimeParameterSpec r3 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr953);
        ntrulpr953 = r3;
        NTRULPRimeParameterSpec r4 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr1013);
        ntrulpr1013 = r4;
        NTRULPRimeParameterSpec r5 = new NTRULPRimeParameterSpec(NTRULPRimeParameters.ntrulpr1277);
        ntrulpr1277 = r5;
        HashMap r6 = new HashMap();
        parameters = r6;
        r6.put("ntrulpr653", r0);
        parameters.put("ntrulpr761", r1);
        parameters.put("ntrulpr857", r2);
        parameters.put("ntrulpr953", r3);
        parameters.put("ntrulpr1013", r4);
        parameters.put("ntrulpr1277", r5);
    }

    private NTRULPRimeParameterSpec(NTRULPRimeParameters r1) {
        this.name = r1.getName();
    }

    public static NTRULPRimeParameterSpec fromName(String r2) {
        return (NTRULPRimeParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), NTRULPRimeParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

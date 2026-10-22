package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.ntru.NTRUParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class NTRUParameterSpec implements AlgorithmParameterSpec {
    public static final NTRUParameterSpec ntruhps2048509 = null;
    public static final NTRUParameterSpec ntruhps2048677 = null;
    public static final NTRUParameterSpec ntruhps4096821 = null;
    public static final NTRUParameterSpec ntruhrss701 = null;
    private static Map parameters;
    private final String name;

    static {
        NTRUParameterSpec r0 = new NTRUParameterSpec(NTRUParameters.ntruhps2048509);
        ntruhps2048509 = r0;
        NTRUParameterSpec r1 = new NTRUParameterSpec(NTRUParameters.ntruhps2048677);
        ntruhps2048677 = r1;
        NTRUParameterSpec r2 = new NTRUParameterSpec(NTRUParameters.ntruhps4096821);
        ntruhps4096821 = r2;
        NTRUParameterSpec r3 = new NTRUParameterSpec(NTRUParameters.ntruhrss701);
        ntruhrss701 = r3;
        HashMap r4 = new HashMap();
        parameters = r4;
        r4.put("ntruhps2048509", r0);
        parameters.put("ntruhps2048677", r1);
        parameters.put("ntruhps4096821", r2);
        parameters.put("ntruhrss701", r3);
    }

    private NTRUParameterSpec(NTRUParameters r1) {
        this.name = r1.getName();
    }

    public static NTRUParameterSpec fromName(String r2) {
        return (NTRUParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), NTRUParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

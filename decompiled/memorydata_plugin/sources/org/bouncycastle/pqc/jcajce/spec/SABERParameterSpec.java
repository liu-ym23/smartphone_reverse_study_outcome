package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.saber.SABERParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class SABERParameterSpec implements AlgorithmParameterSpec {
    public static final SABERParameterSpec firesaberkem128r3 = null;
    public static final SABERParameterSpec firesaberkem192r3 = null;
    public static final SABERParameterSpec firesaberkem256r3 = null;
    public static final SABERParameterSpec lightsaberkem128r3 = null;
    public static final SABERParameterSpec lightsaberkem192r3 = null;
    public static final SABERParameterSpec lightsaberkem256r3 = null;
    private static Map parameters;
    public static final SABERParameterSpec saberkem128r3 = null;
    public static final SABERParameterSpec saberkem192r3 = null;
    public static final SABERParameterSpec saberkem256r3 = null;
    private final String name;

    static {
        lightsaberkem128r3 = new SABERParameterSpec(SABERParameters.lightsaberkem128r3);
        saberkem128r3 = new SABERParameterSpec(SABERParameters.saberkem128r3);
        firesaberkem128r3 = new SABERParameterSpec(SABERParameters.firesaberkem128r3);
        lightsaberkem192r3 = new SABERParameterSpec(SABERParameters.lightsaberkem192r3);
        saberkem192r3 = new SABERParameterSpec(SABERParameters.saberkem192r3);
        firesaberkem192r3 = new SABERParameterSpec(SABERParameters.firesaberkem192r3);
        lightsaberkem256r3 = new SABERParameterSpec(SABERParameters.lightsaberkem256r3);
        saberkem256r3 = new SABERParameterSpec(SABERParameters.saberkem256r3);
        firesaberkem256r3 = new SABERParameterSpec(SABERParameters.firesaberkem256r3);
        parameters = new HashMap();
    }

    private SABERParameterSpec(SABERParameters r1) {
        this.name = r1.getName();
    }

    public static SABERParameterSpec fromName(String r2) {
        return (SABERParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), SABERParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

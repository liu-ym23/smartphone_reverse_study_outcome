package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.cmce.CMCEParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEParameterSpec implements AlgorithmParameterSpec {
    public static final CMCEParameterSpec mceliece348864 = null;
    public static final CMCEParameterSpec mceliece348864f = null;
    public static final CMCEParameterSpec mceliece460896 = null;
    public static final CMCEParameterSpec mceliece460896f = null;
    public static final CMCEParameterSpec mceliece6688128 = null;
    public static final CMCEParameterSpec mceliece6688128f = null;
    public static final CMCEParameterSpec mceliece6960119 = null;
    public static final CMCEParameterSpec mceliece6960119f = null;
    public static final CMCEParameterSpec mceliece8192128 = null;
    public static final CMCEParameterSpec mceliece8192128f = null;
    private static Map parameters;
    private final String name;

    static {
        CMCEParameterSpec r0 = new CMCEParameterSpec(CMCEParameters.mceliece348864r3);
        mceliece348864 = r0;
        CMCEParameterSpec r1 = new CMCEParameterSpec(CMCEParameters.mceliece348864fr3);
        mceliece348864f = r1;
        CMCEParameterSpec r2 = new CMCEParameterSpec(CMCEParameters.mceliece460896r3);
        mceliece460896 = r2;
        CMCEParameterSpec r3 = new CMCEParameterSpec(CMCEParameters.mceliece460896fr3);
        mceliece460896f = r3;
        CMCEParameterSpec r4 = new CMCEParameterSpec(CMCEParameters.mceliece6688128r3);
        mceliece6688128 = r4;
        CMCEParameterSpec r5 = new CMCEParameterSpec(CMCEParameters.mceliece6688128fr3);
        mceliece6688128f = r5;
        CMCEParameterSpec r6 = new CMCEParameterSpec(CMCEParameters.mceliece6960119r3);
        mceliece6960119 = r6;
        CMCEParameterSpec r7 = new CMCEParameterSpec(CMCEParameters.mceliece6960119fr3);
        mceliece6960119f = r7;
        CMCEParameterSpec r8 = new CMCEParameterSpec(CMCEParameters.mceliece8192128r3);
        mceliece8192128 = r8;
        CMCEParameterSpec r9 = new CMCEParameterSpec(CMCEParameters.mceliece8192128fr3);
        mceliece8192128f = r9;
        HashMap r10 = new HashMap();
        parameters = r10;
        r10.put("mceliece348864", r0);
        parameters.put("mceliece348864f", r1);
        parameters.put("mceliece460896", r2);
        parameters.put("mceliece460896f", r3);
        parameters.put("mceliece6688128", r4);
        parameters.put("mceliece6688128f", r5);
        parameters.put("mceliece6960119", r6);
        parameters.put("mceliece6960119f", r7);
        parameters.put("mceliece8192128", r8);
        parameters.put("mceliece8192128f", r9);
    }

    private CMCEParameterSpec(CMCEParameters r1) {
        this.name = r1.getName();
    }

    public static CMCEParameterSpec fromName(String r2) {
        return (CMCEParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), CMCEParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

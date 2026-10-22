package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.picnic.PicnicParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class PicnicParameterSpec implements AlgorithmParameterSpec {
    private static Map parameters;
    public static final PicnicParameterSpec picnic3l1 = null;
    public static final PicnicParameterSpec picnic3l3 = null;
    public static final PicnicParameterSpec picnic3l5 = null;
    public static final PicnicParameterSpec picnicl1fs = null;
    public static final PicnicParameterSpec picnicl1full = null;
    public static final PicnicParameterSpec picnicl1ur = null;
    public static final PicnicParameterSpec picnicl3fs = null;
    public static final PicnicParameterSpec picnicl3full = null;
    public static final PicnicParameterSpec picnicl3ur = null;
    public static final PicnicParameterSpec picnicl5fs = null;
    public static final PicnicParameterSpec picnicl5full = null;
    public static final PicnicParameterSpec picnicl5ur = null;
    private final String name;

    static {
        PicnicParameterSpec r0 = new PicnicParameterSpec(PicnicParameters.picnicl1fs);
        picnicl1fs = r0;
        PicnicParameterSpec r1 = new PicnicParameterSpec(PicnicParameters.picnicl1ur);
        picnicl1ur = r1;
        PicnicParameterSpec r2 = new PicnicParameterSpec(PicnicParameters.picnicl3fs);
        picnicl3fs = r2;
        PicnicParameterSpec r3 = new PicnicParameterSpec(PicnicParameters.picnicl3ur);
        picnicl3ur = r3;
        PicnicParameterSpec r4 = new PicnicParameterSpec(PicnicParameters.picnicl5fs);
        picnicl5fs = r4;
        PicnicParameterSpec r5 = new PicnicParameterSpec(PicnicParameters.picnicl5ur);
        picnicl5ur = r5;
        PicnicParameterSpec r6 = new PicnicParameterSpec(PicnicParameters.picnic3l1);
        picnic3l1 = r6;
        PicnicParameterSpec r7 = new PicnicParameterSpec(PicnicParameters.picnic3l3);
        picnic3l3 = r7;
        PicnicParameterSpec r8 = new PicnicParameterSpec(PicnicParameters.picnic3l5);
        picnic3l5 = r8;
        PicnicParameterSpec r9 = new PicnicParameterSpec(PicnicParameters.picnicl1full);
        picnicl1full = r9;
        PicnicParameterSpec r10 = new PicnicParameterSpec(PicnicParameters.picnicl3full);
        picnicl3full = r10;
        PicnicParameterSpec r11 = new PicnicParameterSpec(PicnicParameters.picnicl5full);
        picnicl5full = r11;
        HashMap r12 = new HashMap();
        parameters = r12;
        r12.put("picnicl1fs", r0);
        parameters.put("picnicl1ur", r1);
        parameters.put("picnicl3fs", r2);
        parameters.put("picnicl3ur", r3);
        parameters.put("picnicl5fs", r4);
        parameters.put("picnicl5ur", r5);
        parameters.put("picnic3l1", r6);
        parameters.put("picnic3l3", r7);
        parameters.put("picnic3l5", r8);
        parameters.put("picnicl1full", r9);
        parameters.put("picnicl3full", r10);
        parameters.put("picnicl5full", r11);
    }

    private PicnicParameterSpec(PicnicParameters r1) {
        this.name = r1.getName();
    }

    public static PicnicParameterSpec fromName(String r2) {
        return (PicnicParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), PicnicParameterSpec.class, "com.obric.memorydata.plugin");
    }
}

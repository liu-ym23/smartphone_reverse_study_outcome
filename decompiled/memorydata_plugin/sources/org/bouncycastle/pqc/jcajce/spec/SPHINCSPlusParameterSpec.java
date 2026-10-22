package org.bouncycastle.pqc.jcajce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPlusParameterSpec implements AlgorithmParameterSpec {
    public static final SPHINCSPlusParameterSpec haraka_128f = null;
    public static final SPHINCSPlusParameterSpec haraka_128f_simple = null;
    public static final SPHINCSPlusParameterSpec haraka_128s = null;
    public static final SPHINCSPlusParameterSpec haraka_128s_simple = null;
    public static final SPHINCSPlusParameterSpec haraka_192f = null;
    public static final SPHINCSPlusParameterSpec haraka_192f_simple = null;
    public static final SPHINCSPlusParameterSpec haraka_192s = null;
    public static final SPHINCSPlusParameterSpec haraka_192s_simple = null;
    public static final SPHINCSPlusParameterSpec haraka_256f = null;
    public static final SPHINCSPlusParameterSpec haraka_256f_simple = null;
    public static final SPHINCSPlusParameterSpec haraka_256s = null;
    public static final SPHINCSPlusParameterSpec haraka_256s_simple = null;
    private static Map parameters;
    public static final SPHINCSPlusParameterSpec sha2_128f = null;
    public static final SPHINCSPlusParameterSpec sha2_128f_simple = null;
    public static final SPHINCSPlusParameterSpec sha2_128s = null;
    public static final SPHINCSPlusParameterSpec sha2_128s_simple = null;
    public static final SPHINCSPlusParameterSpec sha2_192f = null;
    public static final SPHINCSPlusParameterSpec sha2_192f_simple = null;
    public static final SPHINCSPlusParameterSpec sha2_192s = null;
    public static final SPHINCSPlusParameterSpec sha2_192s_simple = null;
    public static final SPHINCSPlusParameterSpec sha2_256f = null;
    public static final SPHINCSPlusParameterSpec sha2_256f_simple = null;
    public static final SPHINCSPlusParameterSpec sha2_256s = null;
    public static final SPHINCSPlusParameterSpec sha2_256s_simple = null;
    public static final SPHINCSPlusParameterSpec shake_128f = null;
    public static final SPHINCSPlusParameterSpec shake_128f_simple = null;
    public static final SPHINCSPlusParameterSpec shake_128s = null;
    public static final SPHINCSPlusParameterSpec shake_128s_simple = null;
    public static final SPHINCSPlusParameterSpec shake_192f = null;
    public static final SPHINCSPlusParameterSpec shake_192f_simple = null;
    public static final SPHINCSPlusParameterSpec shake_192s = null;
    public static final SPHINCSPlusParameterSpec shake_192s_simple = null;
    public static final SPHINCSPlusParameterSpec shake_256f = null;
    public static final SPHINCSPlusParameterSpec shake_256f_simple = null;
    public static final SPHINCSPlusParameterSpec shake_256s = null;
    public static final SPHINCSPlusParameterSpec shake_256s_simple = null;
    private final String name;

    static {
        SPHINCSPlusParameterSpec r0 = new SPHINCSPlusParameterSpec("sha2-128f-robust");
        sha2_128f = r0;
        SPHINCSPlusParameterSpec r1 = new SPHINCSPlusParameterSpec("sha2-128s-robust");
        sha2_128s = r1;
        SPHINCSPlusParameterSpec r2 = new SPHINCSPlusParameterSpec("sha2-192f-robust");
        sha2_192f = r2;
        SPHINCSPlusParameterSpec r3 = new SPHINCSPlusParameterSpec("sha2-192s-robust");
        sha2_192s = r3;
        SPHINCSPlusParameterSpec r4 = new SPHINCSPlusParameterSpec("sha2-256f-robust");
        sha2_256f = r4;
        SPHINCSPlusParameterSpec r5 = new SPHINCSPlusParameterSpec("sha2-256s-robust");
        sha2_256s = r5;
        SPHINCSPlusParameterSpec r6 = new SPHINCSPlusParameterSpec("sha2-128s-simple");
        sha2_128f_simple = r6;
        SPHINCSPlusParameterSpec r7 = new SPHINCSPlusParameterSpec("sha2-128f-simple");
        sha2_128s_simple = r7;
        SPHINCSPlusParameterSpec r8 = new SPHINCSPlusParameterSpec("sha2-192f-simple");
        sha2_192f_simple = r8;
        SPHINCSPlusParameterSpec r9 = new SPHINCSPlusParameterSpec("sha2-192s-simple");
        sha2_192s_simple = r9;
        SPHINCSPlusParameterSpec r10 = new SPHINCSPlusParameterSpec("sha2-256f-simple");
        sha2_256f_simple = r10;
        SPHINCSPlusParameterSpec r11 = new SPHINCSPlusParameterSpec("sha2-256s-simple");
        sha2_256s_simple = r11;
        SPHINCSPlusParameterSpec r12 = new SPHINCSPlusParameterSpec("shake-128f-robust");
        shake_128f = r12;
        SPHINCSPlusParameterSpec r13 = new SPHINCSPlusParameterSpec("shake-128s-robust");
        shake_128s = r13;
        SPHINCSPlusParameterSpec r14 = new SPHINCSPlusParameterSpec("shake-192f-robust");
        shake_192f = r14;
        SPHINCSPlusParameterSpec r15 = new SPHINCSPlusParameterSpec("shake-192s-robust");
        shake_192s = r15;
        SPHINCSPlusParameterSpec r16 = new SPHINCSPlusParameterSpec("shake-256f-robust");
        shake_256f = r16;
        SPHINCSPlusParameterSpec r17 = new SPHINCSPlusParameterSpec("shake-256s-robust");
        shake_256s = r17;
        SPHINCSPlusParameterSpec r18 = new SPHINCSPlusParameterSpec("shake-128f-simple");
        shake_128f_simple = r18;
        SPHINCSPlusParameterSpec r19 = new SPHINCSPlusParameterSpec("shake-128s-simple");
        shake_128s_simple = r19;
        SPHINCSPlusParameterSpec r110 = new SPHINCSPlusParameterSpec("shake-192f-simple");
        shake_192f_simple = r110;
        SPHINCSPlusParameterSpec r111 = new SPHINCSPlusParameterSpec("shake-192s-simple");
        shake_192s_simple = r111;
        SPHINCSPlusParameterSpec r112 = new SPHINCSPlusParameterSpec("shake-256f-simple");
        shake_256f_simple = r112;
        SPHINCSPlusParameterSpec r113 = new SPHINCSPlusParameterSpec("shake-256s-simple");
        shake_256s_simple = r113;
        SPHINCSPlusParameterSpec r114 = new SPHINCSPlusParameterSpec("haraka-128f-robust");
        haraka_128f = r114;
        SPHINCSPlusParameterSpec r115 = new SPHINCSPlusParameterSpec("haraka-128s-robust");
        haraka_128s = r115;
        SPHINCSPlusParameterSpec r116 = new SPHINCSPlusParameterSpec("haraka-256f-robust");
        haraka_256f = r116;
        SPHINCSPlusParameterSpec r117 = new SPHINCSPlusParameterSpec("haraka-256s-robust");
        haraka_256s = r117;
        SPHINCSPlusParameterSpec r118 = new SPHINCSPlusParameterSpec("haraka-192f-robust");
        haraka_192f = r118;
        SPHINCSPlusParameterSpec r119 = new SPHINCSPlusParameterSpec("haraka-192s-robust");
        haraka_192s = r119;
        SPHINCSPlusParameterSpec r120 = new SPHINCSPlusParameterSpec("haraka-128f-simple");
        haraka_128f_simple = r120;
        SPHINCSPlusParameterSpec r121 = new SPHINCSPlusParameterSpec("haraka-128s-simple");
        haraka_128s_simple = r121;
        SPHINCSPlusParameterSpec r122 = new SPHINCSPlusParameterSpec("haraka-192f-simple");
        haraka_192f_simple = r122;
        SPHINCSPlusParameterSpec r123 = new SPHINCSPlusParameterSpec("haraka-192s-simple");
        haraka_192s_simple = r123;
        SPHINCSPlusParameterSpec r124 = new SPHINCSPlusParameterSpec("haraka-256f-simple");
        haraka_256f_simple = r124;
        SPHINCSPlusParameterSpec r125 = new SPHINCSPlusParameterSpec("haraka-256s-simple");
        haraka_256s_simple = r125;
        HashMap r126 = new HashMap();
        parameters = r126;
        r126.put(r0.getName(), r0);
        parameters.put(r1.getName(), r1);
        parameters.put(r2.getName(), r2);
        parameters.put(r3.getName(), r3);
        parameters.put(r4.getName(), r4);
        parameters.put(r5.getName(), r5);
        parameters.put(r6.getName(), r6);
        parameters.put(r7.getName(), r7);
        parameters.put(r8.getName(), r8);
        parameters.put(r9.getName(), r9);
        parameters.put(r10.getName(), r10);
        parameters.put(r11.getName(), r11);
        parameters.put(r12.getName(), r12);
        parameters.put(r13.getName(), r13);
        parameters.put(r14.getName(), r14);
        parameters.put(r15.getName(), r15);
        parameters.put(r16.getName(), r16);
        parameters.put(r17.getName(), r17);
        parameters.put(r18.getName(), r18);
        parameters.put(r19.getName(), r19);
        parameters.put(r110.getName(), r110);
        parameters.put(r111.getName(), r111);
        parameters.put(r112.getName(), r112);
        parameters.put(r113.getName(), r113);
        parameters.put(r114.getName(), r114);
        parameters.put(r115.getName(), r115);
        parameters.put(r118.getName(), r118);
        parameters.put(r119.getName(), r119);
        parameters.put(r116.getName(), r116);
        parameters.put(r117.getName(), r117);
        parameters.put(r120.getName(), r120);
        parameters.put(r121.getName(), r121);
        parameters.put(r122.getName(), r122);
        parameters.put(r123.getName(), r123);
        parameters.put(r124.getName(), r124);
        parameters.put(r125.getName(), r125);
    }

    private SPHINCSPlusParameterSpec(String r1) {
        this.name = r1;
    }

    public static SPHINCSPlusParameterSpec fromName(String r2) {
        return (SPHINCSPlusParameterSpec) ZeusTransformUtils.preCheckCast(parameters.get(Strings.toLowerCase(r2)), SPHINCSPlusParameterSpec.class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.name;
    }
}

package org.bouncycastle.pqc.crypto.sphincsplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPlusParameters {
    public static final SPHINCSPlusParameters haraka_128f = null;
    public static final SPHINCSPlusParameters haraka_128f_simple = null;
    public static final SPHINCSPlusParameters haraka_128s = null;
    public static final SPHINCSPlusParameters haraka_128s_simple = null;
    public static final SPHINCSPlusParameters haraka_192f = null;
    public static final SPHINCSPlusParameters haraka_192f_simple = null;
    public static final SPHINCSPlusParameters haraka_192s = null;
    public static final SPHINCSPlusParameters haraka_192s_simple = null;
    public static final SPHINCSPlusParameters haraka_256f = null;
    public static final SPHINCSPlusParameters haraka_256f_simple = null;
    public static final SPHINCSPlusParameters haraka_256s = null;
    public static final SPHINCSPlusParameters haraka_256s_simple = null;
    private static final Map<Integer, SPHINCSPlusParameters> oidToParams = null;
    private static final Map<SPHINCSPlusParameters, Integer> paramsToOid = null;
    public static final SPHINCSPlusParameters sha2_128f = null;
    public static final SPHINCSPlusParameters sha2_128f_simple = null;
    public static final SPHINCSPlusParameters sha2_128s = null;
    public static final SPHINCSPlusParameters sha2_128s_simple = null;
    public static final SPHINCSPlusParameters sha2_192f = null;
    public static final SPHINCSPlusParameters sha2_192f_simple = null;
    public static final SPHINCSPlusParameters sha2_192s = null;
    public static final SPHINCSPlusParameters sha2_192s_simple = null;
    public static final SPHINCSPlusParameters sha2_256f = null;
    public static final SPHINCSPlusParameters sha2_256f_simple = null;
    public static final SPHINCSPlusParameters sha2_256s = null;
    public static final SPHINCSPlusParameters sha2_256s_simple = null;
    public static final SPHINCSPlusParameters shake_128f = null;
    public static final SPHINCSPlusParameters shake_128f_simple = null;
    public static final SPHINCSPlusParameters shake_128s = null;
    public static final SPHINCSPlusParameters shake_128s_simple = null;
    public static final SPHINCSPlusParameters shake_192f = null;
    public static final SPHINCSPlusParameters shake_192f_simple = null;
    public static final SPHINCSPlusParameters shake_192s = null;
    public static final SPHINCSPlusParameters shake_192s_simple = null;
    public static final SPHINCSPlusParameters shake_256f = null;
    public static final SPHINCSPlusParameters shake_256f_simple = null;
    public static final SPHINCSPlusParameters shake_256s = null;
    public static final SPHINCSPlusParameters shake_256s_simple = null;
    private static final Integer sphincsPlus_haraka_128f_robust = null;
    private static final Integer sphincsPlus_haraka_128f_simple = null;
    private static final Integer sphincsPlus_haraka_128s_robust = null;
    private static final Integer sphincsPlus_haraka_128s_simple = null;
    private static final Integer sphincsPlus_haraka_192f_robust = null;
    private static final Integer sphincsPlus_haraka_192f_simple = null;
    private static final Integer sphincsPlus_haraka_192s_robust = null;
    private static final Integer sphincsPlus_haraka_192s_simple = null;
    private static final Integer sphincsPlus_haraka_256f_robust = null;
    private static final Integer sphincsPlus_haraka_256f_simple = null;
    private static final Integer sphincsPlus_haraka_256s_robust = null;
    private static final Integer sphincsPlus_haraka_256s_simple = null;
    private static final Integer sphincsPlus_sha2_128f_robust = null;
    private static final Integer sphincsPlus_sha2_128f_simple = null;
    private static final Integer sphincsPlus_sha2_128s_robust = null;
    private static final Integer sphincsPlus_sha2_128s_simple = null;
    private static final Integer sphincsPlus_sha2_192f_robust = null;
    private static final Integer sphincsPlus_sha2_192f_simple = null;
    private static final Integer sphincsPlus_sha2_192s_robust = null;
    private static final Integer sphincsPlus_sha2_192s_simple = null;
    private static final Integer sphincsPlus_sha2_256f_robust = null;
    private static final Integer sphincsPlus_sha2_256f_simple = null;
    private static final Integer sphincsPlus_sha2_256s_robust = null;
    private static final Integer sphincsPlus_sha2_256s_simple = null;
    private static final Integer sphincsPlus_shake_128f_robust = null;
    private static final Integer sphincsPlus_shake_128f_simple = null;
    private static final Integer sphincsPlus_shake_128s_robust = null;
    private static final Integer sphincsPlus_shake_128s_simple = null;
    private static final Integer sphincsPlus_shake_192f_robust = null;
    private static final Integer sphincsPlus_shake_192f_simple = null;
    private static final Integer sphincsPlus_shake_192s_robust = null;
    private static final Integer sphincsPlus_shake_192s_simple = null;
    private static final Integer sphincsPlus_shake_256f_robust = null;
    private static final Integer sphincsPlus_shake_256f_simple = null;
    private static final Integer sphincsPlus_shake_256s_robust = null;
    private static final Integer sphincsPlus_shake_256s_simple = null;
    private final SPHINCSPlusEngineProvider engineProvider;
    private final String name;

    private static class HarakaSEngineProvider implements SPHINCSPlusEngineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17982a;
        private final int d;
        private final int h;
        private final int k;
        private final int n;
        private final boolean robust;
        private final int w;

        public HarakaSEngineProvider(boolean r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            this.robust = r1;
            this.n = r2;
            this.w = r3;
            this.d = r4;
            this.f17982a = r5;
            this.k = r6;
            this.h = r7;
        }

        @Override // org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngineProvider
        public int getN() {
            return this.n;
        }
    }

    private static class Sha2EngineProvider implements SPHINCSPlusEngineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17983a;
        private final int d;
        private final int h;
        private final int k;
        private final int n;
        private final boolean robust;
        private final int w;

        public Sha2EngineProvider(boolean r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            this.robust = r1;
            this.n = r2;
            this.w = r3;
            this.d = r4;
            this.f17983a = r5;
            this.k = r6;
            this.h = r7;
        }

        @Override // org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngineProvider
        public int getN() {
            return this.n;
        }
    }

    private static class Shake256EngineProvider implements SPHINCSPlusEngineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17984a;
        private final int d;
        private final int h;
        private final int k;
        private final int n;
        private final boolean robust;
        private final int w;

        public Shake256EngineProvider(boolean r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            this.robust = r1;
            this.n = r2;
            this.w = r3;
            this.d = r4;
            this.f17984a = r5;
            this.k = r6;
            this.h = r7;
        }

        @Override // org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusEngineProvider
        public int getN() {
            return this.n;
        }
    }

    static {
        sha2_128f = new SPHINCSPlusParameters("sha2-128f-robust", new Sha2EngineProvider(true, 16, 16, 22, 6, 33, 66));
        sha2_128s = new SPHINCSPlusParameters("sha2-128s-robust", new Sha2EngineProvider(true, 16, 16, 7, 12, 14, 63));
        sha2_192f = new SPHINCSPlusParameters("sha2-192f-robust", new Sha2EngineProvider(true, 24, 16, 22, 8, 33, 66));
        sha2_192s = new SPHINCSPlusParameters("sha2-192s-robust", new Sha2EngineProvider(true, 24, 16, 7, 14, 17, 63));
        sha2_256f = new SPHINCSPlusParameters("sha2-256f-robust", new Sha2EngineProvider(true, 32, 16, 17, 9, 35, 68));
        sha2_256s = new SPHINCSPlusParameters("sha2-256s-robust", new Sha2EngineProvider(true, 32, 16, 8, 14, 22, 64));
        sha2_128f_simple = new SPHINCSPlusParameters("sha2-128f-simple", new Sha2EngineProvider(false, 16, 16, 22, 6, 33, 66));
        sha2_128s_simple = new SPHINCSPlusParameters("sha2-128s-simple", new Sha2EngineProvider(false, 16, 16, 7, 12, 14, 63));
        sha2_192f_simple = new SPHINCSPlusParameters("sha2-192f-simple", new Sha2EngineProvider(false, 24, 16, 22, 8, 33, 66));
        sha2_192s_simple = new SPHINCSPlusParameters("sha2-192s-simple", new Sha2EngineProvider(false, 24, 16, 7, 14, 17, 63));
        sha2_256f_simple = new SPHINCSPlusParameters("sha2-256f-simple", new Sha2EngineProvider(false, 32, 16, 17, 9, 35, 68));
        sha2_256s_simple = new SPHINCSPlusParameters("sha2-256s-simple", new Sha2EngineProvider(false, 32, 16, 8, 14, 22, 64));
        shake_128f = new SPHINCSPlusParameters("shake-128f-robust", new Shake256EngineProvider(true, 16, 16, 22, 6, 33, 66));
        shake_128s = new SPHINCSPlusParameters("shake-128s-robust", new Shake256EngineProvider(true, 16, 16, 7, 12, 14, 63));
        shake_192f = new SPHINCSPlusParameters("shake-192f-robust", new Shake256EngineProvider(true, 24, 16, 22, 8, 33, 66));
        shake_192s = new SPHINCSPlusParameters("shake-192s-robust", new Shake256EngineProvider(true, 24, 16, 7, 14, 17, 63));
        shake_256f = new SPHINCSPlusParameters("shake-256f-robust", new Shake256EngineProvider(true, 32, 16, 17, 9, 35, 68));
        shake_256s = new SPHINCSPlusParameters("shake-256s-robust", new Shake256EngineProvider(true, 32, 16, 8, 14, 22, 64));
        shake_128f_simple = new SPHINCSPlusParameters("shake-128f-simple", new Shake256EngineProvider(false, 16, 16, 22, 6, 33, 66));
        shake_128s_simple = new SPHINCSPlusParameters("shake-128s-simple", new Shake256EngineProvider(false, 16, 16, 7, 12, 14, 63));
        shake_192f_simple = new SPHINCSPlusParameters("shake-192f-simple", new Shake256EngineProvider(false, 24, 16, 22, 8, 33, 66));
        shake_192s_simple = new SPHINCSPlusParameters("shake-192s-simple", new Shake256EngineProvider(false, 24, 16, 7, 14, 17, 63));
        shake_256f_simple = new SPHINCSPlusParameters("shake-256f-simple", new Shake256EngineProvider(false, 32, 16, 17, 9, 35, 68));
        shake_256s_simple = new SPHINCSPlusParameters("shake-256s-simple", new Shake256EngineProvider(false, 32, 16, 8, 14, 22, 64));
        haraka_128f = new SPHINCSPlusParameters("haraka-128f-robust", new HarakaSEngineProvider(true, 16, 16, 22, 6, 33, 66));
        haraka_128s = new SPHINCSPlusParameters("haraka-128s-robust", new HarakaSEngineProvider(true, 16, 16, 7, 12, 14, 63));
        haraka_256f = new SPHINCSPlusParameters("haraka-256f-robust", new HarakaSEngineProvider(true, 32, 16, 17, 9, 35, 68));
        haraka_256s = new SPHINCSPlusParameters("haraka-256s-robust", new HarakaSEngineProvider(true, 32, 16, 8, 14, 22, 64));
        haraka_192f = new SPHINCSPlusParameters("haraka-192f-robust", new HarakaSEngineProvider(true, 24, 16, 22, 8, 33, 66));
        haraka_192s = new SPHINCSPlusParameters("haraka-192s-robust", new HarakaSEngineProvider(true, 24, 16, 7, 14, 17, 63));
        haraka_128f_simple = new SPHINCSPlusParameters("haraka-128f-simple", new HarakaSEngineProvider(false, 16, 16, 22, 6, 33, 66));
        haraka_128s_simple = new SPHINCSPlusParameters("haraka-128s-simple", new HarakaSEngineProvider(false, 16, 16, 7, 12, 14, 63));
        haraka_192f_simple = new SPHINCSPlusParameters("haraka-192f-simple", new HarakaSEngineProvider(false, 24, 16, 22, 8, 33, 66));
        haraka_192s_simple = new SPHINCSPlusParameters("haraka-192s-simple", new HarakaSEngineProvider(false, 24, 16, 7, 14, 17, 63));
        haraka_256f_simple = new SPHINCSPlusParameters("haraka-256f-simple", new HarakaSEngineProvider(false, 32, 16, 17, 9, 35, 68));
        haraka_256s_simple = new SPHINCSPlusParameters("haraka-256s-simple", new HarakaSEngineProvider(false, 32, 16, 8, 14, 22, 64));
        Integer r0 = Integers.valueOf(65793);
        sphincsPlus_sha2_128f_robust = r0;
        Integer r1 = Integers.valueOf(65794);
        sphincsPlus_sha2_128s_robust = r1;
        Integer r2 = Integers.valueOf(65795);
        sphincsPlus_sha2_192f_robust = r2;
        Integer r3 = Integers.valueOf(65796);
        sphincsPlus_sha2_192s_robust = r3;
        Integer r4 = Integers.valueOf(65797);
        sphincsPlus_sha2_256f_robust = r4;
        Integer r5 = Integers.valueOf(65798);
        sphincsPlus_sha2_256s_robust = r5;
        Integer r6 = Integers.valueOf(66049);
        sphincsPlus_sha2_128f_simple = r6;
        Integer r7 = Integers.valueOf(66050);
        sphincsPlus_sha2_128s_simple = r7;
        Integer r8 = Integers.valueOf(66051);
        sphincsPlus_sha2_192f_simple = r8;
        Integer r9 = Integers.valueOf(66052);
        sphincsPlus_sha2_192s_simple = r9;
        Integer r10 = Integers.valueOf(66053);
        sphincsPlus_sha2_256f_simple = r10;
        Integer r11 = Integers.valueOf(66054);
        sphincsPlus_sha2_256s_simple = r11;
        Integer r12 = Integers.valueOf(131329);
        sphincsPlus_shake_128f_robust = r12;
        Integer r13 = Integers.valueOf(131330);
        sphincsPlus_shake_128s_robust = r13;
        Integer r14 = Integers.valueOf(131331);
        sphincsPlus_shake_192f_robust = r14;
        Integer r15 = Integers.valueOf(131332);
        sphincsPlus_shake_192s_robust = r15;
        Integer r16 = Integers.valueOf(131333);
        sphincsPlus_shake_256f_robust = r16;
        Integer r17 = Integers.valueOf(131334);
        sphincsPlus_shake_256s_robust = r17;
        Integer r18 = Integers.valueOf(131585);
        sphincsPlus_shake_128f_simple = r18;
        Integer r19 = Integers.valueOf(131586);
        sphincsPlus_shake_128s_simple = r19;
        Integer r110 = Integers.valueOf(131587);
        sphincsPlus_shake_192f_simple = r110;
        Integer r111 = Integers.valueOf(131588);
        sphincsPlus_shake_192s_simple = r111;
        Integer r112 = Integers.valueOf(131589);
        sphincsPlus_shake_256f_simple = r112;
        Integer r113 = Integers.valueOf(131590);
        sphincsPlus_shake_256s_simple = r113;
        Integer r114 = Integers.valueOf(196865);
        sphincsPlus_haraka_128f_robust = r114;
        Integer r115 = Integers.valueOf(196866);
        sphincsPlus_haraka_128s_robust = r115;
        Integer r116 = Integers.valueOf(196867);
        sphincsPlus_haraka_192f_robust = r116;
        Integer r117 = Integers.valueOf(196868);
        sphincsPlus_haraka_192s_robust = r117;
        Integer r118 = Integers.valueOf(196869);
        sphincsPlus_haraka_256f_robust = r118;
        Integer r119 = Integers.valueOf(196870);
        sphincsPlus_haraka_256s_robust = r119;
        Integer r120 = Integers.valueOf(197121);
        sphincsPlus_haraka_128f_simple = r120;
        Integer r121 = Integers.valueOf(197122);
        sphincsPlus_haraka_128s_simple = r121;
        Integer r122 = Integers.valueOf(197123);
        sphincsPlus_haraka_192f_simple = r122;
        Integer r123 = Integers.valueOf(197124);
        sphincsPlus_haraka_192s_simple = r123;
        Integer r124 = Integers.valueOf(197125);
        sphincsPlus_haraka_256f_simple = r124;
        Integer r125 = Integers.valueOf(197126);
        sphincsPlus_haraka_256s_simple = r125;
        HashMap r126 = new HashMap();
        oidToParams = r126;
        HashMap r127 = new HashMap();
        paramsToOid = r127;
        SPHINCSPlusParameters r128 = sha2_128f;
        r126.put(r0, r128);
        SPHINCSPlusParameters r20 = sha2_128s;
        r126.put(r1, r20);
        SPHINCSPlusParameters r21 = sha2_192f;
        r126.put(r2, r21);
        SPHINCSPlusParameters r22 = sha2_192s;
        r126.put(r3, r22);
        SPHINCSPlusParameters r23 = sha2_256f;
        r126.put(r4, r23);
        SPHINCSPlusParameters r24 = sha2_256s;
        r126.put(r5, r24);
        SPHINCSPlusParameters r25 = sha2_128f_simple;
        r126.put(r6, r25);
        SPHINCSPlusParameters r26 = sha2_128s_simple;
        r126.put(r7, r26);
        SPHINCSPlusParameters r27 = sha2_192f_simple;
        r126.put(r8, r27);
        SPHINCSPlusParameters r28 = sha2_192s_simple;
        r126.put(r9, r28);
        SPHINCSPlusParameters r29 = sha2_256f_simple;
        r126.put(r10, r29);
        SPHINCSPlusParameters r129 = sha2_256s_simple;
        r126.put(r11, r129);
        SPHINCSPlusParameters r130 = shake_128f;
        r126.put(r12, r130);
        SPHINCSPlusParameters r131 = shake_128s;
        r126.put(r13, r131);
        SPHINCSPlusParameters r132 = shake_192f;
        r126.put(r14, r132);
        SPHINCSPlusParameters r133 = shake_192s;
        r126.put(r15, r133);
        SPHINCSPlusParameters r134 = shake_256f;
        r126.put(r16, r134);
        SPHINCSPlusParameters r135 = shake_256s;
        r126.put(r17, r135);
        SPHINCSPlusParameters r136 = shake_128f_simple;
        r126.put(r18, r136);
        SPHINCSPlusParameters r137 = shake_128s_simple;
        r126.put(r19, r137);
        SPHINCSPlusParameters r138 = shake_192f_simple;
        r126.put(r110, r138);
        SPHINCSPlusParameters r139 = shake_192s_simple;
        r126.put(r111, r139);
        SPHINCSPlusParameters r140 = shake_256f_simple;
        r126.put(r112, r140);
        SPHINCSPlusParameters r141 = shake_256s_simple;
        r126.put(r113, r141);
        SPHINCSPlusParameters r142 = haraka_128f_simple;
        r126.put(r120, r142);
        SPHINCSPlusParameters r143 = haraka_128f;
        r126.put(r114, r143);
        SPHINCSPlusParameters r144 = haraka_192f_simple;
        r126.put(r122, r144);
        SPHINCSPlusParameters r145 = haraka_192f;
        r126.put(r116, r145);
        SPHINCSPlusParameters r146 = haraka_256f_simple;
        r126.put(r124, r146);
        SPHINCSPlusParameters r147 = haraka_256f;
        r126.put(r118, r147);
        SPHINCSPlusParameters r148 = haraka_128s_simple;
        r126.put(r121, r148);
        SPHINCSPlusParameters r149 = haraka_128s;
        r126.put(r115, r149);
        SPHINCSPlusParameters r150 = haraka_192s_simple;
        r126.put(r123, r150);
        SPHINCSPlusParameters r151 = haraka_192s;
        r126.put(r117, r151);
        SPHINCSPlusParameters r152 = haraka_256s_simple;
        r126.put(r125, r152);
        SPHINCSPlusParameters r153 = haraka_256s;
        r126.put(r119, r153);
        r127.put(r128, sphincsPlus_sha2_128f_robust);
        r127.put(r20, sphincsPlus_sha2_128s_robust);
        r127.put(r21, sphincsPlus_sha2_192f_robust);
        r127.put(r22, sphincsPlus_sha2_192s_robust);
        r127.put(r23, sphincsPlus_sha2_256f_robust);
        r127.put(r24, sphincsPlus_sha2_256s_robust);
        r127.put(r25, sphincsPlus_sha2_128f_simple);
        r127.put(r26, sphincsPlus_sha2_128s_simple);
        r127.put(r27, sphincsPlus_sha2_192f_simple);
        r127.put(r28, sphincsPlus_sha2_192s_simple);
        r127.put(r29, sphincsPlus_sha2_256f_simple);
        r127.put(r129, sphincsPlus_sha2_256s_simple);
        r127.put(r130, sphincsPlus_shake_128f_robust);
        r127.put(r131, sphincsPlus_shake_128s_robust);
        Map<SPHINCSPlusParameters, Integer> r30 = paramsToOid;
        r30.put(r132, sphincsPlus_shake_192f_robust);
        r30.put(r133, sphincsPlus_shake_192s_robust);
        r30.put(r134, sphincsPlus_shake_256f_robust);
        r30.put(r135, sphincsPlus_shake_256s_robust);
        r30.put(r136, sphincsPlus_shake_128f_simple);
        r30.put(r137, sphincsPlus_shake_128s_simple);
        r30.put(r138, sphincsPlus_shake_192f_simple);
        r30.put(r139, sphincsPlus_shake_192s_simple);
        r30.put(r140, sphincsPlus_shake_256f_simple);
        r30.put(r141, sphincsPlus_shake_256s_simple);
        r30.put(r143, sphincsPlus_haraka_128f_robust);
        r30.put(r145, sphincsPlus_haraka_192f_robust);
        r30.put(r147, sphincsPlus_haraka_256f_robust);
        r30.put(r149, sphincsPlus_haraka_128s_robust);
        r30.put(r151, sphincsPlus_haraka_192s_robust);
        r30.put(r153, sphincsPlus_haraka_256s_robust);
        r30.put(r142, sphincsPlus_haraka_128f_simple);
        r30.put(r144, sphincsPlus_haraka_192f_simple);
        r30.put(r146, sphincsPlus_haraka_256f_simple);
        r30.put(r148, sphincsPlus_haraka_128s_simple);
        r30.put(r150, sphincsPlus_haraka_192s_simple);
        r30.put(r152, sphincsPlus_haraka_256s_simple);
    }

    private SPHINCSPlusParameters(String r3, SPHINCSPlusEngineProvider r4) {
        SPHINCSPlusEngineProvider r5 = (SPHINCSPlusEngineProvider) ZeusTransformUtils.wrapperContextForParams(r4, SPHINCSPlusEngineProvider.class, "com.obric.memorydata.plugin");
        this.name = r3;
        this.engineProvider = r5;
    }

    public static Integer getID(SPHINCSPlusParameters r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(paramsToOid.get(r2), Integer.class, "com.obric.memorydata.plugin");
    }

    public static SPHINCSPlusParameters getParams(Integer r2) {
        return (SPHINCSPlusParameters) ZeusTransformUtils.preCheckCast(oidToParams.get(r2), SPHINCSPlusParameters.class, "com.obric.memorydata.plugin");
    }

    int getN() {
        return this.engineProvider.getN();
    }

    public String getName() {
        return this.name;
    }
}

package com.obric.performance.power.monitor.cpu;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.performance.power.monitor.utils.EnsureLoad;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static Map<Integer, Long> i;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int[] d;
    public final boolean e;
    public CPUInfo f;
    public int g;
    public final c h;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.cpu.a$a, reason: collision with other inner class name */
    public static final class C0006a {
    }

    static {
    }

    public final void a() {
        EnsureLoad.a.getClass();
        if (EnsureLoad.b == true) goto L5;
        return;
    L5:
        boolean r3 = false;
        if (this.a == true) goto L19;
        int[] r0 = this.d;
        if (r0 == null) goto L18;
        if (r0 != null) goto L11;
    L16:
        boolean r1 = false;
    L17:
        if (r1 == false) goto L19;
        return;
    L11:
        if (r0.length != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 != true) goto L16;
        r1 = true;
        goto L17
    L13:
        r2 = false;
        goto L14
    L18:
        return;
    L19:
        c r4 = this.h;
        r4.a = 0.0d;
        r4.b = 0.0d;
        r4.c = 0.0d;
        r4.d = 0.0d;
        r4.e = 0;
        r4.f = 0;
        Map<Integer, Map<Long, Long>> r8 = r4.g;
        if (r8 == null) goto L22;
        r8.clear();
    L22:
        r4.h = 0;
        r4.i = 0;
        Map<Integer, Long> r9 = r4.j;
        if (r9 == null) goto L25;
        r9.clear();
    L25:
        Map<Integer, Map<Integer, Long>> r5 = r4.k;
        if (r5 == null) goto L28;
        r5.clear();
    L28:
        boolean r10 = this.a;
        boolean r11 = this.e;
        int[] r12 = this.d;
        boolean r13 = this.b;
        CPUNative r6 = CPUNative.a;
        long r14 = System.currentTimeMillis();
        CPUInfo r7 = CPUNative.dumpNativeCpuTime(r10, r11, r10, r12, r13, r13);
        r7.setRefreshTime(r14);
        r7.toString();
        CPUInfo r15 = this.f;
        if (r15 == null) goto L142;
        this.h.i = System.currentTimeMillis() - r15.getRefreshTime();
        long r16 = r7.getProcCpu() - r15.getProcCpu();
        if (r16 <= 0) goto L41;
        c r17 = this.h;
        r17.h = r16;
        r17.b = (r16 / r17.i) / ((double) b());
        long r18 = r7.getDevCpu() - r15.getDevCpu();
        if (r18 <= 0) goto L41;
        c r19 = this.h;
        r19.e = r18;
        r19.a = r19.h / r18;
        long r110 = r7.getDevIdle() - r15.getDevIdle();
        if (1 <= r110) goto L37;
    L39:
        if (r3 == false) goto L41;
        c r20 = this.h;
        r20.f = r110;
        r20.d = ((double) 1) - (r110 / r20.e);
        goto L41
    L37:
        if (r110 > r18) goto L39;
        r3 = true;
    L41:
        Map r21 = r7.getDevCpuFreqMap();
        if (r21 == null) goto L59;
        Map r22 = r15.getDevCpuFreqMap();
        if (r22 == null) goto L59;
        LinkedHashMap r23 = new LinkedHashMap();
        Iterator r24 = r21.entrySet().iterator();
    L47:
        if (r24.hasNext() == false) goto L57;
        Map.Entry r111 = (Map.Entry) r24.next();
        int r112 = ((Number) r111.getKey()).intValue();
        Map r113 = (Map) r111.getValue();
        Map r114 = (Map) r22.get(Integer.valueOf(r112));
        if (r114 == null) goto L47;
        Integer r115 = Integer.valueOf(r112);
        LinkedHashMap r116 = new LinkedHashMap();
        Iterator r117 = r113.entrySet().iterator();
    L52:
        if (r117.hasNext() == false) goto L56;
        Map.Entry r118 = (Map.Entry) r117.next();
        long r119 = ((Number) r118.getKey()).longValue();
        long r120 = ((Number) r118.getValue()).longValue();
        Long r121 = (Long) r114.get(Long.valueOf(r119));
        if (r121 == null) goto L52;
        r116.put(Long.valueOf(r119), Long.valueOf(r120 - r121.longValue()));
        goto L52
    L56:
        r23.put(r115, r116);
        goto L47
    L57:
        this.h.g = r23;
    L59:
        if (this.c == false) goto L112;
        Map<Integer, Map<Long, Long>> r25 = this.h.g;
        if (r25 == null) goto L112;
        if (i != null) goto L98;
        CPUMonitor.initPolicyMaxFreqMap.1 r26 = CPUMonitor.initPolicyMaxFreqMap.1.INSTANCE;
        monitor-enter(r26);
    L95:
        th = move-exception;
        throw th;
    L67:
        if (i != null) goto L92;
        i = new LinkedHashMap();     // Catch: Throwable -> L95
        Map r27 = CPUNative.a.a();     // Catch: Throwable -> L95
        if (r27 == null) goto L92;
        Iterator r28 = r27.entrySet().iterator();     // Catch: Throwable -> L95
    L72:
        if (r28.hasNext() == false) goto L92;
        Map.Entry r122 = (Map.Entry) r28.next();     // Catch: Throwable -> L95
        int r123 = ((Number) r122.getKey()).intValue();     // Catch: Throwable -> L95
        int r124 = ((Number) r122.getValue()).intValue();     // Catch: Throwable -> L95
        Map<Long, Long> r125 = r25.get(Integer.valueOf(r123));     // Catch: Throwable -> L95
        if (r125 == null) goto L72;
        Iterator<T> r126 = r125.entrySet().iterator();     // Catch: Throwable -> L95
        Long r127 = null;
        if (r126.hasNext() == true) goto L78;
        Object r128 = null;
    L87:
        Map.Entry r129 = (Map.Entry) r128;     // Catch: Throwable -> L95
        if (r129 == null) goto L90;
        r127 = (Long) r129.getKey();     // Catch: Throwable -> L95
    L90:
        if (r127 == null) goto L72;
        Integer r130 = Integer.valueOf(r123);     // Catch: Throwable -> L95
        Map<Integer, Long> r131 = i;     // Catch: Throwable -> L95
        Intrinsics.checkNotNull(r131);     // Catch: Throwable -> L95
        r131.put(r130, Long.valueOf(((long) r124) * r127.longValue()));     // Catch: Throwable -> L95
        goto L72
    L78:
        r128 = r126.next();     // Catch: Throwable -> L95
        if (r126.hasNext() == false) goto L87;
        long r132 = ((Number) ((Map.Entry) r128).getKey()).longValue();     // Catch: Throwable -> L95
    L82:
        Object r133 = r126.next();     // Catch: Throwable -> L95
        long r134 = ((Number) ((Map.Entry) r133).getKey()).longValue();     // Catch: Throwable -> L95
        if (r132 >= r134) goto L86;
        r128 = r133;
        r132 = r134;
    L86:
        if (r126.hasNext() == true) goto L82;
    L92:
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L95
        monitor-exit(r26);
    L98:
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r30 = r25.entrySet().iterator();
        double r31 = 0.0d;
    L100:
        if (r30.hasNext() == false) goto L111;
        Map.Entry<Integer, Map<Long, Long>> r32 = r30.next();
        int r135 = r32.getKey().intValue();
        Map<Long, Long> r33 = r32.getValue();
        Map<Integer, Long> r136 = i;
        Intrinsics.checkNotNull(r136);
        Long r137 = (Long) ((LinkedHashMap) r136).get(Integer.valueOf(r135));
        if (r137 == null) goto L100;
        long r138 = r137.longValue();
        Iterator<Map.Entry<Long, Long>> r34 = r33.entrySet().iterator();
        long r139 = 0;
    L105:
        if (r34.hasNext() == false) goto L107;
        Map.Entry<Long, Long> r140 = r34.next();
        r139 = r139 + (r140.getKey().longValue() * r140.getValue().longValue());
        goto L105
    L107:
        double r141 = r139 / (r138 * this.h.i);
        if (r141 <= 1.0d) goto L110;
        r141 = 1.0d;
    L110:
        r31 = r31 + r141;
        goto L100
    L111:
        double r35 = r31 / ((double) r25.size());
        c r36 = this.h;
        r36.c = r36.a * r35;
    L112:
        Map r37 = r7.getThreadCpuMap();
        if (r37 == null) goto L125;
        Map r38 = r15.getThreadCpuMap();
        if (r38 == null) goto L125;
        LinkedHashMap r39 = new LinkedHashMap();
        Iterator r40 = r37.entrySet().iterator();
    L118:
        if (r40.hasNext() == false) goto L124;
        Map.Entry r41 = (Map.Entry) r40.next();
        int r42 = ((Number) r41.getKey()).intValue();
        long r142 = ((Number) r41.getValue()).longValue();
        Long r43 = (Long) r38.get(Integer.valueOf(r42));
        if (r43 == null) goto L118;
        long r143 = r142 - r43.longValue();
        if (r143 < 0) goto L118;
        r39.put(Integer.valueOf(r42), Long.valueOf(r143));
        goto L118
    L124:
        this.h.j = r39;
    L125:
        Map r44 = r7.getThreadCpuPolicyMap();
        if (r44 == null) goto L142;
        Map r45 = r15.getThreadCpuPolicyMap();
        if (r45 == null) goto L142;
        LinkedHashMap r46 = new LinkedHashMap();
        Iterator r47 = r44.entrySet().iterator();
    L131:
        if (r47.hasNext() == false) goto L141;
        Map.Entry r48 = (Map.Entry) r47.next();
        int r49 = ((Number) r48.getKey()).intValue();
        Map r50 = (Map) r48.getValue();
        Map r51 = (Map) r45.get(Integer.valueOf(r49));
        if (r51 == null) goto L131;
        Integer r52 = Integer.valueOf(r49);
        LinkedHashMap r53 = new LinkedHashMap();
        Iterator r54 = r50.entrySet().iterator();
    L136:
        if (r54.hasNext() == false) goto L140;
        Map.Entry r55 = (Map.Entry) r54.next();
        int r144 = ((Number) r55.getKey()).intValue();
        long r145 = ((Number) r55.getValue()).longValue();
        Long r56 = (Long) r51.get(Integer.valueOf(r144));
        if (r56 == null) goto L136;
        r53.put(Integer.valueOf(r144), Long.valueOf(r145 - r56.longValue()));
        goto L136
    L140:
        r46.put(r52, r53);
        goto L131
    L141:
        this.h.k = r46;
    L142:
        this.f = r7;
    }

    public final int b() {
        int r0 = this.g;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        String[] r1 = new PolarisFileWrapper("/sys/devices/system/cpu").list(new b());
        if (r1 == null) goto L8;
        int r2 = r1.length;
    L9:
        this.g = r2;
        return r2;
    L8:
        r2 = 0;
        goto L9
    }

    public a(boolean r3, int[] r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 16) == 0) goto L11;
        r5 = false;
    L11:
        this.a = r3;
        this.b = false;
        this.c = false;
        this.d = r4;
        this.e = r5;
        this.g = -1;
        this.h = new c(null);
    }
}

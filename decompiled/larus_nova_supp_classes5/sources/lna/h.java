package lna;

import android.os.Handler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl;
import com.obric.performance.power.monitor.cpu.exception.CPUExceptionDiagnosisConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static final AtomicBoolean a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static boolean e;
    public static volatile CPUExceptionDiagnosisConfig f;
    public static volatile boolean g;
    public static volatile boolean h;
    public static final Lazy i = null;
    public static final a j = null;

    public static final class a implements Runnable {
        public a() {
        }

        public final void a() {
            AtomicBoolean r0 = h.a;
            if (h.g == false) goto L5;
            float r1 = h.f.getBackgroundSampledRate();
        L7:
            if (new Random().nextFloat() >= r1) goto L9;
            boolean r2 = true;
        L11:
            if (r2 == true) goto L22;
            ILogDepend.a.d("CPUExceptionDiagnosis", "periodTask skip (sample miss)");
        L18:
            if (h.a.get() == false) goto L20;
            AtomicBoolean r3 = h.a;
            ((Handler) h.d.getValue()).postDelayed(this, h.f.getPeriodInterval());
            return;
        L20:
            ILogDepend.a.d("CPUExceptionDiagnosis", "already stop");
            return;
        L22:
            h.a();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            ILogDepend.a.e("CPUExceptionDiagnosis", "periodTask catch error", th);
            goto L18
        L9:
            r2 = false;
            goto L11
        L5:
            r1 = h.f.getFrontSampledRate();
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h() {
    }

    static {
        a = new AtomicBoolean(false);
        b = LazyKt.lazy(new lna.a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
        e = true;
        f = new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
        kna.a r1 = kna.a.a;
        int r2 = kna.b.a;
        g = true;
        i = LazyKt.lazy(new d());
        j = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v62, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v68, types: [java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r0v93 */
    public static final void a() {
        ILogDepend.Companion r0 = ILogDepend.a;
        r0.d("CPUExceptionDiagnosis", "threadCheckAndDump");
        long r3 = System.currentTimeMillis();
        ThreadGroup r1 = (ThreadGroup) b.getValue();
        if (r1 == null) goto L285;
        int r5 = r1.activeCount() * 2;
        if (r5 <= 0) goto L286;
        Thread[] r7 = new Thread[r5];
        r0.d("CPUExceptionDiagnosis", "thread active:" + r5 + " actual:" + r1.enumerate(r7));
        LinkedHashMap r2 = new LinkedHashMap();
        int r4 = 0;
    L10:
        if (r4 >= r5) goto L48;
        Thread r11 = r7[r4];
        if (r11 == null) goto L47;
        int r12 = qna.c.b(r11);
        if (r12 > 0) goto L17;
        ILogDepend.a.w("CPUExceptionDiagnosis", "getNativeTid fail");
        goto L47
    L17:
        if (e == false) goto L38;
        j r13 = j.a;
        String r14 = r11.getName();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, DBDefinition.NAME);
        if (r12 <= 0) goto L38;
        if (r14.length() != 0) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == true) goto L38;
        if (j.c.contains(r14) == true) goto L34;
        Iterator r16 = j.d.iterator();
    L31:
        if (r16.hasNext() == false) goto L35;
        if (StringsKt.startsWith$default(r14, (String) r16.next(), false, 2, null) == false) goto L31;
    L35:
        boolean r9 = false;
    L36:
        if (r9 == false) goto L38;
        ILogDepend.a.d("TCpuFilter", "system thread tid:" + r12 + " name:" + r14);
        j.b.add(Integer.valueOf(r12));
    L34:
        r9 = true;
        goto L36
    L23:
        r15 = false;
    L38:
        j.a.getClass();
        if (r12 > 0) goto L41;
    L44:
        boolean r10 = true;
    L45:
        if (r10 == true) goto L47;
        r2.put(Integer.valueOf(r12), new k(r11.getName(), r11));
        goto L47
    L41:
        if (j.b.contains(Integer.valueOf(r12)) == true) goto L44;
        r10 = false;
    L47:
        r4 = r4 + 1;
        goto L10
    L48:
        e = false;
        ILogDepend.a.d("CPUExceptionDiagnosis", "enumerate cost:" + (System.currentTimeMillis() - r3));
        int[] r6 = CollectionsKt.toIntArray(r2.keySet());
        long r8 = f.getMeasureCpuTime();
        long r17 = f.cpuExceptionTime(g);
        String r18 = ", thread name:";
        String r19 = ", processName: ";
        if (r2.isEmpty() == false) goto L51;
    L106:
        ?? r20 = MapsKt.emptyMap();
    L108:
        if (r20.isEmpty() == false) goto L110;
        ILogDepend.a.d("CPUExceptionDiagnosis", "no issue thread");
        return;
    L110:
        ILogDepend.a.d("CPUExceptionDiagnosis", "issue thread list:" + r20.size());
        ?? r21 = r20;
        if (f.getTopDumpCount() <= 0) goto L117;
        List r22 = CollectionsKt.take(CollectionsKt.shuffled(CollectionsKt.toList(r20.entrySet())), f.getTopDumpCount());
        LinkedHashMap r23 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r22, 10)), 16));
        Iterator r24 = r22.iterator();
    L114:
        if (r24.hasNext() == false) goto L116;
        Map.Entry r25 = (Map.Entry) r24.next();
        Pair r26 = TuplesKt.to(r25.getKey(), r25.getValue());
        r23.put(r26.getFirst(), r26.getSecond());
        goto L114
    L116:
        r21 = r23;
    L117:
        Iterator r27 = r21.entrySet().iterator();
    L119:
        if (r27.hasNext() == false) goto L287;
        Map.Entry r28 = (Map.Entry) r27.next();
        int r29 = ((Number) r28.getKey()).intValue();
        long r30 = ((Number) r28.getValue()).longValue();
        k r31 = (k) r2.get(Integer.valueOf(r29));
        if (r31 == null) goto L119;
        ILogDepend.a.d("CPUExceptionDiagnosis", "try dump as exception, tid:" + r29 + ", cpu:" + r30 + r18 + r31.a + r19 + ((String) i.getValue()));
        r31.c = System.currentTimeMillis();
        Thread r32 = r31.b;
        int r33 = RangesKt.coerceAtLeast(f.getThreadStackSleepMaxRetry(), 0);
        long r34 = RangesKt.coerceAtLeast(f.getDumpIntervalMillis(), 0);
        int r35 = r33 + 1;
        int r36 = 0;
    L123:
        if (r36 >= r35) goto L196;
        StackTraceElement[] r110 = r32.getStackTrace();     // Catch: Throwable -> L194
        if (r110 != null) goto L128;
        r110 = new StackTraceElement[0];     // Catch: Throwable -> L194
    L128:
        if (r110.length != 0) goto L130;
        boolean r111 = true;
    L132:
        if (r111 == true) goto L134;
        StackTraceElement r112 = r110[0];
        String r113 = r112.getClassName();
        String r114 = r112.getMethodName();
        LinkedHashMap r115 = r2;
        Iterator r210 = r27;
        if (Intrinsics.areEqual(r113, "sun.misc.Unsafe") == false) goto L145;
        if (Intrinsics.areEqual(r114, "park") == false) goto L145;
    L153:
        int r211 = r29;
        String r212 = r18;
        String r213 = r19;
    L176:
        k r214 = r31;
    L184:
        boolean r37 = true;
    L186:
        if (r37 == false) goto L197;
        ILogDepend.Companion r38 = ILogDepend.a;
        String r39 = "stack top still sleep-like, retry " + (r36 + 1) + '/' + r35 + ", thread=" + r32.getName();
        Throwable r40 = new Throwable();
        r40.setStackTrace(r110);
        Unit r41 = Unit.INSTANCE;
        r38.w("CPUExceptionDiagnosis", r39, r40);
        long r42 = 0;
        if (r36 >= (r35 - 1)) goto L193;
        if (r34 <= 0) goto L193;
        Thread.sleep(r34);
    L193:
        r36 = r36 + 1;
        r2 = r115;
        r27 = r210;
        r18 = r212;
        r29 = r211;
        r19 = r213;
        r31 = r214;
    L197:
        if (r110 != null) goto L199;
        String r43 = r213;
    L238:
        r19 = r43;
        r2 = r115;
        r27 = r210;
        r18 = r212;
        goto L119
    L199:
        if (f.getStackFramePromotionEnabled() == false) goto L229;
        if (r110.length != 0) goto L204;
        boolean r44 = true;
    L205:
        if (r44 == true) goto L229;
        List<String> r45 = f.getStackFrameSkipClassPrefixes();
        int r46 = r110.length;
        int r47 = 0;
    L208:
        if (r47 >= r46) goto L225;
        String r48 = r110[r47].getClassName();
        Iterator<String> r49 = r45.iterator();
    L211:
        if (r49.hasNext() == false) goto L220;
        String r50 = r49.next();
        if (Intrinsics.areEqual(r50, "$") == true) goto L215;
        if (StringsKt.startsWith$default(r48, r50, false, 2, null) == false) goto L211;
    L219:
        boolean r116 = true;
    L222:
        if ((!r116) == true) goto L226;
        r47 = r47 + 1;
    L226:
        if (r47 <= 0) goto L229;
        r110 = (StackTraceElement[]) ArraysKt.plus(new StackTraceElement[]{r110[r47]}, r110);
        goto L229
    L215:
        if (StringsKt.startsWith$default(r48, "$", false, 2, null) == false) goto L211;
    L220:
        r116 = false;
        goto L222
    L225:
        r47 = -1;
        goto L226
    L204:
        r44 = false;
    L229:
        StringBuilder r51 = new StringBuilder("CPUExceptionDiagnosis, thread name: ");
        k r52 = r214;
        r51.append(r52.a);
        r43 = r213;
        r51.append(r43);
        Lazy r53 = i;
        r51.append((String) r53.getValue());
        Throwable r54 = new Throwable(r51.toString());
        r54.setStackTrace(r110);
        ILogDepend.a.w("CPUExceptionDiagnosis", "dump stack as Throwable tid=" + r211 + ", thread name: " + r52.a + r43 + ((String) r53.getValue()), r54);
        if (h == true) goto L233;
        String r55 = "CPU_EXCEPTION_DIAGNOSIS_SCREEN_OFF";
    L236:
        com.bytedance.crash.d.d(r54, r55);
        goto L238
    L233:
        if (g == false) goto L235;
        r55 = "CPU_EXCEPTION_DIAGNOSIS_BACKGROUND";
        goto L236
    L235:
        r55 = "CPU_EXCEPTION_DIAGNOSIS_FOREGROUND";
    L145:
        if (Intrinsics.areEqual(r113, "android.os.MessageQueue") == false) goto L150;
        if (Intrinsics.areEqual(r114, "nativePollOnce") == true) goto L153;
    L150:
        if (Intrinsics.areEqual(r113, "java.lang.Thread") == false) goto L155;
        if (Intrinsics.areEqual(r114, "sleep") == true) goto L153;
    L155:
        if (Intrinsics.areEqual(r113, "java.lang.Object") == false) goto L159;
        Intrinsics.checkNotNull(r114);
        r211 = r29;
        r212 = r18;
        r213 = r19;
        Object r56 = null;
        int r57 = 2;
        boolean r117 = false;
        if (StringsKt.startsWith$default(r114, "wait", false, 2, null) == true) goto L176;
    L161:
        if (Intrinsics.areEqual(r113, "java.util.concurrent.locks.LockSupport") == false) goto L165;
        Intrinsics.checkNotNull(r114);
        if (StringsKt.startsWith$default(r114, "park", r117, r57, r56) == true) goto L176;
    L165:
        Intrinsics.checkNotNull(r113);
        if (StringsKt.startsWith$default(r113, "jdk.internal.misc.Unsafe", r117, r57, r56) == false) goto L171;
        if (Intrinsics.areEqual(r114, "park") == true) goto L176;
    L171:
        if (StringsKt.contains$default(r113, "AbstractQueuedSynchronizer", r117, r57, r56) == false) goto L178;
        Intrinsics.checkNotNull(r114);
        if (StringsKt.contains(r114, "park", true) == true) goto L176;
        if (StringsKt.contains(r114, "await", true) == true) goto L176;
    L178:
        r214 = r31;
        if (StringsKt.contains$default(r113, "AbstractQueuedLongSynchronizer", false, 2, null) == false) goto L185;
        Intrinsics.checkNotNull(r114);
        if (StringsKt.contains(r114, "park", true) == true) goto L184;
        if (StringsKt.contains(r114, "await", true) == true) goto L184;
    L185:
        r37 = false;
        goto L186
    L159:
        r211 = r29;
        r212 = r18;
        r213 = r19;
        r56 = null;
        r57 = 2;
        r117 = false;
        goto L161
    L134:
        if (r36 < (r35 - 1)) goto L136;
    L138:
        ILogDepend.a.d("CPUExceptionDiagnosis", "java stack is empty, retry " + (r36 + 1) + '/' + r35 + ", thread=" + r32.getName());
        r115 = r2;
        r210 = r27;
        r211 = r29;
        r212 = r18;
        r214 = r31;
        r213 = r19;
        r42 = 0;
        goto L193
    L136:
        if (r34 <= 0) goto L138;
        Thread.sleep(r34);
        goto L138
    L130:
        r111 = false;
    L194:
        th = move-exception;
        r115 = r2;
        r210 = r27;
        r211 = r29;
        r212 = r18;
        r214 = r31;
        r213 = r19;
        ILogDepend.a.e("CPUExceptionDiagnosis", "getStackTrace failed, name=" + r32.getName(), th);
        r110 = new StackTraceElement[0];
        goto L197
    L196:
        r115 = r2;
        r210 = r27;
        r211 = r29;
        r212 = r18;
        r214 = r31;
        r213 = r19;
        ILogDepend.a.d("CPUExceptionDiagnosis", "abandon stack after " + r35 + " attempts (still sleep-like), thread=" + r32.getName());
        r110 = null;
        goto L197
    L287:
        return;
    L51:
        if (r6.length != 0) goto L53;
        boolean r58 = true;
    L54:
        if (r58 == true) goto L106;
        com.obric.performance.power.monitor.cpu.a r59 = new com.obric.performance.power.monitor.cpu.a(false, r6, false, 22);
        r59.a();
        Thread.sleep(r8);
        r59.a();
        Map<Integer, Long> r60 = r59.h.j;
        if (r60 == null) goto L70;
        Iterator r61 = MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(r60), new g())).entrySet().iterator();
    L60:
        if (r61.hasNext() == false) goto L70;
        Map.Entry r118 = (Map.Entry) r61.next();
        int r119 = ((Number) r118.getKey()).intValue();
        long r62 = ((Number) r118.getValue()).longValue();
        k r120 = (k) r2.get(Integer.valueOf(r119));
        if (r120 == null) goto L64;
        String r121 = r120.a;
    L65:
        ILogDepend.Companion r63 = ILogDepend.a;
        Iterator r122 = r61;
        StringBuilder r64 = new StringBuilder("enable dump:");
        if (r62 <= r17) goto L68;
        boolean r65 = true;
    L69:
        r64.append(r65);
        r64.append(", tid:");
        r64.append(r119);
        r64.append(", cpuTime:");
        r64.append(r62);
        r64.append(", thread name:");
        r64.append(r121);
        r64.append(", processName: ");
        r64.append((String) i.getValue());
        r63.d("CPUExceptionDiagnosis", r64.toString());
        r61 = r122;
        goto L60
    L68:
        r65 = false;
        goto L69
    L64:
        r121 = null;
    L70:
        ILogDepend.Companion r66 = ILogDepend.a;
        StringBuilder r67 = new StringBuilder("threadCpuMap size: ");
        Map<Integer, Long> r68 = r59.h.j;
        if (r68 == null) goto L73;
        Integer r69 = Integer.valueOf(r68.size());
    L74:
        r67.append(r69);
        r66.d("CPUExceptionDiagnosis", r67.toString());
        Map<Integer, Long> r70 = r59.h.j;
        if (r70 == null) goto L102;
        LinkedHashMap r71 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Long>> r72 = r70.entrySet().iterator();
    L78:
        if (r72.hasNext() == false) goto L91;
        Map.Entry<Integer, Long> r73 = r72.next();
        k r74 = (k) r2.get(Integer.valueOf(r73.getKey().intValue()));
        if (r74 == null) goto L84;
        Thread r75 = r74.b;
        if (r75 == null) goto L84;
        Thread.State r76 = r75.getState();
    L86:
        if (r76 == Thread.State.TERMINATED) goto L88;
        boolean r77 = true;
    L89:
        if (r77 == false) goto L78;
        r71.put(r73.getKey(), r73.getValue());
        goto L78
    L88:
        r77 = false;
    L84:
        r76 = null;
        goto L86
    L91:
        ?? r78 = new LinkedHashMap();
        Iterator r79 = r71.entrySet().iterator();
    L93:
        if (r79.hasNext() == false) goto L103;
        Map.Entry r80 = (Map.Entry) r79.next();
        long r81 = ((Number) r80.getValue()).longValue();
        if (r17 <= r81) goto L97;
    L99:
        boolean r82 = false;
    L100:
        if (r82 == false) goto L93;
        r78.put(r80.getKey(), r80.getValue());
        goto L93
    L97:
        if (r81 > r8) goto L99;
        r82 = true;
    L103:
        boolean r83 = r78.isEmpty();
        r20 = r78;
        if (r83 == false) goto L108;
        ILogDepend.a.d("CPUExceptionDiagnosis", "filteredResult isEmpty");
        r20 = MapsKt.emptyMap();
        goto L108
    L102:
        r78 = MapsKt.emptyMap();
        goto L103
    L73:
        r69 = null;
        goto L74
    L53:
        r58 = false;
        goto L54
    L286:
        return;
    }

    public static void b(CPUExceptionDiagnosisConfig r9, ObricPerformanceMonitorServiceImpl.AnonymousClass1.b r10, ObricPerformanceMonitorServiceImpl.AnonymousClass1.c r11) {
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r10, "appBackgroundDelegate");
        Intrinsics.checkNotNullParameter(r11, "screenStateDelegate");
        if (r9.getEnable() == true) goto L6;
        ILogDepend.a.d("CPUExceptionDiagnosis", "disable, return");
        return;
    L6:
        boolean r1 = false;
        boolean r2 = true;
        if (a.compareAndSet(false, true) == false) goto L40;
        Object r0 = qna.c.a;
        int r4 = qna.a.a;     // Catch: Throwable -> L41
        Field r3 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(Thread.class, new Object[]{"nativePeer"});     // Catch: Throwable -> L13
        r3.setAccessible(true);     // Catch: Throwable -> L13
    L15:
        qna.c.c = r3;     // Catch: Throwable -> L41
        Class r5 = qna.c.a();     // Catch: Throwable -> L41
        qna.c.a = qna.a.a(r5, "getUnsafe", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L41
        Method r6 = qna.a.a(r5, "getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L41
        qna.c.b = r6;     // Catch: Throwable -> L41
        if (qna.c.a == null) goto L21;
        if (r6 == null) goto L21;
        if (qna.c.c == null) goto L21;
    L22:
        if (r2 == false) goto L28;
        PolarisFileWrapper r7 = new PolarisFileWrapper("/proc/self/task/" + qna.c.b(ThreadMethodProxy.currentThread()));
        if (r7.exists() == true) goto L26;
    L29:
        if (r1 == true) goto L32;
        ILogDepend.a.e("CPUExceptionDiagnosis", "reflect fail");
        return;
    L32:
        ILogDepend.a.d("CPUExceptionDiagnosis", "start");
        r10.c(new e());
        r11.b(new f());
        g = r10.a();
        h = r11.a();
        f = r9;
        j r12 = j.a;
        List<String> r13 = f.getThreadFilterExactNames();
        List<String> r14 = f.getThreadFilterNamePrefixes();
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter(r13, "exactNames");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r14, "namePrefixes");     // Catch: Throwable -> L37
        Set<String> r8 = j.c;     // Catch: Throwable -> L37
        r8.clear();     // Catch: Throwable -> L37
        r8.addAll(r13);     // Catch: Throwable -> L37
        Set<String> r15 = j.d;     // Catch: Throwable -> L37
        r15.clear();     // Catch: Throwable -> L37
        r15.addAll(r14);     // Catch: Throwable -> L37
        monitor-exit(r12);
        ((Handler) d.getValue()).postDelayed(j, RangesKt.random(new LongRange(0, f.getPeriodInterval()), kotlin.random.Random.Default));
        return;
    L37:
        th = move-exception;
        throw th;
    L26:
        if (r7.canRead() == false) goto L29;
    L28:
        r1 = r2;
        goto L29
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L41
        r3 = null;
    L21:
        r2 = false;
        goto L22
    }
}

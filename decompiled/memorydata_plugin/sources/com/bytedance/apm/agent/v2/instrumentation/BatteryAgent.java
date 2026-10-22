package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, a> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, b>> sExecutingRecord;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1102b;

        public a() {
            this.f1101a = 0;
            this.f1102b = 0;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f1102b;
        }

        public int a() {
            return this.f1101a;
        }

        public void a(b r7) {
            this.f1101a += b.a(r7);
            this.f1102b = (int) (((long) this.f1102b) + (b.b(r7) - b.c(r7)));
        }

        public int b() {
            return this.f1102b;
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.f1101a + ", cpuCost=" + this.f1102b + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1104b;
        private int c;
        private int d;

        public b() {
            this.f1103a = 0;
            this.f1104b = 0;
            this.c = 0;
            this.d = 0;
        }

        static /* synthetic */ int a(b r0) {
            return r0.d;
        }

        static /* synthetic */ long b(b r2) {
            return r2.f1104b;
        }

        static /* synthetic */ long c(b r2) {
            return r2.f1103a;
        }

        public void a() {
            if (this.d != 0) goto L5;
            this.f1103a = SystemClock.currentThreadTimeMillis();
        L5:
            this.c++;
            this.d++;
        }

        public boolean b() {
            int r0 = this.c - 1;
            this.c = r0;
            if (r0 != 0) goto L6;
            this.f1104b = SystemClock.currentThreadTimeMillis();
            return true;
        L6:
            return false;
        }
    }

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public BatteryAgent() {
    }

    public static void e(String r5) {
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(sExecutingRecord.get(), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r5), b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.b() == false) goto L21;
        r0.remove(r5);
        Map<String, a> r2 = sExecutedRecord;
        monitor-enter(r2);
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r3 != null) goto L15;
        r3 = new a();     // Catch: Throwable -> L18
        r2.put(r5, r3);     // Catch: Throwable -> L18
    L15:
        r3.a(r1);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static Map<String, a> filterResultAndClear(long r7) {
        Map<String, a> r0 = sExecutedRecord;
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        monitor-enter(r0);
        HashMap r1 = new HashMap();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, a>> r2 = r0.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (a.a((a) ZeusTransformUtils.preCheckCast(r3.getValue(), a.class, "com.obric.memorydata.plugin")) <= r7) goto L9;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L16
        goto L9
    L13:
        sExecutedRecord.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    public static void s(String r4) {
        hasHook = true;
        HashMap<String, b> r0 = (HashMap) ZeusTransformUtils.preCheckCast(sExecutingRecord.get(), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new HashMap();
        sExecutingRecord.set(r0);
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r4), b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        r1 = new b();
        r0.put(r4, r1);
    L8:
        r1.a();
    }
}

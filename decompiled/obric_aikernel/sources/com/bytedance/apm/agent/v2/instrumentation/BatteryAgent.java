package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, a> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, b>> sExecutingRecord;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f731b;

        public a() {
            this.f730a = 0;
            this.f731b = 0;
        }

        static /* synthetic */ int a(a r10) {
            return r10.f731b;
        }

        public void b(b r10) {
            this.f730a += b.a(r10);
            this.f731b = (int) (((long) this.f731b) + (b.b(r10) - b.c(r10)));
        }

        public int c() {
            return this.f731b;
        }

        public int d() {
            return this.f730a;
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.f730a + ", cpuCost=" + this.f731b + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f735d;

        public b() {
            this.f732a = 0;
            this.f733b = 0;
            this.f734c = 0;
            this.f735d = 0;
        }

        static /* synthetic */ int a(b r10) {
            return r10.f735d;
        }

        static /* synthetic */ long b(b r10) {
            return r10.f733b;
        }

        static /* synthetic */ long c(b r10) {
            return r10.f732a;
        }

        public void d() {
            if (this.f735d != 0) goto L5;
            this.f732a = SystemClock.currentThreadTimeMillis();
        L5:
            this.f734c++;
            this.f735d++;
        }

        public boolean e() {
            int r10 = this.f734c - 1;
            this.f734c = r10;
            if (r10 != 0) goto L6;
            this.f733b = SystemClock.currentThreadTimeMillis();
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

    @Keep
    public static void e(String r10) {
        HashMap<String, b> r11 = sExecutingRecord.get();
        if (r11 != null) goto L5;
        return;
    L5:
        b r12 = r11.get(r10);
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.e() == false) goto L21;
        r11.remove(r10);
        Map<String, a> r13 = sExecutedRecord;
        monitor-enter(r13);
        a r14 = r13.get(r10);     // Catch: Throwable -> L18
        if (r14 != null) goto L15;
        r14 = new a();     // Catch: Throwable -> L18
        r13.put(r10, r14);     // Catch: Throwable -> L18
    L15:
        r14.b(r12);     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static Map<String, a> filterResultAndClear(long r10) {
        Map<String, a> r11 = sExecutedRecord;
        if (r11.isEmpty() == false) goto L6;
        return null;
    L6:
        monitor-enter(r11);
        HashMap r12 = new HashMap();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, a>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<String, a> r14 = r13.next();     // Catch: Throwable -> L16
        if (a.a(r14.getValue()) <= r10) goto L9;
        r12.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L16
        goto L9
    L13:
        sExecutedRecord.clear();     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r10) {
        hasHook = true;
        HashMap<String, b> r11 = sExecutingRecord.get();
        if (r11 != null) goto L5;
        r11 = new HashMap();
        sExecutingRecord.set(r11);
    L5:
        b r12 = r11.get(r10);
        if (r12 != null) goto L8;
        r12 = new b();
        r11.put(r10, r12);
    L8:
        r12.d();
    }
}

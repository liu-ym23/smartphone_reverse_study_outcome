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
        public int f3739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3740b;

        public a() {
            this.f3739a = 0;
            this.f3740b = 0;
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("MethodExecutedValue{exeCount=");
            r8.append(this.f3739a);
            r8.append(", cpuCost=");
            return android.aimedia.a.f(r8, this.f3740b, '}');
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f3741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3744d;

        public b() {
            this.f3741a = 0;
            this.f3742b = 0;
            this.f3743c = 0;
            this.f3744d = 0;
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
        HashMap<String, b> r8 = sExecutingRecord.get();
        if (r8 != null) goto L5;
        return;
    L5:
        b r11 = r8.get(r10);
        if (r11 != null) goto L8;
        return;
    L8:
        boolean r12 = true;
        int r13 = r11.f3743c - 1;
        r11.f3743c = r13;
        if (r13 != 0) goto L11;
        r11.f3742b = SystemClock.currentThreadTimeMillis();
    L12:
        if (r12 == false) goto L24;
        r8.remove(r10);
        Map<String, a> r14 = sExecutedRecord;
        monitor-enter(r14);
        a r15 = r14.get(r10);     // Catch: Throwable -> L21
        if (r15 != null) goto L18;
        r15 = new a();     // Catch: Throwable -> L21
        r14.put(r10, r15);     // Catch: Throwable -> L21
    L18:
        r15.f3739a += r11.f3744d;     // Catch: Throwable -> L21
        r15.f3740b = (int) ((r11.f3742b - r11.f3741a) + r15.f3740b);     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        return;
    L11:
        r12 = false;
        goto L12
    }

    public static Map<String, a> filterResultAndClear(long r8) {
        HashMap r10 = new HashMap();
        Map<String, a> r11 = sExecutedRecord;
        if (r11.isEmpty() == false) goto L5;
        return r10;
    L5:
        monitor-enter(r11);
        Iterator<Map.Entry<String, a>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, a> r13 = r12.next();     // Catch: Throwable -> L15
        if (r13.getValue().f3740b <= r8) goto L8;
        r10.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L15
        goto L8
    L12:
        sExecutedRecord.clear();     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        return r10;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r8) {
        hasHook = true;
        HashMap<String, b> r10 = sExecutingRecord.get();
        if (r10 != null) goto L5;
        r10 = new HashMap();
        sExecutingRecord.set(r10);
    L5:
        b r11 = r10.get(r8);
        if (r11 != null) goto L9;
        r11 = new b();
        r10.put(r8, r11);
    L9:
        if (r11.f3744d != 0) goto L11;
        r11.f3741a = SystemClock.currentThreadTimeMillis();
    L11:
        r11.f3743c++;
        r11.f3744d++;
    }
}

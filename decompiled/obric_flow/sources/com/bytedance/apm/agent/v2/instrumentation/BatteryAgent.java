package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import u5.a;
import u5.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, a> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, b>> sExecutingRecord;

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public BatteryAgent() {
    }

    @Keep
    public static void e(String r10) {
        HashMap<String, b> r5 = sExecutingRecord.get();
        if (r5 != null) goto L5;
        return;
    L5:
        b r11 = r5.get(r10);
        if (r11 != null) goto L8;
        return;
    L8:
        int r12 = r11.f22257c - 1;
        r11.f22257c = r12;
        if (r12 != 0) goto L22;
        r11.f22256b = SystemClock.currentThreadTimeMillis();
        r5.remove(r10);
        Map<String, a> r13 = sExecutedRecord;
        monitor-enter(r13);
        a r14 = r13.get(r10);     // Catch: Throwable -> L15
        if (r14 != null) goto L17;
        r14 = new a();     // Catch: Throwable -> L15
        r14.f22253a = 0;     // Catch: Throwable -> L15
        r14.f22254b = 0;     // Catch: Throwable -> L15
        r13.put(r10, r14);     // Catch: Throwable -> L15
    L17:
        r14.f22253a += r11.d;     // Catch: Throwable -> L15
        r14.f22254b = (int) ((r11.f22256b - r11.f22255a) + r14.f22254b);     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static Map<String, a> filterResultAndClear(long r10) {
        HashMap r5 = new HashMap();
        Map<String, a> r11 = sExecutedRecord;
        if (r11.isEmpty() == false) goto L5;
        return r5;
    L5:
        monitor-enter(r11);
        Iterator<Map.Entry<String, a>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, a> r13 = r12.next();     // Catch: Throwable -> L12
        if (r13.getValue().f22254b <= r10) goto L8;
        r5.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L12
        goto L8
    L14:
        sExecutedRecord.clear();     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r5) {
        hasHook = true;
        HashMap<String, b> r10 = sExecutingRecord.get();
        if (r10 != null) goto L5;
        r10 = new HashMap();
        sExecutingRecord.set(r10);
    L5:
        b r11 = r10.get(r5);
        if (r11 != null) goto L9;
        r11 = new b();
        r11.f22255a = 0;
        r11.f22256b = 0;
        r11.f22257c = 0;
        r11.d = 0;
        r10.put(r5, r11);
    L9:
        if (r11.d != 0) goto L11;
        r11.f22255a = SystemClock.currentThreadTimeMillis();
    L11:
        r11.f22257c++;
        r11.d++;
    }
}

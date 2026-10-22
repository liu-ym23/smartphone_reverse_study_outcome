package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BinderMonitor extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<a> f2219f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f2220g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f2221h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        StackTraceElement[] f2225d;

        public a() {
        }

        public long a() {
            return this.f2222a;
        }

        public StackTraceElement[] b() {
            return this.f2225d;
        }

        public long c() {
            return this.f2223b;
        }

        public String toString() {
            return "{\"start\":" + this.f2222a + ",\"end\":" + this.f2223b + ",\"parcel_size\":" + this.f2224c + ",\"cost_millis\":" + (this.f2223b - this.f2222a) + ",\"java_stack\":\"" + o.d(BinderMonitor.g(this.f2225d)) + "\"}";
        }
    }

    static {
        f2219f = new ArrayList(200);
        f2220g = new Object();
        f2221h = 0;
    }

    BinderMonitor(int r10) {
        super(r10, "binder_monitor");
    }

    static /* synthetic */ StackTraceElement[] g(StackTraceElement[] r10) {
        return l(r10);
    }

    @Keep
    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static void h(long r10, long r11, long r12, StackTraceElement[] r13) {
        Object r14 = f2220g;
        monitor-enter(r14);
        List<a> r15 = f2219f;     // Catch: Throwable -> L11
        if (r15.size() != 200) goto L7;
        a r16 = r15.get(f2221h % 200);     // Catch: Throwable -> L11
        r16.f2222a = r10;     // Catch: Throwable -> L11
        r16.f2223b = r11;     // Catch: Throwable -> L11
        r16.f2224c = r12;     // Catch: Throwable -> L11
        r16.f2225d = r13;     // Catch: Throwable -> L11
    L8:
        f2221h++;     // Catch: Throwable -> L11
        monitor-exit(r14);     // Catch: Throwable -> L11
        return;
    L7:
        a r17 = new a();     // Catch: Throwable -> L11
        r17.f2222a = r10;     // Catch: Throwable -> L11
        r17.f2223b = r11;     // Catch: Throwable -> L11
        r17.f2224c = r12;     // Catch: Throwable -> L11
        r17.f2225d = r13;     // Catch: Throwable -> L11
        r15.add(r17);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private String i(long r10, long r11) {
        List<a> r12 = k();
        ArrayList r13 = new ArrayList();
        int r14 = r12.size() - 1;
    L3:
        if (r14 < 0) goto L14;
        a r15 = r12.get(r14);
        if (r15.f2222a <= r11) goto L7;
    L8:
        r13.add(r15);
    L10:
        if (r15.f2223b < r10) goto L14;
        r14 = r14 - 1;
        goto L3
    L7:
        if (r15.f2223b <= r10) goto L10;
    L14:
        return r13.toString();
    }

    private static StackTraceElement[] l(StackTraceElement[] r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.length == 0) goto L21;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        if ("saveBinderInfo".equals(r10[r12].getMethodName()) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        r11 = r12;
    L13:
        int r13 = r11 + 1;
        if (r13 <= r10.length) goto L16;
        return r10;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r10, r13, r10.length);
    L21:
        return r10;
    }

    @Keep
    public static void saveBinderInfo(long r10, long r11, long r12) {
        h(r10, r11, r12, Thread.currentThread().getStackTrace());
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> a() {
        return new Pair(this.f2245a, f2219f.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> b(long r10, long r11) {
        return new Pair(this.f2245a, i(r10, r11));
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r10) {
    }

    void j() {
        MonitorJni.enableBinderHook();
    }

    public List<a> k() {
        ArrayList r10 = new ArrayList();
        Object r11 = f2220g;
        monitor-enter(r11);
        int r12 = 0;
    L6:
        if (r12 >= 200) goto L10;
        int r13 = ((f2221h - 1) + r12) % 200;     // Catch: Throwable -> L12
        List<a> r14 = f2219f;     // Catch: Throwable -> L12
        if (r13 >= r14.size()) goto L10;
        r10.add(r14.get(((f2221h - 1) + r12) % 200));     // Catch: Throwable -> L12
        r12 = r12 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r10;
    }
}

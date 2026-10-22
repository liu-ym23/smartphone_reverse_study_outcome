package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BinderMonitor extends b {
    private static final int MAX_INFO_SIZE = 200;
    private static final Object copyLock = null;
    private static final List<a> sBinderInfoList = null;
    private static volatile int sPos;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2820b;
        long c;
        StackTraceElement[] d;

        public a() {
        }

        public long a() {
            return this.f2819a;
        }

        public long b() {
            return this.f2820b;
        }

        public StackTraceElement[] c() {
            return this.d;
        }

        public String toString() {
            return "{\"start\":" + this.f2819a + ",\"end\":" + this.f2820b + ",\"parcel_size\":" + this.c + ",\"cost_millis\":" + (this.f2820b - this.f2819a) + ",\"java_stack\":\"" + o.b(BinderMonitor.access$000(this.d)) + "\"}";
        }
    }

    static {
        sBinderInfoList = new ArrayList(200);
        copyLock = new Object();
        sPos = 0;
    }

    BinderMonitor(int r2) {
        super(r2, "binder_monitor");
    }

    static /* synthetic */ StackTraceElement[] access$000(StackTraceElement[] r0) {
        return removeUselessStackTrace(r0);
    }

    private static void addBinderInfo(long r4, long r6, long r8, StackTraceElement[] r10) {
        Object r0 = copyLock;
        monitor-enter(r0);
        List<a> r1 = sBinderInfoList;     // Catch: Throwable -> L11
        if (r1.size() != 200) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.get(sPos % 200), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r2.f2819a = r4;     // Catch: Throwable -> L11
        r2.f2820b = r6;     // Catch: Throwable -> L11
        r2.c = r8;     // Catch: Throwable -> L11
        r2.d = r10;     // Catch: Throwable -> L11
    L8:
        sPos++;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        a r3 = new a();     // Catch: Throwable -> L11
        r3.f2819a = r4;     // Catch: Throwable -> L11
        r3.f2820b = r6;     // Catch: Throwable -> L11
        r3.c = r8;     // Catch: Throwable -> L11
        r3.d = r10;     // Catch: Throwable -> L11
        r1.add(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private String dumpBinderInfo(long r6, long r8) {
        List<a> r5 = getBinderInfoListCopy();
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L14;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r5.get(r1), a.class, "com.obric.memorydata.plugin");
        if (r2.f2819a <= r8) goto L7;
    L8:
        r0.add(r2);
    L10:
        if (r2.f2820b < r6) goto L14;
        r1 = r1 - 1;
        goto L3
    L7:
        if (r2.f2820b <= r6) goto L10;
    L14:
        return r0.toString();
    }

    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static StackTraceElement[] removeUselessStackTrace(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r4, r2, r4.length), StackTraceElement[].class, "com.obric.memorydata.plugin");
    L21:
        return r4;
    }

    public static void saveBinderInfo(long r8, long r10, long r12) {
        addBinderInfo(r8, r10, r12, Thread.currentThread().getStackTrace());
    }

    void disable() {
        MonitorJni.disableBinderHook();
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> dumpInfo() {
        return new Pair(this.mCollectorType, sBinderInfoList.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> dumpInfosRange(long r3, long r5) {
        return new Pair(this.mCollectorType, dumpBinderInfo(r3, r5));
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    void dumpInfosToALog(long r4, long r6, long r8) {
        d.a r0 = k.a().e();
        if (r0 == null) goto L6;
        String r1 = "perf" + this.mCollectorType;
        r0.a(r1, "begin");
        r0.a(r1, dumpBinderInfo(r4 - r8, r6));
        r0.a(r1, "end");
        return;
    }

    void enable() {
        MonitorJni.enableBinderHook();
    }

    public List<a> getBinderInfoListCopy() {
        ArrayList r6 = new ArrayList();
        Object r0 = copyLock;
        monitor-enter(r0);
        int r1 = 0;
    L6:
        if (r1 >= 200) goto L10;
        int r3 = ((sPos - 1) + r1) % 200;     // Catch: Throwable -> L12
        List<a> r4 = sBinderInfoList;     // Catch: Throwable -> L12
        if (r3 >= r4.size()) goto L10;
        r6.add(r4.get(((sPos - 1) + r1) % 200));     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    }

    @Override // com.bytedance.monitor.collector.b
    public void updateConfig(int r1) {
    }
}

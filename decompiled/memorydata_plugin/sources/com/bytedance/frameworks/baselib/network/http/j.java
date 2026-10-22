package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class j implements RetrofitMetrics.IRequestLogReporterBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j f2448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2449b;
    private static boolean c;

    static {
        f2448a = new j();
        f2449b = false;
        c = false;
    }

    public j() {
    }

    public static void a() {
        RetrofitMetrics.setRequestLogReporterBridge(f2448a);
    }

    private void a(Object r3) {
        if (((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).v == null) goto L6;
        Logger.e("TTNetCallMonitor", "monitor cast error" + ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).v.getPath());
        return;
    }

    public static void a(boolean r0) {
        f2449b = r0;
    }

    public static void b(boolean r0) {
        c = r0;
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public boolean isAllErrorReport() {
        return f.e();
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public void monitorApiError(String r5, Object r6, Throwable r7) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L12
        if (c == false) goto L8;
        if (r0.ac.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f2449b == false) goto L10;
        f.b(r5, r0, r7);     // Catch: ClassCastException -> L12
        return;
    L10:
        f.a(r5, r0, r7);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r6);
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public void monitorApiOk(String r5, Object r6) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L12
        if (c == false) goto L8;
        if (r0.ac.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f2449b == false) goto L10;
        f.b(r5, r0);     // Catch: ClassCastException -> L12
        return;
    L10:
        f.a(r5, r0);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r6);
    }
}

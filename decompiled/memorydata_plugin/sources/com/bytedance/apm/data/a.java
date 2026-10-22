package com.bytedance.apm.data;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.b;
import com.bytedance.apm.e.e;
import com.bytedance.apm.h;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.commonevent.model.TracingData;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.b.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends b> implements com.bytedance.services.slardar.config.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f1274b = 1000;
    private static boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1275a;
    private final LinkedList<T> c;
    private volatile boolean d;
    private volatile boolean e;

    static {
    }

    public a() {
        this.e = false;
        this.f1275a = false;
        this.c = new LinkedList();
    }

    static /* synthetic */ LinkedList a(a r0) {
        return r0.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(a r2, b r3) {
        r2.e((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
    }

    private void a(d r2) {
        if (LogTypeName.MONITOR_TYPE_BATCH_TRACING.equals(r2.c()) == false) goto L5;
        CommonEventDeliverer.monitorTrace(new TracingData(com.bytedance.b.a.a.a(r2.a())));
        return;
    L5:
        CommonEventDeliverer.monitorTrace(new TracingData(r2.a()));
    }

    public static boolean a() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    private void b() {
        com.bytedance.apm.l.b.a().a(new AnonymousClass2(this));
    }

    private void e(T r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (b(r4) == true) goto L5;
        return;
    L5:
        c(r4);
        if (this.d == false) goto L8;
        d(r4);
        return;
    L8:
        f(r4);
    }

    private void f(T r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        LinkedList<T> r0 = this.c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.c.size() <= f1274b) goto L15;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.c.poll(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (f == true) goto L12;
    L22:
        com.bytedance.apm.e.a.b("apm_debug", "apm_cache_buffer_full:" + r1.a().toString());     // Catch: Exception -> L21 Throwable -> L18
        goto L15
    L12:
        if (this.e == true) goto L22;
        h.a().a("apm_cache_buffer_full");     // Catch: Throwable -> L18
        this.e = true;     // Catch: Throwable -> L18
    L15:
        this.c.add((T) r7);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public final void a(T r3) {
        final b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (com.bytedance.apm.l.b.a().b() == true) goto L5;
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this, r4));
        return;
    L5:
        e(r4);
    }

    public void a(String r5, String r6, JSONObject r7, boolean r8, boolean r9) {
        if (com.bytedance.apm.b.k() == false) goto L5;
        e.d("BaseDataPipeline", new String[]{"type:" + r5 + " isSaveUnSampleLog:" + r9 + "isSampled:" + r8 + " log:" + r7});
    L5:
        if (r8 == false) goto L19;
        if (this.f1275a == false) goto L9;
        JSONObject r10 = JsonUtils.e(r7);
    L11:
        if (TextUtils.equals(r5, "tracing") == false) goto L14;
        a(new d(r10, null, false, r6));
    L28:
        com.bytedance.apm.g.a.a().a(r5, r6, r7);
        if (TextUtils.equals(r5, LogTypeName.MONITOR_LOG_TYPE_UI_ACTION) == false) goto L34;
        com.bytedance.apm.data.b.a.a().a(r7);
        return;
    L34:
        return;
    L14:
        if (TextUtils.equals(r5, LogTypeName.MONITOR_LOG_TYPE_COMMON_LOG) == false) goto L16;
        GeneralLegacyEvent r4 = new GeneralLegacyEvent(r6, r10);
    L17:
        CommonEventDeliverer.monitorLegacyEvent(r4);
        goto L28
    L16:
        r4 = new GeneralLegacyEvent(r5, r10);
        goto L17
    L9:
        r10 = JsonUtils.c(r7);
        goto L11
    L19:
        if (com.bytedance.apm.b.k() == false) goto L21;
        com.bytedance.apm.doctor.a.a(r5, r7, false);
    L21:
        if (r9 == false) goto L28;
        if (com.bytedance.apm.e.a.b() == false) goto L28;
        com.bytedance.apm.e.a.d(r5, r7.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "apm_unsampled_log_error");
        goto L28
    }

    public boolean b(T r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        return true;
    }

    public void c(T r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    public abstract void d(T r1);

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
        this.d = true;
        b();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
    }
}

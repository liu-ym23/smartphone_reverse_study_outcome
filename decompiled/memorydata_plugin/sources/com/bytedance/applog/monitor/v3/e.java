package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.impl.LatencyMonitor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1694a = null;
    private static final String l = null;
    private static int o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f1695b;
    private final com.bytedance.applog.monitor.v3.impl.a c;
    private final com.bytedance.applog.monitor.v3.impl.c d;
    private final com.bytedance.applog.monitor.v3.impl.d e;
    private final LatencyMonitor f;
    private final com.bytedance.applog.monitor.v3.impl.b g;
    private final JSONObject h;
    private Handler i;
    private d j;
    private final com.bytedance.applog.monitor.b.a k;
    private final AtomicBoolean m;
    private final JSONObject n;

    static {
        f1694a = Collections.singletonList("MonitorV3Helper");
        l = UUID.randomUUID().toString();
        o = 3590;
    }

    public e() {
        b r0 = new b();
        this.f1695b = r0;
        this.c = new com.bytedance.applog.monitor.v3.impl.a(r0);
        this.d = new com.bytedance.applog.monitor.v3.impl.c(r0);
        this.e = new com.bytedance.applog.monitor.v3.impl.d(r0);
        this.f = new LatencyMonitor(r0);
        this.g = new com.bytedance.applog.monitor.v3.impl.b(r0);
        this.h = new JSONObject();
        this.k = new com.bytedance.applog.monitor.b.a();
        this.m = new AtomicBoolean(false);
        this.n = new JSONObject();
        d("cold_start_id", l);
    }

    static /* synthetic */ d a(e r0) {
        return r0.j;
    }

    static /* synthetic */ JSONObject b(e r0) {
        return r0.h;
    }

    static /* synthetic */ JSONObject c(e r0) {
        return r0.n;
    }

    static /* synthetic */ com.bytedance.applog.monitor.v3.impl.c d(e r0) {
        return r0.d;
    }

    static /* synthetic */ com.bytedance.applog.monitor.v3.impl.d e(e r0) {
        return r0.e;
    }

    static /* synthetic */ com.bytedance.applog.monitor.v3.impl.a f(e r0) {
        return r0.c;
    }

    static /* synthetic */ LatencyMonitor g(e r0) {
        return r0.f;
    }

    static /* synthetic */ com.bytedance.applog.monitor.v3.impl.b h(e r0) {
        return r0.g;
    }

    static /* synthetic */ List j() {
        return f1694a;
    }

    private void k() {
        if (c() == false) goto L15;
        d r0 = this.j;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.c() != null) goto L9;
        return;
    L9:
        if (this.j.e() != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.j.d()) == true) goto L19;
        q.a().b(8, f1694a, "start doReport...", new Object[0]);
        final long r4 = this.f1695b.b();
        final int r3 = this.f1695b.c();
        final INetworkClient r6 = this.j.c();
        final String r7 = this.j.d();
        this.j.e().submit(new AnonymousClass2(this, r3, r4, r6, r7));
        this.i.removeMessages(1);
        this.i.sendEmptyMessageDelayed(1, this.f1695b.f());
        return;
    L19:
        return;
    }

    public b a() {
        return this.f1695b;
    }

    public void a(int r7, StageEventType r8, int r9) {
        if (h() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "onLatency {} -> {}", new Object[]{Integer.valueOf(r7), Integer.valueOf(r9)});
        this.f.a(r7, r8, r9);
    }

    public void a(EventStage r10, String r11, String r12, long r13, StageEventType r15) {
        a(null, -1, r10, r11, r12, r13, r15);
    }

    public void a(StatsCountKeys r2) {
        a(r2, 1);
    }

    public void a(StatsCountKeys r7, int r8) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "increaseStats {} +{}", new Object[]{r7, Integer.valueOf(r8)});
        this.e.a(r7.name(), r8);
    }

    public void a(d r8) {
        q.a().b(8, f1694a, "init monitor v3 helper with config: {}", new Object[]{r8});
        if (this.m.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.j = r8;
        c r0 = r8.a();
        if (this.f1695b.a() == true) goto L8;
    L31:
        this.c.a();
        this.d.a();
        this.e.a();
        this.f.a();
        this.g.b();
        return;
    L8:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L31;
        if (r0 == null) goto L31;
        d("aid", String.valueOf(o));
        d("host_aid", r0.a());
        d("channel", r0.b());
        d(Cdid.KEY_CDID, r0.k());
        d("sdk_version_v2", r0.j());
        d("os", LocationInfoConst.SYSTEM);
        d("os_version", Build.VERSION.RELEASE);
        d(Api.KEY_APP_NAME, r0.d());
        d("app_version", r0.c());
        d("update_version_code", String.valueOf(r0.e()));
        if (r0.f() == false) goto L15;
        a("log_enable", 1);
    L15:
        if (r0.l() == false) goto L18;
        a("devtools_enable", 1);
    L18:
        if (r0.g() == false) goto L21;
        a("tourist_mode", 1);
    L21:
        if (r0.h() == false) goto L24;
        a("frequency_control_enable", 1);
    L24:
        if (r0.i() == false) goto L27;
        a("log_event_filter_enable", 1);
    L27:
        if (e() == false) goto L29;
        a("debug_mode", 1);
    L29:
        a("report_interval", r8.b());
        String r1 = r0.a();
        this.f1695b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1);
        HandlerThread r4 = new HandlerThread(r0.a() + "@applog_monitor_v3");
        final Thread.UncaughtExceptionHandler r2 = r4.getUncaughtExceptionHandler();
        r4.setUncaughtExceptionHandler(new AnonymousClass1(this, r2));
        r4.start();
        Handler r3 = new Handler(r4.getLooper(), this);
        this.i = r3;
        r3.sendEmptyMessageDelayed(1, this.f1695b.g());
        this.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r1);
        this.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r1);
        this.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r1);
        this.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r1);
    }

    public void a(String r2) {
        a(r2, 1);
    }

    public void a(String r7, int r8) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "increaseStats {} +{}", new Object[]{r7, Integer.valueOf(r8)});
        this.e.a(r7, r8);
    }

    public void a(String r16, int r17, EventStage r18, String r19, String r20, long r21, StageEventType r23) {
        if (d() == true) goto L5;
        return;
    L5:
        this.k.a(r16, r17, r18, r19, r20, r21, r23);
        q.a().b(8, f1694a, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", new Object[]{r18, r19, r20, Long.valueOf(r21), r23, r16, Integer.valueOf(r17)});
        this.d.a(r16, r17, r18, r19, r20, r21, r23);
    }

    public void a(String r8, long r9) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setFeature int {} = {}", new Object[]{r8, Long.valueOf(r9)});
        JSONObject r0 = this.n;
        monitor-enter(r0);
        this.n.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        q.a().b(8, f1694a, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void a(String r6, String r7) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setHeader {} = {}", new Object[]{r6, r7});
        this.h.put(r6, r7);     // Catch: Throwable -> L8
        return;
    }

    public void a(String r2, Throwable r3) {
        a(r2, r3, true);
    }

    public void a(String r6, Throwable r7, boolean r8) {
        if (g() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "sendError {} -> {}", new Object[]{r6, r7});
        this.c.a(r6, r7);
        if (r8 == false) goto L9;
        com.bytedance.applog.monitor.exception.b.a().a(r6, r7);
        return;
    }

    public void a(String r8, JSONObject r9) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setFeature json {} = {}", new Object[]{r8, r9});
        JSONObject r0 = this.n;
        monitor-enter(r0);
        this.n.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        q.a().b(8, f1694a, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void a(String r8, boolean r9) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setFeature boolean {} = {}", new Object[]{r8, Boolean.valueOf(r9)});
        JSONObject r0 = this.n;
        monitor-enter(r0);
        JSONObject r7 = this.n;     // Catch: Throwable -> L13
        if (r9 == false) goto L10;
        int r10 = 1;
    L11:
        r7.put(r8, r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L10:
        r10 = 0;
    L17:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        q.a().b(8, f1694a, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L17
        goto L15
    }

    public void b() {
        if (this.i != null) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "monitor flush...", new Object[0]);
        this.i.removeMessages(1);
        this.i.sendEmptyMessageDelayed(1, 500);
    }

    public void b(String r8, String r9) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setFeature string {} = {}", new Object[]{r8, r9});
        JSONObject r0 = this.n;
        monitor-enter(r0);
        this.n.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        q.a().b(8, f1694a, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public boolean b(String r2) {
        if (d() == true) goto L7;
        return false;
    L7:
        return this.d.a(r2);
    }

    public com.bytedance.applog.monitor.a.a c(String r2, String r3) {
        if (i() == true) goto L7;
        return com.bytedance.applog.monitor.a.a.f1668a;
    L7:
        return new com.bytedance.applog.monitor.a.b(this.g, r2, r3);
    }

    public boolean c() {
        return this.f1695b.a();
    }

    public boolean c(String r2) {
        if (d() == true) goto L7;
        return false;
    L7:
        return this.d.b(r2);
    }

    public void d(String r6, String r7) {
        if (c() == true) goto L5;
        return;
    L5:
        q.a().b(8, f1694a, "setStringHeader {}: {}", new Object[]{r6, r7});
        this.h.put(r6, r7);     // Catch: Throwable -> L8
        return;
    }

    public boolean d() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1695b.i() == false) goto L7;
        return true;
    }

    public boolean e() {
        return this.f1695b.l();
    }

    public boolean f() {
        if (d() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.d.b() == false) goto L7;
        return true;
    }

    public boolean g() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1695b.d() == false) goto L7;
        return true;
    }

    public boolean h() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1695b.e() == false) goto L7;
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 1) goto L8;
        k();
        return false;
    L8:
        return false;
    }

    public boolean i() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g.a() == false) goto L7;
        return true;
    }
}

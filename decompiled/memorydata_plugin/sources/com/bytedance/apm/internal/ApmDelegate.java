package com.bytedance.apm.internal;

import android.content.Context;
import com.bytedance.apm.block.a.f;
import com.bytedance.apm.block.g;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.config.c;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.monitor.collector.j;
import com.bytedance.monitor.collector.k;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements com.bytedance.services.slardar.config.a {
    private static long i;
    private static boolean j;
    private static boolean k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.config.b f1380b;
    private c c;
    private com.bytedance.apm.d.b d;
    private e e;
    private SlardarConfigManagerImpl f;
    private volatile boolean g;
    private boolean h;
    private boolean l;

    /* JADX INFO: renamed from: com.bytedance.apm.internal.ApmDelegate$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.config.b f1381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f1382b;
        final /* synthetic */ Runnable c;
        final /* synthetic */ ApmDelegate d;

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.d).registerConfigListener(ApmDelegate.a());
            com.bytedance.apm.trace.b.a(this.f1381a.f());
            com.bytedance.apm.trace.b.a(this.f1381a.g());
            com.bytedance.apm.internal.a.a(this.f1382b);
            com.bytedance.apm.c r0 = com.bytedance.apm.b.d();
            if (r0 == null) goto L6;
            r0.a();
        L6:
            if (ApmDelegate.b(this.d) == false) goto L20;
            f.a().b();
            j.a r1 = new j.a();
            j.a r2 = r1.a(com.bytedance.apm.internal.a.b());
            if (com.bytedance.apm.internal.a.b() != 0) goto L10;
        L12:
            boolean r3 = false;
        L13:
            j.a r4 = r2.b(r3);
            if (this.f1381a.e() == true) goto L16;
        L18:
            boolean r5 = false;
        L19:
            r4.c(r5).e(com.bytedance.apm.internal.a.b(64)).a(false).d(!ApmDelegate.c(this.d).d()).a(com.bytedance.apm.internal.a.c());
            k.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1.a());
            k.a().h();
            k.a().a(ApmDelegate.c(this.d).c());
        L21:
            g.a().b();
            Runnable r6 = this.c;
            if (r6 == null) goto L25;
            r6.run();
        L25:
            if (com.bytedance.apm.b.k() == false) goto L32;
            DoctorManager r7 = DoctorManager.getInstance();
            if (ApmDelegate.b(this.d) == false) goto L29;
            String r8 = "APM_INIT_ASYNC";
        L30:
            r7.a(r8, "done");
            return;
        L29:
            r8 = "APM_INIT_ASYNC_OTHER_PROCESS";
            goto L30
        L32:
            return;
        L16:
            if (com.bytedance.apm.internal.a.b(2) == false) goto L18;
            r5 = true;
            goto L19
        L10:
            if (com.bytedance.apm.internal.a.b(2) == false) goto L12;
            r3 = true;
            goto L13
        L20:
            k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.internal.ApmDelegate$7, reason: invalid class name */
    class AnonymousClass7 implements IHttpService {
        final /* synthetic */ ApmDelegate this$0;

        AnonymousClass7(ApmDelegate r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public com.bytedance.services.apm.api.g buildMultipartUpload(String r1, String r2, boolean r3) {
            return com.bytedance.apm.b.a(r1, r2, r3);
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public com.bytedance.services.apm.api.g buildMultipartUpload(String r2, String r3, boolean r4, Map<String, String> r5) {
            return com.bytedance.apm.b.a(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public com.bytedance.services.apm.api.c doGet(String r2, Map<String, String> r3) {
            return com.bytedance.apm.b.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public com.bytedance.services.apm.api.c doPost(String r2, byte[] r3, Map<String, String> r4) {
            return com.bytedance.apm.b.a(r2, r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.services.apm.api.IHttpService
        public com.bytedance.services.apm.api.c uploadFiles(String r2, List<File> r3, Map<String, String> r4) {
            return com.bytedance.apm.b.a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ApmDelegate f1384a = null;

        static {
            f1384a = new ApmDelegate(null);
        }

        static /* synthetic */ ApmDelegate a() {
            return f1384a;
        }
    }

    private ApmDelegate() {
        this.f1379a = false;
        this.l = true;
    }

    /* synthetic */ ApmDelegate(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ SlardarConfigManagerImpl a(ApmDelegate r0) {
        return r0.f;
    }

    public static ApmDelegate a() {
        return a.a();
    }

    static /* synthetic */ boolean b(ApmDelegate r0) {
        return r0.h;
    }

    static /* synthetic */ com.bytedance.apm.config.b c(ApmDelegate r0) {
        return r0.f1380b;
    }

    private void d() {
        if (this.f1379a == false) goto L5;
        return;
    L5:
        this.f1379a = true;
        com.bytedance.apm.l.a.a().post(new AnonymousClass2(this));
        com.bytedance.apm.block.b r0 = new com.bytedance.apm.block.b();
        r0.a(this.c.d());
        r0.b(this.c.b());
        r0.c(this.c.c());
        r0.a(this.c.h());
        r0.b();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r0.c();
    L8:
        r0.a(this.f1380b.i());
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        com.bytedance.perf.monitor.a.a(i);
        com.bytedance.perf.monitor.a.a(j);
        com.bytedance.perf.monitor.a.f2970a = true;
        f.a().c();
        com.bytedance.apm.block.a.g.a().b();
        new com.bytedance.perf.monitor.a(k).b();
        k.a().b(true);
    }

    public boolean a(String r2) {
        if (this.g == false) goto L9;
        SlardarConfigManagerImpl r1 = this.f;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getLogTypeSwitch(r2);
    L9:
        return false;
    }

    public com.bytedance.apm.config.b b() {
        com.bytedance.apm.config.b r0 = this.f1380b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.bytedance.apm.config.b.h().a();
    }

    public e c() {
        return this.e;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
        boolean r0 = true;
        this.g = true;
        com.bytedance.apm.d.b r1 = this.d;
        if (r1 == null) goto L5;
        r1.a();
    L5:
        JSONObject r2 = this.f.getConfig();
        if (this.h == false) goto L14;
        new com.bytedance.apm.h.g().j();
        if (JsonUtils.a(r2, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "traffic", SlardarSettingsConstants.PERF_KEY_ENABLE_COLLECT) != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        com.bytedance.apm.h.b.f.a().j();
        goto L14
    L10:
        r3 = false;
    L14:
        if (this.c.e() == false) goto L40;
        if (JsonUtils.a(r2, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD) != 1) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        com.bytedance.apm.battery.e.a();
    L21:
        if (r5 == false) goto L23;
    L24:
        com.bytedance.apm.battery.e.a(this.c.f());
    L26:
        if (JsonUtils.a(r2, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, "power_monitor_enable") != 1) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L32;
        com.bytedance.apm.battery.e.b();
    L32:
        if (JsonUtils.a(r2, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, "temperature_enable_upload") == 1) goto L35;
        r0 = false;
    L35:
        if (r0 == false) goto L37;
    L38:
        com.bytedance.apm.battery.e.b(this.c.g());
        goto L40
    L37:
        if (this.c.g() == false) goto L40;
    L28:
        r6 = false;
        goto L29
    L23:
        if (this.c.f() == false) goto L26;
    L18:
        r5 = false;
    L40:
        if (this.c.a() == true) goto L42;
        return;
    L42:
        if (com.bytedance.apm.h.c.a().a(LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L46;
        d();
        return;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r2, boolean r3) {
        JSONObject r4 = r2.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        if (r4 == null) goto L5;
        this.l = r4.optBoolean("enable_active_upload_alog", true);
        return;
    L5:
        this.l = true;
    }
}

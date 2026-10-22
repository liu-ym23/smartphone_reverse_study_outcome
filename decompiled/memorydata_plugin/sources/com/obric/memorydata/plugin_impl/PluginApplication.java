package com.obric.memorydata.plugin_impl;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.obric.memorydata.f;
import com.obric.memorydata.init.tasks.a.c;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin_api.MemoryPluginActiveState;
import com.obric.memorydata.utils.an;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusApplication;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/plugin_impl/PluginApplication;", "Landroid/app/Application;", "<init>", "()V", "pluginContext", "Landroid/content/Context;", "getPluginContext", "()Landroid/content/Context;", "setPluginContext", "(Landroid/content/Context;)V", "mainHandler", "Landroid/os/Handler;", "attachBaseContext", "", "base", "onCreate", "Companion", "plugin-impl_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PluginApplication extends ZeusApplication {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f12422b;
    private final Handler c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/plugin_impl/PluginApplication$Companion;", "", "<init>", "()V", "TAG", "", "PLUGIN_PKG_NAME", "plugin-impl_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12421a = new a(null);
    }

    public PluginApplication() {
        this.c = new Handler(Looper.getMainLooper());
    }

    private static final void a(PluginApplication r3, Application r4) {
        PluginApplication r5 = (PluginApplication) ZeusTransformUtils.wrapperContextForParams(r3, PluginApplication.class, "com.obric.memorydata.plugin");
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        MemoryPluginActiveState.init();
        f r0 = f.f9869a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6);
        r0.a(r7, r6);
    }

    /* JADX INFO: renamed from: lambda$DRCiDNtf-amTJQB9mw7m-3RQeL0, reason: not valid java name */
    public static /* synthetic */ void m1105lambda$DRCiDNtfamTJQB9mw7m3RQeL0(PluginApplication r0, Application r1) {
        a(r0, r1);
    }

    public final Context a() {
        Context r0 = this.f12422b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f12422b = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    public void attachBaseContext(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "base");
        if (an.f13171a.b(r11) == true) goto L7;
        RunLog.INSTANCE.debug("PluginApplication", "非 memorydata 进程，跳过插件 attachBaseContext 初始化");
    L5:
        super.attachBaseContext(r11);
        return;
    L7:
        a(r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginApplication", "attachBaseContext", false, 4, null);
        AppContext r0 = AppContext.INSTANCE;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getAppApplication(...)");
        r0.setApplicationContext(r1, r11);
        c.f9915a.a();
        long r2 = SystemClock.uptimeMillis();
        com.obric.memorydata.plugin_impl.a.f12423a.a(r11);
        RunLog.INSTANCE.debug("PluginApplication", "data migration already finish, duration = " + (SystemClock.uptimeMillis() - r2));
        goto L5
    }

    public void onCreate() {
        super.onCreate();
        if (an.f13171a.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) == true) goto L6;
        RunLog.INSTANCE.debug("PluginApplication", "非 memorydata 进程，跳过插件 onCreate 初始化");
        return;
    L6:
        final Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        SharedStateLogger.INSTANCE.setDebug(AppContext.INSTANCE.isDebug());
        SharedState r1 = SharedState.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.init((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        if (com.obric.aiagent.assistant.utils.a.f5901a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) == DefaultAssistantStatus.IsDefaultAssistant) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginApplication", "NotRoleAssistant, kill process", false, 4, null);
        Process.killProcess(Process.myPid());
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PluginApplication", "onCreate", false, 4, null);
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L13;
        com.obric.memorydata.init.tasks.a.f9911a.a();
    L13:
        this.c.post(new $$Lambda$PluginApplication$DRCiDNtfamTJQB9mw7m3RQeL0(this, r0));
        SharedState.INSTANCE.putInt("zeus_memory_version", Zeus.getPlugin("com.obric.memorydata.plugin").getVersion());
    }
}

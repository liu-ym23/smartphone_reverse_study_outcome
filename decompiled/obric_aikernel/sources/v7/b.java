package v7;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import c4.d;
import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.obric.aikernel.api.configs.FeatureGetterConfig;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.commonmonitor.IApmManager;
import com.obric.aikernel.middleware.api.commonmonitor.ReportScene;
import com.obric.aikernel.runtime.utils.e;
import com.obric.aikernel.utils.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Application implements m7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m7.a f13191c;

    public b() {
        this.f13191c = new c();
    }

    public static /* synthetic */ ILaunchTrace b() {
        return e();
    }

    private final void d() {
        d.c(ILaunchTrace.class, a.f13190a);
    }

    private static final ILaunchTrace e() {
        return new LaunchTraceImpl();
    }

    @Override // m7.a
    public void a(InitPeriod r10) {
        Intrinsics.checkNotNullParameter(r10, "initPeriod");
        c().a(r10);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "base");
        if (e.f5420a.c(r10) == false) goto L17;
        AppContext r11 = AppContext.INSTANCE;
        if (r11.testStubApp() == true) goto L17;
        d();
        IApmManager r12 = o7.a.a();
        if (r12 == null) goto L10;
        r12.startTrace();
    L10:
        IApmManager r13 = o7.a.a();
        if (r13 == null) goto L13;
        r13.startSpan("Application_attachBaseContext");
    L13:
        String r14 = ya.a.a(r10);
        boolean r15 = m.f5603a.a(r10);
        r11.setApplicationContext(this, r10);
        com.obric.aikernel.api.b.f4431a.k(FeatureGetterConfig.f4440a.a());
        Intrinsics.checkNotNullExpressionValue(r14, "processName");
        InitScheduler.config(new TaskConfig.Builder(r10, r15, r14).isDebug(r11.isDebug()).setTimeOut(60000).build());
        InitScheduler.initTasks();
        c().a(InitPeriod.APP_ATTACHBASE2SUPER);
        super.attachBaseContext(r10);
        c().a(InitPeriod.APP_SUPER2ATTACHBASEEND);
        IApmManager r16 = o7.a.a();
        if (r16 == null) goto L19;
        IApmManager.a.a(r16, "Application_attachBaseContext", false, 2, null);
        return;
    L19:
        return;
    L17:
        AppContext.INSTANCE.setApplicationContext(this, r10);
        super.attachBaseContext(r10);
    }

    protected m7.a c() {
        return this.f13191c;
    }

    @Override // android.app.Application
    public void onCreate() {
        e r10 = e.f5420a;
        Context r11 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r11, "applicationContext");
        if (r10.c(r11) == false) goto L21;
        AppContext r12 = AppContext.INSTANCE;
        if (r12.testStubApp() == true) goto L21;
        IApmManager r13 = o7.a.a();
        if (r13 == null) goto L10;
        r13.startSpan("Application_onCreate");
    L10:
        c().a(InitPeriod.APP_ONCREATE2SUPER);
        super.onCreate();
        c().a(InitPeriod.APP_SUPER2ONCREATEEND);
        IApmManager r14 = o7.a.a();
        if (r14 == null) goto L13;
        IApmManager.a.a(r14, "Application_onCreate", false, 2, null);
    L13:
        IApmManager r15 = o7.a.a();
        if (r15 == null) goto L16;
        r15.endTrace();
    L16:
        IApmManager r16 = o7.a.a();
        if (r16 == null) goto L19;
        r16.reportThreadCount(ReportScene.app_start.getPrefix());
    L19:
        com.obric.aikernel.api.base.c r17 = com.obric.aikernel.api.b.f4431a.d();
        Context r18 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r18, "applicationContext");
        r17.a(r18);
        Log.d("BaseApplication", "onCreate " + r12.getAIKTargetSoC() + ", " + r12.getChannel() + ' ' + r12.getVersionCode() + ' ' + r12.getAIKBizType());
        return;
    L21:
        super.onCreate();
    }
}

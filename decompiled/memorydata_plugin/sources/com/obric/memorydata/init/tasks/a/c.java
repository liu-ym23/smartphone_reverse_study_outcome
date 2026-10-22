package com.obric.memorydata.init.tasks.a;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.platform.a.e;
import com.obric.aiagent.platform.a.f;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/init/tasks/platform/ObricPlatform;", "", "<init>", "()V", "inited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f9916b;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/platform/ObricPlatform$init$1", "Lcom/obric/aiagent/platform/IAIAgentPlatform;", "getAppContext", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getCloudConfig", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "getLogger", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.aiagent.platform.b {

        /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.a.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/init/tasks/platform/ObricPlatform$init$1$getAppContext$1", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getAppName", "", "getAppStringName", "getApplication", "Landroid/app/Application;", "getVersionCode", "", "getVersionName", "isDebug", "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0478a implements com.obric.aiagent.platform.a.a {
            C0478a() {
            }

            @Override // com.obric.aiagent.platform.a.a
            public Application a() {
                Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.debug("Memory_ObricPlatform", "product-platform init app=" + r3);
                return r3;
            }

            @Override // com.obric.aiagent.platform.a.a
            public String b() {
                return com.obric.aiagent.platform.a.a.b.a(this);
            }

            @Override // com.obric.aiagent.platform.a.a
            public int c() {
                return AppContext.INSTANCE.getVersionCode();
            }

            @Override // com.obric.aiagent.platform.a.a
            public String d() {
                return AppContext.INSTANCE.getVersionName();
            }

            @Override // com.obric.aiagent.platform.a.a
            public boolean e() {
                return com.obric.aiagent.platform.a.a.b.b(this);
            }

            @Override // com.obric.aiagent.platform.a.a
            public boolean f() {
                return com.obric.aiagent.platform.a.a.b.c(this);
            }

            @Override // com.obric.aiagent.platform.a.a
            public Context getContext() {
                return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.aiagent.platform.a.a.b.getContext(this), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            }
        }

        a() {
        }

        @Override // com.obric.aiagent.platform.b
        public com.obric.aiagent.platform.a.a a() {
            return (com.obric.aiagent.platform.a.a) ZeusTransformUtils.preCheckCast(new C0478a(), com.obric.aiagent.platform.a.a.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.platform.b
        public com.obric.aiagent.platform.a.b b() {
            return com.obric.aiagent.platform.b.C0242b.a(this);
        }

        @Override // com.obric.aiagent.platform.b
        public d c() {
            return (d) ZeusTransformUtils.preCheckCast(com.obric.memorydata.init.tasks.a.a.f9913b, d.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.platform.b
        public e d() {
            return com.obric.aiagent.platform.b.C0242b.b(this);
        }

        @Override // com.obric.aiagent.platform.b
        public f e() {
            return com.obric.aiagent.platform.b.C0242b.c(this);
        }

        @Override // com.obric.aiagent.platform.b
        public com.obric.aiagent.platform.a.c f() {
            return (com.obric.aiagent.platform.a.c) ZeusTransformUtils.preCheckCast(b.f9914b, com.obric.aiagent.platform.a.c.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f9915a = new c();
        f9916b = new AtomicBoolean(false);
    }

    private c() {
    }

    public final void a() {
        if (f9916b.get() == false) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "Memory_ObricPlatform";
        String r2 = "inited=true, method return";
    L5:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return;
    L7:
        RunLog.INSTANCE.debug("Memory_ObricPlatform", "product-platform init start");
        f9916b.set(true);
        com.obric.aiagent.product.b.f5974a.a((com.obric.aiagent.platform.b) ZeusTransformUtils.preCheckCast(new a(), com.obric.aiagent.platform.b.class, "com.obric.memorydata.plugin"));
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = "product-platform init success | process: " + Process.myPid();
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "Memory_ObricPlatform";
        goto L5
    }
}

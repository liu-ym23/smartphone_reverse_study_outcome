package com.obric.memorydata.personalcontext;

import android.app.Application;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/AtomicCapability;", "", "<init>", "()V", "isInited", "", "()Z", "setInited", "(Z)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "setAtomicCapabilitySdkLogger", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12048b;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/personalcontext/AtomicCapability$setAtomicCapabilitySdkLogger$1", "Lcom/obric/capabilitykit/logger/ILogger;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", "isDebug", "", BaseSwitches.V, "w", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ILogger {
        a() {
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            RunLog.INSTANCE.debug(r1, String.valueOf(r2));
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void e(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, String.valueOf(r8), null, 4, null);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            RunLog.INSTANCE.error(r1, String.valueOf(r2), r3);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void i(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, String.valueOf(r8), false, 4, null);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public boolean isDebug() {
            return true;
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void v(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            RunLog.INSTANCE.debug(r1, String.valueOf(r2));
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, String.valueOf(r8), null, 4, null);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            RunLog.INSTANCE.warn(r1, String.valueOf(r2), r3);
        }

        @Override // com.obric.capabilitykit.logger.ILogger
        public void w(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            RunLog.INSTANCE.warn(r2, "", r3);
        }
    }

    static {
        f12047a = new c();
    }

    private c() {
    }

    private final void b() {
        AtomicCapabilitySdk.setLogger((ILogger) ZeusTransformUtils.preCheckCast(new a(), ILogger.class, "com.obric.memorydata.plugin"));
    }

    public final void a() {
        if (f12048b == false) goto L5;
        return;
    L5:
        f12048b = true;
        RunLog.INSTANCE.debug("AtomicCapability", "init AtomicCapabilitySdk");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Application");
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(r1, Application.class, "com.obric.memorydata.plugin");
        EntitySupplier r5 = null;
        String r6 = null;
        EntitySyncDataSupplier r7 = null;
        AtomicCapabilitySdk.init(new AtomicCapabilitySdk.InitConfig(r4, r5, r6, r7, 32, 14, null));
        b();
        h.f12183a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        e.f12095a.a();
    }
}

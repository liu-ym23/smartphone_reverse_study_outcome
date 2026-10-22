package com.obric.memorydata.init.tasks;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/init/tasks/AIKernel;", "", "<init>", "()V", "inited", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9912b;

    /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/init/tasks/AIKernel$init$1", "Lcom/obric/aikernel/core/log/ILog;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "t", "", "i", "isDebug", "", BaseSwitches.V, "w", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0477a implements ILog {
        C0477a() {
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void e(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
            RunLog.INSTANCE.error(r1, r2, r3);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void i(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public boolean isDebug() {
            return AppContext.INSTANCE.isDebug();
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void v(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void w(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
            RunLog.INSTANCE.warn(r1, r2, r3);
        }
    }

    static {
        f9911a = new a();
    }

    private a() {
    }

    private static final int b() {
        return !DeviceInfoState.INSTANCE.isSupportVLMEmbedding() ? 1 : 0;
    }

    public static /* synthetic */ int lambda$YdJHAeeP_ofMn4lj9Dom50rKNk4() {
        return b();
    }

    public final void a() {
        if (f9912b == false) goto L5;
        return;
    L5:
        f9912b = true;
        AIKernelManager.INSTANCE.init(new AIKernelConfig.Builder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).appId(AppContext.INSTANCE.getAid()).packageName(AppContext.INSTANCE.getPluginPkgName()).setLlmUsageMode($$Lambda$a$YdJHAeeP_ofMn4lj9Dom50rKNk4.INSTANCE).build());
        AIKernelManager.INSTANCE.registerLog((ILog) ZeusTransformUtils.preCheckCast(new C0477a(), ILog.class, "com.obric.memorydata.plugin"));
    }
}

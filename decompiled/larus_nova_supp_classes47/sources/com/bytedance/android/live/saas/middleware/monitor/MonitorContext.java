package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.monitor.strategy.EmptyReport;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/MonitorContext;", "", "()V", "mMonitorReport", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "getMMonitorReport", "()Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "setMMonitorReport", "(Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;)V", "init", "", "context", "Landroid/app/Application;", "params", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorContext {
    public static final MonitorContext INSTANCE = null;
    private static IMonitorReport mMonitorReport;

    private MonitorContext() {
    }

    static {
        INSTANCE = new MonitorContext();
        mMonitorReport = new EmptyReport();
    }

    public final IMonitorReport getMMonitorReport() {
        return mMonitorReport;
    }

    public final void setMMonitorReport(IMonitorReport r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        mMonitorReport = r2;
    }

    @JvmStatic
    public static final void init(Application r1, MonitorConfig r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r2.getInhouseSdkMonitor() == false) goto L5;
        mMonitorReport = new LiveSdkMonitorStrategy(r2.getAppId());
    L6:
        mMonitorReport.callInit(r1);
        return;
    L5:
        mMonitorReport = new SlardarStrategy();
        goto L6
    }
}

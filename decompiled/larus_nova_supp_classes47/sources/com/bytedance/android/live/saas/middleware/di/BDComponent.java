package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.BDLiveSdkHelper;
import com.bytedance.android.live.saas.middleware.applog.AppLogProxy;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibProxy;
import com.bytedance.android.live.saas.middleware.fresco.FrescoProxy;
import com.bytedance.android.live.saas.middleware.monitor.MonitorProxy;
import com.bytedance.android.live.saas.middleware.network.NetworkProxy;
import com.bytedance.android.live.saas.middleware.npth.NpthProxy;
import com.bytedance.android.live.saas.middleware.sec.SecProxy;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/di/BDComponent;", "", "inject", "", "helper", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkHelper;", "applog", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;", "baselib", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibProxy;", "fresco", "Lcom/bytedance/android/live/saas/middleware/fresco/FrescoProxy;", "config", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorProxy;", "Lcom/bytedance/android/live/saas/middleware/network/NetworkProxy;", "npth", "Lcom/bytedance/android/live/saas/middleware/npth/NpthProxy;", "sec", "Lcom/bytedance/android/live/saas/middleware/sec/SecProxy;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface BDComponent {
    void inject(BDLiveSdkHelper r1);

    void inject(AppLogProxy r1);

    void inject(BaseLibProxy r1);

    void inject(FrescoProxy r1);

    void inject(MonitorProxy r1);

    void inject(NetworkProxy r1);

    void inject(NpthProxy r1);

    void inject(SecProxy r1);
}

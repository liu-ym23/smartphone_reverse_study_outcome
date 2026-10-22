package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.BDLiveSdkHelper;
import com.bytedance.android.live.saas.middleware.applog.AppLogProxy;
import com.bytedance.android.live.saas.middleware.applog.di.AppLogModule;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibProxy;
import com.bytedance.android.live.saas.middleware.baselib.di.BaseLibModule;
import com.bytedance.android.live.saas.middleware.fresco.FrescoProxy;
import com.bytedance.android.live.saas.middleware.fresco.di.FrescoModule;
import com.bytedance.android.live.saas.middleware.monitor.MonitorProxy;
import com.bytedance.android.live.saas.middleware.monitor.di.MonitorModule;
import com.bytedance.android.live.saas.middleware.network.NetworkProxy;
import com.bytedance.android.live.saas.middleware.network.di.CornetModule;
import com.bytedance.android.live.saas.middleware.npth.NpthProxy;
import com.bytedance.android.live.saas.middleware.npth.di.NpthModule;
import com.bytedance.android.live.saas.middleware.sec.SecProxy;
import com.bytedance.android.live.saas.middleware.sec.di.SecModule;
import dagger.Component;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Component(modules = {NpthModule.class, BaseLibModule.class, AppLogModule.class, BDLiveSdkModule.class, CornetModule.class, SecModule.class, MonitorModule.class, FrescoModule.class})
@Singleton
public interface _BDComponent {
    void inject(BDLiveSdkHelper r1);

    void inject(AppLogProxy r1);

    void inject(BaseLibProxy r1);

    void inject(FrescoProxy r1);

    void inject(MonitorProxy r1);

    void inject(NetworkProxy r1);

    void inject(NpthProxy r1);

    void inject(SecProxy r1);
}

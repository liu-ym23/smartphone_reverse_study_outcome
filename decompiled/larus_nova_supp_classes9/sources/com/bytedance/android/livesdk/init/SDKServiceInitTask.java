package com.bytedance.android.livesdk.init;

import android.content.Context;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.base.service.IServiceCast;
import com.bytedance.android.live.base.service.IUserId;
import com.bytedance.android.live.core.IInnerSDKCore;
import com.bytedance.android.live.core.InnerSDKCore;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.h9;
import com.bytedance.android.livesdk.provideservices.d0;
import com.bytedance.android.livesdkapi.LiveSaaSInternalService;
import com.bytedance.android.livesdkapi.TTInternalBusinessService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.business.IHsLiveAdMocService;
import com.bytedance.android.livesdkapi.business.ILiveAdMiddleWareService;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.common.utility.Logger;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_SDKServiceInitTask", value = 32)
public class SDKServiceInitTask extends AbsTask {
    IHostService mHostService;

    public class a implements IServiceCast {
        public final /* synthetic */ SDKServiceInitTask a;

        public a(SDKServiceInitTask r1) {
            this.a = r1;
        }

        public final <T> T as(Class<T> r2) {
            if (r2 != IUserId.class) goto L7;
            return (T) new z();
        L7:
            if (r2 != IHostMonitor.class) goto L11;
            return (T) this.a.mHostService.monitor();
        L11:
            return (T) TTLiveService.getService(r2);
        }
    }

    public class b implements IInnerSDKCore {
        public final /* synthetic */ SDKServiceInitTask a;

        public final String getChannel() {
            return this.a.mHostService.appContext().getChannel();
        }

        public Context getContext() {
            return this.a.mHostService.appContext().context();
        }

        public b(SDKServiceInitTask r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void a(Throwable r0) {
        lambda$run$0(r0);
    }

    public int getTaskId() {
        return 0;
    }

    public void run() {
        y50.e.a = System.currentTimeMillis();
        if (RxJavaPlugins.getErrorHandler() == null) goto L5;
    L7:
        TTLiveSDKContext.registerService(ILiveService.class, new d0());
        TTLiveSDKContext.registerService(IMiddlewareLiveService.class, new d0());
        TTLiveSDKContext.registerService(IHostService.class, this.mHostService);
        BaseServices.install(new a(this));
        TTLiveService.setSDKContext(new h9());
        TTLiveServiceMiddleware.setSDKContext(new h9());
        LiveSaaSInternalService.setSDKContext(new h9());
        h9 r0 = new h9();
        TTInternalBusinessService.Companion.setSDKContext(r0);
        TTLiveSDKContext.registerService(IInternalBusinessService.class, new com.bytedance.android.livesdk.provideservices.d());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        SettingUtil.setLocalTest(true);
    L10:
        InnerSDKCore.setLiveSDKCore(new b(this));
        if (jc1.k.f(ILiveDouPlusService.class) != null) goto L14;
        jc1.k.l(ILiveDouPlusService.class, new ILiveDouPlusService.DEFAULT());
    L14:
        if (jc1.k.f(IHsLiveAdMocService.class) != null) goto L17;
        jc1.k.l(IHsLiveAdMocService.class, new IHsLiveAdMocService.DEFAULT());
    L17:
        if (jc1.k.f(ILiveRenQiBaoService.class) != null) goto L20;
        jc1.k.l(ILiveRenQiBaoService.class, new ILiveRenQiBaoService.DEFAULT());
    L20:
        if (jc1.k.f(ILiveAdMiddleWareService.class) != null) goto L23;
        jc1.k.l(ILiveAdMiddleWareService.class, new ILiveAdMiddleWareService.DEFAULT());
    L23:
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L26;
        TTLiveSDKContext.getHostService().a.webView().setCachePrefix(TTLiveWebOfflineConfig.getOfflinePatterns());
        return;
    L26:
        return;
    L5:
        if (isDebug(this.mHostService) == true) goto L7;
        RxJavaPlugins.setErrorHandler(new y());
        goto L7
    }

    public SDKServiceInitTask(IHostService r1) {
        this.mHostService = r1;
    }

    private static boolean isDebug(IHostService r0) {
        return Logger.debug();
    }

    private static /* synthetic */ void lambda$run$0(Throwable r4) throws Exception {
        if (r4 != null) goto L5;
        r4 = new UnknownError("unknown error");
    L5:
        r4.getMessage();
        if (r4.getStackTrace() == null) goto L10;
        StackTraceElement[] r5 = r4.getStackTrace();
        int r0 = r5.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        r5[r1].toString();
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }
}

package com.ss.android.lark.officesdk.plugin;

import com.ss.android.lark.officesdk.api.plugin.IOfficeSDKPluginService;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginError;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginStage;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginState;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import io.reactivex.Completable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final ConcurrentHashMap<String, Completable> a = null;

    public d() {
    }

    static {
        a = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static final IOfficeSDKPluginService c(String r2, OfficeSDKPluginStage r3) {
        IOfficeSDKPluginService r0 = (IOfficeSDKPluginService) OfficeSDKManager.getHostGlobalService(IOfficeSDKPluginService.class);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw e(r3, OfficeSDKPluginErrorCode.SERVICE_NOT_REGISTERED, "OfficeSDK plugin service is not registered: " + r2, null);
    }

    public static final Completable a(String r3, OfficeSDKPluginStage r4, Function1 r5) {
        return Completable.create(new a(r5, r4, r3)).timeout(10, TimeUnit.MINUTES).onErrorResumeNext(new b(r4, r3));
    }

    public static final OfficeSDKPluginState b(IOfficeSDKPluginService r2, String r3, OfficeSDKPluginStage r4) {
        return r2.getPluginState(r3);
    L4:
        th = move-exception;
        throw e(r4, OfficeSDKPluginErrorCode.OPERATION_EXCEPTION, "Query plugin state failed: " + r3, th);
    }

    public static final void d(IOfficeSDKPluginService r2, String r3, OfficeSDKPluginStage r4) {
        if (r2.isPluginSupported(r3) == false) goto L6;
        return;
    L6:
        throw e(OfficeSDKPluginStage.QUERY, OfficeSDKPluginErrorCode.PLUGIN_UNSUPPORTED, "Plugin is not supported by current host: " + r3, null);
    L7:
        th = move-exception;
        throw e(r4, OfficeSDKPluginErrorCode.OPERATION_EXCEPTION, "Query plugin support failed: " + r3, th);
    }

    public static OfficeSDKPluginException e(OfficeSDKPluginStage r10, int r11, String r12, Throwable r13) {
        return new OfficeSDKPluginException(new OfficeSDKPluginError(r10, r11, r12, null, r13, 8, null), r13);
    }
}

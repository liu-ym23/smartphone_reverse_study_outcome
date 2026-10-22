package com.ss.android.lark.openplatform.openapi.api.usage;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import el9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class RecentAppsManager implements IRecentAppsManager {
    private static final String TAG = "RecentAppsManager";
    private IRecentAppsManager recentAppsImpl;

    public interface OnAppDeleteListener {
        void onFail(String r1);

        void onSuccess();
    }

    public interface OnDataGetListener {
        void onFail(boolean r1);

        void onSuccess(List<AppLaunchInfo> r1, boolean r2);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public IRecentAppsManager getImpl() {
        if (this.recentAppsImpl != null) goto L10;
        this.recentAppsImpl = (IRecentAppsManager) INVOKESTATIC_com_ss_android_lark_openplatform_openapi_api_usage_RecentAppsManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppbrandHostConstants.ImplClass.RECENT_APPS_MANAGER_IMPL).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
    L10:
        return this.recentAppsImpl;
    }

    public RecentAppsManager() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_openplatform_openapi_api_usage_RecentAppsManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public void addDataChangeListener(DataChangeListener r2) {
        if (getImpl() == null) goto L6;
        this.recentAppsImpl.addDataChangeListener(r2);
        return;
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public boolean removeDataChangeListener(DataChangeListener r2) {
        if (getImpl() != null) goto L5;
        return false;
    L5:
        return this.recentAppsImpl.removeDataChangeListener(r2);
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public List<AppLaunchInfo> getRecentAppList(OnDataGetListener r2, IAppContext r3) {
        if (getImpl() == null) goto L7;
        return this.recentAppsImpl.getRecentAppList(r2, r3);
    L7:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.openplatform.openapi.api.usage.IRecentAppsManager
    public void deleteRecentApp(String r2, OnAppDeleteListener r3, IAppContext r4) {
        if (getImpl() == null) goto L6;
        this.recentAppsImpl.deleteRecentApp(r2, r3, r4);
        return;
    }
}

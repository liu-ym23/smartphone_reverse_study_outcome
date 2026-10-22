package com.bytedance.android.ec.common.impl.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.marketing.sdk.api.IMarketingBridgeService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import el9.a;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/RequestECMarketingBridgeMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequestECMarketingBridgeMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "requestECMarketingBridge";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl");
    }

    public RequestECMarketingBridgeMethod() {
    }

    public final void c(JSONObject r10, final ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        IMarketingBridgeService r0 = (IMarketingBridgeService) ServiceManager.get().getService(IMarketingBridgeService.class, false, false);
        if (r0 == null) goto L14;
    L10:
        Context r1 = getContext();
        if (r0 == null) goto L15;
        r0.a(r10, b().a, r1, new RequestECMarketingBridgeMethod$handle$1(r11));
        return;
    L15:
        return;
    L14:
        Constructor r12 = d().getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L9
        r12.setAccessible(true);     // Catch: Throwable -> L9
        Object r13 = r12.newInstance(new Object[0]);     // Catch: Throwable -> L9
        if (r13 == null) goto L8;
        r0 = (IMarketingBridgeService) r13;     // Catch: Throwable -> L9
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.marketing.sdk.api.IMarketingBridgeService");     // Catch: Throwable -> L9
    L9:
        r0 = null;
        goto L10
    }
}

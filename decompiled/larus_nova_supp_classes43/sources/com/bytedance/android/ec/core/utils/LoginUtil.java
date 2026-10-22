package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LoginUtil {
    public static final Map<String, String> a = null;

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("action_buy", "product_detail_buynow"), TuplesKt.to("action_sku", com.bytedance.android.ec.core.event.a.VALUE_SKU_NAME), TuplesKt.to("action_add_to_cart", "product_detail_addcart"), TuplesKt.to("action_enter_cart", "product_detail_clickcart"), TuplesKt.to("action_im", "product_detail_services"), TuplesKt.to("logistics_and_coupon_coupon_event_id", "product_detail_discount")});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdturing.reflect.VersionUtils");
    }

    public static void f(Context r1, Function0 r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "callBack");
        Activity r11 = p.a.getActivity(r1);
        if (r11 == null) goto L6;
        c(r11, "", "", r10);
        return;
    }

    public static void e(Context r10, String r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "callBack");
        Activity r1 = p.a.getActivity(r10);
        if (r1 == null) goto L6;
        b(r1, "", "", r11, r12, null);
        return;
    }

    public static void c(Activity r10, String r11, String r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        b(r10, r11, r12, "", r13, null);
    }

    public static void g(Activity r10, String r11, String r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter("livesdk_click_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        b(r10, r11, "livesdk_click_product", r12, r13, null);
    }

    public static void d(Activity r10, String r11, String r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        Intrinsics.checkNotNullParameter(r14, "errorCallback");
        b(r10, r11, r12, "", r13, r14);
    }

    public static void b(Activity r10, String r11, String r12, String r13, final Function0 r14, final Function0 r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r14, "callBack");
        com.bytedance.android.ec.sdk.helper.r r1 = com.bytedance.android.ec.sdk.helper.r.a;
        if (r1.isLogin() == false) goto L5;
        r14.invoke();
        return;
    L5:
        r1.d(r10, r11, r12, r13, new LoginUtil$checkLogin$3(r14), new LoginUtil$checkLogin$4(r15));
    }

    public static void h(Activity r14, String r15, String r16, Bundle r17, String r18, final Function0 r19, final Function0 r20) {
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r15, "enterFrom");
        Intrinsics.checkNotNullParameter(r16, "enterMethod");
        Intrinsics.checkNotNullParameter(r18, "ecSceneID");
        Intrinsics.checkNotNullParameter("goods_detail", "sceneType");
        Intrinsics.checkNotNullParameter(r19, "callBack");
        Intrinsics.checkNotNullParameter(r20, "errorCallback");
        boolean r10 = false;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        boolean r0 = com.bytedance.android.ec.sdk.helper.r.a.c(r18);     // Catch: Throwable -> L8
        boolean r12 = Intrinsics.areEqual(a().getDeclaredMethod("loginVerifyAvailable", new Class[0]).invoke(Unit.INSTANCE, new Object[0]), Boolean.TRUE);     // Catch: Throwable -> L8
        Lazy r13 = ECAppInfoService.a;     // Catch: Throwable -> L8
        if (we.a.a == false) goto L12;
        if (r12 == false) goto L12;
        if (r0 == false) goto L12;
        r10 = true;
    L12:
        if (r10 == false) goto L14;
        r19.invoke();
        return;
    L14:
        Lazy r1 = ECAppInfoService.a;
        if (we.a.a == false) goto L17;
        String r21 = "livesdk_click_product";
    L18:
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r15, "enterFrom");
        Intrinsics.checkNotNullParameter(r21, "enterMethod");
        Intrinsics.checkNotNullParameter(r19, "callBack");
        com.bytedance.android.ec.sdk.helper.r r22 = com.bytedance.android.ec.sdk.helper.r.a;
        if (r22.isLogin() == false) goto L21;
        r19.invoke();
        return;
    L21:
        String r23 = r21;
        r22.e(r14, r15, r23, r17, new LoginUtil$checkLogin$5(r19), new LoginUtil$checkLogin$6(r20));
        return;
    L17:
        r21 = r16;
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Throwable r24 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r24 == null) goto L12;
        ECExceptionMonitor.e(r24);
        goto L12
    }
}

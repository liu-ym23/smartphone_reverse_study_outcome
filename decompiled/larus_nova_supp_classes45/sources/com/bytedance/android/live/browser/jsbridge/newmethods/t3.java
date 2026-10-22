package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Process;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.ie;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getAppInfo")
public final class t3 extends AbsGetAppInfoMethod<JsonObject, GetAppInfoResultModel> {
    public final IMiddleWareHostContext a;
    public final Map<String, String> b;

    public t3() {
        this.a = jc1.k.f(IMiddleWareHostContext.class);
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L7;
        IMiddlewareNetworkService r0 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r0 == null) goto L10;
        Map<String, String> r1 = r0.getCommonParams();
    L11:
        this.b = r1;
        return;
    L10:
        r1 = null;
        goto L11
    L7:
        IMiddlewareNetworkService r2 = jc1.k.f(IMiddlewareNetworkService.class);
        if (r2 == null) goto L10;
        r1 = r2.getCommonParams();
        goto L11
    }

    public final void invoke(Object r11, CallContext r12) {
        Intrinsics.checkNotNullParameter((JsonObject) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        GetAppInfoResultModel r13 = new GetAppInfoResultModel();
        IMiddleWareHostContext r0 = this.a;
        boolean r1 = true;
        boolean r2 = false;
        Object r3 = null;
        if (r0 == null) goto L64;
        r13.setAppID(String.valueOf(r0.hostAppId()));
        r13.setAppName(r0.appName());
        String r4 = r0.getVersionName();
        if (r4 != null) goto L7;
    L9:
        String r5 = r0.getVersionCode();
    L10:
        r13.setAppVersion(r5);
        r13.setUpdateVersionCode(String.valueOf(r0.getUpdateVersionCode()));
        r13.setNetworkType(NetworkUtils.getNetworkAccessType(r0.context()));
        r13.setDeviceID(AppLog.v());
        Context r14 = r12.getContext();
        if (r14 != null) goto L101;
    L62:
        r13.setScreenWidth(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y())));
        r13.setInstallID(AppLog.r());
        r13.setChannel(r0.getChannel());
        r13.setTeenMode(Boolean.valueOf(r0.isNeedProtectUnderage()));
        goto L64
    L101:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        r13.setCarrier(l30.h.a(r14, TokenCert.Companion.with("bpea-live_mobile_flow_old")));     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if ((r14 instanceof Activity) == true) goto L19;
        Context r7 = null;
    L20:
        Activity r8 = (Activity) r7;
        String r9 = "portrait";
        if (r8 != null) goto L23;
    L37:
        r13.setScreenOrientation(r9);
        r13.setScreenHeight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.q(r14).heightPixels - com.bytedance.android.live.core.utils.x1.j(r14))));
        int r15 = com.bytedance.android.livesdk.utils.y5.a;
        if (Build.VERSION.SDK_INT < 28) goto L60;
        Activity r16 = ContextUtil.contextToActivity(r14);
        if (r16 == null) goto L52;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L52;
        View r18 = r17.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L48;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r19 = ThreadMethodProxy.currentThread();
        if (r19 == com.larus.home.impl.utils.c.a) goto L48;
        com.larus.home.impl.utils.c.a(r19, "getDecorView");
    L48:
        if (r18 == null) goto L52;
        WindowInsets r21 = r18.getRootWindowInsets();
        if (r21 == null) goto L52;
        DisplayCutout r22 = r21.getDisplayCutout();
    L53:
        if (r22 == null) goto L57;
        List<Rect> r23 = r22.getBoundingRects();
        if (r23 == null) goto L57;
        int r24 = r23.size();
    L58:
        if (r24 <= 0) goto L60;
        Intrinsics.checkNotNull(r22);
        com.bytedance.android.livesdk.utils.x5 r110 = new com.bytedance.android.livesdk.utils.x5(r22.getSafeInsetLeft(), r22.getSafeInsetTop(), r22.getSafeInsetRight(), r22.getSafeInsetBottom());
    L61:
        GetAppInfoResultModel.GetAppInfoSafeArea r25 = new GetAppInfoResultModel.GetAppInfoSafeArea();
        r25.setMarginLeft(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r110.a)));
        r25.setMarginTop(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r110.b)));
        r25.setMarginRight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r110.c)));
        r25.setMarginBottom(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(r110.d)));
        Unit r111 = Unit.INSTANCE;
        r13.setSafeArea(r25);
    L57:
        r24 = 0;
    L52:
        r22 = null;
    L60:
        r110 = new com.bytedance.android.livesdk.utils.x5(0, com.bytedance.android.live.core.utils.x1.j(r14), 0, 0);
        goto L61
    L23:
        if (r8.getRequestedOrientation() != 1) goto L25;
        String r26 = "portrait";
    L27:
        if (PadConfigUtils.c() == false) goto L32;
        if (com.bytedance.android.livesdk.utils.e5.g(r8) == false) goto L37;
    L35:
        r9 = "landscape";
        goto L37
    L32:
        if (((Boolean) ie.a.getValue()).booleanValue() == true) goto L34;
        r9 = r26;
        goto L37
    L34:
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L37;
    L25:
        r26 = "landscape";
        goto L27
    L19:
        r7 = r14;
    L14:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L7:
        if ((!StringsKt.isBlank(r4)) != true) goto L9;
        r5 = r0.getVersionName();
    L64:
        if (fm3.d.b() == true) goto L75;
        IMiddleWareHostContext r112 = this.a;
        if (r112 == null) goto L69;
        Boolean r113 = r112.isDarkMode();
    L71:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L74;
    L76:
        String r114 = "dark";
    L77:
        r13.setAppTheme(r114);
        Map<String, String> r115 = this.b;
        if (r115 == null) goto L80;
        r13.setLanguage(r115.get("language"));
        r13.setOsVersion(r115.get("os_version"));
    L80:
        r13.setStatusBarHeight(Float.valueOf(com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.A())));
        r13.setDevicePlatform("android");
        r13.setDeviceModel(Build.MODEL);
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L88
        if (Build.VERSION.SDK_INT >= 23) goto L84;
    L85:
        r2 = true;
    L86:
        Object r117 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L88
    L91:
        if (Result.isFailure-impl(r117) == true) goto L94;
        r3 = r117;
    L94:
        Boolean r28 = (Boolean) r3;
        if (r28 == null) goto L97;
        r1 = r28.booleanValue();
    L97:
        r13.set32Bit(Boolean.valueOf(r1));
        r13.setMsg("SUCCESS");
        finishWithResult(r13);
        return;
    L84:
        if (Process.is64Bit() == true) goto L86;
    L88:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L74:
        if (Intrinsics.areEqual(r113, Boolean.FALSE) == false) goto L76;
    L69:
        r113 = null;
    L75:
        r114 = "light";
        goto L77
    }
}

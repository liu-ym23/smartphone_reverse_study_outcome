package com.bytedance.android.live.browser.service;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.browser.utils.LiveBrowserDomainUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.f1;
import com.bytedance.android.livesdkapi.buynow.IECBuyNowService;
import com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements i9.d {
    public final com.bytedance.android.live.browser.w a;

    public final String k0() {
        return String.valueOf(com.bytedance.android.livesdk.paas.c.b());
    }

    public h0(com.bytedance.android.live.browser.w r1) {
        this.a = r1;
    }

    public final void U0(LynxView r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        ALogger.i("AnnieNGInitHelper", "injectLynxSoLib===>" + r3 + " ;");
        jc1.k.n(IMiddlewareHostBusiness.class).loadLynxSoLib(r3);
    }

    public final void O(com.bytedance.android.annie.param.k r17, Context r18, String r19, boolean r21, String r22) {
        Intrinsics.checkNotNullParameter(r17, "params");
        ALogger.i("AnnieNGInitHelper", "appendLiveCommonGlobalParams start");
        if (((Boolean) f1.a.getValue()).booleanValue() == false) goto L16;
        if (r19 != null) goto L6;
    L9:
        boolean r6 = true;
    L10:
        if (r6 == true) goto L16;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r19), "enable_lite_page_annie_cache_param"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L16;
        if (r22 == null) goto L110;
        String[] r0 = AnnieParamUtil.a;
        AnnieParamUtil.f(r17, r18, r19, r22, this.a);
        return;
    L110:
        return;
    L6:
        if (r19.length() == 0) goto L9;
        r6 = false;
    L16:
        Map r11 = null;
        if (r17.c == false) goto L32;
        com.bytedance.android.live.browser.w r7 = this.a;
        String[] r1 = AnnieParamUtil.a;
        Intrinsics.checkNotNullParameter(r17, "param");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        AnnieParamUtil.b(r17);     // Catch: Throwable -> L21
        AnnieParamUtil.c(r17, r19, r22);     // Catch: Throwable -> L21
        AnnieParamUtil.d(r17, r18);     // Catch: Throwable -> L21
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L27;
        ALogger.e("HybridParamUtil", r4);
    L27:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L29;
    L30:
        if (r22 == null) goto L87;
        AnnieParamUtil.f(r17, r18, r19, r22, r7);
    L87:
        IMiddlewareHostCommerceServiceLive r5 = jc1.k.f(IMiddlewareHostCommerceServiceLive.class);
        if (r5 == null) goto L111;
        IECBuyNowService r8 = r5.getBuyNowService();
        if (r8 != null) goto L92;
        return;
    L92:
        if (r17.q() != null) goto L94;
        r17.e1(new LinkedHashMap());
    L94:
        Map r9 = r17.q();
        if (TypeIntrinsics.isMutableMap(r9) == false) goto L98;
        r11 = r9;
    L98:
        if (r11 == null) goto L113;
        r8.appendParams(r11, r19);
        jc1.k.n(IMiddlewareHostBusiness.class).appendBcmInfo(r11, r22, r17.g0());
        return;
    L113:
        return;
    L111:
        return;
    L29:
        if (AnnieParamUtil.j(r22) == false) goto L87;
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L32:
        com.bytedance.android.live.browser.w r13 = this.a;
        String[] r14 = AnnieParamUtil.a;
        Intrinsics.checkNotNullParameter(r17, "param");
        ALogger.i("HybridParamUtil", "getCommonHybridParam start, url=" + r22 + ", checkPermission=" + r21);
        if (r22 != null) goto L35;
    L38:
        boolean r15 = true;
    L39:
        if (r15 == true) goto L87;
        if (r21 == true) goto L43;
    L101:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L77
        AnnieParamUtil.a(r17);     // Catch: Throwable -> L77
        ALogger.i("HybridParamUtil", "before appendAppParams");     // Catch: Throwable -> L77
        AnnieParamUtil.b(r17);     // Catch: Throwable -> L77
        ALogger.i("HybridParamUtil", "after appendAppParams");     // Catch: Throwable -> L77
        r17.C1(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L77
        ALogger.i("HybridParamUtil", "before appendBusinessParams");     // Catch: Throwable -> L77
        AnnieParamUtil.c(r17, r19, r22);     // Catch: Throwable -> L77
        ALogger.i("HybridParamUtil", "after appendBusinessParams");     // Catch: Throwable -> L77
        r17.x2(Resources.getSystem().getConfiguration().locale.toString());     // Catch: Throwable -> L77
        r17.v2(String.valueOf(com.bytedance.android.live.network.impl.utils.i.b()));     // Catch: Throwable -> L77
        AnnieParamUtil.d(r17, r18);     // Catch: Throwable -> L77
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L77
    L79:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L83;
        ALogger.e("HybridParamUtil", r24);
    L83:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L85;
    L86:
        AnnieParamUtil.f(r17, r18, r19, r22, r13);
        goto L87
    L85:
        if (AnnieParamUtil.j(r22) == false) goto L87;
    L77:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L43:
        if (r22 != null) goto L45;
        String r110 = "";
    L46:
        Uri r111 = UriProtector.parse(r110);
        if (r111.getHost() == null) goto L72;
        Iterator r112 = ((List) LiveBrowserDomainUtils.a.getValue()).iterator();
    L50:
        if (r112.hasNext() == false) goto L72;
        String r113 = (String) r112.next();
        String r114 = r111.getHost();
        if (r114 != null) goto L55;
        r114 = "";
    L55:
        if (TextUtils.isEmpty(r113) == false) goto L57;
    L69:
        boolean r26 = false;
    L70:
        if (r26 == false) goto L50;
        boolean r27 = true;
    L73:
        if (r27 == true) goto L101;
    L57:
        if (TextUtils.isEmpty(r114) == true) goto L69;
        if (r114.length() < r113.length()) goto L69;
        if (StringsKt.endsWith$default(r114, r113, false, 2, null) == false) goto L69;
        if (Intrinsics.areEqual(r113, r114) == false) goto L67;
    L68:
        r26 = true;
        goto L70
    L67:
        if (StringsKt.endsWith$default(r114, ".".concat(r113), false, 2, null) == false) goto L69;
    L72:
        r27 = false;
        goto L73
    L45:
        r110 = r22;
        goto L46
    L35:
        if (StringsKt.isBlank(r22) == true) goto L38;
        r15 = false;
        goto L39
    }
}

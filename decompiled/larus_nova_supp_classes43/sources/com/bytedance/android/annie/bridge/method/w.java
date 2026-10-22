package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.annie.bridge.method.abs.AbsGetAppInfoMethod;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getAppInfo")
public final class w extends AbsGetAppInfoMethod<JsonObject, GetAppInfoResultModel> {
    public w() {
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter((JsonObject) r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Context r0 = r11.getContext().getApplicationContext();
        GetAppInfoResultModel r1 = new GetAppInfoResultModel();
        boolean r12 = true;
        r1.setCode(1);
        r1.setMsg("SUCCESS");
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r13 = com.bytedance.android.annie.ng.e.a;
        r1.setAppID(String.valueOf(r13.a));
        com.bytedance.android.annie.ng.g.b().getClass();
        r1.setAppName(r13.b);
        Activity r14 = null;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L8
        String r16 = r11.getContext().getPackageManager().getPackageInfo(r11.getContext().getPackageName(), 0).versionName;     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L12:
        if (TextUtils.isEmpty(r16) == false) goto L14;
        com.bytedance.android.annie.ng.g.b().getClass();
        r16 = com.bytedance.android.annie.ng.e.a.c;
    L14:
        r1.setAppVersion(r16);
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r17 = com.bytedance.android.annie.ng.e.a;
        r1.setChannel(r17.e);
        com.bytedance.android.annie.ng.g.b().getClass();
        r1.setLanguage(r17.f);
        com.bytedance.android.annie.ng.g.b().getClass();
        r1.setTeenMode(Boolean.valueOf(r17.g));
        com.bytedance.android.annie.ng.g.b().getClass();
        r1.setAppTheme(r17.h);
        r1.setOsVersion(Build.VERSION.RELEASE);
        r1.setDevicePlatform("android");
        r1.setDeviceID(com.bytedance.android.annie.ng.g.b().b.b);
        r1.setDeviceModel(Build.MODEL);
        String r18 = NetworkUtils.getNetworkAccessType(r11.getContext().getApplicationContext());     // Catch: Throwable -> L20
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L23:
        r1.setNetworkType(r18);
        int r19 = g7.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        if (r0.getResources().getConfiguration().orientation != 1) goto L26;
        String r110 = "portrait";
    L27:
        r1.setScreenOrientation(r110);
        com.bytedance.android.annie.ng.g.b().getClass();
        r1.setUpdateVersionCode(com.bytedance.android.annie.ng.e.a.i);
        r1.setStatusBarHeight(Integer.valueOf(g7.a.f(g7.a.d(r0), r0)));
        r1.setCarrier(com.bytedance.android.annie.ng.g.b().b.a);
        Context r111 = r11.getContext();
        Intrinsics.checkNotNullParameter(r0, "applicationContext");
        if (r111 != null) goto L31;
        r111 = r0;
    L31:
        if (r111.getResources().getConfiguration().orientation != 2) goto L33;
        boolean r20 = true;
    L34:
        int r21 = g7.a.b;
        if (r21 > 0) goto L41;
        g7.a.e(r111);
        r21 = g7.a.b;
        if (r21 > 0) goto L41;
        r21 = 0;
    L41:
        int r22 = g7.a.f(r21, r111);
        int r23 = g7.a.a;
        if (r23 > 0) goto L48;
        g7.a.e(r111);
        r23 = g7.a.a;
        if (r23 > 0) goto L48;
        r23 = 0;
    L48:
        int r112 = g7.a.f(r23, r111);
        if (r20 == false) goto L51;
        int r113 = Math.max(r22, r112);
    L52:
        r1.setScreenWidth(Integer.valueOf(r113));
        r1.setScreenHeight(Integer.valueOf(g7.a.c(r11.getContext(), r0)));
        Context r114 = r11.getContext();
        if ((r114 instanceof Activity) == false) goto L55;
        r14 = (Activity) r114;
    L55:
        r1.setSafeArea(g7.a.b(r14, r0));
        if (Build.SUPPORTED_64_BIT_ABIS.length == 0) goto L59;
        r12 = false;
    L59:
        r1.set32Bit(Boolean.valueOf(r12));
        finishWithResult(r1);
        return;
    L51:
        r113 = Math.min(r22, r112);
        goto L52
    L33:
        r20 = false;
        goto L34
    L26:
        r110 = "landscape";
    L18:
        Throwable th2 = th;
    L22:
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th2));
    L20:
        th = move-exception;
        th2 = th;
        r18 = null;
    L6:
        Throwable th3 = th;
    L10:
        Result.Companion r25 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th3));
    L8:
        th = move-exception;
        th3 = th;
        r16 = null;
        goto L10
    }
}

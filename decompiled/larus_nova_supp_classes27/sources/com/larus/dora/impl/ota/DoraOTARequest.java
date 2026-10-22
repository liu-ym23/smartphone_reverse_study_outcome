package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.http.y;
import g49.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTARequest {
    public static final DoraOTARequest a = null;

    static {
        a = new DoraOTARequest();
    }

    public DoraOTARequest() {
    }

    public final Object a(String r18, String r110, String r20, String r21, String r22, String r23, String r24, String r25, Continuation<? super Result<e49.a>> r26) {
        if ((r26 instanceof DoraOTARequest$checkUpdate$1) == false) goto L7;
        DoraOTARequest$checkUpdate$1 r8 = (DoraOTARequest$checkUpdate$1) r26;
        int r9 = r8.label;
        if ((r9 & Integer.MIN_VALUE) == 0) goto L7;
        r8.label = r9 - Integer.MIN_VALUE;
    L8:
        Object r4 = r8.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r8.label;
        if (r11 == 0) goto L15;
        if (r11 != 1) goto L14;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L32
    L22:
        y r5 = (com.larus.network.http.a) r4;     // Catch: Throwable -> L32
        d.d("DoraOTARequest", "checkUpdate: result=".concat(r5.getClass().getSimpleName()));     // Catch: Throwable -> L32
        if ((r5 instanceof y) == false) goto L30;
        Long r0 = r5.g;     // Catch: Throwable -> L32
        if (r0 == null) goto L30;
        if (r0.longValue() != 0) goto L30;
        return Result.constructor-impl(new e49.a((z39.a) ((com.larus.network.http.a) r5).b, false, false, 6));
    L30:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        return Result.constructor-impl(ResultKt.createFailure(new Exception("call is failed")));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r4);
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L32
        r6.put("product", r18);     // Catch: Throwable -> L32
        r6.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r110);     // Catch: Throwable -> L32
        r6.put("udid", r20);     // Catch: Throwable -> L32
        r6.put("os_version", r21);     // Catch: Throwable -> L32
        r6.put("rom_version", r22);     // Catch: Throwable -> L32
        r6.put("buildtime", r23);     // Catch: Throwable -> L32
        r6.put("buildtype", r25);     // Catch: Throwable -> L32
        r6.put("flag", r24);     // Catch: Throwable -> L32
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L32
        r14.put("doubao_version", AppHost.a.getVersionName());     // Catch: Throwable -> L32
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L32
        r6.put("extra_apps", r14);     // Catch: Throwable -> L32
        d.d("DoraOTARequest", "checkUpdate: product=" + r18 + " model=" + r110 + " pkgType=" + r24 + " buildType=" + r25);     // Catch: Throwable -> L32
        DoraDevice r2 = kj4.a.g().c();     // Catch: Throwable -> L32
        if (r2 == null) goto L19;
        o59.a.p(r2);     // Catch: Throwable -> L32
    L19:
        com.larus.dora.api.network.a r3 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L32
        r8.label = 1;     // Catch: Throwable -> L32
        r4 = com.larus.dora.api.network.a.c(r3, z39.a.class, "https://ocean-ota.obriccloud.com/open/v3/ota/check", r6, null, r8, 248);     // Catch: Throwable -> L32
        if (r4 != r10) goto L22;
        return r10;
    L32:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r8 = new DoraOTARequest$checkUpdate$1(this, r26);
        goto L8
    }
}

package com.obric.assistant.feedback.voc;

import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class VocApiKt {
    public static final Object a(String r6, String r7, int r8, String r9, String r10, Continuation<? super com.larus.network.http.a<? extends Object>> r11) {
        if ((r11 instanceof VocApiKt$submitVocRequest$1) == false) goto L7;
        VocApiKt$submitVocRequest$1 r0 = (VocApiKt$submitVocRequest$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L33
    L19:
        String r13 = (String) r12;     // Catch: Throwable -> L33
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L22
        Object r15 = Result.constructor-impl(new JSONObject(r13));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r15) == false) goto L27;
        r15 = null;
    L27:
        JSONObject r16 = (JSONObject) r15;     // Catch: Throwable -> L33
        if (r16 != null) goto L30;
        Object r17 = r13;
    L31:
        return new y(r17, null, 14);
    L30:
        r17 = r16;
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L25
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        FlowHttpConnection r19 = FlowHttpConnection.a;     // Catch: Throwable -> L33
        VocApiOrigin r110 = (VocApiOrigin) RetrofitUtils.createSsRetrofit(FlowHttpConnection.a(), CollectionsKt.emptyList(), rx5.a.a()).create(VocApiOrigin.class);     // Catch: Throwable -> L33
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L33
        r4.put("content", r6);     // Catch: Throwable -> L33
        r4.put("image_list", r7);     // Catch: Throwable -> L33
        r4.put("multi_image", String.valueOf(r8));     // Catch: Throwable -> L33
        r4.put("extra_params", r9);     // Catch: Throwable -> L33
        r4.put("extra_persistent_params", r10);     // Catch: Throwable -> L33
        AppHost.Companion r20 = AppHost.a;     // Catch: Throwable -> L33
        r4.put("channel", r20.getBuildChannel());     // Catch: Throwable -> L33
        IApplog.Companion r21 = IApplog.a;     // Catch: Throwable -> L33
        r4.put("iid", r21.getInstallId());     // Catch: Throwable -> L33
        r4.put("appkey", "doubao_android");     // Catch: Throwable -> L33
        r4.put("appName", "doubao_app");     // Catch: Throwable -> L33
        r4.put("device_id", r21.getDeviceId());     // Catch: Throwable -> L33
        r4.put("aid", String.valueOf(r20.getAppId()));     // Catch: Throwable -> L33
        r4.put("report_type", "android_native");     // Catch: Throwable -> L33
        r0.label = 1;     // Catch: Throwable -> L33
        r12 = r110.postMessage(r4, r0);     // Catch: Throwable -> L33
        if (r12 != r2) goto L19;
        return r2;
    L33:
        AsyncThrowable.Companion.getClass();
        return new f(AsyncThrowable.access$getDEFAULT$cp(), null);
    L7:
        r0 = new VocApiKt$submitVocRequest$1(r11);
        goto L8
    }
}

package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j3<T> implements Consumer {
    public final /* synthetic */ FetchV3Method a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public j3(FetchV3Method r1, CallContext r2, Ref.ObjectRef r3, JSONObject r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r18) {
        JSONObject r9 = (JSONObject) r18;
        HybridLogger.m("BDXBridge", "fetch success", null, null, 12);
        FetchV3Method r0 = this.a;
        Context r11 = this.b.getContext();
        JSONObject r12 = (JSONObject) this.c.element;
        r0.getClass();
        JSONObject r1 = r9.optJSONObject("raw");
        if (r1 == null) goto L68;
        int r4 = r1.optInt("status_code");
        ILiveCoreService r2 = (ILiveCoreService) jc1.k.n(ILiveCoreService.class);
        RequestError r8 = new RequestError();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r5 = r9.optJSONObject("raw");     // Catch: Throwable -> L13
        if (r5 == null) goto L10;
        JSONObject r6 = r5.optJSONObject("data");     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        String r7 = r6.optString("prompts");     // Catch: Throwable -> L13
    L11:
        Object r13 = Result.constructor-impl(r7);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r13) == false) goto L18;
        r13 = null;
    L18:
        String r14 = (String) r13;
        if (r14 != null) goto L21;
    L26:
        r2.minorIntercept(null, r4, "live_detail", r8, null, r9);
        String r15 = r8.alert;
        if (r15 != null) goto L29;
    L32:
        boolean r16 = true;
    L34:
        if ((!r16) == false) goto L36;
        RequestError r17 = r8;
    L37:
        if (r17 == null) goto L68;
        Object r19 = Result.constructor-impl(r12.optString("request_source"));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r19) == false) goto L46;
        r19 = null;
    L46:
        if (TextUtils.equals("coin_pay", (String) r19) == true) goto L73;
        String r110 = null;
    L63:
        Activity r21 = ContextUtil.contextToActivity(r11);
        if (r21 == null) goto L68;
        if (r110 != null) goto L67;
        r110 = r17.alert;
    L67:
        ExceptionUtils.displayAlert(r21, r110, com.bytedance.android.live.core.utils.s1.B(2131915969));
        goto L68
    L73:
        JSONObject r22 = r9.optJSONObject("raw");     // Catch: Throwable -> L55
        if (r22 == null) goto L52;
        JSONObject r23 = r22.optJSONObject("data");     // Catch: Throwable -> L55
        if (r23 == null) goto L52;
        String r24 = r23.optString("prompts");     // Catch: Throwable -> L55
    L53:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r25) == false) goto L60;
        Object r111 = null;
    L61:
        r110 = (String) r111;
        goto L63
    L60:
        r111 = r25;
    L52:
        r24 = null;
    L55:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L36:
        r17 = null;
        goto L37
    L29:
        if (r15.length() == 0) goto L32;
        r16 = false;
        goto L34
    L21:
        if ((!StringsKt.isBlank(r14)) == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L26;
        r8.prompts = r14;
    L10:
        r7 = null;
    L13:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L68:
        FetchTimingSession r29 = this.a.b;
        if (r29 == null) goto L71;
        r29.recordJsbEndTiming(r9);
    L71:
        int r31 = com.bytedance.android.annie.bridge.g.a;
        com.bytedance.android.annie.bridge.g.b(this.d, r9);
        this.a.finishWithResult(r9);
        x40.c.b(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), this.e, this.f, (JSONObject) this.c.element, "success", "result =  " + r9);
    }
}

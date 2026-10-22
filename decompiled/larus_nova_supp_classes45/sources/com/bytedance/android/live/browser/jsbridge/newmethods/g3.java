package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g3<T> implements Consumer {
    public final /* synthetic */ e3 a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ JsonObject d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public g3(e3 r1, CallContext r2, Ref.ObjectRef r3, JsonObject r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r15) {
        JsonObject r16 = (JsonObject) r15;
        e3 r0 = this.a;
        Context r1 = this.b.getContext();
        JsonObject r2 = (JsonObject) this.c.element;
        r0.getClass();
        JsonElement r5 = r16.get("raw");
        if (r5 == null) goto L88;
        JsonObject r6 = r5.getAsJsonObject();
        if (r6 == null) goto L88;
        JsonElement r7 = r6.get("status_code");
        if (r7 == null) goto L88;
        int r8 = r7.getAsInt();
        ILiveCoreService r9 = (ILiveCoreService) jc1.k.n(ILiveCoreService.class);
        RequestError r11 = new RequestError();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L24
        JsonElement r13 = r16.get("raw");     // Catch: Throwable -> L24
        if (r13 == null) goto L21;
        JsonObject r14 = r13.getAsJsonObject();     // Catch: Throwable -> L24
        if (r14 == null) goto L21;
        JsonElement r17 = r14.get("data");     // Catch: Throwable -> L24
        if (r17 == null) goto L21;
        JsonObject r18 = r17.getAsJsonObject();     // Catch: Throwable -> L24
        if (r18 == null) goto L21;
        JsonElement r19 = r18.get("prompts");     // Catch: Throwable -> L24
        if (r19 == null) goto L21;
        String r21 = r19.getAsString();     // Catch: Throwable -> L24
        if (r21 == null) goto L21;
    L22:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L24
    L26:
        String r110 = null;
        Object r111 = null;
        if (Result.isFailure-impl(r22) == false) goto L29;
        r22 = null;
    L29:
        String r23 = (String) r22;
        if (r23 != null) goto L32;
    L37:
        r9.minorInterceptOld(null, r8, "live_detail", r11, null);
        String r24 = r11.alert;
        if (r24 != null) goto L40;
    L43:
        boolean r25 = true;
    L45:
        if ((!r25) == true) goto L48;
        r11 = null;
    L48:
        if (r11 == null) goto L88;
        JsonElement r3 = r2.get("request_source");     // Catch: Throwable -> L55
        if (r3 == null) goto L52;
        String r4 = r3.getAsString();     // Catch: Throwable -> L55
    L53:
        Object r26 = Result.constructor-impl(r4);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r26) == false) goto L61;
        r26 = null;
    L61:
        if (TextUtils.equals("coin_pay", (String) r26) == true) goto L99;
    L83:
        Activity r27 = ContextUtil.contextToActivity(r1);
        if (r27 == null) goto L88;
        if (r110 != null) goto L87;
        r110 = r11.alert;
    L87:
        ExceptionUtils.displayAlert(r27, r110, com.bytedance.android.live.core.utils.s1.B(2131915969));
        goto L88
    L99:
        JsonElement r28 = r16.get("raw");     // Catch: Throwable -> L76
        if (r28 == null) goto L73;
        JsonObject r29 = r28.getAsJsonObject();     // Catch: Throwable -> L76
        if (r29 == null) goto L73;
        JsonElement r31 = r29.get("data");     // Catch: Throwable -> L76
        if (r31 == null) goto L73;
        JsonObject r32 = r31.getAsJsonObject();     // Catch: Throwable -> L76
        if (r32 == null) goto L73;
        JsonElement r33 = r32.get("prompts");     // Catch: Throwable -> L76
        if (r33 == null) goto L73;
        String r34 = r33.getAsString();     // Catch: Throwable -> L76
    L74:
        Object r35 = Result.constructor-impl(r34);     // Catch: Throwable -> L76
    L79:
        if (Result.isFailure-impl(r35) == true) goto L82;
        r111 = r35;
    L82:
        r110 = (String) r111;
    L73:
        r34 = null;
    L76:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L52:
        r4 = null;
    L55:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L40:
        if (r24.length() == 0) goto L43;
        r25 = false;
        goto L45
    L32:
        if ((!StringsKt.isBlank(r23)) == true) goto L35;
        r23 = null;
    L35:
        if (r23 == null) goto L37;
        r11.prompts = r23;
    L21:
        r21 = "";
    L24:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        FetchTimingSession r39 = this.a.c;
        if (r39 == null) goto L91;
        r39.recordJsbEndTiming(r16);
    L91:
        int r41 = com.bytedance.android.annie.bridge.g.a;
        com.bytedance.android.annie.bridge.g.a(this.d, r16);
        e3 r42 = this.a;
        if (r42.b == false) goto L94;
        String r43 = UtilsKt.h(r16);
    L95:
        r42.finishWithResult(r43);
        x40.c.a(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), this.e, this.f, (JsonObject) this.c.element, "success", "result =  " + r16);
        return;
    L94:
        r43 = r16.toString();
        goto L95
    }
}

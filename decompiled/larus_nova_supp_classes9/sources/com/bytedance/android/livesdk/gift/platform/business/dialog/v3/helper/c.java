package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.UtilsKt;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final JsonObject a(byte[] r2, JsonObject r3, String r4, String r5) {
        if (r2 == null) goto L31;
        if (r4 == null) goto L31;
        if (r5 == null) goto L31;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl((JsonObject) GsonHelper.get().fromJson(r4, JsonObject.class));     // Catch: Throwable -> L8
    L10:
        Object r0 = null;
        t9.c r8 = Annie.getService$default(t9.c.class, null, 2, null);
        if (Result.isFailure-impl(r7) == false) goto L13;
        r7 = null;
    L13:
        JsonObject r9 = (JsonObject) r7;
        if (r9 != null) goto L16;
        return null;
    L16:
        t9.b r10 = r8.M0(r9);
        if (r10 != null) goto L19;
        return null;
    L19:
        if (r10.b(r5, null) == false) goto L37;
        Object r11 = Result.constructor-impl((JsonObject) GsonHelper.getDefault().fromJson(com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(UtilsKt.g(r10.a(r2, r5))), JsonObject.class));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r11) == true) goto L30;
        r0 = r11;
    L30:
        return (JsonObject) r0;
    L23:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L37:
        return null;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        return r3;
    }
}

package com.bytedance.android.annie.bridge;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JsonObject r10, JsonObject r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        Unit r1 = null;
        if (r10 == null) goto L25;
        JsonPrimitive r12 = r10.getAsJsonPrimitive("jsb_invoke_back_mode");     // Catch: Throwable -> L27
        if (r12 == null) goto L25;
        if (r12.isNumber() == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L25;
        Number r13 = r12.getAsNumber();     // Catch: Throwable -> L27
        if (r13 == null) goto L25;
        Integer r14 = Integer.valueOf(r13.intValue());     // Catch: Throwable -> L27
        if (r14 != null) goto L16;
    L18:
        boolean r15 = false;
    L19:
        if (r15 == true) goto L22;
        r13 = null;
    L22:
        if (r13 == null) goto L25;
        if (r11 == null) goto L25;
        r11.addProperty("__jsb_invoke_back_mode", r13);     // Catch: Throwable -> L27
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L27
        goto L25
    L16:
        if (r14.intValue() <= 0) goto L18;
        r15 = true;
    L25:
        Result.constructor-impl(r1);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void b(JSONObject r10, JSONObject r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        boolean r1 = false;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.optInt("jsb_invoke_back_mode", 0));     // Catch: Throwable -> L16
    L7:
        if (r12 != null) goto L9;
    L11:
        if (r1 == false) goto L14;
        if (r11 == null) goto L14;
        r11.putOpt("__jsb_invoke_back_mode", 1);     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L9:
        if (r12.intValue() <= 0) goto L11;
        r1 = true;
        goto L11
    L5:
        r12 = null;
    L16:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}

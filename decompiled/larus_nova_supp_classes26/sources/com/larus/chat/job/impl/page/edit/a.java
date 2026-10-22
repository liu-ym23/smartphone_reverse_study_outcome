package com.larus.chat.job.impl.page.edit;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r8 = Result.constructor-impl(new JSONTokener(r7).nextValue());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        if ((r8 instanceof JSONArray) == false) goto L12;
        JSONArray r9 = (JSONArray) r8;
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        int r1 = r9.length();
        int r2 = 0;
        String r3 = null;
    L16:
        if (r2 >= r1) goto L40;
        JSONObject r4 = r9.optJSONObject(r2);
        if (r4 == null) goto L39;
        JSONObject r5 = r4.optJSONObject("content");
        if (r5 == null) goto L39;
        JSONObject r6 = r5.optJSONObject("lynx_block");
        if (r6 == null) goto L39;
        String r10 = r6.optString("lynx_data");
        if (r10 == null) goto L39;
        if ((!StringsKt.isBlank(r10)) == true) goto L30;
        r10 = null;
    L30:
        if (r10 == null) goto L39;
        Integer r11 = d(r4, "block_type");
        if (r11 != null) goto L35;
    L37:
        if (r3 != null) goto L39;
        r3 = r10;
        goto L39
    L35:
        if (r11.intValue() != 10067) goto L37;
        return r10;
    L39:
        r2 = r2 + 1;
        goto L16
    L40:
        return r3;
    L12:
        r9 = null;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String b(String... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        String r3 = r6[r2];
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L12:
        if ((true ^ r5) == true) goto L16;
        r2 = r2 + 1;
    L16:
        if (r3 != null) goto L21;
        return "";
    L21:
        return r3;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r5 = false;
        goto L12
    L15:
        r3 = null;
        goto L16
    }

    public static String c(JSONArray r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r4.optString(r1);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 != null) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return "";
    }

    public static JSONObject e(String r2) {
        Object r1 = null;
        if (StringsKt.isBlank(r2) == true) goto L21;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = new JSONTokener(r2).nextValue();     // Catch: Throwable -> L11
        if ((r3 instanceof JSONObject) == false) goto L8;
        JSONObject r4 = (JSONObject) r3;     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L18;
        r1 = r5;
    L18:
        return (JSONObject) r1;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L21:
        return null;
    }

    public static Integer d(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L7:
        return null;
    L5:
        if (r1.isNull(r2) == true) goto L7;
        return Integer.valueOf(r1.optInt(r2));
    }
}

package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public static Integer a(JSONObject r2) {
        if (r2 != null) goto L5;
    L10:
        return null;
    L5:
        if (r2.has("denyType") == false) goto L8;
        return Integer.valueOf(r2.optInt("denyType"));
    L8:
        if (r2.has("deny_type") == false) goto L10;
        return Integer.valueOf(r2.optInt("deny_type"));
    }

    public static Integer b(ErrorResult r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L17;
        if (r4 != null) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L17;
        boolean r2 = false;
    L18:
        Object r5 = null;
        if (r2 == true) goto L21;
        return null;
    L21:
        String r6 = r4.getDebugMsg();
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L66;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L32
        Object r9 = Result.constructor-impl(new JSONObject(r6));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r9) == false) goto L37;
        r9 = null;
    L37:
        JSONObject r10 = (JSONObject) r9;
        if (r10 == null) goto L67;
        Integer r11 = a(r10.optJSONObject("data"));
        if (r11 != null) goto L65;
        String r12 = r10.optString("message");
        Intrinsics.checkNotNull(r12);
        if (r12.length() <= 0) goto L46;
        r0 = true;
    L46:
        if (r0 == true) goto L49;
        r12 = null;
    L49:
        if (r12 == null) goto L68;
        Object r13 = Result.constructor-impl(new JSONObject(r12));     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r13) == true) goto L60;
        r5 = r13;
    L60:
        return a((JSONObject) r5);
    L53:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L68:
        return null;
    L65:
        return Integer.valueOf(r11.intValue());
    L67:
        return null;
    L32:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L66:
        return null;
    L24:
        if (r6.length() == 0) goto L27;
        r7 = false;
        goto L28
    L11:
        if (r4.getStatus() != 220202) goto L13;
        r1 = true;
    L17:
        r2 = true;
        goto L18
    L5:
        if (r4.getCode() != 220202) goto L7;
        r3 = true;
        goto L8
    }
}

package com.larus.voicecall.impl.museum;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final a b(String r17) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r17 != null) goto L5;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        Object r2 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        JSONObject r3 = (JSONObject) r2;
        if (r3 != null) goto L17;
        return null;
    L17:
        if (Intrinsics.areEqual(r3.optString("scene"), "museum_extension_banner") == true) goto L19;
        return null;
    L19:
        JSONObject r4 = a(r3, LynxResourceModule.DATA_KEY);
        if (r4 != null) goto L23;
        return null;
    L23:
        if (Intrinsics.areEqual(r4.optString("banner_source"), "museum_extend_pack") == true) goto L25;
        return null;
    L25:
        JSONObject r5 = a(r4, "ext");
        if (r5 != null) goto L28;
        r5 = new JSONObject();
    L28:
        String r10 = r5.optString("stage");
        if (SetsKt.setOf(new String[]{"start_session_auto", "warning", "no_quota", "hangup"}).contains(r10) == true) goto L31;
        return null;
    L31:
        String r6 = r4.optString("button_text");
        Intrinsics.checkNotNull(r6);
        if ((!StringsKt.isBlank(r6)) == false) goto L34;
        String r11 = r6;
    L35:
        if (r11 != null) goto L37;
        return null;
    L37:
        JSONObject r7 = a(r4, "policy");
        String r8 = r3.optString("title");
        String r9 = r3.optString(LynxAccessibilityModule.MSG_CONTENT);
        String r12 = r3.optString("icon");
        String r13 = r5.optString("museum");
        Intrinsics.checkNotNull(r10);
        Integer r14 = StringsKt.toIntOrNull(r4.optString("priority"));
        if (r14 == null) goto L40;
        int r15 = r14.intValue();
    L41:
        int r16 = r15;
        if (r7 == null) goto L44;
        long r18 = r7.optLong("auto_dismiss_seconds");
    L45:
        long r19 = r18;
        String r20 = r4.optString("conversation_id");
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank(r20)) == false) goto L48;
        String r110 = r20;
    L49:
        String r21 = r5.optString("call_id");
        Intrinsics.checkNotNull(r21);
        if ((!StringsKt.isBlank(r21)) == false) goto L52;
        String r111 = r21;
    L54:
        return new a(r8, r9, r12, r13, r10, r11, r16, r19, r110, r111);
    L52:
        r111 = null;
        goto L54
    L48:
        r110 = null;
        goto L49
    L44:
        r18 = r4.optLong("ttl", 15);
        goto L45
    L40:
        r15 = r4.optInt("priority", 0);
        goto L41
    L34:
        r11 = null;
        goto L35
    L5:
        r1 = r17;
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final String c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(r1.hashCode()) {
            case -1224574323: goto L18;
            case 145397365: goto L14;
            case 991992442: goto L10;
            case 1124446108: goto L6;
            default: goto L25;
        };
    L25:
        return r1;
    L6:
        if (r1.equals("warning") == false) goto L26;
        return "75_percent";
    L26:
        return r1;
    L10:
        if (r1.equals("no_quota") == false) goto L27;
        return "wall";
    L27:
        return r1;
    L14:
        if (r1.equals("start_session_auto") == false) goto L28;
        return "scan_wall_auto";
    L28:
        return r1;
    L18:
        if (r1.equals("hangup") == false) goto L29;
        return "post_call";
    L29:
        return r1;
    }

    public static final JSONObject a(JSONObject r1, String r2) {
        Object r3 = r1.opt(r2);
        if ((r3 instanceof JSONObject) == true) goto L20;
        Object r0 = null;
        if ((r3 instanceof String) == false) goto L17;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        Object r5 = Result.constructor-impl(new JSONObject((String) r3));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == true) goto L21;
        r0 = r5;
    L21:
        return (JSONObject) r0;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r3;
    }
}

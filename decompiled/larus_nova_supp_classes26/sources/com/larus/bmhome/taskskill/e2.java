package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.utils.logger.FLogger;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e2 {
    public static final e2 a = null;

    static {
        a = new e2();
    }

    public e2() {
    }

    public static List a(String r4, Integer r5) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L32;
        FLogger.a.i("SkillTrialSchemaParser", "[parse] payload is blank");
        return CollectionsKt.emptyList();
    L32:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r2 = Result.constructor-impl(b(r4, r5));     // Catch: Throwable -> L14
    L17:
        if (Result.exceptionOrNull-impl(r2) != null) goto L34;
    L24:
        Throwable r6 = Result.exceptionOrNull-impl(r2);
        if (r6 == null) goto L27;
        FLogger.a.w("SkillTrialSchemaParser", "[parse] parse selected_skills failed, msg=" + r6.getMessage());
    L27:
        List r7 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r2) == false) goto L31;
        r2 = r7;
    L31:
        return (List) r2;
    L34:
        e2 r3 = a;     // Catch: Throwable -> L21
        String r8 = URLDecoder.decode(r4, "UTF-8");     // Catch: Throwable -> L21
        r3.getClass();     // Catch: Throwable -> L21
        Object r9 = Result.constructor-impl(b(r8, r5));     // Catch: Throwable -> L21
    L23:
        r2 = r9;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L9
    }

    public static List b(String r19, Integer r20) {
        JSONArray r0 = new JSONArray(r19);
        LinkedHashSet r1 = new LinkedHashSet();
        ArrayList r2 = new ArrayList();
        int r3 = r0.length();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L38;
        JSONObject r6 = r0.optJSONObject(r5);
        if (r6 == null) goto L37;
        String r9 = StringsKt.trim(r6.optString("name")).toString();
        if (StringsKt.isBlank(r9) == true) goto L37;
        if (r1.add(r9) == false) goto L37;
        String r7 = r6.optString("skill_id");
        Intrinsics.checkNotNull(r7);
        boolean r10 = true;
        Integer r11 = null;
        if ((!StringsKt.isBlank(r7)) == true) goto L16;
        r7 = null;
    L16:
        Integer r8 = Integer.valueOf(r6.optInt("skill_type"));
        if (r8.intValue() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L25;
        int r13 = r8.intValue();
    L34:
        int r14 = r13;
    L36:
        r2.add(new TaskSkill(r9, r7, null, r6.optString("display_name"), false, r14, false, null, null, 16308));
        goto L37
    L25:
        if (r20 != null) goto L27;
    L32:
        if (r11 == null) goto L35;
        r13 = r11.intValue();
        goto L34
    L35:
        r14 = 0;
        goto L36
    L27:
        if (r20.intValue() > 0) goto L30;
        r10 = false;
    L30:
        if (r10 == false) goto L32;
        r11 = r20;
        goto L32
    L19:
        r12 = false;
    L37:
        r5 = r5 + 1;
        goto L3
    L38:
        FLogger.a.i("SkillTrialSchemaParser", "[parseJsonArray] selectedCount=" + r2.size());
        return r2;
    }
}

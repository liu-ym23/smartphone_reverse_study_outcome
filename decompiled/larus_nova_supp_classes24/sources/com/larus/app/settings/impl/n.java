package com.larus.app.settings.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n {
    public static final Set<Integer> a = null;

    static {
        a = SetsKt.setOf(new Integer[]{0, 1, 2});
    }

    public static final Integer a(t r5) {
        Map<String, u> r0 = r5.a();
        if (r0 == null) goto L6;
        u r1 = r0.get("2");
        if (r1 == null) goto L6;
    L29:
        s r6 = r1.c();
        if (r6 == null) goto L39;
        Integer r7 = r6.a();
        if (r7 == null) goto L39;
        if (a.contains(Integer.valueOf(r7.intValue())) == true) goto L37;
        r7 = null;
    L37:
        if (r7 == null) goto L39;
        return Integer.valueOf(r7.intValue());
    L39:
        String r8 = r1.b();
        if (r8 != null) goto L42;
        return null;
    L42:
        if ((!StringsKt.isBlank(r8)) == true) goto L45;
        r8 = null;
    L45:
        if (r8 == null) goto L76;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L53
        JSONObject r9 = new JSONObject(r8).optJSONObject("portrait_auth");     // Catch: Throwable -> L53
        if (r9 == null) goto L50;
        Integer r10 = Integer.valueOf(r9.optInt("status", -1));     // Catch: Throwable -> L53
    L51:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r11) == false) goto L58;
        r11 = null;
    L58:
        Integer r12 = (Integer) r11;
        if (r12 != null) goto L61;
        return null;
    L61:
        if (a.contains(Integer.valueOf(r12.intValue())) == true) goto L63;
        return null;
    L63:
        return r12;
    L50:
        r10 = null;
    L53:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L76:
        return null;
    L6:
        Map<String, u> r13 = r5.a();
        if (r13 == null) goto L26;
        Collection<u> r14 = r13.values();
        if (r14 == null) goto L26;
        Iterator<T> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L24;
        Object r4 = r15.next();
        u r16 = (u) r4;
        if (r16 == null) goto L21;
        Integer r17 = r16.a();
        if (r17 == null) goto L21;
        if (r17.intValue() != 2) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L12;
    L25:
        r1 = (u) r4;
    L27:
        if (r1 != null) goto L29;
        return null;
    L21:
        r19 = false;
        goto L22
    L24:
        r4 = null;
    L26:
        r1 = null;
        goto L27
    }

    public static final boolean b(List r4, int r5) {
        if (r4 == null) goto L28;
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Object r1 = r6.next();
        com.larus.uaigc.api.v r3 = (com.larus.uaigc.api.v) r1;
        if (r3 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L6;
    L16:
        com.larus.uaigc.api.v r2 = (com.larus.uaigc.api.v) r1;
        if (r2 != null) goto L20;
        return false;
    L20:
        if (r2.b() != 1) goto L29;
        return true;
    L29:
        return false;
    L10:
        if (r3.a() != r5) goto L12;
        r7 = true;
        goto L13
    L15:
        r1 = null;
        goto L16
    L28:
        return false;
    }
}

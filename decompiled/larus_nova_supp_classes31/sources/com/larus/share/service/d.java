package com.larus.share.service;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter("share_id", "paramKey");
        Intrinsics.checkNotNullParameter(r13, "paramValue");
        if (StringsKt.isBlank(r12) == false) goto L5;
        return r12;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L64;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L53
        URI r2 = new URI(r12);     // Catch: Throwable -> L53
        String r3 = r2.getScheme();     // Catch: Throwable -> L53
        if (r3 == null) goto L10;
        String r4 = r3.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L53
    L12:
        if (Intrinsics.areEqual(r4, "http") == false) goto L14;
    L15:
        String r5 = r2.getHost();     // Catch: Throwable -> L53
        boolean r6 = true;
        if (r5 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == true) goto L31;
        String r8 = c(r12, "share_id");     // Catch: Throwable -> L53
        if (r8 != null) goto L27;
    L30:
        if (r6 == false) goto L31;
        int r9 = StringsKt.indexOf$default(r12, '#', 0, false, 6, null);     // Catch: Throwable -> L53
        if (r9 < 0) goto L36;
        String r10 = r12.substring(0, r9);     // Catch: Throwable -> L53
    L37:
        String r11 = "";
        if (r9 < 0) goto L40;
        String r14 = r12.substring(r9);     // Catch: Throwable -> L53
    L42:
        if (StringsKt.contains$default(r10, '?', false, 2, null) == true) goto L45;
        r11 = "?";
    L50:
        String r15 = r10 + r11 + "share_id=" + URLEncoder.encode(r13, Charsets.UTF_8.name()) + r14;     // Catch: Throwable -> L53
    L51:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L53
    L55:
        Object r17 = r12;
        if (Result.isFailure-impl(r16) == true) goto L60;
        r17 = r16;
    L60:
        return (String) r17;
    L45:
        if (StringsKt.endsWith$default(r10, '?', false, 2, null) == true) goto L50;
        if (StringsKt.endsWith$default(r10, '&', false, 2, null) == true) goto L50;
        r11 = "&";
        goto L50
    L40:
        r14 = "";
        goto L42
    L36:
        r10 = r12;
        goto L37
    L27:
        if (StringsKt.isBlank(r8) == true) goto L30;
        r6 = false;
    L31:
        r15 = r12;
        goto L51
    L18:
        if (StringsKt.isBlank(r5) == true) goto L21;
        r7 = false;
        goto L22
    L14:
        if (Intrinsics.areEqual(r4, "https") == false) goto L31;
    L10:
        r4 = null;
    L53:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L64:
        return r12;
    }

    public static String b(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "baseUrl");
        Intrinsics.checkNotNullParameter(r4, "params");
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        Iterator r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) r6.next();
        String r1 = (String) r0.getKey();
        String r2 = (String) r0.getValue();
        if (r2 == null) goto L4;
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L4;
        r5.appendQueryParameter(r1, r2);
        goto L4
    L14:
        return r5.build().toString();
    }

    public static String c(String r8, String r9) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L41;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(new URI(r8).getRawQuery());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r10) == false) goto L16;
        r10 = null;
    L16:
        String r2 = (String) r10;
        if (r2 == null) goto L42;
        Iterator r11 = StringsKt.split$default(r2, new String[]{"&"}, false, 0, 6, null).iterator();
    L20:
        if (r11.hasNext() == false) goto L43;
        String r3 = (String) r11.next();
        int r4 = StringsKt.indexOf$default(r3, '=', 0, false, 6, null);
        if (r4 > 0) goto L24;
    L29:
        String r5 = null;
    L30:
        if (r5 == null) goto L20;
        return r5;
    L24:
        if (Intrinsics.areEqual(r3.substring(0, r4), r9) == false) goto L29;
        r5 = r3.substring(r4 + 1);
        if ((!StringsKt.isBlank(r5)) == false) goto L29;
    L43:
        return null;
    L42:
        return null;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L41:
        return null;
    }

    @JvmStatic
    public static final String d(JSONObject r7, String r8) {
        String[] r1 = new String[4];
        String r3 = null;
        if (r7 == null) goto L5;
        String r4 = r7.optString("share_id");
    L6:
        r1[0] = r4;
        if (r7 == null) goto L9;
        String r9 = r7.optString("ug_share_id");
    L10:
        r1[1] = r9;
        r1[2] = c(r8, "share_id");
        r1[3] = c(r8, "ug_share_id");
        int r10 = 0;
    L11:
        if (r10 >= 4) goto L26;
        String r11 = r1[r10];
        if (r11 == null) goto L22;
        String r12 = StringsKt.trim(r11).toString();
        if (r12 == null) goto L22;
        if (r12.length() <= 0) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L22;
    L23:
        if (r12 != null) goto L25;
        r10 = r10 + 1;
        goto L11
    L25:
        r3 = r12;
        goto L26
    L19:
        r2 = false;
    L22:
        r12 = null;
    L26:
        if (r3 == null) goto L28;
        return r3;
    L28:
        return "x" + UUID.randomUUID();
    L9:
        r9 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}

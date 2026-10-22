package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.bdinstall.Level;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final String a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r0 = c(r10);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        boolean r11 = true;
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L36;
        String r12 = a36.b.e(r10, "channel");
        String r13 = a36.b.e(r10, "bundle");
        if (r12 != null) goto L13;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == true) goto L28;
        if (r13 != null) goto L20;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L28;
        return r12 + '_' + r13;
    L20:
        if (r13.length() == 0) goto L23;
        r15 = false;
    L28:
        if (r0.length() == 0) goto L31;
        r11 = false;
    L31:
        if (r11 == true) goto L33;
        return r0;
    L33:
        return r10.toString();
    L13:
        if (r12.length() == 0) goto L16;
        r14 = false;
        goto L17
    L36:
        return UriProtector.parse(r0).buildUpon().clearQuery().toString();
    L8:
        r1 = false;
        goto L9
    }

    public static final String c(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r10.getScheme(), "https") == true) goto L13;
        String r0 = a36.b.e(r10, "a_surl");
        if (r0 != null) goto L14;
        String r1 = a36.b.e(r10, "surl");
        if (r1 == null) goto L16;
        return r1;
    L16:
        return a36.b.e(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    L14:
        return r0;
    L13:
        return r10.toString();
    }

    public static final String b(Uri r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter(r21, "bid");
        Intrinsics.checkNotNullParameter(r22, "sessionId");
        String r10 = a36.b.e(r20, "ssr_url");
        Object r11 = null;
        if (r10 != null) goto L56;
        return null;
    L56:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L45
        Uri r13 = UriProtector.parse(r10);     // Catch: Throwable -> L45
        Uri.Builder r14 = r13.buildUpon();     // Catch: Throwable -> L45
        boolean r15 = true;
        if (a36.b.e(r13, "appended_global_props") != null) goto L30;
        String r16 = a36.b.e(r20, "append_global_props");     // Catch: Throwable -> L45
        if (r16 != null) goto L10;
    L18:
        List r17 = null;
    L19:
        List r18 = r17;     // Catch: Throwable -> L45
        if (r18 != null) goto L22;
    L25:
        boolean r19 = true;
    L26:
        if (r19 == true) goto L30;
        if (HybridSecureUtil.a(r13) == false) goto L30;
        ConcurrentHashMap<String, Object> r110 = com.bytedance.android.anniex.ability.f.a;     // Catch: Throwable -> L45
        r14.appendQueryParameter("appended_global_props", new JSONObject(com.bytedance.android.anniex.ability.f.r(r20, r21, r22, r17)).toString());     // Catch: Throwable -> L45
        goto L30
    L22:
        if (r18.isEmpty() == true) goto L25;
        r19 = false;
        goto L26
    L10:
        if (r16.length() <= 0) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L15;
        String r112 = r16;
    L16:
        if (r112 == null) goto L18;
        r17 = StringsKt.split$default(r112, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L45
        goto L19
    L15:
        r112 = null;
        goto L16
    L12:
        r111 = false;
    L30:
        r14.appendQueryParameter("disable_offline", "1");     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(a36.b.e(r13, "append_common_params"), "0") == false) goto L33;
    L35:
        r15 = false;
    L36:
        String r0 = r14.build().toString();     // Catch: Throwable -> L45
        if (r15 == false) goto L43;
        StringBuilder r1 = new StringBuilder(r0);     // Catch: Throwable -> L45
        Lazy r23 = HybridSecureUtil.a;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r13, "uri");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r1, "sb");     // Catch: Throwable -> L45
        if (HybridSecureUtil.a(r13) == false) goto L42;
        boolean r24 = AppLog.L;     // Catch: Throwable -> L45
        eta.b r25 = c0.a;     // Catch: Throwable -> L45
        c0.d(r1, false, Level.L0);     // Catch: Throwable -> L45
    L42:
        r0 = r1.toString();     // Catch: Throwable -> L45
    L43:
        Object r26 = Result.constructor-impl(r0);     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r26) == true) goto L51;
        r11 = r26;
    L51:
        String r27 = (String) r11;
        if (r27 != null) goto L55;
        return r10;
    L55:
        return r27;
    L33:
        if (Intrinsics.areEqual(a36.b.e(r20, "append_common_params"), "1") == false) goto L35;
    L45:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }
}

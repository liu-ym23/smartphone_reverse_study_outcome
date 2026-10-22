package com.larus.browsertakeover.transport;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Map b() {
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == false) goto L5;
        String r1 = r0.getXTTToken();
        if (r1 == null) goto L44;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L44;
        if (r2.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
    L18:
        boolean r4 = false;
    L19:
        String r5 = null;
        if (r4 == true) goto L23;
        r2 = null;
    L23:
        if (r2 == null) goto L44;
        int r6 = 0;
    L26:
        if (r6 >= r2.length()) goto L37;
        char r7 = r2.charAt(r6);
        if (r7 != '\r') goto L30;
    L33:
        boolean r8 = true;
    L34:
        if (r8 == true) goto L35;
        r6 = r6 + 1;
        goto L26
    L35:
        boolean r9 = false;
    L38:
        if (r9 == false) goto L40;
        r5 = r2;
    L40:
        if (r5 == null) goto L44;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("Passport-Auth", "session"), TuplesKt.to("sdk-version", "2"), TuplesKt.to("X-Tt-Token", r5)});
    L30:
        if (r7 == '\n') goto L33;
        r8 = false;
        goto L34
    L37:
        r9 = true;
        goto L38
    L16:
        if (r2.length() > 4096) goto L18;
        r4 = true;
        goto L19
    L13:
        r3 = false;
    L44:
        return MapsKt.emptyMap();
    L5:
        return MapsKt.emptyMap();
    }

    public static void a(Uri r3, Uri.Builder r4, String r5, String r6) {
        boolean r1 = false;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L23;
        return;
    L23:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(UriProtector.getQueryParameter(r3, r5));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r7) == false) goto L15;
        r7 = null;
    L15:
        String r8 = (String) r7;
        if (r8 != null) goto L18;
    L19:
        r1 = true;
    L20:
        if (r1 == false) goto L25;
        r4.appendQueryParameter(r5, r6);
        return;
    L25:
        return;
    L18:
        if (r8.length() != 0) goto L20;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}

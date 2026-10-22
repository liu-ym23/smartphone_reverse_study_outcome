package com.larus.chat.gallery.impl.preview.datasource;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public static String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        String r5 = StringsKt.trim(r4).toString();
        boolean r2 = true;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L28;
        return r5;
    L28:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        String r3 = UriProtector.parse(r5).getScheme();     // Catch: Throwable -> L16
        if (r3 != null) goto L11;
    L13:
        r2 = false;
    L14:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L16
    L18:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = r7;
    L22:
        if (((Boolean) r6).booleanValue() == false) goto L25;
        return r5;
    L25:
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == false) goto L30;
        String r8 = Uri.fromFile(new PolarisFileWrapper(r5)).toString();
        Intrinsics.checkNotNull(r8);
        return r8;
    L30:
        return r5;
    L11:
        if ((!StringsKt.isBlank(r3)) != true) goto L13;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        r0 = false;
        goto L6
    }

    public static String b(String r2) {
        if (r2 != null) goto L5;
    L12:
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        return a(r2);
    }

    public static String c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        String r6 = StringsKt.trim(r5).toString();
        if (r6.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r6 = null;
    L10:
        if (r6 != null) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r6, "/", false, 2, null) == false) goto L34;
        return r6;
    L34:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Object r7 = Result.constructor-impl(UriProtector.parse(r6));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r7) == false) goto L22;
        r7 = null;
    L22:
        Uri r8 = (Uri) r7;
        if (r8 != null) goto L26;
        return null;
    L26:
        if (StringsKt.equals(r8.getScheme(), ShareType.FILE, true) == true) goto L28;
        return null;
    L28:
        String r9 = r8.getPath();
        if (r9 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r9)) == true) goto L33;
        return null;
    L33:
        return r9;
    L17:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r0 = false;
        goto L7
    }

    public static String d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        String r4 = StringsKt.trim(r3).toString();
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith(r4, "content://", true) == false) goto L16;
        return null;
    L16:
        if (c(r4) == null) goto L18;
        return null;
    L18:
        return a(r4);
    L5:
        r0 = false;
        goto L7
    }
}

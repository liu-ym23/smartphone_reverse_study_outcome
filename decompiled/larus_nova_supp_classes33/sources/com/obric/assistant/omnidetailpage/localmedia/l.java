package com.obric.assistant.omnidetailpage.localmedia;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public static String b(String r5) {
        boolean r0 = true;
        if (r5 == null) goto L33;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L33;
        if (r6.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L33;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
        if (StringsKt.startsWith(r6, "content://", true) == false) goto L19;
    L24:
        r6 = null;
    L25:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r7) == false) goto L32;
        r7 = null;
    L32:
        String r8 = (String) r7;
    L34:
        if (r8 != null) goto L36;
        return null;
    L36:
        PolarisFileWrapper r9 = new PolarisFileWrapper(r8);
        String r10 = r9.getAbsolutePath();
        if (r9.isFile() == true) goto L39;
    L41:
        r0 = false;
    L42:
        if (r0 == true) goto L44;
        return null;
    L44:
        return r10;
    L39:
        if (r9.canRead() == false) goto L41;
    L19:
        if (StringsKt.startsWith(r6, "file://", true) == false) goto L22;
        r6 = UriProtector.parse(r6).getPath();     // Catch: Throwable -> L27
        goto L25
    L22:
        if (StringsKt.startsWith$default(r6, "/", false, 2, null) == false) goto L24;
    L27:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L9:
        r3 = false;
    L33:
        r8 = null;
        goto L34
    }

    public static String c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        return Uri.fromFile(new PolarisFileWrapper(r1)).toString();
    }

    public static void a(String r3, String r4, String r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("filter local resource, blockId=");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r1.append(r3);
        r1.append(", type=");
        r1.append(r4);
        r1.append(", reason=");
        r1.append(r5);
        r0.i("OmniLocalResourceAccess", r1.toString());
    }
}

package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "localResPath");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r3));     // Catch: Throwable -> L5
    L7:
        String r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        Uri r4 = (Uri) r1;
        if (r4 == null) goto L13;
        r2 = r4.getScheme();
    L13:
        if (r2 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L24;
        String r6 = Uri.fromFile(new PolarisFileWrapper(r3)).toString();
        Intrinsics.checkNotNull(r6);
        return r6;
    L24:
        return r3;
    L15:
        if (StringsKt.isBlank(r2) == true) goto L18;
        r5 = false;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}

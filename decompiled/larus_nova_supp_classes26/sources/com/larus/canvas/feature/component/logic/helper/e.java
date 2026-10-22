package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.canvas.feature.component.base.HttpUrl;
import com.larus.canvas.feature.component.base.ImageRes;
import com.larus.canvas.feature.component.base.LocalFilePath;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ky8.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final ImageRes a(j r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ImageRes r1 = null;
        String r2 = "";
        if (o0.d(r6.e) == false) goto L44;
        String r0 = r6.e;
        if (r0 != null) goto L51;
        r0 = "";
    L51:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(y0.j(r0));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = null;
    L14:
        Uri r5 = (Uri) r4;
        if (r5 == null) goto L36;
        String r7 = r5.getScheme();
        if (r7 != null) goto L20;
    L25:
        Uri r8 = y0.j(a.a(r0));
        if (r8 == null) goto L28;
        String r9 = r8.getPath();
    L29:
        if (r9 != null) goto L31;
        r9 = "";
    L31:
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9);
        if (r10.exists() == false) goto L36;
        if (r10.isFile() == false) goto L36;
    L35:
        boolean r11 = true;
    L37:
        if (r11 == false) goto L44;
        String r12 = r6.e;
        if (r12 == null) goto L42;
        r2 = r12;
    L42:
        r1 = new LocalFilePath(r2);
    L50:
        return r1;
    L28:
        r9 = null;
        goto L29
    L20:
        if (r7.hashCode() != 951530617) goto L25;
        if (r7.equals("content") == false) goto L25;
    L36:
        r11 = false;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        if (o0.d(r6.b) == false) goto L50;
        String r14 = r6.b;
        if (r14 == null) goto L49;
        r2 = r14;
    L49:
        r1 = new HttpUrl(r2);
        goto L50
    }
}

package com.larus.dora.impl.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ d(DoraFileFetchManager r1, String r2) {
        this.a = r2;
    }

    public final Object invoke(Object r6) {
        String r0 = this.a;
        File r7 = (File) r6;
        Intrinsics.checkNotNullParameter(r7, "dir");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(r7.getCanonicalFile());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        File r9 = (File) r8;
        if (r9 == null) goto L36;
        Object r2 = Result.constructor-impl(new PolarisFileWrapper(r9, r0).getCanonicalFile());     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r2) == false) goto L20;
        r2 = null;
    L20:
        File r3 = (File) r2;
        if (r3 == null) goto L37;
        String r10 = r9.getPath() + File.separator;
        boolean r4 = false;
        if (r3.isFile() == true) goto L26;
    L28:
        if (r4 == true) goto L30;
        return null;
    L30:
        return r3;
    L26:
        if (StringsKt.startsWith$default(r3.getPath(), r10, false, 2, null) == false) goto L28;
        r4 = true;
        goto L28
    L37:
        return null;
    L15:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L36:
        return null;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}

package com.ss.android.lark.richtextmd.parse.plugins;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i<T extends s> implements t {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        a r0 = this.a;
        String r1 = r10.d.j;
        r0.getClass();
        Object r2 = "[Image]";
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Context r4 = UIHelper.getContext();     // Catch: Throwable -> L9
        int r5 = r4.getResources().getIdentifier("Lark_Legacy_ImageSummarize", "string", r4.getPackageName());     // Catch: Throwable -> L9
        if (r5 != 0) goto L6;
        String r6 = "[Image]";
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r2 = r7;
    L15:
        r0.getClass();
        Regex r8 = a.d;
        String r9 = r8.replace(r1, (String) r2);
        if (this.a.a.b == true) goto L18;
        r9 = StringsKt.replace$default(r9, '\n', ' ', false, 4, null);
    L18:
        r10.g.d(r9);
        return;
    L6:
        r6 = r4.getString(r5);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}

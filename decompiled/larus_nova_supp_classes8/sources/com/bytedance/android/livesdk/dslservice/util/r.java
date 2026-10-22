package com.bytedance.android.livesdk.dslservice.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r2) {
        if (r2 != null) goto L17;
        return;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        if (r2.getParent() == null) goto L12;
        ViewParent r1 = r2.getParent();     // Catch: Throwable -> L14
        if ((r1 instanceof ViewGroup) == true) goto L9;
        r1 = null;
    L9:
        ViewGroup r3 = (ViewGroup) r1;     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        r3.removeView(r2);     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}

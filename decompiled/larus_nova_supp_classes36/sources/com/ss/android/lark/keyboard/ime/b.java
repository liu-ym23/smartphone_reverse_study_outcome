package com.ss.android.lark.keyboard.ime;

import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void a(String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (KeyboardBaseModule.a().isFeatureGatingEnable("messenger.im.disable_ime_diag_log") == true) goto L6;
        boolean r1 = true;
    L7:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L9
    L11:
        Boolean r5 = Boolean.TRUE;
        if (Result.isFailure-impl(r2) == false) goto L15;
        r2 = r5;
    L15:
        if (((Boolean) r2).booleanValue() == false) goto L20;
        Log.i(r3, (String) r4.invoke());
        return;
    L20:
        return;
    L6:
        r1 = false;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}

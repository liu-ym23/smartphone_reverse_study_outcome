package com.obric.assistant.spi.keyguard;

import android.os.Handler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oga.e;
import oga.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static void b(boolean r8, Function0 r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        boolean r5 = false;
    L6:
        Intrinsics.checkNotNullParameter(r9, "onSucceeded");
        IKeyguardService$a.a(KeyguardService.a, new f(r9), false, false, false, r5, null, 14);
        return;
    L5:
        r5 = r8;
        goto L6
    }

    public static void a(Function0 r8, Function0 r9, Handler r10, boolean r11, int r12) {
        if ((r12 & 4) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 8) == 0) goto L8;
        boolean r5 = false;
    L9:
        Intrinsics.checkNotNullParameter(r8, "onSucceeded");
        Intrinsics.checkNotNullParameter(r9, "onFailed");
        IKeyguardService$a.a(KeyguardService.a, new e(r10, r8, r9), false, false, false, r5, null, 14);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}

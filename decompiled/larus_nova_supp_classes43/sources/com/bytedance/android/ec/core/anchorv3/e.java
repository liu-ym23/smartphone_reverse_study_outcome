package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements Runnable {
    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        int r1 = ECSdk.a;     // Catch: Throwable -> L8
        ba3.a r10 = (ba3.a) ECSdk.a(ba3.a.class);     // Catch: Throwable -> L8
        if (r10 == null) goto L5;
        r10.a();     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r11);     // Catch: Throwable -> L8
        return;
    L5:
        r11 = null;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }
}

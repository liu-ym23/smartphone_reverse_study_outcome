package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Runnable {
    public final /* synthetic */ NewProfileEnterExitUseCase.b a;

    public b(NewProfileEnterExitUseCase.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NewProfileEnterExitUseCase.b r0 = this.a;     // Catch: Throwable -> L7
        NewProfileEnterExitUseCase r1 = r0.a;     // Catch: Throwable -> L7
        Function0 r2 = r0.c;     // Catch: Throwable -> L7
        Animator r3 = r1.e;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.end();     // Catch: Throwable -> L7
    L5:
        ValueAnimator r4 = r1.c(r1.b, true);     // Catch: Throwable -> L7
        r4.addListener(new c(r1, r2));     // Catch: Throwable -> L7
        r4.start();     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r1.e = r4;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}

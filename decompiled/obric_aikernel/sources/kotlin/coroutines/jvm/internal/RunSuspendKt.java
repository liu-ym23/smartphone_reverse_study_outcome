package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class RunSuspendKt {
    @SinceKotlin(version = "1.3")
    public static final void runSuspend(Function1<? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        RunSuspend r11 = new RunSuspend();
        ContinuationKt.startCoroutine(r10, r11);
        r11.await();
    }
}

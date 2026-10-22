package kotlin.coroutines.intrinsics;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final class IntrinsicsKt extends IntrinsicsKt__IntrinsicsKt {
    private IntrinsicsKt() {
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <T> Continuation<Unit> createCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        return IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        return IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(r10, r11, r12);
    }

    public static /* bridge */ /* synthetic */ Object getCOROUTINE_SUSPENDED() {
        return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <T> Continuation<T> intercepted(Continuation<? super T> r10) {
        return IntrinsicsKt__IntrinsicsJvmKt.intercepted(r10);
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ <R, P, T> Object wrapWithContinuationImpl(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> r10, R r11, P r12, Continuation<? super T> r13) {
        return IntrinsicsKt__IntrinsicsJvmKt.wrapWithContinuationImpl(r10, r11, r12, r13);
    }
}

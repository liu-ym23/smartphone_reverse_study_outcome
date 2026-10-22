package com.larus.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.CoroutineScopeExtKt$debounceCoroutine$1$1", f = "CoroutineScopeExt.kt", i = {}, l = {25, 26}, m = "invokeSuspend", n = {}, s = {})
final class CoroutineScopeExtKt$debounceCoroutine$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ long $delayMillis;
    int label;

    public CoroutineScopeExtKt$debounceCoroutine$1$1(long r1, Function1<? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super CoroutineScopeExtKt$debounceCoroutine$1$1> r4) {
        this.$delayMillis = r1;
        this.$block = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoroutineScopeExtKt$debounceCoroutine$1$1(this.$delayMillis, this.$block, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Function1<Continuation<? super Unit>, Object> r8 = this.$block;
        this.label = 2;
        if (r8.invoke(this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        long r4 = this.$delayMillis;
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L13;
        return r0;
    }
}

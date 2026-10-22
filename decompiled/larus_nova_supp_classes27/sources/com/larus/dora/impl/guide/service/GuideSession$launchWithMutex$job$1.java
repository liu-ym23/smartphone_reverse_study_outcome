package com.larus.dora.impl.guide.service;

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
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launchWithMutex$job$1", f = "DoraGuideServiceImpl.kt", i = {0, 1}, l = {669, 341}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class GuideSession$launchWithMutex$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$launchWithMutex$job$1(GuideSession r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super GuideSession$launchWithMutex$job$1> r3) {
        this.this$0 = r1;
        this.$block = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GuideSession$launchWithMutex$job$1(this.this$0, this.$block, r4);
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
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        a r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L9
    L21:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r2.unlock(null);
        return Unit.INSTANCE;
    L9:
        Throwable th = th;
    L26:
        r2.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function1<Continuation<? super Unit>, Object> r3 = (Function1) this.L$1;
        a r4 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);
        a r9 = r4;
    L30:
        this.L$0 = r9;     // Catch: Throwable -> L24
        this.L$1 = null;     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        if (r3.invoke(this) != r0) goto L20;
        return r0;
    L20:
        r2 = r9;
    L24:
        th = move-exception;
        r2 = r9;
        th = th;
        goto L26
    L14:
        ResultKt.throwOnFailure(r7);
        r9 = this.this$0.l;
        r3 = this.$block;
        this.L$0 = r9;
        this.L$1 = r3;
        this.label = 1;
        if (r9.a(null, this) != r0) goto L30;
        return r0;
    }
}

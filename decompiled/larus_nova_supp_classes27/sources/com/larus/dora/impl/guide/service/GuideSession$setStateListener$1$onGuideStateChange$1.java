package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$setStateListener$1$onGuideStateChange$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {603}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$setStateListener$1$onGuideStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l $interactor;
    final /* synthetic */ int $prevState;
    final /* synthetic */ int $state;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$setStateListener$1$onGuideStateChange$1(GuideSession r1, l r2, int r3, int r4, Continuation<? super GuideSession$setStateListener$1$onGuideStateChange$1> r5) {
        this.this$0 = r1;
        this.$interactor = r2;
        this.$state = r3;
        this.$prevState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        GuideSession$setStateListener$1$onGuideStateChange$1 r6 = new GuideSession$setStateListener$1$onGuideStateChange$1(this.this$0, this.$interactor, this.$state, this.$prevState, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        GuideSession r2 = this.this$0;
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L21;
        g49.d.c(r2.c(), "guideListener.invoke exception: " + r12.getMessage(), r12);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        GuideSession r14 = this.this$0;
        l r5 = this.$interactor;
        int r6 = this.$state;
        int r7 = this.$prevState;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        GuideSession$setStateListener$1$onGuideStateChange$1$1$1 r4 = new GuideSession$setStateListener$1$onGuideStateChange$1$1$1(r14, r5, r6, r7, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        int r8 = GuideSession.m;     // Catch: Throwable -> L15
        r14.getClass();     // Catch: Throwable -> L15
        if (GuideSession.f(r4, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}

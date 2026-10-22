package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$setStateListener$1$onGuideStateChange$1$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$setStateListener$1$onGuideStateChange$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ l $interactor;
    final /* synthetic */ int $prevState;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$setStateListener$1$onGuideStateChange$1$1$1(GuideSession r1, l r2, int r3, int r4, Continuation<? super GuideSession$setStateListener$1$onGuideStateChange$1$1$1> r5) {
        this.this$0 = r1;
        this.$interactor = r2;
        this.$state = r3;
        this.$prevState = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new GuideSession$setStateListener$1$onGuideStateChange$1$1$1(this.this$0, this.$interactor, this.$state, this.$prevState, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        GuideSession r6 = this.this$0;
        r6.h.invoke(Boxing.boxInt(r6.a), Boxing.boxInt(this.$interactor.f()), Boxing.boxInt(this.$state), Boxing.boxInt(this.$prevState));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

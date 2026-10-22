package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$setStateListener$1$onReadyShowNextGuide$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$setStateListener$1$onReadyShowNextGuide$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ l $interactor;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$setStateListener$1$onReadyShowNextGuide$1(GuideSession r1, l r2, Continuation<? super GuideSession$setStateListener$1$onReadyShowNextGuide$1> r3) {
        this.this$0 = r1;
        this.$interactor = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GuideSession$setStateListener$1$onReadyShowNextGuide$1(this.this$0, this.$interactor, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        GuideSession r5 = this.this$0;
        if (r5.c != GuideSession.GuideSessionState.FINISHED) goto L9;
        g49.d.e(r5.c(), "onReadyShowNextGuide ignored: session already finished");
        return Unit.INSTANCE;
    L9:
        if (r5.i != this.$interactor) goto L11;
        r5.i = null;
    L11:
        r5.e(new GuideSession$launchNextGuide$1(r5, null));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

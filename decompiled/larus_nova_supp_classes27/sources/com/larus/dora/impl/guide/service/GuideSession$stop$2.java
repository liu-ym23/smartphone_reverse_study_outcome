package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$stop$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$stop$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$stop$2(GuideSession r1, Continuation<? super GuideSession$stop$2> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new GuideSession$stop$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r9);
        this.this$0.h(GuideSession.GuideSessionState.FINISHED);     // Catch: Exception -> L10
        GuideSession r10 = this.this$0;     // Catch: Exception -> L10
        l r1 = r10.i;     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        BuildersKt.launch$default(r10.g, null, null, new GuideSession$stop$2$1$1(r10, r1, null), 3, null);     // Catch: Exception -> L10
    L8:
        g49.d.d(this.this$0.c(), "endGuideSession done id=" + this.this$0.a);     // Catch: Exception -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        g49.d.c(this.this$0.c(), "endGuideSession failed: " + e.getMessage(), e);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

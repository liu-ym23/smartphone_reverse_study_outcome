package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.DoraGuideServiceImpl$launchGuideSession$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
final class DoraGuideServiceImpl$launchGuideSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuideSession $session;
    int label;
    final /* synthetic */ DoraGuideServiceImpl this$0;

    public DoraGuideServiceImpl$launchGuideSession$2(DoraGuideServiceImpl r1, GuideSession r2, Continuation<? super DoraGuideServiceImpl$launchGuideSession$2> r3) {
        this.this$0 = r1;
        this.$session = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGuideServiceImpl$launchGuideSession$2(this.this$0, this.$session, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (((Boolean) r8).booleanValue() == true) goto L24;
        g49.d.b("DoraGuideServiceImpl", "launchGuideSession orchestrator aborted: init not ready");
        return Unit.INSTANCE;
    L24:
        GuideSession r9 = this.$session;     // Catch: Exception -> L20
        i59.b r2 = this.this$0.a;     // Catch: Exception -> L20
        if (r2 != null) goto L18;
        new i59.c();     // Catch: Exception -> L20
        r2 = i59.c.a();     // Catch: Exception -> L20
    L18:
        r9.b = r2;     // Catch: Exception -> L20
        this.$session.d();     // Catch: Exception -> L20
    L23:
        return Unit.INSTANCE;
    L20:
        e = move-exception;
        g49.d.c("DoraGuideServiceImpl", "launchGuideSession failed: " + e.getMessage(), e);
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        DoraGuideServiceImpl r3 = this.this$0;
        this.label = 1;
        int r10 = DoraGuideServiceImpl.e;
        r8 = r3.c(5000, 500, this);
        if (r8 != r0) goto L12;
        return r0;
    }
}

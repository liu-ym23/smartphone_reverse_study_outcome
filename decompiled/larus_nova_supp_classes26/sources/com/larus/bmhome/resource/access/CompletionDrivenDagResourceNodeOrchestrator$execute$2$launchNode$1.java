package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1", f = "ResourceAccessPipeline.kt", i = {}, l = {482, 481}, m = "invokeSuspend", n = {}, s = {})
final class CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<m0> $completedResults;
    final /* synthetic */ h0 $context;
    final /* synthetic */ l0 $node;
    final /* synthetic */ f $task;
    Object L$0;
    int label;

    public CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1(Channel<m0> r1, f r2, h0 r3, l0 r4, Continuation<? super CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1> r5) {
        this.$completedResults = r1;
        this.$task = r2;
        this.$context = r3;
        this.$node = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1(this.$completedResults, this.$task, this.$context, this.$node, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Channel<m0> r2 = (Channel) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r2.send(r12, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        r2 = this.$completedResults;
        ResourceNodeRunner r4 = ResourceNodeRunner.a;
        f r5 = this.$task;
        h0 r6 = this.$context;
        l0 r7 = this.$node;
        this.L$0 = r2;
        this.label = 1;
        r12 = r4.a(r5, r6, r7, true, false, this);
        if (r12 != r0) goto L13;
        return r0;
    }
}

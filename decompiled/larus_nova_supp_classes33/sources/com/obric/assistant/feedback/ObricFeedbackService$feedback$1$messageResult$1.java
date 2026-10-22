package com.obric.assistant.feedback;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/feedback/ObricFeedbackService$FeedbackMessageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.ObricFeedbackService$feedback$1$messageResult$1", f = "ObricFeedbackService.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class ObricFeedbackService$feedback$1$messageResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricFeedbackService$b>, Object> {
    final /* synthetic */ List<String> $messageIds;
    final /* synthetic */ Set<String> $queryMessageIds;
    int label;
    final /* synthetic */ ObricFeedbackService this$0;

    public ObricFeedbackService$feedback$1$messageResult$1(Set<String> r1, ObricFeedbackService r2, List<String> r3, Continuation<? super ObricFeedbackService$feedback$1$messageResult$1> r4) {
        this.$queryMessageIds = r1;
        this.this$0 = r2;
        this.$messageIds = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricFeedbackService$feedback$1$messageResult$1(this.$queryMessageIds, this.this$0, this.$messageIds, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ObricFeedbackService$b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L17:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (this.$queryMessageIds.isEmpty() == false) goto L12;
        return null;
    L12:
        ObricFeedbackService r7 = this.this$0;
        Set<String> r2 = this.$queryMessageIds;
        Set r3 = CollectionsKt.toSet(this.$messageIds);
        this.label = 1;
        int r4 = ObricFeedbackService.e;
        r7.getClass();
        j r8 = new j(IntrinsicsKt.intercepted(this), 1);
        r8.C();
        com.larus.im.d.e().d(r2, new c(r3, r8));
        r6 = r8.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r6 != r0) goto L17;
        return r0;
    }
}

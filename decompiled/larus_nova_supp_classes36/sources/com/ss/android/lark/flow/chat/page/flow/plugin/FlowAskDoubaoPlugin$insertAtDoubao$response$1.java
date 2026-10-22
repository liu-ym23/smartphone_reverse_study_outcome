package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/pb/contact/v2/PullDoubaoChatterResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowAskDoubaoPlugin$insertAtDoubao$response$1", f = "FlowAskDoubaoPlugin.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
final class FlowAskDoubaoPlugin$insertAtDoubao$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PullDoubaoChatterResponse>, Object> {
    final /* synthetic */ PullDoubaoChatterRequest.Builder $builder;
    final /* synthetic */ FlowAskDoubaoPlugin.a $service;
    int label;

    public FlowAskDoubaoPlugin$insertAtDoubao$response$1(FlowAskDoubaoPlugin.a r1, PullDoubaoChatterRequest.Builder r2, Continuation<? super FlowAskDoubaoPlugin$insertAtDoubao$response$1> r3) {
        this.$service = r1;
        this.$builder = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowAskDoubaoPlugin$insertAtDoubao$response$1(this.$service, this.$builder, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super PullDoubaoChatterResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L15:
        com.larksuite.rucket.job.base.b r5 = (com.larksuite.rucket.job.base.b) r4;
        if (r5 != null) goto L20;
    L18:
        return null;
    L20:
        return (PullDoubaoChatterResponse) r5.b();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        FlowAskDoubaoPlugin.a r6 = this.$service;
        if (r6 == null) goto L18;
        RucketJob<PullDoubaoChatterResponse> r7 = r6.getDoubaoChatter(this.$builder.build());
        if (r7 == null) goto L18;
        this.label = 1;
        r4 = r7.awaitGet(this);
        if (r4 != r0) goto L15;
        return r0;
    }
}

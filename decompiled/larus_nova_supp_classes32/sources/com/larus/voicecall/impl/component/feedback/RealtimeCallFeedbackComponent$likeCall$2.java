package com.larus.voicecall.impl.component.feedback;

import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.network.bean.BizResponse;
import com.larus.voicecall.impl.component.feedback.api.RealtimeCallFeedbackApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackSubmitResponse;", "Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent$likeCall$2", f = "RealtimeCallFeedbackComponent.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFeedbackComponent$likeCall$2 extends SuspendLambda implements Function2<RealtimeCallFeedbackApi, Continuation<? super BizResponse<i3a.c>>, Object> {
    final /* synthetic */ Map<String, String> $extra;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RealtimeCallFeedbackComponent this$0;

    public RealtimeCallFeedbackComponent$likeCall$2(RealtimeCallFeedbackComponent r1, Map<String, String> r2, Continuation<? super RealtimeCallFeedbackComponent$likeCall$2> r3) {
        this.this$0 = r1;
        this.$extra = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RealtimeCallFeedbackComponent$likeCall$2 r0 = new RealtimeCallFeedbackComponent$likeCall$2(this.this$0, this.$extra, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(RealtimeCallFeedbackApi r1, Continuation<? super BizResponse<i3a.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((RealtimeCallFeedbackApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        RealtimeCallFeedbackApi r9 = (RealtimeCallFeedbackApi) this.L$0;
        RealtimeCallFeedbackComponent r3 = this.this$0;
        int r4 = RealtimeCallFeedbackComponent.u;
        i3a.b r2 = new i3a.b(r3.m3().e, new i3a.a(Boxing.boxInt(MsgFeedbackType.MsgFeedbackTypeLike.value), 6), this.$extra);
        this.label = 1;
        r8 = r9.feedbackSubmit(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}

package com.larus.voicecall.impl.component.feedback;

import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.network.bean.BizResponse;
import com.larus.voicecall.impl.component.feedback.api.RealtimeCallFeedbackApi;
import java.util.List;
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
@DebugMetadata(c = "com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent$dislikeCall$2", f = "RealtimeCallFeedbackComponent.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFeedbackComponent$dislikeCall$2 extends SuspendLambda implements Function2<RealtimeCallFeedbackApi, Continuation<? super BizResponse<i3a.c>>, Object> {
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $feedbackDetailContent;
    final /* synthetic */ List<Integer> $feedbackDetailTypes;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RealtimeCallFeedbackComponent this$0;

    public RealtimeCallFeedbackComponent$dislikeCall$2(RealtimeCallFeedbackComponent r1, List<Integer> r2, String r3, Map<String, String> r4, Continuation<? super RealtimeCallFeedbackComponent$dislikeCall$2> r5) {
        this.this$0 = r1;
        this.$feedbackDetailTypes = r2;
        this.$feedbackDetailContent = r3;
        this.$extra = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        RealtimeCallFeedbackComponent$dislikeCall$2 r6 = new RealtimeCallFeedbackComponent$dislikeCall$2(this.this$0, this.$feedbackDetailTypes, this.$feedbackDetailContent, this.$extra, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(RealtimeCallFeedbackApi r1, Continuation<? super BizResponse<i3a.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((RealtimeCallFeedbackApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        RealtimeCallFeedbackApi r10 = (RealtimeCallFeedbackApi) this.L$0;
        RealtimeCallFeedbackComponent r3 = this.this$0;
        int r4 = RealtimeCallFeedbackComponent.u;
        i3a.b r2 = new i3a.b(r3.m3().e, new i3a.a(Boxing.boxInt(MsgFeedbackType.MsgFeedbackTypeDislike.value), this.$feedbackDetailTypes, this.$feedbackDetailContent), this.$extra);
        this.label = 1;
        r9 = r10.feedbackSubmit(r2, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}

package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$startOrJoin$1$3$deferred$1", f = "MentionRecommendStore.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_5}, m = "invokeSuspend", n = {}, s = {})
public final class MentionRecommendStore$startOrJoin$1$3$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
    final /* synthetic */ qp8.e $config;
    final /* synthetic */ MentionRecommendStore.b $key;
    final /* synthetic */ MentionRecommendStore $this_run;
    int label;

    public MentionRecommendStore$startOrJoin$1$3$deferred$1(MentionRecommendStore r1, qp8.e r2, MentionRecommendStore.b r3, Continuation<? super MentionRecommendStore$startOrJoin$1$3$deferred$1> r4) {
        this.$this_run = r1;
        this.$config = r2;
        this.$key = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MentionRecommendStore$startOrJoin$1$3$deferred$1(this.$this_run, this.$config, this.$key, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MentionRecommendStore r6 = this.$this_run;
        qp8.e r2 = this.$config;
        MentionRecommendStore.b r3 = this.$key;
        this.label = 1;
        r5 = MentionRecommendStore.a(r6, r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}

package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadMore$1$nextPage$1", f = "MentionPanelController.kt", i = {}, l = {843}, m = "invokeSuspend", n = {}, s = {})
public final class MentionPanelController$loadMore$1$nextPage$1 extends SuspendLambda implements Function1<Continuation<? super f0>, Object> {
    final /* synthetic */ String $cursor;
    final /* synthetic */ MentionSearchDomain $domain;
    final /* synthetic */ String $query;
    int label;

    public MentionPanelController$loadMore$1$nextPage$1(String r1, MentionSearchDomain r2, String r3, Continuation<? super MentionPanelController$loadMore$1$nextPage$1> r4) {
        this.$query = r1;
        this.$domain = r2;
        this.$cursor = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MentionPanelController$loadMore$1$nextPage$1(this.$query, this.$domain, this.$cursor, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super f0> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MentionSearchRepository r7 = MentionSearchRepository.a;
        String r2 = this.$query;
        MentionSearchDomain r3 = this.$domain;
        String r4 = this.$cursor;
        this.label = 1;
        r6 = r7.f(r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}

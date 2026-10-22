package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/larus/bmhome/input/api/officemention/OfficeMentionContact;", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$fetchAndCache$2", f = "MentionRecommendStore.kt", i = {0}, l = {139, 139}, m = "invokeSuspend", n = {"recommendationRequest"}, s = {"L$0"})
final class MentionRecommendStore$fetchAndCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends qp8.c>, ? extends f0>>, Object> {
    final /* synthetic */ qp8.e $config;
    final /* synthetic */ MentionRecommendStore.b $key;
    private /* synthetic */ Object L$0;
    int label;

    public MentionRecommendStore$fetchAndCache$2(MentionRecommendStore.b r1, qp8.e r2, Continuation<? super MentionRecommendStore$fetchAndCache$2> r3) {
        this.$key = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MentionRecommendStore$fetchAndCache$2 r0 = new MentionRecommendStore$fetchAndCache$2(this.$key, this.$config, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<? extends List<qp8.c>, f0>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        return TuplesKt.to(r2, r13);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r13);
    L14:
        this.L$0 = r13;
        this.label = 2;
        Object r4 = r3.await(this);
        if (r4 != r0) goto L17;
        return r0;
    L17:
        r2 = r13;
        r13 = r4;
        goto L19
    L10:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        Deferred r5 = BuildersKt.async$default(r14, null, null, new MentionRecommendStore$fetchAndCache$2$contactsRequest$1(this.$key, this.$config, null), 3, null);
        Deferred r15 = BuildersKt.async$default(r14, null, null, new MentionRecommendStore$fetchAndCache$2$recommendationRequest$1(this.$key, null), 3, null);
        this.L$0 = r15;
        this.label = 1;
        Object r6 = r5.await(this);
        if (r6 != r0) goto L13;
        return r0;
    L13:
        r3 = r15;
        r13 = r6;
        goto L14
    }
}

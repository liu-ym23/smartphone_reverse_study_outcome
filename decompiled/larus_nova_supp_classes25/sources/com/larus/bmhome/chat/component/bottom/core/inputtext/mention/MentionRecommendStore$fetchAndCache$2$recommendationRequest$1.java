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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$fetchAndCache$2$recommendationRequest$1", f = "MentionRecommendStore.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
public final class MentionRecommendStore$fetchAndCache$2$recommendationRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
    final /* synthetic */ MentionRecommendStore.b $key;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$fetchAndCache$2$recommendationRequest$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$fetchAndCache$2$recommendationRequest$1$1", f = "MentionRecommendStore.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super f0>, Object> {
        final /* synthetic */ MentionRecommendStore.b $key;
        int label;

        public AnonymousClass1(MentionRecommendStore.b r1, Continuation<? super AnonymousClass1> r2) {
            this.$key = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass1(this.$key, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super f0> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MentionSearchRepository r5 = MentionSearchRepository.a;
            boolean r2 = this.$key.d;
            this.label = 1;
            r4 = r5.h(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public MentionRecommendStore$fetchAndCache$2$recommendationRequest$1(MentionRecommendStore.b r1, Continuation<? super MentionRecommendStore$fetchAndCache$2$recommendationRequest$1> r2) {
        this.$key = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MentionRecommendStore$fetchAndCache$2$recommendationRequest$1(this.$key, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        MentionRecommendStore r7 = MentionRecommendStore.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.$key, null);
        this.label = 1;
        r6 = MentionRecommendStore.b(r7, r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}

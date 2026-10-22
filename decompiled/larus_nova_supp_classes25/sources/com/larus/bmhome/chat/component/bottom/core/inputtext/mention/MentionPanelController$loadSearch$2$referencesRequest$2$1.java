package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadSearch$2$referencesRequest$2$1", f = "MentionPanelController.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class MentionPanelController$loadSearch$2$referencesRequest$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
    final /* synthetic */ List<MentionSearchDomain> $domains;
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadSearch$2$referencesRequest$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadSearch$2$referencesRequest$2$1$1", f = "MentionPanelController.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super f0>, Object> {
        final /* synthetic */ List<MentionSearchDomain> $domains;
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String r1, List<? extends MentionSearchDomain> r2, Continuation<? super AnonymousClass1> r3) {
            this.$query = r1;
            this.$domains = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.$query, this.$domains, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super f0> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
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
            MentionSearchRepository r6 = MentionSearchRepository.a;
            String r2 = this.$query;
            List<MentionSearchDomain> r3 = this.$domains;
            this.label = 1;
            r5 = r6.g(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MentionPanelController$loadSearch$2$referencesRequest$2$1(MentionPanelController r1, String r2, List<? extends MentionSearchDomain> r3, Continuation<? super MentionPanelController$loadSearch$2$referencesRequest$2$1> r4) {
        this.this$0 = r1;
        this.$query = r2;
        this.$domains = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MentionPanelController$loadSearch$2$referencesRequest$2$1(this.this$0, this.$query, this.$domains, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        f0 r8 = (f0) r7;
        if (r8 == null) goto L14;
        return r8;
    L14:
        return new f0(null, null, null, null, 31);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MentionPanelController r9 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(this.$query, this.$domains, null);
        this.label = 1;
        r7 = MentionPanelController.a(r9, r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}

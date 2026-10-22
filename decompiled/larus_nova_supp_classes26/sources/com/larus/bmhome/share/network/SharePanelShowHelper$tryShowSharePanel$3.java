package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper$tryShowSharePanel$3", f = "SharePanelShowHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SharePanelShowHelper$tryShowSharePanel$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SharePanelShowHelper this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.share.network.SharePanelShowHelper$tryShowSharePanel$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper$tryShowSharePanel$3$1", f = "SharePanelShowHelper.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<SaveMessageShareInfo>>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ String $messageId;
        int label;
        final /* synthetic */ SharePanelShowHelper this$0;

        public AnonymousClass1(SharePanelShowHelper r1, String r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$conversationId = r2;
            this.$messageId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$conversationId, this.$messageId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2) {
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
            SharePanelShowHelper r6 = this.this$0;
            String r2 = this.$conversationId;
            String r3 = this.$messageId;
            this.label = 1;
            r5 = SharePanelShowHelper.b(r6, r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public SharePanelShowHelper$tryShowSharePanel$3(SharePanelShowHelper r1, String r2, String r3, Continuation<? super SharePanelShowHelper$tryShowSharePanel$3> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$messageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SharePanelShowHelper$tryShowSharePanel$3 r0 = new SharePanelShowHelper$tryShowSharePanel$3(this.this$0, this.$conversationId, this.$messageId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        SharePanelShowHelper r10 = this.this$0;
        r10.b = BuildersKt.async$default(r0, Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, this.$conversationId, this.$messageId, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

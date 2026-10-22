package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/dto/chat/MentionChatChatterResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$search$2$net$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoMentionViewModel$search$2$net$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ccb.d>>, Object> {
    final /* synthetic */ String $requestId;
    final /* synthetic */ String $searchKey;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoubaoMentionViewModel this$0;

    public DoubaoMentionViewModel$search$2$net$1(DoubaoMentionViewModel r1, String r2, String r3, Continuation<? super DoubaoMentionViewModel$search$2$net$1> r4) {
        this.this$0 = r1;
        this.$searchKey = r2;
        this.$requestId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoubaoMentionViewModel$search$2$net$1 r0 = new DoubaoMentionViewModel$search$2$net$1(this.this$0, this.$searchKey, this.$requestId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends ccb.d>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((ccb.d) r6);     // Catch: Throwable -> L15
    L18:
        return Result.box-impl(r7);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        DoubaoMentionViewModel r9 = this.this$0;
        String r2 = this.$searchKey;
        String r3 = this.$requestId;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        ChatAtModel r5 = DoubaoMentionViewModel.access$getModel$p(r9);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = DoubaoMentionViewModel.access$awaitNetSearch(r9, r5, r2, r3, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}

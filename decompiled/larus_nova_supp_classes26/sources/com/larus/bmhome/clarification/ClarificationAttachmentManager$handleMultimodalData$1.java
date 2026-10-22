package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$handleMultimodalData$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentManager$handleMultimodalData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.n $data;
    final /* synthetic */ boolean $isFromDrive;
    final /* synthetic */ int $pageIndex;
    int label;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$handleMultimodalData$1(ClarificationAttachmentManager r1, int r2, com.larus.bmhome.chat.component.bottom.multimodal.n r3, boolean r4, Continuation<? super ClarificationAttachmentManager$handleMultimodalData$1> r5) {
        this.this$0 = r1;
        this.$pageIndex = r2;
        this.$data = r3;
        this.$isFromDrive = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ClarificationAttachmentManager$handleMultimodalData$1(this.this$0, this.$pageIndex, this.$data, this.$isFromDrive, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ClarificationAttachmentManager r7 = this.this$0;
        int r2 = this.$pageIndex;
        com.larus.bmhome.chat.component.bottom.multimodal.n r3 = this.$data;
        boolean r4 = this.$isFromDrive;
        this.label = 1;
        if (ClarificationAttachmentManager.a(r7, r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}

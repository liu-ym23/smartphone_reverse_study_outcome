package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.NestedFileContent;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$onClickModifySend$1", f = "CoreInputAbility.kt", i = {}, l = {3346}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputAbility$onClickModifySend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentInfo $attachment;
    final /* synthetic */ String $attachmentEntityLocalMsgId;
    final /* synthetic */ NestedFileContent $nestedFileContent;
    int label;
    final /* synthetic */ CoreInputAbility<T> this$0;

    public CoreInputAbility$onClickModifySend$1(CoreInputAbility<T> r1, AttachmentInfo r2, NestedFileContent r3, String r4, Continuation<? super CoreInputAbility$onClickModifySend$1> r5) {
        this.this$0 = r1;
        this.$attachment = r2;
        this.$nestedFileContent = r3;
        this.$attachmentEntityLocalMsgId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CoreInputAbility$onClickModifySend$1(this.this$0, this.$attachment, this.$nestedFileContent, this.$attachmentEntityLocalMsgId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        String r2 = (String) r7;
        if (r2 == null) goto L14;
        CoreInputAbility<T> r8 = this.this$0;
        r8.n.invoke(r8.F().getModifyMode(), r2, this.$attachment, this.$nestedFileContent, this.$attachmentEntityLocalMsgId);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        a9 r9 = this.this$0.f;
        this.label = 1;
        r7 = r9.KD(this);
        if (r7 != r0) goto L11;
        return r0;
    }
}

package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.j1;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$appendHistoryAttachments$4", f = "AttachmentPanelComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$appendHistoryAttachments$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localMsgId;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$appendHistoryAttachments$4(AttachmentPanelComponent r1, String r2, UplinkFileEntity r3, Continuation<? super AttachmentPanelComponent$appendHistoryAttachments$4> r4) {
        this.this$0 = r1;
        this.$localMsgId = r2;
        this.$entity = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AttachmentPanelComponent$appendHistoryAttachments$4(this.this$0, this.$localMsgId, this.$entity, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r13);
        AttachmentPanelComponent r14 = this.this$0;
        int r0 = AttachmentPanelComponent.g2;
        j1 r1 = r14.Y3();
        if (r1 == null) goto L8;
        Boxing.boxBoolean(j1.a.a(r1, this.$localMsgId, this.$entity, null, false, false, null, null, null, null, 508));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

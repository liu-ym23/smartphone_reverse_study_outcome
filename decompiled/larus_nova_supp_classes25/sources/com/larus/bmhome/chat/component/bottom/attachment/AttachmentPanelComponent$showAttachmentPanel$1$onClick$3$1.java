package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$showAttachmentPanel$1$onClick$3$1", f = "AttachmentPanelComponent.kt", i = {}, l = {3280, 3282}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$showAttachmentPanel$1$onClick$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.d $uploadParam;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$showAttachmentPanel$1$onClick$3$1(AttachmentPanelComponent r1, com.larus.bmhome.chat.component.bottom.multimodal.upload.d r2, Continuation<? super AttachmentPanelComponent$showAttachmentPanel$1$onClick$3$1> r3) {
        this.this$0 = r1;
        this.$uploadParam = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AttachmentPanelComponent$showAttachmentPanel$1$onClick$3$1(this.this$0, this.$uploadParam, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 != 0) goto L5;
        ResultKt.throwOnFailure(r4);
        AttachmentPanelComponent r5 = this.this$0;
        int r2 = AttachmentPanelComponent.g2;
        r5.getClass();
        FileUploader r6 = FileUploader.a;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r7 = this.$uploadParam;
        this.label = 2;
        if (FileUploader.k(r7, this) != r0) goto L15;
        return r0;
    L15:
        return Unit.INSTANCE;
    L5:
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r4);
        goto L15
    }
}

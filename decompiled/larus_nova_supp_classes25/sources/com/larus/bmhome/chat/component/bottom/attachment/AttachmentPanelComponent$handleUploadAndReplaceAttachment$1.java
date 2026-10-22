package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.im.bean.message.UplinkFileEntity;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$handleUploadAndReplaceAttachment$1", f = "AttachmentPanelComponent.kt", i = {}, l = {1901, 1903}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$handleUploadAndReplaceAttachment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.q $tryAttachmentUploadParam;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$handleUploadAndReplaceAttachment$1(AttachmentPanelComponent r1, UplinkFileEntity r2, com.larus.bmhome.chat.component.bottom.multimodal.upload.q r3, Continuation<? super AttachmentPanelComponent$handleUploadAndReplaceAttachment$1> r4) {
        this.this$0 = r1;
        this.$entity = r2;
        this.$tryAttachmentUploadParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AttachmentPanelComponent$handleUploadAndReplaceAttachment$1(this.this$0, this.$entity, this.$tryAttachmentUploadParam, r5);
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
        if (r1 != 0) goto L5;
        ResultKt.throwOnFailure(r6);
        AttachmentPanelComponent r7 = this.this$0;
        int r2 = AttachmentPanelComponent.g2;
        r7.getClass();
        AttachmentPanelComponent r8 = this.this$0;
        UplinkFileEntity r3 = this.$entity;
        String r4 = r3.getFileIdentifier();
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        AttachmentPanelComponent.c r5 = r8.V0.get(r4);
        if (r5 == null) goto L17;
        ns8.b r9 = r5.a;
    L18:
        ns8.b r10 = AttachmentPanelComponent.m3(r8, r3, r9);
        FileUploader r11 = FileUploader.a;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r12 = this.$tryAttachmentUploadParam;
        this.label = 2;
        if (FileUploader.g(r12, r10, this, 4) != r0) goto L22;
        return r0;
    L22:
        return Unit.INSTANCE;
    L17:
        r9 = r8.P0;
        goto L18
    L5:
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
        goto L22
    }
}

package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.im.bean.bot.BotModel;
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
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$retryUploadAttachment$1", f = "AttachmentPanelComponent.kt", i = {}, l = {1193, 1198, 1218, 1220}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentPanelComponent$retryUploadAttachment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.a $callback;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ String $localMsgId;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$retryUploadAttachment$1(AttachmentPanelComponent r1, UplinkFileEntity r2, com.larus.bmhome.chat.component.bottom.multimodal.upload.a r3, String r4, String r5, Continuation<? super AttachmentPanelComponent$retryUploadAttachment$1> r6) {
        this.this$0 = r1;
        this.$entity = r2;
        this.$callback = r3;
        this.$fromScene = r4;
        this.$localMsgId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AttachmentPanelComponent$retryUploadAttachment$1(this.this$0, this.$entity, this.$callback, this.$fromScene, this.$localMsgId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r26);
    L52:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r26);
        AttachmentPanelComponent r3 = this.this$0;
        int r6 = AttachmentPanelComponent.g2;
        r3.getClass();
        String r7 = null;
        if (this.$entity.getUri() == null) goto L32;
        String r8 = this.this$0.K();
        BotModel r4 = this.this$0.W3();
        if (r4 == null) goto L18;
        String r15 = r4.getBotId();
    L19:
        wc9.e r9 = this.this$0.H3();
        if (r9 == null) goto L22;
        r7 = r9.B;
    L22:
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r10 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(r8, true, this.$callback, this.$fromScene, this.$entity, false, this.$localMsgId, r15, r7, null, 544);
        FileUploader r11 = FileUploader.a;
        AttachmentPanelComponent r12 = this.this$0;
        String r13 = this.$entity.getFileIdentifier();
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        AttachmentPanelComponent.c r14 = r12.V0.get(r13);
        if (r14 == null) goto L28;
        ns8.b r16 = r14.a;
    L29:
        this.label = 2;
        if (FileUploader.g(r10, r16, this, 4) != r1) goto L52;
        return r1;
    L28:
        r16 = r12.P0;
        goto L29
    L18:
        r15 = null;
        goto L19
    L32:
        String r17 = l1.d(this.$entity);
        if (r17 != null) goto L35;
    L38:
        if (r5 == true) goto L40;
        String r18 = l1.a(this.$entity);
        com.larus.bmhome.chat.component.bottom.multimodal.upload.a r19 = this.$callback;
        UplinkFileEntity r110 = this.$entity;
        String r111 = this.this$0.K();
        BotModel r20 = this.this$0.W3();
        if (r20 == null) goto L44;
        String r112 = r20.getBotId();
    L45:
        wc9.e r21 = this.this$0.H3();
        if (r21 == null) goto L48;
        r7 = r21.B;
    L48:
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r22 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.d(true, r17, r18, r19, r110, r111, r112, r7, this.$localMsgId, false, false, null, null, null, null, null, 65024);
        FileUploader r23 = FileUploader.a;
        this.label = 4;
        if (FileUploader.k(r22, this) != r1) goto L52;
        return r1;
    L44:
        r112 = null;
        goto L45
    L40:
        return Unit.INSTANCE;
    L35:
        if (r17.length() == 0) goto L38;
        r5 = false;
        goto L38
    }
}

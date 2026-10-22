package com.larus.drive.sdk.impl.component.chat;

import com.larus.bmhome.chat.component.bottom.attachment.d1;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, s = {})
public final class DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ AttachmentSnapshot $attachment;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ DriveChatReceiveComponent this$0;

    public DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1(AttachmentSnapshot r1, DriveChatReceiveComponent r2, String r3, String r4, Continuation<? super DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1> r5) {
        this.$attachment = r1;
        this.this$0 = r2;
        this.$conversationId = r3;
        this.$botId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1(this.$attachment, this.this$0, this.$conversationId, this.$botId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L29:
        return (UplinkFileEntity) r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UplinkFileEntity r4 = d1.f(this.$attachment);
        Integer r11 = r4.getUpLinkStatus();
        int r2 = UpLinkState.SUCCESS.getValue();
        if (r11 != null) goto L12;
    L22:
        DriveChatReceiveComponent r7 = this.this$0;
        String r5 = this.$conversationId;
        String r6 = this.$botId;
        this.label = 1;
        int r12 = DriveChatReceiveComponent.j;
        r7.getClass();
        if (r4.getUri() != null) goto L25;
        FLogger.a.e("DriveChatReceiveComponent", "[materializePreviewAttachment] missing local uri");
        r10 = null;
    L26:
        if (r10 != r0) goto L29;
        return r0;
    L25:
        r10 = TimeoutKt.c(120000, new DriveChatReceiveComponent$materializePreviewAttachment$2(r4, r5, r6, r7, null), this);
        goto L26
    L12:
        if (r11.intValue() != r2) goto L22;
        String r13 = l1.h(r4);
        if (r13 != null) goto L16;
    L19:
        boolean r14 = true;
    L20:
        if (r14 == true) goto L22;
        return r4;
    L16:
        if (StringsKt.isBlank(r13) == true) goto L19;
        r14 = false;
        goto L20
    }
}

package com.larus.bmhome.clarification;

import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadDelegate;
import com.larus.bmhome.chat.component.cvs.y;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$startUpload$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {443}, m = "invokeSuspend", n = {}, s = {})
public final class ClarificationAttachmentManager$startUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.m $callback;
    final /* synthetic */ y $conversation;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ String $localMsgId;
    int label;

    public ClarificationAttachmentManager$startUpload$1(y r1, com.larus.bmhome.chat.component.bottom.multimodal.upload.m r2, String r3, UplinkFileEntity r4, String r5, Continuation<? super ClarificationAttachmentManager$startUpload$1> r6) {
        this.$conversation = r1;
        this.$callback = r2;
        this.$fromScene = r3;
        this.$entity = r4;
        this.$localMsgId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ClarificationAttachmentManager$startUpload$1(this.$conversation, this.$callback, this.$fromScene, this.$entity, this.$localMsgId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        com.larus.bmhome.chat.component.bottom.multimodal.upload.l r3 = FileUploadDelegate.b.b();
        y r4 = this.$conversation;
        if (r4 == null) goto L11;
        String r5 = r4.Y1();
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        String r6 = r5;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.m r7 = this.$callback;
        String r8 = this.$fromScene;
        UplinkFileEntity r9 = this.$entity;
        String r11 = this.$localMsgId;
        y r10 = this.$conversation;
        if (r10 == null) goto L19;
        BotModel r12 = r10.j0();
        if (r12 == null) goto L19;
        String r13 = r12.getBotId();
    L20:
        y r14 = this.$conversation;
        if (r14 == null) goto L25;
        wc9.e r15 = r14.h();
        if (r15 == null) goto L25;
        String r16 = r15.B;
    L26:
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r17 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(r6, true, r7, r8, r9, false, r11, r13, r16, null, 544);
        this.label = 1;
        if (r3.b(r17, null, this) != r1) goto L30;
        return r1;
    L25:
        r16 = null;
    L19:
        r13 = null;
        goto L20
    L11:
        r5 = null;
        goto L12
    }
}

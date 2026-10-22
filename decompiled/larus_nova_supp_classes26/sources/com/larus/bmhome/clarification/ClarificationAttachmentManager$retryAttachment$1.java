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
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$retryAttachment$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentManager$retryAttachment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.m $callback;
    final /* synthetic */ y $conversation;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localPath;
    final /* synthetic */ z1 $pageState;
    final /* synthetic */ d2 $session;
    int label;

    public ClarificationAttachmentManager$retryAttachment$1(String r1, UplinkFileEntity r2, com.larus.bmhome.chat.component.bottom.multimodal.upload.m r3, d2 r4, y r5, z1 r6, Continuation<? super ClarificationAttachmentManager$retryAttachment$1> r7) {
        this.$localPath = r1;
        this.$entity = r2;
        this.$callback = r3;
        this.$session = r4;
        this.$conversation = r5;
        this.$pageState = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ClarificationAttachmentManager$retryAttachment$1(this.$localPath, this.$entity, this.$callback, this.$session, this.$conversation, this.$pageState, r10);
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
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r26);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        com.larus.bmhome.chat.component.bottom.multimodal.upload.l r3 = FileUploadDelegate.b.b();
        String r6 = this.$localPath;
        String r7 = yc9.l1.a(this.$entity);
        com.larus.bmhome.chat.component.bottom.multimodal.upload.m r8 = this.$callback;
        UplinkFileEntity r9 = this.$entity;
        String r10 = this.$session.a;
        y r4 = this.$conversation;
        if (r4 == null) goto L13;
        BotModel r5 = r4.j0();
        if (r5 == null) goto L13;
        String r22 = r5.getBotId();
    L14:
        y r11 = this.$conversation;
        if (r11 == null) goto L19;
        wc9.e r12 = r11.h();
        if (r12 == null) goto L19;
        String r23 = r12.B;
    L20:
        com.larus.bmhome.chat.component.bottom.multimodal.upload.d r13 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.d(true, r6, r7, r8, r9, r10, r22, r23, this.$pageState.h, false, false, null, null, null, null, null, 65024);
        this.label = 1;
        if (r3.a(r13, this) != r1) goto L24;
        return r1;
    L19:
        r23 = null;
    L13:
        r22 = null;
        goto L14
    }
}

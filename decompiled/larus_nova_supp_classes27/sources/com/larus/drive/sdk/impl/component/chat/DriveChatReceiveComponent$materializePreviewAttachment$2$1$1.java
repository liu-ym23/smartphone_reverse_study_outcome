package com.larus.drive.sdk.impl.component.chat;

import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadDelegate;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$materializePreviewAttachment$2$1$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {559}, m = "invokeSuspend", n = {}, s = {})
public final class DriveChatReceiveComponent$materializePreviewAttachment$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ DriveChatReceiveComponent$materializePreviewAttachment$2.b $callback;
    final /* synthetic */ kotlinx.coroutines.i<UplinkFileEntity> $continuation;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ UplinkFileEntity $entity;
    private /* synthetic */ Object L$0;
    int label;

    public DriveChatReceiveComponent$materializePreviewAttachment$2$1$1(String r1, DriveChatReceiveComponent$materializePreviewAttachment$2.b r2, UplinkFileEntity r3, String r4, kotlinx.coroutines.i<? super UplinkFileEntity> r5, Continuation<? super DriveChatReceiveComponent$materializePreviewAttachment$2$1$1> r6) {
        this.$conversationId = r1;
        this.$callback = r2;
        this.$entity = r3;
        this.$botId = r4;
        this.$continuation = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DriveChatReceiveComponent$materializePreviewAttachment$2$1$1 r7 = new DriveChatReceiveComponent$materializePreviewAttachment$2$1$1(this.$conversationId, this.$callback, this.$entity, this.$botId, this.$continuation, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L15
    L13:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        kotlinx.coroutines.i<UplinkFileEntity> r3 = this.$continuation;
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L23;
        FLogger.a.e("DriveChatReceiveComponent", "[materializePreviewAttachment] upload start failed", r4);
        if (r3.isActive() == false) goto L23;
        r3.resumeWith(Result.constructor-impl(null));
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        String r6 = this.$conversationId;
        DriveChatReceiveComponent$materializePreviewAttachment$2.b r8 = this.$callback;
        UplinkFileEntity r10 = this.$entity;
        String r13 = this.$botId;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L15
        com.larus.bmhome.chat.component.bottom.multimodal.upload.l r9 = FileUploadDelegate.b.b();     // Catch: Throwable -> L15
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r15 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(r6, true, r8, "file", r10, true, r10.getFileIdentifier(), r13, null, null, 768);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r9.b(r15, null, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}

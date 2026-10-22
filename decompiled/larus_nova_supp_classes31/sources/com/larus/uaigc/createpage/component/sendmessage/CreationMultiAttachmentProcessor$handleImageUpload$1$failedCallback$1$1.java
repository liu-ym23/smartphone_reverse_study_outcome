package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {594}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ String $curUploaderIdentifier;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ ResourceUploadError $error;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1(String r1, ResourceUploadError r2, UplinkFileEntity r3, String r4, AtomicBoolean r5, AtomicInteger r6, CreationMultiAttachmentProcessor r7, AtomicBoolean r8, CreationSendMessageConfig r9, Map<String, String> r10, String r11, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1> r12) {
        this.$curUploaderIdentifier = r1;
        this.$error = r2;
        this.$entity = r3;
        this.$localNestedFileMessageId = r4;
        this.$finishOnce = r5;
        this.$handlingFileCount = r6;
        this.this$0 = r7;
        this.$messageSent = r8;
        this.$config = r9;
        this.$ext = r10;
        this.$localTextMessageId = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r16, Continuation<?> r17) {
        CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1 r14 = new CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1(this.$curUploaderIdentifier, this.$error, this.$entity, this.$localNestedFileMessageId, this.$finishOnce, this.$handlingFileCount, this.this$0, this.$messageSent, this.$config, this.$ext, this.$localTextMessageId, r17);
        r14.L$0 = r16;
        return r14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L20
    L18:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        String r2 = this.$curUploaderIdentifier;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L25;
        FLogger.a.e("CreationMultiAttachmentProcessor", "[handleImageUpload failedCallback] update failed, identifier: " + r2, r16);
    L25:
        CreationMultiAttachmentProcessor.c(this.$finishOnce, this.$handlingFileCount, this.this$0, this.$messageSent, this.$config, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$curUploaderIdentifier, "handleImageUpload failedCallback");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        ResourceUploadError r18 = this.$error;
        UplinkFileEntity r3 = this.$entity;
        String r4 = this.$localNestedFileMessageId;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        com.larus.uaigc.helper.f.a.getClass();     // Catch: Throwable -> L20
        if (com.larus.uaigc.helper.f.a() == true) goto L13;
    L15:
        r3.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));     // Catch: Throwable -> L20
        MainCoroutineDispatcher r19 = Dispatchers.getMain();     // Catch: Throwable -> L20
        CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1$1$1 r6 = new CreationMultiAttachmentProcessor$handleImageUpload$1$failedCallback$1$1$1$1(r4, r3, null);     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        if (BuildersKt.withContext(r19, r6, this) != r0) goto L18;
        return r0;
    L13:
        if (ICreationResourceAccessServiceKt.f(r18) == false) goto L15;
        r3.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}

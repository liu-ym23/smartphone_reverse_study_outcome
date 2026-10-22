package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageReview$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {778, 794, 788, 794, 794}, m = "invokeSuspend", n = {}, s = {})
final class CreationMultiAttachmentProcessor$handleImageReview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    Object L$0;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageReview$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageReview$1$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ String $localNestedFileMessageId;
        int label;

        public AnonymousClass1(String r1, UplinkFileEntity r2, Continuation<? super AnonymousClass1> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            NestedFileCacheManagerService.b.k(this.$localNestedFileMessageId, this.$entity);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationMultiAttachmentProcessor$handleImageReview$1(CreationMultiAttachmentProcessor r1, CreationSendMessageConfig r2, UplinkFileEntity r3, CustomMultiAttachmentInfo r4, String r5, AtomicInteger r6, AtomicBoolean r7, Map<String, String> r8, String r9, Continuation<? super CreationMultiAttachmentProcessor$handleImageReview$1> r10) {
        this.this$0 = r1;
        this.$config = r2;
        this.$entity = r3;
        this.$customMultiAttachment = r4;
        this.$localNestedFileMessageId = r5;
        this.$handlingFileCount = r6;
        this.$messageSent = r7;
        this.$ext = r8;
        this.$localTextMessageId = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CreationMultiAttachmentProcessor$handleImageReview$1(this.this$0, this.$config, this.$entity, this.$customMultiAttachment, this.$localNestedFileMessageId, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L21;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L54;
        if (r0 == 4) goto L16;
        if (r0 != 5) goto L10;
        Throwable r1 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r18);
        throw r1;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L54:
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L14
        String r14 = "CreationMultiAttachmentProcessor";
        String r12 = "[imageReview] handlingFileCount decremented, remaining: ";
        String r13 = ", identifier: ";
    L42:
        int r2 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i(r14, r12 + r2 + r13 + this.$entity.getFileIdentifier());
        CreationMultiAttachmentProcessor r3 = this.this$0;
        AtomicInteger r4 = this.$handlingFileCount;
        AtomicBoolean r5 = this.$messageSent;
        CreationSendMessageConfig r6 = this.$config;
        Map<String, String> r7 = this.$ext;
        String r8 = this.$localNestedFileMessageId;
        String r9 = this.$localTextMessageId;
        this.label = 4;
        if (CreationMultiAttachmentProcessor.a(r3, r4, r5, r6, r7, r8, r9, this) != r10) goto L46;
        return r10;
    L46:
        return Unit.INSTANCE;
    L14:
        th = th;
        r14 = "CreationMultiAttachmentProcessor";
        r12 = "[imageReview] handlingFileCount decremented, remaining: ";
        r13 = ", identifier: ";
    L48:
        int r11 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i(r14, r12 + r11 + r13 + this.$entity.getFileIdentifier());
        CreationMultiAttachmentProcessor r15 = this.this$0;
        AtomicInteger r16 = this.$handlingFileCount;
        AtomicBoolean r17 = this.$messageSent;
        CreationSendMessageConfig r19 = this.$config;
        Map<String, String> r20 = this.$ext;
        String r21 = this.$localNestedFileMessageId;
        String r22 = this.$localTextMessageId;
        this.L$0 = th;
        this.label = 5;
        if (CreationMultiAttachmentProcessor.a(r15, r16, r17, r19, r20, r21, r22, this) != r10) goto L59;
        return r10;
    L59:
        throw th;
    L16:
        ResultKt.throwOnFailure(r18);
        goto L46
    L17:
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L19
        r14 = "CreationMultiAttachmentProcessor";
        r12 = "[imageReview] handlingFileCount decremented, remaining: ";
        r13 = ", identifier: ";
    L35:
        int r23 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i(r14, r12 + r23 + r13 + this.$entity.getFileIdentifier());
        CreationMultiAttachmentProcessor r24 = this.this$0;
        AtomicInteger r25 = this.$handlingFileCount;
        AtomicBoolean r26 = this.$messageSent;
        CreationSendMessageConfig r27 = this.$config;
        Map<String, String> r28 = this.$ext;
        String r29 = this.$localNestedFileMessageId;
        String r30 = this.$localTextMessageId;
        this.label = 2;
        if (CreationMultiAttachmentProcessor.a(r24, r25, r26, r27, r28, r29, r30, this) != r10) goto L46;
        return r10;
    L21:
        ResultKt.throwOnFailure(r18);
        CreationMultiAttachmentProcessor r31 = this.this$0;     // Catch: Throwable -> L19
        CreationSendMessageConfig r32 = this.$config;     // Catch: Throwable -> L19
        UplinkFileEntity r33 = this.$entity;     // Catch: Throwable -> L19
        CustomMultiAttachmentInfo r34 = this.$customMultiAttachment;     // Catch: Throwable -> L19
        String r110 = this.$localNestedFileMessageId;     // Catch: Throwable -> L19
        UplinkEntityContent r111 = r33.getUplinkEntityContent();     // Catch: Throwable -> L19
        if (r111 == null) goto L27;
        Image r112 = r111.getUplinkImageInfo();     // Catch: Throwable -> L19
        if (r112 == null) goto L27;
        String r113 = r112.key;     // Catch: Throwable -> L19
    L28:
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        this.label = 1;     // Catch: Throwable -> L19
        r14 = "CreationMultiAttachmentProcessor";
        r12 = "[imageReview] handlingFileCount decremented, remaining: ";
        String r35 = r113;
        r13 = ", identifier: ";
        if (CreationMultiAttachmentProcessor.f(r31, r32, r33, r34, r110, r35, this) != r10) goto L35;
        return r10;
    L38:
        th = th;
    L57:
        FLogger.a.e(r14, "[imageReview] review failed, identifier: " + this.$entity.getFileIdentifier(), th);     // Catch: Throwable -> L47
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));     // Catch: Throwable -> L47
        MainCoroutineDispatcher r36 = Dispatchers.getMain();     // Catch: Throwable -> L47
        AnonymousClass1 r37 = new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L47
        this.label = 3;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r36, r37, this) != r10) goto L42;
        return r10;
    L47:
        th = th;
    L27:
        r113 = null;
    L19:
        th = th;
        r14 = "CreationMultiAttachmentProcessor";
        r12 = "[imageReview] handlingFileCount decremented, remaining: ";
        r13 = ", identifier: ";
        goto L57
    }
}

package com.larus.uaigc.createpage.component.sendmessage;

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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleVideoUpload$2", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {1172}, m = "invokeSuspend", n = {}, s = {})
final class CreationMultiAttachmentProcessor$handleVideoUpload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleVideoUpload$2(AtomicInteger r1, UplinkFileEntity r2, CreationMultiAttachmentProcessor r3, AtomicBoolean r4, CreationSendMessageConfig r5, Map<String, String> r6, String r7, String r8, Continuation<? super CreationMultiAttachmentProcessor$handleVideoUpload$2> r9) {
        this.$handlingFileCount = r1;
        this.$entity = r2;
        this.this$0 = r3;
        this.$messageSent = r4;
        this.$config = r5;
        this.$ext = r6;
        this.$localNestedFileMessageId = r7;
        this.$localTextMessageId = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new CreationMultiAttachmentProcessor$handleVideoUpload$2(this.$handlingFileCount, this.$entity, this.this$0, this.$messageSent, this.$config, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        int r14 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i("CreationMultiAttachmentProcessor", "[handleVideoUpload] handlingFileCount decremented (non-processing), remaining: " + r14 + ", identifier: " + this.$entity.getFileIdentifier());
        CreationMultiAttachmentProcessor r4 = this.this$0;
        AtomicInteger r5 = this.$handlingFileCount;
        AtomicBoolean r6 = this.$messageSent;
        CreationSendMessageConfig r7 = this.$config;
        Map<String, String> r8 = this.$ext;
        String r9 = this.$localNestedFileMessageId;
        String r10 = this.$localTextMessageId;
        this.label = 1;
        if (CreationMultiAttachmentProcessor.a(r4, r5, r6, r7, r8, r9, r10, this) != r0) goto L12;
        return r0;
    }
}

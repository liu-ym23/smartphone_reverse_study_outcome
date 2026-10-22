package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
final class CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1(CreationMultiAttachmentProcessor r1, AtomicInteger r2, AtomicBoolean r3, CreationSendMessageConfig r4, Map<String, String> r5, String r6, String r7, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1> r8) {
        this.this$0 = r1;
        this.$handlingFileCount = r2;
        this.$messageSent = r3;
        this.$config = r4;
        this.$ext = r5;
        this.$localNestedFileMessageId = r6;
        this.$localTextMessageId = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1(this.this$0, this.$handlingFileCount, this.$messageSent, this.$config, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CreationMultiAttachmentProcessor r2 = this.this$0;
        AtomicInteger r11 = this.$handlingFileCount;
        AtomicBoolean r3 = this.$messageSent;
        CreationSendMessageConfig r4 = this.$config;
        Map<String, String> r5 = this.$ext;
        String r6 = this.$localNestedFileMessageId;
        String r7 = this.$localTextMessageId;
        this.label = 1;
        if (CreationMultiAttachmentProcessor.a(r2, r11, r3, r4, r5, r6, r7, this) != r0) goto L12;
        return r0;
    }
}

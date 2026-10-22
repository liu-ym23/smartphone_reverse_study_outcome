package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.im.bean.message.UplinkFileEntity;
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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$handleVideoUploadBeforeSendNestedFiles$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {798}, m = "invokeSuspend", n = {}, s = {})
final class UgcUploadingSendMessageProcessor$handleVideoUploadBeforeSendNestedFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$handleVideoUploadBeforeSendNestedFiles$1(AtomicInteger r1, UplinkFileEntity r2, UgcUploadingSendMessageProcessor r3, y8 r4, AtomicBoolean r5, ICoreInputAbility.OnSendParams r6, Map<String, String> r7, String r8, String r9, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r10, Continuation<? super UgcUploadingSendMessageProcessor$handleVideoUploadBeforeSendNestedFiles$1> r11) {
        this.$handlingFileCount = r1;
        this.$entity = r2;
        this.this$0 = r3;
        this.$dependency = r4;
        this.$messageSent = r5;
        this.$params = r6;
        this.$ext = r7;
        this.$localNestedFileMessageId = r8;
        this.$localTextMessageId = r9;
        this.$originalLogic = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new UgcUploadingSendMessageProcessor$handleVideoUploadBeforeSendNestedFiles$1(this.$handlingFileCount, this.$entity, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$originalLogic, r14);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        int r15 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[handleVideoUploadBeforeSendNestedFiles] handlingFileCount decremented (non-processing), remaining: " + r15 + ", identifier: " + this.$entity.getFileIdentifier());
        UgcUploadingSendMessageProcessor r4 = this.this$0;
        AtomicInteger r5 = this.$handlingFileCount;
        AtomicBoolean r6 = this.$messageSent;
        ICoreInputAbility.OnSendParams r7 = this.$params;
        Map<String, String> r8 = this.$ext;
        String r9 = this.$localNestedFileMessageId;
        String r10 = this.$localTextMessageId;
        Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r11 = this.$originalLogic;
        this.label = 1;
        if (UgcUploadingSendMessageProcessor.a(r4, r5, r6, r7, r8, r9, r10, r11, this) != r0) goto L12;
        return r0;
    }
}

package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1(UgcUploadingSendMessageProcessor r1, y8 r2, AtomicInteger r3, AtomicBoolean r4, ICoreInputAbility.OnSendParams r5, Map<String, String> r6, Ref.ObjectRef<String> r7, Ref.ObjectRef<String> r8, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r9, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1> r10) {
        this.this$0 = r1;
        this.$dependency = r2;
        this.$handlingFileCount = r3;
        this.$messageSent = r4;
        this.$params = r5;
        this.$ext = r6;
        this.$localNestedFileMessageId = r7;
        this.$localTextMessageId = r8;
        this.$originalLogic = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1(this.this$0, this.$dependency, this.$handlingFileCount, this.$messageSent, this.$params, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$originalLogic, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        UgcUploadingSendMessageProcessor r2 = this.this$0;
        AtomicInteger r12 = this.$handlingFileCount;
        AtomicBoolean r3 = this.$messageSent;
        ICoreInputAbility.OnSendParams r4 = this.$params;
        Map<String, String> r5 = this.$ext;
        String r6 = (String) this.$localNestedFileMessageId.element;
        String r7 = (String) this.$localTextMessageId.element;
        Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r8 = this.$originalLogic;
        this.label = 1;
        if (UgcUploadingSendMessageProcessor.a(r2, r12, r3, r4, r5, r6, r7, r8, this) != r0) goto L12;
        return r0;
    }
}

package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceUploadError;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curUploaderIdentifier;
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ ResourceUploadError $error;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1(ResourceUploadError r1, UplinkFileEntity r2, Ref.ObjectRef<String> r3, String r4, AtomicBoolean r5, AtomicInteger r6, UgcUploadingSendMessageProcessor r7, y8 r8, AtomicBoolean r9, ICoreInputAbility.OnSendParams r10, Map<String, String> r11, Ref.ObjectRef<String> r12, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r13, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1> r14) {
        this.$error = r1;
        this.$entity = r2;
        this.$localNestedFileMessageId = r3;
        this.$curUploaderIdentifier = r4;
        this.$finishOnce = r5;
        this.$handlingFileCount = r6;
        this.this$0 = r7;
        this.$dependency = r8;
        this.$messageSent = r9;
        this.$params = r10;
        this.$ext = r11;
        this.$localTextMessageId = r12;
        this.$originalLogic = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1 r15 = new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1(this.$error, this.$entity, this.$localNestedFileMessageId, this.$curUploaderIdentifier, this.$finishOnce, this.$handlingFileCount, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localTextMessageId, this.$originalLogic, r18);
        r15.L$0 = r17;
        return r15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L20
    L18:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        String r3 = this.$curUploaderIdentifier;
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L25;
        FLogger.a.e("NestedFileSendMessageProcessor", "[imageUpload failedCallback] update failed, identifier: " + r3, r4);
    L25:
        UgcUploadingSendMessageProcessor.c(this.$finishOnce, this.$curUploaderIdentifier, this.$handlingFileCount, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$originalLogic, "imageUpload failedCallback");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResourceUploadError r6 = this.$error;
        UplinkFileEntity r7 = this.$entity;
        Ref.ObjectRef<String> r8 = this.$localNestedFileMessageId;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L20
        com.larus.uaigc.helper.f.a.getClass();     // Catch: Throwable -> L20
        if (com.larus.uaigc.helper.f.a() == true) goto L13;
    L15:
        r7.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));     // Catch: Throwable -> L20
        MainCoroutineDispatcher r10 = Dispatchers.getMain();     // Catch: Throwable -> L20
        UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1$1$1 r11 = new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$failedCallback$1$1$1$1(r8, r7, null);     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        if (BuildersKt.withContext(r10, r11, this) != r0) goto L18;
        return r0;
    L13:
        if (ICreationResourceAccessServiceKt.f(r6) == false) goto L15;
        r7.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}

package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {542}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ mr9.l $result;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1(boolean r1, CustomMultiAttachmentInfo r2, UplinkFileEntity r3, CreationMultiAttachmentProcessor r4, CreationSendMessageConfig r5, String r6, mr9.l r7, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1> r8) {
        this.$pipelineEnabled = r1;
        this.$customMultiAttachment = r2;
        this.$entity = r3;
        this.this$0 = r4;
        this.$config = r5;
        this.$localNestedFileMessageId = r6;
        this.$result = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1(this.$pipelineEnabled, this.$customMultiAttachment, this.$entity, this.this$0, this.$config, this.$localNestedFileMessageId, this.$result, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        if (this.$pipelineEnabled == true) goto L11;
    L13:
        CreationMultiAttachmentProcessor r2 = this.this$0;
        CreationSendMessageConfig r10 = this.$config;
        UplinkFileEntity r3 = this.$entity;
        CustomMultiAttachmentInfo r4 = this.$customMultiAttachment;
        String r5 = this.$localNestedFileMessageId;
        String r6 = this.$result.a;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        this.label = 1;
        if (CreationMultiAttachmentProcessor.f(r2, r10, r3, r4, r5, r6, this) != r0) goto L20;
        return r0;
    L11:
        if (this.$customMultiAttachment.getOnlyRegisterCheck() == true) goto L13;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));
        goto L20
    }
}

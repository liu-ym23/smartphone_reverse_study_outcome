package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.UplinkFileEntity;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {512, 523}, m = "invokeSuspend", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ mr9.l $result;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
        int label;

        public AnonymousClass1(Ref.ObjectRef<String> r1, UplinkFileEntity r2, Continuation<? super AnonymousClass1> r3) {
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
            NestedFileCacheManagerService.b.k((String) this.$localNestedFileMessageId.element, this.$entity);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1(y8 r1, ICoreInputAbility.OnSendParams r2, UplinkFileEntity r3, boolean r4, UgcUploadingSendMessageProcessor r5, mr9.l r6, Ref.ObjectRef<String> r7, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1> r8) {
        this.$dependency = r1;
        this.$params = r2;
        this.$entity = r3;
        this.$pipelineEnabled = r4;
        this.this$0 = r5;
        this.$result = r6;
        this.$localNestedFileMessageId = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1(this.$dependency, this.$params, this.$entity, this.$pipelineEnabled, this.this$0, this.$result, this.$localNestedFileMessageId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L54:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L45:
        Boolean r16 = (Boolean) r15;
        if (Intrinsics.areEqual(r16, Boxing.boxBoolean(false)) == false) goto L51;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, null);
        this.label = 2;
        if (BuildersKt.withContext(r17, r2, this) != r0) goto L54;
        return r0;
    L51:
        if (Intrinsics.areEqual(r16, Boxing.boxBoolean(true)) == false) goto L54;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));
        goto L54
    L10:
        ResultKt.throwOnFailure(r15);
        com.larus.bmhome.chat.component.cvs.y r18 = this.$dependency.u0();
        if (r18 == null) goto L15;
        wc9.e r19 = r18.h();
        if (r19 == null) goto L15;
        String r10 = r19.a;
    L16:
        com.larus.bmhome.chat.component.cvs.y r110 = this.$dependency.u0();
        if (r110 == null) goto L21;
        wc9.e r111 = r110.h();
        if (r111 == null) goto L21;
        String r11 = r111.B;
    L22:
        CustomMultiAttachmentInfo r112 = this.$params.getCustomMultiAttachment();
        if (r112 != null) goto L25;
    L27:
        boolean r113 = false;
    L28:
        if (r113 == false) goto L31;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.PROCESSING.getValue()));
        goto L54
    L31:
        if (this.$pipelineEnabled == false) goto L33;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));
        goto L54
    L33:
        UgcUploadingSendMessageProcessor r6 = this.this$0;
        String r114 = this.$result.a;
        if (r114 != null) goto L36;
        r114 = "";
    L36:
        String r7 = r114;
        UplinkFileEntity r8 = this.$entity;
        String r9 = (String) this.$localNestedFileMessageId.element;
        CustomMultiAttachmentInfo r115 = this.$params.getCustomMultiAttachment();
        if (r115 != null) goto L39;
    L41:
        boolean r12 = false;
    L42:
        this.label = 1;
        r15 = UgcUploadingSendMessageProcessor.b(r6, r7, r8, r9, r10, r11, r12, this);
        if (r15 != r0) goto L45;
        return r0;
    L39:
        if (r115.getPreHandleV2Check() != true) goto L41;
        r12 = true;
        goto L42
    L25:
        if (r112.getOnlyRegisterCheck() != true) goto L27;
        r113 = true;
    L21:
        r11 = null;
    L15:
        r10 = null;
        goto L16
    }
}

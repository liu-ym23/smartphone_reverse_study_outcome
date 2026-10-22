package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationResourceAccessService;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1", f = "CreationMultiAttachmentProcessor.kt", i = {0, 0, 1}, l = {532, 551, 552, 556}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u243", "imageOri", "reviewJob"}, s = {"L$6", "L$7", "L$0"})
public final class CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ String $curUploaderIdentifier;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localResPath;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ mr9.l $result;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1(String r1, boolean r2, Ref.ObjectRef<String> r3, UplinkFileEntity r4, mr9.l r5, String r6, CustomMultiAttachmentInfo r7, CreationMultiAttachmentProcessor r8, CreationSendMessageConfig r9, AtomicBoolean r10, AtomicInteger r11, AtomicBoolean r12, Map<String, String> r13, String r14, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1> r15) {
        this.$curUploaderIdentifier = r1;
        this.$pipelineEnabled = r2;
        this.$localResPath = r3;
        this.$entity = r4;
        this.$result = r5;
        this.$localNestedFileMessageId = r6;
        this.$customMultiAttachment = r7;
        this.this$0 = r8;
        this.$config = r9;
        this.$finishOnce = r10;
        this.$handlingFileCount = r11;
        this.$messageSent = r12;
        this.$ext = r13;
        this.$localTextMessageId = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1 r15 = new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1(this.$curUploaderIdentifier, this.$pipelineEnabled, this.$localResPath, this.$entity, this.$result, this.$localNestedFileMessageId, this.$customMultiAttachment, this.this$0, this.$config, this.$finishOnce, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, r19);
        r15.L$0 = r18;
        return r15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        ResultKt.throwOnFailure(r27);
    L96:
        CreationMultiAttachmentProcessor.c(this.$finishOnce, this.$handlingFileCount, this.this$0, this.$messageSent, this.$config, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$curUploaderIdentifier, "handleImageUpload successCallback");
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L89
    L87:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L89
    L91:
        String r3 = this.$curUploaderIdentifier;
        UplinkFileEntity r4 = this.$entity;
        String r5 = this.$localNestedFileMessageId;
        Throwable r6 = Result.exceptionOrNull-impl(r1);
        if (r6 == null) goto L96;
        FLogger.a.e("CreationMultiAttachmentProcessor", "[handleImageUpload successCallback] post process failed, identifier: " + r3, r6);
        r4.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1 r8 = new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1(r5, r4, null);
        this.L$0 = r1;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.L$7 = null;
        this.label = 4;
        if (BuildersKt.withContext(r7, r8, this) != r2) goto L96;
        return r2;
    L13:
        Deferred r9 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L89
    L84:
        this.L$0 = null;     // Catch: Throwable -> L89
        this.label = 3;     // Catch: Throwable -> L89
        if (r9.await(this) != r2) goto L87;
        return r2;
    L16:
        boolean r10 = this.Z$0;
        ImageObj r11 = (ImageObj) this.L$7;
        CoroutineScope r12 = (CoroutineScope) this.L$6;
        CreationSendMessageConfig r13 = (CreationSendMessageConfig) this.L$5;
        CreationMultiAttachmentProcessor r14 = (CreationMultiAttachmentProcessor) this.L$4;
        CustomMultiAttachmentInfo r15 = (CustomMultiAttachmentInfo) this.L$3;
        String r16 = (String) this.L$2;
        mr9.l r17 = (mr9.l) this.L$1;
        UplinkFileEntity r18 = (UplinkFileEntity) this.L$0;
        ResultKt.throwOnFailure(r27);     // Catch: Throwable -> L89
        UplinkFileEntity r20 = r18;
        CoroutineScope r19 = r12;
        CreationSendMessageConfig r22 = r13;
    L19:
        CreationMultiAttachmentProcessor r21 = r14;
        CustomMultiAttachmentInfo r110 = r15;
        String r23 = r16;
        mr9.l r24 = r17;
        Deferred r25 = BuildersKt.async$default(r19, null, null, new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1(r11, r24, null), 3, null);     // Catch: Throwable -> L89
        if (r10 == false) goto L80;
        boolean r111 = true;
    L81:
        r9 = BuildersKt.async$default(r19, null, null, new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$reviewJob$1(r111, r110, r20, r21, r22, r23, r24, null), 3, null);     // Catch: Throwable -> L89
        this.L$0 = r9;     // Catch: Throwable -> L89
        this.L$1 = null;     // Catch: Throwable -> L89
        this.L$2 = null;     // Catch: Throwable -> L89
        this.L$3 = null;     // Catch: Throwable -> L89
        this.L$4 = null;     // Catch: Throwable -> L89
        this.L$5 = null;     // Catch: Throwable -> L89
        this.L$6 = null;     // Catch: Throwable -> L89
        this.L$7 = null;     // Catch: Throwable -> L89
        this.label = 2;     // Catch: Throwable -> L89
        if (r25.await(this) != r2) goto L84;
        return r2;
    L80:
        r111 = false;
        goto L81
    L20:
        ResultKt.throwOnFailure(r27);
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        String r26 = this.$curUploaderIdentifier;
        boolean r28 = this.$pipelineEnabled;
        Ref.ObjectRef<String> r29 = this.$localResPath;
        UplinkFileEntity r113 = this.$entity;
        r17 = this.$result;
        r16 = this.$localNestedFileMessageId;
        r15 = this.$customMultiAttachment;
        r14 = this.this$0;
        CreationSendMessageConfig r30 = this.$config;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L89
        com.larus.bmhome.resource.access.f0 r31 = ICreationResourceAccessService.a.c(r26);     // Catch: Throwable -> L89
        if (r28 == false) goto L35;
        if (r31 == null) goto L34;
        com.larus.bmhome.resource.access.j0.b r32 = r31.b;     // Catch: Throwable -> L89
        if (r32 == null) goto L34;
        if ((r32 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L29;
        com.larus.bmhome.resource.access.j0.b r33 = r32;     // Catch: Throwable -> L89
    L30:
        if (r33 == null) goto L32;
        String r34 = r33.b;     // Catch: Throwable -> L89
    L33:
        if (r34 == null) goto L34;
    L36:
        r113.setFileParsedStatus(Boxing.boxInt(FileParseState.SUCCESS.getValue()));     // Catch: Throwable -> L89
        r113.setUpLinkProcess(Boxing.boxInt(100));     // Catch: Throwable -> L89
        r113.setUpLinkStatus(Boxing.boxInt(UpLinkState.SUCCESS.getValue()));     // Catch: Throwable -> L89
        UplinkEntityContent r35 = r113.getUplinkEntityContent();     // Catch: Throwable -> L89
        if (r35 == null) goto L39;
        Image r36 = r35.getUplinkImageInfo();     // Catch: Throwable -> L89
    L40:
        if (r28 == false) goto L43;
        if (r36 == null) goto L48;
        r36.localResPath = r34;     // Catch: Throwable -> L89
    L48:
        if (r36 == null) goto L50;
        r36.key = r17.a;     // Catch: Throwable -> L89
    L50:
        if (r36 == null) goto L52;
        r36.resourceId = r17.c;     // Catch: Throwable -> L89
    L52:
        ResourceUploadInstantInfo r37 = r17.g;     // Catch: Throwable -> L89
        if (r37 == null) goto L55;
        zd9.h.a.getClass();     // Catch: Throwable -> L89
        String r38 = zd9.h.c(r37);     // Catch: Throwable -> L89
    L56:
        r113.setInstantUploadInfoJson(r38);     // Catch: Throwable -> L89
        if (r36 == null) goto L62;
        ImageObj r39 = r36.imageOri;     // Catch: Throwable -> L89
        if (r39 == null) goto L62;
    L61:
        r11 = r39;
        mr9.d r40 = r17.d;     // Catch: Throwable -> L89
        if (r40 == null) goto L68;
        int r41 = r40.b;     // Catch: Throwable -> L89
    L69:
        r11.width = r41;     // Catch: Throwable -> L89
        if (r40 == null) goto L72;
        int r42 = r40.a;     // Catch: Throwable -> L89
    L73:
        r11.height = r42;     // Catch: Throwable -> L89
        MainCoroutineDispatcher r43 = Dispatchers.getMain();     // Catch: Throwable -> L89
        CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$2 r44 = new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$2(r16, r113, null);     // Catch: Throwable -> L89
        this.L$0 = r113;     // Catch: Throwable -> L89
        this.L$1 = r17;     // Catch: Throwable -> L89
        this.L$2 = r16;     // Catch: Throwable -> L89
        this.L$3 = r15;     // Catch: Throwable -> L89
        this.L$4 = r14;     // Catch: Throwable -> L89
        this.L$5 = r30;     // Catch: Throwable -> L89
        this.L$6 = r112;     // Catch: Throwable -> L89
        this.L$7 = r11;     // Catch: Throwable -> L89
        this.Z$0 = r28;     // Catch: Throwable -> L89
        this.label = 1;     // Catch: Throwable -> L89
        if (BuildersKt.withContext(r43, r44, this) != r2) goto L76;
        return r2;
    L76:
        r10 = r28;
        r22 = r30;
        r19 = r112;
        r20 = r113;
        goto L19
    L72:
        r42 = 0;
        goto L73
    L68:
        r41 = 0;
    L62:
        r39 = new ImageObj(null, 0, 0, null, null, 31, null);     // Catch: Throwable -> L89
        if (r36 == null) goto L61;
        r36.imageOri = r39;     // Catch: Throwable -> L89
        goto L61
    L55:
        r38 = null;
        goto L56
    L43:
        UplinkEntityContent r45 = r113.getUplinkEntityContent();     // Catch: Throwable -> L89
        if (r45 == null) goto L48;
        UplinkFileInfo r46 = r45.getUplinkFileInfo();     // Catch: Throwable -> L89
        if (r46 == null) goto L48;
        r46.setLocalResPath(r34);     // Catch: Throwable -> L89
        goto L48
    L39:
        r36 = null;
        goto L40
    L32:
        r34 = null;
        goto L33
    L29:
        r33 = null;
    L34:
        r34 = (String) r29.element;     // Catch: Throwable -> L89
        goto L36
    L35:
        r34 = (String) r29.element;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    }
}

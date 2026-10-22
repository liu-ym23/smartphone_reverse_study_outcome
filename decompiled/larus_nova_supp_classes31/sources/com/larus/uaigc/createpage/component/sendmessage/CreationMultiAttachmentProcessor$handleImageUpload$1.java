package com.larus.uaigc.createpage.component.sendmessage;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1", f = "CreationMultiAttachmentProcessor.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4}, l = {457, 469, 623, 641, 756}, m = "invokeSuspend", n = {"localResPath", "pipelineEnabled", "localResPath", "preprocessFileInfo", "pipelineEnabled", "localResPath", "preprocessFileInfo", "curUploaderIdentifier", "taskReusedForSend", "successCallback", "processCallback", "failedCallback", "existingUploadResult", "pipelineEnabled", "successCallback", "failedCallback", "identifier"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$0"})
final class CreationMultiAttachmentProcessor$handleImageUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ String $pendingIdentifier;
    Object L$0;
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

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$2", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ String $localNestedFileMessageId;
        int label;

        public AnonymousClass2(String r1, UplinkFileEntity r2, Continuation<? super AnonymousClass2> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$localNestedFileMessageId, this.$entity, r4);
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

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$5", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ String $localNestedFileMessageId;
        int label;

        public AnonymousClass5(String r1, UplinkFileEntity r2, Continuation<? super AnonymousClass5> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass5(this.$localNestedFileMessageId, this.$entity, r4);
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

    public CreationMultiAttachmentProcessor$handleImageUpload$1(UplinkFileEntity r1, String r2, CreationSendMessageConfig r3, CreationMultiAttachmentProcessor r4, CustomMultiAttachmentInfo r5, AtomicBoolean r6, AtomicInteger r7, AtomicBoolean r8, Map<String, String> r9, String r10, String r11, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1> r12) {
        this.$entity = r1;
        this.$localNestedFileMessageId = r2;
        this.$config = r3;
        this.this$0 = r4;
        this.$customMultiAttachment = r5;
        this.$finishOnce = r6;
        this.$handlingFileCount = r7;
        this.$messageSent = r8;
        this.$ext = r9;
        this.$localTextMessageId = r10;
        this.$pendingIdentifier = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new CreationMultiAttachmentProcessor$handleImageUpload$1(this.$entity, this.$localNestedFileMessageId, this.$config, this.this$0, this.$customMultiAttachment, this.$finishOnce, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, this.$pendingIdentifier, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final Object invokeSuspend(Object r63) {
        String r2 = "[handleImageUpload] localMessageId=";
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L15;
        if (r5 == 4) goto L12;
        if (r5 != 5) goto L11;
        String r0 = (String) this.L$0;
        ResultKt.throwOnFailure(r63);
        String r13 = r0;
        ?? r6 = this;
    L260:
        CreationMultiAttachmentProcessor.c(r6.$finishOnce, r6.$handlingFileCount, r6.this$0, r6.$messageSent, r6.$config, r6.$ext, r6.$localNestedFileMessageId, r6.$localTextMessageId, r13, "handleImageUpload exception");
    L262:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Function1 r1 = (Function1) this.L$1;
        Function1 r3 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r63);     // Catch: Throwable -> L242
        Function1 r7 = r3;
        Function1 r8 = r1;
        Object r9 = r63;
    L126:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r9, r7, r8);     // Catch: Throwable -> L127
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L127
        goto L262
    L15:
        boolean r11 = this.Z$0;
        mr9.l r12 = (mr9.l) this.L$7;
        Function1 r14 = (Function1) this.L$6;
        Function1 r15 = (Function1) this.L$5;
        r7 = (Function1) this.L$4;
        Ref.BooleanRef r16 = (Ref.BooleanRef) this.L$3;
        String r17 = (String) this.L$2;
        ic8.m0 r18 = (ic8.m0) this.L$1;
        Ref.ObjectRef r19 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r63);     // Catch: Throwable -> L242
        String r38 = "[handleImageUpload] observe existing taskId=";
        String r40 = "[handleImageUpload] reuse ready artifact, identifier=";
        String r37 = ", identifier=";
        String r39 = "CreationMultiAttachmentProcessor";
        String r36 = "";
        Object r20 = r63;
        ?? r21 = this;
        Ref.BooleanRef r22 = r16;
        boolean r110 = r11;
        r4 = r4;
    L275:
        com.larus.bmhome.resource.access.b0 r23 = (com.larus.bmhome.resource.access.b0) r20;     // Catch: Throwable -> L107
        mr9.l r24 = r12;
        ic8.m0 r111 = r18;
        final Function1 r25 = r15;
        boolean r26 = r110;
        Function1 r61 = r14;
        Ref.BooleanRef r112 = r22;
        r8 = r61;
        r4 = r4;
        r21 = r21;
    L117:
        if (r24 == null) goto L121;
        FLogger.a.i(r39, r40 + r17);     // Catch: Throwable -> L127
        r112.element = true;     // Catch: Throwable -> L127
        r7.invoke(r24);     // Catch: Throwable -> L127
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L127
        goto L262
    L121:
        String r28 = r39;
        if (r23 == null) goto L130;
        CreationResourceAccessUploader r29 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L127
        CreationResourceAccessUploader.h(r17);     // Catch: Throwable -> L127
        FLogger.a.i(r28, r38 + r23.getTaskId() + r37 + r17);     // Catch: Throwable -> L127
        r112.element = true;     // Catch: Throwable -> L127
        Function1 r30 = new x();     // Catch: Throwable -> L127
        Function1 r31 = new y(r25);     // Catch: Throwable -> L127
        r21.L$0 = r7;     // Catch: Throwable -> L127
        r21.L$1 = r8;     // Catch: Throwable -> L127
        r21.L$2 = null;     // Catch: Throwable -> L127
        r21.L$3 = null;     // Catch: Throwable -> L127
        r21.L$4 = null;     // Catch: Throwable -> L127
        r21.L$5 = null;     // Catch: Throwable -> L127
        r21.L$6 = null;     // Catch: Throwable -> L127
        r21.L$7 = null;     // Catch: Throwable -> L127
        r21.label = 4;     // Catch: Throwable -> L127
        r9 = ICreationResourceAccessServiceKt.a(r23, r30, r31, r21);     // Catch: Throwable -> L127
        if (r9 != r4) goto L126;
        return r4;
    L130:
        if (r26 == true) goto L136;
        ICreationResourceAccessService.Companion r32 = ICreationResourceAccessService.a;     // Catch: Throwable -> L127
        int r33 = com.larus.uaigc.service.p0.x;     // Catch: Throwable -> L127
        String r113 = (String) r19.element;     // Catch: Throwable -> L127
        com.larus.bmhome.resource.access.d0 r34 = com.larus.uaigc.service.g.a;     // Catch: Throwable -> L127
        ResourceCenter.a.getClass();     // Catch: Throwable -> L127
        boolean r35 = ResourceCenter.d(r17);     // Catch: Throwable -> L127
        String r210 = com.larus.platform.service.o.a.getDeviceId();     // Catch: Throwable -> L127
        String r211 = r21.$config.getCvsId();     // Catch: Throwable -> L127
        String r212 = r21.$config.getBotId();     // Catch: Throwable -> L127
        wc9.e r114 = r21.$config.getConversation();     // Catch: Throwable -> L127
        if (r114 == null) goto L134;
        String r213 = r114.B;     // Catch: Throwable -> L127
    L135:
        r32.b(com.larus.uaigc.service.p0.a.c(r113, r17, r111, new mr9.h(r35, new ResourceAttachmentExtra(r210, r211, r212, r213, r21.$localNestedFileMessageId), null, 28), false, null, null, null, null, r25, r7, r8, null, r34, null, 1820616));     // Catch: Throwable -> L127
        goto L262
    L134:
        r213 = null;
        goto L135
    L136:
        UplinkEntityContent r41 = r21.$entity.getUplinkEntityContent();     // Catch: Throwable -> L127
        if (r41 == null) goto L139;
        Image r42 = r41.getUplinkImageInfo();     // Catch: Throwable -> L127
    L140:
        Object r43 = r19.element;     // Catch: Throwable -> L127
        String r44 = (String) r43;     // Catch: Throwable -> L127
    L231:
        th = th;
    L245:
        String r45 = r21.$entity.getFileIdentifier();
        if (r45 != null) goto L248;
        String r115 = r36;
    L249:
        String r46 = r21.$pendingIdentifier;
        if (r115.length() != 0) goto L252;
        boolean r47 = true;
    L253:
        if (r47 == true) goto L256;
        r46 = r115;
    L256:
        FLogger.a.e(r28, "[handleImageUpload] process failed before callback, identifier: " + r46, th);
        CreationResourceAccessUploader r48 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r46);
        r21.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        MainCoroutineDispatcher r49 = Dispatchers.getMain();
        AnonymousClass5 r50 = new AnonymousClass5(r21.$localNestedFileMessageId, r21.$entity, null);
        r21.L$0 = r46;
        r21.L$1 = null;
        r21.L$2 = null;
        r21.L$3 = null;
        r21.L$4 = null;
        r21.L$5 = null;
        r21.L$6 = null;
        r21.L$7 = null;
        r21.label = 5;
        if (BuildersKt.withContext(r49, r50, r21) != r4) goto L259;
        return r4;
    L259:
        r13 = r46;
        r6 = r21;
        goto L260
    L252:
        r47 = false;
        goto L253
    L248:
        r115 = r45;
        goto L249
    L143:
        if (StringsKt.startsWith$default(r44, "content://", false, 2, null) == false) goto L145;
    L152:
        boolean r51 = true;
    L153:
        if (r51 == true) goto L156;
        r43 = null;
    L156:
        String r52 = (String) r43;     // Catch: Throwable -> L231
        int r53 = t0.a;     // Catch: Throwable -> L231
        if (r42 == null) goto L159;
        String r54 = r42.key;     // Catch: Throwable -> L231
    L160:
        if (r42 == null) goto L165;
        ImageObj r116 = r42.imageOri;     // Catch: Throwable -> L231
        if (r116 == null) goto L165;
        String r117 = r116.url;     // Catch: Throwable -> L231
        if (r117 == null) goto L165;
    L176:
        String r55 = r117;
    L177:
        Uri r118 = r21.$entity.getUri();     // Catch: Throwable -> L231
        if (r118 == null) goto L180;
        String r119 = r118.toString();     // Catch: Throwable -> L231
    L181:
        s0 r56 = t0.c(r54, r55, r52, r119);     // Catch: Throwable -> L231
        com.larus.bmhome.resource.access.j0 r410 = CreationMultiAttachmentProcessor.g(r21.this$0, r56);     // Catch: Throwable -> L231
        if (r410 != null) goto L186;
        r8.invoke(new ResourceUploadError("missing_resource_input", "pending image resource input is missing"));     // Catch: Throwable -> L231
        return Unit.INSTANCE;
    L186:
        if (r56.getType() != CreationPendingResourceInputType.TOS_KEY) goto L188;
    L191:
        boolean r57 = true;
    L192:
        ICreationResourceAccessService.Companion r58 = ICreationResourceAccessService.a;     // Catch: Throwable -> L231
        int r59 = com.larus.uaigc.service.p0.x;     // Catch: Throwable -> L231
        if (r57 == false) goto L195;
        String r411 = "creation_remote";
    L196:
        CreationMultiAttachmentProcessor r60 = r21.this$0;     // Catch: Throwable -> L231
        String r120 = (String) r19.element;     // Catch: Throwable -> L231
        Uri r121 = r21.$entity.getUri();     // Catch: Throwable -> L231
        if (r121 == null) goto L199;
        String r122 = r121.toString();     // Catch: Throwable -> L231
    L200:
        String r412 = CreationMultiAttachmentProcessor.e(r60, r120, r122);     // Catch: Throwable -> L231
        if (r57 == false) goto L203;
        String r413 = "remote";
    L204:
        Object r62 = r19.element;     // Catch: Throwable -> L231
        String r123 = (String) r62;     // Catch: Throwable -> L231
        if (r57 == true) goto L207;
    L211:
        boolean r64 = false;
    L212:
        if (r64 == true) goto L215;
        r62 = null;
    L215:
        String r65 = (String) r62;     // Catch: Throwable -> L231
        if (r65 == null) goto L218;
        Map r66 = MapsKt.mapOf(TuplesKt.to("remote_detect_local_path", r65));     // Catch: Throwable -> L231
    L219:
        if (r66 != null) goto L221;
        r66 = MapsKt.emptyMap();     // Catch: Throwable -> L231
    L221:
        Map r510 = r66;
        CountDownLatch r67 = new CountDownLatch(1);     // Catch: Throwable -> L229
        com.larus.bmhome.resource.access.d0 r511 = com.larus.uaigc.service.g.a;     // Catch: Throwable -> L229
        ResourceCenter.a.getClass();     // Catch: Throwable -> L229
        boolean r124 = ResourceCenter.d(r17);     // Catch: Throwable -> L229
        String r125 = com.larus.platform.service.o.a.getDeviceId();     // Catch: Throwable -> L229
        String r126 = r21.$config.getCvsId();     // Catch: Throwable -> L229
        String r127 = r21.$config.getBotId();     // Catch: Throwable -> L229
        wc9.e r128 = r21.$config.getConversation();     // Catch: Throwable -> L229
        if (r128 == null) goto L226;
        String r214 = r128.B;     // Catch: Throwable -> L229
    L227:
        r58.b(com.larus.uaigc.service.p0.a.b(r410, r17, r411, new mr9.h(r124, new ResourceAttachmentExtra(r125, r126, r127, r214, r21.$localNestedFileMessageId), null, 28), true, r67, r412, null, r413, r25, r7, r8, null, null, null, null, r510, r511, false, null, 1696000));     // Catch: Throwable -> L229
        goto L262
    L226:
        r214 = null;
    L229:
        th = th;
        goto L245
    L218:
        r66 = null;
        goto L219
    L207:
        if ((!StringsKt.isBlank(r123)) == false) goto L211;
        if (new PolarisFileWrapper(r123).exists() == false) goto L211;
        r64 = true;
        goto L212
    L203:
        r413 = null;
        goto L204
    L199:
        r122 = null;
        goto L200
    L195:
        r411 = null;
        goto L196
    L188:
        if (r56.getType() == CreationPendingResourceInputType.REMOTE_URL) goto L191;
        r57 = false;
        goto L192
    L180:
        r119 = null;
    L165:
        if (r42 == null) goto L169;
        ImageObj r129 = r42.imageThumb;     // Catch: Throwable -> L231
        if (r129 == null) goto L169;
        r117 = r129.url;     // Catch: Throwable -> L231
    L170:
        if (r117 != null) goto L176;
        if (r42 == null) goto L175;
        ImageObj r68 = r42.previewImage;     // Catch: Throwable -> L231
        if (r68 == null) goto L175;
        r55 = r68.url;     // Catch: Throwable -> L231
    L175:
        r55 = null;
    L169:
        r117 = null;
        goto L170
    L159:
        r54 = null;
        goto L160
    L145:
        if (StringsKt.startsWith$default(r44, "file://", false, 2, null) == true) goto L152;
        if ((!StringsKt.isBlank(r44)) == true) goto L149;
    L151:
        r51 = false;
        goto L153
    L149:
        if (new PolarisFileWrapper(r44).exists() == false) goto L151;
    L139:
        r42 = null;
    L107:
        th = th;
    L108:
        r28 = r39;
        r4 = r4;
        r21 = r21;
        goto L245
    L18:
        boolean r69 = this.Z$0;
        ic8.m0 r70 = (ic8.m0) this.L$1;
        Ref.ObjectRef r71 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r63);     // Catch: Throwable -> L242
        r19 = r71;
        ic8.m0 r72 = r70;
    L59:
        String r73 = this.$entity.getFileIdentifier();     // Catch: Throwable -> L242
        if (r73 != null) goto L62;
        r17 = "";
    L63:
        tx9.l0.d(r17);     // Catch: Throwable -> L242
        FLogger.a.i("CreationMultiAttachmentProcessor", "[handleImageUpload] localMessageId=" + this.$localNestedFileMessageId + ", identifier=" + r17);     // Catch: Throwable -> L242
        ResourceCenter r74 = ResourceCenter.a;     // Catch: Throwable -> L242
        FlowResourceScene r75 = FlowResourceScene.ImageVLM;     // Catch: Throwable -> L242
        r74.getClass();     // Catch: Throwable -> L242
        ResourceCenter.k(r17, r75);     // Catch: Throwable -> L242
        if (r69 == false) goto L66;
        com.larus.bmhome.resource.access.z r76 = ICreationResourceAccessService.a.c(ICreationResourceAccessService.a, r17, com.larus.uaigc.service.f.a, ResourceMediaType.IMAGE, 8);     // Catch: Throwable -> L242
    L67:
        final long r77 = System.currentTimeMillis();     // Catch: Throwable -> L242
        final Ref.BooleanRef r130 = new Ref.BooleanRef();     // Catch: Throwable -> L242
        if (r69 == false) goto L70;
        final boolean r215 = true;
    L71:
        final UplinkFileEntity r78 = this.$entity;     // Catch: Throwable -> L242
        r36 = "";
        final String r131 = this.$localNestedFileMessageId;     // Catch: Throwable -> L240
        r37 = ", identifier=";
        final CustomMultiAttachmentInfo r79 = this.$customMultiAttachment;     // Catch: Throwable -> L240
        r38 = "[handleImageUpload] observe existing taskId=";
        final CreationMultiAttachmentProcessor r80 = this.this$0;     // Catch: Throwable -> L240
        r39 = "CreationMultiAttachmentProcessor";
        final CreationSendMessageConfig r132 = this.$config;     // Catch: Throwable -> L238
        r40 = "[handleImageUpload] reuse ready artifact, identifier=";
        final AtomicBoolean r81 = this.$finishOnce;     // Catch: Throwable -> L238
        final AtomicInteger r82 = this.$handlingFileCount;     // Catch: Throwable -> L236
        ic8.m0 r414 = r72;
        final AtomicBoolean r83 = this.$messageSent;     // Catch: Throwable -> L236
        boolean r415 = r69;
        final Map<String, String> r84 = this.$ext;     // Catch: Throwable -> L236
        final String r133 = this.$localTextMessageId;     // Catch: Throwable -> L236
        final String r134 = r17;
        final Ref.ObjectRef r216 = r19;
        final com.larus.bmhome.resource.access.z r310 = r76;
        Function1 r85 = new u(r134, r216, r215, r78, r131, r79, r80, r132, r81, r82, r83, r84, r133, r310, r77, r130);     // Catch: Throwable -> L233
        r25 = new v(r78, r131);     // Catch: Throwable -> L233
        final String r135 = r17;
        final Ref.ObjectRef r217 = r19;
        final com.larus.bmhome.resource.access.z r311 = r76;
        r8 = new w(r135, r217, r78, r131, r81, r82, r80, r83, r132, r84, r133, r311, r77, r130);     // Catch: Throwable -> L233
        if (r415 == false) goto L94;
        if (r76 == null) goto L82;
        com.larus.bmhome.resource.access.a0 r86 = r76.c;     // Catch: Throwable -> L233
    L84:
        if ((r86 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L86;
        com.larus.bmhome.resource.access.a0.d r87 = (com.larus.bmhome.resource.access.a0.d) r86;     // Catch: Throwable -> L233
    L87:
        if (r87 == null) goto L90;
        com.larus.bmhome.resource.access.f0 r88 = r87.a;     // Catch: Throwable -> L233
        if (r88 == null) goto L90;
    L91:
        if (r88 == null) goto L94;
        r12 = com.larus.bmhome.resource.access.s.c(r88);     // Catch: Throwable -> L233
    L95:
        if (r415 == false) goto L116;
        if (r12 != null) goto L116;
        ICreationResourceAccessService.Companion r89 = ICreationResourceAccessService.a;     // Catch: Throwable -> L113
        com.larus.bmhome.resource.access.x r90 = com.larus.uaigc.service.f.a;     // Catch: Throwable -> L113
        ResourceMediaType r91 = ResourceMediaType.IMAGE;     // Catch: Throwable -> L113
        com.larus.bmhome.resource.access.b0 r92 = ICreationResourceAccessService.a.b(r89, r17, r90, r91, 8);     // Catch: Throwable -> L113
        if (r92 != null) goto L112;
        CreationResourceAccessUploader r93 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L113
        CreationMultiAttachmentProcessor$handleImageUpload$1 r94 = this;
        r7 = r85;
        r94.L$0 = r19;     // Catch: Throwable -> L110
        r18 = r414;
        r94.L$1 = r18;     // Catch: Throwable -> L110
        r94.L$2 = r17;     // Catch: Throwable -> L110
        r94.L$3 = r130;     // Catch: Throwable -> L110
        r94.L$4 = r7;     // Catch: Throwable -> L110
        r94.L$5 = r25;     // Catch: Throwable -> L110
        r94.L$6 = r8;     // Catch: Throwable -> L110
        r94.L$7 = r12;     // Catch: Throwable -> L110
        r110 = r415;
        r94.Z$0 = r110;     // Catch: Throwable -> L110
        r94.label = 3;     // Catch: Throwable -> L110
        r20 = CreationResourceAccessUploader.d(r17, r90, r91, r94);     // Catch: Throwable -> L110
        Object r95 = r4;
        if (r20 != r95) goto L105;
        return r95;
    L105:
        r14 = r8;
        r22 = r130;
        r15 = r25;
        r4 = r95;
        r21 = r94;
    L110:
        th = th;
        r21 = r94;
    L115:
        r4 = r4;
        goto L108
    L112:
        r21 = this;
        r7 = r85;
        r4 = r4;
        r23 = r92;
        r24 = r12;
        r111 = r414;
        r112 = r130;
        r26 = r415;
    L113:
        th = th;
        r21 = this;
    L116:
        r21 = this;
        r7 = r85;
        r4 = r4;
        r24 = r12;
        r111 = r414;
        r112 = r130;
        r26 = r415;
        r23 = null;
    L90:
        r88 = ICreationResourceAccessService.a.c(r17);     // Catch: Throwable -> L233
        goto L91
    L86:
        r87 = null;
        goto L87
    L82:
        r86 = null;
    L94:
        r12 = null;
    L233:
        th = th;
        CreationMultiAttachmentProcessor$handleImageUpload$1 r96 = this;
    L235:
        r28 = r39;
        r4 = r4;
        r21 = r96;
    L236:
        th = th;
        r96 = this;
    L238:
        th = th;
        r28 = r39;
    L244:
        r21 = this;
    L240:
        th = th;
        r28 = "CreationMultiAttachmentProcessor";
        goto L244
    L70:
        r215 = false;
        goto L71
    L66:
        r76 = null;
        goto L67
    L62:
        r17 = r73;
        goto L63
    L21:
        r69 = this.Z$0;
        Ref.ObjectRef r97 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r63);     // Catch: Throwable -> L242
        Object r98 = r63;
    L38:
        ic8.n0 r99 = (ic8.n0) r98;     // Catch: Throwable -> L242
        ProcessFileResultCode r100 = r99.b;     // Catch: Throwable -> L242
        if (r100 != null) goto L41;
    L43:
        boolean r101 = false;
    L44:
        if (r101 == false) goto L52;
        r72 = r99.a;     // Catch: Throwable -> L242
        if (r72 == null) goto L48;
        String r102 = r72.e;     // Catch: Throwable -> L242
    L49:
        if (r102 != null) goto L51;
        r102 = "";
    L51:
        r97.element = r102;     // Catch: Throwable -> L242
    L53:
        if (r69 == true) goto L55;
        this.$entity.setFileParsedStatus(Boxing.boxInt(FileParseState.SUCCESS.getValue()));     // Catch: Throwable -> L242
    L55:
        MainCoroutineDispatcher r103 = Dispatchers.getMain();     // Catch: Throwable -> L242
        AnonymousClass2 r136 = new AnonymousClass2(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L242
        this.L$0 = r97;     // Catch: Throwable -> L242
        this.L$1 = r72;     // Catch: Throwable -> L242
        this.Z$0 = r69;     // Catch: Throwable -> L242
        this.label = 2;     // Catch: Throwable -> L242
        if (BuildersKt.withContext(r103, r136, this) != r4) goto L58;
        return r4;
    L58:
        r19 = r97;
        goto L59
    L48:
        r102 = null;
    L52:
        r72 = null;
        goto L53
    L41:
        if (r100.isSuccess() != true) goto L43;
        r101 = true;
        goto L44
    L24:
        ResultKt.throwOnFailure(r63);
        final String r104 = this.$localNestedFileMessageId;     // Catch: Throwable -> L242
        final UplinkFileEntity r105 = this.$entity;     // Catch: Throwable -> L242
        com.larus.utils.t0.e(new t(r104, r105));     // Catch: Throwable -> L242
        r97 = new Ref.ObjectRef();     // Catch: Throwable -> L242
        String r106 = l1.d(this.$entity);     // Catch: Throwable -> L242
        if (r106 != null) goto L28;
        r106 = "";
    L28:
        r97.element = r106;     // Catch: Throwable -> L242
        com.larus.uaigc.helper.f.a.getClass();     // Catch: Throwable -> L242
        r69 = com.larus.uaigc.helper.f.a();     // Catch: Throwable -> L242
        if (r69 == true) goto L52;
        Integer r107 = this.$entity.getFileParsedStatus();     // Catch: Throwable -> L242
        int r108 = FileParseState.SUCCESS.getValue();     // Catch: Throwable -> L242
        if (r107 != null) goto L34;
    L35:
        CreationImageUploadPolicy r109 = CreationImageUploadPolicy.a;     // Catch: Throwable -> L242
        Uri r137 = Uri.fromFile(new PolarisFileWrapper((String) r97.element));     // Catch: Throwable -> L242
        this.L$0 = r97;     // Catch: Throwable -> L242
        this.Z$0 = r69;     // Catch: Throwable -> L242
        this.label = 1;     // Catch: Throwable -> L242
        r98 = r109.a(r137, "ai_creation", null, this);     // Catch: Throwable -> L242
        if (r98 != r4) goto L38;
        return r4;
    L34:
        if (r107.intValue() == r108) goto L52;
    L242:
        th = th;
        r28 = "CreationMultiAttachmentProcessor";
        r36 = "";
    L127:
        th = th;
        r4 = r2;
        r21 = r4;
        goto L245
    }

    public static final void a(String r9, com.larus.bmhome.resource.access.z r10, long r11, Ref.BooleanRef r13, String r14, String r15) {
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        ResourceMediaType r2 = ResourceMediaType.IMAGE;
        long r4 = System.currentTimeMillis() - r11;
        boolean r6 = r13.element;
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("local_nested_file_message_id", r14);
        if (r10 == null) goto L7;
        com.larus.bmhome.resource.access.a0 r3 = r10.c;
        if (r3 == null) goto L7;
        String r5 = r3.getClass().getSimpleName();
    L8:
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r1[1] = TuplesKt.to("task_state_at_click", r5);
        CreationResourceAccessUploader.k(r9, r10, r2, r15, r4, r6, "creation_multi_attachment_image", MapsKt.mapOf(r1));
        return;
    L7:
        r5 = null;
        goto L8
    }
}

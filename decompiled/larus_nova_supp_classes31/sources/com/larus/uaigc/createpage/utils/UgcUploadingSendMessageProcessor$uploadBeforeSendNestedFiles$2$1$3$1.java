package com.larus.uaigc.createpage.utils;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.uaigc.service.p0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import ic8.m0;
import ic8.n0;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.l0;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1", f = "NestedFileSendMessageProcessor.kt", i = {1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4}, l = {432, 441, 453, 620, 637, 678}, m = "invokeSuspend", n = {"localResPath", "localResPath", "preprocessFileInfo", "localResPath", "preprocessFileInfo", "successCallback", "processCallback", "failedCallback", "existingArtifact", "successCallback", "failedCallback"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1"})
final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curUploaderIdentifier;
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    final /* synthetic */ boolean $pipelineEnabled;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$2", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
        int label;

        public AnonymousClass2(Ref.ObjectRef<String> r1, UplinkFileEntity r2, Continuation<? super AnonymousClass2> r3) {
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
            NestedFileCacheManagerService.b.k((String) this.$localNestedFileMessageId.element, this.$entity);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$3", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
        int label;

        public AnonymousClass3(Ref.ObjectRef<String> r1, UplinkFileEntity r2, Continuation<? super AnonymousClass3> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$localNestedFileMessageId, this.$entity, r4);
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

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1(UplinkFileEntity r1, boolean r2, String r3, Ref.ObjectRef<String> r4, y8 r5, ICoreInputAbility.OnSendParams r6, UgcUploadingSendMessageProcessor r7, AtomicBoolean r8, AtomicInteger r9, AtomicBoolean r10, Map<String, String> r11, Ref.ObjectRef<String> r12, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r13, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1> r14) {
        this.$entity = r1;
        this.$pipelineEnabled = r2;
        this.$curUploaderIdentifier = r3;
        this.$localNestedFileMessageId = r4;
        this.$dependency = r5;
        this.$params = r6;
        this.this$0 = r7;
        this.$finishOnce = r8;
        this.$handlingFileCount = r9;
        this.$messageSent = r10;
        this.$ext = r11;
        this.$localTextMessageId = r12;
        this.$originalLogic = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1(this.$entity, this.$pipelineEnabled, this.$curUploaderIdentifier, this.$localNestedFileMessageId, this.$dependency, this.$params, this.this$0, this.$finishOnce, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, this.$originalLogic, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r7 = "";
        boolean r8 = true;
        switch(this.label) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r41);
    L128:
        UgcUploadingSendMessageProcessor.c(this.$finishOnce, this.$curUploaderIdentifier, this.$handlingFileCount, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$originalLogic, "imageUpload exception");
    L130:
        return Unit.INSTANCE;
    L7:
        Function1 r0 = (Function1) this.L$1;
        Function1 r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r41);     // Catch: Throwable -> L123
        Function1 r15 = r2;
        Object r3 = r41;
    L96:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r3, r15, r0);     // Catch: Throwable -> L117
        goto L130
    L10:
        com.larus.bmhome.resource.access.f0 r5 = (com.larus.bmhome.resource.access.f0) this.L$5;
        Function1 r6 = (Function1) this.L$4;
        Function1 r9 = (Function1) this.L$3;
        Function1 r10 = (Function1) this.L$2;
        m0 r11 = (m0) this.L$1;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r41);     // Catch: Throwable -> L123
        String r28 = "[imageUpload] observe existing taskId=";
        String r30 = "[imageUpload] reuse ready artifact, identifier=";
        String r27 = ", identifier=";
        String r29 = "NestedFileSendMessageProcessor";
        Object r1 = r41;
    L131:
        com.larus.bmhome.resource.access.b0 r13 = (com.larus.bmhome.resource.access.b0) r1;     // Catch: Throwable -> L78
        r0 = r6;
        final Function1 r14 = r9;
        r15 = r10;
        m0 r16 = r11;
        Ref.ObjectRef r17 = r12;
    L84:
        if (r5 == null) goto L86;
        mr9.l r18 = com.larus.bmhome.resource.access.s.c(r5);     // Catch: Throwable -> L78
    L87:
        if (r18 == null) goto L91;
        FLogger.a.i(r29, r30 + this.$curUploaderIdentifier);     // Catch: Throwable -> L117
        r15.invoke(r18);     // Catch: Throwable -> L117
        goto L130
    L91:
        String r19 = r29;
        if (r13 == null) goto L97;
        CreationResourceAccessUploader r20 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L117
        CreationResourceAccessUploader.h(this.$curUploaderIdentifier);     // Catch: Throwable -> L117
        FLogger.a.i(r19, r28 + r13.getTaskId() + r27 + this.$curUploaderIdentifier);     // Catch: Throwable -> L117
        Function1 r21 = new w();     // Catch: Throwable -> L117
        Function1 r22 = new x(r14);     // Catch: Throwable -> L117
        this.L$0 = r15;     // Catch: Throwable -> L117
        this.L$1 = r0;     // Catch: Throwable -> L117
        this.L$2 = null;     // Catch: Throwable -> L117
        this.L$3 = null;     // Catch: Throwable -> L117
        this.L$4 = null;     // Catch: Throwable -> L117
        this.L$5 = null;     // Catch: Throwable -> L117
        this.label = 5;     // Catch: Throwable -> L117
        r3 = ICreationResourceAccessServiceKt.a(r13, r21, r22, this);     // Catch: Throwable -> L117
        if (r3 != r4) goto L96;
        return r4;
    L97:
        ICreationResourceAccessService.Companion r23 = ICreationResourceAccessService.a;     // Catch: Throwable -> L117
        int r24 = p0.x;     // Catch: Throwable -> L117
        String r25 = (String) r17.element;     // Catch: Throwable -> L117
        com.larus.bmhome.resource.access.d0 r110 = com.larus.uaigc.service.g.a;     // Catch: Throwable -> L117
        ResourceCenter r26 = ResourceCenter.a;     // Catch: Throwable -> L117
        String r31 = this.$curUploaderIdentifier;     // Catch: Throwable -> L117
        r26.getClass();     // Catch: Throwable -> L117
        boolean r32 = ResourceCenter.d(r31);     // Catch: Throwable -> L117
        String r210 = com.larus.platform.service.o.a.getDeviceId();     // Catch: Throwable -> L117
        com.larus.bmhome.chat.component.cvs.y r33 = this.$dependency.u0();     // Catch: Throwable -> L117
        if (r33 == null) goto L100;
        String r211 = r33.Y1();     // Catch: Throwable -> L117
    L101:
        com.larus.bmhome.chat.component.cvs.y r34 = this.$dependency.u0();     // Catch: Throwable -> L117
        if (r34 == null) goto L104;
        String r212 = r34.getBotId();     // Catch: Throwable -> L117
    L105:
        com.larus.bmhome.chat.component.cvs.y r35 = this.$dependency.u0();     // Catch: Throwable -> L117
        if (r35 == null) goto L110;
        wc9.e r36 = r35.h();     // Catch: Throwable -> L117
        if (r36 == null) goto L110;
        String r213 = r36.B;     // Catch: Throwable -> L117
    L112:
        String r38 = r19;
        r23.b(p0.a.c(r25, this.$curUploaderIdentifier, r16, new mr9.h(r32, new ResourceAttachmentExtra(r210, r211, r212, r213, (String) this.$localNestedFileMessageId.element), null, 28), false, null, null, null, null, r14, r15, r0, null, r110, null, 1820616));     // Catch: Throwable -> L115
    L115:
        th = th;
    L125:
        FLogger.a.e(r38, "[imageUpload] process failed before callback, identifier: " + this.$curUploaderIdentifier, th);
        CreationResourceAccessUploader r37 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(this.$curUploaderIdentifier);
        this.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        MainCoroutineDispatcher r39 = Dispatchers.getMain();
        AnonymousClass3 r40 = new AnonymousClass3(this.$localNestedFileMessageId, this.$entity, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 6;
        if (BuildersKt.withContext(r39, r40, this) != r4) goto L128;
        return r4;
    L110:
        r213 = null;
        goto L112
    L104:
        r212 = null;
        goto L105
    L100:
        r211 = null;
        goto L101
    L86:
        r18 = null;
    L78:
        th = th;
        String r111 = r29;
    L118:
        r38 = r111;
        goto L125
    L13:
        m0 r42 = (m0) this.L$1;
        Ref.ObjectRef r43 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r41);     // Catch: Throwable -> L123
        m0 r112 = r42;
        r17 = r43;
    L60:
        l0.d(this.$curUploaderIdentifier);     // Catch: Throwable -> L123
        FLogger.a.i("NestedFileSendMessageProcessor", "[imageResourceAccess] localMessageId=" + ((String) this.$localNestedFileMessageId.element) + ", identifier=" + this.$curUploaderIdentifier);     // Catch: Throwable -> L123
        ResourceCenter r44 = ResourceCenter.a;     // Catch: Throwable -> L123
        String r45 = this.$curUploaderIdentifier;     // Catch: Throwable -> L123
        FlowResourceScene r46 = FlowResourceScene.ImageVLM;     // Catch: Throwable -> L123
        r44.getClass();     // Catch: Throwable -> L123
        ResourceCenter.k(r45, r46);     // Catch: Throwable -> L123
        final String r47 = this.$curUploaderIdentifier;     // Catch: Throwable -> L123
        final boolean r48 = this.$pipelineEnabled;     // Catch: Throwable -> L123
        final UplinkFileEntity r49 = this.$entity;     // Catch: Throwable -> L123
        final Ref.ObjectRef<String> r113 = this.$localNestedFileMessageId;     // Catch: Throwable -> L123
        final y8 r114 = this.$dependency;     // Catch: Throwable -> L123
        final ICoreInputAbility.OnSendParams r115 = this.$params;     // Catch: Throwable -> L123
        final UgcUploadingSendMessageProcessor r116 = this.this$0;     // Catch: Throwable -> L123
        final AtomicBoolean r117 = this.$finishOnce;     // Catch: Throwable -> L123
        r27 = ", identifier=";
        final AtomicInteger r50 = this.$handlingFileCount;     // Catch: Throwable -> L123
        r28 = "[imageUpload] observe existing taskId=";
        final AtomicBoolean r51 = this.$messageSent;     // Catch: Throwable -> L123
        r29 = "NestedFileSendMessageProcessor";
        final Map<String, String> r52 = this.$ext;     // Catch: Throwable -> L121
        r30 = "[imageUpload] reuse ready artifact, identifier=";
        final Ref.ObjectRef<String> r53 = this.$localTextMessageId;     // Catch: Throwable -> L121
        final Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r54 = this.$originalLogic;     // Catch: Throwable -> L119
        m0 r410 = r112;
        final Ref.ObjectRef r118 = r17;
        Function1 r119 = new t(r47, r118, r48, r49, r113, r114, r115, r116, r117, r50, r51, r52, r53, r54);     // Catch: Throwable -> L119
        Function1 r120 = new u(r49, r113);     // Catch: Throwable -> L119
        final Ref.ObjectRef r121 = r17;
        Function1 r122 = new v(r47, r121, r49, r113, r117, r50, r116, r114, r51, r115, r52, r53, r54);     // Catch: Throwable -> L119
        if (r48 == false) goto L67;
        r5 = ICreationResourceAccessService.a.c(r47);     // Catch: Throwable -> L119
    L68:
        if (this.$pipelineEnabled == true) goto L135;
        r4 = r4;
        r14 = r120;
        r0 = r122;
        r16 = r410;
        r15 = r119;
        r13 = null;
        goto L84
    L135:
        ICreationResourceAccessService.Companion r55 = ICreationResourceAccessService.a;     // Catch: Throwable -> L81
        String r56 = this.$curUploaderIdentifier;     // Catch: Throwable -> L81
        com.larus.bmhome.resource.access.x r57 = com.larus.uaigc.service.f.a;     // Catch: Throwable -> L81
        ResourceMediaType r58 = ResourceMediaType.IMAGE;     // Catch: Throwable -> L81
        com.larus.bmhome.resource.access.b0 r59 = ICreationResourceAccessService.a.b(r55, r56, r57, r58, 8);     // Catch: Throwable -> L81
        if (r59 != null) goto L80;
        CreationResourceAccessUploader r60 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L81
        String r61 = this.$curUploaderIdentifier;     // Catch: Throwable -> L81
        this.L$0 = r17;     // Catch: Throwable -> L81
        this.L$1 = r410;     // Catch: Throwable -> L81
        this.L$2 = r119;     // Catch: Throwable -> L81
        this.L$3 = r120;     // Catch: Throwable -> L81
        this.L$4 = r122;     // Catch: Throwable -> L81
        this.L$5 = r5;     // Catch: Throwable -> L81
        this.label = 4;     // Catch: Throwable -> L81
        r1 = CreationResourceAccessUploader.d(r61, r57, r58, this);     // Catch: Throwable -> L81
        r4 = r4;
        if (r1 != r4) goto L76;
        return r4;
    L76:
        r12 = r17;
        r6 = r122;
        r9 = r120;
        r11 = r410;
        r10 = r119;
        goto L131
    L80:
        r4 = r4;
        r14 = r120;
        r15 = r119;
        r13 = r59;
        r0 = r122;
        r16 = r410;
    L81:
        th = th;
        r4 = r4;
    L122:
        r38 = r29;
        goto L125
    L67:
        r5 = null;
    L119:
        th = th;
        r38 = r29;
        r4 = r4;
    L121:
        th = th;
        goto L122
    L16:
        r17 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r41);     // Catch: Throwable -> L123
        Object r123 = r41;
    L37:
        n0 r124 = (n0) r123;     // Catch: Throwable -> L123
        ProcessFileResultCode r125 = r124.b;     // Catch: Throwable -> L123
        if (r125 != null) goto L40;
    L42:
        r8 = false;
    L43:
        if (r8 == false) goto L52;
        m0 r62 = r124.a;     // Catch: Throwable -> L123
        if (r62 == null) goto L47;
        String r126 = r62.e;     // Catch: Throwable -> L123
    L48:
        if (r126 == null) goto L51;
        r7 = r126;
    L51:
        r17.element = r7;     // Catch: Throwable -> L123
    L54:
        if (this.$pipelineEnabled == true) goto L56;
        this.$entity.setFileParsedStatus(Boxing.boxInt(FileParseState.SUCCESS.getValue()));     // Catch: Throwable -> L123
    L56:
        MainCoroutineDispatcher r63 = Dispatchers.getMain();     // Catch: Throwable -> L123
        AnonymousClass2 r127 = new AnonymousClass2(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L123
        this.L$0 = r17;     // Catch: Throwable -> L123
        this.L$1 = r62;     // Catch: Throwable -> L123
        this.label = 3;     // Catch: Throwable -> L123
        if (BuildersKt.withContext(r63, r127, this) != r4) goto L59;
        return r4;
    L59:
        r112 = r62;
        goto L60
    L47:
        r126 = null;
    L52:
        r62 = null;
        goto L54
    L40:
        if (r125.isSuccess() != true) goto L42;
    L18:
        ResultKt.throwOnFailure(r41);     // Catch: Throwable -> L123
    L24:
        r17 = new Ref.ObjectRef();     // Catch: Throwable -> L123
        String r128 = l1.d(this.$entity);     // Catch: Throwable -> L123
        if (r128 != null) goto L27;
        r128 = "";
    L27:
        r17.element = r128;     // Catch: Throwable -> L123
        if (this.$pipelineEnabled == true) goto L52;
        Integer r129 = this.$entity.getFileParsedStatus();     // Catch: Throwable -> L123
        int r130 = FileParseState.SUCCESS.getValue();     // Catch: Throwable -> L123
        if (r129 != null) goto L33;
    L34:
        CreationImageUploadPolicy r131 = CreationImageUploadPolicy.a;     // Catch: Throwable -> L123
        Uri r132 = Uri.fromFile(new PolarisFileWrapper((String) r17.element));     // Catch: Throwable -> L123
        this.L$0 = r17;     // Catch: Throwable -> L123
        this.label = 2;     // Catch: Throwable -> L123
        r123 = r131.a(r132, "ai_creation", null, this);     // Catch: Throwable -> L123
        if (r123 != r4) goto L37;
        return r4;
    L33:
        if (r129.intValue() == r130) goto L52;
    L20:
        ResultKt.throwOnFailure(r41);
        MainCoroutineDispatcher r64 = Dispatchers.getMain();     // Catch: Throwable -> L123
        AnonymousClass1 r133 = new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L123
        this.label = 1;     // Catch: Throwable -> L123
        if (BuildersKt.withContext(r64, r133, this) != r4) goto L24;
        return r4;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L123:
        th = th;
        r38 = "NestedFileSendMessageProcessor";
    L117:
        th = th;
        goto L118
    }
}

package com.larus.uaigc.createpage.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.service.IMessageService;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.p0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import ic8.m0;
import ic8.n0;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.l0;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1", f = "ImageEditSendMessageStrategy.kt", i = {0, 1, 1, 1}, l = {218, 363}, m = "invokeSuspend", n = {"preprocessResult", "preprocessResult", "filePath", "curUploadTaskId"}, s = {"L$0", "L$0", "L$1", "L$2"})
final class ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ String $inputPath;
    final /* synthetic */ int $instructionType;
    final /* synthetic */ List<Message> $localMessageList;
    final /* synthetic */ boolean $needPreprocessImage;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ Message $textMsg;
    final /* synthetic */ hy9.f $this_run;
    final /* synthetic */ Function1<hy9.j, Unit> $uploadSuccessCallback;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<mr9.l, Unit> {
        final /* synthetic */ String $curUploadTaskId;
        final /* synthetic */ String $filePath;
        final /* synthetic */ Message $imageMsg;
        final /* synthetic */ int $instructionType;
        final /* synthetic */ boolean $pipelineEnabled;
        final /* synthetic */ Ref.ObjectRef<n0> $preprocessResult;
        final /* synthetic */ Message $textMsg;
        final /* synthetic */ hy9.f $this_run;
        final /* synthetic */ Function1<hy9.j, Unit> $uploadSuccessCallback;
        final /* synthetic */ ImageEditSendMessageStrategy this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(boolean r1, String r2, ImageEditSendMessageStrategy r3, String r4, Message r5, hy9.f r6, Function1<? super hy9.j, Unit> r7, Message r8, int r9, Ref.ObjectRef<n0> r10) {
            this.$pipelineEnabled = r1;
            this.$curUploadTaskId = r2;
            this.this$0 = r3;
            this.$filePath = r4;
            this.$imageMsg = r5;
            this.$this_run = r6;
            this.$uploadSuccessCallback = r7;
            this.$textMsg = r8;
            this.$instructionType = r9;
            this.$preprocessResult = r10;
            super(1, Intrinsics.Kotlin.class, "onUploadSuccess", "invokeSuspend$onUploadSuccess(ZLjava/lang/String;Lcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;Lkotlin/jvm/functions/Function1;Lcom/larus/im/bean/message/Message;ILkotlin/jvm/internal/Ref$ObjectRef;Lcom/larus/platform/model/upload/ResourceUploadResult;)V", 0);
        }

        public final void invoke(mr9.l r13) {
            Intrinsics.checkNotNullParameter(r13, "p0");
            ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadSuccess(this.$pipelineEnabled, this.$curUploadTaskId, this.this$0, this.$filePath, this.$imageMsg, this.$this_run, this.$uploadSuccessCallback, this.$textMsg, this.$instructionType, this.$preprocessResult, r13);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mr9.l) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<mr9.k, Unit> {
        final /* synthetic */ Message $imageMsg;
        final /* synthetic */ boolean $pipelineEnabled;
        final /* synthetic */ ImageEditSendMessageStrategy this$0;

        public AnonymousClass2(boolean r7, ImageEditSendMessageStrategy r8, Message r9) {
            this.$pipelineEnabled = r7;
            this.this$0 = r8;
            this.$imageMsg = r9;
            super(1, Intrinsics.Kotlin.class, "onUploadProgress", "invokeSuspend$onUploadProgress(ZLcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/upload/ResourceUploadProgressResult;)V", 0);
        }

        public final void invoke(mr9.k r4) {
            Intrinsics.checkNotNullParameter(r4, "p0");
            ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadProgress(this.$pipelineEnabled, this.this$0, this.$imageMsg, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mr9.k) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ResourceUploadError, Unit> {
        final /* synthetic */ String $curUploadTaskId;
        final /* synthetic */ String $filePath;
        final /* synthetic */ Message $imageMsg;
        final /* synthetic */ List<Message> $localMessageList;
        final /* synthetic */ boolean $pipelineEnabled;
        final /* synthetic */ Ref.ObjectRef<n0> $preprocessResult;
        final /* synthetic */ hy9.f $this_run;
        final /* synthetic */ ImageEditSendMessageStrategy this$0;

        public AnonymousClass3(boolean r1, String r2, ImageEditSendMessageStrategy r3, Message r4, List<Message> r5, hy9.f r6, Ref.ObjectRef<n0> r7, String r8) {
            this.$pipelineEnabled = r1;
            this.$curUploadTaskId = r2;
            this.this$0 = r3;
            this.$imageMsg = r4;
            this.$localMessageList = r5;
            this.$this_run = r6;
            this.$preprocessResult = r7;
            this.$filePath = r8;
            super(1, Intrinsics.Kotlin.class, "onUploadFailed", "invokeSuspend$onUploadFailed(ZLjava/lang/String;Lcom/larus/uaigc/createpage/utils/ImageEditSendMessageStrategy;Lcom/larus/im/bean/message/Message;Ljava/util/List;Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/lang/String;Lcom/larus/platform/model/upload/ResourceUploadError;)V", 0);
        }

        public final void invoke(ResourceUploadError r11) {
            Intrinsics.checkNotNullParameter(r11, "p0");
            ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1.access$invokeSuspend$onUploadFailed(this.$pipelineEnabled, this.$curUploadTaskId, this.this$0, this.$imageMsg, this.$localMessageList, this.$this_run, this.$preprocessResult, this.$filePath, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ResourceUploadError) r1);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1(hy9.f r1, boolean r2, String r3, boolean r4, ImageEditSendMessageStrategy r5, Message r6, Message r7, Function1<? super hy9.j, Unit> r8, int r9, List<Message> r10, Continuation<? super ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1> r11) {
        this.$this_run = r1;
        this.$pipelineEnabled = r2;
        this.$inputPath = r3;
        this.$needPreprocessImage = r4;
        this.this$0 = r5;
        this.$imageMsg = r6;
        this.$textMsg = r7;
        this.$uploadSuccessCallback = r8;
        this.$instructionType = r9;
        this.$localMessageList = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1(this.$this_run, this.$pipelineEnabled, this.$inputPath, this.$needPreprocessImage, this.this$0, this.$imageMsg, this.$textMsg, this.$uploadSuccessCallback, this.$instructionType, this.$localMessageList, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r57) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        String r1 = (String) this.L$2;
        String r2 = (String) this.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r57);
        Ref.ObjectRef r10 = r3;
        String r4 = r2;
        Object r5 = r57;
    L106:
        if (((Boolean) r5).booleanValue() == true) goto L108;
        String r29 = r1;
        String r6 = r4;
        Ref.ObjectRef r7 = r10;
    L112:
        if (this.$pipelineEnabled == false) goto L118;
        this.this$0.getClass();
        if (ImageEditSendMessageStrategy.i(r6) == false) goto L116;
        com.larus.bmhome.resource.access.j0 r28 = new com.larus.bmhome.resource.access.j0.a(r6);
    L117:
        int r8 = p0.x;
        String r11 = r29;
        p0 r12 = p0.a.b(r28, r29, null, null, true, new CountDownLatch(1), StringsKt.substringAfterLast$default(r6, '.', null, 2, null), "ai_beautify", "send_after_add_msg", new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$1(this.$pipelineEnabled, this.this$0, this.$imageMsg), new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$2(this.$pipelineEnabled, r11, this.this$0, r6, this.$imageMsg, this.$this_run, this.$uploadSuccessCallback, this.$textMsg, this.$instructionType, r7), new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$3(this.$pipelineEnabled, r11, this.this$0, this.$imageMsg, this.$localMessageList, this.$this_run, r7, r6), Boxing.boxBoolean(this.$needPreprocessImage), null, null, null, null, com.larus.uaigc.service.g.a, false, null, 1818648);
    L123:
        com.larus.bmhome.resource.access.b0 r13 = ICreationResourceAccessService.a.b(r12);
        if (this.$pipelineEnabled == false) goto L161;
        this.this$0.k(r13, this.$imageMsg);
    L161:
        return Unit.INSTANCE;
    L116:
        r28 = new com.larus.bmhome.resource.access.j0.b(r6, null, null, null, 30);
        goto L117
    L118:
        int r14 = p0.x;
        n0 r15 = (n0) r7.element;
        if (r15 == null) goto L121;
        m0 r16 = r15.a;
    L122:
        String r17 = r29;
        String r18 = r6;
        String r19 = r29;
        m0 r110 = r16;
        r12 = p0.a.c(r18, r19, r110, null, true, new CountDownLatch(1), StringsKt.substringAfterLast$default(r6, '.', null, 2, null), "ai_beautify", "send_after_add_msg", new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$4(this.$pipelineEnabled, this.this$0, this.$imageMsg), new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$5(this.$pipelineEnabled, r17, this.this$0, r6, this.$imageMsg, this.$this_run, this.$uploadSuccessCallback, this.$textMsg, this.$instructionType, r7), new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$submitRequest$6(this.$pipelineEnabled, r17, this.this$0, this.$imageMsg, this.$localMessageList, this.$this_run, r7, r6), Boxing.boxBoolean(false), com.larus.uaigc.service.g.a, null, 1802280);
        goto L123
    L121:
        r16 = null;
        goto L122
    L108:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef r20 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r21 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r57);
        Ref.ObjectRef r22 = r21;
        Object r23 = r57;
    L22:
        r20.element = r23;
        n0 r24 = (n0) r22.element;
        if (r24 == null) goto L29;
        ProcessFileResultCode r25 = r24.b;
        if (r25 == null) goto L29;
        if (r25.isSuccess() != true) goto L29;
        boolean r26 = true;
    L30:
        if (r26 == false) goto L58;
        IBachDetectCenterAbility.Companion r27 = IBachDetectCenterAbility.a;
        if (r27.b() == false) goto L51;
        String r30 = this.$inputPath;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L49
        n0 r32 = (n0) r22.element;     // Catch: Throwable -> L49
        if (r32 == null) goto L46;
        m0 r33 = r32.a;     // Catch: Throwable -> L49
        if (r33 == null) goto L46;
        String r34 = r33.e;     // Catch: Throwable -> L49
        if (r34 == null) goto L46;
        PolarisFileWrapper r35 = new PolarisFileWrapper(r34);     // Catch: Throwable -> L49
        PolarisFileWrapper r36 = new PolarisFileWrapper(r30);     // Catch: Throwable -> L49
        if (r35.exists() == true) goto L43;
    L45:
        Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L49
    L47:
        Result.constructor-impl(r37);     // Catch: Throwable -> L49
        goto L51
    L43:
        if (r36.exists() == false) goto L45;
        Uri r38 = Uri.fromFile(r35);     // Catch: Throwable -> L49
        Uri r39 = Uri.fromFile(r36);     // Catch: Throwable -> L49
        Intrinsics.checkNotNull(r39);     // Catch: Throwable -> L49
        Intrinsics.checkNotNull(r38);     // Catch: Throwable -> L49
        r27.e(r39, r38, true);     // Catch: Throwable -> L49
    L46:
        r37 = null;
    L49:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        n0 r41 = (n0) r22.element;
        if (r41 == null) goto L56;
        m0 r42 = r41.a;
        if (r42 == null) goto L56;
        r6 = r42.e;
    L57:
        if (r6 == null) goto L58;
    L59:
        r7 = r22;
    L63:
        if (o0.d(r6) == false) goto L126;
        AttachmentInfo r43 = this.$this_run.m;
        if (r43 == null) goto L82;
        String r44 = r43.getFileIdentifier();
        if (r44 == null) goto L82;
        if (this.$pipelineEnabled == true) goto L71;
    L76:
        boolean r45 = false;
    L77:
        if (r45 == true) goto L80;
        r44 = null;
    L80:
        if (r44 == null) goto L82;
    L83:
        String r46 = r44;
        l0.d(r46);
        if (this.$pipelineEnabled == false) goto L99;
        AttachmentInfo r47 = this.$this_run.m;
        if (r47 == null) goto L95;
        String r48 = r47.getFileIdentifier();
        if (r48 == null) goto L95;
        if (r48.length() <= 0) goto L92;
        boolean r49 = true;
    L93:
        if (r49 == false) goto L95;
    L97:
        if (Intrinsics.areEqual(r48, r46) == false) goto L99;
        boolean r50 = true;
    L100:
        if (r50 == false) goto L110;
        ImageEditSendMessageStrategy r51 = this.this$0;
        Message r52 = this.$imageMsg;
        AnonymousClass1 r53 = new AnonymousClass1(this.$pipelineEnabled, r46, this.this$0, r6, this.$imageMsg, this.$this_run, this.$uploadSuccessCallback, this.$textMsg, this.$instructionType, r7);
        AnonymousClass2 r54 = new AnonymousClass2(this.$pipelineEnabled, this.this$0, this.$imageMsg);
        AnonymousClass3 r111 = new AnonymousClass3(this.$pipelineEnabled, r46, this.this$0, this.$imageMsg, this.$localMessageList, this.$this_run, r7, r6);
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r46;
        this.label = 2;
        r10 = r7;
        r5 = ImageEditSendMessageStrategy.c(r51, r46, r52, r53, r54, r111, this);
        if (r5 != r9) goto L104;
        return r9;
    L104:
        r4 = r6;
        r1 = r46;
        goto L106
    L110:
        r29 = r46;
        goto L112
    L92:
        r49 = false;
    L95:
        r48 = null;
    L99:
        r50 = false;
        goto L100
    L71:
        if (r44.length() <= 0) goto L73;
        boolean r55 = true;
    L74:
        if (r55 == false) goto L76;
        r45 = true;
        goto L77
    L73:
        r55 = false;
    L82:
        r44 = UUID.randomUUID().toString();
        goto L83
    L126:
        Ref.ObjectRef r112 = r7;
        IMessageService.a.a(com.larus.im.d.e(), this.$this_run.c, CollectionsKt.listOf(new Message[]{this.$imageMsg, this.$textMsg}), false, false, false, null, 48);
        FLogger r56 = FLogger.a;
        r56.e("ImageEditSendMessageStrategy", "preprocess albumImg failed");
        n0 r58 = (n0) r112.element;
        if (r58 == null) goto L129;
        ProcessFileResultCode r59 = r58.b;
    L130:
        if (r59 != null) goto L132;
        int r60 = -1;
    L134:
        if (r60 == 1) goto L138;
        if (r60 == 2) goto L137;
        t19.s r61 = t19.s.a;
        Context r62 = this.$this_run.a.getContext();
        r61.getClass();
        t19.s.s(r62, 2131908214);
    L139:
        r56.e("ImageEditSendMessageStrategy", "sendAiBeautifyMakeSameMessage, unsupported_format");
        com.larus.platform.service.g r63 = com.larus.platform.service.g.a;
        StringBuilder r64 = new StringBuilder("sendAiBeautifyMakeSameMessage, resultCode: ");
        n0 r65 = (n0) r112.element;
        if (r65 == null) goto L142;
        ProcessFileResultCode r66 = r65.b;
    L143:
        r64.append(r66);
        r64.append(", inputFilePath: ");
        r64.append(this.$this_run.b);
        r63.ensureNotReachHere(new Throwable(r64.toString()));
        ny9.u r67 = this.$this_run.f;
        if (r67 == null) goto L146;
        String r113 = r67.getClickFrom();
    L147:
        ny9.u r68 = this.$this_run.f;
        if (r68 == null) goto L150;
        String r210 = r68.m();
    L151:
        ny9.u r69 = this.$this_run.f;
        if (r69 == null) goto L154;
        String r211 = r69.i();
    L155:
        ny9.u r70 = this.$this_run.f;
        if (r70 == null) goto L158;
        String r212 = r70.getEnterMethod();
    L159:
        String r71 = this.$this_run.h;
        IAIChatControlTraceService.Companion r72 = IAIChatControlTraceService.a;
        y3.a(r71, "chat", null, "upload", "pic", null, "0", null, null, r113, null, r210, r211, null, null, r212, null, r72.h(r72.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        goto L161
    L158:
        r212 = null;
        goto L159
    L154:
        r211 = null;
        goto L155
    L150:
        r210 = null;
        goto L151
    L146:
        r113 = null;
        goto L147
    L142:
        r66 = null;
        goto L143
    L137:
        r56.e("ImageEditSendMessageStrategy", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r73 = t19.s.a;
        Context r74 = this.$this_run.a.getContext();
        r73.getClass();
        t19.s.s(r74, 2131906526);
        goto L139
    L138:
        r56.e("ImageEditSendMessageStrategy", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r75 = t19.s.a;
        Context r76 = this.$this_run.a.getContext();
        r75.getClass();
        t19.s.s(r76, 2131906513);
        goto L139
    L132:
        r60 = a.a[r59.ordinal()];
        goto L134
    L129:
        r59 = null;
    L56:
        r6 = null;
    L58:
        r6 = "";
    L29:
        r26 = false;
        goto L30
    L10:
        ResultKt.throwOnFailure(r57);
        u7 r77 = this.$this_run.i;
        if (r77 == null) goto L13;
        r77.O5(true);
    L13:
        r20 = new Ref.ObjectRef();
        if (this.$pipelineEnabled == false) goto L17;
        String r78 = this.$inputPath;
    L61:
        r7 = r20;
        r6 = r78;
        goto L63
    L17:
        if (this.$needPreprocessImage == false) goto L60;
        CreationImageUploadPolicy r79 = CreationImageUploadPolicy.a;
        Uri r80 = Uri.fromFile(new PolarisFileWrapper(this.$inputPath));
        this.L$0 = r20;
        this.L$1 = r20;
        this.label = 1;
        r23 = r79.a(r80, "ai_beautify", null, this);
        if (r23 != r9) goto L21;
        return r9;
    L21:
        r22 = r20;
        goto L22
    L60:
        r78 = this.$inputPath;
        goto L61
    }

    public static final Long a(Ref.ObjectRef<n0> r1, String r2, String r3) {
        n0 r4 = (n0) r1.element;
        if (r4 == null) goto L7;
        m0 r5 = r4.a;
        if (r5 == null) goto L7;
        return Long.valueOf(r5.c);
    L7:
        com.larus.bmhome.resource.access.f0 r6 = ICreationResourceAccessService.a.c(r2);
        if (r6 == null) goto L14;
        Map r7 = r6.f;
        if (r7 == null) goto L14;
        String r8 = (String) r7.get("preprocess_file_size");
        if (r8 == null) goto L14;
        Long r9 = StringsKt.toLongOrNull(r8);
    L15:
        if (r9 != null) goto L25;
        File r10 = new PolarisFileWrapper(r3);
        if (r10.exists() == true) goto L20;
        r10 = null;
    L20:
        if (r10 == null) goto L23;
        return Long.valueOf(r10.length());
    L23:
        return null;
    L25:
        return r9;
    L14:
        r9 = null;
        goto L15
    }

    public static final String c(Ref.ObjectRef<n0> r1, String r2, String r3) {
        n0 r4 = (n0) r1.element;
        if (r4 == null) goto L8;
        m0 r5 = r4.a;
        if (r5 == null) goto L8;
        String r6 = r5.d;
        if (r6 == null) goto L8;
        return r6;
    L8:
        com.larus.bmhome.resource.access.f0 r7 = ICreationResourceAccessService.a.c(r2);
        if (r7 == null) goto L17;
        Map r8 = r7.f;
        if (r8 == null) goto L17;
        String r9 = (String) r8.get("preprocess_file_type");
        if (r9 == null) goto L17;
        if ((!StringsKt.isBlank(r9)) == false) goto L17;
    L18:
        if (r9 != null) goto L25;
        String r10 = StringsKt.substringAfterLast(r3, '.', "");
        if ((!StringsKt.isBlank(r10)) == false) goto L23;
        return r10;
    L23:
        return null;
    L25:
        return r9;
    L17:
        r9 = null;
        goto L18
    }

    public static final void access$invokeSuspend$onUploadProgress(boolean r2, ImageEditSendMessageStrategy r3, Message r4, mr9.k r5) {
        if (r2 == false) goto L4;
        int r0 = com.larus.uaigc.createpage.utils.a.a;
        int r6 = com.larus.uaigc.createpage.utils.a.b(r5.a);
    L9:
        r3.l(r4, r6, r2);
        return;
    L4:
        Long r7 = r5.a;
        if (r7 == null) goto L7;
        long r1 = r7.longValue();
    L8:
        r6 = Math.max(5, (int) r1);
        goto L9
    L7:
        r1 = 5;
        goto L8
    }

    public static final void access$invokeSuspend$onUploadFailed(boolean r49, String r50, ImageEditSendMessageStrategy r51, Message r52, List r53, hy9.f r54, Ref.ObjectRef r55, String r56, ResourceUploadError r57) {
        if (r49 == false) goto L5;
        CreationResourceAccessUploader r5 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r50);
    L5:
        ImageEditSendMessageStrategy.a(r51, r52, r49);
        ImageEditSendMessageStrategy.b(r51, r57, r53);
        l0.a("creation_page_album_image_to_message", r50, false, mr9.i.a(r57.getCode()), a(r55, r50, r56), c(r55, r50, r56));
        ny9.u r0 = r54.f;
        String r1 = null;
        if (r0 == null) goto L8;
        String r11 = r0.getClickFrom();
    L9:
        ny9.u r2 = r54.f;
        if (r2 == null) goto L12;
        String r13 = r2.m();
    L13:
        ny9.u r3 = r54.f;
        if (r3 == null) goto L16;
        String r14 = r3.i();
    L17:
        ny9.u r4 = r54.f;
        if (r4 == null) goto L20;
        r1 = r4.getEnterMethod();
    L20:
        String r6 = r54.h;
        IAIChatControlTraceService.Companion r7 = IAIChatControlTraceService.a;
        y3.a(r6, "chat", null, "upload", "pic", null, "0", null, null, r11, null, r13, r14, null, null, r1, null, r7.h(r7.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L16:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r11 = null;
        goto L9
    }

    public static final void access$invokeSuspend$onUploadSuccess(boolean r62, String r63, ImageEditSendMessageStrategy r64, String r65, Message r66, hy9.f r67, Function1 r68, Message r69, int r70, Ref.ObjectRef r71, mr9.l r72) {
        if (r62 == false) goto L5;
        CreationResourceAccessUploader r2 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r63);
    L5:
        String r14 = null;
        if (r62 == false) goto L20;
        r64.getClass();
        com.larus.bmhome.resource.access.f0 r3 = ICreationResourceAccessService.a.c(r63);
        if (r3 == null) goto L10;
        com.larus.bmhome.resource.access.j0 r4 = r3.b;
    L12:
        if ((r4 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L14;
        com.larus.bmhome.resource.access.j0.b r5 = (com.larus.bmhome.resource.access.j0.b) r4;
    L15:
        if (r5 == null) goto L18;
        String r6 = r5.b;
        if (r6 == null) goto L18;
    L19:
        String r7 = r6;
    L21:
        if (r62 == false) goto L23;
        ImageEditSendMessageStrategy.f(r64, r66, r7);
    L23:
        ImageEditSendMessageStrategy.a(r64, r66, r62);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1$onUploadSuccess$1(r68, r72, r7, r66, r69, r64, r70, null), 2, null);
        l0.b("creation_page_album_image_to_message", r63, true, null, a(r71, r63, r65), c(r71, r63, r65), 8);
        String r0 = r72.a;
        if (r0 != null) goto L26;
        r0 = "";
    L26:
        ny9.u r1 = r67.f;
        if (r1 == null) goto L29;
        String r24 = r1.getClickFrom();
    L30:
        ny9.u r8 = r67.f;
        if (r8 == null) goto L33;
        String r26 = r8.m();
    L34:
        ny9.u r9 = r67.f;
        if (r9 == null) goto L37;
        String r27 = r9.i();
    L38:
        ny9.u r10 = r67.f;
        if (r10 == null) goto L41;
        String r30 = r10.getEnterMethod();
    L42:
        String r15 = r67.h;
        if (StringsKt.isBlank(r0) == false) goto L45;
        String r11 = "0";
    L46:
        String r21 = r11;
        if (StringsKt.isBlank(r0) == false) goto L49;
        r14 = "upload";
    L49:
        IAIChatControlTraceService.Companion r12 = IAIChatControlTraceService.a;
        y3.a(r15, "chat", null, r14, "pic", null, r21, null, null, r24, null, r26, r27, null, null, r30, null, r12.h(r12.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682076, 65535);
        return;
    L45:
        r11 = "1";
        goto L46
    L41:
        r30 = null;
        goto L42
    L37:
        r27 = null;
        goto L38
    L33:
        r26 = null;
        goto L34
    L29:
        r24 = null;
    L18:
        r6 = ImageEditSendMessageStrategy.j(r65);
        goto L19
    L14:
        r5 = null;
        goto L15
    L10:
        r4 = null;
        goto L12
    L20:
        r7 = r65;
        goto L21
    }
}

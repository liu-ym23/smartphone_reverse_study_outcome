package com.larus.uaigc.createpage.utils;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.uaigc.service.p0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import tx9.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadVideo$1", f = "NestedFileSendMessageProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {969, 987}, m = "invokeSuspend", n = {"resourceKey", "finishOnce", "localResPath", "video", "videoCover", "processCallback", "successCallback", "failedCallback", "existingArtifact", "resourceKey", "finishOnce", "successCallback", "failedCallback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3"})
final class UgcUploadingSendMessageProcessor$uploadVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$uploadVideo$1(UplinkFileEntity r1, String r2, AtomicInteger r3, UgcUploadingSendMessageProcessor r4, y8 r5, AtomicBoolean r6, ICoreInputAbility.OnSendParams r7, Map<String, String> r8, String r9, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r10, Continuation<? super UgcUploadingSendMessageProcessor$uploadVideo$1> r11) {
        this.$entity = r1;
        this.$localNestedFileMessageId = r2;
        this.$handlingFileCount = r3;
        this.this$0 = r4;
        this.$dependency = r5;
        this.$messageSent = r6;
        this.$params = r7;
        this.$ext = r8;
        this.$localTextMessageId = r9;
        this.$originalLogic = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new UgcUploadingSendMessageProcessor$uploadVideo$1(this.$entity, this.$localNestedFileMessageId, this.$handlingFileCount, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localTextMessageId, this.$originalLogic, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r49) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        Function2 r0 = (Function2) this.L$3;
        final Function2 r2 = (Function2) this.L$2;
        AtomicBoolean r3 = (AtomicBoolean) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r49);     // Catch: Throwable -> L9
        UgcUploadingSendMessageProcessor$uploadVideo$1 r8 = this;
        final String r6 = "NestedFileSendMessageProcessor";
        final Function2 r7 = r0;
        Object r5 = r49;
    L143:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r5, new f0(r2), new g0(r7));     // Catch: Throwable -> L88
    L125:
        return Unit.INSTANCE;
    L88:
        th = th;
    L122:
        AtomicBoolean r9 = r3;
        String r11 = r4;
    L123:
        CreationResourceAccessUploader r12 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r11);
        FLogger.a.e(r6, "[uploadVideo] process failed before callback, resourceKey: " + r11, th);
        r8.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        final String r13 = r8.$localNestedFileMessageId;
        final UplinkFileEntity r14 = r8.$entity;
        t0.e(new j0(r13, r14));
        a(r9, r11, r8.$handlingFileCount, r8.this$0, r8.$dependency, r8.$messageSent, r8.$params, r8.$ext, r8.$localNestedFileMessageId, r8.$localTextMessageId, r8.$originalLogic, "uploadVideo exception");
    L9:
        th = th;
        r9 = r3;
        r11 = r4;
        r8 = this;
        r6 = "NestedFileSendMessageProcessor";
        goto L123
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        com.larus.bmhome.resource.access.f0 r15 = (com.larus.bmhome.resource.access.f0) this.L$8;
        Function2 r16 = (Function2) this.L$7;
        Function2 r17 = (Function2) this.L$6;
        Function1 r18 = (Function1) this.L$5;
        Image r19 = (Image) this.L$4;
        VideoExtension r20 = (VideoExtension) this.L$3;
        r6 = (String) this.L$2;
        final AtomicBoolean r110 = (AtomicBoolean) this.L$1;
        String r111 = (String) this.L$0;
        ResultKt.throwOnFailure(r49);     // Catch: Throwable -> L16
        String r37 = "[uploadVideo] observe existing taskId=";
        String r39 = "[uploadVideo] reuse ready artifact, identifier=";
        String r38 = "NestedFileSendMessageProcessor";
        Function2 r21 = r17;
        r8 = this;
        Object r22 = r10;
        r7 = r16;
        Object r23 = r49;
    L64:
        final Function1 r112 = r18;
        String r113 = r6;
        com.larus.bmhome.resource.access.b0 r24 = (com.larus.bmhome.resource.access.b0) r23;     // Catch: Throwable -> L65
        r2 = r21;
    L69:
        if (r15 == null) goto L73;
        mr9.l r25 = com.larus.bmhome.resource.access.s.c(r15);     // Catch: Throwable -> L65
    L136:
        if (r25 != null) goto L139;
        r6 = r38;
        if (r24 == null) goto L90;
        CreationResourceAccessUploader r26 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L112
        CreationResourceAccessUploader.h(r111);     // Catch: Throwable -> L112
        FLogger.a.i(r6, r37 + r24.getTaskId() + ", identifier=" + r111);     // Catch: Throwable -> L112
        Function1 r27 = new e0(r112);     // Catch: Throwable -> L112
        r8.L$0 = r111;     // Catch: Throwable -> L112
        r8.L$1 = r110;     // Catch: Throwable -> L112
        r8.L$2 = r2;     // Catch: Throwable -> L112
        r8.L$3 = r7;     // Catch: Throwable -> L112
        r8.L$4 = null;     // Catch: Throwable -> L112
        r8.L$5 = null;     // Catch: Throwable -> L112
        r8.L$6 = null;     // Catch: Throwable -> L112
        r8.L$7 = null;     // Catch: Throwable -> L112
        r8.L$8 = null;     // Catch: Throwable -> L112
        r8.label = 2;     // Catch: Throwable -> L112
        r5 = ICreationResourceAccessServiceKt.b(r24, r27, r8, 1);     // Catch: Throwable -> L112
        if (r5 != r22) goto L85;
        return r22;
    L85:
        r4 = r111;
        r3 = r110;
        goto L143
    L90:
        int r28 = p0.x;     // Catch: Throwable -> L112
        String r29 = StringsKt.substringAfterLast$default(r113, '.', null, 2, null);     // Catch: Throwable -> L112
        CountDownLatch r30 = new CountDownLatch(1);     // Catch: Throwable -> L112
        com.larus.bmhome.resource.access.d0 r31 = com.larus.uaigc.service.g.b;     // Catch: Throwable -> L112
        ResourceCenter.a.getClass();     // Catch: Throwable -> L112
        boolean r32 = ResourceCenter.d(r111);     // Catch: Throwable -> L112
        int r114 = UplinkEntityType.EntityTypeFile.getValue();     // Catch: Throwable -> L112
        Integer r210 = Boxing.boxInt(FileType.FileTypeVideo.getValue());     // Catch: Throwable -> L112
        VideoExtension r115 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: Throwable -> L112
        r115.setPath(r113);     // Catch: Throwable -> L112
        r115.setCover(r19);     // Catch: Throwable -> L112
        if (r20 == null) goto L94;
        Integer r33 = r20.getWidth();     // Catch: Throwable -> L112
        if (r33 == null) goto L94;
    L95:
        r115.setWidth(r33);     // Catch: Throwable -> L112
        if (r20 == null) goto L101;
        Integer r34 = r20.getHeight();     // Catch: Throwable -> L112
        if (r34 == null) goto L101;
        Integer r35 = r34;
    L102:
        r115.setHeight(r35);     // Catch: Throwable -> L112
        r115.setSource("upload");     // Catch: Throwable -> L112
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L112
        UplinkFileEntity r40 = new UplinkFileEntity(Boxing.boxInt(r114), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r210, null, null, r115, null, null, null, 951, null), null, 2, null), r111, null, null, null, null, null, null, false, null, null, null, null, 15352, null);     // Catch: Throwable -> L110
        if (r32 == false) goto L107;
        boolean r41 = true;
    L108:
        ICreationResourceAccessService.a.b(p0.a.d(r113, r111, "creation_video", new mr9.h(r41, null, r40, 26), true, r30, r29, "video", r112, new h0(r2), new i0(r7), Boxing.boxBoolean(true), null, r31, null, 213248));     // Catch: Throwable -> L110
        goto L125
    L107:
        r41 = false;
    L110:
        th = th;
    L114:
        r4 = r111;
        r3 = r110;
    L101:
        r35 = Boxing.boxInt(0);     // Catch: Throwable -> L112
    L94:
        r33 = Boxing.boxInt(0);     // Catch: Throwable -> L112
        goto L95
    L139:
        FLogger.a.i(r38, r39 + r111);     // Catch: Throwable -> L112
        r2.invoke(r25, Boxing.boxBoolean(true));     // Catch: Throwable -> L112
    L78:
        th = th;
    L79:
        r6 = r38;
    L121:
        r4 = r111;
        r3 = r110;
    L112:
        th = th;
    L65:
        th = th;
    L72:
        r9 = r110;
        r11 = r111;
        r6 = r38;
        goto L123
    L73:
        r25 = null;
    L16:
        th = th;
        r8 = this;
        r11 = r111;
        r6 = "NestedFileSendMessageProcessor";
        r9 = r110;
        goto L123
    L18:
        ResultKt.throwOnFailure(r49);
        String r42 = this.$entity.getFileIdentifier();
        if (r42 != null) goto L21;
        r111 = "";
    L22:
        r110 = new AtomicBoolean(false);
        UplinkEntityContent r43 = this.$entity.getUplinkEntityContent();     // Catch: Throwable -> L119
        if (r43 == null) goto L28;
        UplinkFileInfo r44 = r43.getUplinkFileInfo();     // Catch: Throwable -> L119
        if (r44 == null) goto L28;
        String r45 = r44.getLocalResPath();     // Catch: Throwable -> L119
    L29:
        if (r45 != null) goto L31;
        String r46 = "";
    L32:
        UplinkEntityContent r47 = this.$entity.getUplinkEntityContent();     // Catch: Throwable -> L119
        if (r47 == null) goto L37;
        UplinkFileInfo r48 = r47.getUplinkFileInfo();     // Catch: Throwable -> L119
        if (r48 == null) goto L37;
        VideoExtension r50 = r48.getVideo();     // Catch: Throwable -> L119
    L38:
        if (r50 == null) goto L40;
        Image r51 = r50.getCover();     // Catch: Throwable -> L119
    L41:
        FLogger.a.i("NestedFileSendMessageProcessor", "[uploadVideo] resourceKey = " + r111 + ", localResPath = " + r46 + ", video = " + r50);     // Catch: Throwable -> L119
        final PolarisFileWrapper r52 = new PolarisFileWrapper(r46);     // Catch: Throwable -> L119
        com.larus.bmhome.upload.h r53 = com.larus.bmhome.upload.h.a;     // Catch: Throwable -> L119
        com.larus.bmhome.upload.h.a(r111, new mr9.e(r52.getName(), r111, null, null, Boxing.boxLong(r52.length()), null, null, null, null, null, null, null, 16364), "uploadVideo");     // Catch: Throwable -> L119
        l0.d(r111);     // Catch: Throwable -> L119
        ResourceCenter r54 = ResourceCenter.a;     // Catch: Throwable -> L119
        FlowResourceScene r55 = FlowResourceScene.CreationUserVideoV2;     // Catch: Throwable -> L119
        r54.getClass();     // Catch: Throwable -> L119
        ResourceCenter.k(r111, r55);     // Catch: Throwable -> L119
        com.larus.uaigc.helper.f.a.getClass();     // Catch: Throwable -> L119
        boolean r56 = com.larus.uaigc.helper.f.a();     // Catch: Throwable -> L119
        if (r56 == false) goto L45;
        ICreationResourceAccessService.Companion r57 = ICreationResourceAccessService.a;     // Catch: Throwable -> L119
        com.larus.bmhome.resource.access.x r116 = com.larus.uaigc.service.f.c;     // Catch: Throwable -> L119
        ResourceMediaType r117 = ResourceMediaType.VIDEO;     // Catch: Throwable -> L119
        Set<String> r118 = UgcUploadingSendMessageProcessor.a;     // Catch: Throwable -> L119
        com.larus.bmhome.resource.access.z r58 = r57.d(r111, r116, r117, "creation_video");     // Catch: Throwable -> L119
    L46:
        final long r310 = System.currentTimeMillis();     // Catch: Throwable -> L119
        final UplinkFileEntity r119 = this.$entity;     // Catch: Throwable -> L119
        final String r120 = this.$localNestedFileMessageId;     // Catch: Throwable -> L119
        r37 = "[uploadVideo] observe existing taskId=";
        Function1 r59 = new z(r119, r120);     // Catch: Throwable -> L119
        r38 = "NestedFileSendMessageProcessor";
        final AtomicInteger r121 = this.$handlingFileCount;     // Catch: Throwable -> L117
        r39 = "[uploadVideo] reuse ready artifact, identifier=";
        final UgcUploadingSendMessageProcessor r60 = this.this$0;     // Catch: Throwable -> L117
        final y8 r122 = this.$dependency;     // Catch: Throwable -> L117
        final AtomicBoolean r61 = this.$messageSent;     // Catch: Throwable -> L117
        Image r410 = r51;
        final ICoreInputAbility.OnSendParams r62 = this.$params;     // Catch: Throwable -> L117
        VideoExtension r411 = r50;
        final Map<String, String> r63 = this.$ext;     // Catch: Throwable -> L117
        String r412 = r46;
        r6 = this.$localTextMessageId;     // Catch: Throwable -> L117
        final Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r64 = this.$originalLogic;     // Catch: Throwable -> L117
        final String r123 = r111;
        final com.larus.bmhome.resource.access.z r211 = r58;
        Function2 r65 = new c0(r123, r119, r52, r120, r211, r310, r110, r121, r60, r122, r61, r62, r63, r6, r64);     // Catch: Throwable -> L115
        final String r124 = r111;
        final com.larus.bmhome.resource.access.z r212 = r58;
        r7 = new d0(r124, r119, r52, r120, r212, r310, r110, r121, r60, r122, r61, r62, r63, r6, r64);     // Catch: Throwable -> L115
        if (r56 == true) goto L145;
        r15 = null;
    L55:
        if (r56 == false) goto L68;
        ICreationResourceAccessService.Companion r66 = ICreationResourceAccessService.a;     // Catch: Throwable -> L52
        com.larus.bmhome.resource.access.x r67 = com.larus.uaigc.service.f.c;     // Catch: Throwable -> L52
        ResourceMediaType r68 = ResourceMediaType.VIDEO;     // Catch: Throwable -> L52
        Set<String> r69 = UgcUploadingSendMessageProcessor.a;     // Catch: Throwable -> L52
        com.larus.bmhome.resource.access.b0 r70 = r66.e(r111, r67, r68, "creation_video");     // Catch: Throwable -> L52
        if (r70 != null) goto L67;
        CreationResourceAccessUploader r71 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L52
        r8 = this;
        r21 = r65;
        r8.L$0 = r111;     // Catch: Throwable -> L65
        r8.L$1 = r110;     // Catch: Throwable -> L65
        r8.L$2 = r412;     // Catch: Throwable -> L65
        r8.L$3 = r411;     // Catch: Throwable -> L65
        r8.L$4 = r410;     // Catch: Throwable -> L65
        r8.L$5 = r59;     // Catch: Throwable -> L65
        r8.L$6 = r21;     // Catch: Throwable -> L65
        r8.L$7 = r7;     // Catch: Throwable -> L65
        r8.L$8 = r15;     // Catch: Throwable -> L65
        r8.label = 1;     // Catch: Throwable -> L65
        r23 = r71.c(r111, r67, r68, "creation_video", this);     // Catch: Throwable -> L65
        r22 = r10;
        if (r23 != r22) goto L63;
        return r22;
    L63:
        r20 = r411;
        r19 = r410;
        r18 = r59;
        r6 = r412;
    L52:
        th = th;
        r8 = this;
        goto L72
    L67:
        r8 = this;
        r112 = r59;
        r22 = r10;
        r113 = r412;
        r24 = r70;
        r2 = r65;
        r20 = r411;
        r19 = r410;
        goto L69
    L68:
        r8 = this;
        r112 = r59;
        r22 = r10;
        r113 = r412;
        r2 = r65;
        r20 = r411;
        r19 = r410;
        r24 = null;
        goto L69
    L145:
        r15 = ICreationResourceAccessService.a.c(r111);     // Catch: Throwable -> L52
    L115:
        th = th;
        r8 = this;
    L117:
        th = th;
        r8 = this;
        goto L79
    L45:
        r58 = null;
        goto L46
    L40:
        r51 = null;
    L37:
        r50 = null;
        goto L38
    L31:
        r46 = r45;
    L28:
        r45 = null;
    L119:
        th = th;
        r8 = this;
        r6 = "NestedFileSendMessageProcessor";
        goto L121
    L21:
        r111 = r42;
        goto L22
    }

    public static final void c(String r9, com.larus.bmhome.resource.access.z r10, long r11, String r13, String r14, boolean r15) {
        CreationResourceAccessUploader r0 = CreationResourceAccessUploader.a;
        ResourceMediaType r2 = ResourceMediaType.VIDEO;
        long r4 = System.currentTimeMillis() - r11;
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("local_nested_file_message_id", r13);
        if (r10 == null) goto L7;
        com.larus.bmhome.resource.access.a0 r3 = r10.c;
        if (r3 == null) goto L7;
        String r5 = r3.getClass().getSimpleName();
    L8:
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r1[1] = TuplesKt.to("task_state_at_click", r5);
        CreationResourceAccessUploader.k(r9, r10, r2, r14, r4, r15, "ugc_uploading_video", MapsKt.mapOf(r1));
        return;
    L7:
        r5 = null;
        goto L8
    }

    public static final void a(AtomicBoolean r13, String r14, AtomicInteger r15, UgcUploadingSendMessageProcessor r16, y8 r17, AtomicBoolean r18, ICoreInputAbility.OnSendParams r19, Map<String, String> r20, String r21, String r22, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r23, String r24) {
        if (r13.compareAndSet(false, true) == true) goto L6;
        FLogger.a.i("NestedFileSendMessageProcessor", "[" + r24 + "] skip duplicate finish, resourceKey: " + r14);
        return;
    L6:
        UgcUploadingSendMessageProcessor.a.remove(r14);
        int r2 = r15.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[" + r24 + "] handlingFileCount decremented, remaining: " + r2 + ", resourceKey: " + r14);
        AlbumHelperKt.g(GlobalScope.INSTANCE, null, new UgcUploadingSendMessageProcessor$uploadVideo$1$finishVideoProcessing$1(r16, r17, r15, r18, r19, r20, r21, r22, r23, null), 3);
    }
}

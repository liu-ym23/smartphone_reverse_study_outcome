package com.larus.uaigc.createpage.component.sendmessage;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleVideoUpload$1", f = "CreationMultiAttachmentProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2}, l = {1045, 1062, 1138}, m = "invokeSuspend", n = {"localResPath", "video", "processCallback", "runningCallback", "successCallback", "failedCallback", "existingUploadResult", "pipelineEnabled", "successCallback", "failedCallback", "successCallback", "failedCallback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$0", "L$1"})
final class CreationMultiAttachmentProcessor$handleVideoUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ String $localNestedFileMessageId;
    final /* synthetic */ String $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ String $resourceKey;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    final /* synthetic */ CreationMultiAttachmentProcessor this$0;

    public CreationMultiAttachmentProcessor$handleVideoUpload$1(UplinkFileEntity r1, String r2, CreationMultiAttachmentProcessor r3, String r4, AtomicBoolean r5, AtomicInteger r6, AtomicBoolean r7, CreationSendMessageConfig r8, Map<String, String> r9, String r10, Continuation<? super CreationMultiAttachmentProcessor$handleVideoUpload$1> r11) {
        this.$entity = r1;
        this.$resourceKey = r2;
        this.this$0 = r3;
        this.$localNestedFileMessageId = r4;
        this.$finishOnce = r5;
        this.$handlingFileCount = r6;
        this.$messageSent = r7;
        this.$config = r8;
        this.$ext = r9;
        this.$localTextMessageId = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new CreationMultiAttachmentProcessor$handleVideoUpload$1(this.$entity, this.$resourceKey, this.this$0, this.$localNestedFileMessageId, this.$finishOnce, this.$handlingFileCount, this.$messageSent, this.$config, this.$ext, this.$localTextMessageId, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleVideoUpload$1] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleVideoUpload$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleVideoUpload$1] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final Object invokeSuspend(Object r44) {
        ?? r8 = "[uploadVideo] observe existing taskId=";
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        Function2 r0 = (Function2) this.L$1;
        Function2 r2 = (Function2) this.L$0;
        ResultKt.throwOnFailure(r44);     // Catch: Throwable -> L157
        final Function2 r9 = r2;
        r8 = this;
        String r3 = "identifier";
        String r4 = "CreationMultiAttachmentProcessor";
        final Function2 r7 = r0;
        Object r5 = r44;
    L146:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r5, new j0(r9), new k0(r7));     // Catch: Throwable -> L148
    L161:
        return Unit.INSTANCE;
    L148:
        th = th;
    L159:
        CreationResourceAccessUploader r6 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.g(r8.$resourceKey);
        ConcurrentHashMap<String, r0.a> r11 = r0.a;
        String r12 = r8.$resourceKey;
        Intrinsics.checkNotNullParameter(r12, r3);
        r0.a.remove(r12);
        FLogger.a.e(r4, "[uploadVideo] process failed before callback, resourceKey: " + r8.$resourceKey, th);
        r8.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        final String r13 = r8.$localNestedFileMessageId;
        final UplinkFileEntity r14 = r8.$entity;
        com.larus.utils.t0.e(new l0(r13, r14));
        CreationMultiAttachmentProcessor.d(r8.$finishOnce, r8.$resourceKey, r8.$handlingFileCount, r8.this$0, r8.$messageSent, r8.$config, r8.$ext, r8.$localNestedFileMessageId, r8.$localTextMessageId, "uploadVideo exception");
        goto L161
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Function2 r15 = (Function2) this.L$1;
        final Function2 r16 = (Function2) this.L$0;
        ResultKt.throwOnFailure(r44);     // Catch: Throwable -> L157
        r7 = r15;
        Object r17 = r44;
    L108:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r17, new q0(r16), new b0(r7));     // Catch: Throwable -> L109
        goto L161
    L15:
        boolean r18 = this.Z$0;
        mr9.l r19 = (mr9.l) this.L$6;
        Function2 r20 = (Function2) this.L$5;
        Function2 r21 = (Function2) this.L$4;
        Function1 r22 = (Function1) this.L$3;
        Function1 r23 = (Function1) this.L$2;
        VideoExtension r110 = (VideoExtension) this.L$1;
        String r111 = (String) this.L$0;
        ResultKt.throwOnFailure(r44);     // Catch: Throwable -> L157
        String r35 = "[uploadVideo] observe existing taskId=";
        String r37 = "[uploadVideo] reuse ready artifact, identifier=";
        String r34 = "identifier";
        String r36 = "CreationMultiAttachmentProcessor";
        r9 = r21;
        ?? r24 = this;
        mr9.l r25 = r19;
        r7 = r20;
        Object r38 = r10;
        String r41 = r111;
        boolean r112 = true;
        Object r26 = r44;
    L92:
        com.larus.bmhome.resource.access.b0 r27 = (com.larus.bmhome.resource.access.b0) r26;     // Catch: Throwable -> L93
        Function1 r113 = r22;
        final Function1 r39 = r23;
        boolean r28 = r18;
        mr9.l r29 = r25;
        r8 = r24;
        ?? r114 = r112;
    L98:
        if (r29 == null) goto L102;
        FLogger.a.i(r36, r37 + r8.$resourceKey);     // Catch: Throwable -> L109
        r9.invoke(r29, Boxing.boxBoolean(r114));     // Catch: Throwable -> L109
    L93:
        th = th;
        r4 = r36;
    L110:
        r3 = r34;
        goto L159
    L102:
        r4 = r36;
        if (r27 == null) goto L111;
        CreationResourceAccessUploader r30 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L109
        CreationResourceAccessUploader.h(r8.$resourceKey);     // Catch: Throwable -> L109
        FLogger.a.i(r4, r35 + r27.getTaskId() + ", identifier=" + r8.$resourceKey);     // Catch: Throwable -> L109
        Function1 r31 = new p0(r39);     // Catch: Throwable -> L109
        r8.L$0 = r9;     // Catch: Throwable -> L109
        r8.L$1 = r7;     // Catch: Throwable -> L109
        r8.L$2 = null;     // Catch: Throwable -> L109
        r8.L$3 = null;     // Catch: Throwable -> L109
        r8.L$4 = null;     // Catch: Throwable -> L109
        r8.L$5 = null;     // Catch: Throwable -> L109
        r8.L$6 = null;     // Catch: Throwable -> L109
        r8.label = 2;     // Catch: Throwable -> L109
        r17 = ICreationResourceAccessServiceKt.a(r27, r113, r31, r8);     // Catch: Throwable -> L109
        if (r17 != r38) goto L107;
        return r38;
    L107:
        r16 = r9;
        goto L108
    L111:
        if (r28 == true) goto L113;
        int r32 = com.larus.uaigc.service.p0.x;     // Catch: Throwable -> L109
        String r210 = StringsKt.substringAfterLast$default(r41, '.', null, 2, null);     // Catch: Throwable -> L109
        CountDownLatch r33 = new CountDownLatch(r114);     // Catch: Throwable -> L109
        com.larus.bmhome.resource.access.d0 r310 = com.larus.uaigc.service.g.b;     // Catch: Throwable -> L109
        String r115 = r41;
        com.larus.uaigc.service.p0 r40 = com.larus.uaigc.service.p0.a.d(r115, r8.$resourceKey, "creation_video", CreationMultiAttachmentProcessor.b(r8.this$0, r8.$resourceKey, null, r41, r110), true, r33, r210, "video", r39, new c0(r9), new d0(r7), Boxing.boxBoolean(r114), null, r310, null, 213248);     // Catch: Throwable -> L109
        r113 = r113;
        r3 = r34;
    L141:
        com.larus.bmhome.resource.access.b0 r42 = ICreationResourceAccessService.a.b(r40);     // Catch: Throwable -> L148
        if (r28 == false) goto L161;
        Function1 r43 = new e0(r39);     // Catch: Throwable -> L148
        r8.L$0 = r9;     // Catch: Throwable -> L148
        r8.L$1 = r7;     // Catch: Throwable -> L148
        r8.L$2 = null;     // Catch: Throwable -> L148
        r8.L$3 = null;     // Catch: Throwable -> L148
        r8.L$4 = null;     // Catch: Throwable -> L148
        r8.L$5 = null;     // Catch: Throwable -> L148
        r8.L$6 = null;     // Catch: Throwable -> L148
        r8.label = 3;     // Catch: Throwable -> L148
        r5 = ICreationResourceAccessServiceKt.a(r42, r113, r43, r8);     // Catch: Throwable -> L148
        r8 = r8;
        if (r5 != r38) goto L146;
        return r38;
    L113:
        int r45 = t0.a;     // Catch: Throwable -> L109
        if (((StringsKt.isBlank(r41) ? 1 : 0) ^ r114) != 0) goto L116;
    L118:
        boolean r46 = false;
    L119:
        if (r46 == false) goto L121;
        String r47 = r41;
    L122:
        Uri r48 = r8.$entity.getUri();     // Catch: Throwable -> L109
        if (r48 == null) goto L125;
        String r49 = r48.toString();     // Catch: Throwable -> L109
    L126:
        com.larus.bmhome.resource.access.j0 r116 = CreationMultiAttachmentProcessor.g(r8.this$0, t0.d(r47, r49));     // Catch: Throwable -> L109
        if (r116 != null) goto L130;
        r7.invoke(new ResourceUploadError("missing_resource_input", "pending video resource input is missing"), Boxing.boxBoolean(false));     // Catch: Throwable -> L109
        return Unit.INSTANCE;
    L130:
        int r50 = com.larus.uaigc.service.p0.x;     // Catch: Throwable -> L109
        CreationMultiAttachmentProcessor r51 = r8.this$0;     // Catch: Throwable -> L109
        Uri r52 = r8.$entity.getUri();     // Catch: Throwable -> L109
        if (r52 == null) goto L133;
        String r53 = r52.toString();     // Catch: Throwable -> L109
    L134:
        String r211 = CreationMultiAttachmentProcessor.e(r51, r41, r53);     // Catch: Throwable -> L109
        ConcurrentHashMap<String, r0.a> r54 = r0.a;     // Catch: Throwable -> L109
        String r55 = r8.$resourceKey;     // Catch: Throwable -> L109
        r3 = r34;
        Intrinsics.checkNotNullParameter(r55, r3);     // Catch: Throwable -> L148
        r0.a();     // Catch: Throwable -> L148
        r0.a r56 = r0.a.get(r55);     // Catch: Throwable -> L148
        if (r56 == null) goto L139;
        Map r57 = MapsKt.mapOf(TuplesKt.to("video_max_duration_seconds", String.valueOf(r56.a)));     // Catch: Throwable -> L148
    L140:
        Map r212 = r57;
        CountDownLatch r58 = new CountDownLatch(1);     // Catch: Throwable -> L148
        com.larus.bmhome.resource.access.d0 r59 = com.larus.uaigc.service.g.a;     // Catch: Throwable -> L148
        r40 = com.larus.uaigc.service.p0.a.f(r116, r8.$resourceKey, CreationMultiAttachmentProcessor.b(r8.this$0, r8.$resourceKey, r8.$entity.getUri(), r41, r110), r58, r211, Boxing.boxBoolean(true), r212, null, 138496);     // Catch: Throwable -> L148
        goto L141
    L139:
        r57 = MapsKt.emptyMap();     // Catch: Throwable -> L148
        goto L140
    L133:
        r53 = null;
        goto L134
    L125:
        r49 = null;
        goto L126
    L121:
        r47 = null;
        goto L122
    L116:
        if (new PolarisFileWrapper(r41).exists() == false) goto L118;
        r46 = true;
        goto L119
    L18:
        ResultKt.throwOnFailure(r44);
        UplinkEntityContent r60 = this.$entity.getUplinkEntityContent();     // Catch: Throwable -> L157
        if (r60 == null) goto L24;
        UplinkFileInfo r61 = r60.getUplinkFileInfo();     // Catch: Throwable -> L157
        if (r61 == null) goto L24;
        String r62 = r61.getLocalResPath();     // Catch: Throwable -> L157
    L25:
        if (r62 != null) goto L27;
        r62 = "";
    L27:
        String r117 = r62;
        UplinkEntityContent r63 = this.$entity.getUplinkEntityContent();     // Catch: Throwable -> L157
        if (r63 == null) goto L32;
        UplinkFileInfo r64 = r63.getUplinkFileInfo();     // Catch: Throwable -> L157
        if (r64 == null) goto L32;
        VideoExtension r118 = r64.getVideo();     // Catch: Throwable -> L157
    L34:
        if ((!StringsKt.isBlank(r117)) == false) goto L36;
        String r65 = r117;
    L37:
        if (r65 == null) goto L41;
        PolarisFileWrapper r66 = new PolarisFileWrapper(r65);     // Catch: Throwable -> L157
        if (r66.exists() == false) goto L41;
    L42:
        com.larus.uaigc.helper.f.a.getClass();     // Catch: Throwable -> L157
        boolean r67 = com.larus.uaigc.helper.f.a();     // Catch: Throwable -> L157
        FLogger.a.i("CreationMultiAttachmentProcessor", "[uploadVideo] resourceKey = " + this.$resourceKey + ", localResPath = " + r117 + ", video = " + r118);     // Catch: Throwable -> L157
        if (r66 == null) goto L47;
        String r68 = this.$resourceKey;     // Catch: Throwable -> L157
        if (r67 == true) goto L47;
        com.larus.bmhome.upload.h r69 = com.larus.bmhome.upload.h.a;     // Catch: Throwable -> L157
        com.larus.bmhome.upload.h.a(r68, new mr9.e(r66.getName(), r68, null, null, Boxing.boxLong(r66.length()), null, null, null, null, null, null, null, 16364), "uploadVideo");     // Catch: Throwable -> L157
    L47:
        tx9.l0.d(this.$resourceKey);     // Catch: Throwable -> L157
        ResourceCenter r70 = ResourceCenter.a;     // Catch: Throwable -> L157
        String r71 = this.$resourceKey;     // Catch: Throwable -> L157
        FlowResourceScene r72 = FlowResourceScene.CreationUserVideoV2;     // Catch: Throwable -> L157
        r70.getClass();     // Catch: Throwable -> L157
        ResourceCenter.k(r71, r72);     // Catch: Throwable -> L157
        if (r67 == false) goto L51;
        ICreationResourceAccessService.Companion r73 = ICreationResourceAccessService.a;     // Catch: Throwable -> L157
        String r74 = this.$resourceKey;     // Catch: Throwable -> L157
        com.larus.bmhome.resource.access.x r75 = com.larus.uaigc.service.f.c;     // Catch: Throwable -> L157
        ResourceMediaType r119 = ResourceMediaType.VIDEO;     // Catch: Throwable -> L157
        Set<String> r120 = CreationMultiAttachmentProcessor.b;     // Catch: Throwable -> L157
        com.larus.bmhome.resource.access.z r76 = r73.d(r74, r75, r119, "creation_video");     // Catch: Throwable -> L157
    L52:
        if (r76 == null) goto L58;
        Map r77 = r76.g;     // Catch: Throwable -> L157
        if (r77 == null) goto L58;
        com.larus.bmhome.resource.access.q0 r78 = (com.larus.bmhome.resource.access.q0) r77.get("preprocess");     // Catch: Throwable -> L157
        if (r78 == null) goto L58;
        Map r79 = r78.f;     // Catch: Throwable -> L157
    L59:
        if (r79 != null) goto L61;
        r79 = MapsKt.emptyMap();     // Catch: Throwable -> L157
    L61:
        final Map r213 = r79;
        final long r80 = System.currentTimeMillis();     // Catch: Throwable -> L157
        final UplinkFileEntity r121 = this.$entity;     // Catch: Throwable -> L157
        final String r81 = this.$localNestedFileMessageId;     // Catch: Throwable -> L157
        r34 = "identifier";
        Function1 r122 = new i0(r121, r81);     // Catch: Throwable -> L155
        r35 = "[uploadVideo] observe existing taskId=";
        final String r82 = this.$resourceKey;     // Catch: Throwable -> L155
        r36 = "CreationMultiAttachmentProcessor";
        Function1 r123 = new m0(r121, r82, r81);     // Catch: Throwable -> L153
        r37 = "[uploadVideo] reuse ready artifact, identifier=";
        final AtomicBoolean r83 = this.$finishOnce;     // Catch: Throwable -> L153
        r38 = r10;
        final AtomicInteger r124 = this.$handlingFileCount;     // Catch: Throwable -> L153
        final CreationMultiAttachmentProcessor r125 = this.this$0;     // Catch: Throwable -> L153
        r39 = r122;
        final AtomicBoolean r126 = this.$messageSent;     // Catch: Throwable -> L153
        VideoExtension r410 = r118;
        final CreationSendMessageConfig r127 = this.$config;     // Catch: Throwable -> L153
        r41 = r117;
        final Map<String, String> r128 = this.$ext;     // Catch: Throwable -> L153
        final String r84 = this.$localTextMessageId;     // Catch: Throwable -> L153
        final PolarisFileWrapper r214 = r66;
        final com.larus.bmhome.resource.access.z r215 = r76;
        Function2 r85 = new n0(r82, r213, r121, r214, r81, r215, r80, r83, r124, r125, r126, r127, r128, r84);     // Catch: Throwable -> L150
        final PolarisFileWrapper r216 = r66;
        final com.larus.bmhome.resource.access.z r217 = r76;
        r7 = new o0(r82, r121, r216, r81, r217, r80, r83, r124, r125, r126, r127, r128, r84);     // Catch: Throwable -> L150
        if (r67 == false) goto L81;
        if (r76 == null) goto L70;
        com.larus.bmhome.resource.access.a0 r86 = r76.c;     // Catch: Throwable -> L150
    L72:
        if ((r86 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L74;
        com.larus.bmhome.resource.access.a0.d r87 = (com.larus.bmhome.resource.access.a0.d) r86;     // Catch: Throwable -> L150
    L75:
        if (r87 == null) goto L78;
        com.larus.bmhome.resource.access.f0 r88 = r87.a;     // Catch: Throwable -> L150
        if (r88 == null) goto L78;
    L79:
        if (r88 == null) goto L81;
        r29 = com.larus.bmhome.resource.access.s.c(r88);     // Catch: Throwable -> L150
    L82:
        if (r67 == false) goto L96;
        if (r29 != null) goto L96;
        ICreationResourceAccessService.Companion r89 = ICreationResourceAccessService.a;     // Catch: Throwable -> L150
        r8 = this;
        r9 = r85;
        String r90 = r8.$resourceKey;     // Catch: Throwable -> L93
        com.larus.bmhome.resource.access.x r91 = com.larus.uaigc.service.f.c;     // Catch: Throwable -> L93
        ResourceMediaType r92 = ResourceMediaType.VIDEO;     // Catch: Throwable -> L93
        Set<String> r93 = CreationMultiAttachmentProcessor.b;     // Catch: Throwable -> L93
        r27 = r89.e(r90, r91, r92, "creation_video");     // Catch: Throwable -> L93
        if (r27 != null) goto L95;
        CreationResourceAccessUploader r94 = CreationResourceAccessUploader.a;     // Catch: Throwable -> L93
        String r95 = r8.$resourceKey;     // Catch: Throwable -> L93
        r41 = r41;
        r8.L$0 = r41;     // Catch: Throwable -> L93
        r8.L$1 = r410;     // Catch: Throwable -> L93
        r8.L$2 = r39;     // Catch: Throwable -> L93
        r8.L$3 = r123;     // Catch: Throwable -> L93
        r8.L$4 = r9;     // Catch: Throwable -> L93
        r8.L$5 = r7;     // Catch: Throwable -> L93
        r8.L$6 = r29;     // Catch: Throwable -> L93
        r8.Z$0 = r67;     // Catch: Throwable -> L93
        r112 = true;
        r8.label = 1;     // Catch: Throwable -> L93
        r26 = r94.c(r95, r91, r92, "creation_video", this);     // Catch: Throwable -> L93
        r38 = r38;
        if (r26 != r38) goto L91;
        return r38;
    L91:
        r25 = r29;
        r23 = r39;
        r22 = r123;
        r18 = r67;
        r110 = r410;
        r24 = r8;
        goto L92
    L95:
        boolean r129 = true;
        ?? r96 = r8;
    L97:
        r28 = r67;
        r113 = r123;
        r110 = r410;
        r8 = r96;
        r114 = r129;
    L96:
        r129 = true;
        r96 = this;
        r9 = r85;
        r27 = null;
    L78:
        r88 = ICreationResourceAccessService.a.c(r82);     // Catch: Throwable -> L150
        goto L79
    L74:
        r87 = null;
        goto L75
    L70:
        r86 = null;
    L81:
        r29 = null;
    L150:
        th = th;
        r8 = this;
    L152:
        r3 = r34;
        r4 = r36;
    L153:
        th = th;
        r8 = this;
    L155:
        th = th;
        r8 = this;
        r4 = "CreationMultiAttachmentProcessor";
    L58:
        r79 = null;
        goto L59
    L51:
        r76 = null;
    L41:
        r66 = null;
        goto L42
    L36:
        r65 = null;
    L32:
        r118 = null;
    L24:
        r62 = null;
    L109:
        th = th;
    L157:
        th = th;
        r8 = this;
        r3 = "identifier";
        r4 = "CreationMultiAttachmentProcessor";
        goto L159
    }

    public static final void a(final UplinkFileEntity r34, String r35, final String r36, Map<String, String> r37, mr9.e r38, boolean r39) {
        int r4 = u0.a;
        Intrinsics.checkNotNullParameter(r34, "entity");
        Intrinsics.checkNotNullParameter(r35, "resourceKey");
        Intrinsics.checkNotNullParameter(r37, "attributes");
        UplinkEntityContent r5 = r34.getUplinkEntityContent();
        if (r5 != null) goto L5;
        r5 = new UplinkEntityContent(null, null, 3, null);
    L5:
        UplinkFileInfo r6 = r5.getUplinkFileInfo();
        if (r6 != null) goto L8;
        r6 = new UplinkFileInfo(null, null, null, Integer.valueOf(FileType.FileTypeVideo.getValue()), null, null, null, null, null, null, 1015, null);
    L8:
        VideoExtension r7 = r6.getVideo();
        if (r7 != null) goto L11;
        r7 = new VideoExtension(null, null, null, null, null, null, null, null, null, "upload", 511, null);
    L11:
        VideoExtension r21 = r7;
        mr9.e r1 = com.larus.bmhome.upload.h.a.query(r35);
        String r8 = r37.get("video_local_path");
        boolean r9 = true;
        if (r8 != null) goto L14;
    L19:
        r8 = r6.getLocalResPath();
    L20:
        if (r8 != null) goto L22;
        String r23 = r21.getPath();
    L23:
        if (r38 == null) goto L26;
        Image r10 = r38.a;
        if (r10 == null) goto L26;
    L33:
        Image r24 = r10;
        if (r38 == null) goto L39;
        String r11 = r38.f();
        if (r11 == null) goto L39;
    L38:
        String r25 = r11;
        if (r38 == null) goto L57;
        Long r13 = r38.d();
        if (r13 == null) goto L57;
        if (r13.longValue() <= 0) goto L51;
        boolean r14 = true;
    L52:
        if (r14 == true) goto L55;
        r13 = null;
    L55:
        if (r13 == null) goto L57;
        Float r12 = Float.valueOf(r13.longValue() / 1000.0f);
    L85:
        Float r28 = r12;
        if (r38 == null) goto L98;
        Integer r15 = r38.j();
        if (r15 == null) goto L98;
        if (r15.intValue() <= 0) goto L92;
        boolean r16 = true;
    L93:
        if (r16 == true) goto L96;
        r15 = null;
    L96:
        if (r15 == null) goto L98;
    L122:
        Integer r30 = r15;
        if (r38 == null) goto L135;
        Integer r17 = r38.h();
        if (r17 == null) goto L135;
        if (r17.intValue() <= 0) goto L129;
        boolean r18 = true;
    L130:
        if (r18 == true) goto L133;
        r17 = null;
    L133:
        if (r17 == null) goto L135;
        Integer r29 = r17;
    L160:
        VideoExtension r27 = VideoExtension.copy$default(r21, null, r23, r24, r25, null, null, r28, r29, r30, null, 561, null);
        if (r38 == null) goto L166;
        String r2 = r38.e();
        if (r2 == null) goto L166;
    L165:
        String r22 = r2;
        if (r38 == null) goto L176;
        Long r3 = r38.i();
        if (r3 == null) goto L176;
    L175:
        Long r26 = r3;
        if (r38 == null) goto L186;
        String r19 = r38.f();
        if (r19 == null) goto L186;
        String r210 = r19;
    L192:
        UplinkFileInfo r20 = UplinkFileInfo.copy$default(r6, r22, null, null, null, r26, null, r27, r210, r8, null, 558, null);
        if (Intrinsics.areEqual(r20, r6) == false) goto L195;
        r9 = false;
    L196:
        if (r9 == true) goto L198;
        return;
    L198:
        if (r39 == false) goto L201;
        com.larus.utils.t0.e(new a0(r36, r34));
        return;
    L201:
        return;
    L195:
        r34.setUplinkEntityContent(UplinkEntityContent.copy$default(r5, r20, null, 2, null));
    L186:
        if (r1 == null) goto L188;
        String r31 = r1.f();
    L189:
        if (r31 != null) goto L191;
        r31 = r6.getMimeType();
    L191:
        r210 = r31;
        goto L192
    L188:
        r31 = null;
    L176:
        if (r1 == null) goto L178;
        r3 = r1.i();
    L179:
        if (r3 != null) goto L175;
        r3 = r6.getSize();
        goto L175
    L178:
        r3 = null;
    L166:
        if (r1 == null) goto L168;
        r2 = r1.e();
    L169:
        if (r2 != null) goto L165;
        r2 = r6.getFileName();
        goto L165
    L168:
        r2 = null;
        goto L169
    L129:
        r18 = false;
    L135:
        String r32 = r37.get("video_height");
        if (r32 == null) goto L145;
        Integer r33 = StringsKt.toIntOrNull(r32);
        if (r33 == null) goto L145;
        if (r33.intValue() <= 0) goto L142;
        boolean r110 = true;
    L143:
        if (r110 == false) goto L145;
    L146:
        if (r33 != null) goto L159;
        if (r1 == null) goto L156;
        r33 = r1.h();
        if (r33 == null) goto L156;
        if (r33.intValue() <= 0) goto L153;
        boolean r111 = true;
    L154:
        if (r111 == false) goto L156;
    L157:
        if (r33 != null) goto L159;
        r33 = r21.getHeight();
        goto L159
    L153:
        r111 = false;
    L156:
        r33 = null;
    L159:
        r29 = r33;
        goto L160
    L142:
        r110 = false;
    L145:
        r33 = null;
        goto L146
    L92:
        r16 = false;
    L98:
        String r112 = r37.get("video_width");
        if (r112 == null) goto L108;
        r15 = StringsKt.toIntOrNull(r112);
        if (r15 == null) goto L108;
        if (r15.intValue() <= 0) goto L105;
        boolean r113 = true;
    L106:
        if (r113 == false) goto L108;
    L109:
        if (r15 != null) goto L122;
        if (r1 == null) goto L119;
        r15 = r1.j();
        if (r15 == null) goto L119;
        if (r15.intValue() <= 0) goto L116;
        boolean r114 = true;
    L117:
        if (r114 == false) goto L119;
    L120:
        if (r15 != null) goto L122;
        r15 = r21.getWidth();
        goto L122
    L116:
        r114 = false;
    L119:
        r15 = null;
        goto L120
    L105:
        r113 = false;
    L108:
        r15 = null;
        goto L109
    L51:
        r14 = false;
    L57:
        String r115 = r37.get("video_duration_ms");
        if (r115 == null) goto L70;
        Long r116 = StringsKt.toLongOrNull(r115);
        if (r116 == null) goto L70;
        if (r116.longValue() <= 0) goto L64;
        boolean r117 = true;
    L65:
        if (r117 == true) goto L68;
        r116 = null;
    L68:
        if (r116 == null) goto L70;
        r12 = Float.valueOf(r116.longValue() / 1000.0f);
        goto L85
    L64:
        r117 = false;
    L70:
        if (r1 == null) goto L82;
        Long r118 = r1.d();
        if (r118 == null) goto L82;
        if (r118.longValue() <= 0) goto L76;
        boolean r119 = true;
    L77:
        if (r119 == true) goto L80;
        r118 = null;
    L80:
        if (r118 == null) goto L82;
        r12 = Float.valueOf(r118.longValue() / 1000.0f);
    L83:
        if (r12 != null) goto L85;
        r12 = r21.getDuration();
        goto L85
    L76:
        r119 = false;
    L82:
        r12 = null;
    L39:
        if (r1 == null) goto L41;
        r11 = r1.f();
    L42:
        if (r11 != null) goto L38;
        r11 = r21.getFormat();
        goto L38
    L41:
        r11 = null;
    L26:
        r10 = u0.a(r37);
        if (r10 != null) goto L33;
        if (r1 == null) goto L30;
        r10 = r1.a;
    L31:
        if (r10 != null) goto L33;
        r10 = r21.getCover();
        goto L33
    L30:
        r10 = null;
        goto L31
    L22:
        r23 = r8;
        goto L23
    L14:
        if ((!StringsKt.isBlank(r8)) == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L19;
        goto L19
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
        CreationResourceAccessUploader.k(r9, r10, r2, r14, r4, r15, "creation_multi_attachment_video", MapsKt.mapOf(r1));
        return;
    L7:
        r5 = null;
        goto L8
    }

    public static /* synthetic */ void invokeSuspend$refreshVideoMetadata$default(UplinkFileEntity r6, String r7, String r8, Map r9, mr9.e r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r10 = null;
    L5:
        mr9.e r4 = r10;
        if ((r12 & 32) == 0) goto L8;
        boolean r5 = true;
    L9:
        a(r6, r7, r8, r9, r4, r5);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}

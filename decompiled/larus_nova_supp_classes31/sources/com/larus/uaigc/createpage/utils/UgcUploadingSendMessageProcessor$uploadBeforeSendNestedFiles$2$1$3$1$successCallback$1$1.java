package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1", f = "NestedFileSendMessageProcessor.kt", i = {0, 1}, l = {494, 537, 538, 542}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u242", "job2"}, s = {"L$6", "L$0"})
public final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curUploaderIdentifier;
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicBoolean $finishOnce;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localResPath;
    final /* synthetic */ Ref.ObjectRef<String> $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ mr9.l $result;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1(String r4, boolean r5, Ref.ObjectRef<String> r6, UplinkFileEntity r7, mr9.l r8, Ref.ObjectRef<String> r9, y8 r10, ICoreInputAbility.OnSendParams r11, UgcUploadingSendMessageProcessor r12, AtomicBoolean r13, AtomicInteger r14, AtomicBoolean r15, Map<String, String> r16, Ref.ObjectRef<String> r17, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r18, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1> r19) {
        this.$curUploaderIdentifier = r4;
        this.$pipelineEnabled = r5;
        this.$localResPath = r6;
        this.$entity = r7;
        this.$result = r8;
        this.$localNestedFileMessageId = r9;
        this.$dependency = r10;
        this.$params = r11;
        this.this$0 = r12;
        this.$finishOnce = r13;
        this.$handlingFileCount = r14;
        this.$messageSent = r15;
        this.$ext = r16;
        this.$localTextMessageId = r17;
        this.$originalLogic = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
        UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1 r15 = new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1(this.$curUploaderIdentifier, this.$pipelineEnabled, this.$localResPath, this.$entity, this.$result, this.$localNestedFileMessageId, this.$dependency, this.$params, this.this$0, this.$finishOnce, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, this.$originalLogic, r21);
        r15.L$0 = r20;
        return r15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L11;
        if (r3 != 4) goto L10;
        ResultKt.throwOnFailure(r22);
    L99:
        UgcUploadingSendMessageProcessor.c(this.$finishOnce, this.$curUploaderIdentifier, this.$handlingFileCount, this.this$0, this.$dependency, this.$messageSent, this.$params, this.$ext, this.$localNestedFileMessageId, this.$localTextMessageId, this.$originalLogic, "imageUpload successCallback");
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L92
    L90:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L94:
        String r4 = this.$curUploaderIdentifier;
        UplinkFileEntity r5 = this.$entity;
        Ref.ObjectRef<String> r6 = this.$localNestedFileMessageId;
        Throwable r7 = Result.exceptionOrNull-impl(r0);
        if (r7 == null) goto L99;
        FLogger.a.e("NestedFileSendMessageProcessor", "[imageUpload successCallback] post process failed, identifier: " + r4, r7);
        r5.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$2$1 r9 = new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$2$1(r6, r5, null);
        this.L$0 = r0;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 4;
        if (BuildersKt.withContext(r8, r9, this) != r2) goto L99;
        return r2;
    L13:
        Deferred r1 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L92
        Object r10 = null;
    L87:
        this.L$0 = r10;     // Catch: Throwable -> L92
        this.label = 3;     // Catch: Throwable -> L92
        if (r1.await(this) != r2) goto L90;
        return r2;
    L16:
        boolean r11 = this.Z$0;
        CoroutineScope r12 = (CoroutineScope) this.L$6;
        UgcUploadingSendMessageProcessor r13 = (UgcUploadingSendMessageProcessor) this.L$5;
        ICoreInputAbility.OnSendParams r14 = (ICoreInputAbility.OnSendParams) this.L$4;
        y8 r15 = (y8) this.L$3;
        Ref.ObjectRef<String> r16 = (Ref.ObjectRef) this.L$2;
        mr9.l r17 = (mr9.l) this.L$1;
        UplinkFileEntity r18 = (UplinkFileEntity) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L92
        Ref.ObjectRef<String> r19 = r16;
        ICoreInputAbility.OnSendParams r110 = r14;
        mr9.l r111 = r17;
        UgcUploadingSendMessageProcessor r112 = r13;
    L80:
        mr9.l r113 = r111;
        Deferred r114 = BuildersKt.async$default(r12, null, null, new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1(r18, r111, null), 3, null);     // Catch: Throwable -> L92
        if (r11 == false) goto L83;
        boolean r115 = true;
    L84:
        r1 = BuildersKt.async$default(r12, null, null, new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job2$1(r15, r110, r18, r115, r112, r113, r19, null), 3, null);     // Catch: Throwable -> L92
        this.L$0 = r1;     // Catch: Throwable -> L92
        r10 = null;
        this.L$1 = null;     // Catch: Throwable -> L92
        this.L$2 = null;     // Catch: Throwable -> L92
        this.L$3 = null;     // Catch: Throwable -> L92
        this.L$4 = null;     // Catch: Throwable -> L92
        this.L$5 = null;     // Catch: Throwable -> L92
        this.L$6 = null;     // Catch: Throwable -> L92
        this.label = 2;     // Catch: Throwable -> L92
        if (r114.await(this) != r2) goto L87;
        return r2;
    L83:
        r115 = false;
        goto L84
    L19:
        ResultKt.throwOnFailure(r22);
        r12 = (CoroutineScope) this.L$0;
        String r20 = this.$curUploaderIdentifier;
        boolean r116 = this.$pipelineEnabled;
        Ref.ObjectRef<String> r117 = this.$localResPath;
        UplinkFileEntity r118 = this.$entity;
        mr9.l r119 = this.$result;
        Ref.ObjectRef<String> r120 = this.$localNestedFileMessageId;
        y8 r21 = this.$dependency;
        ICoreInputAbility.OnSendParams r23 = this.$params;
        UgcUploadingSendMessageProcessor r24 = this.this$0;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L92
        FLogger.a.i("NestedFileSendMessageProcessor", "imageResourceAccess success, curUploaderIdentifier:" + r20);     // Catch: Throwable -> L92
        com.larus.bmhome.resource.access.f0 r25 = ICreationResourceAccessService.a.c(r20);     // Catch: Throwable -> L92
        if (r116 == false) goto L34;
        if (r25 == null) goto L33;
        com.larus.bmhome.resource.access.j0.b r26 = r25.b;     // Catch: Throwable -> L92
        if (r26 == null) goto L33;
        if ((r26 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L28;
        com.larus.bmhome.resource.access.j0.b r27 = r26;     // Catch: Throwable -> L92
    L29:
        if (r27 == null) goto L31;
        String r28 = r27.b;     // Catch: Throwable -> L92
    L32:
        if (r28 == null) goto L33;
    L35:
        r118.setFileParsedStatus(Boxing.boxInt(FileParseState.SUCCESS.getValue()));     // Catch: Throwable -> L92
        r118.setUpLinkProcess(Boxing.boxInt(100));     // Catch: Throwable -> L92
        r118.setUpLinkStatus(Boxing.boxInt(UpLinkState.SUCCESS.getValue()));     // Catch: Throwable -> L92
        UplinkEntityContent r29 = r118.getUplinkEntityContent();     // Catch: Throwable -> L92
        if (r29 == null) goto L40;
        UplinkFileInfo r30 = r29.getUplinkFileInfo();     // Catch: Throwable -> L92
        if (r30 == null) goto L40;
        r30.setLocalResPath(r28);     // Catch: Throwable -> L92
    L40:
        UplinkEntityContent r31 = r118.getUplinkEntityContent();     // Catch: Throwable -> L92
        if (r31 == null) goto L45;
        Image r32 = r31.getUplinkImageInfo();     // Catch: Throwable -> L92
        if (r32 == null) goto L45;
        r32.key = r119.a;     // Catch: Throwable -> L92
    L45:
        UplinkEntityContent r33 = r118.getUplinkEntityContent();     // Catch: Throwable -> L92
        if (r33 == null) goto L50;
        Image r34 = r33.getUplinkImageInfo();     // Catch: Throwable -> L92
        if (r34 == null) goto L50;
        r34.resourceId = r119.c;     // Catch: Throwable -> L92
    L50:
        ResourceUploadInstantInfo r35 = r119.g;     // Catch: Throwable -> L92
        if (r35 == null) goto L53;
        zd9.h.a.getClass();     // Catch: Throwable -> L92
        String r36 = zd9.h.c(r35);     // Catch: Throwable -> L92
    L54:
        r118.setInstantUploadInfoJson(r36);     // Catch: Throwable -> L92
        UplinkEntityContent r37 = r118.getUplinkEntityContent();     // Catch: Throwable -> L92
        if (r37 == null) goto L65;
        Image r38 = r37.getUplinkImageInfo();     // Catch: Throwable -> L92
        if (r38 == null) goto L65;
        ImageObj r39 = r38.imageOri;     // Catch: Throwable -> L92
        if (r39 == null) goto L65;
        mr9.d r40 = r119.d;     // Catch: Throwable -> L92
        if (r40 == null) goto L63;
        int r41 = r40.b;     // Catch: Throwable -> L92
    L64:
        r39.width = r41;     // Catch: Throwable -> L92
        goto L65
    L63:
        r41 = 0;
    L65:
        UplinkEntityContent r42 = r118.getUplinkEntityContent();     // Catch: Throwable -> L92
        if (r42 == null) goto L76;
        Image r43 = r42.getUplinkImageInfo();     // Catch: Throwable -> L92
        if (r43 == null) goto L76;
        ImageObj r44 = r43.imageOri;     // Catch: Throwable -> L92
        if (r44 == null) goto L76;
        mr9.d r45 = r119.d;     // Catch: Throwable -> L92
        if (r45 == null) goto L74;
        int r46 = r45.a;     // Catch: Throwable -> L92
    L75:
        r44.height = r46;     // Catch: Throwable -> L92
        goto L76
    L74:
        r46 = 0;
    L76:
        MainCoroutineDispatcher r47 = Dispatchers.getMain();     // Catch: Throwable -> L92
        UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$2 r48 = new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$2(r120, r118, null);     // Catch: Throwable -> L92
        this.L$0 = r118;     // Catch: Throwable -> L92
        this.L$1 = r119;     // Catch: Throwable -> L92
        this.L$2 = r120;     // Catch: Throwable -> L92
        this.L$3 = r21;     // Catch: Throwable -> L92
        this.L$4 = r23;     // Catch: Throwable -> L92
        this.L$5 = r24;     // Catch: Throwable -> L92
        this.L$6 = r12;     // Catch: Throwable -> L92
        this.Z$0 = r116;     // Catch: Throwable -> L92
        this.label = 1;     // Catch: Throwable -> L92
        if (BuildersKt.withContext(r47, r48, this) != r2) goto L79;
        return r2;
    L79:
        r11 = r116;
        r18 = r118;
        r19 = r120;
        r111 = r119;
        r15 = r21;
        r110 = r23;
        r112 = r24;
        goto L80
    L53:
        r36 = null;
        goto L54
    L31:
        r28 = null;
        goto L32
    L28:
        r27 = null;
    L33:
        r28 = (String) r117.element;     // Catch: Throwable -> L92
        goto L35
    L34:
        r28 = (String) r117.element;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L94
    }
}

package com.larus.bmhome.utils;

import com.larus.bmhome.rc.FlowResource;
import com.larus.bmhome.rc.FlowResourceMeta;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ImageResourceMeta;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceFingerprintMeta;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterTraceError;
import com.larus.bmhome.rc.ResourceTargetMeta;
import com.larus.im.bean.message.Image;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadFingerprintMeta;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.model.upload.ResourceUploadTargetMeta;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.RegisterHelper$registerResource$1", f = "RegisterHelper.kt", i = {}, l = {81, 101}, m = "invokeSuspend", n = {}, s = {})
public final class RegisterHelper$registerResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Image $imageMeta;
    final /* synthetic */ ResourceUploadInstantInfo $instantUploadInfo;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ String $outerIdentifier;
    final /* synthetic */ String $sceneId;
    final /* synthetic */ String $sectionId;
    final /* synthetic */ String $tosKey;
    int label;

    public RegisterHelper$registerResource$1(String r1, ResourceUploadInstantInfo r2, String r3, String r4, String r5, String r6, String r7, String r8, Image r9, Continuation<? super RegisterHelper$registerResource$1> r10) {
        this.$outerIdentifier = r1;
        this.$instantUploadInfo = r2;
        this.$sceneId = r3;
        this.$cvsId = r4;
        this.$botId = r5;
        this.$sectionId = r6;
        this.$localMessageId = r7;
        this.$tosKey = r8;
        this.$imageMeta = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new RegisterHelper$registerResource$1(this.$outerIdentifier, this.$instantUploadInfo, this.$sceneId, this.$cvsId, this.$botId, this.$sectionId, this.$localMessageId, this.$tosKey, this.$imageMeta, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r31);
    L61:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r31);     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        Object r2 = r31;
    L45:
        String r3 = this.$localMessageId;     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        ResourceRegisterData r4 = (ResourceRegisterData) r2;     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        FLogger.a.i("RegisterHelper", "registerResource success resourceId#" + r4.getResourceId() + " aliasName#" + r4.getAliasName() + " msgId#" + r3);     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
    L15:
        ResultKt.throwOnFailure(r31);
        if (com.larus.utils.o0.d(this.$outerIdentifier) == false) goto L18;
        String r5 = this.$outerIdentifier;
    L19:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        String r6 = r5;
        int r7 = RegisterHelper.a;
        ResourceUploadInstantInfo r8 = this.$instantUploadInfo;
        if (r8 != null) goto L24;
        ResourceInstantUploadInfo r10 = null;
    L34:
        if (com.larus.utils.o0.d(this.$sceneId) == false) goto L36;
        String r11 = this.$sceneId;
    L37:
        String r12 = r11;
        ResourceAttachmentExtra r13 = new ResourceAttachmentExtra(com.larus.platform.service.o.a.getDeviceId(), this.$cvsId, this.$botId, this.$sectionId, this.$localMessageId);
        if (r10 == null) goto L40;
        boolean r14 = Intrinsics.areEqual(r10.getPreQueryHit(), Boxing.boxBoolean(true));
    L41:
        if (r14 == false) goto L49;
        String r15 = this.$tosKey;     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        Image r16 = this.$imageMeta;     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        this.label = 1;     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        r2 = RegisterHelper.a(r15, r6, r12, r13, r10, r16, this);     // Catch: ResourceUploadError -> L11 ResourceRegisterTraceError -> L13
        if (r2 != r9) goto L45;
        return r9;
    L49:
        String r17 = this.$tosKey;
        Image r18 = this.$imageMeta;
        this.label = 2;
        Integer r19 = Boxing.boxInt(FlowResourceType.Image.getValue());
        if (r18 == null) goto L53;
        Image r20 = Image.copy$default(r18, null, null, null, null, null, null, r6, null, null, null, null, null, null, null, 16319, null);
        if (r20 == null) goto L53;
    L54:
        Object r0 = ResourceCenter.a.l(CollectionsKt.listOf(new FlowResource(r17, r19, new FlowResourceMeta(null, new ImageResourceMeta(r20, null, 2, null), null, null, null, null, 61, null), null, 8, null)), r13, r12, this);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
        r0 = Unit.INSTANCE;
    L58:
        if (r0 != r9) goto L61;
        return r9;
    L53:
        r20 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r20.identifier = r6;
        Unit r21 = Unit.INSTANCE;
        goto L54
    L40:
        r14 = false;
        goto L41
    L36:
        FlowResourceScene.a r22 = FlowResourceScene.Companion;
        FlowResourceScene r23 = FlowResourceScene.ImageVLM;
        r22.getClass();
        r11 = FlowResourceScene.a.b(r23);
        goto L37
    L24:
        Boolean r24 = r8.getPreQueryHit();
        ResourceUploadFingerprintMeta r110 = r8.getFingerprintMeta();
        if (r110 != null) goto L27;
        ResourceFingerprintMeta r111 = null;
    L28:
        ResourceUploadTargetMeta r112 = r8.getTargetMeta();
        if (r112 != null) goto L31;
        ResourceTargetMeta r113 = null;
    L32:
        r10 = new ResourceInstantUploadInfo(r24, r111, r113, r8.getRegisterUri());
        goto L34
    L31:
        r113 = new ResourceTargetMeta(r112.getTargetUri(), r112.getTargetResourceId());
        goto L32
    L27:
        r111 = new ResourceFingerprintMeta(r110.getOriginHash(), r110.getTransformPolicyId(), r110.getPolicyFamily(), r110.getPolicyDigest(), r110.getPolicySchemaVersion(), r110.getPolicyDefinition(), r110.getFileSize(), r110.getMimeType(), r110.getFileName(), r110.getDataType(), r110.getBizDomain(), r110.getUploadScene(), r110.getPreCheckMeta());
        goto L28
    L18:
        r5 = UUID.randomUUID().toString();
    L13:
        e = move-exception;
        FLogger.a.e("RegisterHelper", "registerResource instant hit failed, fallback legacy msgId#" + this.$localMessageId + " error#" + e.getUploadError());
        Unit r25 = Unit.INSTANCE;
    L11:
        e = move-exception;
        FLogger.a.e("RegisterHelper", "registerResource instant hit failed, fallback legacy msgId#" + this.$localMessageId + " error#" + e);
        Unit r26 = Unit.INSTANCE;
        goto L61
    }
}

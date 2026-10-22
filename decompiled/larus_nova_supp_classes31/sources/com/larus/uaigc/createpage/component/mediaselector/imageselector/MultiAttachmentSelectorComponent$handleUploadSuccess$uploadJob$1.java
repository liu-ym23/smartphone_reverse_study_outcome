package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.network.bean.BizResponse;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {2156}, m = "invokeSuspend", n = {"accessArtifact", "skipReviewOnInstant"}, s = {"L$0", "I$0"})
final class MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hideLoadingWhenReviewing;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ boolean $pipelineEnabled;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ mr9.l $result;
    final /* synthetic */ String $uploaderIdentifier;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1(boolean r1, MultiAttachmentSelectorComponent r2, String r3, boolean r4, String r5, mr9.l r6, String r7, String r8, Continuation<? super MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1> r9) {
        this.$pipelineEnabled = r1;
        this.this$0 = r2;
        this.$resourceKey = r3;
        this.$hideLoadingWhenReviewing = r4;
        this.$uploaderIdentifier = r5;
        this.$result = r6;
        this.$localResPath = r7;
        this.$localMessageId = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1(this.$pipelineEnabled, this.this$0, this.$resourceKey, this.$hideLoadingWhenReviewing, this.$uploaderIdentifier, this.$result, this.$localResPath, this.$localMessageId, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r34) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$0;
        com.larus.bmhome.resource.access.f0 r4 = (com.larus.bmhome.resource.access.f0) this.L$0;
        ResultKt.throwOnFailure(r34);
        Object r8 = r34;
    L33:
        dm9.a r9 = (dm9.a) r8;
        int r5 = r3;
    L34:
        if (r4 == null) goto L45;
        com.larus.bmhome.resource.access.j0.b r6 = r4.b;
        if (r6 == null) goto L45;
        if ((r6 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L40;
        com.larus.bmhome.resource.access.j0.b r7 = r6;
    L41:
        if (r7 == null) goto L43;
        String r10 = r7.b;
    L44:
        if (r10 == null) goto L45;
    L46:
        String r23 = r10;
        boolean r11 = r9 instanceof dm9.a.b;
        if (r11 == false) goto L64;
        dm9.a.b r12 = (dm9.a.b) r9;
        if (r12.a.isSuccess() == false) goto L64;
        ReviewUgcImageApi.c r13 = (ReviewUgcImageApi.c) r12.a.getData();
        if (r13 == null) goto L58;
        Integer r14 = r13.a();
        if (r14 == null) goto L58;
        if (r14.intValue() != 3) goto L58;
        boolean r15 = true;
    L59:
        if (r15 == false) goto L64;
        final MultiAttachmentSelectorComponent r16 = this.this$0;
        final String r17 = this.$resourceKey;
        com.larus.utils.t0.e(new g3(r16, r17));
        MultiAttachmentSelectorComponent.V4(this.this$0, false, "review");
        if (this.$pipelineEnabled == true) goto L63;
        nz9.b.e("image_review", "-103", this.$resourceKey);
    L63:
        nz9.b.e("creation_page/album_upload", "-103", this.$resourceKey);
    L106:
        return Unit.INSTANCE;
    L58:
        r15 = false;
    L64:
        if (r5 != 0) goto L72;
        if (r11 == true) goto L72;
        if (NetworkUtils.isNetworkAvailable(this.this$0.getContext()) == true) goto L72;
        final MultiAttachmentSelectorComponent r18 = this.this$0;
        final String r19 = this.$resourceKey;
        com.larus.utils.t0.e(new h3(r18, r19));
        MultiAttachmentSelectorComponent.V4(this.this$0, false, "upload");
        if (this.$pipelineEnabled == true) goto L71;
        nz9.b.e("image_review", "-1000", this.$resourceKey);
    L71:
        nz9.b.e("creation_page/album_upload", "-103", this.$resourceKey);
    L72:
        String r110 = this.$result.a;
        mr9.d r111 = this.$result.d;
        if (r111 == null) goto L75;
        long r112 = r111.b;
    L76:
        Long r113 = Boxing.boxLong(r112);
        mr9.d r114 = this.$result.d;
        if (r114 == null) goto L79;
        long r115 = r114.a;
    L80:
        ImageUploadInfo r116 = new ImageUploadInfo(r113, Boxing.boxLong(r115));
        String r117 = this.$uploaderIdentifier;
        String r118 = this.$result.c;
        if (r118 != null) goto L83;
        r118 = "";
    L83:
        MediaAttachment r119 = new MediaAttachment(null, r110, r116, null, r23, r117, r118, this.$localMessageId, null, null, null, null, 3848, null);
        if (this.$pipelineEnabled == false) goto L91;
        if (r4 == null) goto L89;
        Map r20 = r4.f;
        if (r20 == null) goto L89;
        String r21 = (String) r20.get("face_detected");
    L90:
        Boolean r22 = Boxing.boxBoolean(Intrinsics.areEqual(r21, "true"));
    L101:
        final ry9.j.c r24 = new ry9.j.c(new ry9.i.a(r119, r22));
        final MultiAttachmentSelectorComponent r25 = this.this$0;
        final String r26 = this.$resourceKey;
        com.larus.utils.t0.e(new i3(r25, r26, r24));
        MultiAttachmentSelectorComponent r27 = this.this$0;
        String r28 = this.$resourceKey;
        int r29 = MultiAttachmentSelectorComponent.Z;
        r27.o5(r28);
        MultiAttachmentSelectorComponent.V4(this.this$0, true, null);
        if (this.$pipelineEnabled == true) goto L104;
        nz9.b.e("image_review", "0", this.$resourceKey);
    L104:
        nz9.b.e("creation_page/album_upload", "0", this.$resourceKey);
    L89:
        r21 = null;
        goto L90
    L91:
        if (r11 == false) goto L93;
        dm9.a.b r30 = (dm9.a.b) r9;
    L94:
        if (r30 == null) goto L100;
        BizResponse r31 = r30.a;
        if (r31 == null) goto L100;
        ReviewUgcImageApi.c r32 = (ReviewUgcImageApi.c) r31.getData();
        if (r32 == null) goto L100;
        r22 = r32.b();
    L100:
        r22 = null;
        goto L101
    L93:
        r30 = null;
        goto L94
    L79:
        r115 = 0;
        goto L80
    L75:
        r112 = 0;
        goto L76
    L43:
        r10 = null;
        goto L44
    L40:
        r7 = null;
    L45:
        r10 = this.$localResPath;
        goto L46
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r34);
        if (this.$pipelineEnabled == true) goto L14;
        MultiAttachmentSelectorComponent r33 = this.this$0;
        String r35 = this.$resourceKey;
        int r36 = MultiAttachmentSelectorComponent.Z;
        MutableLiveData<ry9.k> r37 = r33.X3(r35);
        if (r37 == null) goto L13;
        r37.setValue(new ry9.k(this.$resourceKey, ry9.j.g.b, 0, false, false, this.$hideLoadingWhenReviewing, 28));
    L13:
        String r38 = this.$resourceKey;
        nz9.b.h("image_review", "creation_page/album_upload", r38, r38, 16);
    L14:
        r4 = ICreationResourceAccessService.a.c(this.$uploaderIdentifier);
        ResourceUploadInstantInfo r39 = this.$result.g;
        if (r39 == null) goto L17;
        boolean r40 = Intrinsics.areEqual(r39.getPreQueryHit(), Boxing.boxBoolean(true));
    L18:
        if (r40 == false) goto L22;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().b(), Boxing.boxBoolean(true)) == false) goto L22;
        r5 = 1;
    L24:
        if (this.$pipelineEnabled == true) goto L28;
        if (r5 == 0) goto L29;
        FLogger.a.i("MultiAttachmentSelector", "[handleUploadSuccess] skip review on instant hit");
        goto L28
    L29:
        ReviewUgcImageApi.Companion r41 = ReviewUgcImageApi.a;
        MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1$checkResult$1 r42 = new MultiAttachmentSelectorComponent$handleUploadSuccess$uploadJob$1$checkResult$1(this.$result, null);
        this.L$0 = r4;
        this.I$0 = r5;
        this.label = 1;
        r41.getClass();
        r8 = ReviewUgcImageApi.Companion.a(r42, this);
        if (r8 != r1) goto L32;
        return r1;
    L32:
        r3 = r5;
    L28:
        r9 = null;
    L22:
        r5 = 0;
        goto L24
    L17:
        r40 = false;
        goto L18
    }
}

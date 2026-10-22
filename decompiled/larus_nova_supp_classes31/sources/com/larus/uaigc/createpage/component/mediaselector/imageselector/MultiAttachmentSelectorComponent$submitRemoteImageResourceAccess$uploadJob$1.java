package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {3634, 3666}, m = "invokeSuspend", n = {"localMessageId", "path"}, s = {"L$0", "L$3"})
final class MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAvatar;
    final /* synthetic */ boolean $isPrivate;
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ String $targetIdentifier;
    final /* synthetic */ String $uri;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1(MultiAttachmentSelectorComponent r1, String r2, String r3, String r4, String r5, String r6, String r7, boolean r8, boolean r9, Continuation<? super MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1> r10) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$targetIdentifier = r3;
        this.$localFilePath = r4;
        this.$url = r5;
        this.$uri = r6;
        this.$resourceId = r7;
        this.$isPrivate = r8;
        this.$isAvatar = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1(this.this$0, this.$resourceKey, this.$targetIdentifier, this.$localFilePath, this.$url, this.$uri, this.$resourceId, this.$isPrivate, this.$isAvatar, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r1 = false;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r35);
    L48:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$3;
        String r5 = (String) this.L$2;
        MultiAttachmentSelectorComponent r6 = (MultiAttachmentSelectorComponent) this.L$1;
        String r7 = (String) this.L$0;
        ResultKt.throwOnFailure(r35);
        Object r8 = r35;
    L10:
        String r17 = r2;
        String r14 = r5;
        MultiAttachmentSelectorComponent r13 = r6;
        String r3 = ((CreationRemoteConversationHelper.a) r8).a;
        int r9 = MultiAttachmentSelectorComponent.Z;
        mr9.h r4 = r13.D3(r14, r7, r3, r17, null, null);
    L25:
        mr9.h r16 = r4;
        ICreationResourceAccessService.Companion r10 = ICreationResourceAccessService.a;
        int r11 = com.larus.uaigc.service.p0.x;
        MultiAttachmentSelectorComponent r15 = this.this$0;
        String r18 = this.$url;
        String r19 = this.$uri;
        r15.getClass();
        if (r19 != null) goto L30;
    L31:
        r1 = true;
    L32:
        if (r1 == true) goto L34;
        com.larus.bmhome.resource.access.j0.d r20 = new com.larus.bmhome.resource.access.j0.d(r19);
    L35:
        com.larus.bmhome.resource.access.j0.d r110 = r20;
        CountDownLatch r21 = new CountDownLatch(1);
        String r22 = this.$localFilePath;
        if ((true ^ StringsKt.isBlank(r22)) == true) goto L39;
        r22 = null;
    L39:
        if (r22 == null) goto L43;
        Map r23 = MapsKt.mapOf(TuplesKt.to("remote_detect_local_path", r22));
        if (r23 == null) goto L43;
    L44:
        com.larus.bmhome.resource.access.b0 r24 = r10.b(com.larus.uaigc.service.p0.a.b(r110, this.$targetIdentifier, "creation_remote", r16, true, r21, null, "ai_creation", "remote", null, new o3(), new p3(), null, null, null, null, r23, com.larus.uaigc.service.g.a, false, null, 1172608));
        MultiAttachmentSelectorComponent r25 = this.this$0;
        String r26 = this.$resourceKey;
        String r27 = this.$url;
        String r28 = this.$targetIdentifier;
        String r29 = this.$resourceId;
        String r30 = this.$localFilePath;
        boolean r111 = this.$isPrivate;
        boolean r112 = this.$isAvatar;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (MultiAttachmentSelectorComponent.Y2(r25, r24, r26, r27, r28, r29, r30, r7, r111, r112, this) != r12) goto L48;
        return r12;
    L43:
        r23 = MapsKt.emptyMap();
        goto L44
    L34:
        r20 = new com.larus.bmhome.resource.access.j0.c(r18);
        goto L35
    L30:
        if (StringsKt.isBlank(r19) == false) goto L32;
    L11:
        ResultKt.throwOnFailure(r35);
        MultiAttachmentSelectorComponent r31 = this.this$0;
        int r32 = MultiAttachmentSelectorComponent.Z;
        r7 = r31.h4();
        tx9.l0.d(this.$resourceKey);
        ResourceCenter r33 = ResourceCenter.a;
        String r34 = this.$targetIdentifier;
        FlowResourceScene r36 = FlowResourceScene.ImageVLM;
        r33.getClass();
        ResourceCenter.k(r34, r36);
        nz9.b.h("creation_page/re_upload", "creation_page", this.$resourceKey, null, 24);
        r2 = this.$localFilePath;
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
    L16:
        boolean r37 = false;
    L17:
        if (r37 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L26;
        r6 = this.this$0;
        r5 = this.$targetIdentifier;
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r5;
        this.L$3 = r2;
        this.label = 1;
        r8 = r6.s5(this);
        if (r8 != r12) goto L10;
        return r12;
    L26:
        r4 = new mr9.h(false, null, null, 31);
        goto L25
    L14:
        if (new PolarisFileWrapper(r2).exists() == false) goto L16;
        r37 = true;
        goto L17
    }
}

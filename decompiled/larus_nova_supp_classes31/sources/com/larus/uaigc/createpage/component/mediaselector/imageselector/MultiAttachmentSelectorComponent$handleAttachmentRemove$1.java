package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAttachmentRemove$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$handleAttachmentRemove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromScene;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$handleAttachmentRemove$1(MultiAttachmentSelectorComponent r1, String r2, String r3, String r4, Continuation<? super MultiAttachmentSelectorComponent$handleAttachmentRemove$1> r5) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$fromScene = r3;
        this.$localResPath = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorComponent$handleAttachmentRemove$1(this.this$0, this.$resourceKey, this.$fromScene, this.$localResPath, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r7);
        Job r8 = this.this$0.E.get(this.$resourceKey);
        boolean r0 = true;
        Uri r1 = null;
        if (r8 == null) goto L7;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L7:
        this.this$0.E.remove(this.$resourceKey);
        MultiAttachmentSelectorComponent r9 = this.this$0;
        r9.t.remove(this.$resourceKey);
        this.this$0.V5(this.$resourceKey);
        String r10 = this.this$0.w.get(this.$resourceKey);
        if (r10 == null) goto L10;
        this.this$0.x.remove(r10);
        Boxing.boxBoolean(ICreationResourceAccessService.a.a(r10, ResourceCancelReason.USER_CANCEL));
    L10:
        this.this$0.w.remove(this.$resourceKey);
        this.this$0.G.remove(this.$resourceKey);
        this.this$0.y.remove(this.$resourceKey);
        MultiAttachmentSelectorComponent r11 = this.this$0;
        String r2 = this.$fromScene;
        if (r2 != null) goto L13;
        r2 = "delete";
    L13:
        r11.R4(r2);
        this.this$0.z.remove(this.$resourceKey);
        this.this$0.A.remove(this.$resourceKey);
        if (this.this$0.y.isEmpty() == false) goto L17;
        this.this$0.J = null;
    L17:
        if (this.this$0.z5(this.$resourceKey) != ResourceType.IMAGE) goto L43;
        if (IBachDetectCenterAbility.a.b() == false) goto L43;
        String r12 = this.$localResPath;
        if (r12.length() > 0) goto L24;
        r0 = false;
    L24:
        if (r0 == true) goto L27;
        r12 = null;
    L27:
        if (r12 == null) goto L43;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r12);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L34
        if (r3.exists() == false) goto L32;
        r1 = Uri.fromFile(r3);     // Catch: Throwable -> L34
    L32:
        Object r14 = Result.constructor-impl(r1);     // Catch: Throwable -> L34
    L37:
        if (Result.isSuccess-impl(r14) == false) goto L41;
        Uri r4 = (Uri) r14;
        if (r4 == null) goto L41;
        IBachDetectCenterAbility.a.d(r4);
    L41:
        Result.box-impl(r14);
    L34:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L43:
        if (Intrinsics.areEqual(this.$fromScene, "click_remove") == false) goto L46;
        nz9.b.f("-99999", CollectionsKt.listOf(new String[]{"creation_page/album_upload", "creation_page/re_upload", "upload", "creation_page/album_upload/video", "preprocess", "image_review"}), this.$resourceKey);
    L46:
        return Unit.INSTANCE;
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

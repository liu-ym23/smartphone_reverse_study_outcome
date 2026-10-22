package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3", f = "MultiAttachmentSelectorComponent.kt", i = {4, 4}, l = {1078, 1086, 1093, 1107, 1114}, m = "invokeSuspend", n = {"$this$launchSafely", "realLocalPath"}, s = {"L$0", "L$1"})
final class MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceItemBean $bean;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3(MultiAttachmentSelectorComponent r1, Uri r2, ResourceItemBean r3, String r4, Continuation<? super MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3> r5) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$bean = r3;
        this.$resourceKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3 r6 = new MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3(this.this$0, this.$uri, this.$bean, this.$resourceKey, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L12;
        if (r2 != 5) goto L11;
        String r3 = (String) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r25);
    L57:
        String r7 = r3;
    L58:
        CoroutineScopeKt.ensureActive(r4);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L62;
        FLogger.a.i("MultiAttachmentSelector", "[preCheckAndUploadVideo] network not available");
        final MultiAttachmentSelectorComponent r5 = this.this$0;
        final String r6 = this.$resourceKey;
        com.larus.utils.t0.e(new n3(r5, r6));
        MultiAttachmentSelectorComponent r8 = this.this$0;
        int r9 = MultiAttachmentSelectorComponent.Z;
        r8.T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", this.$bean.getKey());
        return Unit.INSTANCE;
    L62:
        CoroutineScopeKt.ensureActive(r4);
        MultiAttachmentSelectorComponent r10 = this.this$0;
        String r11 = this.$resourceKey;
        int r12 = MultiAttachmentSelectorComponent.Z;
        r10.E5(r11, "creation_page/album_upload/video");
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(r10), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$uploadVideo$1(r7, r10, r11, null), 2);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResourceItemBean r13 = (ResourceItemBean) this.L$0;
        ResultKt.throwOnFailure(r25);
    L51:
        nz9.b.e("creation_page/album_upload/video", "-101", r13.getKey());
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r25);
    L38:
        nz9.b.e("creation_page/album_upload/video", "-101", this.$bean.getKey());
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r25);
    L31:
        nz9.b.e("creation_page/album_upload/video", "-101", this.$bean.getKey());
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r25);
    L24:
        nz9.b.e("creation_page/album_upload/video", "-101", this.$bean.getKey());
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r25);
        r4 = (CoroutineScope) this.L$0;
        String r14 = vqc.d.d(this.this$0.getContext(), this.$uri);
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        PolarisFileWrapper r15 = new PolarisFileWrapper(r14);
        FLogger r16 = FLogger.a;
        r16.i("MultiAttachmentSelector", "[preCheckAndUploadVideo] localFileExists=" + r15.exists());
        if (r15.exists() == true) goto L26;
        MultiAttachmentSelectorComponent r17 = this.this$0;
        ResourceItemBean r18 = this.$bean;
        ic8.n0 r19 = new ic8.n0(null, ProcessFileResultCode.PREPARE_FILE_NOT_FOUND);
        this.label = 1;
        int r20 = MultiAttachmentSelectorComponent.Z;
        if (r17.U5(r18, r19, false, this) != r1) goto L24;
        return r1;
    L26:
        CoroutineScopeKt.ensureActive(r4);
        long r21 = r15.length();
        ImFileUtil.a.getClass();
        if (ImFileUtil.A(r21) == false) goto L33;
        MultiAttachmentSelectorComponent r22 = this.this$0;
        ResourceItemBean r23 = this.$bean;
        ic8.n0 r24 = new ic8.n0(null, ProcessFileResultCode.PREPARE_OVER_SIZE);
        this.label = 2;
        int r26 = MultiAttachmentSelectorComponent.Z;
        if (r22.U5(r23, r24, false, this) != r1) goto L31;
        return r1;
    L33:
        CoroutineScopeKt.ensureActive(r4);
        if (ImFileUtil.x(r21) == false) goto L40;
        MultiAttachmentSelectorComponent r27 = this.this$0;
        ResourceItemBean r28 = this.$bean;
        ic8.n0 r29 = new ic8.n0(null, ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE);
        this.label = 3;
        int r30 = MultiAttachmentSelectorComponent.Z;
        if (r27.U5(r28, r29, false, this) != r1) goto L38;
        return r1;
    L40:
        r7 = AlbumHelperKt.e(r14);
        r16.i("MultiAttachmentSelector", "[preCheckAndUploadVideo] copyToInternal=true");
        if (r7 != null) goto L43;
        r7 = r14;
    L43:
        CoroutineScopeKt.ensureActive(r4);
        mr9.e r31 = AlbumHelperKt.h(this.$uri, r15.getName(), r21, this.$bean.getKey());
        if (r31 == null) goto L58;
        MultiAttachmentSelectorComponent r32 = this.this$0;
        ResourceItemBean r33 = this.$bean;
        String r110 = this.$resourceKey;
        r16.i("MultiAttachmentSelector", "[preCheckAndUploadVideo] videoMetaReady=true");
        if (ImFileUtil.z(r31, true) == false) goto L53;
        ic8.n0 r34 = new ic8.n0(null, ProcessFileResultCode.PREPARE_OVER_META_LIMIT);
        this.L$0 = r33;
        this.label = 4;
        int r35 = MultiAttachmentSelectorComponent.Z;
        if (r32.U5(r33, r34, false, this) != r1) goto L50;
        return r1;
    L50:
        r13 = r33;
        goto L51
    L53:
        com.larus.bmhome.upload.h r36 = com.larus.bmhome.upload.h.a;
        com.larus.bmhome.upload.h.a(r110, r31, "preCheckAndUploadVideo");
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1 r111 = new MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1(r32, r33, r31, r7, r110, null);
        this.L$0 = r4;
        this.L$1 = r7;
        this.label = 5;
        if (BuildersKt.withContext(r37, r111, this) != r1) goto L56;
        return r1;
    L56:
        r3 = r7;
        goto L57
    }
}

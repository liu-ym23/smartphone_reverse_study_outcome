package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoModelResult;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {1611, 1620}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaAttachment $attachment;
    final /* synthetic */ boolean $isPrivate;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaAttachment $attachment;
        final /* synthetic */ String $coverUri;
        final /* synthetic */ String $coverUrl;
        final /* synthetic */ String $downloadUrl;
        final /* synthetic */ String $resourceKey;
        final /* synthetic */ String $videoModel;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, String r2, MediaAttachment r3, String r4, String r5, String r6, String r7, Continuation<? super AnonymousClass1> r8) {
            this.this$0 = r1;
            this.$resourceKey = r2;
            this.$attachment = r3;
            this.$coverUrl = r4;
            this.$coverUri = r5;
            this.$videoModel = r6;
            this.$downloadUrl = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$resourceKey, this.$attachment, this.$coverUrl, this.$coverUri, this.$videoModel, this.$downloadUrl, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r49) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r49);
            ResourceItemBean r1 = this.this$0.y.get(this.$resourceKey);
            if (r1 != null) goto L8;
            this.this$0.N.setValue(new ry9.f(this.$resourceKey, 0, null, UIStatus.STATUS_DELETE, 6));
            return Unit.INSTANCE;
        L8:
            MutableLiveData<ry9.f> r2 = this.this$0.N;
            UIStatus r8 = UIStatus.STATUS_COMPRESS_SUCCESS;
            mt8.b r9 = r1.getVideo();
            if (r9 == null) goto L21;
            VideoUploadInfo r4 = this.$attachment.getVideoUploadInfo();
            if (r4 == null) goto L13;
            String r15 = r4.getVid();
        L14:
            String r16 = this.$attachment.getResourceId();
            mt8.b r5 = r1.getVideo();
            if (r5 == null) goto L19;
            Image r6 = r5.a;
            if (r6 == null) goto L19;
            String r23 = r6.localResPath;
        L20:
            mt8.b r7 = mt8.b.a(r9, new Image(this.$coverUri, null, new ImageObj(this.$coverUrl, 0, 0, null, null, 30, null), new ImageObj(this.$coverUrl, 0, 0, null, null, 30, null), null, r23, null, null, null, null, null, null, null, null, 16338, null), 0.0f, 0, 0, null, r15, r16, this.$videoModel, this.$downloadUrl, 30);
        L22:
            ResourceItemBean r10 = AlbumHelperKt.c(r1, null, r7, 1);
            MultiAttachmentSelectorComponent r3 = this.this$0;
            r3.y.put(this.$resourceKey, r10);
            r2.setValue(new ry9.f(this.$resourceKey, 0, r10, r8, 2));
            return Unit.INSTANCE;
        L19:
            r23 = null;
            goto L20
        L13:
            r15 = null;
            goto L14
        L21:
            r7 = null;
            goto L22
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5(MediaAttachment r1, boolean r2, MultiAttachmentSelectorComponent r3, String r4, Continuation<? super MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5> r5) {
        this.$attachment = r1;
        this.$isPrivate = r2;
        this.this$0 = r3;
        this.$resourceKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5(this.$attachment, this.$isPrivate, this.this$0, this.$resourceKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        String r4 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L65:
        final ry9.j.c r16 = new ry9.j.c(new ry9.i.b(this.$attachment));
        final MultiAttachmentSelectorComponent r2 = this.this$0;
        final String r5 = this.$resourceKey;
        final boolean r6 = this.$isPrivate;
        com.larus.utils.t0.e(new t3(r2, r5, r16, r6));
    L68:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L17:
        GetVideoModelResultItem r17 = (GetVideoModelResultItem) r15;
        if (r17 == null) goto L22;
        VideoUrlResult r7 = r17.getVideoUrlResult();
        if (r7 == null) goto L22;
        String r12 = r7.getVideoUrl();
    L23:
        if (r17 == null) goto L27;
        VideoModelResult r8 = r17.getVideoModelResult();
        if (r8 == null) goto L27;
        String r11 = r8.getVideoModel();
    L29:
        if (this.$isPrivate == false) goto L31;
        String r9 = "";
    L35:
        String r10 = r9;
    L38:
        if (this.$isPrivate == false) goto L44;
        VideoUploadInfo r18 = this.$attachment.getVideoUploadInfo();
        if (r18 == null) goto L48;
        com.larus.bmhome.actionbar.model.f2 r19 = r18.getCover();
        if (r19 == null) goto L48;
        r4 = r19.a;
    L48:
        String r13 = r4;
        if (r12 != null) goto L51;
    L54:
        boolean r14 = true;
    L55:
        if (r14 == true) goto L66;
        if (r11 != null) goto L58;
    L61:
        if (r3 == true) goto L66;
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        AnonymousClass1 r20 = new AnonymousClass1(this.this$0, this.$resourceKey, this.$attachment, r13, r10, r11, r12, null);
        this.label = 2;
        if (BuildersKt.withContext(r110, r20, this) != r0) goto L65;
        return r0;
    L58:
        if (StringsKt.isBlank(r11) == true) goto L61;
        r3 = false;
    L66:
        final MediaAttachment r111 = this.$attachment;
        final MultiAttachmentSelectorComponent r21 = this.this$0;
        final String r22 = this.$resourceKey;
        final boolean r23 = this.$isPrivate;
        com.larus.utils.t0.e(new u3(r111, r21, r22, r23));
        goto L68
    L51:
        if (StringsKt.isBlank(r12) == true) goto L54;
        r14 = false;
        goto L55
    L44:
        if (r17 == null) goto L48;
        VideoUrlResult r112 = r17.getVideoUrlResult();
        if (r112 == null) goto L48;
        r4 = r112.getPosterUrl();
        goto L48
    L31:
        if (r17 == null) goto L36;
        VideoUrlResult r24 = r17.getVideoUrlResult();
        if (r24 == null) goto L36;
        r9 = r24.getPosterUri();
    L36:
        r10 = null;
    L27:
        r11 = null;
    L22:
        r12 = null;
        goto L23
    L10:
        ResultKt.throwOnFailure(r15);
        ResourceCenter r25 = ResourceCenter.a;
        VideoUploadInfo r113 = this.$attachment.getVideoUploadInfo();
        if (r113 == null) goto L13;
        String r26 = r113.getVid();
    L14:
        this.label = 1;
        r15 = ResourceCenter.i(r25, null, r26, true, this, 1);
        if (r15 != r0) goto L17;
        return r0;
    L13:
        r26 = null;
        goto L14
    }
}

package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.network.bean.BizResponse;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
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
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$handleUploadSuccess$1", f = "ImageSelectorComponent.kt", i = {0}, l = {2104}, m = "invokeSuspend", n = {"skipReviewOnInstant"}, s = {"I$0"})
final class ImageSelectorComponent$handleUploadSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ mr9.l $result;
    int I$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$handleUploadSuccess$1(mr9.l r1, ImageSelectorComponent r2, String r3, Continuation<? super ImageSelectorComponent$handleUploadSuccess$1> r4) {
        this.$result = r1;
        this.this$0 = r2;
        this.$localFilePath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSelectorComponent$handleUploadSuccess$1(this.$result, this.this$0, this.$localFilePath, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r27);
        Object r8 = r27;
    L33:
        dm9.a r9 = (dm9.a) r8;
        int r4 = r3;
    L34:
        String r5 = this.this$0.C;
        if (r5 != null) goto L39;
        return Unit.INSTANCE;
    L39:
        if (Intrinsics.areEqual(r5, this.$localFilePath) == false) goto L85;
        if ((this.this$0.X3().getCurState().getValue() instanceof sy9.b.e) == false) goto L85;
        boolean r6 = r9 instanceof dm9.a.b;
        if (r6 == false) goto L58;
        dm9.a.b r10 = (dm9.a.b) r9;
        if (r10.a.isSuccess() == false) goto L58;
        ReviewUgcImageApi.c r11 = (ReviewUgcImageApi.c) r10.a.getData();
        if (r11 == null) goto L55;
        Integer r12 = r11.a();
        if (r12 == null) goto L55;
        if (r12.intValue() != 3) goto L55;
        boolean r13 = true;
    L56:
        if (r13 == false) goto L58;
        t19.s r7 = t19.s.a;
        Context r14 = this.this$0.getContext();
        r7.getClass();
        t19.s.s(r14, 2131908918);
        this.this$0.X3().V5(new sy9.b.a(this.this$0.h5()));
        this.this$0.m.setValue(ry9.j.b.b);
        this.this$0.v4(false, "review");
        nz9.b.e("image_review", "-103", null);
        nz9.b.e("creation_page/album_upload", "-103", null);
    L83:
        return Unit.INSTANCE;
    L55:
        r13 = false;
    L58:
        if (r4 != 0) goto L63;
        if (r6 == true) goto L63;
        if (NetworkUtils.isNetworkAvailable(this.this$0.getContext()) == true) goto L63;
        t19.s r15 = t19.s.a;
        Context r16 = this.this$0.getContext();
        r15.getClass();
        t19.s.s(r16, 2131908080);
        this.this$0.X3().V5(new sy9.b.C0075b(this.this$0.X3().getCurBitmap(), this.this$0.h5()));
        this.this$0.m.setValue(ry9.j.f.b);
        this.this$0.v4(false, "upload");
        nz9.b.e("image_review", "-103", null);
        nz9.b.e("creation_page/album_upload", "-103", null);
    L63:
        this.this$0.X3().V5(new sy9.b.c(this.this$0.X3().getCurBitmap(), this.this$0.h5()));
        ImageSelectorComponent r17 = this.this$0;
        r17.C = null;
        r17.D = null;
        r17.E = null;
        StateFlowImpl r18 = r17.m;
        String r19 = this.$result.a;
        mr9.d r110 = this.$result.d;
        long r111 = 0;
        if (r110 == null) goto L66;
        long r112 = r110.b;
    L67:
        Long r113 = Boxing.boxLong(r112);
        mr9.d r114 = this.$result.d;
        if (r114 == null) goto L70;
        r111 = r114.a;
    L70:
        ImageUploadInfo r115 = new ImageUploadInfo(r113, Boxing.boxLong(r111));
        String r20 = this.$localFilePath;
        ImageSelectorComponent r21 = this.this$0;
        MediaAttachment r116 = new MediaAttachment(null, r19, r115, null, r20, r21.J, this.$result.c, r21.L, null, null, null, null, 3848, null);
        if (r6 == false) goto L73;
        dm9.a.b r22 = (dm9.a.b) r9;
    L74:
        if (r22 == null) goto L80;
        BizResponse r23 = r22.a;
        if (r23 == null) goto L80;
        ReviewUgcImageApi.c r24 = (ReviewUgcImageApi.c) r23.getData();
        if (r24 == null) goto L80;
        Boolean r25 = r24.b();
    L81:
        r18.setValue(new ry9.j.c(new ry9.i.a(r116, r25)));
        this.this$0.V4();
        this.this$0.v4(true, null);
        nz9.b.e("image_review", "0", null);
        nz9.b.e("creation_page/album_upload", "0", null);
    L80:
        r25 = null;
        goto L81
    L73:
        r22 = null;
        goto L74
    L66:
        r112 = 0;
    L85:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        nz9.b.h("image_review", "creation_page/album_upload", null, null, 28);
        ResourceUploadInstantInfo r26 = this.$result.g;
        if (r26 == null) goto L11;
        boolean r28 = Intrinsics.areEqual(r26.getPreQueryHit(), Boxing.boxBoolean(true));
    L12:
        if (r28 == false) goto L18;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().a(), Boxing.boxBoolean(true)) == false) goto L18;
        ImageSelectorComponent r29 = this.this$0;
        Lazy<Long> r30 = ImageSelectorComponent.X;
        if ((r29.X3().getCurState().getValue() instanceof sy9.b.e) == false) goto L18;
        ImageSelectorView r31 = this.this$0.X3();
        Object r32 = this.this$0.X3().getCurState().getValue();
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.imageselector.UIState.Uploading");
        r31.V5(sy9.b.e.a((sy9.b.e) r32, false, true, 7));
    L18:
        ResourceUploadInstantInfo r33 = this.$result.g;
        if (r33 == null) goto L21;
        boolean r34 = Intrinsics.areEqual(r33.getPreQueryHit(), Boxing.boxBoolean(true));
    L22:
        if (r34 == false) goto L26;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().b(), Boxing.boxBoolean(true)) == false) goto L26;
        r4 = 1;
    L27:
        if (r4 == 0) goto L29;
        FLogger.a.i("ImageSelectorComponent", "[handleUploadSuccess] skip review on instant hit, tosKey=" + this.$result.a);
        r9 = null;
        goto L34
    L29:
        ReviewUgcImageApi.Companion r35 = ReviewUgcImageApi.a;
        ImageSelectorComponent$handleUploadSuccess$1$checkResult$1 r36 = new ImageSelectorComponent$handleUploadSuccess$1$checkResult$1(this.$result, null);
        this.I$0 = r4;
        this.label = 1;
        r35.getClass();
        r8 = ReviewUgcImageApi.Companion.a(r36, this);
        if (r8 != r1) goto L32;
        return r1;
    L32:
        r3 = r4;
    L26:
        r4 = 0;
        goto L27
    L21:
        r34 = false;
        goto L22
    L11:
        r28 = false;
        goto L12
    }
}

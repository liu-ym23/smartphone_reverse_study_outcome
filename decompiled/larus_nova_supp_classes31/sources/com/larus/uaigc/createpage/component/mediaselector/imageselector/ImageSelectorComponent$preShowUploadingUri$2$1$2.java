package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$preShowUploadingUri$2$1$2", f = "ImageSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$preShowUploadingUri$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ boolean $reportDecodeFailure;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$preShowUploadingUri$2$1$2(Bitmap r1, ImageSelectorComponent r2, boolean r3, Continuation<? super ImageSelectorComponent$preShowUploadingUri$2$1$2> r4) {
        this.$bitmap = r1;
        this.this$0 = r2;
        this.$reportDecodeFailure = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ImageSelectorComponent$preShowUploadingUri$2$1$2 r0 = new ImageSelectorComponent$preShowUploadingUri$2$1$2(this.$bitmap, this.this$0, this.$reportDecodeFailure, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        if (this.$bitmap == null) goto L7;
        ImageSelectorComponent r7 = this.this$0;
        Bitmap r0 = this.$bitmap;
        Lazy<Long> r1 = ImageSelectorComponent.X;
        ImageSelectorUploadPreviewHelper r8 = r7.h4();
        int r2 = ImageSelectorUploadPreviewHelper.d;
        r8.d(r0, null);
        boolean r9 = true;
    L12:
        return Boxing.boxBoolean(r9);
    L7:
        boolean r10 = this.$reportDecodeFailure;
        ImageSelectorComponent r3 = this.this$0;
        FLogger.a.e("ImageSelectorComponent", "onAlbumSelected, fetchDecodedImage failed");
        if (r10 == false) goto L10;
        Lazy<Long> r11 = ImageSelectorComponent.X;
        r3.v4(false, "upload");
    L10:
        r9 = false;
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

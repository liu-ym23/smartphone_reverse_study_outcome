package com.larus.avlink.gallery.view;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.avlink.model.DoraCallStateCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function2 {
    public /* synthetic */ t() {
    }

    public final Object invoke(Object r3, Object r4) {
        PipelineDraweeControllerBuilder r5 = (PipelineDraweeControllerBuilder) r3;
        Uri r6 = (Uri) r4;
        int r0 = AlbumVideoItemHolder.k;
        Intrinsics.checkNotNullParameter(r5, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r6, "it");
        r5.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r6).setLocalThumbnailPreviewsEnabled(true).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888).build()).setResizeOptions(new ResizeOptions(DoraCallStateCode.DORA_OB_USER_END, DoraCallStateCode.DORA_OB_USER_END)).build());
        return Unit.INSTANCE;
    }
}

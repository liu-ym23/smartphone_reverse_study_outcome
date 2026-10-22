package com.larus.bmhome.chat.layout.item;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k4 implements Function2 {
    public final /* synthetic */ l4 a;
    public final /* synthetic */ ImageDecodeOptions b;

    public /* synthetic */ k4(l4 r1, ImageDecodeOptions r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5, Object r6) {
        l4 r0 = this.a;
        ImageDecodeOptions r1 = this.b;
        PipelineDraweeControllerBuilder r7 = (PipelineDraweeControllerBuilder) r5;
        Uri r8 = (Uri) r6;
        Intrinsics.checkNotNullParameter(r7, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r8, "it");
        SimpleDraweeView r2 = r0.q;
        if (r2 == null) goto L5;
        DraweeController r3 = r2.getController();
    L6:
        r7.setOldController(r3);
        r7.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r8).setResizeOptions(new ResizeOptions(r0.u, r0.v)).setCacheChoice(ImageRequest.CacheChoice.SMALL).setImageDecodeOptions(r1).build());
        return Unit.INSTANCE;
    L5:
        r3 = null;
        goto L6
    }
}

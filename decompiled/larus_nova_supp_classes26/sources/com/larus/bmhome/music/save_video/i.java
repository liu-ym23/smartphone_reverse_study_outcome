package com.larus.bmhome.music.save_video;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements Function2<PipelineDraweeControllerBuilder, Uri, Unit> {
    public final /* synthetic */ MusicShareView a;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;

    public i(MusicShareView r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4, Object r5) {
        PipelineDraweeControllerBuilder r6 = (PipelineDraweeControllerBuilder) r4;
        Uri r7 = (Uri) r5;
        Intrinsics.checkNotNullParameter(r6, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r7, "it");
        r6.setOldController(this.a.a.e.getController());
        ImageRequestBuilder r8 = ImageRequestBuilder.newBuilderWithSource(r7);
        r8.setResizeOptions(new ResizeOptions(i5.p0(), i5.p0()));
        r6.setImageRequest(r8.build());
        r6.setControllerListener(new h(this.b));
        return Unit.INSTANCE;
    }
}

package com.larus.bmhome.music.save_video;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements Function2<PipelineDraweeControllerBuilder, Uri, Unit> {
    public final /* synthetic */ MusicDynamicShareView a;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;

    public e(MusicDynamicShareView r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3, Object r4) {
        PipelineDraweeControllerBuilder r5 = (PipelineDraweeControllerBuilder) r3;
        Uri r6 = (Uri) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r6, "it");
        r5.setOldController(this.a.a.b.getController());
        ImageRequestBuilder r7 = ImageRequestBuilder.newBuilderWithSource(r6);
        int r0 = c7.b(248);
        r7.setResizeOptions(new ResizeOptions(r0, r0));
        r5.setImageRequest(r7.build());
        r5.setControllerListener(new d(this.b));
        return Unit.INSTANCE;
    }
}

package com.larus.bmhome.music.save_video;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements Function2<PipelineDraweeControllerBuilder, Uri, Unit> {
    public final /* synthetic */ MusicShareView a;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;

    public g(MusicShareView r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r2, Object r3) {
        PipelineDraweeControllerBuilder r4 = (PipelineDraweeControllerBuilder) r2;
        Uri r5 = (Uri) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r5, "it");
        r4.setOldController(this.a.a.b.getController());
        r4.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r5).build());
        r4.setControllerListener(new f(this.b));
        return Unit.INSTANCE;
    }
}

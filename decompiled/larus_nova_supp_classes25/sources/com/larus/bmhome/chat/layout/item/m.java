package com.larus.bmhome.chat.layout.item;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function2 {
    public final /* synthetic */ o a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ n c;

    public /* synthetic */ m(o r1, n r2) {
        this.a = r1;
        this.b = true;
        this.c = r2;
    }

    public final Object invoke(Object r6, Object r7) {
        o r0 = this.a;
        boolean r1 = this.b;
        n r2 = this.c;
        PipelineDraweeControllerBuilder r8 = (PipelineDraweeControllerBuilder) r6;
        Uri r9 = (Uri) r7;
        Intrinsics.checkNotNullParameter(r8, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r9, "it");
        ImageRequestBuilder r10 = ImageRequestBuilder.newBuilderWithSource(r9);
        if (r1 == false) goto L5;
        int r3 = r2.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971518, r2.getContext(), 2131167405));
        r10.setResizeOptions(new ResizeOptions(r3, r3));
    L5:
        r8.setImageRequest(r10.build());
        r8.setAutoPlayAnimations(true);
        r8.setControllerListener(r0);
        return Unit.INSTANCE;
    }
}

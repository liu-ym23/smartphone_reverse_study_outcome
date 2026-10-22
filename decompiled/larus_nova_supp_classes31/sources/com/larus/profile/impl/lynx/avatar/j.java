package com.larus.profile.impl.lynx.avatar;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Function2 {
    public /* synthetic */ j() {
    }

    public final Object invoke(Object r2, Object r3) {
        PipelineDraweeControllerBuilder r4 = (PipelineDraweeControllerBuilder) r2;
        Uri r5 = (Uri) r3;
        int r0 = ProfileAvatarLynxUI.m;
        Intrinsics.checkNotNullParameter(r4, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r5, "it");
        r4.setImageRequest(ImageRequestBuilder.newBuilderWithSource(r5).disableDiskCache().disableMemoryCache().build());
        return Unit.INSTANCE;
    }
}

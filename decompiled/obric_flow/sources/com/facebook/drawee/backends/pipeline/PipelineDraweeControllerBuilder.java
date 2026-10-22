package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImagePipeline f7735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PipelineDraweeControllerFactory f7736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageOriginListener f7737n;

    public PipelineDraweeControllerBuilder(Context r5, PipelineDraweeControllerFactory r10, ImagePipeline r11) {
        super(r5);
        this.f7735l = r11;
        this.f7736m = r10;
        r10.getClass();
    }
}

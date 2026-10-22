package com.facebook.drawee.view;

import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.SizeReadyCallback;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class LazySizeAttach implements SizeReadyCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageRequestBuilder f7942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractDraweeControllerBuilder f7943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f7944c;

    public LazySizeAttach(ImageRequestBuilder r5, AbstractDraweeControllerBuilder r10, SimpleDraweeView r11) {
        this.f7942a = r5;
        this.f7943b = r10;
        this.f7944c = r11;
    }
}

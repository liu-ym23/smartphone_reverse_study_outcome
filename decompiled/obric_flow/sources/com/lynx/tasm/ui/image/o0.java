package com.lynx.tasm.ui.image;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends l0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImagePipeline f11086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DrawableFactory f11087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u0 f11088k;

    public o0(DrawableFactory r5) {
        this.f11078a = null;
        this.f11079b = null;
        this.f11080c = null;
        this.d = false;
        this.f11086i = Fresco.a().e();
        this.f11087j = r5;
    }
}

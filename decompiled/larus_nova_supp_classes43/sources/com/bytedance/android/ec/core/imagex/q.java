package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface q {
    boolean a();

    SlcPipelineDraweeControllerBuilder b();

    void c(com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r1);

    void d(Drawable r1, ScalingUtils.ScaleType r10);

    Context getContext();

    com.bytedance.android.ecom.arch.slice.render.widget.fresco.h getController();
}

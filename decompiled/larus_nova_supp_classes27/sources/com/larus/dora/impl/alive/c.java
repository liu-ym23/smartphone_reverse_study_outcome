package com.larus.dora.impl.alive;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.dora.impl.databinding.LarusDoraKeepAliveItemLayoutBinding;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ LarusDoraKeepAliveItemLayoutBinding a;
    public final /* synthetic */ float b;

    public c(LarusDoraKeepAliveItemLayoutBinding r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r3, Throwable r4) {
        super.onFailure(r3, r4);
        g49.d.c("DoraKeepAliveAdapter", "onFailure: " + r3, r4);
        SimpleDraweeView r5 = this.a.b;
        GradientDrawable r6 = new GradientDrawable();
        r6.setCornerRadius(this.b);
        int r0 = j0.a;
        r6.setColor(j0.a(2131102535));
        r5.setBackground(r6);
        e1.x(this.a.c);
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        g49.d.d("DoraKeepAliveAdapter", "onFinalImageSet: " + r2 + ", " + ((ImageInfo) r3));
    }
}

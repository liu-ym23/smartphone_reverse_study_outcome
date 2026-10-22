package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.common.ResizeOptions;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y0 implements q {
    public final /* synthetic */ SlcImageFetchManager a;

    @Override // com.bytedance.android.ec.core.imagex.q
    public final boolean a() {
        return this.a.h;
    }

    @Override // com.bytedance.android.ec.core.imagex.q
    public final SlcPipelineDraweeControllerBuilder b() {
        Lazy r0 = this.a.r;
        KProperty r1 = SlcImageFetchManager.t[0];
        return (SlcPipelineDraweeControllerBuilder) r0.getValue();
    }

    public final ResizeOptions e() {
        com.bytedance.android.ecom.arch.slice.render.m r0 = this.a.o;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a > 0) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return null;
    L15:
        return new ResizeOptions(r0.a, r0.b);
    L7:
        if (r0.b <= 0) goto L9;
        r10 = true;
        goto L10
    }

    @Override // com.bytedance.android.ec.core.imagex.q
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // com.bytedance.android.ec.core.imagex.q
    public final com.bytedance.android.ecom.arch.slice.render.widget.fresco.h getController() {
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c r0 = this.a.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public y0(SlcImageFetchManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ec.core.imagex.q
    public final void c(com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        this.a.l(r10);
    }

    @Override // com.bytedance.android.ec.core.imagex.q
    public final void d(Drawable r10, ScalingUtils.ScaleType r11) {
        Intrinsics.checkNotNullParameter(r11, "scaleType");
        GenericDraweeHierarchy r0 = this.a.f();
        if (r0 == null) goto L6;
        r0.setPlaceholderImage(r10, r11);
        return;
    }
}

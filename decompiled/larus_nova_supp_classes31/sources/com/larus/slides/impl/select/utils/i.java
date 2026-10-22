package com.larus.slides.impl.select.utils;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        Function1<Boolean, Unit> r3 = this.a;
        if (r3 == null) goto L6;
        r3.invoke(Boolean.FALSE);
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        Function1<Boolean, Unit> r4 = this.a;
        if (r4 == null) goto L6;
        r4.invoke(Boolean.TRUE);
        return;
    }
}

package com.bytedance.android.ec.core.utils;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class r0 extends q0 {
    public Function1<? super ImageInfo, Unit> a;

    public r0() {
    }

    public final void onFinalImageSet(String r1, Object r10, Animatable r11) {
        ImageInfo r12 = (ImageInfo) r10;
        Function1<? super ImageInfo, Unit> r13 = this.a;
        if (r13 == null) goto L6;
        Unit r14 = (Unit) r13.invoke(r12);
        return;
    }
}

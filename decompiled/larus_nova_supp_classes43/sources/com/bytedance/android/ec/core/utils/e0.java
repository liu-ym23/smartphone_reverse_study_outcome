package com.bytedance.android.ec.core.utils;

import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 extends r0 {
    public e0() {
    }

    public final void onIntermediateImageSet(String r1, Object r10) {
        ImageInfo r11 = (ImageInfo) r10;
        Function1<? super ImageInfo, Unit> r12 = this.a;
        if (r12 == null) goto L6;
        Unit r13 = (Unit) r12.invoke(r11);
        return;
    }
}

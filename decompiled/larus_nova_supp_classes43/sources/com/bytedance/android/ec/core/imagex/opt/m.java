package com.bytedance.android.ec.core.imagex.opt;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends ImageDecodeBitmapConfigStrategy {
    public final /* synthetic */ ImageDecodeBitmapConfigStrategy a;

    public m(ImageDecodeBitmapConfigStrategy r1) {
        this.a = r1;
    }

    public final Bitmap.Config getBitmapConfig(String r11, int r12, int r13, int r14, int r15, boolean r16, ImageFormat r17) {
        boolean r1 = false;
        Uri r10 = UriProtector.parse(r11);     // Catch: Exception -> L8
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "from_ec_image_loaded"), "1") == false) goto L9;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "ec_rgb565"), "1") == false) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L12;
        return ImageDecodeBitmapConfigStrategy.MEMORY_AT_LEAST.getBitmapConfig(r11, r12, r13, r14, r15, r16, r17);
    L12:
        return this.a.getBitmapConfig(r11, r12, r13, r14, r15, r16, r17);
    }
}

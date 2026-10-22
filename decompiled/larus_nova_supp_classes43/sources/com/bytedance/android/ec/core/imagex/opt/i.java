package com.bytedance.android.ec.core.imagex.opt;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {

    public static final class a implements ResourceReleaser<CloseableImage> {
        public final CloseableReference<Bitmap> a;
        public final /* synthetic */ CloseableStaticBitmap b;

        public a(CloseableStaticBitmap r1) {
            this.b = r1;
            this.a = r1.cloneUnderlyingBitmapReference();
        }

        public final void release(Object r1) {
            CloseableImage r10 = (CloseableImage) r1;
            CloseableReference<Bitmap> r11 = this.a;
            if (r11 == null) goto L6;
            r11.close();
            return;
        }
    }

    public static final boolean a(CloseableStaticBitmap r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$reuseValid");
        if (r1.isClosed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isThumbCache() == true) goto L7;
        return true;
    }

    public static final CloseableReference<CloseableImage> b(CloseableStaticBitmap r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toCloseableReference");
        return CloseableReference.of(r1, new a(r1));
    }
}

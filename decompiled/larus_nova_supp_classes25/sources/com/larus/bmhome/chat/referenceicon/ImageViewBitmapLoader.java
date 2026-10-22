package com.larus.bmhome.chat.referenceicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImageViewBitmapLoader {
    public static final /* synthetic */ int a = 0;

    public static final class a extends ImageView {
        public final boolean a;
        public Function1<? super Bitmap, Unit> b;

        @Override // android.widget.ImageView
        public final void setImageBitmap(Bitmap r3) {
            super.setImageBitmap(r3);
            if (r3 != null) goto L5;
            return;
        L5:
            Function1<? super Bitmap, Unit> r0 = this.b;
            if (r0 != null) goto L8;
            return;
        L8:
            this.b = null;
            r0.invoke(r3);
        }

        @Override // android.widget.ImageView
        public final void setImageDrawable(Drawable r10) {
            super.setImageDrawable(r10);
            if (this.a == true) goto L5;
            return;
        L5:
            Function1<? super Bitmap, Unit> r0 = this.b;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r10 != null) goto L10;
            return;
        L10:
            Resources r2 = getResources();
            int r5 = RangesKt.coerceAtLeast((int) (24 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density), 1);
            Bitmap r11 = DrawableKt.toBitmap$default(r10, r5, r5, null, 4, null);
            this.b = null;
            r0.invoke(r11);
        }

        public a(Context r2, boolean r3, ImageViewBitmapLoader$load$2.b r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = r3;
            this.b = r4;
        }
    }

    static {
    }

    public static Object a(Context r2, boolean r3, Function1 r4, Continuation r5) {
        return TimeoutKt.c(10000, new ImageViewBitmapLoader$load$2(r2, r3, r4, null), r5);
    }
}

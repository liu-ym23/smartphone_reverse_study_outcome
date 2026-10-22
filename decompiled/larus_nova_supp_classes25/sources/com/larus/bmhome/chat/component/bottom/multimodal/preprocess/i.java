package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Bitmap.CompressFormat.values().length];
            r0[Bitmap.CompressFormat.JPEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Bitmap.CompressFormat.PNG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Bitmap.CompressFormat.WEBP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Bitmap.CompressFormat.WEBP_LOSSLESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Bitmap.CompressFormat.WEBP_LOSSY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final String a(Bitmap.CompressFormat r10) {
        int r9 = -1;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r10 == null) goto L7;
        r9 = a.a[r10.ordinal()];
    L7:
        if (r9 == 1) goto L25;
        if (r9 == 2) goto L27;
        if (r9 == 3) goto L26;
        if (r9 == 4) goto L26;
        if (r9 == 5) goto L26;
        return "jpeg";
    L26:
        return "webp";
    L27:
        return "png";
    L25:
        return "jpg";
    L15:
        if (r10 == null) goto L18;
        r9 = a.a[r10.ordinal()];
    L18:
        if (r9 == 1) goto L25;
        if (r9 == 2) goto L27;
        if (r9 == 3) goto L26;
        return "jpeg";
    }

    public static final int b(Bitmap.CompressFormat r3, int r4, boolean r5) {
        int r6 = RangesKt.coerceIn(r4, 0, 100);
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L10:
        return r6;
    L5:
        if (Intrinsics.areEqual(a(r3), "webp") == false) goto L10;
        if (r6 != 100) goto L10;
        if (r5 == true) goto L10;
        return 99;
    }
}

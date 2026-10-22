package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.content.res.Resources;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Size(width=" + this.a + ", height=" + this.b + ", clamped=" + this.c + ')';
        }

        public a(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public static a a(Context r10, int r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "source");
        if (r11 <= 1) goto L32;
        if (r12 <= 1) goto L32;
        Resources r1 = r10.getResources();
        int r2 = Math.min(WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).widthPixels, UIUtils.dp2px(r10, 680.0f));
        int r3 = UIUtils.dp2px(r10, 240.0f);
        if (r11 != 0) goto L9;
    L15:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L19;
        int[] r5 = {UIUtils.dp2px(r10, 150.0f), r3};
    L24:
        int r14 = RangesKt.coerceAtLeast(r5[0], 1);
        int r6 = RangesKt.coerceAtLeast(r5[1], 1);
        if (r14 != r11) goto L29;
        if (r6 != r12) goto L29;
        return new a(r11, r12, false);
    L29:
        Log.w("MovableAttachmentImageSizeGuard", "movable attachment image size clamped, source=" + r13 + ", width=" + r11 + ", height=" + r12 + ", clampedWidth=" + r14 + ", clampedHeight=" + r6 + ", maxWidth=" + r2 + ", maxHeight=" + r3);
        return new a(r14, r6, true);
    L19:
        if (r11 > r2) goto L23;
        if (r12 > r3) goto L23;
        r5 = new int[]{r11, r12};
    L23:
        r5 = ImageUtils.g(r11, r12, r2, r3, 1, 1);
        goto L24
    L9:
        if ((r12 / r11) < 3) goto L15;
        if (r11 <= UIUtils.dp2px(r10, 200.0f)) goto L15;
        if (r2 <= UIUtils.dp2px(r10, 150.0f)) goto L15;
        r4 = true;
    L32:
        return new a(RangesKt.coerceAtLeast(r11, 1), RangesKt.coerceAtLeast(r12, 1), true);
    }
}

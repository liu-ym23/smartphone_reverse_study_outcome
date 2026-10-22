package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12401b;

    public b(int r5, int r10) {
        this.f12400a = r5;
        this.f12401b = r10;
    }

    public static b[] a(b[] r5, int r10) {
        if (r5.length != r10) goto L5;
        return r5;
    L5:
        b[] r11 = (b[]) Arrays.copyOf(r5, r10);
        int r12 = r5.length;
    L6:
        if (r12 >= r10) goto L8;
        r11[r12] = new b(0, BlendMode.mapToLegacyObricBlend(BlendMode.SRC_OVER));
        r12 = r12 + 1;
        goto L6
    L8:
        return r11;
    }

    public final String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.f12400a), Integer.valueOf(this.f12401b)});
    }
}

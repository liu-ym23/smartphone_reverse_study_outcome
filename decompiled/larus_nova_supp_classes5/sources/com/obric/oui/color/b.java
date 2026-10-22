package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final b c = null;
    public final int a;
    public final int b;

    static {
        c = new b(0, BlendMode.SRC_OVER);
    }

    public final String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    public b(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public b(int r1, BlendMode r2) {
        this(r1, BlendMode.mapToLegacyObricBlend(r2));
    }
}

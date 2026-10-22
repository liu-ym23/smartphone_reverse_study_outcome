package com.obric.oui.color;

import androidx.core.graphics.ColorUtils;
import com.obric.oui.graphic.BlendMode;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13475b;
    private final BlendMode c;

    public f(float r1, int r2, BlendMode r3) {
        this.f13474a = r1;
        this.f13475b = r2;
        this.c = r3;
    }

    public static f a(f r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new f(r3.f13474a, r3.f13475b, r3.c);
    }

    public static f a(f r2, f r3, float r4) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L6;
        return r2;
    L6:
        float r5 = Math.max(0.0f, Math.min(1.0f, r4));
        if (r5 > 0.0f) goto L10;
        return r2;
    L10:
        if (r5 < 1.0f) goto L12;
        return r3;
    L12:
        float r0 = r2.f13474a;
        return new f(r0 + ((r3.f13474a - r0) * r5), ColorUtils.blendARGB(r2.f13475b, r3.f13475b, r5), r2.c);
    }

    public float a() {
        return this.f13474a;
    }

    public int b() {
        return this.f13475b;
    }

    public BlendMode c() {
        return this.c;
    }

    public f d() {
        return a(this);
    }
}

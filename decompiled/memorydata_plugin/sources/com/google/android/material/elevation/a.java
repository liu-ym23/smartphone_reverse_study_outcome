package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.b;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3902a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3903b;
    private final int c;
    private final int d;
    private final int e;
    private final float f;

    static {
        f3902a = (int) Math.round(5.1000000000000005d);
    }

    public a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        this(b.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayEnabled, "attr", "elevationOverlayEnabled"), false), com.google.android.material.c.a.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayColor, "attr", "elevationOverlayColor"), 0), com.google.android.material.c.a.a(r12, ZeusTransformUtils.mapRes(R.attr.elevationOverlayAccentColor, "attr", "elevationOverlayAccentColor"), 0), com.google.android.material.c.a.a(r12, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), 0), ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public a(boolean r1, int r2, int r3, int r4, float r5) {
        this.f3903b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }

    private boolean a(int r2) {
        if (ColorUtils.setAlphaComponent(r2, 255) != this.e) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(float r2) {
        return a(this.e, r2);
    }

    public int a(int r2, float r3) {
        if (this.f3903b == true) goto L5;
    L8:
        return r2;
    L5:
        if (a(r2) == false) goto L8;
        return b(r2, r3);
    }

    public boolean a() {
        return this.f3903b;
    }

    public float b(float r3) {
        float r2 = this.f;
        if (r2 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r3 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r3 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int r3, float r4) {
        float r5 = b(r4);
        int r0 = Color.alpha(r3);
        int r6 = com.google.android.material.c.a.a(ColorUtils.setAlphaComponent(r3, 255), this.c, r5);
        if (r5 <= 0.0f) goto L8;
        int r2 = this.d;
        if (r2 == 0) goto L8;
        r6 = com.google.android.material.c.a.a(r6, ColorUtils.setAlphaComponent(r2, f3902a));
    L8:
        return ColorUtils.setAlphaComponent(r6, r0);
    }
}

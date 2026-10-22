package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Path;
import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public Rect a;
    public int b;
    public float[] c;
    public float d;
    public float e;
    public String f;
    public Path g;
    public Integer h;
    public boolean i;

    public final String toString() {
        return "mRegion=" + this.a + ", mRotation=" + this.b + ", crop=" + Arrays.toString(this.c) + ", scaleX=" + this.d + ", scaleY=" + this.e + ", svgPath=" + this.f + ", ssivTileBackgroundColor=" + this.h + ", applyWhiteBgTransformation=" + this.i;
    }

    public b() {
        this.c = new float[0];
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = "";
        this.i = true;
    }
}

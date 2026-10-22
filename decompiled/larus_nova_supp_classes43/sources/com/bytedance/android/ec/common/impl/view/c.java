package com.bytedance.android.ec.common.impl.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public int a;
    public int b;
    public int c;
    public int d;
    public final RectF e;
    public final float[] f;
    public final Path g;
    public final Paint h;
    public final PorterDuffXfermode i;
    public final b j;

    public c(b r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.j = r10;
        this.e = new RectF();
        this.f = new float[8];
        this.g = new Path();
        this.h = new Paint(1);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}

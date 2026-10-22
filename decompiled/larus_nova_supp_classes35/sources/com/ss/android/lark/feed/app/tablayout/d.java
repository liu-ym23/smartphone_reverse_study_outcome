package com.ss.android.lark.feed.app.tablayout;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class d extends a {
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public final float[] g;
    public int[] h;
    public final float i;
    public final float j;
    public final float k;
    public final GradientDrawable.Orientation l;
    public Drawable m;

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable r0 = this.m;
        if (r0 == null) goto L7;
        int[] r1 = r0.getState();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return super.getState();
    }

    public d() {
        this.g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.i = 0.5f;
        this.j = 0.5f;
        this.k = 0.5f;
        this.l = GradientDrawable.Orientation.LEFT_RIGHT;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        Drawable r0 = this.m;
        if (r0 == null) goto L6;
        r0.setColorFilter(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        Drawable r0 = this.m;
        if (r0 == null) goto L6;
        return r0.setState(r2);
    L6:
        return super.setState(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r2) {
        super.setTintList(r2);
        Drawable r0 = this.m;
        if (r0 == null) goto L6;
        r0.setTintList(r2);
        return;
    }
}

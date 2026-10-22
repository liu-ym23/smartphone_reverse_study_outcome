package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.obric.oui.common.style.o;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f14368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14370c;
    public float d;
    public float e;
    public int f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f14374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f14375l;

    public f() {
        this.f14368a = new Paint();
        this.f14369b = 255;
        new Rect();
        this.f14373j = true;
        this.f14374k = 1.15f;
        this.f14375l = 0.85f;
    }

    public final void a(float r5) {
        if (this.f14371h != 0.0f) goto L5;
        this.f14371h = r5;
    L5:
        float r10 = this.f14372i;
        if (r10 == r5) goto L10;
        this.f14371h = r10;
        this.f14372i = r5;
        this.e = r5;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        float r5 = 0.0f + this.f14371h;
        float r10 = 2;
        float r12 = this.e;
        float r13 = (r5 / r10) - (r12 / r10);
        float r14 = this.f14370c;
        o.d(r14, r13, r14 + this.d, r13 + r12, this.g, r11, this.f14368a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f14369b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f14369b != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (r5 == this.f14369b) goto L6;
        this.f14369b = r5;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

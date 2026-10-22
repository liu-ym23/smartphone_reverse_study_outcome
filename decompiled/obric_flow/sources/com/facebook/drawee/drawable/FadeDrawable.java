package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class FadeDrawable extends ArrayDrawable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable[] f7838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7841l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f7842m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f7843n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7844o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean[] f7845p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7846q;

    public FadeDrawable(Drawable[] r10) {
        super(r10);
        if (r10.length < 1) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        this.f7838i = r10;
        int[] r11 = new int[r10.length];
        this.f7842m = r11;
        int[] r12 = new int[r10.length];
        this.f7843n = r12;
        this.f7844o = 255;
        boolean[] r13 = new boolean[r10.length];
        this.f7845p = r13;
        this.f7846q = 0;
        this.f7839j = 2;
        Arrays.fill(r11, 0);
        r11[0] = 255;
        Arrays.fill(r12, 0);
        r12[0] = 255;
        Arrays.fill(r13, false);
        r13[0] = true;
        return;
    L10:
        throw new IllegalStateException("At least one layer required!");
    L5:
        r5 = false;
        goto L6
    }

    public final void a() {
        int r5 = this.f7846q - 1;
        this.f7846q = r5;
        if (r5 != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    public final void b() {
        this.f7839j = 0;
        Arrays.fill(this.f7845p, true);
        if (this.f7846q != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    public final void c(int r5) {
        this.f7839j = 0;
        this.f7845p[r5] = true;
        if (this.f7846q != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    public final void d(int r5) {
        this.f7839j = 0;
        this.f7845p[r5] = false;
        if (this.f7846q != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        int r5 = this.f7839j;
        int r11 = 0;
        int r12 = 2;
        if (r5 == 0) goto L15;
        if (r5 == 1) goto L7;
        boolean r13 = true;
    L24:
        Drawable[] r14 = this.f7838i;
        if (r11 >= r14.length) goto L31;
        Drawable r15 = r14[r11];
        int r16 = (this.f7843n[r11] * this.f7844o) / 255;
        if (r15 == null) goto L30;
        if (r16 <= 0) goto L30;
        this.f7846q++;
        r15.mutate().setAlpha(r16);
        this.f7846q--;
        r15.draw(r10);
    L30:
        r11 = r11 + 1;
        goto L24
    L31:
        if (r13 == false) goto L33;
        return;
    L33:
        if (this.f7846q != 0) goto L42;
        super.invalidateSelf();
        return;
    L42:
        return;
    L7:
        if (this.f7840k <= 0) goto L14;
        r13 = a((SystemClock.uptimeMillis() - this.f7841l) / this.f7840k);
        if (r13 == true) goto L12;
        r12 = 1;
    L12:
        this.f7839j = r12;
        goto L24
    L14:
        throw new IllegalStateException();
    L15:
        System.arraycopy(this.f7843n, 0, this.f7842m, 0, this.f7838i.length);
        this.f7841l = SystemClock.uptimeMillis();
        if (this.f7840k != 0) goto L18;
        float r17 = 1.0f;
    L19:
        r13 = a(r17);
        if (r13 == true) goto L23;
        r12 = 1;
    L23:
        this.f7839j = r12;
        goto L24
    L18:
        r17 = 0.0f;
        goto L19
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7844o;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        if (this.f7846q != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (this.f7844o == r5) goto L8;
        this.f7844o = r5;
        if (this.f7846q != 0) goto L9;
        super.invalidateSelf();
        return;
    L9:
        return;
    }

    public final boolean a(float r10) {
        boolean r5 = true;
        int r11 = 0;
    L4:
        if (r11 >= this.f7838i.length) goto L24;
        boolean r12 = this.f7845p[r11];
        if (r12 == false) goto L8;
        int r13 = 1;
    L9:
        int[] r14 = this.f7843n;
        int r15 = (int) (((r13 * 255) * r10) + this.f7842m[r11]);
        r14[r11] = r15;
        if (r15 >= 0) goto L13;
        r14[r11] = 0;
    L13:
        if (r14[r11] <= 255) goto L15;
        r14[r11] = 255;
    L15:
        if (r12 == true) goto L17;
    L19:
        if (r12 == true) goto L23;
        if (r14[r11] <= 0) goto L23;
        r5 = false;
    L23:
        r11 = r11 + 1;
        goto L4
    L17:
        if (r14[r11] >= 255) goto L19;
        r5 = false;
        goto L19
    L8:
        r13 = -1;
        goto L9
    L24:
        return r5;
    }

    public final void c() {
        this.f7839j = 2;
        int r5 = 0;
    L4:
        if (r5 >= this.f7838i.length) goto L11;
        int[] r10 = this.f7843n;
        if (this.f7845p[r5] == false) goto L8;
        int r11 = 255;
    L9:
        r10[r5] = r11;
        r5 = r5 + 1;
        goto L4
    L8:
        r11 = 0;
        goto L9
    L11:
        if (this.f7846q != 0) goto L17;
        super.invalidateSelf();
        return;
    }
}

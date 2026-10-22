package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Px
    public int f3521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Px
    public int f3522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public int[] f3523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f3524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3526f;

    protected b(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        this.f3523c = new int[0];
        int r14 = r10.getResources().getDimensionPixelSize(q5.d.mtrl_progress_track_thickness);
        TypedArray r15 = k.h(r10, r11, l.BaseProgressIndicator, r12, r13, new int[0]);
        this.f3521a = com.google.android.material.resources.c.d(r10, r15, l.BaseProgressIndicator_trackThickness, r14);
        this.f3522b = Math.min(com.google.android.material.resources.c.d(r10, r15, l.BaseProgressIndicator_trackCornerRadius, 0), this.f3521a / 2);
        this.f3525e = r15.getInt(l.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f3526f = r15.getInt(l.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(r10, r15);
        d(r10, r15);
        r15.recycle();
    }

    private void c(@NonNull Context r10, @NonNull TypedArray r11) {
        int r12 = l.BaseProgressIndicator_indicatorColor;
        if (r11.hasValue(r12) == true) goto L7;
        this.f3523c = new int[]{t5.a.b(r10, q5.b.colorPrimary, -1)};
        return;
    L7:
        if (r11.peekValue(r12).type == 1) goto L10;
        this.f3523c = new int[]{r11.getColor(r12, -1)};
        return;
    L10:
        int[] r13 = r10.getResources().getIntArray(r11.getResourceId(r12, -1));
        this.f3523c = r13;
        if (r13.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void d(@NonNull Context r10, @NonNull TypedArray r11) {
        int r12 = l.BaseProgressIndicator_trackColor;
        if (r11.hasValue(r12) == false) goto L7;
        int r13 = r11.getColor(r12, -1);
    L5:
        this.f3524d = r13;
        return;
    L7:
        this.f3524d = this.f3523c[0];
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float r15 = r14.getFloat(0, 0.2f);
        r14.recycle();
        r13 = t5.a.a(this.f3524d, (int) (r15 * 255.0f));
        goto L5
    }

    public boolean a() {
        if (this.f3526f == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.f3525e == 0) goto L5;
        return true;
    L5:
        return false;
    }

    abstract void e();
}

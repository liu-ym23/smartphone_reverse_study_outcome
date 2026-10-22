package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

/* JADX INFO: loaded from: classes.dex */
abstract class e<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    S f3546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DrawableWithAnimatedVisibilityChange f3547b;

    public e(S r10) {
        this.f3546a = r10;
    }

    abstract void a(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11);

    abstract void b(@NonNull Canvas r10, @NonNull Paint r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @ColorInt int r14);

    abstract void c(@NonNull Canvas r10, @NonNull Paint r11);

    abstract int d();

    abstract int e();

    protected void f(@NonNull DrawableWithAnimatedVisibilityChange r10) {
        this.f3547b = r10;
    }

    void g(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.f3546a.e();
        a(r10, r11);
    }
}

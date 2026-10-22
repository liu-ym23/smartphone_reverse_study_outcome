package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.c;

/* JADX INFO: loaded from: classes2.dex */
abstract class f<S extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    S f4016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DrawableWithAnimatedVisibilityChange f4017b;

    public f(S r1) {
        this.f4016a = r1;
    }

    abstract int a();

    abstract void a(Canvas r1, float r2);

    abstract void a(Canvas r1, Paint r2);

    abstract void a(Canvas r1, Paint r2, float r3, float r4, int r5);

    public void a(DrawableWithAnimatedVisibilityChange r1) {
        this.f4017b = r1;
    }

    abstract int b();

    void b(Canvas r2, float r3) {
        this.f4016a.c();
        a(r2, r3);
    }
}

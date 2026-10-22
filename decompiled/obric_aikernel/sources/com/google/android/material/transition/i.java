package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f4164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f4165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f4166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.shape.m f4167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.shape.l f4168e;

    i() {
        this.f4164a = new Path();
        this.f4165b = new Path();
        this.f4166c = new Path();
        this.f4167d = com.google.android.material.shape.m.k();
    }

    void a(Canvas r10) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r10.clipPath(this.f4164a);
        return;
    L5:
        r10.clipPath(this.f4165b);
        r10.clipPath(this.f4166c, Region.Op.UNION);
    }

    void b(float r10, com.google.android.material.shape.l r11, com.google.android.material.shape.l r12, RectF r13, RectF r14, RectF r15, MaterialContainerTransform.b r16) {
        com.google.android.material.shape.l r17 = l.n(r11, r12, r13, r15, r16.d(), r16.c(), r10);
        this.f4168e = r17;
        this.f4167d.d(r17, 1.0f, r14, this.f4165b);
        this.f4167d.d(this.f4168e, 1.0f, r15, this.f4166c);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.f4164a.op(this.f4165b, this.f4166c, Path.Op.UNION);
        return;
    }

    com.google.android.material.shape.l c() {
        return this.f4168e;
    }

    Path d() {
        return this.f4164a;
    }
}

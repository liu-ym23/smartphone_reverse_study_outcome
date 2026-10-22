package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f4258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f4259b;
    private final Path c;
    private final com.google.android.material.shape.m d;
    private com.google.android.material.shape.l e;

    i() {
        this.f4258a = new Path();
        this.f4259b = new Path();
        this.c = new Path();
        this.d = com.google.android.material.shape.m.a();
    }

    Path a() {
        return this.f4258a;
    }

    void a(float r8, com.google.android.material.shape.l r9, com.google.android.material.shape.l r10, RectF r11, RectF r12, RectF r13, MaterialContainerTransform.a r14) {
        com.google.android.material.shape.l r15 = l.a(r9, r10, r11, r13, r14.a(), r14.b(), r8);
        this.e = r15;
        this.d.a(r15, 1.0f, r12, this.f4259b);
        this.d.a(this.e, 1.0f, r13, this.c);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.f4258a.op(this.f4259b, this.c, Path.Op.UNION);
        return;
    }

    void a(Canvas r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.clipPath(this.f4258a);
        return;
    L5:
        r3.clipPath(this.f4259b);
        r3.clipPath(this.c, Region.Op.UNION);
    }

    com.google.android.material.shape.l b() {
        return this.e;
    }
}

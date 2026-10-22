package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes2.dex */
abstract class g<T extends Animator> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected IndeterminateDrawable f4018b;
    protected final float[] c;
    protected final int[] d;

    public g(int r2) {
        this.c = new float[r2 * 2];
        this.d = new int[r2];
    }

    public float a(int r1, int r2, int r3) {
        return (r1 - r2) / r3;
    }

    abstract void a();

    public abstract void a(Animatable2Compat.AnimationCallback r1);

    public void a(IndeterminateDrawable r1) {
        this.f4018b = r1;
    }

    abstract void b();

    abstract void c();

    public abstract void d();

    public abstract void e();
}

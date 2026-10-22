package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes.dex */
abstract class f<T extends Animator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected IndeterminateDrawable f3548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final float[] f3549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f3550c;

    protected f(int r10) {
        this.f3549b = new float[r10 * 2];
        this.f3550c = new int[r10];
    }

    abstract void a();

    protected float b(int r10, int r11, int r12) {
        return (r10 - r11) / r12;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback r10);

    protected void e(@NonNull IndeterminateDrawable r10) {
        this.f3548a = r10;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}

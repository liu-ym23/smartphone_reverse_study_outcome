package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import r5.h;

/* JADX INFO: loaded from: classes.dex */
interface e {
    void a();

    @AnimatorRes
    int b();

    void c();

    @Nullable
    h d();

    boolean e();

    void f(@NonNull Animator.AnimatorListener r10);

    void g(@NonNull Animator.AnimatorListener r10);

    void h();

    void i(@Nullable h r10);

    AnimatorSet j();

    List<Animator.AnimatorListener> k();

    void l(@Nullable ExtendedFloatingActionButton.j r10);

    void onAnimationStart(Animator r10);
}

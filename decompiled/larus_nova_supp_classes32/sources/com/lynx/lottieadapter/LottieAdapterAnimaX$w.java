package com.lynx.lottieadapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.core.util.Consumer;
import b6a.d;
import b6a.f;
import b6a.g;
import b6a.h;
import java.lang.ref.WeakReference;
import t4a.c;
import t4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$w extends e {
    public final WeakReference<LottieAdapterAnimaX> a;

    public LottieAdapterAnimaX$w(LottieAdapterAnimaX r2) {
        this.a = new WeakReference(r2);
    }

    @Override // t4a.e, t4a.f
    public final void a(c r2) {
        f(ValueAnimator.AnimatorUpdateListener.class, new f());
    }

    @Override // t4a.e, t4a.f
    public final void b(c r2) {
        f(Animator.AnimatorListener.class, new g());
    }

    @Override // t4a.e, t4a.f
    public final void c(c r5) {
        LottieAdapterAnimaX r0 = this.a.get();
        if (r0 == null) goto L6;
        LottieAdapterAnimaX.access$1600(r0, r5.a("current"), r5.a("current") + r5.a("total"));
        return;
    }

    @Override // t4a.f
    public final void d(c r2) {
        f(Animator.AnimatorListener.class, new h());
    }

    @Override // t4a.e, t4a.f
    public final void j(c r2) {
        f(Animator.AnimatorListener.class, new d());
    }

    @Override // t4a.e, t4a.f
    public final void l(c r2) {
        f(Animator.AnimatorListener.class, new b6a.e());
    }

    public final <T> void f(Class<T> r2, Consumer<T> r3) {
        LottieAdapterAnimaX r0 = this.a.get();
        if (r0 == null) goto L6;
        LottieAdapterAnimaX.access$1700(r0, r2, r3);
        return;
    }
}

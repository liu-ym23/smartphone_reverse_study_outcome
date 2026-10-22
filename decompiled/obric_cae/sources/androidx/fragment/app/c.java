package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1933b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i0.d f1935n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k.a f1936o;

    public c(ViewGroup r8, View r10, boolean r11, i0.d r12, k.a r13) {
        this.f1932a = r8;
        this.f1933b = r10;
        this.f1934m = r11;
        this.f1935n = r12;
        this.f1936o = r13;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        ViewGroup r10 = this.f1932a;
        View r11 = this.f1933b;
        r10.endViewTransition(r11);
        if (this.f1934m == false) goto L5;
        this.f1935n.f1983a.a(r11);
    L5:
        this.f1936o.a();
    }
}

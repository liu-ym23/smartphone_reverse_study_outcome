package com.obric.oui.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f13474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f13475c;
    public final /* synthetic */ Function0 d;

    public e(f r5, c r10, Function0 r11) {
        this.f13474b = r5;
        this.f13475c = r10;
        this.d = r11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        this.f13473a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        f r10 = this.f13474b;
        r10.f13476a.animate().setUpdateListener(null).setListener(null);
        if (this.f13473a == false) goto L5;
        return;
    L5:
        c r11 = r10.e;
        if (r11 == null) goto L13;
        c r12 = this.f13475c;
        if (r11.f13469a != r12.f13469a) goto L12;
        this.d.invoke();
        return;
    L12:
        return;
    }
}

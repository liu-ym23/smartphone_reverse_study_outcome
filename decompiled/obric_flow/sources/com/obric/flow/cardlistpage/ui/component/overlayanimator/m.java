package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f11678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f11679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f11680c;
    public final /* synthetic */ Function0 d;

    public m(Ref.BooleanRef r5, p r10, float r11, Function0 r12) {
        this.f11678a = r5;
        this.f11679b = r10;
        this.f11680c = r11;
        this.d = r12;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        this.f11678a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        p r10 = this.f11679b;
        r10.f11691k = null;
        if (this.f11680c <= 0.0f) goto L5;
        boolean r11 = true;
    L6:
        b0 r12 = new b0(r11);
        Intrinsics.checkNotNullParameter(r12, "intent");
        r10.d(r12);
        if (this.f11678a.element == true) goto L12;
        Function0 r13 = this.d;
        if (r13 == null) goto L13;
        r13.invoke();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        super.onAnimationStart(r5);
        b0 r10 = new b0(true);
        p r11 = this.f11679b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "intent");
        r11.d(r10);
    }
}

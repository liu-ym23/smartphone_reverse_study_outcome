package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ TouchUtils a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ AppFloatManager.b e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.c(this.b, this.c, this.d);
        AppFloatManager.b r5 = this.e;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.c(this.b, this.c, this.d);
        AppFloatManager.b r5 = this.e;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        TouchUtils r4 = this.a;
        r4.b.j = true;
        TouchUtils.a(r4, this.c);
    }

    public f(TouchUtils r1, d r2, boolean r3, boolean r4, AppFloatManager.e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}

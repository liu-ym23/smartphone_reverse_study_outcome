package d2a;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ Function1<Animator, Unit> a;
    public final /* synthetic */ Animator b;
    public final /* synthetic */ Function1<Animator, Unit> c;
    public final /* synthetic */ Function1<Animator, Unit> d;
    public final /* synthetic */ Function1<Animator, Unit> e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.removeListener(this);
        this.d.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.removeListener(this);
        this.c.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.invoke(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Function1<Animator, Unit> r0 = this.c;
        e r1 = g.a;
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
    L9:
        this.e.invoke(r3);
        return;
    L5:
        if (Intrinsics.areEqual(this.d, r1) == false) goto L9;
        if (Intrinsics.areEqual(this.a, r1) == false) goto L9;
        this.b.removeListener(this);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Animator, Unit> r1, Animator r2, Function1<? super Animator, Unit> r3, Function1<? super Animator, Unit> r4, Function1<? super Animator, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}

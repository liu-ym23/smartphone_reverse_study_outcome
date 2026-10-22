package com.larus.common_ui.blur;

import android.animation.Animator;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a$b implements Animator.AnimatorListener {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ a b;
    public final /* synthetic */ Function0<Float> c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.b.c = null;
        FLogger.a.i("BlurCircleAnim", "[Round#" + this.a.element + "]: " + r4.hashCode() + "#onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        a r0 = this.b;
        r0.c = null;
        if (r0.b != 1) goto L5;
        boolean r1 = true;
    L6:
        FLogger.a.i("BlurCircleAnim", "[Round#" + this.a.element + "]: " + r6.hashCode() + "#onAnimationEnd[stop:" + r1 + ']');
        if (r1 == false) goto L9;
        return;
    L9:
        a r7 = this.b;
        r7.b(r7.a, ((Number) this.c.invoke()).floatValue(), this);
        this.a.element++;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        FLogger.a.i("BlurCircleAnim", "[Round#" + this.a.element + "]: " + r4.hashCode() + "#onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        FLogger.a.i("BlurCircleAnim", "[Round#" + this.a.element + "]:onAnimationStart#" + r4.hashCode());
    }

    public a$b(Ref.IntRef r1, a r2, Function0<Float> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

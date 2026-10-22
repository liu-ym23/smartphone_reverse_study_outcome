package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements Animator.AnimatorListener {
    public final /* synthetic */ MessageActionPanel a;
    public final /* synthetic */ View b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ float e;
    public final /* synthetic */ View f;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MessageActionPanel r3 = this.a;
        r3.Q = false;
        r3.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.f.setVisibility(8);
        View r3 = this.a.N;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
        r3 = null;
    L5:
        r3.setVisibility(8);
        MessageActionPanel r4 = this.a;
        r4.Q = false;
        r4.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        MessageActionPanel r5 = this.a;
        r5.Q = true;
        this.b.setTranslationY(r5.i - this.c);
        View r6 = this.a.N;
        View r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
        r6 = null;
    L5:
        r6.setVisibility(0);
        View r7 = this.a.N;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
    L9:
        float r8 = this.e;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L14;
        r1.height = (int) r8;
        r0.setLayoutParams(r1);
        this.b.setVisibility(0);
        this.d.invoke();
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r0 = r7;
        goto L9
    }

    public k(MessageActionPanel r1, UDShadowLayout r2, float r3, Function0 r4, float r5, UDShadowLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}

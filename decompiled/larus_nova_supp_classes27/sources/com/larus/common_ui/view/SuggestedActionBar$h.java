package com.larus.common_ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SuggestedActionBar$h extends AnimatorListenerAdapter {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SuggestedActionBar c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Function0<Unit> r4 = this.a;
        if (r4 == null) goto L6;
        r4.invoke();
    L6:
        if (this.b == true) goto L8;
        e1.o(this.c);
    L8:
        SuggestedActionBar r5 = this.c;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L13;
        r0.height = -2;
        r5.setLayoutParams(r0);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public SuggestedActionBar$h(Function0<Unit> r1, boolean r2, SuggestedActionBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

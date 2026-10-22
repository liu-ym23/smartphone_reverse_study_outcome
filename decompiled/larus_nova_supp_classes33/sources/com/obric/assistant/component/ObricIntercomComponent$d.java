package com.obric.assistant.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricIntercomComponent$d extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Function0<Unit> e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.c == false) goto L9;
        this.d.setVisibility(8);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.b == true) goto L8;
        if (this.c == false) goto L8;
        this.d.setVisibility(8);
    L8:
        if (this.a == false) goto L10;
        return;
    L10:
        if (this.b == false) goto L16;
        Function0<Unit> r3 = this.e;
        if (r3 == null) goto L17;
        r3.invoke();
        return;
    L17:
        return;
    }

    public ObricIntercomComponent$d(boolean r1, boolean r2, View r3, Function0<Unit> r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}

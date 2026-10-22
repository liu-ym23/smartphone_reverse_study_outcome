package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.obric.oui.texteffects.ODimPointGenerateEffectView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f11686c;

    public o(p r5, View r10) {
        this.f11684a = 0;
        this.f11685b = r5;
        this.f11686c = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        switch(this.f11684a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "animation");
        ((Ref.BooleanRef) this.f11685b).element = true;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
        ((p) this.f11685b).f11692l = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        View r10 = this.f11686c;
        Object r11 = this.f11685b;
        int r12 = this.f11684a;
        Intrinsics.checkNotNullParameter(r5, "animation");
        switch(r12) {
            case 0: goto L8;
            default: goto L5;
        };
    L8:
        ((p) r11).f11692l = null;
        r10.setX(0.0f);
        return;
    L5:
        if (((Ref.BooleanRef) r11).element == true) goto L10;
        int r13 = ODimPointGenerateEffectView.f14707j;
        ((ODimPointGenerateEffectView) r10).e();
        return;
    }

    public o(Ref.BooleanRef r5, js.s r10, ODimPointGenerateEffectView r11) {
        this.f11684a = 1;
        this.f11685b = r5;
        this.f11686c = r11;
    }
}

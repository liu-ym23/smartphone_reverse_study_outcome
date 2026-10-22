package qc8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ BubbleBannerComponent b;
    public final /* synthetic */ String c;
    public final /* synthetic */ View d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ float g;
    public final /* synthetic */ float h;
    public final /* synthetic */ Function0<Unit> i;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        if (this.a == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.b.v, this.c) == false) goto L10;
        this.b.w = null;
        BubbleBannerComponent.h3(this.d, this.e, this.f, this.g, this.h, 1.0f);
        this.i.invoke();
        return;
    }

    public q(BubbleBannerComponent r1, String r2, View r3, float r4, float r5, float r6, float r7, Function0<Unit> r8) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}

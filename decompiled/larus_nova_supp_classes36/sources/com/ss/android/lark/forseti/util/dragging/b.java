package com.ss.android.lark.forseti.util.dragging;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ a.InterfaceC0068a d;

    public b(ForsetiNormalChainDraggingView r1, float r2, float r3, a.InterfaceC0068a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        float r6 = ((Float) r5).floatValue();
        this.a.setTranslationX((this.b + r6) - this.c);
        d.a.getClass();
        a.InterfaceC0068a r0 = this.d;
        if (r0 == null) goto L6;
        r0.c(r6, r6 - this.c);
        return;
    }
}

package com.google.android.material.motion;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8560b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f8559a = r10;
        this.f8560b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        switch(this.f8559a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        p r10 = (p) this.f8560b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Object r11 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Float");
        float r12 = ((Float) r11).floatValue();
        CardFeedLayout r13 = (CardFeedLayout) r10.e.get();
        if (r13 == null) goto L13;
        r13.setAlpha(r12);
        return;
    L13:
        return;
    L9:
        DrawerLayoutUtils.a((DrawerLayout) this.f8560b, r5);
        return;
    L11:
        MaterialMainContainerBackHelper.a((ClippableRoundedCornerLayout) this.f8560b, r5);
    }
}

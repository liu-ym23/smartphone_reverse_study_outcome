package com.obric.assistant.omnidetailpage.blockview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.obric.assistant.card.databinding.ObricOmniBlockLocalSearchBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s extends AnimatorListenerAdapter {
    public final /* synthetic */ LocalSearchResultView a;
    public final /* synthetic */ ObricOmniBlockLocalSearchBinding b;
    public final /* synthetic */ boolean c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationCancel(r2);
        this.a.f = null;
        LocalSearchResultView.c(this.b, this.c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.f = null;
        LocalSearchResultView.c(this.b, this.c);
    }

    public s(LocalSearchResultView r1, ObricOmniBlockLocalSearchBinding r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

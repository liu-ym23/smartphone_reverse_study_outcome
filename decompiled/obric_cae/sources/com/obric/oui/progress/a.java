package com.obric.oui.progress;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ODownloadProgressView.a f6493a;

    public a(ODownloadProgressView.a r8) {
        this.f6493a = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        this.f6493a.f6477a.invalidate();
    }
}

package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements AccessibilityManagerCompat.TouchExplorationStateChangeListener, AnimatableView.Listener, ViewUtils.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f8562a;

    public /* synthetic */ a(Object r5) {
        this.f8562a = r5;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f8562a).start();
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10, ViewUtils.RelativePadding r11) {
        return SearchView.g((SearchView) this.f8562a, r5, r10, r11);
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean r5) {
        SearchBar.a((SearchBar) this.f8562a, r5);
    }
}

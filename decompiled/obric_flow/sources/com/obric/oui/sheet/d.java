package com.obric.oui.sheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBottomSheetDialog f14431a;

    public d(OBottomSheetDialog r5) {
        this.f14431a = r5;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r5, float r10) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r5, int r10) {
        if (r10 != 5) goto L6;
        this.f14431a.cancel();
        return;
    }
}

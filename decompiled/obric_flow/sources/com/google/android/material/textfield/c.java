package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f8604b;

    public /* synthetic */ c(EndIconDelegate r5, int r10) {
        this.f8603a = r10;
        this.f8604b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = this.f8603a;
        EndIconDelegate r11 = this.f8604b;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        DropdownMenuEndIconDelegate.c((DropdownMenuEndIconDelegate) r11, r5);
        return;
    L6:
        ClearTextEndIconDelegate.d((ClearTextEndIconDelegate) r11, r5);
        return;
    L8:
        ClearTextEndIconDelegate.c((ClearTextEndIconDelegate) r11, r5);
    }
}

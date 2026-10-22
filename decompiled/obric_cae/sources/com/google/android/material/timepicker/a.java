package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f5154a;

    public a(ClockFaceView r8) {
        this.f5154a = r8;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView r8 = this.f5154a;
        if (r8.isShown() == true) goto L5;
        return true;
    L5:
        r8.getViewTreeObserver().removeOnPreDrawListener(this);
        int r10 = ((r8.getHeight() / 2) - r8.D.f5139n) - r8.L;
        if (r10 == r8.B) goto L8;
        r8.B = r10;
        r8.s();
        int r11 = r8.B;
        ClockHandView r12 = r8.D;
        r12.f5147v = r11;
        r12.invalidate();
    L8:
        return true;
    }
}

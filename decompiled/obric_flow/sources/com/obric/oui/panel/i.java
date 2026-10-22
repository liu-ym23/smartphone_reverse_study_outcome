package com.obric.oui.panel;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14009a;

    public /* synthetic */ i(int r5) {
        this.f14009a = r5;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        switch(this.f14009a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        float r10 = r5 - 1.0f;
        return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
    L6:
        float r11 = r5 - 1.0f;
        return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
    L8:
        float r12 = r5 - 1.0f;
        return ((((r12 * r12) * r12) * r12) * r12) + 1.0f;
    L10:
        float r13 = r5 - 1.0f;
        return ((((r13 * r13) * r13) * r13) * r13) + 1.0f;
    }
}

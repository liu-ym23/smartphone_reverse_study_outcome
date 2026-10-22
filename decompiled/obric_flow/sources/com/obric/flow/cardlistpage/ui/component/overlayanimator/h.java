package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        float r10 = r5 - 1.0f;
        return 1.0f - (((r10 * r10) * r10) * r10);
    }
}

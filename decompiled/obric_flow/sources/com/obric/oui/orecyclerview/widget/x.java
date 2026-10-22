package com.obric.oui.orecyclerview.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        float r10 = r5 - 1.0f;
        return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
    }
}

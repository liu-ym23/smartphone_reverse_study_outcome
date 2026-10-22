package com.obric.oui.orecyclerview.base;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends BaseInterpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        return Math.min(1.0f, (1.0f - (((9.06472f * r5) + 1.0f) * ((float) Math.exp(r5 * (-9.06472f))))) * 1.0011656f);
    }
}

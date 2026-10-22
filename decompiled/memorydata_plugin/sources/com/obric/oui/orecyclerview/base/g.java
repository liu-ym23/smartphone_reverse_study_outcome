package com.obric.oui.orecyclerview.base;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes5.dex */
public class g extends BaseInterpolator {
    public g() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r4) {
        return Math.min(1.0f, (1.0f - (((9.06472f * r4) + 1.0f) * ((float) Math.exp(r4 * (-9.06472f))))) * 1.0011656f);
    }
}

package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class SmoothInterpolator extends BaseInterpolator {
    private static final float OMEGA = 9.06472f;

    public SmoothInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r4) {
        return 1.0f - (((OMEGA * r4) + 1.0f) * ((float) Math.exp(r4 * (-9.06472f))));
    }
}

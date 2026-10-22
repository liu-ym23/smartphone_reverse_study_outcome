package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements TypeEvaluator<Float> {
    public h() {
    }

    @Override // android.animation.TypeEvaluator
    public final Float evaluate(float r1, Float r2, Float r3) {
        float r4 = r2.floatValue();
        return Float.valueOf(r4 + ((r3.floatValue() - r4) * r1));
    }
}

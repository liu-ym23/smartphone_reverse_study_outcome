package com.bytedance.android.ec.core.toolbox.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends MetricAffectingSpan {
    public final float a;

    public a() {
        this.a = -0.15f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r10) {
        Intrinsics.checkNotNullParameter(r10, "textPaint");
        r10.setTextSkewX(this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r10) {
        Intrinsics.checkNotNullParameter(r10, "textPaint");
        r10.setTextSkewX(this.a);
    }
}

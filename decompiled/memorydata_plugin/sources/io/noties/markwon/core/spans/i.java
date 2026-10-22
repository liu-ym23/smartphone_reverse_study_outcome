package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes6.dex */
public class i extends MetricAffectingSpan {
    public i() {
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        r1.setTextSkewX(-0.25f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r1) {
        r1.setTextSkewX(-0.25f);
    }
}

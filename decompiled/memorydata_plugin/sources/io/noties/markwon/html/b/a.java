package io.noties.markwon.html.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes6.dex */
public class a extends MetricAffectingSpan {
    public a() {
    }

    private void a(TextPaint r3) {
        r3.setTextSize(r3.getTextSize() * 0.75f);
        r3.baselineShift -= (int) (r3.ascent() / 2.0f);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        a(r1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r1) {
        a(r1);
    }
}

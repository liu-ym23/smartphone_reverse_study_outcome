package z6a;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends MetricAffectingSpan {
    public final float a;

    public e(float r1) {
        this.a = r1;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        if (Float.isNaN(this.a) == true) goto L6;
        r3.setLetterSpacing(this.a / r3.getTextSize());
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r3) {
        if (Float.isNaN(this.a) == true) goto L6;
        r3.setLetterSpacing(this.a / r3.getTextSize());
        return;
    }
}

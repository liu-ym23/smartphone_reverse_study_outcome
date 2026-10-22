package z6a;

import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m extends MetricAffectingSpan {
    public final Rect a;
    public final a7a.b b;

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r1) {
    }

    public m(a7a.b r2) {
        this.a = new Rect();
        this.b = r2;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        if (this.a.width() != 0) goto L5;
        return;
    L5:
        if (this.a.height() == 0) goto L10;
        this.b.setBounds(this.a);
        r3.setShader(this.b.b);
        return;
    }
}

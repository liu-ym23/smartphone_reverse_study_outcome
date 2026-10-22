package z6a;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends MetricAffectingSpan {
    public final Typeface a;

    public final int hashCode() {
        Typeface r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public i(Typeface r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (i.class == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.a, ((i) r3).a);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Typeface r0 = this.a;
        if (r0 == null) goto L6;
        r2.setTypeface(r0);
        return;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Typeface r0 = this.a;
        if (r0 == null) goto L6;
        r2.setTypeface(r0);
        return;
    }
}

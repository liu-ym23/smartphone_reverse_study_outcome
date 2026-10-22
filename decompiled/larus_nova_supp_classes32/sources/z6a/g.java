package z6a;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g extends MetricAffectingSpan {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (g.class != r5.getClass()) goto L17;
        g r6 = (g) r5;
        if (this.a == r6.a) goto L13;
    L15:
        return false;
    L13:
        if (this.b != r6.b) goto L15;
        return true;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r8) {
        com.lynx.tasm.behavior.shadow.text.b.n(r8, this.c, this.a, this.b, this.d, this.e, this.f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r8) {
        com.lynx.tasm.behavior.shadow.text.b.n(r8, this.c, this.a, this.b, this.d, this.e, this.f);
    }

    public g(int r1, int r2, String r3, String r4, String r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}

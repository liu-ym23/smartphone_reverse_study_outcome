package klb;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements LineHeightSpan {
    public final a a;

    public static class a {
        public float a;

        public a() {
        }
    }

    public b(a r1) {
        this.a = r1;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
        int r7 = ((Spanned) r1).getSpanEnd(this);
        boolean r8 = true;
        if (r7 != r3) goto L5;
    L8:
        if (r8 == false) goto L11;
        int r9 = r6.bottom;
        int r10 = (int) (((double) (this.a.a - (r9 - r6.top))) + 0.5d);
        r6.descent += r10;
        r6.bottom = r9 + r10;
        return;
    L11:
        return;
    L5:
        if (r7 == (r3 - 1)) goto L8;
        r8 = false;
        goto L8
    }
}

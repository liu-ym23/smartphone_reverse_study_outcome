package x9b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class h extends MetricAffectingSpan {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public h() {
    }

    public final void a(TextPaint r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.a == false) goto L8;
        r3.setFakeBoldText(true);
    L8:
        if (this.b == false) goto L11;
        r3.setTextSkewX(-0.25f);
    L11:
        if (this.c == false) goto L14;
        r3.setUnderlineText(true);
    L14:
        if (this.d == false) goto L17;
        r3.setStrikeThruText(true);
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r1) {
        a(r1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "textPaint");
        a(r2);
    }
}

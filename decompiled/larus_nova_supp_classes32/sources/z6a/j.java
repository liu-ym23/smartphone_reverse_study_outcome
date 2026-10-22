package z6a;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends MetricAffectingSpan {
    public final int a;
    public int b;
    public float c;
    public boolean d;

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r1) {
    }

    public final int hashCode() {
        return this.a + 31;
    }

    public j(int r2) {
        this.d = false;
        this.a = r2;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof j) == true) goto L5;
        return false;
    L5:
        if (this.a != ((j) r3).a) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r6) {
        boolean r0 = this.d;
        int r1 = this.a;
        int r2 = this.b;
        float r3 = this.c;
        DecimalFormat r4 = com.lynx.tasm.behavior.shadow.text.b.a;
        if (r0 == false) goto L5;
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(r3);
        r6.setColor(r2);
        r6.bgColor = 0;
        return;
    L5:
        r6.setStyle(Paint.Style.FILL);
        r6.setColor(r1);
    }
}

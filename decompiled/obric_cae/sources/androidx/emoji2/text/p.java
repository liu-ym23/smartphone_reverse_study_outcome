package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class p extends k {
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r10, @SuppressLint({"UnknownNullness"}) CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
        f.a().getClass();
        i r8 = this.f1784b;
        n r19 = r8.f1772b;
        Typeface r20 = r19.f1799d;
        Typeface r21 = r18.getTypeface();
        r18.setTypeface(r20);
        int r22 = r8.f1771a * 2;
        r10.drawText(r19.f1797b, r22, 2, r14, r16, r18);
        r18.setTypeface(r21);
    }
}

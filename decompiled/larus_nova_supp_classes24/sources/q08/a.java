package q08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import h18.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements p08.a {
    public final int a;
    public float b;
    public int c;
    public final TextPaint d;
    public final TextPaint e;
    public final TextPaint f;
    public final TextPaint g;
    public final Paint h;
    public final Paint i;

    @Override // p08.a
    public final int b() {
        return this.a;
    }

    @Override // p08.a
    public final void c(float r2) {
        this.b = r2;
        this.d.setTextSize(r2);
        this.e.setTextSize(r2);
        this.f.setTextSize(r2);
        this.g.setTextSize(r2);
    }

    public final float d(TextPaint r4) {
        Paint.FontMetrics r5 = r4.getFontMetrics();
        float r0 = this.a / 2;
        float r2 = r5.descent;
        return (r0 + ((r2 - r5.ascent) / 2)) - r2;
    }

    @Override // p08.a
    public final void setTypeFace(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "typeFace");
        this.d.setTypeface(r2);
        this.e.setTypeface(r2);
        this.f.setTypeface(r2);
        this.g.setTypeface(r2);
    }

    public a(Context r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.a = r9;
        this.b = d.a(r8, 16.0f);
        TextPaint r0 = new TextPaint();
        this.d = r0;
        TextPaint r1 = new TextPaint();
        this.e = r1;
        TextPaint r2 = new TextPaint();
        this.f = r2;
        TextPaint r3 = new TextPaint();
        this.g = r3;
        Paint r4 = new Paint();
        this.h = r4;
        Paint r5 = new Paint();
        this.i = r5;
        this.c = (int) d.a(r8, 16.0f);
        d.a(r8, 6.0f);
        d.a(r8, 6.0f);
        r0.setTextSize(this.b);
        r0.setTextAlign(Paint.Align.CENTER);
        r0.setColor(r8.getResources().getColor(2131106622));
        r0.setAntiAlias(true);
        r1.setTextSize(this.b);
        r1.setTextAlign(Paint.Align.CENTER);
        r1.setColor(r8.getResources().getColor(2131106620));
        r1.setAntiAlias(true);
        r2.setTextSize(this.b);
        r2.setTextAlign(Paint.Align.CENTER);
        r2.setColor(r8.getResources().getColor(2131105560));
        r2.setAntiAlias(true);
        r3.setTextSize(this.b);
        r3.setTextAlign(Paint.Align.CENTER);
        r3.setColor(r8.getResources().getColor(2131105542));
        r3.setAntiAlias(true);
        r4.setStyle(Paint.Style.FILL);
        r4.setColor(r8.getResources().getColor(2131105548));
        r4.setAntiAlias(true);
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(r8.getResources().getColor(2131103351));
        r5.setAntiAlias(true);
    }

    @Override // p08.a
    public final void a(Canvas r7, n08.a r8) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r8, "baseDay");
        int r0 = r7.save();
        int r1 = r7.getWidth() / 7;
        r7.translate((r8.b * r1) + (r1 / 2), r8.a * this.a);
        CalendarAttr r2 = r8.d;
        CalendarAttr.MonthState r3 = r2.c;
        CalendarAttr.SelectState r4 = r2.a;
        CalendarAttr.DateState r5 = r2.b;
        String r9 = String.valueOf(r8.c.getMonthDay());
        if (r3 != CalendarAttr.MonthState.CURRENT_MONTH) goto L15;
        float r6 = this.a / 2;
        if (r4 != CalendarAttr.SelectState.SELECT) goto L11;
        if (r5 != CalendarAttr.DateState.CURRENT_DATE) goto L9;
        r7.drawCircle(0.0f, r6, this.c, this.h);
        r7.drawText(r9, 0.0f, d(this.f), this.f);
    L18:
        r7.restoreToCount(r0);
        return;
    L9:
        r7.drawCircle(0.0f, r6, this.c, this.i);
        r7.drawText(r9, 0.0f, d(this.d), this.d);
        goto L18
    L11:
        if (r5 != CalendarAttr.DateState.CURRENT_DATE) goto L13;
        r7.drawText(r9, 0.0f, d(this.g), this.g);
        goto L18
    L13:
        r7.drawText(r9, 0.0f, d(this.d), this.d);
        goto L18
    L15:
        if (r5 != CalendarAttr.DateState.CURRENT_DATE) goto L17;
        r7.drawText(r9, 0.0f, d(this.g), this.g);
        goto L18
    L17:
        r7.drawText(r9, 0.0f, d(this.e), this.e);
        goto L18
    }
}

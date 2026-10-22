package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h18.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends Drawable {
    public CharSequence a;
    public float b;
    public Drawable c;
    public int d;
    public Drawable e;
    public float f;
    public final Paint g;
    public volatile boolean h;
    public volatile boolean i;
    public int j;
    public int k;
    public final Rect l;

    /* JADX INFO: renamed from: com.larksuite.component.ui.imageview.a$a, reason: collision with other inner class name */
    public static final class C0035a {
        public CharSequence a;
        public float b;
        public Drawable c;
        public int d;
        public Drawable e;
        public float f;
        public final Context g;

        public C0035a(Context r2) {
            this.d = -1;
            this.g = r2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        if (TextUtils.isEmpty(this.a) == true) goto L8;
        int r0 = (int) this.g.measureText(this.a.toString());
        int r2 = (int) (this.g.getFontMetrics().bottom - this.g.getFontMetrics().top);
        if (this.a.length() != 1) goto L7;
        int r1 = (int) (Math.max(r0, r2) + (this.f * 2.0f));
        this.k = r1;
        this.j = r1;
    L9:
        Drawable r3 = this.e;
        if (r3 == null) goto L20;
        int r4 = r3.getIntrinsicWidth();
        int r5 = this.e.getIntrinsicWidth();
        this.e.setBounds(0, 0, r4, r5);
        int r6 = this.j;
        if (r6 == 0) goto L15;
        r4 = r6;
    L15:
        this.j = r4;
        int r7 = this.k;
        if (r7 == 0) goto L19;
        r5 = r7;
    L19:
        this.k = r5;
    L20:
        Drawable r8 = this.c;
        if (r8 == null) goto L30;
        int r9 = this.j;
        if (r9 != 0) goto L25;
        r9 = r8.getIntrinsicWidth();
    L25:
        this.j = r9;
        int r10 = this.k;
        if (r10 != 0) goto L28;
        r10 = this.c.getIntrinsicHeight();
    L28:
        this.k = r10;
        this.c.setBounds(0, 0, this.j, r10);
        return;
    L30:
        return;
    L7:
        int r11 = com.larksuite.framework.utils.autoscale.a.a;
        float r12 = r0 + (this.f * 2.0f);
        Resources r13 = Resources.getSystem();
        this.j = (int) (r12 + ((WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).density * 8.0f) + 0.5f));
        this.k = (int) (r2 + (this.f * 2.0f));
        goto L9
    L8:
        this.j = 0;
        this.k = 0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.j;
    }

    public a(C0035a r4) {
        this.h = false;
        this.i = false;
        this.l = new Rect();
        Context r0 = r4.g;
        this.a = r4.a;
        float r1 = r4.b;
        if (r1 > 0.0f) goto L6;
        r1 = this.b;
    L6:
        this.b = r1;
        this.d = r4.d;
        Drawable r2 = r4.c;
        if (r2 != null) goto L10;
        r2 = new ColorDrawable(-65536);
    L10:
        this.c = r2;
        this.e = r4.e;
        float r3 = r4.f;
        if (r3 >= 0.0f) goto L14;
        r3 = this.f;
    L14:
        this.f = r3;
        TextPaint r5 = new TextPaint();
        this.g = r5;
        r5.setAntiAlias(true);
        r5.setColor(this.d);
        r5.setTextSize(this.b);
        r5.setTextAlign(Paint.Align.CENTER);
        r5.setStyle(Paint.Style.FILL);
        r5.setAlpha(255);
        int r6 = e.a;
        r5.setTypeface(e.b(r4.g, 1));
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Rect r0 = getBounds();
        Drawable r1 = this.c;
        if (r1 == null) goto L6;
        Rect r2 = r1.getBounds();
        int r3 = r2.width();
        int r4 = r2.height();
        r8.save();
        r8.translate((r0.width() - r3) / 2, (r0.height() - r4) / 2);
        this.c.draw(r8);
        r8.restore();
    L6:
        if (this.e == null) goto L9;
        r8.save();
        r8.translate((r0.width() - this.e.getBounds().width()) / 2, (r0.height() - this.e.getBounds().width()) / 2);
        this.e.draw(r8);
        r8.restore();
        return;
    L9:
        if (TextUtils.isEmpty(this.a) == true) goto L13;
        String r5 = this.a.toString();
        float r6 = r0.centerX();
        this.g.getTextBounds(r5, 0, this.a.length(), this.l);
        r8.drawText(r5, r6, r0.centerY() - this.l.exactCenterY(), this.g);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.g.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.g.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r1, int r2, int r3, int r4) {
        super.setBounds(r1, r2, r3, r4);
        a();
    }
}

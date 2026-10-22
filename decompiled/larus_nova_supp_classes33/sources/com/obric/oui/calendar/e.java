package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e extends AppCompatCheckedTextView {
    public CalendarDay a;
    public int b;
    public final int c;
    public Drawable d;
    public Drawable e;
    public Drawable f;
    public mla.e g;
    public mla.e h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final int m;
    public final int n;
    public int o;
    public final Rect p;
    public final Rect q;

    public final String a() {
        mla.e r0 = this.g;
        CalendarDay r1 = this.a;
        return ((mla.c) r0).b.a(r1.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        Drawable r0 = this.e;
        if (r0 == null) goto L5;
        setBackgroundDrawable(r0);
        return;
    L5:
        int r1 = this.b;
        StateListDrawable r2 = new StateListDrawable();
        r2.setExitFadeDuration(50);
        int[] r3 = {R.attr.state_checked};
        ShapeDrawable r4 = new ShapeDrawable(new OvalShape());
        r4.getPaint().setColor(r1);
        r2.addState(r3, r4);
        ShapeDrawable r5 = new ShapeDrawable(new OvalShape());
        r5.getPaint().setColor(0);
        r2.addState(new int[0], r5);
        this.f = r2;
        setBackgroundDrawable(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        int r2 = 0;
        if (this.j == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.i == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        setEnabled(r3);
        int r4 = this.o;
        int r5 = MaterialCalendarView.D;
        if ((r4 & 1) == 0) goto L19;
        boolean r6 = true;
    L21:
        if ((r4 & 2) == 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L28;
        if (r6 == true) goto L28;
        boolean r8 = false;
    L30:
        if ((r4 & 4) == 0) goto L32;
        boolean r9 = true;
    L33:
        boolean r10 = this.j;
        if (r10 == true) goto L37;
        if (r6 == false) goto L37;
        r0 = true;
    L37:
        boolean r11 = this.i;
        if (r11 == true) goto L42;
        if (r8 == false) goto L42;
        r0 = r0 | r10;
    L42:
        if (this.l == false) goto L49;
        if (r9 == false) goto L49;
        if (r10 == false) goto L47;
        if (r11 == false) goto L47;
        boolean r12 = true;
    L48:
        r0 = r0 | r12;
    L47:
        r12 = false;
    L49:
        if (r10 == true) goto L52;
        if (r0 == false) goto L52;
        this.k = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L53:
        if (r0 == true) goto L56;
        r2 = 4;
    L56:
        setVisibility(r2);
        return;
    L52:
        this.k = true;
        goto L53
    L32:
        r9 = false;
    L28:
        r8 = true;
        goto L30
    L23:
        r7 = false;
        goto L24
    L19:
        r6 = false;
        goto L21
    L13:
        if (this.l == true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (this.i == false) goto L9;
        if (this.l == true) goto L9;
        r0 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        boolean r0 = super/*android.widget.CheckedTextView*/.performClick();
        bma.a.c(getContext(), 1);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Drawable r0 = this.d;
        if (r0 == null) goto L5;
        r0.setBounds(this.p);
        this.d.setState(getDrawableState());
        this.d.draw(r3);
    L5:
        this.f.setBounds(this.q);
        super/*android.widget.CheckedTextView*/.onDraw(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setChecked(boolean r2) {
        if (isChecked() == r2) goto L5;
        boolean r0 = true;
    L6:
        super/*android.widget.CheckedTextView*/.setChecked(r2);
        if (r0 == true) goto L9;
        return;
    L9:
        if (isChecked() == false) goto L11;
        int r3 = this.m;
    L12:
        vma.f.a(this, r3);
        return;
    L11:
        r3 = this.n;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r4, CalendarDay r5) {
        super(r4);
        this.b = -7829368;
        this.c = 40;
        this.d = null;
        mla.c r6 = mla.e.a;
        this.g = r6;
        this.h = r6;
        this.i = true;
        this.j = true;
        this.k = true;
        this.l = false;
        this.o = 4;
        this.p = new Rect();
        this.q = new Rect();
        this.m = getResources().getInteger(2131427394);
        this.n = getResources().getInteger(2131427398);
        this.b = this.b;
        b();
        setGravity(17);
        setIncludeFontPadding(false);
        setTextAlignment(4);
        this.a = r5;
        setText(a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextAppearance(Context r1, int r2) {
        super.setTextAppearance(r1, r2);
        setIncludeFontPadding(false);
        if (isChecked() == false) goto L5;
        int r3 = this.m;
    L6:
        vma.f.a(this, r3);
        return;
    L5:
        r3 = this.n;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.CheckedTextView*/.onLayout(r1, r2, r3, r4, r5);
        int r6 = r4 - r2;
        int r7 = r5 - r3;
        float r8 = this.c;
        Resources r9 = getResources();
        int r10 = Math.min((int) (r8 * WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density), Math.min(r6, r7));
        int r11 = (r6 - r10) / 2;
        int r12 = (r7 - r10) / 2;
        int r13 = r11 + r10;
        int r14 = r10 + r12;
        this.p.set(r11, r12, r13, r14);
        this.q.set(r11, r12, r13, r14);
        b();
    }
}

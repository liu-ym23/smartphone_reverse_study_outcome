package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.common.oui.R$integer;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AppCompatCheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CalendarDay f12268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12270c;
    public Drawable d;
    public Drawable e;
    public StateListDrawable f;
    public yq.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public yq.a f12271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f12278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f12279p;

    public f(Context r5, CalendarDay r10) {
        super(r5);
        this.f12269b = -7829368;
        this.f12270c = 40;
        this.d = null;
        zm.z r11 = yq.a.f23316m1;
        this.g = r11;
        this.f12271h = r11;
        this.f12272i = true;
        this.f12273j = true;
        this.f12274k = true;
        this.f12277n = 4;
        this.f12278o = new Rect();
        this.f12279p = new Rect();
        this.f12275l = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.f12276m = getResources().getInteger(R$integer.oui_font_weight_regular);
        this.f12269b = this.f12269b;
        a();
        setGravity(17);
        setIncludeFontPadding(false);
        setTextAlignment(4);
        this.f12268a = r10;
        zm.z r12 = (zm.z) this.g;
        r12.getClass();
        LocalDate r13 = r10.f12167a;
        setText(((org.threeten.bp.format.b) r12.f23549a).a(r13));
    }

    public final void a() {
        Drawable r5 = this.e;
        if (r5 == null) goto L5;
        setBackgroundDrawable(r5);
        return;
    L5:
        int r10 = this.f12269b;
        StateListDrawable r11 = new StateListDrawable();
        r11.setExitFadeDuration(50);
        int[] r12 = {R.attr.state_checked};
        ShapeDrawable r13 = new ShapeDrawable(new OvalShape());
        r13.getPaint().setColor(r10);
        r11.addState(r12, r13);
        ShapeDrawable r14 = new ShapeDrawable(new OvalShape());
        r14.getPaint().setColor(0);
        r11.addState(new int[0], r14);
        this.f = r11;
        setBackgroundDrawable(r11);
    }

    public final void b() {
        int r5 = 0;
        if (this.f12273j == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        setEnabled(this.f12272i);
        int r11 = this.f12277n;
        int r12 = MaterialCalendarView.D;
        if ((r11 & 1) == 0) goto L11;
        boolean r13 = true;
    L13:
        if ((r11 & 2) != 0) goto L16;
        if (r13 == true) goto L16;
        boolean r14 = false;
    L18:
        boolean r15 = this.f12273j;
        if (r15 == true) goto L23;
        if (r13 == false) goto L23;
        r10 = true;
    L23:
        if (this.f12272i == true) goto L26;
        if (r14 == false) goto L26;
        r10 = r10 | r15;
    L26:
        if (r15 == true) goto L29;
        if (r10 == false) goto L29;
        this.f12274k = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L30:
        if (r10 == true) goto L33;
        r5 = 4;
    L33:
        setVisibility(r5);
        return;
    L29:
        this.f12274k = true;
    L16:
        r14 = true;
        goto L18
    L11:
        r13 = false;
        goto L13
    L5:
        if (this.f12272i == false) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        Drawable r10 = this.d;
        if (r10 == null) goto L5;
        r10.setBounds(this.f12278o);
        this.d.setState(getDrawableState());
        this.d.draw(r5);
    L5:
        this.f.setBounds(this.f12279p);
        super.onDraw(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        int r16 = Math.min((int) (this.f12270c * getResources().getDisplayMetrics().density), Math.min(r14, r15));
        int r17 = (r14 - r16) / 2;
        int r18 = (r15 - r16) / 2;
        int r19 = r17 + r16;
        int r20 = r16 + r18;
        this.f12278o.set(r17, r18, r19, r20);
        this.f12279p.set(r17, r18, r19, r20);
        a();
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r5 = super.performClick();
        com.lynx.tasm.utils.g.p(1, getContext());
        return r5;
    }

    @Override // android.widget.CheckedTextView, android.widget.Checkable
    public final void setChecked(boolean r5) {
        if (isChecked() == r5) goto L5;
        boolean r10 = true;
    L6:
        super.setChecked(r5);
        if (r10 == true) goto L9;
        return;
    L9:
        if (isChecked() == false) goto L11;
        int r11 = this.f12275l;
    L12:
        ym.m.m(this, r11);
        return;
    L11:
        r11 = this.f12276m;
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public final void setTextAppearance(Context r5, int r10) {
        super.setTextAppearance(r5, r10);
        setIncludeFontPadding(false);
        if (isChecked() == false) goto L5;
        int r11 = this.f12275l;
    L6:
        ym.m.m(this, r11);
        return;
    L5:
        r11 = this.f12276m;
        goto L6
    }
}

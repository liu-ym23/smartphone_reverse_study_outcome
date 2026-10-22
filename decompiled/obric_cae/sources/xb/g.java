package xb;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public final class g extends androidx.appcompat.widget.g {
    public final Rect A;
    public final Rect B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CalendarDay f13804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f13806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f13807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public StateListDrawable f13808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public yb.e f13809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public yb.e f13810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13811v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f13814y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13815z;

    public g(Context r8, CalendarDay r10) {
        super(r8, null);
        this.f13805p = -7829368;
        this.f13806q = null;
        yb.c r11 = yb.e.f14109a;
        this.f13809t = r11;
        this.f13810u = r11;
        this.f13811v = true;
        this.f13812w = true;
        this.f13813x = true;
        this.f13814y = false;
        this.f13815z = 4;
        this.A = new Rect();
        this.B = new Rect();
        this.f13805p = this.f13805p;
        c();
        setGravity(17);
        setTextAlignment(4);
        this.f13804o = r10;
        setText(b());
    }

    public static ShapeDrawable a(int r8) {
        ShapeDrawable r10 = new ShapeDrawable(new OvalShape());
        r10.getPaint().setColor(r8);
        return r10;
    }

    public final String b() {
        yb.e r8 = this.f13809t;
        yb.c r10 = (yb.c) r8;
        return r10.a(this.f13804o);
    }

    public final void c() {
        Drawable r8 = this.f13807r;
        if (r8 == null) goto L5;
        setBackgroundDrawable(r8);
        return;
    L5:
        int r10 = this.f13805p;
        StateListDrawable r11 = new StateListDrawable();
        r11.setExitFadeDuration(50);
        r11.addState(new int[]{R.attr.state_checked}, a(r10));
        r11.addState(new int[]{R.attr.state_pressed}, new RippleDrawable(ColorStateList.valueOf(r10), null, a(-1)));
        r11.addState(new int[0], a(0));
        this.f13808s = r11;
        setBackgroundDrawable(r11);
    }

    public final void d() {
        int r8 = 0;
        if (this.f13812w == true) goto L5;
    L9:
        boolean r10 = false;
    L11:
        if (this.f13811v == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        setEnabled(r11);
        boolean r12 = MaterialCalendarView.d(this.f13815z);
        int r13 = this.f13815z;
        if ((r13 & 2) == 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == true) goto L24;
        if (r12 == true) goto L24;
        boolean r15 = false;
    L26:
        if ((r13 & 4) == 0) goto L28;
        boolean r16 = true;
    L29:
        boolean r17 = this.f13812w;
        if (r17 == true) goto L33;
        if (r12 == false) goto L33;
        r10 = true;
    L33:
        boolean r18 = this.f13811v;
        if (r18 == true) goto L38;
        if (r15 == false) goto L38;
        r10 = r10 | r17;
    L38:
        if (this.f13814y == false) goto L45;
        if (r16 == false) goto L45;
        if (r17 == false) goto L43;
        if (r18 == false) goto L43;
        boolean r19 = true;
    L44:
        r10 = r10 | r19;
    L43:
        r19 = false;
    L45:
        if (r17 == true) goto L48;
        if (r10 == false) goto L48;
        this.f13813x = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L49:
        if (r10 == true) goto L52;
        r8 = 4;
    L52:
        setVisibility(r8);
        return;
    L48:
        this.f13813x = true;
        goto L49
    L28:
        r16 = false;
    L24:
        r15 = true;
        goto L26
    L19:
        r14 = false;
        goto L20
    L13:
        if (this.f13814y == true) goto L15;
        r11 = true;
        goto L16
    L5:
        if (this.f13811v == false) goto L9;
        if (this.f13814y == true) goto L9;
        r10 = true;
        goto L11
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r8) {
        Drawable r10 = this.f13806q;
        if (r10 == null) goto L5;
        r10.setBounds(this.A);
        this.f13806q.setState(getDrawableState());
        this.f13806q.draw(r8);
    L5:
        this.f13808s.setBounds(this.B);
        super.onDraw(r8);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        int r16 = Math.min(r15, r14);
        int r17 = Math.abs(r15 - r14) / 2;
        int r18 = r16 + r17;
        Rect r19 = this.B;
        Rect r20 = this.A;
        if (r14 < r15) goto L5;
        r20.set(r17, 0, r18, r15);
        r19.set(r17, 0, r18, r15);
    L6:
        c();
        return;
    L5:
        r20.set(0, r17, r14, r18);
        r19.set(0, r17, r14, r18);
        goto L6
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r8 = super.performClick();
        defpackage.c.o0(getContext(), 1);
        return r8;
    }
}

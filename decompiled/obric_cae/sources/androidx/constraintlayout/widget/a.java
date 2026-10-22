package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public s.a f1412u;

    public a(Context r8) {
        super(r8);
        setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f1412u.f11810v0;
    }

    public int getMargin() {
        return this.f1412u.f11811w0;
    }

    public int getType() {
        return this.f1410s;
    }

    @Override // androidx.constraintlayout.widget.c
    public final void i(AttributeSet r8) {
        super.i(r8);
        this.f1412u = new s.a();
        if (r8 == null) goto L17;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, v.d.f12656b);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L16;
        int r13 = r10.getIndex(r12);
        if (r13 != 26) goto L10;
        setType(r10.getInt(r13, 0));
    L15:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != 25) goto L13;
        this.f1412u.f11810v0 = r10.getBoolean(r13, true);
        goto L15
    L13:
        if (r13 != 27) goto L15;
        this.f1412u.f11811w0 = r10.getDimensionPixelSize(r13, 0);
        goto L15
    L16:
        r10.recycle();
    L17:
        this.f1433n = this.f1412u;
        k();
    }

    @Override // androidx.constraintlayout.widget.c
    public final void j(s.e r8, boolean r10) {
        int r11 = this.f1410s;
        this.f1411t = r11;
        if (r10 == false) goto L8;
        if (r11 == 5) goto L11;
        if (r11 != 6) goto L14;
    L9:
        int r12 = 0;
    L12:
        this.f1411t = r12;
    L14:
        if ((r8 instanceof s.a) == false) goto L17;
        int r13 = this.f1411t;
        ((s.a) r8).f11809u0 = r13;
        return;
    L17:
        return;
    L11:
        r12 = 1;
        goto L12
    L8:
        if (r11 == 5) goto L9;
        if (r11 != 6) goto L14;
        goto L11
    }

    public void setAllowsGoneWidget(boolean r8) {
        this.f1412u.f11810v0 = r8;
    }

    public void setDpMargin(int r8) {
        this.f1412u.f11811w0 = (int) ((r8 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int r8) {
        this.f1412u.f11811w0 = r8;
    }

    public void setType(int r8) {
        this.f1410s = r8;
    }
}

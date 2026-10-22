package com.obric.oui.radio;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.r;
import com.obric.cae.R;
import he.i;
import nb.a;

/* JADX INFO: loaded from: classes2.dex */
public class ORadio extends r {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f6503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f6504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f6506r;

    public ORadio(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6506r = false;
        this.f6504p = true;
        if (r10 == null) goto L6;
        TypedArray r11 = r8.obtainStyledAttributes(r10, a.f9502p, 0, 0);
        i.e(r11, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.f6506r = r11.getBoolean(1, false);
        this.f6505q = r11.getInt(3, 0);
        this.f6504p = r11.getBoolean(0, true);
        this.f6503o = r11.getBoolean(2, false);
        r11.recycle();
    L6:
        if (this.f6506r == true) goto L8;
        a();
        return;
    L8:
        setClickable(true);
    }

    public final void a() {
        if (this.f6506r == false) goto L6;
        return;
    L6:
        if (this.f6505q != 1) goto L10;
        int r8 = R.drawable.o_ic_radio_tick_checked;
    L8:
        setButtonDrawable(r8);
        setChecked(isChecked());
        return;
    L10:
        if (this.f6503o == false) goto L12;
        r8 = R.drawable.o_radio_round_always_light;
        goto L8
    L12:
        r8 = R.drawable.o_radio_round;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6506r == false) goto L6;
        return;
    L6:
        if (this.f6504p == false) goto L9;
        Resources r8 = Resources.getSystem();
        i.e(r8, "Resources.getSystem()");
        int r10 = l6.a.I0(TypedValue.applyDimension(1, 44, r8.getDisplayMetrics()));
        bc.a.a(this, r10, r10, false);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r8) {
        super.setChecked(r8);
        if (this.f6506r == false) goto L6;
        return;
    L6:
        if (this.f6505q != 1) goto L12;
        if (r8 == false) goto L9;
        int r10 = 0;
    L10:
        setVisibility(r10);
        return;
    L9:
        r10 = 4;
        goto L10
    }

    public final void setStyle(int r8) {
        if (this.f6506r == false) goto L5;
        return;
    L5:
        this.f6505q = r8;
        a();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r8, TextView.BufferType r10) {
        super.setText(r8, r10);
    }
}

package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.obric.cae.R;
import he.i;
import l6.a;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCheckBox f6266a;

    public OCheckBoxLayout(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        if (r10 == null) goto L5;
        OCheckBox r11 = new OCheckBox(r8, r10, 0);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 17;
        j r13 = j.f13877a;
        r11.setLayoutParams(r12);
        this.f6266a = r11;
        addView(r11);
        return;
    L5:
        OCheckBox r14 = new OCheckBox(r8);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 17;
        j r16 = j.f13877a;
        r14.setLayoutParams(r15);
        this.f6266a = r14;
        addView(r14);
    }

    public final OCheckBox getCheckBox() {
        return this.f6266a;
    }

    public final int getCheckedState() {
        return this.f6266a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f6266a.isChecked();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        Resources r11 = Resources.getSystem();
        i.e(r11, "Resources.getSystem()");
        int r12 = View.MeasureSpec.makeMeasureSpec(a.I0(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics())), 1073741824);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L15;
        if (isEnabled() == false) goto L15;
        int r10 = r8.getAction();
        if (r10 != 0) goto L8;
        setBackground(getResources().getDrawable(R.drawable.o_ic_radio_round_press_bg, null));
        goto L15
    L8:
        if (r10 != 1) goto L10;
    L12:
        setBackground(null);
        goto L15
    L10:
        if (r10 == 3) goto L12;
    L15:
        return super.onTouchEvent(r8);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.f6266a.performClick();
    }

    public final void setAlwaysLight(boolean r8) {
        this.f6266a.setAlwaysLight(r8);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        this.f6266a.setChecked(r8);
    }

    public final void setCheckedState(int r8) {
        this.f6266a.setCheckedState(r8);
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        this.f6266a.setEnabled(r8);
        if (r8 == true) goto L6;
        setBackground(null);
        return;
    }

    public final void setOnCheckedChangeListener(OCheckBox.a r8) {
        this.f6266a.setOnCheckedChangeListener(r8);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.b r8) {
        this.f6266a.setOnCheckedStateChangedListener(r8);
    }

    public final void setPrimaryColor(int r8) {
        this.f6266a.setPrimaryColor(r8);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f6266a.toggle();
    }
}

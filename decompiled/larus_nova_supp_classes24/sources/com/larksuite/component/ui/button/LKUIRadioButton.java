package com.larksuite.component.ui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import j08.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIRadioButton extends AppCompatRadioButton {
    public Drawable a;

    public LKUIRadioButton(Context r1) {
        super(r1);
        a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AttributeSet r7) {
        boolean r2 = false;
        if (r7 != null) goto L5;
        TypedArray r3 = null;
    L6:
        if (r3 == null) goto L8;
        boolean r4 = r3.getBoolean(0, false);
        r3.recycle();
    L9:
        if (r7 != null) goto L11;
        TypedArray r8 = null;
    L12:
        if (r8 == null) goto L14;
        r2 = r8.getBoolean(0, false);
        r8.recycle();
    L14:
        if (r4 == false) goto L16;
        this.a = d.b(getContext(), 2131243844);
        setClickable(r2);
    L17:
        setButtonDrawable(null);
        setBackground(null);
        return;
    L16:
        this.a = d.b(getContext(), 2131243852);
        goto L17
    L11:
        r8 = getContext().obtainStyledAttributes(r7, new int[]{R.attr.clickable});
        goto L12
    L8:
        r4 = false;
        goto L9
    L5:
        r3 = getContext().obtainStyledAttributes(r7, new int[]{2130969181});
        goto L6
    }

    public LKUIRadioButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r5, int r6) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
    L9:
        super/*android.widget.RadioButton*/.onMeasure(r5, r6);
        return;
    L5:
        if (r0.width != (-2)) goto L9;
        if (r0.height != (-2)) goto L9;
        int r7 = (int) j08.b.a(getContext(), 18.0f);
        int r8 = (getPaddingLeft() + r7) + getPaddingRight();
        int r9 = (r7 + getPaddingTop()) + getPaddingBottom();
        int r10 = View.MeasureSpec.makeMeasureSpec(r8, 1073741824);
        r6 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        r5 = r10;
        goto L9
    }

    public LKUIRadioButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.RadioButton*/.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L9;
        int r6 = (int) j08.b.a(getContext(), 18.0f);
        if (getLayoutParams() == null) goto L7;
        r6 = Math.min((getWidth() - getPaddingRight()) - getPaddingLeft(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    L7:
        this.a.setBounds(0, 0, r6, r6);
        setCompoundDrawables(this.a, null, null, null);
        return;
    }
}

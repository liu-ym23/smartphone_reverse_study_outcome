package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import j08.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUICheckBox extends AppCompatCheckBox {
    public Drawable a;
    public boolean b;

    public LKUICheckBox(Context r1) {
        super(r1);
        this.b = false;
        a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AttributeSet r6) {
        if (r6 != null) goto L5;
        TypedArray r7 = null;
    L6:
        if (r7 == null) goto L8;
        this.b = r7.getBoolean(0, this.b);
        r7.recycle();
    L8:
        setButtonDrawable(null);
        setBackground(null);
        return;
    L5:
        r7 = getContext().obtainStyledAttributes(r6, new int[]{2130973709});
        goto L6
    }

    public void setRadio(boolean r1) {
        this.b = r1;
    }

    public LKUICheckBox(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = false;
        a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r6, int r7) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L10;
        int r1 = (int) j08.b.a(getContext(), 18.0f);
        if (r0.width != (-2)) goto L8;
        r6 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r1) + getPaddingRight(), 1073741824);
    L8:
        if (r0.height != (-2)) goto L10;
        r7 = View.MeasureSpec.makeMeasureSpec((r1 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        super/*android.widget.CheckBox*/.onMeasure(r6, r7);
    }

    public LKUICheckBox(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = false;
        a(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.CheckBox*/.onLayout(r1, r2, r3, r4, r5);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
        this.a = d.b(getContext(), 2131243852);
    L8:
        int r6 = (int) j08.b.a(getContext(), 18.0f);
        if (getLayoutParams() == null) goto L11;
        r6 = Math.min((getWidth() - getPaddingRight()) - getPaddingLeft(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    L11:
        this.a.setBounds(0, 0, r6, r6);
        setCompoundDrawables(this.a, null, null, null);
        return;
    L7:
        this.a = d.b(getContext(), 2131243835);
        goto L8
    }
}

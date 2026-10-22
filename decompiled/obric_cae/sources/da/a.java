package da;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.y;
import x9.b;

/* JADX INFO: loaded from: classes.dex */
public final class a extends y {
    public a(Context r8, AttributeSet r10) {
        super(ea.a.a(r8, r10, R.attr.textViewStyle, 0), r10, R.attr.textViewStyle);
        Context r11 = getContext();
        boolean r12 = true;
        if (b.b(r11, true, com.obric.cae.R.attr.textAppearanceLineHeightEnabled) == false) goto L13;
        Resources.Theme r13 = r11.getTheme();
        int[] r14 = g9.a.f7778s;
        TypedArray r15 = r13.obtainStyledAttributes(r10, r14, R.attr.textViewStyle, 0);
        int r16 = q(r11, r15, new int[]{1, 2});
        r15.recycle();
        if (r16 != (-1)) goto L8;
        r12 = false;
    L8:
        if (r12 == true) goto L14;
        TypedArray r17 = r13.obtainStyledAttributes(r10, r14, R.attr.textViewStyle, 0);
        int r18 = r17.getResourceId(0, -1);
        r17.recycle();
        if (r18 == (-1)) goto L15;
        p(r18, r13);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static int q(Context r8, TypedArray r10, int... r11) {
        int r12 = -1;
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L14;
        if (r12 >= 0) goto L14;
        int r14 = r11[r13];
        TypedValue r15 = new TypedValue();
        if (r10.getValue(r14, r15) == true) goto L9;
    L12:
        r12 = r10.getDimensionPixelSize(r14, -1);
    L13:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r15.type != 2) goto L12;
        TypedArray r16 = r8.getTheme().obtainStyledAttributes(new int[]{r15.data});
        int r17 = r16.getDimensionPixelSize(0, -1);
        r16.recycle();
        r12 = r17;
    L14:
        return r12;
    }

    public final void p(int r8, Resources.Theme r10) {
        TypedArray r11 = r10.obtainStyledAttributes(r8, g9.a.f7777r);
        int r12 = q(getContext(), r11, new int[]{1, 2});
        r11.recycle();
        if (r12 < 0) goto L6;
        setLineHeight(r12);
        return;
    }

    @Override // androidx.appcompat.widget.y, android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        if (b.b(r8, true, com.obric.cae.R.attr.textAppearanceLineHeightEnabled) == false) goto L6;
        p(r10, r8.getTheme());
        return;
    }
}

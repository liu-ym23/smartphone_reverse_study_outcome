package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class DialogTitle extends y {
    public DialogTitle(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // androidx.appcompat.widget.y, android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        Layout r11 = getLayout();
        if (r11 == null) goto L13;
        int r12 = r11.getLineCount();
        if (r12 > 0) goto L7;
        return;
    L7:
        if (r11.getEllipsisCount(r12 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r13 = getContext().obtainStyledAttributes(null, c.a.f3238x, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int r14 = r13.getDimensionPixelSize(0, 0);
        if (r14 == 0) goto L11;
        setTextSize(0, r14);
    L11:
        r13.recycle();
        super.onMeasure(r8, r10);
        return;
    L15:
        return;
    }
}

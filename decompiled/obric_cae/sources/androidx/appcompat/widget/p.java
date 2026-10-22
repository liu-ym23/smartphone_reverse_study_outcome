package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class p extends PopupWindow {
    public p(Context r8, AttributeSet r10, int r11, int r12) {
        super(r8, r10, r11, r12);
        v0 r13 = new v0(r8, r8.obtainStyledAttributes(r10, c.a.f3233s, r11, r12));
        if (r13.l(2) == false) goto L5;
        androidx.core.widget.j.c(this, r13.a(2, false));
    L5:
        setBackgroundDrawable(r13.e(0));
        r13.n();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r8, int r10, int r11) {
        super.showAsDropDown(r8, r10, r11);
    }

    @Override // android.widget.PopupWindow
    public final void update(View r8, int r10, int r11, int r12, int r13) {
        super.update(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r8, int r10, int r11, int r12) {
        super.showAsDropDown(r8, r10, r11, r12);
    }
}

package com.obric.oui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.obric.cae.R;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class ODivider extends View {
    public ODivider(Context r8, AttributeSet r10) {
        this(r8, r10, 4);
    }

    @Override // android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    public final void setStyle(int r8) {
        Context r10 = getContext();
        Object r11 = a.f1674a;
        setBackgroundColor(a.c.a(r10, R.color.oui_line_2));
    }

    public ODivider(Context r8, AttributeSet r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        i.f(r8, "context");
        super(r8, r10, 0);
        TypedArray r12 = r8.getTheme().obtainStyledAttributes(r10, nb.a.f9495i, 0, 0);
        int r13 = r12.getInt(0, 0);     // Catch: Throwable -> L9
        r12.recycle();
        setStyle(r13);
        return;
    L9:
        th = move-exception;
        r12.recycle();
        throw th;
    }
}

package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h6 extends FrameLayout {
    public h6(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        View r0 = getChildAt(0);
        if (r0 != null) goto L5;
        return;
    L5:
        measureChildWithMargins(r0, r8, 0, r9, 0);
        int r10 = (r0.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r11 = (r0.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r10 <= getMeasuredWidth()) goto L8;
    L9:
        setMeasuredDimension(Math.max(getMeasuredWidth(), r10), Math.max(getMeasuredHeight(), r11));
        return;
    L8:
        if (r11 > getMeasuredHeight()) goto L9;
    }
}

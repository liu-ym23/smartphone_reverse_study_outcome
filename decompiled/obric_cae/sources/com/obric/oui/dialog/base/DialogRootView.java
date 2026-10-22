package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import he.i;
import l6.a;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogRootView extends RadiusLayout {
    public DialogRootView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        Context r11 = getContext();
        i.e(r11, "context");
        int r12 = (int) (((double) a.Q(r11)) * 0.9d);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r10);
        if (r14 == Integer.MIN_VALUE) goto L7;
        if (r14 == 0) goto L6;
        int r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r13, r12), 1073741824);
    L9:
        if (View.MeasureSpec.getMode(r8) != Integer.MIN_VALUE) goto L15;
        Context r16 = getContext();
        i.e(r16, "context");
        Resources r17 = r16.getResources();
        i.e(r17, "resources");
        DisplayMetrics r18 = r17.getDisplayMetrics();
        if (r18 == null) goto L13;
        int r19 = r18.widthPixels;
    L14:
        r8 = View.MeasureSpec.makeMeasureSpec(r19, 1073741824);
        goto L15
    L13:
        r19 = 0;
    L15:
        super.onMeasure(r8, r15);
        return;
    L6:
        r15 = View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE);
        goto L9
    L7:
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r13, r12), Integer.MIN_VALUE);
        goto L9
    }
}

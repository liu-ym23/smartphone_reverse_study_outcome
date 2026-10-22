package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final <T> boolean a(ArrayList<T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$isInBounds");
        int r12 = r10.size();
        if (r11 < 0) goto L7;
        if (r12 <= r11) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean b(ViewPager r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$isNotEmpty");
        PagerAdapter r11 = r10.getAdapter();
        if (r11 == null) goto L5;
        int r12 = r11.getCount();
    L6:
        if (r12 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r12 = 0;
        goto L6
    }

    public static final void c(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setHorizontalMargin");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r12 = null;
    L5:
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        if (r13 == null) goto L9;
        r13.setMarginStart(r11);
        r13.setMarginEnd(r11);
        r10.requestLayout();
        return;
    }

    public static final void d(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setWidth");
        r10.getLayoutParams().width = r11;
        r10.requestLayout();
    }
}

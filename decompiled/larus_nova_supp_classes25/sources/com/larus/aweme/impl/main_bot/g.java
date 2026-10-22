package com.larus.aweme.impl.main_bot;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final ViewPager2FixLayout a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ViewPager2FixLayout r0 = new ViewPager2FixLayout(r4.getContext(), null, 0);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r0.addView(r4, new FrameLayout.LayoutParams(-1, -1));
        return r0;
    }
}

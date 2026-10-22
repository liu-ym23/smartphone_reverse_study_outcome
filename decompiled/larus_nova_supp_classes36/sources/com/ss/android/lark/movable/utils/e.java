package com.ss.android.lark.movable.utils;

import android.content.res.Resources;
import android.graphics.Point;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final int a(int r2) {
        Resources r0 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static final Point b(MovableView r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ScrollIsland r0 = r4.getParentIsland$movable_release();
        if (r0 == null) goto L5;
        MovableView r5 = r4.getRootMovableView();
        int[] r3 = new int[2];
        int[] r2 = new int[2];
        r0.getLocationInWindow(r3);
        r5.getLocationInWindow(r2);
        return new Point(r3[0] - r2[0], r3[1] - r2[1]);
    L5:
        return new Point(0, 0);
    }

    public static final int c(MovableView r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ScrollIsland r2 = r1.getParentIsland$movable_release();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getScrollX();
    }
}

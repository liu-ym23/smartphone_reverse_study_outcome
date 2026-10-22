package com.larksuite.component.universe_design.tab;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(View r0, boolean r1) {
        if (r0 != 0) goto L5;
        return 0;
    L5:
        if (r1 == false) goto L9;
        return r0.getLeft();
    L9:
        if ((r0 instanceof a) == false) goto L13;
        return ((a) r0).getContentViewLeft();
    L13:
        return r0.getLeft();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(View r0, boolean r1) {
        if (r0 != 0) goto L5;
        return 0;
    L5:
        if (r1 == false) goto L9;
        return r0.getRight();
    L9:
        if ((r0 instanceof a) == false) goto L13;
        return ((a) r0).getContentViewRight();
    L13:
        return r0.getRight();
    }

    public static void c(UDTabLayout r2, View r3, View r4, float r5, Drawable r6) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r6, "indicator");
        boolean r7 = r2.isIndicatorFullWidth();
        int r0 = a(r3, r7);
        int r8 = b(r3, r7);
        int r1 = a(r4, r7);
        int r9 = b(r4, r7);
        r6.setBounds((int) (r0 + ((r1 - r0) * r5)), r6.getBounds().top, (int) (r8 + ((r9 - r8) * r5)), r6.getBounds().bottom);
    }
}

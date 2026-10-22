package com.larksuite.framework.utils;

import com.larksuite.component.ui.toast.LKUIToast;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 {
    public static final Random a = null;

    static {
        a = new Random();
    }

    public static int a(int r5) {
        boolean r1 = true;
        if (Integer.MAX_VALUE < r5) goto L5;
        boolean r3 = true;
    L6:
        Object[] r4 = new Object[0];
        if (r3 == false) goto L20;
        if (r5 >= 0) goto L11;
        r1 = false;
    L11:
        Object[] r2 = new Object[0];
        if (r1 == false) goto L18;
        if (r5 != Integer.MAX_VALUE) goto L16;
        return r5;
    L16:
        return r5 + a.nextInt(LKUIToast.DURATION_MAX - r5);
    L18:
        throw new IllegalArgumentException(String.format("Both range values must be non-negative.", r2));
    L20:
        throw new IllegalArgumentException(String.format("Start value must be smaller or equal to end value.", r4));
    L5:
        r3 = false;
        goto L6
    }
}

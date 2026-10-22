package com.obric.aikernel.runtime;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final int a(boolean r10, Integer r11) {
        if (r10 == true) goto L5;
        return 0;
    L5:
        if (r11 == null) goto L7;
        int r12 = r11.intValue();
    L9:
        if (r12 > 1) goto L11;
        return 0;
    L11:
        return r12 - 1;
    L7:
        r12 = 0;
        goto L9
    }

    public static final boolean b(int r10) {
        if (r10 >= 4) goto L5;
        return true;
    L5:
        return false;
    }
}

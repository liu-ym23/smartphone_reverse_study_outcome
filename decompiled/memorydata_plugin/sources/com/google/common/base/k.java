package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends f {
    public static int a(Object... r0) {
        return Arrays.hashCode(r0);
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }
}

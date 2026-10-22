package com.bytedance.android.live;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
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

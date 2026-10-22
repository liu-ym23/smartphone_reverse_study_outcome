package com.bytedance.android.live.revlink.impl.region;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final boolean a(pc0.c r1, int r2, int r3, int r4, int r5) {
        if (Float.compare(r2, r1.d) == 0) goto L5;
    L11:
        return false;
    L5:
        if (Float.compare(r3, r1.e) != 0) goto L11;
        if (Float.compare(r5, r1.c) != 0) goto L11;
        if (Float.compare(r4, r1.b) != 0) goto L11;
        return true;
    }
}

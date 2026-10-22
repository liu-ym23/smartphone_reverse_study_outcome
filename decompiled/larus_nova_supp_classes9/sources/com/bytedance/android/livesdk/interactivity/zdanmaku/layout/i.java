package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Comparator {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r3, Object r4) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r5 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r3;
        tc2.f r6 = (tc2.f) ((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r4).b().e(tc2.f.class);
        int r0 = 0;
        if (r6 == null) goto L5;
        int r7 = r6.e;
    L6:
        tc2.f r8 = (tc2.f) r5.b().e(tc2.f.class);
        if (r8 == null) goto L10;
        r0 = r8.e;
    L10:
        return r7 - r0;
    L5:
        r7 = 0;
        goto L6
    }
}

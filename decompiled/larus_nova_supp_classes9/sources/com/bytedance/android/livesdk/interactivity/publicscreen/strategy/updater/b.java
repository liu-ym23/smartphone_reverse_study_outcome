package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final void a(a r4, int r5) {
        if ((r4 instanceof c) == true) goto L5;
        r4 = null;
    L5:
        c r6 = (c) r4;
        if (r6 == null) goto L11;
        r6.s = (int) Math.ceil(((double) r5) / ((double) Math.max(r6.l.c(), 1)));
        if (r6.l.a() == true) goto L12;
        r6.s = 0;
        return;
    L12:
        return;
    }
}

package com.bytedance.android.livesdk.gift.biggift.viewModel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        r6.getMessage();
        if (r6.getStackTrace() == null) goto L7;
        StackTraceElement[] r7 = r6.getStackTrace();
        int r0 = r7.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r7[r1].toString();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }
}

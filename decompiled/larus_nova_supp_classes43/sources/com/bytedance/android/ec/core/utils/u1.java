package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u1<T> implements Consumer {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        String r0 = r11.getMessage();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ECExceptionMonitor.f(r11, r0);
    }
}

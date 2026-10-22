package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        if (r11 == null) goto L8;
        StackTraceElement[] r0 = r11.getStackTrace();
        if (r0 == null) goto L8;
        String r13 = ArraysKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
        if (r13 == null) goto L8;
    L9:
        jy0.b.a("login log", r13);
        return;
    L8:
        r13 = BuildConfig.FLAVOR;
        goto L9
    }
}

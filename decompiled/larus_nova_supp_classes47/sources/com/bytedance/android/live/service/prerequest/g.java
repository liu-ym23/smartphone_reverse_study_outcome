package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        StringBuilder r0 = new StringBuilder("observeFollowStatusChange error: ");
        if (r4 == null) goto L5;
        String r5 = r4.getMessage();
    L6:
        r0.append(r5);
        ALogger.e("PreRequestManager", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }
}

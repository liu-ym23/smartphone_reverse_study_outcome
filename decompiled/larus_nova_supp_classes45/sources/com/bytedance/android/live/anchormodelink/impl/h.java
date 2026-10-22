package com.bytedance.android.live.anchormodelink.impl;

import com.bytedance.android.livesdk.event.t;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements Runnable {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        xs2.b.a().post(new t(1));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

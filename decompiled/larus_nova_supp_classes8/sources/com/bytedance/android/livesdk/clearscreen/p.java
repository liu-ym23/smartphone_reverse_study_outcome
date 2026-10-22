package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.pg0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements Runnable {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    public final void a() {
        this.a.J.put("live_zoom_and_lock_notify", Boolean.FALSE);
        if (pg0.a.getValue().booleanValue() == true) goto L5;
    L7:
        this.a.e0 = false;
        return;
    L5:
        if (this.a.e0 == true) goto L7;
        ClearScreenHelper.m(false);
        this.a.g0 = false;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

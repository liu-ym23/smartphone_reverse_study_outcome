package com.bytedance.android.live.anchormodelink.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import ly.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements Runnable {
    public final /* synthetic */ AnchorModeLinkDynamicWidget a;

    public d(AnchorModeLinkDynamicWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        iy.g r0 = com.bytedance.android.live.anchormodelink.linkroom.a.a;     // Catch: Throwable -> L10
        AnchorModeLinkDynamicWidget r1 = this.a;     // Catch: Throwable -> L10
        com.bytedance.android.live.anchormodelink.linkroom.a.a = r1;     // Catch: Throwable -> L10
        ly.h r2 = r1.c;     // Catch: Throwable -> L10
        if (r2 == null) goto L13;
        r2.k = true;     // Catch: Throwable -> L10
        t r3 = r2.j;     // Catch: Throwable -> L10
        if (r3 == null) goto L17;
        ih0.c r4 = r3.d;     // Catch: Throwable -> L10
        if (r4 == null) goto L18;
        r4.updateData(r2.a());     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}

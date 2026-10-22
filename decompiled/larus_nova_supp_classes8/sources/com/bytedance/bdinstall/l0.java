package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import i84.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0 extends BroadcastReceiver {
    public boolean a;
    public final /* synthetic */ i0$d b;

    public l0(i0$d r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (this.a == false) goto L6;
        this.a = false;
        return;
    L6:
        if (r3 != null) goto L10;
        t.a("intent is null when receive net change event");
        return;
    L10:
        if (r3.getBooleanExtra("noConnectivity", false) == false) goto L14;
        t.a("no connectivity");
        return;
    L14:
        if (j.a(this.b.c) == false) goto L23;
        i0$d r4 = this.b;
        monitor-enter(r4);
        m0 r5 = new m0(r4);     // Catch: Throwable -> L20
        v.e(v.a(v.d), r5);     // Catch: Throwable -> L20
        monitor-exit(r4);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}

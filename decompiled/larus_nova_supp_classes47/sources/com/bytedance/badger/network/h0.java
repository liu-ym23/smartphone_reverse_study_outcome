package com.bytedance.badger.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 extends BroadcastReceiver {
    public boolean a;
    public final /* synthetic */ j0 b;

    public h0(j0 r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        boolean r0 = false;
        if (this.a == false) goto L6;
        this.a = false;
        return;
    L6:
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.getBooleanExtra("noConnectivity", false) == false) goto L26;
        return;
    L26:
        NetworkInfo r4 = ((ConnectivityManager) this.b.c.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L25
        if (r4 == null) goto L17;
        if (r4.isConnected() == false) goto L17;
        r0 = true;
    L17:
        if (r0 == false) goto L24;
        j0 r5 = this.b;
        r5.getClass();
        Iterator r6 = new ArrayList(r5.a).iterator();
    L20:
        if (r6.hasNext() == false) goto L33;
        i0 r7 = (i0) ((WeakReference) r6.next()).get();
        if (r7 == null) goto L20;
        r7.a();
        goto L20
    L33:
        return;
    }
}

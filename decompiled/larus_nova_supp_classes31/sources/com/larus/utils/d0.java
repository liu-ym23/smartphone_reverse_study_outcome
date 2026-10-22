package com.larus.utils;

import android.net.NetworkInfo;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ boolean a;

    public /* synthetic */ d0(boolean r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        NetworkInfo r1 = e0.b.getActiveNetworkInfo();
        if (r1 == null) goto L5;
        boolean r2 = r1.isConnected();
    L7:
        if (r0 == false) goto L9;
        FLogger.a.i("NetworkStateUtil", "network available, new state: " + r2);
    L10:
        e0.c.postValue(Boolean.valueOf(r2));
        return;
    L9:
        FLogger.a.i("NetworkStateUtil", "network lost, new state: " + r2);
        goto L10
    L5:
        r2 = false;
        goto L7
    }
}

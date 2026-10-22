package com.larus.dora.impl.wlan.wifi.add;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o implements Runnable {
    public final /* synthetic */ DoraWifiScanListFragment a;

    public o(DoraWifiScanListFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentActivity r0 = this.a.getActivity();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setResult(-1);     // Catch: Throwable -> L6
        r0.finish();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

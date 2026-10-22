package com.larus.avlink.activeSummary;

import androidx.core.app.NotificationManagerCompat;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;

    public /* synthetic */ i(j r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r0 = this.a;
        int r1 = this.b;
        r0.getClass();
        NotificationManagerCompat.from(AppHost.a.getApplication()).cancel(r1);
    }
}

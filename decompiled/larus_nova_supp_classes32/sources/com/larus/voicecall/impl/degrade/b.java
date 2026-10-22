package com.larus.voicecall.impl.degrade;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.spi.common.IObricUtilService;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ b(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r2 = this.a;
        IObricUtilService r0 = kga.b.a();
        AppHost.Companion r1 = AppHost.a;
        if (r0.d(r1.getApplication().getApplicationContext(), r2) == true) goto L11;
        Context r3 = r1.a().getCurrentActivity();
        if (r3 != null) goto L9;
        r3 = r1.getApplication().getApplicationContext();
    L9:
        Context r4 = r3;
        s.j(s.a, r4, r2, null, false, 28);
        return;
    }
}

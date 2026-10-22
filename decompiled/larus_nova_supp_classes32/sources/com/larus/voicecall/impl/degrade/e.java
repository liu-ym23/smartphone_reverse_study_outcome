package com.larus.voicecall.impl.degrade;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ e(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r2 = this.a;
        AppHost.Companion r0 = AppHost.a;
        Context r1 = r0.a().getCurrentActivity();
        if (r1 != null) goto L6;
        r1 = r0.getApplication().getApplicationContext();
    L6:
        s.j(s.a, r1, r2, null, false, 28);
    }
}

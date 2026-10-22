package com.obric.assistant.common.utils;

import android.widget.Toast;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ z(int r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        AppHost.Companion r1 = AppHost.a;
        if (r1.a().isAppBackground() == false) goto L5;
        Toast.makeText(r1.getApplication(), r1.getApplication().getResources().getString(r0), 1).show();
        return;
    L5:
        t19.s.a.g(r1.getApplication(), r0, false);
    }
}

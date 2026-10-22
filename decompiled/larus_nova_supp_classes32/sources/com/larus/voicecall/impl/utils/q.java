package com.larus.voicecall.impl.utils;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class q implements Runnable {
    public /* synthetic */ q() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppHost.Companion r0 = AppHost.a;
        String r5 = r0.getApplication().getResources().getString(2131900529);
        t19.s.j(t19.s.a, r0.getApplication(), r5, null, false, 28);
    }
}

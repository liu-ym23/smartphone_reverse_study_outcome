package com.larus.common.mssdk.impl;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements g4 {
    public final /* synthetic */ SecurityServiceImpl a;

    public final void b() {
    }

    public final void a() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L6;
        this.a.getClass();
        SecurityServiceImpl.O(r0);
        return;
    }

    public n(SecurityServiceImpl r1) {
        this.a = r1;
    }
}

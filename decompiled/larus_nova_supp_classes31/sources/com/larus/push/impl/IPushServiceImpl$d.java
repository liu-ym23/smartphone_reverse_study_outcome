package com.larus.push.impl;

import com.bytedance.push.b;
import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class IPushServiceImpl$d implements e {
    public final /* synthetic */ IPushServiceImpl a;

    public IPushServiceImpl$d(IPushServiceImpl r1) {
        this.a = r1;
    }

    public final void onGetId(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "did");
        Intrinsics.checkNotNullParameter(r3, "iid");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        IApplog.a.k(this);
        b.a.c(r2, r3, r4);
        PushEventManager.a.getClass();
        PushEventManager.c();
        IPushServiceImpl r5 = this.a;
        int r6 = IPushServiceImpl.b;
        r5.o();
    }
}

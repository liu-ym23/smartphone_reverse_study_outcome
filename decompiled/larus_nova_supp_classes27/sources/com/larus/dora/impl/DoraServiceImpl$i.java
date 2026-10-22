package com.larus.dora.impl;

import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.platform.service.AccountService;
import g49.d;
import kj4.a;
import kotlin.jvm.internal.Intrinsics;
import oy8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraServiceImpl$i implements b {
    public DoraServiceImpl$i() {
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "macAddress");
        d.b("DoraServiceImpl", "onDeviceAppeared");
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if ((!DoraAdapterExtKt.j(a.g()).isEmpty()) == true) goto L6;
    L13:
        return;
    L6:
        if (AccountService.a.isLogin().booleanValue() == false) goto L8;
        com.larus.dora.impl.core.i0.a.a.i(0, r3);     // Catch: Throwable -> L10
        goto L13
    L8:
        d.d("DoraServiceImpl", "initLinkManager user not login");     // Catch: Throwable -> L10
        goto L13
    }
}

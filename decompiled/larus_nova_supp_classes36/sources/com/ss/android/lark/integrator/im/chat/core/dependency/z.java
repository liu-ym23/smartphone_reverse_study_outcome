package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.biz.im.api.param.IMConstants;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w4b.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements g0 {
    public static final List<aqb.d> a = null;
    public static boolean b;

    public z() {
    }

    static {
        a = new CopyOnWriteArrayList();
        b = false;
    }

    public final IMConstants.NetworkLevel getCurNetWorkLevel() {
        List r0 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        return IMConstants.NetworkLevel.forNumber(LarkNetworkLevelManager.a.a().getCurNetWorkLevel().getValue());
    }

    public final void a(aqb.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) a).add(r3);
        if (b == false) goto L7;
        return;
    L7:
        monitor-enter(z.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (b == true) goto L11;
        y r0 = new y();     // Catch: Throwable -> L13
        List r1 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;     // Catch: Throwable -> L13
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a.getClass();     // Catch: Throwable -> L13
        ((CopyOnWriteArrayList) com.ss.android.lark.rustinfrabridge.netstate.impl.d.a).add(r0);     // Catch: Throwable -> L13
        b = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(z.class);     // Catch: Throwable -> L13
    }

    public final void b(aqb.d r2) {
        if (r2 == null) goto L5;
        ((CopyOnWriteArrayList) a).remove(r2);
        return;
    }
}

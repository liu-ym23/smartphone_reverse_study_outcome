package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.revenue.common.t;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.h;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PanelContextManager implements o, e {
    public final LinkedHashSet<c> a;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.panel.context.e
    public final c i() {
        LinkedHashSet<c> r0 = this.a;
        monitor-enter(r0);
        c r1 = (c) CollectionsKt.lastOrNull(this.a);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public PanelContextManager() {
        this.a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.e
    public final void h1(c r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        LinkedHashSet<c> r2 = this.a;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.a.add(r6) == false) goto L7;
        jy0.b.a("Recharge/PanelContextManager", "attach recharge panel context: " + r6 + " (" + t.a(r6) + ')');     // Catch: Throwable -> L12
    L8:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
        int r1 = h.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(h.a(new PanelContextManager$attachRechargePanelContext$2(this, r6)), r6.getCd());
        return;
    L7:
        jy0.b.f("Recharge/PanelContextManager", "recharge panel context already attached: " + r6 + " (" + t.a(r6) + ')', null, 4);     // Catch: Throwable -> L12
        goto L8
    }
}

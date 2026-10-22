package com.bytedance.android.live.broadcastgame.opengame.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b0 implements l {
    public com.bytedance.android.live.broadcastgame.opengame.panel.h a;

    public b0() {
    }

    public abstract Function0<com.bytedance.android.live.broadcastgame.opengame.panel.h> b();

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void q0() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("SyncCreatePanelFactory", new Object[]{"create panel"});
        this.a = (com.bytedance.android.live.broadcastgame.opengame.panel.h) b().invoke();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void r0(Function0<Unit> r1, Function1<? super com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r2.invoke(r3);
        return;
    }
}

package com.bytedance.android.live.liveinteract.api.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements com.bytedance.android.scope.o, b {
    public final bn0.b a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public h(bn0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.api.utils.b
    public final void Eh(Throwable r2) {
        g.r("join_fail", r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.utils.b
    public final void r6(Map r4) {
        g.n("server_sys_kickout", r4, tc0.c.h(), true);
    }
}

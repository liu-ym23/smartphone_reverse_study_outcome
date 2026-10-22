package com.bytedance.android.live.broadcastgame.opengame.debug;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.live.broadcastgame.opengame.i.a {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
    public final void onInitSuccess() {
        d.b(this.a);
    }

    public f(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
    public final void a(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        d.a(this.a, r2);
    }
}

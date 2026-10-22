package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.api.channel.DelayType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements com.bytedance.android.live.broadcastgame.api.model.k {
    public final boolean a;
    public final long b;
    public final tlc.d c;

    public final int b() {
        if (this.a == false) goto L5;
        DelayType r0 = DelayType.DELAY_FLOW_STREAM;
    L7:
        return r0.getValue();
    L5:
        r0 = DelayType.NO_DELAY;
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.k
    public final long a() {
        return this.b;
    }

    public b0(boolean r2, long r3, tlc.d r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}

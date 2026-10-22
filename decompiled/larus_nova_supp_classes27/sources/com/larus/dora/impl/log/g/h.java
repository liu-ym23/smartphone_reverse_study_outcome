package com.larus.dora.impl.log.g;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h extends r0 {
    public h() {
    }

    public final void a1(DoraDevice r3, mj4.b r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r4, "state");
        g49.d.d("DoraGLogManager", "onIdleStateChanged device " + r3 + ", state " + r4.a);
    }
}

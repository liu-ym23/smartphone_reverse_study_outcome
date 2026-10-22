package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.platform.aio.channel.js.a {
    public c() {
    }

    public final void a(String r2, com.bytedance.platform.aio.channel.js.c r3) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "method");
    }

    public final void b(com.bytedance.platform.aio.channel.js.model.e r3) {
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "eventName");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
    }

    public final void c(String r2, com.bytedance.platform.aio.channel.js.c r3) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "method");
    }

    public final void d(JavaOnlyMap r3) {
        Intrinsics.checkNotNullParameter("rpcChannelMessageV2", "eventName");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
    }
}

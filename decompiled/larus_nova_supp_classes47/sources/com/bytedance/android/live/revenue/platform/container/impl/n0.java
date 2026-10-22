package com.bytedance.android.live.revenue.platform.container.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.b a;

    public n0(com.bytedance.platform.aio.channel.js.c r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        com.bytedance.platform.aio.channel.js.b r0 = this.a;
        KProperty[] r1 = e0.a;
        Intrinsics.checkNotNullParameter(r0, "$this$convertToStatefulMethod");
        return new d0(r0);
    }
}

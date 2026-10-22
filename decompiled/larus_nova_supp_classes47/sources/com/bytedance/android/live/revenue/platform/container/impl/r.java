package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ String a;

    public r(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        m.a r12 = (m.a) r10;
        Intrinsics.checkNotNullParameter(r12, "it");
        com.bytedance.platform.aio.a r13 = r12.a;
        if (r13 == null) goto L5;
        return r13;
    L5:
        String r14 = this.a;
        RpcExceptionMonitorLevel r4 = RpcExceptionMonitorLevel.ERROR;
        Intrinsics.checkNotNullParameter("service_center_no_such_service", "category");
        Intrinsics.checkNotNullParameter(r14, "interfaceId");
        Intrinsics.checkNotNullParameter(r4, "errorLevel");
        throw new RpcException("service_center_no_such_service", "service " + r14 + " not found", com.bytedance.platform.aio.d.g(new Exception()), r4, null, 16, null);
    }
}

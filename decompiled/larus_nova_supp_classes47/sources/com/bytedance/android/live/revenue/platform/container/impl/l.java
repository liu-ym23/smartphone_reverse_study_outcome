package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest;
import com.bytedance.platform.aio.ServiceHub;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements com.bytedance.platform.aio.a {
    public l() {
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interfaceId");
        return true;
    }

    public final void g(ServiceHub r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceHub");
    }

    public final void i(com.bytedance.platform.aio.c r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceHub");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, R> j57.a<R> c(String r7, String r8, T r9) {
        Intrinsics.checkNotNullParameter(r7, "interfaceId");
        Intrinsics.checkNotNullParameter(r8, "methodId");
        Intrinsics.checkNotNullParameter(r9, "arguments");
        JsonObject r10 = ((v) r9).a;
        i97.a r1 = i97.a.a;
        z r0 = new z(r10, System.currentTimeMillis());
        if (com.bytedance.android.live.revenue.common.b0.b().D() == true) goto L6;
        com.bytedance.revenue.platform.api.core.rx.l r12 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return new j57.a(Observable.error(com.bytedance.platform.aio.d.f(r7)), null, 6);
    L6:
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.live.revenue.platform.container.impl.core.g r3 = (com.bytedance.android.live.revenue.platform.container.impl.core.g) com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revenue.platform.container.impl.core.g.class));
        if (r3 == null) goto L9;
        NotifyServiceCenterStateRequest.State r4 = r3.b0();
    L11:
        if (r4 != NotifyServiceCenterStateRequest.State.STOPPED) goto L14;
        com.bytedance.revenue.platform.api.core.rx.l r14 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return new j57.a(Observable.error(com.bytedance.platform.aio.d.f(r7)), null, 6);
    L14:
        Object r15 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revenue.platform.container.impl.core.g.class));
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.revenue.platform.container.impl.core.g.a r5 = com.bytedance.android.live.revenue.platform.container.impl.core.g.D0;
        CenterServiceType r6 = CenterServiceType.BUSINESS_SERVICE;
        r5.getClass();
        return new j57.a(com.bytedance.android.live.revenue.platform.container.impl.core.g.b.a((com.bytedance.android.live.revenue.platform.container.impl.core.g) r15, com.bytedance.android.live.revenue.platform.container.impl.core.g.a.a(r6), r7, r8, r0), null, 6);
    L9:
        r4 = null;
        goto L11
    }
}

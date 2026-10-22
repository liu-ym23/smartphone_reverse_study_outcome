package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.scope.o, yz0.m {
    public final cy0.f a;
    public final yz0.k b;
    public final n01.a c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final DataCenter getDataCenter() {
        return this.b.getDataCenter();
    }

    @Override // yz0.m
    public final void i() {
        ALogger.d("FansClubLoaderService", "FansClubLoaderService->onRoomReady");
        t r0 = new t(this.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = e33.k.a;
        if (r0.e != r1) goto L6;
        String r2 = "revenueInstance";
    L12:
        if (r2 != null) goto L16;
        com.bytedance.android.scope.l.a(r0);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r2);
    L6:
        if (r0.f != r1) goto L9;
        r2 = "revenueInstanceExt";
        goto L12
    L9:
        if (r0.g != r1) goto L11;
        r2 = "roomInstance";
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    public d(cy0.f r2, yz0.k r3, n01.a r4) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "vsService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

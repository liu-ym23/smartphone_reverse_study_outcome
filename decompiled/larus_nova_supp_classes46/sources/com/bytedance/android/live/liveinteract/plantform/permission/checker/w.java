package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements js0.b {
    public final /* synthetic */ t a;

    @Override // js0.b
    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        com.bytedance.android.scope.m r5 = com.bytedance.android.scope.m.e;
        f00.a.a r0 = f00.a.b;
        nz.t r1 = (nz.t) r5.d(r0, nz.t.class);
        if (r1 != null) goto L5;
    L9:
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).init();
    L10:
        this.a.c();
        return;
    L5:
        if (r1.isOpen() != true) goto L9;
        nz.t r6 = (nz.t) r5.d(r0, nz.t.class);
        if (r6 == null) goto L10;
        r6.init();
        goto L10
    }

    public w(t r1, rh0.a r2) {
        this.a = r1;
    }
}

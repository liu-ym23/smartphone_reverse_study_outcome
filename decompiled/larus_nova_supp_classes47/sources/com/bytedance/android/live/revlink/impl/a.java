package com.bytedance.android.live.revlink.impl;

import kotlin.jvm.internal.Intrinsics;
import mz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final void a(m r2) {
        Intrinsics.checkNotNullParameter(LinkCrossRoomDataHolder.c, "$this$anchorLinkLog");
        Intrinsics.checkNotNullParameter(r2, "logFilterBuilder");
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public static final void b(m r2) {
        Intrinsics.checkNotNullParameter(LinkCrossRoomDataHolder.c, "$this$linkCrossRoomLog");
        Intrinsics.checkNotNullParameter(r2, "logFilterBuilder");
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }
}

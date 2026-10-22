package com.bytedance.android.live.revenue.platform.network.dynamic;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements vlc.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function1 b;

    public h(String r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r3) {
        int r0 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(this.a) == true) goto L5;
        if (r3 == null) goto L18;
        this.b.invoke(r3);
        return;
    L18:
        return;
    L5:
        if ((r3 instanceof xlc.b) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((xlc.b) r3).getWRDSSubKey(), this.a) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L16;
        this.b.invoke(r3);
        return;
    }
}

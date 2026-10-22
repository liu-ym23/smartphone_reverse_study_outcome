package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements a {
    public final b a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "MoreLiveEntranceInfoValidProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        if (this.a.b().m == null) goto L15;
        com.bytedance.android.live.base.model.moreliveentrance.b r0 = this.a.b().m;
        if (r0 == null) goto L16;
        String r1 = r0.e();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 != true) goto L18;
        return true;
    L18:
        return false;
    L11:
        r2 = false;
        goto L12
    L16:
        return false;
    L15:
        return false;
    }

    public c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
    }
}

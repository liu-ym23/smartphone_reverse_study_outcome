package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements a {
    public final b a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "MoreLiveFloatViewEnterProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        if (this.a.b().d == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.b().e == false) goto L7;
        return true;
    }

    public e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
    }
}

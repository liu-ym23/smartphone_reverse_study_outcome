package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements a {
    public final b a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "LiveTabEnterRoomSourceProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        return this.a.b().c;
    }

    public g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
    }
}

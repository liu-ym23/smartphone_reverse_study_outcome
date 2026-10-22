package com.bytedance.android.live.room.discovery.stable;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.broadcast.api.stable.b {
    public final void getPriority() {
    }

    public a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
    }

    public final int compareTo(Object r2) {
        com.bytedance.android.live.broadcast.api.stable.b r3 = (com.bytedance.android.live.broadcast.api.stable.b) r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        return com.bytedance.android.live.broadcast.api.stable.b.a.a(this, r3);
    }
}

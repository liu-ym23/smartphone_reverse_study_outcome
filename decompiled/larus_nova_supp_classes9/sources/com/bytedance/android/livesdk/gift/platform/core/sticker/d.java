package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import kc0.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final j b;

    public static final class a {
    }

    static {
    }

    public d(com.bytedance.android.livesdk.revenue.service.room.c r2) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        this.a = r2;
        this.b = null;
        new Handler();
    }
}

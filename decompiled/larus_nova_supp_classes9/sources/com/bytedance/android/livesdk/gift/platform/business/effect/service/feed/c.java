package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final zy0.d a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        vy0.b r0 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Intrinsics.checkNotNullParameter(r3, "$this$toUri");
        return r0.U0(r2, UriProtector.parse(r3), null);
    }
}

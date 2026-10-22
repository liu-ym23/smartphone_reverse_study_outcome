package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static float a(String r4) {
        if (r4 != null) goto L9;
        return 0.0f;
    L9:
        return (float) (((double) MathKt.roundToInt((com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).l4(r4) / 1048576.0f) * 10)) / 10.0d);
    L11:
        return 0.0f;
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "assetMd5");
        GiftResourceFileCacheService r0 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        r0.c.put(r2, r2);
        return;
    L13:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "assetPath");
        uy0.b r0 = com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        String r1 = r0.o(r2);
        r0.J(r2);
        GiftResourceFileCacheService r3 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L13;
        r3.c.remove(r1);
        return;
    L13:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}

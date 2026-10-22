package com.larus.ugc.feed.impl.viewholder;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.settings.value.na;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m0 {
    public static final boolean a = false;

    static {
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new na())).booleanValue() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        a = r2;
        boolean r3 = w0a.a.a;
        w0a.a.c("CreationViewHolderUtils", "use is 4_3:" + r2);
        return;
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
        r2 = true;
        goto L8
    }

    public static ResizeOptions a() {
        if (z2.a.getCreationPreviewPerformanceOptConfig().g == true) goto L7;
        return null;
    L7:
        return new ResizeOptions(i5.q(), i5.q());
    }

    public static int b(final Integer r9, final Integer r10, final int r11, final String r12) {
        Intrinsics.checkNotNullParameter(r12, "trackTag");
        boolean r0 = a;
        if (r0 == false) goto L5;
        float r1 = 1.3333334f;
    L6:
        if (r0 == false) goto L8;
        float r2 = 0.75f;
    L9:
        int r3 = RangesKt.coerceAtMost(r11, 100000);
        float r4 = r3;
        float r5 = r1 * r4;
        if (r9 == null) goto L23;
        if (r10 == null) goto L23;
        if (r9.intValue() == 0) goto L23;
        if (r3 == (-1)) goto L23;
        float r6 = (r3 * r10.intValue()) / r9.intValue();
        if (r6 > r5) goto L23;
        r5 = r4 * r2;
        if (r6 < r5) goto L23;
        r5 = r6;
    L23:
        final int r7 = RangesKt.coerceAtMost((int) r5, 100000);
        w0a.a.a("CreationViewHolderUtils", new l0(r12, r9, r10, r11, r7));
        return r7;
    L8:
        r2 = 0.5625f;
        goto L9
    L5:
        r1 = 1.7777778f;
        goto L6
    }
}

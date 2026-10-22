package com.larus.community.impl.viewholder;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0 {
    public static final boolean a = false;

    static {
        if (z2.a.creationFeedThumbRatioLimit43() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        boolean r1 = m29.a.a;
        m29.a.c("CreationViewHolderUtils", "use is 4_3:" + r0);
        return;
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
        r0 = true;
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
        final Ref.FloatRef r8 = new Ref.FloatRef();
        float r3 = r11;
        float r4 = r1 * r3;
        r8.element = r4;
        if (r9 == null) goto L25;
        if (r10 == null) goto L25;
        if (r9.intValue() == 0) goto L25;
        if (r11 == (-1)) goto L25;
        float r5 = (r10.intValue() * r11) / r9.intValue();
        if (r5 > r4) goto L23;
        r4 = r3 * r2;
        if (r5 < r4) goto L23;
        r4 = r5;
    L23:
        r8.element = r4;
        m29.a.a("CreationViewHolderUtils", new q0(r12, r9, r10, r11, r8));
    L25:
        return (int) r8.element;
    L8:
        r2 = 0.5625f;
        goto L9
    L5:
        r1 = 1.7777778f;
        goto L6
    }
}

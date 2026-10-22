package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final boolean a() {
        return ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager().e();
    }

    public static final boolean b() {
        Integer r0 = (Integer) vh6.c.b(tr2.a.class).Qm(0);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public static final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager().i(r1);
    }
}

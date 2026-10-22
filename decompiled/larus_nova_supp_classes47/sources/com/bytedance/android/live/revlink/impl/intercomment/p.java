package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements com.bytedance.android.livesdk.log.filter.m {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public p(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void a(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        d31.d r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r0.Do();
    L6:
        if (r2 == null) goto L8;
        int r3 = r2.getCurrentMode();
    L10:
        if (com.bytedance.android.live.utils.c.a(r3, 4) == false) goto L12;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.a;
        if (r5 == null) goto L16;
        r1 = r5.getRevLinkLogHelper();
    L16:
        if (r1 == null) goto L20;
        r4.putAll(r1.i());
        return;
    L20:
        return;
    L12:
        if (com.bytedance.android.live.utils.c.a(r3, 64) == true) goto L13;
        return;
    L8:
        r3 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}

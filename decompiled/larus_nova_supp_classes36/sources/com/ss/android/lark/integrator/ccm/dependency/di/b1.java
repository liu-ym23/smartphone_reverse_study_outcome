package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.ss.android.lark.location.dto.LarkLocation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b1 implements ew4.p {
    public final /* synthetic */ com.ss.android.lark.location.service.g.a a;
    public final /* synthetic */ z0 b;

    public b1(LocationHelper.d.a r1, z0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(ew4.o r3) {
        com.ss.android.lark.location.service.g.a r0 = this.a;
        if (r0 == null) goto L9;
        if (r3 == null) goto L6;
        LarkLocation r4 = z0.h(this.b, r3);
    L7:
        r0.a(r4);
        return;
    L6:
        r4 = null;
        goto L7
    }
}

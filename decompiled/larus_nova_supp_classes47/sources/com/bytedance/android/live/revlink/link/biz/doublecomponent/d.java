package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements g41.a {
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d a;

    @Override // g41.a
    public final boolean a() {
        b03.a r0 = b03.a.a;
        if (b03.a.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.r9() == true) goto L7;
        return true;
    }

    @Override // g41.a
    public final boolean isPortrait() {
        b03.a r0 = b03.a.a;
        return b03.a.c();
    }

    public d(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}

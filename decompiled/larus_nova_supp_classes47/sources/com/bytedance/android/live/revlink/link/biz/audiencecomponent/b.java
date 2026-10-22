package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import f31.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.revlink.impl.region.a {
    public final k a;

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int a() {
        return this.a.f;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int b() {
        return this.a.d;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final String c() {
        String r0 = this.a.a;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int d() {
        return this.a.e;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int e() {
        return this.a.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final String getUserID() {
        return this.a.b;
    }

    public b(k r2) {
        Intrinsics.checkNotNullParameter(r2, "windowStatus");
        this.a = r2;
    }
}

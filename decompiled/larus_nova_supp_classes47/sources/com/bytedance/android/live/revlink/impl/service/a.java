package com.bytedance.android.live.revlink.impl.service;

import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends i11.c.a {
    public final p11.a a;

    public a(c r1) {
        this.a = r1;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r2, List<? extends p> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r3, "list");
        p11.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}

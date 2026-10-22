package com.larus.ugc.feed.impl.mapper;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import kotlin.jvm.internal.Intrinsics;
import m0a.k;
import zp9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements k {
    public final m a;

    public b(m r1) {
        this.a = r1;
    }

    @Override // m0a.k
    public final boolean a(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        m r0 = this.a;
        if (r0 == null) goto L7;
        r0.i(c.d(r2));
        return false;
    L7:
        return false;
    }

    @Override // m0a.k
    public final boolean b(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        m r0 = this.a;
        if (r0 == null) goto L7;
        r0.d(c.d(r2));
        return false;
    L7:
        return false;
    }
}

package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.rustclient.api.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements d {
    public final l a;

    public h(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.d
    public final l a(com.larksuite.framework.http.v2.d r2) {
        Intrinsics.checkNotNullParameter(r2, "userCookieStrategy");
        if ((r2 instanceof com.larksuite.framework.http.v2.d.b) == true) goto L14;
        if ((r2 instanceof com.larksuite.framework.http.v2.d.c) == true) goto L14;
        if ((r2 instanceof com.larksuite.framework.http.v2.d.a) == false) goto L12;
        throw new IllegalArgumentException("LarkHttp can't apply custom user cookie strategy in user scope.");
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return this.a;
    }
}

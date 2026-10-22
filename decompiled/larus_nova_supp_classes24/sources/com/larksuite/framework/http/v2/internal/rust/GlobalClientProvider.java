package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.rustclient.api.a0;
import com.bytedance.lark.rustclient.api.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class GlobalClientProvider implements d {
    public final com.bytedance.lark.rustclient.api.h a;
    public final Function0<String> b;

    @Override // com.larksuite.framework.http.v2.internal.rust.d
    public final l a(final com.larksuite.framework.http.v2.d r3) {
        Intrinsics.checkNotNullParameter(r3, "userCookieStrategy");
        if ((r3 instanceof com.larksuite.framework.http.v2.d.b) == false) goto L5;
    L12:
        Function0<String> r0 = this.b;
    L13:
        com.bytedance.lark.rustclient.api.h r4 = this.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r0, "uidProvider");
        return new a0(r4, r0);
    L5:
        if ((r3 instanceof com.larksuite.framework.http.v2.d.c) == true) goto L12;
        if ((r3 instanceof com.larksuite.framework.http.v2.d.a) == false) goto L11;
        r0 = new GlobalClientProvider$provideClient$uid$1(r3);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public GlobalClientProvider(com.bytedance.lark.rustclient.api.h r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "globalClient");
        Intrinsics.checkNotNullParameter(r3, "uidProvider");
        this.a = r2;
        this.b = r3;
    }
}

package com.lark.kmp.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements com.lark.kmp.rustclient.api.c {
    public final String a;

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scopeUserId");
        this.a = r2;
    }

    @Override // com.lark.kmp.rustclient.api.c
    public final boolean a(rpc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "push");
        String r3 = this.a;
        rpc.a r0 = a.a;
        Intrinsics.checkNotNullParameter(r3, "userId");
        return Intrinsics.areEqual(r3, "absent_user");
    }
}

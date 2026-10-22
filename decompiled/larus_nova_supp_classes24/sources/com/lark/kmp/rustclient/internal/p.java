package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p extends BaseRustDispatcher {
    public final void h(rpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        k(r2);
    }

    public final void i(rpc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        j(r2);
    }

    public p(List<? extends com.lark.kmp.rustclient.api.c> r2, r r3) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r3, "definition");
        super(r2, r3.c(), r3.a());
    }
}

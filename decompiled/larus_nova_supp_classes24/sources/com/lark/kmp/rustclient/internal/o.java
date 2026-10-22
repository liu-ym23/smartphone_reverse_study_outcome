package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o extends BaseRustClient implements com.lark.kmp.rustclient.api.b {
    public final gy7.f e;
    public final p f;

    @Override // com.lark.kmp.rustclient.internal.BaseRustClient
    public final s c() {
        return this.f;
    }

    public o(r r2, com.lark.kmp.rustclient.api.f r3, com.lark.kmp.rustclient.api.e r4, t r5, List<? extends com.lark.kmp.rustclient.api.g> r6, List<? extends com.lark.kmp.rustclient.api.c> r7, gy7.f r8) {
        Intrinsics.checkNotNullParameter(r2, "definition");
        Intrinsics.checkNotNullParameter(r3, "rustSDK");
        Intrinsics.checkNotNullParameter(r4, "containerHolder");
        Intrinsics.checkNotNullParameter(r5, "receiverRegistry");
        Intrinsics.checkNotNullParameter(r6, "invokeInterceptors");
        Intrinsics.checkNotNullParameter(r7, "pushInterceptors");
        Intrinsics.checkNotNullParameter(r2, "clientDef");
        super(r3, r4, CollectionsKt.plus(r6, CollectionsKt.listOf(new VerifyDataInterceptor(r2))));
        this.e = r8;
        p r9 = new p(r7, r2);
        this.f = r9;
        r5.b(r9);
    }
}

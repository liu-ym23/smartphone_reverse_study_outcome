package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.Sdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y implements com.lark.kmp.rustclient.api.f {
    public y() {
    }

    @Override // com.lark.kmp.rustclient.api.f
    public final InvokeResponse a(com.lark.kmp.rustclient.api.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        int r0 = spc.a.a;
        int r1 = r3.a;
        byte[] r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "data");
        return Sdk.Companion._invokeV2(r1, r4);
    }

    @Override // com.lark.kmp.rustclient.api.f
    public final void b(com.lark.kmp.rustclient.api.model.e r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        int r0 = spc.a.a;
        int r1 = r5.a;
        byte[] r2 = r5.b;
        long r3 = r5.c;
        Intrinsics.checkNotNullParameter(r2, "req");
        Sdk.Companion._invokeAsyncV2(r1, r2, r3);
    }
}

package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class BaseRustClient {
    public final com.lark.kmp.rustclient.api.f a;
    public final com.lark.kmp.rustclient.api.e b;
    public final List<com.lark.kmp.rustclient.api.g> c;
    public final Lazy d;

    public abstract s c();

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRustClient(com.lark.kmp.rustclient.api.f r2, com.lark.kmp.rustclient.api.e r3, List<? extends com.lark.kmp.rustclient.api.g> r4) {
        Intrinsics.checkNotNullParameter(r2, "rustSDK");
        Intrinsics.checkNotNullParameter(r3, "containerHolder");
        Intrinsics.checkNotNullParameter(r4, "inputInterceptors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new BaseRustClient$interceptors$2(this));
    }
}

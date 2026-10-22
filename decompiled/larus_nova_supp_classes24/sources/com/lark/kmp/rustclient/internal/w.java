package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w<Resp> {
    public final List<com.lark.kmp.rustclient.api.g> a;
    public final com.lark.kmp.rustclient.api.a<Resp> b;

    public final FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 a() {
        com.lark.kmp.rustclient.api.h r0 = new com.lark.kmp.rustclient.api.h(this.a, 0, this.b);
        com.lark.kmp.rustclient.a.a(r0.c.a, "start to async invoke.");
        return new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.b(this.b), new RustCall$enqueue$1(r0, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(List<? extends com.lark.kmp.rustclient.api.g> r2, com.lark.kmp.rustclient.api.a<Resp> r3) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r3, "input");
        this.a = r2;
        this.b = r3;
    }
}

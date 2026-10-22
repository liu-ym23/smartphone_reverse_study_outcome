package com.lark.kmp.rustclient.api;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h<Resp> {
    public final List<g> a;
    public final int b;
    public final a<Resp> c;

    public final Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> b(a<Resp> r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        if (this.b >= this.a.size()) goto L7;
        h<Resp> r0 = new h(this.a, this.b + 1, r4);
        return ((g) ListProtector.get(this.a, this.b)).a(r0);
    L7:
        throw new IllegalStateException("Interceptor chain exhausted");
    }

    public final Object a(a<Resp> r4, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r5) {
        if (this.b >= this.a.size()) goto L7;
        h<Resp> r0 = new h(this.a, this.b + 1, r4);
        return ((g) ListProtector.get(this.a, this.b)).b(r0, r5);
    L7:
        throw new IllegalStateException("Interceptor chain exhausted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends g> r2, int r3, a<Resp> r4) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r4, "input");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

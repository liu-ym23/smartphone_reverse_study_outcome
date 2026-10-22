package com.larksuite.framework.http.v2.internal.main;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements com.larksuite.framework.http.v2.c {
    public final OkHttpClient a;

    @Override // com.larksuite.framework.http.v2.c
    public final OkHttpClient getOriginal() {
        return this.a;
    }

    @Override // com.larksuite.framework.http.v2.c
    public final a a(Request r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "spec");
        l r4 = this.a.newCall(r2);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type okhttp3.RealCall");
        return new a(r4);
    }

    public b(OkHttpClient r2, com.larksuite.framework.http.v2.c.b r3, LarkHttpImpl r4) {
        Intrinsics.checkNotNullParameter(r2, "original");
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intrinsics.checkNotNullParameter(r4, "http");
        this.a = r2;
    }
}

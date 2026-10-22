package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.pb.improto.Command;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements com.ss.android.lark.officesdk.minutes.service.foundation.network.a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.a a;
    public final g b;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void c(Command r4) {
        Intrinsics.checkNotNullParameter(r4, "command");
        g r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "command");
        if (r1.d("server_push", r4.getName()) == true) goto L6;
        this.a.c(r4);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void d(com.bytedance.lark.pb.basic.v1.Command r4) {
        Intrinsics.checkNotNullParameter(r4, "command");
        g r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "command");
        if (r1.d("client_push", r4.getName()) == true) goto L6;
        this.a.d(r4);
        return;
    }

    public a(com.ss.android.lark.officesdk.minutes.service.foundation.network.core.e r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "real");
        Intrinsics.checkNotNullParameter(r3, "mockEngine");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> a(Command r4, Class<R> r5) {
        Intrinsics.checkNotNullParameter(r4, "command");
        Intrinsics.checkNotNullParameter(r5, "respType");
        g r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "command");
        Intrinsics.checkNotNullParameter(r5, "respType");
        r4.getName();
        r2.a();
        return this.a.a(r4, r5);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r4, Class<R> r5) {
        Intrinsics.checkNotNullParameter(r4, "command");
        Intrinsics.checkNotNullParameter(r5, "respType");
        g r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "command");
        Intrinsics.checkNotNullParameter(r5, "respType");
        r4.getName();
        r2.a();
        return this.a.b(r4, r5);
    }
}

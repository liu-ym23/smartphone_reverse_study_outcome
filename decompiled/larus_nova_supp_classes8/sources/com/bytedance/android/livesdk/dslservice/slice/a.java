package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.ecom.arch.slice.render.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public b a;

    public a() {
    }

    public final synchronized b a(q r2, r r3, yt1.r r4, Function2<? super q, ? super k, Unit> r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r3, "sliceView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r5, "onRelease");     // Catch: Throwable -> L10
        b r0 = this.a;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        int r1 = b.g;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r3, "sliceView");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r5, "onRelease");     // Catch: Throwable -> L10
        b r6 = new b(r3, r2);     // Catch: Throwable -> L10
        r6.a = r5;     // Catch: Throwable -> L10
        r6.c = r4;     // Catch: Throwable -> L10
        this.a = r6;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r6;
    L10:
        th = move-exception;
        throw th;
    }
}

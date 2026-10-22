package com.lark.wire;

import java.time.Duration;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n extends ProtoAdapter<Duration> {
    public static int n(Duration r5) {
        if (r5.getSeconds() >= 0) goto L8;
        if (r5.getNano() == 0) goto L8;
        return r5.getNano() - 1000000000;
    L8:
        return r5.getNano();
    }

    public static long o(Duration r5) {
        if (r5.getSeconds() >= 0) goto L8;
        if (r5.getNano() == 0) goto L8;
        return r5.getSeconds() + 1;
    L8:
        return r5.getSeconds();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Duration b(h0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        int r0 = r7.h();
        long r1 = 0;
        int r3 = 0;
    L3:
        int r4 = r7.nextTag();
        if (r4 == (-1)) goto L12;
        if (r4 != 1) goto L8;
        r1 = ((Number) ProtoAdapter.k.b(r7)).longValue();
        goto L3
    L8:
        if (r4 != 2) goto L9;
        r3 = ((Number) ProtoAdapter.h.b(r7)).intValue();
        goto L3
    L9:
        r7.m(r4);
        goto L3
    L12:
        r7.k(r0);
        return Duration.ofSeconds(r1, r3);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Duration c(g0 r8) {
        Intrinsics.checkNotNullParameter(r8, "reader");
        long r0 = r8.c();
        long r2 = 0;
        int r4 = 0;
    L3:
        int r5 = r8.e();
        if (r5 == (-1)) goto L12;
        if (r5 != 1) goto L8;
        r2 = ((Number) ProtoAdapter.k.c(r8)).longValue();
        goto L3
    L8:
        if (r5 != 2) goto L9;
        r4 = ((Number) ProtoAdapter.h.c(r8)).intValue();
        goto L3
    L9:
        r8.j(r5);
        goto L3
    L12:
        r8.d(r0);
        return Duration.ofSeconds(r2, r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Duration r7) {
        Duration r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "value");
        long r0 = o(r8);
        int r4 = 0;
        if (r0 == 0) goto L5;
        r4 = 0 + ProtoAdapter.k.l(1, Long.valueOf(r0));
    L5:
        int r9 = n(r8);
        if (r9 != 0) goto L8;
        return r4;
    L8:
        return r4 + ProtoAdapter.h.l(2, Integer.valueOf(r9));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r6, Duration r7) {
        Duration r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        long r0 = o(r8);
        if (r0 == 0) goto L5;
        ProtoAdapter.k.i(r6, 1, Long.valueOf(r0));
    L5:
        int r9 = n(r8);
        if (r9 == 0) goto L9;
        ProtoAdapter.h.i(r6, 2, Integer.valueOf(r9));
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r5, Duration r6) {
        Duration r7 = r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = n(r7);
        if (r0 == 0) goto L5;
        ProtoAdapter.h.j(r5, 2, Integer.valueOf(r0));
    L5:
        long r1 = o(r7);
        if (r1 == 0) goto L9;
        ProtoAdapter.k.j(r5, 1, Long.valueOf(r1));
        return;
    }

    public n(FieldEncoding r8, KClass<Duration> r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.Duration", r10, null, 48);
    }
}

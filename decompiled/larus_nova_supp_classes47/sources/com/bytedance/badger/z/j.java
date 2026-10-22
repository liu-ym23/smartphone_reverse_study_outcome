package com.bytedance.badger.z;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class j extends Lambda implements Function1 {
    final /* synthetic */ Long a;
    final /* synthetic */ long b;

    public j(Long r1, long r2) {
        this.a = r1;
        this.b = r2;
        super(1);
    }

    public Object invoke(Object r4) {
        com.bytedance.badger.t.c r5 = (com.bytedance.badger.t.c) r4;
        long r0 = this.a.longValue();
        r5.a.b(r0);
        long r1 = this.b;
        r5.a.b(r1);
        return Unit.INSTANCE;
    }
}

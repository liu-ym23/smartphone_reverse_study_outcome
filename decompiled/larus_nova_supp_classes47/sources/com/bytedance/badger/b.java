package com.bytedance.badger;

import com.bytedance.badger.t.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class b extends Lambda implements Function1 {
    final /* synthetic */ long a;

    public b(long r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r3) {
        long r0 = this.a;
        ((c) r3).a.b(r0);
        return Unit.INSTANCE;
    }
}

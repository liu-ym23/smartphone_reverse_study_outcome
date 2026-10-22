package com.bytedance.badger.y;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class f extends Lambda implements Function1 {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        super(1);
    }

    public Object invoke(Object r3) {
        com.bytedance.badger.t.c r4 = (com.bytedance.badger.t.c) r3;
        List r0 = g.a;
        r4.b(r0.size());
        r4.d(r0);
        return Unit.INSTANCE;
    }
}

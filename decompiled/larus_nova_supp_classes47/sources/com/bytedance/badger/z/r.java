package com.bytedance.badger.z;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class r extends Lambda implements Function1 {
    final /* synthetic */ int a;

    public r(int r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r2) {
        ((com.bytedance.badger.t.c) r2).b(this.a);
        return Unit.INSTANCE;
    }
}

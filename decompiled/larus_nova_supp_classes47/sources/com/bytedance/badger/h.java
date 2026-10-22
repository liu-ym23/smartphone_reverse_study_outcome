package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class h extends Lambda implements Function1 {
    final /* synthetic */ c a;

    public h(c r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r2) {
        ((com.bytedance.badger.t.c) r2).c(this.a.getDeviceId());
        return Unit.INSTANCE;
    }
}

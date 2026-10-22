package com.bytedance.badger.network;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class I extends Lambda implements Function0 {
    final /* synthetic */ J a;

    public I(J r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        b r0 = this.a.a;
        r0.c.a(new i.b(r0.a));
        return Unit.INSTANCE;
    }
}

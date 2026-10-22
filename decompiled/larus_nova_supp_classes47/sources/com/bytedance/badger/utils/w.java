package com.bytedance.badger.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class w extends Lambda implements Function0 {
    final /* synthetic */ e0 a;

    public w(e0 r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        e0 r0 = this.a;
        f0 r1 = r0.a;
        r1.k.a(r1.c, r0.b);
        return Unit.INSTANCE;
    }
}

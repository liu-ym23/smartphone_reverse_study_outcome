package com.bytedance.badger;

import com.bytedance.badger.t.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class g extends Lambda implements Function1 {
    final /* synthetic */ byte[] a;

    public g(byte[] r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r2) {
        byte[] r0 = this.a;
        ((c) r2).a.d(r0);
        return Unit.INSTANCE;
    }
}

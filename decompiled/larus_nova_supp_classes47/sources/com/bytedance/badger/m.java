package com.bytedance.badger;

import com.bytedance.badger.t.c;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class m extends Lambda implements Function1 {
    final /* synthetic */ int[] a;

    public m(int[] r1) {
        this.a = r1;
        super(1);
    }

    public final void a(c r2) {
        r2.d(ArraysKt.toList(this.a));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((c) r1);
        return Unit.INSTANCE;
    }
}

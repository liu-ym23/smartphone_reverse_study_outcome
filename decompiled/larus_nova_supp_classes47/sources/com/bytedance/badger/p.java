package com.bytedance.badger;

import com.bytedance.badger.t.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class p extends Lambda implements Function1 {
    final /* synthetic */ String a;

    public p(String r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r2) {
        ((c) r2).c(this.a);
        return Unit.INSTANCE;
    }
}

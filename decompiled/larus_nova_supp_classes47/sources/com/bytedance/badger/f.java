package com.bytedance.badger;

import com.bytedance.badger.t.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class f extends Lambda implements Function1 {
    final /* synthetic */ int a;

    public f(int r1) {
        this.a = r1;
        super(1);
    }

    public Object invoke(Object r2) {
        ((c) r2).b(this.a);
        return Unit.INSTANCE;
    }
}

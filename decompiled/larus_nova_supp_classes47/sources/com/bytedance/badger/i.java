package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class i extends Lambda implements Function1 {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    public i(String r1, c r2) {
        this.a = r1;
        this.b = r2;
        super(1);
    }

    public Object invoke(Object r2) {
        com.bytedance.badger.t.c r3 = (com.bytedance.badger.t.c) r2;
        r3.c(this.a);
        r3.b(this.b.getSceneId());
        return Unit.INSTANCE;
    }
}

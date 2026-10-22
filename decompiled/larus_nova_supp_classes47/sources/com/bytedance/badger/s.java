package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class s extends Lambda implements Function1 {
    final /* synthetic */ c a;
    final /* synthetic */ int b;

    public s(c r1, int r2) {
        this.a = r1;
        this.b = r2;
        super(1);
    }

    public Object invoke(Object r2) {
        com.bytedance.badger.t.c r3 = (com.bytedance.badger.t.c) r2;
        r3.b(this.a.getSceneId());
        r3.b(this.b);
        return Unit.INSTANCE;
    }
}

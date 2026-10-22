package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class L extends Lambda implements Function0 {
    final /* synthetic */ b a;
    final /* synthetic */ int b;

    public L(b r1, int r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        BadgerCore.Companion.getClass();
        int r0 = BadgerCore.updateFeatures$default(j.a(), this.a.b, this.b, false, 4, null);
        z0 r1 = d0.a;
        d0.d(this.a, r0, new K(this), null, 24);
        d0.c(this.a);
        return Unit.INSTANCE;
    }
}

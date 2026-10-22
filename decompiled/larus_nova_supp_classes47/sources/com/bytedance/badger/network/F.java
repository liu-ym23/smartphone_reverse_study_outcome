package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class F extends Lambda implements Function0 {
    final /* synthetic */ b a;

    public F(b r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        BadgerCore.Companion.getClass();
        int r0 = BadgerCore.updateFeatures$default(j.a(), this.a.b, 30000, false, 4, null);
        z0 r1 = d0.a;
        d0.d(this.a, r0, new D(this), new E(this), 16);
        return Unit.INSTANCE;
    }
}

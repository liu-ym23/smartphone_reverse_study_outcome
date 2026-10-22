package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class J extends Lambda implements Function0 {
    final /* synthetic */ b a;

    public J(b r1) {
        this.a = r1;
        super(0);
    }

    public Object invoke() {
        BadgerCore.Companion.getClass();
        BadgerCore r0 = j.a();
        b r1 = this.a;
        int r2 = r0.updateFeatures(r1.b, 30000, r1.i);
        z0 r3 = d0.a;
        d0.d(this.a, r2, new H(this), new I(this), 16);
        return Unit.INSTANCE;
    }
}

package com.bytedance.badger.z;

import com.bytedance.badger.data.IBadgerData;
import com.bytedance.badger.module.BadgerModuleBase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class u0 extends BadgerModuleBase {
    public u0() {
    }

    public static boolean b(Long r1, IBadgerData r2, long r3) {
        if (r1 == null) goto L6;
        int r0 = com.bytedance.badger.t.a.a;
        j r4 = new j(r1, r3);
        com.bytedance.badger.t.c r5 = new com.bytedance.badger.t.c(598148581);
        r4.invoke(r5);
        com.bytedance.badger.t.d r6 = r5.a(r2);
        if (r6.e() == false) goto L6;
        return com.bytedance.badger.t.d.f(r6);
    L6:
        return false;
    }
}

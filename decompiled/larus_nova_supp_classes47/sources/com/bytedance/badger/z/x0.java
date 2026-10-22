package com.bytedance.badger.z;

import com.bytedance.badger.module.BadgerModuleBase;
import java.util.Map;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0 {
    static {
    }

    public static void a(int r3, BadgerModuleBase r4) {
        Lazy r0 = w0.b;
        KProperty r1 = w0.a[0];
        if (((Map) r0.getValue()).containsKey(Integer.valueOf(r3)) == true) goto L8;
        if (r4 == null) goto L9;
        q r2 = new q(r3);
        com.bytedance.badger.t.c r5 = new com.bytedance.badger.t.c(901594402);
        r2.invoke(r5);
        r5.a(r4);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("registerExternalProvider: " + r3 + " is already occupied");
    }
}

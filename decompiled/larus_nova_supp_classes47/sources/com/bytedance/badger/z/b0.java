package com.bytedance.badger.z;

import com.bytedance.badger.data.DataString;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class b0 extends Lambda implements Function3 {
    final /* synthetic */ n0 a;

    public b0(n0 r1) {
        this.a = r1;
        super(3);
    }

    public Object invoke(Object r4, Object r5, Object r6) {
        long r0 = ((Number) r6).longValue();
        n0 r7 = this.a;
        DataString r2 = new DataString((String) r5);
        r7.getClass();
        return Boolean.valueOf(u0.b((Long) r4, r2, r0));
    }
}

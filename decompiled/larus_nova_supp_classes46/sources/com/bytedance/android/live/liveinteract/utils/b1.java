package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b1 {
    public final List<Long> a;
    public long b;

    public final boolean a() {
        us1.c r0 = (us1.c) vm2.i.G.getValue(null, vm2.i.a[31]);
        i97.a r1 = i97.a.a;
        long r2 = System.currentTimeMillis();
        if ((r2 - this.b) > (r0.p8() * 1000)) goto L5;
        return false;
    L5:
        ((ArrayList) this.a).add(Long.valueOf(r2));
        if (((ArrayList) this.a).isEmpty() == false) goto L8;
    L14:
        return true;
    L8:
        if (((ArrayList) this.a).size() <= r0.getMaxCount()) goto L14;
        List<Long> r3 = this.a;
        if ((r2 - ((Number) ListProtector.get(r3, ((ArrayList) r3).size() - r0.getMaxCount())).longValue()) >= (r0.z2() * 1000)) goto L14;
        this.b = r2;
        return false;
    }

    public b1() {
        this.a = new ArrayList();
    }
}

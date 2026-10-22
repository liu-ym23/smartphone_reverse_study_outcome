package com.bytedance.badger.z;

import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0 implements a74.q {
    public final /* synthetic */ JSONObject[] a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData c;
    public final /* synthetic */ Long d;
    public final /* synthetic */ CountDownLatch e;
    public final /* synthetic */ String[] f;
    public final /* synthetic */ k0 g;

    public j0(k0 r1, JSONObject[] r2, AtomicBoolean r3, BadgerModuleBase.BadgerRequestData r4, Long r5, CountDownLatch r6, String[] r7) {
        this.g = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    @Override // a74.q
    public final void a(String r3) {
        this.f[0] = r3;
        this.e.countDown();
    }

    @Override // a74.q
    public final void a(JSONObject r9) {
        this.a[0] = r9;
        if (this.b.get() == false) goto L7;
        k0 r0 = this.g;
        Long r2 = Long.valueOf(this.c.getToken());
        DataJson r3 = new DataJson(r9);
        long r4 = System.currentTimeMillis() - this.d.longValue();
        r0.getClass();
        boolean r10 = u0.b(r2, r3, r4);
        com.bytedance.badger.e.g("sensor#", "compensate status " + r10);
        if (r10 == false) goto L8;
        com.bytedance.badger.network.z0 r12 = com.bytedance.badger.network.d0.a;
        com.bytedance.badger.network.d0.b(23, z64.h.b.a, new i0(), true);
    L8:
        this.e.countDown();
        return;
    L7:
        com.bytedance.badger.e.g("sensor#", " not compensate!");
        goto L8
    }
}

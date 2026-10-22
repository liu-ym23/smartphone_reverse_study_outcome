package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d1 extends u0 {
    public Long a;

    public d1() {
    }

    public static BadgerResult c(com.bytedance.badger.x.y r8) {
        String r0 = r8.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length();
    L7:
        if (r2 <= 3) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L22;
        Pair[] r4 = new Pair[3];
        r4[0] = TuplesKt.to(DataType.TRUE, r8.d);
        r4[1] = TuplesKt.to("2", r8.e);
        com.bytedance.badger.x.z r9 = r8.c;
        boolean r5 = r9.a;
        if (r5 == true) goto L14;
    L16:
        if (r5 == false) goto L19;
        r1 = 2;
    L21:
        r4[2] = TuplesKt.to("3", Integer.valueOf(r1));
        return new BadgerResult.Success(new DataJson(com.bm.badgervi.b.f(r4)));
    L19:
        if (r9.b == false) goto L21;
        r1 = 1;
        goto L21
    L14:
        if (r9.b == false) goto L16;
        r1 = 3;
        goto L21
    L22:
        int r6 = r8.a;
        String r10 = r8.b;
        if (r10.length() <= 25) goto L26;
        r10 = r10.substring(0, 25);
    L26:
        return new BadgerResult.Failure(r6, r10);
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = 0;
        goto L7
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r19, BadgerModuleBase.BadgerRequestData r20) {
        long r4 = System.currentTimeMillis();
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = null;
        AtomicBoolean r8 = new AtomicBoolean(false);
        com.bytedance.badger.x.f0.h.getClass();
        Lazy r9 = com.bytedance.badger.x.f0.g;
        KProperty r0 = com.bytedance.badger.x.x.a[0];
        com.bytedance.badger.x.f0 r1 = (com.bytedance.badger.x.f0) r9.getValue();
        r1.getClass();
        com.bytedance.badger.x.z r15 = new com.bytedance.badger.x.z(com.bytedance.badger.x.f0.g(), com.bytedance.badger.x.p.d(r19));
        this.a = null;     // Catch: Throwable -> L12
        com.bytedance.badger.e.b("DeviceFingerprint1Provider", "getInfoV2 start");     // Catch: Throwable -> L12
        CountDownLatch r10 = new CountDownLatch(1);     // Catch: Throwable -> L12
        r1.e(r19, new c1(this, r8, r6, r10));     // Catch: Throwable -> L12
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L12
        com.bytedance.badger.v.g r2 = com.bytedance.badger.v.d.h;     // Catch: Throwable -> L12
        KProperty r12 = com.bytedance.badger.v.d.a[7];     // Catch: Throwable -> L12
        com.bytedance.badger.v.w r3 = (com.bytedance.badger.v.w) r2.a();     // Catch: Throwable -> L12
        if (r10.await(r3.a, r3.b) == true) goto L11;
        this.a = Long.valueOf(r20.getToken());     // Catch: Throwable -> L12
        boolean r7 = true;
        r6.element = new com.bytedance.badger.x.y(BadgerResult.ERROR_AWAIT_TIMEOUT, "timeout", r15, null, null, 56);     // Catch: Throwable -> L9
    L15:
        r8.set(r7);
        StringBuilder r5 = new StringBuilder("getInfoV2 result= ");
        com.bytedance.badger.x.y r13 = (com.bytedance.badger.x.y) r6.element;
        if (r13 == null) goto L18;
        String r14 = r13.b;
    L19:
        r5.append(r14);
        com.bytedance.badger.e.b("DeviceFingerprint1Provider", r5.toString());
        com.bytedance.badger.x.y r16 = (com.bytedance.badger.x.y) r6.element;
        if (r16 == null) goto L33;
        com.bytedance.badger.x.f0.f("getInfo", r16, System.currentTimeMillis() - r4, null, null);
        return c(r16);
    L33:
        return new BadgerResult.Failure(BadgerResult.ERROR, "DeviceFp1Task onFailure");
    L18:
        r14 = null;
    L9:
        th = th;
    L31:
        com.bytedance.badger.e.c("DeviceFingerprint1Provider", "DeviceFp1Task  " + th.getClass().getName() + ' ' + th.getMessage(), th);     // Catch: Throwable -> L24
        r6.element = new com.bytedance.badger.x.y(BadgerResult.ERROR_AWAIT_TIMEOUT, "timeout", r15, null, null, 56);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r8.set(r7);
        throw th;
    L11:
        r7 = true;
    L12:
        th = th;
        r7 = true;
        goto L31
    }
}

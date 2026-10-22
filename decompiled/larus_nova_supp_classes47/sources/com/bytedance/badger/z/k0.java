package com.bytedance.badger.z;

import android.content.Context;
import android.os.Looper;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0 extends u0 {
    public k0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r18, BadgerModuleBase.BadgerRequestData r19) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        CountDownLatch r1 = new CountDownLatch(1);
        JSONObject[] r12 = new JSONObject[1];
        String[] r13 = new String[1];
        AtomicBoolean r14 = new AtomicBoolean(false);
        Long r8 = Long.valueOf(System.currentTimeMillis());
        a74.p.b(r18.getApplicationContext());     // Catch: Exception -> L34
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.h r3 = com.bytedance.badger.v.d.O;
        KProperty[] r15 = com.bytedance.badger.v.d.a;
        KProperty r4 = r15[41];
        int r10 = ((Number) r3.a()).intValue();
        com.bytedance.badger.v.h r5 = com.bytedance.badger.v.d.P;
        KProperty r6 = r15[42];
        a74.p.a(r10, ((Number) r5.a()).intValue(), new j0(this, r12, r14, r19, r8, r1, r13));
        com.bytedance.badger.v.k r2 = com.bytedance.badger.v.d.N;     // Catch: InterruptedException -> L32
        KProperty r7 = r15[40];     // Catch: InterruptedException -> L32
        if ((!r1.await(((Number) r2.a()).longValue(), TimeUnit.MILLISECONDS)) == false) goto L13;
        r14.set(true);     // Catch: InterruptedException -> L32
        return new BadgerResult.Failure(-1002, "Timeout waiting for sensor data.");
    L13:
        String r9 = r13[0];     // Catch: InterruptedException -> L32
        if (r9 == null) goto L27;
        if ("context_null".equals(r9) == true) goto L25;
        if ("bind_failed".equals(r13[0]) == true) goto L25;
        return new BadgerResult.Failure(-1003, "collection error: " + r13[0]);
    L25:
        return new BadgerResult.Failure(-1001, "Failed to bind to Service.");
    L27:
        if (r12[0] == null) goto L31;
        return new BadgerResult.Success(new DataJson(r12[0]));
    L31:
        return new BadgerResult.Failure(-1004, "Unknown error: received no data or error after wait.");
    L32:
        ThreadMethodProxy.currentThread().interrupt();
        return new BadgerResult.Failure(-1005, "Thread interrupted while waiting for sensor data.");
    L34:
        e = move-exception;
        return new BadgerResult.Failure(BadgerResult.ERROR, e.toString());
    L5:
        return new BadgerResult.Failure(-999, "cannot be called on the main thread.");
    }
}

package com.bytedance.badger.z;

import android.content.Context;
import android.os.Handler;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 extends u0 {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final e0 c = null;

    public h0() {
    }

    static {
        c = new e0();
        a = LazyKt.lazy(T.a);
        b = LazyKt.lazy(S.a);
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r17, BadgerModuleBase.BadgerRequestData r18) {
        if (com.bytedance.badger.utils.y.d() == false) goto L5;
        CountDownLatch r0 = new CountDownLatch(1);
        AtomicInteger r2 = new AtomicInteger(0);
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = "";
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = "";
        long r8 = System.currentTimeMillis();
        c.getClass();
        Lazy r3 = b;
        KProperty r4 = e0.a[1];
        com.bytedance.badger.utils.x r12 = new com.bytedance.badger.utils.x(r17, (Handler) r3.getValue());
        r12.b(new g0(this, r2, r14, r18, r8, r0, r12, r15));
        com.bytedance.badger.v.d.f0.getClass();
        com.bytedance.badger.v.g r1 = com.bytedance.badger.v.d.d0;
        KProperty r5 = com.bytedance.badger.v.d.a[56];
        com.bytedance.badger.v.w r6 = (com.bytedance.badger.v.w) r1.a();
        if (r0.await(r6.a, r6.b) == true) goto L10;
        r2.compareAndSet(0, 2);
        return new BadgerResult.Failure(BadgerResult.ERROR, "Timeout");
    L10:
        boolean r7 = false;
        if (((String) r15.element).length() != 0) goto L13;
        r7 = true;
    L13:
        if (r7 == true) goto L17;
        return new BadgerResult.Failure(-1001, (String) r15.element);
    L17:
        return new BadgerResult.Success(new DataString((String) r14.element));
    L5:
        return new BadgerResult.Failure(-999, "not support");
    }
}

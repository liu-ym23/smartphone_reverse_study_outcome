package com.bytedance.badger.z;

import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.IBadgerData;
import com.bytedance.badger.monitor.TriggerStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c1 implements com.bytedance.badger.x.b0 {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ CountDownLatch d;

    public c1(d1 r1, AtomicBoolean r2, Ref.ObjectRef r3, CountDownLatch r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.bytedance.badger.x.b0
    public final void a(com.bytedance.badger.x.y r12, long r13) {
        if (this.b.compareAndSet(false, true) == true) goto L12;
        Long r0 = this.a.a;
        BadgerResult r14 = d1.c(r12);
        if ((r14 instanceof BadgerResult.Success) == false) goto L10;
        if (r0 == null) goto L10;
        com.bytedance.badger.e.f("DeviceFingerprint1Provider", " onComplete after timeout");
        d1 r1 = this.a;
        IBadgerData r15 = ((BadgerResult.Success) r14).getData();
        r1.getClass();
        if (u0.b(r0, r15, r13) == false) goto L10;
        com.bytedance.badger.C.b r16 = x64.b.a;
        x64.b.a(new x64.l(TriggerStage.recollect, 16, false, com.bytedance.badger.C.a.e, null, null, 52), null);
    L10:
        this.a.a = null;
        return;
    L12:
        this.c.element = r12;
        this.d.countDown();
    }
}

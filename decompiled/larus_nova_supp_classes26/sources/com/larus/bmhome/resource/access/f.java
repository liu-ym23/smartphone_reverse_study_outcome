package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements b0, c0 {
    public final String a;
    public final r0 b;
    public final w c;
    public final StateFlowImpl d;
    public final StateFlowImpl e;
    public final long f;
    public volatile long g;
    public final AtomicReference<Job> h;
    public final ConcurrentHashMap<String, String> i;
    public final StateFlowImpl j;
    public final StateFlowImpl k;

    public final synchronized boolean c() {
        monitor-enter(this);
        boolean r0 = d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        a0 r0 = (a0) this.d.getValue();
        if ((r0 instanceof a0.d) == false) goto L5;
    L19:
        return true;
    L5:
        if ((r0 instanceof a0.c) == true) goto L19;
        if ((r0 instanceof a0.a) == true) goto L19;
        if (Intrinsics.areEqual(r0, a0.b.a) == false) goto L12;
    L18:
        return false;
    L12:
        if ((r0 instanceof a0.e) == true) goto L18;
        if ((r0 instanceof a0.f) == true) goto L18;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final z snapshot() {
        return new z(this.a, this.b, (a0) this.d.getValue(), this.c, this.f, this.g, (Map) this.e.getValue());
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final StateFlowImpl a() {
        return this.j;
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final StateFlowImpl b() {
        return this.k;
    }

    @Override // com.larus.bmhome.resource.access.b0
    public final String getTaskId() {
        return this.a;
    }

    public final synchronized boolean e(a0 r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "state");     // Catch: Throwable -> L12
        if (d() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.d.setValue(r3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(q0 r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "state");     // Catch: Throwable -> L6
        this.g = System.currentTimeMillis();     // Catch: Throwable -> L6
        StateFlowImpl r0 = this.e;     // Catch: Throwable -> L6
        r0.setValue(MapsKt.plus((Map) r0.getValue(), TuplesKt.to(r4.a, r4)));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.resource.access.c0
    public void update(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        e(r2);
    }

    public f(String r3, r0 r4, w r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "request");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        StateFlowImpl r6 = j1.a(a0.b.a);
        this.d = r6;
        StateFlowImpl r7 = j1.a(MapsKt.emptyMap());
        this.e = r7;
        long r0 = System.currentTimeMillis();
        this.f = r0;
        this.g = r0;
        this.h = new AtomicReference(null);
        this.i = new ConcurrentHashMap();
        this.j = r6;
        this.k = r7;
    }
}

package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements q3a.p {
    public final q3a.o a;
    public final String b;
    public r3a.l c;
    public final ReentrantReadWriteLock d;

    public static final class a {
    }

    static {
    }

    @Override // q3a.p
    public final void a() {
    }

    @Override // q3a.p
    public final void g() {
    }

    @Override // q3a.p
    public final void k(int r1) {
    }

    @Override // q3a.p
    public final void p(boolean r1, int r2) {
    }

    @Override // q3a.p
    public final void n() {
        b(new d());
    }

    @Override // q3a.p
    public final void r() {
        b(new c());
    }

    @Override // q3a.p
    public final String o() {
        return this.b;
    }

    public e(q3a.o r2) {
        Intrinsics.checkNotNullParameter(r2, "eventDispatcher");
        this.a = r2;
        this.b = "CameraStateManager";
        this.c = new b();
        this.d = new ReentrantReadWriteLock();
        r2.a(this);
    }

    public final void b(final r3a.l r12) {
        Intrinsics.checkNotNullParameter(r12, "newState");
        ReentrantReadWriteLock r2 = this.d;
        ReentrantReadWriteLock.ReadLock r3 = r2.readLock();
        int r5 = 0;
        if (r2.getWriteHoldCount() != 0) goto L5;
        int r4 = r2.getReadHoldCount();
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L9;
        r3.unlock();
        r6 = r6 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r7 = r2.writeLock();
        r7.lock();
        final r3a.l r8 = this.c;     // Catch: Throwable -> L20
        this.c = r12;     // Catch: Throwable -> L20
        FLogger.a.i("CameraStateManager", "State transition: " + r8.getTag() + " -> " + r12.getTag());     // Catch: Throwable -> L20
    L11:
        if (r5 >= r4) goto L13;
        r3.lock();
        r5 = r5 + 1;
        goto L11
    L13:
        r7.unlock();
        if (Intrinsics.areEqual(r8, r12) == true) goto L30;
        q3a.o r9 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "oldState");
        Intrinsics.checkNotNullParameter(r12, "newState");
        if (r9.c.get() == true) goto L31;
        FLogger.a.i("CameraEventDispatcher", "Dispatching state change: " + r8.getTag() + " -> " + r12.getTag());
        r9.c("onStateChanged", new q3a.i(r8, r12));
        return;
    L31:
        return;
    L30:
        return;
    L20:
        th = move-exception;
    L21:
        if (r5 >= r4) goto L23;
        r3.lock();
        r5 = r5 + 1;
        goto L21
    L23:
        r7.unlock();
        throw th;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "captureParams");
        b(new com.larus.voicecall.impl.component.vlm.camera.camera_state.a());
    }

    @Override // q3a.p
    public final void l(s3a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // q3a.p
    public final void s(r3a.i r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // q3a.p
    public final void t(r3a.j r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
    }

    @Override // q3a.p
    public final void h(r3a.l r2, r3a.l r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
    }
}

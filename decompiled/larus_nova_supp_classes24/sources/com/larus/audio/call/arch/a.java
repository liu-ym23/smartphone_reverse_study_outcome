package com.larus.audio.call.arch;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a<C extends c> {
    public final C a;
    public z0 b;
    public com.larus.im.service.audio.x c;
    public com.larus.im.service.audio.v d;
    public com.larus.audio.call.mgr.f.a e;

    public com.larus.audio.call.mgr.f.a P2() {
        return null;
    }

    public com.larus.im.service.audio.x Q2() {
        return null;
    }

    public com.larus.im.service.audio.v R2() {
        return null;
    }

    public z0 S2() {
        return null;
    }

    public abstract String T2();

    public void V2() {
    }

    public void W2() {
    }

    public void X2() {
    }

    public void Y2() {
    }

    public void Z2() {
    }

    public void a3() {
    }

    public void b3() {
    }

    public void c3() {
    }

    public void d3() {
    }

    public void f3() {
    }

    public void h3() {
    }

    public void g3() {
        z0 r0 = this.b;
        if (r0 == null) goto L7;
        id9.d r1 = this.a.j();
        if (r1 == null) goto L7;
        r1.n(r0);
    L7:
        com.larus.im.service.audio.v r2 = this.d;
        if (r2 == null) goto L12;
        id9.d r3 = this.a.j();
        if (r3 == null) goto L12;
        r3.b(r2);
    L12:
        com.larus.im.service.audio.x r4 = this.c;
        if (r4 == null) goto L17;
        id9.d r5 = this.a.j();
        if (r5 == null) goto L17;
        r5.d(r4);
    L17:
        com.larus.audio.call.mgr.f.a r6 = this.e;
        if (r6 == null) goto L20;
        this.a.a().V(r6);
    L20:
        this.b = null;
        this.d = null;
        this.e = null;
        this.c = null;
    }

    public final boolean i3() {
        MajorState r0 = this.a.a().s1();
        if ((r0 instanceof MajorState.c) == false) goto L5;
    L9:
        return false;
    L5:
        if ((r0 instanceof MajorState.a) == true) goto L9;
        if ((r0 instanceof MajorState.f) == true) goto L9;
        return true;
    }

    public void e3() {
        z0 r0 = S2();
        if (r0 == null) goto L8;
        id9.d r1 = this.a.j();
        if (r1 == null) goto L7;
        r1.q(r0);
    L7:
        this.b = r0;
    L8:
        com.larus.im.service.audio.x r2 = Q2();
        if (r2 == null) goto L14;
        id9.d r3 = this.a.j();
        if (r3 == null) goto L13;
        r3.x(r2);
    L13:
        this.c = r2;
    L14:
        com.larus.im.service.audio.v r4 = R2();
        if (r4 == null) goto L20;
        id9.d r5 = this.a.j();
        if (r5 == null) goto L19;
        r5.w(r4);
    L19:
        this.d = r4;
    L20:
        com.larus.audio.call.mgr.f.a r6 = P2();
        if (r6 == null) goto L24;
        this.a.a().M0(r6);
        this.e = r6;
        return;
    }

    public final C getContext() {
        return this.a;
    }

    public a(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final Job U2(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        CoroutineScope r1 = this.a.r();
        if (r1 == null) goto L5;
        Job r9 = BuildersKt.launch$default(r1, null, null, r8, 3, null);
    L6:
        if (r9 != null) goto L8;
        com.larus.audio.call.util.e.a.e(T2(), "launchDuplexCollect: lifecycleScope is null, duplex collect unavailable, duplexConsumerEnabled=" + com.larus.audio.call.f.f());
    L8:
        return r9;
    L5:
        r9 = null;
        goto L6
    }
}

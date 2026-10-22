package com.lark.kmp.rustclient.internal;

import com.lark.kmp.logger.LarkLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RustBarrier implements com.lark.kmp.rustclient.barrier.a {
    public final CoroutineScope a;
    public final buc.a b;
    public final MutexImpl c;
    public final List<Function1<Continuation<? super Unit>, Object>> d;
    public final MutexImpl e;
    public final Set<WeakReference<com.lark.kmp.rustclient.barrier.b>> f;

    public static final class a {
    }

    static {
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean b() {
        return e(false);
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean d() {
        return e(true);
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean c() {
        return this.b.c();
    }

    public RustBarrier() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.b = buc.b.a(true);
        this.c = kotlinx.coroutines.sync.b.a();
        this.d = new ArrayList();
        this.e = kotlinx.coroutines.sync.b.a();
        this.f = new LinkedHashSet();
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final void a(v.a r8) {
        Intrinsics.checkNotNullParameter(r8, "observer");
        BuildersKt.launch$default(this.a, null, null, new RustBarrier$addBarrierObserver$1(this, r8, null), 3, null);
    }

    public final boolean e(boolean r11) {
        LarkLogger r0 = LarkLogger.a;
        LarkLogger.c("RustBarrier", "updateBarrierState enableBarrier = " + r11 + ", current = " + this.b.c());
        ArrayList r1 = new ArrayList();
        boolean r2 = this.b.a(r11 ^ true, r11);
        if (r2 == false) goto L6;
        if (r11 == true) goto L6;
        BuildersKt.launch$default(this.a, null, null, new RustBarrier$updateBarrierState$1(this, r1, null), 3, null);
    L6:
        if (r2 == false) goto L8;
        boolean r12 = this.b.c();
        LarkLogger.c("RustBarrier", "notifyBarrierObservers, barrier = " + r12);
        BuildersKt.launch$default(this.a, null, null, new RustBarrier$notifyBarrierObservers$1(this, r12, null), 3, null);
    L9:
        return r2;
    L8:
        LarkLogger.b("RustBarrier", "updateBarrierState compareAndSet failed");
        goto L9
    }
}

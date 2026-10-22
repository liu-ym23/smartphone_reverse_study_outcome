package com.larus.audio.call;

import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class p {
    public final long a;
    public final long b;
    public boolean c;
    public long d;
    public final Object e;
    public CompletableJob f;

    public abstract void b();

    public abstract void c(long r1);

    public final void a() {
        Object r0 = this.e;
        monitor-enter(r0);
        this.c = true;     // Catch: Throwable -> L8
        Job.DefaultImpls.cancel$default(this.f, null, 1, null);     // Catch: Throwable -> L8
        this.f = SupervisorKt.SupervisorJob$default(null, 1, null);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d() {
        Object r0 = this.e;
        monitor-enter(r0);
        this.c = false;     // Catch: Throwable -> L13
        if (this.a > 0) goto L10;
        b();     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L10:
        this.d = 0;     // Catch: Throwable -> L13
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f.plus(Dispatchers.getMain())), null, null, new SupportPauseCountDownTimer$startTimerInner$1(this, 0, null), 3, null);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public p(long r1, long r3) {
        this.a = r1;
        this.b = r3;
        this.e = new Object();
        this.f = SupervisorKt.SupervisorJob$default(null, 1, null);
    }
}

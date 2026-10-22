package com.larus.power.state.impl;

import android.content.Context;
import com.larus.power.state.api.PowerStateService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wr9.e;
import wr9.i;
import wr9.j;
import xr9.a;
import xr9.c;
import xr9.d;
import xr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/power/state/impl/PowerStateServiceImpl;", "Lcom/larus/power/state/api/PowerStateService;", "clock", "Lcom/larus/power/state/api/PowerStateClock;", "<init>", "(Lcom/larus/power/state/api/PowerStateClock;)V", "()V", "lock", "", "engine", "Lcom/larus/power/state/impl/CachedPowerStateEngine;", "initialize", "", "context", "Landroid/content/Context;", "openSession", "Lcom/larus/power/state/api/PowerStateSession;", "config", "Lcom/larus/power/state/api/PowerStateMonitorConfig;", "latestSnapshot", "Lcom/larus/power/state/api/PowerStateSnapshot;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PowerStateServiceImpl implements PowerStateService {
    public final e b;
    public final Object c;
    public volatile c d;

    public PowerStateServiceImpl() {
        a r0 = a.a;
        Intrinsics.checkNotNullParameter(r0, "clock");
        this.b = r0;
        this.c = new Object();
    }

    @Override // wr9.h
    public final j o() {
        c r0 = this.d;
        if (r0 == null) goto L7;
        j r1 = r0.f.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return g.b(this.b.a(), "service_not_initialized");
    }

    @Override // com.larus.power.state.api.PowerStateService
    public final i a(wr9.g r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        c r1 = this.d;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "config");
        return new d(r1);
    L6:
        return new xr9.j(g.b(this.b.a(), "service_not_initialized"));
    }

    @Override // com.larus.power.state.api.PowerStateService
    public final void initialize(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.d == null) goto L5;
        return;
    L5:
        Object r0 = this.c;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.d != null) goto L10;
        c r1 = new c(new AndroidPowerStateEventSource(r5.getApplicationContext(), this.b), this.b);     // Catch: Throwable -> L13
        r1.d();     // Catch: Throwable -> L13
        this.d = r1;     // Catch: Throwable -> L13
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
    }
}

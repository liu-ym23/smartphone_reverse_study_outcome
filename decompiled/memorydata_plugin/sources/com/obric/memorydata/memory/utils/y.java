package com.obric.memorydata.memory.utils;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/utils/Waiter;", "", "<init>", "()V", "signal", "Lkotlinx/coroutines/channels/Channel;", "", "getSignal", "()Lkotlinx/coroutines/channels/Channel;", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.channels.i<Unit> f11570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f11571b;

    public y() {
        this.f11570a = kotlinx.coroutines.channels.l.a(0, null, null, 6, null);
    }

    public final kotlinx.coroutines.channels.i<Unit> a() {
        return this.f11570a;
    }

    public final void a(boolean r1) {
        this.f11571b = r1;
    }

    public final boolean b() {
        return this.f11571b;
    }
}

package com.obric.memorydata.memory;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryCancellationReportGate;", "", "<init>", "()V", "reported", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onDeleteFinished", "", "deleted", "onBuildCompleted", "cancelled", "hasEntity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f10045a;

    public a() {
        this.f10045a = new AtomicBoolean(false);
    }

    public final boolean a(boolean r3) {
        if (r3 == false) goto L8;
        if (this.f10045a.compareAndSet(false, true) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean a(boolean r3, boolean r4) {
        if (r3 == false) goto L9;
        if (r4 == true) goto L9;
        if (this.f10045a.compareAndSet(false, true) == false) goto L9;
        return true;
    L9:
        return false;
    }
}

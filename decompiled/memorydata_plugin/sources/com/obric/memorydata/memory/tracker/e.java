package com.obric.memorydata.memory.tracker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryLinkTimeHolder;", "", "<init>", "()V", "lastFinishInputTs", "", "getLastFinishInputTs", "()J", "setLastFinishInputTs", "(J)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f10541b;

    static {
        f10540a = new e();
    }

    private e() {
    }

    public final long a() {
        return f10541b;
    }

    public final void a(long r1) {
        f10541b = r1;
    }
}

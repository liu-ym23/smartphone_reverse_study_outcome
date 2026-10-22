package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final RxThreadFactory f9653h = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ThreadFactory f9654g;

    static {
        f9653h = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public d() {
        this(f9653h);
    }

    public d(ThreadFactory r10) {
        this.f9654g = r10;
    }

    @Override // xb.p
    public p.c a() {
        return new e(this.f9654g);
    }
}

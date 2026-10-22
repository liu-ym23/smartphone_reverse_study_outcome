package io.reactivex.internal.schedulers;

import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f18140c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RxThreadFactory f18141b;

    static {
        f18140c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public j() {
        this.f18141b = f18140c;
    }

    @Override // mt.z
    public final y a() {
        return new k(this.f18141b);
    }
}

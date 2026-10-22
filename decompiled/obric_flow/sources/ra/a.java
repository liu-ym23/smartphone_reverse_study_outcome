package ra;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f21711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f21713c;

    public a() {
        this.f21713c = new ReentrantLock();
    }
}

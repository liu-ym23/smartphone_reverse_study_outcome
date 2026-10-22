package com.obric.memorydata.personalcontext.impl.events;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils;", "", "<init>", "()V", "HISTORY_WINDOW_MS", "", "GALLERY_HISTORY_WINDOW_MS", "isHistory", "", "ts", "isGalleryHistory", "BurstSuppressor", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12198a = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "", "threshold", "", "windowMs", "", "<init>", "(IJ)V", "windowStartMs", "Ljava/util/concurrent/atomic/AtomicLong;", CommonConsts.COUNT_TYPE, "Ljava/util/concurrent/atomic/AtomicInteger;", "blockedUntilMs", "tryAcquire", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12200b;
        private final AtomicLong c;
        private final AtomicInteger d;
        private final AtomicLong e;

        public a(int r2, long r3) {
            this.f12199a = r2;
            this.f12200b = r3;
            this.c = new AtomicLong(0);
            this.d = new AtomicInteger(0);
            this.e = new AtomicLong(0);
        }

        public final boolean a() {
            long r0 = System.currentTimeMillis();
            long r2 = this.e.get();
            if (r2 <= 0) goto L8;
            if (r0 >= r2) goto L8;
            return false;
        L8:
            if ((r0 - this.c.get()) < this.f12200b) goto L11;
            this.c.set(r0);
            this.d.set(0);
            this.e.set(0);
        L11:
            if (this.d.incrementAndGet() < this.f12199a) goto L14;
            this.e.set(this.c.get() + this.f12200b);
            return false;
        L14:
            return true;
        }
    }

    static {
        f12198a = new b();
    }

    private b() {
    }

    public final boolean a(long r3) {
        if ((System.currentTimeMillis() - r3) <= 600000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(long r3) {
        if ((System.currentTimeMillis() - r3) <= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L5;
        return true;
    L5:
        return false;
    }
}

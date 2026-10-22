package ve;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12891b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12892c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12893d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12894e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<g> f12895a;
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        f12891b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
        f12892c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
        f12893d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
        f12894e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");
    }

    public m() {
        this.f12895a = new AtomicReferenceArray(128);
    }

    public final g a(g r8) {
        AtomicIntegerFieldUpdater r10 = f12892c;
        if ((r10.get(this) - f12893d.get(this)) != 127) goto L5;
        return r8;
    L5:
        boolean r11 = true;
        if (r8.f12879b.b() == 1) goto L9;
        r11 = false;
    L9:
        if (r11 == false) goto L11;
        f12894e.incrementAndGet(this);
    L11:
        int r12 = r10.get(this) & QesdkUtils.LIMITS.INT_8_UPPER;
    L12:
        AtomicReferenceArray<g> r13 = this.f12895a;
        if (r13.get(r12) == null) goto L15;
        Thread.yield();
        goto L12
    L15:
        r13.lazySet(r12, r8);
        r10.incrementAndGet(this);
        return null;
    }

    public final g b() {
    L2:
        AtomicIntegerFieldUpdater r8 = f12893d;
        int r10 = r8.get(this);
        if ((r10 - f12892c.get(this)) == 0) goto L4;
        int r11 = r10 & QesdkUtils.LIMITS.INT_8_UPPER;
        if (r8.compareAndSet(this, r10, r10 + 1) == false) goto L2;
        g r12 = this.f12895a.getAndSet(r11, null);
        if (r12 == null) goto L2;
        boolean r13 = true;
        if (r12.f12879b.b() == 1) goto L14;
        r13 = false;
    L14:
        if (r13 == false) goto L16;
        f12894e.decrementAndGet(this);
    L16:
        return r12;
    L4:
        return null;
    }

    public final g c(int r8, boolean r10) {
        int r11 = r8 & QesdkUtils.LIMITS.INT_8_UPPER;
        AtomicReferenceArray<g> r12 = this.f12895a;
        g r13 = r12.get(r11);
        if (r13 == null) goto L18;
        boolean r14 = false;
        if (r13.f12879b.b() != 1) goto L7;
        boolean r15 = true;
    L8:
        if (r15 != r10) goto L18;
    L10:
        if (r12.compareAndSet(r11, r13, null) == true) goto L11;
        if (r12.get(r11) == r13) goto L10;
    L14:
        if (r14 == false) goto L18;
        if (r10 == false) goto L17;
        f12894e.decrementAndGet(this);
    L17:
        return r13;
    L11:
        r14 = true;
        goto L14
    L7:
        r15 = false;
    L18:
        return null;
    }
}

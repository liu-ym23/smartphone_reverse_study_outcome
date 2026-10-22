package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    public static final /* synthetic */ AtomicLongFieldUpdater f = null;
    public static final g8.g g = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18944c;
    public final /* synthetic */ AtomicReferenceArray d;

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");
        f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");
        g = new g8.g("REMOVE_FROZEN", 10);
    }

    public m(int r5, boolean r10) {
        this.f18942a = r5;
        this.f18943b = r10;
        int r11 = r5 - 1;
        this.f18944c = r11;
        this.d = new AtomicReferenceArray(r5);
        if (r11 > 1073741823) goto L10;
        if ((r5 & r11) != 0) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.");
    L10:
        throw new IllegalStateException("Check failed.");
    }

    public final int a(Runnable r14) {
    L2:
        AtomicLongFieldUpdater r10 = f;
        long r5 = r10.get(this);
        if ((3458764513820540928L & r5) != 0) goto L5;
        int r11 = (int) (1073741823 & r5);
        int r12 = (int) ((1152921503533105152L & r5) >> 30);
        int r13 = this.f18944c;
        if (((r12 + 2) & r13) == (r11 & r13)) goto L10;
        AtomicReferenceArray r15 = this.d;
        if (this.f18943b == true) goto L21;
        if (r15.get(r12 & r13) == null) goto L21;
        int r16 = this.f18942a;
        if (r16 < 1024) goto L19;
        if (((r12 - r11) & 1073741823) <= (r16 >> 1)) goto L2;
    L19:
        return 1;
    L21:
        if (r10.compareAndSet(this, r5, ((-1152921503533105153L) & r5) | (((long) ((r12 + 1) & 1073741823)) << 30)) == false) goto L2;
        r15.set(r12 & r13, r14);
    L24:
        if ((r10.get(this) & 1152921504606846976L) == 0) goto L32;
        m this = this.c();
        AtomicReferenceArray r17 = this.d;
        int r18 = this.f18944c & r12;
        Object r19 = r17.get(r18);
        if ((r19 instanceof l) == true) goto L28;
    L30:
        this = null;
    L31:
        if (this != null) goto L24;
        return 0;
    L28:
        if (((l) r19).f18941a != r12) goto L30;
        r17.set(r18, r14);
        goto L31
    L32:
        return 0;
    L10:
        return 1;
    L5:
        if ((2305843009213693952L & r5) == 0) goto L50;
        return 2;
    L50:
        return 1;
    }

    public final boolean b() {
    L2:
        AtomicLongFieldUpdater r5 = f;
        long r10 = r5.get(this);
        if ((r10 & 2305843009213693952L) != 0) goto L4;
        if ((1152921504606846976L & r10) != 0) goto L7;
        if (r5.compareAndSet(this, r10, 2305843009213693952L | r10) == false) goto L2;
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    public final m c() {
    L2:
        AtomicLongFieldUpdater r10 = f;
        long r5 = r10.get(this);
        if ((r5 & 1152921504606846976L) != 0) goto L8;
        long r11 = r5 | 1152921504606846976L;
        if (r10.compareAndSet(this, r5, r11) == false) goto L2;
        r5 = r11;
    L8:
        AtomicReferenceFieldUpdater r12 = e;
        m r13 = (m) r12.get(this);
        if (r13 != null) goto L10;
        m r14 = new m(this.f18942a * 2, this.f18943b);
        int r15 = (int) (1073741823 & r5);
        int r16 = (int) ((1152921503533105152L & r5) >> 30);
    L12:
        int r17 = this.f18944c;
        int r18 = r15 & r17;
        if (r18 == (r17 & r16)) goto L18;
        Object r19 = this.d.get(r18);
        if (r19 != null) goto L17;
        r19 = new l(r15);
    L17:
        r14.d.set(r14.f18944c & r15, r19);
        r15 = r15 + 1;
        goto L12
    L18:
        r10.set(r14, (-1152921504606846977L) & r5);
    L20:
        if (r12.compareAndSet(this, null, r14) == true) goto L8;
        if (r12.get(this) == null) goto L20;
    L10:
        return r13;
    }

    public final Object d() {
    L3:
        AtomicLongFieldUpdater r5 = f;
        long r10 = r5.get(this);
        if ((r10 & 1152921504606846976L) != 0) goto L6;
        int r11 = (int) (r10 & 1073741823);
        int r12 = this.f18944c;
        int r13 = r11 & r12;
        if ((((int) ((1152921503533105152L & r10) >> 30)) & r12) == r13) goto L9;
        AtomicReferenceArray r15 = this.d;
        Object r14 = r15.get(r13);
        boolean r16 = this.f18943b;
        if (r14 == null) goto L12;
        if ((r14 instanceof l) == true) goto L16;
        long r17 = (r11 + 1) & 1073741823;
        if (r5.compareAndSet(this, r10, (r10 & (-1073741824)) | r17) == true) goto L19;
        if (r16 == false) goto L3;
        m r18 = this;
    L23:
        AtomicLongFieldUpdater r19 = f;
        long r20 = r19.get(r18);
        int r110 = (int) (r20 & 1073741823);
        if ((r20 & 1152921504606846976L) != 0) goto L25;
        if (r19.compareAndSet(r18, r20, (r20 & (-1073741824)) | r17) == false) goto L23;
        r18.d.set(r18.f18944c & r110, null);
        r18 = null;
    L29:
        if (r18 != null) goto L23;
        return r14;
    L25:
        r18 = r18.c();
        goto L29
    L19:
        r15.set(r13, null);
        return r14;
    L16:
        return null;
    L12:
        if (r16 == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return g;
    }
}

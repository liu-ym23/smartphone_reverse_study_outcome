package ue;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class n<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12615e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12616f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b9.a f12617g = null;
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f12621d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12622a;

        public a(int r8) {
            this.f12622a = r8;
        }
    }

    static {
        f12615e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");
        f12616f = AtomicLongFieldUpdater.newUpdater(n.class, "_state");
        f12617g = new b9.a("REMOVE_FROZEN", 4);
    }

    public n(int r8, boolean r10) {
        this.f12618a = r8;
        this.f12619b = r10;
        int r11 = r8 - 1;
        this.f12620c = r11;
        this.f12621d = new AtomicReferenceArray(r8);
        boolean r12 = false;
        if (r11 > 1073741823) goto L5;
        boolean r13 = true;
    L7:
        if (r13 == false) goto L16;
        if ((r8 & r11) != 0) goto L11;
        r12 = true;
    L11:
        if (r12 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r13 = false;
        goto L7
    }

    public final int a(E r17) {
        n<E> r8 = this;
    L3:
        AtomicLongFieldUpdater r10 = f12616f;
        long r11 = r10.get(r8);
        if ((3458764513820540928L & r11) != 0) goto L6;
        int r12 = (int) ((1073741823 & r11) >> 0);
        int r13 = (int) ((1152921503533105152L & r11) >> 30);
        int r14 = r8.f12620c;
        if (((r13 + 2) & r14) == (r12 & r14)) goto L11;
        boolean r15 = r8.f12619b;
        AtomicReferenceArray r16 = r8.f12621d;
        if (r15 == true) goto L22;
        if (r16.get(r13 & r14) == null) goto L22;
        int r18 = r8.f12618a;
        if (r18 < 1024) goto L20;
        if (((r13 - r12) & 1073741823) <= (r18 >> 1)) goto L3;
    L20:
        return 1;
    L22:
        if (f12616f.compareAndSet(this, r11, ((-1152921503533105153L) & r11) | (((long) ((r13 + 1) & 1073741823)) << 30)) == false) goto L3;
        r16.set(r13 & r14, r17);
    L25:
        if ((r10.get(r8) & 1152921504606846976L) == 0) goto L34;
        n<E> r19 = r8.c();
        AtomicReferenceArray r20 = r19.f12621d;
        int r21 = r19.f12620c & r13;
        Object r22 = r20.get(r21);
        if ((r22 instanceof a) == true) goto L29;
    L31:
        r19 = null;
    L32:
        r8 = r19;
        if (r8 != null) goto L25;
    L29:
        if (((a) r22).f12622a != r13) goto L31;
        r20.set(r21, r17);
    L34:
        return 0;
    L11:
        return 1;
    L6:
        if ((r11 & 2305843009213693952L) == 0) goto L49;
        return 2;
    L49:
        return 1;
    }

    public final boolean b() {
    L2:
        AtomicLongFieldUpdater r8 = f12616f;
        long r10 = r8.get(this);
        if ((r10 & 2305843009213693952L) != 0) goto L4;
        if ((1152921504606846976L & r10) != 0) goto L7;
        if (r8.compareAndSet(this, r10, 2305843009213693952L | r10) == false) goto L2;
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n<E> c() {
    L2:
        AtomicLongFieldUpdater r8 = f12616f;
        long r10 = r8.get(this);
        if ((r10 & 1152921504606846976L) != 0) goto L8;
        long r11 = r10 | 1152921504606846976L;
        if (r8.compareAndSet(this, r10, r11) == false) goto L2;
        r10 = r11;
    L8:
        AtomicReferenceFieldUpdater r12 = f12615e;
        n<E> r13 = (n) r12.get(this);
        if (r13 != null) goto L10;
        n r14 = new n(this.f12618a * 2, this.f12619b);
        int r15 = (int) ((1073741823 & r10) >> 0);
        int r16 = (int) ((1152921503533105152L & r10) >> 30);
    L12:
        int r17 = this.f12620c;
        int r18 = r15 & r17;
        if (r18 == (r17 & r16)) goto L18;
        Object r19 = this.f12621d.get(r18);
        if (r19 != null) goto L17;
        r19 = new a(r15);
    L17:
        r14.f12621d.set(r14.f12620c & r15, r19);
        r15 = r15 + 1;
        goto L12
    L18:
        r8.set(r14, (-1152921504606846977L) & r10);
    L20:
        if (r12.compareAndSet(this, null, r14) == true) goto L8;
        if (r12.get(this) == null) goto L20;
    L10:
        return r13;
    }

    public final Object d() {
    L3:
        AtomicLongFieldUpdater r8 = f12616f;
        long r10 = r8.get(this);
        if ((r10 & 1152921504606846976L) != 0) goto L6;
        int r11 = (int) ((r10 & 1073741823) >> 0);
        int r12 = this.f12620c;
        int r14 = r11 & r12;
        if ((((int) ((1152921503533105152L & r10) >> 30)) & r12) == r14) goto L9;
        AtomicReferenceArray r13 = this.f12621d;
        Object r15 = r13.get(r14);
        boolean r16 = this.f12619b;
        if (r15 == null) goto L12;
        if ((r15 instanceof a) == true) goto L16;
        long r17 = ((long) ((r11 + 1) & 1073741823)) << 0;
        if (r8.compareAndSet(this, r10, r17 | (r10 & (-1073741824))) == true) goto L19;
        if (r16 == false) goto L3;
        n<E> r18 = this;
    L23:
        AtomicLongFieldUpdater r19 = f12616f;
        long r20 = r19.get(r18);
        int r21 = (int) ((r20 & 1073741823) >> 0);
        if ((r20 & 1152921504606846976L) != 0) goto L25;
        if (r19.compareAndSet(r18, r20, (r20 & (-1073741824)) | r17) == false) goto L23;
        r18.f12621d.set(r18.f12620c & r21, null);
        r18 = null;
    L29:
        if (r18 != null) goto L23;
        return r15;
    L25:
        r18 = r18.c();
        goto L29
    L19:
        r13.set(r14, null);
        return r15;
    L16:
        return null;
    L12:
        if (r16 == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f12617g;
    }
}

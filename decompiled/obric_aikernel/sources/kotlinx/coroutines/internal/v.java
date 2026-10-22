package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
public final class v<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f10586e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10587f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10588g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final i0 f10589h = null;

    @Volatile
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReferenceArray f10593d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(long r10) {
            if ((r10 & 2305843009213693952L) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long b(long r10, int r11) {
            return d(r10, 1073741823) | (((long) r11) << 0);
        }

        public final long c(long r10, int r11) {
            return d(r10, 1152921503533105152L) | (((long) r11) << 30);
        }

        public final long d(long r10, long r11) {
            return r10 & (~r11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final int f10594a;

        public b(int r10) {
            this.f10594a = r10;
        }
    }

    static {
        f10586e = new a(null);
        f10587f = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_next");
        f10588g = AtomicLongFieldUpdater.newUpdater(v.class, "_state");
        f10589h = new i0("REMOVE_FROZEN");
    }

    public v(int r10, boolean r11) {
        this.f10590a = r10;
        this.f10591b = r11;
        int r12 = r10 - 1;
        this.f10592c = r12;
        this.f10593d = new AtomicReferenceArray(r10);
        boolean r13 = false;
        if (r12 > 1073741823) goto L5;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L16;
        if ((r10 & r12) != 0) goto L11;
        r13 = true;
    L11:
        if (r13 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r14 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final v<E> b(long r10) {
        v<E> r11 = new v(this.f10590a * 2, this.f10591b);
        int r12 = (int) ((1073741823 & r10) >> 0);
        int r13 = (int) ((1152921503533105152L & r10) >> 30);
    L3:
        int r14 = this.f10592c;
        if ((r12 & r14) == (r13 & r14)) goto L9;
        Object r15 = this.f10593d.get(r14 & r12);
        if (r15 != null) goto L8;
        r15 = new b(r12);
    L8:
        r11.f10593d.set(r11.f10592c & r12, r15);
        r12 = r12 + 1;
        goto L3
    L9:
        f10588g.set(r11, f10586e.d(r10, 1152921504606846976L));
        return r11;
    }

    private final v<E> c(long r10) {
        AtomicReferenceFieldUpdater r11 = f10587f;
    L3:
        v<E> r12 = (v) r11.get(this);
        if (r12 != null) goto L5;
        f10587f.compareAndSet(this, null, b(r10));
        goto L3
    L5:
        return r12;
    }

    private final v<E> e(int r10, E r11) {
        Object r12 = this.f10593d.get(this.f10592c & r10);
        if ((r12 instanceof b) == true) goto L5;
        return null;
    L5:
        if (((b) r12).f10594a != r10) goto L10;
        this.f10593d.set(r10 & this.f10592c, r11);
        return this;
    L10:
        return null;
    }

    private final long h() {
        AtomicLongFieldUpdater r10 = f10588g;
    L3:
        long r11 = r10.get(this);
        if ((r11 & 1152921504606846976L) != 0) goto L5;
        long r12 = r11 | 1152921504606846976L;
        if (r10.compareAndSet(this, r11, r12) == false) goto L3;
        return r12;
    L5:
        return r11;
    }

    private final v<E> k(int r11, int r12) {
        AtomicLongFieldUpdater r10 = f10588g;
    L3:
        long r13 = r10.get(this);
        a r14 = f10586e;
        boolean r15 = false;
        int r16 = (int) ((1073741823 & r13) >> 0);
        if (kotlinx.coroutines.n0.a() == false) goto L12;
        if (r16 != r11) goto L7;
        r15 = true;
    L7:
        if (r15 == true) goto L12;
        throw new AssertionError();
    L12:
        if ((1152921504606846976L & r13) != 0) goto L14;
        if (f10588g.compareAndSet(this, r13, r14.b(r13, r12)) == false) goto L3;
        this.f10593d.set(this.f10592c & r16, null);
        return null;
    L14:
        return i();
    }

    public final int a(E r15) {
        AtomicLongFieldUpdater r10 = f10588g;
    L3:
        long r11 = r10.get(this);
        if ((3458764513820540928L & r11) != 0) goto L6;
        a r12 = f10586e;
        int r13 = (int) ((1073741823 & r11) >> 0);
        int r14 = (int) ((1152921503533105152L & r11) >> 30);
        int r16 = this.f10592c;
        if (((r14 + 2) & r16) == (r13 & r16)) goto L9;
        if (this.f10591b == true) goto L20;
        if (this.f10593d.get(r14 & r16) == null) goto L20;
        int r17 = this.f10590a;
        if (r17 < 1024) goto L18;
        if (((r14 - r13) & 1073741823) <= (r17 >> 1)) goto L3;
    L18:
        return 1;
    L20:
        if (f10588g.compareAndSet(this, r11, r12.c(r11, (r14 + 1) & 1073741823)) == false) goto L3;
        this.f10593d.set(r14 & r16, r15);
    L23:
        if ((f10588g.get(this) & 1152921504606846976L) == 0) goto L26;
        v<E> this = this.i().e(r14, r15);
        if (this != null) goto L23;
    L26:
        return 0;
    L9:
        return 1;
    L6:
        return f10586e.a(r11);
    }

    public final boolean d() {
        AtomicLongFieldUpdater r10 = f10588g;
    L3:
        long r11 = r10.get(this);
        if ((r11 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r11) != 0) goto L8;
        if (r10.compareAndSet(this, r11, r11 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    public final int f() {
        long r10 = f10588g.get(this);
        int r11 = (int) ((1073741823 & r10) >> 0);
        return 1073741823 & (((int) ((r10 & 1152921503533105152L) >> 30)) - r11);
    }

    public final boolean g() {
        long r10 = f10588g.get(this);
        if (((int) ((1073741823 & r10) >> 0)) != ((int) ((r10 & 1152921503533105152L) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final v<E> i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater r10 = f10588g;
    L3:
        long r11 = r10.get(this);
        if ((1152921504606846976L & r11) != 0) goto L6;
        a r12 = f10586e;
        int r13 = (int) ((1073741823 & r11) >> 0);
        int r14 = (int) ((1152921503533105152L & r11) >> 30);
        int r15 = this.f10592c;
        if ((r14 & r15) == (r13 & r15)) goto L9;
        Object r16 = this.f10593d.get(r15 & r13);
        if (r16 == null) goto L13;
        if ((r16 instanceof b) == true) goto L17;
        int r17 = (r13 + 1) & 1073741823;
        if (f10588g.compareAndSet(this, r11, r12.b(r11, r17)) == true) goto L20;
        if (this.f10591b == false) goto L3;
    L24:
        v<E> this = this.k(r13, r17);
        if (this != null) goto L24;
        return r16;
    L20:
        this.f10593d.set(this.f10592c & r13, null);
        return r16;
    L17:
        return null;
    L13:
        if (this.f10591b == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f10589h;
    }
}

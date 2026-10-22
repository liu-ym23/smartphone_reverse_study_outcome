package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
public class n0<T extends o0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10566b = null;

    @Volatile
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T[] f10567a;

    static {
        f10566b = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_size");
    }

    public n0() {
    }

    private final T[] f() {
        T[] r10 = this.f10567a;
        if (r10 != null) goto L6;
        T[] r11 = (T[]) new o0[4];
        this.f10567a = r11;
        return r11;
    L6:
        if (c() < r10.length) goto L10;
        Object[] r12 = Arrays.copyOf(r10, c() * 2);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        T[] r13 = (T[]) ((o0[]) r12);
        this.f10567a = r13;
        return r13;
    L10:
        return r10;
    }

    private final void j(int r10) {
        f10566b.set(this, r10);
    }

    private final void k(int r10) {
    L2:
        int r11 = (r10 * 2) + 1;
        if (r11 >= c()) goto L4;
        T[] r12 = this.f10567a;
        Intrinsics.checkNotNull(r12);
        int r13 = r11 + 1;
        if (r13 >= c()) goto L10;
        T r14 = r12[r13];
        Intrinsics.checkNotNull(r14);
        T r15 = r12[r11];
        Intrinsics.checkNotNull(r15);
        if (((Comparable) r14).compareTo(r15) >= 0) goto L10;
        r11 = r13;
    L10:
        T r16 = r12[r10];
        Intrinsics.checkNotNull(r16);
        T r17 = r12[r11];
        Intrinsics.checkNotNull(r17);
        if (((Comparable) r16).compareTo(r17) <= 0) goto L12;
        m(r10, r11);
        r10 = r11;
        goto L2
    L12:
        return;
    }

    private final void l(int r10) {
    L2:
        if (r10 <= 0) goto L3;
        T[] r11 = this.f10567a;
        Intrinsics.checkNotNull(r11);
        int r12 = (r10 - 1) / 2;
        T r13 = r11[r12];
        Intrinsics.checkNotNull(r13);
        T r14 = r11[r10];
        Intrinsics.checkNotNull(r14);
        if (((Comparable) r13).compareTo(r14) <= 0) goto L6;
        m(r10, r12);
        r10 = r12;
        goto L2
    L6:
        return;
    }

    private final void m(int r10, int r11) {
        T[] r12 = this.f10567a;
        Intrinsics.checkNotNull(r12);
        T r13 = r12[r11];
        Intrinsics.checkNotNull(r13);
        T r14 = r12[r10];
        Intrinsics.checkNotNull(r14);
        r12[r10] = r13;
        r12[r11] = r14;
        r13.d(r10);
        r14.d(r11);
    }

    @PublishedApi
    public final void a(T r10) {
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        r10.a(this);
        o0[] r11 = f();
        int r12 = c();
        j(r12 + 1);
        r11[r12] = r10;
        r10.d(r12);
        l(r12);
        return;
    L5:
        if (r10.c() != null) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == true) goto L12;
        throw new AssertionError();
    L7:
        r13 = false;
        goto L8
    }

    @PublishedApi
    public final T b() {
        T[] r10 = this.f10567a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10[0];
    }

    public final int c() {
        return f10566b.get(this);
    }

    public final boolean d() {
        if (c() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T e() {
        monitor-enter(this);
        T r10 = (T) b();
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean g(T r10) {
        monitor-enter(this);
        boolean r11 = true;
        boolean r12 = false;
        if (r10.c() != null) goto L6;
        r11 = false;
    L15:
        monitor-exit(this);
        return r11;
    L6:
        int r13 = r10.getIndex();     // Catch: Throwable -> L17
        if (kotlinx.coroutines.n0.a() == false) goto L14;
        if (r13 < 0) goto L10;
        r12 = true;
    L10:
        if (r12 == true) goto L14;
        throw new AssertionError();     // Catch: Throwable -> L17
    L14:
        h(r13);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @PublishedApi
    public final T h(int r10) {
        boolean r11 = false;
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        T[] r12 = this.f10567a;
        Intrinsics.checkNotNull(r12);
        j(c() - 1);
        if (r10 >= c()) goto L20;
        m(r10, c());
        int r13 = (r10 - 1) / 2;
        if (r10 <= 0) goto L19;
        T r14 = r12[r10];
        Intrinsics.checkNotNull(r14);
        T r15 = r12[r13];
        Intrinsics.checkNotNull(r15);
        if (((Comparable) r14).compareTo(r15) >= 0) goto L19;
        m(r10, r13);
        l(r13);
    L19:
        k(r10);
    L20:
        T r16 = r12[c()];
        Intrinsics.checkNotNull(r16);
        if (kotlinx.coroutines.n0.a() == true) goto L23;
    L29:
        r16.a(null);
        r16.d(-1);
        r12[c()] = null;
        return r16;
    L23:
        if (r16.c() != this) goto L25;
        r11 = true;
    L25:
        if (r11 == true) goto L29;
        throw new AssertionError();
    L5:
        if (c() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 == true) goto L12;
        throw new AssertionError();
    L7:
        r17 = false;
        goto L8
    }

    public final T i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (c() <= 0) goto L7;
        T r10 = (T) h(0);
    L8:
        monitor-exit(this);
        return r10;
    L7:
        r10 = null;
        goto L8
    }
}

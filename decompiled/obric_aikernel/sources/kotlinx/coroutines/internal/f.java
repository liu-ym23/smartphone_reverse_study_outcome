package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.f;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
public abstract class f<N extends f<N>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10547c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10548g = null;

    @Volatile
    private volatile Object _next;

    @Volatile
    private volatile Object _prev;

    static {
        f10547c = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next");
        f10548g = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_prev");
    }

    public f(N r10) {
        this._prev = r10;
    }

    public static final /* synthetic */ Object a(f r10) {
        return r10.f();
    }

    private final N c() {
        N r10 = (N) g();
    L3:
        if (r10 == null) goto L7;
        if (r10.h() == false) goto L7;
        r10 = (N) f10548g.get(r10);
    L7:
        return r10;
    }

    private final N d() {
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L9:
        N r10 = (N) e();
        Intrinsics.checkNotNull(r10);
    L11:
        if (r10.h() == false) goto L16;
        f r11 = r10.e();
        if (r11 == null) goto L14;
        r10 = (N) r11;
        goto L11
    L14:
        return r10;
    L16:
        return r10;
    L5:
        if ((!i()) == true) goto L9;
        throw new AssertionError();
    }

    private final Object f() {
        return f10547c.get(this);
    }

    public final void b() {
        f10548g.lazySet(this, null);
    }

    public final N e() {
        Object r10 = a(this);
        if (r10 != e.a()) goto L7;
        return null;
    L7:
        return (N) r10;
    }

    public final N g() {
        return (N) f10548g.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        if (e() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j() {
        return f10547c.compareAndSet(this, null, e.a());
    }

    public final void k() {
        if (kotlinx.coroutines.n0.a() == false) goto L16;
        if (h() == false) goto L7;
    L10:
        boolean r10 = true;
    L11:
        if (r10 == true) goto L16;
        throw new AssertionError();
    L7:
        if (i() == true) goto L10;
        r10 = false;
    L16:
        if (i() == false) goto L18;
        return;
    L18:
        f r11 = c();
        f r12 = d();
        AtomicReferenceFieldUpdater r13 = f10548g;
    L19:
        Object r14 = r13.get(r12);
        if (((f) r14) != null) goto L22;
        f r15 = null;
    L24:
        if (r13.compareAndSet(r12, r14, r15) == false) goto L19;
        if (r11 == null) goto L28;
        f10547c.set(r11, r12);
    L28:
        if (r12.h() == false) goto L31;
        if (r12.i() == false) goto L18;
    L31:
        if (r11 == null) goto L44;
        if (r11.h() == true) goto L18;
        return;
    L44:
        return;
    L22:
        r15 = r11;
        goto L24
    }

    public final boolean l(N r10) {
        return f10547c.compareAndSet(this, null, r10);
    }
}

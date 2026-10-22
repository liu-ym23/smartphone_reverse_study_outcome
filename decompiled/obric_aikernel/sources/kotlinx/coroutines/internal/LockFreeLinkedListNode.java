package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10528c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10529g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10530h = null;

    @Volatile
    private volatile Object _next;

    @Volatile
    private volatile Object _prev;

    @Volatile
    private volatile Object _removedRef;

    @PublishedApi
    public static abstract class a extends b<LockFreeLinkedListNode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final LockFreeLinkedListNode f10531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public LockFreeLinkedListNode f10532c;

        public a(LockFreeLinkedListNode r10) {
            this.f10531b = r10;
        }

        @Override // kotlinx.coroutines.internal.b
        public /* bridge */ /* synthetic */ void b(LockFreeLinkedListNode r10, Object r11) {
            e(r10, r11);
        }

        public void e(LockFreeLinkedListNode r10, Object r11) {
            if (r11 != null) goto L4;
            boolean r12 = true;
        L5:
            if (r12 == false) goto L7;
            LockFreeLinkedListNode r13 = this.f10531b;
        L8:
            if (r13 != null) goto L10;
            return;
        L10:
            if (LockFreeLinkedListNode.d().compareAndSet(r10, this, r13) == false) goto L15;
            if (r12 == false) goto L16;
            LockFreeLinkedListNode r14 = this.f10531b;
            LockFreeLinkedListNode r15 = this.f10532c;
            Intrinsics.checkNotNull(r15);
            LockFreeLinkedListNode.c(r14, r15);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r13 = this.f10532c;
            goto L8
        L4:
            r12 = false;
            goto L5
        }
    }

    static {
        f10528c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        f10529g = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        f10530h = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
    }

    public static final /* synthetic */ void c(LockFreeLinkedListNode r10, LockFreeLinkedListNode r11) {
        r10.h(r11);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater d() {
        return f10528c;
    }

    private final LockFreeLinkedListNode f(b0 r10) {
    L2:
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) f10529g.get(this);
        LockFreeLinkedListNode r12 = r11;
    L3:
        LockFreeLinkedListNode r13 = null;
    L4:
        AtomicReferenceFieldUpdater r14 = f10528c;
        Object r15 = r14.get(r12);
        if (r15 == this) goto L6;
        if (l() == true) goto L14;
        if (r15 == r10) goto L16;
        if ((r15 instanceof b0) == true) goto L19;
        if ((r15 instanceof c0) == true) goto L22;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r13 = r12;
        r12 = (LockFreeLinkedListNode) r15;
        goto L4
    L22:
        if (r13 != null) goto L24;
        r12 = (LockFreeLinkedListNode) f10529g.get(r12);
        goto L4
    L24:
        if (r14.compareAndSet(r13, r12, ((c0) r15).f10543a) == false) goto L2;
        r12 = r13;
        goto L3
    L19:
        ((b0) r15).a(r12);
        goto L2
    L16:
        return r12;
    L14:
        return null;
    L6:
        if (r11 == r12) goto L7;
        if (f10529g.compareAndSet(this, r11, r12) == false) goto L2;
        return r12;
    L7:
        return r12;
    }

    private final LockFreeLinkedListNode g(LockFreeLinkedListNode r10) {
    L3:
        if (r10.l() == false) goto L4;
        r10 = (LockFreeLinkedListNode) f10529g.get(r10);
        goto L3
    L4:
        return r10;
    }

    private final void h(LockFreeLinkedListNode r10) {
        AtomicReferenceFieldUpdater r11 = f10529g;
    L3:
        LockFreeLinkedListNode r12 = (LockFreeLinkedListNode) r11.get(r10);
        if (i() != r10) goto L5;
        if (f10529g.compareAndSet(r10, r12, this) == false) goto L3;
        if (l() == false) goto L15;
        r10.f(null);
        return;
    L15:
        return;
    }

    private final c0 o() {
        AtomicReferenceFieldUpdater r10 = f10530h;
        c0 r11 = (c0) r10.get(this);
        if (r11 != null) goto L6;
        c0 r12 = new c0(this);
        r10.lazySet(this, r12);
        return r12;
    L6:
        return r11;
    }

    public final boolean e(LockFreeLinkedListNode r10) {
        f10529g.lazySet(r10, this);
        f10528c.lazySet(r10, this);
    L4:
        if (i() != this) goto L5;
        if (f10528c.compareAndSet(this, this, r10) == false) goto L4;
        r10.h(this);
        return true;
    L5:
        return false;
    }

    public final Object i() {
        AtomicReferenceFieldUpdater r10 = f10528c;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof b0) == false) goto L5;
        ((b0) r11).a(this);
        goto L3
    L5:
        return r11;
    }

    public final LockFreeLinkedListNode j() {
        return t.b(i());
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode r10 = f(null);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return g((LockFreeLinkedListNode) f10529g.get(this));
    }

    public boolean l() {
        return i() instanceof c0;
    }

    public boolean m() {
        if (n() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @PublishedApi
    public final LockFreeLinkedListNode n() {
    L2:
        Object r10 = i();
        if ((r10 instanceof c0) == true) goto L5;
        if (r10 == this) goto L8;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) r10;
        c0 r12 = r11.o();
        if (f10528c.compareAndSet(this, r10, r12) == false) goto L2;
        r11.f(null);
        return null;
    L8:
        return (LockFreeLinkedListNode) r10;
    L5:
        return ((c0) r10).f10543a;
    }

    @PublishedApi
    public final int p(LockFreeLinkedListNode r10, LockFreeLinkedListNode r11, a r12) {
        f10529g.lazySet(r10, this);
        AtomicReferenceFieldUpdater r13 = f10528c;
        r13.lazySet(r10, r11);
        r12.f10532c = r11;
        if (r13.compareAndSet(this, r11, r12) == true) goto L7;
        return 0;
    L7:
        if (r12.a(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    public String toString() {
        return new AnonymousClass1(this) + '@' + kotlinx.coroutines.o0.b(this);
    }
}

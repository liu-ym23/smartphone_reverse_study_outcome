package ue;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.d0;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12610b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12611m = null;
    private volatile Object _next;
    private volatile Object _prev;
    private volatile Object _removedRef;

    public static abstract class a extends ue.b<l> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f12612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l f12613c;

        public a(l r8) {
            this.f12612b = r8;
        }

        @Override // ue.b
        public final void b(l r8, Object r10) {
            l r11 = r8;
            boolean r12 = true;
            if (r10 != null) goto L5;
            boolean r13 = true;
        L6:
            l r14 = this.f12612b;
            if (r13 == false) goto L9;
            l r15 = r14;
        L10:
            if (r15 == null) goto L25;
            AtomicReferenceFieldUpdater r16 = l.f12609a;
        L13:
            if (r16.compareAndSet(r11, this, r15) == true) goto L18;
            if (r16.get(r11) == this) goto L13;
            r12 = false;
        L18:
            if (r12 == false) goto L26;
            if (r13 == false) goto L27;
            l r17 = this.f12613c;
            he.i.c(r17);
            r14.h(r17);
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L9:
            r15 = this.f12613c;
            goto L10
        L5:
            r13 = false;
            goto L6
        }
    }

    public /* synthetic */ class b extends he.m {
        public final String e() {
            return this.f8052b.getClass().getSimpleName();
        }
    }

    static {
        f12609a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_next");
        f12610b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_prev");
        f12611m = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_removedRef");
    }

    public l() {
        this._next = this;
        this._prev = this;
    }

    public final l g() {
    L2:
        AtomicReferenceFieldUpdater r8 = f12610b;
        l r10 = (l) r8.get(this);
        l r11 = r10;
    L3:
        l r12 = null;
    L4:
        AtomicReferenceFieldUpdater r13 = f12609a;
        Object r14 = r13.get(r11);
        boolean r15 = false;
        if (r14 == this) goto L6;
        if (l() == true) goto L18;
        if (r14 == null) goto L20;
        if ((r14 instanceof q) == true) goto L23;
        if ((r14 instanceof r) == true) goto L26;
        he.i.d(r14, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r12 = r11;
        r11 = (l) r14;
        goto L4
    L26:
        if (r12 != null) goto L27;
        r11 = (l) r8.get(r11);
        goto L4
    L27:
        l r16 = ((r) r14).f12624a;
    L29:
        if (r13.compareAndSet(r12, r11, r16) == true) goto L30;
        if (r13.get(r12) == r11) goto L29;
    L33:
        if (r15 == false) goto L2;
        r11 = r12;
        goto L3
    L30:
        r15 = true;
        goto L33
    L23:
        ((q) r14).a(r11);
        goto L2
    L20:
        return r11;
    L18:
        return null;
    L6:
        if (r10 == r11) goto L7;
    L9:
        if (r8.compareAndSet(this, r10, r11) == true) goto L10;
        if (r8.get(this) == r10) goto L9;
    L13:
        if (r15 == false) goto L2;
        return r11;
    L10:
        r15 = true;
        goto L13
    L7:
        return r11;
    }

    public final void h(l r8) {
    L2:
        AtomicReferenceFieldUpdater r10 = f12610b;
        l r11 = (l) r10.get(r8);
        if (i() != r8) goto L4;
    L6:
        if (r10.compareAndSet(r8, r11, this) == true) goto L7;
        if (r10.get(r8) == r11) goto L6;
        boolean r12 = false;
    L11:
        if (r12 == false) goto L2;
        if (l() == false) goto L24;
        r8.g();
        return;
    L24:
        return;
    L7:
        r12 = true;
        goto L11
    }

    public final Object i() {
    L2:
        Object r8 = f12609a.get(this);
        if ((r8 instanceof q) == false) goto L4;
        ((q) r8).a(this);
        goto L2
    L4:
        return r8;
    }

    public final l j() {
        Object r8 = i();
        b9.a r10 = k.f12608a;
        if ((r8 instanceof r) == false) goto L5;
        r r11 = (r) r8;
    L6:
        if (r11 == null) goto L9;
        l r12 = r11.f12624a;
        if (r12 == null) goto L9;
        return r12;
    L9:
        he.i.d(r8, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (l) r8;
    L5:
        r11 = null;
        goto L6
    }

    public final l k() {
        l r8 = g();
        if (r8 != null) goto L9;
        AtomicReferenceFieldUpdater r10 = f12610b;
        r8 = (l) r10.get(this);
    L6:
        if (r8.l() == false) goto L9;
        r8 = (l) r10.get(r8);
    L9:
        return r8;
    }

    public boolean l() {
        return i() instanceof r;
    }

    public String toString() {
        return new b(this) + '@' + d0.c(this);
    }
}

package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18939c = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        f18937a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");
        f18938b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev$volatile");
        f18939c = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef$volatile");
    }

    public j() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public final boolean c(j r5, int r10) {
    L2:
        j r11 = d();
        AtomicReferenceFieldUpdater r12 = f18938b;
        if (r11 != null) goto L10;
        Object r13 = r12.get(this);
    L5:
        r11 = (j) r13;
        if (r11.g() == false) goto L10;
        r13 = r12.get(r11);
    L10:
        if ((r11 instanceof h) == true) goto L12;
        r12.set(r5, r11);
        AtomicReferenceFieldUpdater r14 = f18937a;
        r14.set(r5, this);
    L19:
        if (r14.compareAndSet(r11, this, r5) == true) goto L20;
        if (r14.get(r11) == this) goto L19;
    L20:
        r5.e(this);
        return true;
    L12:
        if ((((h) r11).d & r10) == 0) goto L14;
    L16:
        return false;
    L14:
        if (r11.c(r5, r10) == false) goto L16;
        return true;
    }

    public final j d() {
    L2:
        AtomicReferenceFieldUpdater r5 = f18938b;
        j r10 = (j) r5.get(this);
        j r11 = r10;
    L3:
        j r12 = null;
    L4:
        AtomicReferenceFieldUpdater r13 = f18937a;
        Object r14 = r13.get(r11);
        if (r14 == this) goto L6;
        if (g() == true) goto L16;
        if ((r14 instanceof p) == true) goto L19;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        r12 = r11;
        r11 = (j) r14;
        goto L4
    L19:
        if (r12 != null) goto L20;
        r11 = (j) r5.get(r11);
        goto L4
    L20:
        j r15 = ((p) r14).f18949a;
    L22:
        if (r13.compareAndSet(r12, r11, r15) == true) goto L23;
        if (r13.get(r12) == r11) goto L22;
    L23:
        r11 = r12;
        goto L3
    L16:
        return null;
    L6:
        if (r10 == r11) goto L7;
    L9:
        if (r5.compareAndSet(this, r10, r11) == true) goto L10;
        if (r5.get(this) == r10) goto L9;
    L10:
        return r11;
    L7:
        return r11;
    }

    public final void e(j r5) {
    L2:
        AtomicReferenceFieldUpdater r10 = f18938b;
        j r11 = (j) r10.get(r5);
        if (f18937a.get(this) != r5) goto L4;
    L6:
        if (r10.compareAndSet(r5, r11, this) == true) goto L8;
        if (r10.get(r5) == r11) goto L6;
    L8:
        if (g() == false) goto L18;
        r5.d();
        return;
    L18:
        return;
    }

    public final j f() {
        Object r5 = f18937a.get(this);
        if ((r5 instanceof p) == false) goto L5;
        p r10 = (p) r5;
    L6:
        if (r10 == null) goto L9;
        j r11 = r10.f18949a;
        if (r11 == null) goto L9;
        return r11;
    L9:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (j) r5;
    L5:
        r10 = null;
        goto L6
    }

    public boolean g() {
        return f18937a.get(this) instanceof p;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + j0.f(this);
    }
}

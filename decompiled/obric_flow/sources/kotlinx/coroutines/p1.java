package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18984b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18985c = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = null;
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile;
    private volatile /* synthetic */ Object _rootCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f18986a;

    static {
        f18984b = AtomicIntegerFieldUpdater.newUpdater(p1.class, "_isCompleting$volatile");
        f18985c = AtomicReferenceFieldUpdater.newUpdater(p1.class, Object.class, "_rootCause$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(p1.class, Object.class, "_exceptionsHolder$volatile");
    }

    public p1(u1 r5, Throwable r10) {
        this.f18986a = r5;
        this._isCompleting$volatile = 0;
        this._rootCause$volatile = r10;
    }

    public final void a(Throwable r5) {
        Throwable r10 = c();
        if (r10 != null) goto L6;
        f18985c.set(this, r5);
        return;
    L6:
        if (r5 != r10) goto L8;
        return;
    L8:
        AtomicReferenceFieldUpdater r11 = d;
        Object r12 = r11.get(this);
        if (r12 != null) goto L12;
        r11.set(this, r5);
        return;
    L12:
        if ((r12 instanceof Throwable) == false) goto L17;
        if (r5 != r12) goto L15;
        return;
    L15:
        ArrayList r13 = new ArrayList(4);
        r13.add(r12);
        r13.add(r5);
        r11.set(this, r13);
        return;
    L17:
        if ((r12 instanceof ArrayList) == false) goto L21;
        ((ArrayList) r12).add(r5);
        return;
    L21:
        throw new IllegalStateException(("State is " + r12).toString());
    }

    @Override // kotlinx.coroutines.g1
    public final u1 b() {
        return this.f18986a;
    }

    public final Throwable c() {
        return (Throwable) f18985c.get(this);
    }

    public final boolean d() {
        if (c() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ArrayList e(Throwable r5) {
        AtomicReferenceFieldUpdater r10 = d;
        Object r11 = r10.get(this);
        if (r11 != null) goto L6;
        ArrayList r12 = new ArrayList(4);
    L11:
        Throwable r13 = c();
        if (r13 == null) goto L14;
        r12.add(0, r13);
    L14:
        if (r5 != null) goto L16;
    L18:
        r10.set(this, j0.f18968h);
        return r12;
    L16:
        if (Intrinsics.areEqual(r5, r13) == true) goto L18;
        r12.add(r5);
        goto L18
    L6:
        if ((r11 instanceof Throwable) == false) goto L9;
        ArrayList r14 = new ArrayList(4);
        r14.add(r11);
        r12 = r14;
        goto L11
    L9:
        if ((r11 instanceof ArrayList) == false) goto L21;
        r12 = (ArrayList) r11;
        goto L11
    L21:
        throw new IllegalStateException(("State is " + r11).toString());
    }

    @Override // kotlinx.coroutines.g1
    public final boolean isActive() {
        if (c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Finishing[cancelling=");
        r5.append(d());
        r5.append(", completing=");
        if (f18984b.get(this) == 0) goto L5;
        boolean r10 = true;
    L6:
        r5.append(r10);
        r5.append(", rootCause=");
        r5.append(c());
        r5.append(", exceptions=");
        r5.append(d.get(this));
        r5.append(", list=");
        r5.append(this.f18986a);
        r5.append(']');
        return r5.toString();
    L5:
        r10 = false;
        goto L6
    }
}

package kotlinx.coroutines;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JobSupport$c implements x0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = null;
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile;
    private volatile /* synthetic */ Object _rootCause$volatile;
    public final j1 a;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(JobSupport$c.class, "_isCompleting$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(JobSupport$c.class, Object.class, "_rootCause$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(JobSupport$c.class, Object.class, "_exceptionsHolder$volatile");
    }

    public final Throwable b() {
        return (Throwable) c.get(this);
    }

    public final boolean d() {
        if (b.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "Finishing[cancelling=" + c() + ", completing=" + d() + ", rootCause=" + b() + ", exceptions=" + d.get(this) + ", list=" + this.a + ']';
    }

    public final boolean c() {
        if (b() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isActive() {
        if (b() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final j1 getList() {
        return this.a;
    }

    public final void a(Throwable r5) {
        Throwable r0 = b();
        if (r0 != null) goto L6;
        c.set(this, r5);
        return;
    L6:
        if (r5 != r0) goto L8;
        return;
    L8:
        AtomicReferenceFieldUpdater r1 = d;
        Object r2 = r1.get(this);
        if (r2 != null) goto L12;
        r1.set(this, r5);
        return;
    L12:
        if ((r2 instanceof Throwable) == false) goto L17;
        if (r5 != r2) goto L15;
        return;
    L15:
        ArrayList r3 = new ArrayList(4);
        r3.add(r2);
        r3.add(r5);
        r1.set(this, r3);
        return;
    L17:
        if ((r2 instanceof ArrayList) == false) goto L21;
        ((ArrayList) r2).add(r5);
        return;
    L21:
        throw new IllegalStateException(("State is " + r2).toString());
    }

    public final List<Throwable> e(Throwable r5) {
        AtomicReferenceFieldUpdater r0 = d;
        Object r1 = r0.get(this);
        if (r1 != null) goto L6;
        ArrayList r2 = new ArrayList(4);
    L11:
        Throwable r3 = b();
        if (r3 == null) goto L14;
        ListProtector.add(r2, 0, r3);
    L14:
        if (r5 != null) goto L16;
    L18:
        r0.set(this, g1.e);
        return r2;
    L16:
        if (Intrinsics.areEqual(r5, r3) == true) goto L18;
        r2.add(r5);
        goto L18
    L6:
        if ((r1 instanceof Throwable) == false) goto L9;
        ArrayList r4 = new ArrayList(4);
        r4.add(r1);
        r2 = r4;
        goto L11
    L9:
        if ((r1 instanceof ArrayList) == false) goto L21;
        r2 = (ArrayList) r1;
        goto L11
    L21:
        throw new IllegalStateException(("State is " + r1).toString());
    }

    public JobSupport$c(j1 r1, Throwable r2) {
        this.a = r1;
        this._isCompleting$volatile = 0;
        this._rootCause$volatile = r2;
    }
}

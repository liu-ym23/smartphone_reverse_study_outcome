package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b2 extends d0 implements b1, p1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c2 f10245i;

    public b2() {
    }

    @Override // kotlinx.coroutines.p1
    public h2 a() {
        return null;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
        r().T0(this);
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return true;
    }

    public final c2 r() {
        c2 r10 = this.f10245i;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public final void s(c2 r10) {
        this.f10245i = r10;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return o0.a(this) + '@' + o0.b(this) + "[job@" + o0.b(r()) + ']';
    }
}

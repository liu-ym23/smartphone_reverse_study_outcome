package p0;

import io.reactivex.internal.observers.h;
import java.security.MessageDigest;
import z.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21317b;

    public b(Object r5) {
        h.h(r5, "Argument must not be null");
        this.f21317b = r5;
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        r5.update(this.f21317b.toString().getBytes(c.f23353a));
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof b) == true) goto L5;
        return false;
    L5:
        return this.f21317b.equals(((b) r5).f21317b);
    }

    @Override // z.c
    public final int hashCode() {
        return this.f21317b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f21317b + '}';
    }
}

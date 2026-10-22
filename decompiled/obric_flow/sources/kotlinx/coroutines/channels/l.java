package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f18813a;

    public l(Throwable r5) {
        this.f18813a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof l) == false) goto L7;
        Throwable r10 = ((l) r5).f18813a;
        if (Intrinsics.areEqual(this.f18813a, r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        Throwable r5 = this.f18813a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    @Override // kotlinx.coroutines.channels.m
    public final String toString() {
        return "Closed(" + this.f18813a + ')';
    }
}

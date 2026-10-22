package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f18814b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18815a;

    static {
        f18814b = new m();
    }

    public /* synthetic */ n(Object r5) {
        this.f18815a = r5;
    }

    public static final Throwable a(Object r5) {
        if ((r5 instanceof l) == false) goto L5;
        l r10 = (l) r5;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.f18813a;
    L5:
        r10 = null;
        goto L6
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof n) == false) goto L10;
        Object r10 = ((n) r5).f18815a;
        if (Intrinsics.areEqual(this.f18815a, r10) == false) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        Object r5 = this.f18815a;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public final String toString() {
        Object r5 = this.f18815a;
        if ((r5 instanceof l) == false) goto L6;
        return ((l) r5).toString();
    L6:
        return "Value(" + r5 + ')';
    }
}

package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f8.b f18473b;

    public m(long r5, f8.b r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.f18472a = r5;
        this.f18473b = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        long r5 = r11.f18472a;
        if (this.f18472a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18473b, r11.f18473b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Long.hashCode(this.f18472a) * 31;
        return this.f18473b.hashCode() + r5;
    }

    public final String toString() {
        return "Keyframe(timeMs=" + this.f18472a + ", value=" + this.f18473b + ')';
    }
}

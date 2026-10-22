package nb;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20227b;

    public b(int r5, int r10) {
        this.f20226a = r5;
        this.f20227b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        int r11 = r10.f20226a;
        if (this.f20226a == r11) goto L12;
        return false;
    L12:
        if (this.f20227b == r10.f20227b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f20226a) * 31;
        return Integer.hashCode(this.f20227b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("DisplayMetric(width=");
        r5.append(this.f20226a);
        r5.append(", height=");
        return j0.n(r5, this.f20227b, ')');
    }
}

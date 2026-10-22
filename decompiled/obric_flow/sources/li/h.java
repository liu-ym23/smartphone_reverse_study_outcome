package li;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19662b;

    public h(int r5, long r10) {
        this.f19661a = r10;
        this.f19662b = r5;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        long r5 = r11.f19661a;
        if (this.f19661a == r5) goto L12;
        return false;
    L12:
        if (this.f19662b == r11.f19662b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Long.hashCode(this.f19661a) * 31;
        return Integer.hashCode(this.f19662b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LimitRecord(spendTimestamp=");
        r5.append(this.f19661a);
        r5.append(", count=");
        return j0.n(r5, this.f19662b, ')');
    }
}

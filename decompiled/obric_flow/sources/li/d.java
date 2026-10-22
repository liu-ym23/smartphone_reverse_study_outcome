package li;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f19649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19651c;

    public d(Long r5, int r10, int r11) {
        this.f19649a = r5;
        this.f19650b = r10;
        this.f19651c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        Long r11 = r10.f19649a;
        if (Intrinsics.areEqual(this.f19649a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f19650b == r10.f19650b) goto L15;
        return false;
    L15:
        if (this.f19651c == r10.f19651c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19649a.hashCode() * 31;
        int r10 = k5.d.a(this.f19650b, r5);
        return Integer.hashCode(this.f19651c) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BridgeCallRecord(lastCallTimeStamp=");
        r5.append(this.f19649a);
        r5.append(", callTimes=");
        r5.append(this.f19650b);
        r5.append(", callFreqTimes=");
        return j0.n(r5, this.f19651c, ')');
    }
}

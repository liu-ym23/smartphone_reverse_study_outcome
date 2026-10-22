package o;

import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20381b;

    public final boolean equals(Object r5) {
        if ((r5 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r10 = (Pair) r5;
        F r11 = r10.first;
        Object r12 = this.f20380a;
        if (r11 == r12) goto L10;
        if (r11 != 0) goto L9;
        return false;
    L9:
        if (r11.equals(r12) == true) goto L10;
        return false;
    L10:
        S r13 = r10.second;
        Object r14 = this.f20381b;
        if (r13 == r14) goto L15;
        if (r13 != 0) goto L14;
        return false;
    L14:
        if (r13.equals(r14) == true) goto L15;
        return false;
    L15:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f20380a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        String r12 = this.f20381b;
        if (r12 == null) goto L11;
        r10 = r12.hashCode();
    L11:
        return r11 ^ r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f20380a) + " " + String.valueOf(this.f20381b) + "}";
    }
}

package androidx.core.util;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F r5, S r10) {
        this.first = r5;
        this.second = r10;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A r5, B r10) {
        return new Pair(r5, r10);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r10 = (Pair) r5;
        if (ObjectsCompat.equals(r10.first, this.first) == true) goto L8;
        return false;
    L8:
        if (ObjectsCompat.equals(r10.second, this.second) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r5 = this.first;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        S r12 = this.second;
        if (r12 == null) goto L11;
        r10 = r12.hashCode();
    L11:
        return r11 ^ r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

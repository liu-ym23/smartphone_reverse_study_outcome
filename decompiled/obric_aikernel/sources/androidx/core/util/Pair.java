package androidx.core.util;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F r10, S r11) {
        this.first = r10;
        this.second = r11;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A r10, B r11) {
        return new Pair(r10, r11);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r11 = (Pair) r10;
        if (ObjectsCompat.equals(r11.first, this.first) == true) goto L8;
        return false;
    L8:
        if (ObjectsCompat.equals(r11.second, this.second) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r10 = this.first;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        S r13 = this.second;
        if (r13 == null) goto L11;
        r11 = r13.hashCode();
    L11:
        return r12 ^ r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

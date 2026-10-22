package jd0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public final int a;

    public j() {
        this(0);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof j) == true) goto L6;
        return false;
    L6:
        if (this.a == ((j) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "RTChorusSentenceEvent(index=" + this.a + ")";
    }

    public j(int r1) {
        this.a = r1;
    }
}

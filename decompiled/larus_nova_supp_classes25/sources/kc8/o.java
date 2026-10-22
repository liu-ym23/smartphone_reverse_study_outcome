package kc8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public final boolean a;

    public o() {
        this(true);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof o) == true) goto L9;
        return false;
    L9:
        if (this.a == ((o) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ContainerVmConfig(enableRoundCorner=" + this.a + ')';
    }

    public o(boolean r1) {
        this.a = r1;
    }
}

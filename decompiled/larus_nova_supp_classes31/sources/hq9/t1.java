package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t1 {
    public final boolean a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t1) == true) goto L9;
        return false;
    L9:
        if (this.a == ((t1) r4).a) goto L11;
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
        return "ImageGenerateHeicConfig(thumbImageUseHeic=" + this.a + ')';
    }

    public t1(boolean r1) {
        this.a = r1;
    }
}

package m3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final boolean a;

    public b() {
        this(true);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r10).a) goto L11;
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
        return "DoubaoBottomSheetBehavior(dismissOnMaskTap=" + this.a + ')';
    }

    public b(boolean r1) {
        this.a = r1;
    }
}

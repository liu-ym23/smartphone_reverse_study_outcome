package d10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final long a;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == true) goto L6;
        return false;
    L6:
        if (this.a == ((e) r5).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "MultiLinkGameStartEvent(targetUiLayout=" + this.a + ")";
    }

    public e() {
        this(0);
    }

    public e(long r1) {
        this.a = r1;
    }
}

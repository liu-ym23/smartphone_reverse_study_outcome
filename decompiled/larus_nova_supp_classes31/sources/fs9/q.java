package fs9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public final boolean a;

    public q() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof q) == true) goto L9;
        return false;
    L9:
        if (this.a == ((q) r4).a) goto L11;
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
        return "ProfileBotListEmptyData(isSelfProfileInfo=" + this.a + ')';
    }

    public q(int r1) {
        this.a = true;
    }
}

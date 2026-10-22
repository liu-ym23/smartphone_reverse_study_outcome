package j98;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public c() {
        this(0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "DiaryFeedbackEntryUiModel(titleRes=" + this.a + ", likeTextRes=" + this.b + ", dislikeTextRes=" + this.c + ", selectedActionType=" + this.d + ')';
    }

    public c(int r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        int r0 = 2131903886;
    L7:
        if ((r6 & 2) == 0) goto L9;
        int r2 = 2131903891;
    L11:
        if ((r6 & 4) == 0) goto L13;
        int r3 = 2131903883;
    L15:
        if ((r6 & 8) == 0) goto L17;
        r5 = 0;
    L17:
        this.a = r0;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        return;
    L13:
        r3 = 0;
        goto L15
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = 0;
        goto L7
    }
}

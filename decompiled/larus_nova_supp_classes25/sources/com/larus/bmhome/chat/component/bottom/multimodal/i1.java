package com.larus.bmhome.chat.component.bottom.multimodal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 {
    public final int a;
    public final int b;
    public final int c;

    public i1() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r6 = (i1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "MultipleFileSizeData(textFileSize=" + this.a + ", imageSize=" + this.b + ", audioSize=" + this.c + ')';
    }

    public i1(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

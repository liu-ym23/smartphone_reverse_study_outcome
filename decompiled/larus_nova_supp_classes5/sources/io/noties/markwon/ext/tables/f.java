package io.noties.markwon.ext.tables;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final boolean a;

    public f() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L5;
    L13:
        return true;
    L5:
        if ((r4 instanceof f) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.a != ((f) r4).a) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
    L9:
        r5 = false;
        goto L10
    }

    public final int hashCode() {
        boolean r0 = this.a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "TableOptions(generateExcelLiteral=" + this.a + ")";
    }

    public f(boolean r1) {
        this.a = r1;
    }
}

package v7b;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x {
    public final int a;
    public final int b;
    public final int c;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String toString() {
        return "SourceSpan{line=" + this.a + ", column=" + this.b + ", length=" + this.c + "}";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (x.class != r5.getClass()) goto L19;
        x r6 = (x) r5;
        if (this.a == r6.a) goto L13;
    L17:
        return false;
    L13:
        if (this.b != r6.b) goto L17;
        if (this.c != r6.c) goto L17;
        return true;
    }

    public x(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

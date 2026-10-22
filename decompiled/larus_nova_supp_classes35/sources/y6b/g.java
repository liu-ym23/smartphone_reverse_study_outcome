package y6b;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements y28.b<g> {
    public final long a;
    public final boolean b;
    public final boolean c;
    public String d;
    public String e;

    public final int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.a), Boolean.valueOf(this.c), Boolean.valueOf(this.b)});
    }

    public final boolean equals(Object r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if ((r7 instanceof g) == false) goto L19;
        g r8 = (g) r7;
        if (this.a == r8.a) goto L10;
        return false;
    L10:
        if (this.c == r8.c) goto L12;
        return false;
    L12:
        if (this.b != r8.b) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public final boolean isContentSame(y28.b r1) {
        return equals((g) r1);
    }

    public final boolean isItemSame(y28.b r1) {
        if (this != ((g) r1)) goto L5;
        return true;
    L5:
        return false;
    }

    public g(long r1, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}

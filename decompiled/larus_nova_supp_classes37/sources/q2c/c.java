package q2c;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends b {
    public String a;
    public int b;
    public List<d> c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, Integer.valueOf(this.b), this.c});
    }

    public c() {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.b == r6.b) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(this.a, r6.a) == false) goto L15;
        if (Objects.equals(this.c, r6.c) == false) goto L15;
        return true;
    }
}

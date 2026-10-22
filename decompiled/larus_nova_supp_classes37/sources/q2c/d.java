package q2c;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public String a;
    public String b;
    public String c;
    public final boolean d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, Boolean.valueOf(this.d)});
    }

    public d() {
        this.d = true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.d == r6.d) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(this.a, r6.a) == false) goto L15;
        if (Objects.equals(this.b, r6.b) == false) goto L15;
        return true;
    }

    public d(String r2, String r3) {
        this.d = true;
        this.a = r2;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.b = r3;
    }
}

package w7b;

import java.util.Objects;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public final CharSequence a;
    public final x b;

    public f(CharSequence r2, x r3) {
        Objects.requireNonNull(r2, "content must not be null");
        this.a = r2;
        this.b = r3;
    }

    public final f a(int r4, int r5) {
        CharSequence r0 = this.a.subSequence(r4, r5);
        x r1 = this.b;
        if (r1 == null) goto L7;
        int r2 = r1.b + r4;
        int r6 = r5 - r4;
        if (r6 == 0) goto L7;
        x r3 = new x(r1.a, r2, r6);
    L9:
        return new f(r0, r3);
    L7:
        r3 = null;
        goto L9
    }
}

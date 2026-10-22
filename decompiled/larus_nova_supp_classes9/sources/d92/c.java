package d92;

import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements c92.a {
    public c() {
        new b92.b();
    }

    @Override // c92.a
    public final z82.b a(a92.a r6) {
        Intrinsics.checkNotNullParameter(r6, "param");
        int r0 = r6.b;
        Integer r1 = h.b(r0, r6.a());
        if (r1 == null) goto L16;
        int r2 = r1.intValue();
        g r3 = r6.e;
        int r4 = 0;
        if (r6.c == true) goto L7;
        r3.getClass();
    L10:
        int r5 = 0;
    L12:
        if (r6.f == null) goto L15;
        r4 = z82.a.a();
    L15:
        return new z82.b(r2, r0, r5 + r4, (int) ((r6.a - r2) / 2.0f));
    L7:
        if (r3.a == false) goto L10;
        r5 = r3.b;
        goto L12
    L16:
        return null;
    }
}

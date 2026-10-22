package m31;

import k31.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public b() {
    }

    public static k31.c a(l31.a r7) {
        Intrinsics.checkNotNullParameter(r7, "param");
        if (r7.b != 0) goto L5;
        return null;
    L5:
        if (r7.c == 0) goto L23;
        Float r0 = r7.a();
        if (r0 == null) goto L21;
        float r1 = r0.floatValue();
        int r2 = r7.b;
        int r4 = r7.c;
        if ((r2 / r4) <= r1) goto L15;
        Integer r3 = o.b(r4, r7.a());
        if (r3 == null) goto L19;
        int r5 = r3.intValue();
        return new k31.c(r5, r4, 0, (int) ((r7.b - r5) / 2.0f));
    L19:
        return null;
    L15:
        Integer r6 = o.a(r2, r7.a());
        if (r6 == null) goto L22;
        int r8 = r6.intValue();
        return new k31.c(r2, r8, (int) ((r7.c - r8) / 2.0f), 0);
    L22:
        return null;
    L21:
        return null;
    L23:
        return null;
    }
}

package d92;

import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements c92.a {
    public final int a;

    public d() {
        new b92.b();
        this.a = s1.f(134.0f);
    }

    @Override // c92.a
    public final z82.b a(a92.a r7) {
        Intrinsics.checkNotNullParameter(r7, "param");
        int r0 = r7.a;
        Integer r1 = h.a(r0, r7.a());
        if (r1 == null) goto L17;
        int r2 = r1.intValue();
        int r3 = this.a;
        g r4 = r7.e;
        if (r7.c == true) goto L7;
        r4.getClass();
    L10:
        int r5 = 0;
    L11:
        int r6 = r3 + r5;
        if (r7.f == null) goto L14;
        int r8 = z82.a.a();
    L16:
        return new z82.b(r0, r2, r6 + r8, 0);
    L14:
        r8 = 0;
        goto L16
    L7:
        if (r4.a == false) goto L10;
        r5 = r4.b;
        goto L11
    L17:
        return null;
    }
}

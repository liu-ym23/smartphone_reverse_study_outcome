package kb;

import com.bytedance.ies.bullet.core.r;
import com.bytedance.ies.bullet.core.s;
import kotlin.jvm.internal.Intrinsics;
import s26.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final r a;

    public b(m16.b r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        Intrinsics.checkNotNullParameter(r11, "bid");
        d r0 = d.c;
        e26.b r12 = d.c.d(r11, e26.b.class);
        r r1 = null;
        if (r12 == null) goto L5;
        s r13 = r12.D(r10);
    L7:
        if ((r13 instanceof r) == false) goto L9;
        r1 = (r) r13;
    L9:
        this.a = r1;
        return;
    L5:
        r13 = null;
        goto L7
    }
}

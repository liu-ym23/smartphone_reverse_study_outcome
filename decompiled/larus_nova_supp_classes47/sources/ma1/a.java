package ma1;

import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.scope.m;
import cy0.c;
import kotlin.jvm.internal.Reflection;
import wq2.f;
import xq2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final f a() {
        b r0 = (dy0.b) e.c(j.C0.a(), b.class);
        if (r0 == null) goto L5;
        c r1 = r0.c0();
    L6:
        if (r1 == null) goto L9;
        m.e.getClass();
        return (f) m.b(r1).a(Reflection.getOrCreateKotlinClass(f.class));
    L9:
        return null;
    L5:
        r1 = null;
        goto L6
    }
}

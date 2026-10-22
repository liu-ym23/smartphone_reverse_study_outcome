package z11;

import com.bytedance.android.live.revenue.core.b;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.live.kmp.core.d;
import d51.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final d a(Class r1) {
        if (c.A0.a() == false) goto L8;
        b r0 = j.C0.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        e.b(r0, r1);
    L8:
        b r2 = j.C0.a();
        Intrinsics.checkNotNull(r2);
        return e.b(r2, r1);
    }
}

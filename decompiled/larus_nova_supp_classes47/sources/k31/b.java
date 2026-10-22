package k31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final int a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$computeMoveDistance");
        int r1 = 0;
        if (r41.f.a == false) goto L5;
        int r0 = com.bytedance.android.live.revenue.common.i.b(20);
    L6:
        n r2 = r5.b;
        if (r2 != null) goto L9;
    L12:
        g r6 = r5.a;
        if (r6 != null) goto L15;
    L21:
        return r0;
    L15:
        if (r6.a == false) goto L21;
        Integer r7 = r6.b;
        if (r7 == null) goto L20;
        r1 = r7.intValue();
    L20:
        return r1 + r0;
    L9:
        if (r2.a != true) goto L12;
        return r2.b + r0;
    L5:
        r0 = 0;
        goto L6
    }
}

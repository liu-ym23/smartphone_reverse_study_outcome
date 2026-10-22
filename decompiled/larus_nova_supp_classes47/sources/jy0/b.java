package jy0;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        ((a) f.a(a.class)).k(r1, r2);
    }

    public static final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        ((a) f.a(a.class)).j(r1, r2);
    }

    public static final void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        if (r3 == null) goto L6;
        ((a) f.a(a.class)).M3(r1, r2, r3);
        return;
    L6:
        ((a) f.a(a.class)).M3(r1, r2, null);
    }

    public static final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        if (r3 == null) goto L6;
        ((a) f.a(a.class)).d5(r1, r2, r3);
        return;
    L6:
        ((a) f.a(a.class)).d5(r1, r2, null);
    }

    public static /* synthetic */ void c(String r1, String r2, Throwable r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        b(r1, r2, r3);
    }

    public static /* synthetic */ void f(String r1, String r2, Throwable r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        e(r1, r2, r3);
    }
}

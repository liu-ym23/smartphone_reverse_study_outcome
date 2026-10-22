package swb;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o {
    public static void a(String r3, Throwable r4) {
        String r5 = "ReportCrashUtils_" + r3;
        int r0 = com.ss.android.lark.officesdk.utils.di.j.a;
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r5, "tag");
        DependencyContainer r1 = DependencyContainer.a;
        ntb.n r2 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r2 == null) goto L6;
        r2.g(r5, "", r4, true);
        return;
    }
}

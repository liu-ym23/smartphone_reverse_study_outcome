package kka;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        new a();
    }

    @JvmStatic
    public static final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r4 = c("", r3);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r4 = c(r2, r3);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
    }

    @JvmStatic
    public static final String c(String r1, String r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r2;
    L11:
        return r1 + "-->" + r2;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}

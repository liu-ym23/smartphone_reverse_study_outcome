package f3b;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Integer a(r5b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        lya.a r2 = r1.l();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a();
    }
}

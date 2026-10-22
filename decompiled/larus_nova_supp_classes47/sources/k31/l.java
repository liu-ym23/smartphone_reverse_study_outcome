package k31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final String b(k r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$formatString");
        return "needMovePlayer4StatusBar = " + r2.a + ", distance = " + r2.b;
    }

    public static final int a(k r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$computeMoveDistance");
        if (r2 == true) goto L5;
    L7:
        return 0;
    L5:
        if (r1.a == false) goto L7;
        return r1.b;
    }
}

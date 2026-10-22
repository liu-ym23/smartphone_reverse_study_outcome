package uga;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final AtomicReference<String> a = null;

    static {
        a = new AtomicReference();
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        AtomicReference<String> r0 = a;
        String r1 = r0.get();
        if (r1 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r1, r2) == true) goto L8;
        return;
    L8:
        if (r0.compareAndSet(r1, null) == true) goto L16;
        if (r0.get() == r1) goto L8;
        return;
    }

    public static boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        if ((!StringsKt.isBlank(r2)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(a.get(), r2) == false) goto L7;
        return true;
    }
}

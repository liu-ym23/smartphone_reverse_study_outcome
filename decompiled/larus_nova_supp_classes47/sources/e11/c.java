package e11;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static a a;

    public static final b a(b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$get");
        if (a != null) goto L12;
        b.a r2 = b.a;
        monitor-enter(r2);
        a = new a();     // Catch: Throwable -> L9
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r2);
    L9:
        th = move-exception;
        throw th;
    L12:
        a r3 = a;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}

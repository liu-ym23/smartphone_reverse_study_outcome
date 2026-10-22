package hq9;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Object r3, Function0 r4, Function1 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r3, "stateLock");
        Intrinsics.checkNotNullParameter(r4, "readContext");
        Intrinsics.checkNotNullParameter(r5, "evaluate");
        Intrinsics.checkNotNullParameter(r6, "publishIfCurrent");
    L3:
        Object r0 = r4.invoke();
        Object r1 = r5.invoke(r0);
        monitor-enter(r3);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (Intrinsics.areEqual(r0, r4.invoke()) == false) goto L9;
        Object r2 = r6.invoke(r1);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r3);
        if (r2 == null) goto L3;
        return r2;
    L9:
        r2 = null;
        goto L10
    }
}

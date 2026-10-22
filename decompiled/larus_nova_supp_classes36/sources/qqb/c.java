package qqb;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final b a(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new b(a.d(), r2);
    }

    public static final void c(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        a.h("");     // Catch: Throwable -> L6
        r2.run();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> R b(String r1, Function0<? extends R> r2) {
        Intrinsics.checkNotNullParameter(r1, "mark");
        Intrinsics.checkNotNullParameter(r2, "block");
        a.h(r1);     // Catch: Throwable -> L6
        R r3 = (R) r2.invoke();
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return r3;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void d(String r1, Runnable r2) {
        Intrinsics.checkNotNullParameter(r1, "mark");
        Intrinsics.checkNotNullParameter(r2, "block");
        a.h(r1);     // Catch: Throwable -> L6
        r2.run();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}

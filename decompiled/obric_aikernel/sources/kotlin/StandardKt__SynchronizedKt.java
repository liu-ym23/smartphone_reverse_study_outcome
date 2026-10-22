package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class StandardKt__SynchronizedKt extends StandardKt__StandardKt {
    public StandardKt__SynchronizedKt() {
    }

    @InlineOnly
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    private static final <R> R m42synchronized(Object r10, Function0<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "lock");
        Intrinsics.checkNotNullParameter(r11, "block");
        monitor-enter(r10);
        R r12 = r11.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r10);
        InlineMarker.finallyEnd(1);
        return r12;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}

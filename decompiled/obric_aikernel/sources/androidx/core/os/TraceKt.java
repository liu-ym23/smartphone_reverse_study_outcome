package androidx.core.os;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    @Deprecated(message = "Use androidx.tracing.Trace instead", replaceWith = @ReplaceWith(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(String r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "sectionName");
        Intrinsics.checkNotNullParameter(r11, "block");
        TraceCompat.beginSection(r10);
        T r12 = r11.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        TraceCompat.endSection();
        InlineMarker.finallyEnd(1);
        return r12;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        TraceCompat.endSection();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}

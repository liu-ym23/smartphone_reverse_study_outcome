package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "AutoCloseableKt")
public final class AutoCloseableKt {
    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final void closeFinally(AutoCloseable r10, Throwable r11) {
        if (r10 == null) goto L12;
        if (r11 != null) goto L10;
        r10.close();
        return;
    L10:
        r10.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ExceptionsKt.addSuppressed(r11, th);
        return;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T extends AutoCloseable, R> R use(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        R r12 = r11.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        closeFinally(r10, null);
        InlineMarker.finallyEnd(1);
        return r12;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        closeFinally(r10, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}

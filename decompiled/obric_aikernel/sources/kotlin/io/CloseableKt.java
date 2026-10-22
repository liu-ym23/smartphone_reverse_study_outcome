package kotlin.io;

import java.io.Closeable;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "CloseableKt")
public final class CloseableKt {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void closeFinally(Closeable r10, Throwable r11) {
        if (r10 == null) goto L12;
        if (r11 != null) goto L10;
        r10.close();
        return;
    L10:
        r10.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        kotlin.ExceptionsKt.addSuppressed(r11, th);
        return;
    }

    @InlineOnly
    private static final <T extends Closeable, R> R use(T r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        R r12 = r11.invoke(r10);     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        closeFinally(r10, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r12;
    L7:
        if (r10 == null) goto L9;
        r10.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r10 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r10.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        closeFinally(r10, th);
        goto L20
    }
}

package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,84:1\n34#1,13:85\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n53#1:85,13\n*E\n"})
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = r10.readFully();
        Intrinsics.checkNotNullExpressionValue(r11, "readFully()");
        return r11;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        byte[] r12 = r10.readFully();
        Intrinsics.checkNotNullExpressionValue(r12, "readFully()");
        return new String(r12, r11);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        return readText(r10, r11);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile r10, Function1<? super FileOutputStream, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        FileOutputStream r12 = r10.startWrite();
        Intrinsics.checkNotNullExpressionValue(r12, "stream");     // Catch: Throwable -> L6
        r11.invoke(r12);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.finishWrite(r12);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.failWrite(r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "array");
        FileOutputStream r12 = r10.startWrite();
        Intrinsics.checkNotNullExpressionValue(r12, "stream");     // Catch: Throwable -> L6
        r12.write(r11);     // Catch: Throwable -> L6
        r10.finishWrite(r12);
        return;
    L6:
        th = move-exception;
        r10.failWrite(r12);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile r10, String r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "charset");
        byte[] r13 = r11.getBytes(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).getBytes(charset)");
        writeBytes(r10, r13);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile r10, String r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        writeText(r10, r11, r12);
    }
}

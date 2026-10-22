package androidx.core.util;

import com.bytedance.ai.event.MessageIndication;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0086\b\u001a\u0012\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", MessageIndication.CONTENT_TYPE_TEXT, "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,76:1\n30#1,13:77\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n48#1:77,13\n*E\n"})
public final class AtomicFileKt {
    public static final byte[] readBytes(android.util.AtomicFile r5) {
        return r5.readFully();
    }

    public static final String readText(android.util.AtomicFile r5, Charset r10) {
        return new String(r5.readFully(), r10);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        return readText(r5, r10);
    }

    public static final void tryWrite(android.util.AtomicFile r5, Function1<? super FileOutputStream, Unit> r10) {
        FileOutputStream r11 = r5.startWrite();
        r10.invoke(r11);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r5.finishWrite(r11);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r5.failWrite(r11);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void writeBytes(android.util.AtomicFile r5, byte[] r10) {
        FileOutputStream r11 = r5.startWrite();
        r11.write(r10);     // Catch: Throwable -> L6
        r5.finishWrite(r11);
        return;
    L6:
        th = move-exception;
        r5.failWrite(r11);
        throw th;
    }

    public static final void writeText(android.util.AtomicFile r5, String r10, Charset r11) {
        writeBytes(r5, r10.getBytes(r11));
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile r5, String r10, Charset r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        writeText(r5, r10, r11);
    }
}

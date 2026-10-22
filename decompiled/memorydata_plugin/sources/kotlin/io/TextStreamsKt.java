package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001aB\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TextStreamsKt {
    private static final BufferedReader buffered(Reader r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, BufferedReader.class) == false) goto L6;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r1, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedReader(r1, r2);
    }

    private static final BufferedWriter buffered(Writer r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, BufferedWriter.class) == false) goto L6;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r1, BufferedWriter.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedWriter(r1, r2);
    }

    static /* synthetic */ BufferedReader buffered$default(Reader r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (ZeusTransformUtils.instanceOf(r0, BufferedReader.class) == false) goto L9;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r0, BufferedReader.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedReader(r0, r1);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (ZeusTransformUtils.instanceOf(r0, BufferedWriter.class) == false) goto L9;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r0, BufferedWriter.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedWriter(r0, r1);
    }

    public static final long copyTo(Reader r5, Writer r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "out");
        char[] r8 = new char[r7];
        int r0 = r5.read(r8);
        long r1 = 0;
    L3:
        if (r0 < 0) goto L5;
        r6.write(r8, 0, r0);
        r1 = r1 + ((long) r0);
        r0 = r5.read(r8);
        goto L3
    L5:
        return r1;
    }

    public static /* synthetic */ long copyTo$default(Reader r0, Writer r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 8192;
    L6:
        return copyTo(r0, r1, r2);
    }

    public static final void forEachLine(Reader r3, Function1<? super String, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        if (ZeusTransformUtils.instanceOf(r3, BufferedReader.class) == false) goto L5;
        BufferedReader r6 = (BufferedReader) ZeusTransformUtils.preCheckCast(r3, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
        Iterator<String> r1 = lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r7, BufferedReader.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        r5.invoke(r1.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L5:
        r6 = new BufferedReader(r3, 8192);
        goto L6
    }

    public static final Sequence<String> lineSequence(BufferedReader r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return SequencesKt.constrainOnce((Sequence) ZeusTransformUtils.preCheckCast(new LinesSequence(r2), Sequence.class, "com.obric.memorydata.plugin"));
    }

    public static final byte[] readBytes(URL r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2.openStream(), Closeable.class, "com.obric.memorydata.plugin");
        InputStream r0 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        byte[] r1 = ByteStreamsKt.readBytes(r0);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r1;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public static final List<String> readLines(Reader r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        final ArrayList r0 = new ArrayList();
        forEachLine(r4, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0), Function1.class, "com.obric.memorydata.plugin"));
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final String readText(Reader r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringWriter r0 = new StringWriter();
        copyTo$default(r5, (Writer) ZeusTransformUtils.preCheckCast(r0, Writer.class, "com.obric.memorydata.plugin"), 0, 2, null);
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    private static final String readText(URL r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new String(readBytes(r1), r2);
    }

    static /* synthetic */ String readText$default(URL r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new String(readBytes(r0), r1);
    }

    private static final StringReader reader(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new StringReader(r1);
    }

    public static final <T> T useLines(Reader r5, Function1<? super Sequence<String>, ? extends T> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "block");
        if (ZeusTransformUtils.instanceOf(r5, BufferedReader.class) == false) goto L5;
        BufferedReader r8 = (BufferedReader) ZeusTransformUtils.preCheckCast(r5, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        T r10 = (T) r7.invoke(lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.memorydata.plugin")));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r9, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r10;
    L11:
        r9.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r9, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r9.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r8 = new BufferedReader(r5, 8192);
        goto L6
    }
}

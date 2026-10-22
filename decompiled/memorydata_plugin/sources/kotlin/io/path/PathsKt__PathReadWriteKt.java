package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001aL\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
    }

    private static final void appendBytes(Path r3, byte[] r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "array");
        Files.write(r5, r4, new OpenOption[]{StandardOpenOption.APPEND});
    }

    private static final Path appendLines(Path r3, Iterable<? extends CharSequence> r4, Charset r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Path r8 = Files.write(r6, r7, r5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    private static final Path appendLines(Path r3, Sequence<? extends CharSequence> r4, Charset r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Sequence r7 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Path r8 = Files.write(r6, SequencesKt.asIterable(r7), r5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    static /* synthetic */ Path appendLines$default(Path r1, Iterable r2, Charset r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Path r8 = Files.write(r6, r7, r3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    static /* synthetic */ Path appendLines$default(Path r1, Sequence r2, Charset r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Sequence r7 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r2, Sequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Path r8 = Files.write(r6, SequencesKt.asIterable(r7), r3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    public static final void appendText(Path r3, CharSequence r4, Charset r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r5, "charset");
        PathsKt.writeText(r6, r7, r5, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ void appendText$default(Path r1, CharSequence r2, Charset r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        PathsKt.appendText(r6, r7, r3);
    }

    private static final BufferedReader bufferedReader(Path r4, Charset r5, int r6, OpenOption... r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Intrinsics.checkNotNullParameter(r7, "options");
        return new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(Files.newInputStream(r8, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), OpenOption[].class, "com.obric.memorydata.plugin")), r5), Reader.class, "com.obric.memorydata.plugin"), r6);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path r2, Charset r3, int r4, OpenOption[] r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r3 = Charsets.UTF_8;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r4 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        return new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(Files.newInputStream(r8, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin")), r3), Reader.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final BufferedWriter bufferedWriter(Path r4, Charset r5, int r6, OpenOption... r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Intrinsics.checkNotNullParameter(r7, "options");
        return new BufferedWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter(Files.newOutputStream(r8, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), OpenOption[].class, "com.obric.memorydata.plugin")), r5), Writer.class, "com.obric.memorydata.plugin"), r6);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path r2, Charset r3, int r4, OpenOption[] r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r3 = Charsets.UTF_8;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r4 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        return new BufferedWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter(Files.newOutputStream(r8, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin")), r3), Writer.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final void forEachLine(Path r3, Charset r4, Function1<? super String, Unit> r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r7, "action");
        BufferedReader r8 = Files.newBufferedReader(r6, r4);
        Intrinsics.checkNotNullExpressionValue(r8, "newBufferedReader(...)");
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast((Reader) ZeusTransformUtils.preCheckCast(r8, Reader.class, "com.obric.memorydata.plugin"), BufferedReader.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");
        Iterator<String> r1 = TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        r7.invoke(r1.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r9, null);
    L12:
        InlineMarker.finallyEnd(1);
        return;
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
    }

    static /* synthetic */ void forEachLine$default(Path r2, Charset r3, Function1 r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r8, "action");
        BufferedReader r9 = Files.newBufferedReader(r7, r3);
        Intrinsics.checkNotNullExpressionValue(r9, "newBufferedReader(...)");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast((Reader) ZeusTransformUtils.preCheckCast(r9, Reader.class, "com.obric.memorydata.plugin"), BufferedReader.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");
        Iterator<String> r0 = TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r10, BufferedReader.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
    L8:
        if (r0.hasNext() == false) goto L10;
        r8.invoke(r0.next());     // Catch: Throwable -> L17
        goto L8
    L10:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r10, null);
    L15:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        r10.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L30;
        CloseableKt.closeFinally(r10, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        r10.close();     // Catch: Throwable -> L27
        goto L25
    }

    private static final InputStream inputStream(Path r2, OpenOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        InputStream r5 = Files.newInputStream(r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "newInputStream(...)");
        return r5;
    }

    private static final OutputStream outputStream(Path r2, OpenOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "options");
        OutputStream r5 = Files.newOutputStream(r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r5, "newOutputStream(...)");
        return r5;
    }

    private static final byte[] readBytes(Path r2) {
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        byte[] r4 = Files.readAllBytes(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "readAllBytes(...)");
        return r4;
    }

    private static final List<String> readLines(Path r2, Charset r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        List<String> r5 = Files.readAllLines(r4, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "readAllLines(...)");
        return r5;
    }

    static /* synthetic */ List readLines$default(Path r1, Charset r2, int r3, Object r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        List<String> r6 = Files.readAllLines(r5, r2);
        Intrinsics.checkNotNullExpressionValue(r6, "readAllLines(...)");
        return r6;
    }

    public static final String readText(Path r4, Charset r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new InputStreamReader(Files.newInputStream(r6, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new OpenOption[0], 0), OpenOption[].class, "com.obric.memorydata.plugin")), r5), Closeable.class, "com.obric.memorydata.plugin");
        String r8 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((InputStreamReader) ZeusTransformUtils.preCheckCast(r7, InputStreamReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r7, null);
        return r8;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static /* synthetic */ String readText$default(Path r1, Charset r2, int r3, Object r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = Charsets.UTF_8;
    L6:
        return PathsKt.readText(r5, r2);
    }

    private static final InputStreamReader reader(Path r3, Charset r4, OpenOption... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        return new InputStreamReader(Files.newInputStream(r6, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin")), r4);
    }

    static /* synthetic */ InputStreamReader reader$default(Path r1, Charset r2, OpenOption[] r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, "options");
        return new InputStreamReader(Files.newInputStream(r6, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin")), r2);
    }

    private static final <T> T useLines(Path r3, Charset r4, Function1<? super Sequence<String>, ? extends T> r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r7, "block");
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newBufferedReader(r6, r4), Closeable.class, "com.obric.memorydata.plugin");
        BufferedReader r1 = (BufferedReader) ZeusTransformUtils.preCheckCast(r8, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11
        T r9 = (T) r7.invoke(TextStreamsKt.lineSequence(r1));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r8, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r9;
    L7:
        if (r8 == null) goto L9;
        r8.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r8 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r8.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r8, th);
        goto L20
    }

    static /* synthetic */ Object useLines$default(Path r2, Charset r3, Function1 r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r8, "block");
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newBufferedReader(r7, r3), Closeable.class, "com.obric.memorydata.plugin");
        BufferedReader r0 = (BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L14
        Object r10 = r8.invoke(TextStreamsKt.lineSequence(r0));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r9, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r10;
    L10:
        if (r9 == null) goto L12;
        r9.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r9 != null) goto L28;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L28:
        r9.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r9, th);
        goto L23
    }

    private static final void writeBytes(Path r2, byte[] r3, OpenOption... r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "array");
        Intrinsics.checkNotNullParameter(r4, "options");
        Files.write(r5, r3, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), OpenOption[].class, "com.obric.memorydata.plugin"));
    }

    private static final Path writeLines(Path r2, Iterable<? extends CharSequence> r3, Charset r4, OpenOption... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        Path r8 = Files.write(r6, r7, r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    private static final Path writeLines(Path r2, Sequence<? extends CharSequence> r3, Charset r4, OpenOption... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Sequence r7 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r3, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lines");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        Path r8 = Files.write(r6, SequencesKt.asIterable(r7), r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r8, "write(...)");
        return r8;
    }

    static /* synthetic */ Path writeLines$default(Path r1, Iterable r2, Charset r3, OpenOption[] r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r9 = Files.write(r7, r8, r3, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "write(...)");
        return r9;
    }

    static /* synthetic */ Path writeLines$default(Path r1, Sequence r2, Charset r3, OpenOption[] r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Sequence r8 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r2, Sequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "lines");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "options");
        Path r9 = Files.write(r7, SequencesKt.asIterable(r8), r3, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r9, "write(...)");
        return r9;
    }

    public static final void writeText(Path r4, CharSequence r5, Charset r6, OpenOption... r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "charset");
        Intrinsics.checkNotNullParameter(r7, "options");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(Files.newOutputStream(r8, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), OpenOption[].class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        OutputStream r11 = (OutputStream) ZeusTransformUtils.preCheckCast(r10, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L6;
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L21
        FilesKt.writeTextImpl(r11, (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), r6);     // Catch: Throwable -> L21
    L18:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r10, null);
        return;
    L6:
        CharsetEncoder r13 = FilesKt.newReplaceEncoder(r6);     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r9, CharBuffer.class) == false) goto L9;
        CharBuffer r0 = ((CharBuffer) ZeusTransformUtils.preCheckCast(r9, CharBuffer.class, "com.obric.memorydata.plugin")).asReadOnlyBuffer();     // Catch: Throwable -> L21
    L10:
        int r14 = Math.min(r9.length(), 8192);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L21
        ByteBuffer r15 = FilesKt.byteBufferForEncoding(r14, r13);     // Catch: Throwable -> L21
    L12:
        if (r0.hasRemaining() == false) goto L18;
        if ((true ^ r13.encode(r0, r15, true).isError()) == false) goto L17;
        r11.write(r15.array(), 0, r15.position());     // Catch: Throwable -> L21
        r15.clear();     // Catch: Throwable -> L21
        goto L12
    L17:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L21
    L9:
        r0 = CharBuffer.wrap(r9);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    public static /* synthetic */ void writeText$default(Path r1, CharSequence r2, Charset r3, OpenOption[] r4, int r5, Object r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = Charsets.UTF_8;
    L5:
        PathsKt.writeText(r7, r8, r3, r4);
    }

    private static final OutputStreamWriter writer(Path r3, Charset r4, OpenOption... r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, "options");
        return new OutputStreamWriter(Files.newOutputStream(r6, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), OpenOption[].class, "com.obric.memorydata.plugin")), r4);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path r1, Charset r2, OpenOption[] r3, int r4, Object r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, "options");
        return new OutputStreamWriter(Files.newOutputStream(r6, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin")), r2);
    }
}

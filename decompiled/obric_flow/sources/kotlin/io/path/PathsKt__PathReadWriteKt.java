package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001aL\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", MessageIndication.CONTENT_TYPE_TEXT, "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", SVGRenderEngine.LINE, "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,346:1\n1#2:347\n1#2:352\n54#3,4:348\n1317#4,2:353\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n219#1:352\n219#1:348,4\n219#1:353,2\n*E\n"})
class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void appendBytes(Path r5, byte[] r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "array");
        Files.write(r5, r10, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path appendLines(Path r5, Iterable<? extends CharSequence> r10, Charset r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return Files.write(r5, r10, r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ Path appendLines$default(Path r5, Iterable r10, Charset r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return Files.write(r5, r10, r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void appendText(Path r5, CharSequence r10, Charset r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "charset");
        writeText(r5, r10, r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ void appendText$default(Path r5, CharSequence r10, Charset r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        appendText(r5, r10, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedReader bufferedReader(Path r5, Charset r10, int r11, OpenOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r10), r11);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(Path r5, Charset r10, int r11, OpenOption[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r10), r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedWriter bufferedWriter(Path r5, Charset r10, int r11, OpenOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r10), r11);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(Path r5, Charset r10, int r11, OpenOption[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r10), r11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void forEachLine(Path r5, Charset r10, Function1<? super String, Unit> r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "action");
        BufferedReader r12 = Files.newBufferedReader(r5, r10);
        Iterator<String> r13 = TextStreamsKt.lineSequence(r12).iterator();     // Catch: Throwable -> L7
    L5:
        if (r13.hasNext() == false) goto L9;
        r11.invoke(r13.next());     // Catch: Throwable -> L7
        goto L5
    L9:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L13;
        CloseableKt.closeFinally(r12, null);
    L14:
        InlineMarker.finallyEnd(1);
        return;
    L13:
        r12.close();
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L28;
        CloseableKt.closeFinally(r12, th);
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L28:
        r12.close();     // Catch: Throwable -> L25
        goto L23
    }

    public static /* synthetic */ void forEachLine$default(Path r5, Charset r10, Function1 r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "action");
        BufferedReader r14 = Files.newBufferedReader(r5, r10);
        Iterator<String> r15 = TextStreamsKt.lineSequence(r14).iterator();     // Catch: Throwable -> L10
    L8:
        if (r15.hasNext() == false) goto L12;
        r11.invoke(r15.next());     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L16;
        CloseableKt.closeFinally(r14, null);
    L17:
        InlineMarker.finallyEnd(1);
        return;
    L16:
        r14.close();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L33;
        CloseableKt.closeFinally(r14, th);
    L26:
        InlineMarker.finallyEnd(1);
        throw th;
    L33:
        r14.close();     // Catch: Throwable -> L28
        goto L26
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStream inputStream(Path r5, OpenOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStream outputStream(Path r5, OpenOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final byte[] readBytes(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.readAllBytes(r5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final List<String> readLines(Path r5, Charset r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return Files.readAllLines(r5, r10);
    }

    public static /* synthetic */ List readLines$default(Path r5, Charset r10, int r11, Object r12) throws IOException {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return Files.readAllLines(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final String readText(Path r5, Charset r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        InputStreamReader r11 = new InputStreamReader(Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), r10);
        String r12 = TextStreamsKt.readText(r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r12;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static /* synthetic */ String readText$default(Path r5, Charset r10, int r11, Object r12) throws IOException {
        if ((r11 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        return readText(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStreamReader reader(Path r5, Charset r10, OpenOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new InputStreamReader(Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(r11, r11.length)), r10);
    }

    public static /* synthetic */ InputStreamReader reader$default(Path r5, Charset r10, OpenOption[] r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new InputStreamReader(Files.newInputStream(r5, (OpenOption[]) Arrays.copyOf(r11, r11.length)), r10);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final <T> T useLines(Path r5, Charset r10, Function1<? super Sequence<String>, ? extends T> r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "block");
        BufferedReader r12 = Files.newBufferedReader(r5, r10);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        T r13 = r11.invoke(TextStreamsKt.lineSequence(r12));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r12, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r13;
    L7:
        if (r12 == null) goto L9;
        r12.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r12 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r12.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r12, th);
        goto L20
    }

    public static /* synthetic */ Object useLines$default(Path r5, Charset r10, Function1 r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "block");
        BufferedReader r14 = Files.newBufferedReader(r5, r10);
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L14
        Object r15 = r11.invoke(TextStreamsKt.lineSequence(r14));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r14, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r15;
    L10:
        if (r14 == null) goto L12;
        r14.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r14 != null) goto L26;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L26:
        r14.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r14, th);
        goto L23
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void writeBytes(Path r5, byte[] r10, OpenOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "array");
        Intrinsics.checkNotNullParameter(r11, "options");
        Files.write(r5, r10, (OpenOption[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path writeLines(Path r5, Iterable<? extends CharSequence> r10, Charset r11, OpenOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.write(r5, r10, r11, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    }

    public static /* synthetic */ Path writeLines$default(Path r5, Iterable r10, Charset r11, OpenOption[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.write(r5, r10, r11, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void writeText(Path r5, CharSequence r10, Charset r11, OpenOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        OutputStream r13 = Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L4:
        if ((r10 instanceof String) == false) goto L8;
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L6
        FilesKt.writeTextImpl(r13, (String) r10, r11);     // Catch: Throwable -> L6
    L20:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r13, null);
        return;
    L8:
        CharsetEncoder r15 = FilesKt.newReplaceEncoder(r11);     // Catch: Throwable -> L6
        if ((r10 instanceof CharBuffer) == false) goto L11;
        CharBuffer r16 = ((CharBuffer) r10).asReadOnlyBuffer();     // Catch: Throwable -> L6
    L12:
        int r17 = Math.min(r10.length(), 8192);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L6
        ByteBuffer r18 = FilesKt.byteBufferForEncoding(r17, r15);     // Catch: Throwable -> L6
    L14:
        if (r16.hasRemaining() == false) goto L20;
        if (r15.encode(r16, r18, true).isError() == true) goto L19;
        r13.write(r18.array(), 0, r18.position());     // Catch: Throwable -> L6
        r18.clear();     // Catch: Throwable -> L6
        goto L14
    L19:
        throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L6
    L11:
        r16 = CharBuffer.wrap(r10);     // Catch: Throwable -> L6
        goto L12
    }

    public static /* synthetic */ void writeText$default(Path r5, CharSequence r10, Charset r11, OpenOption[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        writeText(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStreamWriter writer(Path r5, Charset r10, OpenOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new OutputStreamWriter(Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r11, r11.length)), r10);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(Path r5, Charset r10, OpenOption[] r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new OutputStreamWriter(Files.newOutputStream(r5, (OpenOption[]) Arrays.copyOf(r11, r11.length)), r10);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path appendLines(Path r5, Sequence<? extends CharSequence> r10, Charset r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return Files.write(r5, SequencesKt.asIterable(r10), r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path writeLines(Path r5, Sequence<? extends CharSequence> r10, Charset r11, OpenOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.write(r5, SequencesKt.asIterable(r10), r11, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    }

    public static /* synthetic */ Path appendLines$default(Path r5, Sequence r10, Charset r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return Files.write(r5, SequencesKt.asIterable(r10), r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ Path writeLines$default(Path r5, Sequence r10, Charset r11, OpenOption[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "lines");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.write(r5, SequencesKt.asIterable(r10), r11, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    }
}

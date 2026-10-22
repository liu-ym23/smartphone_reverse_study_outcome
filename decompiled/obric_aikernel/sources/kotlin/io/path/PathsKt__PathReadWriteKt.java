package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n1#2:327\n1#2:329\n52#3:328\n1313#4,2:330\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n202#1:329\n202#1:328\n202#1:330,2\n*E\n"})
class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void appendBytes(Path r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "array");
        Files.write(r10, r11, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path appendLines(Path r10, Iterable<? extends CharSequence> r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Path r13 = Files.write(r10, r11, r12, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r13, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path appendLines(Path r10, Sequence<? extends CharSequence> r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Path r13 = Files.write(r10, SequencesKt.asIterable(r11), r12, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r13, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return r13;
    }

    static /* synthetic */ Path appendLines$default(Path r10, Iterable r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Path r15 = Files.write(r10, r11, r12, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r15, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return r15;
    }

    static /* synthetic */ Path appendLines$default(Path r10, Sequence r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Path r15 = Files.write(r10, SequencesKt.asIterable(r11), r12, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r15, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return r15;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void appendText(Path r10, CharSequence r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "charset");
        OutputStream r13 = Files.newOutputStream(r10, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(r13, "newOutputStream(this, StandardOpenOption.APPEND)");
        OutputStreamWriter r14 = new OutputStreamWriter(r13, r12);
        r14.append(r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public static /* synthetic */ void appendText$default(Path r10, CharSequence r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        appendText(r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedReader bufferedReader(Path r10, Charset r11, int r12, OpenOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(r13, r13.length)), r11), r12);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path r10, Charset r11, int r12, OpenOption[] r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(r13, r13.length)), r11), r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final BufferedWriter bufferedWriter(Path r10, Charset r11, int r12, OpenOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r13, r13.length)), r11), r12);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path r10, Charset r11, int r12, OpenOption[] r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r13, r13.length)), r11), r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void forEachLine(Path r10, Charset r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "action");
        BufferedReader r13 = Files.newBufferedReader(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "newBufferedReader(this, charset)");
        Iterator<String> r14 = TextStreamsKt.lineSequence(r13).iterator();     // Catch: Throwable -> L10
    L5:
        if (r14.hasNext() == false) goto L7;
        r12.invoke(r14.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, null);
        InlineMarker.finallyEnd(1);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static /* synthetic */ void forEachLine$default(Path r10, Charset r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "action");
        BufferedReader r15 = Files.newBufferedReader(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r15, "newBufferedReader(this, charset)");
        Iterator<String> r16 = TextStreamsKt.lineSequence(r15).iterator();     // Catch: Throwable -> L13
    L8:
        if (r16.hasNext() == false) goto L10;
        r12.invoke(r16.next());     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, null);
        InlineMarker.finallyEnd(1);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStream inputStream(Path r10, OpenOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        InputStream r12 = Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "newInputStream(this, *options)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStream outputStream(Path r10, OpenOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        OutputStream r12 = Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "newOutputStream(this, *options)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final byte[] readBytes(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = Files.readAllBytes(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "readAllBytes(this)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final List<String> readLines(Path r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        List<String> r12 = Files.readAllLines(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "readAllLines(this, charset)");
        return r12;
    }

    static /* synthetic */ List readLines$default(Path r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        List<String> r14 = Files.readAllLines(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "readAllLines(this, charset)");
        return r14;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final String readText(Path r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        InputStreamReader r12 = new InputStreamReader(Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), r11);
        String r13 = TextStreamsKt.readText(r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r12, null);
        return r13;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public static /* synthetic */ String readText$default(Path r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        return readText(r10, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final InputStreamReader reader(Path r10, Charset r11, OpenOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new InputStreamReader(Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r11);
    }

    static /* synthetic */ InputStreamReader reader$default(Path r10, Charset r11, OpenOption[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new InputStreamReader(Files.newInputStream(r10, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final <T> T useLines(Path r10, Charset r11, Function1<? super Sequence<String>, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "block");
        BufferedReader r13 = Files.newBufferedReader(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "it");     // Catch: Throwable -> L6
        T r14 = r12.invoke(TextStreamsKt.lineSequence(r13));     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, null);
        InlineMarker.finallyEnd(1);
        return r14;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static /* synthetic */ Object useLines$default(Path r10, Charset r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "block");
        BufferedReader r15 = Files.newBufferedReader(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r15, "it");     // Catch: Throwable -> L9
        Object r16 = r12.invoke(TextStreamsKt.lineSequence(r15));     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, null);
        InlineMarker.finallyEnd(1);
        return r16;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void writeBytes(Path r10, byte[] r11, OpenOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "array");
        Intrinsics.checkNotNullParameter(r12, "options");
        Files.write(r10, r11, (OpenOption[]) Arrays.copyOf(r12, r12.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path writeLines(Path r10, Iterable<? extends CharSequence> r11, Charset r12, OpenOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        Path r14 = Files.write(r10, r11, r12, (OpenOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "write(this, lines, charset, *options)");
        return r14;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path writeLines(Path r10, Sequence<? extends CharSequence> r11, Charset r12, OpenOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        Path r14 = Files.write(r10, SequencesKt.asIterable(r11), r12, (OpenOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "write(this, lines.asIterable(), charset, *options)");
        return r14;
    }

    static /* synthetic */ Path writeLines$default(Path r10, Iterable r11, Charset r12, OpenOption[] r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        Path r16 = Files.write(r10, r11, r12, (OpenOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r16, "write(this, lines, charset, *options)");
        return r16;
    }

    static /* synthetic */ Path writeLines$default(Path r10, Sequence r11, Charset r12, OpenOption[] r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lines");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        Path r16 = Files.write(r10, SequencesKt.asIterable(r11), r12, (OpenOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r16, "write(this, lines.asIterable(), charset, *options)");
        return r16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final void writeText(Path r10, CharSequence r11, Charset r12, OpenOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "charset");
        Intrinsics.checkNotNullParameter(r13, "options");
        OutputStream r14 = Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "newOutputStream(this, *options)");
        OutputStreamWriter r15 = new OutputStreamWriter(r14, r12);
        r15.append(r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r15, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    }

    public static /* synthetic */ void writeText$default(Path r10, CharSequence r11, Charset r12, OpenOption[] r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        writeText(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final OutputStreamWriter writer(Path r10, Charset r11, OpenOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new OutputStreamWriter(Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r11);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path r10, Charset r11, OpenOption[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "options");
        return new OutputStreamWriter(Files.newOutputStream(r10, (OpenOption[]) Arrays.copyOf(r12, r12.length)), r11);
    }
}

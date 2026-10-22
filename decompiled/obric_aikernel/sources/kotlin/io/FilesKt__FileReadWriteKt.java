package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n231#1:234\n1#2:233\n1#2:235\n*S KotlinDebug\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n*L\n230#1:234\n230#1:235\n*E\n"})
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public FilesKt__FileReadWriteKt() {
    }

    public static final void appendBytes(File r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "array");
        FileOutputStream r12 = new FileOutputStream(r10, true);
        r12.write(r11);     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r12, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public static final void appendText(File r10, String r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "charset");
        byte[] r13 = r11.getBytes(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).getBytes(charset)");
        appendBytes(r10, r13);
    }

    public static /* synthetic */ void appendText$default(File r10, String r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        appendText(r10, r11, r12);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(File r10, Charset r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Reader r13 = new InputStreamReader(new FileInputStream(r10), r11);
        if ((r13 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r13;
    L6:
        return new BufferedReader(r13, r12);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File r10, Charset r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Reader r15 = new InputStreamReader(new FileInputStream(r10), r11);
        if ((r15 instanceof BufferedReader) == false) goto L12;
        return (BufferedReader) r15;
    L12:
        return new BufferedReader(r15, r12);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(File r10, Charset r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r13 = new OutputStreamWriter(new FileOutputStream(r10), r11);
        if ((r13 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r13;
    L6:
        return new BufferedWriter(r13, r12);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File r10, Charset r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r15 = new OutputStreamWriter(new FileOutputStream(r10), r11);
        if ((r15 instanceof BufferedWriter) == false) goto L12;
        return (BufferedWriter) r15;
    L12:
        return new BufferedWriter(r15, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void forEachBlock(File r10, int r11, Function2<? super byte[], ? super Integer, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        ?? r13 = new byte[RangesKt.coerceAtLeast(r11, 512)];
        FileInputStream r14 = new FileInputStream(r10);
    L15:
        int r15 = r14.read(r13);     // Catch: Throwable -> L10
        if (r15 <= 0) goto L5;
        r12.invoke(r13, Integer.valueOf(r15));     // Catch: Throwable -> L10
        goto L15
    L5:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r14, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public static final void forEachBlock(File r10, Function2<? super byte[], ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        forEachBlock(r10, 4096, r11);
    }

    public static final void forEachLine(File r10, Charset r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(r10), r11)), r12);
    }

    public static /* synthetic */ void forEachLine$default(File r10, Charset r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        forEachLine(r10, r11, r12);
    }

    @InlineOnly
    private static final FileInputStream inputStream(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new FileInputStream(r10);
    }

    @InlineOnly
    private static final FileOutputStream outputStream(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new FileOutputStream(r10);
    }

    @InlineOnly
    private static final PrintWriter printWriter(File r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r12 = new OutputStreamWriter(new FileOutputStream(r10), r11);
        if ((r12 instanceof BufferedWriter) == false) goto L5;
        BufferedWriter r13 = (BufferedWriter) r12;
    L7:
        return new PrintWriter(r13);
    L5:
        r13 = new BufferedWriter(r12, 8192);
        goto L7
    }

    static /* synthetic */ PrintWriter printWriter$default(File r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r14 = new OutputStreamWriter(new FileOutputStream(r10), r11);
        if ((r14 instanceof BufferedWriter) == false) goto L8;
        BufferedWriter r15 = (BufferedWriter) r14;
    L10:
        return new PrintWriter(r15);
    L8:
        r15 = new BufferedWriter(r14, 8192);
        goto L10
    }

    public static byte[] readBytes(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FileInputStream r11 = new FileInputStream(r10);
        long r12 = r10.length();     // Catch: Throwable -> L27
        if (r12 > 2147483647L) goto L26;
        int r13 = (int) r12;
        byte[] r14 = new byte[r13];     // Catch: Throwable -> L27
        int r15 = r13;
        int r16 = 0;
    L8:
        if (r15 <= 0) goto L13;
        int r17 = r11.read(r14, r16, r15);     // Catch: Throwable -> L27
        if (r17 < 0) goto L13;
        r15 = r15 - r17;
        r16 = r16 + r17;
    L13:
        if (r15 <= 0) goto L15;
        r14 = Arrays.copyOf(r14, r16);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r14, "copyOf(this, newSize)");     // Catch: Throwable -> L27
    L21:
        CloseableKt.closeFinally(r11, null);
        return r14;
    L15:
        int r18 = r11.read();     // Catch: Throwable -> L27
        if (r18 == (-1)) goto L21;
        ExposingBufferByteArrayOutputStream r19 = new ExposingBufferByteArrayOutputStream(8193);     // Catch: Throwable -> L27
        r19.write(r18);     // Catch: Throwable -> L27
        ByteStreamsKt.copyTo$default(r11, r19, 0, 2, null);     // Catch: Throwable -> L27
        int r20 = r19.size() + r13;     // Catch: Throwable -> L27
        if (r20 < 0) goto L24;
        byte[] r110 = r19.getBuffer();     // Catch: Throwable -> L27
        byte[] r21 = Arrays.copyOf(r14, r20);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r21, "copyOf(this, newSize)");     // Catch: Throwable -> L27
        r14 = ArraysKt.copyInto(r110, r21, r13, 0, r19.size());     // Catch: Throwable -> L27
        goto L21
    L24:
        throw new OutOfMemoryError("File " + r10 + " is too big to fit in memory.");     // Catch: Throwable -> L27
    L26:
        throw new OutOfMemoryError("File " + r10 + " is too big (" + r12 + " bytes) to fit in memory.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final List<String> readLines(File r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        final ArrayList r12 = new ArrayList();
        forEachLine(r10, r11, new AnonymousClass1(r12));
        return r12;
    }

    public static /* synthetic */ List readLines$default(File r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        return readLines(r10, r11);
    }

    public static final String readText(File r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        InputStreamReader r12 = new InputStreamReader(new FileInputStream(r10), r11);
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

    public static /* synthetic */ String readText$default(File r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = Charsets.UTF_8;
    L6:
        return readText(r10, r11);
    }

    @InlineOnly
    private static final InputStreamReader reader(File r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new InputStreamReader(new FileInputStream(r10), r11);
    }

    static /* synthetic */ InputStreamReader reader$default(File r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new InputStreamReader(new FileInputStream(r10), r11);
    }

    public static final <T> T useLines(File r10, Charset r11, Function1<? super Sequence<String>, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Intrinsics.checkNotNullParameter(r12, "block");
        Reader r13 = new InputStreamReader(new FileInputStream(r10), r11);
        if ((r13 instanceof BufferedReader) == false) goto L5;
        BufferedReader r14 = (BufferedReader) r13;
    L15:
        T r15 = r12.invoke(TextStreamsKt.lineSequence(r14));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r14, null);
        InlineMarker.finallyEnd(1);
        return r15;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r14, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r14 = new BufferedReader(r13, 8192);
        goto L15
    }

    public static /* synthetic */ Object useLines$default(File r10, Charset r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Reader r15 = new InputStreamReader(new FileInputStream(r10), r11);
        if ((r15 instanceof BufferedReader) == false) goto L8;
        BufferedReader r16 = (BufferedReader) r15;
    L18:
        Object r17 = r12.invoke(TextStreamsKt.lineSequence(r16));     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r16, null);
        InlineMarker.finallyEnd(1);
        return r17;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r16, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L8:
        r16 = new BufferedReader(r15, 8192);
        goto L18
    }

    public static void writeBytes(File r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "array");
        FileOutputStream r12 = new FileOutputStream(r10);
        r12.write(r11);     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r12, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public static void writeText(File r10, String r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r12, "charset");
        byte[] r13 = r11.getBytes(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).getBytes(charset)");
        FilesKt.writeBytes(r10, r13);
    }

    public static /* synthetic */ void writeText$default(File r10, String r11, Charset r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = Charsets.UTF_8;
    L5:
        FilesKt.writeText(r10, r11, r12);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(File r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new OutputStreamWriter(new FileOutputStream(r10), r11);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new OutputStreamWriter(new FileOutputStream(r10), r11);
    }
}

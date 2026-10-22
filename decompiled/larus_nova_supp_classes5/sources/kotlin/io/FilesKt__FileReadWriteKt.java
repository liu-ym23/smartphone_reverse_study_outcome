package kotlin.io;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001aB\u0010\u0015\u001a\u00020\u0007*\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001aJ\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001a7\u0010\u001d\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u001e\u001a\r\u0010 \u001a\u00020!*\u00020\bH\u0087\b\u001a\u0014\u0010\"\u001a\n #*\u0004\u0018\u00010\u00050\u0005*\u00020\u000fH\u0000\u001a\r\u0010$\u001a\u00020%*\u00020\bH\u0087\b\u001a\u0017\u0010&\u001a\u00020'*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\n\u0010(\u001a\u00020\n*\u00020\b\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0**\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010+\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010,\u001a\u00020-*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001aL\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01\u0012\u0004\u0012\u0002H/0\u001eH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00102\u001a\u0012\u00103\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u00104\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u00105\u001a\u00020\u0007*\u0002062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0017\u00107\u001a\u000208*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", DBDefinition.NAME, "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "newReplaceEncoder", "kotlin.jvm.PlatformType", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writeTextImpl", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public FilesKt__FileReadWriteKt() {
    }

    private static final FileInputStream inputStream(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new FileInputStream(r1);
    }

    public static CharsetEncoder newReplaceEncoder(Charset r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new FileOutputStream(r1);
    }

    public static byte[] readBytes(File r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        FileInputStream r0 = new FileInputStream(r9);
        long r1 = r9.length();     // Catch: Throwable -> L27
        if (r1 > 2147483647L) goto L26;
        int r2 = (int) r1;
        byte[] r3 = new byte[r2];     // Catch: Throwable -> L27
        int r4 = r2;
        int r6 = 0;
    L8:
        if (r4 <= 0) goto L13;
        int r7 = r0.read(r3, r6, r4);     // Catch: Throwable -> L27
        if (r7 < 0) goto L13;
        r4 = r4 - r7;     // Catch: Throwable -> L27
        r6 = r6 + r7;     // Catch: Throwable -> L27
    L13:
        if (r4 <= 0) goto L15;
        r3 = Arrays.copyOf(r3, r6);     // Catch: Throwable -> L27
    L21:
        CloseableKt.closeFinally(r0, null);
        return r3;
    L15:
        int r5 = r0.read();     // Catch: Throwable -> L27
        if (r5 == (-1)) goto L21;
        ExposingBufferByteArrayOutputStream r8 = new ExposingBufferByteArrayOutputStream(8193);     // Catch: Throwable -> L27
        r8.write(r5);     // Catch: Throwable -> L27
        ByteStreamsKt.copyTo$default(r0, r8, 0, 2, null);     // Catch: Throwable -> L27
        int r10 = r8.size() + r2;     // Catch: Throwable -> L27
        if (r10 < 0) goto L24;
        r3 = ArraysKt.copyInto(r8.getBuffer(), Arrays.copyOf(r3, r10), r2, 0, r8.size());     // Catch: Throwable -> L27
        goto L21
    L24:
        throw new OutOfMemoryError("File " + r9 + " is too big to fit in memory.");     // Catch: Throwable -> L27
    L26:
        throw new OutOfMemoryError("File " + r9 + " is too big (" + r1 + " bytes) to fit in memory.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static void appendBytes(File r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "array");
        FileOutputStream r0 = new FileOutputStream(r2, true);
        r0.write(r3);     // Catch: Throwable -> L6
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static ByteBuffer byteBufferForEncoding(int r2, CharsetEncoder r3) {
        Intrinsics.checkNotNullParameter(r3, "encoder");
        return ByteBuffer.allocate(r2 * ((int) Math.ceil(r3.maxBytesPerChar())));
    }

    public static final void forEachBlock(File r1, Function2<? super byte[], ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        forEachBlock(r1, 4096, r2);
    }

    private static final PrintWriter printWriter(File r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Writer r1 = new OutputStreamWriter(new FileOutputStream(r3), r4);
        if ((r1 instanceof BufferedWriter) == false) goto L5;
        BufferedWriter r2 = (BufferedWriter) r1;
    L7:
        return new PrintWriter(r2);
    L5:
        r2 = new BufferedWriter(r1, 8192);
        goto L7
    }

    public static final List<String> readLines(File r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        ArrayList r0 = new ArrayList();
        forEachLine(r2, r3, new readLines.1(r0));
        return r0;
    }

    public static String readText(File r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        InputStreamReader r0 = new InputStreamReader(new FileInputStream(r2), r3);
        String r4 = TextStreamsKt.readText(r0);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    private static final InputStreamReader reader(File r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        return new InputStreamReader(new FileInputStream(r2), r3);
    }

    public static void writeBytes(File r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "array");
        FileOutputStream r0 = new FileOutputStream(r1);
        r0.write(r2);     // Catch: Throwable -> L6
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    private static final OutputStreamWriter writer(File r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        return new OutputStreamWriter(new FileOutputStream(r2), r3);
    }

    public static final void appendText(File r2, String r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "charset");
        FileOutputStream r0 = new FileOutputStream(r2, true);
        FilesKt.writeTextImpl(r0, r3, r4);     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    private static final BufferedReader bufferedReader(File r2, Charset r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Reader r0 = new InputStreamReader(new FileInputStream(r2), r3);
        if ((r0 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r0;
    L6:
        return new BufferedReader(r0, r4);
    }

    private static final BufferedWriter bufferedWriter(File r2, Charset r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Writer r0 = new OutputStreamWriter(new FileOutputStream(r2), r3);
        if ((r0 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r0;
    L6:
        return new BufferedWriter(r0, r4);
    }

    public static final void forEachBlock(File r1, int r2, Function2<? super byte[], ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "action");
        byte[] r4 = new byte[RangesKt.coerceAtLeast(r2, 512)];
        FileInputStream r0 = new FileInputStream(r1);
    L15:
        int r5 = r0.read(r4);     // Catch: Throwable -> L10
        if (r5 <= 0) goto L5;
        r3.invoke(r4, Integer.valueOf(r5));     // Catch: Throwable -> L10
        goto L15
    L5:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r0, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static final void forEachLine(File r3, Charset r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r5, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(r3), r4)), r5);
    }

    public static final <T> T useLines(File r2, Charset r3, Function1<? super Sequence<String>, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "charset");
        Intrinsics.checkNotNullParameter(r4, "block");
        Reader r0 = new InputStreamReader(new FileInputStream(r2), r3);
        if ((r0 instanceof BufferedReader) == false) goto L5;
        BufferedReader r1 = (BufferedReader) r0;
    L25:
        T r5 = (T) r4.invoke(TextStreamsKt.lineSequence(r1));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r1, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r5;
    L11:
        r1.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r1, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r1.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r1 = new BufferedReader(r0, 8192);
        goto L25
    }

    public static void writeText(File r1, String r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "charset");
        FileOutputStream r0 = new FileOutputStream(r1);
        FilesKt.writeTextImpl(r0, r2, r3);     // Catch: Throwable -> L6
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static void writeTextImpl(OutputStream r8, String r9, Charset r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r10, "charset");
        if (r9.length() >= 16384) goto L6;
        r8.write(r9.getBytes(r10));
        return;
    L6:
        CharsetEncoder r11 = FilesKt.newReplaceEncoder(r10);
        CharBuffer r1 = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(r11);
        ByteBuffer r0 = FilesKt.byteBufferForEncoding(8192, r11);
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r9.length()) goto L22;
        int r5 = Math.min(8192 - r4, r9.length() - r3);
        int r6 = r3 + r5;
        r9.getChars(r3, r6, r1.array(), r4);
        r1.limit(r5 + r4);
        r4 = 1;
        if (r6 != r9.length()) goto L12;
        boolean r7 = true;
    L14:
        if (r11.encode(r1, r0, r7).isUnderflow() == false) goto L21;
        r8.write(r0.array(), 0, r0.position());
        if (r1.position() == r1.limit()) goto L18;
        r1.put(0, r1.get());
    L19:
        r1.clear();
        r0.clear();
        r3 = r6;
        goto L8
    L18:
        r4 = 0;
        goto L19
    L21:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r7 = false;
        goto L14
    }

    public static /* synthetic */ PrintWriter printWriter$default(File r1, Charset r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Writer r5 = new OutputStreamWriter(new FileOutputStream(r1), r2);
        if ((r5 instanceof BufferedWriter) == false) goto L8;
        BufferedWriter r6 = (BufferedWriter) r5;
    L10:
        return new PrintWriter(r6);
    L8:
        r6 = new BufferedWriter(r5, 8192);
        goto L10
    }

    public static /* synthetic */ List readLines$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return readLines(r0, r1);
    }

    public static /* synthetic */ String readText$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return FilesKt.readText(r0, r1);
    }

    public static /* synthetic */ InputStreamReader reader$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new InputStreamReader(new FileInputStream(r0), r1);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new OutputStreamWriter(new FileOutputStream(r0), r1);
    }

    public static /* synthetic */ void appendText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        appendText(r0, r1, r2);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(File r0, Charset r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Reader r5 = new InputStreamReader(new FileInputStream(r0), r1);
        if ((r5 instanceof BufferedReader) == false) goto L12;
        return (BufferedReader) r5;
    L12:
        return new BufferedReader(r5, r2);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(File r0, Charset r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Writer r5 = new OutputStreamWriter(new FileOutputStream(r0), r1);
        if ((r5 instanceof BufferedWriter) == false) goto L12;
        return (BufferedWriter) r5;
    L12:
        return new BufferedWriter(r5, r2);
    }

    public static /* synthetic */ void forEachLine$default(File r0, Charset r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        forEachLine(r0, r1, r2);
    }

    public static /* synthetic */ Object useLines$default(File r1, Charset r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Intrinsics.checkNotNullParameter(r3, "block");
        Reader r6 = new InputStreamReader(new FileInputStream(r1), r2);
        if ((r6 instanceof BufferedReader) == false) goto L8;
        BufferedReader r7 = (BufferedReader) r6;
    L28:
        Object r8 = r3.invoke(TextStreamsKt.lineSequence(r7));     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r7, null);
    L15:
        InlineMarker.finallyEnd(1);
        return r8;
    L14:
        r7.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L32;
        CloseableKt.closeFinally(r7, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r7.close();     // Catch: Throwable -> L27
        goto L25
    L8:
        r7 = new BufferedReader(r6, 8192);
        goto L28
    }

    public static /* synthetic */ void writeText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        FilesKt.writeText(r0, r1, r2);
    }
}

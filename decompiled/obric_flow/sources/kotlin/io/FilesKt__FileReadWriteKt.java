package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001aB\u0010\u0015\u001a\u00020\u0007*\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001aJ\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001a7\u0010\u001d\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u001e\u001a\r\u0010 \u001a\u00020!*\u00020\bH\u0087\b\u001a\u0014\u0010\"\u001a\n #*\u0004\u0018\u00010\u00050\u0005*\u00020\u000fH\u0000\u001a\r\u0010$\u001a\u00020%*\u00020\bH\u0087\b\u001a\u0017\u0010&\u001a\u00020'*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\n\u0010(\u001a\u00020\n*\u00020\b\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0**\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010+\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010,\u001a\u00020-*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001aL\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01\u0012\u0004\u0012\u0002H/0\u001eH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00102\u001a\u0012\u00103\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u00104\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u00105\u001a\u00020\u0007*\u0002062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0017\u00107\u001a\u000208*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", MessageIndication.CONTENT_TYPE_TEXT, "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", SVGRenderEngine.LINE, "inputStream", "Ljava/io/FileInputStream;", "newReplaceEncoder", "kotlin.jvm.PlatformType", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writeTextImpl", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public FilesKt__FileReadWriteKt() {
    }

    public static final void appendBytes(File r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "array");
        FileOutputStream r11 = new FileOutputStream(r5, true);
        r11.write(r10);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final void appendText(File r5, String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "charset");
        FileOutputStream r12 = new FileOutputStream(r5, true);
        writeTextImpl(r12, r10, r11);     // Catch: Throwable -> L6
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

    public static /* synthetic */ void appendText$default(File r5, String r10, Charset r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        appendText(r5, r10, r11);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(File r5, Charset r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(r5), r10), r11);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(File r5, Charset r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(r5), r10), r11);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(File r5, Charset r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5), r10), r11);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(File r5, Charset r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5), r10), r11);
    }

    public static ByteBuffer byteBufferForEncoding(int r5, CharsetEncoder r10) {
        Intrinsics.checkNotNullParameter(r10, "encoder");
        return ByteBuffer.allocate(r5 * ((int) Math.ceil(r10.maxBytesPerChar())));
    }

    public static final void forEachBlock(File r5, Function2<? super byte[], ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        forEachBlock(r5, 4096, r10);
    }

    public static final void forEachLine(File r5, Charset r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(r5), r10)), r11);
    }

    public static /* synthetic */ void forEachLine$default(File r5, Charset r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        forEachLine(r5, r10, r11);
    }

    @InlineOnly
    private static final FileInputStream inputStream(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new FileInputStream(r5);
    }

    public static CharsetEncoder newReplaceEncoder(Charset r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        CharsetEncoder r10 = r5.newEncoder();
        CodingErrorAction r11 = CodingErrorAction.REPLACE;
        return r10.onMalformedInput(r11).onUnmappableCharacter(r11);
    }

    @InlineOnly
    private static final FileOutputStream outputStream(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new FileOutputStream(r5);
    }

    @InlineOnly
    private static final PrintWriter printWriter(File r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5), r10), 8192));
    }

    public static /* synthetic */ PrintWriter printWriter$default(File r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5), r10), 8192));
    }

    public static final byte[] readBytes(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FileInputStream r5 = new FileInputStream(r10);
        long r11 = r10.length();     // Catch: Throwable -> L12
        if (r11 > 2147483647L) goto L28;
        int r12 = (int) r11;
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L12
        int r14 = r12;
        int r15 = 0;
    L8:
        if (r14 <= 0) goto L15;
        int r16 = r5.read(r13, r15, r14);     // Catch: Throwable -> L12
        if (r16 < 0) goto L15;
        r14 = r14 - r16;     // Catch: Throwable -> L12
        r15 = r15 + r16;     // Catch: Throwable -> L12
    L15:
        if (r14 <= 0) goto L17;
        r13 = Arrays.copyOf(r13, r15);     // Catch: Throwable -> L12
    L23:
        CloseableKt.closeFinally(r5, null);
        return r13;
    L17:
        int r17 = r5.read();     // Catch: Throwable -> L12
        if (r17 == (-1)) goto L23;
        ExposingBufferByteArrayOutputStream r18 = new ExposingBufferByteArrayOutputStream(8193);     // Catch: Throwable -> L12
        r18.write(r17);     // Catch: Throwable -> L12
        ByteStreamsKt.copyTo$default(r5, r18, 0, 2, null);     // Catch: Throwable -> L12
        int r19 = r18.size() + r12;     // Catch: Throwable -> L12
        if (r19 < 0) goto L26;
        r13 = ArraysKt.copyInto(r18.getBuffer(), Arrays.copyOf(r13, r19), r12, 0, r18.size());     // Catch: Throwable -> L12
        goto L23
    L26:
        throw new OutOfMemoryError("File " + r10 + " is too big to fit in memory.");     // Catch: Throwable -> L12
    L28:
        throw new OutOfMemoryError("File " + r10 + " is too big (" + r11 + " bytes) to fit in memory.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static final List<String> readLines(File r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        final ArrayList r11 = new ArrayList();
        forEachLine(r5, r10, new AnonymousClass1(r11));
        return r11;
    }

    public static /* synthetic */ List readLines$default(File r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        return readLines(r5, r10);
    }

    public static final String readText(File r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        InputStreamReader r11 = new InputStreamReader(new FileInputStream(r5), r10);
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

    public static /* synthetic */ String readText$default(File r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = Charsets.UTF_8;
    L6:
        return readText(r5, r10);
    }

    @InlineOnly
    private static final InputStreamReader reader(File r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new InputStreamReader(new FileInputStream(r5), r10);
    }

    public static /* synthetic */ InputStreamReader reader$default(File r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new InputStreamReader(new FileInputStream(r5), r10);
    }

    public static final <T> T useLines(File r5, Charset r10, Function1<? super Sequence<String>, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "block");
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(r5), r10), 8192);
        T r13 = r11.invoke(TextStreamsKt.lineSequence(r12));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r12, null);
    L8:
        InlineMarker.finallyEnd(1);
        return r13;
    L7:
        r12.close();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L23;
        CloseableKt.closeFinally(r12, th);
    L18:
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        r12.close();     // Catch: Throwable -> L20
        goto L18
    }

    public static /* synthetic */ Object useLines$default(File r5, Charset r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        Intrinsics.checkNotNullParameter(r11, "block");
        BufferedReader r14 = new BufferedReader(new InputStreamReader(new FileInputStream(r5), r10), 8192);
        Object r15 = r11.invoke(TextStreamsKt.lineSequence(r14));     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r14, null);
    L11:
        InlineMarker.finallyEnd(1);
        return r15;
    L10:
        r14.close();
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L28;
        CloseableKt.closeFinally(r14, th);
    L21:
        InlineMarker.finallyEnd(1);
        throw th;
    L28:
        r14.close();     // Catch: Throwable -> L23
        goto L21
    }

    public static final void writeBytes(File r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "array");
        FileOutputStream r11 = new FileOutputStream(r5);
        r11.write(r10);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final void writeText(File r5, String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "charset");
        FileOutputStream r12 = new FileOutputStream(r5);
        writeTextImpl(r12, r10, r11);     // Catch: Throwable -> L6
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

    public static /* synthetic */ void writeText$default(File r5, String r10, Charset r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        writeText(r5, r10, r11);
    }

    public static void writeTextImpl(OutputStream r10, String r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "charset");
        if (r11.length() >= 16384) goto L6;
        r10.write(r11.getBytes(r12));
        return;
    L6:
        CharsetEncoder r13 = newReplaceEncoder(r12);
        CharBuffer r5 = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(r13);
        ByteBuffer r14 = byteBufferForEncoding(8192, r13);
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r15 >= r11.length()) goto L22;
        int r17 = Math.min(8192 - r16, r11.length() - r15);
        int r18 = r15 + r17;
        r11.getChars(r15, r18, r5.array(), r16);
        r5.limit(r17 + r16);
        r16 = 1;
        if (r18 != r11.length()) goto L12;
        boolean r19 = true;
    L14:
        if (r13.encode(r5, r14, r19).isUnderflow() == false) goto L21;
        r10.write(r14.array(), 0, r14.position());
        if (r5.position() == r5.limit()) goto L18;
        r5.put(0, r5.get());
    L19:
        r5.clear();
        r14.clear();
        r15 = r18;
        goto L8
    L18:
        r16 = 0;
        goto L19
    L21:
        throw new IllegalStateException("Check failed.");
    L12:
        r19 = false;
        goto L14
    }

    @InlineOnly
    private static final OutputStreamWriter writer(File r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new OutputStreamWriter(new FileOutputStream(r5), r10);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(File r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new OutputStreamWriter(new FileOutputStream(r5), r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void forEachBlock(File r5, int r10, Function2<? super byte[], ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        ?? r12 = new byte[RangesKt.coerceAtLeast(r10, 512)];
        FileInputStream r13 = new FileInputStream(r5);
    L16:
        int r14 = r13.read(r12);     // Catch: Throwable -> L8
        if (r14 <= 0) goto L5;
        r11.mo2invoke(r12, Integer.valueOf(r14));     // Catch: Throwable -> L8
        goto L16
    L5:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r13, null);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }
}

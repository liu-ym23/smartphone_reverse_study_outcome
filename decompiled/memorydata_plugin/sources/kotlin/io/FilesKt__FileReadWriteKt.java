package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001aB\u0010\u0015\u001a\u00020\u0007*\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001aJ\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001a7\u0010\u001d\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u001e\u001a\r\u0010 \u001a\u00020!*\u00020\bH\u0087\b\u001a\u0014\u0010\"\u001a\n #*\u0004\u0018\u00010\u00050\u0005*\u00020\u000fH\u0000\u001a\r\u0010$\u001a\u00020%*\u00020\bH\u0087\b\u001a\u0017\u0010&\u001a\u00020'*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\n\u0010(\u001a\u00020\n*\u00020\b\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0**\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010+\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010,\u001a\u00020-*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001aL\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01\u0012\u0004\u0012\u0002H/0\u001eH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00102\u001a\u0012\u00103\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u00104\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u00105\u001a\u00020\u0007*\u0002062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0017\u00107\u001a\u000208*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "newReplaceEncoder", "kotlin.jvm.PlatformType", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writeTextImpl", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public FilesKt__FileReadWriteKt() {
    }

    public static final void appendBytes(File r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "array");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2, true), Closeable.class, "com.obric.memorydata.plugin");
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.memorydata.plugin")).write(r3);     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r4, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public static final void appendText(File r3, String r4, Charset r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r5, "charset");
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3, true), Closeable.class, "com.obric.memorydata.plugin");
        FilesKt.writeTextImpl((OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin"), r4, r5);     // Catch: Throwable -> L6
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r6, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    public static /* synthetic */ void appendText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        FilesKt.appendText(r0, r1, r2);
    }

    private static final BufferedReader bufferedReader(File r3, Charset r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Reader r6 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.memorydata.plugin"), r4), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedReader.class) == false) goto L6;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r6, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedReader(r6, r5);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File r1, Charset r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = Charsets.UTF_8;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Reader r6 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r1), InputStream.class, "com.obric.memorydata.plugin"), r2), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedReader.class) == false) goto L12;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r6, BufferedReader.class, "com.obric.memorydata.plugin");
    L12:
        return new BufferedReader(r6, r3);
    }

    private static final BufferedWriter bufferedWriter(File r3, Charset r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Writer r6 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), OutputStream.class, "com.obric.memorydata.plugin"), r4), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedWriter.class) == false) goto L6;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r6, BufferedWriter.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedWriter(r6, r5);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File r1, Charset r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = Charsets.UTF_8;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Writer r6 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.memorydata.plugin"), r2), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedWriter.class) == false) goto L12;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r6, BufferedWriter.class, "com.obric.memorydata.plugin");
    L12:
        return new BufferedWriter(r6, r3);
    }

    public static final ByteBuffer byteBufferForEncoding(int r2, CharsetEncoder r3) {
        Intrinsics.checkNotNullParameter(r3, "encoder");
        ByteBuffer r4 = ByteBuffer.allocate(r2 * ((int) Math.ceil(r3.maxBytesPerChar())));
        Intrinsics.checkNotNullExpressionValue(r4, "allocate(...)");
        return r4;
    }

    public static final void forEachBlock(File r2, int r3, Function2<? super byte[], ? super Integer, Unit> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        byte[] r6 = new byte[RangesKt.coerceAtLeast(r3, 512)];
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r2), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L4:
        int r1 = r0.read(r6);     // Catch: Throwable -> L11
        if (r1 <= 0) goto L6;
        r5.invoke(r6, Integer.valueOf(r1));     // Catch: Throwable -> L11
        goto L4
    L6:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r7, null);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static final void forEachBlock(File r2, Function2<? super byte[], ? super Integer, Unit> r3) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "action");
        FilesKt.forEachBlock(r2, 4096, r4);
    }

    public static final void forEachLine(File r4, Charset r5, Function1<? super String, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Intrinsics.checkNotNullParameter(r7, "action");
        TextStreamsKt.forEachLine((Reader) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r4), InputStream.class, "com.obric.memorydata.plugin"), r5), Reader.class, "com.obric.memorydata.plugin")), Reader.class, "com.obric.memorydata.plugin"), r7);
    }

    public static /* synthetic */ void forEachLine$default(File r1, Charset r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        FilesKt.forEachLine(r1, r2, r6);
    }

    private static final FileInputStream inputStream(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new FileInputStream(r1);
    }

    public static final CharsetEncoder newReplaceEncoder(Charset r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new FileOutputStream(r1);
    }

    private static final PrintWriter printWriter(File r4, Charset r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Writer r6 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), OutputStream.class, "com.obric.memorydata.plugin"), r5), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedWriter.class) == false) goto L5;
        BufferedWriter r7 = (BufferedWriter) ZeusTransformUtils.preCheckCast(r6, BufferedWriter.class, "com.obric.memorydata.plugin");
    L7:
        return new PrintWriter((Writer) ZeusTransformUtils.preCheckCast(r7, Writer.class, "com.obric.memorydata.plugin"));
    L5:
        r7 = new BufferedWriter(r6, 8192);
        goto L7
    }

    static /* synthetic */ PrintWriter printWriter$default(File r3, Charset r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L5;
        r4 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Writer r7 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), OutputStream.class, "com.obric.memorydata.plugin"), r4), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, BufferedWriter.class) == false) goto L8;
        BufferedWriter r8 = (BufferedWriter) ZeusTransformUtils.preCheckCast(r7, BufferedWriter.class, "com.obric.memorydata.plugin");
    L10:
        return new PrintWriter((Writer) ZeusTransformUtils.preCheckCast(r8, Writer.class, "com.obric.memorydata.plugin"));
    L8:
        r8 = new BufferedWriter(r7, 8192);
        goto L10
    }

    public static final byte[] readBytes(File r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r12), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r0, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        long r3 = r12.length();     // Catch: Throwable -> L27
        if (r3 > 2147483647L) goto L26;
        int r4 = (int) r3;
        byte[] r5 = new byte[r4];     // Catch: Throwable -> L27
        int r7 = r4;
        int r8 = 0;
    L8:
        if (r7 <= 0) goto L13;
        int r9 = r1.read(r5, r8, r7);     // Catch: Throwable -> L27
        if (r9 < 0) goto L13;
        r7 = r7 - r9;
        r8 = r8 + r9;
    L13:
        if (r7 <= 0) goto L15;
        r5 = Arrays.copyOf(r5, r8);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r5, "copyOf(...)");     // Catch: Throwable -> L27
    L21:
        CloseableKt.closeFinally(r0, null);
        return r5;
    L15:
        int r10 = r1.read();     // Catch: Throwable -> L27
        if (r10 == (-1)) goto L21;
        ExposingBufferByteArrayOutputStream r11 = new ExposingBufferByteArrayOutputStream(8193);     // Catch: Throwable -> L27
        r11.write(r10);     // Catch: Throwable -> L27
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L27
        int r2 = r11.size() + r4;     // Catch: Throwable -> L27
        if (r2 < 0) goto L24;
        byte[] r13 = r11.getBuffer();     // Catch: Throwable -> L27
        byte[] r6 = Arrays.copyOf(r5, r2);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r6, "copyOf(...)");     // Catch: Throwable -> L27
        r5 = ArraysKt.copyInto(r13, r6, r4, 0, r11.size());     // Catch: Throwable -> L27
        goto L21
    L24:
        throw new OutOfMemoryError("File " + r12 + " is too big to fit in memory.");     // Catch: Throwable -> L27
    L26:
        throw new OutOfMemoryError("File " + r12 + " is too big (" + r3 + " bytes) to fit in memory.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static final List<String> readLines(File r4, Charset r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        final ArrayList r0 = new ArrayList();
        FilesKt.forEachLine(r4, r5, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0), Function1.class, "com.obric.memorydata.plugin"));
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ List readLines$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return FilesKt.readLines(r0, r1);
    }

    public static final String readText(File r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.memorydata.plugin"), r4), Closeable.class, "com.obric.memorydata.plugin");
        String r6 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((InputStreamReader) ZeusTransformUtils.preCheckCast(r5, InputStreamReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r5, null);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static /* synthetic */ String readText$default(File r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Charsets.UTF_8;
    L6:
        return FilesKt.readText(r0, r1);
    }

    private static final InputStreamReader reader(File r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        return new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ InputStreamReader reader$default(File r1, Charset r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r1), InputStream.class, "com.obric.memorydata.plugin"), r2);
    }

    public static final <T> T useLines(File r4, Charset r5, Function1<? super Sequence<String>, ? extends T> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "charset");
        Intrinsics.checkNotNullParameter(r7, "block");
        Reader r8 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r4), InputStream.class, "com.obric.memorydata.plugin"), r5), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, BufferedReader.class) == false) goto L5;
        BufferedReader r9 = (BufferedReader) ZeusTransformUtils.preCheckCast(r8, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
        T r11 = (T) r7.invoke(TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r10, BufferedReader.class, "com.obric.memorydata.plugin")));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r10, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r11;
    L11:
        r10.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r10, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r10.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r9 = new BufferedReader(r8, 8192);
        goto L6
    }

    public static /* synthetic */ Object useLines$default(File r3, Charset r4, Function1 r5, int r6, Object r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L5;
        r4 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        Intrinsics.checkNotNullParameter(r8, "block");
        Reader r9 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), InputStream.class, "com.obric.memorydata.plugin"), r4), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, BufferedReader.class) == false) goto L8;
        BufferedReader r10 = (BufferedReader) ZeusTransformUtils.preCheckCast(r9, BufferedReader.class, "com.obric.memorydata.plugin");
    L9:
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r10, Closeable.class, "com.obric.memorydata.plugin");
        Object r12 = r8.invoke(TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r11, BufferedReader.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r11, null);
    L15:
        InlineMarker.finallyEnd(1);
        return r12;
    L14:
        r11.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L32;
        CloseableKt.closeFinally(r11, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r11.close();     // Catch: Throwable -> L27
        goto L25
    L8:
        r10 = new BufferedReader(r9, 8192);
        goto L9
    }

    public static final void writeBytes(File r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "array");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), Closeable.class, "com.obric.memorydata.plugin");
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.memorydata.plugin")).write(r3);     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r4, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    public static final void writeText(File r3, String r4, Charset r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r5, "charset");
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), Closeable.class, "com.obric.memorydata.plugin");
        FilesKt.writeTextImpl((OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin"), r4, r5);     // Catch: Throwable -> L6
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r6, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    public static /* synthetic */ void writeText$default(File r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        FilesKt.writeText(r0, r1, r2);
    }

    public static final void writeTextImpl(OutputStream r9, String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "charset");
        if (r10.length() >= 16384) goto L6;
        byte[] r12 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        r9.write(r12);
        return;
    L6:
        CharsetEncoder r13 = FilesKt.newReplaceEncoder(r11);
        CharBuffer r1 = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(r13);
        ByteBuffer r0 = FilesKt.byteBufferForEncoding(8192, r13);
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r10.length()) goto L22;
        int r5 = Math.min(8192 - r4, r10.length() - r3);
        int r6 = r3 + r5;
        char[] r7 = r1.array();
        Intrinsics.checkNotNullExpressionValue(r7, "array(...)");
        r10.getChars(r3, r6, r7, r4);
        r1.limit(r5 + r4);
        r4 = 1;
        if (r6 != r10.length()) goto L12;
        boolean r8 = true;
    L14:
        if (r13.encode(r1, r0, r8).isUnderflow() == false) goto L21;
        r9.write(r0.array(), 0, r0.position());
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
        r8 = false;
        goto L14
    }

    private static final OutputStreamWriter writer(File r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "charset");
        return new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), OutputStream.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File r1, Charset r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.memorydata.plugin"), r2);
    }
}

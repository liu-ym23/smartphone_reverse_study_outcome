package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "ByteStreamsKt")
public final class ByteStreamsKt {
    @InlineOnly
    private static final BufferedInputStream buffered(InputStream r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r10;
    L6:
        return new BufferedInputStream(r10, r11);
    }

    @InlineOnly
    private static final BufferedOutputStream buffered(OutputStream r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedOutputStream) == false) goto L6;
        return (BufferedOutputStream) r10;
    L6:
        return new BufferedOutputStream(r10, r11);
    }

    static /* synthetic */ BufferedInputStream buffered$default(InputStream r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedInputStream) == false) goto L9;
        return (BufferedInputStream) r10;
    L9:
        return new BufferedInputStream(r10, r11);
    }

    static /* synthetic */ BufferedOutputStream buffered$default(OutputStream r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedOutputStream) == false) goto L9;
        return (BufferedOutputStream) r10;
    L9:
        return new BufferedOutputStream(r10, r11);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(InputStream r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Reader r12 = new InputStreamReader(r10, r11);
        if ((r12 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r12;
    L6:
        return new BufferedReader(r12, 8192);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(InputStream r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Reader r14 = new InputStreamReader(r10, r11);
        if ((r14 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r14;
    L9:
        return new BufferedReader(r14, 8192);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(OutputStream r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r12 = new OutputStreamWriter(r10, r11);
        if ((r12 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r12;
    L6:
        return new BufferedWriter(r12, 8192);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        Writer r14 = new OutputStreamWriter(r10, r11);
        if ((r14 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r14;
    L9:
        return new BufferedWriter(r14, 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream byteInputStream(String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        byte[] r12 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(r12);
    }

    static /* synthetic */ ByteArrayInputStream byteInputStream$default(String r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        byte[] r14 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(r14);
    }

    public static final long copyTo(InputStream r10, OutputStream r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "out");
        byte[] r13 = new byte[r12];
        int r14 = r10.read(r13);
        long r15 = 0;
    L3:
        if (r14 < 0) goto L5;
        r11.write(r13, 0, r14);
        r15 = r15 + ((long) r14);
        r14 = r10.read(r13);
        goto L3
    L5:
        return r15;
    }

    public static /* synthetic */ long copyTo$default(InputStream r10, OutputStream r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 8192;
    L6:
        return copyTo(r10, r11, r12);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ByteArrayInputStream(r10);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ByteArrayInputStream(r10, r11, r12);
    }

    public static final ByteIterator iterator(final BufferedInputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    @SinceKotlin(version = "1.3")
    public static final byte[] readBytes(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(Math.max(8192, r10.available()));
        copyTo$default(r10, r11, 0, 2, null);
        byte[] r12 = r11.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r12, "buffer.toByteArray()");
        return r12;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(Math.max(r11, r10.available()));
        copyTo$default(r10, r12, 0, 2, null);
        byte[] r13 = r12.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r13, "buffer.toByteArray()");
        return r13;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 8192;
    L6:
        return readBytes(r10, r11);
    }

    @InlineOnly
    private static final InputStreamReader reader(InputStream r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new InputStreamReader(r10, r11);
    }

    static /* synthetic */ InputStreamReader reader$default(InputStream r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new InputStreamReader(r10, r11);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(OutputStream r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new OutputStreamWriter(r10, r11);
    }

    static /* synthetic */ OutputStreamWriter writer$default(OutputStream r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new OutputStreamWriter(r10, r11);
    }
}

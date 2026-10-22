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
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "ByteStreamsKt")
public final class ByteStreamsKt {
    @InlineOnly
    private static final BufferedInputStream buffered(InputStream r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r5;
    L6:
        return new BufferedInputStream(r5, r10);
    }

    public static /* synthetic */ BufferedInputStream buffered$default(InputStream r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedInputStream) == false) goto L9;
        return (BufferedInputStream) r5;
    L9:
        return new BufferedInputStream(r5, r10);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(InputStream r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedReader(new InputStreamReader(r5, r10), 8192);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(InputStream r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedReader(new InputStreamReader(r5, r10), 8192);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(OutputStream r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedWriter(new OutputStreamWriter(r5, r10), 8192);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new BufferedWriter(new OutputStreamWriter(r5, r10), 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream byteInputStream(String r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new ByteArrayInputStream(r5.getBytes(r10));
    }

    public static /* synthetic */ ByteArrayInputStream byteInputStream$default(String r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new ByteArrayInputStream(r5.getBytes(r10));
    }

    public static final long copyTo(InputStream r5, OutputStream r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "out");
        byte[] r12 = new byte[r11];
        int r13 = r5.read(r12);
        long r14 = 0;
    L3:
        if (r13 < 0) goto L5;
        r10.write(r12, 0, r13);
        r14 = r14 + ((long) r13);
        r13 = r5.read(r12);
        goto L3
    L5:
        return r14;
    }

    public static /* synthetic */ long copyTo$default(InputStream r5, OutputStream r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 8192;
    L6:
        return copyTo(r5, r10, r11);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ByteArrayInputStream(r5);
    }

    public static final ByteIterator iterator(final BufferedInputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new AnonymousClass1(r5);
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(Math.max(r10, r5.available()));
        copyTo$default(r5, r11, 0, 2, null);
        return r11.toByteArray();
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 8192;
    L6:
        return readBytes(r5, r10);
    }

    @InlineOnly
    private static final InputStreamReader reader(InputStream r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new InputStreamReader(r5, r10);
    }

    public static /* synthetic */ InputStreamReader reader$default(InputStream r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new InputStreamReader(r5, r10);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(OutputStream r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new OutputStreamWriter(r5, r10);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(OutputStream r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new OutputStreamWriter(r5, r10);
    }

    @InlineOnly
    private static final BufferedOutputStream buffered(OutputStream r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedOutputStream) == false) goto L6;
        return (BufferedOutputStream) r5;
    L6:
        return new BufferedOutputStream(r5, r10);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ByteArrayInputStream(r5, r10, r11);
    }

    public static /* synthetic */ BufferedOutputStream buffered$default(OutputStream r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedOutputStream) == false) goto L9;
        return (BufferedOutputStream) r5;
    L9:
        return new BufferedOutputStream(r5, r10);
    }

    @SinceKotlin(version = "1.3")
    public static final byte[] readBytes(InputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(Math.max(8192, r5.available()));
        copyTo$default(r5, r10, 0, 2, null);
        return r10.toByteArray();
    }
}

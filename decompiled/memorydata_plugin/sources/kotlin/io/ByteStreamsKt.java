package kotlin.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", TypedValues.CycleType.S_WAVE_OFFSET, XSDatatype.FACET_LENGTH, "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ByteStreamsKt {
    private static final BufferedInputStream buffered(InputStream r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, BufferedInputStream.class) == false) goto L6;
        return (BufferedInputStream) ZeusTransformUtils.preCheckCast(r1, BufferedInputStream.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedInputStream(r1, r2);
    }

    private static final BufferedOutputStream buffered(OutputStream r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, BufferedOutputStream.class) == false) goto L6;
        return (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r1, BufferedOutputStream.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedOutputStream(r1, r2);
    }

    static /* synthetic */ BufferedInputStream buffered$default(InputStream r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (ZeusTransformUtils.instanceOf(r0, BufferedInputStream.class) == false) goto L9;
        return (BufferedInputStream) ZeusTransformUtils.preCheckCast(r0, BufferedInputStream.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedInputStream(r0, r1);
    }

    static /* synthetic */ BufferedOutputStream buffered$default(OutputStream r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (ZeusTransformUtils.instanceOf(r0, BufferedOutputStream.class) == false) goto L9;
        return (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r0, BufferedOutputStream.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedOutputStream(r0, r1);
    }

    private static final BufferedReader bufferedReader(InputStream r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Reader r3 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r1, r2), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BufferedReader.class) == false) goto L6;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r3, BufferedReader.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedReader(r3, 8192);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(InputStream r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Reader r4 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r0, r1), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, BufferedReader.class) == false) goto L9;
        return (BufferedReader) ZeusTransformUtils.preCheckCast(r4, BufferedReader.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedReader(r4, 8192);
    }

    private static final BufferedWriter bufferedWriter(OutputStream r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        Writer r3 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter(r1, r2), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BufferedWriter.class) == false) goto L6;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r3, BufferedWriter.class, "com.obric.memorydata.plugin");
    L6:
        return new BufferedWriter(r3, 8192);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        Writer r4 = (Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter(r0, r1), Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, BufferedWriter.class) == false) goto L9;
        return (BufferedWriter) ZeusTransformUtils.preCheckCast(r4, BufferedWriter.class, "com.obric.memorydata.plugin");
    L9:
        return new BufferedWriter(r4, 8192);
    }

    private static final ByteArrayInputStream byteInputStream(String r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        byte[] r3 = r1.getBytes(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "getBytes(...)");
        return new ByteArrayInputStream(r3);
    }

    static /* synthetic */ ByteArrayInputStream byteInputStream$default(String r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        byte[] r4 = r0.getBytes(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "getBytes(...)");
        return new ByteArrayInputStream(r4);
    }

    public static final long copyTo(InputStream r5, OutputStream r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "out");
        byte[] r8 = new byte[r7];
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

    public static /* synthetic */ long copyTo$default(InputStream r0, OutputStream r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 8192;
    L6:
        return copyTo(r0, r1, r2);
    }

    private static final ByteArrayInputStream inputStream(byte[] r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ByteArrayInputStream(r1);
    }

    private static final ByteArrayInputStream inputStream(byte[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ByteArrayInputStream(r1, r2, r3);
    }

    public static final ByteIterator iterator(final BufferedInputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (ByteIterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), ByteIterator.class, "com.obric.memorydata.plugin");
    }

    public static final byte[] readBytes(InputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(Math.max(8192, r5.available()));
        copyTo$default(r5, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);
        byte[] r6 = r0.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r6, "toByteArray(...)");
        return r6;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(Math.max(r5, r4.available()));
        copyTo$default(r4, (OutputStream) ZeusTransformUtils.preCheckCast(r0, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);
        byte[] r6 = r0.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r6, "toByteArray(...)");
        return r6;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 8192;
    L6:
        return readBytes(r0, r1);
    }

    private static final InputStreamReader reader(InputStream r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new InputStreamReader(r1, r2);
    }

    static /* synthetic */ InputStreamReader reader$default(InputStream r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new InputStreamReader(r0, r1);
    }

    private static final OutputStreamWriter writer(OutputStream r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new OutputStreamWriter(r1, r2);
    }

    static /* synthetic */ OutputStreamWriter writer$default(OutputStream r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return new OutputStreamWriter(r0, r1);
    }
}

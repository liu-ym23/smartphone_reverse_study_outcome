package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001aB\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "TextStreamsKt")
@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,157:1\n54#1,4:158\n1#2:162\n1#2:165\n1317#3,2:163\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n35#1:158,4\n35#1:162\n35#1:163,2\n*E\n"})
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(Reader r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r5;
    L6:
        return new BufferedReader(r5, r10);
    }

    public static /* synthetic */ BufferedReader buffered$default(Reader r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r5;
    L9:
        return new BufferedReader(r5, r10);
    }

    public static final long copyTo(Reader r5, Writer r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "out");
        char[] r12 = new char[r11];
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

    public static /* synthetic */ long copyTo$default(Reader r5, Writer r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 8192;
    L6:
        return copyTo(r5, r10, r11);
    }

    public static final void forEachLine(Reader r5, Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        if ((r5 instanceof BufferedReader) == false) goto L5;
        BufferedReader r11 = (BufferedReader) r5;
    L21:
        Iterator<String> r12 = lineSequence(r11).iterator();     // Catch: Throwable -> L10
    L8:
        if (r12.hasNext() == false) goto L12;
        r10.invoke(r12.next());     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r11, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L5:
        r11 = new BufferedReader(r5, 8192);
        goto L21
    }

    public static final Sequence<String> lineSequence(BufferedReader r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(r5));
    }

    public static final byte[] readBytes(URL r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        InputStream r10 = r5.openStream();
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L6
        byte[] r11 = ByteStreamsKt.readBytes(r10);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r10, null);
        return r11;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    public static final List<String> readLines(Reader r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        final ArrayList r10 = new ArrayList();
        forEachLine(r5, new AnonymousClass1(r10));
        return r10;
    }

    public static final String readText(Reader r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringWriter r10 = new StringWriter();
        copyTo$default(r5, r10, 0, 2, null);
        return r10.toString();
    }

    public static /* synthetic */ String readText$default(URL r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new String(readBytes(r5), r10);
    }

    @InlineOnly
    private static final StringReader reader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new StringReader(r5);
    }

    public static final <T> T useLines(Reader r5, Function1<? super Sequence<String>, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "block");
        if ((r5 instanceof BufferedReader) == false) goto L5;
        BufferedReader r11 = (BufferedReader) r5;
    L25:
        T r12 = r10.invoke(lineSequence(r11));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r11, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r12;
    L11:
        r11.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r11, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r11.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r11 = new BufferedReader(r5, 8192);
        goto L25
    }

    @InlineOnly
    private static final BufferedWriter buffered(Writer r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r5;
    L6:
        return new BufferedWriter(r5, r10);
    }

    public static /* synthetic */ BufferedWriter buffered$default(Writer r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r5;
    L9:
        return new BufferedWriter(r5, r10);
    }

    @InlineOnly
    private static final String readText(URL r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new String(readBytes(r5), r10);
    }
}

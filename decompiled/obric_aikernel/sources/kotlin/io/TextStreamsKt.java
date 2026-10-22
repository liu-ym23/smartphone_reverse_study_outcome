package kotlin.io;

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
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "TextStreamsKt")
@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1313#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(Reader r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r10;
    L6:
        return new BufferedReader(r10, r11);
    }

    @InlineOnly
    private static final BufferedWriter buffered(Writer r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r10;
    L6:
        return new BufferedWriter(r10, r11);
    }

    static /* synthetic */ BufferedReader buffered$default(Reader r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r10;
    L9:
        return new BufferedReader(r10, r11);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r10;
    L9:
        return new BufferedWriter(r10, r11);
    }

    public static final long copyTo(Reader r10, Writer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "out");
        char[] r13 = new char[r12];
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

    public static /* synthetic */ long copyTo$default(Reader r10, Writer r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 8192;
    L6:
        return copyTo(r10, r11, r12);
    }

    public static final void forEachLine(Reader r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        if ((r10 instanceof BufferedReader) == false) goto L5;
        BufferedReader r12 = (BufferedReader) r10;
    L19:
        Iterator<String> r13 = lineSequence(r12).iterator();     // Catch: Throwable -> L14
    L9:
        if (r13.hasNext() == false) goto L11;
        r11.invoke(r13.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r12, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L5:
        r12 = new BufferedReader(r10, 8192);
        goto L19
    }

    public static final Sequence<String> lineSequence(BufferedReader r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(r10));
    }

    public static final byte[] readBytes(URL r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        InputStream r11 = r10.openStream();
        Intrinsics.checkNotNullExpressionValue(r11, "it");     // Catch: Throwable -> L6
        byte[] r12 = ByteStreamsKt.readBytes(r11);     // Catch: Throwable -> L6
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

    public static final List<String> readLines(Reader r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        final ArrayList r11 = new ArrayList();
        forEachLine(r10, new AnonymousClass1(r11));
        return r11;
    }

    public static final String readText(Reader r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringWriter r11 = new StringWriter();
        copyTo$default(r10, r11, 0, 2, null);
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "buffer.toString()");
        return r12;
    }

    @InlineOnly
    private static final String readText(URL r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new String(readBytes(r10), r11);
    }

    static /* synthetic */ String readText$default(URL r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new String(readBytes(r10), r11);
    }

    @InlineOnly
    private static final StringReader reader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new StringReader(r10);
    }

    public static final <T> T useLines(Reader r10, Function1<? super Sequence<String>, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        if ((r10 instanceof BufferedReader) == false) goto L5;
        BufferedReader r12 = (BufferedReader) r10;
    L15:
        T r13 = r11.invoke(lineSequence(r12));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r12, null);
        InlineMarker.finallyEnd(1);
        return r13;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r12, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r12 = new BufferedReader(r10, 8192);
        goto L15
    }
}

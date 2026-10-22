package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "ConsoleKt")
public final class ConsoleKt {
    @InlineOnly
    private static final void print(byte r10) {
        System.out.print(Byte.valueOf(r10));
    }

    @InlineOnly
    private static final void print(char r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(double r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(float r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(int r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(long r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(Object r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(short r10) {
        System.out.print(Short.valueOf(r10));
    }

    @InlineOnly
    private static final void print(boolean r10) {
        System.out.print(r10);
    }

    @InlineOnly
    private static final void print(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        System.out.print(r10);
    }

    @InlineOnly
    private static final void println() {
        System.out.println();
    }

    @InlineOnly
    private static final void println(byte r10) {
        System.out.println(Byte.valueOf(r10));
    }

    @InlineOnly
    private static final void println(char r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(double r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(float r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(int r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(long r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(Object r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(short r10) {
        System.out.println(Short.valueOf(r10));
    }

    @InlineOnly
    private static final void println(boolean r10) {
        System.out.println(r10);
    }

    @InlineOnly
    private static final void println(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        System.out.println(r10);
    }

    public static final String readLine() {
        LineReader r10 = LineReader.INSTANCE;
        InputStream r11 = System.in;
        Intrinsics.checkNotNullExpressionValue(r11, "`in`");
        Charset r12 = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(r12, "defaultCharset()");
        return r10.readLine(r11, r12);
    }

    @SinceKotlin(version = "1.6")
    public static final String readln() {
        String r10 = readlnOrNull();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = "1.6")
    public static final String readlnOrNull() {
        return readLine();
    }
}

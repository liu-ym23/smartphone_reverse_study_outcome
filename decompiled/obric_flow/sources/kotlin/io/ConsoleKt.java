package kotlin.io;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\t\u0010\r\u001a\u00020\u0001H\u0087\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\b\u0010\u0010\u001a\u00020\u000fH\u0007\u001a\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0012"}, d2 = {"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "readln", "readlnOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "ConsoleKt")
public final class ConsoleKt {
    @InlineOnly
    private static final void print(Object r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(Object r5) {
        System.out.println(r5);
    }

    public static final String readLine() {
        return LineReader.INSTANCE.readLine(System.in, Charset.defaultCharset());
    }

    @SinceKotlin(version = "1.6")
    public static final String readln() {
        String r5 = readlnOrNull();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = "1.6")
    public static final String readlnOrNull() {
        return readLine();
    }

    @InlineOnly
    private static final void print(int r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(int r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(long r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(long r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(byte r5) {
        System.out.print(Byte.valueOf(r5));
    }

    @InlineOnly
    private static final void println(byte r5) {
        System.out.println(Byte.valueOf(r5));
    }

    @InlineOnly
    private static final void print(short r5) {
        System.out.print(Short.valueOf(r5));
    }

    @InlineOnly
    private static final void println(short r5) {
        System.out.println(Short.valueOf(r5));
    }

    @InlineOnly
    private static final void print(char r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(char r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(boolean r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(boolean r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(float r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(float r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(double r5) {
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(double r5) {
        System.out.println(r5);
    }

    @InlineOnly
    private static final void print(char[] r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        System.out.print(r5);
    }

    @InlineOnly
    private static final void println(char[] r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        System.out.println(r5);
    }

    @InlineOnly
    private static final void println() {
        System.out.println();
    }
}

package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 implements Closeable {
    public static final v0 Companion = null;
    private Reader reader;

    static {
        Companion = new v0();
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final w0 create(String r5, h0 r10) {
        Companion.getClass();
        return v0.a(r5, r10);
    }

    public final InputStream byteStream() {
        return source().I();
    }

    public final ByteString byteString() throws IOException {
        long r5 = contentLength();
        if (r5 > Integer.MAX_VALUE) goto L20;
        nu.l r10 = source();
        ByteString r11 = r10.C();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r10, null);
        int r12 = r11.size();
        if (r5 != (-1)) goto L9;
    L13:
        return r11;
    L9:
        if (r5 == r12) goto L13;
        throw new IOException("Content-Length (" + r5 + ") and stream length (" + r12 + ") disagree");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L20:
        throw new IOException(androidx.constraintlayout.motion.widget.a.j(r5, "Cannot buffer entire body for content length: "));
    }

    public final byte[] bytes() throws IOException {
        long r5 = contentLength();
        if (r5 > Integer.MAX_VALUE) goto L20;
        nu.l r10 = source();
        byte[] r11 = r10.w();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r10, null);
        int r12 = r11.length;
        if (r5 != (-1)) goto L9;
    L13:
        return r11;
    L9:
        if (r5 == r12) goto L13;
        throw new IOException("Content-Length (" + r5 + ") and stream length (" + r12 + ") disagree");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L20:
        throw new IOException(androidx.constraintlayout.motion.widget.a.j(r5, "Cannot buffer entire body for content length: "));
    }

    public final Reader charStream() {
        Reader r5 = this.reader;
        if (r5 != null) goto L12;
        nu.l r10 = source();
        h0 r11 = contentType();
        if (r11 == null) goto L10;
        Charset r12 = r11.a(Charsets.UTF_8);
        if (r12 == null) goto L10;
    L11:
        r5 = new t0(r10, r12);
        this.reader = r5;
    L10:
        r12 = Charsets.UTF_8;
    L12:
        return r5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract h0 contentType();

    public abstract nu.l source();

    public final String string() throws IOException {
        nu.l r5 = source();
        h0 r10 = contentType();     // Catch: Throwable -> L12
        if (r10 == null) goto L8;
        Charset r11 = r10.a(Charsets.UTF_8);     // Catch: Throwable -> L12
        if (r11 == null) goto L8;
    L9:
        String r12 = r5.A(Util.readBomAsCharset(r5, r11));     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r5, null);
        return r12;
    L8:
        r11 = Charsets.UTF_8;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final w0 create(nu.l r5, h0 r10, long r11) {
        Companion.getClass();
        return v0.b(r5, r10, r11);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final w0 create(h0 r5, long r10, nu.l r11) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r11, "content");
        return v0.b(r11, r5, r10);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final w0 create(h0 r5, String r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return v0.a(r10, r5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final w0 create(h0 r5, ByteString r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r10, "$this$toResponseBody");
        nu.j r11 = new nu.j();
        r11.Q(r10);
        return v0.b(r11, r5, r10.size());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final w0 create(h0 r5, byte[] r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "content");
        return v0.c(r10, r5);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final w0 create(byte[] r5, h0 r10) {
        Companion.getClass();
        return v0.c(r5, r10);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final w0 create(ByteString r5, h0 r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$toResponseBody");
        nu.j r11 = new nu.j();
        r11.Q(r5);
        return v0.b(r11, r10, r5.size());
    }
}

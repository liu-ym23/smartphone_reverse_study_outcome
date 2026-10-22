package okio;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ZipFilesKt;
import okio.internal.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt", "okio/Okio__ZlibOkioKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class Okio {
    public static final Sink blackhole() {
        return new f();
    }

    public static final Sink appendingSink(File r2) throws FileNotFoundException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return sink(new PolarisFileOutputStreamWrapper(r2, true));
    }

    public static final l asResourceFileSystem(ClassLoader r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new f(r2, true);
    }

    public static final BufferedSink buffer(Sink r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new e0(r1);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError r4) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.getCause() == null) goto L11;
        String r5 = r4.getMessage();
        if (r5 == null) goto L7;
        boolean r6 = StringsKt.contains$default(r5, "getsockname failed", false, 2, null);
    L8:
        if (r6 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r6 = false;
        goto L8
    L11:
        return false;
    }

    public static final Sink sink(Socket r2) throws IOException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        i0 r1 = new i0(r2);
        a0 r3 = new a0(r2.getOutputStream(), r1);
        Intrinsics.checkNotNullParameter(r3, "sink");
        return new d(r1, r3);
    }

    public static final Source source(Socket r2) throws IOException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        i0 r1 = new i0(r2);
        u r3 = new u(r2.getInputStream(), r1);
        Intrinsics.checkNotNullParameter(r3, "source");
        return new e(r1, r3);
    }

    public static final BufferedSource buffer(Source r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new f0(r1);
    }

    public static final Sink sink(OutputStream r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new a0(r2, new j0());
    }

    public static final Source source(File r2) throws FileNotFoundException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new u(new PolarisFileInputStreamWrapper(r2), j0.d);
    }

    public static final Sink sink(File r3) throws FileNotFoundException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return sink$default(r3, false, 1, null);
    }

    public static final Source source(InputStream r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new u(r2, new j0());
    }

    public static final g cipherSink(Sink r1, Cipher r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "cipher");
        return new g(buffer(r1), r2);
    }

    public static final h cipherSource(Source r1, Cipher r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "cipher");
        return new h(buffer(r1), r2);
    }

    public static final r hashingSink(Sink r1, MessageDigest r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "digest");
        return new r(r1, r2);
    }

    public static final s hashingSource(Source r1, MessageDigest r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "digest");
        return new s(r1, r2);
    }

    public static final l openZip(l r1, b0 r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "zipPath");
        return ZipFilesKt.d(r2, r1);
    }

    public static final Sink sink(Path r1, OpenOption... r2) throws IOException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return sink(Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length)));
    }

    public static final Source source(Path r1, OpenOption... r2) throws IOException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        return source(Files.newInputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length)));
    }

    public static final <T extends Closeable, R> R use(T r3, Function1<? super T, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        Throwable th = null;
        R r5 = (R) r4.invoke(r3);
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L23;
    L9:
        InlineMarker.finallyEnd(1);
    L18:
        if (th != null) goto L20;
        return r5;
    L20:
        throw th;
    L23:
        r3.close();     // Catch: Throwable -> L8
    L8:
        th = th;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L21;
    L17:
        InlineMarker.finallyEnd(1);
        th = th;
        r5 = null;
        goto L18
    L21:
        r3.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    }

    public static final r hashingSink(Sink r1, Mac r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mac");
        return new r(r1, r2);
    }

    public static final s hashingSource(Source r1, Mac r2) {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mac");
        return new s(r1, r2);
    }

    public static final Sink sink(File r1, boolean r2) throws FileNotFoundException {
        Logger r0 = y.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return sink(new PolarisFileOutputStreamWrapper(r1, r2));
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) throws FileNotFoundException {
        Logger r4 = y.a;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return sink(r0, r1);
    }
}

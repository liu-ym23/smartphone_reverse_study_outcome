package okio;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\f*\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\u0006*\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0007\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0010\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0011\u001a%\u0010\u000e\u001a\u00020\u0006*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\t\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0018\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0011\u001a%\u0010\u0017\u001a\u00020\r*\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0019\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u001a"}, d2 = {"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "blackholeSink", "Lokio/Sink;", "blackhole", "appendingSink", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", AILabCheckPermissionTask.KEY_SOURCE, "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "jvm"}, k = 2, mv = {1, 1, 11})
public final class Okio {
    public static final Sink appendingSink(File r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return sink((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2, true), OutputStream.class, "com.obric.memorydata.plugin"));
    }

    public static final Sink blackhole() {
        return (Sink) ZeusTransformUtils.preCheckCast(new BlackholeSink(), Sink.class, "com.obric.memorydata.plugin");
    }

    public static final BufferedSink buffer(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        return (BufferedSink) ZeusTransformUtils.preCheckCast(new RealBufferedSink(r3), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    public static final BufferedSource buffer(Source r2) {
        Source r3 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$receiver");
        return (BufferedSource) ZeusTransformUtils.preCheckCast(new RealBufferedSource(r3), BufferedSource.class, "com.obric.memorydata.plugin");
    }

    public static final boolean isAndroidGetsocknameError(AssertionError r4) {
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        if (r4.getCause() == null) goto L11;
        String r5 = r4.getMessage();
        if (r5 == null) goto L7;
        boolean r6 = StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("getsockname failed", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null);
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

    public static final Sink sink(File r3) {
        return sink$default(r3, false, 1, null);
    }

    public static final Sink sink(File r1, boolean r2) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        return sink((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1, r2), OutputStream.class, "com.obric.memorydata.plugin"));
    }

    public static final Sink sink(OutputStream r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return (Sink) ZeusTransformUtils.preCheckCast(new OutputStreamSink(r2, new Timeout()), Sink.class, "com.obric.memorydata.plugin");
    }

    public static final Sink sink(Socket r4) {
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r4);
        OutputStream r5 = r4.getOutputStream();
        Intrinsics.checkExpressionValueIsNotNull(r5, "getOutputStream()");
        return r0.sink((Sink) ZeusTransformUtils.preCheckCast(new OutputStreamSink(r5, (Timeout) ZeusTransformUtils.preCheckCast(r0, Timeout.class, "com.obric.memorydata.plugin")), Sink.class, "com.obric.memorydata.plugin"));
    }

    public static final Sink sink(Path r2, OpenOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "options");
        OutputStream r5 = Files.newOutputStream(r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r5, "Files.newOutputStream(this, *options)");
        return sink(r5);
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return sink(r0, r1);
    }

    public static final Source source(File r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return source((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r2), InputStream.class, "com.obric.memorydata.plugin"));
    }

    public static final Source source(InputStream r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return (Source) ZeusTransformUtils.preCheckCast(new InputStreamSource(r2, new Timeout()), Source.class, "com.obric.memorydata.plugin");
    }

    public static final Source source(Socket r4) {
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r4);
        InputStream r5 = r4.getInputStream();
        Intrinsics.checkExpressionValueIsNotNull(r5, "getInputStream()");
        return r0.source((Source) ZeusTransformUtils.preCheckCast(new InputStreamSource(r5, (Timeout) ZeusTransformUtils.preCheckCast(r0, Timeout.class, "com.obric.memorydata.plugin")), Source.class, "com.obric.memorydata.plugin"));
    }

    public static final Source source(Path r2, OpenOption... r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$receiver");
        Intrinsics.checkParameterIsNotNull(r3, "options");
        InputStream r5 = Files.newInputStream(r4, (OpenOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), OpenOption[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r5, "Files.newInputStream(this, *options)");
        return source(r5);
    }
}

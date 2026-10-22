package okhttp3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\u0082\b¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", IslandSession.REOPEN_VALUE_CLOSE, "", "consumeSource", ExifInterface.GPS_DIRECTION_TRUE, "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", AILabCheckPermissionTask.KEY_SOURCE, TypedValues.Custom.S_STRING, "", "BomAwareReader", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = null;
    private Reader reader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", "", "delegate", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "cbuf", "", f.g, "len", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(BufferedSource r3, Charset r4) {
            BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r4, "charset");
            this.source = r5;
            this.charset = r4;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.closed = true;
            Reader r0 = this.delegate;
            if (r0 == null) goto L5;
            r0.close();
            return;
        L5:
            ((BomAwareReader) ZeusTransformUtils.preCheckCast(this, BomAwareReader.class, "com.obric.memorydata.plugin")).source.close();
        }

        @Override // java.io.Reader
        public int read(char[] r6, int r7, int r8) {
            Intrinsics.checkParameterIsNotNull(r6, "cbuf");
            if (this.closed == true) goto L11;
            Reader r0 = this.delegate;
            if (r0 != null) goto L9;
            InputStreamReader r1 = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
            this.delegate = (Reader) ZeusTransformUtils.preCheckCast(r1, Reader.class, "com.obric.memorydata.plugin");
            r0 = (Reader) ZeusTransformUtils.preCheckCast(r1, Reader.class, "com.obric.memorydata.plugin");
        L9:
            return r0.read(r6, r7, r8);
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Stream closed"), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0010"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", Params.CONTENT, "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, String r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = (MediaType) ZeusTransformUtils.preCheckCast(null, MediaType.class, "com.obric.memorydata.plugin");
        L6:
            return r0.create(r1, r2);
        }

        public static /* synthetic */ ResponseBody create$default(Companion r1, BufferedSource r2, MediaType r3, long r4, int r6, Object r7) {
            BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r2, BufferedSource.class, "com.obric.memorydata.plugin");
            if ((r6 & 1) == 0) goto L6;
            r3 = (MediaType) ZeusTransformUtils.preCheckCast(null, MediaType.class, "com.obric.memorydata.plugin");
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = -1;
        L9:
            return r1.create(r5, r3, r4);
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, ByteString r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = (MediaType) ZeusTransformUtils.preCheckCast(null, MediaType.class, "com.obric.memorydata.plugin");
        L6:
            return r0.create(r1, r2);
        }

        public static /* synthetic */ ResponseBody create$default(Companion r0, byte[] r1, MediaType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = (MediaType) ZeusTransformUtils.preCheckCast(null, MediaType.class, "com.obric.memorydata.plugin");
        L6:
            return r0.create(r1, r2);
        }

        @JvmStatic
        public final ResponseBody create(String r4, MediaType r5) {
            Intrinsics.checkParameterIsNotNull(r4, "$this$toResponseBody");
            Charset r0 = Charsets.UTF_8;
            if (r5 == null) goto L7;
            r0 = MediaType.charset$default(r5, null, 1, null);
            if (r0 != null) goto L7;
            r0 = Charsets.UTF_8;
            r5 = MediaType.Companion.parse(r5 + "; charset=utf-8");
        L7:
            Buffer r6 = new Buffer().writeString(r4, r0);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create((BufferedSource) ZeusTransformUtils.preCheckCast(r6, BufferedSource.class, "com.obric.memorydata.plugin"), r5, r6.size());
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r3, long r4, BufferedSource r6) {
            BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, Params.CONTENT);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(r7, r3, r4);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r3, String r4) {
            Intrinsics.checkParameterIsNotNull(r4, Params.CONTENT);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(r4, r3);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r3, ByteString r4) {
            Intrinsics.checkParameterIsNotNull(r4, Params.CONTENT);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(r4, r3);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        public final ResponseBody create(MediaType r3, byte[] r4) {
            Intrinsics.checkParameterIsNotNull(r4, Params.CONTENT);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(r4, r3);
        }

        @JvmStatic
        public final ResponseBody create(BufferedSource r2, final MediaType r3, final long r4) {
            final BufferedSource r1 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r2, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "$this$asResponseBody");
            return (ResponseBody) ZeusTransformUtils.preCheckCast(new ResponseBody$Companion$asResponseBody$1(r1, r3, r4), ResponseBody.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final ResponseBody create(ByteString r4, MediaType r5) {
            Intrinsics.checkParameterIsNotNull(r4, "$this$toResponseBody");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create((BufferedSource) ZeusTransformUtils.preCheckCast(new Buffer().write(r4), BufferedSource.class, "com.obric.memorydata.plugin"), r5, r4.size());
        }

        @JvmStatic
        public final ResponseBody create(byte[] r4, MediaType r5) {
            Intrinsics.checkParameterIsNotNull(r4, "$this$toResponseBody");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create((BufferedSource) ZeusTransformUtils.preCheckCast(new Buffer().write(r4), BufferedSource.class, "com.obric.memorydata.plugin"), r5, r4.length);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ResponseBody() {
    }

    private final Charset charset() {
        MediaType r1 = contentType();
        if (r1 == null) goto L8;
        Charset r2 = r1.charset(Charsets.UTF_8);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return Charsets.UTF_8;
    }

    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> r7, Function1<? super T, Integer> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        long r2 = contentLength();
        if (r2 > Integer.MAX_VALUE) goto L20;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(source(), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        T r11 = (T) r9.invoke(r6);
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r6, r0);
        InlineMarker.finallyEnd(1);
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r10.invoke(r11), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 != (-1)) goto L9;
    L13:
        return r11;
    L9:
        if (r2 == r12) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Content-Length (" + r2 + ") and stream length (" + r12 + ") disagree"), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r6, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Cannot buffer entire body for content length: " + r2), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final ResponseBody create(String r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r2, long r3, BufferedSource r5) {
        BufferedSource r6 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r5, BufferedSource.class, "com.obric.memorydata.plugin");
        return Companion.create(r2, r3, r6);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, String r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, ByteString r2) {
        return Companion.create(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType r1, byte[] r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final ResponseBody create(BufferedSource r2, MediaType r3, long r4) {
        BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r2, BufferedSource.class, "com.obric.memorydata.plugin");
        return Companion.create(r5, r3, r4);
    }

    @JvmStatic
    public static final ResponseBody create(ByteString r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    @JvmStatic
    public static final ResponseBody create(byte[] r1, MediaType r2) {
        return Companion.create(r1, r2);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() {
        long r0 = contentLength();
        if (r0 > Integer.MAX_VALUE) goto L20;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(source(), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        ByteString r4 = ((BufferedSource) ZeusTransformUtils.preCheckCast(r7, BufferedSource.class, "com.obric.memorydata.plugin")).readByteString();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r7, r2);
        int r8 = r4.size();
        if (r0 != (-1)) goto L9;
    L13:
        return r4;
    L9:
        if (r0 == r8) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Content-Length (" + r0 + ") and stream length (" + r8 + ") disagree"), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Cannot buffer entire body for content length: " + r0), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final byte[] bytes() {
        long r0 = contentLength();
        if (r0 > Integer.MAX_VALUE) goto L20;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(source(), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        byte[] r4 = ((BufferedSource) ZeusTransformUtils.preCheckCast(r7, BufferedSource.class, "com.obric.memorydata.plugin")).readByteArray();     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r7, r2);
        int r8 = r4.length;
        if (r0 != (-1)) goto L9;
    L13:
        return r4;
    L9:
        if (r0 == r8) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Content-Length (" + r0 + ") and stream length (" + r8 + ") disagree"), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Cannot buffer entire body for content length: " + r0), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Reader charStream() {
        Reader r0 = this.reader;
        if (r0 != null) goto L7;
        BomAwareReader r1 = new BomAwareReader(source(), charset());
        this.reader = (Reader) ZeusTransformUtils.preCheckCast(r1, Reader.class, "com.obric.memorydata.plugin");
        return (Reader) ZeusTransformUtils.preCheckCast(r1, Reader.class, "com.obric.memorydata.plugin");
    L7:
        return r0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(source(), Closeable.class, "com.obric.memorydata.plugin"));
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() {
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(source(), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        BufferedSource r2 = (BufferedSource) ZeusTransformUtils.preCheckCast(r0, BufferedSource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        String r4 = r2.readString(Util.readBomAsCharset(r2, charset()));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, r1);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}

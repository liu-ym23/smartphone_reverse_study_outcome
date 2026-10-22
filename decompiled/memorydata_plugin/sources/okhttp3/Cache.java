package okhttp3;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0000¢\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006F"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", IslandSession.REOPEN_VALUE_CLOSE, "delete", "-deprecated_directory", "evictAll", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "get", "Lokhttp3/Response;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", ChatMessage.TYPE_RESPONSE, "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", BuildConfig.CHANNEL, "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = null;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", AILabCheckPermissionTask.KEY_SOURCE, "okhttp"}, k = 1, mv = {1, 1, 15})
    private static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot r2, String r3, String r4) {
            Intrinsics.checkParameterIsNotNull(r2, "snapshot");
            this.snapshot = r2;
            this.contentType = r3;
            this.contentLength = r4;
            final Source r5 = r2.getSource(1);
            this.bodySource = Okio.buffer((Source) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r5, r5), Source.class, "com.obric.memorydata.plugin"));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String r2 = this.contentLength;
            if (r2 != null) goto L5;
            return -1;
        L5:
            return Util.toLongOrDefault(r2, -1);
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String r1 = this.contentType;
            if (r1 != null) goto L7;
            return null;
        L7:
            return MediaType.Companion.parse(r1);
        }

        public final DiskLruCache.Snapshot getSnapshot$okhttp() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final Set<String> varyFields(Headers r14) {
            Set<String> r13 = (Set) ZeusTransformUtils.preCheckCast(null, Set.class, "com.obric.memorydata.plugin");
            int r0 = r14.size();
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L19;
            if (StringsKt.equals("Vary", r14.name(r3), true) == false) goto L18;
            String r4 = r14.value(r3);
            if (r13 != null) goto L10;
            r13 = (Set) ZeusTransformUtils.preCheckCast(new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE)), Set.class, "com.obric.memorydata.plugin");
        L10:
            Iterator r5 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null).iterator();
        L12:
            if (r5.hasNext() == false) goto L18;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L17;
            r13.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString());
            goto L12
        L17:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L18:
            r3 = r3 + 1;
            goto L3
        L19:
            if (r13 == null) goto L22;
            return r13;
        L22:
            return SetsKt.emptySet();
        }

        private final Headers varyHeaders(Headers r5, Headers r6) {
            Set<String> r4 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).varyFields(r6);
            if (r4.isEmpty() == true) goto L5;
            Headers.Builder r7 = new Headers.Builder();
            int r0 = 0;
            int r1 = r5.size();
        L7:
            if (r0 >= r1) goto L13;
            String r2 = r5.name(r0);
            if (r4.contains(r2) == false) goto L11;
            r7.add(r2, r5.value(r0));
        L11:
            r0 = r0 + 1;
            goto L7
        L13:
            return r7.build();
        L5:
            return Util.EMPTY_HEADERS;
        }

        public final boolean hasVaryAll(Response r3) {
            Intrinsics.checkParameterIsNotNull(r3, "$this$hasVaryAll");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).varyFields(r3.headers()).contains("*");
        }

        @JvmStatic
        public final String key(HttpUrl r1) {
            Intrinsics.checkParameterIsNotNull(r1, "url");
            return ByteString.Companion.encodeUtf8(r1.toString()).md5().hex();
        }

        public final int readInt$okhttp(BufferedSource r6) {
            BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
            long r1 = r5.readDecimalLong();     // Catch: NumberFormatException -> L16
            String r7 = r5.readUtf8LineStrict();     // Catch: NumberFormatException -> L16
            if (r1 < 0) goto L15;
            if (r1 > Integer.MAX_VALUE) goto L15;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L15;
            return (int) r1;
        L10:
            r8 = false;
        L15:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("expected an int but was \"" + r1 + r7 + Typography.quote), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L16
        L16:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException(e.getMessage()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Headers varyHeaders(Response r4) {
            Intrinsics.checkParameterIsNotNull(r4, "$this$varyHeaders");
            Response r0 = r4.networkResponse();
            if (r0 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            Headers r1 = r0.request().headers();
            Headers r5 = r4.headers();
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).varyHeaders(r1, r5);
        }

        public final boolean varyMatches(Response r4, Headers r5, Request r6) {
            Intrinsics.checkParameterIsNotNull(r4, "cachedResponse");
            Intrinsics.checkParameterIsNotNull(r5, "cachedRequest");
            Intrinsics.checkParameterIsNotNull(r6, "newRequest");
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).varyFields(r4.headers()), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
        L7:
            Iterator r7 = r3.iterator();
        L9:
            if (r7.hasNext() == false) goto L18;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
            if ((!Intrinsics.areEqual(r5.values(r8), r6.headers(r8))) == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
            return true;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010#\u001a\u00060$R\u00020%J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0012\u0010+\u001a\u00020'2\n\u0010,\u001a\u00060-R\u00020%R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "code", "", "handshake", "Lokhttp3/Handshake;", "isHttps", "", "()Z", "message", "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "varyHeaders", "matches", Ext.KEY_REQUEST, "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
    private static final class Entry {
        public static final Companion Companion = null;
        private static final String RECEIVED_MILLIS = null;
        private static final String SENT_MILLIS = null;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"}, k = 1, mv = {1, 1, 15})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            SENT_MILLIS = Platform.Companion.get().getPrefix() + "-Sent-Millis";
            RECEIVED_MILLIS = Platform.Companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(Response r3) {
            Intrinsics.checkParameterIsNotNull(r3, ChatMessage.TYPE_RESPONSE);
            this.url = r3.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(r3);
            this.requestMethod = r3.request().method();
            this.protocol = r3.protocol();
            this.code = r3.code();
            this.message = r3.message();
            this.responseHeaders = r3.headers();
            this.handshake = r3.handshake();
            this.sentRequestMillis = r3.sentRequestAtMillis();
            this.receivedResponseMillis = r3.receivedResponseAtMillis();
        }

        public Entry(Source r11) {
            Source r12 = (Source) ZeusTransformUtils.wrapperContextForParams(r11, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r12, "rawSource");
            BufferedSource r0 = Okio.buffer(r12);     // Catch: Throwable -> L34
            this.url = r0.readUtf8LineStrict();     // Catch: Throwable -> L34
            this.requestMethod = r0.readUtf8LineStrict();     // Catch: Throwable -> L34
            Headers.Builder r2 = new Headers.Builder();     // Catch: Throwable -> L34
            int r3 = Cache.Companion.readInt$okhttp(r0);     // Catch: Throwable -> L34
            boolean r4 = false;
            int r5 = 0;
        L4:
            if (r5 >= r3) goto L6;
            r2.addLenient$okhttp(r0.readUtf8LineStrict());     // Catch: Throwable -> L34
            r5 = r5 + 1;     // Catch: Throwable -> L34
            goto L4
        L6:
            this.varyHeaders = r2.build();     // Catch: Throwable -> L34
            StatusLine r6 = StatusLine.Companion.parse(r0.readUtf8LineStrict());     // Catch: Throwable -> L34
            this.protocol = r6.protocol;     // Catch: Throwable -> L34
            this.code = r6.code;     // Catch: Throwable -> L34
            this.message = r6.message;     // Catch: Throwable -> L34
            Headers.Builder r7 = new Headers.Builder();     // Catch: Throwable -> L34
            int r8 = Cache.Companion.readInt$okhttp(r0);     // Catch: Throwable -> L34
            int r9 = 0;
        L7:
            if (r9 >= r8) goto L9;
            r7.addLenient$okhttp(r0.readUtf8LineStrict());     // Catch: Throwable -> L34
            r9 = r9 + 1;     // Catch: Throwable -> L34
            goto L7
        L9:
            String r10 = SENT_MILLIS;     // Catch: Throwable -> L34
            String r13 = r7.get(r10);     // Catch: Throwable -> L34
            String r14 = RECEIVED_MILLIS;     // Catch: Throwable -> L34
            String r15 = r7.get(r14);     // Catch: Throwable -> L34
            r7.removeAll(r10);     // Catch: Throwable -> L34
            r7.removeAll(r14);     // Catch: Throwable -> L34
            long r16 = 0;
            if (r13 == null) goto L12;
            long r17 = Long.parseLong(r13);     // Catch: Throwable -> L34
        L13:
            this.sentRequestMillis = r17;     // Catch: Throwable -> L34
            if (r15 == null) goto L16;
            r16 = Long.parseLong(r15);     // Catch: Throwable -> L34
        L16:
            this.receivedResponseMillis = r16;     // Catch: Throwable -> L34
            this.responseHeaders = r7.build();     // Catch: Throwable -> L34
            if (isHttps() == false) goto L30;
            String r18 = r0.readUtf8LineStrict();     // Catch: Throwable -> L34
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
            r4 = true;
        L21:
            if (r4 == true) goto L29;
            CipherSuite r1 = CipherSuite.Companion.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L34
            List<Certificate> r19 = readCertificateList(r0);     // Catch: Throwable -> L34
            List<Certificate> r20 = readCertificateList(r0);     // Catch: Throwable -> L34
            if (r0.exhausted() == true) goto L25;
            TlsVersion r21 = TlsVersion.Companion.forJavaName(r0.readUtf8LineStrict());     // Catch: Throwable -> L34
        L26:
            Handshake r22 = Handshake.Companion.get(r21, r1, r19, r20);     // Catch: Throwable -> L34
        L27:
            this.handshake = r22;     // Catch: Throwable -> L34
            r12.close();
            return;
        L25:
            r21 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L34
            goto L26
        L29:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("expected \"\" but was \"" + r18 + Typography.quote), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L34
        L30:
            r22 = (Handshake) ZeusTransformUtils.preCheckCast(null, Handshake.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
            goto L27
        L12:
            r17 = 0;
        L34:
            th = move-exception;
            r12.close();
            throw th;
        }

        private final boolean isHttps() {
            return StringsKt.startsWith$default(this.url, ReportConsts.HTTPS, false, 2, null);
        }

        private final List<Certificate> readCertificateList(BufferedSource r8) {
            BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r8, BufferedSource.class, "com.obric.memorydata.plugin");
            int r9 = Cache.Companion.readInt$okhttp(r7);
            if (r9 == (-1)) goto L5;
            CertificateFactory r1 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L14
            ArrayList r2 = new ArrayList(r9);     // Catch: CertificateException -> L14
            int r3 = 0;
        L7:
            if (r3 >= r9) goto L12;
            String r4 = r7.readUtf8LineStrict();     // Catch: CertificateException -> L14
            Buffer r5 = new Buffer();     // Catch: CertificateException -> L14
            ByteString r6 = ByteString.Companion.decodeBase64(r4);     // Catch: CertificateException -> L14
            if (r6 != null) goto L11;
            Intrinsics.throwNpe();     // Catch: CertificateException -> L14
        L11:
            r5.write(r6);     // Catch: CertificateException -> L14
            r2.add(r1.generateCertificate(r5.inputStream()));     // Catch: CertificateException -> L14
            r3 = r3 + 1;     // Catch: CertificateException -> L14
            goto L7
        L12:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        L14:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException(e.getMessage()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            return CollectionsKt.emptyList();
        }

        private final void writeCertList(BufferedSink r11, List<? extends Certificate> r12) {
            BufferedSink r10 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r11, BufferedSink.class, "com.obric.memorydata.plugin");
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            r10.writeDecimalLong(r13.size()).writeByte(10);     // Catch: CertificateEncodingException -> L8
            int r14 = 0;
            int r2 = r13.size();     // Catch: CertificateEncodingException -> L8
        L4:
            if (r14 >= r2) goto L7;
            byte[] r5 = ((Certificate) ZeusTransformUtils.preCheckCast(r13.get(r14), Certificate.class, "com.obric.memorydata.plugin")).getEncoded();     // Catch: CertificateEncodingException -> L8
            ByteString.Companion r4 = ByteString.Companion;     // Catch: CertificateEncodingException -> L8
            Intrinsics.checkExpressionValueIsNotNull(r5, "bytes");     // Catch: CertificateEncodingException -> L8
            r10.writeUtf8(ByteString.Companion.of$default(r4, r5, 0, 0, 3, null).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L8
            r14 = r14 + 1;
            goto L4
        L7:
            return;
        L8:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException(e.getMessage()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final boolean matches(Request r3, Response r4) {
            Intrinsics.checkParameterIsNotNull(r3, Ext.KEY_REQUEST);
            Intrinsics.checkParameterIsNotNull(r4, ChatMessage.TYPE_RESPONSE);
            if (Intrinsics.areEqual(this.url, r3.url().toString()) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.requestMethod, r3.method()) == false) goto L9;
            if (Cache.Companion.varyMatches(r4, this.varyHeaders, r3) == false) goto L9;
            return true;
        }

        public final Response response(DiskLruCache.Snapshot r6) {
            Intrinsics.checkParameterIsNotNull(r6, "snapshot");
            String r0 = this.responseHeaders.get(NetConst.KEY_CONTENT_TYPE);
            String r1 = this.responseHeaders.get("Content-Length");
            Request r2 = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(r2).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body((ResponseBody) ZeusTransformUtils.preCheckCast(new CacheResponseBody(r6, r0, r1), ResponseBody.class, "com.obric.memorydata.plugin")).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor r8) {
            Intrinsics.checkParameterIsNotNull(r8, "editor");
            int r0 = 0;
            BufferedSink r9 = Okio.buffer(r8.newSink(0));
            r9.writeUtf8(this.url).writeByte(10);
            r9.writeUtf8(this.requestMethod).writeByte(10);
            r9.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
            int r1 = this.varyHeaders.size();
            int r3 = 0;
        L4:
            if (r3 >= r1) goto L6;
            r9.writeUtf8(this.varyHeaders.name(r3)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(r3)).writeByte(10);
            r3 = r3 + 1;
            goto L4
        L6:
            r9.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            r9.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
            int r2 = this.responseHeaders.size();
        L7:
            if (r0 >= r2) goto L9;
            r9.writeUtf8(this.responseHeaders.name(r0)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(r0)).writeByte(10);
            r0 = r0 + 1;
            goto L7
        L9:
            r9.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            r9.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps() == false) goto L15;
            r9.writeByte(10);
            Handshake r4 = this.handshake;
            if (r4 != null) goto L14;
            Intrinsics.throwNpe();
        L14:
            r9.writeUtf8(r4.cipherSuite().javaName()).writeByte(10);
            writeCertList(r9, this.handshake.peerCertificates());
            writeCertList(r9, this.handshake.localCertificates());
            r9.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
        L15:
            r9.close();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone$okhttp", "()Z", "setDone$okhttp", "(Z)V", "abort", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(Cache r2, DiskLruCache.Editor r3) {
            Intrinsics.checkParameterIsNotNull(r3, "editor");
            this.this$0 = r2;
            this.editor = r3;
            final Sink r4 = r3.newSink(1);
            this.cacheOut = r4;
            this.body = (Sink) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4), Sink.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ DiskLruCache.Editor access$getEditor$p(RealCacheRequest r0) {
            return r0.editor;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Cache r2 = this.this$0;     // Catch: Throwable -> L14
            r2.setWriteAbortCount$okhttp(r2.getWriteAbortCount$okhttp() + 1);     // Catch: Throwable -> L14
            monitor-exit(r0);
            Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(this.cacheOut, Closeable.class, "com.obric.memorydata.plugin"));
            this.editor.abort();     // Catch: IOException -> L17
            return;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.body;
        }

        public final boolean getDone$okhttp() {
            return this.done;
        }

        public final void setDone$okhttp(boolean r1) {
            this.done = r1;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0013\u001a\u00020\u0004H\u0096\u0002J\t\u0010\u0014\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\f\u0012\b\u0012\u00060\nR\u00020\u000b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"okhttp3/Cache$urls$1", "", "", "canRemove", "", "getCanRemove", "()Z", "setCanRemove", "(Z)V", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "getDelegate", "()Ljava/util/Iterator;", "nextUrl", "getNextUrl", "()Ljava/lang/String;", "setNextUrl", "(Ljava/lang/String;)V", "hasNext", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class AnonymousClass1 implements Iterator<String>, KMutableIterator {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;
        final /* synthetic */ Cache this$0;

        AnonymousClass1(Cache r1) {
            this.this$0 = r1;
            this.delegate = r1.getCache$okhttp().snapshots();
        }

        public final boolean getCanRemove() {
            return this.canRemove;
        }

        public final Iterator<DiskLruCache.Snapshot> getDelegate() {
            return this.delegate;
        }

        public final String getNextUrl() {
            return this.nextUrl;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl == null) goto L5;
            return true;
        L5:
            this.canRemove = false;
        L7:
            if (this.delegate.hasNext() == false) goto L17;
            Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(this.delegate.next(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L18
            Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L18
            this.nextUrl = Okio.buffer(((DiskLruCache.Snapshot) ZeusTransformUtils.preCheckCast(r3, DiskLruCache.Snapshot.class, "com.obric.memorydata.plugin")).getSource(0)).readUtf8LineStrict();     // Catch: Throwable -> L12
            goto L7
        L10:
            CloseableKt.closeFinally(r3, r4);     // Catch: IOException -> L18
            return true;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r3, th);     // Catch: IOException -> L18
            throw th;     // Catch: IOException -> L18
        L17:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public String next2() {
            if (hasNext() == false) goto L10;
            String r0 = this.nextUrl;
            if (r0 != null) goto L7;
            Intrinsics.throwNpe();
        L7:
            this.nextUrl = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            this.canRemove = true;
            return r0;
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove == false) goto L7;
            this.delegate.remove();
            return;
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("remove() before next()".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void setCanRemove(boolean r1) {
            this.canRemove = r1;
        }

        public final void setNextUrl(String r1) {
            this.nextUrl = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Cache(File r2, long r3) {
        Intrinsics.checkParameterIsNotNull(r2, "directory");
        this(r2, r3, FileSystem.SYSTEM);
    }

    public Cache(File r8, long r9, FileSystem r11) {
        FileSystem r1 = (FileSystem) ZeusTransformUtils.wrapperContextForParams(r11, FileSystem.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, "directory");
        Intrinsics.checkParameterIsNotNull(r1, "fileSystem");
        this.cache = DiskLruCache.Companion.create(r1, r8, VERSION, 2, r9);
    }

    private final void abortQuietly(DiskLruCache.Editor r1) {
        if (r1 == null) goto L8;
        r1.abort();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final String key(HttpUrl r1) {
        return Companion.key(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    /* JADX INFO: renamed from: -deprecated_directory, reason: not valid java name */
    public final File m2924deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    public final Response get$okhttp(Request r5) {
        Intrinsics.checkParameterIsNotNull(r5, Ext.KEY_REQUEST);
        String r1 = Companion.key(r5.url());
        DiskLruCache.Snapshot r4 = this.cache.get(r1);     // Catch: IOException -> L15
        if (r4 == null) goto L14;
        Entry r2 = new Entry(r4.getSource(0));     // Catch: IOException -> L13
        Response r6 = r2.response(r4);
        if (r2.matches(r5, r6) == true) goto L12;
        ResponseBody r7 = r6.body();
        if (r7 == null) goto L11;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin"));
    L11:
        return null;
    L12:
        return r6;
    L13:
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin"));
    L14:
        return null;
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        monitor-enter(this);
        int r0 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final CacheRequest put$okhttp(Response r12) {
        Intrinsics.checkParameterIsNotNull(r12, ChatMessage.TYPE_RESPONSE);
        String r0 = r12.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(r12.request().method()) == false) goto L7;
        remove$okhttp(r12.request());     // Catch: IOException -> L20
    L5:
        return null;
    L7:
        if ((!Intrinsics.areEqual(r0, HttpMethodContrants.GET)) == false) goto L9;
        return null;
    L9:
        Companion r1 = Companion;
        if (r1.hasVaryAll(r12) == false) goto L12;
        return null;
    L12:
        Entry r2 = new Entry(r12);
        DiskLruCache.Editor r3 = (DiskLruCache.Editor) ZeusTransformUtils.preCheckCast(null, DiskLruCache.Editor.class, "com.obric.memorydata.plugin");
        r3 = DiskLruCache.edit$default(this.cache, r1.key(r12.request().url()), 0, 2, null);     // Catch: IOException -> L18
        if (r3 == null) goto L17;
        r2.writeTo(r3);     // Catch: IOException -> L18
        return (CacheRequest) ZeusTransformUtils.preCheckCast(new RealCacheRequest(this, r3), CacheRequest.class, "com.obric.memorydata.plugin");
    L17:
        return null;
    L18:
        abortQuietly(r3);
        return null;
    }

    public final void remove$okhttp(Request r2) {
        Intrinsics.checkParameterIsNotNull(r2, Ext.KEY_REQUEST);
        this.cache.remove(Companion.key(r2.url()));
    }

    public final synchronized int requestCount() {
        monitor-enter(this);
        int r0 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setWriteAbortCount$okhttp(int r1) {
        this.writeAbortCount = r1;
    }

    public final void setWriteSuccessCount$okhttp(int r1) {
        this.writeSuccessCount = r1;
    }

    public final long size() {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, "cacheStrategy");     // Catch: Throwable -> L11
        this.requestCount++;     // Catch: Throwable -> L11
        if (r2.getNetworkRequest() == null) goto L7;
        this.networkCount++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r2.getCacheResponse() == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void update$okhttp(Response r4, Response r5) {
        Intrinsics.checkParameterIsNotNull(r4, "cached");
        Intrinsics.checkParameterIsNotNull(r5, "network");
        Entry r0 = new Entry(r5);
        ResponseBody r6 = r4.body();
        if (r6 == null) goto L12;
        DiskLruCache.Snapshot r7 = ((CacheResponseBody) ZeusTransformUtils.preCheckCast(r6, CacheResponseBody.class, "com.obric.memorydata.plugin")).getSnapshot$okhttp();
        DiskLruCache.Editor r8 = (DiskLruCache.Editor) ZeusTransformUtils.preCheckCast(null, DiskLruCache.Editor.class, "com.obric.memorydata.plugin");
        r8 = r7.edit();     // Catch: IOException -> L9
        if (r8 == null) goto L15;
        r0.writeTo(r8);     // Catch: IOException -> L9
        r8.commit();     // Catch: IOException -> L9
        return;
    L15:
        return;
    L9:
        abortQuietly(r8);
        return;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    }

    public final Iterator<String> urls() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Iterator.class, "com.obric.memorydata.plugin");
    }

    public final synchronized int writeAbortCount() {
        monitor-enter(this);
        int r0 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r0 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}

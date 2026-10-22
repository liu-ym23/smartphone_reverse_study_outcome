package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0001J#\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\f¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001a¨\u0006+"}, d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", ActivityLifecycle.NAME, "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", LocationMonitorConst.TAG, ExifInterface.GPS_DIRECTION_TRUE, "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020/H\u0016J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013H\u0016J-\u00104\u001a\u00020\u0000\"\u0004\b\u0000\u001052\u000e\u00106\u001a\n\u0012\u0006\b\u0000\u0012\u0002H50\u001a2\b\u00104\u001a\u0004\u0018\u0001H5H\u0016¢\u0006\u0002\u00107J\u0012\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u000208H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00069"}, d2 = {"Lokhttp3/Request$Builder;", "", "()V", Ext.KEY_REQUEST, "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", "patch", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "put", "removeHeader", LocationMonitorConst.TAG, ExifInterface.GPS_DIRECTION_TRUE, "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            this.method = HttpMethodContrants.GET;
            this.headers = new Headers.Builder();
        }

        public Builder(Request r4) {
            Intrinsics.checkParameterIsNotNull(r4, Ext.KEY_REQUEST);
            this.tags = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            this.url = r4.url();
            this.method = r4.method();
            this.body = r4.body();
            if (r4.getTags$okhttp().isEmpty() == false) goto L5;
            Map<Class<?>, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        L6:
            this.tags = r0;
            this.headers = r4.headers().newBuilder();
            return;
        L5:
            r0 = MapsKt.toMutableMap(r4.getTags$okhttp());
            goto L6
        }

        public static /* synthetic */ Builder delete$default(Builder r0, RequestBody r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L7;
            r1 = Util.EMPTY_REQUEST;
        L7:
            return r0.delete(r1);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public Builder addHeader(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.add(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Request build() {
            HttpUrl r1 = this.url;
            if (r1 == null) goto L7;
            return new Request(r1, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("url == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public Builder cacheControl(CacheControl r3) {
            Intrinsics.checkParameterIsNotNull(r3, "cacheControl");
            String r4 = r3.toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            return removeHeader("Cache-Control");
        L10:
            return header("Cache-Control", r4);
        L5:
            r0 = false;
            goto L7
        }

        public Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder delete(RequestBody r2) {
            return method(HttpMethodContrants.DELETE, r2);
        }

        public Builder get() {
            return method(HttpMethodContrants.GET, null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method(HttpMethodContrants.HEAD, null);
        }

        public Builder header(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.set(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder headers(Headers r4) {
            Intrinsics.checkParameterIsNotNull(r4, "headers");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.headers = r4.newBuilder();
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder method(String r7, RequestBody r8) {
            Intrinsics.checkParameterIsNotNull(r7, "method");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L21;
            if (r8 != null) goto L15;
            if ((true ^ HttpMethod.requiresRequestBody(r7)) == false) goto L13;
        L16:
            r2.method = r7;
            r2.body = r8;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("method " + r7 + " must have a request body.").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L15:
            if (HttpMethod.permitsRequestBody(r7) == true) goto L16;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("method " + r7 + " must not have a request body.").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L21:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("method.isEmpty() == true".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r3 = false;
            goto L6
        }

        public Builder patch(RequestBody r2) {
            Intrinsics.checkParameterIsNotNull(r2, "body");
            return method(HttpMethodContrants.PATCH, r2);
        }

        public Builder post(RequestBody r2) {
            Intrinsics.checkParameterIsNotNull(r2, "body");
            return method("POST", r2);
        }

        public Builder put(RequestBody r2) {
            Intrinsics.checkParameterIsNotNull(r2, "body");
            return method(HttpMethodContrants.PUT, r2);
        }

        public Builder removeHeader(String r4) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.removeAll(r4);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setBody$okhttp(RequestBody r1) {
            this.body = r1;
        }

        public final void setHeaders$okhttp(Headers.Builder r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.headers = r2;
        }

        public final void setMethod$okhttp(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.method = r2;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> r3) {
            Map<Class<?>, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.tags = r4;
        }

        public final void setUrl$okhttp(HttpUrl r1) {
            this.url = r1;
        }

        public <T> Builder tag(Class<? super T> r6, T r7) {
            Intrinsics.checkParameterIsNotNull(r6, "type");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L6;
            r2.tags.remove(r6);
        L13:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L6:
            if (r2.tags.isEmpty() == false) goto L8;
            r2.tags = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        L8:
            Map<Class<?>, Object> r3 = r2.tags;
            T r8 = r6.cast(r7);
            if (r8 != null) goto L11;
            Intrinsics.throwNpe();
        L11:
            r3.put(r6, r8);
            goto L13
        }

        public Builder tag(Object r2) {
            return tag(Object.class, r2);
        }

        public Builder url(String r4) {
            Intrinsics.checkParameterIsNotNull(r4, "url");
            if (StringsKt.startsWith(r4, "ws:", true) == false) goto L7;
            StringBuilder r0 = new StringBuilder().append("http:");
            int r1 = 3;
        L5:
            String r5 = r4.substring(r1);
            Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.String).substring(startIndex)");
            r4 = r0.append(r5).toString();
        L10:
            return url(HttpUrl.Companion.get(r4));
        L7:
            if (StringsKt.startsWith(r4, "wss:", true) == false) goto L10;
            r0 = new StringBuilder().append("https:");
            r1 = 4;
            goto L5
        }

        public Builder url(URL r3) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            HttpUrl.Companion r0 = HttpUrl.Companion;
            String r4 = r3.toString();
            Intrinsics.checkExpressionValueIsNotNull(r4, "url.toString()");
            return url(r0.get(r4));
        }

        public Builder url(HttpUrl r4) {
            Intrinsics.checkParameterIsNotNull(r4, "url");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).url = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    public Request(HttpUrl r3, String r4, Headers r5, RequestBody r6, Map<Class<?>, ? extends Object> r7) {
        Map<Class<?>, Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "url");
        Intrinsics.checkParameterIsNotNull(r4, "method");
        Intrinsics.checkParameterIsNotNull(r5, "headers");
        Intrinsics.checkParameterIsNotNull(r8, "tags");
        this.url = r3;
        this.method = r4;
        this.headers = r5;
        this.body = r6;
        this.tags = r8;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m3025deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m3026deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m3027deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))
    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m3028deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m3029deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl r0 = this.lazyCacheControl;
        if (r0 != null) goto L6;
        CacheControl r1 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = r1;
        return r1;
    L6:
        return r0;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        return this.headers.get(r2);
    }

    public final List<String> headers(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        return this.headers.values(r2);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "type");
        return r2.cast(this.tags.get(r2));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Request{method=");
        r0.append(this.method);
        r0.append(", url=");
        r0.append(this.url);
        if (this.headers.size() == 0) goto L16;
        r0.append(", headers=[");
        int r2 = 0;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.headers, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r4 = r1.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.component1(), String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.component2(), String.class, "com.obric.memorydata.plugin");
        if (r2 <= 0) goto L13;
        r0.append(", ");
    L13:
        r0.append(r7);
        r0.append(':');
        r0.append(r8);
        r2 = r5;
        goto L6
    L14:
        r0.append(']');
    L16:
        if ((!this.tags.isEmpty()) == false) goto L18;
        r0.append(", tags=");
        r0.append(this.tags);
    L18:
        r0.append('}');
        String r9 = r0.toString();
        Intrinsics.checkExpressionValueIsNotNull(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }

    public final HttpUrl url() {
        return this.url;
    }
}

package com.obric.memorydata.middleware.api.bridge;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010$\u001a\u00020\u0005H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\u0085\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0016\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u00064"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/HttpRequest;", "", "method", "Lcom/obric/memorydata/middleware/api/bridge/HttpMethod;", "host", "", "path", "addAuthHeader", "", "queryParams", "", "headers", "postBody", "Lcom/google/gson/JsonObject;", "connectTimeout", "", "readTimeout", "writeTimeout", "<init>", "(Lcom/obric/memorydata/middleware/api/bridge/HttpMethod;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/Map;Lcom/google/gson/JsonObject;JJJ)V", "getMethod", "()Lcom/obric/memorydata/middleware/api/bridge/HttpMethod;", "getHost", "()Ljava/lang/String;", "getPath", "getAddAuthHeader", "()Z", "getQueryParams", "()Ljava/util/Map;", "getHeaders", "getPostBody", "()Lcom/google/gson/JsonObject;", "getConnectTimeout", "()J", "getReadTimeout", "getWriteTimeout", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRequest {

    @SerializedName("add_auth_header")
    private final boolean addAuthHeader;

    @SerializedName("connect_timeout")
    private final long connectTimeout;

    @SerializedName("headers")
    private final Map<String, String> headers;

    @SerializedName("host")
    private final String host;

    @SerializedName("method")
    private final HttpMethod method;

    @SerializedName("path")
    private final String path;

    @SerializedName("post_body")
    private final JsonObject postBody;

    @SerializedName("query_params")
    private final Map<String, String> queryParams;

    @SerializedName("read_timeout")
    private final long readTimeout;

    @SerializedName("write_timeout")
    private final long writeTimeout;

    public HttpRequest(HttpMethod r3, String r4, String r5, boolean r6, Map<String, String> r7, Map<String, String> r8, JsonObject r9, long r10, long r12, long r14) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r11, "queryParams");
        Intrinsics.checkNotNullParameter(r13, "headers");
        Intrinsics.checkNotNullParameter(r9, "postBody");
        this.method = r3;
        this.host = r4;
        this.path = r5;
        this.addAuthHeader = r6;
        this.queryParams = r11;
        this.headers = r13;
        this.postBody = r9;
        this.connectTimeout = r10;
        this.readTimeout = r12;
        this.writeTimeout = r14;
    }

    public /* synthetic */ HttpRequest(HttpMethod r19, String r20, String r21, boolean r22, Map r23, Map r24, JsonObject r25, long r26, long r28, long r30, int r32, DefaultConstructorMarker r33) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        if ((r32 & 8) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r32 & 16) == 0) goto L9;
        r1 = MapsKt.emptyMap();
    L9:
        Map r9 = r1;
        if ((r32 & 32) == 0) goto L12;
        r2 = MapsKt.emptyMap();
    L12:
        Map r10 = r2;
        if ((r32 & 64) == 0) goto L15;
        JsonObject r11 = new JsonObject();
    L17:
        if ((r32 & 128) == 0) goto L19;
        long r12 = 10000;
    L21:
        if ((r32 & 256) == 0) goto L23;
        long r14 = 30000;
    L25:
        if ((r32 & 512) == 0) goto L27;
        long r16 = 30000;
    L28:
        this(r19, r20, r21, r8, r9, r10, r11, r12, r14, r16);
        return;
    L27:
        r16 = r30;
        goto L28
    L23:
        r14 = r28;
        goto L25
    L19:
        r12 = r26;
        goto L21
    L15:
        r11 = r25;
        goto L17
    L5:
        r8 = r22;
        goto L7
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest r15, HttpMethod r16, String r17, String r18, boolean r19, Map r20, Map r21, JsonObject r22, long r23, long r25, long r27, int r29, Object r30) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if ((r29 & 1) == 0) goto L5;
        HttpMethod r4 = r15.method;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r5 = r15.host;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r6 = r15.path;
    L15:
        if ((r29 & 8) == 0) goto L17;
        boolean r7 = r15.addAuthHeader;
    L19:
        if ((r29 & 16) == 0) goto L22;
        r2 = r15.queryParams;
    L22:
        if ((r29 & 32) == 0) goto L25;
        r3 = r15.headers;
    L25:
        if ((r29 & 64) == 0) goto L27;
        JsonObject r8 = r15.postBody;
    L29:
        if ((r29 & 128) == 0) goto L31;
        long r9 = r15.connectTimeout;
    L33:
        if ((r29 & 256) == 0) goto L35;
        long r11 = r15.readTimeout;
    L37:
        if ((r29 & 512) == 0) goto L39;
        long r13 = r15.writeTimeout;
    L41:
        return r15.copy(r4, r5, r6, r7, r2, r3, r8, r9, r11, r13);
    L39:
        r13 = r27;
        goto L41
    L35:
        r11 = r25;
        goto L37
    L31:
        r9 = r23;
        goto L33
    L27:
        r8 = r22;
        goto L29
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public final HttpMethod component1() {
        return this.method;
    }

    public final long component10() {
        return this.writeTimeout;
    }

    public final String component2() {
        return this.host;
    }

    public final String component3() {
        return this.path;
    }

    public final boolean component4() {
        return this.addAuthHeader;
    }

    public final Map<String, String> component5() {
        return this.queryParams;
    }

    public final Map<String, String> component6() {
        return this.headers;
    }

    public final JsonObject component7() {
        return this.postBody;
    }

    public final long component8() {
        return this.connectTimeout;
    }

    public final long component9() {
        return this.readTimeout;
    }

    public final HttpRequest copy(HttpMethod r17, String r18, String r19, boolean r20, Map<String, String> r21, Map<String, String> r22, JsonObject r23, long r24, long r26, long r28) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "method");
        Intrinsics.checkNotNullParameter(r18, "host");
        Intrinsics.checkNotNullParameter(r19, "path");
        Intrinsics.checkNotNullParameter(r7, "queryParams");
        Intrinsics.checkNotNullParameter(r8, "headers");
        Intrinsics.checkNotNullParameter(r23, "postBody");
        return new HttpRequest(r17, r18, r19, r20, r7, r8, r23, r24, r26, r28);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, HttpRequest.class) == true) goto L8;
        return false;
    L8:
        HttpRequest r10 = (HttpRequest) ZeusTransformUtils.preCheckCast(r9, HttpRequest.class, "com.obric.memorydata.plugin");
        if (this.method == r10.method) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.host, r10.host) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.path, r10.path) == true) goto L18;
        return false;
    L18:
        if (this.addAuthHeader == r10.addAuthHeader) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.queryParams, r10.queryParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headers, r10.headers) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.postBody, r10.postBody) == true) goto L30;
        return false;
    L30:
        if (this.connectTimeout == r10.connectTimeout) goto L33;
        return false;
    L33:
        if (this.readTimeout == r10.readTimeout) goto L36;
        return false;
    L36:
        if (this.writeTimeout == r10.writeTimeout) goto L38;
        return false;
    L38:
        return true;
    }

    public final boolean getAddAuthHeader() {
        return this.addAuthHeader;
    }

    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getHost() {
        return this.host;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final String getPath() {
        return this.path;
    }

    public final JsonObject getPostBody() {
        return this.postBody;
    }

    public final Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public final long getReadTimeout() {
        return this.readTimeout;
    }

    public final long getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        return (((((((((((((((((this.method.hashCode() * 31) + this.host.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.addAuthHeader)) * 31) + this.queryParams.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.postBody.hashCode()) * 31) + Long.hashCode(this.connectTimeout)) * 31) + Long.hashCode(this.readTimeout)) * 31) + Long.hashCode(this.writeTimeout);
    }

    public String toString() {
        return "HttpRequest(method=" + this.method + ", host=" + this.host + ", path=" + this.path + ", addAuthHeader=" + this.addAuthHeader + ", queryParams=" + this.queryParams + ", headers=<omitted>, connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", postBody=<omitted>)";
    }
}

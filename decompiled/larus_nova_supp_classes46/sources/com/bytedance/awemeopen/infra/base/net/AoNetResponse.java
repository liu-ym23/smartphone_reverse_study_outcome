package com.bytedance.awemeopen.infra.base.net;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q64.c;
import q64.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00100\u001a\u00020/\u0012\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000104¢\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010&\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R%\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "", "", "contentType", "", "contentLength", "", "bytes", "stringBody", "Lorg/json/JSONObject;", "jsonBody", "", "isSuccessful", "key", "getHeaderString", "toString", "", "code", "I", "getCode", "()I", MultiLinkOpenSource.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "url", "getUrl", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "Lq64/e;", "body", "Lq64/e;", "getBody", "()Lq64/e;", "", "throwable", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "libType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "metric", "Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "getMetric", "()Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lq64/c;Lq64/e;Ljava/lang/Throwable;Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;Lcom/bytedance/awemeopen/servicesapi/network/AoNetworkMetric;Ljava/util/Map;)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoNetResponse {
    private final e body;
    private final int code;
    private final Map<String, Object> extraInfo;
    private final c headers;
    private final AoRequestType libType;
    private final String message;
    private final AoNetworkMetric metric;
    private final Throwable throwable;
    private final String url;

    public final byte[] bytes() {
        e r0 = this.body;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final long contentLength() {
        e r0 = this.body;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    public final String contentType() {
        e r0 = this.body;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final boolean isSuccessful() {
        if (this.throwable != null) goto L13;
        int r0 = this.code;
        if (200 <= r0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0 >= 300) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public final JSONObject jsonBody() {
        e r0 = this.body;
        if (r0 == null) goto L10;
        return new JSONObject(r0.f());
    L11:
        return null;
    L10:
        return null;
    }

    public final String stringBody() {
        e r0 = this.body;
        if (r0 == null) goto L6;
        String r1 = r0.f();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String toString() {
        return "BdpResponse(code=" + this.code + ", message='" + this.message + "', headers=" + this.headers + ", body=" + this.body + ", throwable=" + this.throwable + ", libType=" + this.libType + ", metric=" + this.metric + ", extraInfo=" + this.extraInfo + ')';
    }

    public final e getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final AoRequestType getLibType() {
        return this.libType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AoNetworkMetric getMetric() {
        return this.metric;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getHeaderString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.headers.a(r2);
    }

    public AoNetResponse(int r2, String r3, String r4, c r5, e r6, Throwable r7, AoRequestType r8, AoNetworkMetric r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "headers");
        Intrinsics.checkNotNullParameter(r8, "libType");
        Intrinsics.checkNotNullParameter(r9, "metric");
        Intrinsics.checkNotNullParameter(r10, "extraInfo");
        this.code = r2;
        this.message = r3;
        this.url = r4;
        this.headers = r5;
        this.body = r6;
        this.throwable = r7;
        this.libType = r8;
        this.metric = r9;
        this.extraInfo = r10;
    }
}

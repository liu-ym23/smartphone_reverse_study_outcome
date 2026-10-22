package com.bytedance.awemeopen.infra.base.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q64.c;
import q64.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001CB±\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00104\u001a\u00020-\u0012\u0006\u00106\u001a\u00020\u000f\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010:\u001a\u00020\u000f\u0012\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010<¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R\u0017\u00104\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R\u0017\u00106\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u0019\u00108\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u0007R\u0017\u0010:\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013R%\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "", "", "toString", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "method", "getMethod", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "getFrom", "()Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "", "responseStreaming", "Z", "getResponseStreaming", "()Z", "addHostSecurityParams", "getAddHostSecurityParams", "addHostCommonParams", "getAddHostCommonParams", "addHostMd5Stub", "getAddHostMd5Stub", "addCommonParams", "getAddCommonParams", "Lq64/c;", "headers", "Lq64/c;", "getHeaders", "()Lq64/c;", "reportMonitor", "getReportMonitor", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "requestLibType", "Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "getRequestLibType", "()Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "Lq64/d;", "requestBody", "Lq64/d;", "getRequestBody", "()Lq64/d;", "", "connectTimeOut", "J", "getConnectTimeOut", "()J", "readTimeOut", "getReadTimeOut", "writeTimeOut", "getWriteTimeOut", "httpDns", "getHttpDns", "cacheAppId", "getCacheAppId", "enableHttp2", "getEnableHttp2", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;ZZZZZLq64/c;ZLcom/bytedance/awemeopen/infra/base/net/AoRequestType;Lq64/d;JJJZLjava/lang/String;ZLjava/util/Map;)V", "a", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoNetRequest {
    private final boolean addCommonParams;
    private final boolean addHostCommonParams;
    private final boolean addHostMd5Stub;
    private final boolean addHostSecurityParams;
    private final String cacheAppId;
    private final long connectTimeOut;
    private final boolean enableHttp2;
    private final Map<String, Object> extraInfo;
    private final AoFromSource from;
    private final c headers;
    private final boolean httpDns;
    private final String method;
    private final long readTimeOut;
    private final boolean reportMonitor;
    private final d requestBody;
    private final AoRequestType requestLibType;
    private final boolean responseStreaming;
    private final String url;
    private final long writeTimeOut;

    public static final class a {
        public final String a;
        public String b;
        public final AoFromSource c;
        public boolean d;
        public final boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public long i;
        public long j;
        public long k;
        public c.a l;
        public boolean m;
        public AoRequestType n;
        public d o;
        public String p;
        public boolean q;
        public final Map<String, Object> r;

        public final AoNetRequest a() {
            String r2 = this.a;
            String r3 = this.b;
            AoFromSource r4 = this.c;
            boolean r5 = this.d;
            boolean r6 = this.f;
            boolean r7 = this.g;
            boolean r9 = this.h;
            c.a r1 = this.l;
            r1.getClass();
            return new AoNetRequest(r2, r3, r4, r5, r6, r7, false, r9, new c(r1.a), this.m, this.n, this.o, this.i, this.k, this.j, this.e, this.p, this.q, this.r);
        }

        public final void b(d r3) {
            Intrinsics.checkNotNullParameter(r3, "body");
            Intrinsics.checkNotNullParameter("POST", "method");
            this.b = "POST";
            this.o = r3;
        }

        public final void c(Map r6) {
            Intrinsics.checkNotNullParameter(r6, "headers");
            c.a r0 = this.l;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "map");
            ((ArrayList) r0.a).clear();
            Iterator r7 = r6.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r1 = (Map.Entry) r7.next();
            String r2 = (String) r1.getKey();
            String r3 = (String) r1.getValue();
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            List<c.C0256c> r4 = r0.a;
            ArrayList r5 = (ArrayList) r4;
            r5.add(new c.C0256c(r2, r3));
            goto L4
        }

        public final a delete(d r3) {
            Intrinsics.checkNotNullParameter("DELETE", "method");
            this.b = "DELETE";
            this.o = r3;
            return this;
        }

        public a(String r2, AoFromSource r3) {
            Intrinsics.checkNotNullParameter(r2, "httpUrl");
            Intrinsics.checkNotNullParameter(r3, "fromSource");
            this.a = r2;
            this.c = r3;
            this.b = "GET";
            this.i = 60000;
            this.j = 60000;
            this.k = 60000;
            this.d = false;
            this.e = true;
            this.f = true;
            this.g = false;
            this.h = false;
            this.l = new c.a();
            this.m = true;
            this.n = AoRequestType.HOST;
            this.o = null;
            this.p = null;
            this.q = false;
            this.r = new HashMap();
        }
    }

    public String toString() {
        return "BdpRequest(url='" + this.url + "', method='" + this.method + "', from=" + this.from + ", responseStreaming=" + this.responseStreaming + ", addHostSecurityParams=" + this.addHostSecurityParams + ", addHostCommonParams=" + this.addHostCommonParams + ", addHostMd5Stub=" + this.addHostMd5Stub + ", addBdpCommonParams=" + this.addCommonParams + ", headers=" + this.headers + ", reportMonitor=" + this.reportMonitor + ", requestLibType=" + this.requestLibType + ", requestBody=" + this.requestBody + ", connectTimeOut=" + this.connectTimeOut + ", readTimeOut=" + this.readTimeOut + ", writeTimeOut=" + this.writeTimeOut + ", httpDns=" + this.httpDns + ", cacheAppId=" + this.cacheAppId + ", enableHttp2=" + this.enableHttp2 + ", extraInfo=" + this.extraInfo + ')';
    }

    public final boolean getAddCommonParams() {
        return this.addCommonParams;
    }

    public final boolean getAddHostCommonParams() {
        return this.addHostCommonParams;
    }

    public final boolean getAddHostMd5Stub() {
        return this.addHostMd5Stub;
    }

    public final boolean getAddHostSecurityParams() {
        return this.addHostSecurityParams;
    }

    public final String getCacheAppId() {
        return this.cacheAppId;
    }

    public final long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public final boolean getEnableHttp2() {
        return this.enableHttp2;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final AoFromSource getFrom() {
        return this.from;
    }

    public final c getHeaders() {
        return this.headers;
    }

    public final boolean getHttpDns() {
        return this.httpDns;
    }

    public final String getMethod() {
        return this.method;
    }

    public final long getReadTimeOut() {
        return this.readTimeOut;
    }

    public final boolean getReportMonitor() {
        return this.reportMonitor;
    }

    public final d getRequestBody() {
        return this.requestBody;
    }

    public final AoRequestType getRequestLibType() {
        return this.requestLibType;
    }

    public final boolean getResponseStreaming() {
        return this.responseStreaming;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public AoNetRequest(String r9, String r10, AoFromSource r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, c r17, boolean r18, AoRequestType r19, d r20, long r21, long r23, long r25, boolean r27, String r28, boolean r29, Map<String, ? extends Object> r30) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r17, "headers");
        Intrinsics.checkNotNullParameter(r19, "requestLibType");
        Intrinsics.checkNotNullParameter(r30, "extraInfo");
        this.url = r9;
        this.method = r10;
        this.from = r11;
        this.responseStreaming = r12;
        this.addHostSecurityParams = r13;
        this.addHostCommonParams = r14;
        this.addHostMd5Stub = r15;
        this.addCommonParams = r16;
        this.headers = r17;
        this.reportMonitor = r18;
        this.requestLibType = r19;
        this.requestBody = r20;
        this.connectTimeOut = r21;
        this.readTimeOut = r23;
        this.writeTimeOut = r25;
        this.httpDns = r27;
        this.cacheAppId = r28;
        this.enableHttp2 = r29;
        this.extraInfo = r30;
    }
}

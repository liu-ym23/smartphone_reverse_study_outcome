package h64;

import android.text.TextUtils;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.http.RequestContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q64.e;
import q64.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements g {
    public final Request a;
    public final Throwable b;
    public final SsCall c;

    @Override // q64.g
    public final AoNetworkMetric a() {
        IMetricsCollect r0 = this.c;
        if ((r0 instanceof IMetricsCollect) == false) goto L5;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.retrofit2.IMetricsCollect");
        r0.doCollect();
    L5:
        IRequestInfo r1 = this.c;
        if ((r1 instanceof IRequestInfo) == false) goto L18;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.retrofit2.IRequestInfo");
        Object r2 = r1.getRequestInfo();
        if ((r2 instanceof BaseHttpRequestInfo) == false) goto L18;
        BaseHttpRequestInfo r3 = (BaseHttpRequestInfo) r2;
        SsCall r4 = this.c;
        if (r4 == null) goto L14;
        Request r5 = r4.getRequest();
        if (r5 == null) goto L14;
        RetrofitMetrics r6 = r5.getMetrics();
    L16:
        return a.c(r3, r6);
    L14:
        r6 = null;
    L18:
        return new AoNetworkMetric();
    }

    @Override // q64.g
    public final void cancel() {
        SsCall r0 = this.c;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // q64.g
    public final q64.b execute() {
        SsCall r1 = this.c;
        e r3 = null;
        String r4 = null;
        if (r1 != null) goto L24;
        StringBuilder r0 = new StringBuilder();
        Throwable r2 = this.b;
        if (r2 == null) goto L18;
        Class<?> r5 = r2.getClass();
    L19:
        r0.append(r5);
        r0.append(": ");
        Throwable r6 = this.b;
        if (r6 == null) goto L22;
        r4 = r6.getMessage();
    L22:
        r0.append(r4);
        r0.append(", -1");
        String r7 = r0.toString();
        String r8 = this.a.getUrl();
        q64.c r9 = q64.c.b;
        return new q64.b(-1, r7, r8, q64.c.b, null, this.b);
    L18:
        r5 = null;
        goto L19
    L24:
        Response r10 = r1.execute();     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        q64.c r11 = a.b(r10.getHeaders());     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        TypedInput r12 = r10.getBody();     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        if (r12 == null) goto L7;
        r3 = new e(r12.mimeType(), r12.length(), r12.in());     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
    L7:
    L29:
        return new q64.b(r10.getStatus(), r10.getReason(), r10.getUrl(), r11, r3, null);
    L11:
        e = move-exception;
        String r13 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r14 = e.getStatusCode();
        String r15 = this.a.getUrl();
        q64.c r16 = q64.c.b;
        return new q64.b(r14, r13, r15, q64.c.b, null, e);
    L13:
        e = move-exception;
        String r17 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r18 = e.getStatusCode();
        String r19 = this.a.getUrl();
        q64.c r20 = q64.c.b;
        return new q64.b(r18, r17, r19, q64.c.b, null, e);
    L9:
        e = move-exception;
        String r21 = e.getClass() + ": " + e.getMessage() + ", -1";
        String r22 = this.a.getUrl();
        q64.c r23 = q64.c.b;
        return new q64.b(-1, r21, r22, q64.c.b, null, e);
    }

    public b(q64.a r14) {
        Intrinsics.checkNotNullParameter(r14, "mAoRequest");
        lx5.b r0 = HttpClient.getHttpClient(r14.a);
        String r1 = r14.b;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = "GET";
    L5:
        String r3 = r1;
        List<Header> r5 = a.a(r14.f);
        RequestContext r11 = new RequestContext();
        ((BaseRequestContext) r11).timeout_connect = r14.h;
        ((BaseRequestContext) r11).timeout_read = r14.i;
        ((BaseRequestContext) r11).timeout_write = r14.j;
        ((BaseRequestContext) r11).force_handle_response = true;
        q64.d r2 = r14.g;
        if (r2 == null) goto L8;
        d r6 = new d(r2);
    L9:
        RetrofitMetrics r4 = new RetrofitMetrics();
        Request r12 = new Request(r3, r14.a, r5, r6, 3, r14.c, Integer.MAX_VALUE, r14.d, r11);
        this.a = r12;
        r4.createSsHttpCallTime = System.currentTimeMillis();     // Catch: Exception -> L12
        this.c = r0.newSsCall(r12);     // Catch: Exception -> L12
    L14:
        this.a.setMetrics(r4);
        return;
    L12:
        e = move-exception;
        this.b = e;
        goto L14
    L8:
        r6 = null;
        goto L9
    }
}

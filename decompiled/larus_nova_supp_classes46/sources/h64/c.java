package h64;

import android.util.Pair;
import com.bytedance.awemeopen.infra.plugs.ttnet.AoTTNetRetrofitApi;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q64.e;
import q64.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements g {
    public final q64.a a;
    public final Call<?> b;
    public final Throwable c;
    public SsResponse<?> d;

    @Override // q64.g
    public final AoNetworkMetric a() {
        IMetricsCollect r0 = this.b;
        if ((r0 instanceof IMetricsCollect) == false) goto L5;
        r0.doCollect();
    L5:
        SsResponse<?> r1 = this.d;
        RetrofitMetrics r2 = null;
        if (r1 == null) goto L10;
        Response r3 = r1.raw();
        if (r3 == null) goto L10;
        Object r4 = r3.getExtraInfo();
    L12:
        if ((r4 instanceof BaseHttpRequestInfo) == false) goto L21;
        BaseHttpRequestInfo r5 = (BaseHttpRequestInfo) r4;
        if (r0 == null) goto L19;
        Request r6 = r0.request();
        if (r6 == null) goto L19;
        r2 = r6.getMetrics();
    L19:
        return a.c(r5, r2);
    L21:
        return new AoNetworkMetric();
    L10:
        r4 = null;
        goto L12
    }

    @Override // q64.g
    public final void cancel() {
        Call<?> r0 = this.b;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // q64.g
    public final q64.b execute() {
        Call<?> r1 = this.b;
        e r3 = null;
        String r4 = null;
        if (r1 != null) goto L28;
        StringBuilder r0 = new StringBuilder();
        Throwable r2 = this.c;
        if (r2 == null) goto L22;
        Class<?> r5 = r2.getClass();
    L23:
        r0.append(r5);
        r0.append(": ");
        Throwable r6 = this.c;
        if (r6 == null) goto L26;
        r4 = r6.getMessage();
    L26:
        r0.append(r4);
        r0.append(", -1");
        String r7 = r0.toString();
        String r8 = this.a.a;
        q64.c r9 = q64.c.b;
        return new q64.b(-1, r7, r8, q64.c.b, null, this.c);
    L22:
        r5 = null;
        goto L23
    L28:
        SsResponse<?> r10 = r1.execute();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        this.d = r10;     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        q64.c r11 = a.b(r10.headers());     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        if (r10.isSuccessful() == false) goto L7;
        Object r12 = r10.body();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L9:
        if ((r12 instanceof TypedInput) == false) goto L11;
        r3 = new e(((TypedInput) r12).mimeType(), ((TypedInput) r12).length(), ((TypedInput) r12).in());     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L11:
    L33:
        return new q64.b(r10.code(), r10.raw().getReason(), r10.raw().getUrl(), r11, r3, null);
    L7:
        r12 = r10.errorBody();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L17:
        e = move-exception;
        String r13 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r14 = e.getStatusCode();
        String r15 = this.a.a;
        q64.c r16 = q64.c.b;
        return new q64.b(r14, r13, r15, q64.c.b, null, e);
    L15:
        e = move-exception;
        String r17 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r18 = e.getStatusCode();
        String r19 = this.a.a;
        q64.c r20 = q64.c.b;
        return new q64.b(r18, r17, r19, q64.c.b, null, e);
    L13:
        e = move-exception;
        String r21 = e.getClass() + ": " + e.getMessage() + ", -1";
        String r22 = this.a.a;
        q64.c r23 = q64.c.b;
        return new q64.b(-1, r21, r22, q64.c.b, null, e);
    }

    public c(q64.a r14) {
        Intrinsics.checkNotNullParameter(r14, "mAoRequest");
        this.a = r14;
    L59:
        th = move-exception;
        this.c = th;
        return;
    L5:
        if (r14.b.length() <= 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        String r1 = r14.b;     // Catch: Throwable -> L59
    L12:
        List<Header> r4 = a.a(r14.f);     // Catch: Throwable -> L59
        boolean r12 = r14.d;     // Catch: Throwable -> L59
        HashMap r8 = new HashMap();     // Catch: Throwable -> L59
        Pair r5 = UrlUtils.parseUrl(r14.a, r8);     // Catch: Throwable -> L59
        String r6 = (String) r5.first;     // Catch: Throwable -> L59
        String r7 = (String) r5.second;     // Catch: Throwable -> L59
        RequestContext r11 = new RequestContext();     // Catch: Throwable -> L59
        ((BaseRequestContext) r11).timeout_connect = r14.h;     // Catch: Throwable -> L59
        ((BaseRequestContext) r11).timeout_read = r14.i;     // Catch: Throwable -> L59
        ((BaseRequestContext) r11).timeout_write = r14.j;     // Catch: Throwable -> L59
        ((BaseRequestContext) r11).force_handle_response = true;     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r6, "baseUrl");     // Catch: Throwable -> L59
        AoTTNetRetrofitApi r9 = (AoTTNetRetrofitApi) RetrofitUtils.createSsService(r6, AoTTNetRetrofitApi.class);     // Catch: Throwable -> L59
        if (r9 == null) goto L58;
        boolean r2 = r14.c;     // Catch: Throwable -> L59
        q64.d r15 = r14.g;     // Catch: Throwable -> L59
        if (r15 == null) goto L17;
        d r10 = new d(r15);     // Catch: Throwable -> L59
    L19:
        switch(r1.hashCode()) {
            case -531492226: goto L52;
            case 70454: goto L47;
            case 79599: goto L42;
            case 2213344: goto L39;
            case 2461856: goto L34;
            case 75900968: goto L31;
            case 80083237: goto L28;
            case 1669334218: goto L25;
            case 2012838315: goto L22;
            default: goto L56;
        };     // Catch: Throwable -> L59
    L56:
        throw new RuntimeException("call need method");     // Catch: Throwable -> L59
    L22:
        if (r1.equals("DELETE") == false) goto L56;
        Call<TypedInput> r16 = r9.delete(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
    L54:
        this.b = r16;     // Catch: Throwable -> L59
        return;
    L25:
        if (r1.equals("CONNECT") == false) goto L56;
        r16 = r9.connect(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L28:
        if (r1.equals("TRACE") == false) goto L56;
        r16 = r9.trace(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L31:
        if (r1.equals("PATCH") == false) goto L56;
        r16 = r9.patch(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L34:
        if (r1.equals("POST") == false) goto L56;
        if (r2 == false) goto L37;
        r16 = r9.postStream(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L37:
        r16 = r9.post(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L39:
        if (r1.equals("HEAD") == false) goto L56;
        r16 = r9.head(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L42:
        if (r1.equals("PUT") == false) goto L56;
        if (r2 == false) goto L45;
        r16 = r9.putStream(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L45:
        r16 = r9.put(Integer.MAX_VALUE, r7, r8, r10, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L47:
        if (r1.equals("GET") == false) goto L56;
        if (r2 == false) goto L50;
        r16 = r9.getStream(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L50:
        r16 = r9.get(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L52:
        if (r1.equals("OPTIONS") == false) goto L56;
        r16 = r9.options(Integer.MAX_VALUE, r7, r8, r4, r11, r12);     // Catch: Throwable -> L59
        goto L54
    L17:
        r10 = new TypedByteArray(null, new byte[0], new String[0]);     // Catch: Throwable -> L59
        goto L19
    L58:
        throw new RuntimeException("generateTTNetApi Failed");     // Catch: Throwable -> L59
    L11:
        r1 = "GET";
        goto L12
    L7:
        r0 = false;
        goto L9
    }
}

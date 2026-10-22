package com.ss.android.lark.http.okhttp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.http.base.BaseRequest;
import com.ss.android.lark.http.model.ErrorResult;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseOkHttpRequest<T> extends BaseRequest<T> {
    public static final String HEADER_LOG_TAG = "X-Request-ID";
    private HttpHeaders mHttpHeaders;
    private HttpParams mHttpParams;

    public class a implements Callback {
        public final /* synthetic */ Request a;
        public final /* synthetic */ BaseOkHttpRequest b;

        public a(BaseOkHttpRequest r1, Request r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onFailure(Call r3, IOException r4) {
            this.b.logRequest(this.a, 0, r4);
        }

        public final void onResponse(Call r7, Response r8) throws IOException {
            int r1 = r8.code();
            this.b.logRequest(this.a, r1, null);
            this.b.getResponseFilter();     // Catch: Throwable -> L6 Exception -> L9
            String r9 = r8.body().string();     // Catch: Throwable -> L6 Exception -> L9
            BaseOkHttpRequest.access$000(this.b, null, r1, r9, JSON.parseObject(r9));
            return;
        L9:
            e = move-exception;
            new ErrorResult(-1, r1, "http code:" + r1 + " " + e.getMessage());
            throw null;
        L6:
            th = move-exception;
            new ErrorResult(-1, r1, "http code:" + r1 + " " + th.getMessage());
            throw null;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HttpMethod.values().length];
            a = r0;
            r0[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public abstract String getBaseUrl();

    public abstract String getHttpTag();

    public abstract ekb.a getResponseFilter();

    public final String a() {
        String r0 = getBaseUrl() + getPath();
        LinkedHashMap<String, String> r1 = this.mHttpParams.urlParamsMap;
        int r2 = fkb.a.a;
        if (TextUtils.isEmpty(r0) == true) goto L31;
        if (r1 != null) goto L6;
        return r0;
    L6:
        if (r1.size() <= 0) goto L33;
        StringBuilder r3 = new StringBuilder(r0);
        if (r0.endsWith("?") == true) goto L11;
        r3.append("?");
    L11:
        Iterator<String> r4 = r1.keySet().iterator();
        boolean r5 = true;
    L13:
        if (r4.hasNext() == false) goto L23;
        String r6 = r4.next();
        if (TextUtils.isEmpty(r6) == true) goto L13;
        if (TextUtils.isEmpty(r1.get(r6)) == true) goto L13;
        if (r5 == false) goto L20;
        r5 = false;
    L21:
        r3.append(r6);
        r3.append("=");
        r3.append(r1.get(r6));
        goto L13
    L20:
        r3.append("&");
        goto L21
    L23:
        return r3.toString();
    L33:
        return r0;
    L31:
        return r0;
    }

    public BaseOkHttpRequest() {
        this.mHttpParams = new HttpParams();
        this.mHttpHeaders = new HttpHeaders();
    }

    public RequestBody buildBody() {
        HttpRequestBody r0 = getRequestBody();
        if (r0 != null) goto L10;
        return null;
    L10:
        return RequestBody.create(MediaType.parse(r0.getMediaType()), r0.getContent());
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.lark.http.base.BaseRequest
    public String getUrl() {
        return a();
    }

    static {
    }

    @Override // com.ss.android.lark.http.base.BaseRequest
    public HttpHeaders getHeaders() {
        return this.mHttpHeaders;
    }

    @Override // com.ss.android.lark.http.base.BaseRequest
    public HttpParams getHttpParams() {
        return this.mHttpParams;
    }

    @Override // com.ss.android.lark.http.base.BaseRequest
    public HttpHeaders buildHeaders(HttpHeaders r5) {
        long r0 = System.currentTimeMillis();
        r5.put(HEADER_LOG_TAG, String.valueOf(r0) + Math.abs(new Random(r0).nextInt()));
        return r5;
    }

    @Override // com.ss.android.lark.http.base.BaseRequest
    public void request(dkb.a<T> r6) {
        monitor-enter(ekb.b.class);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (ekb.b.a != null) goto L7;
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();     // Catch: Throwable -> L28
        TimeUnit r1 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L28
        r0.connectTimeout(15000, r1).readTimeout(10000, r1).writeTimeout(30000, TimeUnit.MICROSECONDS);     // Catch: Throwable -> L28
        ekb.b.a = r0.build();     // Catch: Throwable -> L28
    L7:
        OkHttpClient r2 = ekb.b.a;     // Catch: Throwable -> L28
        monitor-exit(ekb.b.class);
        if (TextUtils.isEmpty(getPath()) == false) goto L12;
        Request r7 = null;
    L26:
        r2.newCall(r7).enqueue(new a(this, r7));
        return;
    L12:
        Request.Builder r8 = new Request.Builder().url(a());
        HttpHeaders r3 = buildHeaders(this.mHttpHeaders);
        if (r3.isEmpty() == true) goto L18;
        Iterator<String> r4 = r3.getNames().iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        String r5 = r4.next();
        r8.addHeader(r5, r3.get(r5));
    L18:
        int r9 = b.a[getMethod().ordinal()];
        if (r9 != 1) goto L21;
        r8.get();
    L25:
        r7 = r8.build();
        goto L26
    L21:
        if (r9 != 2) goto L25;
        r8.post(buildBody());
        goto L25
    }

    public void logRequest(Request r2, int r3, Throwable r4) {
        r2.header(HEADER_LOG_TAG);
        r2.url().toString();
        new StringBuilder(", statusCode:").append(r3);
        if (r4 != null) goto L5;
        getHttpTag();
        return;
    L5:
        getHttpTag();
    }

    public static void access$000(BaseOkHttpRequest r6, dkb.a r7, int r8, String r9, JSONObject r10) {
        r6.getClass();
        int r11 = -3;
        if (r8 < 400) goto L10;
        String r12 = r10.getString(INotificationHitPoint.NoticeType.MESSAGE);
        if (TextUtils.isEmpty(r12) == false) goto L7;
        r12 = "http status code:" + r8 + " get verify code fail";
        r11 = -2;
    L7:
        new ErrorResult(r11, r8, r12);
        throw null;
    L10:
        if (r8 != 200) goto L12;
        r6.getObjectConverter();     // Catch: Exception -> L22
        throw null;     // Catch: Exception -> L22
    L22:
        new ErrorResult(-1, r8, "X-Request-ID:" + r6.getHeaders().get(HEADER_LOG_TAG) + ", url:" + r6.getUrl() + ", responseBody:" + r9);
        throw null;
    L12:
        if (r8 == 204) goto L18;
        String r13 = r10.getString(INotificationHitPoint.NoticeType.MESSAGE);
        if (TextUtils.isEmpty(r13) == false) goto L16;
        r13 = "http status code:" + r8 + " get verify code fail";
        r11 = -2;
    L16:
        new ErrorResult(r11, r8, r13);
        throw null;
    L18:
        new ErrorResult(-3, r8, "no content");
        throw null;
    }
}

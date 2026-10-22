package com.ss.android.lark.http.base;

import ckb.a;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseRequest<T> implements Serializable {
    public BaseRequest() {
    }

    public HttpHeaders buildHeaders(HttpHeaders r1) {
        return r1;
    }

    public HttpParams buildParams(HttpParams r1) {
        return r1;
    }

    public abstract HttpHeaders getHeaders();

    public abstract HttpParams getHttpParams();

    public abstract a<T> getObjectConverter();

    public abstract String getPath();

    public abstract HttpRequestBody getRequestBody();

    public abstract String getUrl();

    public abstract void request(dkb.a<T> r1);

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}

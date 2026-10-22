package com.ss.android.lark.passport.signinsdk_api.base.http;

import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import dzb.c;
import fzb.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IRequest<T> extends Serializable {
    public static final Map<String, Object> mRequestBody = null;

    HttpHeaders buildHeaders(HttpHeaders r1);

    boolean canLog();

    HttpHeaders getHeaders();

    String getHttpTag();

    HttpMethod getMethod();

    a getMonitorCodeCreator();

    String getName();

    ckb.a<T> getObjectConverter();

    String getPath();

    HttpRequestBody getRequestBody();

    ezb.a getResponseFilter();

    UniContext getUniContext();

    String getUrl();

    boolean isCancelable();

    void onProcessResponseHeaders(Map<String, String> r1);

    void request(dzb.a<T> r1);

    c request2(dzb.a<T> r1);

    void retryRequest(dzb.a<T> r1);

    void setUniContext(UniContext r1);

    static {
        mRequestBody = new HashMap();
    }
}

package com.obric.aikernel.middleware.impl.network;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.k;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.utils.GsonExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n4.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class HttpRequest {
    private Map<String, String> headers;
    private final String httpMethodName;
    private String path;
    private final String postDataJson;
    private Map<String, String> queryParams;

    public HttpRequest() {
    }

    public final List<b> getHeaderList() {
        ArrayList r10 = new ArrayList();
        Map<String, String> r11 = this.headers;
        if (r11 == null) goto L8;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, String> r13 = r12.next();
        r10.add(new b(r13.getKey(), r13.getValue()));
    L8:
        return r10;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getHttpMethodName() {
        return this.httpMethodName;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPostDataJson() {
        return this.postDataJson;
    }

    public final k getPostJson() {
        String r10 = this.postDataJson;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L21;
        return new k();
    L21:
        Object r12 = GsonExtKt.a().k(this.postDataJson, k.class);     // Catch: Exception -> L15
    L17:
        k r13 = (k) r12;
        if (r13 == null) goto L20;
        return r13;
    L20:
        return new k();
    L15:
        e = move-exception;
        AIKLog.INSTANCE.e("GsonExt", "toObj error : " + e);
        r12 = null;
        goto L17
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public final Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public final boolean isValid() {
        String r10 = this.path;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(this.httpMethodName) == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public final void setHeaders(Map<String, String> r10) {
        this.headers = r10;
    }

    public final void setPath(String r10) {
        this.path = r10;
    }

    public final void setQueryParams(Map<String, String> r10) {
        this.queryParams = r10;
    }
}

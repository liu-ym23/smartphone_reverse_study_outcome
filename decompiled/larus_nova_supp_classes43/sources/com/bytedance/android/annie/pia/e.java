package com.bytedance.android.annie.pia;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements i47.e {
    public final /* synthetic */ WebResourceResponse a;

    public final InputStream getData() {
        return this.a.getData();
    }

    public final String getEncoding() {
        return this.a.getEncoding();
    }

    public final Map<String, String> getHeaders() {
        return this.a.getResponseHeaders();
    }

    public final String getMimeType() {
        return this.a.getMimeType();
    }

    public final String getReasonPhrase() {
        if (TextUtils.isEmpty(this.a.getReasonPhrase()) == false) goto L6;
        return "OK";
    L6:
        return this.a.getReasonPhrase();
    }

    public final int getStatusCode() {
        if (this.a.getStatusCode() != 0) goto L6;
        return 200;
    L6:
        return this.a.getStatusCode();
    }

    public final LoadFrom a() {
        return LoadFrom.Offline;
    }

    public e(WebResourceResponse r1) {
        this.a = r1;
    }
}

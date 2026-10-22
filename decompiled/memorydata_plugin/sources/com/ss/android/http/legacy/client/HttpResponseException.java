package com.ss.android.http.legacy.client;

import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;

/* JADX INFO: loaded from: classes6.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int r1, String r2) {
        super(r2);
        this.statusCode = r1;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

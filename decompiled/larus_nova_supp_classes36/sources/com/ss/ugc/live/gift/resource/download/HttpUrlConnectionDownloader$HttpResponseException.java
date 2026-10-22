package com.ss.ugc.live.gift.resource.download;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class HttpUrlConnectionDownloader$HttpResponseException extends IOException {
    private int code;

    public int getCode() {
        return this.code;
    }

    public HttpUrlConnectionDownloader$HttpResponseException(String r1, int r2) {
        super(r1);
        this.code = r2;
    }
}

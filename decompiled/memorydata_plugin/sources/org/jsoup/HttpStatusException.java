package org.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class HttpStatusException extends IOException {
    private final int statusCode;
    private final String url;

    public HttpStatusException(String r2, int r3, String r4) {
        super(r2 + ". Status=" + r3 + ", URL=[" + r4 + "]");
        this.statusCode = r3;
        this.url = r4;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }
}

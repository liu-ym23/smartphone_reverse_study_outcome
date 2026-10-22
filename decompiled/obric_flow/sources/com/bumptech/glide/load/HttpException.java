package com.bumptech.glide.load;

import ai.j0;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int r5) {
        this(j0.g(r5, "Http request failed with status code: "), r5);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String r5) {
        this(r5, -1);
    }

    public HttpException(String r5, int r10) {
        this(r5, r10, null);
    }

    public HttpException(String r5, int r10, @Nullable Throwable r11) {
        super(r5, r11);
        this.statusCode = r10;
    }
}

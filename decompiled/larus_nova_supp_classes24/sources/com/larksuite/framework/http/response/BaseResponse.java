package com.larksuite.framework.http.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 6799379234808041243L;
    private int code;
    private Map<String, String> headers;
    private IResponseBody mResponseBody;

    public interface IResponseBody extends Serializable {
        InputStream byteStream();

        byte[] bytes() throws IOException;

        long contentLength();

        String string() throws IOException;
    }

    public InputStream byteStream() {
        return this.mResponseBody.byteStream();
    }

    public boolean isSuccessful() {
        int r0 = this.code;
        if (r0 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= 300) goto L7;
        return true;
    }

    public String message() throws IOException {
        return this.mResponseBody.string();
    }

    public BaseResponse() {
        this.code = 0;
    }

    public IResponseBody body() {
        return this.mResponseBody;
    }

    public int code() {
        return this.code;
    }

    public Map<String, String> headers() {
        return this.headers;
    }

    public BaseResponse(int r1, IResponseBody r2) {
        this.code = r1;
        this.mResponseBody = r2;
    }

    public BaseResponse(int r1, Map<String, String> r2, IResponseBody r3) {
        this.code = r1;
        this.headers = r2;
        this.mResponseBody = r3;
    }
}

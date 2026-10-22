package com.bytedance.vmsdk.net;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.lynx.jsbridge.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Response {
    private final String TAG;
    private final byte[] body;
    private ReadableMap headers;
    private final String mimeType;
    private final int status;
    private final String url;

    public Response(String r5, int r10, Map r11, InputStream r12, String r13) {
        this.TAG = "Response";
        if (r5 == null) goto L15;
        if (r10 < 200) goto L13;
        this.url = r5;
        this.status = r10;
        this.mimeType = r13;
        this.headers = new JavaOnlyMap(r11);
        if (r12 != null) goto L10;
        this.body = null;
        return;
    L10:
        this.body = getBodyBytesInternal(r12);
        return;
    L13:
        throw new IllegalArgumentException(a.d(r10, "Invalid status code: "));
    L15:
        throw new IllegalArgumentException("url == null");
    }

    private static native long nativeCreateResponse(Response r5);

    @CalledByNative
    public byte[] getBodyBytes() {
        return this.body;
    }

    public byte[] getBodyBytesInternal(InputStream r5) {
        byte[] r10 = new byte[1024];
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: IOException -> L7
    L4:
        int r12 = r5.read(r10, 0, 1024);     // Catch: IOException -> L7
        if (r12 <= 0) goto L9;
        r11.write(r10, 0, r12);     // Catch: IOException -> L7
    L9:
        if (r12 > 0) goto L4;
        return r11.toByteArray();
    L7:
        e = move-exception;
        Log.e("Response", "failed to read response body: " + e.getMessage());
        return null;
    }

    @CalledByNative
    public ReadableMap getHeaders() {
        return this.headers;
    }

    @CalledByNative
    public int getStatusCode() {
        return this.status;
    }

    @CalledByNative
    public String getUrl() {
        return this.url;
    }
}

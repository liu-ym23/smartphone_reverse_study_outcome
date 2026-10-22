package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Request;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static ByteString a(Request r2) {
        Request r3 = r2.newBuilder().build();
        Buffer r0 = new Buffer();
        r3.body().writeTo(r0);     // Catch: IOException -> L5
        return r0.readByteString();
    L5:
        e = move-exception;
        Log.e("lark_http_rust", "error get json body: " + e);
        return null;
    }

    public static SendHttpRequest.Builder b(Request r6) {
        SendHttpRequest.Builder r0 = new SendHttpRequest.Builder();
        SendHttpRequest.Builder r1 = r0.url(r6.url().toString());
        String r2 = r6.method().toLowerCase();
        r2.getClass();
        int r4 = 0;
        byte r5 = -1;
        switch(r2.hashCode()) {
            case -1335458389: goto L22;
            case 102230: goto L18;
            case 111375: goto L14;
            case 3446944: goto L10;
            case 106438728: goto L6;
            default: goto L26;
        };
    L6:
        if (r2.equals("patch") == false) goto L26;
        r5 = 4;
        goto L26
    L10:
        if (r2.equals("post") == false) goto L26;
        r5 = 3;
        goto L26
    L14:
        if (r2.equals("put") == false) goto L26;
        r5 = 2;
        goto L26
    L18:
        if (r2.equals("get") == false) goto L26;
        r5 = 1;
        goto L26
    L22:
        if (r2.equals("delete") == false) goto L26;
        r5 = 0;
    L26:
        switch(r5) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        String r7 = "unsupported method: ".concat(r2);
        Log.e("lark_http_rust", r7);
        throw new IllegalArgumentException(r7);
    L29:
        SendHttpRequest.Method r3 = SendHttpRequest.Method.PATCH;
    L34:
        r1.method(r3);
        if (r6.body() == null) goto L37;
        r0.body(a(r6));
    L38:
        HashMap r8 = new HashMap();
        Headers r9 = r6.headers();
        if (r9 != null) goto L42;
    L44:
        r0.headers(r8);
        return r0;
    L42:
        if (r4 >= r9.size()) goto L44;
        r8.put(r9.name(r4), r9.value(r4));
        r4 = r4 + 1;
        goto L42
    L37:
        Log.i("lark_http_rust", "originBody is null");
        goto L38
    L30:
        r3 = SendHttpRequest.Method.POST;
        goto L34
    L31:
        r3 = SendHttpRequest.Method.PUT;
        goto L34
    L32:
        r3 = SendHttpRequest.Method.GET;
        goto L34
    L33:
        r3 = SendHttpRequest.Method.DELETE;
        goto L34
    }
}

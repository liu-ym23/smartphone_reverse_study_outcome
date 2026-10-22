package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static Response.Builder a(SendHttpResponse r2, Request r3) {
        if (r2 != null) goto L4;
        Log.e("lark_http_rust", "response is null, request is " + r3);
    L4:
        Response.Builder r0 = new Response.Builder();
        r0.request(r3);
        r0.body(ResponseBody.create(MediaType.get("application/json"), ""));
        b(r0, r2.headers, r2.body);
        r0.code(r2.http_status_code.intValue());
        r0.message(r2.unknown_error);
        return r0;
    }

    public static void b(Response.Builder r9, Map<String, String> r10, ByteString r11) {
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r12.hasNext() == false) goto L49;
        Map.Entry<String, String> r3 = r12.next();
        if (r3 == null) goto L4;
        String r5 = r3.getKey().toLowerCase();
        String r4 = r3.getValue();
        r5.getClass();
        byte r8 = -1;
        switch(r5.hashCode()) {
            case 785670158: goto L19;
            case 1467947085: goto L15;
            case 2095084583: goto L11;
            default: goto L22;
        };
    L22:
        switch(r8) {
            case 0: goto L44;
            case 1: goto L28;
            case 2: goto L25;
            default: goto L48;
        };
    L25:
        if ("gzip".equalsIgnoreCase(r4) == false) goto L48;
    L28:
        if (r4.contains("http/1.0") == false) goto L31;
        Protocol r6 = Protocol.HTTP_1_0;
    L43:
        r9.protocol(r6);
        r1 = true;
        goto L48
    L31:
        if (r4.contains("http/1.1") == false) goto L34;
        r6 = Protocol.HTTP_1_1;
        goto L43
    L34:
        if (r4.contains("spdy/3.1") == false) goto L37;
        r6 = Protocol.SPDY_3;
        goto L43
    L37:
        if (r4.contains("h2") == false) goto L40;
        r6 = Protocol.HTTP_2;
        goto L43
    L40:
        if (r4.contains("quic") == false) goto L42;
        r6 = Protocol.QUIC;
        goto L43
    L42:
        Log.d("lark_http_rust", "unknown protocol: ".concat(r4));
        r6 = Protocol.HTTP_1_1;
        goto L43
    L44:
        if (r4 == null) goto L46;
        r9.body(ResponseBody.create(MediaType.parse(r4), r11.toByteArray()));
    L47:
        r2 = true;
        goto L48
    L46:
        Log.w("lark_http_rust", "contentType is null");
    L48:
        r9.addHeader(r5, r4);
        goto L4
    L11:
        if (r5.equals("content-encoding") == false) goto L22;
        r8 = 2;
        goto L22
    L15:
        if (r5.equals("x-protocol") == false) goto L22;
        r8 = 1;
        goto L22
    L19:
        if (r5.equals("content-type") == false) goto L22;
        r8 = 0;
        goto L22
    L49:
        if (r1 == true) goto L51;
        Log.e("lark_http_rust", "Protocol not found, use HTTP/1.0");
        r9.protocol(Protocol.HTTP_1_0);
    L51:
        if (r2 == true) goto L64;
        Log.e("lark_http_rust", "ContentType not found");
        return;
    }
}

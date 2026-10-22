package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements e<UserSendHttpRequest.Builder, UserSendHttpResponse> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final ProtoAdapter<UserSendHttpResponse> c() {
        return UserSendHttpResponse.ADAPTER;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Command getCommand() {
        return Command.USER_SEND_HTTP;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Message.Builder b(Request r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
        int r0 = b.a;
        UserSendHttpRequest.Builder r1 = new UserSendHttpRequest.Builder();
        UserSendHttpRequest.Builder r2 = r1.url(r11.url().toString());
        String r3 = r11.method().toLowerCase();
        r3.getClass();
        int r4 = 0;
        switch(r3.hashCode()) {
            case -1335458389: goto L22;
            case 102230: goto L18;
            case 111375: goto L14;
            case 3446944: goto L10;
            case 106438728: goto L6;
            default: goto L25;
        };
    L25:
        byte r5 = -1;
    L27:
        if (r5 == 0) goto L38;
        if (r5 == 1) goto L37;
        if (r5 == 2) goto L36;
        if (r5 == 3) goto L35;
        if (r5 != 4) goto L33;
        HttpMethod r6 = HttpMethod.PATCH;
    L39:
        r2.method(r6);
        if (r11.body() == null) goto L42;
        r1.body(b.a(r11));
    L43:
        ArrayList r7 = new ArrayList();
        Headers r12 = r11.headers();
        if (r12 != null) goto L46;
    L48:
        r1.headers(new HttpHeaderMap.Builder().headers(r7).build());
        return r1;
    L46:
        if (r4 >= r12.size()) goto L48;
        r7.add(new HttpHeader.Builder().name(r12.name(r4)).value(r12.value(r4)).build());
        r4 = r4 + 1;
        goto L46
    L42:
        Log.i("lark_http_rust", "originBody is null");
        goto L43
    L33:
        String r13 = "unsupported method: ".concat(r3);
        Log.e("lark_http_rust", r13);
        throw new IllegalArgumentException(r13);
    L35:
        r6 = HttpMethod.POST;
        goto L39
    L36:
        r6 = HttpMethod.PUT;
        goto L39
    L37:
        r6 = HttpMethod.GET;
        goto L39
    L38:
        r6 = HttpMethod.DELETE;
        goto L39
    L6:
        if (r3.equals("patch") == false) goto L25;
        r5 = 4;
        goto L27
    L10:
        if (r3.equals("post") == false) goto L25;
        r5 = 3;
        goto L27
    L14:
        if (r3.equals("put") == false) goto L25;
        r5 = 2;
        goto L27
    L18:
        if (r3.equals("get") == false) goto L25;
        r5 = 1;
        goto L27
    L22:
        if (r3.equals("delete") == false) goto L25;
        r5 = 0;
        goto L27
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.e
    public final Response a(Message r6, Request r7) {
        UserSendHttpResponse r8 = (UserSendHttpResponse) r6;
        Intrinsics.checkNotNullParameter(r8, "rustResp");
        Intrinsics.checkNotNullParameter(r7, "request");
        if (r8 != null) goto L5;
        Log.e("lark_http_rust", "response is null, request is " + r7);
    L5:
        Response.Builder r0 = new Response.Builder();
        r0.request(r7);
        r0.body(ResponseBody.create(MediaType.get("application/json"), ""));
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r2 = r8.headers.headers.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        HttpHeader r3 = (HttpHeader) r2.next();
        r9.put(r3.name.toLowerCase(), r3.value);
        goto L7
    L9:
        c.b(r0, r9, r8.body);
        r0.code(r8.status_code.intValue());
        r0.message("");
        return r0.build();
    }
}

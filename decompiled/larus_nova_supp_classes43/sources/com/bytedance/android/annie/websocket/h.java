package com.bytedance.android.annie.websocket;

import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements IMessageReceiveListener {
    public String a;
    public final /* synthetic */ c b;

    public h(g r1) {
        this.b = r1;
    }

    public final void onFeedBackLog(String r10) {
        if (this.b != null) goto L5;
        return;
    L5:
        int r0 = i.a;
        JSONObject r1 = new JSONObject(r10);     // Catch: Exception -> L8
    L9:
        int r11 = r1.optInt("ws_state", -1);
        if (r11 != (-1)) goto L12;
        return;
    L12:
        if (r11 != 0) goto L30;
        if (r1.optBoolean("using_quic") == false) goto L16;
        String r12 = "quic";
    L40:
        JSONObject r13 = new JSONObject(this.a);     // Catch: Exception -> L20
    L21:
        String r14 = r1.optString("response_header");
        Intrinsics.checkNotNullParameter(r13, "jsonOb");
        r13.put("__MP_RESP_HEADER", r14);     // Catch: Exception -> L33
    L23:
        int r15 = i.a;
        Intrinsics.checkNotNullParameter(r13, "jsonOb");
        r13.put("__MP_TRANSPORT_PROTOCOL", r12);     // Catch: Exception -> L34
    L25:
        int r16 = i.a;
        Intrinsics.checkNotNullParameter(r13, "jsonOb");
        r13.put("__MP_LOG", r1);     // Catch: JSONException -> L35
    L27:
        this.b.c(4, r13.toString());
        return;
    L20:
        r13 = new JSONObject();
        goto L21
    L16:
        r12 = "tcp";
        goto L40
    L30:
        if (r11 != 1) goto L46;
        String r17 = r1.optString("ws_error");
        this.b.c(3, r17);
        return;
    L46:
        return;
    L8:
        r1 = new JSONObject();
        goto L9
    }

    public final void onMessage(byte[] r10, int r11) {
        c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onMessage(r10, r11);
    }

    public final void onConnection(int r1, String r10, JSONObject r11) {
        if (this.b != null) goto L5;
        return;
    L5:
        if (r11 == null) goto L8;
        String r12 = r11.toString();
        if (r12 == null) goto L8;
    L10:
        if (r1 != 4) goto L12;
    L18:
        this.a = r12;
        return;
    L12:
        if (r1 == 3) goto L18;
        if (r1 == 2) goto L18;
        this.b.c(r1, r12);
        return;
    L8:
        r12 = "{}";
        goto L10
    }
}

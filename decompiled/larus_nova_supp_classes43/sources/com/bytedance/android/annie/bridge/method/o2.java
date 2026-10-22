package com.bytedance.android.annie.bridge.method;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o2 implements com.bytedance.android.annie.websocket.d {
    public final CallContext a;

    public final CallContext getContext() {
        return this.a;
    }

    public o2(CallContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
    }

    @Override // com.bytedance.android.annie.websocket.d
    public final void a(com.bytedance.android.annie.websocket.e r10) {
        Intrinsics.checkNotNullParameter(r10, "requestState");
        String r0 = r10.a;
        switch(r0.hashCode()) {
            case -1987107780: goto L18;
            case -1357520532: goto L14;
            case -1281977283: goto L10;
            case -579210487: goto L6;
            default: goto L31;
        };
    L31:
        return;
    L6:
        if (r0.equals("connected") == false) goto L32;
        JSONObject r1 = new JSONObject();
        r1.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "connected");
        r1.put("socketTaskID", r10.b);
        this.a.b("socketStatusChanged", r1);
        return;
    L32:
        return;
    L10:
        if (r0.equals(MessageIndication.STATUS_FAILED) == false) goto L33;
        JSONObject r11 = new JSONObject();
        r11.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, MessageIndication.STATUS_FAILED);
        r11.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r10.c);
        r11.put("socketTaskID", r10.b);
        this.a.b("socketStatusChanged", r11);
        return;
    L33:
        return;
    L14:
        if (r0.equals("closed") == false) goto L34;
        JSONObject r12 = new JSONObject();
        r12.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "closed");
        r12.put("socketTaskID", r10.b);
        this.a.b("socketStatusChanged", r12);
        return;
    L34:
        return;
    L18:
        if (r0.equals("onMessaged") == false) goto L35;
        JSONObject r13 = new JSONObject();
        r13.put("socketTaskID", r10.b);
        String r14 = r10.d;
        if (r14 == null) goto L23;
        r13.put("data", r14);
    L23:
        String r15 = r10.e;
        if (r15 == null) goto L26;
        r13.put("dataType", r15);
    L26:
        this.a.b("socketDataReceived", r13);
        return;
    }
}

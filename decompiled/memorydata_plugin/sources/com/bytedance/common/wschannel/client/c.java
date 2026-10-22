package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, d> f2090b;

    public interface a {
        void a(int r1, ConnectionState r2, boolean r3);

        void a(com.bytedance.common.wschannel.event.a r1, JSONObject r2);

        void a(ServiceConnectEvent r1);

        void a(WsChannelMsg r1);

        void a(WsChannelMsg r1, boolean r2);

        void a(String r1, boolean r2);
    }

    public c(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super(r5);
        HashMap r0 = new HashMap();
        r0.put(WsConstants.RECEIVE_CONNECTION_ACTION, new e(r5));
        r0.put(WsConstants.SYNC_CONNECT_STATE, new j(r5));
        r0.put(WsConstants.RECEIVE_PROGRESS_ACTION, new g(r5));
        r0.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new f(r5));
        r0.put(WsConstants.SEND_PAYLOAD_ACTION, new i(r5));
        r0.put(WsConstants.RECEIVE_SERVICE_ACTION, new h(r5));
        this.f2090b = Collections.unmodifiableMap(r0);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r4, com.bytedance.common.wschannel.model.a r5) {
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.f2090b.get(r4.getAction()), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        r3.a(r4, r5);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d("AbsWsClientService", "count = " + r4.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L17:
        return;
    L6:
        Logger.e("error action!");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Logger.e("AbsWsClientService", th.toString());
        goto L11
    }
}

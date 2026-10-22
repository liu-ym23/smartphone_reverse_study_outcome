package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u1.d f1309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u1.c f1310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u1.e f1311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f1312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Boolean> f1313e;

    public int a() {
        throw null;
    }

    void b(WsChannelMsg r10) {
        if (this.f1309a == null) goto L9;
        if (r10.isAckMsg() == true) goto L9;
        this.f1309a.c(r10);
        return;
    L9:
        if (this.f1310b != null) goto L11;
        return;
    L11:
        if (r10.isAckMsg() == false) goto L15;
        MessageAckEvent r11 = new MessageAckEvent(r10.getUUID(), r10.getChannelId(), r10.getService(), r10.getMethod(), r10.getLogInfo());
        r11.a(r10.getState());
        this.f1310b.a(r11);
        return;
    }

    void c(com.bytedance.common.wschannel.event.a r10, JSONObject r11) {
        u1.d r12 = this.f1309a;
        if (r12 == null) goto L6;
        r12.b(r10, r11);
    L6:
        if (r10.f1304b == ConnectionState.CONNECT_CLOSED) goto L8;
        return;
    L8:
        if (this.f1312d.get() == false) goto L12;
        k.f(a());
        return;
    }

    void d(ServiceConnectEvent r10) {
        u1.e r11 = this.f1311c;
        if (r11 == null) goto L6;
        r11.b(r10);
        return;
    }

    void e(WsChannelMsg r10, boolean r11) {
        if ((r10 instanceof MainProcessMsg) == false) goto L8;
        MainProcessMsg r12 = (MainProcessMsg) r10;
        WsChannelMsg r13 = r12.getOrigin();
        f r14 = r12.getListener();
        if (r14 == null) goto L9;
        r14.a(r13, r11);
        return;
    L9:
        return;
    }

    void f(ServiceConnectEvent r10) {
        this.f1313e.put(Integer.valueOf(r10.getServiceId()), Boolean.valueOf(r10.isServiceConnected()));
    }

    void g(ConnectionState r10, boolean r11) {
    }
}

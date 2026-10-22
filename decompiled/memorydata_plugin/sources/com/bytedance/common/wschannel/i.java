package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.common.wschannel.app.d f2126b;
    private final com.bytedance.common.wschannel.app.c c;
    private final com.bytedance.common.wschannel.app.e d;
    private ConnectionState e;
    private AtomicBoolean f;
    private ConcurrentHashMap<Integer, Boolean> g;
    private boolean h;

    public int a() {
        return this.f2125a.f2001a;
    }

    void a(ConnectionState r1, boolean r2) {
        this.e = r1;
        this.h = r2;
    }

    void a(com.bytedance.common.wschannel.event.a r2, JSONObject r3) {
        com.bytedance.common.wschannel.app.d r0 = this.f2126b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
    L6:
        if (r2.f2111b == ConnectionState.CONNECT_CLOSED) goto L8;
        return;
    L8:
        if (this.f.get() == false) goto L12;
        k.b(a());
        return;
    }

    void a(ServiceConnectEvent r1) {
        com.bytedance.common.wschannel.app.e r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    void a(WsChannelMsg r8) {
        if (this.f2126b == null) goto L9;
        if (r8.isAckMsg() == true) goto L9;
        this.f2126b.a(r8);
        return;
    L9:
        if (this.c != null) goto L11;
        return;
    L11:
        if (r8.isAckMsg() == false) goto L15;
        MessageAckEvent r0 = new MessageAckEvent(r8.getUUID(), r8.getChannelId(), r8.getService(), r8.getMethod(), r8.getLogInfo());
        r0.a(r8.getState());
        this.c.a(r0);
        return;
    }

    void a(WsChannelMsg r3, boolean r4) {
        if (ZeusTransformUtils.instanceOf(r3, MainProcessMsg.class) == false) goto L8;
        WsChannelMsg r2 = ((MainProcessMsg) ZeusTransformUtils.preCheckCast(r3, MainProcessMsg.class, "com.obric.memorydata.plugin")).getOrigin();
        g r5 = ((MainProcessMsg) ZeusTransformUtils.preCheckCast(r3, MainProcessMsg.class, "com.obric.memorydata.plugin")).getListener();
        if (r5 == null) goto L9;
        r5.a(r2, r4);
        return;
    L9:
        return;
    }

    void b(ServiceConnectEvent r2) {
        this.g.put(Integer.valueOf(r2.getServiceId()), Boolean.valueOf(r2.isServiceConnected()));
    }
}

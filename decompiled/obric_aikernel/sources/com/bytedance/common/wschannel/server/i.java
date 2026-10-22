package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i implements v1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f1436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z1.c.a f1437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z1.c f1438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f1439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f1440f;

    i(Context r10, a r11) {
        com.bytedance.common.wschannel.d r12 = new com.bytedance.common.wschannel.d();
        this.f1437c = r12;
        this.f1438d = new z1.c(r12);
        this.f1440f = new AtomicInteger(0);
        this.f1435a = r10;
        this.f1436b = r11;
    }

    private long i() {
        return 0;
    }

    @WorkerThread
    private void j(WsChannelService.b r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.f1372b != null) goto L9;
        if (r12.f1374d != null) goto L9;
        return;
    L9:
        if (r12.f1374d == null) goto L11;
        boolean r10 = true;
    L54:
        long r11 = i();     // Catch: Throwable -> L48
        if (r10 == false) goto L16;
        WsChannelMsg r13 = r12.f1374d;     // Catch: Throwable -> L48
    L20:
        long r14 = i();     // Catch: Throwable -> L48
        if (r13 != WsChannelMsg.EMPTY) goto L23;
        return;
    L23:
        if (d.m(r13) == true) goto L65;
        r13.setNewMsgTimeHolder(new NewMsgTimeHolder(r12.f1373c, r11, r14));     // Catch: Throwable -> L48
        r13.setChannelId(r12.f1371a);     // Catch: Throwable -> L48
        r13.setReplayToComponentName(new ComponentName(this.f1435a, WsChannelService.class));     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L28;
        Logger.d("WsChannelService", "version =  seqId = " + r13.getSeqId() + " logId = " + r13.getLogId() + " wsChannelMsg = " + r13.toString());     // Catch: Throwable -> L48
    L28:
        Map<Integer, IWsApp> r15 = this.f1436b.f1375a;     // Catch: Throwable -> L48
        if (r15 != null) goto L31;
        return;
    L31:
        if (r15.size() <= 0) goto L67;
        Iterator<Map.Entry<Integer, IWsApp>> r16 = this.f1436b.f1375a.entrySet().iterator();     // Catch: Throwable -> L48
    L34:
        if (r16.hasNext() == false) goto L71;
        IWsApp r17 = r16.next().getValue();     // Catch: Throwable -> L48
        if (r17 == null) goto L34;
        if (r17.getChannelId() != r13.getChannelId()) goto L34;
        Intent r18 = new Intent();     // Catch: Throwable -> L48
        r18.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L48
        r18.putExtra(WsConstants.KEY_PAYLOAD, r13);     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L45;
        r18.putExtra(WsConstants.MSG_COUNT, this.f1440f.addAndGet(1));     // Catch: Throwable -> L48
    L45:
        this.f1438d.a(r18, null);     // Catch: Throwable -> L48
        goto L34
    L71:
        return;
    L67:
        return;
    L65:
        return;
    L16:
        byte[] r19 = r12.f1372b;     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L19;
        Logger.d("WsChannelService", "data = " + g2.c.a(r19) + " data.length = " + r19.length);     // Catch: Throwable -> L48
    L19:
        r13 = a2.b.a().a(r19);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L52;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L52:
        th.printStackTrace();
        return;
    L11:
        r10 = false;
        goto L54
    }

    private void l(IWsChannelClient r10) {
        if (com.bytedance.common.wschannel.l.f(this.f1435a).j() == true) goto L5;
        return;
    L5:
        this.f1439e.t(r10);
    }

    @Override // v1.a
    public void a(WsChannelMsg r10, boolean r11) {
        this.f1437c.a(r10, r11);
    }

    @Override // v1.a
    public void b(ServiceConnectEvent r10) {
        Intent r11 = new Intent();     // Catch: Throwable -> L4
        r11.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r11.putExtra("service", r10);     // Catch: Throwable -> L4
        this.f1438d.a(r11, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // v1.a
    public void c() {
    }

    @Override // v1.a
    public void d(IWsChannelClient r10, int r11, JSONObject r12) {
        if (r12 != null) goto L10;
        return;
    L10:
        r12.put(WsConstants.KEY_CHANNEL_ID, r11);     // Catch: JSONException -> L6
    L8:
        h(r10, SocketState.fromJson(r12));
        l(r10);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // v1.a
    public void e() {
        Intent r10 = new Intent();
        r10.setAction(WsConstants.SYNC_CONNECT_STATE);
        r10.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f1436b.f1377c.values()));
        this.f1438d.a(r10, null);
    }

    @Override // v1.a
    public void f(int r10, byte[] r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        j(new WsChannelService.b(r10, r11, 0));
    }

    @Override // v1.a
    public void g(int r10, WsChannelMsg r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        j(new WsChannelService.b(r10, r11, 0));
    }

    @Override // v1.a
    public void h(IWsChannelClient r10, SocketState r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.f1436b.f1377c.put(Integer.valueOf(r11.getChannelId()), r11);
        Intent r12 = new Intent();     // Catch: Throwable -> L7
        r12.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r12.putExtra(WsConstants.KEY_CONNECTION, r11);     // Catch: Throwable -> L7
        this.f1438d.a(r12, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    void k(b r10) {
        this.f1439e = r10;
    }
}

package com.bytedance.common.wschannel.server;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class l implements v1.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static AtomicBoolean f1448j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.common.wschannel.server.a f1450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f1451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f1453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BlockingQueue<WsChannelService.b> f1454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExecutorService f1455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f1456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Future<?> f1457i;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f1458c;

        a(l r10) {
            this.f1458c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("MessageDispatcher");     // Catch: Throwable -> L11
        L3:
            Thread.currentThread();     // Catch: Throwable -> L11
            if (Thread.interrupted() == true) goto L13;
            l.i().getAndSet(true);     // Catch: Throwable -> L11
            WsChannelService.b r10 = (WsChannelService.b) l.j(this.f1458c).take();     // Catch: Throwable -> L11
            l.k(this.f1458c, r10);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L11
        L13:
            l.i().getAndSet(false);
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
            goto L13
        }
    }

    static {
        f1448j = new AtomicBoolean(true);
    }

    l(Context r10, com.bytedance.common.wschannel.server.a r11) {
        this.f1454f = new LinkedBlockingQueue();
        this.f1455g = Executors.newSingleThreadExecutor();
        this.f1456h = l();
        this.f1449a = r10;
        this.f1450b = r11;
        this.f1451c = new c(r10, WsClientService.class);
        this.f1452d = true;
        p();
    }

    static /* synthetic */ AtomicBoolean i() {
        return f1448j;
    }

    static /* synthetic */ BlockingQueue j(l r10) {
        return r10.f1454f;
    }

    static /* synthetic */ void k(l r10, WsChannelService.b r11) {
        r10.n(r11);
    }

    @WorkerThread
    private Runnable l() {
        return new a(this);
    }

    private long m() {
        if (this.f1452d == true) goto L5;
        return 0;
    L5:
        return g2.b.a();
    }

    @WorkerThread
    private void n(WsChannelService.b r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.f1372b != null) goto L10;
        if (r11.f1374d != null) goto L10;
        return;
    L10:
        if (r11.f1374d == null) goto L12;
        boolean r10 = true;
    L58:
        long r12 = m();     // Catch: Throwable -> L52
        if (r10 == false) goto L17;
        WsChannelMsg r13 = r11.f1374d;     // Catch: Throwable -> L52
    L21:
        long r14 = m();     // Catch: Throwable -> L52
        if (r13 != WsChannelMsg.EMPTY) goto L24;
    L50:
        Logger.e("WsChannelService", "handleMessage decode msg is EMPTY!");     // Catch: Throwable -> L52
        return;
    L24:
        if (d.m(r13) == true) goto L50;
        r13.setNewMsgTimeHolder(new NewMsgTimeHolder(r11.f1373c, r12, r14));     // Catch: Throwable -> L52
        r13.setChannelId(r11.f1371a);     // Catch: Throwable -> L52
        r13.setReplayToComponentName(new ComponentName(this.f1449a, WsChannelService.class));     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "version =  seqId = " + r13.getSeqId() + " logId = " + r13.getLogId() + " wsChannelMsg = " + r13.toString());     // Catch: Throwable -> L52
    L29:
        Map<Integer, IWsApp> r15 = this.f1450b.f1375a;     // Catch: Throwable -> L52
        if (r15 != null) goto L32;
    L48:
        Logger.e("WsChannelService", "mKeeper.mWsAppMap is empty!");     // Catch: Throwable -> L52
        return;
    L32:
        if (r15.size() <= 0) goto L48;
        Iterator<Map.Entry<Integer, IWsApp>> r16 = this.f1450b.f1375a.entrySet().iterator();     // Catch: Throwable -> L52
    L36:
        if (r16.hasNext() == false) goto L68;
        IWsApp r17 = r16.next().getValue();     // Catch: Throwable -> L52
        if (r17 == null) goto L39;
        if (r17.getChannelId() != r13.getChannelId()) goto L36;
        Intent r18 = new Intent();     // Catch: Throwable -> L46
        r18.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L46
        r18.setComponent(new ComponentName(this.f1449a, WsClientService.class));     // Catch: Throwable -> L46
        r18.putExtra(WsConstants.KEY_PAYLOAD, r13);     // Catch: Throwable -> L46
        q(r18);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        String r19 = "deliver fail,reason:" + th;     // Catch: Throwable -> L52
    L40:
        Logger.e("WsChannelService", r19);     // Catch: Throwable -> L52
        goto L36
    L39:
        r19 = "wsApp is null!";
        goto L40
    L68:
        return;
    L17:
        byte[] r20 = r11.f1372b;     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "data = " + g2.c.a(r20) + " data.length = " + r20.length);     // Catch: Throwable -> L52
    L20:
        r13 = a2.b.a().a(r20);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L56;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L56:
        th.printStackTrace();
        return;
    L12:
        r10 = false;
        goto L58
    }

    private void p() {
        if (this.f1456h != null) goto L10;
        this.f1456h = l();
    L10:
        this.f1457i = this.f1455g.submit(this.f1456h);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @SuppressLint({"NewApi"})
    private void q(Intent r10) {
        this.f1451c.b(r10);
    }

    private void r(IWsChannelClient r10) {
        if (com.bytedance.common.wschannel.l.f(this.f1449a).j() == true) goto L5;
        return;
    L5:
        this.f1453e.t(r10);
    }

    @Override // v1.a
    public void a(WsChannelMsg r10, boolean r11) {
        ComponentName r12 = r10.getReplayToComponentName();
        if (r12 == null) goto L17;
        byte[] r13 = r10.getPayload();     // Catch: Throwable -> L12
        if (r13 != null) goto L7;
        r13 = new byte[1];     // Catch: Throwable -> L12
    L7:
        Intent r14 = new Intent();     // Catch: Throwable -> L12
        r14.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L12
        r14.setComponent(r12);     // Catch: Throwable -> L12
        r14.putExtra(WsConstants.KEY_SEND_RESULT, r11);     // Catch: Throwable -> L12
        r14.putExtra(WsConstants.KEY_PAYLOAD_MD5, com.bytedance.common.utility.a.b(r13));     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelService", "send result = " + r11 + " payloadMd5 = " + r14.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L12
    L10:
        this.f1449a.startService(r14);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // v1.a
    public void b(ServiceConnectEvent r10) {
        Intent r11 = new Intent();     // Catch: Throwable -> L4
        r11.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r11.setComponent(new ComponentName(this.f1449a, WsClientService.class));     // Catch: Throwable -> L4
        r11.putExtra("service", r10);     // Catch: Throwable -> L4
        q(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // v1.a
    public void c() {
        this.f1451c.c();
    }

    @Override // v1.a
    public void d(IWsChannelClient r10, int r11, JSONObject r12) {
        if (r12 != null) goto L12;
        return;
    L12:
        r12.put(WsConstants.KEY_CHANNEL_ID, r11);     // Catch: JSONException -> L6
    L8:
        SocketState r13 = SocketState.fromJson(r12);
        h(r10, r13);
        r(r10);
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelService", "onConnection: state=" + r13.connectionState + " | type=" + r13.connectionType + " | error=" + r13.error);
        return;
    L14:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // v1.a
    public void e() {
        Intent r10 = new Intent();     // Catch: Throwable -> L4
        r10.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r10.setComponent(new ComponentName(this.f1449a, WsClientService.class));     // Catch: Throwable -> L4
        r10.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f1450b.f1377c.values()));     // Catch: Throwable -> L4
        q(r10);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // v1.a
    public void f(int r10, byte[] r11) {
        if (r11 != null) goto L9;
        return;
    L9:
        WsChannelService.b r12 = new WsChannelService.b(r10, r11, m());     // Catch: Throwable -> L6
        this.f1454f.offer(r12);     // Catch: Throwable -> L6
        f1448j.getAndSet(true);     // Catch: Throwable -> L6
        p();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // v1.a
    public void g(int r10, WsChannelMsg r11) {
        if (r11 != null) goto L9;
        return;
    L9:
        WsChannelService.b r12 = new WsChannelService.b(r10, r11, m());     // Catch: Throwable -> L6
        this.f1454f.offer(r12);     // Catch: Throwable -> L6
        f1448j.getAndSet(true);     // Catch: Throwable -> L6
        p();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // v1.a
    public void h(IWsChannelClient r10, SocketState r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.f1450b.f1377c.put(Integer.valueOf(r11.getChannelId()), r11);
        Intent r12 = new Intent();     // Catch: Throwable -> L7
        r12.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r12.setComponent(new ComponentName(this.f1449a, WsClientService.class));     // Catch: Throwable -> L7
        r12.putExtra(WsConstants.KEY_CONNECTION, r11);     // Catch: Throwable -> L7
        q(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    void o(b r10) {
        this.f1453e = r10;
    }
}

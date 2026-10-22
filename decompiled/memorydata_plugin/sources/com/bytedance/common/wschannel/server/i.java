package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.bytedance.common.wschannel.channel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2187b;
    private com.bytedance.common.wschannel.client.c.a c;
    private com.bytedance.common.wschannel.client.c d;
    private b e;
    private final AtomicInteger f;
    private final boolean g;

    i(Context r4, a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.c = new com.bytedance.common.wschannel.e();
        this.d = new com.bytedance.common.wschannel.client.c(this.c);
        this.f = new AtomicInteger(0);
        this.g = false;
        this.f2186a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.f2187b = r5;
    }

    private void a(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.wschannel.l.a(this.f2186a).h() == true) goto L5;
        return;
    L5:
        this.e.a(r4);
    }

    private void a(WsChannelService.a r13) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.f2152b != null) goto L10;
        if (r13.d != null) goto L10;
        return;
    L10:
        if (r13.d == null) goto L12;
        boolean r1 = true;
    L55:
        long r6 = c();     // Catch: Throwable -> L49
        if (r1 == false) goto L17;
        WsChannelMsg r2 = r13.d;     // Catch: Throwable -> L49
    L21:
        long r8 = c();     // Catch: Throwable -> L49
        if (r2 != WsChannelMsg.EMPTY) goto L24;
        return;
    L24:
        if (d.a(r2) == true) goto L66;
        r2.setNewMsgTimeHolder(new NewMsgTimeHolder(r13.c, r6, r8));     // Catch: Throwable -> L49
        r2.setChannelId(r13.f2151a);     // Catch: Throwable -> L49
        r2.setReplayToComponentName(new ComponentName(this.f2186a, WsChannelService.class));     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "version =  seqId = " + r2.getSeqId() + " logId = " + r2.getLogId() + " wsChannelMsg = " + r2.toString());     // Catch: Throwable -> L49
    L30:
        if (this.f2187b.f2153a != null) goto L32;
        return;
    L32:
        if (this.f2187b.f2153a.size() <= 0) goto L68;
        Iterator<Map.Entry<Integer, IWsApp>> r14 = this.f2187b.f2153a.entrySet().iterator();     // Catch: Throwable -> L49
    L35:
        if (r14.hasNext() == false) goto L72;
        IWsApp r3 = (IWsApp) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), IWsApp.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        if (r3 == null) goto L35;
        if (r3.getChannelId() != r2.getChannelId()) goto L35;
        Intent r4 = new Intent();     // Catch: Throwable -> L49
        r4.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L49
        r4.putExtra("payload", r2);     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L46;
        r4.putExtra(WsConstants.MSG_COUNT, this.f.addAndGet(1));     // Catch: Throwable -> L49
    L46:
        this.d.a(r4, null);     // Catch: Throwable -> L49
        goto L35
    L72:
        return;
    L68:
        return;
    L66:
        return;
    L17:
        byte[] r5 = r13.f2152b;     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "data = " + com.bytedance.common.wschannel.c.c.a(r5) + " data.length = " + r5.length);     // Catch: Throwable -> L49
    L20:
        r2 = com.bytedance.common.wschannel.a.b.a().a(r5);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, ProtocolException.class) == false) goto L53;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L53:
        th.printStackTrace();
        return;
    L12:
        r1 = false;
        goto L55
    }

    private long c() {
        return 0;
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a() {
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        a(new WsChannelService.a(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(int r4, byte[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        a(new WsChannelService.a(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(IWsChannelClient r3, int r4, JSONObject r5) {
        IWsChannelClient r6 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L11;
        return;
    L11:
        r5.put(WsConstants.KEY_CHANNEL_ID, r4);     // Catch: JSONException -> L7
    L9:
        a(r6, SocketState.fromJson(r5));
        a(r6);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(IWsChannelClient r3, SocketState r4) {
        IWsChannelClient r5 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.f2187b.c.put(Integer.valueOf(r4.getChannelId()), r4);
        Intent r6 = new Intent();     // Catch: Throwable -> L8
        r6.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L8
        r6.putExtra(WsConstants.KEY_CONNECTION, r4);     // Catch: Throwable -> L8
        this.d.a(r6, null);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(ServiceConnectEvent r3) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.putExtra("service", r3);     // Catch: Throwable -> L4
        this.d.a(r0, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(WsChannelMsg r1, boolean r2) {
        this.c.a(r1, r2);
    }

    void a(b r1) {
        this.e = r1;
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void b() {
        Intent r0 = new Intent();
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f2187b.c.values()));
        this.d.a(r0, null);
    }
}

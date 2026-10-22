package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b implements y5.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f3930h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, SocketState> f3932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, IWsApp> f3933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j6.b f3934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue f3935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExecutorService f3936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f3937g;

    static {
        f3930h = new AtomicBoolean(true);
    }

    public b(Context r8, ConcurrentHashMap r10, ConcurrentHashMap r11) {
        this.f3935e = new LinkedBlockingQueue();
        ExecutorService r12 = Executors.newSingleThreadExecutor();
        this.f3936f = r12;
        this.f3937g = new a(this);
        this.f3931a = r8;
        this.f3932b = r10;
        this.f3933c = r11;
        this.f3934d = new j6.b(r8);
        if (this.f3937g != null) goto L10;
        this.f3937g = new a(this);
    L10:
        r12.submit(this.f3937g);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(b r8, WsChannelService.a r10) {
        Context r11 = r8.f3931a;
        if (r10 == null) goto L54;
        byte[] r12 = r10.f3928b;
        if (r12 == null) goto L59;
    L36:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L40;
        Logger.e("WsChannelSdk", "不支持的消息协议，忽略此消息");
        return;
    L40:
        th.printStackTrace();
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelService", "data = " + k6.a.a(r12) + " data.length = " + r12.length);     // Catch: Throwable -> L36
    L11:
        WsChannelMsg r13 = l6.a.f9135d.a(r12);     // Catch: Throwable -> L36
        if (r13 == WsChannelMsg.f3903u) goto L55;
        r13.f3913t = r10.f3927a;     // Catch: Throwable -> L36
        r13.f3912s = new ComponentName(r11, WsChannelService.class);     // Catch: Throwable -> L36
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelService", "version =  seqId = " + r13.f3904a + " logId = " + r13.f3905b + " wsChannelMsg = " + r13.toString());     // Catch: Throwable -> L36
    L17:
        Map<Integer, IWsApp> r14 = r8.f3933c;
        if (r14 != null) goto L20;
        return;
    L20:
        if (r14.size() <= 0) goto L57;
        Iterator<Map.Entry<Integer, IWsApp>> r15 = r14.entrySet().iterator();     // Catch: Throwable -> L36
    L23:
        if (r15.hasNext() == false) goto L60;
        IWsApp r16 = r15.next().getValue();     // Catch: Throwable -> L36
        if (r16 == null) goto L23;
        if (r16.k() != r13.f3913t) goto L23;
        Intent r17 = new Intent();     // Catch: Throwable -> L33
        r17.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L33
        r17.setComponent(new ComponentName(r11, WsClientService.class));     // Catch: Throwable -> L33
        r17.putExtra(WsConstants.KEY_PAYLOAD, r13);     // Catch: Throwable -> L33
        r8.f3934d.f8703a.a(r17);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L23
    L60:
        return;
    L57:
        return;
    L55:
        return;
    L59:
        return;
    }

    public final void b(SocketState r8) {
        Integer r10 = Integer.valueOf(r8.f3887n);
        this.f3932b.put(r10, r8);
        Intent r11 = new Intent();     // Catch: Throwable -> L5
        r11.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L5
        r11.setComponent(new ComponentName(this.f3931a, WsClientService.class));     // Catch: Throwable -> L5
        r11.putExtra(WsConstants.KEY_CONNECTION, r8);     // Catch: Throwable -> L5
        this.f3934d.f8703a.a(r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public final void c() {
        Intent r8 = new Intent();     // Catch: Throwable -> L4
        r8.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r8.setComponent(new ComponentName(this.f3931a, WsClientService.class));     // Catch: Throwable -> L4
        r8.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f3932b.values()));     // Catch: Throwable -> L4
        this.f3934d.f8703a.a(r8);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}

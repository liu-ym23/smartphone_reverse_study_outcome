package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class b implements WeakHandler.IHandler, f.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHandler f1378c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f1379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f1380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f1381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final v1.a f1382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.common.wschannel.server.a f1383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicLong f1384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private f f1385m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1386n;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f1387c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f1388g;

        a(b r10, f r11) {
            this.f1388g = r10;
            this.f1387c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1387c.a();
            b r10 = this.f1388g;
            b.c(r10, b.b(r10).a());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.b$b, reason: collision with other inner class name */
    class RunnableC0046b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Message f1389c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f1390g;

        RunnableC0046b(b r10, Message r11) {
            this.f1390g = r10;
            this.f1389c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1389c.what != 1) goto L5;
        L7:
            b.e(this.f1390g, this.f1389c);
            return;
        L5:
            if (b.d(this.f1390g).isEnable() == true) goto L7;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IWsChannelClient f1391c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f1392g;

        c(b r10, IWsChannelClient r11) {
            this.f1392g = r10;
            this.f1391c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.f(this.f1392g, this.f1391c);
        }
    }

    b(Context r10, Looper r11, g r12, com.bytedance.common.wschannel.server.a r13, v1.a r14, f r15) {
        this.f1380h = new Object();
        this.f1384l = new AtomicLong(0);
        this.f1386n = false;
        this.f1379g = r10.getApplicationContext();
        this.f1378c = new WeakHandler(r11, this);
        this.f1381i = r12;
        this.f1383k = r13;
        this.f1382j = r14;
        this.f1385m = r15;
        r15.b(this);
        p(new a(this, r15));
    }

    static /* synthetic */ g b(b r10) {
        return r10.f1381i;
    }

    static /* synthetic */ void c(b r10, Map r11) {
        r10.v(r11);
    }

    static /* synthetic */ f d(b r10) {
        return r10.f1385m;
    }

    static /* synthetic */ void e(b r10, Message r11) {
        r10.h(r11);
    }

    static /* synthetic */ void f(b r10, IWsChannelClient r11) {
        r10.r(r11);
    }

    private void h(Message r11) {
        int r10 = r11.what;     // Catch: Throwable -> L134
        if (r10 == 0) goto L130;
        boolean r12 = true;
        if (r10 == 1) goto L107;
        boolean r13 = false;
        if (r10 != 2) goto L9;
        int r14 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "appState = " + r14);     // Catch: Throwable -> L134
    L96:
        if (r14 == 1) goto L99;
        r12 = false;
    L99:
        this.f1386n = r12;     // Catch: Throwable -> L134
        this.f1382j.c();     // Catch: Throwable -> L134
        if (l() == false) goto L166;
        q(this.f1383k.f1376b.values());     // Catch: Throwable -> L134
        Iterator<IWsChannelClient> r15 = this.f1383k.f1376b.values().iterator();     // Catch: Throwable -> L134
    L103:
        if (r15.hasNext() == false) goto L172;
        IWsChannelClient r16 = r15.next();     // Catch: Throwable -> L134
        if (r16 == null) goto L103;
        r16.onAppStateChanged(r14);     // Catch: Throwable -> L134
        goto L103
    L172:
        return;
    L166:
        return;
    L9:
        if (r10 != 3) goto L11;
        int r17 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L85;
        Logger.d("WsChannelService", "networkState = " + r17);     // Catch: Throwable -> L134
    L85:
        this.f1382j.c();     // Catch: Throwable -> L134
        if (l() == false) goto L165;
        Iterator<IWsChannelClient> r18 = this.f1383k.f1376b.values().iterator();     // Catch: Throwable -> L134
    L89:
        if (r18.hasNext() == false) goto L171;
        IWsChannelClient r19 = r18.next();     // Catch: Throwable -> L134
        if (r19 == null) goto L89;
        r19.onNetworkStateChanged(r17);     // Catch: Throwable -> L134
        goto L89
    L171:
        return;
    L165:
        return;
    L11:
        if (r10 != 4) goto L13;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r110 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r110 instanceof IWsApp) == false) goto L163;
        i((IWsApp) r110);     // Catch: Throwable -> L134
        return;
    L163:
        return;
    L13:
        if (r10 != 5) goto L15;
    L39:
        if (r10 == 10) goto L42;
        r12 = false;
    L42:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r20 = r11.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L134
        if ((r20 instanceof WsChannelMsg) == false) goto L160;
        WsChannelMsg r21 = (WsChannelMsg) r20;     // Catch: Throwable -> L134
        if (r21.getSeqId() > 0) goto L47;
        r21.setSeqId(this.f1384l.incrementAndGet());     // Catch: Throwable -> L134
    L47:
        IWsChannelClient r22 = this.f1383k.f1376b.get(Integer.valueOf(r21.getChannelId()));     // Catch: Throwable -> L134
        if (r12 == false) goto L50;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L134
    L50:
        if (r22 == null) goto L75;
        if (r10 == 10) goto L58;
        if ((r22 instanceof v1.b) == false) goto L58;
        if (((v1.b) r22).b() == false) goto L58;
        r21 = u(r22, r21);     // Catch: Throwable -> L134
    L58:
        if (r22.privateProtocolEnabled() == true) goto L60;
    L62:
        boolean r23 = r22.sendMessage(a2.b.a().b(r21));     // Catch: Throwable -> L134
    L63:
        r13 = r23;
        long r24 = com.bytedance.common.wschannel.l.f(this.f1379g).c();     // Catch: Throwable -> L134
        if (r13 == true) goto L69;
        if (r12 == true) goto L69;
        if (r24 <= 0) goto L69;
        Message r111 = Message.obtain(r11);     // Catch: Throwable -> L134
        r111.what = 10;     // Catch: Throwable -> L134
        this.f1378c.sendMessageDelayed(r111, r24);     // Catch: Throwable -> L134
    L69:
        if (r13 == false) goto L71;
    L73:
        v1.a r112 = this.f1382j;     // Catch: Throwable -> L134
    L74:
        r112.a(r21, r13);     // Catch: Throwable -> L134
    L77:
        if (Logger.debug() == false) goto L161;
        Logger.d("WsChannelService", "send payload success = " + r13);     // Catch: Throwable -> L134
        return;
    L161:
        return;
    L71:
        if (r24 <= 0) goto L73;
        if (r12 == false) goto L77;
    L60:
        if (r22.privateProtocolProxyEnabled() == true) goto L62;
        r23 = r22.sendMessage(r21);     // Catch: Throwable -> L134
        goto L63
    L75:
        r112 = this.f1382j;     // Catch: Throwable -> L134
        goto L74
    L160:
        return;
    L15:
        if (r10 == 9) goto L38;
        if (r10 == 10) goto L39;
        if (r10 != 12) goto L20;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r113 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r113 instanceof ServiceParcelable) == false) goto L156;
        int r25 = ((ServiceParcelable) r113).getChannelId();     // Catch: Throwable -> L134
        int r114 = ((ServiceParcelable) r113).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r115 = this.f1383k.f1376b.get(Integer.valueOf(r25));     // Catch: Throwable -> L134
        if (r115 != null) goto L35;
        return;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d("WsChannelService", "register serviceId = " + r114);     // Catch: Throwable -> L134
    L37:
        r115.registerService(r114);     // Catch: Throwable -> L134
        return;
    L156:
        return;
    L20:
        if (r10 != 13) goto L152;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r116 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r116 instanceof ServiceParcelable) == false) goto L153;
        int r26 = ((ServiceParcelable) r116).getChannelId();     // Catch: Throwable -> L134
        int r117 = ((ServiceParcelable) r116).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r118 = this.f1383k.f1376b.get(Integer.valueOf(r26));     // Catch: Throwable -> L134
        if (r118 != null) goto L27;
        return;
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "unregister serviceId = " + r117);     // Catch: Throwable -> L134
    L29:
        r118.unregisterService(r117);     // Catch: Throwable -> L134
        return;
    L153:
        return;
    L152:
        return;
    L38:
        this.f1382j.e();     // Catch: Throwable -> L134
        return;
    L107:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r119 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r119 instanceof IntegerParcelable) == false) goto L167;
        int r120 = ((IntegerParcelable) r119).getData();     // Catch: Throwable -> L134
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L134
        this.f1383k.f1375a.remove(Integer.valueOf(r120));     // Catch: Throwable -> L127
        this.f1381i.b(this.f1383k.f1375a);     // Catch: Throwable -> L127
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L127
        Object r27 = this.f1380h;     // Catch: Throwable -> L134
        monitor-enter(r27);     // Catch: Throwable -> L134
        IWsChannelClient r28 = this.f1383k.f1376b.remove(Integer.valueOf(r120));     // Catch: Throwable -> L124
        monitor-exit(r27);     // Catch: Throwable -> L124
        if (r28 != null) goto L119;
    L122:
        this.f1383k.f1377c.remove(Integer.valueOf(r120));     // Catch: Throwable -> L134
        this.f1378c.sendMessageDelayed(this.f1378c.obtainMessage(8, r28), 1000);     // Catch: Throwable -> L134
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r120);     // Catch: Throwable -> L134
    L121:
        r28.destroy();     // Catch: Throwable -> L134
        goto L122
    L124:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L134
    L167:
        return;
    L130:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r121 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if ((r121 instanceof IWsApp) == false) goto L168;
        j((IWsApp) r121);     // Catch: Throwable -> L134
        return;
    L168:
        return;
    L134:
        th = move-exception;
        th.printStackTrace();
    }

    private void i(@NonNull IWsApp r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r11 = WsChannelService.d(r10);
        if (l() == false) goto L33;
        IWsChannelClient r12 = this.f1383k.f1376b.get(Integer.valueOf(r10.getChannelId()));     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r13 = this.f1383k.f1375a.get(Integer.valueOf(r11));     // Catch: Throwable -> L25
        if (r12 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r10.equals(r13) == true) goto L14;
    L16:
        this.f1383k.f1375a.put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L25
        this.f1381i.b(this.f1383k.f1375a);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r14 = k(r10);     // Catch: Throwable -> L28
        if (r14 == null) goto L22;
        r12.onParameterChange(r14, r10.getConnectUrls());     // Catch: Throwable -> L28
        return;
    L22:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L28
    L14:
        if (r12.isConnected() == false) goto L16;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void j(@NonNull IWsApp r10) {
        int r11 = WsChannelService.d(r10);
        if (l() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r12 = this.f1383k.f1375a.get(Integer.valueOf(r11));     // Catch: Throwable -> L22
        IWsChannelClient r13 = this.f1383k.f1376b.get(Integer.valueOf(r11));     // Catch: Throwable -> L22
        boolean r14 = false;
        boolean r15 = true;
        if (r12 != null) goto L10;
    L14:
        if (r12 != null) goto L16;
        this.f1383k.f1375a.put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L22
        this.f1381i.b(this.f1383k.f1375a);     // Catch: Throwable -> L22
    L12:
        r15 = false;
        r14 = true;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r14 == false) goto L19;
        w(r10);
        return;
    L19:
        if (r15 == false) goto L28;
        i(r10);
        return;
    L28:
        return;
    L10:
        if (r10.equals(r12) == false) goto L14;
        if (r13 == null) goto L12;
        r15 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private Map<String, Object> k(IWsApp r11) {
        HashMap r10 = new HashMap();
        r10.put(WsConstants.KEY_APP_KEY, r11.getAppKey());
        r10.put(WsConstants.KEY_FPID, Integer.valueOf(r11.getFPID()));
        r10.put("sdk_version", 2);
        r10.put(WsConstants.KEY_PLATFORM, 0);
        r10.put("app_version", Integer.valueOf(r11.getAppVersion()));
        r10.put("aid", Integer.valueOf(r11.getAppId()));
        r10.put("device_id", r11.getDeviceId());
        r10.put("iid", r11.getInstallId());
        r10.put(WsConstants.KEY_HEADERS, r11.getHeaders());
        String r12 = r11.getExtra();
        if (r12 != null) goto L6;
        o(WsConstants.KEY_EXTRA);
        r12 = "";
    L6:
        if (com.bytedance.common.wschannel.l.f(this.f1379g).j() == false) goto L17;
        String[] r13 = r12.split("&");
        StringBuilder r14 = new StringBuilder();
        r14.append("is_background=");
        if (n() == false) goto L10;
        String r15 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L11:
        r14.append(r15);
        String r16 = r14.toString();
        if (r13.length > 0) goto L14;
    L16:
        r12 = r16;
        goto L17
    L14:
        if (TextUtils.isEmpty(r13[0]) == true) goto L16;
        r12 = r12 + "&" + r16;
        goto L17
    L10:
        r15 = NetConst.ENCRYPT_VERISON_CODE;
    L17:
        r10.put(WsConstants.KEY_EXTRA, r12);
        if (r11.getDeviceId() != null) goto L21;
        o("device_id");
    L21:
        if (r11.getInstallId() != null) goto L24;
        o("install_id");
    L24:
        if (com.bytedance.common.utility.g.b(r11.getAppKey()) == false) goto L26;
        o(WsConstants.KEY_APP_KEY);
    L26:
        r10.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r11.newPrivateProtocolEnabled()));
        if (r11.getServiceIdList() == null) goto L30;
        r10.put(WsConstants.KEY_SERVICE_ID_LIST, r11.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r11.getPrivateProtocolUrl()) == true) goto L32;
        r10.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r11.getPrivateProtocolUrl());
    L32:
        r10.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r11.getTransportMode()));
        r10.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r11.disableFallbackWSEnabled()));
        return r10;
    }

    private boolean l() {
        return this.f1385m.isEnable();
    }

    private boolean m() {
        Context r10 = this.f1379g;
        if (r10 != null) goto L5;
        return false;
    L5:
        com.bytedance.common.wschannel.l r11 = com.bytedance.common.wschannel.l.f(r10);
        if (r11 != null) goto L9;
        return false;
    L9:
        return r11.h();
    }

    private boolean n() {
        return this.f1386n;
    }

    private void o(String r10) {
        Bundle r11 = new Bundle();
        r11.putString("param_name", r10);
        f2.a.a(this.f1379g, "wschannel_param_null", r11);
    }

    private void p(Runnable r10) {
        this.f1378c.post(r10);
    }

    private void q(Collection<IWsChannelClient> r10) {
        if (com.bytedance.common.wschannel.l.f(this.f1379g).j() == true) goto L5;
        return;
    L5:
        Iterator<IWsChannelClient> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        r(r11.next());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void r(IWsChannelClient r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        WsChannelMsg r11 = g();
        if (r10.privateProtocolEnabled() == false) goto L8;
        r10.sendMessage(r11);
        return;
    L8:
        r10.sendMessage(a2.b.a().b(r11));
    }

    private void s() {
        Object r10 = this.f1380h;     // Catch: Throwable -> L17
        monitor-enter(r10);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r11 = this.f1383k.f1376b.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r11.hasNext() == false) goto L10;
        IWsChannelClient r12 = r11.next().getValue();     // Catch: Throwable -> L14
        if (r12 == null) goto L6;
        r12.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.f1383k.f1376b.clear();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        this.f1383k.f1375a.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    private void v(Map<Integer, IWsApp> r10) {
        if (m() == false) goto L8;
        if (NetworkUtils.c(this.f1379g) == true) goto L8;
        return;
    L8:
        if (this.f1385m.isEnable() == false) goto L17;
        if (r10 == null) goto L23;
        Iterator<IWsApp> r11 = r10.values().iterator();
    L12:
        if (r11.hasNext() == false) goto L24;
        IWsApp r12 = r11.next();
        if (r12 == null) goto L12;
        j(r12);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private void w(IWsApp r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r11 = this.f1380h;
        monitor-enter(r11);
        IWsChannelClient r12 = this.f1383k.f1376b.get(Integer.valueOf(r10.getChannelId()));     // Catch: Throwable -> L28
        if (r12 != null) goto L10;
        r12 = v1.b.c(r10.getChannelId(), this.f1382j, this.f1378c);     // Catch: Throwable -> L28
        r12.init(this.f1379g, r12);     // Catch: Throwable -> L28
        this.f1383k.f1376b.put(Integer.valueOf(r10.getChannelId()), r12);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L28
        if (r12.isConnected() == false) goto L32;
        SocketState r13 = this.f1383k.f1377c.get(Integer.valueOf(r10.getChannelId()));
        Logger.d("WsChannelService", "state = " + r13);
        if (r13 == null) goto L37;
        this.f1382j.h(r12, r13);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L32:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r10.getChannelId());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r14 = k(r10);     // Catch: Throwable -> L25
        if (r14 == null) goto L24;
        r12.openConnection(r14, r10.getConnectUrls());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.server.f.a
    public void a(boolean r10) {
        if (r10 == false) goto L4;
        v(this.f1381i.a());
        return;
    L4:
        s();
    }

    @NonNull
    WsChannelMsg g() {
        WsChannelMsg.b r10 = WsChannelMsg.b.c(Integer.MAX_VALUE).e(4).i(WsConstants.APP_STATE_CHANGE_SERVICE).d(1008601).f(new byte[0]).g("pb").h("pb");
        if (n() == false) goto L5;
        String r11 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L7:
        return r10.a(WsConstants.APP_STATE_BACKGROUND_KEY, r11).b();
    L5:
        r11 = NetConst.ENCRYPT_VERISON_CODE;
        goto L7
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        p(new RunnableC0046b(this, Message.obtain(r10)));
    }

    void t(IWsChannelClient r10) {
        if (r10.isConnected() == true) goto L5;
        return;
    L5:
        this.f1378c.post(new c(this, r10));
    }

    public WsChannelMsg u(IWsChannelClient r10, WsChannelMsg r11) {
        com.bytedance.common.wschannel.l.a r12 = com.bytedance.common.wschannel.l.b();
        if (r12 != null) goto L14;
        return r11;
    L14:
        Iterator<Map.Entry<String, String>> r13 = r12.b(r11.toMap()).entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Exception -> L11
        r11.addHeader(r14.getKey(), r14.getValue());     // Catch: Exception -> L11
        goto L7
    L10:
        return r11;
    L11:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r11;
    }
}

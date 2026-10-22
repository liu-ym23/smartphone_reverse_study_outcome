package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class b implements WeakHandler.IHandler, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHandler f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2156b;
    private final Object c;
    private final g d;
    private final com.bytedance.common.wschannel.channel.a e;
    private final a f;
    private AtomicLong g;
    private f h;
    private boolean i;

    b(Context r5, Looper r6, g r7, a r8, com.bytedance.common.wschannel.channel.a r9, f r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        g r12 = (g) ZeusTransformUtils.wrapperContextForParams(r7, g.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.channel.a r13 = (com.bytedance.common.wschannel.channel.a) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.common.wschannel.channel.a.class, "com.obric.memorydata.plugin");
        final f r14 = (f) ZeusTransformUtils.wrapperContextForParams(r10, f.class, "com.obric.memorydata.plugin");
        this.c = new Object();
        this.g = new AtomicLong(0);
        this.i = false;
        this.f2156b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f2155a = new WeakHandler(r6, this);
        this.d = r12;
        this.f = r8;
        this.e = r13;
        this.h = r14;
        r14.a(this);
        a(new AnonymousClass1(this, r14));
    }

    static /* synthetic */ g a(b r0) {
        return r0.d;
    }

    private Map<String, Object> a(IWsApp r11) {
        IWsApp r12 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r11, IWsApp.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put(WsConstants.KEY_APP_KEY, r12.getAppKey());
        r0.put(WsConstants.KEY_FPID, Integer.valueOf(r12.getFPID()));
        r0.put("sdk_version", 2);
        r0.put(WsConstants.KEY_PLATFORM, 0);
        r0.put("app_version", Integer.valueOf(r12.getAppVersion()));
        r0.put("aid", Integer.valueOf(r12.getAppId()));
        r0.put("device_id", r12.getDeviceId());
        r0.put("iid", r12.getInstallId());
        r0.put(WsConstants.KEY_HEADERS, r12.getHeaders());
        String r3 = r12.getExtra();
        if (r3 != null) goto L6;
        a(WsConstants.KEY_EXTRA);
        r3 = "";
    L6:
        if (com.bytedance.common.wschannel.l.a(this.f2156b).h() == false) goto L17;
        String[] r7 = r3.split("&");
        StringBuilder r8 = new StringBuilder().append("is_background=");
        if (b() == false) goto L10;
        String r9 = "0";
    L11:
        String r10 = r8.append(r9).toString();
        if (r7.length > 0) goto L14;
    L16:
        r3 = r10;
        goto L17
    L14:
        if (TextUtils.isEmpty(r7[0]) == true) goto L16;
        r3 = r3 + "&" + r10;
        goto L17
    L10:
        r9 = "1";
    L17:
        r0.put(WsConstants.KEY_EXTRA, r3);
        if (r12.getDeviceId() != null) goto L21;
        a("device_id");
    L21:
        if (r12.getInstallId() != null) goto L24;
        a("install_id");
    L24:
        if (com.bytedance.common.utility.h.a(r12.getAppKey()) == false) goto L26;
        a(WsConstants.KEY_APP_KEY);
    L26:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r12.newPrivateProtocolEnabled()));
        if (r12.getServiceIdList() == null) goto L30;
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r12.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r12.getPrivateProtocolUrl()) == true) goto L32;
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r12.getPrivateProtocolUrl());
    L32:
        r0.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r12.getTransportMode()));
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r12.disableFallbackWSEnabled()));
        return r0;
    }

    private void a(Message r11) {
        int r0 = r11.what;     // Catch: Throwable -> L134
        if (r0 == 0) goto L130;
        boolean r1 = true;
        if (r0 == 1) goto L107;
        boolean r3 = false;
        if (r0 != 2) goto L9;
        int r12 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L96;
        Logger.d("WsChannelService", "appState = " + r12);     // Catch: Throwable -> L134
    L96:
        if (r12 == 1) goto L99;
        r1 = false;
    L99:
        this.i = r1;     // Catch: Throwable -> L134
        this.e.a();     // Catch: Throwable -> L134
        if (d() == false) goto L166;
        a(this.f.f2154b.values());     // Catch: Throwable -> L134
        Iterator<IWsChannelClient> r10 = this.f.f2154b.values().iterator();     // Catch: Throwable -> L134
    L103:
        if (r10.hasNext() == false) goto L172;
        IWsChannelClient r2 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(r10.next(), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r2 == null) goto L103;
        r2.onAppStateChanged(r12);     // Catch: Throwable -> L134
        goto L103
    L172:
        return;
    L166:
        return;
    L9:
        if (r0 != 3) goto L11;
        int r13 = r11.arg1;     // Catch: Throwable -> L134
        if (Logger.debug() == false) goto L85;
        Logger.d("WsChannelService", "networkState = " + r13);     // Catch: Throwable -> L134
    L85:
        this.e.a();     // Catch: Throwable -> L134
        if (d() == false) goto L165;
        Iterator<IWsChannelClient> r14 = this.f.f2154b.values().iterator();     // Catch: Throwable -> L134
    L89:
        if (r14.hasNext() == false) goto L171;
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(r14.next(), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r4 == null) goto L89;
        r4.onNetworkStateChanged(r13);     // Catch: Throwable -> L134
        goto L89
    L171:
        return;
    L165:
        return;
    L11:
        if (r0 != 4) goto L13;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r15 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r15, IWsApp.class) == false) goto L163;
        b((IWsApp) ZeusTransformUtils.preCheckCast(r15, IWsApp.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L134
        return;
    L163:
        return;
    L13:
        if (r0 != 5) goto L15;
    L39:
        if (r0 == 10) goto L42;
        r1 = false;
    L42:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r5 = r11.getData().getParcelable("payload");     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r5, WsChannelMsg.class) == false) goto L160;
        WsChannelMsg r6 = (WsChannelMsg) ZeusTransformUtils.preCheckCast(r5, WsChannelMsg.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r6.getSeqId() > 0) goto L47;
        r6.setSeqId(this.g.incrementAndGet());     // Catch: Throwable -> L134
    L47:
        IWsChannelClient r7 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r6.getChannelId())), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r1 == false) goto L50;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L134
    L50:
        if (r7 == null) goto L75;
        if (r0 == 10) goto L58;
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.common.wschannel.channel.b.class) == false) goto L58;
        if (((com.bytedance.common.wschannel.channel.b) ZeusTransformUtils.preCheckCast(r7, com.bytedance.common.wschannel.channel.b.class, "com.obric.memorydata.plugin")).a() == false) goto L58;
        r6 = a(r7, r6);     // Catch: Throwable -> L134
    L58:
        if (r7.privateProtocolEnabled() == true) goto L60;
    L62:
        boolean r8 = r7.sendMessage(com.bytedance.common.wschannel.a.b.a().a(r6));     // Catch: Throwable -> L134
    L63:
        r3 = r8;
        long r9 = com.bytedance.common.wschannel.l.a(this.f2156b).g();     // Catch: Throwable -> L134
        if (r3 == true) goto L69;
        if (r1 == true) goto L69;
        if (r9 <= 0) goto L69;
        Message r16 = Message.obtain(r11);     // Catch: Throwable -> L134
        r16.what = 10;     // Catch: Throwable -> L134
        this.f2155a.sendMessageDelayed(r16, r9);     // Catch: Throwable -> L134
    L69:
        if (r3 == false) goto L71;
    L73:
        com.bytedance.common.wschannel.channel.a r17 = this.e;     // Catch: Throwable -> L134
    L74:
        r17.a(r6, r3);     // Catch: Throwable -> L134
    L77:
        if (Logger.debug() == false) goto L161;
        Logger.d("WsChannelService", "send payload success = " + r3);     // Catch: Throwable -> L134
        return;
    L161:
        return;
    L71:
        if (r9 <= 0) goto L73;
        if (r1 == false) goto L77;
    L60:
        if (r7.privateProtocolProxyEnabled() == true) goto L62;
        r8 = r7.sendMessage(r6);     // Catch: Throwable -> L134
        goto L63
    L75:
        r17 = this.e;     // Catch: Throwable -> L134
        goto L74
    L160:
        return;
    L15:
        if (r0 == 9) goto L38;
        if (r0 == 10) goto L39;
        if (r0 != 12) goto L20;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r18 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r18, ServiceParcelable.class) == false) goto L156;
        int r19 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r18, ServiceParcelable.class, "com.obric.memorydata.plugin")).getChannelId();     // Catch: Throwable -> L134
        int r110 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r18, ServiceParcelable.class, "com.obric.memorydata.plugin")).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r111 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r19)), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r111 != null) goto L35;
        return;
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d("WsChannelService", "register serviceId = " + r110);     // Catch: Throwable -> L134
    L37:
        r111.registerService(r110);     // Catch: Throwable -> L134
        return;
    L156:
        return;
    L20:
        if (r0 != 13) goto L152;
        r11.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r112 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r112, ServiceParcelable.class) == false) goto L153;
        int r20 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r112, ServiceParcelable.class, "com.obric.memorydata.plugin")).getChannelId();     // Catch: Throwable -> L134
        int r113 = ((ServiceParcelable) ZeusTransformUtils.preCheckCast(r112, ServiceParcelable.class, "com.obric.memorydata.plugin")).getServiceId();     // Catch: Throwable -> L134
        IWsChannelClient r114 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r20)), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L134
        if (r114 != null) goto L27;
        return;
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "unregister serviceId = " + r113);     // Catch: Throwable -> L134
    L29:
        r114.unregisterService(r113);     // Catch: Throwable -> L134
        return;
    L153:
        return;
    L152:
        return;
    L38:
        this.e.b();     // Catch: Throwable -> L134
        return;
    L107:
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L134
        Parcelable r115 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r115, IntegerParcelable.class) == false) goto L167;
        int r116 = ((IntegerParcelable) ZeusTransformUtils.preCheckCast(r115, IntegerParcelable.class, "com.obric.memorydata.plugin")).getData();     // Catch: Throwable -> L134
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L134
        this.f.f2153a.remove(Integer.valueOf(r116));     // Catch: Throwable -> L127
        this.d.a(this.f.f2153a);     // Catch: Throwable -> L127
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L127
        Object r21 = this.c;     // Catch: Throwable -> L134
        monitor-enter(r21);     // Catch: Throwable -> L134
        IWsChannelClient r22 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.remove(Integer.valueOf(r116)), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L124
        monitor-exit(r21);     // Catch: Throwable -> L124
        if (r22 != null) goto L119;
    L122:
        this.f.c.remove(Integer.valueOf(r116));     // Catch: Throwable -> L134
        this.f2155a.sendMessageDelayed(this.f2155a.obtainMessage(8, r22), 1000);     // Catch: Throwable -> L134
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r116);     // Catch: Throwable -> L134
    L121:
        r22.destroy();     // Catch: Throwable -> L134
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
        Parcelable r117 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L134
        if (ZeusTransformUtils.instanceOf(r117, IWsApp.class) == false) goto L168;
        c((IWsApp) ZeusTransformUtils.preCheckCast(r117, IWsApp.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L134
        return;
    L168:
        return;
    L134:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ void a(b r0, Message r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(b r2, IWsChannelClient r3) {
        r2.b((IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(b r2, Map r3) {
        r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.f2155a.post(r4);
    }

    private void a(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("param_name", r3);
        com.bytedance.common.wschannel.b.a.a(this.f2156b, "wschannel_param_null", r0);
    }

    private void a(Collection<IWsChannelClient> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.wschannel.l.a(this.f2156b).h() == true) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        b((IWsChannelClient) ZeusTransformUtils.preCheckCast(r6.next(), IWsChannelClient.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void a(Map<Integer, IWsApp> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (c() == false) goto L8;
        if (NetworkUtils.a(this.f2156b) == true) goto L8;
        return;
    L8:
        if (this.h.b() == false) goto L17;
        if (r5 == null) goto L23;
        Iterator r6 = r5.values().iterator();
    L12:
        if (r6.hasNext() == false) goto L24;
        IWsApp r0 = (IWsApp) ZeusTransformUtils.preCheckCast(r6.next(), IWsApp.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        c(r0);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    static /* synthetic */ f b(b r0) {
        return r0.h;
    }

    private void b(IWsApp r7) {
        IWsApp r8 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r7, IWsApp.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r0 = WsChannelService.a(r8);
        if (d() == false) goto L33;
        IWsChannelClient r1 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r8.getChannelId())), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L28
        IWsApp r3 = (IWsApp) ZeusTransformUtils.preCheckCast(this.f.f2153a.get(Integer.valueOf(r0)), IWsApp.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (r8.equals(r3) == true) goto L14;
    L16:
        this.f.f2153a.put(Integer.valueOf(r0), r8);     // Catch: Throwable -> L25
        this.d.a(this.f.f2153a);     // Catch: Throwable -> L25
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L25
        Map<String, Object> r6 = a(r8);     // Catch: Throwable -> L28
        if (r6 == null) goto L22;
        r1.onParameterChange(r6, r8.getConnectUrls());     // Catch: Throwable -> L28
        return;
    L22:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L28
    L14:
        if (r1.isConnected() == false) goto L16;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void b(IWsChannelClient r3) {
        IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        WsChannelMsg r2 = a();
        if (r4.privateProtocolEnabled() == false) goto L9;
        r4.sendMessage(r2);
        return;
    L9:
        r4.sendMessage(com.bytedance.common.wschannel.a.b.a().a(r2));
    }

    private boolean b() {
        return this.i;
    }

    private void c(IWsApp r9) {
        IWsApp r10 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r9, IWsApp.class, "com.obric.memorydata.plugin");
        int r0 = WsChannelService.a(r10);
        if (d() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r2 = (IWsApp) ZeusTransformUtils.preCheckCast(this.f.f2153a.get(Integer.valueOf(r0)), IWsApp.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        IWsChannelClient r3 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r0)), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        boolean r4 = false;
        boolean r5 = true;
        if (r2 != null) goto L10;
    L14:
        if (r2 != null) goto L16;
        this.f.f2153a.put(Integer.valueOf(r0), r10);     // Catch: Throwable -> L22
        this.d.a(this.f.f2153a);     // Catch: Throwable -> L22
    L12:
        r5 = false;
        r4 = true;
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        if (r4 == false) goto L19;
        d(r10);
        return;
    L19:
        if (r5 == false) goto L28;
        b(r10);
        return;
    L28:
        return;
    L10:
        if (r10.equals(r2) == false) goto L14;
        if (r3 == null) goto L12;
        r5 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private boolean c() {
        Context r1 = this.f2156b;
        if (r1 != null) goto L5;
        return false;
    L5:
        com.bytedance.common.wschannel.l r2 = com.bytedance.common.wschannel.l.a(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.a();
    }

    private void d(IWsApp r5) {
        IWsApp r6 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r5, IWsApp.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r0 = this.c;
        monitor-enter(r0);
        IWsChannelClient r1 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(this.f.f2154b.get(Integer.valueOf(r6.getChannelId())), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r1 != null) goto L10;
        r1 = com.bytedance.common.wschannel.channel.b.a(r6.getChannelId(), this.e, this.f2155a);     // Catch: Throwable -> L28
        r1.init(this.f2156b, r1);     // Catch: Throwable -> L28
        this.f.f2154b.put(Integer.valueOf(r6.getChannelId()), r1);     // Catch: Throwable -> L28
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L28
        if (r1.isConnected() == false) goto L36;
        SocketState r7 = (SocketState) ZeusTransformUtils.preCheckCast(this.f.c.get(Integer.valueOf(r6.getChannelId())), SocketState.class, "com.obric.memorydata.plugin");
        Logger.d("WsChannelService", "state = " + r7);
        if (r7 == null) goto L37;
        this.e.a(r1, r7);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L37:
        return;
    L36:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r6.getChannelId());     // Catch: Throwable -> L25
    L20:
        Map<String, Object> r4 = a(r6);     // Catch: Throwable -> L25
        if (r4 == null) goto L24;
        r1.openConnection(r4, r6.getConnectUrls());     // Catch: Throwable -> L25
        return;
    L24:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private boolean d() {
        return this.h.b();
    }

    private void e() {
        Object r0 = this.c;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<Map.Entry<Integer, IWsChannelClient>> r1 = this.f.f2154b.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        IWsChannelClient r2 = (IWsChannelClient) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), IWsChannelClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L14
        goto L6
    L10:
        this.f.f2154b.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.f.f2153a.clear();     // Catch: Throwable -> L17
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    WsChannelMsg a() {
        WsChannelMsg.a r0 = WsChannelMsg.a.a(Integer.MAX_VALUE).c(4).b(WsConstants.APP_STATE_CHANGE_SERVICE).a(1008601).a(new byte[0]).b(com.tom_roush.pdfbox.pdmodel.a.d.f.d).a(com.tom_roush.pdfbox.pdmodel.a.d.f.d);
        if (b() == false) goto L5;
        String r3 = "0";
    L7:
        return r0.a(WsConstants.APP_STATE_BACKGROUND_KEY, r3).a();
    L5:
        r3 = "1";
        goto L7
    }

    public WsChannelMsg a(IWsChannelClient r4, WsChannelMsg r5) {
        IWsChannelClient r3 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r4, IWsChannelClient.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.l.a r6 = com.bytedance.common.wschannel.l.b();
        if (r6 != null) goto L14;
        return r5;
    L14:
        Iterator<Map.Entry<String, String>> r7 = r6.a(r5.toMap()).entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        r5.addHeader((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L11
        goto L7
    L10:
        return r5;
    L11:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r5;
    }

    void a(IWsChannelClient r3) {
        final IWsChannelClient r4 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.memorydata.plugin");
        if (r4.isConnected() == true) goto L5;
        return;
    L5:
        this.f2155a.post(new AnonymousClass3(this, r4));
    }

    @Override // com.bytedance.common.wschannel.server.f.a
    public void a(boolean r1) {
        if (r1 == false) goto L4;
        a(this.d.a());
        return;
    L4:
        e();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        final Message r3 = Message.obtain(r2);
        a(new AnonymousClass2(this, r3));
    }
}

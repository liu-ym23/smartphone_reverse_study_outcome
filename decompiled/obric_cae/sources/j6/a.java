package j6;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class a implements WeakHandler.IHandler, e.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static a f8688v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f8689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8690b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f8691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f8692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.common.wschannel.server.b f8693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f8694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f8695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap f8696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f8697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap f8698t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8699u;

    /* JADX INFO: renamed from: j6.a$a, reason: collision with other inner class name */
    public class RunnableC0099a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f8700a;

        public RunnableC0099a(a r8) {
            this.f8700a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f8700a;
            r8.f8695q = new e(r8.f8690b, r8.f8689a, r8);
            r8.h(r8.f8692n.b());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Message f8701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f8702b;

        public b(a r8, Message r10) {
            this.f8702b = r8;
            this.f8701a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f8702b;
            Message r13 = this.f8701a;
            r8.getClass();
            int r10 = r13.what;     // Catch: Throwable -> L130
            if (r10 != 0) goto L8;
            r13.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L130
            Parcelable r14 = r13.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L130
            if ((r14 instanceof IWsApp) == false) goto L159;
            r8.c((IWsApp) r14);     // Catch: Throwable -> L130
            return;
        L159:
            return;
        L8:
            boolean r11 = true;
            if (r10 != 1) goto L33;
            r13.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L130
            Parcelable r15 = r13.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L130
            if ((r15 instanceof IntegerParcelable) == false) goto L161;
            int r16 = ((IntegerParcelable) r15).f3883a;     // Catch: Throwable -> L130
            monitor-enter(WsChannelService.class);     // Catch: Throwable -> L130
            r8.f8696r.remove(Integer.valueOf(r16));     // Catch: Throwable -> L30
            r8.f8692n.c(r8.f8696r);     // Catch: Throwable -> L30
            monitor-exit(WsChannelService.class);     // Catch: Throwable -> L30
            Object r12 = r8.f8691m;     // Catch: Throwable -> L130
            monitor-enter(r12);     // Catch: Throwable -> L130
            IWsChannelClient r17 = (IWsChannelClient) r8.f8697s.remove(Integer.valueOf(r16));     // Catch: Throwable -> L27
            monitor-exit(r12);     // Catch: Throwable -> L27
            if (r17 != null) goto L22;
        L25:
            r8.f8698t.remove(Integer.valueOf(r16));     // Catch: Throwable -> L130
            r8.f8689a.sendMessageDelayed(r8.f8689a.obtainMessage(8, r17), 1000);     // Catch: Throwable -> L130
            return;
        L22:
            if (Logger.debug() == false) goto L24;
            Logger.d("WsChannelService", "stopConnection,channelId = " + r16);     // Catch: Throwable -> L130
        L24:
            r17.destroy();     // Catch: Throwable -> L130
            goto L25
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L130
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L130
        L161:
            return;
        L33:
            boolean r18 = false;
            if (r10 != 2) goto L61;
            int r19 = r13.arg1;     // Catch: Throwable -> L130
            if (Logger.debug() == false) goto L38;
            Logger.d("WsChannelService", "appState = " + r19);     // Catch: Throwable -> L130
        L38:
            if (r19 == 1) goto L41;
            r11 = false;
        L41:
            r8.f8699u = r11;     // Catch: Throwable -> L130
            r8.f8693o.f3934d.f8703a.b();     // Catch: Throwable -> L130
            if (r8.f8695q.f8729c == false) goto L162;
            Collection r20 = r8.f8697s.values();     // Catch: Throwable -> L130
            if (com.bytedance.common.wschannel.a.a(r8.f8690b).f3869a.a(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L54;
            byte[] r21 = r8.a();     // Catch: Throwable -> L130
            Iterator r22 = r20.iterator();     // Catch: Throwable -> L130
        L48:
            if (r22.hasNext() == false) goto L54;
            ((IWsChannelClient) r22.next()).sendMessage(r21);     // Catch: Exception -> L52 Throwable -> L130
        L52:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L130
        L54:
            Iterator r23 = r8.f8697s.values().iterator();     // Catch: Throwable -> L130
        L56:
            if (r23.hasNext() == false) goto L173;
            IWsChannelClient r24 = (IWsChannelClient) r23.next();     // Catch: Throwable -> L130
            if (r24 == null) goto L56;
            r24.onAppStateChanged(r19);     // Catch: Throwable -> L130
            goto L56
        L173:
            return;
        L162:
            return;
        L61:
            if (r10 != 3) goto L74;
            int r110 = r13.arg1;     // Catch: Throwable -> L130
            if (Logger.debug() == false) goto L65;
            Logger.d("WsChannelService", "networkState = " + r110);     // Catch: Throwable -> L130
        L65:
            r8.f8693o.f3934d.f8703a.b();     // Catch: Throwable -> L130
            if (r8.f8695q.f8729c == false) goto L163;
            Iterator r25 = r8.f8697s.values().iterator();     // Catch: Throwable -> L130
        L69:
            if (r25.hasNext() == false) goto L174;
            IWsChannelClient r26 = (IWsChannelClient) r25.next();     // Catch: Throwable -> L130
            if (r26 == null) goto L69;
            r26.onNetworkStateChanged(r110);     // Catch: Throwable -> L130
            goto L69
        L174:
            return;
        L163:
            return;
        L74:
            if (r10 != 4) goto L79;
            r13.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L130
            Parcelable r111 = r13.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L130
            if ((r111 instanceof IWsApp) == false) goto L164;
            r8.b((IWsApp) r111);     // Catch: Throwable -> L130
            return;
        L164:
            return;
        L79:
            if (r10 == 5) goto L85;
            if (r10 == 10) goto L85;
            if (r10 != 9) goto L166;
            r8.f8693o.c();     // Catch: Throwable -> L130
            return;
        L166:
            return;
        L85:
            if (r10 != 10) goto L87;
            boolean r27 = true;
        L88:
            r13.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L130
            Parcelable r28 = r13.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L130
            if ((r28 instanceof WsChannelMsg) == false) goto L168;
            WsChannelMsg r29 = (WsChannelMsg) r28;     // Catch: Throwable -> L130
            if (r29.f3904a > 0) goto L93;
            r29.f3904a = r8.f8694p.incrementAndGet();     // Catch: Throwable -> L130
        L93:
            IWsChannelClient r30 = (IWsChannelClient) r8.f8697s.get(Integer.valueOf(r29.f3913t));     // Catch: Throwable -> L130
            if (r27 == false) goto L96;
            Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L130
        L96:
            if (r30 == null) goto L104;
            r18 = r30.sendMessage(l6.a.f9135d.b(r29));     // Catch: Throwable -> L130
            if (r18 == true) goto L104;
            if (r27 == true) goto L104;
            long r31 = com.bytedance.common.wschannel.a.a(r8.f8690b).f3869a.b(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);     // Catch: Throwable -> L130
            if (r31 <= 0) goto L104;
            Message r112 = Message.obtain(r13);     // Catch: Throwable -> L130
            r112.what = 10;     // Catch: Throwable -> L130
            r8.f8689a.sendMessageDelayed(r112, r31);     // Catch: Throwable -> L130
        L104:
            if (Logger.debug() == false) goto L106;
            Logger.d("WsChannelService", "send payload success = " + r18);     // Catch: Throwable -> L130
        L106:
            ComponentName r113 = r29.f3912s;     // Catch: Throwable -> L130
            if (r113 == null) goto L169;
        L111:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L130
            return;
        L109:
            if (r29.f3911r != null) goto L113;
            r29.f3911r = new byte[1];     // Catch: Throwable -> L111
        L113:
            byte[] r32 = r29.f3911r;     // Catch: Throwable -> L111
            if (r32 != null) goto L116;
            r32 = new byte[1];     // Catch: Throwable -> L111
        L116:
            Intent r33 = new Intent();     // Catch: Throwable -> L111
            r33.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L111
            r33.setComponent(r113);     // Catch: Throwable -> L111
            r33.putExtra(WsConstants.KEY_SEND_RESULT, r18);     // Catch: Throwable -> L111
            if (r32.length == 0) goto L122;
            MessageDigest r34 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L111 Exception -> L133
            r34.update(r32);     // Catch: Throwable -> L111 Exception -> L133
            String r35 = l6.a.Y0(r34.digest());     // Catch: Throwable -> L111 Exception -> L133
        L123:
            r33.putExtra(WsConstants.KEY_PAYLOAD_MD5, r35);     // Catch: Throwable -> L111
            if (Logger.debug() == false) goto L126;
            Logger.d("WsChannelService", "send result = " + r18 + " payloadMd5 = " + r33.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L111
        L126:
            r8.f8690b.startService(r33);     // Catch: Throwable -> L111
        L171:
            return;
        L122:
            r35 = null;
            goto L123
        L169:
            return;
        L168:
            return;
        L87:
            r27 = false;
        L130:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public a(Context r8) {
        HandlerThread r10 = new HandlerThread("wschannel");
        this.f8691m = new Object();
        this.f8694p = new AtomicLong(0);
        ConcurrentHashMap r11 = new ConcurrentHashMap();
        this.f8696r = r11;
        this.f8697s = new ConcurrentHashMap();
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        this.f8698t = r12;
        this.f8699u = false;
        Context r13 = r8.getApplicationContext();
        this.f8690b = r13;
        r10.start();
        WeakHandler r14 = new WeakHandler(r10.getLooper(), this);
        this.f8689a = r14;
        this.f8692n = new h(r13);
        this.f8693o = new com.bytedance.common.wschannel.server.b(r13, r12, r11);
        r14.post(new RunnableC0099a(this));
    }

    public static a e(Context r8) {
        if (f8688v != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8688v != null) goto L9;
        f8688v = new a(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8688v;
    }

    public final byte[] a() {
        WsChannelMsg.b r8 = new WsChannelMsg.b();
        r8.f3920e = 4;
        r8.f3919d = 9000;
        r8.f3918c = 1008601;
        r8.f3921f = new byte[0];
        r8.f3923h = "pb";
        r8.f3922g = "pb";
        if (this.f8699u == false) goto L5;
        String r12 = "0";
    L6:
        HashMap r10 = r8.f3917b;
        r10.put("IsBackground", r12);
        if (r8.f3916a <= 0) goto L27;
        if (r8.f3919d <= 0) goto L25;
        if (r8.f3920e <= 0) goto L23;
        if (r8.f3921f == null) goto L21;
        ArrayList r11 = new ArrayList();
        Iterator r13 = r10.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r14 = (Map.Entry) r13.next();
        WsChannelMsg.MsgHeader r15 = new WsChannelMsg.MsgHeader();
        r15.f3914a = (String) r14.getKey();
        r15.f3915b = (String) r14.getValue();
        r11.add(r15);
        goto L16
    L18:
        WsChannelMsg r16 = new WsChannelMsg(r8.f3916a, r8.f3918c, r8.f3919d, r8.f3920e, r11, r8.f3923h, r8.f3922g, r8.f3921f);
        return l6.a.f9135d.b(r16);
    L21:
        throw new IllegalArgumentException("illegal payload");
    L23:
        throw new IllegalArgumentException("illegal method");
    L25:
        throw new IllegalArgumentException("illegal service");
    L27:
        throw new IllegalArgumentException("illegal channelId");
    L5:
        r12 = "1";
        goto L6
    }

    public final void b(IWsApp r8) {
        int r10 = WsChannelService.f3926m;
        if (r8 != null) goto L5;
        int r11 = Integer.MIN_VALUE;
    L7:
        if (this.f8695q.f8729c == false) goto L31;
        IWsChannelClient r12 = (IWsChannelClient) this.f8697s.get(Integer.valueOf(r8.k()));     // Catch: Throwable -> L26
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L26
        IWsApp r13 = (IWsApp) this.f8696r.get(Integer.valueOf(r11));     // Catch: Throwable -> L23
        if (r12 != null) goto L13;
    L21:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L23
        return;
    L13:
        if (r8.equals(r13) == true) goto L15;
    L17:
        this.f8696r.put(Integer.valueOf(r11), r8);     // Catch: Throwable -> L23
        this.f8692n.c(this.f8696r);     // Catch: Throwable -> L23
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L23
        r12.onParameterChange(d(r8), r8.s());     // Catch: Throwable -> L26
        return;
    L15:
        if (r12.isConnected() == false) goto L17;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        return;
    L5:
        r11 = r8.k();
        goto L7
    }

    public final void c(IWsApp r10) {
        int r8 = WsChannelService.f3926m;
        if (r10 != null) goto L5;
        int r11 = Integer.MIN_VALUE;
    L7:
        if (this.f8695q.f8729c == true) goto L10;
        return;
    L10:
        monitor-enter(WsChannelService.class);
        IWsApp r12 = (IWsApp) this.f8696r.get(Integer.valueOf(r11));     // Catch: Throwable -> L21
        IWsChannelClient r13 = (IWsChannelClient) this.f8697s.get(Integer.valueOf(r11));     // Catch: Throwable -> L21
        boolean r14 = false;
        boolean r15 = true;
        if (r12 != null) goto L14;
    L18:
        if (r12 != null) goto L23;
        this.f8696r.put(Integer.valueOf(r11), r10);     // Catch: Throwable -> L21
        this.f8692n.c(this.f8696r);     // Catch: Throwable -> L21
    L20:
        r15 = false;
        r14 = true;
    L23:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L21
        if (r14 == true) goto L26;
        if (r15 == false) goto L67;
        b(r10);
        return;
    L67:
        return;
    L26:
        if (Logger.debug() == false) goto L28;
        Logger.d("WsChannelService", "tryOpenConnection");
    L28:
        Object r16 = this.f8691m;
        monitor-enter(r16);
        IWsChannelClient r17 = (IWsChannelClient) this.f8697s.get(Integer.valueOf(r10.k()));     // Catch: Throwable -> L33
        if (r17 != null) goto L35;
        y5.b r18 = new y5.b(r10.k(), this.f8693o, this.f8689a);     // Catch: Throwable -> L33
        r18.init(this.f8690b, r18);     // Catch: Throwable -> L33
        this.f8697s.put(Integer.valueOf(r10.k()), r18);     // Catch: Throwable -> L33
        r17 = r18;
    L35:
        monitor-exit(r16);     // Catch: Throwable -> L33
        if (r17.isConnected() == false) goto L61;
        SocketState r19 = (SocketState) this.f8698t.get(Integer.valueOf(r10.k()));
        Logger.d("WsChannelService", "state = " + r19);
        if (r19 == null) goto L65;
        this.f8693o.b(r19);     // Catch: Throwable -> L56
        return;
    L70:
        return;
    L65:
        return;
    L61:
    L47:
        th = move-exception;
        th.printStackTrace();
        return;
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d("WsChannelService", "尝试打开长连接,channelId = " + r10.k());     // Catch: Throwable -> L47
    L45:
        r17.openConnection(d(r10), r10.s());     // Catch: Throwable -> L47
        return;
    L33:
        th = move-exception;
        throw th;
    L14:
        if (r10.equals(r12) == false) goto L18;
        if (r13 == null) goto L20;
        r15 = false;
    L21:
        th = move-exception;
        throw th;
    L5:
        r11 = r10.k();
        goto L7
    }

    public final HashMap d(IWsApp r11) {
        HashMap r8 = new HashMap();
        r8.put(WsConstants.KEY_APP_KEY, r11.n());
        r8.put(WsConstants.KEY_FPID, Integer.valueOf(r11.q()));
        r8.put("sdk_version", 2);
        r8.put(WsConstants.KEY_PLATFORM, 0);
        r8.put("app_version", Integer.valueOf(r11.o()));
        r8.put(WsConstants.KEY_APP_ID, Integer.valueOf(r11.getAppId()));
        r8.put("device_id", r11.getDeviceId());
        r8.put(WsConstants.KEY_INSTALL_ID, r11.j());
        r8.put(WsConstants.KEY_CHANNEL_ID, Integer.valueOf(r11.k()));
        String r10 = r11.getExtra();
        if (r10 != null) goto L6;
        f(WsConstants.KEY_EXTRA);
        r10 = "";
    L6:
        if (com.bytedance.common.wschannel.a.a(this.f8690b).f3869a.a(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L17;
        String[] r12 = r10.split("&");
        if (this.f8699u == false) goto L10;
        String r13 = "0";
    L11:
        String r14 = "is_background=".concat(r13);
        if (r12.length > 0) goto L14;
    L16:
        r10 = r14;
        goto L17
    L14:
        if (TextUtils.isEmpty(r12[0]) == true) goto L16;
        r10 = defpackage.a.f(r10, "&", r14);
        goto L17
    L10:
        r13 = "1";
    L17:
        r8.put(WsConstants.KEY_EXTRA, r10);
        if (r11.getDeviceId() != null) goto L21;
        f("device_id");
    L21:
        if (r11.j() != null) goto L24;
        f("install_id");
    L24:
        if (r5.f.b(r11.n()) == false) goto L26;
        f(WsConstants.KEY_APP_KEY);
    L26:
        return r8;
    }

    public final void f(String r8) {
        Bundle r10 = new Bundle();
        r10.putString("param_name", r8);
        l6.a.t0(this.f8690b, "wschannel_param_null", r10);
    }

    public final void g(boolean r8) {
        if (r8 == false) goto L22;
        h(this.f8692n.b());
        return;
    L22:
        Object r10 = this.f8691m;     // Catch: Throwable -> L19
        monitor-enter(r10);     // Catch: Throwable -> L19
        Iterator r11 = this.f8697s.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r11.hasNext() == false) goto L12;
        IWsChannelClient r12 = (IWsChannelClient) ((Map.Entry) r11.next()).getValue();     // Catch: Throwable -> L16
        if (r12 == null) goto L8;
        r12.destroy();     // Catch: Throwable -> L16
        goto L8
    L12:
        this.f8697s.clear();     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        this.f8696r.clear();     // Catch: Throwable -> L19
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    public final void h(LinkedHashMap r8) {
        if (this.f8695q.f8729c == false) goto L11;
        Iterator r10 = r8.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L17;
        IWsApp r11 = (IWsApp) r10.next();
        if (r11 == null) goto L6;
        c(r11);
        goto L6
    L17:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        b r10 = new b(this, Message.obtain(r8));
        this.f8689a.post(r10);
    }
}

package com.lynx.tasm.ui.image;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.view.FrameMetrics;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.AbsWsClientService;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.NetworkUtils$NetworkType;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxEngineProxy;
import com.obric.oui.window.listener.NextLiveData;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.e1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11110c;

    public /* synthetic */ v(int r5, Object r10, Object r11) {
        this.f11108a = r5;
        this.f11110c = r10;
        this.f11109b = r11;
    }

    private final void a() {
        boolean r5 = true;
        if (((Message) this.f11109b).what != 1) goto L5;
    L10:
        s8.a r10 = (s8.a) this.f11110c;
        Message r11 = (Message) this.f11109b;
        r10.getClass();
        int r12 = r11.what;     // Catch: Throwable -> L16
        if (r12 != 0) goto L18;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L16
        Parcelable r13 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L16
        if ((r13 instanceof IWsApp) == false) goto L146;
        r10.e((IWsApp) r13);     // Catch: Throwable -> L16
        r10.a(99, WsConstants.LP_CM_DOHANDLEMSG_REGISTER);     // Catch: Throwable -> L16
        return;
    L146:
        return;
    L18:
        if (r12 != 1) goto L42;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L16
        Parcelable r14 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L16
        if ((r14 instanceof IntegerParcelable) == false) goto L148;
        int r15 = ((IntegerParcelable) r14).f3995a;     // Catch: Throwable -> L16
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L16
        ((ConcurrentHashMap) r10.f.d).remove(Integer.valueOf(r15));     // Catch: Throwable -> L39
        r10.d.e((ConcurrentHashMap) r10.f.d);     // Catch: Throwable -> L39
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L39
        Object r16 = r10.f21837c;     // Catch: Throwable -> L16
        monitor-enter(r16);     // Catch: Throwable -> L16
        IWsChannelClient r17 = (IWsChannelClient) ((ConcurrentHashMap) r10.f.f17502b).remove(Integer.valueOf(r15));     // Catch: Throwable -> L36
        monitor-exit(r16);     // Catch: Throwable -> L36
        if (r17 != null) goto L31;
    L34:
        ((ConcurrentHashMap) r10.f.f17503c).remove(Integer.valueOf(r15));     // Catch: Throwable -> L16
        r10.f21835a.sendMessageDelayed(r10.f21835a.obtainMessage(8, r17), 1000);     // Catch: Throwable -> L16
        return;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r15);     // Catch: Throwable -> L16
    L33:
        r17.destroy();     // Catch: Throwable -> L16
        goto L34
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L148:
        return;
    L42:
        boolean r18 = false;
        if (r12 != 2) goto L70;
        int r19 = r11.arg1;     // Catch: Throwable -> L16
        if (Logger.debug() == false) goto L47;
        Logger.d("WsChannelService", "appState = " + r19);     // Catch: Throwable -> L16
    L47:
        if (r19 == 1) goto L50;
        r5 = false;
    L50:
        r10.f21839i = r5;     // Catch: Throwable -> L16
        r10.e.a();     // Catch: Throwable -> L16
        if (r10.f21838h.isEnable() == false) goto L149;
        Collection r20 = ((ConcurrentHashMap) r10.f.f17502b).values();     // Catch: Throwable -> L16
        if (((c5.a) g8.g.d(r10.f21836b).f17073b).b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L63;
        byte[] r21 = r10.d();     // Catch: Throwable -> L16
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L16
    L57:
        if (r22.hasNext() == false) goto L63;
        ((IWsChannelClient) r22.next()).sendMessage(r21);     // Catch: Throwable -> L16 Exception -> L61
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L63:
        Iterator r23 = ((ConcurrentHashMap) r10.f.f17502b).values().iterator();     // Catch: Throwable -> L16
    L65:
        if (r23.hasNext() == false) goto L159;
        IWsChannelClient r24 = (IWsChannelClient) r23.next();     // Catch: Throwable -> L16
        if (r24 == null) goto L65;
        r24.onAppStateChanged(r19);     // Catch: Throwable -> L16
        goto L65
    L159:
        return;
    L149:
        return;
    L70:
        if (r12 != 3) goto L83;
        int r110 = r11.arg1;     // Catch: Throwable -> L16
        if (Logger.debug() == false) goto L74;
        Logger.d("WsChannelService", "networkState = " + r110);     // Catch: Throwable -> L16
    L74:
        r10.e.a();     // Catch: Throwable -> L16
        if (r10.f21838h.isEnable() == false) goto L150;
        Iterator r25 = ((ConcurrentHashMap) r10.f.f17502b).values().iterator();     // Catch: Throwable -> L16
    L78:
        if (r25.hasNext() == false) goto L160;
        IWsChannelClient r26 = (IWsChannelClient) r25.next();     // Catch: Throwable -> L16
        if (r26 == null) goto L78;
        r26.onNetworkStateChanged(r110);     // Catch: Throwable -> L16
        goto L78
    L160:
        return;
    L150:
        return;
    L83:
        if (r12 != 4) goto L88;
        r11.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L16
        Parcelable r111 = r11.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L16
        if ((r111 instanceof IWsApp) == false) goto L151;
        r10.b((IWsApp) r111);     // Catch: Throwable -> L16
        return;
    L151:
        return;
    L88:
        if (r12 == 5) goto L94;
        if (r12 == 10) goto L94;
        if (r12 != 9) goto L153;
        r10.e.b();     // Catch: Throwable -> L16
        return;
    L153:
        return;
    L94:
        if (r12 == 10) goto L97;
        r5 = false;
    L97:
        r11.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L16
        Parcelable r27 = r11.getData().getParcelable("payload");     // Catch: Throwable -> L16
        if ((r27 instanceof WsChannelMsg) == false) goto L155;
        WsChannelMsg r28 = (WsChannelMsg) r27;     // Catch: Throwable -> L16
        if (r28.f4006a > 0) goto L102;
        r28.f4006a = r10.g.incrementAndGet();     // Catch: Throwable -> L16
    L102:
        IWsChannelClient r29 = (IWsChannelClient) ((ConcurrentHashMap) r10.f.f17502b).get(Integer.valueOf(r28.f4011j));     // Catch: Throwable -> L16
        if (r5 == false) goto L105;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L16
    L105:
        if (r29 == null) goto L117;
        r18 = r29.sendMessage(n8.a.f20211a.b(r28));     // Catch: Throwable -> L16
        long r30 = ((c5.a) g8.g.d(r10.f21836b).f17073b).a(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);     // Catch: Throwable -> L16
        if (r18 == true) goto L112;
        if (r5 == true) goto L112;
        if (r30 <= 0) goto L112;
        Message r112 = Message.obtain(r11);     // Catch: Throwable -> L16
        r112.what = 10;     // Catch: Throwable -> L16
        r10.f21835a.sendMessageDelayed(r112, r30);     // Catch: Throwable -> L16
    L112:
        if (r18 == false) goto L114;
    L116:
        r10.e.c(r28, r18);     // Catch: Throwable -> L16
    L119:
        if (Logger.debug() == false) goto L156;
        Logger.d("WsChannelService", "send payload success = " + r18);     // Catch: Throwable -> L16
        return;
    L156:
        return;
    L114:
        if (r30 <= 0) goto L116;
        if (r5 == false) goto L119;
    L117:
        r10.e.c(r28, false);     // Catch: Throwable -> L16
        goto L119
    L155:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (((s8.a) this.f11110c).f21838h.isEnable() == true) goto L10;
        if (((Message) this.f11109b).what != 0) goto L145;
        ((s8.a) this.f11110c).a(1, WsConstants.LP_CM_HANDLEMSH_DISABLE);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 2;
        int r10 = 0;
        switch(this.f11108a) {
            case 0: goto L241;
            case 1: goto L234;
            case 2: goto L203;
            case 3: goto L176;
            case 4: goto L174;
            case 5: goto L168;
            case 6: goto L158;
            case 7: goto L145;
            case 8: goto L143;
            case 9: goto L122;
            case 10: goto L115;
            case 11: goto L113;
            case 12: goto L111;
            case 13: goto L260;
            case 14: goto L96;
            case 15: goto L92;
            case 16: goto L90;
            case 17: goto L85;
            case 18: goto L72;
            case 19: goto L268;
            case 20: goto L65;
            case 21: goto L56;
            case 22: goto L47;
            case 23: goto L45;
            case 24: goto L43;
            case 25: goto L41;
            case 26: goto L30;
            case 27: goto L28;
            case 28: goto L26;
            default: goto L4;
        };
    L4:
        Context r11 = (Context) this.f11109b;
        boolean r12 = WsChannelReceiver.d;
        boolean r13 = ((c5.a) g8.g.d(r11).f17073b).b(WsConstants.KEY_FRONTIER_ENABLED, true);     // Catch: Throwable -> L255
        if (r13 == WsChannelReceiver.d) goto L9;
        WsChannelReceiver.d = r13;     // Catch: Throwable -> L255
    L9:
        if (WsChannelReceiver.d == false) goto L296;
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelReceiver", "ConnectivityReceiver");     // Catch: Exception -> L256
    L14:
        boolean r14 = f8.b.j(r11);     // Catch: Exception -> L256
        NetworkUtils$NetworkType r15 = f8.b.a(r11);     // Catch: Exception -> L256
        if (r14 == true) goto L18;
    L24:
        Message r16 = Message.obtain();     // Catch: Exception -> L256
        r16.what = 3;     // Catch: Exception -> L256
        r16.arg1 = r5;     // Catch: Exception -> L256
        s8.a r17 = ((WsChannelReceiver) this.f11110c).f4017a;     // Catch: Exception -> L256
        r17.getClass();     // Catch: Exception -> L256
        r17.f21835a.post(new v(27, r17, Message.obtain(r16)));     // Catch: Exception -> L256
        return;
    L18:
        if (NetworkUtils$NetworkType.e != r15) goto L21;
        r5 = 3;
        goto L24
    L21:
        if (NetworkUtils$NetworkType.f4014a == r15) goto L23;
        r5 = 4;
        goto L24
    L23:
        r5 = 1;
    L297:
        return;
    L296:
        return;
    L26:
        ((i8.b) this.f11109b).sendMessage(((s8.a) this.f11110c).d());
        return;
    L28:
        a();
        return;
    L30:
        ((s8.e) this.f11109b).a();
        s8.a r18 = (s8.a) this.f11110c;
        Map r19 = r18.d.a();
        if (r18.f21838h.isEnable() == false) goto L40;
        if (r19 == null) goto L298;
        Iterator r20 = r19.values().iterator();
    L35:
        if (r20.hasNext() == false) goto L299;
        IWsApp r21 = (IWsApp) r20.next();
        if (r21 == null) goto L35;
        r18.e(r21);
        r18.a(98, WsConstants.LP_CM_TRYCONNECT_DOREGISTER);
        goto L35
    L299:
        return;
    L298:
        return;
    L40:
        return;
    L41:
        i6.a.i().b(new j6.e("start", "", (JSONObject) this.f11109b, null, (JSONObject) this.f11110c));
        return;
    L43:
        ((com.bytedance.android.monitorV2.settings.f) ((Map.Entry) this.f11109b).getKey()).a((qg.c) this.f11110c);
        return;
    L45:
        int r22 = oo.e.f;
        ((oo.e) this.f11110c).i((oo.d) this.f11109b);
        return;
    L47:
        Process.setThreadPriority(10);
        com.bytedance.ies.bullet.prefetchv2.d r23 = (com.bytedance.ies.bullet.prefetchv2.d) this.f11110c;
        ng.a r24 = (ng.a) r23.f5840b;
        if (r24 == null) goto L264;
        r24.e(Thread.currentThread().getId());
    L264:
        Runnable r110 = (Runnable) this.f11109b;     // Catch: Throwable -> L54
        if (r110 == null) goto L300;
        r110.run();     // Catch: Throwable -> L54
        return;
    L300:
        return;
    L54:
        mg.a.f20082a.getClass();
        r23.getClass();
        return;
    L56:
        LynxEngineProxy r25 = (LynxEngineProxy) this.f11110c;
        if (r25.f10828a != 0) goto L59;
        LynxLog.b(4, "LynxEngineProxy", "SendCustomEvent failed since mNativePtr is null");
        return;
    L59:
        boolean r26 = kn.b.f18686a;
        on.b r111 = (on.b) this.f11109b;
        ByteBuffer r112 = kn.b.b(r111.b());
        if (r112 != null) goto L62;
    L61:
        int r113 = r10;
        LynxEngineProxy.h(r25, r25.f10828a, r111.f20780b, r111.f20779a, r112, r113, r111.c());
        return;
    L62:
        r10 = r112.position();
        goto L61
    L65:
        LynxEngineProxy r27 = (LynxEngineProxy) this.f11110c;
        long r28 = r27.f10828a;
        if (r28 != 0) goto L68;
        LynxLog.b(4, "LynxEngineProxy", "DispatchTaskToLynxEngine failed since mNativePtr is null");
        return;
    L68:
        LynxEngineProxy.e(r27, r28, (Runnable) this.f11109b);
        return;
    L72:
        Application r29 = (Application) this.f11109b;
        if (r29 == null) goto L305;
        i4.a r114 = (i4.a) this.f11110c;
        WeakReference r30 = (WeakReference) r114.f17502b;
        if (r30 != null) goto L78;
    L79:
        r114.f17502b = new WeakReference(r29.getApplicationContext());
    L262:
        ComponentName r31 = new ComponentName(r29, WsChannelService.class);     // Catch: Throwable -> L82
        m8.b r32 = new m8.b();     // Catch: Throwable -> L82
        r32.f20020a = 9;     // Catch: Throwable -> L82
        ((LinkedBlockingDeque) r114.d).offer(r32);     // Catch: Throwable -> L82
        i4.a.p(r114, r31);     // Catch: Throwable -> L82
        return;
    L82:
        th = move-exception;
        th.printStackTrace();
        return;
    L78:
        if (r30.get() != null) goto L262;
    L305:
        return;
    L85:
        AbsWsClientService r33 = (AbsWsClientService) this.f11110c;
        Intent r115 = (Intent) this.f11109b;
        if (r115 != null) goto L88;
        int r116 = AbsWsClientService.d;
        r33.getClass();
        return;
    L88:
        r33.f3977b.j(r115);
        return;
    L90:
        lm.e r34 = (lm.e) this.f11110c;
        ((SvgImageView) UISvg.l(r34.f19681b)).setImageDrawable((lm.b) this.f11109b);
        r34.f19681b.invalidate();
        return;
    L92:
        lm.g r35 = (lm.g) this.f11110c;
        ((SvgImageView) UISvg.j((UISvg) r35.d)).setImageDrawable((lm.b) this.f11109b);
        UISvg r117 = (UISvg) r35.d;
        r117.invalidate();
        if (r35.f19687c == false) goto L308;
        UISvg.k(r117, null);
        return;
    L308:
        return;
    L96:
        ((kotlinx.coroutines.selects.g) this.f11109b).e((kotlinx.coroutines.selects.a) this.f11110c, Unit.INSTANCE);
        return;
    L111:
        ((kotlinx.coroutines.l) this.f11110c).F((e1) this.f11109b, Unit.INSTANCE);
        return;
    L113:
        ((io.reactivex.internal.schedulers.q) this.f11109b).d = true;
        ((io.reactivex.internal.schedulers.r) this.f11110c).f18157a.remove((io.reactivex.internal.schedulers.q) this.f11109b);
        return;
    L115:
        mt.b r36 = (mt.b) this.f11109b;
        ((Runnable) this.f11110c).run();     // Catch: Throwable -> L119
        r36.onComplete();
        return;
    L119:
        th = move-exception;
        r36.onComplete();
        throw th;
    L122:
        hf.g r37 = (hf.g) this.f11109b;
        PrepareMeta r118 = (PrepareMeta) this.f11110c;
        long r38 = r118.getVersion();
        pa.a r39 = r37.d;     // Catch: Throwable -> L126
        if (r39 == null) goto L128;
        r118.getPack();     // Catch: Throwable -> L126
        r39.e(r118.getPack(), r38);     // Catch: Throwable -> L126
        r118.getChannel();     // Catch: Throwable -> L126
    L128:
        Iterator r40 = pa.b.f21323a.iterator();     // Catch: Throwable -> L126
    L129:
        if (r40.hasNext() == false) goto L134;
        pa.a r41 = (pa.a) r40.next();     // Catch: Throwable -> L126
        r118.getPack();     // Catch: Throwable -> L126
        r41.getClass();     // Catch: Throwable -> L126
        r41.e(r118.getPack(), r38);     // Catch: Throwable -> L126
        r118.getChannel();     // Catch: Throwable -> L126
    L134:
        com.bytedance.geckox.n r42 = r37.f;
        String r43 = r118.getChannel();
        r42.getClass();
        if (r42.f4764k == null) goto L138;
        r42.a(r43, new com.bytedance.iesgurd.g(null, r38, true));
    L138:
        r118.getAccessKey();
        r118.getChannel();
        r118.getLocalVersion();
        Iterator r119 = com.bytedance.iesgurd.a.f6593a.entrySet().iterator();
    L140:
        if (r119.hasNext() == false) goto L142;
        ((com.bytedance.iesgurd.b) ((Map.Entry) r119.next()).getValue()).getClass();
        goto L140
    L142:
        return;
    L126:
        th = move-exception;
        GeckoLogger.b("onEventUpdateSuccess exception: " + th.getMessage());
        goto L134
    L143:
        ((h6.a) this.f11110c).f((h6.b) this.f11109b);
        return;
    L145:
        k6.a r44 = (k6.a) this.f11109b;
    L151:
        e = move-exception;
        r44.h(e);
        return;
    L147:
        if (((h.f) r44.f18623a).d(((Callable) this.f11110c).call()) == false) goto L150;
        return;
    L150:
        throw new IllegalStateException("Cannot set the result of a completed task.");     // Catch: Exception -> L151 CancellationException -> L153
    L154:
        if (((h.f) r44.f18623a).g() == false) goto L157;
        return;
    L157:
        throw new IllegalStateException("Cannot cancel a completed task.");
    L158:
        ba.a r45 = (ba.a) this.f11109b;
        JSONObject r120 = (JSONObject) this.f11110c;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r120, "extraCategory");
        SystemClock.uptimeMillis();
        c7.h r46 = (c7.h) r45.f890c;
        monitor-enter(r46);
        r46.a();     // Catch: Throwable -> L164
        String r121 = r46.f1138a;     // Catch: Throwable -> L164
        com.bytedance.apm.block.b.f3854c = true;     // Catch: Throwable -> L164
        com.bytedance.apm.block.b.f3852a.remove(r121);     // Catch: Throwable -> L164
        monitor-exit(r46);
        r45.f888a = false;
        return;
    L164:
        th = move-exception;
        throw th;
    L174:
        ((NextLiveData) this.f11110c).setValue(this.f11109b);
        return;
    L176:
        r0 r47 = (r0) this.f11110c;
        v0 r48 = ((s0) r47.e).f11104c;
        boolean r49 = r48.B;
        s0 r50 = (s0) r47.e;
        t0 r51 = r48.f11130p;
        if (r49 == false) goto L194;
        String r122 = (String) this.f11109b;
        if (r51 == null) goto L187;
        boolean r52 = r48.f11127m.containsKey(r122);
        v0 r53 = r50.f11104c;
        DraweeHolder r54 = r53.f11125k;
        if (r52 == false) goto L183;
        r54 = (DraweeHolder) r53.f11127m.get(r122);
    L183:
        if (r54 == null) goto L187;
        r54.d.getClass();
        DraweeHierarchy r55 = r54.d;
        r55.getClass();
        GenericDraweeHierarchy r56 = (GenericDraweeHierarchy) r55;
        if (r56.g.f7847a == r56.f7907a) goto L187;
        r50.f11104c.f11130p.onDrawableReady(r54.d());
    L187:
        Iterator r57 = r50.f11104c.f11127m.entrySet().iterator();
    L189:
        if (r57.hasNext() == false) goto L199;
        Map.Entry r58 = (Map.Entry) r57.next();
        if (((String) r58.getKey()).equals(r122) == true) goto L199;
        ((DraweeHolder) r58.getValue()).g();
        r57.remove();
    L199:
        b1 r123 = r50.f11104c.f11129o;
        if (r123 == null) goto L313;
        r123.g();
        r50.f11104c.f11129o = null;
        return;
    L313:
        return;
    L194:
        if (r51 == null) goto L196;
        r51.onDrawableReady(r48.f11125k.d());
    L196:
        DraweeHolder r124 = r50.f11104c.f11126l;
        if (r124 == null) goto L199;
        r124.g();
        r50.f11104c.f11126l = null;
        goto L199
    L203:
        r0 r59 = (r0) this.f11110c;
        v0 r60 = (v0) r59.e;
        boolean r61 = r60.B;
        v0 r62 = (v0) r59.e;
        t0 r63 = r60.f11130p;
        if (r61 == false) goto L221;
        String r125 = (String) this.f11109b;
        if (r63 == null) goto L214;
        boolean r64 = r60.M.containsKey(r125);
        q0 r65 = r62.K;
        if (r64 == false) goto L210;
        r65 = (q0) r62.M.get(r125);
    L210:
        if (r65 == null) goto L214;
        DraweeHierarchy r66 = r65.f11098c;
        r66.getClass();
        GenericDraweeHierarchy r67 = (GenericDraweeHierarchy) r66;
        if (r67.g.f7847a == r67.f7907a) goto L214;
        r62.f11130p.onDrawableReady(r67.e);
    L214:
        Iterator r68 = r62.M.entrySet().iterator();
    L216:
        if (r68.hasNext() == false) goto L230;
        Map.Entry r69 = (Map.Entry) r68.next();
        if (((String) r69.getKey()).equals(r125) == true) goto L230;
        q0 r70 = (q0) r69.getValue();
        r70.f11097b = false;
        r70.a();
        r68.remove();
    L230:
        CloseableReference r126 = r62.Y;
        if (r126 == null) goto L314;
        r126.close();
        r62.Y = null;
        return;
    L314:
        return;
    L221:
        if (r63 == null) goto L227;
        DraweeHierarchy r127 = r60.K.f11098c;
        if (r127 != null) goto L225;
        RootDrawable r128 = null;
    L226:
        r63.onDrawableReady(r128);
        goto L227
    L225:
        r128 = ((GenericDraweeHierarchy) r127).e;
    L227:
        q0 r129 = r62.L;
        if (r129 == null) goto L230;
        r129.f11097b = false;
        r129.a();
        r62.L = null;
        goto L230
    L234:
        DataSource r71 = (DataSource) this.f11109b;
        if (r71 == null) goto L237;
        r71.close();
    L237:
        i0 r130 = (i0) this.f11110c;
        r130.f11058i = null;
        Object r72 = r130.f11057h;
        if (r72 == null) goto L315;
        r130.f(r72);
        r130.f11057h = null;
        return;
    L315:
        return;
    L241:
        w r73 = (w) this.f11110c;
        oo.k r74 = r73.e.f11019w;
        String r75 = r73.f11140a;
        a0 r76 = r73.e;
        if (r74 != null) goto L244;
    L253:
        a0.k(r76);
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("localCache url check error: "), r75, 3, "ImageDelegate");
        return;
    L244:
        if (r75.equals(r74.f20818b) == false) goto L253;
        long r77 = System.currentTimeMillis();
        Bitmap.Config r78 = r76.f11012o;
        if (r78 != null) goto L249;
        r78 = Bitmap.Config.ARGB_8888;
    L249:
        int r79 = td.b.a(r73.f11141b, r73.f11142c, r78);
        String r131 = r76.f11017u;
        LynxContext r132 = kk.a.i(r76.A);
        if (r76.G == false) goto L252;
        td.c.b(r79, 0, r73.d, r77, r132, r131, true, true);
    L252:
        r76.f11022z.i((CloseableReference) this.f11109b);
        return;
    L260:
        ((Runnable) this.f11109b).run();     // Catch: Throwable -> L100
    L102:
        kotlinx.coroutines.internal.g r80 = (kotlinx.coroutines.internal.g) this.f11110c;
        Runnable r81 = r80.g();
        if (r81 == null) goto L309;
        this.f11109b = r81;
        r10 = r10 + 1;
        if (r10 < 16) goto L260;
        if (r80.f18935b.isDispatchNeeded(r80) == false) goto L260;
        r80.f18935b.dispatch(r80, this);
        return;
    L309:
        return;
    L100:
        th = move-exception;
        kotlinx.coroutines.c0.a(th, EmptyCoroutineContext.INSTANCE);
        goto L102
    L268:
        ((Context) this.f11109b).registerReceiver(new e6.d((com.bytedance.crash.upload.k) this.f11110c, r5), new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L257
        return;
    L304:
        return;
    L168:
        if (((FrameMetrics) this.f11109b).getMetric(9) != 0) goto L173;
        d6.c r82 = d6.c.f16598k;
        Iterator r133 = ((d6.b) this.f11110c).f16597a.d.iterator();
    L171:
        if (r133.hasNext() == false) goto L312;
        ((xg.b) r133.next()).getClass();
        goto L171
    L312:
        return;
    }

    public /* synthetic */ v(int r5, Object r10, boolean r11, Object r12) {
        this.f11108a = r5;
        this.f11109b = r10;
        this.f11110c = r12;
    }

    public v(d6.b r5, FrameMetrics r10, int r11) {
        this.f11108a = 5;
        this.f11110c = r5;
        this.f11109b = r10;
    }
}

package com.bytedance.android.live.pushstream;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.broadcast.api.framework.service.ILiveAVResourceService;
import com.bytedance.android.live.broadcast.api.model.IBroadcastApiService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.PerformanceTestSettingKey;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.bq0;
import com.bytedance.android.livesdk.config.bt;
import com.bytedance.android.livesdk.config.fj;
import com.bytedance.android.livesdk.config.gd;
import com.bytedance.android.livesdk.config.gh;
import com.bytedance.android.livesdk.config.gm;
import com.bytedance.android.livesdk.config.h60;
import com.bytedance.android.livesdk.config.hm;
import com.bytedance.android.livesdk.config.im;
import com.bytedance.android.livesdk.config.j60;
import com.bytedance.android.livesdk.config.jq0;
import com.bytedance.android.livesdk.config.ku0;
import com.bytedance.android.livesdk.config.li;
import com.bytedance.android.livesdk.config.lq;
import com.bytedance.android.livesdk.config.lt;
import com.bytedance.android.livesdk.config.m81;
import com.bytedance.android.livesdk.config.mi;
import com.bytedance.android.livesdk.config.mr;
import com.bytedance.android.livesdk.config.n40;
import com.bytedance.android.livesdk.config.na1;
import com.bytedance.android.livesdk.config.ni;
import com.bytedance.android.livesdk.config.s60;
import com.bytedance.android.livesdk.config.t60;
import com.bytedance.android.livesdk.config.u60;
import com.bytedance.android.livesdk.config.u9;
import com.bytedance.android.livesdk.config.w0;
import com.bytedance.android.livesdk.config.w41;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.model.AVMonitorLogConfig;
import com.bytedance.android.livesdkapi.model.AnchorVStreamPerfConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveReuseStreamAdaptLandScapeConfig;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.IPushStreamDataManager;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.livelink.kmp.api.IAndroidLiveLinkService;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fr2.q0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveStream4 extends com.bytedance.android.live.pushstream.e {
    public final Set<String> A;
    public final Set<String> B;
    public final Map<String, String> C;
    public final Map<String, String> D;
    public final Lazy E;
    public final Lazy F;
    public final g G;
    public final b H;
    public final f I;
    public final AVMonitorLogConfig J;
    public final u K;
    public final com.bytedance.android.live.pushstream.b.C0058b a;
    public final com.bytedance.android.live.pushstream.b.a b;
    public h0.b c;
    public final CopyOnWriteArrayList<h0.b> d;
    public h0.c e;
    public final CopyOnWriteArrayList<h0.c> f;
    public final Map<String, String> g;
    public d0 h;
    public ei6.a i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public vv0.f n;
    public d0.a o;
    public final Handler p;
    public int q;
    public int r;
    public com.bytedance.android.live.pushstream.utils.b s;
    public String t;
    public final CompositeDisposable u;
    public final y v;
    public com.bytedance.android.live.pushstream.a w;
    public rv0.a x;
    public View y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveStream4 a;

        public b(LiveStream4 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveStream4 r0 = this.a;     // Catch: Throwable -> L9
            if (r0.a.a != 3) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L12;
            r0.j = 2;     // Catch: Throwable -> L9
            r0.o();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L5:
            r1 = false;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements h0.b {
        public c(LiveStream4 r1) {
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements h0.c {
        public e(LiveStream4 r1) {
        }
    }

    public static final class f implements d0.a.a {
        public final /* synthetic */ LiveStream4 a;

        public f(LiveStream4 r1) {
            this.a = r1;
        }

        public final void a(String r28, JSONObject r29) {
            f r1 = this;
            if (r29 != null) goto L5;
            return;
        L5:
            String r4 = r29.optString("mode", "");
            LiveStream4 r0 = r1.a;
            r0.getClass();
            if (((AnchorVStreamPerfConfig) im.a.getValue()).getEnable() == false) goto L23;
            if (r0.n != null) goto L11;
            r0.n = new vv0.f();
        L11:
            if (Intrinsics.areEqual(r29.optString("event_key", ""), "push_stream") == false) goto L23;
            vv0.f r2 = r0.n;
            if (r2 == null) goto L23;
            Intrinsics.checkNotNullParameter(r29, "obj");
        L20:
            e = move-exception;
            ALogger.e("PushStreamPerformanceMonitor", "handleLiveCorePerformance", e);
            goto L23
        L16:
            if (((ArrayList) r2.a).size() < r2.b) goto L18;
            ListProtector.remove(r2.a, 0);     // Catch: Exception -> L20
        L18:
            ((ArrayList) r2.a).add(r29);     // Catch: Exception -> L20
        L23:
            if (Intrinsics.areEqual(r4, "push") == false) goto L25;
            return;
        L25:
            LiveStream4 r5 = r1.a;
            Map<String, String> r3 = r5.g;
            r5.K.getClass();
            ((ConcurrentHashMap) r3).put("rtmp_type", String.valueOf(0));
            Iterator r6 = ((ConcurrentHashMap) r5.g).keySet().iterator();
        L27:
            if (r6.hasNext() == false) goto L34;
            String r7 = (String) r6.next();
            r29.put(r7, ((ConcurrentHashMap) r5.g).get(r7));     // Catch: JSONException -> L31
        L31:
            e = move-exception;
            e.printStackTrace();
            goto L27
        L34:
            if (TextUtils.isEmpty(com.bytedance.android.live.pushstream.utils.c.a) == false) goto L96;
        L39:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r8 = ILiveWrappedLivePusher.a.b();
            if (r8 == null) goto L43;
            r8.getGLThreadManager();
        L43:
            if (TextUtils.isEmpty(null) == true) goto L98;
            r29.put("gpu_name", null);     // Catch: JSONException -> L46
        L46:
            e = move-exception;
            e.printStackTrace();
        L98:
            r29.put("ttlive_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: JSONException -> L51
        L53:
            String r9 = r29.optString("event_key", "");
            if (v.a() == false) goto L65;
            if (r9.equals("rtc_push_stream") == false) goto L65;
            String r10 = r29.optString("mix_type", "");
            v r12 = v.b();
            if ((!Intrinsics.areEqual(r10, "")) == true) goto L60;
        L62:
            String r13 = "mixOnServer";
        L63:
            r12.c("data_mix_type", r13);
            goto L65
        L60:
            if (Intrinsics.areEqual(r10, DataType.TRUE) == false) goto L62;
            r13 = "mixOnClient";
        L65:
            if (r9.equals("push_stream") == false) goto L67;
        L68:
            IPerformanceManager r14 = jc1.k.f(IPerformanceManager.class);
            if (r14 == null) goto L84;
            float r15 = r14.getTemperature();
            double r16 = r14.getBatteryCurrent();
            int r17 = r14.getBatteryLevel();
            int r18 = r14.getBatteryChange();
            float r19 = r14.getUIStallDuration();
            float r110 = r14.getFps();
            double r111 = r14.getCpuRate();
            double r112 = r14.getCpuSpeed();
            double r113 = r14.getGpuUsed();
            long r114 = r14.getPssTotal();
            long r115 = r14.getGraphics();
            long r116 = r14.getJavaHeapSum();
            long r20 = r14.getNativeHeapSum();
            int r117 = TTNetInit.getNetworkQuality().httpRttMs;     // Catch: Exception -> L73
        L74:
            int r118 = -2;
            int r26 = r117;
            Map r119 = jc1.k.n(IMiddlewareHostApp.class).getNQEParams();     // Catch: Exception -> L89
            if (r119.containsKey("net_effective_connection_type") == false) goto L80;
            r118 = CastIntegerProtector.parseInt((String) r119.get("net_effective_connection_type"));     // Catch: Exception -> L89
        L80:
            int r22 = r118;
        L83:
            r29.put("temperature", Float.valueOf(r15));
            r29.put("battery_current", r16);
            r29.put("battery_level", r17);
            r29.put("battery_state", r18);
            r29.put("ui_stall_duration", Float.valueOf(r19));
            r29.put("avg_fps", Float.valueOf(r110));
            r29.put("cpu", r111);
            r29.put("cpu_speed_rate", r112);
            r29.put("gpu_used", r113);
            r29.put("memory", r114);
            r29.put("graphics", r115);
            r29.put("java_heap_sum", r116);
            r29.put("native_heap_sum", r20);
            r29.put("http_rtt", r26);
            r29.put("network_status", r22);
        L82:
            r22 = -2;
        L81:
            r26 = r117;
        L73:
            r117 = -1;
        L84:
            r1 = this;
        L85:
            sv0.a r23 = r1.a.K.p;
            if (r23 == null) goto L110;
            r23.a(r28, r29);
            return;
        L110:
            return;
        L67:
            if (r9.equals("rtc_push_stream") == false) goto L85;
        L51:
            e = move-exception;
            e.printStackTrace();
            Unit r24 = Unit.INSTANCE;
            goto L53
        L96:
            r29.put("cpu_soc", com.bytedance.android.live.pushstream.utils.c.a);     // Catch: JSONException -> L37
            Logger.d("cpu_soc = " + com.bytedance.android.live.pushstream.utils.c.a);     // Catch: JSONException -> L37
        L37:
            e = move-exception;
            e.printStackTrace();
            goto L39
        }
    }

    public static final class g {
        public g(LiveStream4 r1) {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void r() {
        R(null);
        y r0 = this.v;
        if (r0 == null) goto L23;
        d0 r1 = r0.e;
        if (r1 == null) goto L11;
        d0.a r2 = r1.getBuilder();
        if (r2 == null) goto L11;
        if (r2.g() != 1) goto L11;
        int r3 = 2;
    L13:
        if (((Boolean) fj.a.getValue()).booleanValue() == false) goto L15;
        int r4 = com.bytedance.android.live.pushstream.utils.d.a;
        r0.d.getClass();
        com.bytedance.android.live.pushstream.utils.d.a(1, r3);
    L15:
        d0 r5 = r0.e;
        if (r5 == null) goto L19;
        r5.o();
    L19:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L21;
        ALogger.w("LiveStream", "switchVideoCapture, CAMERA_MIRROR: false, CAPTURE: " + r3, new IllegalStateException());
        return;
    L21:
        ALogger.w("LiveStream", "switchVideoCapture, CAMERA_MIRROR: false, CAPTURE: " + r3);
        return;
    L11:
        r3 = 1;
        goto L13
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final z C() {
        d0 r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.C();
    }

    @Override // com.bytedance.android.live.pushstream.b
    @Deprecated(message = "")
    public final void D() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.D();
        return;
    }

    public final void E() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.D();
        return;
    }

    public final void G() {
        if (((LiveReuseStreamAdaptLandScapeConfig) li.a.getValue()).isEnable() == false) goto L6;
        this.K.getClass();
        return;
    L6:
        this.K.getClass();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void G0() {
        y r0 = this.v;
        if (r0 == null) goto L8;
        d0 r1 = r0.e;
        if (r1 == null) goto L9;
        r1.release();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void I() {
        if (((LiveReuseStreamAdaptLandScapeConfig) li.a.getValue()).isEnable() == true) goto L24;
        y r0 = this.v;
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(this.t, "cacheSdkParams");
        d0 r1 = r0.e;
        if (r1 == null) goto L17;
        r1.A();
    L17:
        IFeatureService r2 = jc1.k.f(IFeatureService.class);
        if (r2 == null) goto L22;
        z90.a r3 = r2.getFeatureManager();
        if (r3 == null) goto L22;
        z90.a.a.a(r3, "is_strategy_support_scene", Boolean.TRUE);
    L22:
        Q(this.h);
        return;
    L24:
        P();     // Catch: JSONException -> L9
        y r4 = this.v;     // Catch: JSONException -> L9
        if (r4 == null) goto L10;
        r4.b(this.t);     // Catch: JSONException -> L9
        d0 r5 = r4.a;     // Catch: JSONException -> L9
        if (r5 == null) goto L10;
        r5.A();     // Catch: JSONException -> L9
    L10:
        ALogger.w("cacheSdkParams", "cacheSdkParams changed:" + this.t);     // Catch: JSONException -> L9
        goto L17
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void J() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.J();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void L() {
        ALogger.i("ttlive_anchor_pushstream_LiveStream", "setBusinessTag: null");
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void M() {
        y r0 = this.v;
        if (r0 == null) goto L8;
        d0 r1 = r0.e;
        if (r1 == null) goto L9;
        r1.I();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void N0() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public final void P() {
        if (((LiveReuseStreamAdaptLandScapeConfig) li.a.getValue()).isEnable() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject(this.t);
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r0, "PushBase");
        r1.put("width", this.K.g);
        r1.put("height", this.K.h);
        this.t = r0.toString();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean a() {
        d0 r0 = this.h;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final uf2.x b() {
        d0 r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // com.bytedance.android.live.pushstream.f
    public final nv0.c c() {
        this.K.getClass();
        E();
        return new nv0.c();
    }

    @Override // com.bytedance.android.live.pushstream.f
    public final void d() {
        this.K.getClass();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void d1() {
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "LiveStream4 updateLandscapeDisplay 0");
        G();
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final nc1.a e() {
        if (this.w != null) goto L9;
        y r0 = this.v;
        com.bytedance.android.live.pushstream.a r1 = null;
        if (r0 == null) goto L7;
        r1 = new com.bytedance.android.live.pushstream.a(null, r0.e);
    L7:
        this.w = r1;
    L9:
        return this.w;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final JSONObject getClientInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final Map<String, String> getFpsInfo() {
        LinkedHashMap r0 = new LinkedHashMap();
        y r1 = this.v;
        double r2 = -1.0d;
        if (r1 == null) goto L5;
        double r4 = r1.a();
    L6:
        r0.put("videoCaptureFps", String.valueOf(r4));
        r0.put("streamFps", String.valueOf(this.k));
        d0 r3 = this.h;
        if (r3 == null) goto L11;
        z r5 = r3.C();
        if (r5 == null) goto L11;
        r2 = r5.a();
    L11:
        r0.put("previewFps", String.valueOf(r2));
        return r0;
    L5:
        r4 = -1.0d;
        goto L6
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void j0() {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void l0() {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void n() {
        K("startVideoCapture");
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L5;
        this.A.clear();
        x(Integer.valueOf(this.K.q));
        z();
    L5:
        y r0 = this.v;
        if (r0 == null) goto L10;
        d0 r1 = r0.e;
        if (r1 == null) goto L10;
        r1.e();
    L10:
        this.b.a = 1;
        this.K.getClass();
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void o() {
        K("stop");
        if (this.j == 2) goto L5;
        this.j = 0;
    L5:
        int r0 = com.bytedance.android.live.pushstream.utils.d.a;
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L8;
        this.A.clear();
        this.A.add("6");
        this.B.clear();
        this.B.add(DataType.FALSE);
    L8:
        d0 r1 = this.h;
        if (r1 == null) goto L11;
        r1.stop();
    L11:
        H("stopAudioCapture", "reason=stop live stream", "stop live stream");
        d0 r2 = this.h;
        if (r2 == null) goto L14;
        r2.f();
    L14:
        this.z = false;
        this.a.a = 4;
        if (((Boolean) LiveRoomStatesAndAVResourceUtils.g.getValue()).booleanValue() == false) goto L18;
        boolean r3 = com.bytedance.android.live.core.privacy.av.impl.g.a;
        com.bytedance.android.live.core.privacy.av.impl.g.f(hashCode());
        com.bytedance.android.live.core.privacy.av.impl.g.g(hashCode(), 0);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void q() {
        K("stopVideoCapture");
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L5;
        this.A.clear();
        this.A.add("6");
        this.B.clear();
        this.B.add(DataType.FALSE);
    L5:
        y r0 = this.v;
        if (r0 == null) goto L10;
        int r1 = com.bytedance.android.live.pushstream.utils.d.a;
        d0 r2 = r0.e;
        if (r2 == null) goto L10;
        r2.d();
    L10:
        this.b.a = 2;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void r1() {
        ei6.a r0 = this.i;
        if (r0 == null) goto L5;
        r0.a("releaseInteractEngine");
    L5:
        this.i = null;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void release() {
        ei6.a r0 = this.i;
        if (r0 == null) goto L5;
        r0.a("LiveStream release");
    L5:
        this.i = null;
        this.u.dispose();
        gm r1 = gm.a;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L10;
        com.bytedance.android.live.pushstream.utils.b r2 = this.s;
        if (r2 == null) goto L10;
        r2.quit();
    L10:
        ALogger.d("LiveUxTracer", "live stream 4, release #1: " + System.currentTimeMillis());
        d0 r3 = this.h;
        if (r3 == null) goto L13;
        r3.N();
    L13:
        ALogger.d("LiveUxTracer", "live stream 4, release #2: " + System.currentTimeMillis());
        d0 r4 = this.h;
        if (r4 == null) goto L16;
        r4.N();
    L16:
        ALogger.d("LiveUxTracer", "live stream 4, release #3: " + System.currentTimeMillis());
        d0 r5 = this.h;
        if (r5 == null) goto L19;
        r5.stop();
    L19:
        ALogger.d("LiveUxTracer", "live stream 4, release #4: " + System.currentTimeMillis());
        y r6 = this.v;
        if (r6 == null) goto L25;
        d0 r7 = r6.e;
        if (r7 == null) goto L24;
        r7.release();
    L24:
        r6.e = null;
        r6.b.clear();
        ((CompositeDisposable) r6.c.getValue()).dispose();
    L25:
        ALogger.d("LiveUxTracer", "live stream 4, release #5: " + System.currentTimeMillis());
        if (((Boolean) LiveRoomStatesAndAVResourceUtils.c.getValue()).booleanValue() == false) goto L30;
        ILiveAVResourceService r8 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (r8 == null) goto L30;
        r8.releaseByPassMonitor((String) this.E.getValue());
    L30:
        this.h = null;
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L36;
        com.bytedance.android.live.pushstream.utils.b r9 = this.s;
        if (r9 == null) goto L36;
        r9.quitSafely();
    L36:
        if (((Boolean) jq0.a.getValue()).booleanValue() == true) goto L38;
        this.p.removeCallbacksAndMessages(null);
    L38:
        this.e = null;
        this.f.clear();
        this.d.clear();
        ALogger.d("LiveUxTracer", "live stream 4, release #6: " + System.currentTimeMillis());
        this.a.a = 5;
        ALogger.d("LiveUxTracer", "live stream 4, release #7: " + System.currentTimeMillis());
        this.K.getClass();
        if (this.x == null) goto L44;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r10 = ILiveWrappedLivePusher.a.b();
        if (r10 == null) goto L43;
        r10.getSafeHandlerThreadPoolExecutor();
    L43:
        ALogger.i("GlThreadImp", BuildConfig.BUILD_TYPE);
    L44:
        boolean r12 = com.bytedance.android.live.core.privacy.av.impl.g.a;
        com.bytedance.android.live.core.privacy.av.impl.g.f(hashCode());
        com.bytedance.android.live.core.privacy.av.impl.g.g(hashCode(), 0);
        jc1.k.a.remove(IPushStreamDataManager.class);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void s() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.s();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void u() {
        d0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.u();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean u1() {
        d0 r0 = this.h;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.t0();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean w0() {
        if (this.m == false) goto L5;
    L8:
        return true;
    L5:
        if (this.z == false) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void x0() {
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "LiveStream4 updateSingleViewOneAnchor");
        JSONObject r1 = new JSONObject();
        G();
        r1.put("isVerticalLandScapeMode", false);
        dy.b.a.f("updateSingleViewOneAnchor", LiveTracingMonitor.EventModule.PK, r1);
        G();
        Logger.d("ttlive_stream_reuse_stream_horizontal", "updateSingleViewOneAnchor false");
        G();
        G();
        d0 r0 = this.h;
        if (r0 == null) goto L15;
        z r2 = r0.C();
        if (r2 == null) goto L16;
        z.a r3 = r2.K0();
        if (r3 == null) goto L17;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
        if (r4 == null) goto L13;
        m1.b r5 = r4.newVideoMixerDescription(null);
        if (r5 == null) goto L13;
        r5.i();
        r5.e();
        r5.b();
        r5.c();
        r5.f();
        r5.g();
        Unit r6 = Unit.INSTANCE;
    L13:
        r3.b();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0.a y0() {
        d0 r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBuilder();
    }

    public final void z() {
        this.B.clear();
        if (this.m == false) goto L5;
        this.B.add("2");
        return;
    L5:
        this.B.add(DataType.TRUE);
        this.K.getClass();
        this.K.getClass();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void E0() {
        v r0 = v.b();
        u r1 = this.K;
        d0.a r2 = this.o;
        r0.getClass();
        if (v.a() == false) goto L24;
        if (r1 == null) goto L25;
        int r3 = r1.u;
        if (r3 != 1) goto L11;
        String r4 = "avc";
    L14:
        r0.c("data_push_stream_encode_type", r4);
        StringBuilder r5 = new StringBuilder("width:");
        if (r2 == null) goto L17;
        int r6 = r2.getVideoWidth();
    L18:
        r5.append(r6);
        r5.append(", height：");
        if (r2 == null) goto L21;
        int r7 = r2.getVideoHeight();
    L22:
        r5.append(r7);
        r0.c("data_push_stream_resolution", r5.toString());
        return;
    L21:
        r7 = r1.j;
        goto L22
    L17:
        r6 = r1.i;
        goto L18
    L11:
        if (r3 != 2) goto L13;
        r4 = "bytevc1";
        goto L14
    L13:
        r4 = "";
        goto L14
    L25:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0 A() {
        return this.h;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean N() {
        return this.z;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int T0() {
        return this.r;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final ei6.a V0() {
        return this.i;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int W0() {
        return this.q;
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final Map<String, String> getLastAudioCaptureLogMap() {
        return this.C;
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final Map<String, String> getLastVideoCaptureLogMap() {
        return this.D;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final d0 getLiveCore() {
        return this.h;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final com.bytedance.android.live.pushstream.b.C0058b getStatus() {
        return this.a;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final View getSurfaceView() {
        return this.y;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final String j1() {
        return this.t;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final com.bytedance.android.live.pushstream.b.a s1() {
        return this.b;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final boolean t0() {
        return this.m;
    }

    public LiveStream4(u r15) {
        Intrinsics.checkNotNullParameter(r15, "config");
        this.K = r15;
        this.a = new com.bytedance.android.live.pushstream.b.C0058b();
        this.b = new com.bytedance.android.live.pushstream.b.a();
        this.d = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new ConcurrentHashMap();
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.p = new Handler(Looper.getMainLooper());
        this.t = r15.x;
        this.u = new CompositeDisposable();
        this.A = Collections.newSetFromMap(new ConcurrentHashMap());
        this.B = Collections.newSetFromMap(new ConcurrentHashMap());
        this.C = new LinkedHashMap();
        this.D = new LinkedHashMap();
        this.E = LazyKt.lazy(new LiveStream4$identityId$2(this));
        this.F = LazyKt.lazy(LiveStream4$isLogWithAppState$2.INSTANCE);
        this.G = new g(this);
        this.H = new b(this);
        new c(this);
        new e(this);
        new d();
        this.I = new f(this);
        IBroadcastService r16 = jc1.k.f(IBroadcastService.class);
        if (r16 == null) goto L5;
        r16.init();
    L5:
        RxUtilKt.n(Observable.just(1).subscribeOn(Schedulers.io()).map(j.a).filter(k.a).map(l.a).flatMapIterable(m.a).filter(n.a).map(o.a).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()), LiveStream4$checkPluginSOMD5$7.INSTANCE);
        ALogger.d("LiveUxTracer", "livestream4, init: begin, " + System.currentTimeMillis());
        d0 r2 = null;
        if (TextUtils.isEmpty(com.bytedance.android.live.pushstream.utils.c.a) == false) goto L39;
        PolarisFileReaderWrapper r0 = new PolarisFileReaderWrapper("/proc/cpuinfo");
        BufferedReader r3 = new BufferedReader(r0);     // Catch: Throwable -> L25
        String r5 = r3.readLine();     // Catch: Throwable -> L25
    L9:
        if (r5 != null) goto L11;
    L157:
        r0.close();     // Catch: Throwable -> L29
    L31:
        String r17 = "";
    L32:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        com.bytedance.android.live.pushstream.utils.c.a = r17;
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L11:
        if (StringsKt.contains$default(r5, "Hardware", false, 2, null) == false) goto L23;
        List r4 = StringsKt.split$default(r5, new char[]{':'}, false, 0, 6, null);     // Catch: Throwable -> L25
        if (r4.size() <= 1) goto L23;
        String r18 = (String) r4.get(1);     // Catch: Throwable -> L25
        if (r18 == null) goto L22;
        r17 = StringsKt.trim(r18).toString();     // Catch: Throwable -> L25
        r0.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L25
    L23:
        r5 = r3.readLine();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L36
    L38:
        throw th;
    L36:
        th = move-exception;
        th.printStackTrace();
    L39:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r19 = ILiveWrappedLivePusher.a.b();
        if (r19 == null) goto L42;
        r19.getMediaEngineFactory();
    L42:
        ILiveWrappedLivePusher r110 = ILiveWrappedLivePusher.a.b();
        if (r110 == null) goto L92;
        d0.a r111 = r110.newLiveCoreBuilder();
        if (r111 == null) goto L92;
        if (((w41) n40.a.getValue()).a() == true) goto L50;
        this.K.getClass();
    L50:
        r111.r0();
        this.K.getClass();
        this.K.getClass();
        r111.H();
        int r1 = this.K.k;
        r111.G();
        r111.j();
        r111.v();
        this.s = new com.bytedance.android.live.pushstream.utils.b((d0.a.a) WeakReferenceWrapper.wrap(this.I));
        r111.A();
        ((Integer) hm.a.getValue()).intValue();
        r111.x();
        Context r6 = this.K.a;
        r111.S();
        String r7 = this.K.w;
        r111.i0();
        r111.M();
        int r8 = this.K.f;
        r111.N();
        int r9 = this.K.c;
        r111.T();
        int r10 = this.K.e;
        r111.v0();
        int r12 = this.K.d;
        r111.F();
        int r13 = this.K.i;
        r111.g0();
        int r14 = this.K.j;
        r111.Q();
        this.K.getClass();
        r111.E();
        int r20 = this.K.q;
        r111.B();
        ((Boolean) lt.a.getValue()).booleanValue();
        r111.s();
        r111.a0();
        int r22 = this.K.o;
        r111.e();
        int r23 = this.K.o;
        r111.c0();
        int r24 = this.K.n;
        r111.c();
        int r25 = this.K.r;
        r111.k();
        this.K.getClass();
        r111.l();
        int r26 = this.K.l;
        r111.e0();
        r111.m0();
        int r27 = this.K.u;
        r111.o();
        boolean r28 = this.K.t;
        r111.I();
        float r29 = this.K.s;
        r111.m();
        this.K.getClass();
        r111.C();
        this.K.getClass();
        r111.i();
        this.K.getClass();
        r111.i();
        String r30 = this.K.v;
        r111.P();
        this.K.getClass();
        r111.p0();
        this.K.getClass();
        r111.X();
        this.K.getClass();
        r111.Y();
        this.K.getClass();
        this.K.getClass();
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "LiveStream4 createLiveStreamBuilder");
        G();
        String r32 = this.K.x;
        r111.a();
        this.K.getClass();
        int r33 = this.K.g;
        r111.t0();
        int r34 = this.K.h;
        r111.w();
        this.K.getClass();
        r111.b();
        this.K.getClass();
        r111.O();
        this.K.getClass();
        r111.n0();
        this.K.getClass();
        r111.j0();
        ((Boolean) mr.a.getValue()).booleanValue();
        r111.t();
        String r35 = (String) lq.a.getValue();
        r111.K();
        gd r36 = gd.a;
        ((ms1.i) r36.getValue()).getClass();
        r111.f();
        ((ms1.i) r36.getValue()).getClass();
        r111.d();
        if (((Boolean) gh.a.getValue()).booleanValue() == false) goto L53;
        r111.d0();
    L53:
        String r37 = this.K.y;
        r111.q();
        this.K.getClass();
        ALogger.i("livestream_external_audio", "open external audio");
        this.K.getClass();
        r111.h();
        this.K.getClass();
        this.q = r111.getVideoWidth();
        this.r = r111.getVideoHeight();
        this.K.getClass();
        this.K.getClass();
        PerformanceTestSettingKey r38 = PerformanceTestSettings.TEST_STREAM_CONFIG;
        if (r38.getValue() != null) goto L56;
    L91:
        G();
        this.K.getClass();
        r111.W();
        this.K.getClass();
        r111.J();
        this.K.getClass();
        this.K.getClass();
        this.K.getClass();
        r111.x0();
        this.K.getClass();
        r111.w0();
    L93:
        this.o = r111;
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_LIVE_CORE.getValue()).booleanValue() == true) goto L98;
        d0.a r112 = this.o;
        if (r112 == null) goto L101;
        r2 = r112.create();
    L101:
        this.h = r2;
        if (r2 == null) goto L104;
        r2.a0();
    L104:
        d0 r113 = this.h;
        if (r113 == null) goto L108;
        r113.z();
    L108:
        if (((Boolean) bq0.a.getValue()).booleanValue() == false) goto L111;
        this.K.getClass();
    L111:
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L115;
        d0 r114 = this.h;
        if (r114 == null) goto L115;
        r114.e0();
    L115:
        d0 r115 = this.h;
        if (r115 == null) goto L118;
        r115.N();
    L118:
        d0 r116 = this.h;
        if (r116 == null) goto L121;
        r116.N();
    L121:
        this.K.getClass();
        this.K.getClass();
        d0 r117 = this.h;
        if (r117 == null) goto L124;
        int r39 = com.bytedance.android.livesdk.utils.ntp.a.b;
        r117.P();
    L124:
        F(this, ((Boolean) u9.a.getValue()).booleanValue(), this.h, false, null, 12);
        u r40 = this.K;
        if (this.x != null) goto L133;
        this.x = new rv0.a();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r42 = ILiveWrappedLivePusher.a.b();
        if (r42 == null) goto L129;
        r42.getSafeHandlerThreadPoolExecutor();
    L129:
        ILiveWrappedLivePusher r43 = ILiveWrappedLivePusher.a.b();
        if (r43 == null) goto L132;
        r43.getSafeHandlerThreadPoolExecutor();
    L132:
        ALogger.i("GlThreadImp", "start null , useNaitveThread null");
    L133:
        this.K.getClass();
        this.v = new y(r40, new Handler(), this.G, this.h, this.o);
        if (v.a() == false) goto L136;
        E0();
    L136:
        jc1.k.l(IPushStreamDataManager.class, new s(this));
        this.K.getClass();
        this.K.getClass();
        this.K.getClass();
        d0 r118 = this.h;
        if (r118 == null) goto L139;
        r118.D();
    L139:
        d0 r119 = this.h;
        if (r119 == null) goto L142;
        r119.D();
    L142:
        ALogger.d("LiveUxTracer", "livestream4, init: end, " + System.currentTimeMillis());
        ILiveAVResourceService r120 = (ILiveAVResourceService) va1.b.a.a.a(ILiveAVResourceService.class);
        if (LiveRoomStatesAndAVResourceUtils.a() == false) goto L147;
        if (r120 == null) goto L147;
        r120.initPolicy();
    L147:
        if (((Boolean) LiveRoomStatesAndAVResourceUtils.c.getValue()).booleanValue() == false) goto L150;
        if (r120 == null) goto L150;
        r120.byPassMonitorStart((String) this.E.getValue());
    L150:
        this.J = (AVMonitorLogConfig) na1.a.getValue();
        return;
    L98:
        d0.a r121 = this.o;
        if (r121 == null) goto L101;
        r2 = r121.createDummy();
        goto L101
    L56:
        if (((m81) r38.getValue()).mEnable == false) goto L91;
        m81 r44 = (m81) r38.getValue();
        if (r44.mEnable == false) goto L90;
        JSONObject r45 = new JSONObject();
        JSONObject r46 = new JSONObject();     // Catch: Exception -> L87
        int r47 = r44.mWidth;     // Catch: Exception -> L87
        if (r47 <= 0) goto L64;
        r46.put("width", r47);     // Catch: Exception -> L87
    L64:
        int r48 = r44.mHeight;     // Catch: Exception -> L87
        if (r48 <= 0) goto L67;
        r46.put("height", r48);     // Catch: Exception -> L87
    L67:
        int r49 = r44.mDefaultBitrate;     // Catch: Exception -> L87
        if (r49 <= 0) goto L70;
        r46.put("defaultBitrate", r49);     // Catch: Exception -> L87
    L70:
        int r50 = r44.mMinBitrate;     // Catch: Exception -> L87
        if (r50 <= 0) goto L73;
        r46.put("minBitrate", r50);     // Catch: Exception -> L87
    L73:
        int r52 = r44.mMaxBitrate;     // Catch: Exception -> L87
        if (r52 <= 0) goto L76;
        r46.put("maxBitrate", r52);     // Catch: Exception -> L87
    L76:
        int r53 = r44.mFps;     // Catch: Exception -> L87
        if (r53 <= 0) goto L80;
        r46.put("fps", r53);     // Catch: Exception -> L87
    L80:
        if (TextUtils.isEmpty(r44.mVCodec) == true) goto L82;
        r46.put("vCodec", r44.mVCodec);     // Catch: Exception -> L87
    L82:
        r46.put("useHardware", r44.mUseHardware);     // Catch: Exception -> L87
        r45.put("PushBase", r46);     // Catch: Exception -> L87
        JSONObject r54 = new JSONObject();     // Catch: Exception -> L87
        JSONObject r55 = new JSONObject();     // Catch: Exception -> L87
        int r56 = r44.mCaptureFps;     // Catch: Exception -> L87
        if (r56 <= 0) goto L85;
        r55.put("videoCaptureFps", r56);     // Catch: Exception -> L87
    L85:
        r54.put("videoCapture", r55);     // Catch: Exception -> L87
        r45.put("CaptureBase", r54);     // Catch: Exception -> L87
    L89:
        r45.toString();
    L87:
        e = move-exception;
        e.printStackTrace();
    L90:
        r111.a();
    L92:
        r111 = null;
        goto L93
    }

    public static void K(String r1) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        ALogger.i("LiveStream4TAG", r1);
        return;
    }

    public static void Q(d0 r5) {
        if (r5 == null) goto L24;
        IFeatureService r0 = jc1.k.f(IFeatureService.class);
        if (r0 == null) goto L25;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L26;
        String r2 = jc1.k.n(IBroadcastApiService.class).getCurrentResolutionKey();
        FeatureType r3 = FeatureType.MONITOR;
        r1.i("anchor_push_resolution", r2, r3);
        d0.a r4 = r5.getBuilder();
        Integer r6 = null;
        if (r4 == null) goto L10;
        Integer r7 = Integer.valueOf(r4.z());
    L11:
        r1.i("anchor_push_fps", r7, r3);
        d0.a r8 = r5.getBuilder();
        if (r8 == null) goto L14;
        Integer r9 = Integer.valueOf(r8.Z());
    L15:
        r1.i("anchor_push_max_bitrate", r9, r3);
        d0.a r10 = r5.getBuilder();
        if (r10 == null) goto L18;
        Integer r12 = Integer.valueOf(r10.y());
    L19:
        r1.i("anchor_push_min_bitrate", r12, r3);
        d0.a r13 = r5.getBuilder();
        if (r13 == null) goto L22;
        r6 = Integer.valueOf(r13.U());
    L22:
        r1.i("anchor_push_default_bitrate", r6, r3);
        return;
    L18:
        r12 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L10:
        r7 = null;
        goto L11
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void A0(String r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.h0();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void B(String r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.v();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void D0(h0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.d.contains(r2) == true) goto L6;
        this.d.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void I0(h0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.f.contains(r2) == true) goto L6;
        this.f.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void K0(View r3) {
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "LiveStream4 setSurfaceView");
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_STREAM_PREVIEW.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        this.y = r3;
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "liveStream4 isVerticalLandScape");
        G();
        ALogger.i("ttlive_anchor_livestream_PreviewLandScapeAdaptWidget", "setSurfaceView false");
        G();
        d0 r4 = this.h;
        if (r4 == null) goto L9;
        r4.x();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void L0(h0.b r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void O(boolean r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.o0();
        return;
    }

    public final void R(Integer r3) {
        this.A.clear();
        if (r3 != null) goto L16;
        Set<String> r4 = this.A;
        y r0 = this.v;
        if (r0 == null) goto L14;
        d0 r1 = r0.e;
        int r2 = 1;
        if (r1 == null) goto L13;
        d0.a r5 = r1.getBuilder();
        if (r5 == null) goto L13;
        if (r5.g() != 1) goto L13;
        r2 = 2;
    L13:
        Integer r6 = Integer.valueOf(r2);
    L15:
        r4.add(String.valueOf(r6));
        return;
    L14:
        r6 = null;
        goto L15
    L16:
        x(r3);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void S0(h0.e r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.g0();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void Y0(int r2) {
        nc1.a r0 = e();
        if (r0 == null) goto L6;
        ((com.bytedance.android.live.pushstream.a) r0).d(r2);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void a1(float r2) {
        if (r2 >= 0.0f) goto L5;
        return;
    L5:
        if (r2 > 2.0f) goto L11;
        d0 r3 = this.h;
        if (r3 == null) goto L12;
        r3.O();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void b1(String r2) {
        y r0 = this.v;
        if (r0 == null) goto L8;
        r0.b(r2);
        d0 r3 = r0.e;
        if (r3 == null) goto L9;
        r3.A();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void e1(h0.b r2) {
        if (this.d.contains(r2) == false) goto L6;
        this.d.remove(r2);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.d
    public final void f(RadioWidget.e r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.l0();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void f0(boolean r2) {
        k0(r2, null, null);
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void g(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        K("pause ".concat(r8));
        long r1 = this.K.m;
        if (r1 <= 0) goto L6;
        this.p.postDelayed(this.H, r1);
    L6:
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L46;
        int r2 = this.a.a;
        if (r2 != 3) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L20;
        this.A.clear();
        this.A.add("6");
        this.A.add("9");
        this.B.clear();
        if (this.m == true) goto L19;
        this.B.add(DataType.FALSE);
        goto L20
    L19:
        this.B.add("2");
    L20:
        d0 r4 = this.h;
        if (r4 == null) goto L25;
        d0.a r5 = r4.getBuilder();
        if (r5 == null) goto L25;
        r5.p0();
    L25:
        IAiService r6 = jc1.k.f(IAiService.class);
        if (r6 == null) goto L28;
        r6.anchorAiService();
    L28:
        IAiService r7 = jc1.k.f(IAiService.class);
        if (r7 == null) goto L32;
        r7.anchorAiService();
    L32:
        if (((Boolean) mi.a.getValue()).booleanValue() == false) goto L46;
        w0 r9 = (w0) LiveInfraSettingKeys.LIVE_BROADCAST_PAUSE_NEW_STYLE.getValue();
        if (r9.a() == false) goto L46;
        if (TextUtils.isEmpty(r9.b()) == true) goto L46;
        if (TextUtils.isEmpty(r9.c()) == true) goto L46;
        String[] r10 = new String[1];
        this.K.getClass();
        String r12 = r9.c();
        if (r12 != null) goto L43;
        r12 = "";
    L43:
        r10[0] = r12;
        Disposable r13 = a1.k(new ImageModel(null, CollectionsKt.mutableListOf(r10))).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this), i.a);
        if (r13 == null) goto L46;
        RxUtilKt.c(r13, this.u);
        goto L46
    L10:
        if (r2 == 6) goto L13;
        r3 = false;
    L46:
        ALogger.e("create_duration", new Exception());
        int r14 = com.bytedance.android.live.pushstream.utils.d.a;
        H("pause", "reason=".concat(r8), r8);
        ei6.a r15 = this.i;
        if (r15 == null) goto L49;
        r15.pause();
    L49:
        y r16 = this.v;
        if (r16 == null) goto L54;
        Intrinsics.checkNotNullParameter(r8, "reason");
        d0 r17 = r16.e;
        if (r17 == null) goto L54;
        r17.pause();
    L54:
        this.a.a = 3;
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void g0(boolean r1) {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final ei6.a g1(fi6.a r12) {
        Intrinsics.checkNotNullParameter(r12, "config");
        String r0 = jc1.k.n(IMiddleWareHostContext.class).getChannel();
        Intrinsics.checkNotNullParameter(r0, "channel");
        r12.y = r0;
        String r1 = jc1.k.n(IMiddleWareHostContext.class).getServerDeviceId();
        Intrinsics.checkNotNullParameter(r1, "deviceId");
        r12.x = r1;
        r12.k = true;
        r12.l = false;
        r12.I = ((Boolean) bt.a.getValue()).booleanValue();
        r12.L = true;
        List r2 = (List) j60.a.getValue();
        Intrinsics.checkNotNullParameter(r2, "list");
        r12.M = r2;
        ((Boolean) s60.a.getValue()).booleanValue();
        r12.getClass();
        r12.a = ((Boolean) u60.a.getValue()).booleanValue();
        r12.b = ((Boolean) t60.a.getValue()).booleanValue();
        na1 r3 = na1.a;
        if (((AVMonitorLogConfig) r3.getValue()).enable == false) goto L5;
        r12.m = true;
        r12.n = ((AVMonitorLogConfig) r3.getValue()).stackTraceDepth;
    L5:
        final ILinkServiceExternal r4 = jc1.k.f(ILinkServiceExternal.class);
        if (this.i != null) goto L19;
        monitor-enter(LiveStream4.class);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.i != null) goto L12;
        this.i = jc1.k.n(IAndroidLiveLinkService.class).createLiveLinkService();     // Catch: Throwable -> L15
    L12:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(LiveStream4.class);
    L19:
        if (this.i == null) goto L33;
        v r6 = v.b();
        ei6.a r7 = this.i;
        r6.getClass();
        if (v.a() == false) goto L24;
        r7.b();
    L24:
        Character r8 = r12.D;
        if (r8 != Character.GUEST) goto L27;
    L32:
        r12.L = true;
        F(this, false, null, true, this.i, 3);
        goto L33
    L27:
        if (r8 == Character.ANCHOR) goto L29;
    L31:
        r12.L = false;
        goto L33
    L29:
        if (((Boolean) h60.a.getValue()).booleanValue() == true) goto L31;
    L33:
        ei6.a r9 = this.i;
        if (r9 != null) goto L36;
    L45:
        ei6.a r10 = this.i;
        if (r10 == null) goto L49;
        r10.update(r12);
    L49:
        return this.i;
    L36:
        if (r9.isInit() == true) goto L45;
        ei6.a r13 = this.i;
        if (r13 == null) goto L40;
        r13.q(r12, new ji6.a(this.h));
    L40:
        xs2.b.a().post(new pv0.a());
        final Ref.LongRef r14 = new Ref.LongRef();
        r14.element = 0;
        ei6.a r15 = this.i;
        if (r15 == null) goto L49;
        gi6.e r16 = r15.getEventManager();
        if (r16 == null) goto L49;
        r16.a(EventCategory.SEI_MANAGER, gi6.j.a.b, new LiveStream4$create$2(r14, r4));
        goto L49
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        K("resume ".concat(r4));
        H("resume", "reason=".concat(r4), r4);
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L11;
        this.A.clear();
        x(Integer.valueOf(this.K.q));
        z();
        IAiService r1 = jc1.k.f(IAiService.class);
        if (r1 == null) goto L7;
        r1.anchorAiService();
    L7:
        IAiService r2 = jc1.k.f(IAiService.class);
        if (r2 == null) goto L11;
        r2.anchorAiService();
    L11:
        if (((Boolean) ku0.a.getValue()).booleanValue() == true) goto L13;
    L21:
        ei6.a r3 = this.i;
        if (r3 == null) goto L24;
        r3.resume();
    L24:
        y r5 = this.v;
        if (r5 == null) goto L29;
        Intrinsics.checkNotNullParameter(r4, "reason");
        d0 r6 = r5.e;
        if (r6 == null) goto L29;
        r6.resume();
    L29:
        this.p.removeCallbacks(this.H);
        this.a.a = 2;
        return;
    L13:
        if (this.z == true) goto L21;
        if ((!Intrinsics.areEqual(r4, "video talk link view init")) == false) goto L21;
        if ((!Intrinsics.areEqual(r4, "live_resume_in_preview")) == false) goto L21;
        if ((!Intrinsics.areEqual(r4, "live_preview_saas")) == false) goto L21;
        m("live resume");
        goto L21
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void h0(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.a.b r1) {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void h1(h0.c r2) {
        if (this.f.contains(r2) == false) goto L6;
        this.f.remove(r2);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void k(String r2) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_PUSH_STREAM.getValue()).booleanValue() == false) goto L6;
        return;
    L6:
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        String r4 = this.K.b;
    L14:
        K("startCaptureSource");
        this.K.getClass();
        d0 r5 = this.h;
        if (r5 == null) goto L17;
        r5.K();
    L17:
        this.z = true;
        d0 r6 = this.h;
        if (r6 == null) goto L20;
        r6.start();
    L20:
        this.a.a = 1;
        if (jc1.k.f(IPushStreamDataManager.class) == null) goto L23;
        return;
    L23:
        if (jc1.a.c() == false) goto L27;
        jc1.k.l(IPushStreamDataManager.class, new s(this));
        return;
    L27:
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void l(List<String> r5) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_PUSH_STREAM.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        List<String> r0 = r5;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L16;
        ALogger.i("zbd-test-push", "url = " + this.K.b);
        k(this.K.b);
        return;
    L16:
        ALogger.i("zbd-test-push", "urlList = " + r5.size());
        K("startCaptureSource");
        this.K.getClass();
        d0 r6 = this.h;
        if (r6 == null) goto L19;
        r6.K();
    L19:
        this.z = true;
        d0 r7 = this.h;
        if (r7 == null) goto L22;
        r7.i();
    L22:
        this.a.a = 1;
        if (jc1.k.f(IPushStreamDataManager.class) == null) goto L25;
        return;
    L25:
        if (jc1.a.c() == false) goto L29;
        jc1.k.l(IPushStreamDataManager.class, new s(this));
        return;
    L29:
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.pushstream.b
    @Deprecated(message = "视频相关的设置一定不要走这个方法")
    public final void l1(b1 r1) {
        y r2 = this.v;
        if (r2 == null) goto L8;
        d0 r3 = r2.a;
        if (r3 == null) goto L9;
        r3.S();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void m(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        K("startAudioCapture " + r3);
        H("startAudioCapture", "reason=" + r3, r3);
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L5;
        z();
    L5:
        d0 r4 = this.h;
        if (r4 == null) goto L8;
        r4.K();
    L8:
        this.z = true;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void m1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "streamControlMessage");
        d0 r3 = this.h;
        if (r3 == null) goto L6;
        r3.B();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void n1(int r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.V();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void o1(q0 r4) {
        y r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b.contains(r4) == true) goto L20;
        r0.b.add(r4);
        d0 r1 = r0.e;
        int r2 = -1;
        if (r1 == null) goto L11;
        d0.a r3 = r1.getBuilder();
        if (r3 == null) goto L11;
        int r5 = r3.u();
    L12:
        d0 r6 = r0.e;
        if (r6 == null) goto L17;
        d0.a r7 = r6.getBuilder();
        if (r7 == null) goto L17;
        r2 = r7.h0();
    L17:
        r4.a(r5, r2);
        return;
    L11:
        r5 = -1;
        goto L12
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void p(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        K("stopAudioCapture " + r3);
        int r0 = com.bytedance.android.live.pushstream.utils.d.a;
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L5;
        this.B.clear();
        this.B.add(DataType.FALSE);
    L5:
        H("stopAudioCapture", "reason=" + r3, r3);
        d0 r4 = this.h;
        if (r4 == null) goto L8;
        r4.f();
    L8:
        this.z = false;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void p1(float r4) {
        Intrinsics.checkNotNullParameter("perf on freeze", "reason");
        H("setMicVolume", "volume=" + r4 + ", reason=perf on freeze", "perf on freeze");
        d0 r5 = this.h;
        if (r5 == null) goto L6;
        r5.h();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void startZoom(float r3) {
        y r0 = this.v;
        if (r0 == null) goto L9;
        d0 r1 = r0.e;
        if (r1 == null) goto L7;
        r1.p();
    L7:
        ALogger.i("LiveStream", "start Zoom:Ratio:" + r3 + ",result:null");
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void t(boolean r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L6;
        r2.N();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void t1(boolean r2) {
        y r0 = this.v;
        if (r0 == null) goto L12;
        if (r2 == false) goto L8;
        d0 r3 = r0.e;
        if (r3 == null) goto L13;
        r3.p();
        return;
    L13:
        return;
    L8:
        d0 r4 = r0.e;
        if (r4 == null) goto L15;
        r4.p();
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void v(int r4) {
        R(Integer.valueOf(r4));
        y r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) fj.a.getValue()).booleanValue() == false) goto L8;
        int r1 = com.bytedance.android.live.pushstream.utils.d.a;
        r0.d.getClass();
        com.bytedance.android.live.pushstream.utils.d.a(r4, r4);
    L8:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        ALogger.w("LiveStream", "switchVideoCapture with params videoCaptureDevice = " + r4, new IllegalStateException());
    L10:
        d0 r5 = r0.e;
        if (r5 == null) goto L15;
        r5.o();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void v1(RtcManager.g r1) {
        this.e = r1;
    }

    public final void x(Integer r3) {
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L10;
    L12:
        if (r3 != null) goto L15;
    L17:
        if (r3 != null) goto L20;
    L22:
        if (r3 != null) goto L25;
    L27:
        if (r3 != null) goto L30;
        return;
    L30:
        if (r3.intValue() != 5) goto L38;
        this.A.add("7");
        return;
    L38:
        return;
    L25:
        if (r3.intValue() != 3) goto L27;
        this.A.add("5");
        return;
    L20:
        if (r3.intValue() != 4) goto L22;
        this.A.add("6");
        return;
    L15:
        if (r3.intValue() != 2) goto L17;
        this.K.getClass();
        this.A.add("2");
        return;
    L10:
        if (r3.intValue() != 1) goto L12;
        this.K.getClass();
        this.A.add(DataType.TRUE);
        return;
    L5:
        if (r3.intValue() != 0) goto L7;
        this.A.add(DataType.FALSE);
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void y(String r1) {
        d0 r2 = this.h;
        if (r2 == null) goto L5;
        r2.A();
    L5:
        Q(this.h);
    }

    public static final double w(LiveStream4 r0, String r1) {
        r0.getClass();
        return -1.0d;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void F0(Bundle r1, com.bytedance.android.live.broadcastgame.opengame.service.g r2) {
        d0 r3 = this.h;
        if (r3 == null) goto L6;
        r3.i0();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void H0(String r2, sk0.a.a r3) {
        y r0 = this.v;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void O0(com.bytedance.android.live.broadcast.api.camera.b r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "dirtyDetectCallBack");
        Intrinsics.checkNotNullParameter(r4, "path");
        if (this.v == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "dirtyDetectCallBack");
        Intrinsics.checkNotNullParameter(r4, "modelPath");
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void P0(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        y r1 = this.v;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r7, "reason");
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("fps", r6);
        Unit r4 = Unit.INSTANCE;
        r2.put("PushBase", r3);
        r2.toString();
        d0 r5 = r1.e;
        if (r5 == null) goto L7;
        r5.A();
    L7:
        int r8 = vv0.b.a;
        Intrinsics.checkNotNullParameter(r7, "reason");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_anchor_prefix_change_video_fps", null, null, 14);
        r0.l(0);
        r0.c(r7);
        r0.i("target_fps", Integer.valueOf(r6));
        r0.a().report();
    L8:
        Q(this.h);
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void e0(String r1, String r2) {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void i(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        H("setAudioMute", "mute=" + r3 + ", reason=" + r4, r4);
        this.m = r3;
        if (((Boolean) ni.a.getValue()).booleanValue() == false) goto L8;
        this.B.clear();
        if (this.m == false) goto L7;
        this.B.add("2");
        goto L8
    L7:
        this.B.add(DataType.TRUE);
    L8:
        d0 r5 = this.h;
        if (r5 == null) goto L12;
        r5.k();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.e
    public final void j(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        H("setAudioMute", "mute=" + r3 + ", reason=" + r4, r4);
        d0 r5 = this.h;
        if (r5 == null) goto L6;
        r5.k();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final void z0(int r5, int r6) {
        y r0 = this.v;
        if (r0 == null) goto L7;
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r2.put("width", r5);
        r2.put("height", r6);
        Unit r7 = Unit.INSTANCE;
        r1.put("PushBase", r2);
        r1.toString();
        d0 r8 = r0.e;
        if (r8 == null) goto L7;
        r8.A();
    L7:
        Q(this.h);
    }

    public final void H(String r6, String r7, String r8) {
        JSONObject r0 = new JSONObject();
        IInteractService r1 = jc1.k.f(IInteractService.class);
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getCurrentScene();
    L6:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L9;
        r2 = r4.getCurUILayout();
    L9:
        r0.put("event_key", r6).put("reason", r8).put(Constants.OperatorKey.MSG, r7).put("multi_link_scene", r3).put("multi_link_ui_layout", r2);
        AVMonitorLogConfig r9 = this.J;
        if (r9.stackTrace == false) goto L15;
        int r10 = r9.stackTraceDepth;
        StackTraceElement[] r12 = ThreadMethodProxy.currentThread().getStackTrace();
        StringBuilder r5 = new StringBuilder();
        int r13 = Math.min(r10, r12.length);
        int r14 = 2;
    L12:
        if (r14 >= r13) goto L14;
        r5.append(r12[r14].toString());
        r5.append("\n");
        r14 = r14 + 1;
        goto L12
    L14:
        r0.put("stack_trace", r5.toString());
    L15:
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L20;
        r15.onLiveCoreAVLinkLogMonitor(LiveTracingMonitor.EventType.SDK_INTERFACE_CALL.getName(), r6, r0);
        return;
    L20:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void i0(int r1, int r2, String r3) {
        this.K.getClass();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void k0(boolean r1, Pair<Integer, Integer> r2, Boolean r3) {
        this.K.getClass();
        E();
        if (r2 == null) goto L5;
        E();
    L5:
        if (r3 == null) goto L8;
        r3.booleanValue();
        E();
        return;
    }

    @Override // com.bytedance.android.live.pushstream.c
    public final void m0(uf2.p.c r1, uf2.p.b r2, uf2.p.a r3) {
        this.K.getClass();
        E();
        E();
        E();
    }

    @Override // com.bytedance.android.live.pushstream.b
    public final int c1(String r1, Object r2, int r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "key");
        d0 r6 = this.h;
        if (r6 != null) goto L7;
        return -1;
    L7:
        return r6.X();
    }

    public static void F(LiveStream4 r4, boolean r5, d0 r6, boolean r7, ei6.a r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r6 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r7 = false;
    L12:
        if ((r9 & 8) == 0) goto L14;
        r8 = null;
    L14:
        r4.getClass();
        if (r5 == true) goto L17;
        if (r7 == true) goto L17;
        return;
    L17:
        File r10 = jc1.a.b().getApplicationContext().getExternalCacheDir();
        if (r10 == null) goto L21;
        String r12 = r10.getPath();
        if (r12 == null) goto L21;
    L22:
        if (r12 == null) goto L35;
        StringBuilder r13 = new StringBuilder(r12);
        String r14 = File.separator;
        r13.append(r14);
        r13.append("audio_metrics");
        r13.append(r14);
        String r15 = r13.toString();
        PolarisFileWrapper r16 = new PolarisFileWrapper(r15);     // Catch: Exception -> L29
        if (r16.exists() == true) goto L27;
        r16.mkdirs();     // Catch: Exception -> L29
    L27:
        PolarisFileWrapper r17 = new PolarisFileWrapper(r15 + "audio_metrics_v1.3.model");     // Catch: Exception -> L29
        ALogger.d("AudioSamiDiagnosisImpl", "createLiveStream: file.exists(): " + r17.exists() + "file size: " + r17.length());     // Catch: Exception -> L29
        RxUtilKt.c(Observable.fromCallable(new p(r17)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r15, r6, r8), r.a), r4.u);     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        ALogger.e("AudioSamiDiagnosisImpl", "createLiveStream: e: " + e);
        String r18 = "AudioSamiDiagnosisImpl " + e.getMessage();
        SettingKey r19 = LiveTracingMonitor.a;
        IHostMonitor r20 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r20 == null) goto L39;
        r20.ensureNotReachHere(e, r18);
        return;
    L39:
        return;
    L35:
        throw new IllegalArgumentException("Required value was null.".toString());
    L21:
        r12 = jc1.a.b().getApplicationContext().getCacheDir().getPath();
        goto L22
    }
}

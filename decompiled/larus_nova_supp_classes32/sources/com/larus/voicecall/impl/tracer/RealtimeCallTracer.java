package com.larus.voicecall.impl.tracer;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.y0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.larus.utils.z0;
import com.larus.voice.output.volume.IVolumeService;
import com.larus.voice_setting.voice.n2;
import com.larus.voicecall.impl.component.denoise.DenoiseStatusRes;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.x0;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import com.obric.assistant.spi.performance.IObricMemoryReportSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.d3;
import tx9.g3;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallTracer implements IRealtimeCallTracer, com.larus.audio.call.tracer.c {
    public static final /* synthetic */ int s0 = 0;
    public long A;
    public long B;
    public long C;
    public int D;
    public boolean E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public IRealtimeCallTracer.HelloStatus L;
    public Function0<String> M;
    public final Map<String, Long> N;
    public boolean O;
    public int P;
    public String Q;
    public long R;
    public long S;
    public String T;
    public String U;
    public long V;
    public boolean W;
    public int X;
    public final Map<String, Object> Y;
    public final Map<String, Object> Z;
    public final /* synthetic */ com.larus.audio.call.tracer.e a;
    public final Map<String, Object> a0;
    public final Function0<RealtimeCallParam> b;
    public final Map<IRealtimeCallTracer.TotalTimeType, Long> b0;
    public jd9.c c;
    public final Map<IRealtimeCallTracer.TotalTimeType, y> c0;
    public String d;
    public long d0;
    public String e;
    public long e0;
    public int f;
    public String f0;
    public long g;
    public String g0;
    public long h;
    public String h0;
    public boolean i;
    public String i0;
    public boolean j;
    public long j0;
    public long k;
    public long k0;
    public long l;
    public long l0;
    public long m;
    public long m0;
    public long n;
    public final b n0;
    public long o;
    public boolean o0;
    public long p;
    public final HashSet<String> p0;
    public long q;
    public String q0;
    public long r;
    public int r0;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public long w;
    public long x;
    public long y;
    public long z;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ RealtimeCallTracer a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            RealtimeCallTracer r0 = this.a;
            r0.m0 = SystemClock.elapsedRealtime();
            RealtimeCallTracer r1 = this.a;
            if (r1.i == false) goto L6;
            r1.H0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_IN_APP);
            return;
        }

        public final void onAppForeground() {
            RealtimeCallTracer r0 = this.a;
            if (r0.i == false) goto L5;
            r0.G0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_IN_APP);
        L5:
            RealtimeCallTracer r1 = this.a;
            if (r1.m0 <= 0) goto L9;
            long r2 = r1.l0;
            long r5 = SystemClock.elapsedRealtime();
            RealtimeCallTracer r7 = this.a;
            r1.l0 = r2 + (r5 - r7.m0);
            r7.m0 = 0;
            return;
        }

        public b(RealtimeCallTracer r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void N(RealtimeCallParam r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "comfortType");
        this.a.N(r2, r3, r4);
    }

    public final void W() {
        this.D = 1;
    }

    public final void X(String r1, RealtimeCallParam r2) {
        this.a.getClass();
    }

    public final void Y(long r1, long r3, long r5) {
        this.a.getClass();
    }

    public final void b0(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void g() {
        this.O = false;
        this.m = System.currentTimeMillis();
    }

    public final void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.AUDIO_TYPE);
    }

    public final void onSessionStarted() {
        this.a.getClass();
    }

    public final void s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    public final void t0() {
    }

    public static String x0() {
        return "default-" + UUID.randomUUID();
    }

    public final void F0() {
        FLogger.a.i("RealtimeCallTracer", "onDestroy, removeAppBackGroundListener");
        AppHost.a.a().c(this.n0);
    }

    public final void I() {
        this.e = this.d;
    }

    public final void S() {
        m58.r r0 = m58.h.c;
        if (r0 == null) goto L6;
        r0.f(this.f0);
        return;
    }

    public final void c() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        if (this.G != (-1)) goto L6;
        this.G = System.currentTimeMillis();     // Catch: Throwable -> L10
    L6:
        if (this.p == (-1)) goto L8;
        RealtimeCallTracerReporterKt.e(this);     // Catch: Throwable -> L10
    L8:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L19;
        FLogger.a.e("RealtimeCallTracer", "on onPlayFirstFrame error. msg=" + r2);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void o0() {
        if (this.y <= 0) goto L6;
        this.z += System.currentTimeMillis() - this.y;
        this.y = 0;
        G0(IRealtimeCallTracer.TotalTimeType.MUTE);
        return;
    }

    public final void s0() {
        if (this.s == false) goto L6;
        this.s = false;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.p = -1;
        this.A = 0;
        this.q = -1;
        this.r = -1;
        this.t = true;
        this.v = true;
        this.B++;
        return;
    }

    public final void t() {
        if (this.s == false) goto L6;
        this.s = false;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.q = -1;
        this.r = -1;
        this.t = true;
        this.v = true;
        this.B++;
        return;
    }

    public final void u0() {
        if (this.G != (-1)) goto L6;
        this.G = System.currentTimeMillis();
        return;
    }

    public final String y0() {
        return ((RealtimeCallParam) this.b.invoke()).p.i;
    }

    public final String z0() {
        Function0<String> r0 = this.M;
        if (r0 == null) goto L6;
        String r1 = (String) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "call";
    }

    public final void E() {
        this.m = System.currentTimeMillis();
    }

    public final void i0() {
        p(x0());
    }

    public final void n0() {
        System.currentTimeMillis();
        this.G = -1;
    }

    public final void r() {
        this.l = System.currentTimeMillis();
        IVolumeService r0 = (IVolumeService) ServiceManager.get().getService(IVolumeService.class);
        if (r0 == null) goto L9;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("uni_id", this.f0);
        RealtimeCallUtil.a.getClass();
        r1.put("bot_id", RealtimeCallUtil.w);
        String r2 = RealtimeCallUtil.x;
        if (r2 != null) goto L7;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r1.put("conversation_id", r2);
        Unit r3 = Unit.INSTANCE;
        r0.a(r1);
        return;
    }

    public final boolean R() {
        return this.j;
    }

    public RealtimeCallTracer(Function0 r5) {
        this.a = new com.larus.audio.call.tracer.e();
        this.b = r5;
        this.c = jd9.c.f.c;
        this.d = LynxUIWebView.DEFAULT;
        this.e = LynxUIWebView.DEFAULT;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = true;
        this.t = true;
        this.v = true;
        this.w = -1;
        this.y = -1;
        this.A = -1;
        this.G = -1;
        this.L = IRealtimeCallTracer.HelloStatus.HELLO_RESET;
        this.N = new LinkedHashMap();
        this.O = true;
        this.P = -999999;
        this.T = NameKeys.UnloadStrategy_No_Strategy;
        this.U = NameKeys.UnloadStrategy_No_Strategy;
        this.Y = new LinkedHashMap();
        this.Z = new LinkedHashMap();
        this.a0 = new LinkedHashMap();
        this.b0 = new LinkedHashMap();
        this.c0 = new LinkedHashMap();
        this.f0 = x0();
        b r0 = new b(this);
        this.n0 = r0;
        FLogger.a.i("RealtimeCallTracer", "init, addAppBackGroundListener");
        AppHost.a.a().j(r0);
        this.o0 = true;
        this.p0 = new HashSet();
    }

    public final long A0(IRealtimeCallTracer.TotalTimeType r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        y r7 = (y) ((LinkedHashMap) this.c0).get(r6);
        if (r7 != null) goto L5;
        return 0;
    L5:
        if (r7.b <= 0) goto L8;
        return (SystemClock.elapsedRealtime() - r7.b) + r7.a;
    L8:
        return r7.a;
    }

    public final void B0(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator r0 = ((LinkedHashMap) this.Z).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r4.put((String) r1.getKey(), r1.getValue());
        goto L4
    }

    public final void C(RealtimeCallParam r8) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        if (this.w <= 0) goto L5;
        this.x += System.currentTimeMillis() - this.w;
        this.w = 0;
        G0(IRealtimeCallTracer.TotalTimeType.PAUSE);
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onResumeCall$1(this, r8, 7, null), 2, null);
    }

    public final void D(boolean r5) {
        if (r5 == false) goto L4;
        this.R = SystemClock.elapsedRealtime() - this.R;
        this.N.put("on_view_created_1", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L4:
        this.N.put("on_view_created_2", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void F(boolean r3) {
        this.u = r3;
        if (this.t == false) goto L6;
        this.t = false;
        this.q = System.currentTimeMillis();
        this.V = 0;
        return;
    }

    public final void G(boolean r1) {
        this.W = r1;
    }

    public final void G0(IRealtimeCallTracer.TotalTimeType r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        y r10 = (y) ((LinkedHashMap) this.c0).get(r9);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.b <= 0) goto L7;
        r10.a += SystemClock.elapsedRealtime() - r10.b;
    L7:
        r10.b = 0;
    }

    public final void H0(IRealtimeCallTracer.TotalTimeType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (this.c0.containsKey(r3) == true) goto L5;
        this.c0.put(r3, new y(r3));
    L5:
        y r4 = (y) ((LinkedHashMap) this.c0).get(r3);
        if (r4 == null) goto L9;
        r4.b = SystemClock.elapsedRealtime();
        return;
    }

    public final void I0(String r9) {
        this.X = r9.length();
        ((LinkedHashMap) this.Y).clear();
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter("onChatResReplyUpdate", "logTag");
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L24
        zd9.h r4 = zd9.h.a;     // Catch: Throwable -> L24
        if (StringsKt.isBlank(r9) == false) goto L28;
    L15:
        Object r10 = null;
    L16:
        Map r11 = (Map) r10;     // Catch: Throwable -> L24
        if (r11 != null) goto L19;
        r11 = MapsKt.emptyMap();     // Catch: Throwable -> L24
    L19:
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L24
    L20:
        if (r12.hasNext() == false) goto L26;
        Map.Entry r0 = (Map.Entry) r12.next();     // Catch: Throwable -> L24
        r3.put(String.valueOf(r0.getKey()), String.valueOf(r0.getValue()));     // Catch: Throwable -> L24
    L26:
        this.Y.putAll(r3);
        return;
    L28:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        r4.getClass();     // Catch: Throwable -> L8
        r10 = Result.constructor-impl(zd9.h.b.fromJson(r9, new t().getType()));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L24
        if (r6 == null) goto L14;
        com.larus.im.internal.delegate.c0 r7 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L24
        StringBuilder r8 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L24
        r8.append(ExceptionsKt.stackTraceToString(r6));     // Catch: Throwable -> L24
        r7.e("GsonHolder", r8.toString());     // Catch: Throwable -> L24
    L14:
        if (Result.isFailure-impl(r10) == false) goto L16;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L24
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        FLogger.a.e("onChatResReplyUpdate", "toStringMap err=" + th.getMessage());
        r3 = new LinkedHashMap();
        goto L26
    }

    public final void K(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "serverInfo");
        Intrinsics.checkNotNullParameter(r2, "serverInfo");
        ((LinkedHashMap) this.Z).clear();
        this.Z.putAll(r2);
    }

    public final void c0(long r4) {
        if (r4 < 0) goto L6;
        this.F += r4;
        return;
    }

    public final void d(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        x58.a r0 = m58.h.a;
        m58.r r1 = m58.h.c;
        if (r1 == null) goto L6;
        r1.g(r2.a);
        return;
    }

    public final void f0(boolean r3) {
        if (r3 == false) goto L4;
        this.N.put("on_create_view_1", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L4:
        this.N.put("on_create_view_2", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void h(jd9.c r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        if ((r9 instanceof jd9.c.a) == false) goto L8;
        if (this.h <= 0) goto L8;
        this.g += SystemClock.elapsedRealtime() - this.h;
        this.h = 0;
    L8:
        if ((this.c instanceof jd9.c.a) == false) goto L10;
        this.f++;
        this.h = SystemClock.elapsedRealtime();
    L10:
        this.c = r9;
    }

    public final void j0(boolean r3) {
        if (r3 == false) goto L4;
        this.N.put("on_resume_1", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L4:
        this.N.put("on_resume_2", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void k(long r1) {
        this.k = r1;
    }

    public final void m0(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONObject r6 = p0.b(r5);
        Iterator<String> r0 = r6.keys();
    L6:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next();
        Intrinsics.checkNotNull(r1);
        if (StringsKt.isBlank(r1) == true) goto L6;
        Object r2 = r6.opt(r1);
        if (r2 == null) goto L6;
        this.a0.put(r1, r2);
        goto L6
    }

    public final void p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        if (StringsKt.isBlank(r2) == false) goto L5;
        this.f0 = x0();
        return;
    L5:
        this.f0 = r2;
    }

    public final void v(boolean r1) {
        this.j = r1;
    }

    public final void v0(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.put("is_model_proactive_speak", this.u ? 1 : 0);
        Iterator r0 = ((LinkedHashMap) this.a0).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        Object r3 = r1.getValue();
        if (r5.has(r2) == true) goto L4;
        r5.putOpt(r2, r3);
        goto L4
    }

    public final void w0(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.put("call_state", RealtimeCallTracerReporterKt.b());
        String r1 = "1";
        if (((RealtimeCallParam) this.b.invoke()).a == false) goto L5;
        Object r0 = "1";
    L6:
        r8.put("is_continuous_speak", r0);
        if (((RealtimeCallParam) this.b.invoke()).b == true) goto L10;
        r1 = "0";
    L10:
        r8.put("is_obric_continuous_talk", r1);
        r8.put("is_model_proactive_speak", this.u ? 1 : 0);
        r8.put("room_id", ((RealtimeCallParam) this.b.invoke()).d);
        r8.put("is_rtc", y0.e(((RealtimeCallParam) this.b.invoke()).s));
        r8.put("av_session_type", ((RealtimeCallParam) this.b.invoke()).s.getType());
        r8.put("is_mmt", y0.b(((RealtimeCallParam) this.b.invoke()).s) ? 1 : 0);
        r8.put("is_v3", this.W);
        r8.put("enter_method", y0());
        r8.put("bot_id", ((RealtimeCallParam) this.b.invoke()).o.h);
        r8.put("task_id", ((RealtimeCallParam) this.b.invoke()).o.a);
        r8.put("conversation_id", ((RealtimeCallParam) this.b.invoke()).o.c);
        r8.put("speaker_id", ((RealtimeCallParam) this.b.invoke()).o.d);
        r8.put("speak_name", ((RealtimeCallParam) this.b.invoke()).o.g);
        int r4 = 0;
        if (this.K <= 0) goto L13;
        int r2 = 1;
    L14:
        r8.put("is_bot_hello_triggered", r2);
        r8.put("chat_type", ((RealtimeCallParam) this.b.invoke()).p.g);
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.t != DenoiseStatusRes.FEATURE_ENABLED) goto L17;
        r4 = 1;
    L17:
        r8.put("is_noise_free", r4);
        String r3 = u.a(this);
        r8.put("modal_type", r3);
        r8.put("call_background_mode", r3);
        r8.put("is_first_call", RealtimeCallUtil.m ? 1 : 0);
        return;
    L13:
        r2 = 0;
        goto L14
    L5:
        r0 = "0";
        goto L6
    }

    public final ouc.d0 x(ouc.d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        JSONObject r3 = com.larus.voicecall.impl.util.d.d(r2);
        w0(r3);
        return com.larus.voicecall.impl.util.d.c(r3);
    }

    public static void C0(RealtimeCallParam r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "json");
        r3.put("room_id", r2.d);
        r3.put("is_rtc", y0.e(r2.s));
        r3.put("client_pre_connect", r2.t);
        r3.put("av_session_type", r2.s.getType());
        r3.put("is_mmt", y0.b(r2.s) ? 1 : 0);
        r3.put("is_quic", y0.d(r2.s));
    }

    public final void B(IRealtimeCallTracer.TotalTimeType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "type");
        int r5 = u.a.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        this.i = r4;
        if (r4 == false) goto L18;
        ((LinkedHashMap) this.c0).clear();
        H0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME);
    L18:
        IObricMemoryReportSPIService r6 = (IObricMemoryReportSPIService) ServiceManager.get().getService(IObricMemoryReportSPIService.class);
        if (r6 == null) goto L22;
        r6.a("realtime_call_".concat(u.a(this)), true);
        return;
    L22:
        return;
    L5:
        if (r5 != 2) goto L7;
        this.j = r4;
        if (r4 == false) goto L18;
        ((LinkedHashMap) this.c0).clear();
        H0(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME);
        goto L18
    L7:
        if (r5 != 3) goto L18;
        if (r4 == false) goto L11;
        H0(IRealtimeCallTracer.TotalTimeType.SUBTITLE);
        goto L18
    L11:
        G0(IRealtimeCallTracer.TotalTimeType.SUBTITLE);
        goto L18
    }

    public final void E0(Integer r9, String r10) {
        if (this.o0 == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        this.o0 = false;
        this.N.put("page_started_time", Long.valueOf(SystemClock.elapsedRealtime()));
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        v0(r2);
        w0(r2);
        if (this.n <= 0) goto L8;
        r0 = true;
    L8:
        r2.put("is_session_started", r0);
        r2.put("create_page_duration_detail", HttpExtKt.p(this.N));
        r2.put("create_page_duration", this.R);
        r2.put("start_to_chat_started_duration", this.S);
        r2.put("error_code", r9);
        r2.put("error_msg", r10);
        Unit r11 = Unit.INSTANCE;
        r1.reportEvent("realtime_start_up_event", r2);
    }

    public final void H(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "txt");
        Intrinsics.checkNotNullParameter(r8, "serverParamJson");
        boolean r4 = true;
        if (this.V != 0) goto L8;
        if ((!StringsKt.isBlank(r7)) == false) goto L8;
        this.V = System.currentTimeMillis();
        I0(r8);
        this.X = r8.length();
        return;
    L8:
        if (r8.length() > 0) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L19;
        int r9 = r8.length();
        if (r9 > 0) goto L15;
        return;
    L15:
        if (r9 == this.X) goto L21;
        I0(r8);
        return;
    L21:
        return;
    }

    public final void O(String r10, RealtimeCallParam r11) {
        Intrinsics.checkNotNullParameter(r10, "endReason");
        if (this.G == (-1)) goto L31;
        if (r11 == null) goto L32;
        m58.r r1 = m58.h.c;
        if (r1 == null) goto L8;
        r1.c(this.f0);
    L8:
        long r2 = System.currentTimeMillis();
        long r5 = this.G;
        if (r2 <= r5) goto L27;
        long r3 = (r2 - r5) / ((long) 1000);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r10, "endReason");
        String r0 = r11.o.h;
        String r6 = r11.e;
        RealtimeCallParam.d r7 = r11.l;
        String r8 = r7.c;
        String r9 = r7.a;
        JSONObject r12 = new JSONObject();
        v0(r12);
        C0(r11, r12);
        Long r13 = Long.valueOf(r3);
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        if (r0 != null) goto L29;
    L15:
        if (r6 == null) goto L17;
        r12.put("call_id", r6);     // Catch: JSONException -> L13
    L17:
        if (r8 == null) goto L19;
        r12.put("conversation_id", r8);     // Catch: JSONException -> L13
    L19:
        r12.put("end_reason", r10);     // Catch: JSONException -> L13
        if (r13 == null) goto L22;
        r12.put("play_duration", r13.longValue());     // Catch: JSONException -> L13
    L22:
        if (r9 == null) goto L26;
        r12.put("task_id", r9);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallTtsPlayDuration " + e.getLocalizedMessage());
    L26:
        TrackParams r14 = new TrackParams().merge(r12);
        by7.a r15 = new by7.a("realtime_call_tts_play_duration");
        r15.a.merge(r14);
        r15.b();
        goto L27
    L29:
        r12.put("bot_id", r0);     // Catch: JSONException -> L13
    L27:
        this.G = -1;
        return;
    L32:
        return;
    }

    public final void Q(IRealtimeCallTracer.HelloStatus r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "status");
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.r == false) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r12, "status");
        switch(u.a.b[r12.ordinal()]) {
            case 1: goto L38;
            case 2: goto L35;
            case 3: goto L32;
            case 4: goto L29;
            case 5: goto L17;
            case 6: goto L13;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        u.e(this, true);
        RealtimeCallUtil.J = false;
    L40:
        this.L = r12;
        return;
    L17:
        IRealtimeCallTracer.HelloStatus r0 = this.L;
        if (r0 != IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO) goto L20;
    L27:
        RealtimeCallUtil.J = true;
        u.d(this, false, r13, null, (RealtimeCallParam) this.b.invoke(), 4);
        goto L40
    L20:
        if (r0 == IRealtimeCallTracer.HelloStatus.START_SESSION) goto L27;
        if (this.K <= 0) goto L40;
        if (r0 != IRealtimeCallTracer.HelloStatus.PLAY_HELLO) goto L40;
        RealtimeCallUtil.J = true;
        u.c(this, false, r13);
        goto L40
    L10:
        throw new NoWhenBranchMatchedException();
    L13:
        if (this.K <= 0) goto L40;
        if (this.L != IRealtimeCallTracer.HelloStatus.PLAY_HELLO) goto L40;
        RealtimeCallUtil.J = true;
        u.c(this, true, null);
        goto L40
    L29:
        if (this.L != IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO) goto L40;
        this.K = System.currentTimeMillis();
        RealtimeCallUtil.J = true;
        u.d(this, true, null, y0(), (RealtimeCallParam) this.b.invoke(), 2);
        goto L40
    L32:
        if (this.L != IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO) goto L40;
        this.J = System.currentTimeMillis();
        goto L40
    L35:
        if (this.L != IRealtimeCallTracer.HelloStatus.START_SESSION) goto L40;
        this.I = System.currentTimeMillis();
        goto L40
    L38:
        if (this.L != IRealtimeCallTracer.HelloStatus.HELLO_RESET) goto L40;
        this.H = System.currentTimeMillis();
        goto L40
    L5:
        if (RealtimeCallUtil.u >= 0) goto L7;
    }

    public final void T(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
        this.g0 = r2;
        this.h0 = r3;
    }

    public final void Z(RealtimeCallParam r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        this.w = System.currentTimeMillis();
        H0(IRealtimeCallTracer.TotalTimeType.PAUSE);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onPauseCall$1(this, r8, r9, null), 2, null);
    }

    public final void a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "comfortType");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "comfortType");
    }

    public final void l0(RealtimeCallParam r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "botFromStatus");
        this.y = System.currentTimeMillis();
        H0(IRealtimeCallTracer.TotalTimeType.MUTE);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "botFromStatus");
        String r2 = r10.o.h;
        String r3 = r10.e;
        String r5 = r10.l.c;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r0 = RealtimeCallUtil.l;
        String r1 = null;
        if (r0 == null) goto L7;
        SceneModel r4 = r0.a;
        if (r4 == null) goto L7;
        String r6 = r4.getKey();
    L8:
        String r7 = y0();
        JSONObject r8 = new JSONObject();
        w0(r8);
        v0(r8);
        RealtimeCallParam.c r9 = r10.p.o;
        if (r9 == null) goto L11;
        String r12 = r9.a;
    L12:
        r8.put("action_bar_item_id", r12);
        RealtimeCallParam.c r13 = r10.p.o;
        if (r13 == null) goto L15;
        r1 = r13.d;
    L15:
        r8.put("action_bar_key", r1);
        B0(r8);
        r8.put("speaker_id", r10.o.d);
        r8.put("is_continuous_speak", "0");
        r8.put("call_enter_method", r10.p.i);
        g3.a(r11, r2, r3, r7, r5, r6, r8);
        return;
    L11:
        r12 = null;
    L7:
        r6 = null;
        goto L8
    }

    public final void m(RealtimeCallParam r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        if (r15 == false) goto L5;
        String r16 = "shoot";
    L6:
        D0(this, r14, 1, null, r16, null, "pic", null, null, null, null, false, 1988);
        return;
    L5:
        r16 = "upload";
        goto L6
    }

    public final void n(RealtimeCallParam r15, String r16) {
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        D0(this, r15, 1, null, null, r16, null, "suggest", null, null, null, false, 1964);
    }

    public final void q(boolean r1, long r2) {
        if (r1 == false) goto L4;
        this.R = r2;
        Long r3 = Long.valueOf(r2);
        this.N.put("open_page_time", r3);
        this.N.put("on_create_1", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L4:
        this.N.put("on_create_2", Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void reportEvent(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        TrackParams r4 = new TrackParams().merge(r3);
        by7.a r0 = new by7.a(r2);
        r0.a.merge(r4);
        r0.b();
    }

    public final void J(int r11, String r12, int r13) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onRedNoticeShow$1(this, r11, r12, r13, null), 2, null);
    }

    public final void a0(Flow<Integer> r8, CoroutineScope r9, RealtimeCallParam r10) {
        Intrinsics.checkNotNullParameter(r8, "callStateFlow");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        if (r9 == null) goto L6;
        BuildersKt.launch$default(r9, null, null, new RealtimeCallTracer$registerStateMachineListener$1(r8, this, null), 3, null);
        return;
    }

    public final void q0(String r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void y(String r7, RealtimeCallParam r8, ouc.d0 r9) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "extraParams");
        C0((RealtimeCallParam) this.b.invoke(), com.larus.voicecall.impl.util.d.d(r9));
        RealtimeCallParam.p r1 = r8.o;
        String r2 = r1.h;
        String r3 = r1.d;
        String r4 = r8.e;
        String r5 = r8.l.c;
        String r10 = r8.i;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        JSONObject r11 = com.larus.voicecall.impl.util.d.d(r9);
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        if (r2 != null) goto L20;
    L7:
        if (r4 == null) goto L9;
        r11.put("call_id", r4);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r11.put("conversation_id", r5);     // Catch: JSONException -> L5
    L11:
        r11.put("event_name", r7);     // Catch: JSONException -> L5
        if (r10 == null) goto L14;
        r11.put("llm_model", r10);     // Catch: JSONException -> L5
    L14:
        if (r3 == null) goto L18;
        r11.put("voice_style", r3);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeProactiveEvent " + e.getLocalizedMessage());
    L18:
        TrackParams r12 = new TrackParams().merge(r11);
        by7.a r13 = new by7.a("realtime_proactive_event");
        r13.a.merge(r12);
        r13.b();
        return;
    L20:
        r11.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public final void A(RealtimeCallParam r109, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r109, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r109, LynxResourceModule.PARAMS_KEY);
        String r39 = z0();
        RealtimeCallParam.p r2 = r109.o;
        String r7 = r2.c;
        String r4 = r2.h;
        String r3 = r2.f;
        String r5 = null;
        if (r3 == null) goto L5;
        Long r29 = StringsKt.toLongOrNull(r3);
    L6:
        RealtimeCallParam.p r6 = r109.o;
        String r9 = r6.g;
        String r8 = r6.d;
        RealtimeCallParam.k r10 = r109.p;
        String r15 = r10.d;
        String r14 = r10.b;
        RealtimeCallParam r11 = (RealtimeCallParam) this.b.invoke();
        JSONObject r13 = new JSONObject();
        RealtimeCallUtil.a.getClass();
        String r12 = "0";
        if (RealtimeCallUtil.t() == false) goto L9;
        Object r16 = "1";
    L10:
        r13.put("is_noise_free", r16);
        r13.put("call_state", RealtimeCallTracerReporterKt.b());
        if (r109.p.q == false) goto L13;
    L16:
        Object r17 = "1";
    L17:
        r13.put("is_continuous_speak", r17);
        if (r109.b == false) goto L20;
        r12 = "1";
    L20:
        r13.put("is_obric_continuous_talk", r12);
        Unit r1 = Unit.INSTANCE;
        w0(r13);
        v0(r13);
        C0(r11, r13);
        B0(r13);
        int r18 = n2.a();
        String r69 = RealtimeCallUtil.y;
        boolean r19 = RealtimeCallUtil.J;
        if (r19 == false) goto L26;
        if (RealtimeCallUtil.l == null) goto L26;
        r5 = RiskPreferenceSettings.SMART_BALANCE;
    L30:
        String r72 = r5;
    L31:
        d3.b(r4, null, null, r7, null, r15, null, "private", -1L, 0L, 0L, null, 1L, r110, "text", null, r14, null, null, null, null, null, 1L, "text", "0", r29, LynxUIWebView.DEFAULT, "0", r8, r9, null, r13, null, r111, r112, r39, null, null, null, null, null, Integer.valueOf(r18), null, null, null, null, "0", "vui_receive_stream", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r69, Integer.valueOf(r19 ? 1 : 0), RealtimeCallUtil.I, r72, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 265378477, -3179440, -1921, 1023);
        return;
    L26:
        if (RealtimeCallUtil.J == false) goto L30;
        if (RealtimeCallUtil.l != null) goto L30;
        r72 = "1";
        goto L31
    L13:
        if (r109.a == true) goto L16;
        r17 = "0";
        goto L17
    L9:
        r16 = "0";
        goto L10
    L5:
        r29 = null;
        goto L6
    }

    public final void e(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put("bot_id", r4);
        r0.put("call_id", r3);
        r0.put("call_scene", r5);
        r0.put("message_id", r6);
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("soothing_sound_generate_start");
        RealtimeCallParam r9 = (RealtimeCallParam) this.b.invoke();
        v0(r0);
        C0(r9, r0);
        r8.a.merge(r7);
        r8.b();
    }

    public final void e0(String r5, String r6, RealtimeCallParam r7, e3a.a r8) {
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r8, "argumentData");
        u.b(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r8, "argumentData");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        boolean r2 = r8 instanceof e3a.a;
        if (r2 == true) goto L6;
        r8 = null;
    L6:
        if (r8 == null) goto L8;
        int r3 = x0.a;
        x0.a(r1, r7, r8);
    L8:
        if (r2 == false) goto L10;
    L14:
        v0(r1);
        r1.put("leave_method", r6);
        r1.put("enter_method", r5);
        r1.put("current_page", "chat");
        RealtimeCallUtil.a.getClass();
        r1.put("is_subtitles_mode", RealtimeCallUtil.z ? 1 : 0);
        r1.put("subtitle_duration", A0(IRealtimeCallTracer.TotalTimeType.SUBTITLE));
        r1.put("mute_duration", A0(IRealtimeCallTracer.TotalTimeType.MUTE));
        r1.put("pause_duration", A0(IRealtimeCallTracer.TotalTimeType.PAUSE));
        r1.put("user_speak_duration", A0(IRealtimeCallTracer.TotalTimeType.USER_SPEAK));
        r1.put("sharescreen_in_app_duration", A0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_IN_APP));
        long r9 = A0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME);
        if (r9 <= 0) goto L17;
        this.e0 += r9;
        r1.put("sharescreen_duration", r9);
    L17:
        Unit r10 = Unit.INSTANCE;
        r0.reportEvent("leave_share_screen", r1);
        ((LinkedHashMap) this.b0).clear();
        return;
    L10:
        if (AppHost.a.isDebug() == false) goto L14;
        throw new RuntimeException("RealtimeArgumentData must be RealtimeArgumentData type!!!!");
    }

    public final void g0(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        JSONObject r0 = new JSONObject();
        r0.put("enter_method", r3);
        r0.put("call_id", r4);
        r0.put("bot_id", r5);
        r0.put("conversation_id", r6);
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("call_mic_permission_entrance_show");
        RealtimeCallParam r9 = (RealtimeCallParam) this.b.invoke();
        v0(r0);
        C0(r9, r0);
        r8.a.merge(r7);
        r8.b();
    }

    public final void h0(long r4, long r6, String r8, String r9) {
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("reportCallMessageDisplayEvent, scene=");
        r11.append(z0());
        r11.append(", imTime=");
        r11.append(r4);
        r11.append(", vuiTime=");
        r11.append(r6);
        r11.append(", diff=");
        long r0 = r6 - r4;
        r11.append(r0);
        r10.i("RealtimeCallTracer", r11.toString());
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (r4 != 0) goto L5;
        return;
    L5:
        if (r6 == 0) goto L10;
        JSONObject r12 = new JSONObject();
        r12.put("scene", z0());
        r12.put("im_time", r4);
        r12.put("vui_time", r6);
        r12.put("duration", r0);
        RealtimeCallParam r5 = (RealtimeCallParam) this.b.invoke();
        v0(r12);
        C0(r5, r12);
        TrackParams r7 = new TrackParams().merge(r12);
        by7.a r13 = new by7.a("realtime_call_message_display");
        r13.a.merge(r7);
        r13.b();
        return;
    }

    public final void k0(String r6, RealtimeCallParam r7, boolean r8, e3a.a r9) {
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r9, "argumentData");
        u.b(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r7, "param");
        Intrinsics.checkNotNullParameter(r9, "argumentData");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        boolean r2 = r9 instanceof e3a.a;
        if (r2 == false) goto L5;
        e3a.a r3 = r9;
    L6:
        if (r3 == null) goto L8;
        int r4 = x0.a;
        x0.a(r1, r7, r3);
        r9.k1 = false;
    L8:
        if (r2 == false) goto L10;
    L14:
        v0(r1);
        r1.put("leave_method", r6);
        RealtimeCallUtil.a.getClass();
        r1.put("is_subtitles_mode", RealtimeCallUtil.z ? 1 : 0);
        if (r8 == false) goto L17;
        String r10 = "back_camera";
    L18:
        r1.put("camera_position", r10);
        r1.put("current_page", "chat");
        r1.put("subtitle_duration", A0(IRealtimeCallTracer.TotalTimeType.SUBTITLE));
        r1.put("mute_duration", A0(IRealtimeCallTracer.TotalTimeType.MUTE));
        r1.put("pause_duration", A0(IRealtimeCallTracer.TotalTimeType.PAUSE));
        r1.put("user_speak_duration", A0(IRealtimeCallTracer.TotalTimeType.USER_SPEAK));
        long r11 = A0(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME);
        if (r11 <= 0) goto L22;
        this.d0 += r11;
        r1.put("video_call_duration", r11);
    L22:
        if (r7.p.q == false) goto L24;
    L27:
        String r12 = "1";
    L28:
        r1.put("is_continuous_speak", r12);
        Unit r13 = Unit.INSTANCE;
        r0.reportEvent("leave_video_call", r1);
        ((LinkedHashMap) this.b0).clear();
        return;
    L24:
        if (r7.a == true) goto L27;
        r12 = "0";
        goto L28
    L17:
        r10 = "front_camera";
        goto L18
    L10:
        if (AppHost.a.isDebug() == false) goto L14;
        throw new RuntimeException("RealtimeArgumentData must be RealtimeArgumentData type!!!!");
    L5:
        r3 = null;
        goto L6
    }

    public final void z(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        JSONObject r0 = new JSONObject();
        r0.put("enter_method", r3);
        r0.put("call_id", r4);
        r0.put("bot_id", r5);
        r0.put("conversation_id", r6);
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("call_mic_permission_entrance_click");
        RealtimeCallParam r9 = (RealtimeCallParam) this.b.invoke();
        v0(r0);
        C0(r9, r0);
        r8.a.merge(r7);
        r8.b();
    }

    public final void M(String r3, String r4, String r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put("bot_id", r4);
        r0.put("call_id", r3);
        r0.put("call_scene", r5);
        r0.put("message_id", r7);
        r0.put("soothing_sound_duration", r6);
        RealtimeCallParam r8 = (RealtimeCallParam) this.b.invoke();
        v0(r0);
        C0(r8, r0);
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("soothing_sound_generate_complete");
        r10.a.merge(r9);
        r10.b();
    }

    public final void P(RealtimeCallParam r19, Long r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.PARAMS_KEY);
        if (this.v == true) goto L5;
    L43:
        this.s = true;
        return;
    L5:
        if (this.p == (-1)) goto L43;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r23 != null) goto L9;
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        this.T = r3;
        if (r22 == null) goto L14;
        r1 = r22;
    L14:
        this.U = r1;
        this.v = false;
        this.r = System.currentTimeMillis();
        if (r21 == null) goto L17;
        JSONObject r7 = new JSONObject(r21);
    L18:
        C0((RealtimeCallParam) this.b.invoke(), r7);
        Iterator r0 = ((LinkedHashMap) this.Y).entrySet().iterator();
    L20:
        if (r0.hasNext() == false) goto L22;
        Map.Entry r2 = (Map.Entry) r0.next();
        r7.put((String) r2.getKey(), r2.getValue());
        goto L20
    L22:
        r7.put("is_v3", this.W);
        r7.put("modal_type", u.a(this));
        String r4 = "0";
        if (r19.p.q == false) goto L25;
    L28:
        Object r5 = "1";
    L29:
        r7.put("is_continuous_speak", r5);
        if (r19.b == false) goto L32;
        r4 = "1";
    L32:
        r7.put("is_obric_continuous_talk", r4);
        r7.put("enter_method", r19.p.i);
        if (this.q <= 0) goto L35;
        long r6 = System.currentTimeMillis() - this.q;
    L36:
        long r8 = this.q;
        if (r8 <= 0) goto L41;
        long r10 = this.p;
        if (r10 <= 0) goto L41;
        long r11 = r8 - r10;
    L42:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onTTSResponse$2(this, r19, r6, r11, r7, null), 2, null);
        this.C++;
    L41:
        r11 = 0;
        goto L42
    L35:
        r6 = 0;
        goto L36
    L25:
        if (r19.a == true) goto L28;
        r5 = "0";
        goto L29
    L17:
        r7 = new JSONObject();
        goto L18
    L9:
        r3 = r23;
        goto L10
    }

    public final void l(String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put("bot_id", r4);
        r0.put("call_id", r3);
        r0.put("call_scene", r5);
        r0.put("generate_scene", r6);
        r0.put("sec_generate_scene", r7);
        r0.put("room_id", ((RealtimeCallParam) this.b.invoke()).d);
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("prompt_sound_generate_start");
        RealtimeCallParam r10 = (RealtimeCallParam) this.b.invoke();
        v0(r0);
        C0(r10, r0);
        r9.a.merge(r8);
        r9.b();
    }

    public final void j(RealtimeCallParam r16, boolean r17, IRealtimeCallTracer.EnterCallSessionStatus r18, long r19, long r21, boolean r23) {
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r18, "sessionStatus");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r18, "sessionStatus");
        System.currentTimeMillis();
        if (r17 == true) goto L5;
        return;
    L5:
        if (this.n != (-1)) goto L9;
        this.n = System.currentTimeMillis();
        this.o = r19;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracerReporterKt$mobEnterCallStatus$1(r16, r18, this, r21, r19, r23, null), 2, null);
        return;
    }

    public final void p0(RealtimeCallParam r26, IRealtimeCallTracer.EnterCallSessionStatus r27, String r28, int r29, String r30, Boolean r31) {
        Intrinsics.checkNotNullParameter(r26, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r30, "errorMsg");
        long r0 = this.n;
        if (r0 <= 0) goto L45;
        if (r0 <= 0) goto L13;
        long r2 = this.m;
        if (r2 <= 0) goto L13;
        long r5 = r0 - r2;
        long r3 = r0 - this.l;
        if (this.K <= 0) goto L10;
        int r7 = 1;
    L11:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$reportSessionFinish$1(this, r26, r3, r5, r7, null), 2, null);
        goto L13
    L10:
        r7 = 0;
    L13:
        if (this.m0 <= 0) goto L15;
        this.l0 += SystemClock.elapsedRealtime() - this.m0;
        this.m0 = 0;
    L15:
        long r6 = this.l0;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r26, LynxResourceModule.PARAMS_KEY);
        Ref.LongRef r4 = new Ref.LongRef();
        r4.element = System.currentTimeMillis() - this.n;
        if (this.y <= 0) goto L18;
        this.z += System.currentTimeMillis() - this.y;
        long r1 = 0;
        this.y = 0;
    L20:
        if (this.i == false) goto L25;
        long r8 = A0(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME);
        if (r8 <= r1) goto L25;
        this.e0 += r8;
    L25:
        if (this.j == false) goto L29;
        long r9 = A0(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME);
        long r10 = 0;
        if (r9 <= 0) goto L30;
        this.d0 += r9;
    L30:
        boolean r11 = z2.a.realtimeCallUseEndCallBgModeSnapshot();
        if (this.i == false) goto L35;
        String r12 = "screen_share";
    L33:
        String r17 = r12;
        GlobalScope r24 = GlobalScope.INSTANCE;
        long r13 = r10;
        BuildersKt.launch$default(r24, Dispatchers.getIO(), null, new RealtimeCallTracerReporterKt$reportEndCall$3(this, r26, r4, r27, r28, r6, r11, r17, null), 2, null);
        long r14 = this.n;
        if (r14 <= r13) goto L43;
        long r15 = this.m;
        if (r15 <= r13) goto L43;
        BuildersKt.launch$default(r24, Dispatchers.getIO(), null, new RealtimeCallTracer$reportSessionFinishV2$1(this, r26, r29, r30, r14 - r15, r14 - this.l, null), 2, null);
    L43:
        this.n = r13;
        goto L45
    L35:
        if (this.j == false) goto L37;
        r12 = "video_call";
        goto L33
    L37:
        r12 = LynxResourceModule.AUDIO_TYPE;
        goto L33
    L29:
        r10 = 0;
        goto L30
    L18:
        r1 = 0;
    L45:
        JSONObject r16 = new JSONObject();
        C0(r26, r16);
        B0(r16);
        r16.put("speaker_id", r26.o.d);
        String r18 = r26.o.h;
        Intrinsics.checkNotNullParameter(r30, "errorMsg");
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        r16.put("error_code", r29);
        r16.put("error_msg", r30);
        if (r18 != null) goto L48;
        r18 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        r16.put("bot_id", r18);
        TrackParams r19 = new TrackParams().merge(r16);
        by7.a r20 = new by7.a("realtime_call_end");
        r20.a.merge(r19);
        r20.b();
        IAudioEventCommonParams r21 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r21 == null) goto L51;
        r21.disable();
    L51:
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.m = false;
    }

    public final void L(RealtimeCallParam r14, int r15, String r16, String r17, Long r18, Long r19, String r20) {
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        D0(this, r14, r15, r16, null, null, null, r17, r18, r19, r20, true, 40);
    }

    public final void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "startType");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r5, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r6, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r7, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r8, "translateMode");
        this.a.getClass();
        com.larus.audio.call.tracer.c.a.c(r2, r3, r4, r5, r6, r7, r8);
    }

    public final void f(RealtimeCallParam r16, String r17, boolean r18, IRealtimeCallTracer.EnterCallSessionStatus r19, Integer r20, long r21, boolean r23) {
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r17, "reason");
        Intrinsics.checkNotNullParameter(r19, "sessionStatus");
        if (r18 == true) goto L5;
        return;
    L5:
        if (r20 == null) goto L7;
        int r0 = r20.intValue();
    L8:
        this.P = r0;
        this.Q = r17;
        E0(r20, r17);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onEnterCallFailed$1(this, r16, r17, r19, r20, r21, r23, null), 2, null);
        return;
    L7:
        r0 = this.P;
        goto L8
    }

    public final void w(RealtimeCallParam r17, int r18, boolean r19, String r20, String r21, long r22, String r24) {
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.PARAMS_KEY);
        this.i0 = r24;
        long r1 = 0;
        if (r22 <= 0) goto L5;
        r1 = SystemClock.elapsedRealtime() - r22;
    L5:
        this.j0 = r1;
        if (r17.a == false) goto L8;
    L11:
        boolean r9 = true;
    L12:
        boolean r10 = r17.b;
        String r2 = r17.o.h;
        String r3 = r17.l.c;
        String r4 = r17.e;
        String r8 = r17.w;
        RealtimeCallParam.k r0 = r17.p;
        RealtimeCallTracerReporterKt.c(this, r2, r3, r4, r18, r19, r20, r21, r8, r9, r10, r0.i, r0.g, r0.o, null);
        return;
    L8:
        if (r17.p.q == true) goto L11;
        r9 = false;
        goto L12
    }

    public final void U(int r17, String r18, long r19, RealtimeCallParam r21, Boolean r22, int r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.PARAMS_KEY);
        this.P = r17;
        this.Q = r18;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracer$onError$1(this, r17, r18, r19, r21, r22, "call", true, null), 2, null);
    }

    public final void V(String r1, Integer r2, String r3, Long r4, Long r5, Long r6, Long r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "scene");
    }

    public final void r0(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        JSONObject r0 = new JSONObject();
        v0(r0);
        r0.put("success", true);
        r0.put("im_asr_message_num", r4);
        r0.put("im_tts_message_num", r5);
        r0.put("im_tts_query_message_num", r6);
        r0.put("im_pull_asr_message_num", r7);
        r0.put("im_pull_tts_message_num", r8);
        r0.put("vui_asr_message_num", r9);
        r0.put("vui_tts_message_num", r10);
        r0.put("vui_chat_message_num", r11);
        r0.put("scene", z0());
        C0((RealtimeCallParam) this.b.invoke(), r0);
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("realtime_call_message_on_screen");
        r13.a.merge(r12);
        r13.b();
    }

    public final void o(String r4, long r5, boolean r7, boolean r8, boolean r9, long r10, long r12, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r4, "audioRoute");
        FLogger.a.i("RealtimeCallTracer", "reportCallTtsPlayEvent, scene=" + z0() + ", audioRoute=" + r4 + ", firstTtsDuration=" + r5 + ", isFinish=" + r7 + ", isTtsEnd=" + r8);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r4, "audioRoute");
        JSONObject r11 = new JSONObject();
        r11.put("scene", z0());
        r11.put("current_route", r4);
        r11.put("first_tts_duration", r5);
        r11.put("is_finish", r7);
        r11.put("is_tts_end", r8);
        RealtimeCallParam r6 = (RealtimeCallParam) this.b.invoke();
        v0(r11);
        w0(r11);
        C0(r6, r11);
        r11.put("answer_start_time", r10);
        r11.put("answer_end_time", r12);
        r11.put("answer_type", r15);
        r11.put("call_round", r14);
        TrackParams r13 = new TrackParams().merge(r11);
        by7.a r16 = new by7.a("realtime_call_tts_play");
        r16.a.merge(r13);
        r16.b();
    }

    public final void u(String r10, String r11, long r12, String r14, String r15, String r16, String r17, String r18, long r19) {
        Intrinsics.checkNotNullParameter(r10, "endType");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r14, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r15, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r16, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r17, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r18, "translateMode");
        this.a.getClass();
        com.larus.audio.call.tracer.c.a.b(r10, r11, r14, r15, r16, r17, r18);
    }

    public final void d0(final RealtimeCallParam r15, final int r16, final long r17, long r19, boolean r21, final String r22, final String r23, final String r24, final Long r25, final Long r26, final String r27) {
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        IRealtimeCallTracer.TotalTimeType r0 = IRealtimeCallTracer.TotalTimeType.USER_SPEAK;
        long r1 = r16;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (this.c0.containsKey(r0) == true) goto L5;
        this.c0.put(r0, new y(r0));
    L5:
        y r2 = (y) ((LinkedHashMap) this.c0).get(r0);
        if (r2 == null) goto L8;
        r2.a += r1;
    L8:
        this.p = System.currentTimeMillis();
        this.k0 = r19;
        com.larus.utils.l0.b(new s(this, r17, r23, r15, r16, r22, r24, r25, r26, r27));
    }

    public static void D0(RealtimeCallTracer r189, RealtimeCallParam r190, int r191, String r192, String r193, String r194, String r195, String r196, Long r197, Long r198, String r199, boolean r200, int r201) {
        String r2 = r194;
        if ((r201 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r201 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r201 & 32) == 0) goto L13;
        String r11 = "text";
    L15:
        if ((r201 & 64) == 0) goto L17;
        String r180 = null;
    L19:
        if ((r201 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L21;
        Long r127 = null;
    L23:
        if ((r201 & 256) == 0) goto L25;
        Long r128 = null;
    L27:
        if ((r201 & 512) == 0) goto L29;
        String r129 = null;
    L31:
        if ((r201 & 1024) == 0) goto L33;
        boolean r3 = false;
    L34:
        String r10 = r189.z0();
        Intrinsics.checkNotNullParameter(r189, "<this>");
        Intrinsics.checkNotNullParameter(r190, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "messageType");
        if (r191 > 0) goto L39;
        if (r3 == true) goto L38;
        return;
    L38:
        if (z2.a.enableRealtimeCallInterpretForceReportMessage() == true) goto L39;
        return;
    L39:
        RealtimeCallParam.k r5 = r190.p;
        String r8 = r5.b;
        String r9 = r5.d;
        RealtimeCallParam.p r12 = r190.o;
        String r15 = r12.h;
        String r13 = r190.l.c;
        String r7 = r190.w;
        String r14 = r12.f;
        String r16 = r12.d;
        String r17 = r12.g;
        String r18 = r5.e;
        if (r18 != null) goto L42;
        r18 = r5.J;
    L42:
        String r33 = r18;
        String r19 = r5.f;
        String r110 = r5.g;
        RealtimeCallParam.n r20 = r5.h;
        if (r20 == null) goto L45;
        String r30 = r20.a;
    L46:
        if (r20 == null) goto L48;
        String r31 = r20.b;
    L49:
        if (r20 == null) goto L51;
        String r36 = r20.c;
    L52:
        if (r20 == null) goto L54;
        String r37 = r20.d;
    L55:
        if (r20 == null) goto L57;
        String r38 = r20.e;
    L58:
        if (r20 == null) goto L60;
        String r32 = r20.f;
    L61:
        String r21 = r5.k;
        String r111 = r5.l;
        String r22 = r5.m;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r23 = RealtimeCallUtil.l;
        if (r23 == null) goto L69;
        SceneModel r24 = r23.a;
        if (r24 == null) goto L69;
        String r25 = r24.getKey();
        if (r25 == null) goto L69;
        String r66 = r25;
    L70:
        RealtimeCallParam.k r26 = r190.p;
        String r27 = r26.i;
        String r28 = r190.e;
        String r29 = r26.n;
        long r112 = z0.c(RealtimeCallUtil.z);
        RealtimeCallParam.c r34 = r190.p.o;
        if (r34 == null) goto L73;
        String r87 = r34.b;
    L74:
        if (r34 == null) goto L76;
        String r88 = r34.c;
    L77:
        if (r34 == null) goto L81;
        String r35 = r34.a;
        if (r35 == null) goto L81;
        Long r86 = StringsKt.toLongOrNull(r35);
    L82:
        RealtimeCallParam.k r39 = r190.p;
        RealtimeCallParam.c r40 = r39.o;
        if (r40 == null) goto L85;
        String r113 = r40.d;
    L87:
        if (r113 != null) goto L89;
        String r72 = NameKeys.UnloadStrategy_No_Strategy;
    L90:
        if (r40 == null) goto L92;
        String r41 = r40.d;
    L94:
        if (r41 == null) goto L96;
        String r73 = "1";
    L97:
        String r42 = r39.H;
        String r43 = r39.I;
        if (u3a.f.e() == false) goto L100;
        String r140 = u3a.f.c();
    L102:
        if (u3a.f.e() == false) goto L104;
        String r141 = u3a.f.d();
    L105:
        JSONObject r114 = new JSONObject();
        if (RealtimeCallUtil.t() == false) goto L108;
        Object r44 = "1";
    L109:
        r114.put("is_noise_free", r44);
        if (o0.d(r6) == false) goto L113;
        r114.put("content_source", r6);
    L113:
        if (r189.i == false) goto L116;
        Object r45 = "screen_share";
    L119:
        r189.v0(r114);
        r189.B0(r114);
        r114.put("call_background_mode", r45);
        C0((RealtimeCallParam) r189.b.invoke(), r114);
        if (r190.p.q == false) goto L122;
    L125:
        Object r46 = r10;
    L126:
        r114.put("is_continuous_speak", r46);
        if (r190.b == false) goto L129;
        Object r47 = r10;
    L130:
        r114.put("is_obric_continuous_talk", r47);
        r189.w0(r114);
        r114.put("volume", Float.valueOf(n2.a() / 100.0f));
        String r48 = r189.i0;
        String r49 = r189.g0;
        String r186 = r6;
        String r50 = r189.h0;
        String r187 = r11;
        if (Intrinsics.areEqual(r189.q0, r190.e) == true) goto L133;
        r189.q0 = r190.e;
        r189.r0 = 0;
    L133:
        String r51 = r189.e;
        InstanceCallState.Companion.getClass();
        boolean r52 = Intrinsics.areEqual(r51, InstanceCallState.a.a(5));
        if (r48 != null) goto L136;
    L149:
        r189.r0 = 0;
        Unit r53 = Unit.INSTANCE;
    L150:
        RealtimeCallTracerReporterKt.a(r114, r190.r);
        r114.put("call_state", RealtimeCallTracerReporterKt.b());
        l3.b(r15, r110, null, null, r13, r9, "private", r7, null, null, "0", null, r187, null, r8, r30, r31, r32, r33, r19, r10, r36, r37, r38, null, null, r111, r22, null, null, null, null, null, null, r114, r21, null, null, null, null, null, null, null, r14, r16, r17, null, null, null, null, null, r66, r27, null, null, null, null, r72, r73, r28, r29, null, null, null, null, null, null, null, null, null, Long.valueOf(r112), r86, r87, r88, null, null, null, r180, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r42, r43, null, null, null, null, null, null, null, null, null, null, null, r127, r128, r129, null, null, null, null, null, null, null, null, null, null, r140, r141, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2046465227, -812652569, -4685885, -234893313, -193, 255);
        RealtimeCallParam.k r54 = r190.p;
        String r115 = r54.d;
        String r55 = r54.b;
        RealtimeCallParam.p r56 = r190.o;
        String r116 = r56.h;
        String r117 = r190.l.c;
        String r118 = r190.w;
        String r119 = r56.f;
        String r57 = r56.d;
        String r58 = r56.g;
        String r59 = r54.e;
        if (r59 != null) goto L153;
        r59 = r54.J;
    L153:
        String r210 = r59;
        String r60 = r54.f;
        String r120 = r54.g;
        RealtimeCallParam.n r61 = r54.h;
        if (r61 == null) goto L156;
        String r211 = r61.a;
    L157:
        if (r61 == null) goto L159;
        String r212 = r61.b;
    L160:
        if (r61 == null) goto L162;
        String r213 = r61.c;
    L163:
        if (r61 == null) goto L165;
        String r214 = r61.d;
    L166:
        if (r61 == null) goto L168;
        String r310 = r61.e;
    L169:
        if (r61 == null) goto L171;
        String r215 = r61.f;
    L172:
        String r62 = r54.k;
        String r63 = r54.l;
        String r64 = r54.m;
        com.larus.voicecall.impl.scene.o r65 = RealtimeCallUtil.l;
        if (r65 == null) goto L180;
        SceneModel r67 = r65.a;
        if (r67 == null) goto L180;
        String r68 = r67.getKey();
        if (r68 == null) goto L180;
        String r510 = r68;
    L181:
        RealtimeCallParam.k r69 = r190.p;
        String r121 = r69.i;
        String r122 = r190.e;
        String r70 = r69.n;
        long r311 = z0.c(RealtimeCallUtil.z);
        RealtimeCallParam.c r71 = r190.p.o;
        if (r71 == null) goto L184;
        String r74 = r71.b;
    L185:
        if (r71 == null) goto L187;
        String r75 = r71.c;
    L188:
        if (r71 == null) goto L192;
        String r76 = r71.a;
        if (r76 == null) goto L192;
        Long r77 = StringsKt.toLongOrNull(r76);
    L193:
        RealtimeCallParam.c r78 = r190.p.o;
        if (r78 == null) goto L196;
        String r79 = r78.d;
    L197:
        if (r79 != null) goto L199;
        String r610 = NameKeys.UnloadStrategy_No_Strategy;
    L200:
        if (r78 == null) goto L202;
        String r80 = r78.d;
    L203:
        if (r80 == null) goto L205;
        String r611 = r10;
    L207:
        if (u3a.f.e() == false) goto L209;
        String r126 = u3a.f.c();
    L211:
        if (u3a.f.e() == false) goto L213;
        String r1210 = u3a.f.d();
    L214:
        JSONObject r81 = new JSONObject();
        if (RealtimeCallUtil.t() == false) goto L217;
        Object r82 = r10;
    L218:
        r81.put("is_noise_free", r82);
        if (o0.d(r186) == false) goto L222;
        r81.put("content_source", r186);
    L222:
        if (r189.i == false) goto L225;
        Object r83 = "screen_share";
    L228:
        r189.v0(r81);
        r189.B0(r81);
        r81.put("call_background_mode", r83);
        C0((RealtimeCallParam) r189.b.invoke(), r81);
        r189.w0(r81);
        if (r190.p.q == false) goto L231;
    L234:
        Object r84 = r10;
    L235:
        r81.put("is_continuous_speak", r84);
        if (r190.b == false) goto L238;
        Object r85 = r10;
    L239:
        r81.put("is_obric_continuous_talk", r85);
        RealtimeCallTracerReporterKt.a(r81, r190.r);
        r81.put("call_state", RealtimeCallTracerReporterKt.b());
        RealtimeCallParam.k r89 = r190.p;
        String r123 = r4;
        l3.d(r116, r120, null, null, r117, r115, null, "private", r118, null, "0", r123, r187, null, r55, r211, r212, r215, r210, r60, null, r10, r213, r214, r310, null, 1L, null, r62, r63, r64, null, null, null, null, null, null, r81, null, null, null, null, null, null, r119, r57, r58, null, null, null, null, r510, null, null, null, null, null, r121, r610, r611, null, null, null, r70, r122, Long.valueOf(r311), r77, r74, r75, null, null, r180, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r89.H, r89.I, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r126, r1210, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1585375847, 1056046065, -5106, -1610612929, Integer.MAX_VALUE);
        AppHost.Companion r90 = AppHost.a;
        if (r90.isTestChannel() == false) goto L242;
    L243:
        f2a.c r91 = com.larus.voicecall.impl.utils.d.a.b("did show new message - query");
        LinkedHashMap r92 = new LinkedHashMap();
        f2a.f r93 = f2a.f.i;
        if (r4 != null) goto L246;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L246:
        r92.put(r93, r4);
        r92.put(f2a.f.c, r190.l.a);
        r92.put(new f2a.f("room_id"), ((RealtimeCallParam) r189.b.invoke()).d);
        f2a.f r0 = new f2a.f("text");
        if (r2 != null) goto L249;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L249:
        r92.put(r0, r2);
        r91.d(r92);
        r91.c.f = "auto_test";
        f2a.c.c(r91, null, 15);
        return;
    L242:
        if (Intrinsics.areEqual(r90.getBuildChannel(), "auto_test") == true) goto L243;
        return;
    L238:
        r85 = "0";
        goto L239
    L231:
        if (r190.a == true) goto L234;
        r84 = "0";
        goto L235
    L225:
        if (r189.j == false) goto L227;
        r83 = "video_call";
        goto L228
    L227:
        r83 = "others";
        goto L228
    L217:
        r82 = "0";
        goto L218
    L213:
        r1210 = null;
        goto L214
    L209:
        r126 = null;
        goto L211
    L205:
        r611 = "0";
        goto L207
    L202:
        r80 = null;
        goto L203
    L199:
        r610 = r79;
        goto L200
    L196:
        r79 = null;
    L192:
        r77 = null;
        goto L193
    L187:
        r75 = null;
        goto L188
    L184:
        r74 = null;
    L180:
        r510 = "other";
        goto L181
    L171:
        r215 = null;
        goto L172
    L168:
        r310 = null;
        goto L169
    L165:
        r214 = null;
        goto L166
    L162:
        r213 = null;
        goto L163
    L159:
        r212 = null;
        goto L160
    L156:
        r211 = null;
        goto L157
    L136:
        if (Intrinsics.areEqual(r48, r49) == false) goto L149;
        if (r2 == null) goto L149;
        if (r50 == null) goto L149;
        r189.r0++;
        int r94 = r.a;
        Intrinsics.checkNotNullParameter(r2, "queryContent");
        Intrinsics.checkNotNullParameter(r50, "respContent");
        Regex r95 = new Regex("[\\p{P}\\p{S}]");
        String r96 = r95.replace(r2, NameKeys.UnloadStrategy_No_Strategy);
        Locale r124 = Locale.ROOT;
        int r97 = StringsKt.indexOf$default(r95.replace(r50, NameKeys.UnloadStrategy_No_Strategy).toLowerCase(r124), r96.toLowerCase(r124), 0, false, 6, null);
        r114.put("query_length", r194.length());
        r114.put("response_length", r50.length());
        String r125 = "normal";
        if (z2.a.enableRealtimeCallOptSelfInterrupt() == false) goto L145;
        if (r97 < 0) goto L144;
        if (r52 == false) goto L144;
        r125 = "self";
    L144:
        r114.put("interrupt_type", r125);
    L148:
        r114.put("interrupt_time", r189.j0);
        r114.put("break_position", r97);
        r114.put("break_round", r189.r0);
        r114.put("message_id", r4);
        goto L150
    L145:
        if (r97 < 0) goto L147;
        r125 = "self";
    L147:
        r114.put("interrupt_type", r125);
        goto L148
    L129:
        r47 = "0";
        goto L130
    L122:
        if (r190.a == true) goto L125;
        r46 = "0";
        goto L126
    L116:
        if (r189.j == false) goto L118;
        r45 = "video_call";
        goto L119
    L118:
        r45 = "others";
        goto L119
    L108:
        r44 = "0";
        goto L109
    L104:
        r141 = null;
        goto L105
    L100:
        r140 = null;
        goto L102
    L96:
        r73 = "0";
        goto L97
    L92:
        r41 = null;
        goto L94
    L89:
        r72 = r113;
        goto L90
    L85:
        r113 = null;
    L81:
        r86 = null;
        goto L82
    L76:
        r88 = null;
        goto L77
    L73:
        r87 = null;
    L69:
        r66 = "other";
        goto L70
    L60:
        r32 = null;
        goto L61
    L57:
        r38 = null;
        goto L58
    L54:
        r37 = null;
        goto L55
    L51:
        r36 = null;
        goto L52
    L48:
        r31 = null;
        goto L49
    L45:
        r30 = null;
        goto L46
    L33:
        r3 = r200;
        goto L34
    L29:
        r129 = r199;
        goto L31
    L25:
        r128 = r198;
        goto L27
    L21:
        r127 = r197;
        goto L23
    L17:
        r180 = r196;
        goto L19
    L13:
        r11 = r195;
        goto L15
    L9:
        r6 = r193;
        goto L11
    L5:
        r4 = r192;
        goto L7
    }
}

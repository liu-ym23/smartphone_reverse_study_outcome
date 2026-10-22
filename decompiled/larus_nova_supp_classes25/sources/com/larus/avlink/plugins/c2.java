package com.larus.avlink.plugins;

import com.google.gson.Gson;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.e.model.session_memory.SessionMemoryMode;
import com.larus.avlink.liveai.DoraLiveAiTracer;
import com.larus.avlink.liveai.model.LiveAiEventScene;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.rtc.DoraRtcManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.api.model.FlowDoraVisionConfig;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.VisionModeIntention;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c2 extends com.larus.avlink.plugins.c<n4> {
    public static boolean m;
    public static c2 n;
    public final x98.a f;
    public final ExecutorService g;
    public final List<Pair<TriggerMode, JSONObject>> h;
    public e i;
    public final Lazy j;
    public final f k;
    public boolean l;

    public static final class a implements x98.c {
        public final /* synthetic */ c2 a;

        public a(c2 r1) {
            this.a = r1;
        }

        @Override // x98.c
        public final boolean a(x98.b r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            boolean r4 = c2.m;
            final c2 r5 = this.a;
            boolean r1 = true;
            if (r5.f.a == 1) goto L7;
            r1 = false;
        L7:
            return b.a(r1, new b2(r5));
        }

        @Override // x98.c
        public final void b(x98.b r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            com.larus.call_plugins_doubao_common.i r4 = this.a.getContext().c(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.i.class), null);
            if (r4 == null) goto L6;
            r4.r1("live ai stop", MapsKt.mapOf(TuplesKt.to("vision_biz_scene", "0")));
            return;
        }

        @Override // x98.c
        public final void c(x98.b r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraLiveAiPlugin$1$onStart$1(this.a, null), 3, null);
        }
    }

    public static final class b {
        public static boolean a(boolean r3, Function1 r4) {
            if (r3 == false) goto L9;
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "checkLiveAIStartReady failed: reason=live_already_in");
            if (r4 == null) goto L7;
            r4.invoke("live_already_in");
        L7:
            return false;
        L9:
            if (com.larus.avlink.e.o.a() == true) goto L14;
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "checkLiveAIStartReady failed: reason=live_photo_switch_off");
            if (r4 == null) goto L13;
            r4.invoke("live_photo_switch_off");
        L13:
            return false;
        L14:
            IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r5 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            if (r6 == false) goto L25;
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "checkLiveAIStartReady failed: reason=live_no_wear");
            if (r4 == null) goto L24;
            r4.invoke("live_no_wear");
        L24:
            return false;
        L25:
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "checkLiveAIStartReady success");
            return true;
        L17:
            if (r5.d0() != 0) goto L19;
            r6 = true;
            goto L20
        }
    }

    public static final class c implements com.larus.im.service.audio.v {
        public final /* synthetic */ c2 a;

        public final String getName() {
            return "DoraLiveAiPlugin";
        }

        public c(c2 r1) {
            this.a = r1;
            r1.getClass();
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "onConnectionStateChanged status=" + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L17;
            c2 r6 = this.a;
            r6.getClass();
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "resendPendingTrigger. pendingTriggerList: " + r6.h);
            Iterator r7 = ((ArrayList) r6.h).iterator();
        L6:
            if (r7.hasNext() == false) goto L10;
            Pair r0 = (Pair) r7.next();
            TriggerMode r1 = (TriggerMode) r0.component1();
            JSONObject r2 = (JSONObject) r0.component2();
            id9.d r3 = ((n4) r6.getContext()).j();
            if (r3 == null) goto L6;
            r3.p(r1, r2.toString());
            goto L6
        L10:
            ((ArrayList) r6.h).clear();
            return;
        }
    }

    public static final class d extends com.larus.im.service.audio.z0 {
        public final /* synthetic */ c2 a;

        public final String g() {
            this.a.getClass();
            return "DoraLiveAiPlugin";
        }

        public d(c2 r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r11) {
            Intrinsics.checkNotNullParameter(r11, "event");
            if ((r11 instanceof pf9.z) == false) goto L6;
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "FlowLLMQueryBeginEvent.");
            this.a.l = true;
            return;
        L6:
            if ((r11 instanceof pf9.e0) == false) goto L8;
            return;
        L8:
            if ((r11 instanceof pf9.q) == false) goto L81;
            final c2 r0 = this.a;
            r0.getClass();
            List r12 = ((pf9.q) r11).a;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r13 = r12.iterator();
        L11:
            if (r13.hasNext() == false) goto L82;
            pf9.p r4 = (pf9.p) r13.next();
            Long r5 = r4.a;
            if (r5 == null) goto L64;
            int r6 = (int) r5.longValue();
            JSONObject r7 = new JSONObject();
            Map r8 = r4.b;
            if (r8 == null) goto L20;
            Iterator r9 = r8.entrySet().iterator();
        L18:
            if (r9.hasNext() == false) goto L20;
            Map.Entry r10 = (Map.Entry) r9.next();
            r7.putOpt((String) r10.getKey(), r10.getValue());
        L20:
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "handleCommandResponse: cmd:" + r6 + ", params: " + r7 + '.');
            Gson r14 = ha8.a.a;
            ChatParam r15 = (ChatParam) ha8.a.a(r7.toString(), ChatParam.class);
            final int r16 = 2;
            if (r6 != 24) goto L23;
            Integer r17 = null;
            Gson r18 = new Gson();     // Catch: Exception -> L41
            if (r15 == null) goto L38;
            String r19 = r15.getVisionModeIntention();     // Catch: Exception -> L41
        L39:
            VisionModeIntention r20 = (VisionModeIntention) r18.fromJson(r19, VisionModeIntention.class);     // Catch: Exception -> L41
        L43:
            if (r20 == null) goto L45;
            Integer r21 = r20.getDoraSpecialMode();
        L46:
            if (r20 == null) goto L48;
            r17 = r20.getVisionEventType();
        L48:
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "handleChatResponseResult: DORA_VISION_MODE_INTENTION. mode:" + r21 + ", status:" + r17);
            if (r21 == null) goto L64;
            if (r21.intValue() != 2) goto L64;
            if (r17 != null) goto L57;
        L59:
            if (r17 == null) goto L64;
            if (r17.intValue() != 2) goto L64;
            final LiveAiEventScene r22 = LiveAiEventScene.MANUAL;
            Intrinsics.checkNotNullParameter(r22, "scene");
            final int r23 = 5;
            r0.g.execute(new z1(r0, r23, r22));
            goto L64
        L57:
            if (r17.intValue() != 1) goto L59;
            final LiveAiEventScene r24 = LiveAiEventScene.MANUAL;
            Intrinsics.checkNotNullParameter(r24, "scene");
            r0.g.execute(new z1(r0, r16, r24));
            boolean r25 = DoraLiveAiTracer.b;
            int r26 = ((n4) r0.getContext()).q();
            LinkedHashMap r27 = new LinkedHashMap();
            r27.put("start_type", "voice_command");
            r27.put("mode", Integer.valueOf(r26));
            Map<Function1<Boolean, Unit>, k4> r28 = x2.a;
            x2.e("dora_companion_mode_wakeup", r27);
            goto L64
        L45:
            r21 = null;
            goto L46
        L38:
            r19 = null;
        L41:
            e = move-exception;
            com.larus.avlink.n1.c("DoraLiveAiPlugin", "handleChatResponseResult: intentionItems.", e);
            r20 = null;
            goto L43
        L23:
            if (r6 != 1000) goto L64;
            String r29 = r7.optString("output_queue_id");
            if (r29 != null) goto L28;
        L31:
            boolean r30 = true;
        L32:
            if (r30 == true) goto L64;
            DoraLiveAiTracer.c(2, r29, 1, "");
            goto L64
        L28:
            if (r29.length() == 0) goto L31;
            r30 = false;
        L64:
            r3.add(r4);
            goto L11
        L82:
            return;
        }
    }

    public static final class e extends com.larus.audio.call.play.e {
        public final /* synthetic */ c2 a;

        public final void onPlayComplete() {
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveAiPlugin", "onPlayComplete.");
            this.a.l = false;
        }

        public e(c2 r1) {
            this.a = r1;
        }
    }

    public static final class f implements h49.g {
        public final /* synthetic */ c2 a;

        public f(c2 r1) {
            this.a = r1;
        }

        public final void a(FlowDoraVideoRecordConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
        }

        public final void b(List<FlowDoraVisionConfig> r7) {
            Intrinsics.checkNotNullParameter(r7, "fLowDoraVisionConfigList");
            Intrinsics.checkNotNullParameter(r7, "fLowDoraVisionConfigList");
            Iterator<T> r8 = r7.iterator();
        L3:
            boolean r1 = false;
            if (r8.hasNext() == false) goto L13;
            Object r0 = r8.next();
            FlowDoraVisionConfig r3 = (FlowDoraVisionConfig) r0;
            if (r3.a == 2) goto L8;
        L10:
            boolean r4 = false;
        L11:
            if (r4 == false) goto L3;
        L14:
            FlowDoraVisionConfig r2 = (FlowDoraVisionConfig) r0;
            if (r2 == null) goto L28;
            float r9 = r2.e;
            if (r9 != 0.0f) goto L19;
            r1 = true;
        L19:
            if (r1 == false) goto L21;
            r9 = 0.5f;
        L21:
            int r10 = (int) (1.0f / r9);
            ((SessionMemoryMode) this.a.j.getValue()).c(r10);
            return;
        L28:
            return;
        L8:
            if (r3.getType() != 0) goto L10;
            r4 = true;
            goto L11
        L13:
            r0 = null;
            goto L14
        }
    }

    static {
    }

    public final String T2() {
        return "DoraLiveAiPlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new c(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new d(this);
    }

    @Override // com.larus.avlink.plugins.c
    public final void V2() {
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "onAfterStart, mode: " + ((n4) getContext()).q() + '.');
        if (v88.a.c(Integer.valueOf(((n4) getContext()).q())) == false) goto L42;
        boolean r0 = true;
        b98.b.f(1, 1);
        m = true;
        this.l = false;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L11;
        com.larus.dora.impl.serviceimpl.t r3 = r2.U();
        if (r3 == null) goto L11;
        if (r3.b() != true) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        k3("live_enter_success");
    L14:
        this.f.b(new x98.b(2, LiveAiEventScene.AUTO));
        boolean r5 = DoraLiveAiTracer.b;
        String r6 = ((n4) getContext()).params().e;
        if (((n4) getContext()).q() != 7) goto L17;
        String r7 = "long_press";
    L18:
        DoraLiveAiTracer.e(r6, r7, ((n4) getContext()).q());
        if (((n4) getContext()).x() == false) goto L23;
        if (DoraRtcManager.f() == false) goto L23;
    L24:
        boolean r8 = true;
    L26:
        if (r8 == true) goto L36;
        SessionMemoryMode r9 = (SessionMemoryMode) this.j.getValue();
        Job r10 = r9.h;
        if (r10 != null) goto L30;
    L32:
        r0 = false;
    L33:
        if (r0 == false) goto L35;
        com.larus.avlink.n1.d("SessionMemoryMode", "Timer job is already running. Current interval: " + r9.g + ", new interval: 2.");
        r9.c(2);
        goto L36
    L35:
        r9.b(2);
        goto L36
    L30:
        if (r10.isActive() != true) goto L32;
    L36:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L43;
        VisionService r11 = r1.V();
        if (r11 == null) goto L44;
        r11.c(this.k);
        return;
    L44:
        return;
    L43:
        return;
    L23:
        if (((n4) getContext()).E() == true) goto L24;
        r8 = false;
        goto L26
    L17:
        r7 = "voice_command";
    L11:
        r4 = false;
        goto L12
    }

    public final void W2() {
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "onStop, mode: " + ((n4) getContext()).q() + '.');
        if (v88.a.c(Integer.valueOf(((n4) getContext()).q())) == false) goto L18;
        m = false;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        AbilityService r1 = r0.o0();
        if (r1 == null) goto L9;
        r1.l();
    L9:
        b98.b.f(1, 2);
        RealtimeCallParam r2 = ((n4) getContext()).params();
        Integer r3 = r2.n.a;
        boolean r4 = DoraLiveAiTracer.b;
        String r5 = r2.e;
        if (((n4) getContext()).q() != 7) goto L12;
        String r6 = "long_press";
    L13:
        DoraLiveAiTracer.d(r5, r6, ((n4) getContext()).q(), r3);
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "inLiveAiMode false");
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L18;
        SessionService r8 = r7.d();
        if (r8 == null) goto L18;
        IDoraService.h.a.a(r8, 1, DoraCallStateCode.RTC_STOP);
        goto L18
    L12:
        r6 = "voice_command";
    L18:
        SessionMemoryMode r9 = (SessionMemoryMode) this.j.getValue();
        r9.getClass();
        com.larus.avlink.n1.d("SessionMemoryMode", "Stopping timer and cleaning up resources.");
        Job r10 = r9.h;
        if (r10 == null) goto L21;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L21:
        r9.h = null;
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L26;
        VisionService r12 = r11.V();
        if (r12 == null) goto L26;
        r12.a(this.k);
    L26:
        n = null;
        e r13 = this.i;
        if (r13 == null) goto L34;
        com.larus.audio.call.plugins.t0 r14 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r14 == null) goto L35;
        u68.c r15 = r14.e0();
        if (r15 == null) goto L36;
        r15.j(r13);
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void e3() {
        super.e3();
        n = this;
        e r0 = new e(this);
        this.i = r0;
        com.larus.audio.call.plugins.t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r1 == null) goto L8;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L9;
        r2.i(r0);
        return;
    L9:
        return;
    }

    public c2(final n4 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        x98.a r0 = new x98.a();
        this.f = r0;
        this.g = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DoraLiveAiPlugin"));
        this.h = new ArrayList();
        this.j = LazyKt.lazy(new a2(r4));
        this.k = new f(this);
        a r5 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r0.b = r5;
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void Q0(int r4) {
        this.f.b(new x98.b(0, null));
    }

    public final void k3(String r4) {
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("notice_key", r4)});
        JSONObject r0 = new JSONObject();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put((String) r1.getKey(), (String) r1.getValue());
        goto L4
    L6:
        id9.d r7 = ((n4) getContext()).j();
        if (r7 == null) goto L9;
        jd9.c r8 = r7.state();
    L11:
        if ((r8 instanceof jd9.c.a) == false) goto L15;
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "sendBotTrigger. trigger CLIENT_SUMMON_NOTICE.");
        id9.d r9 = ((n4) getContext()).j();
        if (r9 == null) goto L18;
        r9.p(TriggerMode.CLIENT_SUMMON_NOTICE, r0.toString());
        return;
    L18:
        return;
    L15:
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "mediaSession is not connected, add to pendingTriggerList.");
        ((ArrayList) this.h).add(TuplesKt.to(TriggerMode.CLIENT_SUMMON_NOTICE, r0));
        return;
    L9:
        r8 = null;
        goto L11
    }

    @Override // com.larus.avlink.plugins.c
    public final void j3(int r1, int r2, String r3, String r4) {
        if (r2 != 4) goto L8;
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "stop tts");
        if (com.larus.audio.call.arch.b.a(getContext()).e0().isPlaying() == false) goto L9;
        com.larus.audio.call.arch.b.a(getContext()).e0().d(true, true, "tts break");
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "stop tts in live ai tts break");
        return;
    L9:
        return;
    }
}

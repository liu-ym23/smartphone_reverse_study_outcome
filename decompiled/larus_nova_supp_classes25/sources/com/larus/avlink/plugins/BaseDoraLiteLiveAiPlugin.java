package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.liveai.DoraLiveAiTracer;
import com.larus.avlink.liveai.model.LiveAiEventScene;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class BaseDoraLiteLiveAiPlugin extends com.larus.audio.call.arch.a<n4> implements y1 {
    public static boolean l;
    public final String f;
    public final String g;
    public final x98.a h;
    public final ExecutorCoroutineDispatcher i;
    public final List<Pair<TriggerMode, ouc.d0>> j;
    public boolean k;

    public static final class a implements x98.c {
        public final /* synthetic */ BaseDoraLiteLiveAiPlugin a;
        public final /* synthetic */ n4 b;

        @Override // x98.c
        public final boolean a(x98.b r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if (this.a.h.a != 1) goto L6;
            com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "check not ready");
            this.a.n3("live_already_in");
            return false;
        L6:
            return true;
        }

        @Override // x98.c
        public final void b(x98.b r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            this.a.r1("live ai stop", MapsKt.mapOf(TuplesKt.to("vision_biz_scene", "0")));
            v1.a = false;
            x3 r0 = this.a.j3();
            if (r0 == null) goto L6;
            r0.r(false);
            return;
        }

        @Override // x98.c
        public final void c(x98.b r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if (this.b.q() != 2) goto L9;
            v1.a = true;
            Map<Function1<Boolean, Unit>, k4> r5 = x2.a;
            IDoraService r6 = x2.c();
            if (r6 == null) goto L20;
            SessionService r7 = r6.d();
            if (r7 == null) goto L21;
            r7.l(1, true);
            return;
        L21:
            return;
        L20:
            return;
        L9:
            v4 r8 = (v4) this.a.getContext().c(Reflection.getOrCreateKotlinClass(v4.class), null);
            if (r8 == null) goto L12;
            r8.X();
        L12:
            BaseDoraLiteLiveAiPlugin.l = true;
            this.a.k = true;
            this.b.params().p.T = true;
            x3 r9 = this.a.j3();
            if (r9 == null) goto L15;
            r9.r(true);
        L15:
            v4 r10 = (v4) this.a.getContext().c(Reflection.getOrCreateKotlinClass(v4.class), null);
            if (r10 == null) goto L18;
            r10.u2();
        L18:
            v1.a = false;
            this.a.r1("onSessionStarted", null);
            this.a.n3("live_enter_success");
            Map<Function1<Boolean, Unit>, k4> r11 = x2.a;
            x2.f(1);
            boolean r12 = DoraLiveAiTracer.b;
            DoraLiveAiTracer.e(this.b.params().e, this.a.k3(), this.b.q());
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "live ai start");
        }

        public a(BaseDoraLiteLiveAiPlugin r1, n4 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    public static final class c implements com.larus.im.service.audio.v {
        public final /* synthetic */ BaseDoraLiteLiveAiPlugin a;

        public final String getName() {
            return "DoraLiteLiveAiPlugin";
        }

        public c(BaseDoraLiteLiveAiPlugin r1) {
            this.a = r1;
            r1.getClass();
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "onConnectionStateChanged status=" + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L17;
            BaseDoraLiteLiveAiPlugin r6 = this.a;
            r6.getClass();
            com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "resendPendingTrigger. pendingTriggerList: " + r6.j);
            Iterator r7 = ((ArrayList) r6.j).iterator();
        L6:
            if (r7.hasNext() == false) goto L10;
            Pair r0 = (Pair) r7.next();
            TriggerMode r1 = (TriggerMode) r0.component1();
            ouc.d0 r2 = (ouc.d0) r0.component2();
            id9.d r3 = ((n4) r6.getContext()).j();
            if (r3 == null) goto L6;
            r3.p(r1, r2.toString());
            goto L6
        L10:
            ((ArrayList) r6.j).clear();
            return;
        }
    }

    public static final class d extends com.larus.im.service.audio.z0 {
        public final /* synthetic */ BaseDoraLiteLiveAiPlugin a;

        public final String g() {
            this.a.getClass();
            return "DoraLiteLiveAiPlugin";
        }

        public d(BaseDoraLiteLiveAiPlugin r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof pf9.z) == false) goto L6;
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "FlowLLMQueryBeginEvent.");
            return;
        L6:
            if ((r2 instanceof pf9.e0) == false) goto L8;
            return;
        L8:
            if ((r2 instanceof pf9.q) == false) goto L13;
            this.a.l3((pf9.q) r2);
            return;
        }
    }

    static {
    }

    public final String T2() {
        return "DoraLiteLiveAiPlugin";
    }

    public void l3(pf9.q r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public abstract void o3();

    public void r1(String r1, Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
    }

    public final com.larus.im.service.audio.v R2() {
        return new c(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new d(this);
    }

    public final void V2() {
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "onAfterStart, mode: " + ((n4) getContext()).q() + '.');
        if (v1.a == false) goto L9;
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        x2.f(1);
        l = true;
        this.k = true;
        ((n4) getContext()).params().p.T = true;
        x3 r2 = j3();
        if (r2 == null) goto L7;
        r2.r(true);
    L7:
        n3("live_enter_success");
        r1("onSessionStarted", null);
        boolean r1 = DoraLiveAiTracer.b;
        DoraLiveAiTracer.e(((n4) getContext()).params().e, k3(), ((n4) getContext()).q());
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "live ai start");
        return;
    }

    public final void W2() {
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "onBeforeStop, mode: " + ((n4) getContext()).q() + '.');
    }

    public final void g3() {
        super.g3();
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "onStop isCurrentSessionInLiveAIMode: " + this.k);
        if (this.k == false) goto L7;
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        x2.f(0);
        o3();
        RealtimeCallParam r2 = ((n4) getContext()).params();
        Integer r3 = r2.n.a;
        boolean r4 = DoraLiveAiTracer.b;
        DoraLiveAiTracer.d(r2.e, k3(), ((n4) getContext()).q(), r3);
        v1.a = false;
        l = false;
        this.k = false;
        x3 r5 = j3();
        if (r5 == null) goto L7;
        r5.r(false);
    L7:
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "onStop, mode: " + ((n4) getContext()).q() + '.');
    }

    public final x3 j3() {
        return (x3) getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
    }

    public final String k3() {
        if (((n4) getContext()).q() != 2) goto L5;
        return "long_press";
    L5:
        return "voice_command";
    }

    @Override // com.larus.avlink.plugins.y1
    public final boolean P() {
        return this.k;
    }

    public BaseDoraLiteLiveAiPlugin(n4 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f = "female_lite_livai_exit.wav";
        this.g = "male_lite_live_exit.wav";
        x98.a r0 = new x98.a();
        this.h = r0;
        Intrinsics.checkNotNullParameter("DoraLiteLiveAiPlugin", "name");
        this.i = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.larus.avlink.platform.a()));
        this.j = new ArrayList();
        a r1 = new a(this, r4);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.b = r1;
    }

    public final void n3(String r5) {
        Map r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("notice_key", r5)});
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r7.next();
        String r2 = (String) r1.getKey();
        ouc.g0 r3 = ouc.k.c((String) r1.getValue());
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        ouc.i r4 = (ouc.i) r0.put(r2, r3);
        goto L4
    L6:
        ouc.d0 r8 = new ouc.d0(r0);
        id9.d r9 = ((n4) getContext()).j();
        if (r9 == null) goto L9;
        jd9.c r10 = r9.state();
    L11:
        if ((r10 instanceof jd9.c.a) == false) goto L15;
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "sendBotTrigger. trigger CLIENT_SUMMON_NOTICE.");
        id9.d r11 = ((n4) getContext()).j();
        if (r11 == null) goto L18;
        r11.p(TriggerMode.CLIENT_SUMMON_NOTICE, r8.toString());
        return;
    L18:
        return;
    L15:
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "mediaSession is not connected, add to pendingTriggerList.");
        ((ArrayList) this.j).add(TuplesKt.to(TriggerMode.CLIENT_SUMMON_NOTICE, r8));
        return;
    L9:
        r10 = null;
        goto L11
    }

    public final void m3(int r8, LiveAiEventScene r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        CoroutineScope r1 = ((n4) getContext()).r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, this.i, null, new BaseDoraLiteLiveAiPlugin$onLiveAiEvent$1(this, r8, r9, null), 2, null);
        return;
    }
}

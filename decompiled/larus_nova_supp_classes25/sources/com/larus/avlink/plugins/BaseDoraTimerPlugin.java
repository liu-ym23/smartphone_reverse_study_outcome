package com.larus.avlink.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.avlink.model.TimerScene;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class BaseDoraTimerPlugin extends com.larus.audio.call.arch.a<n4> implements x3, o4 {
    public volatile boolean f;
    public volatile boolean g;
    public volatile com.larus.audio.call.o h;
    public com.larus.audio.call.o i;
    public final List<z4> j;

    public static final class a {
    }

    public static final class b extends com.larus.im.service.audio.a1 {
        public final /* synthetic */ BaseDoraTimerPlugin a;

        public final String g() {
            this.a.getClass();
            return "DoraTimerPlugin";
        }

        public b(BaseDoraTimerPlugin r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r12) {
            Intrinsics.checkNotNullParameter(r12, "event");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraTimerPlugin", "onReceiveEvent event: " + r12);
            BaseDoraTimerPlugin r1 = this.a;
            r1.getClass();
            if ((r12 instanceof pf9.o) == false) goto L6;
            Intrinsics.checkNotNullParameter((pf9.o) r12, "event");
            return;
        L6:
            if ((r12 instanceof pf9.r) == false) goto L11;
            if (((pf9.r) r12).getType() != TriggerMode.CLIENT_SUMMON_NOTICE) goto L43;
            r1.g1("client summon notice");
            return;
        L43:
            return;
        L11:
            if ((r12 instanceof pf9.z) == false) goto L14;
            r1.g1("query begin");
            return;
        L14:
            if ((r12 instanceof pf9.c0) == false) goto L17;
            r1.g = false;
            return;
        L17:
            if ((r12 instanceof pf9.a0) == false) goto L31;
            r1.g = false;
            if (v88.a.f(Integer.valueOf(((n4) r1.getContext()).q())) == false) goto L21;
        L25:
            pf9.a0 r13 = (pf9.a0) r12;
            if (r13.c == true) goto L28;
        L29:
            r1.q3(30000, TimerScene.QueryEnd);
            return;
        L28:
            if (r13.d == true) goto L29;
            return;
        L21:
            if (((pf9.a0) r12).d == true) goto L25;
            CoroutineScope r5 = ((n4) r1.getContext()).r();
            if (r5 == null) goto L25;
            BuildersKt.launch$default(r5, null, null, new BaseDoraTimerPlugin$handleReceiverEvent$1(r1, null), 3, null);
            goto L25
        L31:
            if ((r12 instanceof pf9.f0) == false) goto L38;
            if (r1.g == true) goto L49;
            r1.g = true;
            com.larus.avlink.n1.d("DoraTimerPlugin", "tts start");
            r1.g1("tts update");
            CoroutineScope r6 = ((n4) r1.getContext()).r();
            if (r6 == null) goto L50;
            BuildersKt.launch$default(r6, null, null, new BaseDoraTimerPlugin$handleReceiverEvent$2(null), 3, null);
            return;
        L50:
            return;
        L49:
            return;
        L38:
            if ((r12 instanceof pf9.e0) == false) goto L40;
            r1.g = false;
            return;
        L40:
            boolean r14 = r12 instanceof pf9.q;
        }
    }

    static {
    }

    public final String T2() {
        return "DoraTimerPlugin";
    }

    public abstract String k3();

    public abstract String m3();

    public void o3() {
        Intrinsics.checkNotNullParameter("pre flash end", "reason");
    }

    @Override // com.larus.avlink.plugins.y2
    public final void r(boolean r1) {
    }

    public boolean s3(TimerScene r1) {
        return false;
    }

    public final com.larus.im.service.audio.z0 S2() {
        b r0 = new b(this);
        com.larus.avlink.n1.d("DoraTimerPlugin", "createSessionListener l: " + r0);
        return r0;
    }

    public void b3() {
        g1("release");
    }

    public long j3() {
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        IDoraService r1 = x2.c();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.O());
    L6:
        if (r2 != null) goto L10;
        return 8000;
    L10:
        return ((long) r2.intValue()) * 1000;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.avlink.plugins.o3
    public final void Z1() {
        MajorState.d r0 = ((n4) getContext()).a().A0();
        com.larus.avlink.n1.d("DoraTimerPlugin", "onTtsPlayFinished: " + r0);
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == false) goto L6;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L20;
        q3(l3(null), TimerScene.OnTtsPlayFinished);
        return;
    L20:
        com.larus.avlink.n1.d("DoraTimerPlugin", "onTtsPlayFinished no need timer: " + r0);
        return;
    L6:
        if ((r0 instanceof MajorState.d) == false) goto L15;
        MajorState.d r2 = r0;
        if (r2.d != MajorState.InterruptType.NOTHING) goto L17;
        MajorState.From r3 = r2.c;
        if (r3 != MajorState.From.PLAY_COMPLETE) goto L12;
    L16:
        r1 = true;
        goto L18
    L12:
        if (r3 != MajorState.From.TTS_ENDED) goto L17;
    L15:
        if ((r0 instanceof MajorState.a) == false) goto L17;
        goto L16
    }

    public void g3() {
        super.g3();
        this.f = true;
    }

    @Override // com.larus.avlink.plugins.o3
    public final void C2() {
        b3();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void s2() {
        g3();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void w1() {
        e3();
    }

    public BaseDoraTimerPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.j = new ArrayList();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void G(TimerScene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        q3(l3(r3), r3);
    }

    @Override // com.larus.avlink.plugins.o4
    public void Q0(int r1) {
        g1("conversation end");
    }

    @Override // com.larus.avlink.plugins.o3
    public void g1(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        com.larus.avlink.n1.d("DoraTimerPlugin", "cancelDelayTimerByScene source: " + r3);
        com.larus.audio.call.o r4 = this.h;
        if (r4 == null) goto L5;
        r4.a();
    L5:
        this.h = null;
        com.larus.audio.call.o r0 = this.i;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        this.i = null;
    }

    public final long l3(TimerScene r5) {
        String r0 = ((n4) getContext()).params().f;
        AndroidPlatformKt.a();
        if (BaseDoraLiteLiveAiPlugin.l == false) goto L6;
        return 86400000;
    L6:
        if (r5 != TimerScene.OnStart) goto L11;
        if (((n4) getContext()).params().p.R == false) goto L11;
        Map<Function1<Boolean, Unit>, k4> r6 = x2.a;
        return ((long) x2.a()) * 1000;
    L11:
        if (Intrinsics.areEqual(r0, k3()) == false) goto L13;
    L16:
        return 15000;
    L13:
        if (Intrinsics.areEqual(r0, m3()) == true) goto L16;
        return j3();
    }

    public void p3(TimerScene r4) {
        ((n4) getContext()).d(false, 1, 3);
    }

    @Override // com.larus.avlink.plugins.o3
    public final void q1(DoraNotificationSummaryPlugin.c r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.j).add(r2);
        com.larus.avlink.n1.d("DoraTimerPlugin", "registerNeedCancelInterceptor: interceptor registered");
    }

    public final void r3(long r5) {
        com.larus.audio.call.o r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        long r1 = RangesKt.coerceAtLeast(r5 - 4000, 0);
        com.larus.avlink.n1.d("DoraTimerPlugin", "startPreFlashBefore preFlashDelayMs: " + r1 + ", totalMs: " + r5);
        com.larus.audio.call.o r6 = new com.larus.audio.call.o(r1, new f(this));
        this.i = r6;
        r6.d();
    }

    public void n3(long r1, TimerScene r3) {
        if (s3(r3) == true) goto L5;
        return;
    L5:
        r3(r1);
    }

    public final void q3(long r11, TimerScene r13) {
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        IDoraService r1 = x2.c();
        boolean r2 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
    L14:
        r2 = false;
    L15:
        if (r2 == true) goto L17;
        return;
    L17:
        CoroutineScope r4 = ((n4) getContext()).r();
        if (r4 == null) goto L21;
        BuildersKt.launch$default(r4, Dispatchers.getMain(), null, new BaseDoraTimerPlugin$startDelayTimer$1(this, r13, r11, null), 2, null);
        return;
    L21:
        return;
    L10:
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == true) goto L14;
        if (v88.a.c(Integer.valueOf(((n4) getContext()).q())) == true) goto L14;
    L5:
        if (r1.J0() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        if (Intrinsics.areEqual(r1, "env_observe") == false) goto L6;
        q3(l3(null), TimerScene.StartConversationInEnvObserve);
        return;
    }
}

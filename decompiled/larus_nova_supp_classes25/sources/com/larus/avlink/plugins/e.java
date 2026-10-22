package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.avlink.business.api.DoraAvlinkDeviceLightAction;
import com.larus.avlink.business.api.DoraAvlinkDeviceSound;
import com.larus.avlink.business.api.DoraAvlinkSessionEndReason;
import com.larus.avlink.business.api.DoraAvlinkSessionState;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.model.TimerScene;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class e extends com.larus.audio.call.arch.a<n4> implements o3, z2, o4 {
    public a3 f;
    public final List<z4> g;
    public TimerScene h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[DoraAvlinkSessionEndReason.values().length];
            r0[DoraAvlinkSessionEndReason.TIMEOUT_30S.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            a = r0;
            int[] r1 = new int[DoraAvlinkDeviceLightAction.values().length];
            r1[DoraAvlinkDeviceLightAction.INDICATOR_RAPID_FLASHING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L6:
            b = r1;
            int[] r2 = new int[DoraAvlinkDeviceSound.values().length];
            r2[DoraAvlinkDeviceSound.VUI_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L8:
            c = r2;
        }
    }

    public static final class c extends com.larus.im.service.audio.a1 {
        public final /* synthetic */ e a;

        public final String g() {
            this.a.getClass();
            return "DoraTimeoutKMPPlugin";
        }

        public c(e r1) {
            this.a = r1;
        }

        public final void n(com.larus.im.service.audio.z0.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            e r0 = this.a;
            a3 r1 = r0.f;
            if (r1 == null) goto L6;
            r1.c(r0.k3());
        L6:
            if ((r10 instanceof pf9.r) == false) goto L13;
            if (((pf9.r) r10).getType() != TriggerMode.CLIENT_SUMMON_NOTICE) goto L40;
            a3 r11 = r0.f;
            if (r11 == null) goto L41;
            r11.e(y88.e.a.a);
            return;
        L41:
            return;
        L40:
            return;
        L13:
            if ((r10 instanceof pf9.z) == false) goto L18;
            r0.h = null;
            DoraAvlinkSessionState r12 = DoraAvlinkSessionState.LISTENING;
            a3 r2 = r0.f;
            if (r2 == null) goto L43;
            r2.a(r12);
            return;
        L43:
            return;
        L18:
            if ((r10 instanceof pf9.c0) == false) goto L20;
            return;
        L20:
            if ((r10 instanceof pf9.a0) == false) goto L34;
            pf9.a0 r13 = (pf9.a0) r10;
            if (v88.a.f(Integer.valueOf(((n4) r0.getContext()).q())) == true) goto L27;
            if (r13.d == true) goto L27;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseDoraTimeoutKMPPlugin$handleQueryEnd$1(r0, null), 3, null);
        L27:
            if (r13.c == true) goto L29;
        L30:
            r0.h = TimerScene.QueryEnd;
            DoraAvlinkSessionState r14 = DoraAvlinkSessionState.THINKING;
            a3 r3 = r0.f;
            if (r3 == null) goto L47;
            r3.a(r14);
            return;
        L47:
            return;
        L29:
            if (r13.d == true) goto L30;
            return;
        L34:
            if ((r10 instanceof pf9.f0) == false) goto L38;
            com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "tts update");
            r0.h = null;
            DoraAvlinkSessionState r15 = DoraAvlinkSessionState.SPEAKING;
            a3 r4 = r0.f;
            if (r4 == null) goto L49;
            r4.a(r15);
            return;
        L49:
            return;
        L38:
            boolean r16 = r10 instanceof pf9.e0;
        }
    }

    static {
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r1) {
    }

    public final String T2() {
        return "DoraTimeoutKMPPlugin";
    }

    public abstract String l3();

    public abstract String m3();

    public abstract void n3(String r1);

    public abstract void o3();

    @Override // com.larus.avlink.plugins.o3
    public final void C2() {
        a3 r0 = this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    @Override // com.larus.avlink.plugins.z2
    public final void Z0() {
        n3("KMP VuiPreEnd");
    }

    public final void b3() {
        a3 r0 = this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final y88.g k3() {
        String r1 = ((n4) getContext()).params().f;
        if (this.h != TimerScene.OnStart) goto L8;
        if (((n4) getContext()).params().p.R == false) goto L8;
        Map<Function1<Boolean, Unit>, k4> r2 = x2.a;
        int r3 = x2.a();
    L21:
        return new y88.g(r3);
    L8:
        if (Intrinsics.areEqual(r1, l3()) == false) goto L10;
    L19:
        r3 = 15;
        goto L21
    L10:
        if (Intrinsics.areEqual(r1, m3()) == true) goto L19;
        Map<Function1<Boolean, Unit>, k4> r4 = x2.a;
        IDoraService r5 = x2.c();
        if (r5 == null) goto L15;
        Integer r6 = Integer.valueOf(r5.O());
    L16:
        if (r6 == null) goto L18;
        r3 = r6.intValue();
        goto L21
    L18:
        r3 = 8;
        goto L21
    L15:
        r6 = null;
        goto L16
    }

    @Override // com.larus.avlink.plugins.z2
    public final y88.a p2() {
        List<z4> r0 = this.g;
        boolean r2 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        if (((z4) r1.next()).needCancel() == false) goto L9;
        r2 = true;
    L14:
        return new y88.a(r2);
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.larus.avlink.plugins.o3
    public final void Z1() {
        MajorState.d r0 = ((n4) getContext()).a().A0();
        if ((r0 instanceof MajorState.d) == false) goto L13;
        MajorState.d r1 = r0;
        if (r1.d != MajorState.InterruptType.NOTHING) goto L13;
        MajorState.From r2 = r1.c;
        if (r2 == MajorState.From.PLAY_COMPLETE) goto L11;
        if (r2 != MajorState.From.TTS_ENDED) goto L13;
    L11:
        if (v88.a.f(Integer.valueOf(((n4) getContext()).q())) == true) goto L13;
        boolean r3 = true;
    L14:
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "onTtsPlayFinished needTimer: " + r3 + ", curState: " + r0);
        if (r3 == false) goto L23;
        this.h = TimerScene.OnTtsPlayFinished;
        a3 r4 = this.f;
        if (r4 == null) goto L19;
        r4.c(k3());
    L19:
        DoraAvlinkSessionState r5 = DoraAvlinkSessionState.WAITING;
        a3 r6 = this.f;
        if (r6 == null) goto L24;
        r6.a(r5);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r3 = false;
        goto L14
    }

    public final void g3() {
        super.g3();
        a3 r0 = this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.larus.avlink.plugins.o3
    public final void w1() {
        super.e3();
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "onTimeoutStart");
        this.h = TimerScene.OnStart;
        a3 r1 = this.f;
        if (r1 == null) goto L33;
        y88.g r4 = k3();
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "buildSessionContext, taskId: " + ((n4) getContext()).params().o.a + ", callId: " + ((n4) getContext()).params().e);
        RealtimeCallParam r0 = ((n4) getContext()).params();
        int r11 = ((n4) getContext()).q();
        String r5 = r0.e;
        String r6 = "";
        if (r5 != null) goto L7;
        String r8 = "";
    L8:
        String r7 = r0.o.a;
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        if (StringsKt.isBlank(r7) == true) goto L14;
        String r9 = r7;
    L19:
        o3();
        Map<Function1<Boolean, Unit>, k4> r10 = x2.a;
        IDoraService r12 = x2.c();
        if (r12 != null) goto L22;
    L24:
        boolean r13 = false;
    L26:
        if (Intrinsics.areEqual(r0.f, l3()) == false) goto L28;
    L31:
        boolean r14 = true;
    L32:
        r1.d(r4, new y88.c(r9, r8, true, r13, r11, r14, com.larus.im.service.audio.y0.e(r0.s), com.larus.im.service.audio.y0.d(r0.s)));
        goto L33
    L28:
        if (Intrinsics.areEqual(r0.f, m3()) == true) goto L31;
        r14 = false;
        goto L32
    L22:
        if (r12.J0() != true) goto L24;
        r13 = true;
        goto L26
    L14:
        if (StringsKt.isBlank(r8) == true) goto L17;
        r6 = r8;
    L17:
        r9 = r6;
        goto L19
    L7:
        r8 = r5;
    L33:
        Map<Function1<Boolean, Unit>, k4> r2 = x2.a;
        x2.e("is_dora_timeout_kmp", MapsKt.mapOf(new Pair[]{TuplesKt.to("session_id", ((n4) getContext()).params().o.a), TuplesKt.to("mode", Integer.valueOf(((n4) getContext()).q()))}));
    }

    public final void e3() {
        w1();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void s2() {
        g3();
    }

    public e(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = new ArrayList();
    }

    @Override // com.larus.avlink.plugins.z2
    public final void F(DoraAvlinkDeviceSound r2) {
        Intrinsics.checkNotNullParameter(r2, "sound");
        if (b.c[r2.ordinal()] != 1) goto L6;
        return;
    L6:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void G(TimerScene r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.h = r4;
        a3 r5 = this.f;
        if (r5 == null) goto L5;
        r5.c(k3());
    L5:
        a3 r6 = this.f;
        if (r6 == null) goto L8;
        r6.e(new y88.e.g(true, DoraAvlinkSessionState.WAITING));
    L8:
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "start timer");
    }

    @Override // com.larus.avlink.plugins.z2
    public final void X0(DoraAvlinkSessionEndReason r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (b.a[r4.ordinal()] != 1) goto L5;
        int r5 = DoraCallStateCode.DOUBAO_VUI_ERROR;
    L6:
        ((n4) getContext()).d(false, 1, r5);
        return;
    L5:
        r5 = 3;
        goto L6
    }

    @Override // com.larus.avlink.plugins.z2
    public final void Y(String r3) {
        Intrinsics.checkNotNullParameter("dora_avlink_timeout", "event");
        Intrinsics.checkNotNullParameter(r3, "paramsJson");
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        x2.e("dora_avlink_timeout", ia8.f.b(r3));
    }

    @Override // com.larus.avlink.plugins.z2
    public final void c2(DoraAvlinkDeviceLightAction r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (b.b[r2.ordinal()] != 1) goto L7;
        n3("KMP DeviceLight");
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void g1(String r4) {
        Intrinsics.checkNotNullParameter("wakeup success", "source");
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "cancelDelayTimerByScene source: wakeup success");
        this.h = null;
        a3 r5 = this.f;
        if (r5 == null) goto L6;
        r5.e(new y88.e.g(false, DoraAvlinkSessionState.UNKNOWN));
        return;
    }

    public final void j3(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.f = r2;
    }

    @Override // com.larus.avlink.plugins.o3
    public final void q1(DoraNotificationSummaryPlugin.c r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.g).add(r2);
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "registerNeedCancelInterceptor: interceptor registered");
    }

    @Override // com.larus.avlink.plugins.z2
    public final void g2(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "paramsJson");
        Map r4 = MapsKt.toMutableMap(ia8.f.b(r3));
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        x2.g(r2, "30s timeout", r4);
    }

    @Override // com.larus.avlink.plugins.z2
    public final void h0(boolean r3, int r4) {
        if (r3 == false) goto L5;
        Map<Function1<Boolean, Unit>, k4> r5 = x2.a;
        x2.i(new byte[]{1, (byte) r4}, 6);
        return;
    L5:
        Map<Function1<Boolean, Unit>, k4> r6 = x2.a;
        x2.i(new byte[]{0}, 7);
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
    }
}

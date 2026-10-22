package com.larus.voicecall.impl.plugins;

import android.os.Handler;
import android.os.Looper;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j2<C extends r> extends com.larus.audio.call.arch.a<C> implements k2 {
    public final String f;
    public pf9.t g;
    public boolean h;
    public final StateFlowImpl i;
    public final StateFlowImpl j;
    public boolean k;
    public i2 l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public final Handler q;
    public final a r;

    public static final class a extends com.larus.audio.call.play.e {
        public final /* synthetic */ j2<C> a;
        public final /* synthetic */ C b;

        public final void a() {
            j2<C> r0 = this.a;
            r0.h = false;
            FLogger r1 = FLogger.a;
            String r2 = r0.f;
            StringBuilder r3 = new StringBuilder("[quota][tts][ended] pending=");
            r3.append(((Boolean) this.a.i.getValue()).booleanValue());
            r3.append(", modalType=");
            pf9.t r4 = this.a.g;
            Integer r5 = null;
            if (r4 == null) goto L5;
            Integer r6 = Integer.valueOf(r4.a);
        L6:
            r3.append(r6);
            r3.append(", hangUpAfterSeconds=");
            pf9.t r7 = this.a.g;
            if (r7 == null) goto L9;
            r5 = Integer.valueOf(r7.e);
        L9:
            r3.append(r5);
            r3.append(", state=");
            r3.append(this.b.a().s1());
            r3.append(", waitForPlayComplete=true");
            r1.i(r2, r3.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.plugins.i2, java.lang.Runnable] */
        /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.voicecall.impl.plugins.h2] */
        public final void onPlayComplete() {
            FLogger r0 = FLogger.a;
            String r1 = this.a.f;
            StringBuilder r2 = new StringBuilder("[quota][playComplete] pending=");
            r2.append(((Boolean) this.a.i.getValue()).booleanValue());
            r2.append(", isTtsPlaying=");
            r2.append(this.a.h);
            r2.append(", hangUpAfterSeconds=");
            pf9.t r4 = this.a.g;
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.e);
        L6:
            r2.append(r5);
            r2.append(", state=");
            r2.append(this.b.a().s1());
            r0.i(r1, r2.toString());
            final j2<C> r3 = this.a;
            if (((Boolean) r3.i.getValue()).booleanValue() == true) goto L9;
        L21:
            r0.i(r3.f, "[quota][hangup][skip] from=onPlayComplete, pending=" + ((Boolean) r3.i.getValue()).booleanValue() + ", isTtsPlaying=" + r3.h);
            return;
        L9:
            if (r3.h == true) goto L21;
            pf9.t r6 = r3.g;
            if (r6 == null) goto L14;
            final int r7 = r6.e;
        L15:
            if (r7 <= 0) goto L20;
            r0.i(r3.f, "[quota][hangup][schedule] from=onPlayComplete, hangUpAfterSeconds=" + r7);
            final ?? r8 = new h2(r3);
            if (r3.l == null) goto L19;
            r0.i(r3.f, "[quota][hangup][schedule][skip] from=onPlayComplete, reason=already_scheduled, seconds=" + r7);
            return;
        L19:
            r0.i(r3.f, "[scheduleHangUpAfterTts] from=onPlayComplete, seconds=" + r7);
            r0.i(r3.f, "[quota][hangup][schedule][start] from=onPlayComplete, seconds=" + r7);
            ?? r9 = new i2(r3, r7, r8);
            r3.l = r9;
            r3.q.postDelayed(r9, ((long) r7) * 1000);
            return;
        L20:
            r0.i(r3.f, "[quota][hangup][immediate] from=onPlayComplete, hangUpAfterSeconds=" + r7);
            r3.k3("onPlayComplete");
            return;
        L14:
            r7 = 0;
            goto L15
        L5:
            r5 = null;
            goto L6
        }

        public final void b(Map<String, String> r5) {
            j2<C> r6 = this.a;
            r6.h = true;
            FLogger r0 = FLogger.a;
            String r7 = r6.f;
            StringBuilder r1 = new StringBuilder("[quota][tts][start] pending=");
            r1.append(((Boolean) this.a.i.getValue()).booleanValue());
            r1.append(", modalType=");
            pf9.t r2 = this.a.g;
            Integer r3 = null;
            if (r2 == null) goto L5;
            Integer r4 = Integer.valueOf(r2.a);
        L6:
            r1.append(r4);
            r1.append(", hangUpAfterSeconds=");
            pf9.t r8 = this.a.g;
            if (r8 == null) goto L9;
            r3 = Integer.valueOf(r8.e);
        L9:
            r1.append(r3);
            r1.append(", state=");
            r1.append(this.b.a().s1());
            r0.i(r7, r1.toString());
            return;
        L5:
            r4 = null;
            goto L6
        }

        public a(j2<C> r1, C r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ j2<C> b;

        public final String g() {
            return this.a;
        }

        public b(j2<C> r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            if ((r10 instanceof pf9.d0) == false) goto L29;
            j2<C> r0 = this.b;
            pf9.d0 r11 = (pf9.d0) r10;
            r0.getClass();
            pf9.t r2 = r11.d;
            if (r2 == null) goto L43;
            FLogger r3 = FLogger.a;
            r3.i(r0.f, "[handleReplyBegin] quota =" + r2.a);
            r3.i(r0.f, "[quota][replyBegin][receive] modalType=" + r2.a + ", countdownSecs=" + r2.b + ", limitType=" + r2.d + ", hangUpAfterSeconds=" + r2.e + ", toast=" + r2.c + ", modelType=" + r11.a + ", linkState=" + r11.c + ", currentInVideoMode=" + r0.l3() + ", state=" + r0.getContext().a().s1() + ", bannerSource=CMD_80004_not_replyBegin");
            String r1 = r0.p;
            String r4 = null;
            if (r1 == null) goto L10;
            r3.i(r0.f, "[quota][replyBegin][ignore] reason=pending_hangup_cancelled, cancelReason=" + r1 + ", modalType=" + r2.a + ", limitType=" + r2.d + ", currentInVideoMode=" + r0.l3());
            r0.p = null;
            return;
        L10:
            r0.g = r2;
            com.larus.voicecall.impl.degrade.h.a.getClass();
            Intrinsics.checkNotNullParameter(r2, "quota");
            r3.i("RealtimeCallQuota", "setSingleTimeQuota modalType = " + r2.a);
            int r5 = r2.a;
            if (r5 != 1) goto L13;
            r4 = "voice_call";
        L17:
            if (r4 == null) goto L21;
            r3.i("RealtimeCallQuota", "setSingleTimeQuota quotaScene = " + r4 + " and toast = " + r2.c + " and countdownSecs = " + r2.b + " and limitType = " + r2.d);
            com.larus.voicecall.impl.degrade.h.c.add(r2);
        L21:
            if (r0.m3() == true) goto L23;
            r3.i(r0.f, "[handleReplyBegin] modal has changed");
            r3.i(r0.f, "[quota][replyBegin][ignore] reason=modal_not_match, modalType=" + r2.a + ", currentInVideoMode=" + r0.l3());
            r0.j3();
            return;
        L23:
            r0.i.setValue(Boolean.TRUE);
            r0.getContext().a().a1(MajorState.b.c, r0.f);
            com.larus.audio.call.arch.b.a(r0.getContext()).K0(true);
            String r12 = r0.f;
            StringBuilder r6 = new StringBuilder("[quota][pending] pending=true, state=");
            r6.append(r0.getContext().a().s1());
            r6.append(", audioUploadPaused=true, hangUpAfterSeconds=");
            r6.append(r2.e);
            r6.append(", waitWindow=");
            if (r2.e <= 0) goto L26;
            String r7 = "after_tts";
        L27:
            r6.append(r7);
            r3.i(r12, r6.toString());
            return;
        L26:
            r7 = "none_immediate_on_play_complete";
            goto L27
        L13:
            if (r5 != 2) goto L17;
            r4 = "video_call";
            goto L17
        L43:
            return;
        L29:
            if ((r10 instanceof pf9.o0) == false) goto L41;
            j2<C> r13 = this.b;
            boolean r8 = r13.l3();
            if (r8 == r13.k) goto L44;
            r13.k = r8;
            if ((r13.getContext().a().s1() instanceof MajorState.b) == true) goto L36;
            FLogger.a.i(r13.f, "[quota][modalSwitch][ignore] from=ModalSwitchedEvent, currentInVideoMode=" + r8 + ", state=" + r13.getContext().a().s1());
            return;
        L36:
            FLogger.a.i(r13.f, "[quota][modalSwitch][cancel] from=ModalSwitchedEvent, currentInVideoMode=" + r8);
            r13.j3();
            com.larus.audio.call.arch.b.a(r13.getContext()).K0(false);
            LLMCallController.D(r13.getContext().n(), r13.getContext().params(), false, 4);
            return;
        L44:
            return;
        }
    }

    @Override // com.larus.voicecall.impl.plugins.k2
    public final void D2() {
        Intrinsics.checkNotNullParameter("museum_extension_pick_start", "reason");
        this.m = true;
        this.n = "museum_extension_pick_start";
        i2 r0 = this.l;
        if (r0 == null) goto L5;
        this.q.removeCallbacks(r0);
    L5:
        this.l = null;
        FLogger.a.i(this.f, "[quota][pending][pause] reason=museum_extension_pick_start, pending=" + ((Boolean) this.i.getValue()).booleanValue() + ", deferredFinishFrom=" + this.o);
    }

    @Override // com.larus.voicecall.impl.plugins.k2
    public final void I() {
        Intrinsics.checkNotNullParameter("museum_extension_pick_success", "reason");
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L6;
        FLogger.a.i(this.f, "[quota][pending][cancel_resume][defer] reason=museum_extension_pick_success, pending=false");
        this.p = "museum_extension_pick_success";
        this.m = false;
        this.n = null;
        this.o = null;
        return;
    L6:
        FLogger r0 = FLogger.a;
        r0.i(this.f, "[cancelPendingHangUpAndResumeCall]");
        String r1 = this.f;
        StringBuilder r4 = new StringBuilder("[quota][pending][cancel_resume][start] reason=museum_extension_pick_success, state=");
        r4.append(getContext().a().s1());
        r4.append(", modalType=");
        pf9.t r5 = this.g;
        if (r5 == null) goto L9;
        Integer r6 = Integer.valueOf(r5.a);
    L10:
        r4.append(r6);
        r4.append(", deferredFinishFrom=");
        r4.append(this.o);
        r0.i(r1, r4.toString());
        this.m = false;
        this.n = null;
        this.o = null;
        j3();
        com.larus.audio.call.arch.b.a(getContext()).K0(false);
        getContext().n().U(getContext().params());
        getContext().a().n2(StateTriggerEvent.Resume.a);
        LLMCallController.D(getContext().n(), getContext().params(), false, 4);
        r0.i(this.f, "[quota][pending][cancel_resume][done] reason=museum_extension_pick_success, state=" + getContext().a().s1() + ", audioUploadPaused=false, unMute=true");
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    @Override // com.larus.voicecall.impl.plugins.k2
    public final void b2() {
        Intrinsics.checkNotNullParameter("museum_extension_pick_fail", "reason");
        String r0 = this.o;
        if (r0 != null) goto L5;
        r0 = "finish_now:museum_extension_pick_fail";
    L5:
        i2 r1 = this.l;
        if (r1 == null) goto L8;
        this.q.removeCallbacks(r1);
    L8:
        FLogger r2 = FLogger.a;
        String r3 = this.f;
        StringBuilder r4 = new StringBuilder("[quota][pending][finish_now] reason=museum_extension_pick_fail, pending=");
        r4.append(((Boolean) this.i.getValue()).booleanValue());
        r4.append(", deferredFinishFrom=");
        r4.append(this.o);
        r4.append(", hadRunnable=");
        if (this.l == null) goto L11;
        boolean r5 = true;
    L12:
        r4.append(r5);
        r2.i(r3, r4.toString());
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        k3(r0);
        return;
    L11:
        r5 = false;
        goto L12
    }

    public final void j3() {
        i2 r0 = this.l;
        if (r0 == null) goto L5;
        this.q.removeCallbacks(r0);
    L5:
        FLogger r1 = FLogger.a;
        String r2 = this.f;
        StringBuilder r3 = new StringBuilder("[quota][pending][clear] hadRunnable=");
        if (this.l == null) goto L8;
        boolean r4 = true;
    L9:
        r3.append(r4);
        r3.append(", hadPending=");
        r3.append(((Boolean) this.i.getValue()).booleanValue());
        r3.append(", paused=");
        r3.append(this.m);
        r3.append(", deferredFinishFrom=");
        r3.append(this.o);
        r1.i(r2, r3.toString());
        this.l = null;
        this.i.setValue(Boolean.FALSE);
        this.g = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final boolean m3() {
        pf9.t r0 = this.g;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.a);
    L7:
        if (r1 != null) goto L10;
    L15:
        if (r1 != null) goto L18;
        return true;
    L18:
        if (r1.intValue() == 2) goto L20;
        return true;
    L20:
        return l3();
    L10:
        if (r1.intValue() != 1) goto L15;
        if (l3() == false) goto L23;
        return false;
    L23:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final void b3() {
        com.larus.audio.call.arch.b.a(getContext()).e0().j(this.r);
        this.h = false;
        j3();
        com.larus.voicecall.impl.degrade.h.a.getClass();
        FLogger.a.i("RealtimeCallQuota", "clearSingleTimeQuota");
        com.larus.voicecall.impl.degrade.h.c.clear();
    }

    public final void e3() {
        super.e3();
        this.k = l3();
        com.larus.audio.call.arch.b.a(getContext()).e0().i(this.r);
    }

    public final boolean l3() {
        o1 r0 = s.e((r) getContext());
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        u2 r2 = s.d((r) getContext());
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.J() != true) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.D5() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.voicecall.impl.plugins.k2
    public final StateFlowImpl S1() {
        return this.j;
    }

    public final String T2() {
        return this.f;
    }

    public j2(C r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "rcQuotaHangUpPlugin";
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(Boolean.FALSE);
        this.i = r0;
        this.j = r0;
        this.q = new Handler(Looper.getMainLooper());
        this.r = new a(this, r3);
    }

    public final void k3(String r6) {
        if (this.m == false) goto L6;
        this.o = r6;
        FLogger.a.i(this.f, "[quota][finish][defer] from=" + r6 + ", reason=pending_hangup_paused, pauseReason=" + this.n);
        return;
    L6:
        String r1 = null;
        Integer r2 = null;
        if (m3() == true) goto L13;
        FLogger r0 = FLogger.a;
        r0.i(this.f, "[finishQuotaExceededCall] modal has changed, from=" + r6);
        String r3 = this.f;
        StringBuilder r4 = new StringBuilder("[quota][finish][cancel] from=");
        r4.append(r6);
        r4.append(", reason=modal_not_match, modalType=");
        pf9.t r7 = this.g;
        if (r7 == null) goto L11;
        r2 = Integer.valueOf(r7.a);
    L11:
        r4.append(r2);
        r4.append(", currentInVideoMode=");
        r4.append(l3());
        r0.i(r3, r4.toString());
        j3();
        com.larus.audio.call.arch.b.a(getContext()).K0(false);
        return;
    L13:
        FLogger r5 = FLogger.a;
        r5.i(this.f, "[quotaExceededHangUp] from=" + r6);
        String r8 = this.f;
        StringBuilder r9 = new StringBuilder("[quota][finish][call] from=");
        r9.append(r6);
        r9.append(", limitType=");
        pf9.t r10 = this.g;
        if (r10 == null) goto L16;
        r1 = r10.d;
    L16:
        r9.append(r1);
        r9.append(", fallbackEndMethod=quota_exceeded");
        r5.i(r8, r9.toString());
        com.larus.voicecall.impl.q r11 = ((r) getContext()).h();
        if (r11 == null) goto L25;
        pf9.t r12 = this.g;
        if (r12 == null) goto L22;
        String r13 = r12.d;
        if (r13 == null) goto L22;
    L23:
        r11.d(r13);
        return;
    L22:
        r13 = "quota_exceeded";
        goto L23
    }
}

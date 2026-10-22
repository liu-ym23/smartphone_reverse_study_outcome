package com.larus.audio.call.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.voicecall.impl.component.interview.RealtimeInterviewComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f1 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements z0 {
    public e1 f;
    public final a g;

    public static final class a extends com.larus.audio.call.play.e {
        public final /* synthetic */ f1 a;

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void a() {
            e1 r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public a(f1 r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void b(Map<String, String> r1) {
            e1 r2 = this.a.f;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "RealtimeCallInterviewPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        com.larus.audio.call.arch.b.a(getContext()).e0().j(this.g);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        com.larus.audio.call.arch.b.a(getContext()).e0().i(this.g);
    }

    public f1(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = new a(this);
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void A2(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("RealtimeCallInterviewPlugin", "[onInterviewUploadPicEnd], currentState:" + r5);
        if (i3() == true) goto L6;
        return;
    L6:
        if (getContext().n().u == false) goto L9;
        r0.i("RealtimeCallInterviewPlugin", "[onInterviewUploadPicEnd], isMuted");
        return;
    L9:
        com.larus.audio.call.arch.b.a(getContext()).l1();
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void B1(RealtimeInterviewComponent.b r1) {
        this.f = r1;
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void e1(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e.a.i("RealtimeCallInterviewPlugin", "[onReceiveInterviewHangUpEvent], currentState:" + r5);
        if (i3() == true) goto L5;
        return;
    L5:
        com.larus.audio.call.arch.b.a(getContext()).u();
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void n1(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i("RealtimeCallInterviewPlugin", "[onInterviewPlaningEnd], currentState:" + r5);
        if (i3() == true) goto L6;
        return;
    L6:
        if (getContext().n().u == false) goto L9;
        r0.i("RealtimeCallInterviewPlugin", "[onInterviewPlaningEnd] isMuted");
        return;
    L9:
        getContext().a().a1(MajorState.h.c, "RealtimeCallInterviewPlugin");
        getContext().a().n2(StateTriggerEvent.RequestSpeaking.a);
        com.larus.audio.call.arch.b.a(getContext()).l1();
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void o1(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e.a.i("RealtimeCallInterviewPlugin", "[triggerHello], currentState:" + r5);
        if (i3() == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("trigger_event", ouc.k.c("scene_mode_introduce"));
        String r0 = getContext().params().p.i;
        if (r0 == null) goto L8;
        r6.put("enter_method", ouc.k.c(r0));
    L8:
        String r1 = getContext().params().p.p;
        if (r1 != null) goto L11;
    L19:
        ouc.d0 r2 = new ouc.d0(r6);
        com.larus.audio.call.arch.b.a(getContext()).C1();
        getContext().a().t();
        id9.d r7 = getContext().j();
        if (r7 == null) goto L23;
        r7.p(TriggerMode.HELLO, r2.toString());
        return;
    L23:
        return;
    L11:
        if (r1.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        r1 = null;
    L17:
        if (r1 == null) goto L19;
        r6.put("bot_say_hello_text_key", ouc.k.c(r1));
        goto L19
    L13:
        r3 = false;
        goto L14
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void v0(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e.a.i("RealtimeCallInterviewPlugin", "[onInterviewPlaningStart], currentState:" + r5);
        if (i3() == true) goto L5;
        return;
    L5:
        com.larus.audio.call.arch.b.a(getContext()).u();
    }

    @Override // com.larus.audio.call.plugins.z0
    public final void z2(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        MajorState r5 = getContext().a().s1();
        com.larus.audio.call.util.e.a.i("RealtimeCallInterviewPlugin", "[onInterviewUploadPicStart], currentState:" + r5);
        if (i3() == true) goto L5;
        return;
    L5:
        com.larus.audio.call.arch.b.a(getContext()).u();
    }
}

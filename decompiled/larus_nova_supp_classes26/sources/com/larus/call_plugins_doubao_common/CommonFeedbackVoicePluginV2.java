package com.larus.call_plugins_doubao_common;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.p;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.im.service.audio.z0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import pf9.a0;
import pf9.c0;
import pf9.e0;
import pf9.f0;
import pf9.r;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class CommonFeedbackVoicePluginV2<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements k {
    public final String f;
    public final Lazy g;
    public volatile boolean h;
    public volatile boolean i;
    public p j;
    public String k;
    public Job l;
    public boolean m;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> a;

        public a(CommonFeedbackVoicePluginV2<C> r1) {
            this.a = r1;
        }

        public final void Q(MajorState r5, MajorState r6) {
            Intrinsics.checkNotNullParameter(r5, "prev");
            Intrinsics.checkNotNullParameter(r6, "current");
            FLogger.a.i(this.a.T2(), "[onStateChanged] prev:" + r5 + ", current:" + r6);
            this.a.l3(r5, r6);
        }
    }

    public static final class b extends z0 {
        public boolean a;
        public final String b;
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> c;

        public final String g() {
            return this.b;
        }

        public b(CommonFeedbackVoicePluginV2<C> r1) {
            this.c = r1;
            this.b = r1.T2();
        }

        public final void n(z0.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if ((r4 instanceof z) == false) goto L6;
            this.a = true;
            CommonFeedbackVoicePluginV2<C> r0 = this.c;
            r0.k = ((z) r4).a;
            FLogger.a.i(r0.T2(), "[FlowLLMQueryBeginEvent] try stopVoiceAppease on intent interrupt");
            this.c.r3(null);
            return;
        L6:
            if ((r4 instanceof c0) == false) goto L9;
            this.c.m = false;
            return;
        L9:
            if ((r4 instanceof a0) == false) goto L19;
            if (this.a == false) goto L13;
        L14:
            this.a = false;
            a0 r5 = (a0) r4;
            if (r5.d == false) goto L17;
            this.c.m = false;
        L17:
            FLogger.a.i(this.c.T2(), "[FlowLLMQueryEndEvent] tryTriggerAppeaseTask");
            this.c.s3(r5);
            return;
        L13:
            if (((a0) r4).d == true) goto L14;
            return;
        L19:
            if ((r4 instanceof f0) == false) goto L22;
            this.c.n3((f0) r4);
            return;
        L22:
            if ((r4 instanceof e0) == false) goto L25;
            this.c.m3((e0) r4);
            return;
        L25:
            if ((r4 instanceof r) == false) goto L36;
            int r1 = sf9.b.a;
            if (sf9.b.a(((r) r4).getType()) == false) goto L37;
            this.c.m = false;
            return;
        L37:
            return;
        }
    }

    public static final class c extends p {
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> g;

        public final void c(long r1) {
        }

        public final void b() {
            CommonFeedbackVoicePluginV2<C> r0 = this.g;
            r0.j = null;
            if (r0.i == false) goto L6;
            FLogger.a.i(this.g.T2(), "[voiceAppeaseTimer] onFinish cancelled due to shouldCancelAppease");
            return;
        L6:
            CommonFeedbackVoicePluginV2.q3(this.g);
        }

        public c(long r1, CommonFeedbackVoicePluginV2<C> r3) {
            this.g = r3;
            super(r1, r1);
        }
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public void O0() {
    }

    public final void X2() {
        r3(null);
    }

    public final void b3() {
        r3(null);
        j3().f();
        IVideoController r0 = j3().d();
        if (r0 == null) goto L6;
        r0.t();
        return;
    }

    public void k3() {
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public void o0() {
    }

    public final z0 S2() {
        return new b(this);
    }

    public AudioSoundAppeaseManager j3() {
        return (AudioSoundAppeaseManager) this.g.getValue();
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public final long B2() {
        AudioSoundAppeaseManager r0 = j3();
        if (r0.f == false) goto L7;
        IVideoController r1 = r0.d();
        if (r1 == null) goto L7;
        return r1.getWatchedDuration();
    L7:
        return 0;
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.l;
        if (r0 != null) goto L7;
    L8:
        this.l = U2(new CommonFeedbackVoicePluginV2$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    public final void g3() {
        super.g3();
        CoroutineScope r1 = getContext().r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, Dispatchers.getMain(), null, new CommonFeedbackVoicePluginV2$onStop$1(this, null), 2, null);
        return;
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public final boolean isPlaying() {
        return j3().f;
    }

    public void o3() {
        IRealtimeCallTracer r0 = getContext().k();
        String r1 = getContext().params().e;
        String r2 = getContext().params().o.h;
        IVoiceCallService r3 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r3 == null) goto L6;
        String r4 = r3.s();
        if (r4 == null) goto L6;
    L7:
        r0.e(r1, r2, r4, this.k);
        return;
    L6:
        r4 = "";
        goto L7
    }

    public String T2() {
        return this.f;
    }

    public CommonFeedbackVoicePluginV2(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "CommonFeedbackVoicePluginV2";
        this.g = LazyKt.lazy(new g());
    }

    public static final <C extends com.larus.audio.call.arch.c> void q3(final CommonFeedbackVoicePluginV2<C> r4) {
        FLogger.a.i(r4.T2(), "[startVoiceAppease] .isPlaying() :" + r4.j3().f);
        r4.k3();
        r4.o3();
        r4.h = true;
        com.larus.audio.call.arch.b.e(r4.getContext(), new e(r4));
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public void m1(Function1<? super MajorState, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateChecker");
    }

    public void m3(e0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.m == true) goto L6;
        FLogger.a.i(T2(), "[FlowLLMReplyEndEvent] stopVoiceAppease");
        r3(null);
        return;
    }

    public void n3(f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (pf9.i.j(r3) == true) goto L5;
        return;
    L5:
        if (this.m == true) goto L9;
        this.m = true;
        FLogger.a.i(T2(), "[FlowLLMReplyUpdateEvent] sentenceUpdate stopVoiceAppease");
        r3(null);
        return;
    }

    public final void r3(Function1<? super Boolean, Unit> r4) {
        FLogger.a.i(T2(), "[stopVoiceAppeaseImmediately] stop");
        this.i = true;
        p r1 = this.j;
        if (r1 == null) goto L5;
        r1.a();
    L5:
        this.j = null;
        j3().h(true, r4);
    }

    public void s3(a0 r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (z2.a.getRealCallSoundConfig().c == true) goto L5;
        return;
    L5:
        if (getContext().n().u == true) goto L19;
        Long r7 = Long.valueOf(r6.e);
        if (r7.longValue() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r7 = null;
    L13:
        if (r7 == null) goto L15;
        long r1 = r7.longValue();
    L16:
        p3(r1, new d());
        return;
    L15:
        r1 = 2000;
        goto L16
    L9:
        r0 = false;
        goto L10
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public void c1(boolean r2, Function1<? super Boolean, Unit> r3) {
        AudioSoundAppeaseManager r4 = j3();
        int r0 = AudioSoundAppeaseManager.i;
        r4.h(false, r3);
    }

    public void l3(MajorState r2, MajorState r3) {
        Intrinsics.checkNotNullParameter(r2, "prev");
        Intrinsics.checkNotNullParameter(r3, "current");
        if ((r2 instanceof MajorState.g) == false) goto L5;
        return;
    L5:
        if ((r3 instanceof MajorState.g) == false) goto L9;
        r3(null);
        return;
    }

    public final void p3(long r5, Function1<? super MajorState, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r7, "stateChecker");
        if (this.j == null) goto L6;
        FLogger.a.i(T2(), "startVoiceAppeaseCountdownTimer ignored, timer already running");
        return;
    L6:
        this.i = false;
        if (r5 > 0) goto L10;
        FLogger.a.i(T2(), "startVoiceAppeaseCountdownTimer start directly, waitTime: " + r5);
        q3(this);
        return;
    L10:
        c r8 = new c(r5, this);
        this.j = r8;
        FLogger.a.i(T2(), "startVoiceAppeaseCountdownTimer interval: " + r5);
        r8.d();
    }
}

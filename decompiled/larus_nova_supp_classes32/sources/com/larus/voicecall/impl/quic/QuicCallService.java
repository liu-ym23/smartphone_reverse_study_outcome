package com.larus.voicecall.impl.quic;

import android.app.Application;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.f;
import com.larus.audio.call.plugins.t0;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.c0;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent$b;
import com.larus.voicecall.impl.q;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import o3a.h;
import o3a.i;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class QuicCallService extends com.larus.audio.call.a implements t1a.c {
    public static final /* synthetic */ int x = 0;
    public final Function0<CoroutineScope> s;
    public RealtimeCallParam t;
    public final e u;
    public final com.larus.voicecall.impl.quic.c v;
    public Job w;

    public final class a extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
        public final String f;
        public final /* synthetic */ QuicCallService g;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.quic.QuicCallService$a$a, reason: collision with other inner class name */
        public static final class C0020a implements v {
            public final String a;
            public final /* synthetic */ QuicCallService b;

            public final String getName() {
                return this.a;
            }

            public C0020a(a r1, QuicCallService r2) {
                this.b = r2;
                this.a = r1.f;
            }

            public final void O1(jd9.c r2, jd9.c r3) {
                Intrinsics.checkNotNullParameter(r2, "oldState");
                Intrinsics.checkNotNullParameter(r3, "newState");
                QuicCallService r4 = this.b;
                int r5 = QuicCallService.x;
                r4.getClass();
            }
        }

        public static final class b extends a1 {
            public final String a;
            public final /* synthetic */ QuicCallService b;

            public final String g() {
                return this.a;
            }

            public final void n(z0.a r2) {
                Intrinsics.checkNotNullParameter(r2, "event");
                QuicCallService r3 = this.b;
                int r0 = QuicCallService.x;
                r3.getClass();
            }

            public b(a r1, QuicCallService r2) {
                this.b = r2;
                this.a = r1.f;
            }

            public final void q(String r1, Object r2) {
                Intrinsics.checkNotNullParameter(r1, "event");
                Intrinsics.checkNotNullParameter(r1, "event");
                QuicCallService r3 = this.b;
                int r4 = QuicCallService.x;
                r3.getClass();
            }
        }

        public final v R2() {
            return new C0020a(this, this.g);
        }

        public final z0 S2() {
            return new b(this, this.g);
        }

        public final String T2() {
            return this.f;
        }

        public a(QuicCallService r2, com.larus.audio.call.arch.c r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.g = r2;
            super(r3);
            this.f = "BridgePlugin";
        }
    }

    public static final class b {
    }

    public final class c implements q {
        public final /* synthetic */ QuicCallService a;

        @Override // com.larus.voicecall.impl.q
        public final void a(r58.d r2) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        }

        @Override // com.larus.voicecall.impl.q
        public final void c(long r1) {
        }

        @Override // com.larus.voicecall.impl.q
        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "endMethod");
        }

        @Override // com.larus.voicecall.impl.q
        public final void e() {
        }

        @Override // com.larus.voicecall.impl.q
        public final void g(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        }

        @Override // com.larus.voicecall.impl.q
        public final void h() {
        }

        @Override // com.larus.voicecall.impl.q
        public final void onReconnect() {
        }

        @Override // com.larus.voicecall.impl.q
        public final void onReconnected() {
        }

        public c(QuicCallService r1) {
            this.a = r1;
        }

        @Override // com.larus.voicecall.impl.q
        public final void b(c0 r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
        }

        @Override // com.larus.voicecall.impl.q
        public final void f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Function1 r0 = ((com.larus.audio.call.a) this.a).a;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }
    }

    static {
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tosKey");
    }

    public final void b() {
        this.u.L();
    }

    public final f h() {
        return LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(f.class));
    }

    public final com.larus.voicecall.impl.plugins.v i() {
        return (com.larus.voicecall.impl.plugins.v) LLMCallController.w(this.u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.v.class));
    }

    public final void j() {
        FLogger.a.i("QuicCallService", "CallStateManager connectionState NetworkError release call");
        RealtimeCallParam r0 = this.t;
        if (r0 == null) goto L5;
        CompletableDeferred r1 = this.u.T(r0);
    L6:
        if (r1 != null) goto L8;
        this.u.L();
    L9:
        s r2 = s.a;
        Application r3 = AppHost.a.getApplication();
        r2.getClass();
        s.s(r3, 2131907052);
        return;
    L8:
        r1.invokeOnCompletion(new com.larus.voicecall.impl.quic.a(this));
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void a(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        FLogger.a.i("QuicCallService", "interruptAsr");
        t0 r4 = LLMCallController.y(this.u, Reflection.getOrCreateKotlinClass(t0.class));
        if (r4 == null) goto L6;
        r4.d0();
        return;
    }

    public final void d(RealtimeCallParam r7) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        this.t = r7;
        LLMCallController.S(this.u, r7);
        FLogger.a.i("QuicCallService", "start session , callId: " + r7.e + " , roomId: " + r7.d + " , url: " + r7.k.a);
        if (com.larus.audio.call.f.f() == false) goto L8;
        CoroutineScope r0 = (CoroutineScope) this.s.invoke();
        Job r8 = null;
        if (r0 == null) goto L7;
        r8 = BuildersKt.launch$default(r0, null, null, new QuicCallService$start$1(this, null), 3, null);
    L7:
        this.w = r8;
        return;
    L8:
        h().M0(this.v);
    }

    public final void e(RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        this.u.T(r4);
        if (com.larus.audio.call.f.f() == false) goto L8;
        Job r0 = this.w;
        if (r0 == null) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L7:
        this.w = null;
    L9:
        FLogger.a.i("QuicCallService", "finish session , callId: " + r4.e + " , roomId: " + r4.d + " , url: " + r4.k.a);
        return;
    L8:
        h().V(this.v);
        goto L9
    }

    public QuicCallService(b78.e r3, QuicInterpretComponent$b r4, h r5, i r6) {
        Intrinsics.checkNotNullParameter(r3, "sessionCreator");
        Intrinsics.checkNotNullParameter(r4, "traceSpan");
        Intrinsics.checkNotNullParameter(r5, "lifecycleScope");
        this.s = r5;
        e r0 = new e(r3, r4, r5, new com.larus.voicecall.impl.quic.b(r6, this));
        r0.y = new c(this);
        this.u = r0;
        this.v = new com.larus.voicecall.impl.quic.c(this);
    }
}

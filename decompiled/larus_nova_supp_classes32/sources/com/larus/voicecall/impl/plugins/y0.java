package com.larus.voicecall.impl.plugins;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.plugins.r;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y0<C extends r> extends com.larus.audio.call.arch.a<C> implements a1 {
    public final String f;
    public boolean g;
    public String h;
    public d i;
    public long j;
    public boolean k;
    public long l;
    public a m;
    public final ConcurrentHashMap<String, a> n;

    public static final class a {
        public long a;
        public String b;
        public final boolean c;
        public String d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r2 = 1231;
        L7:
            return ((r1 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "CountDownConfig(secondsInFuture=" + this.a + ", tips=" + this.b + ", isTotalTimeStrategy=" + this.c + ", limitType=" + this.d + ')';
        }

        public a(long r2, String r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "tips");
            Intrinsics.checkNotNullParameter(r6, "limitType");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ y0<C> b;

        public final String getName() {
            return this.a;
        }

        public b(y0<C> r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r6, jd9.c r7) {
            Intrinsics.checkNotNullParameter(r6, "oldState");
            Intrinsics.checkNotNullParameter(r7, "newState");
            if ((r7 instanceof jd9.c.a) == false) goto L27;
            y0<C> r8 = this.b;
            if (r8.g == false) goto L28;
            boolean r9 = false;
            r8.g = false;
            if (r8.j > (-1)) goto L25;
            r8.j = System.currentTimeMillis();
            o1 r0 = s.e((r) r8.getContext());
            if (r0 != null) goto L11;
        L13:
            boolean r1 = false;
        L14:
            if (r1 == true) goto L23;
            u2 r2 = s.d((r) r8.getContext());
            if (r2 != null) goto L18;
        L20:
            if (r9 == true) goto L23;
            String r10 = "voice_call";
        L24:
            r8.K1(r10);
            goto L25
        L18:
            if (r2.J() != true) goto L20;
            r9 = true;
        L23:
            r10 = "video_call";
            goto L24
        L11:
            if (r0.y1() != true) goto L13;
            r1 = true;
        L25:
            Keva r11 = RealtimeCallDegradeManager.a;
            RealtimeCallDegradeManager.k("enter_realtime_call");
            return;
        L28:
            return;
        }
    }

    public static final class c extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ y0<C> b;

        public final String g() {
            return this.a;
        }

        public c(y0<C> r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(final com.larus.im.service.audio.z0.a r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            if ((r6 instanceof pf9.t) == false) goto L6;
            FLogger r0 = FLogger.a;
            String r1 = this.b.f;
            StringBuilder r2 = new StringBuilder("FlowLLMDownlinkQuotaExceededEvent receive modalType = ");
            pf9.t r3 = (pf9.t) r6;
            r2.append(r3.a);
            r2.append(" and countdownSecs = ");
            r2.append(r3.b);
            r2.append(" quotaExceededToast = ");
            r2.append(r3.c);
            r2.append("and limitType = ");
            r2.append(r3.d);
            r2.append(' ');
            r0.v(r1, r2.toString());
            final y0<C> r4 = this.b;
            com.larus.utils.t0.e(new z0(r4, r6));
            return;
        }
    }

    public static final class d extends com.larus.audio.call.p {
        public final /* synthetic */ y0<C> g;

        public final void b() {
            this.g.k3();
        }

        public final void c(long r4) {
            if (r4 > 0) goto L5;
            return;
        L5:
            if (r4 >= AutoEndConversationTime.AFTER_60_SECONDS) goto L11;
            y0<C> r0 = this.g;
            r0.l = r4 / ((long) 1000);
            com.larus.voicecall.impl.q r5 = ((r) r0.getContext()).h();
            if (r5 == null) goto L12;
            r5.c(this.g.l);
            return;
        L12:
            return;
        }

        public d(y0<C> r3, long r4) {
            this.g = r3;
            super(r4, 1000);
        }
    }

    public final void b3() {
        this.k = true;
        d r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.i = null;
        String r1 = this.h;
        FLogger.a.v(this.f, "scene: " + r1 + " and currentScene: " + this.h);
        if (Intrinsics.areEqual(r1, this.h) == false) goto L9;
        com.larus.voicecall.impl.degrade.i.c(r1);
        this.h = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        Keva r2 = RealtimeCallDegradeManager.a;
        RealtimeCallDegradeManager.k("leave_realtime_call");
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    public final void j3() {
        FLogger.a.i(this.f, "clearCountDown");
        d r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.i = null;
        com.larus.voicecall.impl.q r1 = ((r) getContext()).h();
        if (r1 == null) goto L8;
        r1.e();
    L8:
        this.m = null;
        this.l = -1;
    }

    public final void k3() {
        this.l = 0;
        String r0 = this.h;
        a r1 = this.m;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        com.larus.voicecall.impl.degrade.d.a(r0, r2);
        String r3 = this.h;
        a r4 = this.m;
        if (r4 == null) goto L11;
        String r5 = r4.d;
        if (r5 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "limitType");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L15
        r7.put("limited_biz", r3);     // Catch: Throwable -> L15
        r7.put("limited_trigger", "process");     // Catch: Throwable -> L15
        r7.put("limited_type", r5);     // Catch: Throwable -> L15
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r8) == false) goto L20;
        r8 = null;
    L20:
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        r9.reportEvent("to_limited_toast_show", (JSONObject) r8);
        a r10 = this.m;
        if (r10 == null) goto L24;
        final String r11 = r10.b;
        if (r11 == null) goto L24;
    L25:
        com.larus.utils.t0.d(new x0(r11), 100);
        com.larus.voicecall.impl.q r12 = ((r) getContext()).h();
        if (r12 == null) goto L36;
        a r13 = this.m;
        if (r13 == null) goto L31;
        String r14 = r13.d;
        if (r14 == null) goto L31;
    L32:
        r12.d(r14);
        return;
    L31:
        r14 = "reach_single_time_limit";
        goto L32
    L36:
        return;
    L24:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        r5 = "other";
        goto L12
    L5:
        if (r1.c != true) goto L7;
        r2 = true;
        goto L7
    }

    public final void m3() {
        a r0 = this.m;
        if (r0 == null) goto L13;
        long r1 = r0.a;
        FLogger.a.i(this.f, "startCountDown millisInFuture = " + r1);
        if (this.i == null) goto L7;
        return;
    L7:
        if (r1 < 0) goto L15;
        if (r1 != 0) goto L11;
        k3();
        return;
    L11:
        d r2 = new d(this, r1 * 1000);
        this.i = r2;
        r2.d();
        return;
    L15:
        return;
    }

    public final String T2() {
        return this.f;
    }

    public y0(C r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "rcDowngradePlugin";
        this.g = true;
        this.h = NameKeys.UnloadStrategy_No_Strategy;
        this.j = -1;
        this.l = -1;
        this.n = new ConcurrentHashMap();
    }

    public static void l3(String r3) {
        Keva r0 = com.larus.voicecall.impl.degrade.i.a;
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (com.larus.platform.service.z2.a.enableRealtimeCallDowngrade() == true) goto L6;
        return;
    L6:
        if (AppHost.a.isDebug() == true) goto L8;
    L8:
        com.larus.voicecall.impl.degrade.i.b.put(r3, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.larus.voicecall.impl.plugins.a1
    public final void K1(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (Intrinsics.areEqual(r6, this.h) == false) goto L5;
        return;
    L5:
        if (this.k == false) goto L8;
        return;
    L8:
        if (this.g == false) goto L11;
        FLogger.a.v(this.f, "waitFirstConnect return; changeSceneTo: " + r6 + " and currentScene: " + this.h);
        return;
    L11:
        FLogger.a.v(this.f, "changeSceneTo: " + r6 + " and currentScene: " + this.h);
        if (com.larus.utils.o0.d(this.h) == false) goto L16;
        String r0 = this.h;
        long r1 = com.larus.voicecall.impl.degrade.i.c(r0);
        a r2 = this.n.get(r0);
        if (r2 == null) goto L16;
        r2.a -= r1;
    L16:
        this.h = r6;
        l3(r6);
        com.larus.utils.t0.c(new w0(this));
    }
}

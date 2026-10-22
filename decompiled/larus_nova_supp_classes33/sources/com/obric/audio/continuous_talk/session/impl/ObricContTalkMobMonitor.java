package com.obric.audio.continuous_talk.session.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.im.service.audio.v;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.audio.continuous_talk.d0;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricContTalkMobMonitor extends com.larus.audio.call.arch.a<com.obric.audio.continuous_talk.session.impl.a> implements v {
    public final String f;
    public final String g;
    public final iia.b h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public Job n;
    public Job o;
    public final AtomicReference<ConnectResult> p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public final a w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/continuous_talk/session/impl/ObricContTalkMobMonitor$ConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "CONNECTED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ConnectResult extends Enum<ConnectResult> {
        public static final ConnectResult CONNECTED = null;
        public static final ConnectResult FAILED = null;
        public static final ConnectResult PENDING = null;
        public static final /* synthetic */ ConnectResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ConnectResult> getEntries() {
            return b;
        }

        static {
            ConnectResult r0 = new ConnectResult("PENDING", 0);
            PENDING = r0;
            ConnectResult r1 = new ConnectResult("CONNECTED", 1);
            CONNECTED = r1;
            ConnectResult r3 = new ConnectResult("FAILED", 2);
            FAILED = r3;
            ConnectResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ConnectResult[] values() {
            return (ConnectResult[]) a.clone();
        }

        public static ConnectResult valueOf(String r1) {
            return (ConnectResult) r27.a.a(ConnectResult.class, r1);
        }

        public ConnectResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements u68.a.b {
        public final /* synthetic */ ObricContTalkMobMonitor a;
        public final /* synthetic */ com.obric.audio.continuous_talk.session.impl.a b;

        public final void a() {
        }

        public final void b(Map<String, String> r1) {
        }

        public final void d(com.larus.audio.call.play.h.a r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        public final void e(boolean r1) {
        }

        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
        }

        public final void g(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "audio");
        }

        public final void i(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "audio");
        }

        public final void onPaused() {
        }

        public final void onPlayComplete() {
        }

        public final void onResume() {
        }

        public final void c() {
            ObricContTalkMobMonitor r0 = this.a;
            if (r0.r == true) goto L5;
            return;
        L5:
            r0.r = false;
            long r2 = System.currentTimeMillis();
            ObricContTalkMobMonitor r1 = this.a;
            long r3 = r2 - r1.k;
            iia.b r4 = r1.h;
            RealtimeCallParam r5 = this.b.params();
            boolean r6 = this.a.s;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "params");
            com.obric.audio.continuous_talk.a r7 = iia.b.b(r5);
            Long r8 = Long.valueOf(r3);
            Boolean r9 = Boolean.valueOf(r6);
            Intrinsics.checkNotNullParameter(r7, "commonTraceParams");
            JSONObject r10 = new JSONObject();
            d0.a(r10, r7);
            if (r8 == null) goto L8;
            r10.put("duration", r8.longValue());
        L8:
            if (r9 == null) goto L10;
            r10.put("is_first_reply", r9.booleanValue());
        L10:
            TrackParams r11 = new TrackParams().merge(r10);
            by7.a r12 = new by7.a("obric_continuous_talk_tts_first_frame");
            r12.a.merge(r11);
            r12.b();
            FLogger.a.i("mobObricContinuousTalkTTSFirstFrame", "params:" + r10);
            this.a.s = false;
        }

        public a(ObricContTalkMobMonitor r1, com.obric.audio.continuous_talk.session.impl.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final v R2() {
        return this;
    }

    public final String j3() {
        return ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params().e + this.v;
    }

    public final void e3() {
        this.i = System.currentTimeMillis();
        this.p.set(ConnectResult.PENDING);
        super.e3();
        com.larus.audio.call.arch.b.a(getContext()).e0().i(this.w);
        this.n = U2(new ObricContTalkMobMonitor$onStart$1(this, null));
        this.o = U2(new ObricContTalkMobMonitor$onStart$2(this, null));
    }

    public final void g3() {
        id9.d r0 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).j();
        if (r0 == null) goto L5;
        jd9.c r1 = r0.state();
    L7:
        if (r1 != jd9.c.b.c) goto L17;
        AtomicReference<ConnectResult> r2 = this.p;
        ConnectResult r3 = ConnectResult.PENDING;
        ConnectResult r4 = ConnectResult.FAILED;
    L10:
        if (r2.compareAndSet(r3, r4) == true) goto L11;
        if (r2.get() == r3) goto L10;
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
        long r6 = System.currentTimeMillis() - this.i;
        FLogger.a.i(this.f, "onStop while CONNECTING, duration=" + r6);
        iia.b r7 = this.h;
        RealtimeCallParam r8 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter("stop_during_connecting", WindowEvent.Params.REASON);
        d0.d(iia.b.b(r8), "0", "stop_during_connecting", null, Long.valueOf(r6));
        goto L17
    L11:
        r5 = true;
    L17:
        super.g3();
        Job r9 = this.n;
        if (r9 == null) goto L20;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L20:
        this.n = null;
        Job r10 = this.o;
        if (r10 == null) goto L23;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L23:
        this.o = null;
        com.larus.audio.call.arch.b.a(getContext()).e0().j(this.w);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final String T2() {
        return this.f;
    }

    public final String getName() {
        return this.g;
    }

    public ObricContTalkMobMonitor(com.obric.audio.continuous_talk.session.impl.a r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "ObricContTalkMobMonitor";
        this.g = "ObricContTalkMobMonitor";
        this.h = new iia.b();
        this.p = new AtomicReference(ConnectResult.PENDING);
        this.s = true;
        this.w = new a(this, r3);
    }

    public final void k3(AVKitCoreStates.Error r8) {
        iia.b.d(this.h, ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params(), Integer.valueOf(r8.a), r8.b, r8.c, null, 16);
    }

    public final void O1(jd9.c r9, jd9.c r10) {
        Intrinsics.checkNotNullParameter(r9, "oldState");
        Intrinsics.checkNotNullParameter(r10, "newState");
        boolean r1 = true;
        if ((r10 instanceof jd9.c.a) == true) goto L5;
    L16:
        boolean r11 = r10 instanceof jd9.c.d;
        if (r11 == false) goto L33;
        AtomicReference<ConnectResult> r3 = this.p;
        ConnectResult r4 = ConnectResult.PENDING;
        ConnectResult r5 = ConnectResult.FAILED;
    L20:
        if (r3.compareAndSet(r4, r5) == true) goto L25;
        if (r3.get() == r4) goto L20;
        r1 = false;
    L25:
        if (r1 == false) goto L33;
        long r2 = System.currentTimeMillis() - this.i;
        jd9.c.d r12 = (jd9.c.d) r10;
        String r13 = r12.f;
        if (StringsKt.isBlank(r13) == false) goto L30;
        r13 = r12.e;
    L30:
        if (StringsKt.isBlank(r13) == false) goto L32;
        r13 = String.valueOf(r12.c);
    L32:
        FLogger.a.i(this.f, "onConnectionStateChanged DISCONNECT, duration=" + r2 + ", failReason=" + r13 + ", errCode=" + r12.c);
        iia.b r6 = this.h;
        RealtimeCallParam r7 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params();
        Integer r14 = Integer.valueOf(r12.c);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r13, WindowEvent.Params.REASON);
        d0.d(iia.b.b(r7), "0", r13, r14, Long.valueOf(r2));
        return;
    L33:
        if (r11 == true) goto L35;
        return;
    L35:
        if (this.p.get() != ConnectResult.CONNECTED) goto L52;
        iia.b r8 = this.h;
        RealtimeCallParam r15 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params();
        jd9.c.d r16 = (jd9.c.d) r10;
        Integer r17 = Integer.valueOf(r16.c);
        String r18 = r16.f;
        if (StringsKt.isBlank(r18) == false) goto L40;
        r18 = r16.e;
    L40:
        if (StringsKt.isBlank(r18) == false) goto L42;
        r18 = String.valueOf(r16.c);
    L42:
        iia.b.d(r8, r15, r17, r18, null, Boolean.TRUE, 8);
        return;
    L52:
        return;
    L5:
        if (((jd9.c.a) r10).c == true) goto L16;
        AtomicReference<ConnectResult> r19 = this.p;
        ConnectResult r20 = ConnectResult.PENDING;
        ConnectResult r21 = ConnectResult.CONNECTED;
    L8:
        if (r19.compareAndSet(r20, r21) == true) goto L9;
        if (r19.get() == r20) goto L8;
        boolean r22 = false;
    L13:
        if (r22 == false) goto L16;
        long r23 = System.currentTimeMillis() - this.i;
        FLogger.a.i(this.f, "onConnectionStateChanged CONNECTED, duration=" + r23);
        iia.b r24 = this.h;
        RealtimeCallParam r25 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params();
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "params");
        d0.d(iia.b.b(r25), "1", null, null, Long.valueOf(r23));
        return;
    L9:
        r22 = true;
        goto L13
    }
}

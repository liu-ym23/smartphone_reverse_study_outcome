package com.larus.avlink.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o1 {
    public static final /* synthetic */ int S = 0;
    public long A;
    public boolean B;
    public boolean C;
    public String D;
    public long E;
    public long F;
    public Boolean G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public long M;
    public boolean N;
    public boolean O;
    public String P;
    public String Q;
    public final p1 R;
    public final com.larus.audio.call.arch.c a;
    public final String b;
    public final boolean c;
    public final Function0<Boolean> d;
    public final String e;
    public final String f;
    public final String g;
    public long h;
    public long i;
    public long j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public long n;
    public long o;
    public volatile boolean p;
    public volatile boolean q;
    public volatile boolean r;
    public q1 s;
    public r1 t;
    public s1 u;
    public volatile boolean v;
    public int w;
    public long x;
    public volatile boolean y;
    public int z;

    public static final class a {
    }

    static {
    }

    public final void d() {
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "onTtsPlayFinished");
        if (this.n > 0) goto L5;
    L9:
        this.p = true;
        return;
    L5:
        if (this.y == false) goto L7;
        int r2 = 0;
    L8:
        long r0 = System.currentTimeMillis();
        long r3 = this.n;
        f(r2, r0 - r3, this.o - r3, System.currentTimeMillis() - this.h, 0);
        goto L9
    L7:
        r2 = 3;
        goto L8
    }

    public final void c() {
        this.I = System.currentTimeMillis();
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "onTtsFirstFramePlayed");
        this.o = System.currentTimeMillis();
        s1 r0 = this.u;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.u = null;
        e(this, 0, 0, null, "first_frame_play", 6);
    }

    public static long b(long r3) {
        if (r3 != 0) goto L6;
        return 0;
    L6:
        return System.currentTimeMillis() - r3;
    }

    public final void a(Map<String, Object> r4) {
        r4.put("scene", this.e);
        r4.put("call_id", this.f);
        r4.put("room_id", this.g);
        AndroidPlatformKt.a();
        r4.put("is_mock_test", Boolean.FALSE);
        r4.put("task_id", this.a.params().l.a);
        if (Intrinsics.areEqual(this.e, "call") == false) goto L5;
    L7:
        RealtimeCallParam r0 = this.a.params();
        r4.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r0.s)));
        r4.put("is_quic", Boolean.valueOf(com.larus.im.service.audio.y0.d(r0.s)));
        r4.put("is_mmt", Integer.valueOf(com.larus.im.service.audio.y0.b(r0.s) ? 1 : 0));
        r4.put("client_pre_connect", Integer.valueOf(r0.t));
        r4.put("av_session_type", Integer.valueOf(r0.s.getType()));
        r4.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(this.a.params().k.o, "dora_si") ? 1 : 0));
        r4.put("is_v3", Integer.valueOf(this.C ? 1 : 0));
        boolean r1 = true;
        if (BaseDoraLiteLiveAiPlugin.l == false) goto L10;
    L13:
        r4.put("is_live_ai", Boolean.valueOf(r1));
        return;
    L10:
        if (b98.b.b(1) == true) goto L13;
        r1 = false;
        goto L13
    L5:
        if (Intrinsics.areEqual(this.e, "assistant_scene_mode_click_talk") == true) goto L7;
        r4.put("dora_mode", this.e);
        goto L7
    }

    public o1(com.larus.audio.call.arch.c r2, String r3, boolean r4, u1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "questionId");
        Intrinsics.checkNotNullParameter(r5, "currentConnectValid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r2.params().k.a();
        this.f = r2.params().e;
        this.g = r2.params().d;
        this.k = true;
        this.l = true;
        this.m = true;
        this.p = true;
        this.v = true;
        this.E = -1;
        this.F = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        p1 r6 = new p1(this);
        this.R = r6;
        com.larus.audio.call.arch.b.a(r2).e0().i(r6);
    }

    public final void f(final int r12, final long r13, final long r15, final long r17, final int r19) {
        com.larus.utils.l0.b(new l1(this, r12, r15, r13, r17, r19));
    }

    public static void e(final o1 r6, final int r7, int r8, String r9, String r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        final int r4 = -1;
    L7:
        if ((r11 & 4) == 0) goto L9;
        final String r5 = "";
    L11:
        if ((r11 & 8) == 0) goto L13;
        final String r1 = "";
    L14:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "agentIntention");
        Intrinsics.checkNotNullParameter(r1, "scene");
        com.larus.utils.l0.b(new m1(r1, r7, r6, r4, r5));
        return;
    L13:
        r1 = r10;
        goto L14
    L9:
        r5 = r9;
        goto L11
    L5:
        r4 = r8;
        goto L7
    }
}

package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.mgr.MajorState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements s0 {
    public final boolean f;
    public final Function0<com.larus.im.service.audio.t> g;
    public final String h;
    public final b78.b i;
    public long j;
    public String k;
    public volatile byte[] l;
    public final buc.c m;
    public final g n;

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        this.i.b(true, "onStart");
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.q(this.n);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        cancel("onStop");
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.n(this.n);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.h;
    }

    @Override // com.larus.audio.call.plugins.s0
    public final void cancel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "caller");
        this.l = null;
        this.i.b(false, r3);
    }

    @Override // com.larus.audio.call.plugins.s0
    public final void m2(com.larus.im.service.audio.l r15) {
        Intrinsics.checkNotNullParameter(r15, "frame");
        if (this.i.a() == true) goto L5;
        return;
    L5:
        byte[] r16 = r15.a;
        v58.a r0 = com.larus.audio.call.arch.b.a(getContext()).g0();
        if (r16.length != 0) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        List r17 = CollectionsKt.emptyList();
    L90:
        if (r17.isEmpty() == true) goto L124;
        Iterator r19 = r17.iterator();
    L94:
        if (r19.hasNext() == false) goto L148;
        com.larus.im.service.audio.l r2 = (com.larus.im.service.audio.l) r19.next();
        if (this.i.a() == false) goto L147;
        com.larus.audio.call.util.e.a.i(this.h, "sender handleData sendFrame : " + r2.a);
        id9.d r3 = getContext().j();
        if (r3 == null) goto L94;
        if ((r2.getType() instanceof ue9.g.a) == false) goto L123;
        r2 = ((com.larus.im.service.audio.t) this.g.invoke()).a(r2);
        MajorState r5 = getContext().a().s1();
        if (Intrinsics.areEqual(r5, MajorState.h.c) == false) goto L106;
    L111:
        boolean r6 = true;
    L112:
        if (r6 == false) goto L114;
        LinkedHashMap r7 = new LinkedHashMap();
        LinkedHashMap r8 = new LinkedHashMap();
        ouc.g0 r9 = ouc.k.b(Long.valueOf(SystemClock.elapsedRealtime() - this.j));
        Intrinsics.checkNotNullParameter("playing_duration", "key");
        Intrinsics.checkNotNullParameter(r9, "element");
        ouc.i r10 = (ouc.i) r8.put("playing_duration", r9);
        ouc.g0 r11 = ouc.k.c(this.k);
        Intrinsics.checkNotNullParameter("tts_msg_id", "key");
        Intrinsics.checkNotNullParameter(r11, "element");
        ouc.i r12 = (ouc.i) r8.put("tts_msg_id", r11);
        Unit r13 = Unit.INSTANCE;
        ouc.d0 r14 = new ouc.d0(r8);
        Intrinsics.checkNotNullParameter("tts_status", "key");
        Intrinsics.checkNotNullParameter(r14, "element");
        ouc.i r20 = (ouc.i) r7.put("tts_status", r14);
        ouc.d0 r21 = new ouc.d0(r7);
    L116:
        if (StringsKt.isBlank(String.valueOf(r21)) == true) goto L123;
        byte[] r22 = r2.a;
        ue9.g r23 = r2.getType();
        boolean r24 = r2.d;
        if (r21 == null) goto L121;
        ouc.d0 r4 = q68.d.a(r21, b78.g.a(r2.b));
    L122:
        r2 = new com.larus.im.service.audio.l(r22, String.valueOf(r4), r23, r24);
        goto L123
    L121:
        r4 = null;
        goto L122
    L114:
        r21 = null;
        goto L116
    L106:
        if ((r5 instanceof MajorState.d) == true) goto L108;
    L110:
        r6 = false;
        goto L112
    L108:
        if (((MajorState.d) r5).c != MajorState.From.TTS_ENDED) goto L110;
    L123:
        r3.u(r2);
        goto L94
    L147:
        return;
    L148:
        return;
    L124:
        return;
    L13:
        if (this.f == true) goto L16;
        r17 = CollectionsKt.listOf(new com.larus.im.service.audio.l(r16, null, new ue9.g.a(r0.a, r0.b), false));
        goto L90
    L16:
        if (this.l != null) goto L18;
        this.l = new byte[(((r0.a / CommandStatus.DORA_TRACE) * 10) * r0.b) * 2];
    L18:
        byte[] r25 = this.l;
        if (r25 == null) goto L21;
        int r26 = r25.length;
    L22:
        int r27 = r26 - this.m.b();
        int r29 = r16.length;
        if (r27 != r29) goto L36;
        int r30 = r16.length;
        int r31 = 0;
    L25:
        if (r31 >= r30) goto L30;
        byte[] r32 = this.l;
        if (r32 == null) goto L29;
        r32[this.m.b() + r31] = r16[r31];
    L29:
        r31 = r31 + 1;
        goto L25
    L30:
        buc.c r110 = this.m;
        r110.d(r110.b() + r29);
        byte[] r111 = this.l;
        if (r111 == null) goto L34;
        byte[] r112 = Arrays.copyOf(r111, r111.length);
        if (r112 == null) goto L34;
    L35:
        this.m.d(0);
        r17 = CollectionsKt.listOf(new com.larus.im.service.audio.l(r112, null, new ue9.g.a(r0.a, r0.b), false));
    L34:
        r112 = new byte[0];
        goto L35
    L36:
        if (r27 <= r29) goto L44;
        int r33 = r16.length;
        int r34 = 0;
    L38:
        if (r34 >= r33) goto L43;
        byte[] r35 = this.l;
        if (r35 == null) goto L42;
        r35[this.m.b() + r34] = r16[r34];
    L42:
        r34 = r34 + 1;
        goto L38
    L43:
        buc.c r113 = this.m;
        r113.d(r113.b() + r29);
        r17 = CollectionsKt.emptyList();
        goto L90
    L44:
        ArrayList r36 = new ArrayList();
        int r37 = 0;
    L45:
        int r38 = r27 + r37;
        byte[] r39 = ArraysKt.copyOfRange(r16, r37, r38);     // Catch: Exception -> L48
    L55:
        if (r39 == null) goto L88;
        if (r39.length != 0) goto L59;
        boolean r40 = true;
    L60:
        if (r40 == true) goto L88;
        int r41 = r39.length;
        int r42 = 0;
    L63:
        if (r42 >= r41) goto L68;
        byte[] r114 = this.l;
        if (r114 == null) goto L67;
        r114[this.m.b() + r42] = r39[r42];
    L67:
        r42 = r42 + 1;
        goto L63
    L68:
        buc.c r43 = this.m;
        r43.d(r43.b() + r39.length);
        byte[] r44 = this.l;
        if (r44 == null) goto L71;
        int r45 = r44.length;
    L73:
        if ((r45 - this.m.b()) != 0) goto L80;
        byte[] r46 = this.l;
        if (r46 == null) goto L78;
        byte[] r47 = Arrays.copyOf(r46, r46.length);
        if (r47 == null) goto L78;
    L79:
        this.m.d(0);
        r36.add(new com.larus.im.service.audio.l(r47, null, new ue9.g.a(r0.a, r0.b), false));
    L78:
        r47 = new byte[0];
    L80:
        byte[] r48 = this.l;
        if (r48 == null) goto L83;
        int r49 = r48.length;
    L84:
        int r50 = Math.min(r49 - this.m.b(), r29 - r38);
        if (r38 >= r29) goto L88;
        r37 = r38;
        r27 = r50;
        goto L45
    L83:
        r49 = 0;
        goto L84
    L71:
        r45 = 0;
        goto L73
    L59:
        r40 = false;
    L88:
        r17 = r36;
    L48:
        e = move-exception;
        com.larus.audio.call.g r51 = com.larus.audio.call.f.a;
        if (com.larus.audio.call.f.c().appContext().e() == true) goto L125;
        com.larus.audio.call.util.e r52 = com.larus.audio.call.util.e.a;
        String r53 = this.h;
        String r115 = e.getMessage();
        if (r115 != null) goto L54;
        r115 = "";
    L54:
        r52.e(r53, r115, e);
        r39 = null;
        goto L55
    L125:
        throw e;
    L21:
        r26 = 0;
        goto L22
    L8:
        r1 = false;
        goto L10
    }

    public h(com.larus.audio.call.arch.c r2, boolean r3, com.larus.audio.call.arch.m r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "preProcessor");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = "CommonAudioFrameSender";
        this.i = new b78.b("CommonAudioFrameSender");
        this.j = -1;
        this.m = buc.b.b();
        this.n = new g(this);
    }
}

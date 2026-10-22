package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements com.larus.audio.call.plugins.s0 {
    public final boolean f;
    public final Function0<com.larus.im.service.audio.t> g;
    public final String h;
    public final long i;
    public volatile ByteBuffer j;
    public final b0 k;

    public final void e3() {
        super.e3();
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.q(this.k);
        return;
    }

    public final void g3() {
        super.g3();
        cancel("onStop");
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.n(this.k);
        return;
    }

    public final String T2() {
        return this.h;
    }

    public final void cancel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        ByteBuffer r3 = this.j;
        if (r3 == null) goto L5;
        r3.clear();
    L5:
        this.j = null;
    }

    public final byte[] j3(ByteBuffer r7) {
        r7.flip();
        int r0 = r7.limit();
        byte[] r1 = new byte[r0];
        r7.get(r1);     // Catch: Throwable -> L5
    L7:
        r7.clear();
        r7.limit(r0);
        return r1;
    L5:
        th = move-exception;
        FLogger.a.e(this.h, th.getMessage(), th);
        goto L7
    }

    public final void m2(com.larus.im.service.audio.l r15) {
        Intrinsics.checkNotNullParameter(r15, "frame");
        FLogger.a.i(this.h, "onRecord " + r15.a.length);
        byte[] r16 = r15.a;
        v58.a r0 = com.larus.audio.call.arch.b.a(getContext()).g0();
        if (r16.length != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L10;
        List r17 = CollectionsKt.emptyList();
    L53:
        if (r17.isEmpty() == true) goto L88;
        Iterator r18 = r17.iterator();
    L57:
        if (r18.hasNext() == false) goto L101;
        com.larus.im.service.audio.l r2 = (com.larus.im.service.audio.l) r18.next();
        FLogger.a.i(this.h, "sender handleData sendFrame : " + r2.a);
        v r3 = (v) getContext().c(Reflection.getOrCreateKotlinClass(v.class), null);
        if (r3 == null) goto L61;
        r3.U1(r2);
    L61:
        id9.d r4 = getContext().j();
        if (r4 == null) goto L57;
        if ((r2.getType() instanceof ue9.g.a) == false) goto L87;
        r2 = ((com.larus.im.service.audio.t) this.g.invoke()).a(r2);
        MajorState.d r5 = getContext().a().s1();
        if (Intrinsics.areEqual(r5, MajorState.h.c) == false) goto L69;
    L74:
        boolean r6 = true;
    L75:
        if (r6 == false) goto L77;
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        r8.put("playing_duration", System.currentTimeMillis() - this.i);
        r8.put("tts_msg_id", null);
        Unit r9 = Unit.INSTANCE;
        r7.put("tts_status", r8);
        String r10 = r7.toString();
    L78:
        if (r10 != null) goto L80;
    L83:
        boolean r11 = true;
    L84:
        if (r11 == true) goto L87;
        r2 = com.larus.im.service.audio.l.a(r2, null, com.larus.audio.call.util.l.b(r10, r2.b), 29);
        goto L87
    L80:
        if (StringsKt.isBlank(r10) == true) goto L83;
        r11 = false;
        goto L84
    L77:
        r10 = null;
        goto L78
    L69:
        if ((r5 instanceof MajorState.d) == true) goto L71;
    L73:
        r6 = false;
        goto L75
    L71:
        if (r5.c != MajorState.From.TTS_ENDED) goto L73;
    L87:
        r4.u(r2);
        goto L57
    L101:
        return;
    L88:
        return;
    L10:
        if (this.f == true) goto L12;
        r17 = CollectionsKt.listOf(new com.larus.im.service.audio.l(r16, null, new ue9.g.a(r0.a, r0.b), false));
        goto L53
    L12:
        ByteBuffer r12 = this.j;
        if (r12 != null) goto L21;
        r12 = this.j;
        int r13 = (((r0.a / 1000) * 20) * r0.b) * 2;
        if (r12 != null) goto L17;
        r12 = ByteBuffer.allocate(r13);
        this.j = r12;
        Intrinsics.checkNotNull(r12);
        goto L21
    L17:
        if (r13 > r12.capacity()) goto L19;
        r12.limit(r13);
        goto L21
    L19:
        r12.flip();
        ByteBuffer r14 = ByteBuffer.allocate(r13);
        r14.put(r12);
        r12.clear();
        this.j = r14;
    L21:
        int r19 = r12.remaining();
        int r20 = r16.length;
        if (r19 != r20) goto L24;
        r12.put(r16);
        r17 = CollectionsKt.listOf(new com.larus.im.service.audio.l(j3(r12), null, new ue9.g.a(r0.a, r0.b), false));
        goto L53
    L24:
        if (r19 <= r20) goto L26;
        r12.put(r16);
        r17 = CollectionsKt.emptyList();
        goto L53
    L26:
        ArrayList r21 = new ArrayList();
        int r22 = 0;
    L27:
        int r23 = r19 + r22;
        byte[] r24 = ArraysKt.copyOfRange(r16, r22, r23);     // Catch: Exception -> L30
    L37:
        if (r24 == null) goto L51;
        if (r24.length != 0) goto L41;
        boolean r25 = true;
    L42:
        if (r25 == true) goto L51;
        r12.put(r24);
        if (r12.hasRemaining() == true) goto L47;
        r21.add(new com.larus.im.service.audio.l(j3(r12), null, new ue9.g.a(r0.a, r0.b), false));
    L47:
        int r26 = Math.min(r12.remaining(), r20 - r23);
        if (r23 >= r20) goto L51;
        r22 = r23;
        r19 = r26;
        goto L27
    L41:
        r25 = false;
    L51:
        r17 = r21;
    L30:
        e = move-exception;
        if (AppHost.a.isDebug() == true) goto L89;
        FLogger r27 = FLogger.a;
        String r110 = this.h;
        String r111 = e.getMessage();
        if (r111 != null) goto L36;
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        r27.e(r110, r111, e);
        r24 = null;
        goto L37
    L89:
        throw e;
    L5:
        r1 = false;
        goto L7
    }

    public c0(com.larus.audio.call.arch.c r2, boolean r3, com.larus.audio.call.arch.m r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "preProcessor");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = "CommonAudioFrameSender";
        this.i = -1;
        this.k = new b0();
    }
}
